package com.edu.uac.co.act2;

import java.util.ArrayList;

public class MyOwnerAccounts {

    ArrayList<OwnerAccount> accountsList;

    public MyOwnerAccounts(ArrayList<OwnerAccount> accountsList) {
        this.accountsList = accountsList;
    }

    public MyOwnerAccounts() {
        String[] startingOwners = {"Ada Shelby", "Bobby Cruz", "Catherine Z Jones" };
        String[] startingTowers = {"66", "77", "23"};
        String[] startingApartments = {"13", "10", "7"};
        String[] startingAreas = {"266.6", "127.7", "76.7"};
        this.accountsList = new ArrayList<>();

        for (int i=0; i<startingOwners.length; i++) {
            OwnerAccount oc = new OwnerAccount(startingOwners[i], startingTowers[i], startingApartments[i], startingAreas[i]);
             accountsList.add(oc);
        }
    }

    public ArrayList<OwnerAccount> getAccountsList() {
        return accountsList;
    }

    public void setAccountsList(ArrayList<OwnerAccount> accountsList) {
        this.accountsList = accountsList;
    }
}
