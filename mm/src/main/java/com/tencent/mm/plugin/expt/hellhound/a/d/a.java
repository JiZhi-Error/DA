package com.tencent.mm.plugin.expt.hellhound.a.d;

import android.util.Pair;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.d.c;
import com.tencent.mm.plugin.expt.hellhound.a.d.d;
import com.tencent.mm.plugin.expt.hellhound.a.d.e;
import com.tencent.mm.plugin.expt.hellhound.a.d.f;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.j;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dve;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J8\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J>\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002JP\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0019j\b\u0012\u0004\u0012\u00020\r`\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0019j\b\u0012\u0004\u0012\u00020\u0010`\u001aH\u0002J(\u0010\u001c\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J*\u0010\u001d\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u001a\u0018\u00010\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0004H\u0002J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\"\u0010\"\u001a\u00020\b2\b\b\u0001\u0010\u000e\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J8\u0010$\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0019j\b\u0012\u0004\u0012\u00020\r`\u001aH\u0002J\u0018\u0010%\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J@\u0010&\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0019j\b\u0012\u0004\u0012\u00020\r`\u001aH\u0002J0\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0019j\b\u0012\u0004\u0012\u00020\u0010`\u001a2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020,\u0018\u00010+J\u0018\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u00162\b\u0010/\u001a\u0004\u0018\u00010\u0004J\u0018\u00100\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u00162\b\u0010/\u001a\u0004\u0018\u00010\u0004J\b\u00101\u001a\u0004\u0018\u000102J \u00103\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u00104\u001a\u000205J\b\u00106\u001a\u00020\bH\u0002J\u0010\u00107\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0006\u00108\u001a\u00020\bJ\u0018\u00109\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u00010(2\u0006\u0010;\u001a\u00020,R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatch;", "", "()V", "TAG", "", "is8EventForFragment", "", "_addPage", "", "curSessionId", "curPageConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "pathConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "curPage", AppMeasurement.Param.TIMESTAMP, "", "_addPrePage", "prePageConfig", "expctPageConfig", "_addPrePage2", "prePagesConfig", "", "_doNewMatch", "curCloudConfig", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "matchingPathIds", "_doNewMatch1Page", "_getCloudConfig", "Lcom/tencent/mm/vending/tuple/Tuple2;", "_isPageLegal", "pageName", "_matchOn8Event", "_matchOnFinish", "onSessionClose", "_matchOnNot1stOnResume", "_matchOnResume", "_matchOnSessionNot1STOnResume", "sessionPath", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "_updatePath", "getFuzzyPathOfCurSession", "Landroid/util/Pair;", "", "getMatchedFuzzyPaths", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "sessionId", "getMatchingFuzzyPaths", "getReportCache", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "match", "state", "Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/MatchState;", "mmProcessRestartEvent", "resetFuzzyDaoOnSessionStart", "resetReportCache", "updateSessionFuzzyPath", "sessionFuzzyPath", FirebaseAnalytics.b.INDEX, "plugin-expt_release"})
public final class a {
    private static boolean sHV;
    public static final a sHW = new a();

    static {
        AppMethodBeat.i(122574);
        AppMethodBeat.o(122574);
    }

    private a() {
    }

    public final void a(String str, long j2, g gVar) {
        AppMethodBeat.i(184273);
        p.h(gVar, "state");
        if (str == null) {
            Log.i("HABBYGE-MALI.FuzzyMatch", "match: page is: ".concat(String.valueOf(str)));
            AppMethodBeat.o(184273);
            return;
        }
        b.a aVar = b.sIy;
        if (b.a.cPX()) {
            Log.w("HABBYGE-MALI.FuzzyMatch", "match, doNotNeedSessionMonitor: TRUE");
            AppMethodBeat.o(184273);
            return;
        }
        Log.i("HABBYGE-MALI.FuzzyMatch", "match: " + str + ", " + gVar);
        switch (b.$EnumSwitchMapping$0[gVar.ordinal()]) {
            case 1:
                if (aqd(str)) {
                    ag(str, j2);
                    AppMethodBeat.o(184273);
                    return;
                }
                break;
            case 2:
                if (aqd(str)) {
                    c(str, false, j2);
                    AppMethodBeat.o(184273);
                    return;
                }
                break;
            case 3:
                if (aqd(str)) {
                    c(str, false, j2);
                    AppMethodBeat.o(184273);
                    return;
                }
                break;
            case 4:
                c(str, true, j2);
                AppMethodBeat.o(184273);
                return;
            case 5:
                sHV = true;
                Dp(j2);
                AppMethodBeat.o(184273);
                return;
            case 6:
                cPy();
                AppMethodBeat.o(184273);
                return;
            default:
                Log.e("HABBYGE-MALI.FuzzyMatch", "match ~");
                break;
        }
        AppMethodBeat.o(184273);
    }

