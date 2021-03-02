package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class h implements g.c, k {
    private final w.a bci;
    private k.a bvB;
    private final int bvE;
    private final a bvF;
    private final String bvI;
    private final g.a bwl;
    private final com.google.android.exoplayer2.c.h bwm;
    private final int bwn;
    private long bwo;
    private boolean bwp;
    private final Handler eventHandler;
    private final Uri uri;

    public interface a {
        void onLoadError(IOException iOException);
    }

    public h(Uri uri2, g.a aVar, com.google.android.exoplayer2.c.h hVar, Handler handler, a aVar2) {
        this(uri2, aVar, hVar, handler, aVar2, null);
    }

    public h(Uri uri2, g.a aVar, com.google.android.exoplayer2.c.h hVar, Handler handler, a aVar2, String str) {
        this(uri2, aVar, hVar, handler, aVar2, str, (byte) 0);
    }

    private h(Uri uri2, g.a aVar, com.google.android.exoplayer2.c.h hVar, Handler handler, a aVar2, String str, byte b2) {
        AppMethodBeat.i(196043);
        this.uri = uri2;
        this.bwl = aVar;
        this.bwm = hVar;
        this.bvE = -1;
        this.eventHandler = handler;
        this.bvF = aVar2;
        this.bvI = str;
        this.bwn = 1048576;
        this.bci = new w.a();
        AppMethodBeat.o(196043);
    }

    @Override // com.google.android.exoplayer2.source.k
    public final void a(f fVar, k.a aVar) {
        AppMethodBeat.i(92673);
        this.bvB = aVar;
        e(-9223372036854775807L, false);
        AppMethodBeat.o(92673);
    }

    @Override // com.google.android.exoplayer2.source.k
    public final void vt() {
    }

    @Override // com.google.android.exoplayer2.source.k
    public final j a(k.b bVar, b bVar2) {
        AppMethodBeat.i(92674);
        com.google.android.exoplayer2.i.a.checkArgument(bVar.bwx == 0);
        g gVar = new g(this.uri, this.bwl.wG(), this.bwm.ux(), this.bvE, this.eventHandler, this.bvF, this, bVar2, this.bvI, this.bwn);
        AppMethodBeat.o(92674);
        return gVar;
    }

    @Override // com.google.android.exoplayer2.source.k
    public final void b(j jVar) {
        AppMethodBeat.i(92675);
        g gVar = (g) jVar;
        boolean a2 = gVar.bvK.a(gVar);
        if (gVar.bcY && !a2) {
            for (m mVar : gVar.bvQ) {
                mVar.vL();
            }
        }
        gVar.handler.removeCallbacksAndMessages(null);
        gVar.released = true;
        AppMethodBeat.o(92675);
    }

    @Override // com.google.android.exoplayer2.source.k
    public final void vu() {
        this.bvB = null;
    }

    @Override // com.google.android.exoplayer2.source.g.c
    public final void d(long j2, boolean z) {
        AppMethodBeat.i(92676);
        if (j2 == -9223372036854775807L) {
            j2 = this.bwo;
        }
        if (!(this.bwo == j2 && this.bwp == z) && (this.bwo == -9223372036854775807L || j2 != -9223372036854775807L)) {
            e(j2, z);
            AppMethodBeat.o(92676);
            return;
        }
        AppMethodBeat.o(92676);
    }

    private void e(long j2, boolean z) {
        AppMethodBeat.i(92677);
        this.bwo = j2;
        this.bwp = z;
        this.bvB.a(new p(this.bwo, this.bwp), null);
        AppMethodBeat.o(92677);
    }
}
