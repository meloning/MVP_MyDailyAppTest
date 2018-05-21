package com.example.junsu.mvp_mydailyapptest.DailyInsert;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.junsu.mvp_mydailyapptest.DailyList.DailyListView;
import com.example.junsu.mvp_mydailyapptest.R;
import com.example.junsu.mvp_mydailyapptest.Model.vo.DailyListItem;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DailyInsertView extends AppCompatActivity implements DailyInsertConstruct.View{
    EditText inputTitile,inputContent;
    Button insertBtn,cancleBtn;

    private DailyInsertPresenter dailyInsertPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily_insert_view);

        inputTitile=findViewById(R.id.editText);
        inputContent=findViewById(R.id.editText2);
        insertBtn=findViewById(R.id.button2);
        cancleBtn=findViewById(R.id.button3);

        dailyInsertPresenter = new DailyInsertPresenter();
        dailyInsertPresenter.attachView(this);
        dailyInsertPresenter.setAdapterModel(DailyListView.dailyListAdapter);
        dailyInsertPresenter.setAdapterView(DailyListView.dailyListAdapter);
        dailyInsertPresenter.setDBManager(DailyListView.myDBHelper);


        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

                DailyListItem dailyListItem =new DailyListItem();
                dailyListItem.setTitle(inputTitile.getText().toString());
                dailyListItem.setContent(inputContent.getText().toString());
                dailyListItem.setDate(format1.format(cal.getTime()));
                /*
                DailyListView.myDBHelper.Insert(dailyListItem);
                DailyListView.dailyListAdapter.addItem(dailyListItem);
                DailyListView.dailyListAdapter.notifyDataSetChanged();
                */

                dailyInsertPresenter.AddDataItem(dailyListItem);
                finish();
            }
        });

        cancleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        dailyInsertPresenter.detachView();
    }
}