    private final void ag(String str, long j2) {
        AppMethodBeat.i(184274);
        c<String, ArrayList<dvk>> cPz = cPz();
        if (cPz == null) {
            AppMethodBeat.o(184274);
            return;
        }
        String hdM = cPz.hdM();
        ArrayList<dvk> hdN = cPz.hdN();
        if (hdN == null) {
            AppMethodBeat.o(184274);
            return;
        }
        d.a aVar = d.sHY;
        bfz cPD = d.a.cPD();
        if (cPD == null || cPD.LPD.isEmpty()) {
            p.g(hdM, "curSessionId");
            a(str, hdM, j2, hdN, new ArrayList());
            AppMethodBeat.o(184274);
            return;
        }
        p.g(hdM, "curSessionId");
        a(str, hdM, j2, hdN);
        AppMethodBeat.o(184274);
    }

    private final void a(String str, String str2, long j2, ArrayList<dvk> arrayList) {
        AppMethodBeat.i(184275);
        d.a aVar = d.sHY;
        Pair<dve, Integer> aqg = d.a.aqg(str2);
        if (((dve) aqg.first).LPC.isEmpty()) {
            a(str, str2, j2, arrayList, new ArrayList());
            AppMethodBeat.o(184275);
            return;
        }
        Object obj = aqg.first;
        p.g(obj, "sessionPathPair.first");
        a(str, str2, (dve) obj, j2, arrayList);
        AppMethodBeat.o(184275);
    }

    private final void a(String str, String str2, dve dve, long j2, ArrayList<dvk> arrayList) {
        AppMethodBeat.i(184276);
        a(str, str2, j2, arrayList, a(str, dve, j2));
        AppMethodBeat.o(184276);
    }

