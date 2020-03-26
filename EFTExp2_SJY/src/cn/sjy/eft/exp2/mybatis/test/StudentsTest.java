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
	 * ��ӿͻ�
	 */
	@Test
	public void addStudentTest() throws Exception{		
	    // 1����ȡ�����ļ�
	    String resource = "mybatis-config.xml";
	    InputStream inputStream = Resources.getResourceAsStream(resource);
	    // 2�����������ļ�����SqlSessionFactory
	    SqlSessionFactory sqlSessionFactory = 
	    		new SqlSessionFactoryBuilder().build(inputStream);
	    // 3��ͨ��SqlSessionFactory����SqlSession
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    // 4��SqlSessionִ����Ӳ���
	    // 4.1����Students���󣬲���������������
	    Students s = new Students();
	    s.setName("����ʦ");
	    s.setAge(32);
	    s.setGender("��");
	    s.setNumber("13312341234");
	    s.setAddress("ɽ��̫ԭ");
	    // 4.2ִ��SqlSession�Ĳ��뷽�������ص���SQL���Ӱ�������
		int rows = sqlSession.insert("cn.sjy.eft.exp2.mybatis.mapper"
					+ ".StudentsMapper.addStudent", s);
	    // 4.3ͨ�����ؽ���жϲ�������Ƿ�ִ�гɹ�
	    if(rows > 0){
	        System.out.println("���ɹ�������"+rows+"�����ݣ�");
	    }else{
	        System.out.println("ִ�в������ʧ�ܣ�����");
	    }
	    // 4.4�ύ����
	    sqlSession.commit();
	    // 5���ر�SqlSession
	    sqlSession.close();
	}

	/**
	 * ����ѧ��
	 */
	@Test
	public void updateStudentTest() throws Exception{		
	    // 1����ȡ�����ļ�
	    String resource = "mybatis-config.xml";
	    InputStream inputStream = Resources.getResourceAsStream(resource);
	    // 2�����������ļ�����SqlSessionFactory
	    SqlSessionFactory sqlSessionFactory = 
	    		new SqlSessionFactoryBuilder().build(inputStream);
	    // 3��ͨ��SqlSessionFactory����SqlSession
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    // 4��SqlSessionִ�и��²���
	    // 4.1����Student���󣬶Զ����е����ݽ���ģ�����
	    Students s = new Students();
	    s.setId(2);
	    s.setName("����ʦ");
	    s.setAge(32);
	    s.setGender("��");
	    s.setNumber("13312341234");
	    s.setAddress("ɽ��̫ԭ");
	    // 4.2ִ��SqlSession�ĸ��·��������ص���SQL���Ӱ�������
	    int rows = sqlSession.update("cn.sjy.eft.exp2.mybatis.mapper"
	            + ".StudentsMapper.updateStudent", s);
	    // 4.3ͨ�����ؽ���жϸ��²����Ƿ�ִ�гɹ�
	    if(rows > 0){
	        System.out.println("���ɹ��޸���"+rows+"�����ݣ�");
	    }else{
	        System.out.println("ִ���޸Ĳ���ʧ�ܣ�����");
	    }
	    // 4.4�ύ����
	    sqlSession.commit();
	    // 5���ر�SqlSession
	    sqlSession.close();
	}

	/**
	 * ɾ��ѧ��
	 */
	@Test
	public void deleteCustomerTest() throws Exception{		
	    // 1����ȡ�����ļ�
	    String resource = "mybatis-config.xml";
	    InputStream inputStream = Resources.getResourceAsStream(resource);
	    // 2�����������ļ�����SqlSessionFactory
	    SqlSessionFactory sqlSessionFactory = 
	            new SqlSessionFactoryBuilder().build(inputStream);
	    // 3��ͨ��SqlSessionFactory����SqlSession
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    // 4��SqlSessionִ��ɾ������
	    // 4.1ִ��SqlSession��ɾ�����������ص���SQL���Ӱ�������
	    int rows = sqlSession.delete("cn.sjy.eft.exp2.mybatis.mapper"
	            + ".StudentsMapper.deleteStudent", 2);
	    // 4.2ͨ�����ؽ���ж�ɾ�������Ƿ�ִ�гɹ�
	    if(rows > 0){
	        System.out.println("���ɹ�ɾ����"+rows+"�����ݣ�");
	    }else{
	        System.out.println("ִ��ɾ������ʧ�ܣ�����");
	    }
	    // 4.3�ύ����
	    sqlSession.commit();
	    // 5���ر�SqlSession
	    sqlSession.close();
	}

	
	/**
	 * ����ѧ����Ų�ѯѧ����Ϣ
	 */
	@Test
	public void findStudentByIdTest() throws Exception {
		// 1����ȡ�����ļ�
		String resource = "mybatis-config.xml";
		InputStream inputStream = 
                     Resources.getResourceAsStream(resource);
		// 2�����������ļ�����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = 
                     new SqlSessionFactoryBuilder().build(inputStream);
		// 3��ͨ��SqlSessionFactory����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 4��SqlSessionִ��ӳ���ļ��ж����SQL��������ӳ����
		Students s = sqlSession.selectOne("cn.sjy.eft.exp2.mybatis.mapper"
				  + ".StudentsMapper.findStudentById", 1);
		// ��ӡ������
		System.out.println(s.toString());
		// 5���ر�SqlSession
		sqlSession.close();
	}
	
	/**
	 * ����ѧ���������ַ��ѯѧ����Ϣ�б�
	 */
	@Test
	public void findStudentByNameOrAddressTest(){
	    // ͨ������������SqlSession����
	    SqlSession session = MybatisUtils.getSession();
	    // ����Customer���󣬷�װ��Ҫ��ϲ�ѯ������
	    Students s = new Students();
	    //s.setName("����ʦ");
	    s.setAddress("ɽ��̫ԭ");
	    // ִ��SqlSession�Ĳ�ѯ���������ؽ����
	    List<Students> ss = session.selectList("cn.sjy.eft.exp2.mybatis.mapper" 
	            + ".StudentsMapper.findStudentByNameOrAddress",s);
	    // �����ѯ�����Ϣ
	    for (Students s1 : ss) {
	        // ��ӡ������
	        System.out.println(s1);
	    }
	    // �ر�SqlSession
	    session.close();
	}
	
	
}
