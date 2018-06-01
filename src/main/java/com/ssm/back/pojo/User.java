package com.ssm.back.pojo;

public class User {
	private Integer id;

	private String userName;

	private String password;

	private String roleName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	public User(Integer id, String userName, String password, String roleName) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.roleName = roleName;
	}
	
	public User() {}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", roleName=" + roleName + "]";
	}
}