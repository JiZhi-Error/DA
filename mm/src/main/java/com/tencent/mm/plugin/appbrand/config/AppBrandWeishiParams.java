package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandWeishiParams implements Parcelable {
    public static final Parcelable.Creator<AppBrandWeishiParams> CREATOR = new Parcelable.Creator<AppBrandWeishiParams>() {
        /* class com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandWeishiParams[] newArray(int i2) {
            return new AppBrandWeishiParams[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandWeishiParams createFromParcel(Parcel parcel) {
            AppMethodBeat.i(134799);
            AppBrandWeishiParams appBrandWeishiParams = new AppBrandWeishiParams(parcel);
            AppMethodBeat.o(134799);
            return appBrandWeishiParams;
        }
    };
    public String appId;
    public String appName;
    public int ivk;
    public String leN;
    public String leO;
    public String sourceUserName;
    public String thumbUrl;

    public String toString() {
        AppMethodBeat.i(134800);
        String str = "AppBrandWeishiParams{fromOpenSdk=" + this.ivk + ", thumbUrl='" + this.thumbUrl + '\'' + ", thumbFullPath='" + this.leN + '\'' + ", msgImgPath='" + this.leO + '\'' + ", appId='" + this.appId + '\'' + ", appName='" + this.appName + '\'' + ", sourceUserName='" + this.sourceUserName + '\'' + '}';
        AppMethodBeat.o(134800);
        return str;
    }

    public AppBrandWeishiParams() {
    }

    public AppBrandWeishiParams(Parcel parcel) {
        AppMethodBeat.i(134801);
        j(parcel);
        AppMethodBeat.o(134801);
    }

    private void j(Parcel parcel) {
        AppMethodBeat.i(134802);
        this.ivk = parcel.readInt();
        this.thumbUrl = parcel.readString();
        this.leN = parcel.readString();
        this.leO = parcel.readString();
        this.appId = parcel.readString();
        this.appName = parcel.readString();
        this.sourceUserName = parcel.readString();
        AppMethodBeat.o(134802);
    }

    public final void a(AppBrandWeishiParams appBrandWeishiParams) {
        AppMethodBeat.i(134803);
        if (appBrandWeishiParams == null) {
            AppMethodBeat.o(134803);
            return;
        }
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        appBrandWeishiParams.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        j(obtain);
        obtain.recycle();
        AppMethodBeat.o(134803);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(134804);
        parcel.writeInt(this.ivk);
        parcel.writeString(this.thumbUrl);
        parcel.writeString(this.leN);
        parcel.writeString(this.leO);
        parcel.writeString(this.appId);
        parcel.writeString(this.appName);
        parcel.writeString(this.sourceUserName);
        AppMethodBeat.o(134804);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(134805);
        AppMethodBeat.o(134805);
    }
}
