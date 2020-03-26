package cn.sjy.eft.exp1.aspectj;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	public void addUser() {
		System.out.println("添加用户");
	}
	public void deleteUser() {
		System.out.println("删除用户");
	}
}
