package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.g.b.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0006H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lkotlin/collections/IndexingIterable;", "T", "", "Lkotlin/collections/IndexedValue;", "iteratorFactory", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "iterator", "kotlin-stdlib"})
public final class z<T> implements Iterable<y<? extends T>>, a {
    private final kotlin.g.a.a<Iterator<T>> SXu;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.g.a.a<? extends java.util.Iterator<? extends T>> */
    /* JADX WARN: Multi-variable type inference failed */
    public z(kotlin.g.a.a<? extends Iterator<? extends T>> aVar) {
        p.h(aVar, "iteratorFactory");
        AppMethodBeat.i(129116);
        this.SXu = aVar;
        AppMethodBeat.o(129116);
    }

    @Override // java.lang.Iterable
    public final Iterator<y<T>> iterator() {
        AppMethodBeat.i(129115);
        aa aaVar = new aa(this.SXu.invoke());
        AppMethodBeat.o(129115);
        return aaVar;
    }
}
