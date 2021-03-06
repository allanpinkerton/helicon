package com.allanpinkerton.helicon;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import android.content.Context;

public class TaskCenter {
	private static String TAG = "TaskCenter";
	private static TaskCenter mTaskCenter;
	private static Context mAppContext;
	private ArrayList<Task> mTasks;
	
	private TaskCenter(Context appContext) {
		//initiates as new arraylist to store tasks
		mAppContext = appContext;
		mTasks = new ArrayList<Task>();
		
		for (int i = 0; i<50; i++) {
			Task t = new Task();
			t.setTitle("Task "+i);
			t.setSolved(false);
			t.setDueDate(new Date());
			
			mTasks.add(t);
		}
	}
	
	public static TaskCenter get(Context c) {
		if (mTaskCenter == null) {
			mTaskCenter = new TaskCenter(c.getApplicationContext());
		}
		return mTaskCenter;
	}
	
	public ArrayList<Task> getTasks() {
		return mTasks;
	}

	public Task getTask(UUID id) {
		for (Task t : mTasks) {
			if (t.getId().equals(id)) {
				return t;
			}
		}
		return null;
	}
	public void addTask(Task t) {
		mTasks.add(t);
	}
	
	public void deleteTask(Task t) {
		mTasks.remove(t);
	}

}
