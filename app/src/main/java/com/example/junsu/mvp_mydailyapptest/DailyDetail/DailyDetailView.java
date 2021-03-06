package com.example.junsu.mvp_mydailyapptest.DailyDetail;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.junsu.mvp_mydailyapptest.DailyList.DailyListView;
import com.example.junsu.mvp_mydailyapptest.R;
import com.example.junsu.mvp_mydailyapptest.DailyUpdate.DailyUpdateView;
import com.example.junsu.mvp_mydailyapptest.Model.vo.DailyListItem;

public class DailyDetailView extends AppCompatActivity implements DailyDetailContract.View{
    TextView detail_title,detail_content,detail_date;
    Button updateBtn,deleteBtn;
    DailyListItem dailyListItem;

    private DailyDetailPresenter dailyDetailPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily_detail_view);

        detail_title=findViewById(R.id.detailTitle);
        detail_content=findViewById(R.id.detailContent);
        detail_date=findViewById(R.id.detailDate);

        updateBtn=findViewById(R.id.updateBtn);
        deleteBtn=findViewById(R.id.deleteBtn);

        dailyDetailPresenter=new DailyDetailPresenter();
        dailyDetailPresenter.attachView(this);
        dailyDetailPresenter.setAdapterModel(DailyListView.dailyListAdapter);
        dailyDetailPresenter.setAdapterView(DailyListView.dailyListAdapter);
        dailyDetailPresenter.setDBManager(DailyListView.myDBHelper);


        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),DailyUpdateView.class);
                it.putExtras(getIntent().getExtras());//DailyListItem 객체 Bundle 부가데이터로 넘기기
                startActivity(it);
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //getApplicationContext() AlertDialog Constructor에 넘길시
                //android.view.WindowManager$BadTokenException 오류발생
                //따라서, Class명.this로 context객체로 넘기기!!
                AlertDialog.Builder builder = new AlertDialog.Builder(DailyDetailView.this);
                builder.setTitle("삭제");
                builder.setMessage("정말로 삭제하시겠습니까?");
                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /*DailyListView.myDBHelper.Delete(dailyListItem.getNum());//setDailyView()를 통해 객체 할당받음.
                        DailyListView.dailyListAdapter.deleteItem(dailyListItem);*/
                        dailyDetailPresenter.DeleteDataItem(dailyListItem);
                        finish();
                    }
                });
                builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                // 다이얼로그 생성
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        //넘어온 intent의 부가 데이터를 처리
        setDailyDataItemView(getIntent().getExtras());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        dailyDetailPresenter.detachView();
    }

    @Override
    public void setDailyDataItemView(Bundle bundle){
        dailyListItem=(DailyListItem) bundle.getSerializable("dailyItem");

        detail_title.setText(dailyListItem.getTitle());
        detail_content.setText(dailyListItem.getContent());
        detail_date.setText(dailyListItem.getDate());
    }
}
