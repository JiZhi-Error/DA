package com.tencent.matrix.a.b.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Handler;
import android.util.Log;
import com.tencent.matrix.a.b.a.g;
import com.tencent.matrix.a.c.a;

public final class b extends a implements a.b {
    public final a cSr = new a();
    Handler handler;

    public static class c extends g.a<c> {
        public g.a.c.b<Integer> cSA;
        public g.a.c.b<Integer> cSB;
        public g.a.c.b<Integer> cSC;
        public g.a.c.C0216c<g.a.c.C0212a<C0206b>> cSD;
        public g.a.c.b<Integer> cSz;
    }

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void d(com.tencent.matrix.a.b.c cVar) {
        super.d(cVar);
        this.handler = cVar.mHandler;
    }

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void Se() {
        super.Se();
        com.tencent.matrix.a.c.a.a(this);
    }

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void Sf() {
        super.Sf();
        com.tencent.matrix.a.c.a.b(this);
        this.handler.removeCallbacksAndMessages(null);
        a aVar = this.cSr;
        aVar.cSs = 0;
        aVar.cSt = 0;
        aVar.cSu = 0;
        aVar.cSv = 0;
    }

    @Override // com.tencent.matrix.a.b.a.g
    public final int Sg() {
        return Integer.MIN_VALUE;
    }

    @Override // com.tencent.matrix.a.c.a.b
    public final void a(int i2, long j2, long j3, long j4, int i3, PendingIntent pendingIntent, AlarmManager.OnAlarmListener onAlarmListener) {
        String str = "";
        if (this.cSq.cSe.cRV) {
            str = com.tencent.matrix.a.c.c.K(Log.getStackTraceString(new Throwable()), "at android.app.AlarmManager");
        }
        com.tencent.matrix.g.c.i("Matrix.battery.AlarmMonitorFeature", "#onAlarmSet, target = ".concat(String.valueOf(new C0206b(i2, j2, j3, j4, i3, str))), new Object[0]);
        if (pendingIntent != null || onAlarmListener != null) {
            if (pendingIntent != null) {
                pendingIntent.hashCode();
            } else {
                onAlarmListener.hashCode();
            }
            a aVar = this.cSr;
            synchronized (aVar.mLock) {
                aVar.cSs++;
                aVar.cSt++;
            }
        }
    }

    @Override // com.tencent.matrix.a.c.a.b
    public final void a(PendingIntent pendingIntent, AlarmManager.OnAlarmListener onAlarmListener) {
        if (pendingIntent != null || onAlarmListener != null) {
            if (pendingIntent != null) {
                pendingIntent.hashCode();
            } else {
                onAlarmListener.hashCode();
            }
            a aVar = this.cSr;
            synchronized (aVar.mLock) {
                aVar.cSt--;
            }
        }
    }

    /* renamed from: com.tencent.matrix.a.b.a.b$b  reason: collision with other inner class name */
    public static class C0206b {
        public final long cQq;
        public final long cQr;
        public final long cSw;
        public final int cSx;
        public final long cSy = System.currentTimeMillis();
        public final String stack;
        public final int type;

        public C0206b(int i2, long j2, long j3, long j4, int i3, String str) {
            this.type = i2;
            this.cQq = j2;
            this.cSw = j3;
            this.cQr = j4;
            this.cSx = i3;
            this.stack = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return hashCode() == ((C0206b) obj).hashCode();
        }

        public final String toString() {
            return "AlarmRecord{type=" + this.type + ", triggerAtMillis=" + this.cQq + ", windowMillis=" + this.cSw + ", intervalMillis=" + this.cQr + ", flag=" + this.cSx + ", timeBgn=" + this.cSy + ", stack='" + this.stack + '\'' + '}';
        }
    }

    public static final class a {
        int cSs;
        int cSt;
        int cSu;
        int cSv;
        final byte[] mLock = new byte[0];

        public final c Sh() {
            c cVar = new c();
            synchronized (this.mLock) {
                cVar.cSz = g.a.c.b.b(Integer.valueOf(this.cSs));
                cVar.cSA = g.a.c.b.b(Integer.valueOf(this.cSt));
                cVar.cSB = g.a.c.b.b(Integer.valueOf(this.cSu));
                cVar.cSC = g.a.c.b.b(Integer.valueOf(this.cSv));
                cVar.cSD = g.a.c.C0216c.Sn();
            }
            return cVar;
        }
    }
}
