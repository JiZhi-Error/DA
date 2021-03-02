package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.g.b.a.a;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010*\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\f"}, hxF = {"Lkotlin/collections/EmptyIterator;", "", "", "()V", "hasNext", "", "hasPrevious", "next", "nextIndex", "", "previous", "previousIndex", "kotlin-stdlib"})
public final class u implements ListIterator, a {
    public static final u SXq = new u();

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(Object obj) {
        AppMethodBeat.i(129014);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129014);
        throw unsupportedOperationException;
    }

    public final void remove() {
        AppMethodBeat.i(129013);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129013);
        throw unsupportedOperationException;
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(Object obj) {
        AppMethodBeat.i(129015);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129015);
        throw unsupportedOperationException;
    }

    static {
        AppMethodBeat.i(129012);
        AppMethodBeat.o(129012);
    }

    private u() {
    }

    public final boolean hasNext() {
        return false;
    }

    public final boolean hasPrevious() {
        return false;
    }

    public final int nextIndex() {
        return 0;
    }

    public final int previousIndex() {
        return -1;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final /* synthetic */ Object next() {
        AppMethodBeat.i(129010);
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        AppMethodBeat.o(129010);
        throw noSuchElementException;
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ Object previous() {
        AppMethodBeat.i(129011);
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        AppMethodBeat.o(129011);
        throw noSuchElementException;
    }
}
