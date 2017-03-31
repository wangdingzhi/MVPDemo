package com.wdz.mvpdemo.network.api;

import com.wdz.mvpdemo.bean.GankBeautyResult;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by cd on 17/3/31.
 * 联系作者:413526086@QQ.COM
 */

public interface GankApi {

    @GET("data/福利/{number}/{page}")
    Observable<GankBeautyResult> getBeauties(@Path("number") int number,@Path("page") int pageNo);
}
