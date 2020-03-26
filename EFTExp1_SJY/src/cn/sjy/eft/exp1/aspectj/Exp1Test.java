package cn.sjy.eft.exp1.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Exp1Test {

	public static void main(String[] args) {
		String xmlPath = 
                "cn/sjy/eft/exp1/aspectj/applicationContext.xml";
		ApplicationContext applicationContext = 
               new ClassPathXmlApplicationContext(xmlPath);
		// 1 从spring容器获得内容
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		// 2 执行方法
		userDao.addUser();
        userDao.deleteUser();
	}

}
