package com.tencent.mm.plugin.cdndownloader.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class a<E> extends HashSet<E> {
    private b qmO;

    public a(b bVar) {
        this.qmO = bVar;
    }

    private synchronized void cyd() {
        AppMethodBeat.i(120764);
        this.qmO.cyc();
        AppMethodBeat.o(120764);
    }

    private synchronized void cye() {
        AppMethodBeat.i(120765);
        this.qmO.remove();
        AppMethodBeat.o(120765);
    }

    private synchronized void cyf() {
        AppMethodBeat.i(120766);
        this.qmO.clear();
        AppMethodBeat.o(120766);
    }

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final synchronized boolean add(E e2) {
        boolean add;
        AppMethodBeat.i(120767);
        add = super.add(e2);
        cyd();
        AppMethodBeat.o(120767);
        return add;
    }

    public final void clear() {
        AppMethodBeat.i(120768);
        super.clear();
        cyf();
        AppMethodBeat.o(120768);
    }

    public final synchronized boolean remove(Object obj) {
        boolean remove;
        AppMethodBeat.i(120769);
        remove = super.remove(obj);
        cye();
        AppMethodBeat.o(120769);
        return remove;
    }
}
