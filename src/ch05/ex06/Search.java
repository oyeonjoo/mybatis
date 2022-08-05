package ch05.ex06;

import java.util.List;

public class Search {
	private int[] userIds;
	private List<String> userNames; // 파라미터가 n개인 경우
	
	public Search(int[] userId, List<String> userNames) {
		this.userIds = userIds;
		this.userNames = userNames;
	}	
}
