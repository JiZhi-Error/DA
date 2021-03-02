package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator<PrivFrame> CREATOR = new Parcelable.Creator<PrivFrame>() {
        /* class com.google.android.exoplayer2.metadata.id3.PrivFrame.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PrivFrame[] newArray(int i2) {
            return new PrivFrame[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PrivFrame createFromParcel(Parcel parcel) {
            AppMethodBeat.i(92444);
            PrivFrame privFrame = new PrivFrame(parcel);
            AppMethodBeat.o(92444);
            return privFrame;
        }
    };
    public final String buA;
    public final byte[] buB;

    public PrivFrame(String str, byte[] bArr) {
        super("PRIV");
        this.buA = str;
        this.buB = bArr;
    }

    PrivFrame(Parcel parcel) {
        super("PRIV");
        AppMethodBeat.i(92445);
        this.buA = parcel.readString();
        this.buB = parcel.createByteArray();
        AppMethodBeat.o(92445);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92446);
        if (this == obj) {
            AppMethodBeat.o(92446);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(92446);
            return false;
        } else {
            PrivFrame privFrame = (PrivFrame) obj;
            if (!x.j(this.buA, privFrame.buA) || !Arrays.equals(this.buB, privFrame.buB)) {
                AppMethodBeat.o(92446);
                return false;
            }
            AppMethodBeat.o(92446);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(92447);
        int hashCode = (((this.buA != null ? this.buA.hashCode() : 0) + JsApiGetABTestConfig.CTRL_INDEX) * 31) + Arrays.hashCode(this.buB);
        AppMethodBeat.o(92447);
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(92448);
        parcel.writeString(this.buA);
        parcel.writeByteArray(this.buB);
        AppMethodBeat.o(92448);
    }

    static {
        AppMethodBeat.i(92449);
        AppMethodBeat.o(92449);
    }
}
