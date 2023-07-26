package org.edupoll.model;

import java.util.Date;

public class Quest {
	int id;
	String description;
	Date endDate;
	int joinCnt;

	public Quest(int id, String description, Date endDate, int joinCnt) {
		super();
		this.id = id;
		this.description = description;
		this.endDate = endDate;
		this.joinCnt = joinCnt;
	}

	public Quest() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getJoinCnt() {
		return joinCnt;
	}

	public void setJoinCnt(int joinCnt) {
		this.joinCnt = joinCnt;
	}

}
