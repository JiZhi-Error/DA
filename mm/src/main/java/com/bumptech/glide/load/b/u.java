package com.bumptech.glide.load.b;

import android.support.v4.e.l;
import com.bumptech.glide.g.a.a;
import com.bumptech.glide.g.a.b;
import com.bumptech.glide.g.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class u<Z> implements a.c, v<Z> {
    private static final l.a<u<?>> aHW = a.a(20, new a.AbstractC0066a<u<?>>() {
        /* class com.bumptech.glide.load.b.u.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.bumptech.glide.g.a.a.AbstractC0066a
        public final /* synthetic */ u<?> oR() {
            AppMethodBeat.i(77037);
            u uVar = new u();
            AppMethodBeat.o(77037);
            return uVar;
        }
    });
    private final b aGi = new b.a();
    private boolean aHN;
    private v<Z> aHX;
    private boolean aHY;

    static {
        AppMethodBeat.i(77045);
        AppMethodBeat.o(77045);
    }

    static <Z> u<Z> d(v<Z> vVar) {
        AppMethodBeat.i(77038);
        u<Z> uVar = (u) j.checkNotNull(aHW.acquire(), "Argument must not be null");
        ((u) uVar).aHN = false;
        ((u) uVar).aHY = true;
        ((u) uVar).aHX = vVar;
        AppMethodBeat.o(77038);
        return uVar;
    }

    u() {
        AppMethodBeat.i(77039);
        AppMethodBeat.o(77039);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void unlock() {
        AppMethodBeat.i(77040);
        this.aGi.qz();
        if (!this.aHY) {
            IllegalStateException illegalStateException = new IllegalStateException("Already unlocked");
            AppMethodBeat.o(77040);
            throw illegalStateException;
        }
        this.aHY = false;
        if (this.aHN) {
            recycle();
        }
        AppMethodBeat.o(77040);
    }

    @Override // com.bumptech.glide.load.b.v
    public final Class<Z> oV() {
        AppMethodBeat.i(77041);
        Class<Z> oV = this.aHX.oV();
        AppMethodBeat.o(77041);
        return oV;
    }

    @Override // com.bumptech.glide.load.b.v
    public final Z get() {
        AppMethodBeat.i(77042);
        Z z = this.aHX.get();
        AppMethodBeat.o(77042);
        return z;
    }

    @Override // com.bumptech.glide.load.b.v
    public final int getSize() {
        AppMethodBeat.i(77043);
        int size = this.aHX.getSize();
        AppMethodBeat.o(77043);
        return size;
    }

    @Override // com.bumptech.glide.load.b.v
    public final synchronized void recycle() {
        AppMethodBeat.i(77044);
        this.aGi.qz();
        this.aHN = true;
        if (!this.aHY) {
            this.aHX.recycle();
            this.aHX = null;
            aHW.release(this);
        }
        AppMethodBeat.o(77044);
    }

    @Override // com.bumptech.glide.g.a.a.c
    public final b oK() {
        return this.aGi;
    }
}
