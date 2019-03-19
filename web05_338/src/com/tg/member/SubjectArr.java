package com.tg.member;

public class SubjectArr {
	
	private String subject = "";
	private int num = 0;
	private int score = 0;
	
	public String getSubject() {
		return subject;
	}

	public SubjectArr( int num, String subject, int score) {
		super();
		this.subject = subject;
		this.num = num;
		this.score = score;
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
