package com.tencent.i.a.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.h.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class a {
    public Handler Son;
    public HandlerThread mHandlerThread;

    public a(String str) {
        hI(str, 0);
    }

    public a(String str, byte b2) {
        hI(str, 5);
    }

    private void hI(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            str = "worker_thread";
        }
        this.mHandlerThread = new HandlerThread(str, i2);
        this.mHandlerThread.start();
        this.Son = new Handler(this.mHandlerThread.getLooper()) {
            /* class com.tencent.i.a.a.a.AnonymousClass1 */

            public final void handleMessage(Message message) {
                AppMethodBeat.i(214682);
                try {
                    a.this.q(message);
                    AppMethodBeat.o(214682);
                } catch (Throwable th) {
                    h.i("sensor_AsyncWorker", "[method: handleMessage ] e: " + th.getCause());
                    a.this.q(th);
                    AppMethodBeat.o(214682);
                }
            }
        };
    }

    public void q(Message message) {
    }

    public void q(Throwable th) {
    }

    /* access modifiers changed from: protected */
    public final void hqd() {
        u(2, null);
    }

    /* access modifiers changed from: protected */
    public final void u(int i2, Object obj) {
        if (this.Son != null) {
            j(i2, -1, obj);
        }
    }

    /* access modifiers changed from: protected */
    public final void j(int i2, int i3, Object obj) {
        if (this.Son != null) {
            k(i2, i3, obj);
        }
    }

    private void k(int i2, int i3, Object obj) {
        if (this.Son != null) {
            b(i2, i3, obj, 0);
        }
    }

    /* access modifiers changed from: protected */
    public final void b(int i2, int i3, Object obj, long j2) {
        if (this.Son != null) {
            Message obtainMessage = this.Son.obtainMessage();
            obtainMessage.what = i2;
            obtainMessage.arg1 = i3;
            obtainMessage.arg2 = -1;
            obtainMessage.obj = obj;
            this.Son.sendMessageDelayed(obtainMessage, j2);
        }
    }

    /* access modifiers changed from: protected */
    public final void asB(int i2) {
        if (this.Son != null && this.Son != null && this.Son != null) {
            Message obtainMessage = this.Son.obtainMessage();
            obtainMessage.what = i2;
            obtainMessage.arg1 = -1;
            obtainMessage.arg2 = -1;
            obtainMessage.obj = null;
            this.Son.sendMessageAtFrontOfQueue(obtainMessage);
        }
    }

    public final void a(com.tencent.h.a.a aVar) {
        if (aVar != null) {
            this.Son.removeCallbacks(aVar);
        }
    }
}
