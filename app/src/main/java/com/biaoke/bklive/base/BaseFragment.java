package com.biaoke.bklive.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Holiday on 2017/2/22.
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mContextView = inflater.inflate(bindLayout(), container, false);
        initView(mContextView);
        return mContextView;
    }
    /**
     * [绑定布局]
     */
    protected abstract int bindLayout();
    /**
     * [初始化控件]
     */
    protected abstract void initView(final View view);
}
