package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DebuggerInfo implements Parcelable {
    public static final Parcelable.Creator<DebuggerInfo> CREATOR = new Parcelable.Creator<DebuggerInfo>() {
        /* class com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DebuggerInfo[] newArray(int i2) {
            return new DebuggerInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DebuggerInfo createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(121282);
            DebuggerInfo debuggerInfo = new DebuggerInfo();
            debuggerInfo.lnb = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = false;
            }
            debuggerInfo.lnc = z;
            if (parcel.readInt() == 0) {
                z2 = false;
            }
            debuggerInfo.lnd = z2;
            AppMethodBeat.o(121282);
            return debuggerInfo;
        }
    };
    public boolean lnb;
    public boolean lnc;
    public boolean lnd;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4;
        int i5 = 1;
        AppMethodBeat.i(121283);
        if (this.lnb) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        if (this.lnc) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        parcel.writeInt(i4);
        if (!this.lnd) {
            i5 = 0;
        }
        parcel.writeInt(i5);
        AppMethodBeat.o(121283);
    }

    static {
        AppMethodBeat.i(121284);
        AppMethodBeat.o(121284);
    }
}
