package com.tencent.mm.plugin.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.Util;

public class LocationInfo implements Parcelable {
    public static final Parcelable.Creator<LocationInfo> CREATOR = new Parcelable.Creator<LocationInfo>() {
        /* class com.tencent.mm.plugin.location.model.LocationInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LocationInfo[] newArray(int i2) {
            return new LocationInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LocationInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(55672);
            LocationInfo locationInfo = new LocationInfo();
            locationInfo.yFt = parcel.readString();
            locationInfo.yFu = parcel.readDouble();
            locationInfo.yFv = parcel.readDouble();
            locationInfo.yFw = parcel.readInt();
            locationInfo.yFx = parcel.readString();
            locationInfo.yFy = parcel.readString();
            locationInfo.dWi = parcel.readString();
            locationInfo.yFz = parcel.readString();
            locationInfo.yFA = parcel.readInt();
            locationInfo.yFB = parcel.readString();
            AppMethodBeat.o(55672);
            return locationInfo;
        }
    };
    public String dWi;
    public int yFA;
    public String yFB;
    public String yFt;
    public double yFu;
    public double yFv;
    public int yFw;
    public String yFx;
    public String yFy;
    String yFz;

    public LocationInfo() {
        this.yFt = "";
        this.yFu = -85.0d;
        this.yFv = -1000.0d;
        this.yFx = "";
        this.yFy = "zh-cn";
        this.yFz = "";
        this.yFA = 0;
    }

    public LocationInfo(byte b2) {
        AppMethodBeat.i(55673);
        this.yFt = "";
        this.yFu = -85.0d;
        this.yFv = -1000.0d;
        this.yFx = "";
        this.yFy = "zh-cn";
        this.yFz = "";
        this.yFA = 0;
        this.yFt = toString() + " " + System.nanoTime();
        this.yFw = d.ede();
        AppMethodBeat.o(55673);
    }

    static {
        AppMethodBeat.i(55677);
        AppMethodBeat.o(55677);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(55674);
        parcel.writeString(this.yFt);
        parcel.writeDouble(this.yFu);
        parcel.writeDouble(this.yFv);
        parcel.writeInt(this.yFw);
        parcel.writeString(this.yFx);
        parcel.writeString(this.yFy);
        parcel.writeString(this.dWi);
        parcel.writeString(this.yFz);
        parcel.writeInt(this.yFA);
        parcel.writeString(this.yFB);
        AppMethodBeat.o(55674);
    }

    public final boolean ecH() {
        if (this.yFu == -85.0d || this.yFv == -1000.0d) {
            return false;
        }
        return true;
    }

    public final boolean ecI() {
        AppMethodBeat.i(55675);
        if (!Util.isNullOrNil(this.yFx) || !Util.isNullOrNil(this.dWi)) {
            AppMethodBeat.o(55675);
            return true;
        }
        AppMethodBeat.o(55675);
        return false;
    }

    public String toString() {
        AppMethodBeat.i(55676);
        String str = this.yFu + " " + this.yFv + " " + this.yFx + " " + this.dWi + "  " + this.yFt;
        AppMethodBeat.o(55676);
        return str;
    }

    public int describeContents() {
        return 0;
    }
}
