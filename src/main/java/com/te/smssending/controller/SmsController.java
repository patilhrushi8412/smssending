package com.te.smssending.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.smssending.services.SmsServices;

@RestController
public class SmsController {

	@Autowired
	SmsServices services;
	
	@PostMapping("/sms")
	public String smsSendeing(@RequestParam String mobile) throws IOException {
		return services.sentSms(mobile);
	} 
}
