package a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class a {
    static final int aBA;
    static final int aBB = ((aBz * 2) + 1);
    private static final a aBx = new a();
    private static final int aBz;
    private final Executor aBy = new ExecutorC0000a((byte) 0);

    static {
        AppMethodBeat.i(52976);
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        aBz = availableProcessors;
        aBA = availableProcessors + 1;
        AppMethodBeat.o(52976);
    }

    private a() {
        AppMethodBeat.i(52974);
        AppMethodBeat.o(52974);
    }

    public static ExecutorService newCachedThreadPool() {
        AppMethodBeat.i(52975);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(aBA, aBB, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        AppMethodBeat.o(52975);
        return threadPoolExecutor;
    }

    public static Executor nB() {
        return aBx.aBy;
    }

    /* renamed from: a.a$a  reason: collision with other inner class name */
    static class ExecutorC0000a implements Executor {
        private ExecutorC0000a() {
        }

        /* synthetic */ ExecutorC0000a(byte b2) {
            this();
        }

        public final void execute(Runnable runnable) {
            AppMethodBeat.i(52973);
            new Handler(Looper.getMainLooper()).post(runnable);
            AppMethodBeat.o(52973);
        }
    }
}
