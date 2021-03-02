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
import java.util.HashMap;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.n.n;

public final class af {
    private static final String TAG = TAG;
    private static final long vYo = vYo;
    private static final String vZX = vZX;
    private static final HashMap<String, ArrayList<ecj>> vZY = new HashMap<>();
    private static final HashMap<String, String> vZZ = new HashMap<>();
    public static final af waa = new af();

    static {
        AppMethodBeat.i(253786);
        AppMethodBeat.o(253786);
    }

    private af() {
    }

    public static final /* synthetic */ ecj c(String str, int i2, ArrayList arrayList) {
        AppMethodBeat.i(253787);
        ecj b2 = b(str, i2, arrayList);
        AppMethodBeat.o(253787);
        return b2;
    }

    public static String dEm() {
        return vZX;
    }

    public static HashMap<String, ArrayList<ecj>> dEn() {
        return vZY;
    }

    public static HashMap<String, String> dEo() {
        return vZZ;
    }

    public static /* synthetic */ void a(af afVar, String str, String str2, com.tencent.mm.bw.b bVar, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        AppMethodBeat.i(253774);
        com.tencent.mm.bw.b bVar2 = (i2 & 4) != 0 ? null : bVar;
        boolean z4 = (i2 & 8) != 0 ? false : z;
        if ((i2 & 16) == 0) {
            z3 = z2;
        }
        afVar.a(str, str2, bVar2, z4, z3);
        AppMethodBeat.o(253774);
    }

    private synchronized void a(String str, String str2, com.tencent.mm.bw.b bVar, boolean z, boolean z2) {
        ArrayList<ecj> arrayList;
        int i2;
        AppMethodBeat.i(253773);
        p.h(str, "id");
        p.h(str2, "stage");
        ArrayList<ecj> arrayList2 = vZY.get(str);
        if (arrayList2 == null) {
            arrayList = new ArrayList<>();
        } else {
            arrayList = arrayList2;
        }
        p.g(arrayList, "flows.get(id) ?: ArrayList()");
        if (z) {
            arrayList.clear();
        } else {
            if (!arrayList.isEmpty()) {
                ecj ecj = (ecj) j.kt(arrayList);
                if (ecj != null) {
                    int i3 = ecj.type;
                    ad.a aVar = ad.vZu;
                    if (i3 == ad.vYG) {
                        ecj ecj2 = (ecj) j.kv(arrayList);
                        if (ecj2 != null) {
                            int i4 = ecj2.type;
                            ad.a aVar2 = ad.vZu;
                            if (i4 == ad.vYH) {
                                AppMethodBeat.o(253773);
                            }
                        }
                    }
                } else {
                    AppMethodBeat.o(253773);
                }
            }
            AppMethodBeat.o(253773);
        }
        ecj ecj3 = new ecj();
        ecj3.id = str;
        ecj3.wVT = str2;
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
        b bVar2 = b.waj;
        b.a(ecj3, arrayList, z2);
        arrayList.add(ecj3);
        vZY.put(str, arrayList);
        Log.i(TAG, "tag, stage:" + str2 + ", isStart:" + z + ", isEnd:" + z2);
        if (z2) {
            p.h(str, "id");
            h.RTc.o(new c(str), 0);
        }
        AppMethodBeat.o(253773);
    }

    public static final class c implements Runnable {
        final /* synthetic */ String pAl;

        c(String str) {
            this.pAl = str;
        }

        public final void run() {
            AppMethodBeat.i(253772);
            af afVar = af.waa;
            ArrayList<ecj> arrayList = af.dEn().get(this.pAl);
            if (arrayList != null) {
                b bVar = b.waj;
                String str = this.pAl;
                p.g(arrayList, "dataList");
                b.i(str, arrayList);
            }
            af.waa.a(this.pAl, new a(ae.emptyMap()));
            af.waa.clear(this.pAl);
            AppMethodBeat.o(253772);
        }
    }

