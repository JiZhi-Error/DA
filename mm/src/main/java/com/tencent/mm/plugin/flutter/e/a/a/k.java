package com.tencent.mm.plugin.flutter.e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.flutter.e.a.a.o;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.clk;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.protocal.protobuf.clq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;

public final class k {
    private static k wKr;
    public static final a wKs = new a((byte) 0);
    public final String TAG;
    public final String vRb;
    private int wKo;
    public long wKp;
    public long wKq;

    static {
        AppMethodBeat.i(241094);
        AppMethodBeat.o(241094);
    }

    public static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ k wKt;
        final /* synthetic */ String wKu;

        public b(k kVar, String str) {
            this.wKt = kVar;
            this.wKu = str;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(241093);
            c.a aVar = (c.a) obj;
            int i2 = aVar.errType;
            int i3 = aVar.errCode;
            Log.i(this.wKt.TAG, "SearchdMusic callback " + i2 + ' ' + i3 + ", " + aVar.errMsg);
            if (i2 == 0 && i3 == 0) {
                h.INSTANCE.dN(1565, 8);
                Log.i(this.wKt.vRb, "search music success");
                clk clk = (clk) aVar.iLC;
                this.wKt.wKp = clk.BPd;
                this.wKt.wKo++;
                LinkedList<clp> linkedList = clk.MqJ;
                k kVar = this.wKt;
                p.g(linkedList, "audioList");
                k.a(kVar, linkedList);
                c.a aVar2 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
                com.tencent.mm.plugin.recordvideo.model.audio.c.BPC.tj(this.wKt.wKp);
                c.a aVar3 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
                com.tencent.mm.plugin.recordvideo.model.audio.c.BPC.xE(this.wKu);
                Log.i(this.wKt.TAG, "get audio list ".concat(String.valueOf(clk)));
                Void r0 = com.tencent.mm.vending.c.a.QZL;
                AppMethodBeat.o(241093);
                return r0;
            }
            h.INSTANCE.dN(1565, 9);
            Log.i(this.wKt.vRb, "search music fail");
            Void r02 = com.tencent.mm.vending.c.a.QZL;
            AppMethodBeat.o(241093);
            return r02;
        }
    }

    public /* synthetic */ k(byte b2) {
        this();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private k() {
        this.TAG = "MMVideoEditorMusicSearch";
        this.vRb = "MMVideoEditorMusicSearch.FlutterVideoEditor_DataReport";
    }

    public static final /* synthetic */ void a(k kVar, List list) {
        AppMethodBeat.i(241095);
        Log.i(kVar.TAG, "music search size " + list.size());
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            clp clp = (clp) it.next();
            AudioCacheInfo.a aVar = AudioCacheInfo.BPo;
            AudioCacheInfo.a aVar2 = AudioCacheInfo.BPo;
            AudioCacheInfo a2 = AudioCacheInfo.a.a(clp, AudioCacheInfo.BPj);
            AudioCacheInfo.a aVar3 = AudioCacheInfo.BPo;
            a2.source = AudioCacheInfo.BPn;
            HashMap hashMap = new HashMap();
            hashMap.put("musicUrl", clp.MqU);
            hashMap.put("songName", clp.MqW);
            hashMap.put("playUrl", clp.iAz);
            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(clp.duration));
            hashMap.put("cached", Boolean.valueOf(a2.aXa));
            hashMap.put("musicId", Integer.valueOf(a2.BOX));
            String str = a2.cachePath;
            if (str != null) {
                hashMap.put("cachePath", str);
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it2 = clp.MqX.iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next());
            }
            hashMap.put("singers", arrayList2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<clq> it3 = clp.MqY.iterator();
            while (it3.hasNext()) {
                clq next = it3.next();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("lrcContent", next.Mrc);
                hashMap2.put("startPlayTime", Integer.valueOf(next.Mrb));
                arrayList3.add(hashMap2);
            }
            hashMap.put("lrcInfoList", arrayList3);
            arrayList.add(hashMap);
        }
        o.a aVar4 = o.wKI;
        o.a.dMh().t("onMusicSearchCompleted", arrayList);
        AppMethodBeat.o(241095);
    }
}
