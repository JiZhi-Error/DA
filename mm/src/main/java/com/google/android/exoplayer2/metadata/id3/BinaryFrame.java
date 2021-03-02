package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class BinaryFrame extends Id3Frame {
    public static final Parcelable.Creator<BinaryFrame> CREATOR = new Parcelable.Creator<BinaryFrame>() {
        /* class com.google.android.exoplayer2.metadata.id3.BinaryFrame.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BinaryFrame[] newArray(int i2) {
            return new BinaryFrame[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BinaryFrame createFromParcel(Parcel parcel) {
            AppMethodBeat.i(92402);
            BinaryFrame binaryFrame = new BinaryFrame(parcel);
            AppMethodBeat.o(92402);
            return binaryFrame;
        }
    };
    public final byte[] data;

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.data = bArr;
    }

    BinaryFrame(Parcel parcel) {
        super(parcel.readString());
        AppMethodBeat.i(92403);
        this.data = parcel.createByteArray();
        AppMethodBeat.o(92403);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92404);
        if (this == obj) {
            AppMethodBeat.o(92404);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(92404);
            return false;
        } else {
            BinaryFrame binaryFrame = (BinaryFrame) obj;
            if (!this.id.equals(binaryFrame.id) || !Arrays.equals(this.data, binaryFrame.data)) {
                AppMethodBeat.o(92404);
                return false;
            }
            AppMethodBeat.o(92404);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(92405);
        int hashCode = ((this.id.hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31) + Arrays.hashCode(this.data);
        AppMethodBeat.o(92405);
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(92406);
        parcel.writeString(this.id);
        parcel.writeByteArray(this.data);
        AppMethodBeat.o(92406);
    }

    static {
        AppMethodBeat.i(92407);
        AppMethodBeat.o(92407);
    }
}
