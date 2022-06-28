package com.raquelmichelon.crudrestapijpapostgresqlspringboot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raquelmichelon.crudrestapijpapostgresqlspringboot.bean.BeanValidator;
import com.raquelmichelon.crudrestapijpapostgresqlspringboot.bean.ResultDTO;
import com.raquelmichelon.crudrestapijpapostgresqlspringboot.model.User;
import com.raquelmichelon.crudrestapijpapostgresqlspringboot.service.UserService;


//@RestController annotation is used to define a controller and to indicate that 
//the return value of the methods should be bound to the web response body

//@RequestMapping("/api/v1") declares that all APIs url in the controller will start with /api/v1



@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired //to inject bean as a local variable
	private UserService userService;

	@Autowired //to inject bean as a local variable
	private BeanValidator beanValidator;
	
	
//	@RequestBody indicates that Spring should deserialize a request body into an object. 
//	This object is passed as a handler method parameter. If you want to get the data in form type, 
//	You should use @ModelAttribute instead of @RequestBody.
	
	
//	/api/v1/createUser (POST): Create a new user.

	@PostMapping("/createUser")
	public ResponseEntity<?> createUser(@RequestBody User reqData) {
		System.err.println(":::  UserController.createUser :::");
		ResultDTO<?> responsePacket = null;
		try {
			ArrayList<String> errorList = beanValidator.userValidate(reqData);
			if (errorList.size() != 0) {
				ResultDTO<ArrayList<String>> errorPacket = new ResultDTO<>(errorList,
						"Above fields values must not be empty", false);
				return new ResponseEntity<>(errorPacket, HttpStatus.BAD_REQUEST);
			}
			User isData = userService.isDataExist(reqData);
			if (isData == null) {
				responsePacket = new ResultDTO<>(userService.createUser(reqData), "User Created Successfully", true);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				responsePacket = new ResultDTO<>("Record already exist", false);
				return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	
//	/api/v1/allUsers (GET): Retrieve all users from the database.

	@GetMapping("/allUsers")
	public ResponseEntity<?> allUsers() {
		System.err.println(":::  UserController.allUsers :::");
		ResultDTO<?> responsePacket = null;
		try {
			responsePacket = new ResultDTO<>(userService.getAllUsers(), "Users fetched successfully !!", true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	
//	/api/v1/getUserById (GET): Retrieve a user from the database.

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
		System.err.println(":::  UserController.getUserById :::");
		ResultDTO<?> responsePacket = null;
		try {
			responsePacket = new ResultDTO<>(userService.getUserById(id), "User fetched successfully !!", true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	
//	/api/v1/updateUser (PUT): Update record of a user.

	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody User reqData) {
		System.err.println(":::  UserController.updateUser :::");
		ResultDTO<?> responsePacket = null;
		try {
			User isData = userService.isDataExist(reqData);
			if (isData != null) {
				responsePacket = new ResultDTO<>(userService.updateUser(reqData, isData), "User Updated Successfully",
						true);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				responsePacket = new ResultDTO<>("Record not exist", false);
				return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	
//	/api/v1/deleteUserById (DELETE): Delete a user.

	@DeleteMapping("/deleteUserById/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") Long id) {
		System.err.println(":::  UserController.deleteUserById :::");
		ResultDTO<?> responsePacket = null;
		try {
			responsePacket = new ResultDTO<>(userService.deleteUserById(id), "User deleted successfully !!", true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}

}
