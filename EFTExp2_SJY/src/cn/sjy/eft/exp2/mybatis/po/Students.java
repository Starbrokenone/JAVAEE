package cn.sjy.eft.exp2.mybatis.po;

public class Students {
	private Integer id;       // ����id
	private String name;     // ����
	private Integer age;     //����
	private String gender;   //�Ա�
	private String number;    //�绰
	private String address;      // ��ַ
	private Integer status;    // ״̬
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
