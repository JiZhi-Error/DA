package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class u<T> implements t.c {
    private final a<? extends T> bFQ;
    public volatile long bFR;
    private final g bhK;
    public final j bxj;
    private volatile boolean isCanceled;
    public volatile T result;
    public final int type = 4;

    public interface a<T> {
        T b(Uri uri, InputStream inputStream);
    }

    public u(g gVar, Uri uri, a<? extends T> aVar) {
        AppMethodBeat.i(196068);
        this.bhK = gVar;
        this.bxj = new j(uri, 1);
        this.bFQ = aVar;
        AppMethodBeat.o(196068);
    }

    @Override // com.google.android.exoplayer2.h.t.c
    public final void vA() {
        this.isCanceled = true;
    }

    @Override // com.google.android.exoplayer2.h.t.c
    public final boolean vB() {
        return this.isCanceled;
    }

    @Override // com.google.android.exoplayer2.h.t.c
    public final void vC() {
        AppMethodBeat.i(93101);
        i iVar = new i(this.bhK, this.bxj);
        try {
            iVar.wH();
            this.result = (T) this.bFQ.b(this.bhK.getUri(), iVar);
        } finally {
            this.bFR = iVar.bEN;
            x.closeQuietly(iVar);
            AppMethodBeat.o(93101);
        }
    }
}
