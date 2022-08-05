package ch02.ex02;

import java.time.LocalDate;

import ch02.domain.User;

public interface Map {
	User selectUser(int userId); // User 타입 or null 로 리턴
	User selectUser2(String userName);
	User selectUser3(LocalDate regDate);
}
// 도메인은 데이터를 한개만 가져올거면 단수형으로 써준다 selectUser