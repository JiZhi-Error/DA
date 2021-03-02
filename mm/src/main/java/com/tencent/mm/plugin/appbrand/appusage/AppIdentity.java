package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppIdentity implements Parcelable {
    public static final Parcelable.Creator<AppIdentity> CREATOR = new Parcelable.Creator<AppIdentity>() {
        /* class com.tencent.mm.plugin.appbrand.appusage.AppIdentity.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppIdentity[] newArray(int i2) {
            return new AppIdentity[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppIdentity createFromParcel(Parcel parcel) {
            AppMethodBeat.i(44628);
            AppIdentity appIdentity = new AppIdentity(parcel);
            AppMethodBeat.o(44628);
            return appIdentity;
        }
    };
    public final int iOo;
    public final String username;

    public AppIdentity(String str, int i2) {
        this.username = str;
        this.iOo = i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(44629);
        parcel.writeString(this.username);
        parcel.writeInt(this.iOo);
        AppMethodBeat.o(44629);
    }

    protected AppIdentity(Parcel parcel) {
        AppMethodBeat.i(44630);
        this.username = parcel.readString();
        this.iOo = parcel.readInt();
        AppMethodBeat.o(44630);
    }

    static {
        AppMethodBeat.i(44631);
        AppMethodBeat.o(44631);
    }
}
