package com.wdz.mvpdemo.module.elementary;

import com.wdz.mvpdemo.base.BasePresenter;
import com.wdz.mvpdemo.base.BaseView;
import com.wdz.mvpdemo.bean.ZhuangbiImage;

import java.util.List;

/**
 * Created by cd on 17/3/15.
 * 联系作者:413526086@QQ.COM
 */

public interface ElementaryContract {

    interface View extends BaseView{

        void setAndroidItems(List<ZhuangbiImage> images);

        void getAndroidItemsFail();

        void showSwipLoading();

        void hideSwipLoading();

    }

    interface Presenter extends BasePresenter{

        void getAndroidSearchString(String str);
    }

    interface ModelInterface {


    }
}
