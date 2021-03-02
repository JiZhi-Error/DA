package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.c.c;
import com.google.android.exoplayer2.h.r;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.vfs.s;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

public final class i {
    private static final i BPK = new i();
    public static final a BPL = new a((byte) 0);
    private final Map<Integer, b> BPJ = Collections.synchronizedMap(new HashMap());
    private final String TAG = "MicroMsg.StoryAudioManager";

    public static final class b extends q implements m<Boolean, String, x> {
        final /* synthetic */ i BPM;
        final /* synthetic */ AudioCacheInfo BPN;
        final /* synthetic */ m nzd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(i iVar, m mVar, AudioCacheInfo audioCacheInfo) {
            super(2);
            this.BPM = iVar;
            this.nzd = mVar;
            this.BPN = audioCacheInfo;
        }

        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, String str) {
            AppMethodBeat.i(75439);
            boolean booleanValue = bool.booleanValue();
            String str2 = str;
            Log.i(this.BPM.TAG, "cacheAudio callback " + booleanValue + ", " + (this.nzd == null));
            this.BPM.BPJ.remove(Integer.valueOf(this.BPN.BOX));
            m mVar = this.nzd;
            if (mVar != null) {
                mVar.invoke(Boolean.valueOf(booleanValue), str2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(75439);
            return xVar;
        }
    }

    public i() {
        AppMethodBeat.i(75445);
        AppMethodBeat.o(75445);
    }

    public final void a(AudioCacheInfo audioCacheInfo, m<? super Boolean, ? super String, x> mVar) {
        AppMethodBeat.i(75440);
        p.h(audioCacheInfo, "info");
        a((com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>) null, audioCacheInfo, mVar);
        AppMethodBeat.o(75440);
    }

    public static /* synthetic */ void a(i iVar, Context context, AudioCacheInfo audioCacheInfo) {
        AppMethodBeat.i(75442);
        iVar.a(context, audioCacheInfo, (m<? super Boolean, ? super String, x>) null);
        AppMethodBeat.o(75442);
    }

    public final void a(Context context, AudioCacheInfo audioCacheInfo, m<? super Boolean, ? super String, x> mVar) {
        AppMethodBeat.i(75441);
        p.h(context, "context");
        p.h(audioCacheInfo, "info");
        Log.i(this.TAG, "cacheAudio: " + context + ", " + (mVar == null));
        if (context instanceof MMFragmentActivity) {
            a((com.tencent.mm.vending.e.b) context, audioCacheInfo, mVar);
            AppMethodBeat.o(75441);
            return;
        }
        Log.w(this.TAG, "context is not LifeCycle: ".concat(String.valueOf(context)));
        a((com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>) null, audioCacheInfo, mVar);
        AppMethodBeat.o(75441);
    }

    private void a(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> bVar, AudioCacheInfo audioCacheInfo, m<? super Boolean, ? super String, x> mVar) {
        AppMethodBeat.i(75443);
        p.h(audioCacheInfo, "info");
        Log.i(this.TAG, "cache audio " + audioCacheInfo.BOX);
        b bVar2 = this.BPJ.get(Integer.valueOf(audioCacheInfo.BOX));
        if (bVar2 != null) {
            bVar2.h(mVar);
            AppMethodBeat.o(75443);
        } else if (!s.YS(audioCacheInfo.cachePath)) {
            b bVar3 = new b(bVar, audioCacheInfo);
            bVar3.h(new b(this, mVar, audioCacheInfo));
            bVar3.start();
            Map<Integer, b> map = this.BPJ;
            p.g(map, "audioTaskMap");
            map.put(Integer.valueOf(audioCacheInfo.BOX), bVar3);
            AppMethodBeat.o(75443);
        } else {
            Log.i(this.TAG, "cacheAudio is exist " + audioCacheInfo.cachePath);
            if (mVar != null) {
                mVar.invoke(Boolean.TRUE, audioCacheInfo.cachePath);
                AppMethodBeat.o(75443);
                return;
            }
            AppMethodBeat.o(75443);
        }
    }

    public final void c(AudioCacheInfo audioCacheInfo) {
        b remove;
        AppMethodBeat.i(75444);
        if (audioCacheInfo == null || (remove = this.BPJ.remove(Integer.valueOf(audioCacheInfo.BOX))) == null) {
            AppMethodBeat.o(75444);
            return;
        }
        remove.cancel();
        AppMethodBeat.o(75444);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static k a(AudioCacheInfo audioCacheInfo, String str) {
            AppMethodBeat.i(75438);
            p.h(audioCacheInfo, "cacheInfo");
            p.h(str, "userAgent");
            if (audioCacheInfo.aXa) {
                h hVar = new h(Uri.parse(s.k(audioCacheInfo.cachePath, false)), new r(), new c(), null, null);
                AppMethodBeat.o(75438);
                return hVar;
            }
            h hVar2 = new h(Uri.parse(audioCacheInfo.musicUrl), new com.google.android.exoplayer2.h.p(str), new c(), null, null);
            AppMethodBeat.o(75438);
            return hVar2;
        }
    }

    static {
        AppMethodBeat.i(75446);
        AppMethodBeat.o(75446);
    }
}
