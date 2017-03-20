package com.wdz.mvpdemo.network.api;


import com.wdz.mvpdemo.bean.ZhuangbiImage;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cd on 17/3/15.
 * 联系作者:413526086@QQ.COM
 */

public interface ZhuangbiApi {

    @GET("search")
    Observable<List<ZhuangbiImage>> search(@Query("q") String query);
}
