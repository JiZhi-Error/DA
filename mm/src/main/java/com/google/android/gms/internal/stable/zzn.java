package com.google.android.gms.internal.stable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
public final class zzn extends WeakReference<Throwable> {
    private final int zzahl;

    public zzn(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        AppMethodBeat.i(5519);
        if (th == null) {
            NullPointerException nullPointerException = new NullPointerException("The referent cannot be null");
            AppMethodBeat.o(5519);
            throw nullPointerException;
        }
        this.zzahl = System.identityHashCode(th);
        AppMethodBeat.o(5519);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(5520);
        if (obj == null || obj.getClass() != getClass()) {
            AppMethodBeat.o(5520);
            return false;
        } else if (this == obj) {
            AppMethodBeat.o(5520);
            return true;
        } else {
            zzn zzn = (zzn) obj;
            if (this.zzahl == zzn.zzahl && get() == zzn.get()) {
                AppMethodBeat.o(5520);
                return true;
            }
            AppMethodBeat.o(5520);
            return false;
        }
    }

    public final int hashCode() {
        return this.zzahl;
    }
}
