package com.wsinger.iamhappy.data;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.widget.Toast;

import com.wsinger.iamhappy.MainActivity;

import java.util.List;

public class QuoteVpagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments;

    public QuoteVpagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        //Log.d("AdapterVP", "getItem: "+fragments.get(position).toString());
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
