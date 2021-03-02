package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;

public class AppBrandSysConfigWC extends AppBrandSysConfigLU {
    public static final Parcelable.Creator<AppBrandSysConfigWC> CREATOR = new Parcelable.Creator<AppBrandSysConfigWC>() {
        /* class com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandSysConfigWC[] newArray(int i2) {
            return new AppBrandSysConfigWC[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandSysConfigWC createFromParcel(Parcel parcel) {
            AppMethodBeat.i(44845);
            AppBrandSysConfigWC appBrandSysConfigWC = new AppBrandSysConfigWC(parcel);
            AppMethodBeat.o(44845);
            return appBrandSysConfigWC;
        }
    };
    public boolean leH;
    public boolean leI;
    public boolean leJ;
    public int leK;
    public byte[] leL;
    public ICommLibReader leM;
    public int leb;
    public int lec;

    public AppBrandSysConfigWC() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBrandSysConfigWC(Parcel parcel) {
        super(parcel);
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(44846);
        this.leH = parcel.readByte() != 0;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.leI = z;
        this.leK = parcel.readInt();
        this.leJ = parcel.readInt() != 1 ? false : z2;
        this.leL = parcel.createByteArray();
        this.leM = ICommLibReader.b.h(parcel);
        this.leb = parcel.readInt();
        this.lec = parcel.readInt();
        AppMethodBeat.o(44846);
    }

    @Override // com.tencent.luggage.sdk.config.AppBrandSysConfigLU
    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4 = 1;
        AppMethodBeat.i(44847);
        super.writeToParcel(parcel, i2);
        parcel.writeByte(this.leH ? (byte) 1 : 0);
        if (this.leI) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeInt(this.leK);
        if (!this.leJ) {
            i4 = 0;
        }
        parcel.writeInt(i4);
        parcel.writeByteArray(this.leL);
        ICommLibReader.b.a(this.leM, parcel, i2);
        parcel.writeInt(this.leb);
        parcel.writeInt(this.lec);
        AppMethodBeat.o(44847);
    }

    static {
        AppMethodBeat.i(44848);
        AppMethodBeat.o(44848);
    }
}
