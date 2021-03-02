package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Util;

public class Authen implements Parcelable {
    public static final Parcelable.Creator<Authen> CREATOR = new Parcelable.Creator<Authen>() {
        /* class com.tencent.mm.plugin.wallet_core.model.Authen.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Authen[] newArray(int i2) {
            return new Authen[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Authen createFromParcel(Parcel parcel) {
            AppMethodBeat.i(70206);
            Authen authen = new Authen(parcel);
            AppMethodBeat.o(70206);
            return authen;
        }
    };
    public String ANo;
    public PayInfo BDB = new PayInfo();
    public String HCy;
    public String HQc;
    public String HQm;
    public String HTZ;
    public int HUN = 0;
    public String HUO;
    public String HUP;
    public int HUQ;
    public String HUR;
    public String HUS;
    public String HUT;
    public String HUU;
    public String HUV;
    public String HUW;
    public String HUX;
    public String HUY;
    public String HUZ;
    public int HUj;
    public String HUk;
    public String HUo;
    public String HVa;
    public String HVb;
    public String HVc;
    public String HVd;
    public int HVe;
    public String HVf;
    public int cSx;
    public String country;
    public String dDj;
    public String fuD;
    public String fuJ;
    public String fuK;
    public String iUO;
    public String ksV;
    public String token;
    public String xxN;
    public String ynV;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(70207);
        parcel.writeInt(this.cSx);
        parcel.writeString(Util.nullAs(this.HUO, ""));
        parcel.writeString(Util.nullAs(this.dDj, ""));
        parcel.writeString(Util.nullAs(this.ANo, ""));
        parcel.writeString(Util.nullAs(this.HTZ, ""));
        parcel.writeString(Util.nullAs(this.HUP, ""));
        parcel.writeInt(this.HUQ);
        parcel.writeString(Util.nullAs(this.HQc, ""));
        parcel.writeString(Util.nullAs(this.HUR, ""));
        parcel.writeString(Util.nullAs(this.HUS, ""));
        parcel.writeString(Util.nullAs(this.HUT, ""));
        parcel.writeString(Util.nullAs(this.token, ""));
        parcel.writeString(Util.nullAs(this.HUV, ""));
        parcel.writeString(Util.nullAs(this.HUW, ""));
        parcel.writeString(Util.nullAs(this.country, ""));
        parcel.writeString(Util.nullAs(this.fuJ, ""));
        parcel.writeString(Util.nullAs(this.fuK, ""));
        parcel.writeString(Util.nullAs(this.iUO, ""));
        parcel.writeString(Util.nullAs(this.ynV, ""));
        parcel.writeString(Util.nullAs(this.ksV, ""));
        parcel.writeString(Util.nullAs(this.fuD, ""));
        parcel.writeString(Util.nullAs(this.HCy, ""));
        parcel.writeString(Util.nullAs(this.HUX, ""));
        parcel.writeString(Util.nullAs(this.HUY, ""));
        parcel.writeString(Util.nullAs(this.HUU, ""));
        parcel.writeString(Util.nullAs(this.HUZ, ""));
        parcel.writeString(Util.nullAs(this.HVa, ""));
        parcel.writeString(Util.nullAs(this.HVb, ""));
        parcel.writeString(Util.nullAs(this.HVc, ""));
        parcel.writeString(Util.nullAs(this.HVd, ""));
        parcel.writeInt(Util.nullAs(Integer.valueOf(this.HUj), 0));
        parcel.writeString(Util.nullAs(this.HUo, ""));
        parcel.writeString(Util.nullAs(this.HUk, ""));
        parcel.writeInt(Util.nullAs(Integer.valueOf(this.HVe), 0));
        parcel.writeString(Util.nullAs(this.HQm, ""));
        parcel.writeString(Util.nullAs(this.HVf, ""));
        AppMethodBeat.o(70207);
    }

    public Authen() {
        AppMethodBeat.i(70208);
        AppMethodBeat.o(70208);
    }

    public Authen(Parcel parcel) {
        AppMethodBeat.i(70209);
        this.cSx = parcel.readInt();
        this.HUO = parcel.readString();
        this.dDj = parcel.readString();
        this.ANo = parcel.readString();
        this.HTZ = parcel.readString();
        this.HUP = parcel.readString();
        this.HUQ = parcel.readInt();
        this.HQc = parcel.readString();
        this.HUR = parcel.readString();
        this.HUS = parcel.readString();
        this.HUT = parcel.readString();
        this.token = parcel.readString();
        this.HUV = parcel.readString();
        this.HUW = parcel.readString();
        this.country = parcel.readString();
        this.fuJ = parcel.readString();
        this.fuK = parcel.readString();
        this.iUO = parcel.readString();
        this.ynV = parcel.readString();
        this.ksV = parcel.readString();
        this.fuD = parcel.readString();
        this.HCy = parcel.readString();
        this.HUX = parcel.readString();
        this.HUY = parcel.readString();
        this.HUU = parcel.readString();
        this.HUZ = parcel.readString();
        this.HVa = parcel.readString();
        this.HVb = parcel.readString();
        this.HVc = parcel.readString();
        this.HVd = parcel.readString();
        this.HUj = parcel.readInt();
        this.HUo = parcel.readString();
        this.HUk = parcel.readString();
        this.HVe = parcel.readInt();
        this.HQm = parcel.readString();
        this.HVf = parcel.readString();
        AppMethodBeat.o(70209);
    }

    static {
        AppMethodBeat.i(70210);
        AppMethodBeat.o(70210);
    }
}
