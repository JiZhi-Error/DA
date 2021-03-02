package com.bumptech.glide.load.d.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

/* access modifiers changed from: package-private */
public final class l {
    private static final File aLo = new File("/proc/self/fd");
    private static volatile l aLr;
    private volatile int aLp;
    private volatile boolean aLq = true;

    static {
        AppMethodBeat.i(77410);
        AppMethodBeat.o(77410);
    }

    static l pE() {
        AppMethodBeat.i(77408);
        if (aLr == null) {
            synchronized (l.class) {
                try {
                    if (aLr == null) {
                        aLr = new l();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(77408);
                    throw th;
                }
            }
        }
        l lVar = aLr;
        AppMethodBeat.o(77408);
        return lVar;
    }

    private l() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean pF() {
        boolean z;
        boolean z2 = false;
        synchronized (this) {
            AppMethodBeat.i(77409);
            int i2 = this.aLp + 1;
            this.aLp = i2;
            if (i2 >= 50) {
                this.aLp = 0;
                int length = aLo.list().length;
                if (length < 700) {
                    z2 = true;
                }
                this.aLq = z2;
                if (!this.aLq && Log.isLoggable("Downsampler", 5)) {
                    new StringBuilder("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ").append(length).append(", limit 700");
                }
            }
            z = this.aLq;
            AppMethodBeat.o(77409);
        }
        return z;
    }
}
