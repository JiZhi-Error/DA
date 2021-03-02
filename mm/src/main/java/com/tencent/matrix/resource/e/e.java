package com.tencent.matrix.resource.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class e {
    private final Handler cZX;
    long cZY;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());

    public interface a {

        /* renamed from: com.tencent.matrix.resource.e.e$a$a  reason: collision with other inner class name */
        public enum EnumC0232a {
            DONE,
            RETRY
        }

        EnumC0232a Th();
    }

    public e(long j2, HandlerThread handlerThread) {
        this.cZX = new Handler(handlerThread.getLooper());
        this.cZY = j2;
    }

    public final void Tm() {
        this.cZX.removeCallbacksAndMessages(null);
        this.mMainHandler.removeCallbacksAndMessages(null);
    }

    public final void a(final a aVar, final int i2) {
        this.cZX.postDelayed(new Runnable() {
            /* class com.tencent.matrix.resource.e.e.AnonymousClass1 */

            public final void run() {
                if (aVar.Th() == a.EnumC0232a.RETRY) {
                    e.this.a(aVar, i2 + 1);
                }
            }
        }, this.cZY);
    }
}
