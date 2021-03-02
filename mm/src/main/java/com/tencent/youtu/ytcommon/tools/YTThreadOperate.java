package com.tencent.youtu.ytcommon.tools;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class YTThreadOperate {
    private static ExecutorService mExecutorService = Executors.newFixedThreadPool(3);
    private static Handler mHandler = new Handler(Looper.getMainLooper());

    public interface UiThreadCallback<T> {
        void callback(T t);
    }

    static {
        AppMethodBeat.i(73401);
        AppMethodBeat.o(73401);
    }

    public static void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(73396);
        mHandler.post(runnable);
        AppMethodBeat.o(73396);
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j2) {
        AppMethodBeat.i(73397);
        mHandler.postDelayed(runnable, j2);
        AppMethodBeat.o(73397);
    }

    public static void runOnSubThread(final Runnable runnable) {
        AppMethodBeat.i(73398);
        mExecutorService.submit(new Runnable() {
            /* class com.tencent.youtu.ytcommon.tools.YTThreadOperate.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(73392);
                runnable.run();
                AppMethodBeat.o(73392);
            }
        });
        AppMethodBeat.o(73398);
    }

    public static <T> Future<T> runOnSubThread(final Callable<T> callable) {
        AppMethodBeat.i(73399);
        Future<T> submit = mExecutorService.submit(new Callable<T>() {
            /* class com.tencent.youtu.ytcommon.tools.YTThreadOperate.AnonymousClass2 */

            @Override // java.util.concurrent.Callable
            public final T call() {
                AppMethodBeat.i(73393);
                try {
                    T t = (T) callable.call();
                    AppMethodBeat.o(73393);
                    return t;
                } catch (Exception e2) {
                    AppMethodBeat.o(73393);
                    return null;
                }
            }
        });
        AppMethodBeat.o(73399);
        return submit;
    }

    public static <T> void runOnSubThread(final Callable<T> callable, final UiThreadCallback<T> uiThreadCallback) {
        AppMethodBeat.i(73400);
        mExecutorService.submit(new Runnable() {
            /* class com.tencent.youtu.ytcommon.tools.YTThreadOperate.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(73395);
                final Object obj = null;
                try {
                    obj = callable.call();
                } catch (Exception e2) {
                }
                YTThreadOperate.mHandler.post(new Runnable() {
                    /* class com.tencent.youtu.ytcommon.tools.YTThreadOperate.AnonymousClass3.AnonymousClass1 */

                    public void run() {
                        AppMethodBeat.i(73394);
                        if (uiThreadCallback != null) {
                            try {
                                uiThreadCallback.callback(obj);
                                AppMethodBeat.o(73394);
                                return;
                            } catch (Exception e2) {
                                YTException.report(e2);
                            }
                        }
                        AppMethodBeat.o(73394);
                    }
                });
                AppMethodBeat.o(73395);
            }
        });
        AppMethodBeat.o(73400);
    }
}
