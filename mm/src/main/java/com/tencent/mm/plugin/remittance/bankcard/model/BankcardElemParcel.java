package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ajr;
import com.tencent.mm.protocal.protobuf.jg;
import java.util.ArrayList;
import java.util.Iterator;

public class BankcardElemParcel implements Parcelable {
    public static final Parcelable.Creator<BankcardElemParcel> CREATOR = new Parcelable.Creator<BankcardElemParcel>() {
        /* class com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BankcardElemParcel[] newArray(int i2) {
            return new BankcardElemParcel[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BankcardElemParcel createFromParcel(Parcel parcel) {
            AppMethodBeat.i(67400);
            BankcardElemParcel bankcardElemParcel = new BankcardElemParcel(parcel);
            AppMethodBeat.o(67400);
            return bankcardElemParcel;
        }
    };
    public String CiX;
    public int CiY;
    public int CiZ;
    public String Cja;
    public String Cjb;
    public String Cjc;
    public ArrayList<EnterTimeParcel> Cjd;
    public String Cje;
    public long Cjf;
    public String dDj;
    public String ynT;

    public BankcardElemParcel() {
    }

    public BankcardElemParcel(jg jgVar) {
        AppMethodBeat.i(67401);
        this.dDj = jgVar.dDj;
        this.ynT = jgVar.ynT;
        this.CiX = jgVar.CiX;
        this.CiY = jgVar.CiY;
        this.CiZ = jgVar.CiZ;
        this.Cja = jgVar.Cja;
        this.Cjb = jgVar.Cjb;
        this.Cjc = jgVar.Cjc;
        this.Cjd = new ArrayList<>();
        Iterator<ajr> it = jgVar.KNO.iterator();
        while (it.hasNext()) {
            this.Cjd.add(new EnterTimeParcel(it.next()));
        }
        this.Cje = jgVar.KNQ;
        this.Cjf = jgVar.Cjf;
        AppMethodBeat.o(67401);
    }

    public BankcardElemParcel(Parcel parcel) {
        AppMethodBeat.i(67402);
        this.dDj = parcel.readString();
        this.ynT = parcel.readString();
        this.CiX = parcel.readString();
        this.CiY = parcel.readInt();
        this.CiZ = parcel.readInt();
        this.Cjd = new ArrayList<>();
        parcel.readTypedList(this.Cjd, EnterTimeParcel.CREATOR);
        this.Cja = parcel.readString();
        this.Cjb = parcel.readString();
        this.Cjc = parcel.readString();
        this.Cje = parcel.readString();
        this.Cjf = parcel.readLong();
        AppMethodBeat.o(67402);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(67403);
        parcel.writeString(this.dDj);
        parcel.writeString(this.ynT);
        parcel.writeString(this.CiX);
        parcel.writeInt(this.CiY);
        parcel.writeInt(this.CiZ);
        parcel.writeTypedList(this.Cjd);
        parcel.writeString(this.Cja);
        parcel.writeString(this.Cjb);
        parcel.writeString(this.Cjc);
        parcel.writeString(this.Cje);
        parcel.writeLong(this.Cjf);
        AppMethodBeat.o(67403);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(67404);
        AppMethodBeat.o(67404);
    }
}
