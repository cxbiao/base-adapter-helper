package com.bryan;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bryan.baseadapterhelper.recyclerview.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends Activity
{

	private RecyclerView recyclerView;
	private List<Bean> mDatas = new ArrayList<Bean>();

	private RecyclerViewAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recycler);

		initDatas();

		recyclerView= (RecyclerView) findViewById(R.id.recylcerview);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		mAdapter=new RecyclerViewAdapter(this,mDatas,R.layout.item_list);
		recyclerView.setAdapter(mAdapter);


		mAdapter.setOnItemClickLitener(new BaseQuickAdapter.OnItemClickLitener() {
			@Override
			public void onItemClick(View view, int position) {
				Toast.makeText(RecyclerActivity.this,"onItemClick"+position,Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onItemLongClick(View view, int position) {
				Toast.makeText(RecyclerActivity.this,"onItemLongClick"+position,Toast.LENGTH_SHORT).show();
				mDatas.remove(1);
				//mDatas.remove(1);
				//mDatas.remove(1);
				mAdapter.notifyItemRemoved(position);
				//mAdapter.notifyItemRangeRemoved(1,3);
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

		bean = new Bean("t", "周三早上捡到妹子一只，在食堂二楼", "10086", "20130240122");
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
