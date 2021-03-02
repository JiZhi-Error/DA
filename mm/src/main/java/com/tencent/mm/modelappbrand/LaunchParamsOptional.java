package com.tencent.mm.modelappbrand;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;

public final class LaunchParamsOptional implements Parcelable {
    public static final Parcelable.Creator<LaunchParamsOptional> CREATOR = new Parcelable.Creator<LaunchParamsOptional>() {
        /* class com.tencent.mm.modelappbrand.LaunchParamsOptional.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LaunchParamsOptional[] newArray(int i2) {
            return new LaunchParamsOptional[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LaunchParamsOptional createFromParcel(Parcel parcel) {
            AppMethodBeat.i(146918);
            LaunchParamsOptional launchParamsOptional = new LaunchParamsOptional(parcel, (byte) 0);
            AppMethodBeat.o(146918);
            return launchParamsOptional;
        }
    };
    public String cyq;
    public String cyr;
    public AppBrandWeishiParams cyt;
    public String iIt;

    /* synthetic */ LaunchParamsOptional(Parcel parcel, byte b2) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(146919);
        parcel.writeString(this.cyq);
        parcel.writeString(this.cyr);
        parcel.writeParcelable(this.cyt, i2);
        AppMethodBeat.o(146919);
    }

    public LaunchParamsOptional() {
    }

    private LaunchParamsOptional(Parcel parcel) {
        AppMethodBeat.i(146920);
        this.cyq = parcel.readString();
        this.cyr = parcel.readString();
        this.cyt = (AppBrandWeishiParams) parcel.readParcelable(AppBrandWeishiParams.class.getClassLoader());
        AppMethodBeat.o(146920);
    }

    static {
        AppMethodBeat.i(146921);
        AppMethodBeat.o(146921);
    }
}
