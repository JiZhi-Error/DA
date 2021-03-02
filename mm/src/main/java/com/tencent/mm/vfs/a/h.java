package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class h<T> implements Iterable<T> {
    private final Iterable<? extends T> ReP;
    private final a<T> ReZ;

    public interface a<T> {
        void hen();
    }

    public h(Iterable<? extends T> iterable, a<T> aVar) {
        this.ReP = iterable;
        this.ReZ = aVar;
    }

    @Override // java.lang.Iterable
    public final Iterator<T> iterator() {
        AppMethodBeat.i(187782);
        i iVar = new i(this.ReP.iterator(), this.ReZ);
        AppMethodBeat.o(187782);
        return iVar;
    }
}
