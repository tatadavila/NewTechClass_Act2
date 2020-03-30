package com.edu.uac.co.act2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView accountLV;
    MyOwnerAccounts myAccounts;
    AccountAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accountLV = findViewById(R.id.ownerAccountList);

        myAccounts = ((MyApplication) this.getApplication()).getMyAccounts();

        adapter = new AccountAdapter(this, myAccounts.myAccountsList);

        accountLV.setAdapter(adapter);

        /*Bundle incommingMessages = getIntent().getExtras();
        if(incommingMessages != null){

            Intent i = getIntent();
            OwnerAccount oc = i.getParcelableExtra("account");

            myAccounts.getAccountsList().add(oc);

            adapter.notifyDataSetChanged();

        }*/

    }
}
