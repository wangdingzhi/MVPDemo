package com.wdz.mvpdemo.module.zip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wdz.mvpdemo.R;

/**
 * Created by cd on 17/4/1.
 * 联系作者:413526086@QQ.COM
 */

public class ZipFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_map,container,false);

        return view;
    }
}
