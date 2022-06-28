package com.raquelmichelon.crudrestapijpapostgresqlspringboot.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

//@JsonInclude(JsonInclude.Include.NON_NULL) indicates that property is serialized if its value is not null.
//@JsonIgnoreProperties(ignoreUnknown =true) indicate that any unknown property in JSON String 
//i.e. any property for which we don’t have a corresponding field will be ignored.

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultDTO<T> {

	private T data;
	private String message;
	private boolean isSuccess;

	public ResultDTO() {
		super();
	}

	public ResultDTO(T data, String message, boolean isSuccess) {
		super();
		this.data = data;
		this.message = message;
		this.isSuccess = isSuccess;
	}

	public ResultDTO(String message, boolean isSuccess) {
		super();
		this.message = message;
		this.isSuccess = isSuccess;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

}
