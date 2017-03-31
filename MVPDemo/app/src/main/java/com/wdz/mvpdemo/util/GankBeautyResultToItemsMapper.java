package com.wdz.mvpdemo.util;

import com.wdz.mvpdemo.bean.GankBeauty;
import com.wdz.mvpdemo.bean.GankBeautyResult;
import com.wdz.mvpdemo.bean.Item;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rx.functions.Func1;

/**
 * Created by cd on 17/3/31.
 * 联系作者:413526086@QQ.COM
 */

public class GankBeautyResultToItemsMapper implements Func1<GankBeautyResult,List<Item>> {

    private static GankBeautyResultToItemsMapper INSTANCE = new GankBeautyResultToItemsMapper();

    private void GankBeautyResultToItemsMapper(){};

    public static GankBeautyResultToItemsMapper getInstance(){

        return INSTANCE;
    }

    @Override
    public List<Item> call(GankBeautyResult gankBeautyResult) {

        List<GankBeauty> gankBeauties = gankBeautyResult.beauties;
        List<Item> items = new ArrayList<>(gankBeauties.size());

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yy/MM/dd HH:mm:ss");

        for (GankBeauty gankBeauty : gankBeauties){
            Item item = new Item();

            try {
                Date date = inputFormat.parse(gankBeauty.createdAt);
                item.description = outputFormat.format(date);
            }catch (ParseException e){
                e.printStackTrace();
                item.description = "unknown date";
            }
            item.imageUrl = gankBeauty.url;
            items.add(item);
        }

        return items;
    }
}
