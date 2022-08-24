package org.younes.quiz_game;

public class Level {
	
	int id ; 
	String levelname ;
	String photodir ;
	String solution ; 
	boolean isSolved ;
	int attempts ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLevelname() {
		return levelname;
	}
	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}
	public String getPhotodir() {
		return photodir;
	}
	public void setPhotodir(String photodir) {
		this.photodir = photodir;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public boolean isSolved() {
		return isSolved;
	}
	public void setSolved(boolean isSolved) {
		this.isSolved = isSolved;
	}
	public int getAttempts() {
		return attempts;
	}
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	} 
	
	
}
