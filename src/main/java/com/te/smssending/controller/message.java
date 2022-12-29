package com.te.smssending.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class message {

	public static void sendSms(String number) throws IOException {
		String apiKey = "FOLu25P725gbH8yAgryrCQctrneq7yws7zDZPZRaaLSb4qPMddOGdnBBJSV2";
		String sendId = "FSTSMS";
		String variables_values="5599";
		String language = "english";
		String route = "otp";

			String myUrl = "https://www.fast2sms.com/dev/bulkV2?authorization=" + apiKey 
		+ "&variables_values=" +variables_values+ "&language=" + language + "&route=" + route + "&numbers=" + number;
		System.out.println(myUrl);
		URL url = new URL(myUrl);
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("cache-control", "no-cache");
		StringBuilder response = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		System.out.println("Wait..............");
		
		int code = con.getResponseCode();
		System.out.println("Response code : " + code);
		
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			response.append(line);
		}
		System.out.println(response);
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Program started.....");

		sendSms("8412998685");

	}
}
