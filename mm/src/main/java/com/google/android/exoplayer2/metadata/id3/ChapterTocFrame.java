package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new Parcelable.Creator<ChapterTocFrame>() {
        /* class com.google.android.exoplayer2.metadata.id3.ChapterTocFrame.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ChapterTocFrame[] newArray(int i2) {
            return new ChapterTocFrame[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ChapterTocFrame createFromParcel(Parcel parcel) {
            AppMethodBeat.i(92414);
            ChapterTocFrame chapterTocFrame = new ChapterTocFrame(parcel);
            AppMethodBeat.o(92414);
            return chapterTocFrame;
        }
    };
    public final boolean bpW;
    private final Id3Frame[] bus;
    public final String but;
    public final boolean buu;
    public final String[] buv;

    public ChapterTocFrame(String str, boolean z, boolean z2, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.but = str;
        this.buu = z;
        this.bpW = z2;
        this.buv = strArr;
        this.bus = id3FrameArr;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChapterTocFrame(Parcel parcel) {
        super("CTOC");
        boolean z = true;
        AppMethodBeat.i(92415);
        this.but = parcel.readString();
        this.buu = parcel.readByte() != 0;
        this.bpW = parcel.readByte() == 0 ? false : z;
        this.buv = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.bus = new Id3Frame[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.bus[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
        AppMethodBeat.o(92415);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92416);
        if (this == obj) {
            AppMethodBeat.o(92416);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(92416);
            return false;
        } else {
            ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
            if (this.buu != chapterTocFrame.buu || this.bpW != chapterTocFrame.bpW || !x.j(this.but, chapterTocFrame.but) || !Arrays.equals(this.buv, chapterTocFrame.buv) || !Arrays.equals(this.bus, chapterTocFrame.bus)) {
                AppMethodBeat.o(92416);
                return false;
            }
            AppMethodBeat.o(92416);
            return true;
        }
    }

    public final int hashCode() {
        int i2;
        int i3 = 1;
        int i4 = 0;
        AppMethodBeat.i(92417);
        if (this.buu) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i5 = (i2 + JsApiGetABTestConfig.CTRL_INDEX) * 31;
        if (!this.bpW) {
            i3 = 0;
        }
        int i6 = (i5 + i3) * 31;
        if (this.but != null) {
            i4 = this.but.hashCode();
        }
        int i7 = i6 + i4;
        AppMethodBeat.o(92417);
        return i7;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int i3 = 1;
        AppMethodBeat.i(92418);
        parcel.writeString(this.but);
        parcel.writeByte((byte) (this.buu ? 1 : 0));
        if (!this.bpW) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeStringArray(this.buv);
        parcel.writeInt(this.bus.length);
        for (int i4 = 0; i4 < this.bus.length; i4++) {
            parcel.writeParcelable(this.bus[i4], 0);
        }
        AppMethodBeat.o(92418);
    }

    static {
        AppMethodBeat.i(92419);
        AppMethodBeat.o(92419);
    }
}
