package com.cruds.exception;

public class StudentException extends RuntimeException {
	private String info;
	public StudentException(String info)
	{
		this.info = info;
	}
	public String getInfo()
	{
		return info;
	}

}
