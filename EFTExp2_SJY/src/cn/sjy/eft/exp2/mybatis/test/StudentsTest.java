package cn.sjy.eft.exp2.mybatis.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.sjy.eft.exp2.mybatis.utils.*;

import cn.sjy.eft.exp2.mybatis.po.*;
public class StudentsTest {
	
	/**
	 * 添加客户
	 */
	@Test
	public void addStudentTest() throws Exception{		
	    // 1、读取配置文件
	    String resource = "mybatis-config.xml";
	    InputStream inputStream = Resources.getResourceAsStream(resource);
	    // 2、根据配置文件构建SqlSessionFactory
	    SqlSessionFactory sqlSessionFactory = 
	    		new SqlSessionFactoryBuilder().build(inputStream);
	    // 3、通过SqlSessionFactory创建SqlSession
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    // 4、SqlSession执行添加操作
	    // 4.1创建Students对象，并向对象中添加数据
	    Students s = new Students();
	    s.setName("王老师");
	    s.setAge(32);
	    s.setGender("男");
	    s.setNumber("13312341234");
	    s.setAddress("山西太原");
	    // 4.2执行SqlSession的插入方法，返回的是SQL语句影响的行数
		int rows = sqlSession.insert("cn.sjy.eft.exp2.mybatis.mapper"
					+ ".StudentsMapper.addStudent", s);
	    // 4.3通过返回结果判断插入操作是否执行成功
	    if(rows > 0){
	        System.out.println("您成功插入了"+rows+"条数据！");
	    }else{
	        System.out.println("执行插入操作失败！！！");
	    }
	    // 4.4提交事务
	    sqlSession.commit();
	    // 5、关闭SqlSession
	    sqlSession.close();
	}

	/**
	 * 更新学生
	 */
	@Test
	public void updateStudentTest() throws Exception{		
	    // 1、读取配置文件
	    String resource = "mybatis-config.xml";
	    InputStream inputStream = Resources.getResourceAsStream(resource);
	    // 2、根据配置文件构建SqlSessionFactory
	    SqlSessionFactory sqlSessionFactory = 
	    		new SqlSessionFactoryBuilder().build(inputStream);
	    // 3、通过SqlSessionFactory创建SqlSession
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    // 4、SqlSession执行更新操作
	    // 4.1创建Student对象，对对象中的数据进行模拟更新
	    Students s = new Students();
	    s.setId(2);
	    s.setName("李老师");
	    s.setAge(32);
	    s.setGender("男");
	    s.setNumber("13312341234");
	    s.setAddress("山西太原");
	    // 4.2执行SqlSession的更新方法，返回的是SQL语句影响的行数
	    int rows = sqlSession.update("cn.sjy.eft.exp2.mybatis.mapper"
	            + ".StudentsMapper.updateStudent", s);
	    // 4.3通过返回结果判断更新操作是否执行成功
	    if(rows > 0){
	        System.out.println("您成功修改了"+rows+"条数据！");
	    }else{
	        System.out.println("执行修改操作失败！！！");
	    }
	    // 4.4提交事务
	    sqlSession.commit();
	    // 5、关闭SqlSession
	    sqlSession.close();
	}

	/**
	 * 删除学生
	 */
	@Test
	public void deleteCustomerTest() throws Exception{		
	    // 1、读取配置文件
	    String resource = "mybatis-config.xml";
	    InputStream inputStream = Resources.getResourceAsStream(resource);
	    // 2、根据配置文件构建SqlSessionFactory
	    SqlSessionFactory sqlSessionFactory = 
	            new SqlSessionFactoryBuilder().build(inputStream);
	    // 3、通过SqlSessionFactory创建SqlSession
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    // 4、SqlSession执行删除操作
	    // 4.1执行SqlSession的删除方法，返回的是SQL语句影响的行数
	    int rows = sqlSession.delete("cn.sjy.eft.exp2.mybatis.mapper"
	            + ".StudentsMapper.deleteStudent", 2);
	    // 4.2通过返回结果判断删除操作是否执行成功
	    if(rows > 0){
	        System.out.println("您成功删除了"+rows+"条数据！");
	    }else{
	        System.out.println("执行删除操作失败！！！");
	    }
	    // 4.3提交事务
	    sqlSession.commit();
	    // 5、关闭SqlSession
	    sqlSession.close();
	}

	
	/**
	 * 根据学生编号查询学生信息
	 */
	@Test
	public void findStudentByIdTest() throws Exception {
		// 1、读取配置文件
		String resource = "mybatis-config.xml";
		InputStream inputStream = 
                     Resources.getResourceAsStream(resource);
		// 2、根据配置文件构建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = 
                     new SqlSessionFactoryBuilder().build(inputStream);
		// 3、通过SqlSessionFactory创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 4、SqlSession执行映射文件中定义的SQL，并返回映射结果
		Students s = sqlSession.selectOne("cn.sjy.eft.exp2.mybatis.mapper"
				  + ".StudentsMapper.findStudentById", 1);
		// 打印输出结果
		System.out.println(s.toString());
		// 5、关闭SqlSession
		sqlSession.close();
	}
	
	/**
	 * 根据学生姓名或地址查询学生信息列表
	 */
	@Test
	public void findStudentByNameOrAddressTest(){
	    // 通过工具类生成SqlSession对象
	    SqlSession session = MybatisUtils.getSession();
	    // 创建Customer对象，封装需要组合查询的条件
	    Students s = new Students();
	    //s.setName("王老师");
	    s.setAddress("山西太原");
	    // 执行SqlSession的查询方法，返回结果集
	    List<Students> ss = session.selectList("cn.sjy.eft.exp2.mybatis.mapper" 
	            + ".StudentsMapper.findStudentByNameOrAddress",s);
	    // 输出查询结果信息
	    for (Students s1 : ss) {
	        // 打印输出结果
	        System.out.println(s1);
	    }
	    // 关闭SqlSession
	    session.close();
	}
	
	
}
