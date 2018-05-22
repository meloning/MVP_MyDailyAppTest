package com.example.junsu.mvp_mydailyapptest.DailyDetail;

import android.os.Bundle;

import com.example.junsu.mvp_mydailyapptest.Adapter.DailyAdapterContract;
import com.example.junsu.mvp_mydailyapptest.Model.DAO.DBManager;
import com.example.junsu.mvp_mydailyapptest.Model.vo.DailyListItem;

public interface DailyDetailContract {
    interface View{
        void setDailyDataItemView(Bundle bundle);
    }

    interface Presenter{
        void attachView(View view);

        void setAdapterModel(DailyAdapterContract.Model adapterModel);

        void setAdapterView(DailyAdapterContract.View adapterView);

        void setDBManager(DBManager dbManager);

        void detachView();

        void DeleteDataItem(DailyListItem dailyListItem);
    }
}
