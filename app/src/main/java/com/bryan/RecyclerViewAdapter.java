package com.bryan;

import android.content.Context;

import com.bryan.baseadapterhelper.recyclerview.BaseAdapterHelper;
import com.bryan.baseadapterhelper.recyclerview.BaseQuickAdapter;

import java.util.List;

/**
 * Created by bryan on 2015/8/16.
 */
public class RecyclerViewAdapter extends BaseQuickAdapter<Bean>{

    public RecyclerViewAdapter(Context context, List<Bean> mDatas, int itemLayoutId) {
        super(context, mDatas, itemLayoutId);
    }

    @Override
    public void convert(BaseAdapterHelper helper, Bean item) {
        helper.getTextView(R.id.tv_title).setText(item.getTitle()+"0k");
        helper.getTextView(R.id.tv_describe).setText(item.getDesc());
        helper.getTextView(R.id.tv_phone).setText(item.getPhone());
        helper.getTextView(R.id.tv_time).setText(item.getTime());


    }
}
