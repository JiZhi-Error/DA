package com.tencent.mm.plugin.newtips.a;

import android.util.Pair;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.newtips.PluginNewTips;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.plugin.newtips.b.e;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.protocal.protobuf.ehx;
import com.tencent.mm.protocal.protobuf.ehy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class i implements com.tencent.mm.ak.i {
    private static HashMap<String, WeakReference<a>> ADA = new HashMap<>();
    private static HashMap<Integer, WeakReference<a>> ADz = new HashMap<>();
    public a ADB = null;

    public interface a {
        void e(com.tencent.mm.plugin.newtips.b.a aVar);
    }

    static {
        AppMethodBeat.i(127251);
        AppMethodBeat.o(127251);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(127239);
        Log.i("MicroMsg.NewTips.NewTipsManager", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (qVar.getType() == 597) {
            if (i2 == 0 && i3 == 0) {
                boolean z = ((b) qVar).ACX;
                com.tencent.mm.plugin.newtips.b.a TF = com.tencent.mm.plugin.newtips.a.exm().TF(((b) qVar).ACY);
                if (TF != null) {
                    TF.field_isReject = z;
                    Log.i("MicroMsg.NewTips.NewTipsManager", "Newtips push is reject: %s", Boolean.valueOf(z));
                    com.tencent.mm.plugin.newtips.a.exm().a(TF, new String[0]);
                }
            } else {
                AppMethodBeat.o(127239);
                return;
            }
        }
        AppMethodBeat.o(127239);
    }

    public static void f(int i2, int i3, String str, String str2) {
        AppMethodBeat.i(127240);
        com.tencent.mm.plugin.newtips.b.a TF = com.tencent.mm.plugin.newtips.a.exm().TF(i2);
        if (TF == null) {
            com.tencent.mm.plugin.newtips.b.a aVar = new com.tencent.mm.plugin.newtips.b.a();
            aVar.field_tipId = i2;
            aVar.field_tipVersion = 1;
            aVar.field_tipkey = str;
            aVar.field_tipType = i3;
            if (aVar.field_tipsShowInfo == null) {
                aVar.field_tipsShowInfo = new ehx();
            }
            aVar.field_tipsShowInfo.path = str2;
            com.tencent.mm.plugin.newtips.a.exm().f(aVar);
            if (i3 == d.ACZ && (!aVar.field_isExit || 1 != aVar.field_tipVersion)) {
                g.azz().a(new b(i2, 1, str), 0);
                Log.d("MicroMsg.NewTips.NewTipsManager", "dancy doScene NetScenePushCompatNewTips！！");
                AppMethodBeat.o(127240);
                return;
            }
        } else {
            if (i3 == d.ACZ && (!TF.field_isExit || 1 != TF.field_tipVersion)) {
                g.azz().a(new b(i2, 1, str), 0);
                Log.d("MicroMsg.NewTips.NewTipsManager", "dancy doScene NetScenePushCompatNewTips！！");
            }
            if ((i3 == d.ACZ && 1 != TF.field_tipVersion) || (i3 == d.ADa && TF.field_tipVersion <= 0)) {
                TF.field_tipId = i2;
                TF.field_tipVersion = 1;
                TF.field_tipkey = str;
                TF.field_tipType = i3;
                TF.field_isExit = false;
                if (TF.field_tipsShowInfo == null) {
                    TF.field_tipsShowInfo = new ehx();
                }
                TF.field_tipsShowInfo.path = str2;
                com.tencent.mm.plugin.newtips.a.exm().a(TF, new String[0]);
            }
        }
        AppMethodBeat.o(127240);
    }

    public static void TA(int i2) {
        AppMethodBeat.i(127241);
        com.tencent.mm.plugin.newtips.b.a TF = com.tencent.mm.plugin.newtips.a.exm().TF(i2);
        if (TF == null) {
            Log.e("MicroMsg.NewTips.NewTipsManager", "newTipsInfo is null , makeRead failed!!");
            AppMethodBeat.o(127241);
            return;
        }
        Log.i("MicroMsg.NewTips.NewTipsManager", "dancy new tips tipsId:%s, make read: %s", Integer.valueOf(i2), Boolean.TRUE);
        if (TF.field_tipType == d.ACZ) {
            TF.field_hadRead = true;
            com.tencent.mm.plugin.newtips.a.exm().a(TF, new String[0]);
        }
        if (TF.field_tipType == d.ADa) {
            TF.field_hadRead = true;
            com.tencent.mm.plugin.newtips.a.exm().a(TF, new String[0]);
        }
        MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_newtips_report", 0).edit().putLong("newtips_makeread_time", Util.nowMilliSecond()).commit();
        AppMethodBeat.o(127241);
    }

    public static com.tencent.mm.plugin.newtips.b.a as(Map<String, String> map) {
        boolean z;
        AppMethodBeat.i(127242);
        if (map == null) {
            Log.e("MicroMsg.NewTips.NewTipsManager", "parse newtips map fail! map is null!!");
            AppMethodBeat.o(127242);
            return null;
        }
        long nowSecond = Util.nowSecond();
        com.tencent.mm.plugin.newtips.b.a aVar = new com.tencent.mm.plugin.newtips.b.a();
        aVar.field_tipId = Util.getInt(map.get(".sysmsg.newtips.control.tips_id"), 0);
        aVar.field_tipVersion = Util.getInt(map.get(".sysmsg.newtips.control.tips_version"), 0);
        aVar.field_tipType = Util.getInt(map.get(".sysmsg.newtips.control.tips_type"), 0);
        aVar.field_beginShowTime = Math.max(Util.getLong(map.get(".sysmsg.newtips.control.begin_time"), 0), nowSecond);
        aVar.field_overdueTime = Util.getLong(map.get(".sysmsg.newtips.control.overdue_time"), 0);
        aVar.field_disappearTime = Util.getLong(map.get(".sysmsg.newtips.control.disappear_time"), 0);
        if (map.get(".sysmsg.newtips.control.tips_showInfo") != null) {
            aVar.field_tipsShowInfo = new ehx();
            aVar.field_tipsShowInfo.dDG = Util.getInt(map.get(".sysmsg.newtips.control.tips_showInfo.show_type"), 0);
            aVar.field_tipsShowInfo.title = map.get(".sysmsg.newtips.control.tips_showInfo.title");
            aVar.field_tipsShowInfo.qGB = map.get(".sysmsg.newtips.control.tips_showInfo.icon_url");
            aVar.field_tipsShowInfo.path = map.get(".sysmsg.newtips.control.tips_showInfo.path");
        }
        aVar.field_extInfo = map.get(".sysmsg.newtips.control.tips_showInfo.");
        com.tencent.mm.plugin.newtips.a.exm().TF(aVar.field_tipId);
        com.tencent.mm.plugin.newtips.a.exo();
        if (!e.a(aVar) || !e.b(aVar) || !e.c(aVar) || aVar.field_isReject) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            aVar.field_isExit = true;
            com.tencent.mm.plugin.newtips.a.exm().a(aVar, new String[0]);
        }
        AppMethodBeat.o(127242);
        return aVar;
    }

    public static void aw(int i2, long j2) {
        AppMethodBeat.i(127243);
        com.tencent.mm.plugin.newtips.b.a TF = com.tencent.mm.plugin.newtips.a.exm().TF(i2);
        if (TF == null) {
            Log.e("MicroMsg.NewTips.NewTipsManager", "setPageStayTime fail! newTipsInfo is null!!");
            AppMethodBeat.o(127243);
            return;
        }
        TF.field_pagestaytime = j2;
        com.tencent.mm.plugin.newtips.a.exm().a(TF, new String[0]);
        AppMethodBeat.o(127243);
    }

    public static void b(String str, PluginNewTips.a aVar) {
        AppMethodBeat.i(184031);
        boolean z = MultiProcessMMKV.getMMKV("new_tips").getBoolean(Util.nullAs(str, BuildConfig.COMMAND), false);
        Log.i("MicroMsg.NewTips.NewTipsManager", "registerLocalNewTips() uniqueId(%s) isReject(%s)", str, Boolean.valueOf(z));
        if (z) {
            AppMethodBeat.o(184031);
            return;
        }
        if (aVar != null) {
            PluginNewTips.addLocalNewTipsCallback(str, aVar);
        }
        g.azz().a(new c(str), 0);
        Log.i("MicroMsg.NewTips.NewTipsManager", "registerLocalNewTips() uniqueId:%s", str);
        AppMethodBeat.o(184031);
    }

    public final void h(a aVar) {
        AppMethodBeat.i(127244);
        if (aVar == null) {
            Log.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips() iNewTipsView is null");
            AppMethodBeat.o(127244);
        } else if (Util.isNullOrNil(aVar.getPath())) {
            Log.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips() iNewTipsView.getPath() is null");
            AppMethodBeat.o(127244);
        } else {
            if (aVar.ehp()) {
                String path = aVar.getPath();
                WeakReference<a> weakReference = ADA.get(path);
                if (weakReference == null || !aVar.equals(weakReference.get())) {
                    ADA.put(path, new WeakReference<>(aVar));
                    aIC(path);
                } else {
                    Log.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips(%s) iNewTipsView had registed!", path);
                    aIC(path);
                    AppMethodBeat.o(127244);
                    return;
                }
            } else {
                int aIB = g.aIB(aVar.getPath());
                WeakReference<a> weakReference2 = ADz.get(Integer.valueOf(aIB));
                if (weakReference2 == null || !aVar.equals(weakReference2.get())) {
                    ADz.put(Integer.valueOf(aIB), new WeakReference<>(aVar));
                    TB(aIB);
                } else {
                    Log.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips(%s) iNewTipsView had registed!", aVar.getPath());
                    TB(aIB);
                    AppMethodBeat.o(127244);
                    return;
                }
            }
            Log.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips() register %s (%s) [%s] (%s)", aVar.getPath(), Boolean.valueOf(aVar.ehp()), aVar.toString(), aVar.getClass().getName() + "@" + Integer.toHexString(aVar.hashCode()));
            AppMethodBeat.o(127244);
        }
    }

    public static void i(a aVar) {
        AppMethodBeat.i(184032);
        if (aVar == null) {
            Log.i("MicroMsg.NewTips.NewTipsManager", "unRegisterNewTips() iNewTipsView is null");
            AppMethodBeat.o(184032);
        } else if (Util.isNullOrNil(aVar.getPath())) {
            Log.i("MicroMsg.NewTips.NewTipsManager", "unRegisterNewTips() iNewTipsView.getPath() is null");
            AppMethodBeat.o(184032);
        } else {
            if (aVar.ehp()) {
                String path = aVar.getPath();
                if (ADA.get(path) != null) {
                    ADA.remove(path);
                }
            } else {
                int aIB = g.aIB(aVar.getPath());
                if (ADz.get(Integer.valueOf(aIB)) != null) {
                    ADz.remove(Integer.valueOf(aIB));
                }
            }
            Log.i("MicroMsg.NewTips.NewTipsManager", "unRegisterNewTips %s %s", aVar.getPath(), Boolean.valueOf(aVar.ehp()));
            AppMethodBeat.o(184032);
        }
    }

    private void aIC(String str) {
        AppMethodBeat.i(188560);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() dynamicPath is null");
            AppMethodBeat.o(188560);
            return;
        }
        a(ADA.get(str), new e(str));
        AppMethodBeat.o(188560);
    }

    public final void TB(int i2) {
        AppMethodBeat.i(127245);
        if (i2 == 0) {
            Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path == 0");
            AppMethodBeat.o(127245);
            return;
        }
        a(ADz.get(Integer.valueOf(i2)), new e(i2));
        AppMethodBeat.o(127245);
    }

    private void a(WeakReference<a> weakReference, final e eVar) {
        AppMethodBeat.i(188561);
        if (weakReference == null) {
            Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() weakReference(%s) is null", eVar);
            AppMethodBeat.o(188561);
            return;
        }
        final a aVar = weakReference.get();
        if (aVar == null) {
            Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) is null", eVar);
            AppMethodBeat.o(188561);
        } else if (g.c(aVar)) {
            Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) is show old new tip", eVar);
            AppMethodBeat.o(188561);
        } else {
            h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.plugin.newtips.a.i.AnonymousClass1 */

                public final void run() {
                    boolean z;
                    boolean z2;
                    AppMethodBeat.i(188558);
                    Pair a2 = i.a(i.this, eVar);
                    Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path:%s show %s [%s,%s,%s]", eVar, ((k) a2.first).ADM, ((ehv) a2.second).title, ((ehv) a2.second).url, Integer.valueOf(((ehv) a2.second).ibS));
                    if (g.a(eVar, (k) a2.first)) {
                        k e2 = g.e(aVar);
                        a aVar = aVar;
                        if (aVar == null) {
                            Log.e("MicroMsg.NewTips.NewTipsHelper", "isEqual() curNewTip == null");
                            z = true;
                        } else if (e2 != a2.first) {
                            z = false;
                        } else {
                            ehv f2 = g.f(aVar);
                            ehv ehv = (ehv) a2.second;
                            if (f2 != null || ehv != null) {
                                if ((f2 != null && ehv == null) || (f2 == null && ehv != null)) {
                                    switch (g.AnonymousClass2.ADy[e2.ordinal()]) {
                                        case 1:
                                        case 2:
                                        case 7:
                                            z = true;
                                            break;
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 6:
                                            z = false;
                                            break;
                                        default:
                                            z = false;
                                            break;
                                    }
                                } else {
                                    switch (g.AnonymousClass2.ADy[e2.ordinal()]) {
                                        case 1:
                                        case 2:
                                        case 7:
                                            z = true;
                                            break;
                                        case 3:
                                            if (!Util.isEqual(f2.title, ehv.title)) {
                                                z = false;
                                                break;
                                            } else {
                                                z = true;
                                                break;
                                            }
                                        case 4:
                                            if (!Util.isEqual(f2.url, ehv.url)) {
                                                z = false;
                                                break;
                                            } else {
                                                z = true;
                                                break;
                                            }
                                        case 5:
                                            if (Util.isEqual(f2.title, ehv.title) && Util.isEqual(f2.url, ehv.url)) {
                                                z = true;
                                                break;
                                            } else {
                                                z = false;
                                                break;
                                            }
                                        case 6:
                                            if (!Util.isEqual(f2.ibS, ehv.ibS)) {
                                                z = false;
                                                break;
                                            } else {
                                                z = true;
                                                break;
                                            }
                                        default:
                                            z = false;
                                            break;
                                    }
                                }
                            } else {
                                z = true;
                            }
                        }
                        if (z) {
                            Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path:%s origin==new", eVar);
                            AppMethodBeat.o(188558);
                            return;
                        }
                        boolean a3 = g.a(aVar, (Pair<k, ehv>) new Pair(e2, new ehv()), false);
                        if (a3) {
                            z2 = g.a(aVar, (Pair<k, ehv>) a2, true);
                        } else {
                            z2 = true;
                        }
                        Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path:%s hideResult:%s showReuslt:%s", eVar, Boolean.valueOf(a3), Boolean.valueOf(z2));
                        AppMethodBeat.o(188558);
                        return;
                    }
                    Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) not support %s", eVar, ((k) a2.first).toString());
                    AppMethodBeat.o(188558);
                }
            });
            AppMethodBeat.o(188561);
        }
    }

    public final void TC(int i2) {
        AppMethodBeat.i(185494);
        a(new e(i2));
        AppMethodBeat.o(185494);
    }

    public final void a(e eVar) {
        e eVar2;
        AppMethodBeat.i(188562);
        List<c> fG = e.fG(com.tencent.mm.plugin.newtips.a.exn().c(eVar));
        if (fG.isEmpty()) {
            AppMethodBeat.o(188562);
            return;
        }
        for (c cVar : fG) {
            cVar.field_state = 1;
        }
        Log.i("MicroMsg.NewTips.NewTipsManager", "clickNewTip(%s) clickNewTip tipsInfos state to NEW_TIPS_STATE_DISAPPEAR. ret: %s", eVar, Integer.valueOf(com.tencent.mm.plugin.newtips.a.exn().fI(fG)));
        b(eVar);
        for (c cVar2 : fG) {
            ehy ehy = cVar2.field_parents;
            if (!(ehy == null || ehy.gCs == null)) {
                Iterator<String> it = ehy.gCs.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    int aIB = g.aIB(next);
                    if (aIB == 0) {
                        eVar2 = new e(next);
                    } else {
                        eVar2 = new e(aIB);
                    }
                    List<c> c2 = com.tencent.mm.plugin.newtips.a.exn().c(eVar2);
                    for (c cVar3 : c2) {
                        cVar3.field_state = 1;
                    }
                    Log.i("MicroMsg.NewTips.NewTipsManager", "clickNewTip() clickNewTip parentTipsInfos(%s) state to NEW_TIPS_STATE_DISAPPEAR. ret: %s", next, Integer.valueOf(com.tencent.mm.plugin.newtips.a.exn().fI(c2)));
                    b(eVar2);
                    for (c cVar4 : c2) {
                        a(com.tencent.mm.plugin.newtips.a.exn().aIE(cVar4.field_uniqueId), cVar4, 1);
                    }
                }
            }
        }
        AppMethodBeat.o(188562);
    }

    private void a(List<c> list, c cVar, int i2) {
        e eVar;
        AppMethodBeat.i(127248);
        if (i2 >= 10) {
            Log.e("MicroMsg.NewTips.NewTipsManager", "logicDisappearParent() disappear fail!!!!!");
            AppMethodBeat.o(127248);
            return;
        }
        ehy ehy = cVar.field_parents;
        if (!(ehy == null || ehy.gCs == null)) {
            Iterator<String> it = ehy.gCs.iterator();
            while (it.hasNext()) {
                String next = it.next();
                ArrayList arrayList = new ArrayList();
                int aIB = g.aIB(next);
                if (aIB == 0) {
                    eVar = new e(next);
                } else {
                    eVar = new e(aIB);
                }
                for (c cVar2 : list) {
                    if (eVar.ADS) {
                        if (Util.isEqual(cVar2.field_dynamicPath, eVar.ADR)) {
                            cVar2.field_state = 1;
                            arrayList.add(cVar2);
                            a(list, cVar2, i2 + 1);
                        }
                    } else if (cVar2.field_path == eVar.path) {
                        cVar2.field_state = 1;
                        arrayList.add(cVar2);
                        a(list, cVar2, i2 + 1);
                    }
                }
                Log.d("MicroMsg.NewTips.NewTipsManager", "clickNewTip() clickNewTip parentTipsInfos(%s) state to NEW_TIPS_STATE_DISAPPEAR. ret: %s layer: %s", next, Integer.valueOf(com.tencent.mm.plugin.newtips.a.exn().fI(arrayList)), Integer.valueOf(i2));
                b(eVar);
            }
        }
        AppMethodBeat.o(127248);
    }

    public static void fH(List<c> list) {
        AppMethodBeat.i(127249);
        for (c cVar : list) {
            if (Util.isNullOrNil(cVar.field_dynamicPath)) {
                com.tencent.mm.plugin.newtips.a.exl().TB(cVar.field_path);
            } else {
                com.tencent.mm.plugin.newtips.a.exl().aIC(cVar.field_dynamicPath);
            }
        }
        AppMethodBeat.o(127249);
    }

    private static void b(e eVar) {
        AppMethodBeat.i(188563);
        if (eVar == null) {
            AppMethodBeat.o(188563);
        } else if (eVar.ADS) {
            com.tencent.mm.plugin.newtips.a.exl().aIC(eVar.ADR);
            AppMethodBeat.o(188563);
        } else {
            com.tencent.mm.plugin.newtips.a.exl().TB(eVar.path);
            AppMethodBeat.o(188563);
        }
    }

    public static void TD(int i2) {
        AppMethodBeat.i(259550);
        com.tencent.mm.plugin.newtips.a.exl().TB(i2);
        AppMethodBeat.o(259550);
    }

    static /* synthetic */ Pair a(i iVar, e eVar) {
        boolean z;
        AppMethodBeat.i(188565);
        if (eVar == null) {
            z = false;
        } else if (!eVar.ADS) {
            switch (eVar.path) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 24:
                case 25:
                case 26:
                case 27:
                    z = true;
                    break;
                case 23:
                default:
                    z = false;
                    break;
            }
        } else {
            z = true;
        }
        if (!z) {
            Log.i("MicroMsg.NewTips.NewTipsManager", "getShouldShowType() %s not support newTip", eVar);
            Pair pair = new Pair(k.MMNEWTIPS_SHOWTYPE_NONE, new ehv());
            AppMethodBeat.o(188565);
            return pair;
        }
        List<c> fG = e.fG(com.tencent.mm.plugin.newtips.a.exn().c(eVar));
        if (fG.size() <= 0) {
            Pair pair2 = new Pair(k.MMNEWTIPS_SHOWTYPE_NONE, new ehv());
            AppMethodBeat.o(188565);
            return pair2;
        }
        ArrayList arrayList = new ArrayList();
        long aWB = (long) cl.aWB();
        for (c cVar : fG) {
            if (cVar.field_exposureTime == 0) {
                cVar.field_exposureTime = aWB;
                if (cVar.field_overdueTime != 0) {
                    cVar.field_exposureDisappearTime = cVar.field_overdueTime + aWB;
                }
                arrayList.add(cVar);
            }
        }
        if (!arrayList.isEmpty()) {
            Log.i("MicroMsg.NewTips.NewTipsManager", "getShouldShowType() set exposureTime(%s). ret: %s", Long.valueOf(aWB), Integer.valueOf(com.tencent.mm.plugin.newtips.a.exn().fI(arrayList)));
        }
        if (fG.size() == 1) {
            k TE = k.TE(fG.get(0).field_showType);
            if (!g.a(eVar, TE)) {
                Pair pair3 = new Pair(k.MMNEWTIPS_SHOWTYPE_REDPOINT, new ehv());
                AppMethodBeat.o(188565);
                return pair3;
            } else if (TE == k.MMNEWTIPS_SHOWTYPE_COUNTER) {
                ehv ehv = new ehv();
                ehv.ibS = 1;
                Pair pair4 = new Pair(k.MMNEWTIPS_SHOWTYPE_COUNTER, ehv);
                AppMethodBeat.o(188565);
                return pair4;
            } else {
                Pair pair5 = new Pair(TE, k.a(TE, fG.get(0)));
                AppMethodBeat.o(188565);
                return pair5;
            }
        } else {
            ArrayList arrayList2 = new ArrayList();
            int i2 = 0;
            for (c cVar2 : fG) {
                if (k.MMNEWTIPS_SHOWTYPE_COUNTER == k.TE(cVar2.field_showType)) {
                    i2++;
                } else {
                    arrayList2.add(cVar2);
                }
            }
            if (i2 > 0) {
                if (g.a(eVar, k.MMNEWTIPS_SHOWTYPE_COUNTER)) {
                    ehv ehv2 = new ehv();
                    ehv2.ibS = i2;
                    Pair pair6 = new Pair(k.MMNEWTIPS_SHOWTYPE_COUNTER, ehv2);
                    AppMethodBeat.o(188565);
                    return pair6;
                } else if (i2 == fG.size()) {
                    Log.d("MicroMsg.NewTips.NewTipsManager", "getShouldShowType() path(%s): MMNEWTIPS_SHOWTYPE_COUNTER => MMNEWTIPS_SHOWTYPE_REDPOINT", eVar);
                    Pair pair7 = new Pair(k.MMNEWTIPS_SHOWTYPE_REDPOINT, new ehv());
                    AppMethodBeat.o(188565);
                    return pair7;
                }
            }
            Log.d("MicroMsg.NewTips.NewTipsManager", "getShouldShowType() path(%s) (MMNEWTIPS_SHOWTYPE_COUNTER:%s, ALL:%s) postpone", eVar, Integer.valueOf(i2), Integer.valueOf(fG.size()));
            Collections.sort(arrayList2, new Comparator<c>() {
                /* class com.tencent.mm.plugin.newtips.a.i.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(c cVar, c cVar2) {
                    AppMethodBeat.i(188559);
                    c cVar3 = cVar;
                    c cVar4 = cVar2;
                    if (cVar3.field_priority != cVar4.field_priority) {
                        int i2 = cVar3.field_priority - cVar4.field_priority;
                        AppMethodBeat.o(188559);
                        return i2;
                    }
                    int compare = Long.compare(cVar3.field_beginShowTime, cVar4.field_beginShowTime);
                    AppMethodBeat.o(188559);
                    return compare;
                }
            });
            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                k TE2 = k.TE(((c) arrayList2.get(size)).field_showType);
                if (g.a(eVar, TE2)) {
                    Pair pair8 = new Pair(TE2, k.a(TE2, (c) arrayList2.get(size)));
                    AppMethodBeat.o(188565);
                    return pair8;
                }
            }
            Pair pair9 = new Pair(k.MMNEWTIPS_SHOWTYPE_REDPOINT, new ehv());
            AppMethodBeat.o(188565);
            return pair9;
        }
    }
}
