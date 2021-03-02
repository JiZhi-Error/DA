package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import rx.b.d;
import rx.d.c;
import rx.internal.util.g;

/* access modifiers changed from: package-private */
public enum e {
    ;
    
    static final g Umi = new g("RxScheduledExecutorPool-");

    static {
        AppMethodBeat.i(90377);
        AppMethodBeat.o(90377);
    }

    public static e valueOf(String str) {
        AppMethodBeat.i(90375);
        e eVar = (e) Enum.valueOf(e.class, str);
        AppMethodBeat.o(90375);
        return eVar;
    }

    public static ScheduledExecutorService hQM() {
        AppMethodBeat.i(90376);
        d<? extends ScheduledExecutorService> hQU = c.hQU();
        if (hQU == null) {
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, Umi);
            AppMethodBeat.o(90376);
            return newScheduledThreadPool;
        }
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) hQU.call();
        AppMethodBeat.o(90376);
        return scheduledExecutorService;
    }
}
