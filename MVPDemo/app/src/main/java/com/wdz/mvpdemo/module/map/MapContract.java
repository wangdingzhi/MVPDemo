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

    }

    interface Presenter extends BasePresenter{



    }

    interface Model{

    }
}
