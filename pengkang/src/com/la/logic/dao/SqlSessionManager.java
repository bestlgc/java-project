package com.la.logic.dao;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.la.logic.mapper.PersistenceAdminMapper;
import com.la.logic.mapper.PersistenceAppMapper;
import com.la.logic.mapper.PersistenceAttachmentMapper;
import com.la.logic.mapper.PersistenceClassInfoMapper;
import com.la.logic.mapper.PersistenceCourseInfoMapper;
import com.la.logic.mapper.PersistenceStudentInfoMapper;
import com.la.logic.mapper.PersistenceStudentScoreMapper;
import com.la.logic.mapper.SeqMapper;
import com.la.logic.mapper.persistenceScoreTableMaper;

public class SqlSessionManager {
	private static SqlSessionFactory bizSqlSessionFactory;
	public static SqlSessionFactory getSqlSessionFactory()  {
		if (bizSqlSessionFactory==null) {
			try {
				bizSqlSessionFactory = convertSqlSession(new Dbconfig("/databaseconfig.properties"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bizSqlSessionFactory;
	}
	
	private static SqlSessionFactory convertSqlSession(Dbconfig dbConfig) throws Exception {
		try {
			DataSource dataSource = ConnectionManager.getProxoolDataSource(dbConfig.getDriver(), dbConfig.getUrl(), dbConfig.getUsername(),
					dbConfig.getPassword(), dbConfig.getAlias(), dbConfig.getMaxConnection(), dbConfig.getMinConnection(),
					dbConfig.getSimultaneousBuildThrottle());
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			Environment environment = new Environment("development", transactionFactory, dataSource);
			Configuration configuration = new Configuration(environment);
			configuration.addMapper(IBaseDao.class);
			
			configuration.addMapper(PersistenceAppMapper.class);
			configuration.addMapper(PersistenceAdminMapper.class);
			configuration.addMapper(PersistenceAttachmentMapper.class);
			
			configuration.addMapper(PersistenceClassInfoMapper.class);
			configuration.addMapper(PersistenceCourseInfoMapper.class);
			configuration.addMapper(PersistenceStudentInfoMapper.class);
			configuration.addMapper(PersistenceStudentScoreMapper.class);
			configuration.addMapper(persistenceScoreTableMaper.class);
			configuration.addMapper(SeqMapper.class);
			
			configuration.addInterceptor(new BasePlugin());
			bizSqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bizSqlSessionFactory;
	}
}
