package com.example.junsu.mvp_mydailyapptest.DailyInsert;

import com.example.junsu.mvp_mydailyapptest.Model.DAO.DBManager;
import com.example.junsu.mvp_mydailyapptest.Adapter.DailyAdapterContract;
import com.example.junsu.mvp_mydailyapptest.Model.vo.DailyListItem;

public class DailyInsertPresenter implements DailyInsertContract.Presenter {
    private DailyInsertContract.View view;

    private DailyAdapterContract.Model adaptermodel;
    private DailyAdapterContract.View adapterview;

    private DBManager dbManager;

    @Override
    public void attachView(DailyInsertContract.View view) {
        this.view=view;
    }

    @Override
    public void setAdapterModel(DailyAdapterContract.Model adapterModel) {
        this.adaptermodel=adapterModel;
    }

    @Override
    public void setAdapterView(DailyAdapterContract.View adapterView) {
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
