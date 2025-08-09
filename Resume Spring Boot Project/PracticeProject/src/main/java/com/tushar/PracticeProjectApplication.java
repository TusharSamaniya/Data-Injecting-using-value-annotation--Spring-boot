package com.tushar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tushar.sbeans.HotelInfo;

@SpringBootApplication
public class PracticeProjectApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(PracticeProjectApplication.class, args);
		HotelInfo x = ctx.getBean("info", HotelInfo.class);
		System.out.println(x);
		System.out.println(x.calculateFinalAmount());
	}

}
