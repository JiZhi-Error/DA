package android.support.a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.e.n;
import android.view.Choreographer;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
public final class a {
    public static final ThreadLocal<a> fw = new ThreadLocal<>();
    private c fA;
    long fB = 0;
    boolean fC = false;
    final n<b, Long> fx = new n<>();
    final ArrayList<b> fy = new ArrayList<>();
    private final C0003a fz = new C0003a();

    /* access modifiers changed from: package-private */
    public interface b {
        boolean d(long j2);
    }

    a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: android.support.a.a$a  reason: collision with other inner class name */
    public class C0003a {
        C0003a() {
        }

        /* access modifiers changed from: package-private */
        public final void aF() {
            boolean z;
            a.this.fB = SystemClock.uptimeMillis();
            a aVar = a.this;
            long j2 = a.this.fB;
            long uptimeMillis = SystemClock.uptimeMillis();
            for (int i2 = 0; i2 < aVar.fy.size(); i2++) {
                b bVar = aVar.fy.get(i2);
                if (bVar != null) {
                    Long l = aVar.fx.get(bVar);
                    if (l == null) {
                        z = true;
                    } else if (l.longValue() < uptimeMillis) {
                        aVar.fx.remove(bVar);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        bVar.d(j2);
                    }
                }
            }
            if (aVar.fC) {
                for (int size = aVar.fy.size() - 1; size >= 0; size--) {
                    if (aVar.fy.get(size) == null) {
                        aVar.fy.remove(size);
                    }
                }
                aVar.fC = false;
            }
            if (a.this.fy.size() > 0) {
                a.this.aE().aG();
            }
        }
    }

    public static a aD() {
        if (fw.get() == null) {
            fw.set(new a());
        }
        return fw.get();
    }

    /* access modifiers changed from: package-private */
    public final c aE() {
        if (this.fA == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.fA = new e(this.fz);
            } else {
                this.fA = new d(this.fz);
            }
        }
        return this.fA;
    }

    public final void a(b bVar) {
        this.fx.remove(bVar);
        int indexOf = this.fy.indexOf(bVar);
        if (indexOf >= 0) {
            this.fy.set(indexOf, null);
            this.fC = true;
        }
    }

    /* access modifiers changed from: package-private */
    public static class e extends c {
        private final Choreographer fH = Choreographer.getInstance();
        private final Choreographer.FrameCallback fI = new Choreographer.FrameCallback() {
            /* class android.support.a.a.e.AnonymousClass1 */

            public final void doFrame(long j2) {
                e.this.fE.aF();
            }
        };

        e(C0003a aVar) {
            super(aVar);
        }

        /* access modifiers changed from: package-private */
        @Override // android.support.a.a.c
        public final void aG() {
            this.fH.postFrameCallback(this.fI);
        }
    }

    /* access modifiers changed from: package-private */
    public static class d extends c {
        long fF = -1;
        private final Handler mHandler = new Handler(Looper.myLooper());
        private final Runnable mRunnable = new Runnable() {
            /* class android.support.a.a.d.AnonymousClass1 */

            public final void run() {
                d.this.fF = SystemClock.uptimeMillis();
                d.this.fE.aF();
            }
        };

        d(C0003a aVar) {
            super(aVar);
        }

        /* access modifiers changed from: package-private */
        @Override // android.support.a.a.c
        public final void aG() {
            this.mHandler.postDelayed(this.mRunnable, Math.max(10 - (SystemClock.uptimeMillis() - this.fF), 0L));
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class c {
        final C0003a fE;

        /* access modifiers changed from: package-private */
        public abstract void aG();

        c(C0003a aVar) {
            this.fE = aVar;
        }
    }
}
