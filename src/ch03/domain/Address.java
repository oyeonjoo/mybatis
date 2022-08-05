package ch03.domain;

public class Address {
	private String address;
	
	@Override
	public String toString() {
		return address;
	}
} // or 맵핑할 때 쓰이는 setter는 mybatis가 준비해준다