package ch04.domain;

public class Post {
	private String title;
	private String content;
	// �����ڰ� ��� ���̹�Ƽ���� or ���� �˾Ƽ� ���ش�
	
	@Override
	public String toString() {
		return String.format("%s %s", title, content);
	}
}
