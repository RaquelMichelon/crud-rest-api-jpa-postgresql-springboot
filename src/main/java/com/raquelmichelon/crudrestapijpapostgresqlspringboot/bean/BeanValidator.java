package com.raquelmichelon.crudrestapijpapostgresqlspringboot.bean;

import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.stereotype.Component;

import com.raquelmichelon.crudrestapijpapostgresqlspringboot.model.User;

//some basic validations for CRUD Operations

//@Component annotation allows Spring to automatically detect our custom beans. 
//In other words, without having to write any explicit code.

@Component
public class BeanValidator {

	public Validator getValidator() {
		return Validation.buildDefaultValidatorFactory().getValidator();
	}

	public ArrayList<String> userValidate(User user) {
		ArrayList<String> arrayList = new ArrayList<>();
		Set<ConstraintViolation<User>> constraintViolations = getValidator().validate(user);
		for (ConstraintViolation<User> constraintViolation : constraintViolations) {
			if (constraintViolation.getPropertyPath().toString().equals("name")) {
				arrayList.add(constraintViolation.getMessage());
			}
			if (constraintViolation.getPropertyPath().toString().equals("email")) {
				arrayList.add(constraintViolation.getMessage());
			}
			if (constraintViolation.getPropertyPath().toString().equals("mobNo")) {
				arrayList.add(constraintViolation.getMessage());
			}
			if (constraintViolation.getPropertyPath().toString().equals("password")) {
				arrayList.add(constraintViolation.getMessage());
			}
		}
		return arrayList;
	}

}
