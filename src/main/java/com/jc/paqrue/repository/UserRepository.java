package com.jc.paqrue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jc.paqrue.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT * FROM user_model um WHERE um.email = :user_email AND um.password = :user_pass", nativeQuery = true)
	public User logInUser(@Param("user_email") String user_email, @Param("user_pass") String user_pass);
	
	@Query(value = "SELECT * FROM user_model um WHERE um.email = :user_email", nativeQuery = true)
	public User findByEmail(@Param("user_email") String user_email);

}
