package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavorPayInfo implements Parcelable {
    public static final Parcelable.Creator<FavorPayInfo> CREATOR = new Parcelable.Creator<FavorPayInfo>() {
        /* class com.tencent.mm.plugin.wallet_core.model.FavorPayInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FavorPayInfo[] newArray(int i2) {
            return new FavorPayInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ FavorPayInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(70275);
            FavorPayInfo favorPayInfo = new FavorPayInfo(parcel);
            AppMethodBeat.o(70275);
            return favorPayInfo;
        }
    };
    public String HXI;
    public int HXJ;
    public String HXK;
    public String HXL;
    public String HXM;
    public List<String> HXN = new LinkedList();

    public FavorPayInfo() {
        AppMethodBeat.i(70276);
        AppMethodBeat.o(70276);
    }

    public FavorPayInfo(Parcel parcel) {
        AppMethodBeat.i(70277);
        this.HXI = parcel.readString();
        this.HXJ = parcel.readInt();
        this.HXK = parcel.readString();
        this.HXL = parcel.readString();
        this.HXM = parcel.readString();
        this.HXN = parcel.createStringArrayList();
        AppMethodBeat.o(70277);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(70278);
        parcel.writeString(this.HXI);
        parcel.writeInt(this.HXJ);
        parcel.writeString(this.HXK);
        parcel.writeString(this.HXL);
        parcel.writeString(this.HXM);
        parcel.writeStringList(this.HXN);
        AppMethodBeat.o(70278);
    }

    public String toString() {
        AppMethodBeat.i(70279);
        StringBuffer stringBuffer = new StringBuffer(String.format("FavorPayInfo %s isNeedBankPay %s needBankType %s defaultFavorCompId %s changeBankcardTips %s", this.HXI, Integer.valueOf(this.HXJ), this.HXK, this.HXL, this.HXM));
        if (this.HXN != null) {
            stringBuffer.append("bind_serial_list :");
            Iterator<String> it = this.HXN.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next() + ",");
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(70279);
        return stringBuffer2;
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(70280);
        AppMethodBeat.o(70280);
    }
}
