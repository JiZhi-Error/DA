package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.a.a;
import org.json.JSONObject;

public class AppBrandInitConfig implements Parcelable {
    public static final Parcelable.Creator<AppBrandInitConfig> CREATOR = new Parcelable.Creator<AppBrandInitConfig>() {
        /* class com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandInitConfig[] newArray(int i2) {
            return new AppBrandInitConfig[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandInitConfig createFromParcel(Parcel parcel) {
            AppMethodBeat.i(134782);
            AppBrandInitConfig appBrandInitConfig = new AppBrandInitConfig(parcel);
            AppMethodBeat.o(134782);
            return appBrandInitConfig;
        }
    };
    public String appId;
    public String brandName;
    public String cBG;
    public int eix;
    public String iconUrl;
    public String kHw;
    public String ldJ;
    public boolean ldK;
    public int originalFlag;

    @Override // java.lang.Object
    public /* synthetic */ Object clone() {
        AppMethodBeat.i(134789);
        AppBrandInitConfig NH = NH();
        AppMethodBeat.o(134789);
        return NH;
    }

    public AppBrandInitConfig NH() {
        AppMethodBeat.i(134783);
        Parcel bzR = bzR();
        AppBrandInitConfig appBrandInitConfig = (AppBrandInitConfig) a.bF(getClass()).ak(bzR).object;
        bzR.recycle();
        AppMethodBeat.o(134783);
        return appBrandInitConfig;
    }

    public Parcel bzR() {
        AppMethodBeat.i(134784);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        AppMethodBeat.o(134784);
        return obtain;
    }

    public JSONObject NF() {
        AppMethodBeat.i(134785);
        AppMethodBeat.o(134785);
        return null;
    }

    public final int bzS() {
        return this.eix;
    }

    public AppBrandInitConfig() {
        AppMethodBeat.i(134786);
        AppMethodBeat.o(134786);
    }

    protected AppBrandInitConfig(Parcel parcel) {
        AppMethodBeat.i(134787);
        this.appId = parcel.readString();
        this.brandName = parcel.readString();
        this.iconUrl = parcel.readString();
        this.eix = parcel.readInt();
        this.kHw = parcel.readString();
        this.cBG = parcel.readString();
        this.ldK = parcel.readByte() != 0;
        this.originalFlag = parcel.readInt();
        this.ldJ = parcel.readString();
        AppMethodBeat.o(134787);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(134788);
        parcel.writeString(this.appId);
        parcel.writeString(this.brandName);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.eix);
        parcel.writeString(this.kHw);
        parcel.writeString(this.cBG);
        parcel.writeByte((byte) (this.ldK ? 1 : 0));
        parcel.writeInt(this.originalFlag);
        parcel.writeString(this.ldJ);
        AppMethodBeat.o(134788);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(134790);
        AppMethodBeat.o(134790);
    }
}
