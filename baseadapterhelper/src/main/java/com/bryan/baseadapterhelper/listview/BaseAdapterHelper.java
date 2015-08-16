package com.bryan.baseadapterhelper.listview;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class BaseAdapterHelper
{
	private final SparseArray<View> views;
	private int mPosition;
	private View mConvertView;

	private BaseAdapterHelper(Context context, ViewGroup parent, int layoutId,
							  int position)
	{
		this.mPosition = position;
		this.views = new SparseArray<View>();
		mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
				false);
		// setTag
		mConvertView.setTag(this);
	}

	/**
	 * 拿到一个views对象
	 * 
	 * @param context
	 * @param convertView
	 * @param parent
	 * @param layoutId
	 * @param position
	 * @return
	 */
	public static BaseAdapterHelper get(Context context, View convertView,
			ViewGroup parent, int layoutId, int position)
	{
		if (convertView == null)
		{
			return new BaseAdapterHelper(context, parent, layoutId, position);
		}
		return (BaseAdapterHelper) convertView.getTag();
	}

	public View getConvertView()
	{
		return mConvertView;
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
			view = mConvertView.findViewById(viewId);
			views.put(viewId, view);
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


	public int getPosition()
	{
		return mPosition;
	}

}
