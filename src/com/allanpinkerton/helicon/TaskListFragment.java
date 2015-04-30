package com.allanpinkerton.helicon;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

public class TaskListFragment extends ListFragment{
	private static final String TAG = "TaksListFragment";
	private ArrayList<Task> mTasks;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.task_list_title);

	}
}
