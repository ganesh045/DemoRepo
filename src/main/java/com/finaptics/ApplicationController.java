package com.finaptics;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finaptics.entity.Mobile;
import com.finaptics.entity.User;
import com.finaptics.repo.ApplicationService;

@RestController
public class ApplicationController {
	
	@Autowired
	private ApplicationService service;
	
	@PostMapping("/saveuser")
	public void save(@RequestBody User user) {
		
		 service.save(user);
	}
	
	@PostMapping("/savemobile")
	public void saveMobile(@RequestBody Mobile mobile) {
		
		service.save1(mobile);
	}
	@GetMapping("/findall")
	@ResponseBody
	public Iterable<User> findAllUsers(){
		
		return service.findAllUsers();
	}
	@GetMapping("/findonemobile/{id}")
	public Mobile findObject(@PathVariable int id) {
		
		return service.findOneObject(id);
	}
	
	@GetMapping("/getuser/{email:.+}")
	public User findUserByUserMail(@PathVariable String email) {
		
		return service.findUserByUserMail(email);
	}
	
	@GetMapping("/localdatetime")
	public LocalDateTime findTime() {
		return LocalDateTime.now();
	}
	@GetMapping("/getmobilebydate/{date}")
	public Mobile getMobileBymarketEntryDate(@PathVariable LocalDate date) {
		
		return service.getMobileBymarketEntryDate(date);
	}
	
	@GetMapping("/getmobilebydate2")
	public List<Mobile> collecting() {
		
		LocalDate date1=service.findOneObject(1).getMarketEntryDate();
		LocalDate date2=service.findOneObject(3).getMarketEntryDate();
		
		return 	service.getMobileBymarketEntryDateBetween(date1, date2);
		
	}
	@GetMapping("/date")
	public LocalDate timeTaking() {
		
		LocalDate date1=service.findOneObject(1).getMarketEntryDate();
		return date1;
	}
	
	
	
	
	
	/*
	@PostMapping("/saveusers")
	public void save2() {
		
		 service.save2();
	}
	*/

}
