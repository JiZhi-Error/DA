package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.Iterator;
import kotlin.g.a.b;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J3\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0003\"\u0004\b\u0002\u0010\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000b0\u0006H\u0000¢\u0006\u0002\b\fJ\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lkotlin/sequences/TransformingSequence;", "T", "R", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "flatten", QLog.TAG_REPORTLEVEL_USER, "iterator", "", "flatten$kotlin_stdlib", "kotlin-stdlib"})
public final class p<T, R> implements h<R> {
    public final b<T, R> TSB;
    public final h<T> TSt;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, hxF = {"kotlin/sequences/TransformingSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
    public static final class a implements Iterator<R>, kotlin.g.b.a.a {
        final /* synthetic */ p TSR;
        private final Iterator<T> bXG;

        public final void remove() {
            AppMethodBeat.i(129485);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.o(129485);
            throw unsupportedOperationException;
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(p pVar) {
            this.TSR = pVar;
            AppMethodBeat.i(129484);
            this.bXG = pVar.TSt.iterator();
            AppMethodBeat.o(129484);
        }

        @Override // java.util.Iterator
        public final R next() {
            AppMethodBeat.i(129482);
            R invoke = this.TSR.TSB.invoke(this.bXG.next());
            AppMethodBeat.o(129482);
            return invoke;
        }

        public final boolean hasNext() {
            AppMethodBeat.i(129483);
            boolean hasNext = this.bXG.hasNext();
            AppMethodBeat.o(129483);
            return hasNext;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.m.h<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.g.a.b<? super T, ? extends R> */
    /* JADX WARN: Multi-variable type inference failed */
    public p(h<? extends T> hVar, b<? super T, ? extends R> bVar) {
        kotlin.g.b.p.h(hVar, "sequence");
        kotlin.g.b.p.h(bVar, "transformer");
        AppMethodBeat.i(129526);
        this.TSt = hVar;
        this.TSB = bVar;
        AppMethodBeat.o(129526);
    }

    @Override // kotlin.m.h
    public final Iterator<R> iterator() {
        AppMethodBeat.i(129525);
        a aVar = new a(this);
        AppMethodBeat.o(129525);
        return aVar;
    }
}
