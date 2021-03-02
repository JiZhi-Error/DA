package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzabb implements Iterator<Object> {
    zzabb() {
    }

    public final boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        AppMethodBeat.i(40180);
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        AppMethodBeat.o(40180);
        throw noSuchElementException;
    }

    public final void remove() {
        AppMethodBeat.i(40181);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(40181);
        throw unsupportedOperationException;
    }
}
