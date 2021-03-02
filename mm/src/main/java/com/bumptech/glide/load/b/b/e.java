package com.bumptech.glide.load.b.b;

import android.util.Log;
import com.bumptech.glide.a.a;
import com.bumptech.glide.load.b.b.a;
import com.bumptech.glide.load.b.b.c;
import com.bumptech.glide.load.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

public final class e implements a {
    private final j aIW;
    private final c aIX = new c();
    private a aIY;
    private final File directory;
    private final long maxSize;

    @Deprecated
    e(File file, long j2) {
        AppMethodBeat.i(77150);
        this.directory = file;
        this.maxSize = j2;
        this.aIW = new j();
        AppMethodBeat.o(77150);
    }

    private synchronized a pi() {
        a aVar;
        AppMethodBeat.i(77151);
        if (this.aIY == null) {
            this.aIY = a.b(this.directory, this.maxSize);
        }
        aVar = this.aIY;
        AppMethodBeat.o(77151);
        return aVar;
    }

    @Override // com.bumptech.glide.load.b.b.a
    public final File c(g gVar) {
        AppMethodBeat.i(77152);
        String e2 = this.aIW.e(gVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            new StringBuilder("Get: Obtained: ").append(e2).append(" for for Key: ").append(gVar);
        }
        File file = null;
        try {
            a.d O = pi().O(e2);
            if (O != null) {
                file = O.aDU[0];
            }
        } catch (IOException e3) {
            Log.isLoggable("DiskLruCacheWrapper", 5);
        }
        AppMethodBeat.o(77152);
        return file;
    }

    @Override // com.bumptech.glide.load.b.b.a
    public final void a(g gVar, a.b bVar) {
        c.a aVar;
        AppMethodBeat.i(77153);
        String e2 = this.aIW.e(gVar);
        c cVar = this.aIX;
        synchronized (cVar) {
            try {
                aVar = cVar.aIP.get(e2);
                if (aVar == null) {
                    aVar = cVar.aIQ.pg();
                    cVar.aIP.put(e2, aVar);
                }
                aVar.aIS++;
            } catch (Throwable th) {
                AppMethodBeat.o(77153);
                throw th;
            }
        }
        aVar.aIR.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                new StringBuilder("Put: Obtained: ").append(e2).append(" for for Key: ").append(gVar);
            }
            try {
                com.bumptech.glide.a.a pi = pi();
                if (pi.O(e2) == null) {
                    a.b P = pi.P(e2);
                    if (P == null) {
                        IllegalStateException illegalStateException = new IllegalStateException("Had two simultaneous puts for: ".concat(String.valueOf(e2)));
                        AppMethodBeat.o(77153);
                        throw illegalStateException;
                    }
                    try {
                        if (bVar.s(P.ob())) {
                            com.bumptech.glide.a.a.a(com.bumptech.glide.a.a.this, P, true);
                            P.aDO = true;
                        }
                        P.oc();
                        this.aIX.release(e2);
                        AppMethodBeat.o(77153);
                    } catch (Throwable th2) {
                        P.oc();
                        AppMethodBeat.o(77153);
                        throw th2;
                    }
                }
            } catch (IOException e3) {
                Log.isLoggable("DiskLruCacheWrapper", 5);
            }
        } finally {
            this.aIX.release(e2);
            AppMethodBeat.o(77153);
        }
    }
}
