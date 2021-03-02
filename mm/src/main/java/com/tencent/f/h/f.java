package com.tencent.f.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.f.h.a;
import com.tencent.f.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public final class f extends a {
    public a RUC = new a((byte) 0);

    public f() {
        AppMethodBeat.i(183372);
        AppMethodBeat.o(183372);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.f.h.a
    public final void onShutdown() {
        AppMethodBeat.i(183373);
        this.RUC.aDv.removeCallbacksAndMessages(null);
        AppMethodBeat.o(183373);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.f.h.a
    public final a.AbstractC0138a hmw() {
        return this.RUC;
    }

    @Override // com.tencent.f.h.d
    public final String getName() {
        return "UIPool";
    }

    @Override // com.tencent.f.h.d
    public final void i(k<?> kVar) {
        AppMethodBeat.i(183374);
        this.RUC.aDv.removeCallbacks(kVar);
        AppMethodBeat.o(183374);
    }

    public static class a implements a.AbstractC0138a {
        public Handler aDv;

        private a() {
            AppMethodBeat.i(183370);
            this.aDv = new Handler(Looper.getMainLooper()) {
                /* class com.tencent.f.h.f.a.AnonymousClass1 */

                public final void dispatchMessage(Message message) {
                    AppMethodBeat.i(183368);
                    if (message.getCallback() == null || !(message.getCallback() instanceof k) || !((k) message.getCallback()).isCancelled()) {
                        super.dispatchMessage(message);
                        AppMethodBeat.o(183368);
                        return;
                    }
                    AppMethodBeat.o(183368);
                }
            };
            AppMethodBeat.o(183370);
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.f.h.a.AbstractC0138a
        public final void h(k<?> kVar) {
            AppMethodBeat.i(183371);
            this.aDv.postDelayed(kVar, kVar.getDelay(TimeUnit.MILLISECONDS));
            AppMethodBeat.o(183371);
        }
    }
}
