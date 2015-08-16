package com.bryan;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.bryan.baseadapterhelper.listview.BaseAdapterHelper;
import com.bryan.baseadapterhelper.listview.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity
{

	private ListView mListView;
	private List<Bean> mDatas = new ArrayList<Bean>();

	private BaseQuickAdapter<Bean> mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initDatas();

		mListView = (ListView) findViewById(R.id.id_lv_main);

		// 设置适配器
		mListView.setAdapter(mAdapter = new BaseQuickAdapter<Bean>(
				getApplicationContext(), mDatas, R.layout.item_list)
		{
			@Override
			public void convert(BaseAdapterHelper helper, Bean item)
			{
				helper.getTextView(R.id.tv_title).setText(item.getTitle());
				helper.getTextView(R.id.tv_describe).setText(item.getDesc());
				helper.getTextView(R.id.tv_phone).setText(item.getPhone());
				helper.getTextView(R.id.tv_time).setText(item.getTime());

//				helper.getView(R.id.tv_title).setOnClickListener(l)
			}

		});

	}

	private void initDatas()
	{
		Bean bean = null;
		bean = new Bean("美女一只", "周三早上捡到妹子一只，在食堂二楼", "10086", "20130240122");
		mDatas.add(bean);
		bean = new Bean("美女一捆", "周三早上捡到妹子一捆，在食堂三楼", "10086", "20130240122");
		mDatas.add(bean);
		bean = new Bean("比卡丘一个", "周三早上捡到比卡丘一个，在食堂一楼", "10086", "20130240122");
		mDatas.add(bean);
		bean = new Bean("汉子一火车", "周三早上捡到xxxxxxxxxx，在xxx", "10086",
				"20130240122");
		mDatas.add(bean);

		bean = new Bean("1", "周三早上捡到妹子一只，在食堂二楼", "10086", "20130240122");
		mDatas.add(bean);
		bean = new Bean("2", "周三早上捡到妹子一捆，在食堂三楼", "10086", "20130240122");
		mDatas.add(bean);
		bean = new Bean("3", "周三早上捡到比卡丘一个，在食堂一楼", "10086", "20130240122");
		mDatas.add(bean);
		bean = new Bean("4", "周三早上捡到xxxxxxxxxx，在xxx", "10086",
				"20130240122");
		mDatas.add(bean);
	}

}
