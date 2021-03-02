package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
public final class zzxg extends WeakReference<Throwable> {
    private final int zzboc;

    public zzxg(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, null);
        AppMethodBeat.i(40331);
        if (th == null) {
            NullPointerException nullPointerException = new NullPointerException("The referent cannot be null");
            AppMethodBeat.o(40331);
            throw nullPointerException;
        }
        this.zzboc = System.identityHashCode(th);
        AppMethodBeat.o(40331);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(40332);
        if (obj == null || obj.getClass() != getClass()) {
            AppMethodBeat.o(40332);
            return false;
        } else if (this == obj) {
            AppMethodBeat.o(40332);
            return true;
        } else {
            zzxg zzxg = (zzxg) obj;
            if (this.zzboc == zzxg.zzboc && get() == zzxg.get()) {
                AppMethodBeat.o(40332);
                return true;
            }
            AppMethodBeat.o(40332);
            return false;
        }
    }

    public final int hashCode() {
        return this.zzboc;
    }
}
