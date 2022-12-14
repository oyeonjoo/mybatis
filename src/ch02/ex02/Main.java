package ch02.ex02;

import java.time.LocalDate;

import config.Configuration;

public class Main {
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class);
		
		System.out.println(mapper.selectUser(1));
		System.out.println(mapper.selectUser2("john"));
		
		//과제] john 을 조회하라.
		System.out.println(mapper.selectUser3(LocalDate.of(2002,07,22)));
	}
}