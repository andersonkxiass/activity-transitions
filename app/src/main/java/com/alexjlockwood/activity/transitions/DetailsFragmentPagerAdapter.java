package com.alexjlockwood.activity.transitions;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import static com.alexjlockwood.activity.transitions.Constants.ALBUM_IMAGE_URLS;

/**
 * Created by anderson.acs on 1/27/2016.
 */
public class DetailsFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private  int mStartingPosition;
    DetailsFragment mCurrentDetailsFragment;

    public DetailsFragmentPagerAdapter(FragmentManager fm, int startPosition) {
        super(fm);
        this.mStartingPosition  = startPosition;
    }

    @Override
    public Fragment getItem(int position) {
        return DetailsFragment.newInstance(position, mStartingPosition);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        mCurrentDetailsFragment = (DetailsFragment) object;
    }

    public DetailsFragment getCurrentFragment(){
        return this.mCurrentDetailsFragment;
    }

    @Override
    public int getCount() {
        return ALBUM_IMAGE_URLS.length;
    }
}