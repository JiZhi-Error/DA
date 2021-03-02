package com.tencent.mm.plugin.appbrand.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandBackgroundFetchDataParcel implements Parcelable {
    public static final Parcelable.Creator<AppBrandBackgroundFetchDataParcel> CREATOR = new Parcelable.Creator<AppBrandBackgroundFetchDataParcel>() {
        /* class com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataParcel.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandBackgroundFetchDataParcel[] newArray(int i2) {
            return new AppBrandBackgroundFetchDataParcel[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandBackgroundFetchDataParcel createFromParcel(Parcel parcel) {
            AppMethodBeat.i(44700);
            AppBrandBackgroundFetchDataParcel appBrandBackgroundFetchDataParcel = new AppBrandBackgroundFetchDataParcel(parcel);
            AppMethodBeat.o(44700);
            return appBrandBackgroundFetchDataParcel;
        }
    };
    public long crj;
    public String data;
    public int kXP;
    public String path;
    public String query;
    public int scene;
    public String username;

    public AppBrandBackgroundFetchDataParcel() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(44701);
        parcel.writeString(this.username);
        parcel.writeInt(this.kXP);
        parcel.writeString(this.path);
        parcel.writeString(this.query);
        parcel.writeString(this.data);
        parcel.writeInt(this.scene);
        parcel.writeLong(this.crj);
        AppMethodBeat.o(44701);
    }

    protected AppBrandBackgroundFetchDataParcel(Parcel parcel) {
        AppMethodBeat.i(44702);
        this.username = parcel.readString();
        this.kXP = parcel.readInt();
        this.path = parcel.readString();
        this.query = parcel.readString();
        this.data = parcel.readString();
        this.scene = parcel.readInt();
        this.crj = parcel.readLong();
        AppMethodBeat.o(44702);
    }

    static {
        AppMethodBeat.i(44703);
        AppMethodBeat.o(44703);
    }
}
