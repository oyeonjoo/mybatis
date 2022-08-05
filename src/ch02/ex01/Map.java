package ch02.ex01;

import java.util.List;

import ch02.domain.User;

public interface Map {
	List<User> selectUsers(); // List 타입으로 리턴
}
// 도메인은 데이터를 여러개 가져올거면 복수 selectUsers
// configuration 마지막줄 getMapper(arg) 여기 괄호안에 ch02.ex01 치면 이 인터페이스 호출가능
// 여기까지 해두면 마이바티스가 알아서 한다. 프레임워크 장점.