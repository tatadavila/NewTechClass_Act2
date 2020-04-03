package com.edu.uac.co.act2;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ListView accountLV;
    MyOwnerAccounts myAccounts;
    AccountAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accountLV = findViewById(R.id.ownerAccountList);

        myAccounts = ((MyApplication) this.getApplication()).getMyAccounts();

        adapter = new AccountAdapter(this, myAccounts.accountsList);

        accountLV.setAdapter(adapter);

        Bundle incommingMessages = getIntent().getExtras();
        if (incommingMessages != null) {

            Intent i = getIntent();
            OwnerAccount oc = i.getParcelableExtra("account");

            myAccounts.getAccountsList().add(oc);

            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_toolbar, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.searchIcon).getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(this);

        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.searchIcon:
                Toast.makeText(this, "Filtro por Apartamento", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.addAccount:
                Toast.makeText(this, "Agregar Cuenta Nueva", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(i);
                break;
            case R.id.orderByTower:
                Toast.makeText(this, "Ordenar por Torre", Toast.LENGTH_SHORT).show();
                sortByTower();
                return true;
            case R.id.orderByApartment:
                Toast.makeText(this, "Ordenar por Propietario", Toast.LENGTH_SHORT).show();
                sortbyOwner();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);

        return true;
    }

    public void sortByTower() {
        Collections.sort(myAccounts.accountsList, new Comparator<OwnerAccount>() {
            @Override
            public int compare(OwnerAccount o1, OwnerAccount o2) {
                return o1.getTower().compareTo(o2.getTower());
            }
        });

        adapter.notifyDataSetChanged();
    }

    public void sortbyOwner() {
        Collections.sort(myAccounts.accountsList, new Comparator<OwnerAccount>() {
            @Override
            public int compare(OwnerAccount o1, OwnerAccount o2) {
                return o1.getOwner().compareTo(o2.getOwner());
            }
        });

        adapter.notifyDataSetChanged();
    }
}
