package com.tg.member;

public class SubjectDto {

	private String subject = "";
	private int num = 0;
	private int score = 0;
	
	
	
	public SubjectDto( int num, String subject, int score) {
		super();
		this.subject = subject;
		this.num = num;
		this.score = score;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
