package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new Parcelable.Creator<TextInformationFrame>() {
        /* class com.google.android.exoplayer2.metadata.id3.TextInformationFrame.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TextInformationFrame[] newArray(int i2) {
            return new TextInformationFrame[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TextInformationFrame createFromParcel(Parcel parcel) {
            AppMethodBeat.i(92450);
            TextInformationFrame textInformationFrame = new TextInformationFrame(parcel);
            AppMethodBeat.o(92450);
            return textInformationFrame;
        }
    };
    public final String description;
    public final String value;

    public TextInformationFrame(String str, String str2, String str3) {
        super(str);
        this.description = str2;
        this.value = str3;
    }

    TextInformationFrame(Parcel parcel) {
        super(parcel.readString());
        AppMethodBeat.i(92451);
        this.description = parcel.readString();
        this.value = parcel.readString();
        AppMethodBeat.o(92451);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92452);
        if (this == obj) {
            AppMethodBeat.o(92452);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(92452);
            return false;
        } else {
            TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
            if (!this.id.equals(textInformationFrame.id) || !x.j(this.description, textInformationFrame.description) || !x.j(this.value, textInformationFrame.value)) {
                AppMethodBeat.o(92452);
                return false;
            }
            AppMethodBeat.o(92452);
            return true;
        }
    }

    public final int hashCode() {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(92453);
        int hashCode = (this.id.hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31;
        if (this.description != null) {
            i2 = this.description.hashCode();
        } else {
            i2 = 0;
        }
        int i4 = (i2 + hashCode) * 31;
        if (this.value != null) {
            i3 = this.value.hashCode();
        }
        int i5 = i4 + i3;
        AppMethodBeat.o(92453);
        return i5;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(92454);
        parcel.writeString(this.id);
        parcel.writeString(this.description);
        parcel.writeString(this.value);
        AppMethodBeat.o(92454);
    }

    static {
        AppMethodBeat.i(92455);
        AppMethodBeat.o(92455);
    }
}
