package com.tencent.midas.download;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class APMidasPluginDownloadManager {
    private static final int MAX_CURRENCY_DOWNLOAD_THREAD = 1;
    private static final String TAG = "APMidasPluginDownloadManager";
    private ExecutorService executorService = getExecutorService();

    private APMidasPluginDownloadManager() {
        AppMethodBeat.i(193246);
        AppMethodBeat.o(193246);
    }

    static void startDownload(Context context, ArrayList<APMidasPluginDownInfo> arrayList, IAPMidasPluginDownListener iAPMidasPluginDownListener) {
        AppMethodBeat.i(193247);
        new APMidasPluginDownloadManager().enqueue(new APMidasPluginDownloadWorker(context, arrayList, context.getApplicationContext().getDir("midaspluginsTemp", 0), iAPMidasPluginDownListener));
        AppMethodBeat.o(193247);
    }

    private synchronized void enqueue(APMidasPluginDownloadWorker aPMidasPluginDownloadWorker) {
        AppMethodBeat.i(193248);
        if (aPMidasPluginDownloadWorker == null) {
            APLog.e(TAG, "Cannot enqueue null worker!");
            AppMethodBeat.o(193248);
        } else {
            this.executorService.execute(aPMidasPluginDownloadWorker);
            AppMethodBeat.o(193248);
        }
    }

    private ExecutorService getExecutorService() {
        AppMethodBeat.i(193249);
        if (this.executorService == null) {
            this.executorService = Executors.newFixedThreadPool(1, threadFactory("Plugin Download Thread", false));
        }
        ExecutorService executorService2 = this.executorService;
        AppMethodBeat.o(193249);
        return executorService2;
    }

    private static ThreadFactory threadFactory(final String str, final boolean z) {
        AppMethodBeat.i(193250);
        AnonymousClass1 r0 = new ThreadFactory() {
            /* class com.tencent.midas.download.APMidasPluginDownloadManager.AnonymousClass1 */
            private AtomicInteger netThreadCount = new AtomicInteger(0);

            {
                AppMethodBeat.i(193238);
                AppMethodBeat.o(193238);
            }

            public final Thread newThread(Runnable runnable) {
                AppMethodBeat.i(193239);
                Thread thread = new Thread(runnable, str + " " + this.netThreadCount.getAndIncrement());
                thread.setPriority(10);
                thread.setDaemon(z);
                AppMethodBeat.o(193239);
                return thread;
            }
        };
        AppMethodBeat.o(193250);
        return r0;
    }
}
