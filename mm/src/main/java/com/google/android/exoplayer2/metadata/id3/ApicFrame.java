package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new Parcelable.Creator<ApicFrame>() {
        /* class com.google.android.exoplayer2.metadata.id3.ApicFrame.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ApicFrame[] newArray(int i2) {
            return new ApicFrame[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ApicFrame createFromParcel(Parcel parcel) {
            AppMethodBeat.i(92396);
            ApicFrame apicFrame = new ApicFrame(parcel);
            AppMethodBeat.o(92396);
            return apicFrame;
        }
    };
    public final int bul;
    public final byte[] bum;
    public final String description;
    public final String mimeType;

    public ApicFrame(String str, String str2, int i2, byte[] bArr) {
        super("APIC");
        this.mimeType = str;
        this.description = str2;
        this.bul = i2;
        this.bum = bArr;
    }

    ApicFrame(Parcel parcel) {
        super("APIC");
        AppMethodBeat.i(92397);
        this.mimeType = parcel.readString();
        this.description = parcel.readString();
        this.bul = parcel.readInt();
        this.bum = parcel.createByteArray();
        AppMethodBeat.o(92397);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92398);
        if (this == obj) {
            AppMethodBeat.o(92398);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(92398);
            return false;
        } else {
            ApicFrame apicFrame = (ApicFrame) obj;
            if (this.bul != apicFrame.bul || !x.j(this.mimeType, apicFrame.mimeType) || !x.j(this.description, apicFrame.description) || !Arrays.equals(this.bum, apicFrame.bum)) {
                AppMethodBeat.o(92398);
                return false;
            }
            AppMethodBeat.o(92398);
            return true;
        }
    }

    public final int hashCode() {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(92399);
        int i4 = (this.bul + JsApiGetABTestConfig.CTRL_INDEX) * 31;
        if (this.mimeType != null) {
            i2 = this.mimeType.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (i2 + i4) * 31;
        if (this.description != null) {
            i3 = this.description.hashCode();
        }
        int hashCode = ((i5 + i3) * 31) + Arrays.hashCode(this.bum);
        AppMethodBeat.o(92399);
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(92400);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.description);
        parcel.writeInt(this.bul);
        parcel.writeByteArray(this.bum);
        AppMethodBeat.o(92400);
    }

    static {
        AppMethodBeat.i(92401);
        AppMethodBeat.o(92401);
    }
}
