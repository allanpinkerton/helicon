package com.allanpinkerton.helicon;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class TaskListFragment extends ListFragment{
	private static final String TAG = "TaksListFragment";
	private ArrayList<Task> mTasks;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.task_list_title);
		mTasks = TaskCenter.get(getActivity()).getTasks();

	}

	private class TaskAdapter extends ArrayAdapter<Task> {
		public TaskAdapter(ArrayList<Task> tasks) {super(getActivity(), 0, tasks);}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater()
						.inflate(R.layout.list_item_task,null);
			}
		}
	}
}
