package com.edu.uac.co.act2;

import android.os.Parcel;
import android.os.Parcelable;

public class OwnerAccount implements Parcelable{
    private String owner;
    private String tower;
    private String apartment;
    private String area;

    public OwnerAccount(String owner, String tower, String apartment, String area) {
        this.owner = owner;
        this.tower = tower;
        this.apartment = apartment;
        this.area = area;
    }

    protected OwnerAccount(Parcel in) {

        owner = in.readString();
        tower = in.readString();
        apartment = in.readString();
        area = in.readString();
    }

    public static final Parcelable.Creator<OwnerAccount> CREATOR
            = new Parcelable.Creator<OwnerAccount>() {
        public OwnerAccount createFromParcel(Parcel in) {
            return new OwnerAccount(in);
        }

        public OwnerAccount[] newArray(int size) {
            return new OwnerAccount[size];
        }
    };

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTower() {
        return tower;
    }

    public void setTower(String tower) {
        this.tower = tower;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(owner);
        dest.writeString(tower);
        dest.writeString(apartment);
        dest.writeString(area);
    }
}
