package com.example.junsu.mvp_mydailyapptest.DailyInsert;

import com.example.junsu.mvp_mydailyapptest.Model.DAO.DBManager;
import com.example.junsu.mvp_mydailyapptest.Adapter.DailyAdapterConstruct;
import com.example.junsu.mvp_mydailyapptest.Model.vo.DailyListItem;

public class DailyInsertPresenter implements DailyInsertConstruct.Presenter {
    private DailyInsertConstruct.View view;

    private DailyAdapterConstruct.Model adaptermodel;
    private DailyAdapterConstruct.View adapterview;

    private DBManager dbManager;

    @Override
    public void attachView(DailyInsertConstruct.View view) {
        this.view=view;
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
    public void setDBManager(DBManager dbManager) {
        this.dbManager=dbManager;
    }

    @Override
    public void detachView() {
        view=null;
    }

    @Override
    public void AddDataItem(DailyListItem dailyListItem) {
        dbManager.Insert(dailyListItem);
        adaptermodel.addDataItem(dailyListItem);
        adapterview.notifyDataUpdate();
    }
}
