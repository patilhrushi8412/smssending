package com.te.smssending.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Service;

@Service
public class SmsServices {

	public String sentSms(String number) throws IOException {

		String apiKey = "Av6TFe6PEXw6mxmrfBfwcSFVWP7tEB7NBasNSojuhFNrz2Bar3nN1bHBJZKW";
		String sendId = "FastSM";
		String message = "HI YOUR OTP IS 1111";
		String language = "english";
		String route = "v3";
		message = URLEncoder.encode(message, "UTF-8");
		String myUrl = 
				"https://www.fast2sms.com/dev/bulkV2?authorization=" + apiKey + "&sender_id=" + sendId
				+ "&message=" + message + "&route=" + route + "&numbers=" + number;
		System.out.println(myUrl);
		URL url = new URL(myUrl);
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("cache-control", "no-cache");
		StringBuilder response = new StringBuilder();
		System.err.println(message + "     hello");
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
		return "Message Sent Succesfully";
	}
}