package ch04.domain;

public class Post {
	private String title;
	private String content;
	// 생성자가 없어도 마이바티스가 or 맵핑 알아서 해준다
	
	@Override
	public String toString() {
		return String.format("%s %s", title, content);
	}
}
