package com.example.junsu.mvp_mydailyapptest.Adapter;


import com.example.junsu.mvp_mydailyapptest.Model.vo.DailyListItem;

public interface DailyAdapterConstruct {
    interface View{
        void notifyDataUpdate();
    }

    interface Model{
        DailyListItem getItem(int position);

        void addDataItem(DailyListItem dailyListItem);

        void UpdateDataItem(DailyListItem dailyListItem);

        void DeleteDataItem(DailyListItem dailyListItem);

        void clearDataItem();
    }
}
