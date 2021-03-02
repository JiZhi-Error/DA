package com.tencent.luggage.game.e;

import android.util.SparseIntArray;
import com.tencent.luggage.a.e;
import com.tencent.magicbrush.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class a {
    private static a cxH;
    public String appId = "";
    public ArrayList<String> cxA;
    public boolean cxB;
    public int cxC;
    public double cxD;
    public int cxE = 1004;
    public CopyOnWriteArrayList<Long> cxF = new CopyOnWriteArrayList<>();
    private final C0172a cxG = new C0172a((byte) 0);
    public h.c cxI = new h.c() {
        /* class com.tencent.luggage.game.e.a.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.appbrand.h.c
        public final void onCreate() {
            AppMethodBeat.i(130689);
            Log.i("MicroMsg.MBNiReporter", "hy: onCreate");
            a.e(a.this);
            AppMethodBeat.o(130689);
        }

        @Override // com.tencent.mm.plugin.appbrand.h.c
        public final void onResume() {
            AppMethodBeat.i(130690);
            Log.i("MicroMsg.MBNiReporter", "hy: onResume");
            AppMethodBeat.o(130690);
        }

        @Override // com.tencent.mm.plugin.appbrand.h.c
        public final void a(h.d dVar) {
            AppMethodBeat.i(130691);
            Log.i("MicroMsg.MBNiReporter", "hy: onPause");
            a aVar = a.this;
            if (aVar.cxw) {
                Log.i("MicroMsg.MBNiReporter", "hy: hasReported!");
                AppMethodBeat.o(130691);
                return;
            }
            com.tencent.f.h.RTc.aX(new Runnable() {
                /* class com.tencent.luggage.game.e.a.AnonymousClass5 */

                public final void run() {
                    double d2;
                    AppMethodBeat.i(130694);
                    long j2 = a.this.cxv - a.this.cxu;
                    long currentTicks = (Util.currentTicks() - a.this.cxv) / 1000;
                    if (currentTicks <= 0 || currentTicks >= 10) {
                        d2 = (double) a.this.cxz;
                    } else {
                        d2 = a.this.cxx != null ? (double) a.this.cxx.ii(a.this.cxy) : -1.0d;
                    }
                    c cVar = new c();
                    if (a.this.cxF.size() > 0 && a.this.cxt > 0) {
                        a.a(a.this, cVar, a.this.cxF);
                    }
                    b bVar = new b();
                    if (a.this.cxF.size() > 0) {
                        a.a(bVar, a.this.cxF);
                    }
                    a.this.cxt = 0;
                    a.this.cxF.clear();
                    a.j(a.this);
                    Log.i("MicroMsg.MBNiReporter", "hy: decode performance appid:%s,inject2firstDraw:%d,firstFps:%f,PreDecodeNum:%d,PreDecodeTotalTime:%d,preDecodeAvgTime:%f,totalDecodeNum:%d,totalDecodeTime:%d,totalDecodeAvgTime:%f", a.this.appId, Long.valueOf(j2), Double.valueOf(d2), Integer.valueOf(cVar.cxM), Long.valueOf(cVar.cxN), Double.valueOf(cVar.cxO), Integer.valueOf(bVar.cxM), Long.valueOf(bVar.cxN), Double.valueOf(bVar.cxO));
                    if (j2 > 0) {
                        ((com.tencent.mm.plugin.appbrand.w.b) e.N(com.tencent.mm.plugin.appbrand.w.b.class)).a(16136, a.this.appId, Long.valueOf(j2), Double.valueOf(d2), Integer.valueOf(cVar.cxM), Long.valueOf(cVar.cxN), Double.valueOf(cVar.cxO), Integer.valueOf(bVar.cxM), Long.valueOf(bVar.cxN), Double.valueOf(bVar.cxO));
                    }
                    a.this.cxw = true;
                    AppMethodBeat.o(130694);
                }
            });
            AppMethodBeat.o(130691);
        }

        @Override // com.tencent.mm.plugin.appbrand.h.c
        public final void onDestroy() {
            AppMethodBeat.i(130692);
            Log.i("MicroMsg.MBNiReporter", "hy: onDestroy");
            a aVar = a.this;
            Log.i("MicroMsg.MBNiReporter", "hy: release!");
            h.b(aVar.appId, aVar.cxI);
            AppMethodBeat.o(130692);
        }
    };
    private int cxt = 0;
    public long cxu = 0;
    public long cxv = 0;
    boolean cxw = false;
    public d cxx;
    public int cxy = -1;
    private float cxz = -1.0f;

    public a() {
        AppMethodBeat.i(130697);
        AppMethodBeat.o(130697);
    }

    public static a Nn() {
        AppMethodBeat.i(130698);
        if (cxH == null) {
            synchronized (a.class) {
                try {
                    if (cxH == null) {
                        cxH = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(130698);
                    throw th;
                }
            }
        }
        a aVar = cxH;
        AppMethodBeat.o(130698);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public class c {
        int cxM;
        long cxN;
        double cxO;

        c() {
        }
    }

    /* access modifiers changed from: package-private */
    public class b {
        int cxM;
        long cxN;
        double cxO;

        b() {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.luggage.game.e.a$a  reason: collision with other inner class name */
    public static final class C0172a extends SparseIntArray {
        private C0172a() {
        }

        /* synthetic */ C0172a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final boolean hM(int i2) {
            AppMethodBeat.i(130696);
            if (super.indexOfKey(i2) >= 0) {
                AppMethodBeat.o(130696);
                return true;
            }
            AppMethodBeat.o(130696);
            return false;
        }
    }

    static /* synthetic */ void e(a aVar) {
        AppMethodBeat.i(130699);
        Log.i("MicroMsg.MBNiReporter", "hy: initStatis!");
        if (aVar.cxF != null && aVar.cxF.size() > 0) {
            aVar.cxF.clear();
        }
        synchronized (aVar.cxG) {
            try {
                if (aVar.cxG.size() > 0) {
                    aVar.cxG.clear();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(130699);
                throw th;
            }
        }
        aVar.cxw = false;
        aVar.cxt = 0;
        aVar.cxu = 0;
        aVar.cxv = 0;
        AppMethodBeat.o(130699);
    }

    static /* synthetic */ void a(a aVar, c cVar, CopyOnWriteArrayList copyOnWriteArrayList) {
        AppMethodBeat.i(130700);
        if (copyOnWriteArrayList.size() >= aVar.cxt) {
            Long[] lArr = (Long[]) Arrays.copyOf(copyOnWriteArrayList.toArray(new Long[0]), aVar.cxt);
            if (lArr == null || lArr.length <= 0) {
                AppMethodBeat.o(130700);
                return;
            }
            double d2 = 0.0d;
            int length = lArr.length;
            for (Long l : lArr) {
                d2 += (double) l.longValue();
            }
            cVar.cxM = lArr.length;
            cVar.cxN = (long) d2;
            cVar.cxO = d2 / ((double) length);
        }
        AppMethodBeat.o(130700);
    }

    static /* synthetic */ void a(b bVar, CopyOnWriteArrayList copyOnWriteArrayList) {
        AppMethodBeat.i(130701);
        int size = copyOnWriteArrayList.size();
        Log.i("MicroMsg.MBNiReporter", "hy: calculateAverageCost size:%d", Integer.valueOf(size));
        Long[] lArr = (Long[]) Arrays.copyOf(copyOnWriteArrayList.toArray(new Long[0]), size);
        if (lArr == null || lArr.length <= 0) {
            AppMethodBeat.o(130701);
            return;
        }
        double d2 = 0.0d;
        int length = lArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (lArr[i2] == null) {
                Log.printInfoStack("MicroMsg.MBNiReporter", "calculateAverageCost tempArray[%d] null!", Integer.valueOf(i2));
            } else {
                d2 += (double) lArr[i2].longValue();
            }
        }
        bVar.cxM = lArr.length;
        bVar.cxN = (long) d2;
        bVar.cxO = d2 / ((double) length);
        AppMethodBeat.o(130701);
    }

    static /* synthetic */ void j(a aVar) {
        AppMethodBeat.i(130702);
        synchronized (aVar.cxG) {
            for (int i2 = 0; i2 < aVar.cxG.size(); i2++) {
                try {
                    int keyAt = aVar.cxG.keyAt(i2);
                    int valueAt = aVar.cxG.valueAt(i2);
                    Log.i("MicroMsg.MBNiReporter", "hy: picSize level:%d,num:%d", Integer.valueOf(keyAt), Integer.valueOf(valueAt));
                    ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(936, (long) keyAt, (long) valueAt, false);
                } finally {
                    AppMethodBeat.o(130702);
                }
            }
        }
    }

    static /* synthetic */ void a(a aVar, String str, com.github.henryye.nativeiv.api.a aVar2) {
        AppMethodBeat.i(130703);
        if (aVar2.baO.equalsIgnoreCase("base64")) {
            aVar.cxA.add(MD5Util.getMD5String(str));
            ((com.tencent.mm.plugin.appbrand.w.b) e.N(com.tencent.mm.plugin.appbrand.w.b.class)).a(18076, "", aVar2.baO, aVar.appId, Integer.valueOf(aVar.cxE), Long.valueOf(aVar2.baM), Long.valueOf(aVar2.mHeight), Long.valueOf(aVar2.mWidth));
            AppMethodBeat.o(130703);
            return;
        }
        aVar.cxA.add(str);
        ((com.tencent.mm.plugin.appbrand.w.b) e.N(com.tencent.mm.plugin.appbrand.w.b.class)).a(18076, str, aVar2.baO, aVar.appId, Integer.valueOf(aVar.cxE), Long.valueOf(aVar2.baM), Long.valueOf(aVar2.mHeight), Long.valueOf(aVar2.mWidth));
        AppMethodBeat.o(130703);
    }
}
