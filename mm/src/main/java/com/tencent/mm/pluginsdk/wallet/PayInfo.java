package com.tencent.mm.pluginsdk.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PayInfo implements Parcelable {
    public static final Parcelable.Creator<PayInfo> CREATOR = new Parcelable.Creator<PayInfo>() {
        /* class com.tencent.mm.pluginsdk.wallet.PayInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PayInfo[] newArray(int i2) {
            return new PayInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PayInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(116318);
            PayInfo payInfo = new PayInfo(parcel);
            AppMethodBeat.o(116318);
            return payInfo;
        }
    };
    public int CpF = 0;
    public String Cpg;
    public boolean HZb;
    public int Ijy = 0;
    public int Ijz = 0;
    public String IqM;
    public double KxA = 0.0d;
    public String KxB = "";
    public int Kxr = 0;
    public boolean Kxs = true;
    public String Kxt;
    public int Kxu;
    public long Kxv = 0;
    public int Kxw = -1;
    public String Kxx;
    public String Kxy;
    public int Kxz = 1;
    public String appId;
    public boolean bex;
    public int channel;
    public boolean crp = false;
    public String dDL;
    public int dNP;
    public String dNR;
    public String dNS;
    public String dQk;
    public String dUV = "";
    public int dVv = 0;
    public int dVw = -1;
    public String errMsg;
    public Bundle iqp;
    public String pSm;
    public String partnerId;
    public String productId;
    public String remark;
    public String uuid;
    public String wFE;

    public PayInfo() {
    }

    public PayInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(116319);
        this.dVv = parcel.readInt();
        this.Kxr = parcel.readInt();
        this.dDL = parcel.readString();
        this.uuid = parcel.readString();
        this.appId = parcel.readString();
        this.IqM = parcel.readString();
        this.partnerId = parcel.readString();
        this.dQk = parcel.readString();
        this.productId = parcel.readString();
        this.errMsg = parcel.readString();
        this.channel = parcel.readInt();
        this.dVw = parcel.readInt();
        this.crp = parcel.readInt() == 1;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.Kxs = z;
        this.iqp = parcel.readBundle();
        this.Ijy = parcel.readInt();
        this.dNR = parcel.readString();
        this.dNS = parcel.readString();
        this.dNP = parcel.readInt();
        this.Kxv = parcel.readLong();
        this.dUV = parcel.readString();
        this.Kxx = parcel.readString();
        this.Kxy = parcel.readString();
        this.Kxz = parcel.readInt();
        this.pSm = parcel.readString();
        this.remark = parcel.readString();
        this.CpF = parcel.readInt();
        this.KxA = parcel.readDouble();
        this.KxB = parcel.readString();
        if (this.KxB == null) {
            this.KxB = "";
        }
        this.bex = parcel.readInt() == 1;
        this.Cpg = parcel.readString();
        this.wFE = parcel.readString();
        this.HZb = parcel.readInt() != 1 ? false : z2;
        AppMethodBeat.o(116319);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4 = 1;
        AppMethodBeat.i(116320);
        parcel.writeInt(this.dVv);
        parcel.writeInt(this.Kxr);
        parcel.writeString(this.dDL);
        parcel.writeString(this.uuid);
        parcel.writeString(this.appId);
        parcel.writeString(this.IqM);
        parcel.writeString(this.partnerId);
        parcel.writeString(this.dQk);
        parcel.writeString(this.productId);
        parcel.writeString(this.errMsg);
        parcel.writeInt(this.channel);
        parcel.writeInt(this.dVw);
        parcel.writeInt(this.crp ? 1 : 0);
        if (this.Kxs) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeBundle(this.iqp);
        parcel.writeInt(this.Ijy);
        parcel.writeString(this.dNR);
        parcel.writeString(this.dNS);
        parcel.writeInt(this.dNP);
        parcel.writeLong(this.Kxv);
        parcel.writeString(this.dUV);
        parcel.writeString(this.Kxx);
        parcel.writeString(this.Kxy);
        parcel.writeInt(this.Kxz);
        parcel.writeString(this.pSm);
        parcel.writeString(this.remark);
        parcel.writeInt(this.CpF);
        parcel.writeDouble(this.KxA);
        parcel.writeString(this.KxB);
        parcel.writeInt(this.bex ? 1 : 0);
        parcel.writeString(this.Cpg);
        parcel.writeString(this.wFE);
        if (!this.HZb) {
            i4 = 0;
        }
        parcel.writeInt(i4);
        AppMethodBeat.o(116320);
    }

    static {
        AppMethodBeat.i(116322);
        AppMethodBeat.o(116322);
    }

    public String toString() {
        AppMethodBeat.i(116321);
        String format = String.format("sense : %d, reqKey : %s, uuid : %s, appId : %s, appSource : %s, partnerId : %s, paySign : %s, productId : %s, soterAuth: %s", Integer.valueOf(this.dVv), this.dDL, this.uuid, this.appId, this.IqM, this.partnerId, this.dQk, this.productId, this.dUV);
        AppMethodBeat.o(116321);
        return format;
    }
}
