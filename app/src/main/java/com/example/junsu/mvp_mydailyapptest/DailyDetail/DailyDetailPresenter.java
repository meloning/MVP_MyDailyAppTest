package com.example.junsu.mvp_mydailyapptest.DailyDetail;

import com.example.junsu.mvp_mydailyapptest.Adapter.DailyAdapterContract;
import com.example.junsu.mvp_mydailyapptest.Model.DAO.DBManager;
import com.example.junsu.mvp_mydailyapptest.Model.vo.DailyListItem;

public class DailyDetailPresenter implements DailyDetailContract.Presenter {
    private DailyDetailContract.View view;

    private DailyAdapterContract.Model adaptermodel;
    private DailyAdapterContract.View adapterview;

    private DBManager dbManager;
    @Override
    public void attachView(DailyDetailContract.View view) {
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
    public void DeleteDataItem(DailyListItem dailyListItem) {
        dbManager.Delete(dailyListItem.getNum());
        adaptermodel.DeleteDataItem(dailyListItem);
        adapterview.notifyDataUpdate();
    }
}
