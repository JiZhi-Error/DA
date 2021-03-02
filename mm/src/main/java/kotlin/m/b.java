package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lkotlin/sequences/DropSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", "", "take", "kotlin-stdlib"})
public final class b<T> implements c<T>, h<T> {
    final h<T> TSt;
    final int count;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.m.h<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(h<? extends T> hVar, int i2) {
        p.h(hVar, "sequence");
        AppMethodBeat.i(129529);
        this.TSt = hVar;
        this.count = i2;
        if (!(this.count >= 0)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("count must be non-negative, but was " + this.count + '.').toString());
            AppMethodBeat.o(129529);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(129529);
    }

    @Override // kotlin.m.c
    public final h<T> hMd() {
        AppMethodBeat.i(129527);
        int i2 = this.count + 1;
        if (i2 < 0) {
            b bVar = new b(this, 1);
            AppMethodBeat.o(129527);
            return bVar;
        }
        b bVar2 = new b(this.TSt, i2);
        AppMethodBeat.o(129527);
        return bVar2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000b\u001a\u00020\fH\u0002J\t\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, hxF = {"kotlin/sequences/DropSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "left", "", "getLeft", "()I", "setLeft", "(I)V", "drop", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
    public static final class a implements Iterator<T>, kotlin.g.b.a.a {
        final /* synthetic */ b TSu;
        private final Iterator<T> bXG;
        private int left;

        public final void remove() {
            AppMethodBeat.i(129481);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.o(129481);
            throw unsupportedOperationException;
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(b bVar) {
            this.TSu = bVar;
            AppMethodBeat.i(129480);
            this.bXG = bVar.TSt.iterator();
            this.left = bVar.count;
            AppMethodBeat.o(129480);
        }

        private final void drop() {
            AppMethodBeat.i(129477);
            while (this.left > 0 && this.bXG.hasNext()) {
                this.bXG.next();
                this.left--;
            }
            AppMethodBeat.o(129477);
        }

        @Override // java.util.Iterator
        public final T next() {
            AppMethodBeat.i(129478);
            drop();
            T next = this.bXG.next();
            AppMethodBeat.o(129478);
            return next;
        }

        public final boolean hasNext() {
            AppMethodBeat.i(129479);
            drop();
            boolean hasNext = this.bXG.hasNext();
            AppMethodBeat.o(129479);
            return hasNext;
        }
    }

    @Override // kotlin.m.h
    public final Iterator<T> iterator() {
        AppMethodBeat.i(129528);
        a aVar = new a(this);
        AppMethodBeat.o(129528);
        return aVar;
    }
}
