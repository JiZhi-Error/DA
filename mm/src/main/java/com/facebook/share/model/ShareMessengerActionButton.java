package com.facebook.share.model;

import android.os.Parcel;

public abstract class ShareMessengerActionButton implements ShareModel {
    private final String title;

    protected ShareMessengerActionButton(Builder builder) {
        this.title = builder.title;
    }

    ShareMessengerActionButton(Parcel parcel) {
        this.title = parcel.readString();
    }

    public String getTitle() {
        return this.title;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.title);
    }

    public static abstract class Builder<M extends ShareMessengerActionButton, B extends Builder> implements ShareModelBuilder<M, B> {
        private String title;

        public B setTitle(String str) {
            this.title = str;
            return this;
        }

        public B readFrom(M m) {
            return m == null ? this : setTitle(m.getTitle());
        }
    }
}