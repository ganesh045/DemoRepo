package com.finaptics.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Mobile {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int mobileId;
	
	@Column(name="bname")
	private String brandName;
	
	@JsonIgnore
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="mobile_user",joinColumns=@JoinColumn(name="mobile_id"),inverseJoinColumns=@JoinColumn(name="user_id"))
	private Set<User> users;

	protected Mobile() {
		
	}
	
	public Mobile(int id, String name) {
		
		this.mobileId=id;
		this.brandName=name;
		
	}

	public int getMobile_id() {
		return mobileId;
	}

	public void setMobile_id(int mobile_id) {
		this.mobileId = mobile_id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Mobile [mobile_id=" + mobileId + ", brandName=" + brandName + ", users=" + users + "]";
	}
	
	

}
