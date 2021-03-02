package a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class b {
    private static final b aBC = new b();
    private final ExecutorService aBD;
    private final ScheduledExecutorService aBE;
    private final Executor aBF;

    static {
        AppMethodBeat.i(52981);
        AppMethodBeat.o(52981);
    }

    private b() {
        AppMethodBeat.i(52980);
        String property = System.getProperty("java.runtime.name");
        this.aBD = !(property == null ? false : property.toLowerCase(Locale.US).contains("android")) ? Executors.newCachedThreadPool() : a.newCachedThreadPool();
        this.aBE = Executors.newSingleThreadScheduledExecutor();
        this.aBF = new a((byte) 0);
        AppMethodBeat.o(52980);
    }

    public static ExecutorService nC() {
        return aBC.aBD;
    }

    static Executor nD() {
        return aBC.aBF;
    }

    static class a implements Executor {
        private ThreadLocal<Integer> aBG;

        private a() {
            AppMethodBeat.i(52977);
            this.aBG = new ThreadLocal<>();
            AppMethodBeat.o(52977);
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        private int nE() {
            AppMethodBeat.i(52978);
            Integer num = this.aBG.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.aBG.remove();
            } else {
                this.aBG.set(Integer.valueOf(intValue));
            }
            AppMethodBeat.o(52978);
            return intValue;
        }

        public final void execute(Runnable runnable) {
            AppMethodBeat.i(52979);
            Integer num = this.aBG.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.aBG.set(Integer.valueOf(intValue));
            if (intValue <= 15) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    nE();
                    AppMethodBeat.o(52979);
                    throw th;
                }
            } else {
                b.nC().execute(runnable);
            }
            nE();
            AppMethodBeat.o(52979);
        }
    }
}
