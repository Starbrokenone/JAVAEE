package cn.sjy.eft.exp1.Annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService{
	@Resource(name="studentDao")
	private StudentDao studentDao;
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	@Override
	public void save()
	{
		this.studentDao.save();
		System.out.println("zly studentservice ... save ...");
	}
}
