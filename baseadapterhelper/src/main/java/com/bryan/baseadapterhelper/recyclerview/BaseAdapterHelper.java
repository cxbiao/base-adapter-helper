package com.bryan.baseadapterhelper.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class BaseAdapterHelper extends RecyclerView.ViewHolder
{
	private SparseArray<View> views;
	public BaseAdapterHelper(View itemView){
		super(itemView);
		this.views = new SparseArray<View>();
	}

	/**
	 * 通过控件的Id获取对于的控件，如果没有则加入views
	 * 
	 * @param viewId
	 * @return
	 */
	public <T extends View> T getView(int viewId)
	{
		View view = views.get(viewId);
		if (view == null)
		{
			view=itemView.findViewById(viewId);
			views.put(viewId,view);
		}
		return (T) view;
	}


	public TextView getTextView(int viewId){
		return getView(viewId);
	}


	public Button getButton(int viewId) {
		return getView(viewId);
	}


	public ImageView getImageView(int viewId) {
		return getView(viewId);
	}



}
