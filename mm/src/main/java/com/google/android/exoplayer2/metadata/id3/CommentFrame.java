package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new Parcelable.Creator<CommentFrame>() {
        /* class com.google.android.exoplayer2.metadata.id3.CommentFrame.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CommentFrame[] newArray(int i2) {
            return new CommentFrame[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CommentFrame createFromParcel(Parcel parcel) {
            AppMethodBeat.i(92420);
            CommentFrame commentFrame = new CommentFrame(parcel);
            AppMethodBeat.o(92420);
            return commentFrame;
        }
    };
    public final String description;
    public final String language;
    public final String text;

    public CommentFrame(String str, String str2, String str3) {
        super("COMM");
        this.language = str;
        this.description = str2;
        this.text = str3;
    }

    CommentFrame(Parcel parcel) {
        super("COMM");
        AppMethodBeat.i(92421);
        this.language = parcel.readString();
        this.description = parcel.readString();
        this.text = parcel.readString();
        AppMethodBeat.o(92421);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92422);
        if (this == obj) {
            AppMethodBeat.o(92422);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(92422);
            return false;
        } else {
            CommentFrame commentFrame = (CommentFrame) obj;
            if (!x.j(this.description, commentFrame.description) || !x.j(this.language, commentFrame.language) || !x.j(this.text, commentFrame.text)) {
                AppMethodBeat.o(92422);
                return false;
            }
            AppMethodBeat.o(92422);
            return true;
        }
    }

    public final int hashCode() {
        int i2;
        int i3;
        int i4 = 0;
        AppMethodBeat.i(92423);
        if (this.language != null) {
            i2 = this.language.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (i2 + JsApiGetABTestConfig.CTRL_INDEX) * 31;
        if (this.description != null) {
            i3 = this.description.hashCode();
        } else {
            i3 = 0;
        }
        int i6 = (i3 + i5) * 31;
        if (this.text != null) {
            i4 = this.text.hashCode();
        }
        int i7 = i6 + i4;
        AppMethodBeat.o(92423);
        return i7;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(92424);
        parcel.writeString(this.id);
        parcel.writeString(this.language);
        parcel.writeString(this.text);
        AppMethodBeat.o(92424);
    }

    static {
        AppMethodBeat.i(92425);
        AppMethodBeat.o(92425);
    }
}
