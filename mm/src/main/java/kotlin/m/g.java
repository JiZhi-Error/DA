package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lkotlin/sequences/GeneratorSequence;", "T", "", "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
public final class g<T> implements h<T> {
    final kotlin.g.a.a<T> TSF;
    final b<T, T> TSG;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\t\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0002\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, hxF = {"kotlin/sequences/GeneratorSequence$iterator$1", "", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
    public static final class a implements Iterator<T>, kotlin.g.b.a.a {
        final /* synthetic */ g TSH;
        private int TSy = -2;
        private T TSz;

        public final void remove() {
            AppMethodBeat.i(129504);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.o(129504);
            throw unsupportedOperationException;
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(g gVar) {
            this.TSH = gVar;
        }

        private final void hMe() {
            T invoke;
            AppMethodBeat.i(129501);
            if (this.TSy == -2) {
                invoke = this.TSH.TSF.invoke();
            } else {
                b<T, T> bVar = this.TSH.TSG;
                T t = this.TSz;
                if (t == null) {
                    p.hyc();
                }
                invoke = bVar.invoke(t);
            }
            this.TSz = invoke;
            this.TSy = this.TSz == null ? 0 : 1;
            AppMethodBeat.o(129501);
        }

        @Override // java.util.Iterator
        public final T next() {
            AppMethodBeat.i(129502);
            if (this.TSy < 0) {
                hMe();
            }
            if (this.TSy == 0) {
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                AppMethodBeat.o(129502);
                throw noSuchElementException;
            }
            T t = this.TSz;
            if (t == null) {
                t tVar = new t("null cannot be cast to non-null type T");
                AppMethodBeat.o(129502);
                throw tVar;
            }
            this.TSy = -1;
            AppMethodBeat.o(129502);
            return t;
        }

        public final boolean hasNext() {
            AppMethodBeat.i(129503);
            if (this.TSy < 0) {
                hMe();
            }
            if (this.TSy == 1) {
                AppMethodBeat.o(129503);
                return true;
            }
            AppMethodBeat.o(129503);
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.g.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.g.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public g(kotlin.g.a.a<? extends T> aVar, b<? super T, ? extends T> bVar) {
        p.h(aVar, "getInitialValue");
        p.h(bVar, "getNextValue");
        AppMethodBeat.i(129487);
        this.TSF = aVar;
        this.TSG = bVar;
        AppMethodBeat.o(129487);
    }

    @Override // kotlin.m.h
    public final Iterator<T> iterator() {
        AppMethodBeat.i(129486);
        a aVar = new a(this);
        AppMethodBeat.o(129486);
        return aVar;
    }
}
