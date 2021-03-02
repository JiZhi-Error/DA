package com.tencent.mm.plugin.recharge.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MallRechargeProduct implements Parcelable {
    public static final Parcelable.Creator<MallRechargeProduct> CREATOR = new Parcelable.Creator<MallRechargeProduct>() {
        /* class com.tencent.mm.plugin.recharge.model.MallRechargeProduct.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MallRechargeProduct[] newArray(int i2) {
            return new MallRechargeProduct[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MallRechargeProduct createFromParcel(Parcel parcel) {
            AppMethodBeat.i(67097);
            MallRechargeProduct mallRechargeProduct = new MallRechargeProduct(parcel);
            AppMethodBeat.o(67097);
            return mallRechargeProduct;
        }
    };
    public String BCZ;
    public float BDa = 0.0f;
    public float BDb = 0.0f;
    public boolean BDc;
    public int BDd;
    public int BDe;
    public final boolean BDf;
    public boolean BDg = true;
    public String appId;
    public int iFf;
    public boolean isDefault;
    public String kHR;
    public String productId;
    public String rjt;

    public MallRechargeProduct(boolean z) {
        this.BDf = z;
    }

    public final boolean isValid() {
        if (!this.BDc || this.BDd > 0) {
            return true;
        }
        return false;
    }

    public static void a(MallRechargeProduct mallRechargeProduct, MallRechargeProduct mallRechargeProduct2) {
        mallRechargeProduct2.appId = mallRechargeProduct.appId;
        mallRechargeProduct2.kHR = mallRechargeProduct.kHR;
        mallRechargeProduct2.productId = mallRechargeProduct.productId;
        mallRechargeProduct2.rjt = mallRechargeProduct.rjt;
        mallRechargeProduct2.BCZ = mallRechargeProduct.BCZ;
        mallRechargeProduct2.BDa = mallRechargeProduct.BDa;
        mallRechargeProduct2.BDb = mallRechargeProduct.BDb;
        mallRechargeProduct2.BDc = mallRechargeProduct.BDc;
        mallRechargeProduct2.BDd = mallRechargeProduct.BDd;
        mallRechargeProduct2.BDe = mallRechargeProduct.BDe;
        mallRechargeProduct2.isDefault = mallRechargeProduct.isDefault;
        mallRechargeProduct2.BDg = mallRechargeProduct.BDg;
        mallRechargeProduct2.iFf = mallRechargeProduct.iFf;
    }

    public int describeContents() {
        return 0;
    }

    public MallRechargeProduct(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(67098);
        this.kHR = parcel.readString();
        this.appId = parcel.readString();
        this.productId = parcel.readString();
        this.rjt = parcel.readString();
        this.BCZ = parcel.readString();
        this.BDa = parcel.readFloat();
        this.BDb = parcel.readFloat();
        this.BDc = parcel.readInt() == 1;
        this.BDd = parcel.readInt();
        this.BDe = parcel.readInt();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isDefault = z;
        this.BDf = parcel.readInt() != 1 ? false : z2;
        this.iFf = parcel.readInt();
        AppMethodBeat.o(67098);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4 = 1;
        AppMethodBeat.i(67099);
        parcel.writeString(this.kHR);
        parcel.writeString(this.appId);
        parcel.writeString(this.productId);
        parcel.writeString(this.rjt);
        parcel.writeString(this.BCZ);
        parcel.writeFloat(this.BDa);
        parcel.writeFloat(this.BDb);
        parcel.writeInt(this.BDc ? 1 : 0);
        parcel.writeInt(this.BDd);
        parcel.writeInt(this.BDe);
        if (this.isDefault) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        if (!this.BDf) {
            i4 = 0;
        }
        parcel.writeInt(i4);
        parcel.writeInt(this.iFf);
        AppMethodBeat.o(67099);
    }

    static {
        AppMethodBeat.i(67100);
        AppMethodBeat.o(67100);
    }
}
