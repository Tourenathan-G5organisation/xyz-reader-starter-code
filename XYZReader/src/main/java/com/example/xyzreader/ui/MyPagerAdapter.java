package com.example.xyzreader.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.database.Cursor;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.example.xyzreader.data.ArticleLoader;

class MyPagerAdapter extends FragmentStatePagerAdapter {
    ArticleDetailActivity mActivity;
    Cursor mCursor;

    public MyPagerAdapter(FragmentManager fm, ArticleDetailActivity activity) {
        super(fm);
        mActivity = activity;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        ArticleDetailFragment fragment = (ArticleDetailFragment) object;
    }

    @Override
    public Fragment getItem(int position) {
        mCursor.moveToPosition(position);
        return ArticleDetailFragment.newInstance(mCursor.getLong(ArticleLoader.Query._ID));
    }

    @Override
    public int getCount() {
        return (mCursor != null) ? mCursor.getCount() : 0;
    }

    void setmCursor(Cursor cursor){
        mCursor = cursor;
    }
}
