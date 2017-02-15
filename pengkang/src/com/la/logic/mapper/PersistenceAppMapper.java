package com.la.logic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.la.logic.common.model.PersistenceApp;
import com.la.logic.dao.IBaseDao;

public interface PersistenceAppMapper extends IBaseDao<PersistenceApp, String> {

	@Select("SELECT APP_CODE as appCode, APP_NAME as appName, APP_DESC as appDesc, APP_CALLBACK as appCallback, APP_SECRET as appSecret, APP_C_NAME as appCName, APP_C_PHONE as appCPhone,"
			+ " PARTNER_CODE as partnerCode, STATUS as status ,LOGO_ATTACH_ID AS logoAttachId,CREATE_TIME createTime FROM POP_APP_INFO WHERE APP_CODE = #{appCode}")
	public PersistenceApp getApp(String appCode);
	
	@Select("SELECT APP_CODE as appCode, APP_NAME as appName, APP_DESC as appDesc, APP_CALLBACK as appCallback, APP_SECRET as appSecret, APP_C_NAME as appCName, APP_C_PHONE as appCPhone,"
			+ " PARTNER_CODE as partnerCode, STATUS as status ,LOGO_ATTACH_ID AS logoAttachId,CREATE_TIME createTime FROM POP_APP_INFO WHERE PARTNER_CODE = #{partnerCode}")
	public List<PersistenceApp> getAppListBypartnerCode(String partnerCode);
	
	@Delete("DELETE FROM POP_APP_INFO WHERE APP_CODE = #{appCode}")
    public void deleteApp(String appcode);
	
	@Select("select * from (select u.*, rownum r from ( SELECT APP_CODE as appCode, APP_NAME as appName, APP_DESC as appDesc, APP_CALLBACK as appCallback, APP_SECRET as appSecret, APP_C_NAME as appCName, APP_C_PHONE as appCPhone,"
			+ " PARTNER_CODE as partnerCode, STATUS as status ,LOGO_ATTACH_ID AS logoAttachId,CREATE_TIME createTime FROM POP_APP_INFO ) u  where rownum < #{1}) where r >= #{0}")
	public List<PersistenceApp> listForTable(int start, int end);
	
	@Select("select * from (select u.*, rownum r from ( SELECT APP_CODE as appCode, APP_NAME as appName, APP_DESC as appDesc, APP_CALLBACK as appCallback, APP_SECRET as appSecret, APP_C_NAME as appCName, APP_C_PHONE as appCPhone,"
			+ " PARTNER_CODE as partnerCode, STATUS as status ,LOGO_ATTACH_ID AS logoAttachId,CREATE_TIME createTime FROM POP_APP_INFO where APP_CODE like #{2} or APP_NAME like #{2}) u  where rownum < #{1}) where r >= #{0}")
	public List<PersistenceApp> listForTableByLike(int start, int end, String keyword);
	
	@Select("SELECT count(1) from POP_APP_INFO")
	public int size();
	
	@Select("SELECT count(1) from POP_APP_INFO where APP_CODE like #{2} or APP_NAME like #{2}")
	public int sizeByLike(String keyword);
	
	@Select("select * from (select u.*, rownum r from ( SELECT APP_CODE as appCode, APP_NAME as appName, APP_DESC as appDesc, APP_CALLBACK as appCallback, APP_SECRET as appSecret, APP_C_NAME as appCName, APP_C_PHONE as appCPhone,"
			+ " PARTNER_CODE as partnerCode, STATUS as status ,LOGO_ATTACH_ID AS logoAttachId,CREATE_TIME createTime FROM POP_APP_INFO where PARTNER_CODE = #{2}) u  where rownum < #{1}) where r >= #{0}")
	List<PersistenceApp> listApp(int start, int end,String partnerCode);
	
	@Select("SELECT count(1) from POP_APP_INFO where PARTNER_CODE = #{partnerCode}")
	public int sizeOfApps(String partnerCode);
}