package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.a.b;
import rx.b.a;
import rx.d.c;
import rx.f.d;
import rx.g;
import rx.internal.util.e;
import rx.j;

public class h extends g.a implements j {
    private static final boolean Ump;
    public static final int Umq = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> Umr = new ConcurrentHashMap<>();
    private static final AtomicReference<ScheduledExecutorService> Ums = new AtomicReference<>();
    private static volatile Object Umt;
    private static final Object Umu = new Object();
    final ScheduledExecutorService Umn;
    volatile boolean Umo;

    static {
        AppMethodBeat.i(90336);
        boolean z = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int hQR = e.hQR();
        Ump = !z && (hQR == 0 || hQR >= 21);
        AppMethodBeat.o(90336);
    }

    public static void a(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        AppMethodBeat.i(90326);
        while (true) {
            if (Ums.get() != null) {
                break;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new rx.internal.util.g("RxSchedulerPurge-"));
            if (Ums.compareAndSet(null, newScheduledThreadPool)) {
                newScheduledThreadPool.scheduleAtFixedRate(new Runnable() {
                    /* class rx.internal.c.h.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(90325);
                        h.hQN();
                        AppMethodBeat.o(90325);
                    }
                }, (long) Umq, (long) Umq, TimeUnit.MILLISECONDS);
                break;
            }
            newScheduledThreadPool.shutdownNow();
        }
        Umr.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
        AppMethodBeat.o(90326);
    }

    public static void a(ScheduledExecutorService scheduledExecutorService) {
        AppMethodBeat.i(90327);
        Umr.remove(scheduledExecutorService);
        AppMethodBeat.o(90327);
    }

    static void hQN() {
        AppMethodBeat.i(90328);
        try {
            Iterator<ScheduledThreadPoolExecutor> it = Umr.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor next = it.next();
                if (!next.isShutdown()) {
                    next.purge();
                } else {
                    it.remove();
                }
            }
            AppMethodBeat.o(90328);
        } catch (Throwable th) {
            b.N(th);
            c.onError(th);
            AppMethodBeat.o(90328);
        }
    }

    public static boolean b(ScheduledExecutorService scheduledExecutorService) {
        Method c2;
        Object obj;
        AppMethodBeat.i(90329);
        if (Ump) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj2 = Umt;
                if (obj2 == Umu) {
                    AppMethodBeat.o(90329);
                    return false;
                } else if (obj2 == null) {
                    c2 = c(scheduledExecutorService);
                    if (c2 != null) {
                        obj = c2;
                    } else {
                        obj = Umu;
                    }
                    Umt = obj;
                } else {
                    c2 = (Method) obj2;
                }
            } else {
                c2 = c(scheduledExecutorService);
            }
            if (c2 != null) {
                try {
                    c2.invoke(scheduledExecutorService, Boolean.TRUE);
                    AppMethodBeat.o(90329);
                    return true;
                } catch (InvocationTargetException e2) {
                    c.onError(e2);
                } catch (IllegalAccessException e3) {
                    c.onError(e3);
                } catch (IllegalArgumentException e4) {
                    c.onError(e4);
                }
            }
        }
        AppMethodBeat.o(90329);
        return false;
    }

    private static Method c(ScheduledExecutorService scheduledExecutorService) {
        AppMethodBeat.i(90330);
        Method[] methods = scheduledExecutorService.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    AppMethodBeat.o(90330);
                    return method;
                }
            }
        }
        AppMethodBeat.o(90330);
        return null;
    }

    public h(ThreadFactory threadFactory) {
        AppMethodBeat.i(90331);
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!b(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            a((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.Umn = newScheduledThreadPool;
        AppMethodBeat.o(90331);
    }

    @Override // rx.g.a
    public final j a(a aVar) {
        AppMethodBeat.i(90332);
        j a2 = a(aVar, 0, null);
        AppMethodBeat.o(90332);
        return a2;
    }

    @Override // rx.g.a
    public final j a(a aVar, long j2, TimeUnit timeUnit) {
        AppMethodBeat.i(90333);
        if (this.Umo) {
            j hRn = d.hRn();
            AppMethodBeat.o(90333);
            return hRn;
        }
        i b2 = b(aVar, j2, timeUnit);
        AppMethodBeat.o(90333);
        return b2;
    }

    public final i b(a aVar, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        AppMethodBeat.i(90334);
        i iVar = new i(c.b(aVar));
        if (j2 <= 0) {
            schedule = this.Umn.submit(iVar);
        } else {
            schedule = this.Umn.schedule(iVar, j2, timeUnit);
        }
        iVar.b(schedule);
        AppMethodBeat.o(90334);
        return iVar;
    }

    @Override // rx.j
    public final void hQA() {
        AppMethodBeat.i(90335);
        this.Umo = true;
        this.Umn.shutdownNow();
        a(this.Umn);
        AppMethodBeat.o(90335);
    }

    @Override // rx.j
    public final boolean hQB() {
        return this.Umo;
    }
}
