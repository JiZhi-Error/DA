package com.tencent.liteapp.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxaLiteAppIPCCallbackData implements Parcelable {
    public static final Parcelable.Creator<WxaLiteAppIPCCallbackData> CREATOR = new Parcelable.Creator<WxaLiteAppIPCCallbackData>() {
        /* class com.tencent.liteapp.jsapi.WxaLiteAppIPCCallbackData.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WxaLiteAppIPCCallbackData[] newArray(int i2) {
            return new WxaLiteAppIPCCallbackData[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WxaLiteAppIPCCallbackData createFromParcel(Parcel parcel) {
            AppMethodBeat.i(197697);
            WxaLiteAppIPCCallbackData wxaLiteAppIPCCallbackData = new WxaLiteAppIPCCallbackData(parcel);
            AppMethodBeat.o(197697);
            return wxaLiteAppIPCCallbackData;
        }
    };
    public boolean cqT = false;
    public String cqU = null;
    public String cqV = null;

    public WxaLiteAppIPCCallbackData() {
    }

    public WxaLiteAppIPCCallbackData(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(197698);
        this.cqT = parcel.readInt() != 1 ? false : z;
        this.cqU = parcel.readString();
        this.cqV = parcel.readString();
        AppMethodBeat.o(197698);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(197699);
        parcel.writeInt(this.cqT ? 1 : 0);
        parcel.writeString(this.cqU);
        parcel.writeString(this.cqV);
        AppMethodBeat.o(197699);
    }

    static {
        AppMethodBeat.i(197700);
        AppMethodBeat.o(197700);
    }
}
