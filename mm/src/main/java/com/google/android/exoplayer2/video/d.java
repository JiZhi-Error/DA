package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(16)
public final class d {
    final a bIE;
    final boolean bIF;
    final long bIG;
    final long bIH;
    long bII;
    long bIJ;
    long bIK;
    boolean bIL;
    long bIM;
    long bIN;
    long bIO;

    public d() {
        this(-1.0d);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(android.content.Context r4) {
        /*
            r3 = this;
            r2 = 93306(0x16c7a, float:1.3075E-40)
            java.lang.String r0 = "window"
            java.lang.Object r0 = r4.getSystemService(r0)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r1 = r0.getDefaultDisplay()
            if (r1 == 0) goto L_0x0025
            android.view.Display r0 = r0.getDefaultDisplay()
            float r0 = r0.getRefreshRate()
            double r0 = (double) r0
        L_0x001b:
            r3.<init>(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        L_0x0025:
            r0 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.d.<init>(android.content.Context):void");
    }

    private d(double d2) {
        AppMethodBeat.i(93307);
        this.bIF = d2 != -1.0d;
        if (this.bIF) {
            this.bIE = a.xB();
            this.bIG = (long) (1.0E9d / d2);
            this.bIH = (this.bIG * 80) / 100;
            AppMethodBeat.o(93307);
            return;
        }
        this.bIE = null;
        this.bIG = -1;
        this.bIH = -1;
        AppMethodBeat.o(93307);
    }

    /* access modifiers changed from: package-private */
    public final boolean m(long j2, long j3) {
        AppMethodBeat.i(93308);
        if (Math.abs((j3 - this.bIM) - (j2 - this.bIN)) > 20000000) {
            AppMethodBeat.o(93308);
            return true;
        }
        AppMethodBeat.o(93308);
        return false;
    }

    static final class a implements Handler.Callback, Choreographer.FrameCallback {
        private static final a bIQ = new a();
        public volatile long bIP;
        private final HandlerThread bIR = new HandlerThread("ChoreographerOwner:Handler");
        private int bIS;
        private Choreographer choreographer;
        final Handler handler;

        static {
            AppMethodBeat.i(93305);
            AppMethodBeat.o(93305);
        }

        public static a xB() {
            return bIQ;
        }

        private a() {
            AppMethodBeat.i(93302);
            this.bIR.start();
            this.handler = new Handler(this.bIR.getLooper(), this);
            this.handler.sendEmptyMessage(0);
            AppMethodBeat.o(93302);
        }

        public final void doFrame(long j2) {
            AppMethodBeat.i(93303);
            this.bIP = j2;
            this.choreographer.postFrameCallbackDelayed(this, 500);
            AppMethodBeat.o(93303);
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(93304);
            switch (message.what) {
                case 0:
                    this.choreographer = Choreographer.getInstance();
                    AppMethodBeat.o(93304);
                    return true;
                case 1:
                    this.bIS++;
                    if (this.bIS == 1) {
                        this.choreographer.postFrameCallback(this);
                    }
                    AppMethodBeat.o(93304);
                    return true;
                case 2:
                    this.bIS--;
                    if (this.bIS == 0) {
                        this.choreographer.removeFrameCallback(this);
                        this.bIP = 0;
                    }
                    AppMethodBeat.o(93304);
                    return true;
                default:
                    AppMethodBeat.o(93304);
                    return false;
            }
        }
    }
}
