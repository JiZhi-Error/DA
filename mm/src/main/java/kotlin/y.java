package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.g.a.a;
import kotlin.g.b.p;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, hxF = {"Lkotlin/UnsafeLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"})
public final class y<T> implements Serializable, f<T> {
    private a<? extends T> SWT;
    private Object SWU = v.SXa;

    public y(a<? extends T> aVar) {
        p.h(aVar, "initializer");
        AppMethodBeat.i(129284);
        this.SWT = aVar;
        AppMethodBeat.o(129284);
    }

    @Override // kotlin.f
    public final T getValue() {
        AppMethodBeat.i(129281);
        if (this.SWU == v.SXa) {
            a<? extends T> aVar = this.SWT;
            if (aVar == null) {
                p.hyc();
            }
            this.SWU = aVar.invoke();
            this.SWT = null;
        }
        T t = (T) this.SWU;
        AppMethodBeat.o(129281);
        return t;
    }

    private final Object writeReplace() {
        AppMethodBeat.i(129283);
        d dVar = new d(getValue());
        AppMethodBeat.o(129283);
        return dVar;
    }

    public final String toString() {
        boolean z;
        AppMethodBeat.i(129282);
        if (this.SWU != v.SXa) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            String valueOf = String.valueOf(getValue());
            AppMethodBeat.o(129282);
            return valueOf;
        }
        AppMethodBeat.o(129282);
        return "Lazy value not initialized yet.";
    }
}
