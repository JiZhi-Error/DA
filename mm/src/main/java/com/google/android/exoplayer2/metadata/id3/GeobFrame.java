package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new Parcelable.Creator<GeobFrame>() {
        /* class com.google.android.exoplayer2.metadata.id3.GeobFrame.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GeobFrame[] newArray(int i2) {
            return new GeobFrame[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GeobFrame createFromParcel(Parcel parcel) {
            AppMethodBeat.i(92426);
            GeobFrame geobFrame = new GeobFrame(parcel);
            AppMethodBeat.o(92426);
            return geobFrame;
        }
    };
    public final byte[] data;
    public final String description;
    public final String filename;
    public final String mimeType;

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.mimeType = str;
        this.filename = str2;
        this.description = str3;
        this.data = bArr;
    }

    GeobFrame(Parcel parcel) {
        super("GEOB");
        AppMethodBeat.i(92427);
        this.mimeType = parcel.readString();
        this.filename = parcel.readString();
        this.description = parcel.readString();
        this.data = parcel.createByteArray();
        AppMethodBeat.o(92427);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92428);
        if (this == obj) {
            AppMethodBeat.o(92428);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(92428);
            return false;
        } else {
            GeobFrame geobFrame = (GeobFrame) obj;
            if (!x.j(this.mimeType, geobFrame.mimeType) || !x.j(this.filename, geobFrame.filename) || !x.j(this.description, geobFrame.description) || !Arrays.equals(this.data, geobFrame.data)) {
                AppMethodBeat.o(92428);
                return false;
            }
            AppMethodBeat.o(92428);
            return true;
        }
    }

    public final int hashCode() {
        int i2;
        int i3;
        int i4 = 0;
        AppMethodBeat.i(92429);
        if (this.mimeType != null) {
            i2 = this.mimeType.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (i2 + JsApiGetABTestConfig.CTRL_INDEX) * 31;
        if (this.filename != null) {
            i3 = this.filename.hashCode();
        } else {
            i3 = 0;
        }
        int i6 = (i3 + i5) * 31;
        if (this.description != null) {
            i4 = this.description.hashCode();
        }
        int hashCode = ((i6 + i4) * 31) + Arrays.hashCode(this.data);
        AppMethodBeat.o(92429);
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(92430);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.filename);
        parcel.writeString(this.description);
        parcel.writeByteArray(this.data);
        AppMethodBeat.o(92430);
    }

    static {
        AppMethodBeat.i(92431);
        AppMethodBeat.o(92431);
    }
}
