package com.wdz.mvpdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wdz.mvpdemo.R;
import com.wdz.mvpdemo.bean.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cd on 17/3/20.
 * 联系作者:413526086@QQ.COM
 */

public class ItemListAdapter extends RecyclerView.Adapter {

    private List<Item> images;

//    private List<Item> images = new ArrayList<>();
//    private IloadCallback callback;
//    private Context context;
//    private LayoutInflater layoutInflater;

//    public ItemListAdapter(List<Item> images, Context context) {
//        this.images = images;
//        this.context = context;
//        this.layoutInflater =LayoutInflater.from(context);
//    }

//    public void setCallback(IloadCallback callback) {
//        this.callback = callback;
//    }

//    public void addData(List<Item> list){
//        images.addAll(list);
//        notifyDataSetChanged();
//    }

    public void setImages(List<Item> images) {

        this.images = images;
        notifyDataSetChanged();
    }

//    @Override
//    public int getItemViewType(int position) {
//
//        if (position ==images.size()){
//            return R.layout.item_load_more;
//        }else {
//
//            return R.layout.grid_item;
//        }
//    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item,parent,false);

//        if (viewType ==R.layout.item_load_more){
//
//            return new LoadMoreVH(view);
//        }else {
            return new DebounceViewHolder(view);
//        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        DebounceViewHolder debounceViewHolder = (DebounceViewHolder) holder;
        Item image = images.get(position);
        Glide.with(holder.itemView.getContext()).load(image.imageUrl).into(debounceViewHolder.imageIv);
        debounceViewHolder.descriptionTv.setText(image.description);
    }

    @Override
    public int getItemCount() {
        return images ==null?0:images.size();
    }

    static class DebounceViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.imageIv)
        ImageView imageIv;
        @Bind(R.id.descriptionTv)
        TextView descriptionTv;
        public DebounceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    //底部加载更多item的viewholder.
    //(使用 static 关键字修饰内部类就不会持有外部类的强引用，这样不会造成内存泄露问题），一个是需要展示的 item 的，一个是加载更多的 view 的。)
    static class LoadMoreVH extends RecyclerView.ViewHolder {

        public LoadMoreVH(View itemView) {
            super(itemView);
        }
    }

    interface IloadCallback{

        void load();
    }
}
