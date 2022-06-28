package com.raquelmichelon.crudrestapijpapostgresqlspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raquelmichelon.crudrestapijpapostgresqlspringboot.model.User;


//we have extended JpaRepository in our UserRepository so we can use methods of 
//JpaRepository: save(), findOne(), findById(), findAll(), count(), delete(), deleteById() etc 
//without implementing these methods.

//We can also define our custom methods in UserRepository. 
//I have defined findByEmailAndMobNo which return the user’s data based on email & mobile number.



public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmailAndMobNo(String email, String mobNo);

}
