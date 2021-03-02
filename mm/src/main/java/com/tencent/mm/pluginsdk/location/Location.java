package com.tencent.mm.pluginsdk.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Location implements Parcelable {
    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {
        /* class com.tencent.mm.pluginsdk.location.Location.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Location[] newArray(int i2) {
            return new Location[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Location createFromParcel(Parcel parcel) {
            AppMethodBeat.i(169195);
            Location location = new Location(parcel);
            AppMethodBeat.o(169195);
            return location;
        }
    };
    public final float dTj;
    public final float latitude;

    public Location(float f2, float f3) {
        this.latitude = f2;
        this.dTj = f3;
    }

    protected Location(Parcel parcel) {
        AppMethodBeat.i(169196);
        this.latitude = parcel.readFloat();
        this.dTj = parcel.readFloat();
        AppMethodBeat.o(169196);
    }

    static {
        AppMethodBeat.i(169198);
        AppMethodBeat.o(169198);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(169197);
        parcel.writeFloat(this.latitude);
        parcel.writeFloat(this.dTj);
        AppMethodBeat.o(169197);
    }
}
