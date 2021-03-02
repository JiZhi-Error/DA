package com.tencent.mm.plugin.mmsight.segment.a;

import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.a.a;
import com.tencent.mm.plugin.n.d;
import com.tencent.mm.plugin.n.j;
import com.tencent.mm.plugin.n.k;
import com.tencent.mm.sdk.platformtools.Log;

public final class b implements a {
    boolean ZA = false;
    boolean isStart = false;
    boolean loop = false;
    j zAm = new j(Looper.getMainLooper());
    int zAn;
    int zAo = 0;
    private int zAp = 0;
    a.AbstractC1482a zAq;
    a.d zAr;
    a.b zAs;
    a.c zAt;

    public b() {
        AppMethodBeat.i(107715);
        j jVar = this.zAm;
        if (jVar.zrS != null) {
            k kVar = jVar.zrS;
            if (kVar.zrC != null) {
                kVar.zrC.zrx = false;
            }
        }
        this.zAm.setNeedResetExtractor(false);
        this.zAm.zrT = new d() {
            /* class com.tencent.mm.plugin.mmsight.segment.a.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.n.d
            public final void tf() {
                AppMethodBeat.i(107710);
                if (b.this.zAs != null) {
                    b.this.zAs.dD(b.this.zAm);
                }
                if (b.this.isStart) {
                    b.this.zAm.start();
                }
                b.this.ZA = true;
                AppMethodBeat.o(107710);
            }

            @Override // com.tencent.mm.plugin.n.d
            public final void onCompletion() {
                AppMethodBeat.i(107711);
                if (b.this.loop) {
                    b.this.zAm.QC(b.this.zAo);
                }
                AppMethodBeat.o(107711);
            }

            @Override // com.tencent.mm.plugin.n.d
            public final void onError(int i2, int i3) {
                AppMethodBeat.i(107712);
                if (b.this.zAq != null) {
                    b.this.zAq.hc(i2, i3);
                }
                AppMethodBeat.o(107712);
            }

            @Override // com.tencent.mm.plugin.n.d
            public final void cJH() {
                AppMethodBeat.i(107713);
                Log.i("MicroMsg.MMSegmentVideoPlayer", "onSeekComplete, onSeekCompleteListener: %s", b.this.zAt);
                if (b.this.zAt != null) {
                    b.this.zAt.dE(b.this.zAm);
                    AppMethodBeat.o(107713);
                    return;
                }
                if (b.this.isStart) {
                    b.this.zAm.start();
                }
                AppMethodBeat.o(107713);
            }

            @Override // com.tencent.mm.plugin.n.d
            public final void aa(int i2, int i3, int i4) {
                AppMethodBeat.i(107714);
                b.this.zAn = i4;
                if (b.this.zAr != null) {
                    b.this.zAr.ap(i2, i3, i4);
                }
                AppMethodBeat.o(107714);
            }
        };
        AppMethodBeat.o(107715);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void setSurface(Surface surface) {
        AppMethodBeat.i(107716);
        this.zAm.setSurface(surface);
        AppMethodBeat.o(107716);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void setDataSource(String str) {
        AppMethodBeat.i(107717);
        this.zAm.setPath(str);
        AppMethodBeat.o(107717);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void prepareAsync() {
        AppMethodBeat.i(107718);
        this.zAm.prepare();
        AppMethodBeat.o(107718);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void start() {
        AppMethodBeat.i(107719);
        if (this.ZA) {
            this.zAm.start();
        }
        this.isStart = true;
        AppMethodBeat.o(107719);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void stop() {
        AppMethodBeat.i(107720);
        this.zAm.stop();
        this.isStart = false;
        AppMethodBeat.o(107720);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void pause() {
        AppMethodBeat.i(107721);
        this.zAm.pause();
        AppMethodBeat.o(107721);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final boolean isPlaying() {
        AppMethodBeat.i(107722);
        boolean isPlaying = this.zAm.isPlaying();
        AppMethodBeat.o(107722);
        return isPlaying;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void seekTo(int i2) {
        AppMethodBeat.i(107723);
        if (this.zAm != null) {
            Log.i("MicroMsg.MMSegmentVideoPlayer", "seekTo: %s", Integer.valueOf(i2));
            this.zAm.QC(i2);
        }
        AppMethodBeat.o(107723);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final int getCurrentPosition() {
        AppMethodBeat.i(107724);
        int ejm = this.zAm.ejm();
        AppMethodBeat.o(107724);
        return ejm;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final int getDuration() {
        return (int) this.zAm.zrS.durationMs;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void release() {
        AppMethodBeat.i(107725);
        this.zAm.release();
        AppMethodBeat.o(107725);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void setAudioStreamType(int i2) {
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void setLooping(boolean z) {
        this.loop = z;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void setLoop(int i2, int i3) {
        this.zAo = i2;
        this.zAp = i3;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void a(a.b bVar) {
        this.zAs = bVar;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void a(a.c cVar) {
        this.zAt = cVar;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void a(a.d dVar) {
        this.zAr = dVar;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void a(a.AbstractC1482a aVar) {
        this.zAq = aVar;
    }
}
