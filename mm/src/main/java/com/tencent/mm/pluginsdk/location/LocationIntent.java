package com.tencent.mm.pluginsdk.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.sdk.platformtools.Util;

public class LocationIntent implements Parcelable {
    public static final Parcelable.Creator<LocationIntent> CREATOR = new Parcelable.Creator<LocationIntent>() {
        /* class com.tencent.mm.pluginsdk.location.LocationIntent.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LocationIntent[] newArray(int i2) {
            return new LocationIntent[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LocationIntent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(151627);
            LocationIntent locationIntent = new LocationIntent();
            locationIntent.lat = parcel.readDouble();
            locationIntent.lng = parcel.readDouble();
            locationIntent.dRt = parcel.readInt();
            locationIntent.label = parcel.readString();
            locationIntent.kHV = Util.nullAs(parcel.readString(), "");
            locationIntent.JTr = Util.nullAs(parcel.readString(), "");
            locationIntent.yFz = Util.nullAs(parcel.readString(), "");
            locationIntent.JTs = parcel.readInt();
            locationIntent.iVi = (Addr) parcel.readParcelable(Addr.class.getClassLoader());
            locationIntent.yFB = Util.nullAs(parcel.readString(), "");
            AppMethodBeat.o(151627);
            return locationIntent;
        }
    };
    public String JTr = "";
    public int JTs = 0;
    public int dRt = 0;
    public Addr iVi = null;
    public String kHV = "";
    public String label = "";
    public double lat;
    public double lng;
    public String yFB;
    public String yFz;

    public final String aBz() {
        AppMethodBeat.i(151628);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("lat " + this.lat + ";");
        stringBuffer.append("lng " + this.lng + ";");
        stringBuffer.append("scale " + this.dRt + ";");
        stringBuffer.append("label " + this.label + ";");
        stringBuffer.append("poiname " + this.kHV + ";");
        stringBuffer.append("infourl " + this.JTr + ";");
        stringBuffer.append("locTypeId " + this.yFz + ";");
        stringBuffer.append("poiType " + this.JTs + ";");
        if (this.iVi != null) {
            stringBuffer.append("addr " + this.iVi.toString() + ";");
        }
        stringBuffer.append("poiid " + this.yFB + ";");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(151628);
        return stringBuffer2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(151629);
        parcel.writeDouble(this.lat);
        parcel.writeDouble(this.lng);
        parcel.writeInt(this.dRt);
        parcel.writeString(this.label);
        parcel.writeString(this.kHV);
        parcel.writeString(this.JTr);
        parcel.writeString(this.yFz);
        parcel.writeInt(this.JTs);
        parcel.writeParcelable(this.iVi, i2);
        parcel.writeString(this.yFB);
        AppMethodBeat.o(151629);
    }

    static {
        AppMethodBeat.i(151630);
        AppMethodBeat.o(151630);
    }
}
