package com.dalae37.android.middle;

import android.content.Context;
import android.widget.Toast;

public class AppManager{
    private static AppManager instance = new AppManager();

    private AppManager(){ }

    public static AppManager getInstance(){
        return instance;
    }

    public void ShowToast(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
