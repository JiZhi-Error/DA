package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ekl;
import java.util.ArrayList;
import java.util.List;

public class TransferRecordParcel implements Parcelable {
    public static final Parcelable.Creator<TransferRecordParcel> CREATOR = new Parcelable.Creator<TransferRecordParcel>() {
        /* class com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TransferRecordParcel[] newArray(int i2) {
            return new TransferRecordParcel[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TransferRecordParcel createFromParcel(Parcel parcel) {
            AppMethodBeat.i(67417);
            TransferRecordParcel transferRecordParcel = new TransferRecordParcel(parcel);
            AppMethodBeat.o(67417);
            return transferRecordParcel;
        }
    };
    public String CiX;
    public String Cjt;
    public String Cju;
    public String Cjv;
    public String Cjw;
    public String dDj;
    public String ynT;

    public TransferRecordParcel() {
    }

    private TransferRecordParcel(ekl ekl) {
        this.Cjt = ekl.Cjt;
        this.Cju = ekl.Cju;
        this.CiX = ekl.CiX;
        this.ynT = ekl.ynT;
        this.dDj = ekl.dDj;
        this.Cjv = ekl.Cjv;
        this.Cjw = ekl.Cjw;
    }

    protected TransferRecordParcel(Parcel parcel) {
        AppMethodBeat.i(67418);
        this.Cjt = parcel.readString();
        this.Cju = parcel.readString();
        this.CiX = parcel.readString();
        this.ynT = parcel.readString();
        this.dDj = parcel.readString();
        this.Cjv = parcel.readString();
        this.Cjw = parcel.readString();
        AppMethodBeat.o(67418);
    }

    static {
        AppMethodBeat.i(67421);
        AppMethodBeat.o(67421);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(67419);
        parcel.writeString(this.Cjt);
        parcel.writeString(this.Cju);
        parcel.writeString(this.CiX);
        parcel.writeString(this.ynT);
        parcel.writeString(this.dDj);
        parcel.writeString(this.Cjv);
        parcel.writeString(this.Cjw);
        AppMethodBeat.o(67419);
    }

    public static ArrayList<TransferRecordParcel> go(List<ekl> list) {
        AppMethodBeat.i(67420);
        if (list == null) {
            AppMethodBeat.o(67420);
            return null;
        }
        ArrayList<TransferRecordParcel> arrayList = new ArrayList<>();
        for (ekl ekl : list) {
            arrayList.add(new TransferRecordParcel(ekl));
        }
        AppMethodBeat.o(67420);
        return arrayList;
    }
}
