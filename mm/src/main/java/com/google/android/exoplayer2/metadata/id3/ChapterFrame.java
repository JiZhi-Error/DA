package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new Parcelable.Creator<ChapterFrame>() {
        /* class com.google.android.exoplayer2.metadata.id3.ChapterFrame.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ChapterFrame[] newArray(int i2) {
            return new ChapterFrame[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ChapterFrame createFromParcel(Parcel parcel) {
            AppMethodBeat.i(92408);
            ChapterFrame chapterFrame = new ChapterFrame(parcel);
            AppMethodBeat.o(92408);
            return chapterFrame;
        }
    };
    public final String bun;
    public final int buo;
    public final int bup;
    public final long buq;
    public final long bur;
    private final Id3Frame[] bus;

    public ChapterFrame(String str, int i2, int i3, long j2, long j3, Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.bun = str;
        this.buo = i2;
        this.bup = i3;
        this.buq = j2;
        this.bur = j3;
        this.bus = id3FrameArr;
    }

    ChapterFrame(Parcel parcel) {
        super("CHAP");
        AppMethodBeat.i(92409);
        this.bun = parcel.readString();
        this.buo = parcel.readInt();
        this.bup = parcel.readInt();
        this.buq = parcel.readLong();
        this.bur = parcel.readLong();
        int readInt = parcel.readInt();
        this.bus = new Id3Frame[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.bus[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
        AppMethodBeat.o(92409);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92410);
        if (this == obj) {
            AppMethodBeat.o(92410);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(92410);
            return false;
        } else {
            ChapterFrame chapterFrame = (ChapterFrame) obj;
            if (this.buo == chapterFrame.buo && this.bup == chapterFrame.bup && this.buq == chapterFrame.buq && this.bur == chapterFrame.bur && x.j(this.bun, chapterFrame.bun) && Arrays.equals(this.bus, chapterFrame.bus)) {
                AppMethodBeat.o(92410);
                return true;
            }
            AppMethodBeat.o(92410);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(92411);
        int hashCode = (this.bun != null ? this.bun.hashCode() : 0) + ((((((((this.buo + JsApiGetABTestConfig.CTRL_INDEX) * 31) + this.bup) * 31) + ((int) this.buq)) * 31) + ((int) this.bur)) * 31);
        AppMethodBeat.o(92411);
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(92412);
        parcel.writeString(this.bun);
        parcel.writeInt(this.buo);
        parcel.writeInt(this.bup);
        parcel.writeLong(this.buq);
        parcel.writeLong(this.bur);
        parcel.writeInt(this.bus.length);
        for (Id3Frame id3Frame : this.bus) {
            parcel.writeParcelable(id3Frame, 0);
        }
        AppMethodBeat.o(92412);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public final int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(92413);
        AppMethodBeat.o(92413);
    }
}
