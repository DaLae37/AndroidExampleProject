package com.dalae37.android.middle;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    LinearLayout []layouts = new LinearLayout[9]; //레이아웃들
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        layouts[0] = (LinearLayout)findViewById(R.id.first_a);
        layouts[1] = (LinearLayout)findViewById(R.id.first_b);
        layouts[2] = (LinearLayout)findViewById(R.id.first_c);
        layouts[3] = (LinearLayout)findViewById(R.id.first_d);
        layouts[4] = (LinearLayout)findViewById(R.id.first_e);
        layouts[5] = (LinearLayout)findViewById(R.id.first_f);
        layouts[6] = (LinearLayout)findViewById(R.id.first_g);
        layouts[7] = (LinearLayout)findViewById(R.id.first_h);
        layouts[8] = (LinearLayout)findViewById(R.id.first_i);

        AppManager.getInstance().ShowToast(this,"뒤로가기 버튼을 누르면 메인화면으로 돌아갑니다");
        SetScrollView_Platform();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

    float curX = 0;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        layouts[index].setVisibility(View.GONE);
        switch (action){
            case MotionEvent.ACTION_DOWN :
                curX = event.getX();
                break;
            case MotionEvent.ACTION_UP :
                float diffX = curX - event.getX();
                if(diffX > 50){
                    index = (++index > layouts.length -1) ? 0 : index;
                }
                else if(diffX < -50){
                    index = (--index < 0) ? layouts.length-1 : index;
                }
                break;
            default :
                index = index;
                break;
        }
        layouts[index].setVisibility(View.VISIBLE);

        return true;
    }

    public void SetScrollView_Platform(){
        ScrollView scroll;
        ImageView img;
        BitmapDrawable bitmap;

        scroll = (ScrollView)findViewById(R.id.scrollView_Platform);
        img = (ImageView)findViewById(R.id.image_Platform);

        // 수평x수직 스크롤 바 사용 가능하도록 설정
        scroll.setHorizontalScrollBarEnabled(true);
        scroll.setVerticalScrollBarEnabled(true);

        // 이미지 가져오기
        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.platform_architecture);
        int width = bitmap.getIntrinsicWidth();
        int height = bitmap.getIntrinsicHeight();

        // 이미지뷰의 크기 설정
        img.setImageDrawable(bitmap);
        img.getLayoutParams().width = width;
        img.getLayoutParams().height = height;
    }
}
