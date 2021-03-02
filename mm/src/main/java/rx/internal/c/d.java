package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

public final class d implements j {
    private static final ScheduledExecutorService[] Umd = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService Ume;
    public static final d Umf = new d();
    private static int Umh;
    private final AtomicReference<ScheduledExecutorService[]> Umg = new AtomicReference<>(Umd);

    static {
        AppMethodBeat.i(90373);
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        Ume = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        AppMethodBeat.o(90373);
    }

    private d() {
        AppMethodBeat.i(90369);
        start();
        AppMethodBeat.o(90369);
    }

    @Override // rx.internal.c.j
    public final void start() {
        int i2 = 8;
        AppMethodBeat.i(90370);
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors > 4) {
            availableProcessors /= 2;
        }
        if (availableProcessors <= 8) {
            i2 = availableProcessors;
        }
        ScheduledExecutorService[] scheduledExecutorServiceArr = new ScheduledExecutorService[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            scheduledExecutorServiceArr[i3] = e.hQM();
        }
        if (this.Umg.compareAndSet(Umd, scheduledExecutorServiceArr)) {
            for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
                if (!h.b(scheduledExecutorService) && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
                    h.a((ScheduledThreadPoolExecutor) scheduledExecutorService);
                }
            }
            AppMethodBeat.o(90370);
            return;
        }
        for (ScheduledExecutorService scheduledExecutorService2 : scheduledExecutorServiceArr) {
            scheduledExecutorService2.shutdownNow();
        }
        AppMethodBeat.o(90370);
    }

    @Override // rx.internal.c.j
    public final void shutdown() {
        ScheduledExecutorService[] scheduledExecutorServiceArr;
        AppMethodBeat.i(90371);
        do {
            scheduledExecutorServiceArr = this.Umg.get();
            if (scheduledExecutorServiceArr == Umd) {
                AppMethodBeat.o(90371);
                return;
            }
        } while (!this.Umg.compareAndSet(scheduledExecutorServiceArr, Umd));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            h.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
        AppMethodBeat.o(90371);
    }

    public static ScheduledExecutorService hQL() {
        AppMethodBeat.i(90372);
        ScheduledExecutorService[] scheduledExecutorServiceArr = Umf.Umg.get();
        if (scheduledExecutorServiceArr == Umd) {
            ScheduledExecutorService scheduledExecutorService = Ume;
            AppMethodBeat.o(90372);
            return scheduledExecutorService;
        }
        int i2 = Umh + 1;
        if (i2 >= scheduledExecutorServiceArr.length) {
            i2 = 0;
        }
        Umh = i2;
        ScheduledExecutorService scheduledExecutorService2 = scheduledExecutorServiceArr[i2];
        AppMethodBeat.o(90372);
        return scheduledExecutorService2;
    }
}
