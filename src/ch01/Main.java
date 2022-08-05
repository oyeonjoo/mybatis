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
			query += " FROM USERS"; // spagetti code. ���׹��� �����ڵ�.
			stmt = conn.prepareStatement(query); //�� ������ ����Ŭ�� ��������
			rs = stmt.executeQuery(); //����Ŭ�� ������. ������ rs���� �����ؼ� ��üȭ.
			
			// OR mapping(Object Relation).r�� �մ·ο츦 ������Ʈ�� �����ؾ���
			User user = null;
			while(rs.next()) { //nextȣ��ɶ����� Ŀ��(1�����ڵ�2�����ڵ�..)�̵�
				user = new User(); //���������� john.
				user.setUserId(rs.getInt(1)); //Ŀ���� ����Ű�� 1�� ���ڵ� �о��.
				user.setUserName(rs.getString(2)); //2��°���̺�
				user.setRegDate(rs.getDate(3));
				
				System.out.println(user);
			}
			
		} catch(Exception e) {
			e.printStackTrace(); //�������� �׳� �����޼��� ���.
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
����,��Ģ�� ���� ǥ���� �ڿ��� �ּ�.

Ŀ�ؼǸ������Ѥ�����Ƽ� ����Ŭ������ �������̴�. 5�� �ּҸ�.
mybatis�� Ŀ�ؼ� ���� ���� �ִ�. 6��

12��
13������
14�����̺�

20��..conn��ü�� ���ᰴü�� ����?,..����Ŭ��?

jdbc���� �̷��� ������ �� �� �ۿ� ����.

22�� ���δٸ� �� ���׹��� �����־� �������� ��ƴ�.

28�� nextȣ���ϸ�
Ŀ��(1�����ڵ�2�����ڵ�..)�̵�
�ش緹�ڵ忡 �ο찡 ������ true����
�ʵ尪�� ������������� �ִ´�.
*/