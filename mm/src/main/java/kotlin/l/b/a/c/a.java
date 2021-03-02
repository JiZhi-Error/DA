package kotlin.l.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class a<E> implements Iterable<E> {
    private static final a<Object> TSi = new a<>();
    public final a<E> TSj;
    public final E first;
    public final int size;

    static {
        AppMethodBeat.i(61423);
        AppMethodBeat.o(61423);
    }

    public static <E> a<E> hMa() {
        return (a<E>) TSi;
    }

    private a() {
        this.size = 0;
        this.first = null;
        this.TSj = null;
    }

    private a(E e2, a<E> aVar) {
        AppMethodBeat.i(61415);
        this.first = e2;
        this.TSj = aVar;
        this.size = aVar.size + 1;
        AppMethodBeat.o(61415);
    }

    private E get(int i2) {
        AppMethodBeat.i(61416);
        if (i2 < 0 || i2 > this.size) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(61416);
            throw indexOutOfBoundsException;
        }
        try {
            E next = avN(i2).next();
            AppMethodBeat.o(61416);
            return next;
        } catch (NoSuchElementException e2) {
            IndexOutOfBoundsException indexOutOfBoundsException2 = new IndexOutOfBoundsException("Index: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(61416);
            throw indexOutOfBoundsException2;
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<E> iterator() {
        AppMethodBeat.i(61417);
        Iterator<E> avN = avN(0);
        AppMethodBeat.o(61417);
        return avN;
    }

    private Iterator<E> avN(int i2) {
        AppMethodBeat.i(61418);
        C2368a aVar = new C2368a(avP(i2));
        AppMethodBeat.o(61418);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: kotlin.l.b.a.c.a$a  reason: collision with other inner class name */
    public static class C2368a<E> implements Iterator<E> {
        private a<E> TSk;

        public C2368a(a<E> aVar) {
            this.TSk = aVar;
        }

        public final boolean hasNext() {
            AppMethodBeat.i(61413);
            if (this.TSk.size > 0) {
                AppMethodBeat.o(61413);
                return true;
            }
            AppMethodBeat.o(61413);
            return false;
        }

        @Override // java.util.Iterator
        public final E next() {
            E e2 = this.TSk.first;
            this.TSk = this.TSk.TSj;
            return e2;
        }

        public final void remove() {
            AppMethodBeat.i(61414);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61414);
            throw unsupportedOperationException;
        }
    }

    public final a<E> fK(E e2) {
        AppMethodBeat.i(61419);
        a<E> aVar = new a<>(e2, this);
        AppMethodBeat.o(61419);
        return aVar;
    }

    private a<E> fL(Object obj) {
        AppMethodBeat.i(61420);
        if (this.size == 0) {
            AppMethodBeat.o(61420);
            return this;
        } else if (this.first.equals(obj)) {
            a<E> aVar = this.TSj;
            AppMethodBeat.o(61420);
            return aVar;
        } else {
            a<E> fL = this.TSj.fL(obj);
            if (fL == this.TSj) {
                AppMethodBeat.o(61420);
                return this;
            }
            a<E> aVar2 = new a<>(this.first, fL);
            AppMethodBeat.o(61420);
            return aVar2;
        }
    }

    public final a<E> avO(int i2) {
        AppMethodBeat.i(61421);
        a<E> fL = fL(get(i2));
        AppMethodBeat.o(61421);
        return fL;
    }

    private a<E> avP(int i2) {
        AppMethodBeat.i(61422);
        while (i2 >= 0 && i2 <= this.size) {
            if (i2 == 0) {
                AppMethodBeat.o(61422);
                return this;
            }
            this = this.TSj;
            i2--;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
        AppMethodBeat.o(61422);
        throw indexOutOfBoundsException;
    }
}
