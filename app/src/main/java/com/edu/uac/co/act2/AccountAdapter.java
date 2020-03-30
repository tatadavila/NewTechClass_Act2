package com.edu.uac.co.act2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AccountAdapter extends ArrayAdapter<OwnerAccount> {

    private final Context context;
    private final ArrayList<OwnerAccount> accounts;

    public AccountAdapter(Context context, ArrayList<OwnerAccount> accounts) {
        super(context, -1, accounts);
        this.context = context;
        this.accounts = accounts;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_account, parent,false);

        TextView owner = (TextView) rowView.findViewById(R.id.tvOwner);
        TextView tower = (TextView) rowView.findViewById(R.id.tvTower);
        TextView apt = (TextView) rowView.findViewById(R.id.tvApartment);
        TextView area = (TextView) rowView.findViewById(R.id.tvArea);

        OwnerAccount oc = this.getItem(position);

        owner.setText(oc.getOwner());
        tower.setText(oc.getTower());
        apt.setText(oc.getApartment());
        area.setText(oc.getArea());

        return rowView;
    }
}
