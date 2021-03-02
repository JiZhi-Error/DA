package com.tencent.mm.media.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandMediaSource implements Parcelable {
    public static final Parcelable.Creator<AppBrandMediaSource> CREATOR = new Parcelable.Creator<AppBrandMediaSource>() {
        /* class com.tencent.mm.media.model.AppBrandMediaSource.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandMediaSource[] newArray(int i2) {
            return new AppBrandMediaSource[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandMediaSource createFromParcel(Parcel parcel) {
            AppMethodBeat.i(184247);
            AppBrandMediaSource appBrandMediaSource = new AppBrandMediaSource(parcel);
            AppMethodBeat.o(184247);
            return appBrandMediaSource;
        }
    };
    public String igV = "";
    public String igW = "";
    public String url = "";

    public AppBrandMediaSource() {
    }

    public AppBrandMediaSource(Parcel parcel) {
        AppMethodBeat.i(184248);
        this.url = parcel.readString();
        this.igV = parcel.readString();
        this.igW = parcel.readString();
        AppMethodBeat.o(184248);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(184249);
        parcel.writeString(this.url);
        parcel.writeString(this.igV);
        parcel.writeString(this.igW);
        AppMethodBeat.o(184249);
    }

    static {
        AppMethodBeat.i(184250);
        AppMethodBeat.o(184250);
    }
}
