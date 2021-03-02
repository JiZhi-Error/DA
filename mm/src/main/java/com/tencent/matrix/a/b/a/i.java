package com.tencent.matrix.a.b.a;

import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.os.WorkSource;
import com.tencent.matrix.a.b.a.g;
import com.tencent.matrix.a.c.d;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class i extends a implements d.b {
    long cTF;
    final Map<IBinder, d> cTG = new ConcurrentHashMap(2);
    public final a cTH = new a();

    public interface b {
        @Deprecated
        void a(int i2, d.b bVar);

        void a(d.b bVar, long j2);
    }

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void d(com.tencent.matrix.a.b.c cVar) {
        super.d(cVar);
        this.cTF = cVar.cSe.cRL;
    }

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void Se() {
        super.Se();
        com.tencent.matrix.a.c.d.a(this);
    }

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void Sf() {
        super.Sf();
        com.tencent.matrix.a.c.d.b(this);
        this.cSq.mHandler.removeCallbacksAndMessages(null);
        this.cTG.clear();
    }

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void ba(long j2) {
        super.ba(j2);
        if (!this.cTG.isEmpty()) {
            for (d dVar : this.cTG.values()) {
                if (!dVar.cTP.isFinished() && es(dVar.cTP.tag)) {
                    this.cSq.a(dVar.cTP, j2);
                }
            }
        }
    }

    @Override // com.tencent.matrix.a.b.a.g
    public final int Sg() {
        return Integer.MIN_VALUE;
    }

    @Override // com.tencent.matrix.a.c.d.b
    public final void a(IBinder iBinder, int i2, String str, String str2, WorkSource workSource, String str3) {
        String stackTraceToString = es(str) ? com.tencent.matrix.a.c.c.stackTraceToString(new Throwable().getStackTrace()) : "";
        com.tencent.matrix.g.c.i("Matrix.battery.WakeLockMonitorFeature", "[onAcquireWakeLock] token=%s flags=%s tag=%s historyTag=%s packageName=%s workSource=%s stack=%s", String.valueOf(iBinder), Integer.valueOf(i2), str, str3, str2, workSource, stackTraceToString);
        d dVar = this.cTG.get(iBinder);
        if (dVar != null) {
            dVar.c(this.cSq.mHandler);
        }
        final d dVar2 = new d(iBinder, str, i2, str2, stackTraceToString);
        dVar2.cTT = new d.a() {
            /* class com.tencent.matrix.a.b.a.i.AnonymousClass1 */

            @Override // com.tencent.matrix.a.b.a.i.d.a
            public final void b(int i2, d.b bVar) {
                boolean z;
                i.this.cSq.a(i2, bVar);
                d dVar = dVar2;
                if (dVar.cTQ >= dVar.cTR) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    dVar2.c(i.this.cSq.mHandler);
                    Iterator<Map.Entry<IBinder, d>> it = i.this.cTG.entrySet().iterator();
                    while (it.hasNext()) {
                        if (it.next().getValue() == dVar2) {
                            it.remove();
                            return;
                        }
                    }
                }
            }
        };
        Handler handler = this.cSq.mHandler;
        long j2 = this.cTF;
        if (dVar2.cTS != null || dVar2.cTP.isFinished()) {
            com.tencent.matrix.g.c.w("Matrix.battery.WakeLockMonitorFeature", "cant not start tracing of wakelock, target = " + dVar2.cTP, new Object[0]);
        } else {
            dVar2.cTQ = 0;
            dVar2.cTS = new Runnable(handler, j2) {
                /* class com.tencent.matrix.a.b.a.i.d.AnonymousClass1 */
                final /* synthetic */ Handler NE;
                final /* synthetic */ long cQV;

                {
                    this.NE = r3;
                    this.cQV = r4;
                }

                public final void run() {
                    d.this.cTQ++;
                    if (d.this.cTT != null) {
                        d.this.cTT.b(d.this.cTQ, d.this.cTP);
                    }
                    if (d.this.cTQ < d.this.cTR) {
                        this.NE.postDelayed(this, this.cQV);
                    }
                }
            };
            handler.postDelayed(dVar2.cTS, j2);
        }
        this.cTG.put(iBinder, dVar2);
        et(dVar2.cTP.tag);
    }

    @Override // com.tencent.matrix.a.c.d.b
    public final void a(IBinder iBinder, int i2) {
        d dVar;
        com.tencent.matrix.g.c.i("Matrix.battery.WakeLockMonitorFeature", "[onReleaseWakeLock] token=%s flags=%s", Integer.valueOf(iBinder.hashCode()), Integer.valueOf(i2));
        Iterator<Map.Entry<IBinder, d>> it = this.cTG.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                dVar = null;
                break;
            }
            Map.Entry<IBinder, d> next = it.next();
            if (next.getKey() == iBinder) {
                dVar = next.getValue();
                it.remove();
                break;
            }
        }
        if (dVar != null) {
            dVar.c(this.cSq.mHandler);
            a aVar = this.cTH;
            d.b bVar = dVar.cTP;
            synchronized (aVar.mLock) {
                aVar.mCount++;
                aVar.cTK += bVar.Sp();
            }
            String str = dVar.cTP.tag;
            com.tencent.matrix.g.c.i("Matrix.battery.WakeLockMonitorFeature", "[onReleaseWakeLock] tag = " + str + ", stack = " + (es(str) ? com.tencent.matrix.a.c.c.stackTraceToString(new Throwable().getStackTrace()) : ""), new Object[0]);
            et(str);
            return;
        }
        com.tencent.matrix.g.c.w("Matrix.battery.WakeLockMonitorFeature", "missing tracking, token = ".concat(String.valueOf(iBinder)), new Object[0]);
    }

    private boolean es(String str) {
        boolean z;
        if ((com.tencent.matrix.a.b.c.getContext().getApplicationInfo().flags & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        return z || !this.cSq.cSe.cRX.contains(str) || this.cSq.cSe.cRY.contains(str);
    }

    private void et(String str) {
        if (this.cSq.cSe.cRY.contains(str)) {
            com.tencent.matrix.g.c.w("Matrix.battery.WakeLockMonitorFeature", "dump wakelocks tracing for tag '" + str + "':", new Object[0]);
            for (d dVar : this.cTG.values()) {
                if (dVar.cTP.tag.equalsIgnoreCase(str)) {
                    com.tencent.matrix.g.c.w("Matrix.battery.WakeLockMonitorFeature", " - " + dVar.cTP, new Object[0]);
                }
            }
        }
    }

    public static class d {
        final b cTP;
        int cTQ;
        int cTR = 30;
        Runnable cTS;
        a cTT;
        final IBinder token;

        public interface a {
            void b(int i2, b bVar);
        }

        d(IBinder iBinder, String str, int i2, String str2, String str3) {
            this.token = iBinder;
            this.cTP = new b(str, i2, str2, str3);
        }

        public final void c(Handler handler) {
            if (this.cTS != null) {
                handler.removeCallbacks(this.cTS);
                this.cTS = null;
            }
            this.cTP.cTV = SystemClock.uptimeMillis();
        }

        public final int hashCode() {
            return this.token.hashCode();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            return this.token.equals(obj);
        }

        public static class b {
            public final long cSy;
            public long cTV = 0;
            public final int flags;
            public final String packageName;
            public final String stack;
            public final String tag;

            public b(String str, int i2, String str2, String str3) {
                this.flags = i2;
                this.tag = str;
                this.packageName = str2;
                this.stack = str3;
                this.cSy = SystemClock.uptimeMillis();
            }

            public final boolean isFinished() {
                return this.cTV >= this.cSy;
            }

            public final long Sp() {
                long uptimeMillis = isFinished() ? this.cTV - this.cSy : SystemClock.uptimeMillis() - this.cSy;
                if (uptimeMillis > 0) {
                    return uptimeMillis;
                }
                return 0;
            }

            public final String toString() {
                return "WakeLockRecord{flags=" + this.flags + ", tag='" + this.tag + '\'' + ", packageName='" + this.packageName + '\'' + ", stack='" + this.stack + '\'' + ", timeBgn=" + this.cSy + ", timeEnd=" + this.cTV + '}';
            }
        }
    }

    public static final class a {
        long cTK;
        int mCount;
        final byte[] mLock = new byte[0];

        public final c So() {
            c cVar = new c();
            cVar.cTM = g.a.c.b.b(Integer.valueOf(this.mCount));
            cVar.cTL = g.a.c.b.b(Long.valueOf(this.cTK));
            cVar.cTN = g.a.c.C0216c.Sn();
            return cVar;
        }
    }

    public static class c extends g.a<c> {
        public g.a.c.b<Long> cTL;
        public g.a.c.b<Integer> cTM;
        public g.a.c.C0216c<g.a.c.C0212a<d.b>> cTN;

        c() {
        }
    }
}
