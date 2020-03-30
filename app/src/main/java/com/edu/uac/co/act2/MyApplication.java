package com.edu.uac.co.act2;

import android.app.Application;

public class MyApplication extends Application {

    private MyOwnerAccounts myAccounts = new MyOwnerAccounts();

    public MyOwnerAccounts getMyAccounts() {
        return myAccounts;
    }

    public void setMyAccounts(MyOwnerAccounts myAccounts) {
        this.myAccounts = myAccounts;
    }
}
