package com.example.junsu.mvp_mydailyapptest.DailyDetail;

import com.example.junsu.mvp_mydailyapptest.Adapter.DailyAdapterConstruct;
import com.example.junsu.mvp_mydailyapptest.Model.DAO.DBManager;
import com.example.junsu.mvp_mydailyapptest.Model.vo.DailyListItem;

public class DailyDetailPresenter implements DailyDetailConstruct.Presenter {
    private DailyDetailConstruct.View view;

    private DailyAdapterConstruct.Model adaptermodel;
    private DailyAdapterConstruct.View adapterview;

    private DBManager dbManager;
    @Override
    public void attachView(DailyDetailConstruct.View view) {
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
    public void DeleteDataItem(DailyListItem dailyListItem) {
        dbManager.Delete(dailyListItem.getNum());
        adaptermodel.DeleteDataItem(dailyListItem);
        adapterview.notifyDataUpdate();
    }
}
