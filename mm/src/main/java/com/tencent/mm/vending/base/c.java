package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    private Looper QZA;
    private Handler QZB;
    byte[] QZC = new byte[0];
    a QZD;
    private Handler mVendingHandler;
    private Looper mVendingLooper;

    public interface a {
        void hds();

        void hdt();

        void synchronizing(int i2, Object obj);
    }

    public c(Looper looper, Looper looper2) {
        AppMethodBeat.i(74945);
        this.QZA = looper;
        this.mVendingLooper = looper2;
        this.QZB = new Handler(this.QZA) {
            /* class com.tencent.mm.vending.base.c.AnonymousClass1 */

            public final void handleMessage(Message message) {
                AppMethodBeat.i(74959);
                c.this.t(message.what, message.obj);
                AppMethodBeat.o(74959);
            }
        };
        this.mVendingHandler = new Handler(this.mVendingLooper) {
            /* class com.tencent.mm.vending.base.c.AnonymousClass2 */

            public final void handleMessage(Message message) {
                AppMethodBeat.i(74950);
                synchronized (c.this.QZC) {
                    try {
                        if (c.this.QZD != null) {
                            c.this.QZD.synchronizing(message.what, message.obj);
                        }
                        c.this.QZC.notify();
                    } finally {
                        AppMethodBeat.o(74950);
                    }
                }
            }
        };
        AppMethodBeat.o(74945);
    }

    public final void t(int i2, Object obj) {
        AppMethodBeat.i(74946);
        if (Looper.myLooper() == this.QZA) {
            if (this.QZD == null) {
                com.tencent.mm.vending.f.a.w("Vending.VendingSync", "This call is pointless.", new Object[0]);
                AppMethodBeat.o(74946);
                return;
            }
            this.QZD.hds();
            synchronized (this.QZC) {
                try {
                    this.mVendingHandler.sendMessageAtFrontOfQueue(this.mVendingHandler.obtainMessage(i2, obj));
                    try {
                        this.QZC.wait();
                    } catch (InterruptedException e2) {
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(74946);
                    throw th;
                }
            }
            this.QZD.hdt();
            AppMethodBeat.o(74946);
        } else if (Looper.myLooper() == this.mVendingLooper) {
            this.QZB.sendMessageAtFrontOfQueue(this.QZB.obtainMessage(i2, obj));
            AppMethodBeat.o(74946);
        } else {
            AppMethodBeat.o(74946);
        }
    }
}
