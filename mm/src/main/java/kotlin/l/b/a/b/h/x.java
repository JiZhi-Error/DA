package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class x extends AbstractList<String> implements RandomAccess, o {
    private final o TEm;

    public x(o oVar) {
        this.TEm = oVar;
    }

    public final int size() {
        AppMethodBeat.i(59628);
        int size = this.TEm.size();
        AppMethodBeat.o(59628);
        return size;
    }

    @Override // kotlin.l.b.a.b.h.o
    public final d avC(int i2) {
        AppMethodBeat.i(59629);
        d avC = this.TEm.avC(i2);
        AppMethodBeat.o(59629);
        return avC;
    }

    @Override // kotlin.l.b.a.b.h.o
    public final void f(d dVar) {
        AppMethodBeat.i(59630);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(59630);
        throw unsupportedOperationException;
    }

    @Override // java.util.List, java.util.AbstractList
    public final ListIterator<String> listIterator(final int i2) {
        AppMethodBeat.i(59631);
        AnonymousClass1 r0 = new ListIterator<String>() {
            /* class kotlin.l.b.a.b.h.x.AnonymousClass1 */
            ListIterator<String> cac = x.this.TEm.listIterator(i2);

            {
                AppMethodBeat.i(59614);
                AppMethodBeat.o(59614);
            }

            public final boolean hasNext() {
                AppMethodBeat.i(59615);
                boolean hasNext = this.cac.hasNext();
                AppMethodBeat.o(59615);
                return hasNext;
            }

            public final boolean hasPrevious() {
                AppMethodBeat.i(59616);
                boolean hasPrevious = this.cac.hasPrevious();
                AppMethodBeat.o(59616);
                return hasPrevious;
            }

            public final int nextIndex() {
                AppMethodBeat.i(59617);
                int nextIndex = this.cac.nextIndex();
                AppMethodBeat.o(59617);
                return nextIndex;
            }

            public final int previousIndex() {
                AppMethodBeat.i(59618);
                int previousIndex = this.cac.previousIndex();
                AppMethodBeat.o(59618);
                return previousIndex;
            }

            public final void remove() {
                AppMethodBeat.i(59619);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.o(59619);
                throw unsupportedOperationException;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // java.util.ListIterator
            public final /* synthetic */ void add(String str) {
                AppMethodBeat.i(59620);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.o(59620);
                throw unsupportedOperationException;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // java.util.ListIterator
            public final /* synthetic */ void set(String str) {
                AppMethodBeat.i(59621);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.o(59621);
                throw unsupportedOperationException;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.ListIterator
            public final /* bridge */ /* synthetic */ String previous() {
                AppMethodBeat.i(59622);
                String previous = this.cac.previous();
                AppMethodBeat.o(59622);
                return previous;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.Iterator, java.util.ListIterator
            public final /* bridge */ /* synthetic */ String next() {
                AppMethodBeat.i(59623);
                String next = this.cac.next();
                AppMethodBeat.o(59623);
                return next;
            }
        };
        AppMethodBeat.o(59631);
        return r0;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public final Iterator<String> iterator() {
        AppMethodBeat.i(59632);
        AnonymousClass2 r0 = new Iterator<String>() {
            /* class kotlin.l.b.a.b.h.x.AnonymousClass2 */
            Iterator<String> bWx = x.this.TEm.iterator();

            {
                AppMethodBeat.i(59624);
                AppMethodBeat.o(59624);
            }

            public final boolean hasNext() {
                AppMethodBeat.i(59625);
                boolean hasNext = this.bWx.hasNext();
                AppMethodBeat.o(59625);
                return hasNext;
            }

            public final void remove() {
                AppMethodBeat.i(59626);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.o(59626);
                throw unsupportedOperationException;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.Iterator
            public final /* bridge */ /* synthetic */ String next() {
                AppMethodBeat.i(59627);
                String next = this.bWx.next();
                AppMethodBeat.o(59627);
                return next;
            }
        };
        AppMethodBeat.o(59632);
        return r0;
    }

    @Override // kotlin.l.b.a.b.h.o
    public final List<?> GQ() {
        AppMethodBeat.i(59633);
        List<?> GQ = this.TEm.GQ();
        AppMethodBeat.o(59633);
        return GQ;
    }

    @Override // kotlin.l.b.a.b.h.o
    public final o hJM() {
        return this;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public final /* bridge */ /* synthetic */ String get(int i2) {
        AppMethodBeat.i(59634);
        String str = (String) this.TEm.get(i2);
        AppMethodBeat.o(59634);
        return str;
    }
}
