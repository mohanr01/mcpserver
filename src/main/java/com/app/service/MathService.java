package com.app.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class MathService {
	
	@Tool(name = "add", description = "sum of two number")
	public ResponseWrapper add(int a, int b) {
		int result = a + b;
		ResponseWrapper resp = new ResponseWrapper("success", String.valueOf(result));
		return resp;
	}
	
	@Tool(name = "mulitply" , description = "multiply of two number")
	public ResponseWrapper multiply(int a, int b) {
		int result = a * b;
		ResponseWrapper resp = new ResponseWrapper("success", String.valueOf(result));
		return resp;
	}
	
	@Tool(name = "divide" , description = "divide of two number")
	public ResponseWrapper divide(int a, int b) {
		try {
			int result = a / b;
			ResponseWrapper resp = new ResponseWrapper("success", String.valueOf(result));
			return resp;
		}catch (ArithmeticException e) {
			ResponseWrapper resp = new ResponseWrapper("failure", String.valueOf(0));
			return resp; 
		}
	}

}
