package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.d.f;
import kotlin.k.j;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0011\u001a\u0004\u0018\u0001H\u0012\"\u0004\b\u0000\u0010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014H\b¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u001c\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\n\u0010\u0013\u001a\u00060\u001ej\u0002`\u001fH\u0016J\b\u0010 \u001a\u00020\u0006H\u0002J!\u0010!\u001a\u00020\u00102\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#2\u0006\u0010\u0005\u001a\u00020\u0019H\u0000¢\u0006\u0002\b$J\r\u0010%\u001a\u00020\u0017H\u0000¢\u0006\u0002\b&J\u0015\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0000¢\u0006\u0002\b*J\b\u0010+\u001a\u00020\u0004H\u0016J\r\u0010\u000f\u001a\u00020\u0017H\u0000¢\u0006\u0002\b,R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lkotlinx/coroutines/CommonPool;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "()V", "DEFAULT_PARALLELISM_PROPERTY_NAME", "", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "parallelism", "", "getParallelism", "()I", "pool", "requestedParallelism", "usePrivatePool", "", "Try", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "close", "", "createPlainPool", "Ljava/util/concurrent/ExecutorService;", "createPool", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "getOrCreatePoolSync", "isGoodCommonPool", "fjpClass", "Ljava/lang/Class;", "isGoodCommonPool$kotlinx_coroutines_core", "restore", "restore$kotlinx_coroutines_core", "shutdown", "timeout", "", "shutdown$kotlinx_coroutines_core", "toString", "usePrivatePool$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public final class t extends bk {
    private static final int TTI;
    private static boolean TTJ;
    public static final t TTK = new t();
    private static volatile Executor pool;

    static {
        String str;
        int intValue;
        AppMethodBeat.i(118258);
        try {
            str = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable th) {
            str = null;
        }
        if (str == null) {
            intValue = -1;
        } else {
            Integer buA = n.buA(str);
            if (buA == null || buA.intValue() <= 0) {
                IllegalStateException illegalStateException = new IllegalStateException("Expected positive number in kotlinx.coroutines.default.parallelism, but has ".concat(String.valueOf(str)).toString());
                AppMethodBeat.o(118258);
                throw illegalStateException;
            }
            intValue = buA.intValue();
        }
        TTI = intValue;
        AppMethodBeat.o(118258);
    }

    private t() {
    }

    @Override // kotlinx.coroutines.bk
    public final Executor getExecutor() {
        AppMethodBeat.i(192395);
        Executor executor = pool;
        if (executor == null) {
            executor = hMD();
        }
        AppMethodBeat.o(192395);
        return executor;
    }

    private static int getParallelism() {
        AppMethodBeat.i(118251);
        Integer valueOf = Integer.valueOf(TTI);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            int intValue = valueOf.intValue();
            AppMethodBeat.o(118251);
            return intValue;
        }
        int mZ = j.mZ(Runtime.getRuntime().availableProcessors() - 1, 1);
        AppMethodBeat.o(118251);
        return mZ;
    }

    private static ExecutorService hMB() {
        Class<?> cls;
        ExecutorService executorService;
        ExecutorService executorService2;
        Object obj;
        AppMethodBeat.i(118252);
        if (System.getSecurityManager() != null) {
            ExecutorService hMC = hMC();
            AppMethodBeat.o(118252);
            return hMC;
        }
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable th) {
            cls = null;
        }
        if (cls == null) {
            ExecutorService hMC2 = hMC();
            AppMethodBeat.o(118252);
            return hMC2;
        }
        if (!TTJ && TTI < 0) {
            try {
                Method method = cls.getMethod("commonPool", new Class[0]);
                if (method != null) {
                    obj = method.invoke(null, new Object[0]);
                } else {
                    obj = null;
                }
                if (!(obj instanceof ExecutorService)) {
                    obj = null;
                }
                executorService2 = (ExecutorService) obj;
            } catch (Throwable th2) {
                executorService2 = null;
            }
            if (executorService2 != null) {
                if (!a(cls, executorService2)) {
                    executorService2 = null;
                }
                if (executorService2 != null) {
                    AppMethodBeat.o(118252);
                    return executorService2;
                }
            }
        }
        try {
            Object newInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(getParallelism()));
            if (!(newInstance instanceof ExecutorService)) {
                newInstance = null;
            }
            executorService = (ExecutorService) newInstance;
        } catch (Throwable th3) {
            executorService = null;
        }
        if (executorService != null) {
            AppMethodBeat.o(118252);
            return executorService;
        }
        ExecutorService hMC3 = hMC();
        AppMethodBeat.o(118252);
        return hMC3;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        public static final b TTM = new b();

        static {
            AppMethodBeat.i(118054);
            AppMethodBeat.o(118054);
        }

        b() {
        }

        public final void run() {
        }
    }

    private static boolean a(Class<?> cls, ExecutorService executorService) {
        Integer num;
        AppMethodBeat.i(118253);
        executorService.submit(b.TTM);
        try {
            Object invoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            if (!(invoke instanceof Integer)) {
                invoke = null;
            }
            num = (Integer) invoke;
        } catch (Throwable th) {
            num = null;
        }
        if (num == null) {
            AppMethodBeat.o(118253);
            return false;
        } else if (num.intValue() > 0) {
            AppMethodBeat.o(118253);
            return true;
        } else {
            AppMethodBeat.o(118253);
            return false;
        }
    }

    private static ExecutorService hMC() {
        AppMethodBeat.i(118254);
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(getParallelism(), new a(new AtomicInteger()));
        AppMethodBeat.o(118254);
        return newFixedThreadPool;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Ljava/lang/Thread;", LocaleUtil.ITALIAN, "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "newThread"})
    public static final class a implements ThreadFactory {
        final /* synthetic */ AtomicInteger TTL;

        a(AtomicInteger atomicInteger) {
            this.TTL = atomicInteger;
        }

        public final Thread newThread(Runnable runnable) {
            AppMethodBeat.i(118209);
            Thread thread = new Thread(runnable, "CommonPool-worker-" + this.TTL.incrementAndGet());
            thread.setDaemon(true);
            AppMethodBeat.o(118209);
            return thread;
        }
    }

    private final synchronized Executor hMD() {
        ExecutorService executorService;
        AppMethodBeat.i(118255);
        executorService = pool;
        if (executorService == null) {
            ExecutorService hMB = hMB();
            pool = hMB;
            executorService = hMB;
        }
        AppMethodBeat.o(118255);
        return executorService;
    }

    @Override // kotlinx.coroutines.ad
    public final void a(f fVar, Runnable runnable) {
        Executor executor;
        Runnable runnable2;
        AppMethodBeat.i(118256);
        try {
            Executor executor2 = pool;
            if (executor2 == null) {
                executor = hMD();
            } else {
                executor = executor2;
            }
            cq cqVar = cr.TVl;
            if (cqVar == null || (runnable2 = cqVar.hNB()) == null) {
                runnable2 = runnable;
            }
            executor.execute(runnable2);
            AppMethodBeat.o(118256);
        } catch (RejectedExecutionException e2) {
            ap.TUg.bd(runnable);
            AppMethodBeat.o(118256);
        }
    }

    @Override // kotlinx.coroutines.ad
    public final String toString() {
        return "CommonPool";
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(118257);
        IllegalStateException illegalStateException = new IllegalStateException("Close cannot be invoked on CommonPool".toString());
        AppMethodBeat.o(118257);
        throw illegalStateException;
    }
}
