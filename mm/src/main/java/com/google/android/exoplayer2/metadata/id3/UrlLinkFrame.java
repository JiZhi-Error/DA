package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new Parcelable.Creator<UrlLinkFrame>() {
        /* class com.google.android.exoplayer2.metadata.id3.UrlLinkFrame.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UrlLinkFrame[] newArray(int i2) {
            return new UrlLinkFrame[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UrlLinkFrame createFromParcel(Parcel parcel) {
            AppMethodBeat.i(92456);
            UrlLinkFrame urlLinkFrame = new UrlLinkFrame(parcel);
            AppMethodBeat.o(92456);
            return urlLinkFrame;
        }
    };
    public final String description;
    public final String url;

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.description = str2;
        this.url = str3;
    }

    UrlLinkFrame(Parcel parcel) {
        super(parcel.readString());
        AppMethodBeat.i(92457);
        this.description = parcel.readString();
        this.url = parcel.readString();
        AppMethodBeat.o(92457);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92458);
        if (this == obj) {
            AppMethodBeat.o(92458);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(92458);
            return false;
        } else {
            UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
            if (!this.id.equals(urlLinkFrame.id) || !x.j(this.description, urlLinkFrame.description) || !x.j(this.url, urlLinkFrame.url)) {
                AppMethodBeat.o(92458);
                return false;
            }
            AppMethodBeat.o(92458);
            return true;
        }
    }

    public final int hashCode() {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(92459);
        int hashCode = (this.id.hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31;
        if (this.description != null) {
            i2 = this.description.hashCode();
        } else {
            i2 = 0;
        }
        int i4 = (i2 + hashCode) * 31;
        if (this.url != null) {
            i3 = this.url.hashCode();
        }
        int i5 = i4 + i3;
        AppMethodBeat.o(92459);
        return i5;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(92460);
        parcel.writeString(this.id);
        parcel.writeString(this.description);
        parcel.writeString(this.url);
        AppMethodBeat.o(92460);
    }

    static {
        AppMethodBeat.i(92461);
        AppMethodBeat.o(92461);
    }
}
