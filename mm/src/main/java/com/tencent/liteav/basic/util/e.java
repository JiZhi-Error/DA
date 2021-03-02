package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

public class e extends Handler {
    public e(Looper looper) {
        super(looper);
    }

    public boolean a(final Runnable runnable) {
        AppMethodBeat.i(222120);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        boolean post = post(new Runnable() {
            /* class com.tencent.liteav.basic.util.e.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(14720);
                runnable.run();
                countDownLatch.countDown();
                AppMethodBeat.o(14720);
            }
        });
        if (post) {
            try {
                countDownLatch.await();
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
            }
        }
        AppMethodBeat.o(222120);
        return post;
    }
}
