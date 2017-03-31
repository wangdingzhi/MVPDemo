package com.wdz.mvpdemo.module.map;

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
}
