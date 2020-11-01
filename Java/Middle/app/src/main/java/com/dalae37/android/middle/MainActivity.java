package com.dalae37.android.middle;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button first,third;
    AlertDialog alertDialog;
    static boolean isAgree = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!isAgree)
            Agree();

        //버튼 등록
        first = findViewById(R.id.first);
        first.setOnClickListener(this);

        third = findViewById(R.id.third);
        third.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.first :
                intent = new Intent(getApplicationContext(),FirstActivity.class);
                break;
            case R.id.third :
                intent = new Intent(getApplicationContext(),ThirdActivity.class);
                break;
            case R.id.fourth :
                intent = new Intent(getApplicationContext(),FourthActivity.class);
                break;
            case R.id.fifth :
                intent = new Intent(getApplicationContext(),FifthActivity.class);
                break;
            case R.id.sixth :
                intent = new Intent(getApplicationContext(),SixthActivity.class);
                break;
            case R.id.seventh :
                intent = new Intent(getApplicationContext(),SeventhActivity.class);
                break;
            case R.id.eighth :
                intent = new Intent(getApplicationContext(),EighthActivity.class);
                break;
            default :
                intent = null;
                break;
        }
        if(intent != null){
            startActivity(intent);
            finish();
        }
    }

    public void Agree(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("알림!");
        builder.setMessage("요약본이긴 하나 완벽하지 않으니 PPT꼭 보시길 바랍니다. 왜 이거 안나왔냐 이런 말 하지 말구 알겠죠? 아니오 누르면 앱 종료됩니다.");
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                isAgree = true;
                AppManager.getInstance().ShowToast(getApplicationContext(),"열공~");
            }
        });
        builder.setNegativeButton("싫어요", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                moveTaskToBack(true);
                finish();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
        builder.setCancelable(false);

        alertDialog = builder.create();
        alertDialog.show();
    }
}
