package com.finaptics.entity;

import java.time.LocalDate;
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
	
	@Column(name="mail")
	private String userMail;
	
	@Column(name="loc")
	private String location;
	
	@Column(name="date")
	private LocalDate purchasedDate;
	
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="users")
	private Set<Mobile> mobiles;

	protected User() {
		
	}
	
	public User(int id,String name,String mail,String loc,LocalDate date) {
		this.userId=id;
		this.userName=name;
		this.userMail=mail;
		this.location=loc;
		this.purchasedDate=date;
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
	
	

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	public LocalDate getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(LocalDate purchasedDate) {
		this.purchasedDate = purchasedDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", mobiles=" + mobiles + "]";
	}

	
}
