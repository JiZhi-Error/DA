package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ajr;

public class EnterTimeParcel implements Parcelable {
    public static final Parcelable.Creator<EnterTimeParcel> CREATOR = new Parcelable.Creator<EnterTimeParcel>() {
        /* class com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ EnterTimeParcel[] newArray(int i2) {
            return new EnterTimeParcel[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ EnterTimeParcel createFromParcel(Parcel parcel) {
            AppMethodBeat.i(67405);
            EnterTimeParcel enterTimeParcel = new EnterTimeParcel(parcel);
            AppMethodBeat.o(67405);
            return enterTimeParcel;
        }
    };
    public int Cjg;
    public String Cjh;
    public String Cji;
    public int Cjj;
    public String ixw;

    public EnterTimeParcel() {
    }

    public EnterTimeParcel(ajr ajr) {
        this.Cjg = ajr.Cjg;
        this.Cjh = ajr.Cjh;
        this.Cji = ajr.Cji;
        this.Cjj = ajr.Cjj;
        this.ixw = ajr.ixw;
    }

    public EnterTimeParcel(Parcel parcel) {
        AppMethodBeat.i(67406);
        this.Cjg = parcel.readInt();
        this.Cjh = parcel.readString();
        this.Cji = parcel.readString();
        this.Cjj = parcel.readInt();
        this.ixw = parcel.readString();
        AppMethodBeat.o(67406);
    }

    static {
        AppMethodBeat.i(67408);
        AppMethodBeat.o(67408);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(67407);
        parcel.writeInt(this.Cjg);
        parcel.writeString(this.Cjh);
        parcel.writeString(this.Cji);
        parcel.writeInt(this.Cjj);
        parcel.writeString(this.ixw);
        AppMethodBeat.o(67407);
    }
}
