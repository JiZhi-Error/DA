package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.report.quality.l;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class k {
    private static Map<String, k> hno = new HashMap();
    private static Boolean nKX;
    private final int kCM;
    private final String luj;
    private final String mAppId;
    private final String mAppVersion;
    private final String mRa;
    private final List<a> nKV;
    private final Map<Integer, Integer> nKW;

    public static void b(String str, final String str2, String str3, String str4, boolean z) {
        AppMethodBeat.i(227394);
        if (!bVc()) {
            AppMethodBeat.o(227394);
            return;
        }
        if (!l.bVe().mStarted) {
            l bVe = l.bVe();
            if (!bVe.mStarted) {
                bVe.mStarted = true;
                bVe.nLc = 60000;
                bVe.nLd = new l.b(bVe, (byte) 0);
                h.RTc.b(bVe.nLd, l.nLb);
                Log.i("MicroMsg.QualitySampleHelper", "startSample interval:%d", 60000);
            }
        }
        if (!hno.containsKey(str2)) {
            hno.put(str2, new k(str, str2, str3, str4, z));
            com.tencent.mm.plugin.appbrand.h.a(str2, new h.c() {
                /* class com.tencent.mm.plugin.appbrand.report.quality.k.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.h.c
                public final void a(h.d dVar) {
                    AppMethodBeat.i(227389);
                    k.cj(str2, 2);
                    AppMethodBeat.o(227389);
                }

                @Override // com.tencent.mm.plugin.appbrand.h.c
                public final void onResume() {
                    AppMethodBeat.i(227390);
                    k.cj(str2, 3);
                    AppMethodBeat.o(227390);
                }

                @Override // com.tencent.mm.plugin.appbrand.h.c
                public final void onDestroy() {
                    AppMethodBeat.i(227391);
                    k.cj(str2, 5);
                    k.hno.remove(str2);
                    com.tencent.mm.plugin.appbrand.h.b(str2, this);
                    AppMethodBeat.o(227391);
                }
            });
        }
        AppMethodBeat.o(227394);
    }

    public static void cj(final String str, final int i2) {
        AppMethodBeat.i(227395);
        if (!bVc()) {
            AppMethodBeat.o(227395);
            return;
        }
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.report.quality.k.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(227392);
                k kVar = (k) k.hno.get(str);
                if (kVar != null) {
                    k.a(kVar, i2);
                    k.b(kVar, i2);
                }
                AppMethodBeat.o(227392);
            }
        }, "QualityKVReporter_19941");
        AppMethodBeat.o(227395);
    }

    public static void zf(int i2) {
        AppMethodBeat.i(227396);
        Log.i("MicroMsg.QualitySampleHelper", "updateSampleInterval :%d", Integer.valueOf(i2));
        l.bVe().nLc = i2;
        AppMethodBeat.o(227396);
    }

    static {
        AppMethodBeat.i(227404);
        AppMethodBeat.o(227404);
    }

    private k(String str, String str2, String str3, String str4, boolean z) {
        AppMethodBeat.i(227397);
        this.luj = str;
        this.mAppId = str2;
        this.mRa = str3;
        this.mAppVersion = str4;
        this.kCM = z ? 1 : 0;
        this.nKW = new HashMap();
        this.nKV = new ArrayList();
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.report.quality.k.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(227393);
                k.a(k.this);
                AppMethodBeat.o(227393);
            }
        }, "QualityKVReporter_19941");
        AppMethodBeat.o(227397);
    }

    private static boolean bVc() {
        boolean z;
        AppMethodBeat.i(227398);
        if (nKX != null) {
            boolean booleanValue = nKX.booleanValue();
            AppMethodBeat.o(227398);
            return booleanValue;
        }
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_weapp_performance_index_report_android, 0);
        Log.i("MicroMsg.QualitySampleHelper", "shouldReport:%d", Integer.valueOf(a2));
        if (a2 == 1) {
            z = true;
        } else {
            z = false;
        }
        Boolean valueOf = Boolean.valueOf(z);
        nKX = valueOf;
        boolean booleanValue2 = valueOf.booleanValue();
        AppMethodBeat.o(227398);
        return booleanValue2;
    }

    private void zg(int i2) {
        AppMethodBeat.i(227399);
        a aVar = new a((byte) 0);
        aVar.nKZ = i2;
        aVar.nLa = l.bVe().zi(i2);
        this.nKV.add(aVar);
        AppMethodBeat.o(227399);
    }

    private int zh(int i2) {
        AppMethodBeat.i(227400);
        Integer num = this.nKW.get(Integer.valueOf(i2));
        if (num == null) {
            AppMethodBeat.o(227400);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(227400);
        return intValue;
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        int nKZ;
        int nLa;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    static /* synthetic */ void a(k kVar, int i2) {
        AppMethodBeat.i(227401);
        kVar.nKW.put(Integer.valueOf(i2), Integer.valueOf(kVar.zh(i2) + 1));
        AppMethodBeat.o(227401);
    }

    static /* synthetic */ void b(k kVar, int i2) {
        int i3;
        AppMethodBeat.i(227402);
        for (int i4 = 0; i4 < kVar.nKV.size(); i4++) {
            a aVar = kVar.nKV.get(i4);
            int i5 = aVar.nKZ;
            switch (i5) {
                case 1:
                    i3 = 1;
                    break;
                case 2:
                    i3 = 2;
                    break;
                case 3:
                    i3 = 3;
                    break;
                case 4:
                    i3 = 4;
                    break;
                case 5:
                    i3 = 5;
                    break;
                case 6:
                    i3 = 6;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            l.c zj = l.bVe().zj(i3);
            String format = String.format("%s,%s,%s,%s,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d", kVar.luj, kVar.mAppId, kVar.mRa, kVar.mAppVersion, Integer.valueOf(i2), Integer.valueOf(kVar.zh(i2)), Integer.valueOf(i5), Integer.valueOf(aVar.nLa), Integer.valueOf(l.bVe().zi(i3)), Integer.valueOf(zj.nLi / zj.mCount), Integer.valueOf(l.bVe().zj(i3).mPeak), Integer.valueOf(l.bVe().zj(i3).mCount), Integer.valueOf(com.tencent.mm.plugin.appbrand.a.bqV()), Integer.valueOf(kVar.kCM));
            Log.v("MicroMsg.QualitySampleHelper", "doReport : %s", format);
            com.tencent.mm.plugin.appbrand.report.a.nFX.a(19941, format);
        }
        AppMethodBeat.o(227402);
    }

    static /* synthetic */ void a(k kVar) {
        AppMethodBeat.i(227403);
        kVar.zg(1);
        kVar.zg(2);
        kVar.zg(3);
        kVar.zg(4);
        kVar.zg(5);
        kVar.zg(6);
        AppMethodBeat.o(227403);
    }
}
