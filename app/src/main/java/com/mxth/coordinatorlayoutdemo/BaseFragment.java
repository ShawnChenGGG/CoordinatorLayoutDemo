package com.mxth.coordinatorlayoutdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/10/14.
 */

public abstract class BaseFragment extends Fragment {

    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=initView();
        initData();
        return v;
    }
    private View initView(){
        View v= View.inflate(getActivity(),R.layout.fragment,null);
        tv = (TextView) v.findViewById(R.id.tv);
        return v;
    }
    private void initData(){
        tv.setText(getText());
    }
    public abstract String getText();
}
