package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandWeishiVideoOperation implements Parcelable {
    public static final Parcelable.Creator<AppBrandWeishiVideoOperation> CREATOR = new Parcelable.Creator<AppBrandWeishiVideoOperation>() {
        /* class com.tencent.mm.plugin.appbrand.xweb_ext.video.AppBrandWeishiVideoOperation.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandWeishiVideoOperation[] newArray(int i2) {
            return new AppBrandWeishiVideoOperation[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandWeishiVideoOperation createFromParcel(Parcel parcel) {
            AppMethodBeat.i(50034);
            AppBrandWeishiVideoOperation appBrandWeishiVideoOperation = new AppBrandWeishiVideoOperation(parcel);
            AppMethodBeat.o(50034);
            return appBrandWeishiVideoOperation;
        }
    };
    public long boS;
    public long length;
    public String url;

    public AppBrandWeishiVideoOperation(String str, long j2) {
        this.url = str;
        this.boS = 0;
        this.length = j2;
    }

    protected AppBrandWeishiVideoOperation(Parcel parcel) {
        AppMethodBeat.i(50035);
        this.url = parcel.readString();
        this.boS = parcel.readLong();
        this.length = parcel.readLong();
        AppMethodBeat.o(50035);
    }

    static {
        AppMethodBeat.i(50037);
        AppMethodBeat.o(50037);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(50036);
        parcel.writeString(this.url);
        parcel.writeLong(this.boS);
        parcel.writeLong(this.length);
        AppMethodBeat.o(50036);
    }
}
