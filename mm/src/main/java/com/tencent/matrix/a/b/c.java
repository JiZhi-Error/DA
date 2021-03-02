package com.tencent.matrix.a.b;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.a.b.a;
import com.tencent.matrix.a.b.a.c;
import com.tencent.matrix.a.b.a.e;
import com.tencent.matrix.a.b.a.f;
import com.tencent.matrix.a.b.a.g;
import com.tencent.matrix.a.b.a.i;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public class c implements Handler.Callback, c.a, e.a, f.a, i.b {
    public static long cSk;
    private static long cSl;
    public static long cSm;
    public b cSc;
    public a cSd;
    public final b cSe;
    Callable<String> cSf = new Callable<String>() {
        /* class com.tencent.matrix.a.b.c.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public final /* bridge */ /* synthetic */ String call() {
            return "unknown";
        }
    };
    public volatile boolean cSg = false;
    public boolean cSh = com.tencent.matrix.a.INSTANCE.cPB;
    public boolean cSi;
    public boolean cSj;
    public Handler mHandler;

    /* renamed from: com.tencent.matrix.a.b.c$c  reason: collision with other inner class name */
    public interface AbstractC0217c {
        void Sa();

        void cz(boolean z);
    }

    public class b implements Runnable {
        public int cSp;

        private b() {
            this.cSp = 1;
        }

        /* synthetic */ b(c cVar, byte b2) {
            this();
        }

        public final void run() {
            int i2 = 2;
            if (c.this.cSi) {
                Message obtain = Message.obtain(c.this.mHandler);
                obtain.what = this.cSp;
                obtain.arg1 = 3;
                c.this.mHandler.sendMessageAtFrontOfQueue(obtain);
                if (this.cSp == 2) {
                    i2 = 1;
                }
                this.cSp = i2;
                c.this.mHandler.postDelayed(this, c.cSl);
            }
        }
    }

    public class a implements Runnable {
        int cSo;

        private a() {
            this.cSo = 0;
        }

        public /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        public final void run() {
            this.cSo++;
            com.tencent.matrix.g.c.i("Matrix.battery.BatteryMonitorCore", "#onBackgroundLoopCheck, round = " + this.cSo, new Object[0]);
            if (!c.this.cSh) {
                synchronized (c.class) {
                    for (g gVar : c.this.cSe.cRZ) {
                        gVar.ba(c.cSm * ((long) this.cSo));
                    }
                }
            }
            if (!c.this.cSh) {
                c.this.mHandler.postDelayed(this, c.cSm);
            }
        }
    }

    public c(b bVar) {
        this.cSe = bVar;
        if (bVar.cRJ instanceof a.C0204a) {
            ((a.C0204a) bVar.cRJ).cRw = this;
        }
        if (bVar.cRK != null) {
            this.cSf = bVar.cRK;
        }
        this.mHandler = new Handler(com.tencent.matrix.g.b.TP().getLooper(), this);
        this.cSi = bVar.cRS;
        if (this.cSi) {
            this.cSc = new b(this, (byte) 0);
        }
        this.cSj = bVar.cRT;
        cSk = bVar.cRN;
        cSl = bVar.cRO;
        cSm = bVar.cRP;
        for (g gVar : bVar.cRZ) {
            gVar.d(this);
        }
    }

    public boolean handleMessage(Message message) {
        boolean z;
        if (message.what == 1) {
            com.tencent.matrix.g.c.d("Matrix.battery.BatteryMonitorCore", "#onTraceBegin", new Object[0]);
            this.cSe.cRJ.Sa();
            return true;
        } else if (message.what != 2) {
            return false;
        } else {
            if (message.arg1 == 3) {
                z = true;
            } else {
                z = false;
            }
            com.tencent.matrix.g.c.d("Matrix.battery.BatteryMonitorCore", "#onTraceEnd", new Object[0]);
            this.cSe.cRJ.cz(z);
            return true;
        }
    }

    public final <T extends g> T aa(Class<T> cls) {
        Iterator<g> it = this.cSe.cRZ.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (cls.isAssignableFrom(t.getClass())) {
                return t;
            }
        }
        return null;
    }

    public final boolean Sd() {
        boolean z;
        synchronized (c.class) {
            z = this.cSg;
        }
        return z;
    }

    public static Context getContext() {
        return com.tencent.matrix.b.RG().application;
    }

    public final String getScene() {
        try {
            return this.cSf.call();
        } catch (Exception e2) {
            return "unknown";
        }
    }

    public static int aW(Context context) {
        try {
            return com.tencent.matrix.a.c.c.ba(context);
        } catch (Throwable th) {
            com.tencent.matrix.g.c.printErrStackTrace("Matrix.battery.BatteryMonitorCore", th, "#currentBatteryTemperature error", new Object[0]);
            return 0;
        }
    }

    @Override // com.tencent.matrix.a.b.a.f.a
    public final void a(Thread thread, List<f.c> list) {
        com.tencent.matrix.g.c.d("Matrix.battery.BatteryMonitorCore", "#onTaskTrace, thread = " + thread.getName(), new Object[0]);
        this.cSe.cRJ.a(thread, list);
    }

    @Override // com.tencent.matrix.a.b.a.i.b
    public final void a(int i2, i.d.b bVar) {
        com.tencent.matrix.g.c.d("Matrix.battery.BatteryMonitorCore", "#onWakeLockTimeout, tag = " + bVar.tag + ", pkg = " + bVar.packageName + ", count = " + i2, new Object[0]);
        this.cSe.cRJ.a(i2, bVar);
    }

    @Override // com.tencent.matrix.a.b.a.i.b
    public final void a(i.d.b bVar, long j2) {
        com.tencent.matrix.g.c.d("Matrix.battery.BatteryMonitorCore", "#onWakeLockTimeout, tag = " + bVar.tag + ", pkg = " + bVar.packageName + ", backgroundMillis = " + j2, new Object[0]);
        this.cSe.cRJ.a(bVar, j2);
    }

    @Override // com.tencent.matrix.a.b.a.e.a
    public final void ce(int i2, int i3) {
        com.tencent.matrix.g.c.d("Matrix.battery.BatteryMonitorCore", "#onParseError, tid = ".concat(String.valueOf(i3)), new Object[0]);
        this.cSe.cRJ.ce(i2, i3);
    }

    @Override // com.tencent.matrix.a.b.a.c.a
    public final void a(boolean z, int i2, int i3, ComponentName componentName, long j2) {
        this.cSe.cRJ.a(z, i2, i3, componentName, j2);
    }
}
