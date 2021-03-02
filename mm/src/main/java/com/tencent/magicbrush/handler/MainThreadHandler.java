package com.tencent.magicbrush.handler;

import android.support.annotation.Keep;
import com.tencent.magicbrush.utils.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public class MainThreadHandler {
    private static native void nativeDoTask(long j2, long j3);

    /* access modifiers changed from: package-private */
    public static class a implements Runnable {
        private int cMQ;
        private long cMR;
        private long data;

        /* synthetic */ a(int i2, long j2, long j3, byte b2) {
            this(i2, j2, j3);
        }

        private a(int i2, long j2, long j3) {
            this.cMQ = i2;
            this.cMR = j2;
            this.data = j3;
        }

        public final void run() {
            AppMethodBeat.i(140002);
            if (this.cMQ <= 1) {
                MainThreadHandler.access$000(this.cMR, this.data);
                AppMethodBeat.o(140002);
                return;
            }
            MainThreadHandler.post(this.cMR, this.data, this.cMQ - 1);
            AppMethodBeat.o(140002);
        }
    }

    static /* synthetic */ void access$000(long j2, long j3) {
        AppMethodBeat.i(140004);
        nativeDoTask(j2, j3);
        AppMethodBeat.o(140004);
    }

    @Keep
    public static void post(long j2, long j3, int i2) {
        AppMethodBeat.i(140003);
        f.PA().post(new a(i2, j2, j3, (byte) 0));
        AppMethodBeat.o(140003);
    }
}
