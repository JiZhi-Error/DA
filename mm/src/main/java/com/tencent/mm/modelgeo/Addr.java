package com.tencent.mm.modelgeo;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class Addr implements Parcelable {
    public static final Parcelable.Creator<Addr> CREATOR = new Parcelable.Creator<Addr>() {
        /* class com.tencent.mm.modelgeo.Addr.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Addr[] newArray(int i2) {
            return new Addr[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Addr createFromParcel(Parcel parcel) {
            AppMethodBeat.i(150455);
            Addr addr = new Addr();
            addr.iUO = parcel.readString();
            addr.country = parcel.readString();
            addr.iUP = parcel.readString();
            addr.iUQ = parcel.readString();
            addr.iUR = parcel.readString();
            addr.iUS = parcel.readString();
            addr.iUT = parcel.readString();
            addr.iUU = parcel.readString();
            addr.iUV = parcel.readString();
            addr.iUW = parcel.readString();
            addr.iUX = parcel.readString();
            addr.iUY = parcel.readFloat();
            addr.iUZ = parcel.readFloat();
            AppMethodBeat.o(150455);
            return addr;
        }
    };
    public String country;
    public String iUO;
    public String iUP;
    public String iUQ;
    public String iUR;
    public String iUS;
    public String iUT;
    public String iUU;
    public String iUV;
    public String iUW;
    public String iUX;
    public float iUY;
    public float iUZ;
    public String request_id;
    public Object tag = "";

    public String toString() {
        AppMethodBeat.i(150456);
        StringBuilder sb = new StringBuilder();
        sb.append("address='" + this.iUO + '\'');
        sb.append(", country='" + this.country + '\'');
        sb.append(", administrative_area_level_1='" + this.iUP + '\'');
        sb.append(", locality='" + this.iUQ + '\'');
        sb.append(", locality_shi='" + this.iUR + '\'');
        sb.append(", sublocality='" + this.iUS + '\'');
        sb.append(", neighborhood='" + this.iUT + '\'');
        sb.append(", route='" + this.iUU + '\'');
        sb.append(", streetNum='" + this.iUV + '\'');
        sb.append(", roughAddr='" + this.iUW + '\'');
        sb.append(", poi_name='" + this.iUX + '\'');
        sb.append(", lat=" + this.iUY);
        sb.append(", lng=" + this.iUZ);
        sb.append(", tag=" + this.tag);
        String sb2 = sb.toString();
        AppMethodBeat.o(150456);
        return sb2;
    }

    public final String bbW() {
        AppMethodBeat.i(150457);
        StringBuilder sb = new StringBuilder();
        if (!Util.isNullOrNil(this.iUQ)) {
            sb.append(this.iUQ);
        } else if (!Util.isNullOrNil(this.iUR)) {
            sb.append(this.iUR);
        } else {
            Log.e("MicroMsg.Addr", "wtf!!! locality & locality_shi all invalid!!!");
        }
        sb.append(Util.nullAs(this.iUS, "")).append(Util.nullAs(this.iUT, "")).append(Util.nullAs(this.iUU, "")).append(Util.nullAs(this.iUV, ""));
        Log.d("MicroMsg.Addr", "little addr res: [%s].", sb);
        String sb2 = sb.toString();
        AppMethodBeat.o(150457);
        return sb2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(150458);
        parcel.writeString(Util.nullAs(this.iUO, ""));
        parcel.writeString(Util.nullAs(this.country, ""));
        parcel.writeString(Util.nullAs(this.iUP, ""));
        parcel.writeString(Util.nullAs(this.iUQ, ""));
        parcel.writeString(Util.nullAs(this.iUR, ""));
        parcel.writeString(Util.nullAs(this.iUS, ""));
        parcel.writeString(Util.nullAs(this.iUT, ""));
        parcel.writeString(Util.nullAs(this.iUU, ""));
        parcel.writeString(Util.nullAs(this.iUV, ""));
        parcel.writeString(Util.nullAs(this.iUW, ""));
        parcel.writeString(Util.nullAs(this.iUX, ""));
        parcel.writeFloat(this.iUY);
        parcel.writeFloat(this.iUZ);
        AppMethodBeat.o(150458);
    }

    static {
        AppMethodBeat.i(150459);
        AppMethodBeat.o(150459);
    }
}
