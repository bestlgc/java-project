package trb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

import com.alibaba.fastjson.JSON;


public class TRBCrawer2 {
	public static Map<String,Integer> authorMap = new HashMap<String, Integer>();
	public static  List<TRBDetail> trblist = new ArrayList<TRBDetail>();
	public static final String linkPrex = "http://pubsindex.trb.org/view/2017/C/";
	public static final String inputfilepath = "trbIdList.txt";
	public static final String outputjsonfilepath = "hahadetail3.json";
	public static final String outputsortpath = "E:\\haha2.csv";
	public TRBCrawer2() {
		
	}
		
	public static void crawer2() throws Exception {
		File file = new File(inputfilepath);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String idString  = "";
		int count = 1;
		while (idString != null) {
			System.out.println(count++);
			idString = reader.readLine();
			if (idString==null) {
				break;
			}
			String urlString = linkPrex + idString;
			getDetail(urlString);
			
		}
		reader.close();
		
	}
	
	public static void getDetail(String url)  {
		 
		System.out.println("current link is: " + url);
		HtmlCleaner cleaner2 = new HtmlCleaner();
		TRBDetail detail = new TRBDetail();
		
		detail.setLink(url);
		
		try {
			URL url2 = new URL(url);
			TagNode node = cleaner2.clean(url2);
			
			Object allRecords[] = node.evaluateXPath("//div[@class='recordWrapper']/div");
			for (Object object : allRecords) {
				
				TagNode recordNode = (TagNode) object;
				
				Object labelObject[] = recordNode.evaluateXPath("/p[@class='recordLabel']/text()");
				if (labelObject.length>0) {
					StringBuilder labelBuilder = (StringBuilder)labelObject[0];
					String label = labelBuilder.toString();
					//获取标题
					if (label.equals("Title:")) {
						Object titleObject[] = recordNode.evaluateXPath("/div[@class='recordTitle']/text()");
						if (titleObject.length > 0) {
							StringBuilder title = (StringBuilder)titleObject[0];
							detail.setTitle(title.toString());
						}
					}else if (label.equals("Record Type:")) {
						Object typeObject[] = recordNode.evaluateXPath("/div[@class='recordValue']/text()");
						if (typeObject.length > 0) {
							StringBuilder type = (StringBuilder)typeObject[0];
							detail.setRecordType(type.toString());
						}
					}else if (label.equals("Authors:")) {
						//获取作者
						List<String> authorList = new ArrayList<String>();
						Object authorObject[] = recordNode.evaluateXPath("/div[@class='recordValue']/div[@class='suppInfo']/h6/text()");
						for (Object author : authorObject) {
							StringBuilder authorBuilder = (StringBuilder)author;
							authorList.add(authorBuilder.toString());
							if (authorMap.containsKey(authorBuilder.toString())) {
								String authorString  =  authorBuilder.toString();
								Integer integer = authorMap.get(authorString) + 1;
								authorMap.put(authorString, integer);
							}else {
								String authorString  = (String) authorBuilder.toString();
								authorMap.put(authorString,1);
							}
						}
						detail.setAuthors(authorList);
					}else if (label.equals("Publication Date:")) {
						Object dateObject[] = recordNode.evaluateXPath("/div[@class='recordValue']/text()");
						if (dateObject.length > 0) {
							StringBuilder date = (StringBuilder)dateObject[0];
							detail.setDate(date.toString());
						}
					}else if (label.equals("Subject Areas:")) {
						Object dateObject[] = recordNode.evaluateXPath("/div[@class='recordValue']/text()");
						if (dateObject.length > 0) {
							StringBuilder date = (StringBuilder)dateObject[0];
							detail.setArea(date.toString());
						}
					}		
				}
			}
													
			trblist.add(detail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void writeDetail() throws Exception {
		File file = new File(outputjsonfilepath);
		
		String string = JSON.toJSONString(trblist);
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(string);
		writer.close();
	}
	
	public static void print() throws IOException {
		File file = new File("E:\\haha2.csv");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for (Map.Entry<String, Integer> entry:authorMap.entrySet()) {
			writer.write(entry.getKey()+"\t"+entry.getValue()+"\r\n");
			System.out.println(entry.getKey()+"	"+entry.getValue());
		}
		writer.close();
		
	}
	
	public static void sortAndprint() throws Exception {
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(authorMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
		});
		
		File file = new File(outputsortpath);	
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for (Map.Entry<String, Integer> entry:list) {
			writer.write(entry.getKey()+"\t"+entry.getValue()+"\r\n");
			System.out.println(entry.getKey()+"	"+entry.getValue());
		}
		writer.close();
	}
	
	public static void main(String[] args) {
		
		try {
			crawer2();
			sortAndprint();
			writeDetail();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
