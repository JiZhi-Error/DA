package com.tencent.magicbrush.utils;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0007J\u0014\u0010\u0014\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u001f\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\n¢\u0006\u0002\u0010\u0018J!\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00160\u001aH\u0007¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/magicbrush/utils/ThreadUtil;", "", "()V", "uiHandler", "Landroid/os/Handler;", "getMainHandler", "isUiThread", "", "postOnUiThread", "r", "Lkotlin/Function0;", "", "run", "Ljava/lang/Runnable;", "delayMs", "", "runOnJsThreadIfAvailable", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "runnable", "runOnUiThread", "syncOnUiThread", "T", "cb", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "callable", "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;)Ljava/lang/Object;", "lib-magicbrush-nano_release"})
public final class f {
    private static final Handler cPw = new Handler(Looper.getMainLooper());
    public static final f cPx = new f();

    static {
        AppMethodBeat.i(140298);
        AppMethodBeat.o(140298);
    }

    private f() {
    }

    public static final Handler PA() {
        return cPw;
    }

    public static final boolean RE() {
        AppMethodBeat.i(140294);
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        p.g(mainLooper, "Looper.getMainLooper()");
        boolean j2 = p.j(currentThread, mainLooper.getThread());
        AppMethodBeat.o(140294);
        return j2;
    }

    public static final void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(140295);
        p.h(runnable, "run");
        if (RE()) {
            runnable.run();
            AppMethodBeat.o(140295);
            return;
        }
        cPw.post(runnable);
        AppMethodBeat.o(140295);
    }

    public static void e(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(140296);
        p.h(aVar, "run");
        runOnUiThread(new g(aVar));
        AppMethodBeat.o(140296);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, hxF = {"<anonymous>", "T", "call", "()Ljava/lang/Object;"})
    public static final class a<V> implements Callable<T> {
        final /* synthetic */ kotlin.g.a.a cPy;

        a(kotlin.g.a.a aVar) {
            this.cPy = aVar;
        }

        @Override // java.util.concurrent.Callable
        public final T call() {
            AppMethodBeat.i(140293);
            T t = (T) this.cPy.invoke();
            AppMethodBeat.o(140293);
            return t;
        }
    }

    public static <T> T f(kotlin.g.a.a<? extends T> aVar) {
        AppMethodBeat.i(140297);
        p.h(aVar, "cb");
        e eVar = new e(new a(aVar));
        runOnUiThread(eVar);
        T t = (T) eVar.get();
        AppMethodBeat.o(140297);
        return t;
    }
}
