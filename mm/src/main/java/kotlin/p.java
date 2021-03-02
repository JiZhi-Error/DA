package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u0000 \u0013*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004:\u0001\u0013B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, hxF = {"Lkotlin/SafePublicationLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "Companion", "kotlin-stdlib"})
final class p<T> implements Serializable, f<T> {
    private static final AtomicReferenceFieldUpdater<p<?>, Object> SWW = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "SWU");
    public static final a SWX = new a((byte) 0);
    private volatile kotlin.g.a.a<? extends T> SWT;
    private volatile Object SWU = v.SXa;
    private final Object SWV = v.SXa;

    public p(kotlin.g.a.a<? extends T> aVar) {
        kotlin.g.b.p.h(aVar, "initializer");
        AppMethodBeat.i(129579);
        this.SWT = aVar;
        AppMethodBeat.o(129579);
    }

    @Override // kotlin.f
    public final T getValue() {
        AppMethodBeat.i(129576);
        T t = (T) this.SWU;
        if (t != v.SXa) {
            AppMethodBeat.o(129576);
            return t;
        }
        kotlin.g.a.a<? extends T> aVar = this.SWT;
        if (aVar != null) {
            T t2 = (T) aVar.invoke();
            if (SWW.compareAndSet(this, v.SXa, t2)) {
                this.SWT = null;
                AppMethodBeat.o(129576);
                return t2;
            }
        }
        T t3 = (T) this.SWU;
        AppMethodBeat.o(129576);
        return t3;
    }

    private final Object writeReplace() {
        AppMethodBeat.i(129578);
        d dVar = new d(getValue());
        AppMethodBeat.o(129578);
        return dVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R^\u0010\u0003\u001aR\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001 \u0006*(\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lkotlin/SafePublicationLazyImpl$Companion;", "", "()V", "valueUpdater", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/SafePublicationLazyImpl;", "kotlin.jvm.PlatformType", "kotlin-stdlib"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(129580);
        AppMethodBeat.o(129580);
    }

    public final String toString() {
        boolean z;
        AppMethodBeat.i(129577);
        if (this.SWU != v.SXa) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            String valueOf = String.valueOf(getValue());
            AppMethodBeat.o(129577);
            return valueOf;
        }
        AppMethodBeat.o(129577);
        return "Lazy value not initialized yet.";
    }
}
