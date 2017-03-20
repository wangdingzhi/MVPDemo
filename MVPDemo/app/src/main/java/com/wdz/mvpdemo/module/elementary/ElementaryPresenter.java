package com.wdz.mvpdemo.module.elementary;

import android.util.Log;

import com.wdz.mvpdemo.bean.ZhuangbiImage;
import com.wdz.mvpdemo.network.Network;

import java.util.List;

import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by cd on 17/3/15.
 * 联系作者:413526086@QQ.COM
 */

public class ElementaryPresenter implements ElementaryContract.Presenter{

    private ElementaryContract.View mElementaryView;

    private CompositeSubscription mSubscriptions;

    public ElementaryPresenter(ElementaryContract.View androidView){

        mElementaryView =androidView;
        mSubscriptions = new CompositeSubscription();

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
    }

    @Override
    public void getAndroidSearchString(String str) {

        mElementaryView.showSwipLoading();

        Subscription subscription = Network.getZhuangbiApi()
                .search(str)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ZhuangbiImage>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mElementaryView.hideSwipLoading();
                        mElementaryView.getAndroidItemsFail();
                    }

                    @Override
                    public void onNext(List<ZhuangbiImage> zhuangbiImages) {
                        mElementaryView.hideSwipLoading();
                        mElementaryView.setAndroidItems(zhuangbiImages);

                    }
                });
        mSubscriptions.add(subscription);

    }
}
