package com.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Usuario")
public class Usuario {
	
	

	private String username;
	private byte salt[];
	private byte[] hash;
	private String roleID;
	
	public Usuario(String username, byte[] salt, byte[] hash, String roleID) {
		super();
		this.username = username;
		this.salt = salt;
		this.hash = hash;
		this.roleID = roleID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public byte[] getHash() {
		return hash;
	}

	public void setHash(byte[] hash) {
		this.hash = hash;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}
	
	
}