    public final synchronized String a(String str, a aVar) {
        String str2;
        ecj ecj;
        String valueOf;
        String str3;
        AppMethodBeat.i(253775);
        p.h(str, "id");
        p.h(aVar, "config");
        ArrayList<ecj> arrayList = vZY.get(str);
        if (arrayList != null) {
            StringBuilder sb = new StringBuilder();
            p.g(arrayList, "dataList");
            ecj ecj2 = (ecj) j.kt(arrayList);
            long j2 = ecj2 != null ? ecj2.Asv : 0;
            ecj ecj3 = (ecj) j.kv(arrayList);
            long j3 = ecj3 != null ? ecj3.Asv : 0;
            long j4 = j3 - j2;
            int i2 = 0;
            for (T t : arrayList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                T t2 = t;
                if (i2 == 0) {
                    p.g(sb.append("start at " + t2.Asv + "\n " + t2.wVT + " \n "), "flowStr.append(\"start at…\\n ${curData.stage} \\n \")");
                    i2 = i3;
                } else {
                    ecj ecj4 = arrayList.get(i2 - 1);
                    String str4 = aVar.wab.get(t2.wVT);
                    if (str4 != null) {
                        ecj = b(str4, i2, arrayList);
                    } else {
                        ecj = ecj4;
                    }
                    if (ecj == null) {
                        valueOf = "null ";
                    } else {
                        long j5 = t2.Asv;
                        if (ecj == null) {
                            p.hyc();
                        }
                        valueOf = String.valueOf(j5 - ecj.Asv);
                    }
                    if (j4 <= 0 || ecj == null) {
                        str3 = "";
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        kotlin.g.b.ae aeVar = kotlin.g.b.ae.SYK;
                        Object[] objArr = new Object[1];
                        long j6 = t2.Asv;
                        if (ecj == null) {
                            p.hyc();
                        }
                        objArr[0] = Float.valueOf((((float) (j6 - ecj.Asv)) * 100.0f) / ((float) j4));
                        String format = String.format("%.1f", Arrays.copyOf(objArr, 1));
                        p.g(format, "java.lang.String.format(format, *args)");
                        str3 = sb2.append(format).append("%").toString();
                    }
                    sb.append(t2.wVT + '[' + valueOf + "ms " + str3 + "] \n ");
                    if (i2 == arrayList.size() - 1) {
                        sb.append("end at ".concat(String.valueOf(j3)));
                    }
                    i2 = i3;
                }
            }
            str2 = "Total Cost:" + j4 + "ms... " + ((Object) sb);
            vZZ.put(str, str2);
            Log.i(TAG, str2);
            AppMethodBeat.o(253775);
        } else {
            str2 = "";
            AppMethodBeat.o(253775);
        }
        return str2;
    }

    public final synchronized void clear(String str) {
        AppMethodBeat.i(253776);
        p.h(str, "id");
        vZY.remove(str);
        Log.i(TAG, "clear id:".concat(String.valueOf(str)));
        AppMethodBeat.o(253776);
    }

