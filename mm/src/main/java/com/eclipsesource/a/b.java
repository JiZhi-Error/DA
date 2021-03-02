package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b extends h implements Iterable<h> {
    public final List<h> aIq = new ArrayList();

    public b() {
        AppMethodBeat.i(74687);
        AppMethodBeat.o(74687);
    }

    public final b dB(int i2) {
        AppMethodBeat.i(74688);
        this.aIq.add(a.dA(i2));
        AppMethodBeat.o(74688);
        return this;
    }

    public final b t(long j2) {
        AppMethodBeat.i(74689);
        this.aIq.add(a.s(j2));
        AppMethodBeat.o(74689);
        return this;
    }

    public final b ac(float f2) {
        AppMethodBeat.i(74690);
        this.aIq.add(a.ab(f2));
        AppMethodBeat.o(74690);
        return this;
    }

    public final b e(double d2) {
        AppMethodBeat.i(74691);
        this.aIq.add(a.d(d2));
        AppMethodBeat.o(74691);
        return this;
    }

    public final b aM(boolean z) {
        AppMethodBeat.i(74692);
        this.aIq.add(a.aL(z));
        AppMethodBeat.o(74692);
        return this;
    }

    public final b aT(String str) {
        AppMethodBeat.i(74693);
        this.aIq.add(a.aQ(str));
        AppMethodBeat.o(74693);
        return this;
    }

    public final b a(h hVar) {
        AppMethodBeat.i(74694);
        if (hVar == null) {
            NullPointerException nullPointerException = new NullPointerException("value is null");
            AppMethodBeat.o(74694);
            throw nullPointerException;
        }
        this.aIq.add(hVar);
        AppMethodBeat.o(74694);
        return this;
    }

    public final b aV(int i2, int i3) {
        AppMethodBeat.i(74695);
        this.aIq.set(i2, a.dA(i3));
        AppMethodBeat.o(74695);
        return this;
    }

    public final b f(int i2, long j2) {
        AppMethodBeat.i(74696);
        this.aIq.set(i2, a.s(j2));
        AppMethodBeat.o(74696);
        return this;
    }

    public final b a(int i2, double d2) {
        AppMethodBeat.i(74697);
        this.aIq.set(i2, a.d(d2));
        AppMethodBeat.o(74697);
        return this;
    }

    public final b n(int i2, boolean z) {
        AppMethodBeat.i(74698);
        this.aIq.set(i2, a.aL(z));
        AppMethodBeat.o(74698);
        return this;
    }

    public final b a(int i2, h hVar) {
        AppMethodBeat.i(74699);
        if (hVar == null) {
            NullPointerException nullPointerException = new NullPointerException("value is null");
            AppMethodBeat.o(74699);
            throw nullPointerException;
        }
        this.aIq.set(i2, hVar);
        AppMethodBeat.o(74699);
        return this;
    }

    public final h dC(int i2) {
        AppMethodBeat.i(74700);
        h hVar = this.aIq.get(i2);
        AppMethodBeat.o(74700);
        return hVar;
    }

    @Override // java.lang.Iterable
    public final Iterator<h> iterator() {
        AppMethodBeat.i(74701);
        final Iterator<h> it = this.aIq.iterator();
        AnonymousClass1 r1 = new Iterator<h>() {
            /* class com.eclipsesource.a.b.AnonymousClass1 */

            public final boolean hasNext() {
                AppMethodBeat.i(74684);
                boolean hasNext = it.hasNext();
                AppMethodBeat.o(74684);
                return hasNext;
            }

            public final void remove() {
                AppMethodBeat.i(74685);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.o(74685);
                throw unsupportedOperationException;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.Iterator
            public final /* bridge */ /* synthetic */ h next() {
                AppMethodBeat.i(74686);
                h hVar = (h) it.next();
                AppMethodBeat.o(74686);
                return hVar;
            }
        };
        AppMethodBeat.o(74701);
        return r1;
    }

    /* access modifiers changed from: package-private */
    @Override // com.eclipsesource.a.h
    public final void a(i iVar) {
        AppMethodBeat.i(74702);
        iVar.sH();
        Iterator<h> it = iterator();
        boolean z = true;
        while (it.hasNext()) {
            if (!z) {
                iVar.sJ();
            }
            it.next().a(iVar);
            z = false;
        }
        iVar.sI();
        AppMethodBeat.o(74702);
    }

    @Override // com.eclipsesource.a.h
    public final boolean isArray() {
        return true;
    }

    @Override // com.eclipsesource.a.h
    public final b sd() {
        return this;
    }

    @Override // com.eclipsesource.a.h
    public final int hashCode() {
        AppMethodBeat.i(74703);
        int hashCode = this.aIq.hashCode();
        AppMethodBeat.o(74703);
        return hashCode;
    }

    @Override // com.eclipsesource.a.h
    public final boolean equals(Object obj) {
        AppMethodBeat.i(74704);
        if (this == obj) {
            AppMethodBeat.o(74704);
            return true;
        } else if (obj == null) {
            AppMethodBeat.o(74704);
            return false;
        } else if (getClass() != obj.getClass()) {
            AppMethodBeat.o(74704);
            return false;
        } else {
            boolean equals = this.aIq.equals(((b) obj).aIq);
            AppMethodBeat.o(74704);
            return equals;
        }
    }
}
