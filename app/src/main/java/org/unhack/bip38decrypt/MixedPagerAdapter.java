package org.unhack.bip38decrypt;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by unhack on 6/23/16.
 */
public class MixedPagerAdapter extends FragmentPagerAdapter {
    private final List<mFragment> mFragments = new ArrayList<mFragment>();

    public MixedPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    public void addFragment(mFragment fragment) {
        fragment.setId(mFragments.size());
        mFragments.add(fragment);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public CharSequence  getPageTitle(int id){
        return String.valueOf(mFragments.get(id).getTabId());
    }

    public void NavigateToTab(int tabId){
        Bundle data = new Bundle();
        Message msg = new Message();
        data.putInt(MainActivity.TABNUMBER, tabId);
        msg.setData(data);
        MainActivity.mSwipeHandler.sendMessage(msg);
    }

    public void CoolNavigateToTab(int tabId, String tabIdKey, Handler handlerToNotify){
        Bundle data = new Bundle();
        Message msg = new Message();
        data.putInt(tabIdKey,tabId);
        msg.setData(data);
        handlerToNotify.sendMessage(msg);
    }

}
