package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareInfo implements Parcelable {
    public static final Parcelable.Creator<ShareInfo> CREATOR = new Parcelable.Creator<ShareInfo>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.share.ShareInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ShareInfo[] newArray(int i2) {
            return new ShareInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ShareInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(46815);
            ShareInfo shareInfo = new ShareInfo(parcel, (byte) 0);
            AppMethodBeat.o(46815);
            return shareInfo;
        }
    };
    public String cyq;
    public String cyr;

    /* synthetic */ ShareInfo(Parcel parcel, byte b2) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(46816);
        parcel.writeString(this.cyr);
        parcel.writeString(this.cyq);
        AppMethodBeat.o(46816);
    }

    public ShareInfo(String str, String str2) {
        this.cyr = str;
        this.cyq = str2;
    }

    private ShareInfo(Parcel parcel) {
        AppMethodBeat.i(46817);
        this.cyr = parcel.readString();
        this.cyq = parcel.readString();
        AppMethodBeat.o(46817);
    }

    static {
        AppMethodBeat.i(46818);
        AppMethodBeat.o(46818);
    }
}
