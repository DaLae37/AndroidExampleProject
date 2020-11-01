package com.dalae37.android.middle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        AppManager.getInstance().ShowToast(this,"뒤로가기 버튼을 누르면 메인화면으로 돌아갑니다");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

    /*float curX = 0;
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
    }*/
}
