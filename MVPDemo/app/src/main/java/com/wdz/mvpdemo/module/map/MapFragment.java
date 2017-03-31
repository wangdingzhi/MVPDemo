package com.wdz.mvpdemo.module.map;

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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wdz.mvpdemo.R;
import com.wdz.mvpdemo.adapter.ItemListAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cd on 17/3/17.
 * 联系作者:413526086@QQ.COM
 */

public class MapFragment extends Fragment implements MapContract.View{

    private int pageNo =0;

    @Bind(R.id.pageTv) TextView pageTv;

    @Bind(R.id.previousPageBt) Button prevoudsPageBt;

    @Bind(R.id.nextPageBt) Button nextPageBt;

    @Bind(R.id.swipeRefreshLayout) SwipeRefreshLayout swipeRefreshLayout;

    @Bind(R.id.gridRv) RecyclerView gridRv;

    private ItemListAdapter adapter = new ItemListAdapter();

    private MapPresenter presenter = new MapPresenter(this);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_map,container,false);
        ButterKnife.bind(this,view);
        gridRv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        gridRv.setAdapter(adapter);

        swipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW);
        swipeRefreshLayout.setEnabled(false);

        return view;
    }

    @Override
    public void setAndroidItems() {

       
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
}
