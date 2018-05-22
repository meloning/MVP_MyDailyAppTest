package com.example.junsu.mvp_mydailyapptest.DailyInsert;

import com.example.junsu.mvp_mydailyapptest.Model.DAO.DBManager;
import com.example.junsu.mvp_mydailyapptest.Adapter.DailyAdapterContract;
import com.example.junsu.mvp_mydailyapptest.Model.vo.DailyListItem;

public interface DailyInsertContract {
    interface View{

    }

    interface Presenter{
        void attachView(View view);

        void setAdapterModel(DailyAdapterContract.Model adapterModel);

        void setAdapterView(DailyAdapterContract.View adapterView);

        void detachView();

        void setDBManager(DBManager dbManager);

        void AddDataItem(DailyListItem dailyListItem);
    }
}
