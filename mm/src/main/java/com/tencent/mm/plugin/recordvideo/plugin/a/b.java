package com.tencent.mm.plugin.recordvideo.plugin.a;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.c;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.v;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.jf;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.c;
import com.tencent.mm.plugin.recordvideo.model.audio.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0014\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u0010J\u0006\u0010\u0016\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bandwidthMeter", "Lcom/google/android/exoplayer2/upstream/DefaultBandwidthMeter;", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "trackSelector", "Lcom/google/android/exoplayer2/trackselection/DefaultTrackSelector;", "userAgent", "", "videoTrackSelectionFactory", "Lcom/google/android/exoplayer2/trackselection/AdaptiveTrackSelection$Factory;", "pauseAudio", "", "playAudio", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "release", "resetAudio", "resumeAudio", "seekTo", "timeMs", "", "Companion", "plugin-recordvideo_release"})
public final class b {
    public static final a BTK = new a((byte) 0);
    private final c Ajk = new c(this.BTJ);
    private final com.google.android.exoplayer2.h.l Ajl = new com.google.android.exoplayer2.h.l();
    private v BTI;
    private final a.C0111a BTJ = new a.C0111a(this.Ajl);
    private final String userAgent;

    static {
        AppMethodBeat.i(75760);
        AppMethodBeat.o(75760);
    }

    public b(final Context context) {
        p.h(context, "context");
        AppMethodBeat.i(75759);
        String h2 = x.h(context, context.getString(R.string.wx));
        if (h2 == null) {
            p.hyc();
        }
        this.userAgent = h2;
        h.RTc.aZ(new Runnable(this) {
            /* class com.tencent.mm.plugin.recordvideo.plugin.a.b.AnonymousClass1 */
            final /* synthetic */ b BTL;

            {
                this.BTL = r1;
            }

            public final void run() {
                AppMethodBeat.i(237401);
                this.BTL.BTI = g.a(context, this.BTL.Ajk);
                v vVar = this.BTL.BTI;
                if (vVar != null) {
                    vVar.setRepeatMode(2);
                    AppMethodBeat.o(237401);
                    return;
                }
                AppMethodBeat.o(237401);
            }
        });
        AppMethodBeat.o(75759);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final v d(AudioCacheInfo audioCacheInfo) {
        long j2;
        AppMethodBeat.i(237402);
        pauseAudio();
        if (audioCacheInfo != null) {
            Log.i("MicroMsg.EditMusicController", "play music: " + audioCacheInfo.musicUrl);
            if ((!audioCacheInfo.aXa || !TextUtils.isEmpty(audioCacheInfo.cachePath)) && (audioCacheInfo.aXa || !TextUtils.isEmpty(audioCacheInfo.musicUrl))) {
                v vVar = this.BTI;
                if (vVar != null) {
                    vVar.aO(true);
                }
                i.a aVar = i.BPL;
                k a2 = i.a.a(audioCacheInfo, this.userAgent);
                v vVar2 = this.BTI;
                if (vVar2 != null) {
                    vVar2.a(a2);
                }
                com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.eKX().wD(String.valueOf(audioCacheInfo.BOX));
                com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                jf eKX = com.tencent.mm.plugin.recordvideo.d.c.eKX();
                int i2 = audioCacheInfo.source;
                AudioCacheInfo.a aVar2 = AudioCacheInfo.BPo;
                if (i2 == AudioCacheInfo.BPn) {
                    j2 = 0;
                } else {
                    j2 = (long) (audioCacheInfo.position + 1);
                }
                eKX.rD(j2);
                com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.eKX().rE(audioCacheInfo.BPd);
                com.tencent.mm.plugin.recordvideo.d.c cVar4 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.eKY().sH(1);
                c.a aVar3 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
                com.tencent.mm.plugin.recordvideo.model.audio.c cVar5 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPz;
                if (cVar5 != null) {
                    cVar5.hV(audioCacheInfo.BOX, audioCacheInfo.source);
                }
                v vVar3 = this.BTI;
                AppMethodBeat.o(237402);
                return vVar3;
            }
            AppMethodBeat.o(237402);
            return null;
        }
        AppMethodBeat.o(237402);
        return null;
    }

    public final void seekTo(long j2) {
        AppMethodBeat.i(237403);
        v vVar = this.BTI;
        if (vVar != null) {
            vVar.seekTo(j2);
            AppMethodBeat.o(237403);
            return;
        }
        AppMethodBeat.o(237403);
    }

    public final void eKQ() {
        AppMethodBeat.i(237404);
        v vVar = this.BTI;
        if (vVar != null) {
            vVar.a((k) null);
            AppMethodBeat.o(237404);
            return;
        }
        AppMethodBeat.o(237404);
    }

    public final void pauseAudio() {
        AppMethodBeat.i(75758);
        Log.i("MicroMsg.EditMusicController", "pause music");
        com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.eKX().wD("");
        com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.eKX().rD(0);
        com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.eKX().rE(0);
        com.tencent.mm.plugin.recordvideo.d.c cVar4 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.eKY().sH(0);
        c.a aVar = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
        com.tencent.mm.plugin.recordvideo.model.audio.c cVar5 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPz;
        if (cVar5 != null) {
            cVar5.eKd();
        }
        v vVar = this.BTI;
        if (vVar != null) {
            vVar.aO(false);
            AppMethodBeat.o(75758);
            return;
        }
        AppMethodBeat.o(75758);
    }

    public final void eKR() {
        AppMethodBeat.i(237405);
        v vVar = this.BTI;
        if (vVar != null) {
            vVar.aO(true);
            AppMethodBeat.o(237405);
            return;
        }
        AppMethodBeat.o(237405);
    }

    public final void release() {
        AppMethodBeat.i(237406);
        Log.i("MicroMsg.EditMusicController", "release");
        v vVar = this.BTI;
        if (vVar != null) {
            vVar.stop();
        }
        v vVar2 = this.BTI;
        if (vVar2 != null) {
            vVar2.release();
        }
        this.BTI = null;
        AppMethodBeat.o(237406);
    }
}
