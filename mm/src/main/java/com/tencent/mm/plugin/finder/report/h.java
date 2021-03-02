package com.tencent.mm.plugin.finder.report;

import android.os.Build;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.cg;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;
import org.json.JSONObject;

public final class h {
    private static long vem;
    private static boolean ven;
    private static final ConcurrentHashMap<Integer, a> veo = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Integer, Long> vep = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Integer, a> veq = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<a, Integer> ves = new ConcurrentHashMap<>();
    private static final HashSet<a> vet = new HashSet<>();
    public static final h veu = new h();

    static {
        AppMethodBeat.i(250598);
        AppMethodBeat.o(250598);
    }

    private h() {
    }

    public static final class a {
        public boolean ZA;
        int dLS;
        String sessionId = "";
        long veA;
        long veB;
        long veC;
        long veD;
        long veE;
        long veF;
        long veG;
        long veH;
        long veI;
        long veJ;
        long veK;
        public long veL;
        com.tencent.mm.bw.b veM;
        String veN = "";
        long veO;
        long veP;
        long veQ;
        long veR;
        long veS;
        long veT;
        long veU;
        long veV;
        long veW;
        long veX;
        int veY;
        int veZ;
        long vec;
        long vee;
        long vef;
        long veg;
        public boolean vev;
        boolean vew;
        long vex;
        long vey;
        long vez;
        int vfa;
        int vfb;
        public int vfc;
        int vfd;
        int vfe;
        int vff;
        int vfg;
        public int vfh;
        long vfi;

        public final void setSessionId(String str) {
            AppMethodBeat.i(250558);
            p.h(str, "<set-?>");
            this.sessionId = str;
            AppMethodBeat.o(250558);
        }

        public final void auD(String str) {
            AppMethodBeat.i(250559);
            p.h(str, "<set-?>");
            this.veN = str;
            AppMethodBeat.o(250559);
        }
    }

    private static boolean Ke(int i2) {
        return i2 == 4 || i2 == 3 || i2 == 1 || i2 == 2 || i2 == 6 || i2 == 5;
    }

    private static boolean Kf(int i2) {
        return i2 == 6 || i2 == 5 || i2 == 7 || i2 == 8 || i2 == 9;
    }

    private static boolean Kg(int i2) {
        return i2 == 4 || i2 == 3 || i2 == 1;
    }

    public static /* synthetic */ void a(h hVar, int i2, int i3, bbn bbn) {
        AppMethodBeat.i(250564);
        a(i2, i3, bbn, 0);
        AppMethodBeat.o(250564);
    }

    public static void Kh(int i2) {
        AppMethodBeat.i(250565);
        a aVar = veq.get(Integer.valueOf(i2));
        if (aVar != null) {
            aVar.vee = cl.aWA();
            AppMethodBeat.o(250565);
            return;
        }
        AppMethodBeat.o(250565);
    }

    public static void Ki(int i2) {
        AppMethodBeat.i(250566);
        a aVar = veq.get(Integer.valueOf(i2));
        if (aVar != null) {
            aVar.veg = cl.aWA();
            if (aVar.veR != 0 || aVar.vex <= 0) {
                p.g(aVar, LocaleUtil.ITALIAN);
                a(aVar, i2);
            } else {
                p.g(aVar, LocaleUtil.ITALIAN);
                ves.put(aVar, Integer.valueOf(i2));
            }
            veq.remove(Integer.valueOf(i2));
            AppMethodBeat.o(250566);
            return;
        }
        AppMethodBeat.o(250566);
    }

    public static void Kj(int i2) {
        AppMethodBeat.i(250567);
        a aVar = veq.get(Integer.valueOf(i2));
        if (aVar != null) {
            aVar.vef = cl.aWA();
            AppMethodBeat.o(250567);
            return;
        }
        AppMethodBeat.o(250567);
    }

    public static void Kk(int i2) {
        AppMethodBeat.i(250568);
        a aVar = veq.get(Integer.valueOf(i2));
        if (aVar != null) {
            aVar.vec = cl.aWA();
            AppMethodBeat.o(250568);
            return;
        }
        AppMethodBeat.o(250568);
    }

    public static void dnR() {
        ven = true;
    }

    public static void dnS() {
        AppMethodBeat.i(250569);
        vem = cl.aWA();
        AppMethodBeat.o(250569);
    }

