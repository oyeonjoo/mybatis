package ch05.domain;

public class Search {
	private String userName; // 작성자명
	private Post post; // 글제목, 글내용
	
	public Search(String userName, Post post) {
		this.userName = userName;
		this.post = post;
	}
}
