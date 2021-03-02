package com.bumptech.glide.load.b;

import com.bumptech.glide.g.j;
import com.bumptech.glide.load.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class p<Z> implements v<Z> {
    private a aFB;
    private g aFH;
    final boolean aFI;
    final v<Z> aFJ;
    private final boolean aHL;
    private int aHM;
    private boolean aHN;

    /* access modifiers changed from: package-private */
    public interface a {
        void b(g gVar, p<?> pVar);
    }

    p(v<Z> vVar, boolean z, boolean z2) {
        AppMethodBeat.i(77006);
        this.aFJ = (v) j.checkNotNull(vVar, "Argument must not be null");
        this.aFI = z;
        this.aHL = z2;
        AppMethodBeat.o(77006);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(g gVar, a aVar) {
        this.aFH = gVar;
        this.aFB = aVar;
    }

    @Override // com.bumptech.glide.load.b.v
    public final Class<Z> oV() {
        AppMethodBeat.i(77007);
        Class<Z> oV = this.aFJ.oV();
        AppMethodBeat.o(77007);
        return oV;
    }

    @Override // com.bumptech.glide.load.b.v
    public final Z get() {
        AppMethodBeat.i(77008);
        Z z = this.aFJ.get();
        AppMethodBeat.o(77008);
        return z;
    }

    @Override // com.bumptech.glide.load.b.v
    public final int getSize() {
        AppMethodBeat.i(77009);
        int size = this.aFJ.getSize();
        AppMethodBeat.o(77009);
        return size;
    }

    @Override // com.bumptech.glide.load.b.v
    public final synchronized void recycle() {
        AppMethodBeat.i(77010);
        if (this.aHM > 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot recycle a resource while it is still acquired");
            AppMethodBeat.o(77010);
            throw illegalStateException;
        } else if (this.aHN) {
            IllegalStateException illegalStateException2 = new IllegalStateException("Cannot recycle a resource that has already been recycled");
            AppMethodBeat.o(77010);
            throw illegalStateException2;
        } else {
            this.aHN = true;
            if (this.aHL) {
                this.aFJ.recycle();
            }
            AppMethodBeat.o(77010);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void acquire() {
        AppMethodBeat.i(77011);
        if (this.aHN) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot acquire a recycled resource");
            AppMethodBeat.o(77011);
            throw illegalStateException;
        }
        this.aHM++;
        AppMethodBeat.o(77011);
    }

    /* access modifiers changed from: package-private */
    public final void release() {
        AppMethodBeat.i(77012);
        synchronized (this.aFB) {
            try {
                synchronized (this) {
                    try {
                        if (this.aHM <= 0) {
                            IllegalStateException illegalStateException = new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                            AppMethodBeat.o(77012);
                            throw illegalStateException;
                        }
                        int i2 = this.aHM - 1;
                        this.aHM = i2;
                        if (i2 == 0) {
                            this.aFB.b(this.aFH, this);
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(77012);
                        throw th;
                    }
                }
            } finally {
                AppMethodBeat.o(77012);
            }
        }
    }

    public final synchronized String toString() {
        String str;
        AppMethodBeat.i(77013);
        str = "EngineResource{isCacheable=" + this.aFI + ", listener=" + this.aFB + ", key=" + this.aFH + ", acquired=" + this.aHM + ", isRecycled=" + this.aHN + ", resource=" + this.aFJ + '}';
        AppMethodBeat.o(77013);
        return str;
    }
}