    public static void dnT() {
        vem = 0;
        ven = false;
    }

    public static void Kl(int i2) {
        long j2;
        int i3;
        long j3 = 0;
        AppMethodBeat.i(250570);
        a Kd = Kd(i2);
        if (Kd != null) {
            if (vem > 0) {
                Kd.vex = vem;
                Long l = vep.get(Integer.valueOf(i2));
                if (l != null) {
                    j2 = l.longValue();
                } else {
                    j2 = 0;
                }
                Kd.vey = j2;
                vem = 0;
                if (Kd.vey > 0) {
                    j3 = Kd.vey - Kd.vex;
                }
                Kd.veS = j3;
                if (ven) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                Kd.vfa = i3;
                ven = false;
            }
            AppMethodBeat.o(250570);
            return;
        }
        AppMethodBeat.o(250570);
    }

    public static void an(int i2, boolean z) {
        int i3;
        AppMethodBeat.i(250571);
        a Kd = Kd(i2);
        if (Kd != null) {
            if (z) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            Kd.vfb = i3;
            AppMethodBeat.o(250571);
            return;
        }
        AppMethodBeat.o(250571);
    }

    public static void Km(int i2) {
        AppMethodBeat.i(250572);
        vep.put(Integer.valueOf(i2), Long.valueOf(cl.aWA()));
        AppMethodBeat.o(250572);
    }

    public static /* synthetic */ void a(h hVar, int i2, boolean z, bbn bbn, int i3) {
        AppMethodBeat.i(250574);
        if ((i3 & 4) != 0) {
            bbn = null;
        }
        a(i2, z, bbn, false);
        AppMethodBeat.o(250574);
    }

    public static void a(int i2, boolean z, bbn bbn, boolean z2) {
        int i3;
        long j2;
        long j3 = 0;
        AppMethodBeat.i(250573);
        a Kd = Kd(i2);
        if (Kd != null) {
            a aVar = Kd.ZA && !Kd.vev ? Kd : null;
            if (aVar != null) {
                if (bbn != null) {
                    String str = bbn.sessionId;
                    if (str == null) {
                        str = "";
                    }
                    aVar.setSessionId(str);
                    String str2 = bbn.sGE;
                    if (str2 == null) {
                        str2 = "";
                    }
                    aVar.auD(str2);
                    aVar.veO = (long) bbn.tCE;
                }
                if (!z) {
                    aVar.vev = true;
                    aVar.veG = cl.aWA();
                    aVar.veQ = 1;
                    if (z2) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    aVar.veZ = i3;
                    if (aVar.vff == 0) {
                        aVar.vff = 1;
                    }
                    if ((i2 == 4 || i2 == 3 || i2 == 1) && !z2) {
                        a aVar2 = veq.get(Integer.valueOf(i2));
                        if (aVar2 != null) {
                            p.g(aVar2, "this");
                            a(aVar2, i2);
                        }
                        veq.put(Integer.valueOf(i2), aVar);
                        AppMethodBeat.o(250573);
                        return;
                    }
                    a(aVar, i2);
                    AppMethodBeat.o(250573);
                    return;
                } else if (aVar.vez <= 0 || aVar.vfh != 1) {
                    aVar.vez = cl.aWA();
                    if (aVar.veS > 0 && aVar.vey > 0) {
                        j3 = aVar.vez - aVar.vey;
                    }
                    aVar.vfi = j3;
                    AppMethodBeat.o(250573);
                    return;
                } else {
                    aVar.veA = cl.aWA();
                    if (aVar.veS <= 0 || aVar.vey <= 0) {
                        j2 = 0;
                    } else {
                        j2 = aVar.veA - aVar.vey;
                    }
                    aVar.vfi = j2;
                    AppMethodBeat.o(250573);
                    return;
                }
            }
        }
        AppMethodBeat.o(250573);
    }

    public static /* synthetic */ void a(h hVar, int i2) {
        AppMethodBeat.i(250576);
        a(i2, true, null);
        AppMethodBeat.o(250576);
    }

