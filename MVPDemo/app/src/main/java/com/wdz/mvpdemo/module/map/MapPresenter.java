package com.wdz.mvpdemo.module.map;

import com.wdz.mvpdemo.bean.GankBeautyResult;
import com.wdz.mvpdemo.bean.Item;
import com.wdz.mvpdemo.network.Network;
import com.wdz.mvpdemo.util.GankBeautyResultToItemsMapper;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by cd on 17/3/17.
 * 联系作者:413526086@QQ.COM
 */

public class MapPresenter implements MapContract.Presenter {

    private MapContract.View mMapContractView;

    private CompositeSubscription mCompositeSubscription;

    public MapPresenter(MapContract.View mMapContractView) {
        this.mMapContractView = mMapContractView;
        this.mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mCompositeSubscription.clear();
    }

    @Override
    public void getAndroidSearchString(String str) {

    }

    @Override
    public void getAndroidItems(int page, int number, boolean isRefresh) {

        if (isRefresh){
            mMapContractView.showSwipLoading();
        }else {
            mMapContractView.hideSwipLoading();
        }

        Subscription subscription = Network.getGankApi()
                .getBeauties(number,page)
                .map(GankBeautyResultToItemsMapper.getInstance())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<Item>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mMapContractView.hideSwipLoading();
                        mMapContractView.getAndroidItemsFail();
                    }

                    @Override
                    public void onNext(List<Item> items) {
                        mMapContractView.hideSwipLoading();
                        mMapContractView.setAndroidItems(items);
                    }
                });

        mCompositeSubscription.add(subscription);
    }
}
