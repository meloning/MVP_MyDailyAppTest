package com.example.junsu.mvp_mydailyapptest.DailyList;


import com.example.junsu.mvp_mydailyapptest.Model.DAO.DBManager;
import com.example.junsu.mvp_mydailyapptest.Adapter.DailyAdapterContract;
import com.example.junsu.mvp_mydailyapptest.Model.vo.DailyListItem;

public interface DailyListContract {
    interface View{
        //void dialogShow(AlertDialog dialog);

        //void notifyDataUpdate();
    }

    interface Presenter{
        void attachView(View view);

        void setAdapterModel(DailyAdapterContract.Model adapterModel);

        void setAdapterView(DailyAdapterContract.View adapterView);

        void detachView();

        void LoadAllSelect();

        void setDBManager(DBManager dbManager);

        DailyListItem getItem(int position);

        void clear();
    }
}
