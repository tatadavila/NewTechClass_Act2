package com.edu.uac.co.act2;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

public class AccountAdapter extends ArrayAdapter<OwnerAccount> {

    public ArrayList<OwnerAccount> accounts, filteredAccounts, suggestions;
    MyApplication myApp;
    private Context context;

    public AccountAdapter(Context context, ArrayList<OwnerAccount> accounts) {
        super(context, -1, accounts);
        this.context = context;
        this.accounts = accounts;
        this.filteredAccounts = accounts;
        this.suggestions = new ArrayList<OwnerAccount>(accounts);
        this.myApp = (MyApplication) context.getApplicationContext();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_account, parent, false);

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

    @NonNull
    @Override
    public Filter getFilter() {
        return ApartmentFilter;
    }

    Filter ApartmentFilter = new Filter() {

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            OwnerAccount account = (OwnerAccount) resultValue;
            return account.getApartment();
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults filterResults = new FilterResults();
            if (constraint == null || constraint.length() == 0) {
                filterResults.count = myApp.getMyAccounts().getAccountsList().size();
                filterResults.values = myApp.getMyAccounts().getAccountsList();
            } else if (constraint != null) {
                suggestions.clear();
                for (OwnerAccount owacc : filteredAccounts) {
                    if (owacc.getApartment().startsWith(constraint.toString())) {
                        suggestions.add(owacc);
                    }
                }

                filterResults.values = suggestions;
                filterResults.count = suggestions.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            ArrayList<OwnerAccount> al =  (ArrayList<OwnerAccount> )results.values ;
            if (results.values != null && results.count > 0) {
                clear();
                for (OwnerAccount oc : al) {
                    add(oc);
                    notifyDataSetChanged();
                }
            }
            else{
                clear();
                notifyDataSetChanged();
            }
        }
    };

}
