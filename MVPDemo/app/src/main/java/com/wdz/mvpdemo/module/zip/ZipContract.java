package com.wdz.mvpdemo.module.zip;

import com.wdz.mvpdemo.base.BasePresenter;
import com.wdz.mvpdemo.base.BaseView;

/**
 * Created by cd on 17/4/1.
 * 联系作者:413526086@QQ.COM
 */

public interface ZipContract {

    interface View extends BaseView {

        void setAndroidItems();

        void getAndroidItemFail();

        void showSwipLoading();

        void hideSwipLoading();

    }

    interface Presenter extends BasePresenter {

        void getAndroidItem();
    }

    interface Model {

    }
}
