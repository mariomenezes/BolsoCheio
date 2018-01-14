package com.example.mario.bolsocheio.GasStationFragment;

////import android.app.ActionBar;
import android.app.Fragment;
//import android.os.Bundle;
//import android.app.Activity;
//import android.support.v7.widget.Toolbar;
//import android.view.Window;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.mario.bolsocheio.R;

public class MainGasStationFragment extends AppCompatActivity {
	// Declare Tab Variable
	android.support.v7.app.ActionBar.Tab Tab1;
	android.support.v7.app.ActionBar.Tab Tab2;
	android.support.v7.app.ActionBar.Tab Tab3;
	Fragment fragmentTab1 = new FragmentTab1();
	Fragment fragmentTab2 = new FragmentTab2();
	Fragment fragmentTab3 = new FragmentTab3();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		//requestWindowFeature(Window.FEATURE_ACTION_BAR);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_stations_fragment);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//		setSupportActionBar(toolbar);

		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		//getSupportActionBar();
		// Hide Actionbar Icon
		actionBar.setDisplayShowHomeEnabled(false);

		// Hide Actionbar Title
		actionBar.setDisplayShowTitleEnabled(false);

		// Create Actionbar Tabs
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Set Tab Icon and Titles
		//actionBar.addTab();

		//Tab1 = actionBar.newTab()
		Tab1 = actionBar.newTab().setIcon(R.drawable.tab1);
		Tab2 = actionBar.newTab().setText("Tab2");
		Tab3 = actionBar.newTab().setText("Tab3");

		// Set Tab Listeners
		Tab1.setTabListener(new TabListener(fragmentTab1));
		Tab2.setTabListener(new TabListener(fragmentTab2));
		Tab3.setTabListener(new TabListener(fragmentTab3));

		// Add tabs to actionbar
		actionBar.addTab(Tab1);
		actionBar.addTab(Tab2);
		actionBar.addTab(Tab3);
	}
}
