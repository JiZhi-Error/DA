package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\b\u000bJ\r\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eJ\u0015\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0010R\u0014\u0010\u0003\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lkotlinx/coroutines/ThreadLocalEventLoop;", "", "()V", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "getEventLoop$kotlinx_coroutines_core", "()Lkotlinx/coroutines/EventLoop;", "ref", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "currentOrNull", "currentOrNull$kotlinx_coroutines_core", "resetEventLoop", "", "resetEventLoop$kotlinx_coroutines_core", "setEventLoop", "setEventLoop$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public final class cp {
    private static final ThreadLocal<bg> TVj = new ThreadLocal<>();
    public static final cp TVk = new cp();

    static {
        AppMethodBeat.i(192328);
        AppMethodBeat.o(192328);
    }

    private cp() {
    }

    public static bg hNz() {
        AppMethodBeat.i(192325);
        e eVar = TVj.get();
        if (eVar == null) {
            eVar = new e(Thread.currentThread());
            TVj.set(eVar);
        }
        AppMethodBeat.o(192325);
        return eVar;
    }

    public static void hNA() {
        AppMethodBeat.i(192326);
        TVj.set(null);
        AppMethodBeat.o(192326);
    }

    public static void a(bg bgVar) {
        AppMethodBeat.i(192327);
        TVj.set(bgVar);
        AppMethodBeat.o(192327);
    }
}
