package com.example.junsu.mvp_mydailyapptest.DailyList;



import android.util.Log;

import com.example.junsu.mvp_mydailyapptest.Listener.OnItemClickListener;
import com.example.junsu.mvp_mydailyapptest.Model.DAO.DBManager;
import com.example.junsu.mvp_mydailyapptest.Adapter.DailyAdapterConstruct;
import com.example.junsu.mvp_mydailyapptest.Model.vo.DailyListItem;

import java.util.List;

public class DailyListPresenter implements DailyListConstruct.Presenter, OnItemClickListener {
    private DailyListConstruct.View view;

    private DailyAdapterConstruct.Model adaptermodel;
    private DailyAdapterConstruct.View adapterview;

    private DBManager dbManager;

    public DailyListPresenter(){

    }

    public DailyListPresenter(DailyListConstruct.View view){
        this.view=view;
    }

    @Override
    public void attachView(DailyListConstruct.View view) {
        this.view = view;
    }

    @Override
    public void setAdapterModel(DailyAdapterConstruct.Model adapterModel) {
        this.adaptermodel=adapterModel;
    }

    @Override
    public void setAdapterView(DailyAdapterConstruct.View adapterView) {
        this.adapterview=adapterView;
    }

    @Override
    public void detachView() {
        view=null;
    }

    @Override
    public void setDBManager(DBManager dbManager) {
        this.dbManager=dbManager;
    }

    @Override
    public void LoadAllSelect() {
        List<DailyListItem> dailyListItems = dbManager.getAllSelect();
        for(DailyListItem dailyListItem:dailyListItems){
            adaptermodel.addDataItem(dailyListItem);
        }
        adapterview.notifyDataUpdate();
    }
    @Override
    public DailyListItem getItem(int position){
        return adaptermodel.getItem(position);
    }

    @Override
    public void clear() {
        adaptermodel.clearDataItem();
    }

    @Override
    public void onItemClick(int position) {
        Log.d("Clickposition",String.valueOf(position));
        DailyListItem dailyListItem=getItem(position);
        Log.d("ClickDailyListItem",dailyListItem.toString());
        dbManager.Delete(dailyListItem.getNum());
        adaptermodel.DeleteDataItem(dailyListItem);
        adapterview.notifyDataUpdate();
    }
}
