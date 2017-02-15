package com.la.logic.helper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.la.logic.common.model.AppStatus;
import com.la.logic.common.model.PersistenceApp;
import com.la.logic.dao.SqlSessionManager;
import com.la.logic.mapper.PersistenceAppMapper;

/**
 * @author zhangxu
 * 
 */
public class AppHelper {
	private static PersistenceApp createApp(String appCode, String appName, String appDesc, String appCallback, String appSecret, String appCName, String appCphone, String partnerCode, AppStatus status, Date createTime, String logoAttachId) {
		PersistenceApp app = new PersistenceApp();
		app.setAppCode(appCode);
		app.setAppName(appName);
		app.setAppDesc(appDesc);
		app.setAppCallback(appCallback);
		app.setAppSecret(appSecret);
		app.setAppCName(appCName);
		app.setAppCphone(appCphone);
		app.setPartnerCode(partnerCode);
		app.setStatus(status);
		app.setCreateTime(createTime);
		app.setLogoAttachId(logoAttachId);
		return app;
	}

	public static PersistenceApp getApp(String appCode) throws Exception {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceApp app = null;
		try {
			PersistenceAppMapper mapper = session.getMapper(PersistenceAppMapper.class);
			app = mapper.getApp(appCode);
			return app;
		} catch (Exception e) {
			throw new Exception("getApp from db error appCode ");
			
		} finally {
			session.close();
		}
	}

	public static PersistenceApp newApp(String appCode, String appName, String appDesc, String appCallback, String appSecret, String appCName, String appCphone, String partnerCode, AppStatus status, Date createTime, String logoAttachId) throws Exception {
		PersistenceApp app = createApp(appCode, appName, appDesc, appCallback, appSecret, appCName, appCphone, partnerCode, status, createTime, logoAttachId);
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		try {
			PersistenceAppMapper mapper = session.getMapper(PersistenceAppMapper.class);
			mapper.save(app);
		} catch (Exception e) {
			throw new Exception("newApp to db error");
		} finally {
			session.close();
		}
		return app;
	}

	public static void deleteApp(String appCode) throws Exception {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		try {
			PersistenceAppMapper mapper = session.getMapper(PersistenceAppMapper.class);
			mapper.deleteApp(appCode);
		} catch (Exception e) {
			throw new Exception("deleteApp from db error appCode ");
		} finally {
			session.close();
		}
	}

	public static PersistenceApp updateApp(String appCode, String appName, String appDesc, String appCallback, String appSecret, String appCName, String appCphone, String partnerCode, AppStatus status, Date createTime, String logoAttachId) throws Exception {
		PersistenceApp app = createApp(appCode, appName, appDesc, appCallback, appSecret, appCName, appCphone, partnerCode, status, createTime, logoAttachId);
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		try {
			PersistenceAppMapper mapper = session.getMapper(PersistenceAppMapper.class);
			mapper.update(app);
		} catch (Exception e) {
			throw new Exception("updateApp to db error");
		} finally {
			session.close();
		}
		return app;
	}

	public static List<PersistenceApp> getAppListByPartnerCode(String partnerCode) throws Exception {
		List<PersistenceApp> apps = null;
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession();

		try {
			PersistenceAppMapper mapper = session.getMapper(PersistenceAppMapper.class);
			apps = mapper.getAppListBypartnerCode(partnerCode);
		} catch (Exception e) {
			throw new Exception("updateApp to db error");
		} finally {
			session.close();
		}

		return apps;
	}

	public static List<PersistenceApp> listForTable(int pageIndex, int pageNum) throws Exception {
		List<PersistenceApp> apps = null;
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession();
		try {
			PersistenceAppMapper mapper = session.getMapper(PersistenceAppMapper.class);
			apps = mapper.listForTable(pageIndex * pageNum + 1, (pageIndex + 1) * pageNum + 1);
		} catch (Exception e) {
			throw new Exception("listAppForTable to db error");
		} finally {
			session.close();
		}

		return apps;
	}
	
	public static List<PersistenceApp> listApp(int pageIndex, int pageNum,String partnerCode) throws Exception {
		List<PersistenceApp> apps = null;
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession();
		try {
			PersistenceAppMapper mapper = session.getMapper(PersistenceAppMapper.class);
			apps = mapper.listApp(pageIndex * pageNum + 1, (pageIndex + 1) * pageNum + 1,partnerCode);
		} catch (Exception e) {
			throw new Exception("listAppForTable to db error");
		} finally {
			session.close();
		}

		return apps;
	}
	
	public static List<PersistenceApp> listForTableByLike(int pageIndex, int pageNum, String keyword) throws Exception {
		List<PersistenceApp> apps = null;
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession();
		try {
			PersistenceAppMapper mapper = session.getMapper(PersistenceAppMapper.class);
			apps = mapper.listForTableByLike(pageIndex * pageNum + 1, (pageIndex + 1) * pageNum + 1,"%"+keyword+"%");
		} catch (Exception e) {
			throw new Exception("listAppForTable to db error");
		} finally {
			session.close();
		}

		return apps;
	}
	
	
	public static int size() throws Exception {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession();
		try {
			PersistenceAppMapper mapper = session.getMapper(PersistenceAppMapper.class);
			return mapper.size();
		} catch (Exception e) {
			throw new Exception("size to db error");
		} finally {
			session.close();
		}
	}
	
	public static int sizeOfApps(String partnerCode) throws Exception {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession();
		try {
			PersistenceAppMapper mapper = session.getMapper(PersistenceAppMapper.class);
			return mapper.sizeOfApps(partnerCode);
		} catch (Exception e) {
			throw new Exception("size to db error");
		} finally {
			session.close();
		}
	}
	
	public static int sizeByLike(String keyword) throws Exception {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession();
		try {
			PersistenceAppMapper mapper = session.getMapper(PersistenceAppMapper.class);
			return mapper.sizeByLike("%"+keyword+"%");
		} catch (Exception e) {
			throw new Exception("sizeByLike to db error");
		} finally {
			session.close();
		}
	}
}
