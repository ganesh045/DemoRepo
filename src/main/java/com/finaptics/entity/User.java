package com.finaptics.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	@Column(name="uname")
	private String userName;
	
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="users")
	private Set<Mobile> mobiles;

	protected User() {
		
	}
	
	public User(int id,String userName) {
		this.userId=id;
		this.userName=userName;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Mobile> getMobiles() {
		return mobiles;
	}

	public void setMobiles(Set<Mobile> mobiles) {
		this.mobiles = mobiles;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", mobiles=" + mobiles + "]";
	}

	
}
