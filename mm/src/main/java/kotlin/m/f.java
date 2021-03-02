package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004BA\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\tH\u0002R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lkotlin/sequences/FlatteningSequence;", "T", "R", QLog.TAG_REPORTLEVEL_USER, "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "iterator", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"})
public final class f<T, R, E> implements h<E> {
    final b<T, R> TSB;
    final b<R, Iterator<E>> TSC;
    final h<T> TSt;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.m.h<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.g.a.b<? super T, ? extends R> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.g.a.b<? super R, ? extends java.util.Iterator<? extends E>> */
    /* JADX WARN: Multi-variable type inference failed */
    public f(h<? extends T> hVar, b<? super T, ? extends R> bVar, b<? super R, ? extends Iterator<? extends E>> bVar2) {
        p.h(hVar, "sequence");
        p.h(bVar, "transformer");
        p.h(bVar2, "iterator");
        AppMethodBeat.i(129490);
        this.TSt = hVar;
        this.TSB = bVar;
        this.TSC = bVar2;
        AppMethodBeat.o(129490);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\t\u001a\u00020\nH\u0002J\t\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\rR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0004¨\u0006\u000e"}, hxF = {"kotlin/sequences/FlatteningSequence$iterator$1", "", "itemIterator", "getItemIterator", "()Ljava/util/Iterator;", "setItemIterator", "(Ljava/util/Iterator;)V", "iterator", "getIterator", "ensureItemIterator", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
    public static final class a implements Iterator<E>, kotlin.g.b.a.a {
        private Iterator<? extends E> TSD;
        final /* synthetic */ f TSE;
        private final Iterator<T> bXG;

        public final void remove() {
            AppMethodBeat.i(129500);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.o(129500);
            throw unsupportedOperationException;
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(f fVar) {
            this.TSE = fVar;
            AppMethodBeat.i(129499);
            this.bXG = fVar.TSt.iterator();
            AppMethodBeat.o(129499);
        }

        @Override // java.util.Iterator
        public final E next() {
            AppMethodBeat.i(129496);
            if (!hMf()) {
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                AppMethodBeat.o(129496);
                throw noSuchElementException;
            }
            Iterator<? extends E> it = this.TSD;
            if (it == null) {
                p.hyc();
            }
            E e2 = (E) it.next();
            AppMethodBeat.o(129496);
            return e2;
        }

        public final boolean hasNext() {
            AppMethodBeat.i(129497);
            boolean hMf = hMf();
            AppMethodBeat.o(129497);
            return hMf;
        }

        private final boolean hMf() {
            AppMethodBeat.i(129498);
            Iterator<? extends E> it = this.TSD;
            if (it != null && !it.hasNext()) {
                this.TSD = null;
            }
            while (this.TSD == null) {
                if (!this.bXG.hasNext()) {
                    AppMethodBeat.o(129498);
                    return false;
                }
                Iterator<E> invoke = this.TSE.TSC.invoke(this.TSE.TSB.invoke(this.bXG.next()));
                if (invoke.hasNext()) {
                    this.TSD = invoke;
                    AppMethodBeat.o(129498);
                    return true;
                }
            }
            AppMethodBeat.o(129498);
            return true;
        }
    }

    @Override // kotlin.m.h
    public final Iterator<E> iterator() {
        AppMethodBeat.i(129489);
        a aVar = new a(this);
        AppMethodBeat.o(129489);
        return aVar;
    }
}
