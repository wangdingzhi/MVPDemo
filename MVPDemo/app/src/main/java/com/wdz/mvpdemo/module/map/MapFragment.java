package com.wdz.mvpdemo.module.map;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wdz.mvpdemo.R;
import com.wdz.mvpdemo.adapter.ItemListAdapter;
import com.wdz.mvpdemo.bean.Item;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @Bind(R.id.recyclerView) RecyclerView gridRv;

    private ItemListAdapter adapter = new ItemListAdapter();

    private MapPresenter presenter = new MapPresenter(this);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_map,container,false);

        ButterKnife.bind(this,view);
        gridRv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        gridRv.setAdapter(adapter);

        swipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW);
        swipeRefreshLayout.setEnabled(false);

        return view;
    }

    @OnClick(R.id.previousPageBt)
    void prevoudsPage(){

        loadPage(--pageNo);

        if (pageNo ==1){
            prevoudsPageBt.setEnabled(false);
        }
    }

    @OnClick(R.id.nextPageBt)
    void nextPage(){
        loadPage(++pageNo);
        if (pageNo ==2){
            prevoudsPageBt.setEnabled(true);
        }
    }

    @Override
    public void setAndroidItems(List<Item> items) {
        adapter.setImages(items);
        pageTv.setText(getString(R.string.page_with_number,pageNo));
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

    public void loadPage(int pageNo){
        presenter.getAndroidItems(pageNo,10,true);
    }
}