    public static void a(int i2, boolean z, com.tencent.mm.bw.b bVar) {
        long j2;
        AppMethodBeat.i(250575);
        a Kd = Kd(i2);
        if (Kd != null) {
            a aVar = Kd.ZA && !Kd.vev ? Kd : null;
            if (aVar != null) {
                if (z) {
                    aVar.veB = cl.aWA();
                    if (aVar.veP == 0) {
                        j2 = 1;
                    } else {
                        j2 = 3;
                    }
                    aVar.veP = j2;
                    AppMethodBeat.o(250575);
                    return;
                }
                aVar.veC = cl.aWA();
                aVar.veM = bVar;
                AppMethodBeat.o(250575);
                return;
            }
        }
        AppMethodBeat.o(250575);
    }

    public static void ao(int i2, boolean z) {
        long j2;
        AppMethodBeat.i(250577);
        a Kd = Kd(i2);
        if (Kd != null) {
            a aVar = Kd.ZA && !Kd.vev ? Kd : null;
            if (aVar != null) {
                if (z) {
                    aVar.veD = cl.aWA();
                    if (aVar.veP == 0) {
                        j2 = 2;
                    } else {
                        j2 = 3;
                    }
                    aVar.veP = j2;
                    AppMethodBeat.o(250577);
                    return;
                }
                aVar.veE = cl.aWA();
                AppMethodBeat.o(250577);
                return;
            }
        }
        AppMethodBeat.o(250577);
    }

    public static /* synthetic */ void b(h hVar, int i2) {
        AppMethodBeat.i(250579);
        ap(i2, false);
        AppMethodBeat.o(250579);
    }

    public static void ap(int i2, boolean z) {
        AppMethodBeat.i(250578);
        a Kd = Kd(i2);
        if (Kd != null) {
            if (!(Kd.ZA && !Kd.vev)) {
                Kd = null;
            }
            if (Kd != null) {
                if (z) {
                    Kd.veF = 0;
                    AppMethodBeat.o(250578);
                    return;
                } else if (Kd.veF <= 0 || Kd.vfh != 1) {
                    Kd.veF = cl.aWA();
                    if (Kd.veQ == 2) {
                        Kd.vev = true;
                        Kd.vew = false;
                        a(Kd, i2);
                    }
                    AppMethodBeat.o(250578);
                    return;
                } else {
                    AppMethodBeat.o(250578);
                    return;
                }
            }
        }
        AppMethodBeat.o(250578);
    }

    public static /* synthetic */ void c(h hVar, int i2) {
        AppMethodBeat.i(250581);
        b(i2, false, false, false);
        AppMethodBeat.o(250581);
    }

    public static void b(int i2, boolean z, boolean z2, boolean z3) {
        int i3 = 1;
        AppMethodBeat.i(250580);
        a Kd = Kd(i2);
        if (Kd != null) {
            if (!(Kd.ZA && !Kd.vev)) {
                Kd = null;
            }
            if (Kd != null) {
                if (z) {
                    Kd.veH = cl.aWA();
                    if (z2 && z3) {
                        i3 = 3;
                    } else if (!z2) {
                        i3 = 2;
                    }
                    Kd.vfe = i3;
                    AppMethodBeat.o(250580);
                    return;
                }
                Kd.veI = cl.aWA();
                AppMethodBeat.o(250580);
                return;
            }
        }
        AppMethodBeat.o(250580);
    }

    public static void aq(int i2, boolean z) {
        AppMethodBeat.i(250582);
        a Kd = Kd(i2);
        if (Kd != null) {
            if (!(Kd.ZA && !Kd.vev)) {
                Kd = null;
            }
            if (Kd != null) {
                if (z) {
                    Kd.veJ = cl.aWA();
                    AppMethodBeat.o(250582);
                    return;
                }
                Kd.veK = cl.aWA();
                AppMethodBeat.o(250582);
                return;
            }
        }
        AppMethodBeat.o(250582);
    }

    public static /* synthetic */ void d(h hVar, int i2) {
        AppMethodBeat.i(250584);
        ar(i2, false);
        AppMethodBeat.o(250584);
    }

