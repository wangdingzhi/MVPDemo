package com.wdz.mvpdemo.module.map;

import com.wdz.mvpdemo.base.BasePresenter;
import com.wdz.mvpdemo.base.BaseView;
import com.wdz.mvpdemo.bean.Item;

import java.util.List;

/**
 * Created by cd on 17/3/17.
 * 联系作者:413526086@QQ.COM
 */

public interface MapContract {

    interface View extends BaseView{

        void setAndroidItems(List<Item> items);

        void getAndroidItemsFail();

        void showSwipLoading();

        void hideSwipLoading();

    }

    interface Presenter extends BasePresenter{

        void getAndroidSearchString(String str);

        void getAndroidItems(int page ,int number,boolean isRefresh);
    }

    interface ModelInterface{

    }
}
