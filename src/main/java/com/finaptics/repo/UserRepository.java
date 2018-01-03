package com.finaptics.repo;

import org.springframework.data.repository.CrudRepository;

import com.finaptics.entity.User;

public interface UserRepository extends CrudRepository<User , Integer> {
	
	User findUserByUserMail(String email);

}
