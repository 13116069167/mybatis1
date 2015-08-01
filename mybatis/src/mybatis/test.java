package mybatis;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class test {

	public static void main(String[] args) {
		
		InputStream is = test.class.getClassLoader().getResourceAsStream("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		String str = "mybatis.userMapper.getUser";
		User user = session.selectOne(str,1);
		System.out.println(user);
	}
	
	@Test
	public void test1(){
		InputStream is = test.class.getClassLoader().getResourceAsStream("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		User user = new User(null,"ASasdDF",10);
		String statement = "mybatis.userMapper";
		int insert = session.insert(statement+".addUser",user);
		System.out.println(insert);
		session.commit();
	}
	
}
