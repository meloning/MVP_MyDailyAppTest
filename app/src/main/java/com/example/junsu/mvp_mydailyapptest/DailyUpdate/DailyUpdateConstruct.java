package com.example.junsu.mvp_mydailyapptest.DailyUpdate;

import android.os.Bundle;

import com.example.junsu.mvp_mydailyapptest.Adapter.DailyAdapterConstruct;
import com.example.junsu.mvp_mydailyapptest.Model.DAO.DBManager;
import com.example.junsu.mvp_mydailyapptest.Model.vo.DailyListItem;

public interface DailyUpdateConstruct {
    interface View{
        void setDailyDataItemView(Bundle bundle);
    }

    interface Presenter{
        void attachView(View view);

        void setAdapterModel(DailyAdapterConstruct.Model adapterModel);

        void setAdapterView(DailyAdapterConstruct.View adapterView);

        void setDBManager(DBManager dbManager);

        void detachView();

        void UpdateDataItem(DailyListItem dailyListItem);
    }
}
