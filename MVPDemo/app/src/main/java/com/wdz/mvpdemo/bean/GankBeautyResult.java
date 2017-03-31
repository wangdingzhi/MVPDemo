package com.wdz.mvpdemo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cd on 17/3/31.
 * 联系作者:413526086@QQ.COM
 */

public class GankBeautyResult {

    public boolean error;

    public  @SerializedName("results")
    List<GankBeauty> beauties;
}
