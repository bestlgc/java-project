package com.la.logic.mapper;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

public interface SeqMapper  {
	@Select("select ${_parameter} from dual")
	@Options(statementType=StatementType.PREPARED)
	public String getSequence(String seqName);
}
