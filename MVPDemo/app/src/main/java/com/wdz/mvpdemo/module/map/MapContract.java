package com.wdz.mvpdemo.module.map;

import com.wdz.mvpdemo.base.BasePresenter;
import com.wdz.mvpdemo.base.BaseView;

/**
 * Created by cd on 17/3/17.
 * 联系作者:413526086@QQ.COM
 */

public interface MapContract {

    interface View extends BaseView{

        void setAndroidItems();

        void getAndroidItemsFail();

        void showSwipLoading();

        void hideSwipLoading();

    }

    interface Presenter extends BasePresenter{

        void getAndroidSearchString(String str);

    }

    interface ModelInterface{

    }
}
