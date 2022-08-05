package ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
	public static void main(String[] args) {
		final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		final String DB_USER = "mybatis";
		final String DB_PASSWORD = "mybatis";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
			String query = ("SELECT USER_ID, USER_NAME, REG_DATE");
			query += " FROM USERS"; // spagetti code. 뒤죽박죽 섞인코드.
			stmt = conn.prepareStatement(query); //이 쿼리를 오라클로 보내야함
			rs = stmt.executeQuery(); //오라클로 보내짐. 쿼리를 rs으로 포장해서 객체화.
			
			// OR mapping(Object Relation).r에 잇는로우를 오브젝트로 매핑해야함
			User user = null;
			while(rs.next()) { //next호출될때마다 커서(1번레코드2번레코드..)이동
				user = new User(); //최초유저는 john.
				user.setUserId(rs.getInt(1)); //커서가 가리키는 1번 레코드 읽어낸다.
				user.setUserName(rs.getString(2)); //2번째테이블
				user.setRegDate(rs.getDate(3));
				
				System.out.println(user);
			}
			
		} catch(Exception e) {
			e.printStackTrace(); //에러나면 그냥 에러메세지 출력.
		} finally {
			try {
			rs.close();
			stmt.close();
			conn.close();
			} catch(Exception e) {}
		}
	}
}
/*
url : Uniform Resource Locator
문법,규칙에 맞춰 표현한 자원의 주소.

커넥션리퀘스ㅡㅌ에담아서 오라클서버에 보낼것이다. 5번 주소를.
mybatis는 커넥션 맺을 권한 있다. 6번

12번
13번쿼리
14번테이블

20번..conn객체를 연결객체로 쓴다?,..오라클과?

jdbc쓰면 이렇게 더럽게 쓸 수 밖에 없다.

22번 서로다른 언어가 뒤죽박죽 섞여있어 유지보수 어렵다.

28번 next호출하면
커서(1번레코드2번레코드..)이동
해당레코드에 로우가 잇으면 true리턴
필드값을 멤버변수값으로 넣는다.
*/