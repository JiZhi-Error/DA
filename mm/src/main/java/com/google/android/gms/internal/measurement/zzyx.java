package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzyx implements Iterator {
    private final int limit = this.zzbqz.size();
    private int position = 0;
    private final /* synthetic */ zzyw zzbqz;

    zzyx(zzyw zzyw) {
        this.zzbqz = zzyw;
        AppMethodBeat.i(40338);
        AppMethodBeat.o(40338);
    }

    private final byte nextByte() {
        AppMethodBeat.i(40339);
        try {
            zzyw zzyw = this.zzbqz;
            int i2 = this.position;
            this.position = i2 + 1;
            byte zzae = zzyw.zzae(i2);
            AppMethodBeat.o(40339);
            return zzae;
        } catch (IndexOutOfBoundsException e2) {
            NoSuchElementException noSuchElementException = new NoSuchElementException(e2.getMessage());
            AppMethodBeat.o(40339);
            throw noSuchElementException;
        }
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        AppMethodBeat.i(40341);
        Byte valueOf = Byte.valueOf(nextByte());
        AppMethodBeat.o(40341);
        return valueOf;
    }

    public final void remove() {
        AppMethodBeat.i(40340);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(40340);
        throw unsupportedOperationException;
    }
}
