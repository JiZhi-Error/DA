package com.tencent.mm.plugin.finder.utils;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.utils.ad;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.protocal.protobuf.ecj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.a.j;
import kotlin.g.b.ae;
import kotlin.g.b.p;

public final class ac {
    private static final String TAG = TAG;
    private static final ArrayList<ecj> vYm = new ArrayList<>();
    private static String vYn = "";
    private static final long vYo = vYo;
    public static final ac vYp = new ac();

    static {
        AppMethodBeat.i(253754);
        AppMethodBeat.o(253754);
    }

    private ac() {
    }

    public static ArrayList<ecj> dDj() {
        return vYm;
    }

    public static String dDk() {
        return vYn;
    }

    public static /* synthetic */ void a(ac acVar, String str, com.tencent.mm.bw.b bVar, boolean z, boolean z2, int i2) {
        AppMethodBeat.i(253747);
        if ((i2 & 2) != 0) {
            bVar = null;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        acVar.a(str, bVar, z, z2);
        AppMethodBeat.o(253747);
    }

    private synchronized void a(String str, com.tencent.mm.bw.b bVar, boolean z, boolean z2) {
        int i2;
        AppMethodBeat.i(253746);
        p.h(str, "stage");
        if (z) {
            vYm.clear();
        } else {
            if (!vYm.isEmpty()) {
                ecj ecj = (ecj) j.kt(vYm);
                if (ecj != null) {
                    int i3 = ecj.type;
                    ad.a aVar = ad.vZu;
                    if (i3 == ad.vYG) {
                        ecj ecj2 = (ecj) j.kv(vYm);
                        if (ecj2 != null) {
                            int i4 = ecj2.type;
                            ad.a aVar2 = ad.vZu;
                            if (i4 == ad.vYH) {
                                AppMethodBeat.o(253746);
                            }
                        }
                    }
                } else {
                    AppMethodBeat.o(253746);
                }
            }
            AppMethodBeat.o(253746);
        }
        ecj ecj3 = new ecj();
        ecj3.id = "";
        ecj3.wVT = str;
        ecj3.Asv = cl.aWy();
        if (z) {
            ad.a aVar3 = ad.vZu;
            i2 = ad.vYG;
        } else if (z2) {
            ad.a aVar4 = ad.vZu;
            i2 = ad.vYH;
        } else {
            i2 = 0;
        }
        ecj3.type = i2;
        ecj3.NcA = bVar;
        a aVar5 = a.vYE;
        p.h(ecj3, "tag");
        String str2 = ecj3.wVT;
        ad.a aVar6 = ad.vZu;
        if (p.j(str2, ad.vYU.name)) {
            a.dDr();
            Log.i(TAG, "reportPost");
        } else {
            ad.a aVar7 = ad.vZu;
            if (p.j(str2, ad.vZe.name)) {
                a.dDs();
                Log.i(TAG, "reportCancel");
            } else {
                ad.a aVar8 = ad.vZu;
                if (p.j(str2, ad.vYW.name)) {
                    a.dDt();
                    a.a(ecj3);
                    Log.i(TAG, "reportFailedCreateLive");
                } else {
                    ad.a aVar9 = ad.vZu;
                    if (p.j(str2, ad.vYZ.name)) {
                        a.dDu();
                        a.a(ecj3);
                        Log.i(TAG, "reportFailedJoinLive");
                    } else {
                        ad.a aVar10 = ad.vZu;
                        if (p.j(str2, ad.vZb.name)) {
                            a.dDv();
                            Log.i(TAG, "reportFailedEnterRoom");
                        } else {
                            ad.a aVar11 = ad.vZu;
                            if (p.j(str2, ad.vZd.name)) {
                                a.dDw();
                                Log.i(TAG, "reportFailedShareFeed");
                            } else {
                                ad.a aVar12 = ad.vZu;
                                if (p.j(str2, ad.vYX.name)) {
                                    a.dDx();
                                    Log.i(TAG, "reportRecheckRealName");
                                } else {
                                    ad.a aVar13 = ad.vZu;
                                    if (p.j(str2, ad.vZf.name)) {
                                        a.dDy();
                                        Log.i(TAG, "reportSuccLive");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        vYm.add(ecj3);
        Log.i(TAG, "tag, stage:" + str + ", isStart:" + z + ", isEnd:" + z2);
        if (z2) {
            h.RTc.o(b.vYF, 0);
        }
        AppMethodBeat.o(253746);
    }

    public static final class b implements Runnable {
        public static final b vYF = new b();

        static {
            AppMethodBeat.i(253745);
            AppMethodBeat.o(253745);
        }

        b() {
        }

        public final void run() {
            AppMethodBeat.i(253744);
            ac.vYp.dDq();
            ac acVar = ac.vYp;
            ac.dDj().clear();
            AppMethodBeat.o(253744);
        }
    }

    public static void dDl() {
        AppMethodBeat.i(253748);
        com.tencent.mm.plugin.report.service.h.INSTANCE.F(vYo, 60);
        AppMethodBeat.o(253748);
    }

    public static void dDm() {
        AppMethodBeat.i(253749);
        com.tencent.mm.plugin.report.service.h.INSTANCE.F(vYo, 61);
        AppMethodBeat.o(253749);
    }

    public static void dDn() {
        AppMethodBeat.i(253750);
        com.tencent.mm.plugin.report.service.h.INSTANCE.F(vYo, 62);
        AppMethodBeat.o(253750);
    }

    public static void dDo() {
        AppMethodBeat.i(253751);
        com.tencent.mm.plugin.report.service.h.INSTANCE.F(vYo, 63);
        AppMethodBeat.o(253751);
    }

    public static void dDp() {
        AppMethodBeat.i(253752);
        com.tencent.mm.plugin.report.service.h.INSTANCE.F(vYo, 64);
        AppMethodBeat.o(253752);
    }

    public final synchronized void dDq() {
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(253753);
            StringBuilder sb = new StringBuilder();
            ecj ecj = (ecj) j.kt(vYm);
            long j2 = ecj != null ? ecj.Asv : 0;
            ecj ecj2 = (ecj) j.kv(vYm);
            long j3 = (ecj2 != null ? ecj2.Asv : 0) - j2;
            for (T t : vYm) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                T t2 = t;
                if (i2 > 0) {
                    ecj ecj3 = vYm.get(i2 - 1);
                    p.g(ecj3, "flow.get(index - 1)");
                    ecj ecj4 = ecj3;
                    float f2 = j3 != 0 ? (((float) (t2.Asv - ecj4.Asv)) * 100.0f) / ((float) j3) : 0.0f;
                    StringBuilder append = new StringBuilder().append(t2.wVT).append(':').append(t2.Asv - ecj4.Asv).append("ms,");
                    ae aeVar = ae.SYK;
                    String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(f2)}, 1));
                    p.g(format, "java.lang.String.format(format, *args)");
                    sb.append(append.append(format).append("%\n").toString());
                    i2 = i3;
                } else {
                    sb.append("Total Cost:" + j3 + "ms... start at " + t2.Asv + "\n " + t2.wVT + '\n');
                    i2 = i3;
                }
            }
            StringBuilder sb2 = new StringBuilder("end at ");
            ecj ecj5 = (ecj) j.kv(vYm);
            sb.append(sb2.append(ecj5 != null ? Long.valueOf(ecj5.Asv) : null).toString());
            String sb3 = sb.toString();
            p.g(sb3, "flowData.toString()");
            vYn = sb3;
            Log.i(TAG, String.valueOf(sb));
            AppMethodBeat.o(253753);
        }
    }

    public static final class a {
        private static final long id = id;
        private static final long vYA = vYA;
        private static final long vYB = vYB;
        private static final long vYC = vYC;
        private static final long vYD = vYD;
        public static final a vYE = new a();
        private static final long vYq = vYq;
        private static final long vYr = 11;
        private static final long vYs = vYs;
        private static final long vYt = vYt;
        private static final long vYu = vYu;
        private static final long vYv = 15;
        private static final long vYw = 16;
        private static final long vYx = vYx;
        private static final long vYy = vYy;
        private static final long vYz = vYz;

        static {
            AppMethodBeat.i(253743);
            AppMethodBeat.o(253743);
        }

        private a() {
        }

        public static void dDr() {
            AppMethodBeat.i(253734);
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(id, vYq);
            AppMethodBeat.o(253734);
        }

        public static void dDs() {
            AppMethodBeat.i(253735);
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(id, vYr);
            AppMethodBeat.o(253735);
        }

        public static void dDt() {
            AppMethodBeat.i(253736);
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(id, vYs);
            AppMethodBeat.o(253736);
        }

        public static void dDu() {
            AppMethodBeat.i(253737);
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(id, vYt);
            AppMethodBeat.o(253737);
        }

        public static void dDv() {
            AppMethodBeat.i(253738);
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(id, vYu);
            AppMethodBeat.o(253738);
        }

        public static void dDw() {
            AppMethodBeat.i(253739);
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(id, vYv);
            AppMethodBeat.o(253739);
        }

        public static void dDx() {
            AppMethodBeat.i(253740);
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(id, vYw);
            AppMethodBeat.o(253740);
        }

        public static void dDy() {
            AppMethodBeat.i(253741);
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(id, vYx);
            AppMethodBeat.o(253741);
        }

        static void a(ecj ecj) {
            AppMethodBeat.i(253742);
            com.tencent.mm.bw.b bVar = ecj.NcA;
            if (bVar != null) {
                cit cit = new cit();
                try {
                    cit.parseFrom(bVar.toByteArray());
                } catch (Exception e2) {
                    Log.printDebugStack("safeParser", "", e2);
                    cit = null;
                }
                cit cit2 = cit;
                if (cit2 != null) {
                    switch (cit2.errCode) {
                        case -200018:
                        case -200017:
                        case -200013:
                            com.tencent.mm.plugin.report.service.h.INSTANCE.F(id, vYA);
                            AppMethodBeat.o(253742);
                            return;
                        case -200012:
                        case -200011:
                            com.tencent.mm.plugin.report.service.h.INSTANCE.F(id, vYz);
                            AppMethodBeat.o(253742);
                            return;
                        case -200010:
                            com.tencent.mm.plugin.report.service.h.INSTANCE.F(id, vYC);
                            AppMethodBeat.o(253742);
                            return;
                        case -200009:
                            com.tencent.mm.plugin.report.service.h.INSTANCE.F(id, vYB);
                            AppMethodBeat.o(253742);
                            return;
                        case -100038:
                            com.tencent.mm.plugin.report.service.h.INSTANCE.F(id, vYy);
                            AppMethodBeat.o(253742);
                            return;
                        default:
                            com.tencent.mm.plugin.report.service.h.INSTANCE.F(id, vYD);
                            AppMethodBeat.o(253742);
                            return;
                    }
                } else {
                    AppMethodBeat.o(253742);
                }
            } else {
                AppMethodBeat.o(253742);
            }
        }
    }
}
