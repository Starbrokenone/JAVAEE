package cn.sjy.eft.exp1.Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Exp1Test {

	public static void main(String[] args) {
	String xmlpath="cn/sjy/eft/exp1/Annotation/bean.xml";
		
		ApplicationContext ac=
				new ClassPathXmlApplicationContext(xmlpath);
		StudentController studentController=(StudentController)ac.getBean("studentController");
		studentController.save();
	}

}
