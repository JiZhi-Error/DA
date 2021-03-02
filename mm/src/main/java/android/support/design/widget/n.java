package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

final class n {
    private static n tI;
    private final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        /* class android.support.design.widget.n.AnonymousClass1 */

        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    n nVar = n.this;
                    b bVar = (b) message.obj;
                    synchronized (nVar.lock) {
                        if (nVar.tJ == bVar || nVar.tK == bVar) {
                            nVar.a(bVar);
                        }
                    }
                    return true;
                default:
                    return false;
            }
        }
    });
    final Object lock = new Object();
    b tJ;
    b tK;

    /* access modifiers changed from: package-private */
    public interface a {
    }

    static n cV() {
        if (tI == null) {
            tI = new n();
        }
        return tI;
    }

    private n() {
    }

    public final void a(a aVar) {
        synchronized (this.lock) {
            if (e(aVar)) {
                b(this.tJ);
            }
        }
    }

    public final void b(a aVar) {
        synchronized (this.lock) {
            if (e(aVar) && !this.tJ.tN) {
                this.tJ.tN = true;
                this.handler.removeCallbacksAndMessages(this.tJ);
            }
        }
    }

    public final void c(a aVar) {
        synchronized (this.lock) {
            if (e(aVar) && this.tJ.tN) {
                this.tJ.tN = false;
                b(this.tJ);
            }
        }
    }

    public final boolean d(a aVar) {
        boolean z;
        synchronized (this.lock) {
            z = e(aVar) || f(aVar);
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public static class b {
        int duration;
        final WeakReference<a> tM;
        boolean tN;

        /* access modifiers changed from: package-private */
        public final boolean g(a aVar) {
            return aVar != null && this.tM.get() == aVar;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(b bVar) {
        if (bVar.tM.get() == null) {
            return false;
        }
        this.handler.removeCallbacksAndMessages(bVar);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean e(a aVar) {
        return this.tJ != null && this.tJ.g(aVar);
    }

    /* access modifiers changed from: package-private */
    public final boolean f(a aVar) {
        return this.tK != null && this.tK.g(aVar);
    }

    private void b(b bVar) {
        if (bVar.duration != -2) {
            int i2 = 2750;
            if (bVar.duration > 0) {
                i2 = bVar.duration;
            } else if (bVar.duration == -1) {
                i2 = 1500;
            }
            this.handler.removeCallbacksAndMessages(bVar);
            this.handler.sendMessageDelayed(Message.obtain(this.handler, 0, bVar), (long) i2);
        }
    }
}
