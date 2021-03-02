package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB)\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;", "mRunnable", "mCreateStackTrace", "", "(Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;Ljava/lang/Runnable;Ljava/lang/String;)V", "mDead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "dead", "", "run", "Companion", "luggage-wxa-app_release"})
public final class u implements com.tencent.mm.vending.e.a, Runnable {
    public static final a ohi = new a((byte) 0);
    private final Runnable mRunnable;
    private final AtomicBoolean ohf = new AtomicBoolean(false);
    private final p<? super com.tencent.mm.vending.e.a> ohg;
    private final String ohh;

    static {
        AppMethodBeat.i(135611);
        AppMethodBeat.o(135611);
    }

    private u(p<? super com.tencent.mm.vending.e.a> pVar, Runnable runnable, String str) {
        p.h(pVar, "mRegistry");
        AppMethodBeat.i(160940);
        this.ohg = pVar;
        this.mRunnable = runnable;
        this.ohh = str;
        AppMethodBeat.o(160940);
    }

    public final void run() {
        AppMethodBeat.i(135608);
        if (!this.ohf.get()) {
            try {
                Runnable runnable = this.mRunnable;
                if (runnable != null) {
                    runnable.run();
                }
            } finally {
                this.ohg.a(this);
                AppMethodBeat.o(135608);
            }
        } else {
            Log.w("Luggage.WXA.LifeCycleWrappedRunnable", "run() but dead, <init> stackTrace = " + this.ohh);
            AppMethodBeat.o(135608);
        }
    }

    @Override // com.tencent.mm.vending.e.a
    public final void dead() {
        AppMethodBeat.i(135609);
        this.ohf.set(true);
        AppMethodBeat.o(135609);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable$Companion;", "", "()V", "obtain", "Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable;", "registry", "Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "runnable", "Ljava/lang/Runnable;", "luggage-wxa-app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final u a(p<? super com.tencent.mm.vending.e.a> pVar, Runnable runnable) {
        AppMethodBeat.i(160941);
        p.h(pVar, "registry");
        if (runnable instanceof u) {
            u uVar = (u) runnable;
            AppMethodBeat.o(160941);
            return uVar;
        }
        String stackTraceString = android.util.Log.getStackTraceString(new Throwable());
        p.g(stackTraceString, "android.util.Log.getStackTraceString(Throwable())");
        u uVar2 = new u(pVar, runnable, stackTraceString);
        AppMethodBeat.o(160941);
        return uVar2;
    }
}
