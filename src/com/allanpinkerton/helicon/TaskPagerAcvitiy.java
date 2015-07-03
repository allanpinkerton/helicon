package com.allanpinkerton.helicon;

import java.util.ArrayList;
import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

public class TaskPagerAcvitiy extends FragmentActivity {
	private ViewPager mViewPager;
	private ArrayList<Task> mTasks;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mViewPager = new ViewPager(this);
		mViewPager.setId(R.id.viewPager);
		setContentView(mViewPager);
		
		mTasks = TaskCenter.get(this).getTasks();
		
		FragmentManager fm = getSupportFragmentManager();
		mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
			
			@Override
			public int getCount() {
				return mTasks.size();
			}
			
			@Override
			public Fragment getItem(int pos) {
				Task task = mTasks.get(pos);
				return TaskFragment.newInstance(task.getId());
			}
		});
		mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int pos) {
				Task crime = mTasks.get(pos);
				if (crime.getTitle() != null) {
					setTitle(crime.getTitle());
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				//does nothing
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				//does nothing
			}
		});
		
		UUID crimeId = (UUID) getIntent().getSerializableExtra(TaskFragment.EXTRA_CRIME_ID);
		for(int i=0; i<mTasks.size(); ++i) {
			if(mTasks.get(i).getId().equals(crimeId)) {
				mViewPager.setCurrentItem(i);
				break;
			}
		}
	}
}
