package com.tencent.mm.plugin.appbrand.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandBackgroundFetchDataTokenParcel implements Parcelable {
    public static final Parcelable.Creator<AppBrandBackgroundFetchDataTokenParcel> CREATOR = new Parcelable.Creator<AppBrandBackgroundFetchDataTokenParcel>() {
        /* class com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataTokenParcel.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandBackgroundFetchDataTokenParcel[] newArray(int i2) {
            return new AppBrandBackgroundFetchDataTokenParcel[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandBackgroundFetchDataTokenParcel createFromParcel(Parcel parcel) {
            AppMethodBeat.i(44735);
            AppBrandBackgroundFetchDataTokenParcel appBrandBackgroundFetchDataTokenParcel = new AppBrandBackgroundFetchDataTokenParcel(parcel);
            AppMethodBeat.o(44735);
            return appBrandBackgroundFetchDataTokenParcel;
        }
    };
    public String token;
    public String username;

    public AppBrandBackgroundFetchDataTokenParcel() {
    }

    protected AppBrandBackgroundFetchDataTokenParcel(Parcel parcel) {
        AppMethodBeat.i(44736);
        this.username = parcel.readString();
        this.token = parcel.readString();
        AppMethodBeat.o(44736);
    }

    static {
        AppMethodBeat.i(44738);
        AppMethodBeat.o(44738);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(44737);
        parcel.writeString(this.username);
        parcel.writeString(this.token);
        AppMethodBeat.o(44737);
    }
}
