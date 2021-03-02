package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k {
    volatile boolean mCE = false;
    int mCF = 1000;
    Handler mCG;
    b mCH;
    a mCI = new a(this, (byte) 0);

    /* access modifiers changed from: package-private */
    public interface b {
        void awp();
    }

    k(Handler handler) {
        AppMethodBeat.i(235052);
        this.mCG = handler;
        AppMethodBeat.o(235052);
    }

    /* access modifiers changed from: package-private */
    public final void start() {
        AppMethodBeat.i(235053);
        if (!this.mCE) {
            this.mCE = true;
            this.mCI.bKM();
        }
        AppMethodBeat.o(235053);
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(k kVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(235050);
            if (k.this.mCH != null) {
                k.this.mCH.awp();
            }
            if (k.this.mCE) {
                bKM();
            }
            AppMethodBeat.o(235050);
        }

        /* access modifiers changed from: package-private */
        public final void bKM() {
            AppMethodBeat.i(235051);
            k.this.mCG.postDelayed(k.this.mCI, (long) k.this.mCF);
            AppMethodBeat.o(235051);
        }
    }
}
