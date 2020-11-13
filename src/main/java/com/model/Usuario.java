package com.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Usuario")
public class Usuario {
	
	private String username;
	private String password;
	private String roleID;
	
	public Usuario(String username, String password, String roleID) {
		super();
		this.username = username;
		this.password = password;
		this.roleID = roleID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}


	
}
