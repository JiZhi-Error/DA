package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

/* access modifiers changed from: package-private */
public final class zzes implements Iterator<String> {
    private Iterator<String> zzafz = this.zzaga.zzafy.keySet().iterator();
    private final /* synthetic */ zzer zzaga;

    zzes(zzer zzer) {
        this.zzaga = zzer;
        AppMethodBeat.i(1263);
        AppMethodBeat.o(1263);
    }

    public final boolean hasNext() {
        AppMethodBeat.i(1264);
        boolean hasNext = this.zzafz.hasNext();
        AppMethodBeat.o(1264);
        return hasNext;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        AppMethodBeat.i(1266);
        String next = this.zzafz.next();
        AppMethodBeat.o(1266);
        return next;
    }

    public final void remove() {
        AppMethodBeat.i(1265);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Remove not supported");
        AppMethodBeat.o(1265);
        throw unsupportedOperationException;
    }
}
