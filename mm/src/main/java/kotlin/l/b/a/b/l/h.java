package kotlin.l.b.a.b.l;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class h<T> {
    private final Thread thread = Thread.currentThread();
    final T value;

    h(T t) {
        AppMethodBeat.i(186264);
        this.value = t;
        AppMethodBeat.o(186264);
    }

    public final boolean hasValue() {
        AppMethodBeat.i(186265);
        if (this.thread == Thread.currentThread()) {
            AppMethodBeat.o(186265);
            return true;
        }
        AppMethodBeat.o(186265);
        return false;
    }
}
