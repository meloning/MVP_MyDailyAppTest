package com.example.junsu.mvp_mydailyapptest.DailyInsert;

import com.example.junsu.mvp_mydailyapptest.Model.DAO.DBManager;
import com.example.junsu.mvp_mydailyapptest.Adapter.DailyAdapterConstruct;
import com.example.junsu.mvp_mydailyapptest.Model.vo.DailyListItem;

public interface DailyInsertConstruct {
    interface View{

    }

    interface Presenter{
        void attachView(View view);

        void setAdapterModel(DailyAdapterConstruct.Model adapterModel);

        void setAdapterView(DailyAdapterConstruct.View adapterView);

        void detachView();

        void setDBManager(DBManager dbManager);

        void AddDataItem(DailyListItem dailyListItem);
    }
}
