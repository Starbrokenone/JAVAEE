package cn.sjy.eft.exp2.mybatis.po;

public class Students {
	private Integer id;       // 主键id
	private String name;     // 姓名
	private Integer age;     //年龄
	private String gender;   //性别
	private String number;    //电话
	private String address;      // 地址
	private Integer status;    // 状态
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + 
				       ", age=" + age +
				       ", gender=" + gender + 
				       ", number=" + number + 
				       ", address=" + address + 
				       ", status=" + status + 
				       "]";
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public String getNumber() {
		return number;
	}
	public String getAddress() {
		return address;
	}
	public Integer getStatus() {
		return status;
	}

}
