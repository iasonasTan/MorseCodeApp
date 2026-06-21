package com.morse.app;

import android.app.Activity;
import android.os.Bundle;
import androidx.viewpager2.widget.ViewPager2;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.Fragment;
import com.morse.app.fragment.ManualTransmitterFragment;
import androidx.appcompat.app.AppCompatActivity;

public final class MainActivity extends AppCompatActivity {
	private ViewPager2 mViewPager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FragmentStateAdapter fragmentStateAdapter = new FragmentAdapter(this);
		mViewPager = findViewById(R.id.fragment_adapter);
		mViewPager.setAdapter(fragmentStateAdapter);
	}

	private final class FragmentAdapter extends FragmentStateAdapter {
		public FragmentAdapter(FragmentActivity fa) {
			super(fa);
		}

		@Override
		public Fragment createFragment(int position) {
			switch(position) {
				case 1: return new ManualTransmitterFragment();
				default: throw new IllegalStateException();
			}
		}

		@Override
		public int getItemCount() {
			return 1;
		}
	}
}
