package com.tencent.mm.plugin.recordvideo.model.audio;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0012H\u0016R*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/model/audio/LyricsInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "lyricDatas", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "(Ljava/util/List;)V", "lyrics", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLyrics", "()Ljava/util/ArrayList;", "setLyrics", "(Ljava/util/ArrayList;)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "plugin-recordvideo_release"})
public final class LyricsInfo implements Parcelable {
    public static final a CREATOR = new a((byte) 0);
    public ArrayList<byte[]> BPI;

    static {
        AppMethodBeat.i(75437);
        AppMethodBeat.o(75437);
    }

    private /* synthetic */ LyricsInfo() {
        this(new ArrayList());
        AppMethodBeat.i(75435);
        AppMethodBeat.o(75435);
    }

    public LyricsInfo(List<? extends ckm> list) {
        p.h(list, "lyricDatas");
        AppMethodBeat.i(75434);
        this.BPI = new ArrayList<>();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.BPI.add(it.next().toByteArray());
        }
        AppMethodBeat.o(75434);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LyricsInfo(Parcel parcel) {
        this();
        p.h(parcel, "parcel");
        AppMethodBeat.i(75436);
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            this.BPI.add(bArr);
        }
        AppMethodBeat.o(75436);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(75433);
        p.h(parcel, "parcel");
        parcel.writeInt(this.BPI.size());
        for (byte[] bArr : this.BPI) {
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        }
        AppMethodBeat.o(75433);
    }

    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/model/audio/LyricsInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/LyricsInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/recordvideo/model/audio/LyricsInfo;", "plugin-recordvideo_release"})
    public static final class a implements Parcelable.Creator<LyricsInfo> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LyricsInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(75432);
            p.h(parcel, "parcel");
            LyricsInfo lyricsInfo = new LyricsInfo(parcel);
            AppMethodBeat.o(75432);
            return lyricsInfo;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LyricsInfo[] newArray(int i2) {
            return new LyricsInfo[i2];
        }
    }
}
