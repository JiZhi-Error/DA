package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lkotlinx/coroutines/scheduling/NanoTimeSource;", "Lkotlinx/coroutines/scheduling/TimeSource;", "()V", "nanoTime", "", "kotlinx-coroutines-core"})
public final class g extends m {
    public static final g TWX = new g();

    static {
        AppMethodBeat.i(118030);
        AppMethodBeat.o(118030);
    }

    private g() {
    }

    @Override // kotlinx.coroutines.b.m
    public final long nanoTime() {
        AppMethodBeat.i(118029);
        long nanoTime = System.nanoTime();
        AppMethodBeat.o(118029);
        return nanoTime;
    }
}
