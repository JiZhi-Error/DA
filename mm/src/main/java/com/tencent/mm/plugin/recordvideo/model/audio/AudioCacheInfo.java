package com.tencent.mm.plugin.recordvideo.model.audio;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.protocal.protobuf.clq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.b.p;

public final class AudioCacheInfo implements Parcelable {
    private static final String BPe = BPe;
    private static final String BPf = BPf;
    private static final String BPg = BPg;
    private static final int BPh = 1;
    private static final int BPi = 2;
    private static final int BPj = 3;
    private static final int BPk = 4;
    private static final int BPl = 5;
    private static final int BPm;
    private static final int BPn = 1;
    public static final a BPo = new a((byte) 0);
    public static final Parcelable.Creator<AudioCacheInfo> CREATOR = new b();
    private static final String TAG = TAG;
    public boolean BNb;
    public clp BOW;
    public int BOX;
    public ArrayList<c> BOY;
    public ArrayList<String> BOZ;
    public boolean BPa;
    public boolean BPb;
    public String BPc;
    public long BPd;
    public boolean aXa;
    public String cachePath;
    public int duration;
    public String musicUrl;
    public int position;
    public int source;
    public int type;

    public AudioCacheInfo() {
        AppMethodBeat.i(75403);
        this.BOW = new clp();
        this.BOZ = new ArrayList<>();
        this.BNb = true;
        this.BPc = "";
        this.position = -1;
        this.BPd = -1;
        AppMethodBeat.o(75403);
    }

    public final void b(clp clp) {
        AppMethodBeat.i(237258);
        p.h(clp, "<set-?>");
        this.BOW = clp;
        AppMethodBeat.o(237258);
    }

    public final void aIa(String str) {
        AppMethodBeat.i(237259);
        p.h(str, "<set-?>");
        this.BPc = str;
        AppMethodBeat.o(237259);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AudioCacheInfo(Parcel parcel) {
        this();
        boolean z;
        p.h(parcel, "parcel");
        AppMethodBeat.i(75404);
        this.BOX = parcel.readInt();
        this.musicUrl = parcel.readString();
        this.cachePath = parcel.readString();
        this.aXa = parcel.readByte() != 0;
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.BPa = z;
        this.position = parcel.readInt();
        this.BPd = parcel.readLong();
        this.type = parcel.readInt();
        String readString = parcel.readString();
        this.BPc = readString == null ? "" : readString;
        try {
            this.BOW.parseFrom(parcel.createByteArray());
            AppMethodBeat.o(75404);
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            AppMethodBeat.o(75404);
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        byte b2 = 1;
        AppMethodBeat.i(75401);
        p.h(parcel, "parcel");
        parcel.writeInt(this.BOX);
        parcel.writeString(this.musicUrl);
        parcel.writeString(this.cachePath);
        parcel.writeByte(this.aXa ? (byte) 1 : 0);
        if (!this.BPa) {
            b2 = 0;
        }
        parcel.writeByte(b2);
        parcel.writeInt(this.position);
        parcel.writeLong(this.BPd);
        parcel.writeInt(this.type);
        parcel.writeString(this.BPc);
        parcel.writeByteArray(this.BOW.toByteArray());
        AppMethodBeat.o(75401);
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        AppMethodBeat.i(75402);
        String str = "AudioCacheInfo(musicId=" + this.BOX + ", musicUrl=" + this.musicUrl + ", lyricsList=" + this.BOY + ", cachePath=" + this.cachePath + ", cached=" + this.aXa + ", failed=" + this.BPa + ", type=" + this.type + ", songName='" + this.BPc + "', position=" + this.position + ", request_id=" + this.BPd + ')';
        AppMethodBeat.o(75402);
        return str;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static AudioCacheInfo a(clp clp, int i2) {
            boolean z = true;
            AppMethodBeat.i(169930);
            p.h(clp, "info");
            AudioCacheInfo audioCacheInfo = new AudioCacheInfo();
            audioCacheInfo.b(clp);
            audioCacheInfo.BOX = clp.MqO;
            audioCacheInfo.musicUrl = clp.MqU;
            ArrayList<c> arrayList = new ArrayList<>();
            LinkedList<clq> linkedList = clp.MqY;
            p.g(linkedList, "info.lyrics");
            for (T t : linkedList) {
                if (!Util.isNullOrNil(t.Mrc)) {
                    String str = t.Mrc;
                    p.g(str, "it.lyrics_content");
                    c cVar = new c(str, t.Mrb, t.Mrb);
                    if (!Util.isNullOrNil(arrayList)) {
                        arrayList.get(arrayList.size() - 1).BPq = t.Mrb;
                    }
                    arrayList.add(cVar);
                }
            }
            if (Util.isNullOrNil(arrayList)) {
                String string = MMApplicationContext.getResources().getString(R.string.f91);
                p.g(string, "MMApplicationContext.get…ring.music_no_lyrics_tip)");
                arrayList.add(new c(string, 0, 0));
            }
            audioCacheInfo.BOZ.addAll(clp.MqX);
            audioCacheInfo.BOY = arrayList;
            com.tencent.mm.plugin.recordvideo.e.c cVar2 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
            String aLO = com.tencent.mm.plugin.recordvideo.e.c.aLO(new StringBuilder().append(clp.MqO).append('_').append(cl.aWz()).toString());
            audioCacheInfo.cachePath = aLO;
            audioCacheInfo.aXa = s.boW(aLO) > 0;
            audioCacheInfo.BPa = false;
            String str2 = clp.MqW;
            p.g(str2, "info.song_name");
            audioCacheInfo.aIa(str2);
            audioCacheInfo.type = i2;
            audioCacheInfo.duration = clp.duration;
            if (clp.Mra != 1) {
                z = false;
            }
            audioCacheInfo.BNb = z;
            Log.i(AudioCacheInfo.TAG, "LogStory: " + audioCacheInfo.BOX + ' ' + audioCacheInfo.BOY);
            AppMethodBeat.o(169930);
            return audioCacheInfo;
        }
    }

    static {
        AppMethodBeat.i(75405);
        AppMethodBeat.o(75405);
    }

    public static final class b implements Parcelable.Creator<AudioCacheInfo> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AudioCacheInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(75398);
            p.h(parcel, "parcel");
            AudioCacheInfo audioCacheInfo = new AudioCacheInfo(parcel);
            AppMethodBeat.o(75398);
            return audioCacheInfo;
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AudioCacheInfo[] newArray(int i2) {
            return new AudioCacheInfo[i2];
        }
    }

    public static final class c {
        public String BPp;
        public int BPq;
        public int dvv;

        public c(String str, int i2, int i3) {
            p.h(str, "lrc");
            AppMethodBeat.i(75400);
            this.BPp = str;
            this.dvv = i2;
            this.BPq = i3;
            AppMethodBeat.o(75400);
        }
    }
}
