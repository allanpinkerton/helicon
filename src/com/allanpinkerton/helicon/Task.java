package com.allanpinkerton.helicon;

import java.util.Date;
import java.util.UUID;

import javax.xml.datatype.Duration;

public class Task {
	private UUID mId;
	private String mTitle;
	private Date mDueDate;
	private boolean mSolved;
	private String mCategory;
	private Duration mDuration;
	private int mImportance;
	
	public Task() {
		mId = UUID.randomUUID();
		mDueDate = new Date();
	}
	
	@Override
	public String toString() {
		return mTitle;
	}

	public String getTitle() {
		return mTitle;
	}
	public void setTitle(String title) {
		mTitle = title;
	}
	public Date getDueDate() {
		return mDueDate;
	}
	public void setDueDate(Date dueDate) {
		mDueDate = dueDate;
	}
	public UUID getId() {
		return mId;
	}

	public String getCategory() {
		return mCategory;
	}

	public void setCategory(String category) {
		mCategory = category;
	}

	public Duration getDuration() {
		return mDuration;
	}

	public void setDuration(Duration duration) {
		mDuration = duration;
	}

	public int getImportance() {
		return mImportance;
	}

	public void setImportance(int importance) {
		mImportance = importance;
	}

	public boolean isSolved() {
		return mSolved;
	}

	public void setSolved(boolean solved) {
		mSolved = solved;
	}

	
}
