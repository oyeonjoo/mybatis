package config;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Configuration {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			// ch01~05, 07 ����
			Reader reader = Resources.getResourceAsReader("config/sqlMapConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			// ch06 ����
			//InputStream stream = Resources.getResourceAsStream("config/sqlMapConfig.xml");
			//sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream, "hr");
		} catch(Exception e) {}
	}
	
	public static <T> T getMapper(Class<T> arg) {
		return sqlSessionFactory.openSession(true).getMapper(arg);
	}
}
