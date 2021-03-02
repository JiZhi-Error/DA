package com.tencent.mm.pluginsdk.model.lbs;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class Location implements Parcelable {
    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {
        /* class com.tencent.mm.pluginsdk.model.lbs.Location.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Location[] newArray(int i2) {
            return new Location[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Location createFromParcel(Parcel parcel) {
            AppMethodBeat.i(151844);
            Location location = new Location();
            location.iUY = parcel.readFloat();
            location.iUZ = parcel.readFloat();
            location.accuracy = parcel.readInt();
            location.dTl = parcel.readInt();
            location.mac = parcel.readString();
            location.dTn = parcel.readString();
            AppMethodBeat.o(151844);
            return location;
        }
    };
    public int accuracy;
    public int dTl;
    public String dTn;
    public float iUY;
    public float iUZ;
    public String mac;

    public Location() {
    }

    public Location(float f2, float f3, int i2, int i3, String str, String str2) {
        this.iUY = f2;
        this.iUZ = f3;
        this.accuracy = i2;
        this.dTl = i3;
        this.mac = str;
        this.dTn = str2;
    }

    public final boolean gnj() {
        AppMethodBeat.i(151845);
        if (this.iUY == -85.0f || this.iUZ == -1000.0f) {
            Log.d("MicroMsg.Radar.Location", "mac and cellId is null");
            AppMethodBeat.o(151845);
            return true;
        }
        AppMethodBeat.o(151845);
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(151846);
        parcel.writeFloat(this.iUY);
        parcel.writeFloat(this.iUZ);
        parcel.writeInt(this.accuracy);
        parcel.writeInt(this.dTl);
        parcel.writeString(this.mac);
        parcel.writeString(this.dTn);
        AppMethodBeat.o(151846);
    }

    static {
        AppMethodBeat.i(151847);
        AppMethodBeat.o(151847);
    }
}
