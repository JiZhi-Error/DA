package com.tencent.mm.plugin.appbrand.widget.recent;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class g {
    StringBuilder oCA = new StringBuilder();
    public StringBuilder oCB = new StringBuilder();
    public StringBuilder oCC = new StringBuilder();
    public StringBuilder oCD = new StringBuilder();
    public int oCE;
    int oCF;
    public int oCG;
    public boolean oCH;
    public String oCI = "";
    public String oCJ = "";
    long oCb = 0;
    public int oCc = 0;
    public int oCd;
    int oCe;
    int oCf;
    public int oCg;
    int oCh;
    public int oCi;
    public int oCj;
    public int oCk;
    public int oCl;
    public int oCm;
    public StringBuilder oCn = new StringBuilder();
    public StringBuilder oCo = new StringBuilder();
    public StringBuilder oCp = new StringBuilder();
    public StringBuilder oCq = new StringBuilder();
    int oCr;
    public int oCs;
    int oCt;
    public int oCu;
    int oCv;
    public int oCw;
    public int oCx;
    public StringBuilder oCy = new StringBuilder();
    public StringBuilder oCz = new StringBuilder();

    public g() {
        AppMethodBeat.i(194392);
        AppMethodBeat.o(194392);
    }

    public final void eO(int i2, int i3) {
        AppMethodBeat.i(194393);
        this.oCb = System.currentTimeMillis() / 1000;
        this.oCc = (int) this.oCb;
        this.oCf = i2;
        this.oCr = i3;
        AppMethodBeat.o(194393);
    }

    public final void R(int i2, int i3, int i4) {
        AppMethodBeat.i(194394);
        this.oCg = i2;
        this.oCs = i3;
        this.oCd = i4;
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.widget.recent.g.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(194388);
                if (g.this.oCb <= 0) {
                    Log.d("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime <= 0");
                    AppMethodBeat.o(194388);
                    return;
                }
                Log.i("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime: %s, mRecentCountAtOpen: %s, mRecentCountAtClose: %s, mCloseType: %s, mScrollRecentCount: %s, mOpenRecentAppBrandList: %s, mDeleteRecentCount: %s, mDeleteRecentAppBrandList: %s, \ndragCountWhenClose: %d, mStarCountAtOpen: %d, mStarCountAtClose: %d, mScrollStarCount: %d, mOpenStarAppBrandList: %s, mDeleteStarCount: %d, mDeleteStarAppBrandList: %s, \nmMoveToFirstCount: %d, mClickRecentAppBrandList: %s, mClickStarAppBrandList: %s, mMoveStarAppBrandToFirstList: %s, mAddCollectionCount: %d, mAddCollectionAppBrandList: %s", Long.valueOf(g.this.oCb), Integer.valueOf(g.this.oCf), Integer.valueOf(g.this.oCg), Integer.valueOf(g.this.oCd), Integer.valueOf(g.this.oCh), g.this.oCn.toString(), Integer.valueOf(g.this.oCi), g.this.oCo.toString(), Integer.valueOf(g.this.oCe), Integer.valueOf(g.this.oCr), Integer.valueOf(g.this.oCs), Integer.valueOf(g.this.oCt), g.this.oCy.toString(), Integer.valueOf(g.this.oCu), g.this.oCz.toString(), Integer.valueOf(g.this.oCv), g.this.oCp.toString(), g.this.oCB.toString(), g.this.oCA.toString(), Integer.valueOf(g.this.oCj), g.this.oCq.toString());
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(15081, Long.valueOf(g.this.oCb), Integer.valueOf(g.this.oCf), Integer.valueOf(g.this.oCg), Integer.valueOf(g.this.oCd), Integer.valueOf(g.this.oCh), g.this.oCn.toString(), Integer.valueOf(g.this.oCi), g.this.oCo.toString(), Integer.valueOf(g.this.oCe), Integer.valueOf(g.this.oCr), Integer.valueOf(g.this.oCs), Integer.valueOf(g.this.oCt), g.this.oCy.toString(), Integer.valueOf(g.this.oCu), g.this.oCz.toString(), Integer.valueOf(g.this.oCv), g.this.oCp.toString(), g.this.oCB.toString(), g.this.oCA.toString(), Integer.valueOf(g.this.oCj), g.this.oCq.toString());
                g.a(g.this);
                AppMethodBeat.o(194388);
            }
        });
        AppMethodBeat.o(194394);
    }

    public final void ccT() {
        this.oCe++;
    }

    public final void ccU() {
        AppMethodBeat.i(194395);
        this.oCF++;
        Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo showSearchView %d", Integer.valueOf(this.oCF));
        AppMethodBeat.o(194395);
    }

    public static void k(List<e> list, List<e> list2) {
        AppMethodBeat.i(194396);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        arrayList.addAll(list2);
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (i2 < arrayList.size()) {
            e eVar = (e) arrayList.get(i2);
            if (eVar != null && eVar.ooj != null && !Util.isNullOrNil(eVar.ooj.appId) && !Util.isNullOrNil(eVar.ooj.nickname)) {
                int i3 = i2 < list.size() ? 2 : 1;
                int size = i2 < list.size() ? i2 - 1 : (i2 - 1) - list.size();
                Log.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo nickName: %s, type: %d, pos: %d", eVar.ooj.nickname, Integer.valueOf(i3), Integer.valueOf(size));
                String str = eVar.ooj.appId + "," + eVar.ooj.iOo + "," + i3 + "," + size;
                if (hashMap.containsKey(eVar.ooj.nickname)) {
                    Log.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo contains nickName: %s", eVar.ooj.nickname);
                    Map map = (Map) hashMap.get(eVar.ooj.nickname);
                    if (!map.containsKey(str)) {
                        map.put(str, eVar);
                    }
                } else {
                    Log.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not contains nickName: %s", eVar.ooj.nickname);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(str, eVar);
                    hashMap.put(eVar.ooj.nickname, hashMap2);
                }
                if (Util.isNullOrNil(eVar.ooj.cyB)) {
                    Log.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not shortNickName");
                } else if (eVar.ooj.nickname.equals(eVar.ooj.cyB)) {
                    Log.e("MicroMsg.AppBrandRecentViewReporter", "alvinluo nickname equals shortNickName %s, %s", eVar.ooj.nickname, eVar.ooj.cyB);
                } else if (hashMap.containsKey(eVar.ooj.cyB)) {
                    Log.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo contains shortNickname: %s", eVar.ooj.cyB);
                    Map map2 = (Map) hashMap.get(eVar.ooj.cyB);
                    if (!map2.containsKey(str)) {
                        map2.put(str, eVar);
                    }
                } else {
                    Log.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not contains shortNickname: %s", eVar.ooj.cyB);
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put(str, eVar);
                    hashMap.put(eVar.ooj.cyB, hashMap3);
                }
            }
            i2++;
        }
        for (String str2 : hashMap.keySet()) {
            Map map3 = (Map) hashMap.get(str2);
            if (map3 == null || map3.size() <= 1) {
                Log.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo name %s not duplicated", str2);
            } else {
                Set<String> keySet = map3.keySet();
                HashMap hashMap4 = new HashMap();
                for (String str3 : keySet) {
                    e eVar2 = (e) map3.get(str3);
                    if (eVar2 != null && eVar2.ooj != null && !Util.isNullOrNil(eVar2.ooj.appId) && !hashMap4.containsKey(eVar2.ooj.appId)) {
                        hashMap4.put(eVar2.ooj.appId, eVar2);
                    }
                }
                if (hashMap4.size() <= 1) {
                    Log.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo name %s not duplicated2", str2);
                } else {
                    a aVar = new a(str2);
                    for (String str4 : keySet) {
                        String[] split = str4.split(",");
                        String str5 = split[2];
                        int i4 = Util.getInt(split[3], 0);
                        e eVar3 = (e) map3.get(str4);
                        if (!(eVar3 == null || eVar3.ooj == null)) {
                            Log.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo duplicated appId: %s, name: %s, shortName: %s, type: %s, pos: %d", eVar3.ooj.appId, eVar3.ooj.nickname, eVar3.ooj.cyB, str5, Integer.valueOf(i4));
                            if (str2.equals(eVar3.ooj.cyB)) {
                                aVar.oCM.append(eVar3.ooj.appId).append("#");
                                aVar.oCN.append("1#");
                                aVar.oCO.append(str5).append("#");
                                aVar.oCP.append(i4).append("#");
                                aVar.oCQ.append(eVar3.ooj.appVersion).append("#");
                                aVar.oCR.append(eVar3.ooj.iOo + 1).append("#");
                            }
                            if (str2.equals(eVar3.ooj.nickname)) {
                                aVar.oCM.append(eVar3.ooj.appId).append("#");
                                aVar.oCN.append("2#");
                                aVar.oCO.append(str5).append("#");
                                aVar.oCP.append(i4).append("#");
                                aVar.oCQ.append(eVar3.ooj.appVersion).append("#");
                                aVar.oCR.append(eVar3.ooj.iOo + 1).append("#");
                            }
                        }
                    }
                    Log.i("MicroMsg.AppBrandRecentViewReporter", "alvinluo reportDuplicatedName: %s", aVar);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(15796, aVar.oCL, aVar.oCM, aVar.oCN.toString(), aVar.oCO.toString(), aVar.oCP.toString(), aVar.oCQ.toString(), aVar.oCR.toString());
                }
            }
        }
        AppMethodBeat.o(194396);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        String oCL;
        StringBuilder oCM = new StringBuilder();
        StringBuilder oCN = new StringBuilder();
        StringBuilder oCO = new StringBuilder();
        StringBuilder oCP = new StringBuilder();
        StringBuilder oCQ = new StringBuilder();
        StringBuilder oCR = new StringBuilder();

        public a(String str) {
            AppMethodBeat.i(194390);
            this.oCL = str;
            AppMethodBeat.o(194390);
        }

        public final String toString() {
            AppMethodBeat.i(194391);
            String format = String.format("DuplicateNameInfo: {duplicatedName: %s, appId: %s, \nnameType: %s, \nlistType: %s, \nposition: %s, \nversion: %s, \nversionType: %s", this.oCL, this.oCM.toString(), this.oCN.toString(), this.oCO.toString(), this.oCP.toString(), this.oCQ.toString(), this.oCR.toString());
            AppMethodBeat.o(194391);
            return format;
        }
    }

    static /* synthetic */ void a(g gVar) {
        AppMethodBeat.i(194397);
        gVar.oCb = 0;
        gVar.oCd = 0;
        gVar.oCe = 0;
        gVar.oCf = 0;
        gVar.oCg = 0;
        gVar.oCh = 0;
        gVar.oCi = 0;
        gVar.oCv = 0;
        gVar.oCj = 0;
        gVar.oCk = 0;
        gVar.oCl = 0;
        gVar.oCm = 0;
        gVar.oCn = new StringBuilder();
        gVar.oCo = new StringBuilder();
        gVar.oCp = new StringBuilder();
        gVar.oCq = new StringBuilder();
        gVar.oCr = 0;
        gVar.oCs = 0;
        gVar.oCt = 0;
        gVar.oCu = 0;
        gVar.oCw = 0;
        gVar.oCx = 0;
        gVar.oCy = new StringBuilder();
        gVar.oCz = new StringBuilder();
        gVar.oCA = new StringBuilder();
        gVar.oCB = new StringBuilder();
        gVar.oCC = new StringBuilder();
        gVar.oCD = new StringBuilder();
        gVar.oCE = 0;
        gVar.oCF = 0;
        gVar.oCG = 0;
        gVar.oCH = false;
        gVar.oCI = "";
        gVar.oCJ = "";
        AppMethodBeat.o(194397);
    }
}
