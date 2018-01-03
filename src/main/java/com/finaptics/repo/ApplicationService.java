package com.finaptics.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finaptics.entity.Mobile;
import com.finaptics.entity.User;

@Service
public class ApplicationService {

	@Autowired
	private MobileRepository mobileRepository;

	@Autowired
	private UserRepository userRepository;

	public void save(User user) {

		userRepository.save(user);

	}

	public void save1(Mobile mobile) {

		mobileRepository.save(mobile);

	}
	
	public Iterable<User> findAllUsers(){
		
	   return 	userRepository.findAll();
	}
	
	public Mobile findOneObject(int id) {
		
		return mobileRepository.findOne(id);
	}
	
	public User findUserByUserMail(String email) {
		
		return userRepository.findUserByUserMail(email);
	}
	
	public Mobile getMobileBymarketEntryDate(LocalDate date) {
		
		return mobileRepository.getMobileBymarketEntryDate(date);
	}
	
	public List<Mobile> getMobileBymarketEntryDateBetween(LocalDate date1,LocalDate date2){
		
		return mobileRepository.getMobileByMarketEntryDateBetween(date1, date2);
	}
	
	/*
	public void save2() {
		
		User user1=new User();
		user1.setUserId(1);
		user1.setUserName("Aravind");
		
		User user2=new User();
		user2.setUserName("Yash");
		
		Mobile mobile=new Mobile();
		mobile.setMobile_id(1);
		mobile.setBrandName("Moto");
		
		Set<User> users=new HashSet<>();
		users.add(user1);
		users.add(user2);
		
		
	}*/

}