    private static ecj b(String str, int i2, ArrayList<ecj> arrayList) {
        AppMethodBeat.i(253777);
        T t = null;
        int i3 = 0;
        for (T t2 : arrayList) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                j.hxH();
            }
            T t3 = t2;
            if (i3 >= i2 || !p.j(t3.wVT, str)) {
                t3 = t;
            }
            i3 = i4;
            t = t3;
        }
        AppMethodBeat.o(253777);
        return t;
    }

    public static void dEp() {
        AppMethodBeat.i(253778);
        com.tencent.mm.plugin.report.service.h.INSTANCE.F(vYo, 70);
        AppMethodBeat.o(253778);
    }

    public static void dEq() {
        AppMethodBeat.i(253779);
        com.tencent.mm.plugin.report.service.h.INSTANCE.F(vYo, 71);
        AppMethodBeat.o(253779);
    }

    public static void dEr() {
        AppMethodBeat.i(253780);
        com.tencent.mm.plugin.report.service.h.INSTANCE.F(vYo, 72);
        AppMethodBeat.o(253780);
    }

    public static void dEs() {
        AppMethodBeat.i(253781);
        com.tencent.mm.plugin.report.service.h.INSTANCE.F(vYo, 73);
        AppMethodBeat.o(253781);
    }

    public static void dEt() {
        AppMethodBeat.i(253782);
        com.tencent.mm.plugin.report.service.h.INSTANCE.F(vYo, 79);
        AppMethodBeat.o(253782);
    }

    public static void dEu() {
        AppMethodBeat.i(253783);
        com.tencent.mm.plugin.report.service.h.INSTANCE.F(vYo, 80);
        AppMethodBeat.o(253783);
    }

    public static void dEv() {
        AppMethodBeat.i(253784);
        com.tencent.mm.plugin.report.service.h.INSTANCE.F(vYo, 81);
        AppMethodBeat.o(253784);
    }

    public static void LZ(int i2) {
        AppMethodBeat.i(253785);
        if (i2 < 10) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(vYo, 82);
            AppMethodBeat.o(253785);
        } else if (i2 < 50) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(vYo, 83);
            AppMethodBeat.o(253785);
        } else if (i2 < 200) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(vYo, 84);
            AppMethodBeat.o(253785);
        } else if (i2 < 500) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(vYo, 85);
            AppMethodBeat.o(253785);
        } else if (i2 < 1000) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(vYo, 86);
            AppMethodBeat.o(253785);
        } else if (i2 < 5000) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(vYo, 87);
            AppMethodBeat.o(253785);
        } else {
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(vYo, 88);
            AppMethodBeat.o(253785);
        }
    }

    public static final class a {
        final Map<String, String> wab;

        public a(Map<String, String> map) {
            p.h(map, "cmpMap");
            AppMethodBeat.i(253768);
            this.wab = map;
            AppMethodBeat.o(253768);
        }
    }

    public static final class b {
        private static final int hhs = hhs;
        private static final long id = id;
        private static final long tTn = 4;
        private static final long total;
        private static final long vYA = vYA;
        private static final long vYB = vYB;
        private static final long vYy = vYy;
        private static final long vYz = 51;
        private static final long wac = 1;
        private static final long wad = 2;
        private static final long wae = 3;
        private static final long waf = waf;
        private static final long wag = wag;
        private static final long wah = 7;
        private static final a wai;
        public static final b waj = new b();

        static {
            AppMethodBeat.i(253771);
            HashMap hashMap = new HashMap();
            ad.a aVar = ad.vZu;
            String str = ad.vYP.name;
            ad.a aVar2 = ad.vZu;
            hashMap.put(str, ad.vYM.name);
            ad.a aVar3 = ad.vZu;
            String str2 = ad.vYR.name;
            ad.a aVar4 = ad.vZu;
            hashMap.put(str2, ad.vYM.name);
            ad.a aVar5 = ad.vZu;
            String str3 = ad.vYS.name;
            ad.a aVar6 = ad.vZu;
            hashMap.put(str3, ad.vYQ.name);
            ad.a aVar7 = ad.vZu;
            String str4 = ad.vYT.name;
            ad.a aVar8 = ad.vZu;
            hashMap.put(str4, ad.vYQ.name);
            wai = new a(hashMap);
            AppMethodBeat.o(253771);
        }

        private b() {
        }

        public static void a(ecj ecj, ArrayList<ecj> arrayList, boolean z) {
            ecj ecj2;
            com.tencent.mm.bw.b bVar;
            AppMethodBeat.i(253769);
            p.h(ecj, "curTagData");
            p.h(arrayList, "dataList");
            String str = wai.wab.get(ecj.wVT);
            if (str != null) {
                af afVar = af.waa;
                ecj c2 = af.c(str, arrayList.size(), arrayList);
                if (c2 != null) {
                    long j2 = ecj.Asv - c2.Asv;
                    String str2 = ecj.wVT;
                    ad.a aVar = ad.vZu;
                    if (!p.j(str2, ad.vYP.name)) {
                        ad.a aVar2 = ad.vZu;
                        if (!p.j(str2, ad.vYR.name)) {
                            ad.a aVar3 = ad.vZu;
                            if (p.j(str2, ad.vYS.name)) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(id, wad, j2, false);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(id, wag, 1, false);
                                af afVar2 = af.waa;
                                Log.i(af.TAG, "reportCdnConnect ".concat(String.valueOf(j2)));
                            } else {
                                ad.a aVar4 = ad.vZu;
                                if (p.j(str2, ad.vYT.name)) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(id, wae, j2, false);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(id, wah, 1, false);
                                    af afVar3 = af.waa;
                                    Log.i(af.TAG, "reportTrtcConnect ".concat(String.valueOf(j2)));
                                }
                            }
                        }
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(id, wac, j2, false);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(id, waf, 1, false);
                    String str3 = ecj.wVT;
                    ad.a aVar5 = ad.vZu;
                    if (p.j(str3, ad.vYR.name) && (bVar = ecj.NcA) != null) {
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
                                case -200030:
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.F(id, vYA);
                                    break;
                                case -200001:
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.F(id, vYz);
                                    break;
                                case -100038:
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.F(id, vYy);
                                    break;
                                default:
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.F(id, vYB);
                                    break;
                            }
                        }
                    }
                    af afVar4 = af.waa;
                    Log.i(af.TAG, "reportJoinLive ".concat(String.valueOf(j2)));
                }
            }
            if (!z || (ecj2 = (ecj) j.kt(arrayList)) == null) {
                AppMethodBeat.o(253769);
                return;
            }
            long j3 = ecj.Asv - ecj2.Asv;
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(id, total, j3, false);
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(id, tTn, 1, false);
            af afVar5 = af.waa;
            Log.i(af.TAG, "reportTotal ".concat(String.valueOf(j3)));
            AppMethodBeat.o(253769);
        }

        public static void i(String str, ArrayList<ecj> arrayList) {
            int i2;
            String str2;
            AppMethodBeat.i(253770);
            p.h(str, "id");
            p.h(arrayList, "originDataList");
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(arrayList);
            ecj ecj = (ecj) j.kt(arrayList2);
            ecj ecj2 = (ecj) j.kv(arrayList2);
            if (!(ecj == null || ecj2 == null || !(!p.j(ecj, ecj2)))) {
                long j2 = ecj2.Asv - ecj.Asv;
                String str3 = ecj2.wVT;
                ad.a aVar = ad.vZu;
                if (p.j(str3, ad.vYS.name)) {
                    i2 = 1;
                } else {
                    ad.a aVar2 = ad.vZu;
                    if (p.j(str3, ad.vYT.name)) {
                        i2 = 2;
                    } else {
                        ad.a aVar3 = ad.vZu;
                        i2 = p.j(str3, ad.vYR.name) ? 3 : 0;
                    }
                }
                StringBuilder sb = new StringBuilder();
                int i3 = 0;
                for (Object obj : arrayList2) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        j.hxH();
                    }
                    ecj ecj3 = (ecj) obj;
                    if (i3 > 0) {
                        Object obj2 = arrayList2.get(i3 - 1);
                        p.g(obj2, "dataList.get(index - 1)");
                        sb.append(ecj3.wVT + ':' + (ecj3.Asv - ((ecj) obj2).Asv) + ';');
                    }
                    i3 = i4;
                }
                int i5 = 0;
                com.tencent.mm.bw.b bVar = ecj2.NcA;
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
                        i5 = cit2.errCode;
                        String str4 = cit2.errMsg;
                        if (str4 == null || (str2 = n.j(str4, ",", ";", false)) == null) {
                            str2 = "";
                        }
                    } else {
                        str2 = "";
                    }
                } else {
                    str2 = "";
                }
                String str5 = str + ',' + j2 + ',' + i2 + ',' + ((Object) sb) + ',' + i5 + ',' + str2;
                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(hhs, str5);
                af afVar = af.waa;
                Log.i(af.TAG, "reportFlow 21173, ".concat(String.valueOf(str5)));
            }
            AppMethodBeat.o(253770);
        }
    }
}
