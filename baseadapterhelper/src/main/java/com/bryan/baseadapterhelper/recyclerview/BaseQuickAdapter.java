package com.bryan.baseadapterhelper.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class BaseQuickAdapter<T> extends RecyclerView.Adapter<BaseAdapterHelper>
{
	protected Context mContext;
	protected List<T> mDatas;
	protected final int mItemLayoutId;

	public BaseQuickAdapter(Context context, List<T> mDatas, int itemLayoutId)
	{
		this.mContext = context;
		this.mDatas = mDatas;
		this.mItemLayoutId = itemLayoutId;
	}



	public interface OnItemClickLitener
	{
		void onItemClick(View view, int position);
		void onItemLongClick(View view , int position);
	}

	private OnItemClickLitener mOnItemClickLitener;

	public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
	{
		this.mOnItemClickLitener = mOnItemClickLitener;
	}

	@Override
	public BaseAdapterHelper onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(mContext).inflate(mItemLayoutId, parent, false);
		BaseAdapterHelper vh = new BaseAdapterHelper(view);
		return vh;
	}

	@Override
	public void onBindViewHolder(final BaseAdapterHelper holder, int position) {
		 convert(holder,mDatas.get(position));
		if(mOnItemClickLitener!=null){
			holder.itemView.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					//获得正确的下标位置
					int pos = holder.getLayoutPosition();
					mOnItemClickLitener.onItemClick(holder.itemView, pos);
				}
			});

			holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
			{
				@Override
				public boolean onLongClick(View v)
				{
					int pos = holder.getLayoutPosition();
					mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
					return false;
				}
			});
		}

	}


	public abstract void convert(BaseAdapterHelper helper, T item);
	@Override
	public int getItemCount() {
		return (mDatas==null||mDatas.size()==0)?0:mDatas.size();
	}



}