    private static ArrayList<Long> a(String str, dve dve, long j2) {
        AppMethodBeat.i(184277);
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int size = dve.LPC.size() - 1; size >= 0; size--) {
            bgb bgb = dve.LPC.get(size);
            p.g(bgb, "sessionPath.paths[i]");
            bgb bgb2 = bgb;
            if (bgb2.LPK.size() == 1) {
                if (bgb2.LPI.isEmpty()) {
                    bga bga = new bga();
                    bga.name = str;
                    bga.startTime = j2;
                    bgb2.LPK.addLast(bga);
                    arrayList.add(Long.valueOf(bgb2.LPN));
                    Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath: " + bgb2.LPN + ", " + str);
                } else if (bgb2.LPI.size() == 1) {
                    if (p.j(bgb2.LPJ.dMl, str)) {
                        bga bga2 = new bga();
                        bga2.name = str;
                        bga2.startTime = j2;
                        bgb2.LPK.addLast(bga2);
                        arrayList.add(Long.valueOf(bgb2.LPN));
                        Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, =1: " + bgb2.LPN + ", " + str);
                    } else if (p.j(bgb2.LPI.get(0).dMl, str)) {
                        bgb2.LPK.clear();
                        bga bga3 = new bga();
                        bga3.name = str;
                        bga3.startTime = j2;
                        bgb2.LPK.addLast(bga3);
                        arrayList.add(Long.valueOf(bgb2.LPN));
                    } else {
                        dve.LPC.remove(size);
                    }
                } else if (p.j(bgb2.LPI.get(1).dMl, str)) {
                    bga bga4 = new bga();
                    bga4.name = str;
                    bga4.startTime = j2;
                    bgb2.LPK.addLast(bga4);
                    arrayList.add(Long.valueOf(bgb2.LPN));
                } else if (p.j(bgb2.LPI.get(0).dMl, str)) {
                    bgb2.LPK.clear();
                    bga bga5 = new bga();
                    bga5.name = str;
                    bga5.startTime = j2;
                    bgb2.LPK.addLast(bga5);
                    arrayList.add(Long.valueOf(bgb2.LPN));
                } else {
                    dve.LPC.remove(size);
                }
            } else if (bgb2.LPK.size() > 1 && bgb2.LPL) {
                if (bgb2.LPI.isEmpty()) {
                    bga bga6 = new bga();
                    bga6.name = str;
                    bga6.startTime = j2;
                    bgb2.LPK.addLast(bga6);
                    Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, =1: " + bgb2.LPN + ", " + str);
                    arrayList.add(Long.valueOf(bgb2.LPN));
                } else if (bgb2.LPI.size() == 1) {
                    bga bga7 = new bga();
                    bga7.name = str;
                    bga7.startTime = j2;
                    bgb2.LPK.addLast(bga7);
                    Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, =2: " + bgb2.LPN + ", " + str);
                    arrayList.add(Long.valueOf(bgb2.LPN));
                } else if (bgb2.LPK.size() > bgb2.LPI.size()) {
                    bga bga8 = new bga();
                    bga8.name = str;
                    bga8.startTime = j2;
                    bgb2.LPK.addLast(bga8);
                    Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, >2: " + bgb2.LPN + ", " + str);
                    arrayList.add(Long.valueOf(bgb2.LPN));
                } else if (bgb2.LPK.size() == bgb2.LPI.size()) {
                    if (p.j(bgb2.LPJ.dMl, str)) {
                        bga bga9 = new bga();
                        bga9.name = str;
                        bga9.startTime = j2;
                        bgb2.LPK.addLast(bga9);
                        arrayList.add(Long.valueOf(bgb2.LPN));
                        Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, >=2: " + bgb2.LPN + ", " + str);
                    } else if (p.j(bgb2.LPI.get(0).dMl, str)) {
                        bgb2.LPK.clear();
                        bga bga10 = new bga();
                        bga10.name = str;
                        bga10.startTime = j2;
                        bgb2.LPK.addLast(bga10);
                        arrayList.add(Long.valueOf(bgb2.LPN));
                    } else {
                        dve.LPC.remove(size);
                    }
                } else if (p.j(bgb2.LPI.get(bgb2.LPK.size()).dMl, str)) {
                    bga bga11 = new bga();
                    bga11.name = str;
                    bga11.startTime = j2;
                    bgb2.LPK.addLast(bga11);
                    arrayList.add(Long.valueOf(bgb2.LPN));
                } else if (p.j(bgb2.LPI.get(0).dMl, str)) {
                    bgb2.LPK.clear();
                    bga bga12 = new bga();
                    bga12.name = str;
                    bga12.startTime = j2;
                    bgb2.LPK.addLast(bga12);
                    arrayList.add(Long.valueOf(bgb2.LPN));
                } else {
                    dve.LPC.remove(size);
                }
            }
        }
        d.a aVar = d.sHY;
        d.a.a(dve);
        AppMethodBeat.o(184277);
        return arrayList;
    }

    private static void a(String str, String str2, long j2, ArrayList<dvk> arrayList, ArrayList<Long> arrayList2) {
        AppMethodBeat.i(184278);
        Iterator<dvk> it = arrayList.iterator();
        while (it.hasNext()) {
            dvk next = it.next();
            if (!arrayList2.contains(Long.valueOf(next.LPN))) {
                if (next.MWr.size() == 1) {
                    p.g(next, "pathConfig");
                    a(str, str2, next, j2);
                } else if (next.MWr.size() == 2) {
                    dvg dvg = next.MWr.get(0);
                    dvg dvg2 = next.MWr.get(1);
                    if (p.j(str, dvg.dMl)) {
                        p.g(dvg, "prePageConfig");
                        p.g(dvg2, "curPageConfig");
                        p.g(next, "pathConfig");
                        a(str2, dvg, dvg2, j2, next, str);
                    }
                } else {
                    List<dvg> subList = next.MWr.subList(0, next.MWr.size() - 1);
                    p.g(subList, "pathConfig.pagePathUnits…g.pagePathUnits.size - 1)");
                    LinkedList<dvg> linkedList = next.MWr;
                    p.g(linkedList, "pathConfig.pagePathUnits");
                    dvg last = linkedList.getLast();
                    if (p.j(str, subList.get(0).dMl)) {
                        p.g(last, "curPageConfig");
                        p.g(next, "pathConfig");
                        a(str2, subList, j2, last, next, str);
                    }
                }
            }
        }
        AppMethodBeat.o(184278);
    }

    private static void a(String str, String str2, dvk dvk, long j2) {
        AppMethodBeat.i(221114);
        dvg dvg = dvk.MWr.get(0);
        if (dvg == null) {
            AppMethodBeat.o(221114);
            return;
        }
        if (p.j(str, dvg.dMl)) {
            a(str2, dvg, dvk, str, j2);
        }
        AppMethodBeat.o(221114);
    }

    private static void a(String str, dvg dvg, dvk dvk, String str2, long j2) {
        AppMethodBeat.i(221115);
        bgb bgb = new bgb();
        bgb.dRM = str;
        bgb.LPJ = dvg;
        bgb.LPL = true;
        bgb.vtY = dvk.vtY;
        bgb.LPM = dvk.LPM;
        bgb.LPN = dvk.LPN;
        bga bga = new bga();
        bga.name = str2;
        bga.startTime = j2;
        bgb.LPK.addLast(bga);
        d.a aVar = d.sHY;
        Pair<dve, Integer> aqg = d.a.aqg(str);
        ((dve) aqg.first).LPC.addLast(bgb);
        ((dve) aqg.first).dRM = str;
        d.a aVar2 = d.sHY;
        Object obj = aqg.second;
        p.g(obj, "curSessionPathPair.second");
        d.a.b((dve) aqg.first, ((Number) obj).intValue());
        AppMethodBeat.o(221115);
    }

    private static void a(String str, dvg dvg, dvg dvg2, long j2, dvk dvk, String str2) {
        AppMethodBeat.i(221116);
        bgb bgb = new bgb();
        bgb.dRM = str;
        bgb.LPI.add(dvg);
        bgb.LPJ = dvg2;
        bgb.LPL = true;
        bgb.vtY = dvk.vtY;
        bgb.LPM = dvk.LPM;
        bgb.LPN = dvk.LPN;
        bga bga = new bga();
        bga.name = str2;
        bga.startTime = j2;
        bgb.LPK.addLast(bga);
        d.a aVar = d.sHY;
        Pair<dve, Integer> aqg = d.a.aqg(str);
        ((dve) aqg.first).LPC.addLast(bgb);
        ((dve) aqg.first).dRM = str;
        d.a aVar2 = d.sHY;
        Object obj = aqg.second;
        p.g(obj, "curSessionPathPair.second");
        d.a.b((dve) aqg.first, ((Number) obj).intValue());
        AppMethodBeat.o(221116);
    }

    private static void a(String str, List<? extends dvg> list, long j2, dvg dvg, dvk dvk, String str2) {
        AppMethodBeat.i(221117);
        bgb bgb = new bgb();
        bgb.dRM = str;
        bgb.LPI.addAll(list);
        bgb.LPJ = dvg;
        bgb.LPL = true;
        bgb.vtY = dvk.vtY;
        bgb.LPM = dvk.LPM;
        bgb.LPN = dvk.LPN;
        bga bga = new bga();
        bga.name = str2;
        bga.startTime = j2;
        bgb.LPK.addLast(bga);
        d.a aVar = d.sHY;
        Pair<dve, Integer> aqg = d.a.aqg(str);
        ((dve) aqg.first).LPC.addLast(bgb);
        ((dve) aqg.first).dRM = str;
        d.a aVar2 = d.sHY;
        Object obj = aqg.second;
        p.g(obj, "curSessionPathPair.second");
        d.a.b((dve) aqg.first, ((Number) obj).intValue());
        AppMethodBeat.o(221117);
    }

    private static void c(String str, boolean z, long j2) {
        String str2;
        AppMethodBeat.i(184279);
        if ((z || com.tencent.mm.plugin.expt.hellhound.core.b.aoS(str)) && sHV) {
            sHV = false;
            AppMethodBeat.o(184279);
            return;
        }
        b.a aVar = b.sIy;
        cyl cQp = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQp();
        if (cQp == null) {
            str2 = null;
        } else {
            str2 = cQp.sessionId;
        }
        if (str2 == null) {
            Log.w("HABBYGE-MALI.FuzzyMatch", "_matchOnFinish: curSession == null");
            AppMethodBeat.o(184279);
            return;
        }
        d.a aVar2 = d.sHY;
        dve aqf = d.a.aqf(str2);
        if (aqf == null) {
            Log.w("HABBYGE-MALI.FuzzyMatch", "_matchOnFinish: sessionMatch == null");
            AppMethodBeat.o(184279);
            return;
        }
        Iterator<bgb> it = aqf.LPC.iterator();
        while (it.hasNext()) {
            bgb next = it.next();
            if (next.LPL) {
                String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(next.LPJ.dMl);
                if (p.j(str, next.LPJ.dMl) || p.j(str, aoE)) {
                    next.LPL = false;
                    e.a aVar3 = e.sHZ;
                    e.a.a(next, j2);
                }
            } else {
                for (int size = next.LPK.size() - 1; size >= 0; size--) {
                    bga bga = next.LPK.get(size);
                    if (bga != null) {
                        String aoE2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bga.name);
                        if ((p.j(str, bga.name) || p.j(str, aoE2)) && bga.LPF <= 0) {
                            long j3 = j2 - bga.startTime;
                            if (j3 < 0) {
                                j3 = 0;
                            }
                            bga.LPF = j3;
                        }
                    }
                }
            }
        }
        d.a aVar4 = d.sHY;
        d.a.a(aqf);
        AppMethodBeat.o(184279);
    }

    private static void Dp(long j2) {
        AppMethodBeat.i(184280);
        e.a aVar = e.sHZ;
        e.a.Dq(j2);
        AppMethodBeat.o(184280);
    }

    private static void cPy() {
        AppMethodBeat.i(169392);
        d.a aVar = d.sHY;
        d.a.reset();
        f.a aVar2 = f.sIa;
        f.a.reset();
        j.a aVar3 = j.sIK;
        j.a.reset();
        AppMethodBeat.o(169392);
    }

    private static c<String, ArrayList<dvk>> cPz() {
        AppMethodBeat.i(169393);
        b.a aVar = b.sIy;
        String cPZ = b.a.cPZ();
        if (cPZ == null) {
            AppMethodBeat.o(169393);
            return null;
        }
        b.a aVar2 = b.sIy;
        String aqn = b.a.aqn(cPZ);
        if (aqn == null) {
            AppMethodBeat.o(169393);
            return null;
        }
        c.a aVar3 = c.sHX;
        ArrayList<dvk> aqe = c.a.aqe(aqn);
        if (aqe == null) {
            AppMethodBeat.o(169393);
            return null;
        } else if (aqe.isEmpty()) {
            Log.w("HABBYGE-MALI.FuzzyMatch", "_getCloudConfig Empty!!");
            AppMethodBeat.o(169393);
            return null;
        } else {
            com.tencent.mm.vending.j.c<String, ArrayList<dvk>> Q = com.tencent.mm.vending.j.a.Q(cPZ, aqe);
            AppMethodBeat.o(169393);
            return Q;
        }
    }

    public static void cPA() {
        AppMethodBeat.i(122571);
        Log.i("HABBYGE-MALI.FuzzyMatch", "resetReportCache");
        e.a aVar = e.sHZ;
        com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_fuzzy_mc_rpt", new byte[0]);
        AppMethodBeat.o(122571);
    }

    public static void aqa(String str) {
        AppMethodBeat.i(169394);
        Log.i("HABBYGE-MALI.FuzzyMatch", "resetFuzzyDaoOnStart: ".concat(String.valueOf(str)));
        if (str == null) {
            AppMethodBeat.o(169394);
            return;
        }
        d.a aVar = d.sHY;
        p.h(str, "curSessionId");
        bfz cPD = d.a.cPD();
        if (cPD != null) {
            for (int size = cPD.LPD.size() - 1; size >= 0; size--) {
                dve dve = cPD.LPD.get(size);
                p.g(dve, "matchInfo.sessionFuzzyPaths[i]");
                dve dve2 = dve;
                if (!p.j(str, dve2.dRM)) {
                    Log.i("HABBYGE-MALI.FuzzyMatchDao", "resetOnStart, need remove: " + dve2.dRM);
                    for (int size2 = dve2.LPC.size() - 1; size2 >= 0; size2--) {
                        bgb bgb = dve2.LPC.get(size2);
                        p.g(bgb, "sessionPath.paths[j]");
                        if (bgb.LPL) {
                            Log.i("HABBYGE-MALI.FuzzyMatchDao", "resetOnStart, real remove: " + dve2.dRM);
                            dve2.LPC.remove(size2);
                        }
                    }
                    if (dve2.LPC.isEmpty()) {
                        cPD.LPD.remove(size);
                    }
                }
            }
            d.a.a(cPD);
        }
        f.a aVar2 = f.sIa;
        f.a.reset();
        j.a aVar3 = j.sIK;
        j.a.reset();
        AppMethodBeat.o(169394);
    }

    public static bfy cPB() {
        AppMethodBeat.i(122572);
        e.a aVar = e.sHZ;
        bfy cPE = e.a.cPE();
        AppMethodBeat.o(122572);
        return cPE;
    }

    public static List<bgb> aqb(String str) {
        AppMethodBeat.i(122573);
        ArrayList arrayList = new ArrayList();
        d.a aVar = d.sHY;
        dve aqf = d.a.aqf(str);
        if (aqf == null) {
            AppMethodBeat.o(122573);
            return null;
        }
        Iterator<bgb> it = aqf.LPC.iterator();
        while (it.hasNext()) {
            bgb next = it.next();
            if (next.LPL) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(122573);
        return arrayList2;
    }

    public static List<bgb> aqc(String str) {
        AppMethodBeat.i(185590);
        ArrayList arrayList = new ArrayList();
        d.a aVar = d.sHY;
        dve aqf = d.a.aqf(str);
        if (aqf != null) {
            Iterator<bgb> it = aqf.LPC.iterator();
            while (it.hasNext()) {
                bgb next = it.next();
                if (!next.LPL) {
                    arrayList.add(next);
                }
            }
        }
        f.a aVar2 = f.sIa;
        dve aqh = f.a.aqh(str);
        if (aqh != null) {
            Iterator<bgb> it2 = aqh.LPC.iterator();
            while (it2.hasNext()) {
                bgb next2 = it2.next();
                if (!next2.LPL) {
                    arrayList.add(next2);
                }
            }
        }
        f.a aVar3 = f.sIa;
        f.a.akH(str);
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(185590);
        return arrayList2;
    }

    private static boolean aqd(String str) {
        AppMethodBeat.i(169395);
        boolean z = !p.j(str, "com.tencent.mm.ui.LauncherUI");
        AppMethodBeat.o(169395);
        return z;
    }

    public static Pair<dve, Integer> cPC() {
        bfz bfz;
        AppMethodBeat.i(221118);
        com.tencent.mm.plugin.expt.hellhound.a.f.b cPO = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
        p.g(cPO, "HellSessionMonitor.getInstance()");
        String cPR = cPO.cPR();
        d.a aVar = d.sHY;
        p.g(cPR, "curSessionid");
        p.h(cPR, "sessionId");
        bfz cPD = d.a.cPD();
        if (cPD == null) {
            bfz = new bfz();
        } else {
            bfz = cPD;
        }
        for (int size = bfz.LPD.size() - 1; size >= 0; size--) {
            dve dve = bfz.LPD.get(size);
            p.g(dve, "fuzzyMatchInfo.sessionFuzzyPaths[i]");
            dve dve2 = dve;
            if (p.j(cPR, dve2.dRM)) {
                Pair<dve, Integer> create = Pair.create(dve2, Integer.valueOf(size));
                AppMethodBeat.o(221118);
                return create;
            }
        }
        AppMethodBeat.o(221118);
        return null;
    }

    public static void a(dve dve, int i2) {
        AppMethodBeat.i(221119);
        d.a aVar = d.sHY;
        d.a.b(dve, i2);
        AppMethodBeat.o(221119);
    }
}
