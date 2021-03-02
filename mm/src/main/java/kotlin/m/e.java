package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lkotlin/sequences/FilteringSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "sendWhen", "", "predicate", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;ZLkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
public final class e<T> implements h<T> {
    final h<T> TSt;
    final boolean TSw;
    final b<T, Boolean> TSx;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.m.h<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.g.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public e(h<? extends T> hVar, boolean z, b<? super T, Boolean> bVar) {
        p.h(hVar, "sequence");
        p.h(bVar, "predicate");
        AppMethodBeat.i(129494);
        this.TSt = hVar;
        this.TSw = z;
        this.TSx = bVar;
        AppMethodBeat.o(129494);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\t\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, hxF = {"kotlin/sequences/FilteringSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
    public static final class a implements Iterator<T>, kotlin.g.b.a.a {
        final /* synthetic */ e TSA;
        private int TSy = -1;
        private T TSz;
        private final Iterator<T> bXG;

        public final void remove() {
            AppMethodBeat.i(129540);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.o(129540);
            throw unsupportedOperationException;
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(e eVar) {
            this.TSA = eVar;
            AppMethodBeat.i(129539);
            this.bXG = eVar.TSt.iterator();
            AppMethodBeat.o(129539);
        }

        private final void hMe() {
            AppMethodBeat.i(129536);
            while (this.bXG.hasNext()) {
                T next = this.bXG.next();
                if (this.TSA.TSx.invoke(next).booleanValue() == this.TSA.TSw) {
                    this.TSz = next;
                    this.TSy = 1;
                    AppMethodBeat.o(129536);
                    return;
                }
            }
            this.TSy = 0;
            AppMethodBeat.o(129536);
        }

        @Override // java.util.Iterator
        public final T next() {
            AppMethodBeat.i(129537);
            if (this.TSy == -1) {
                hMe();
            }
            if (this.TSy == 0) {
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                AppMethodBeat.o(129537);
                throw noSuchElementException;
            }
            T t = this.TSz;
            this.TSz = null;
            this.TSy = -1;
            AppMethodBeat.o(129537);
            return t;
        }

        public final boolean hasNext() {
            AppMethodBeat.i(129538);
            if (this.TSy == -1) {
                hMe();
            }
            if (this.TSy == 1) {
                AppMethodBeat.o(129538);
                return true;
            }
            AppMethodBeat.o(129538);
            return false;
        }
    }

    @Override // kotlin.m.h
    public final Iterator<T> iterator() {
        AppMethodBeat.i(129493);
        a aVar = new a(this);
        AppMethodBeat.o(129493);
        return aVar;
    }
}
