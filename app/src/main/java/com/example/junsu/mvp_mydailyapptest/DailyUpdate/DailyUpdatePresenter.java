package com.example.junsu.mvp_mydailyapptest.DailyUpdate;

import com.example.junsu.mvp_mydailyapptest.Adapter.DailyAdapterConstruct;
import com.example.junsu.mvp_mydailyapptest.Model.DAO.DBManager;
import com.example.junsu.mvp_mydailyapptest.Model.vo.DailyListItem;

public class DailyUpdatePresenter implements DailyUpdateConstruct.Presenter {
    private DailyUpdateConstruct.View view;

    private DailyAdapterConstruct.Model adaptermodel;
    private DailyAdapterConstruct.View adapterview;

    private DBManager dbManager;

    @Override
    public void attachView(DailyUpdateConstruct.View view) {
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
    public void UpdateDataItem(DailyListItem dailyListItem) {
        dbManager.Update(dailyListItem);
        adaptermodel.UpdateDataItem(dailyListItem);
        adapterview.notifyDataUpdate();
    }
}
