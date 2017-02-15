package com.la.logic.mapper;

import org.apache.ibatis.annotations.Select;

import com.la.logic.common.model.PersistenceAdmin;
import com.la.logic.dao.IBaseDao;

public interface PersistenceAdminMapper extends IBaseDao<PersistenceAdmin, String>{
	@Select("select admin_name as adminName, admin_password as adminpassword from admin_table where admin_name=#{adminName};")
	public PersistenceAdmin selectByName(String adminName);
}
