package com.tencent.mm.plugin.lite.debug;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LiteAppDebugIPCCallbackData implements Parcelable {
    public static final Parcelable.Creator<LiteAppDebugIPCCallbackData> CREATOR = new Parcelable.Creator<LiteAppDebugIPCCallbackData>() {
        /* class com.tencent.mm.plugin.lite.debug.LiteAppDebugIPCCallbackData.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LiteAppDebugIPCCallbackData[] newArray(int i2) {
            return new LiteAppDebugIPCCallbackData[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LiteAppDebugIPCCallbackData createFromParcel(Parcel parcel) {
            AppMethodBeat.i(198812);
            LiteAppDebugIPCCallbackData liteAppDebugIPCCallbackData = new LiteAppDebugIPCCallbackData(parcel);
            AppMethodBeat.o(198812);
            return liteAppDebugIPCCallbackData;
        }
    };
    public String cqU = null;

    public LiteAppDebugIPCCallbackData() {
    }

    public LiteAppDebugIPCCallbackData(Parcel parcel) {
        AppMethodBeat.i(198813);
        this.cqU = parcel.readString();
        AppMethodBeat.o(198813);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(198814);
        parcel.writeString(this.cqU);
        AppMethodBeat.o(198814);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(198815);
        AppMethodBeat.o(198815);
    }
}
