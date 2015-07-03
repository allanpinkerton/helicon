package com.allanpinkerton.helicon;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class TaskListFragment extends ListFragment{
	private static final String TAG = "TaksListFragment";
	private ArrayList<Task> mTasks;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.task_list_title);
		mTasks = TaskCenter.get(getActivity()).getTasks();
		TaskAdapter adapter = new TaskAdapter(mTasks);
		setListAdapter(adapter);
		setRetainInstance(true);

	}
	
	@Override
	public void onResume() {
		super.onResume();
		((TaskAdapter) getListAdapter()).notifyDataSetChanged();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = super.onCreateView(inflater, parent, savedInstanceState);
		ListView listView = (ListView) v.findViewById(android.R.id.list);
		registerForContextMenu(listView);
		return v;
	}
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Task t = ((TaskAdapter) getListAdapter()).getItem(position);
		Intent i = new Intent();
	}
	private class TaskAdapter extends ArrayAdapter<Task> {
		public TaskAdapter(ArrayList<Task> tasks) {
			super(getActivity(), 0, tasks);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater()
						.inflate(R.layout.list_item_task, null);
			}
			Task t = getItem(position);
			
			TextView titleTextView = 
					(TextView) convertView.findViewById(R.id.task_list_item_titleTextView);
			titleTextView.setText(t.getTitle());
			
			TextView dueDateTextView =
					(TextView) convertView.findViewById(R.id.task_list_item_dateTextView);
			dueDateTextView.setText(t.getDueDate().toString());
			
			CheckBox solvedCheckBox = (CheckBox)convertView.findViewById(R.id.task_list_item_solvedCheckBox);
			solvedCheckBox.setChecked(t.isSolved());
			
			return convertView;
		}
	}
}
