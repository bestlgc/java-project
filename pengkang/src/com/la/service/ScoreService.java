package com.la.service;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.springframework.web.multipart.MultipartFile;

import com.la.logic.common.model.persistenceScoreTable;
import com.la.logic.dao.JsonUtil;
import com.la.logic.dao.SqlSessionManager;
import com.la.logic.mapper.persistenceScoreTableMaper;
import com.la.logic.model.Page;
import com.la.view.ViewClassAverage;
import com.la.view.ViewQueryResult;
import com.la.view.ViewReport;
import com.la.view.ViewScore;
import com.la.view.ViewSubjectScore;

public class ScoreService {

	public static void save(ViewScore score) throws Exception {
		
		persistenceScoreTable scoreTable = new persistenceScoreTable();
		MultipartFile file = score.getScoreFile();
		if (file==null) {
		}else {
			byte[] data = file.getBytes();
			scoreTable.setScoreFile(data);
			scoreTable.setFileName(file.getOriginalFilename());
		}
		
		scoreTable.setCollegeName(score.getCollegeName());
		scoreTable.setProfessionName(score.getProfessionName());
		scoreTable.setProfessionNumber(score.getProfessionNumber());
		scoreTable.setYear(score.getYear());
		
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		persistenceScoreTableMaper maper = session.getMapper(persistenceScoreTableMaper.class);
		maper.insert(scoreTable.getCollegeName(),scoreTable.getYear(),scoreTable.getProfessionName(),scoreTable.getProfessionNumber(),scoreTable.getScoreFile(),scoreTable.getFileName());
		session.close();
	}

	public static Page<persistenceScoreTable> getList(int pageindex, int pageNum) {
		Page<persistenceScoreTable> page = new Page<persistenceScoreTable>();
		page.setPageNo(pageindex);
		page.setPageSize(pageNum);
		
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		persistenceScoreTableMaper maper = session.getMapper(persistenceScoreTableMaper.class);
		int count = maper.getCount();
		page.setTotalRecord(count);
		page.setTotalPage(count/pageNum + 1);
		
		List<persistenceScoreTable> resulTables = maper.getList(pageindex*pageNum,pageNum);
		page.setResults(resulTables);
		session.close();
		return page;
	}

