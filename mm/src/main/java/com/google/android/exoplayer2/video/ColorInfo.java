package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class ColorInfo implements Parcelable {
    public static final Parcelable.Creator<ColorInfo> CREATOR = new Parcelable.Creator<ColorInfo>() {
        /* class com.google.android.exoplayer2.video.ColorInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ColorInfo[] newArray(int i2) {
            return new ColorInfo[0];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ColorInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(93252);
            ColorInfo colorInfo = new ColorInfo(parcel);
            AppMethodBeat.o(93252);
            return colorInfo;
        }
    };
    private int aHK;
    public final byte[] bHM;
    public final int bjW;
    public final int bjX;
    public final int bjY;

    public ColorInfo(int i2, int i3, int i4, byte[] bArr) {
        this.bjW = i2;
        this.bjY = i3;
        this.bjX = i4;
        this.bHM = bArr;
    }

    ColorInfo(Parcel parcel) {
        AppMethodBeat.i(93253);
        this.bjW = parcel.readInt();
        this.bjY = parcel.readInt();
        this.bjX = parcel.readInt();
        this.bHM = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        AppMethodBeat.o(93253);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(93254);
        if (this == obj) {
            AppMethodBeat.o(93254);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(93254);
            return false;
        } else {
            ColorInfo colorInfo = (ColorInfo) obj;
            if (this.bjW == colorInfo.bjW && this.bjY == colorInfo.bjY && this.bjX == colorInfo.bjX && Arrays.equals(this.bHM, colorInfo.bHM)) {
                AppMethodBeat.o(93254);
                return true;
            }
            AppMethodBeat.o(93254);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.i(93255);
        String str = "ColorInfo(" + this.bjW + ", " + this.bjY + ", " + this.bjX + ", " + (this.bHM != null) + ")";
        AppMethodBeat.o(93255);
        return str;
    }

    public final int hashCode() {
        AppMethodBeat.i(93256);
        if (this.aHK == 0) {
            this.aHK = ((((((this.bjW + JsApiGetABTestConfig.CTRL_INDEX) * 31) + this.bjY) * 31) + this.bjX) * 31) + Arrays.hashCode(this.bHM);
        }
        int i2 = this.aHK;
        AppMethodBeat.o(93256);
        return i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(93257);
        parcel.writeInt(this.bjW);
        parcel.writeInt(this.bjY);
        parcel.writeInt(this.bjX);
        parcel.writeInt(this.bHM != null ? 1 : 0);
        if (this.bHM != null) {
            parcel.writeByteArray(this.bHM);
        }
        AppMethodBeat.o(93257);
    }

    static {
        AppMethodBeat.i(93258);
        AppMethodBeat.o(93258);
    }
}
