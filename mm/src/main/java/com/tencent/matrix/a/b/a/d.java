package com.tencent.matrix.a.b.a;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.a.b.a.c;
import com.tencent.matrix.a.b.a.g;
import com.tencent.matrix.a.c.h;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class d extends a {
    List<h.a> cSI = Collections.emptyList();
    Runnable cSK = new Runnable() {
        /* class com.tencent.matrix.a.b.a.d.AnonymousClass1 */

        public final void run() {
            if (d.this.cSI.size() >= d.this.cSq.cSe.cRQ) {
                synchronized ("Matrix.battery.DeviceStatusMonitorFeature") {
                    h.K(d.this.cSI);
                }
            }
        }
    };
    private c cSQ;

    public static class a extends g.a<a> {
        public g.a.c.b<Integer> cSS;
    }

    public static class b extends g.a<b> {
        public g.a.c.C0216c<g.a.c.b<Integer>> cSU;
    }

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void d(com.tencent.matrix.a.b.c cVar) {
        super.d(cVar);
        this.cSQ = new c();
    }

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void Se() {
        super.Se();
        c.C0207c cVar = new c.C0207c(com.tencent.matrix.a.c.c.bb(com.tencent.matrix.a.b.c.getContext()));
        synchronized ("Matrix.battery.DeviceStatusMonitorFeature") {
            this.cSI = new ArrayList();
            this.cSI.add(0, cVar);
        }
        this.cSQ.cSW = new android.support.v4.e.c<Integer>() {
            /* class com.tencent.matrix.a.b.a.d.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.support.v4.e.c
            @SuppressLint({"VisibleForTests"})
            public final /* synthetic */ void accept(Integer num) {
                Integer num2 = num;
                synchronized ("Matrix.battery.DeviceStatusMonitorFeature") {
                    if (d.this.cSI != Collections.EMPTY_LIST) {
                        d.this.cSI.add(0, new h.a(String.valueOf(num2)));
                        d.a(d.this);
                    }
                }
            }
        };
        this.cSQ.aY(com.tencent.matrix.a.b.c.getContext());
    }

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void Sf() {
        super.Sf();
        c cVar = this.cSQ;
        Context context = com.tencent.matrix.a.b.c.getContext();
        if (cVar.cSZ) {
            try {
                context.unregisterReceiver(cVar);
            } catch (Throwable th) {
            }
            cVar.cSZ = false;
        }
    }

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void onForeground(boolean z) {
        super.onForeground(z);
        if (!z && !this.cSQ.cSZ) {
            this.cSQ.aY(com.tencent.matrix.a.b.c.getContext());
        }
    }

    @Override // com.tencent.matrix.a.b.a.g
    public final int Sg() {
        return Integer.MAX_VALUE;
    }

    public static b Sl() {
        b bVar = new b();
        try {
            bVar.cSU = g.a.c.C0216c.r(com.tencent.matrix.a.c.c.Sq());
        } catch (Throwable th) {
            com.tencent.matrix.g.c.printErrStackTrace("Matrix.battery.DeviceStatusMonitorFeature", th, "#currentCpuFreq error", new Object[0]);
            bVar.cSU = g.a.c.C0216c.r(new int[0]);
        }
        return bVar;
    }

    public static a aX(Context context) {
        a aVar = new a();
        aVar.cSS = g.a.c.b.b(Integer.valueOf(com.tencent.matrix.a.b.c.aW(context)));
        return aVar;
    }

    public final C0208d bd(long j2) {
        try {
            h.a aVar = new h.a(String.valueOf(com.tencent.matrix.a.c.c.bb(com.tencent.matrix.a.b.c.getContext())));
            synchronized ("Matrix.battery.DeviceStatusMonitorFeature") {
                if (this.cSI != Collections.EMPTY_LIST) {
                    this.cSI.add(0, aVar);
                }
            }
            h.b a2 = h.a(this.cSI, j2);
            C0208d dVar = new C0208d();
            dVar.cTq = a2.cTq;
            dVar.cSM = g.a.c.b.b(Long.valueOf(a2.cUw));
            dVar.cTb = g.a.c.b.b(Long.valueOf((long) a2.ex("1")));
            dVar.cTc = g.a.c.b.b(Long.valueOf((long) a2.ex(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)));
            return dVar;
        } catch (Throwable th) {
            com.tencent.matrix.g.c.w("Matrix.battery.DeviceStatusMonitorFeature", "configureSnapshot fail: " + th.getMessage(), new Object[0]);
            C0208d dVar2 = new C0208d();
            dVar2.cTq = false;
            return dVar2;
        }
    }

    static final class c extends BroadcastReceiver {
        android.support.v4.e.c<Integer> cSW = new android.support.v4.e.c<Integer>() {
            /* class com.tencent.matrix.a.b.a.d.c.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.support.v4.e.c
            public final /* bridge */ /* synthetic */ void accept(Integer num) {
            }
        };
        boolean cSX = false;
        boolean cSY = false;
        boolean cSZ = false;

        c() {
        }

        public final void onReceive(Context context, Intent intent) {
            boolean z = false;
            String action = intent.getAction();
            if (action == null) {
                return;
            }
            if (action.equals("android.intent.action.BATTERY_CHANGED")) {
                int intExtra = intent.getIntExtra("plugged", -1);
                if (intExtra == 1 || intExtra == 2 || intExtra == 4) {
                    z = true;
                }
                this.cSX = z;
                updateStatus();
            } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                this.cSY = true;
                updateStatus();
            } else if (action.equals("android.intent.action.SCREEN_ON")) {
                this.cSY = false;
                updateStatus();
            }
        }

        private void updateStatus() {
            this.cSW.accept(Integer.valueOf(this.cSX ? 1 : this.cSY ? 3 : 2));
        }

        public final boolean aY(Context context) {
            if (this.cSZ) {
                return true;
            }
            try {
                IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                context.registerReceiver(this, intentFilter);
                this.cSZ = true;
                return true;
            } catch (Throwable th) {
            }
            this.cSZ = false;
            return false;
        }
    }

    /* renamed from: com.tencent.matrix.a.b.a.d$d  reason: collision with other inner class name */
    public static final class C0208d extends g.a<C0208d> {
        public g.a.c.b<Long> cSM = g.a.c.b.b(0L);
        public g.a.c.b<Long> cTb = g.a.c.b.b(0L);
        public g.a.c.b<Long> cTc = g.a.c.b.b(0L);

        C0208d() {
        }
    }

    static /* synthetic */ void a(d dVar) {
        dVar.cSq.mHandler.removeCallbacks(dVar.cSK);
        dVar.cSq.mHandler.postDelayed(dVar.cSK, 1000);
    }
}
