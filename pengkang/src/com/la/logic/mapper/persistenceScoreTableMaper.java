package com.la.logic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.la.logic.common.model.persistenceScoreTable;
import com.la.logic.dao.IBaseDao;

public interface persistenceScoreTableMaper extends IBaseDao<persistenceScoreTable, Integer> {
	@Insert("insert into score_table(collegeName,year,professionName,professionNumber,scoreFile,fileName) values(#{0},#{1},#{2},#{3},#{4},#{5});")
	void insert(String collegeName, String year, String professionName,
			String professionNumber, byte[] scoreFile, String fileName);
	
	@Select("select count(*) from score_table;")
	int getCount();
	
	@Select("select * from score_table limit #{0},#{1};")
	List<persistenceScoreTable> getList(int i, int pageNum);
	
	@Select("select * from score_table where id=#{id};")
	persistenceScoreTable getById(Integer id);
	
	@Delete("delete from score_table where id=#{id};")
	void deleteById(Integer id);
	
	@Select("select * from score_table;")
	List<persistenceScoreTable> getAll();

}
