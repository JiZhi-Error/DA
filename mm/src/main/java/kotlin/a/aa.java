package kotlin.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.g.b.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tH\u0002J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lkotlin/collections/IndexingIterator;", "T", "", "Lkotlin/collections/IndexedValue;", "iterator", "(Ljava/util/Iterator;)V", FirebaseAnalytics.b.INDEX, "", "hasNext", "", "next", "kotlin-stdlib"})
public final class aa<T> implements Iterator<y<? extends T>>, a {
    private final Iterator<T> bXG;
    private int index;

    public final void remove() {
        AppMethodBeat.i(129030);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129030);
        throw unsupportedOperationException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Iterator<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public aa(Iterator<? extends T> it) {
        p.h(it, "iterator");
        AppMethodBeat.i(129029);
        this.bXG = it;
        AppMethodBeat.o(129029);
    }

    public final boolean hasNext() {
        AppMethodBeat.i(129027);
        boolean hasNext = this.bXG.hasNext();
        AppMethodBeat.o(129027);
        return hasNext;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        AppMethodBeat.i(129028);
        int i2 = this.index;
        this.index = i2 + 1;
        if (i2 < 0) {
            j.hxH();
        }
        y yVar = new y(i2, this.bXG.next());
        AppMethodBeat.o(129028);
        return yVar;
    }
}
