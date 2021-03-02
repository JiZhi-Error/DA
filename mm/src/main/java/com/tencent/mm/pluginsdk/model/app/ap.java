package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ckr;
import com.tencent.mm.protocal.protobuf.cks;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ap implements i, u {
    private static ap JXk;
    public boolean JXl = false;
    public boolean JXm = false;
    private List<String> JXn = new LinkedList();
    public long JXo;
    private final int JXp = 20;
    private int JXq = 0;
    public boolean JXr = false;
    private long JXs;
    public String lang;

    private ap() {
        AppMethodBeat.i(151834);
        AppMethodBeat.o(151834);
    }

    public static ap gni() {
        AppMethodBeat.i(151835);
        if (JXk == null) {
            JXk = new ap();
        }
        ap apVar = JXk;
        AppMethodBeat.o(151835);
        return apVar;
    }

    @Override // com.tencent.mm.pluginsdk.model.app.u
    public final void a(int i2, int i3, String str, aa aaVar) {
        boolean z;
        AppMethodBeat.i(151836);
        if (!g.aAc()) {
            AppMethodBeat.o(151836);
            return;
        }
        this.JXl = false;
        Log.d("MicroMsg.SuggestionAppListLogic", "Suggestion onSceneEnd errType=%s errCode=%s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (aaVar == null) {
            Log.e("MicroMsg.SuggestionAppListLogic", "scene == null");
            AppMethodBeat.o(151836);
            return;
        }
        if (i2 == 0 && i3 == 0) {
            switch (aaVar.getType()) {
                case 4:
                    af afVar = (af) aaVar;
                    Log.d("MicroMsg.SuggestionAppListLogic", "get suggestion appList, AppCount = %s", Integer.valueOf(afVar.gnb()));
                    LinkedList<g> linkedList = afVar.JWA;
                    if (linkedList == null || linkedList.size() <= 0) {
                        Log.w("MicroMsg.SuggestionAppListLogic", "empty suggestAppList");
                        AppMethodBeat.o(151836);
                        return;
                    } else if (MMApplicationContext.getContext() != null && a.C1616a.eAZ() != null) {
                        LinkedList<String> linkedList2 = new LinkedList<>();
                        Iterator<g> it = linkedList.iterator();
                        while (it.hasNext()) {
                            g next = it.next();
                            Object[] objArr = new Object[5];
                            objArr[0] = next.field_appName;
                            objArr[1] = next.field_packageName;
                            objArr[2] = next.field_signature;
                            objArr[3] = next.fmM;
                            objArr[4] = Boolean.valueOf(next.fmL != null);
                            Log.d("MicroMsg.SuggestionAppListLogic", "suggestion appName=%s, packageName=%s, signature [%s], introUrl [%s], has iconUrl [%s]", objArr);
                            linkedList2.add(next.field_appId);
                        }
                        a.C1616a.eAZ().bg(linkedList2);
                        List<g> is = h.is(MMApplicationContext.getContext());
                        if (is.size() > 0) {
                            j eAX = a.C1616a.eAZ().eAX();
                            for (g gVar : is) {
                                if (gVar.field_appId != null) {
                                    Iterator<g> it2 = linkedList.iterator();
                                    while (true) {
                                        if (it2.hasNext()) {
                                            g next2 = it2.next();
                                            if (next2.field_appId != null && gVar.field_appId.equals(next2.field_appId)) {
                                                z = true;
                                            }
                                        } else {
                                            z = false;
                                        }
                                    }
                                    if (!z) {
                                        if (h.a(MMApplicationContext.getContext(), gVar)) {
                                            gVar.field_status = 1;
                                        } else {
                                            gVar.field_status = 4;
                                        }
                                        eAX.a(gVar, new String[0]);
                                    }
                                }
                            }
                        }
                        g.aAi();
                        g.aAh().azQ().setLong(352275, System.currentTimeMillis());
                        this.JXo = System.currentTimeMillis();
                        break;
                    } else {
                        Log.e("MicroMsg.SuggestionAppListLogic", "wrong environment");
                        AppMethodBeat.o(151836);
                        return;
                    }
                    break;
            }
        }
        AppMethodBeat.o(151836);
    }

    public final void iu(Context context) {
        AppMethodBeat.i(151837);
        if (!g.aAc()) {
            AppMethodBeat.o(151837);
        } else if (context == null) {
            AppMethodBeat.o(151837);
        } else if (this.JXm) {
            Log.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
            AppMethodBeat.o(151837);
        } else {
            this.JXm = true;
            if (System.currentTimeMillis() - this.JXs < 43200000) {
                Log.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now");
                this.JXm = false;
                AppMethodBeat.o(151837);
                return;
            }
            g.aAi();
            this.JXs = g.aAh().azQ().akg(352276);
            if (System.currentTimeMillis() - this.JXs < 43200000) {
                Log.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now pp");
                this.JXm = false;
                AppMethodBeat.o(151837);
                return;
            }
            if (this.lang == null) {
                this.lang = LocaleUtil.loadApplicationLanguage(context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), context);
            }
            gG(this.lang, this.JXq);
            AppMethodBeat.o(151837);
        }
    }

    public final void iv(Context context) {
        AppMethodBeat.i(151838);
        if (!g.aAc()) {
            AppMethodBeat.o(151838);
        } else if (context == null) {
            AppMethodBeat.o(151838);
        } else if (this.JXm) {
            Log.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
            AppMethodBeat.o(151838);
        } else {
            this.JXm = true;
            if (this.lang == null) {
                this.lang = LocaleUtil.loadApplicationLanguage(context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), context);
            }
            Log.i("MicroMsg.SuggestionAppListLogic", "getServiceAppListImmediately");
            gG(this.lang, this.JXq);
            AppMethodBeat.o(151838);
        }
    }

    private static void gG(String str, int i2) {
        AppMethodBeat.i(151839);
        Log.i("MicroMsg.SuggestionAppListLogic", "get service app, offset = %d, lang = %s", Integer.valueOf(i2), str);
        ae aeVar = new ae(i2, str);
        g.aAi();
        g.aAg().hqi.a(aeVar, 0);
        AppMethodBeat.o(151839);
    }

    public final void reset() {
        AppMethodBeat.i(151840);
        Log.i("MicroMsg.SuggestionAppListLogic", "reset getServiceAppList");
        g.aAi();
        g.aAh().azQ().setLong(352276, 0);
        this.JXs = 0;
        this.JXr = true;
        AppMethodBeat.o(151840);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        ckr ckr;
        boolean z;
        AppMethodBeat.i(151841);
        if (!g.aAc()) {
            Log.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd account not ready");
            this.JXq = 0;
            this.JXn.clear();
            AppMethodBeat.o(151841);
            return;
        }
        this.JXm = false;
        if (qVar == null) {
            Log.e("MicroMsg.SuggestionAppListLogic", "scene == null");
            this.JXq = 0;
            this.JXn.clear();
            AppMethodBeat.o(151841);
        } else if (i2 == 0 && i3 == 0) {
            Log.i("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            ae aeVar = (ae) qVar;
            if (aeVar.rr == null || aeVar.rr.iLL.iLR == null) {
                ckr = null;
            } else {
                ckr = (ckr) aeVar.rr.iLL.iLR;
            }
            if (ckr == null) {
                Log.e("MicroMsg.SuggestionAppListLogic", "resp == null");
                this.JXq = 0;
                this.JXn.clear();
                AppMethodBeat.o(151841);
            } else if (ckr.Mqb == null || ckr.Mqb.size() <= 0) {
                Log.e("MicroMsg.SuggestionAppListLogic", "Service_appinfo empty");
                a(a.C1616a.eAZ().eAX(), this.JXn);
                this.JXq = 0;
                this.JXn.clear();
                g.aAi();
                g.aAh().azQ().setLong(352276, System.currentTimeMillis());
                this.JXs = System.currentTimeMillis();
                AppMethodBeat.o(151841);
            } else {
                Log.i("MicroMsg.SuggestionAppListLogic", "offset = %d, count = %s", Integer.valueOf(this.JXq), Integer.valueOf(ckr.Mqb.size()));
                j eAX = a.C1616a.eAZ().eAX();
                LinkedList linkedList = new LinkedList();
                Iterator<cks> it = ckr.Mqb.iterator();
                while (it.hasNext()) {
                    cks next = it.next();
                    Log.i("MicroMsg.SuggestionAppListLogic", "service info: %s, %s, %s, %s, %s, %s", next.qGA, Integer.valueOf(next.qGD), Integer.valueOf(next.Mqj), Integer.valueOf(next.Mqi), Integer.valueOf(next.Mqg), next.dNI);
                    if (!Util.isNullOrNil(next.dNI) && !Util.isNullOrNil(next.qGA)) {
                        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue();
                        if (g.JVU.equals(next.dNI)) {
                            next.Mqg = (next.Mqg ^ 253) ^ -1;
                            Log.d("MicroMsg.SuggestionAppListLogic", "aa change: %s", Integer.valueOf(next.Mqg));
                        } else if (g.JVT.equals(next.dNI)) {
                            if (next.Mqj <= 0) {
                                if (z.aUj() && z.aUf() == 0 && intValue == 1) {
                                    h.INSTANCE.dN(965, 33);
                                } else {
                                    h.INSTANCE.dN(965, 35);
                                }
                            }
                        } else if (g.JVR.equals(next.dNI) && next.Mqj <= 0) {
                            if (z.aUj() && z.aUf() == 0 && intValue == 1) {
                                h.INSTANCE.dN(965, 32);
                            } else {
                                h.INSTANCE.dN(965, 34);
                            }
                        }
                        this.JXn.add(next.dNI);
                        g o = h.o(next.dNI, true, false);
                        if (o != null) {
                            if (o.field_serviceAppInfoFlag != next.Mqg) {
                                z = true;
                            } else if (o.field_serviceAppType != next.qGD) {
                                z = true;
                            } else if (o.fmZ != next.Mqi) {
                                z = true;
                            } else if (o.field_serviceShowFlag != next.Mqj) {
                                z = true;
                            } else if (!Util.nullAsNil(o.field_appName).equals(Util.nullAsNil(next.qGA))) {
                                z = true;
                            } else if (!Util.nullAsNil(o.field_appName_en).equals(Util.nullAsNil(next.Mqc))) {
                                z = true;
                            } else if (!Util.nullAsNil(o.field_appName_tw).equals(Util.nullAsNil(next.Mqd))) {
                                z = true;
                            } else if (!Util.nullAsNil(o.field_appName_hk).equals(Util.nullAsNil(next.Mqn))) {
                                z = true;
                            } else if (!Util.nullAsNil(o.fmX).equals(Util.nullAsNil(next.Mqf))) {
                                z = true;
                            } else if (!Util.nullAsNil(o.fmW).equals(Util.nullAsNil(next.Mqe))) {
                                z = true;
                            } else if (!Util.nullAsNil(o.fmY).equals(Util.nullAsNil(next.Mqh))) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                String str2 = o.fmX;
                                String str3 = o.fmW;
                                a(o, next);
                                boolean a2 = eAX.a(o, new String[0]);
                                if (!Util.nullAsNil(str2).equals(Util.nullAsNil(next.Mqf))) {
                                    Log.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_list" + Util.nullAsNil(next.Mqf));
                                    com.tencent.mm.plugin.r.a.eAQ().gD(o.field_appId, 5);
                                }
                                if (!Util.nullAsNil(str3).equals(Util.nullAsNil(next.Mqe))) {
                                    Log.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_panel" + Util.nullAsNil(next.Mqe));
                                    com.tencent.mm.plugin.r.a.eAQ().gD(o.field_appId, 4);
                                }
                                Log.i("MicroMsg.SuggestionAppListLogic", "update app: AppID = %s, ret = %s", next.dNI, Boolean.valueOf(a2));
                            }
                        } else {
                            o = new g();
                            o.field_appId = next.dNI;
                            a(o, next);
                            Log.i("MicroMsg.SuggestionAppListLogic", "insert app: AppID = %s, ret = %s", next.dNI, Boolean.valueOf(eAX.r(o)));
                        }
                        if (Util.isNullOrNil(o.field_openId)) {
                            linkedList.add(next.dNI);
                        }
                    }
                }
                if (linkedList.size() > 0) {
                    Log.i("MicroMsg.SuggestionAppListLogic", "needGetOpenIdList %d", Integer.valueOf(linkedList.size()));
                    com.tencent.mm.plugin.r.a.eAU().addAll(linkedList);
                }
                if (ckr.Mqb.size() == 20) {
                    this.JXq += 20;
                    gG(this.lang, this.JXq);
                } else {
                    a(eAX, this.JXn);
                    this.JXq = 0;
                    this.JXn.clear();
                }
                g.aAi();
                g.aAh().azQ().setLong(352276, System.currentTimeMillis());
                this.JXs = System.currentTimeMillis();
                AppMethodBeat.o(151841);
            }
        } else {
            Log.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            this.JXq = 0;
            this.JXn.clear();
            AppMethodBeat.o(151841);
        }
    }

    private static void a(j jVar, List<String> list) {
        boolean z;
        AppMethodBeat.i(151842);
        if (jVar == null || list == null || list.size() <= 0) {
            AppMethodBeat.o(151842);
            return;
        }
        Log.d("MicroMsg.SuggestionAppListLogic", "removeExpiredServiceApp");
        List<g> gmU = h.gmU();
        Log.i("MicroMsg.SuggestionAppListLogic", "oldList %d", Integer.valueOf(gmU.size()));
        if (gmU.size() > 0) {
            for (g gVar : gmU) {
                if (gVar.field_appId != null) {
                    Iterator<String> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        if (gVar.field_appId.equals(it.next())) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        Log.i("MicroMsg.SuggestionAppListLogic", "delete old service : %s, %s", gVar.field_appId, Boolean.valueOf(jVar.b(gVar, new String[0])));
                    }
                }
            }
        }
        AppMethodBeat.o(151842);
    }

    private static void a(g gVar, cks cks) {
        AppMethodBeat.i(151843);
        gVar.field_appName = cks.qGA;
        gVar.field_appName_en = cks.Mqc;
        gVar.field_appName_tw = cks.Mqd;
        gVar.field_appName_hk = cks.Mqn;
        gVar.By(cks.Mqe);
        gVar.Bz(cks.Mqf);
        gVar.BA(cks.Mqh);
        gVar.field_serviceAppInfoFlag = cks.Mqg;
        gVar.field_serviceAppType = cks.qGD;
        gVar.nb(cks.Mqi);
        gVar.field_serviceShowFlag = cks.Mqj;
        AppMethodBeat.o(151843);
    }
}
