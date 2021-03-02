package com.tencent.mm.plugin.address.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RcptItem implements Parcelable {
    public static final Parcelable.Creator<RcptItem> CREATOR = new Parcelable.Creator<RcptItem>() {
        /* class com.tencent.mm.plugin.address.model.RcptItem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RcptItem[] newArray(int i2) {
            return new RcptItem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RcptItem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(20797);
            RcptItem rcptItem = new RcptItem(parcel);
            AppMethodBeat.o(20797);
            return rcptItem;
        }
    };
    public String code = "";
    public String ksV = "";
    public boolean ksW = false;
    public String name = "";

    public RcptItem() {
    }

    public RcptItem(String str, String str2, String str3) {
        this.name = str;
        this.code = str2;
        this.ksV = str3;
    }

    public int describeContents() {
        return 0;
    }

    public RcptItem(Parcel parcel) {
        AppMethodBeat.i(20798);
        this.name = parcel.readString();
        this.code = parcel.readString();
        this.ksV = parcel.readString();
        AppMethodBeat.o(20798);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(20799);
        parcel.writeString(this.name);
        parcel.writeString(this.code);
        parcel.writeString(this.ksV);
        AppMethodBeat.o(20799);
    }

    static {
        AppMethodBeat.i(20800);
        AppMethodBeat.o(20800);
    }
}
