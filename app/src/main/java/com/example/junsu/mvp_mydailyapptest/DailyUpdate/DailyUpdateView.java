package com.example.junsu.mvp_mydailyapptest.DailyUpdate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.junsu.mvp_mydailyapptest.DailyList.DailyListView;
import com.example.junsu.mvp_mydailyapptest.R;
import com.example.junsu.mvp_mydailyapptest.Model.vo.DailyListItem;


public class DailyUpdateView extends AppCompatActivity implements DailyUpdateContract.View{
    EditText inputTitile,inputContent;
    Button checkBtn,cancleBtn;

    DailyListItem dailyListItem;

    private DailyUpdatePresenter dailyUpdatePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily_update_view);

        inputTitile=findViewById(R.id.updateTitle);
        inputContent=findViewById(R.id.updateContent);

        checkBtn=findViewById(R.id.checkBtn);
        cancleBtn=findViewById(R.id.cancleBtn);

        dailyUpdatePresenter=new DailyUpdatePresenter();
        dailyUpdatePresenter.attachView(this);
        dailyUpdatePresenter.setAdapterModel(DailyListView.dailyListAdapter);
        dailyUpdatePresenter.setAdapterView(DailyListView.dailyListAdapter);
        dailyUpdatePresenter.setDBManager(DailyListView.myDBHelper);

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dailyListItem.setTitle(inputTitile.getText().toString());//setDailyView로 인해 이미 객체정보가 담겨져있음.
                dailyListItem.setContent(inputContent.getText().toString());

                /*DailyListView.myDBHelper.Update(dailyListItem);
                DailyListView.dailyListAdapter.updateItem(dailyListItem);*/

                dailyUpdatePresenter.UpdateDataItem(dailyListItem);

                Intent it = new Intent(getApplicationContext(),DailyListView.class);
                it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(it);
            }
        });

        cancleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //넘어온 intent의 부가 데이터를 처리
        setDailyDataItemView(getIntent().getExtras());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        dailyUpdatePresenter.detachView();
    }

    @Override
    public void setDailyDataItemView(Bundle bundle) {
        dailyListItem=(DailyListItem) bundle.getSerializable("dailyItem");

        inputTitile.setText(dailyListItem.getTitle());
        inputContent.setText(dailyListItem.getContent());
    }
}
