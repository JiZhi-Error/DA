package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.g.a.a;
import kotlin.g.b.p;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, hxF = {"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"})
final class q<T> implements Serializable, f<T> {
    private a<? extends T> SWT;
    private volatile Object SWU;
    private final Object lock;

    private q(a<? extends T> aVar) {
        p.h(aVar, "initializer");
        AppMethodBeat.i(129585);
        this.SWT = aVar;
        this.SWU = v.SXa;
        this.lock = this;
        AppMethodBeat.o(129585);
    }

    public /* synthetic */ q(a aVar, byte b2) {
        this(aVar);
    }

    @Override // kotlin.f
    public final T getValue() {
        Object obj;
        AppMethodBeat.i(129582);
        Object obj2 = (T) this.SWU;
        if (obj2 != v.SXa) {
            AppMethodBeat.o(129582);
            obj = obj2;
        } else {
            synchronized (this.lock) {
                try {
                    Object obj3 = this.SWU;
                    Object obj4 = obj3;
                    if (obj3 == v.SXa) {
                        a<? extends T> aVar = this.SWT;
                        if (aVar == null) {
                            p.hyc();
                        }
                        Object invoke = aVar.invoke();
                        this.SWU = invoke;
                        this.SWT = null;
                        obj4 = invoke;
                    }
                } finally {
                    AppMethodBeat.o(129582);
                }
            }
        }
        return (T) obj;
    }

    private final Object writeReplace() {
        AppMethodBeat.i(129584);
        d dVar = new d(getValue());
        AppMethodBeat.o(129584);
        return dVar;
    }

    public final String toString() {
        boolean z;
        AppMethodBeat.i(129583);
        if (this.SWU != v.SXa) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            String valueOf = String.valueOf(getValue());
            AppMethodBeat.o(129583);
            return valueOf;
        }
        AppMethodBeat.o(129583);
        return "Lazy value not initialized yet.";
    }
}