    public static void ar(int i2, boolean z) {
        boolean z2;
        a aVar;
        int i3;
        AppMethodBeat.i(250583);
        a Kd = Kd(i2);
        if (Kd != null) {
            if (!Kd.ZA || Kd.vev) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                aVar = Kd;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                if (aVar.vff == 0) {
                    if (z) {
                        i3 = 3;
                    } else {
                        i3 = 4;
                    }
                    aVar.vff = i3;
                }
                AppMethodBeat.o(250583);
                return;
            }
        }
        AppMethodBeat.o(250583);
    }

    public static void gd(int i2, int i3) {
        boolean z;
        AppMethodBeat.i(250585);
        if (i3 <= 0) {
            AppMethodBeat.o(250585);
            return;
        }
        a Kd = Kd(i2);
        if (Kd != null) {
            if (!Kd.ZA || Kd.vev) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                Kd = null;
            }
            if (Kd != null) {
                Kd.vfd += i3;
                AppMethodBeat.o(250585);
                return;
            }
        }
        AppMethodBeat.o(250585);
    }

    public static /* synthetic */ void e(h hVar, int i2) {
        AppMethodBeat.i(250587);
        d(i2, (bbn) null);
        AppMethodBeat.o(250587);
    }

    public static void d(int i2, bbn bbn) {
        a aVar;
        AppMethodBeat.i(250586);
        a Kd = Kd(i2);
        if (Kd != null) {
            if (Kd.ZA && !Kd.vev) {
                aVar = Kd;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                if (bbn != null) {
                    String str = bbn.sessionId;
                    if (str == null) {
                        str = "";
                    }
                    aVar.setSessionId(str);
                    String str2 = bbn.sGE;
                    if (str2 == null) {
                        str2 = "";
                    }
                    aVar.auD(str2);
                    aVar.veO = (long) bbn.tCE;
                }
                aVar.vev = true;
                aVar.veG = cl.aWA();
                if (aVar.veB > 0 && aVar.veC == 0) {
                    aVar.veC = aVar.veG;
                }
                if (aVar.veD > 0 && aVar.veE == 0) {
                    aVar.veE = aVar.veG;
                }
                aVar.veQ = 3;
                a(aVar, i2);
                AppMethodBeat.o(250586);
                return;
            }
        }
        AppMethodBeat.o(250586);
    }

    public static /* synthetic */ void a(h hVar) {
        AppMethodBeat.i(250589);
        e(2, (bbn) null);
        AppMethodBeat.o(250589);
    }

    public static void e(int i2, bbn bbn) {
        AppMethodBeat.i(250588);
        a Kd = Kd(i2);
        if (Kd != null) {
            a aVar = Kd.ZA && !Kd.vev ? Kd : null;
            if (aVar != null) {
                if (bbn != null) {
                    String str = bbn.sessionId;
                    if (str == null) {
                        str = "";
                    }
                    aVar.setSessionId(str);
                    String str2 = bbn.sGE;
                    if (str2 == null) {
                        str2 = "";
                    }
                    aVar.auD(str2);
                    aVar.veO = (long) bbn.tCE;
                }
                if (aVar.veQ != 0) {
                    AppMethodBeat.o(250588);
                    return;
                }
                aVar.veG = cl.aWA();
                aVar.veY = 3;
                if (aVar.veB > 0 && aVar.veC == 0) {
                    aVar.veC = aVar.veG;
                    aVar.veY = 1;
                }
                if (aVar.veD > 0 && aVar.veE == 0) {
                    aVar.veE = aVar.veG;
                    aVar.veY = 2;
                }
                aVar.vff = 2;
                aVar.veQ = 2;
                if (aVar.veF > 0) {
                    aVar.vev = true;
                    a(aVar, i2);
                    AppMethodBeat.o(250588);
                    return;
                }
                aVar.vew = true;
                AppMethodBeat.o(250588);
                return;
            }
        }
        AppMethodBeat.o(250588);
    }

    public static /* synthetic */ void dnU() {
        AppMethodBeat.i(250591);
        Kn(-1);
        AppMethodBeat.o(250591);
    }

    public static void Kn(int i2) {
        AppMethodBeat.i(250590);
        if (i2 != -1) {
            a aVar = veq.get(Integer.valueOf(i2));
            if (aVar != null) {
                p.g(aVar, "this");
                a(aVar, i2);
            }
            veq.remove(Integer.valueOf(i2));
            AppMethodBeat.o(250590);
            return;
        }
        for (Map.Entry<Integer, a> entry : veq.entrySet()) {
            a(entry.getValue(), entry.getKey().intValue());
        }
        veq.clear();
        for (Map.Entry<a, Integer> entry2 : ves.entrySet()) {
            a(entry2.getKey(), entry2.getValue().intValue());
        }
        ves.clear();
        AppMethodBeat.o(250590);
    }

    public static void dnV() {
        AppMethodBeat.i(250592);
        d.h(b.vfj);
        AppMethodBeat.o(250592);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a7, code lost:
        if ((r0 == null || r0.length() == 0) != false) goto L_0x00a9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.tencent.mm.plugin.finder.report.h.a r14, int r15) {
        /*
        // Method dump skipped, instructions count: 450
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.h.a(com.tencent.mm.plugin.finder.report.h$a, int):void");
    }

    private static void aZ(int i2, String str) {
        long j2;
        AppMethodBeat.i(250595);
        cg cgVar = new cg();
        cgVar.adb();
        if (Kf(i2)) {
            j2 = 2;
        } else {
            j2 = 1;
        }
        cgVar.fS(j2);
        cgVar.lH(str);
        cgVar.bfK();
        Log.i("Finder.FinderLoadingTimeReporter", "report21680 info:" + cgVar.abW());
        AppMethodBeat.o(250595);
    }

    public static List<arc> dnP() {
        long j2;
        AppMethodBeat.i(250596);
        LinkedList linkedList = new LinkedList();
        synchronized (vet) {
            try {
                for (T t : vet) {
                    arc arc = new arc();
                    arc.scene = 2;
                    arc.pullType = (int) t.veR;
                    arc.LCP = (int) t.veS;
                    arc.LCQ = (int) t.veW;
                    long j3 = (t.vfc != 1 || t.vez >= t.veG || t.vez <= 0 || t.veG <= 0) ? 0 : t.veG - t.vez;
                    if (t.vfc == 0 && t.veF < t.veG && t.veF > 0 && t.veG > 0) {
                        j3 = t.veG - t.veF;
                    }
                    arc.LCR = (int) j3;
                    arc.LCS = (t.vef <= 0 || t.vee <= 0 || t.vef <= t.vee) ? 0 : (int) (t.vef - t.vee);
                    if (t.vef > 0) {
                        j2 = t.vef;
                    } else if (t.vec > 0) {
                        j2 = t.vec;
                    } else {
                        j2 = 0;
                    }
                    arc.LCT = (j2 <= 0 || t.veg <= 0 || t.veg <= j2) ? 0 : (int) (t.veg - j2);
                    arc.vff = t.vff;
                    arc.LCV = t.veM;
                    linkedList.add(arc);
                    Log.i("Finder.FinderLoadingTimeReporter", "finderFluencyInfo: scene = " + arc.scene + ", pullType = " + arc.pullType + ", globalInitMs = " + arc.LCP + ',' + " pullCgiMs = " + arc.LCQ + ", showUiMs = " + arc.LCR + ", downloadToDecodeMs = " + arc.LCS + ',' + " decodeToFirstFrameMs = " + arc.LCT + ", finishScene = " + arc.vff);
                }
                vet.clear();
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(250596);
                throw th;
            }
        }
        LinkedList linkedList2 = linkedList;
        AppMethodBeat.o(250596);
        return linkedList2;
    }

    public static a Kd(int i2) {
        boolean z = true;
        AppMethodBeat.i(250562);
        if (!(i2 == 4 || i2 == 3 || i2 == 1 || i2 == 2 || i2 == 6 || i2 == 5 || i2 == 7 || i2 == 8 || i2 == 9)) {
            z = false;
        }
        if (!z) {
            AppMethodBeat.o(250562);
            return null;
        }
        a aVar = veo.get(Integer.valueOf(i2));
        if (aVar == null || aVar.vev) {
            a aVar2 = new a();
            aVar2.dLS = i2;
            veo.put(Integer.valueOf(i2), aVar2);
            aVar = aVar2;
        }
        AppMethodBeat.o(250562);
        return aVar;
    }

    public static final class b extends q implements kotlin.g.a.a<x> {
        public static final b vfj = new b();

        static {
            AppMethodBeat.i(250561);
            AppMethodBeat.o(250561);
        }

        b() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(250560);
            try {
                h hVar = h.veu;
                for (Map.Entry entry : h.veo.entrySet()) {
                    if (((a) entry.getValue()).ZA && !((a) entry.getValue()).vev) {
                        ((a) entry.getValue()).vfg = 1;
                    }
                }
            } catch (Throwable th) {
                Log.e("Finder.FinderLoadingTimeReporter", "notifyAppBackground: ", th);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(250560);
            return xVar;
        }
    }

    public static void a(int i2, int i3, bbn bbn, long j2) {
        boolean z;
        boolean z2;
        boolean z3;
        a aVar = null;
        AppMethodBeat.i(250563);
        if (i3 == 0 || i3 == 1 || i3 == 2) {
            z = true;
        } else {
            z = false;
        }
        if (!z || bbn == null) {
            Log.i("Finder.FinderLoadingTimeReporter", "prepare: not support to report tabType = " + i2 + ", contextObj = " + bbn);
            AppMethodBeat.o(250563);
            return;
        }
        a Kd = Kd(i2);
        if (Kd != null) {
            if (!Kd.ZA || Kd.vev) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                Kd = null;
            }
            if (Kd != null) {
                if (Kd.vfh == 1 && !Kd.vew && i3 == 0) {
                    Log.i("Finder.FinderLoadingTimeReporter", "prepare: remove duplicate enter report");
                    AppMethodBeat.o(250563);
                    return;
                }
                if (Kd.veF == 0 && Kd.veQ == 2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    aVar = Kd;
                }
                if (aVar != null) {
                    ap(i2, false);
                } else {
                    Kd.vev = true;
                    a(Kd, i2);
                }
            }
        }
        a Kd2 = Kd(i2);
        if (Kd2 != null) {
            Kd2.ZA = true;
            Kd2.veR = (long) i3;
            String str = bbn.sessionId;
            if (str == null) {
                str = "";
            }
            Kd2.setSessionId(str);
            String str2 = bbn.sGE;
            if (str2 == null) {
                str2 = "";
            }
            Kd2.auD(str2);
            Kd2.veO = (long) bbn.tCE;
            Kd2.veP = j2;
            AppMethodBeat.o(250563);
            return;
        }
        AppMethodBeat.o(250563);
    }

    private static JSONObject a(a aVar) {
        long j2;
        int i2;
        long j3;
        long j4;
        long j5;
        AppMethodBeat.i(250594);
        if (aVar.veB > 0 && aVar.veC > 0 && aVar.veC > aVar.veB) {
            aVar.veT = aVar.veC - aVar.veB;
        }
        if (aVar.veD > 0 && aVar.veE > 0 && aVar.veE > aVar.veD) {
            aVar.veV = aVar.veE - aVar.veD;
        }
        if (aVar.veC > 0 && aVar.veD > 0 && aVar.veD > aVar.veC) {
            aVar.veU = aVar.veD - aVar.veC;
        }
        aVar.veW = aVar.veT + aVar.veV + aVar.veU;
        if (aVar.veR != 0 || aVar.vex <= 0) {
            j2 = aVar.veG - aVar.vez;
        } else {
            j2 = aVar.veG - aVar.vex;
        }
        aVar.veX = j2;
        long j6 = (aVar.veF <= 0 || aVar.veF >= aVar.veG) ? 0 : aVar.veG - aVar.veF;
        long j7 = aVar.veX;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        if (aVar.veg > 0) {
            long j11 = aVar.vee > 0 ? aVar.veg - aVar.vee : 0;
            int i3 = 1;
            j10 = cl.aWA() - aVar.veg;
            if (j10 > 10000) {
                i3 = 3;
                j10 = 10000;
            }
            if (aVar.veR != 0 || aVar.vex <= 0) {
                j5 = aVar.veg - aVar.vez;
            } else {
                j5 = aVar.veg - aVar.vex;
            }
            i2 = i3;
            j8 = j11;
            j3 = j5;
        } else if (aVar.vee > 0) {
            long aWA = cl.aWA();
            long j12 = aWA - aVar.vee;
            if (aVar.veR != 0 || aVar.vex <= 0) {
                j4 = aWA - aVar.vez;
            } else {
                j4 = aWA - aVar.vex;
            }
            j9 = j12;
            i2 = 2;
            j3 = j4;
        } else {
            i2 = 0;
            j3 = j7;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("enterCost", aVar.veS);
        jSONObject.put("resumeToLoadingStartCost", aVar.vfi);
        if (Kf(aVar.dLS)) {
            jSONObject.put("firstFeedShowCost", aVar.veL > 0 ? aVar.veL - aVar.vez : 0);
            jSONObject.put("getDetailCost", (aVar.veI <= aVar.veH || aVar.veH <= 0) ? 0 : aVar.veI - aVar.veH);
            jSONObject.put("getRelatedCost", (aVar.veK <= aVar.veJ || aVar.veJ <= 0) ? 0 : aVar.veK - aVar.veJ);
            jSONObject.put("cgiEndToLoadingEndCost", j6);
            jSONObject.put("loadCost", aVar.veX);
            jSONObject.put("loadCostWitchActivityCost", aVar.veG - aVar.vez);
            jSONObject.put("feedIdType", aVar.vfe);
            jSONObject.put("cgiBackFeedCount", aVar.vfd);
        } else {
            jSONObject.put("streamCost", aVar.veT);
            jSONObject.put("spanCgiCost", aVar.veU);
            jSONObject.put("historyCost", aVar.veV);
            jSONObject.put("cgiAllCost", aVar.veW);
            jSONObject.put("loadCost", aVar.veX);
            jSONObject.put("cgiEndToLoadingEndCost", j6);
            jSONObject.put("startDownloadTimeStamp", aVar.vee);
            jSONObject.put("videoDecodeStartTimeStamp", aVar.vef);
            jSONObject.put("firstFrameDrawTimeStamp", aVar.veg);
            jSONObject.put("downLoadToFirstFrameDrawCost", j8);
            jSONObject.put("downloadToExitCost", j9);
            jSONObject.put("totalCost", j3);
            jSONObject.put("firstFrameStatus", i2);
            jSONObject.put("standingMsAfterFirstFrame", j10);
            jSONObject.put("exitStatus", aVar.veY);
            jSONObject.put("firstFeedIsPhoto", aVar.veZ);
            jSONObject.put("enterWithRedDot", aVar.vfa);
            jSONObject.put("enterWithFirstPageData", aVar.veS > 0 ? aVar.vfb : 0);
            jSONObject.put("cgiBackFeedCount", aVar.vfd);
            jSONObject.put("usePreloadCache", aVar.vfc);
        }
        jSONObject.put("finishStatus", aVar.veQ);
        jSONObject.put("commentScene", aVar.veO);
        jSONObject.put("tabType", aVar.dLS);
        jSONObject.put("pullType", aVar.veR);
        jSONObject.put(ProviderConstants.API_PATH, Build.VERSION.SDK_INT);
        jSONObject.put("hasBeenAppBackground", aVar.vfg);
        if (aVar.veS > 0) {
            jSONObject.put("isEnterLoad", aVar.vfh);
            c cVar = c.vCb;
            jSONObject.put("finderEnterLoadSwitch", c.dwX().value().intValue());
        }
        if (aVar.veS > 0 && i2 == 3) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1458, 30, 1);
        }
        AppMethodBeat.o(250594);
        return jSONObject;
    }

    private static void b(a aVar) {
        AppMethodBeat.i(250597);
        if (aVar.veQ == 1) {
            if (aVar.veT > 0) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1458, 0, aVar.veT);
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1458, 3, 1);
            }
            if (aVar.veV > 0) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1458, 1, aVar.veV);
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1458, 4, 1);
            }
            if (aVar.veT > 0 && aVar.veV > 0) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1458, 2, aVar.veW);
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1458, 5, 1);
            }
            if (aVar.veS > 0) {
                if (aVar.veW > 0) {
                    switch (aVar.dLS) {
                        case 1:
                            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1458, 13, aVar.veW);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1458, 14, 1);
                            break;
                        case 3:
                            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1458, 16, aVar.veW);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1458, 17, 1);
                            break;
                        case 4:
                            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1458, 10, aVar.veW);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1458, 11, 1);
                            break;
                    }
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1458, 20, aVar.veS);
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1458, 21, 1);
                long j2 = aVar.vez - aVar.vey;
                if (j2 > 0) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(1458, 23, j2);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(1458, 24, 1);
                }
                long j3 = aVar.veF < aVar.veG ? aVar.veG - aVar.veF : 0;
                if (j3 > 0) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(1458, 26, j3);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(1458, 27, 1);
                }
            }
        }
        AppMethodBeat.o(250597);
    }
}