	public static persistenceScoreTable getById(Integer id) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		persistenceScoreTableMaper maper = session.getMapper(persistenceScoreTableMaper.class);
		persistenceScoreTable scoreTable = maper.getById(id);
		session.close();
		return scoreTable;
	}

	public static void deleteById(Integer id) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		persistenceScoreTableMaper maper = session.getMapper(persistenceScoreTableMaper.class);
		maper.deleteById(id);
		session.close();
	}

	/**
	 * 生成报表
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static ViewReport report(Integer id) throws Exception {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		persistenceScoreTableMaper maper = session.getMapper(persistenceScoreTableMaper.class);
		persistenceScoreTable scoreTable = maper.getById(id);
		byte[] data = scoreTable.getScoreFile();
		
		//解析excel文件
		InputStream inputStream = new ByteArrayInputStream(data);
		//或许excel文件
		Workbook wb = WorkbookFactory.create(inputStream);
		List<List<String>>  list = readExcel(wb);
		ViewReport report = getReport(list);
		report.setFilename(scoreTable.getFileName());
		report.setCollegeName(scoreTable.getCollegeName());
		report.setProfessionName(scoreTable.getProfessionName());
		report.setYear(scoreTable.getYear());
		return report;
	}
	
	private static ViewReport getReport(List<List<String>> list) {
		ViewReport report = new ViewReport();
		//学生人数
		int studentCount = 0;
		//班级列表
		List<String> classSet = new ArrayList<String>();
		//科目列表
		List<String> listSubject = new ArrayList<String>();
		List<Integer> studentSumSocore = new ArrayList<Integer>();
		
		Map<String, Integer> less59 = new HashMap<String, Integer>();
		Map<String, Integer> less79 = new HashMap<String, Integer>();
		Map<String, Integer> less100 = new HashMap<String, Integer>();
		
		int sumScore = 0;
		int countSum=0;
		int countBJG = 0;
		int countYL = 0;
		int countClass = 0;
		
		for (int i = 0; i < list.size(); i++) {
			if (i==0) {
				//获取科目列表
				List<String> column = list.get(i);
				for (int j=5;j<column.size();j++) {
					if(column.get(j).trim().equals("")||column.get(j)==null){continue;}
					listSubject.add(column.get(j));
					countClass++;
				}
				continue;
			}
		}
		
		
		//科目挂科人数
		int [] subjectFailure = new int[listSubject.size()];
		
		for (int i = 0; i < list.size(); i++) {
			if (i==0) {
				continue;
			}
			List<String> column = list.get(i);
			//获取班级列表
			if (!classSet.contains(column.get(1))) {
				classSet.add(column.get(1));
			}
			int everySumScore = 0;
			for (int k = 0; k < column.size(); k++) {
				if (k>=5) {
					String temp = column.get(k);
					if (temp==null||temp.equals("")) {
						
					}else {
						int score = Integer.parseInt(column.get(k));
						if (score<60) {
							subjectFailure[k-5]++;
						}
						everySumScore += score;
						countSum++;
					}
				}
			}
			sumScore += everySumScore;
			
			if (everySumScore/countClass <60) {
				if (less59.get(column.get(1))==null) {
					less59.put(column.get(1), 0);
				}else {
					int count = less59.get(column.get(1));
					count++;
					less59.put(column.get(1), count);
					countBJG++;
				}
				
			}else if (everySumScore/countClass  >=80) {
				if (less100.get(column.get(1))==null) {
					less100.put(column.get(1), 0);
				}else {
					int count = less100.get(column.get(1));
					count++;
					less100.put(column.get(1), count);
					countYL++;
				}
				
			}else {
				if (less79.get(column.get(1))==null) {
					less79.put(column.get(1), 0);
				}else {
					int count = less79.get(column.get(1));
					count++;
					less79.put(column.get(1), count);
				}
			}
			studentSumSocore.add(everySumScore);
			studentCount++;
		}
		
		int less59Int[]  =new int[classSet.size()];
		int less79Int[]  = new int[classSet.size()];
		int less100Int[] = new int[classSet.size()];
		int m = 0;
		for (String banji : classSet) {
			
			if (less59.get(banji)==null) {
				less59.put(banji, 0);
			}
			int count59 = less59.get(banji);
			less59Int[m] = count59;
			
			if (less79.get(banji)==null) {
				less79.put(banji, 0);
			}
			int count79 = less79.get(banji);
			less79Int[m] = count79;
			
			if (less100.get(banji)==null) {
				less100.put(banji, 0);
			}
			int count100 = less100.get(banji);
			less100Int[m] = count100;
			m++;
		}
		
		//计算每个班优良率和不及格率
		double goodRate[] = new double[less100Int.length];
		double badRate[] = new double[less100Int.length];
		for (int i = 0; i < less100Int.length; i++) {
			int tempSum = less59Int[i]+less79Int[i]+less100Int[i];
			goodRate[i] = less100Int[i]*1.0/tempSum;
			badRate[i] = less59Int[i]*1.0/tempSum;
		}
		
		report.setAverageScore(sumScore*1.0/countSum);
		report.setStudentCount(studentCount);
		report.setClassCount(classSet.size());
		report.setExcellentRate(countYL*1.0/studentCount);
		report.setFailurerate(countBJG*1.0/studentCount);
		report.setListClass(classSet);
		report.setListSubject(JsonUtil.toJsonString(listSubject));
		report.setDis59Json(JsonUtil.toJsonString(less59Int));
		report.setDis79Json(JsonUtil.toJsonString(less79Int));
		report.setDis100Json(JsonUtil.toJsonString(less100Int));
		report.setListSubjectFailure(JsonUtil.toJsonString(subjectFailure));
		report.setBadRate(JsonUtil.toJsonString(badRate));
		report.setGoodRate(JsonUtil.toJsonString(goodRate));
		
		//每个课程的成绩列表。
		Map<String, Integer[]> subjectClassScoreMap = new HashMap<String,Integer[]>();
		Map<String, Integer> classSudentCount = new HashMap<String, Integer>();
		for (int i = 0; i < classSet.size(); i++) {
			//key是课程名，value是班级列表。
			subjectClassScoreMap.put(classSet.get(i), new Integer[listSubject.size()]);
		}
		
		for (int i = 0; i < list.size(); i++) {
				if (i==0) {
					continue;
				}
				List<String> column = list.get(i);
				if (column.size()<5+listSubject.size()) {
					continue;
				}
				
				String banjiString = column.get(1);
				Integer integer[] = subjectClassScoreMap.get(banjiString);
				if (classSudentCount.get(banjiString)==null) {
					classSudentCount.put(banjiString, 0);
				}
				Integer tempInteger = classSudentCount.get(banjiString);
				classSudentCount.put(banjiString, ++tempInteger);
				
				for (int j = 5; j < 5+listSubject.size(); j++) {
					if (column.get(j)==null||column.get(j).equals("")) {
						continue;
					}
					//计算这个班成绩的总和。
					if (integer[j-5]==null) {
						integer[j-5]=0;
					}
					integer[j-5] = integer[j-5] + Integer.parseInt(column.get(j));
					//计算班级内人的个数
					
				}
		}
		
		List<ViewClassAverage> listviewClassAverages = new ArrayList<ViewClassAverage>();
		for (int i = 0; i < listSubject.size(); i++) {
			ViewClassAverage viewClassAverage = new ViewClassAverage();
			listviewClassAverages.add(viewClassAverage);
		}
		
		for (int i = 0; i < classSet.size(); i++) {
			
			Integer[] integer = subjectClassScoreMap.get(classSet.get(i));
			Integer countInteger = classSudentCount.get(classSet.get(i));
			
			for (int j = 0; j < integer.length; j++) {
				ViewClassAverage viewClassAverage = listviewClassAverages.get(j);
				viewClassAverage.setSubject(listSubject.get(j));
				
				double average =  integer[j]*1.0/countInteger;
				List<Double>listscore = viewClassAverage.getBanjiSocreList();
				listscore.add(average);
			}
			
		}
		
		for (ViewClassAverage viewClassAverage : listviewClassAverages) {
			viewClassAverage.setSubjectBanJiScore(JsonUtil.toJsonString(viewClassAverage.getBanjiSocreList()));
		}
		report.setListAverages(listviewClassAverages);
		return report;
	}

	public static List<List<String>> readExcel(Workbook wb) {
		
		DataFormatter formatter = new DataFormatter();
	    Sheet sheet1 = wb.getSheetAt(0);
	    List<List<String>> table = new ArrayList<List<String>>();
	    for (Row row : sheet1) {
	    	List<String> column = new ArrayList<String>();
	        for (Cell cell : row) {
	            CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
//	            System.out.print(cellRef.formatAsString());
//	            System.out.print(" - ");
	            
	            // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
	            String text = formatter.formatCellValue(cell);
//	            System.out.println(text);
	            column.add(text);
	        }
	        table.add(column);
	    }
	    return table;
	}
	
	
	public static void readExcelContent(Workbook wb) {
		DataFormatter formatter = new DataFormatter();
	    Sheet sheet1 = wb.getSheetAt(0);
	    for (Row row : sheet1) {
	        for (Cell cell : row) {
	            CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
	            System.out.print(cellRef.formatAsString());
	            System.out.print(" - ");

	            // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
	            String text = formatter.formatCellValue(cell);
	            System.out.println(text);

	            // Alternatively, get the value and format it yourself
	            switch (cell.getCellType()) {
	                case Cell.CELL_TYPE_STRING:
	                    System.out.println(cell.getRichStringCellValue().getString());
	                    break;
	                case Cell.CELL_TYPE_NUMERIC:
	                    if (DateUtil.isCellDateFormatted(cell)) {
	                        System.out.println(cell.getDateCellValue());
	                    } else {
	                        System.out.println(cell.getNumericCellValue());
	                    }
	                    break;
	                case Cell.CELL_TYPE_BOOLEAN:
	                    System.out.println(cell.getBooleanCellValue());
	                    break;
	                case Cell.CELL_TYPE_FORMULA:
	                    System.out.println(cell.getCellFormula());
	                    break;
	                case Cell.CELL_TYPE_BLANK:
	                    System.out.println();
	                    break;
	                default:
	                    System.out.println();
	            }
	        }
	    }
	}

	public static ViewQueryResult  search(String stuNo) throws Exception{
		
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		persistenceScoreTableMaper maper = session.getMapper(persistenceScoreTableMaper.class);
		List<persistenceScoreTable> scoreTables = maper.getAll();
		List<ViewSubjectScore> viewSubjectScores = new ArrayList<ViewSubjectScore>();
		String name = "";
		for (persistenceScoreTable scoreTable : scoreTables) {
			byte[] data = scoreTable.getScoreFile();
			
			//解析excel文件
			InputStream inputStream = new ByteArrayInputStream(data);
			//或许excel文件
			Workbook wb = WorkbookFactory.create(inputStream);
			List<List<String>>  list = readExcel(wb);
			
			List<String> subjectList = getSubjectList(list);
			for (int i = 1; i < list.size(); i++) {
				
					List<String> column = list.get(i);
					if (column.get(2).equals(stuNo)) {
						name = column.get(4);
						for (int j=5;j<column.size();j++) {
							if(column.get(j).trim().equals("")||column.get(j)==null){continue;}
							ViewSubjectScore subjectScore = new ViewSubjectScore();
							subjectScore.setSubjectName(subjectList.get(j-5));
							subjectScore.setScore(Integer.parseInt(column.get(j).trim()));
							viewSubjectScores.add(subjectScore);
						}
						continue;
					}
				}
			}
		
			ViewQueryResult queryResult = new ViewQueryResult();
			queryResult.setStuName(name);
			queryResult.setStuNo(stuNo);
			queryResult.setViewSubjectScores(viewSubjectScores);
			return 	queryResult;
		}

	private static List<String> getSubjectList(List<List<String>>  list) {
		List<String> subjectList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (i==0) {
				//获取科目列表
				List<String> column = list.get(i);
				for (int j=5;j<column.size();j++) {
					if(column.get(j).trim().equals("")||column.get(j)==null){continue;}
					subjectList.add(column.get(j));
				}
				continue;
			}
		}
		
		return subjectList;
	}

}
