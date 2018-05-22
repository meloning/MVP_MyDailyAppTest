package com.example.junsu.mvp_mydailyapptest.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.junsu.mvp_mydailyapptest.R;
import com.example.junsu.mvp_mydailyapptest.Model.vo.DailyListItem;

import java.util.ArrayList;

public class DailyListAdapter extends BaseAdapter implements DailyAdapterContract.Model, DailyAdapterContract.View{
    private ArrayList<DailyListItem> dailyListItems;

    public DailyListAdapter(){
        dailyListItems = new ArrayList<DailyListItem>();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DailyListItem dailyListItem = dailyListItems.get(position);
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dailylistitem, parent, false);
        }

        TextView title = convertView.findViewById(R.id.title);
        TextView date = convertView.findViewById(R.id.date);

        title.setText(dailyListItem.getTitle());
        date.setText(dailyListItem.getDate());

        return convertView;
    }

    public void addItem(DailyListItem dailyListItem){
        dailyListItems.add(dailyListItem);
    }

    @Override
    public void UpdateDataItem(DailyListItem dailyListItem){
        DailyListItem temp;
        for(int i=0;i<getCount();i++){
            temp =dailyListItems.get(i);
            Log.d("temp",temp.toString());
            Log.d("updateDailyListItem",dailyListItem.toString());
            if(temp.getNum().equals(dailyListItem.getNum())){
                dailyListItems.remove(i);
                dailyListItems.add(i,dailyListItem);
                //notifyDataSetChanged();
            }
        }
    }

    /*public void deleteItem(DailyListItem dailyListItem){

    }*/

    @Override
    public int getCount() {
        return dailyListItems.size();
    }

    @Override
    public DailyListItem getItem(int position) {
        return dailyListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void notifyDataUpdate() {
        notifyDataSetChanged();
    }

    @Override
    public void addDataItem(DailyListItem dailyListItem) {
        dailyListItems.add(0,dailyListItem);
    }

    @Override
    public void DeleteDataItem(DailyListItem dailyListItem) {
        Log.d("checkObject",dailyListItem.toString());
        Log.d("checkNum",dailyListItem.getNum());
        DailyListItem temp;
        for(int i=0;i<getCount();i++){
            temp =dailyListItems.get(i);
            //Log.d("temp",temp.toString());
            if(dailyListItem.getNum().equals(temp.getNum())){
                dailyListItems.remove(i);
                //notifyDataSetChanged();
            }
        }
    }

    @Override
    public void clearDataItem() {
        dailyListItems.clear();
    }
}
