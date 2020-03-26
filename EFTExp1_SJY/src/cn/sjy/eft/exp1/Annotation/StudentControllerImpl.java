package cn.sjy.eft.exp1.Annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller("studentController")
public class StudentControllerImpl implements StudentController {
	@Resource(name="studentService")
	private StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@Override
	public void save() {
		this.studentService.save();
		System.out.println("zly studentcontroller ... save ...");
		
	}
}
