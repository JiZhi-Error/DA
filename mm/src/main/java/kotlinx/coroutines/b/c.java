package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.k.j;
import kotlin.l;
import kotlinx.coroutines.ad;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.internal.w;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, hxF = {"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "()V", "IO", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIO", "()Lkotlinx/coroutines/CoroutineDispatcher;", "close", "", "toDebugString", "", "toString", "kotlinx-coroutines-core"})
public final class c extends d {
    private static final ad TUt;
    public static final c TWS;

    static {
        boolean z = false;
        AppMethodBeat.i(117977);
        c cVar = new c();
        TWS = cVar;
        int h2 = v.h("kotlinx.coroutines.io.parallelism", j.mZ(64, w.hNR()), 0, 0, 12);
        if (h2 > 0) {
            z = true;
        }
        if (!z) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Expected positive parallelism level, but have ".concat(String.valueOf(h2)).toString());
            AppMethodBeat.o(117977);
            throw illegalArgumentException;
        }
        TUt = new f(cVar, h2);
        AppMethodBeat.o(117977);
    }

    private c() {
    }

    public static ad hMW() {
        return TUt;
    }

    @Override // kotlinx.coroutines.b.d, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(117976);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("DefaultDispatcher cannot be closed");
        AppMethodBeat.o(117976);
        throw unsupportedOperationException;
    }

    @Override // kotlinx.coroutines.b.d, kotlinx.coroutines.ad
    public final String toString() {
        return "DefaultDispatcher";
    }
}
