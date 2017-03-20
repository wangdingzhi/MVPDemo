package com.wdz.mvpdemo.module.elementary;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import com.wdz.mvpdemo.R;
import com.wdz.mvpdemo.adapter.ZhuangbiListAdapter;
import com.wdz.mvpdemo.bean.ZhuangbiImage;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

/**
 * Created by cd on 17/3/15.
 * 联系作者:413526086@QQ.COM
 */

public class ElementaryFragment extends Fragment implements ElementaryContract.View{

    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Bind(R.id.gridRv)
    RecyclerView gridRv;

    private ZhuangbiListAdapter adapter = new ZhuangbiListAdapter();

    private ElementaryContract.Presenter mPresenter = new ElementaryPresenter(this);

    @OnCheckedChanged({R.id.searchRb1,R.id.searchRb2,R.id.searchRb3,R.id.searchRb4})
    void onTagChecked(RadioButton searchRb,boolean check){

        if (check){
            adapter.setImages(null);
            mPresenter.getAndroidSearchString(searchRb.getText().toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_elementary,container,false);
        ButterKnife.bind(this,view);
        gridRv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        gridRv.setAdapter(adapter);

        swipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW);
        swipeRefreshLayout.setEnabled(false);

        return view;
    }

    @Override
    public void setAndroidItems(List<ZhuangbiImage> images) {

        adapter.setImages(images);
    }

    @Override
    public void getAndroidItemsFail() {
        Toast.makeText(getActivity(),"加载失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSwipLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideSwipLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.unsubscribe();
    }
}
