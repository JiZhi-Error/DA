package com.tencent.mm.plugin.appbrand.game;

import com.tencent.luggage.game.c.e;
import com.tencent.luggage.game.d.a.a.b;
import com.tencent.luggage.game.e.a;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.luggage.sdk.b.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.g.b.a.mj;
import com.tencent.mm.plugin.appbrand.aa.b;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.m.g;
import com.tencent.mm.plugin.appbrand.m.t;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.List;

final class e extends com.tencent.luggage.game.d.a.a.e {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.s, java.lang.String] */
    @Override // com.tencent.luggage.sdk.b.a.c.b
    public final /* synthetic */ String a(d dVar, String str) {
        AppMethodBeat.i(45090);
        String a2 = super.a(dVar, str);
        Log.i("MicroMsg.WAGameJsContextInterfaceWC", "beforeInjectUserScript(%s)", str);
        com.tencent.mm.plugin.appbrand.game.preload.d bDu = com.tencent.mm.plugin.appbrand.game.preload.d.bDu();
        if (!Util.isNullOrNil(str) && str.equals("game.js")) {
            com.tencent.mm.plugin.appbrand.game.preload.e.bDw().dX(2000, (int) (Util.nowMilliSecond() - bDu.kGW.bsC().startTime));
            com.tencent.mm.plugin.appbrand.game.preload.e.bDw().dX(3001, bDu.ltZ.intValue());
            com.tencent.mm.plugin.appbrand.game.preload.e.bDw().dX(3003, bDu.ltY.intValue());
            com.tencent.mm.plugin.appbrand.game.preload.e.bDw().dX(4001, bDu.lua.intValue());
        }
        if (!Util.isNullOrNil(str) && str.equals("game.js")) {
            a.Nn().cxu = Util.currentTicks();
        }
        AppMethodBeat.o(45090);
        return a2;
    }

    e(d dVar, t tVar) {
        super(dVar, tVar);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.b
    public final int a(g gVar, String str) {
        AppMethodBeat.i(174724);
        Log.i("MicroMsg.WAGameJsContextInterfaceWC", "hy: injectWxaScript from js context interface: %s %d", str, Integer.valueOf(gVar.bMC()));
        boolean parseBoolean = Boolean.parseBoolean(((d) this.cAJ).bqZ().UN("injectGameContextPlugin"));
        Log.i("MicroMsg.WAGameJsContextInterfaceWC", "injectGameContextPlugin :%b, abtest:%b", Boolean.valueOf(parseBoolean), Boolean.valueOf(v.bvH()));
        if (!v.bvH() || !parseBoolean) {
            Log.i("MicroMsg.WAGameJsContextInterfaceWC", "injectPluginCodeNewLogic");
            if (str.equals("game.js")) {
                WxaRuntimeModulePluginListMap wxaRuntimeModulePluginListMap = ((d) this.cAJ).NP().OM().leE.kOb;
                List<WxaPluginPkgInfo> list = null;
                if (wxaRuntimeModulePluginListMap != null) {
                    list = wxaRuntimeModulePluginListMap.Vz(ModulePkgInfo.MAIN_MODULE_NAME);
                } else {
                    Log.e("MicroMsg.WAGameJsContextInterfaceWC", "pluginCodeList wxaRuntimeModulePluginListMap null");
                }
                if (list != null && list.size() > 0) {
                    Log.i("MicroMsg.WAGameJsContextInterfaceWC", "client inject pluginCode size:%s", Integer.valueOf(list.size()));
                    for (WxaPluginPkgInfo wxaPluginPkgInfo : list) {
                        List<Integer> list2 = wxaPluginPkgInfo.contexts;
                        if (list2 != null) {
                            Log.d("MicroMsg.WAGameJsContextInterfaceWC", "multiPkg contexts size:%d,contexts:%s", Integer.valueOf(list2.size()), Arrays.toString(list2.toArray()));
                        }
                        if (list2 != null && list2.contains(0)) {
                            String str2 = wxaPluginPkgInfo.prefixPath + ModulePkgInfo.GAME_PLUGIN_SCRIPT;
                            Log.d("MicroMsg.WAGameJsContextInterfaceWC", "pluginCodefilePath:%s", str2);
                            super.a(gVar, str2);
                        }
                    }
                }
            }
        }
        super.a(gVar, str);
        AppMethodBeat.o(174724);
        return 1;
    }

    private void b(e.a aVar, String str) {
        AppMethodBeat.i(45086);
        b bVar = (b) ((d) NY()).S(b.class);
        if (bVar != null) {
            bVar.Mg().a(aVar, str);
        }
        AppMethodBeat.o(45086);
    }

    private static void hc(boolean z) {
        AppMethodBeat.i(45087);
        h.INSTANCE.idkeyStat(370, 40, 1, false);
        if (z) {
            h.INSTANCE.idkeyStat(370, 49, 1, false);
            AppMethodBeat.o(45087);
            return;
        }
        h.INSTANCE.idkeyStat(370, 50, 1, false);
        AppMethodBeat.o(45087);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.b
    public final void a(d.a aVar, boolean z, long j2, long j3, Object obj) {
        long j4;
        long j5;
        long j6;
        AppMethodBeat.i(174726);
        String str = aVar.scriptName;
        if (str.endsWith("plugin.js")) {
            if (!z) {
                b(e.a.ERROR, "plugin " + aVar.kKF + " inject fail!");
                hc(false);
                AppMethodBeat.o(174726);
                return;
            } else if (((com.tencent.luggage.sdk.b.a.c.d) NY()).bsW() || ((com.tencent.luggage.sdk.b.a.c.d) NY()).isRunning()) {
                m.c cVar = obj instanceof m.c ? (m.c) obj : null;
                com.tencent.luggage.sdk.d.d NP = ((com.tencent.luggage.sdk.b.a.c.d) NY()).NP();
                Object[] objArr = new Object[2];
                objArr[0] = aVar.scriptName;
                objArr[1] = Integer.valueOf(NP != null ? NP.hashCode() : -1);
                Log.i("MicroMsg.WAGameJsContextInterfaceWC", "[QualitySystem] %s runtime.hashCode = [%d]", objArr);
                com.tencent.mm.plugin.appbrand.report.quality.b.a(this.cAJ, aVar.scriptName, aVar.czA, aVar.kKF, aVar.appVersion, j2, NP != null ? NP.hashCode() : -1, cVar);
                b(e.a.INFO, "plugin " + aVar.kKF + " inject success!");
                hc(true);
                AppMethodBeat.o(174726);
                return;
            }
        } else if ("WAGameSubContext.js".equals(str)) {
            if (z && (((com.tencent.luggage.sdk.b.a.c.d) NY()).bsW() || ((com.tencent.luggage.sdk.b.a.c.d) NY()).isRunning())) {
                m.c cVar2 = obj instanceof m.c ? (m.c) obj : null;
                mj zy = com.tencent.mm.plugin.appbrand.report.quality.b.bUZ().l(NY()).zy(str);
                zy.fbD = (long) aVar.czA;
                if (cVar2 == null || cVar2.codeCacheStatus < 0 || cVar2.codeCacheStatus >= com.tencent.mm.plugin.appbrand.m.v.mNV.length) {
                    j4 = 4;
                } else {
                    j4 = (long) com.tencent.mm.plugin.appbrand.m.v.mNV[cVar2.codeCacheStatus];
                }
                zy.fbG = j4;
                zy.fbH = 1;
                if (cVar2 != null) {
                    j5 = cVar2.flatJSCompileCost;
                } else {
                    j5 = 0;
                }
                zy.fbI = j5;
                if (cVar2 != null) {
                    j6 = (long) cVar2.dqm;
                } else {
                    j6 = 0;
                }
                zy.fca = j6;
                zy.vX(j2);
                zy.vY(j3);
                zy.vW(zy.fae - zy.fad);
                zy.bfK();
            }
            h.INSTANCE.idkeyStat(778, 17, 1, false);
            if (z) {
                h.INSTANCE.idkeyStat(778, 19, 1, false);
            } else {
                h.INSTANCE.idkeyStat(778, 18, 1, false);
                i.cf(((com.tencent.luggage.sdk.b.a.c.d) NY()).getAppId(), 24);
                i.b(((com.tencent.luggage.sdk.b.a.c.d) NY()).getAppId(), ((com.tencent.luggage.sdk.b.a.c.d) NY()).NP().OM().leE.pkgVersion, ((com.tencent.luggage.sdk.b.a.c.d) NY()).NP().OM().leE.kNW, 778, 18);
            }
            if (((com.tencent.luggage.sdk.b.a.c.d) NY()).NP() != null) {
                if (z) {
                    c.a(((com.tencent.luggage.sdk.b.a.c.d) NY()).getAppId(), KSProcessWeAppLaunch.stepInjectWAGameSubContext, "WAGameSubContext.js", j2, j3);
                    AppMethodBeat.o(174726);
                    return;
                }
                c.a(((com.tencent.luggage.sdk.b.a.c.d) NY()).getAppId(), KSProcessWeAppLaunch.stepInjectJSWASubContext, "", "WAGameSubContext.js", j2, j3);
                AppMethodBeat.o(174726);
                return;
            }
        } else if (str.endsWith("game.js")) {
            if (((com.tencent.luggage.sdk.b.a.c.d) NY()).bsW() || ((com.tencent.luggage.sdk.b.a.c.d) NY()).isRunning()) {
                m.c cVar3 = obj instanceof m.c ? (m.c) obj : null;
                com.tencent.luggage.sdk.d.d NP2 = ((com.tencent.luggage.sdk.b.a.c.d) NY()).NP();
                Object[] objArr2 = new Object[1];
                objArr2[0] = Integer.valueOf(NP2 != null ? NP2.hashCode() : -1);
                Log.i("MicroMsg.WAGameJsContextInterfaceWC", "[QualitySystem] app-service.js runtime.hashCode = [%d]", objArr2);
                com.tencent.mm.plugin.appbrand.report.quality.b.a(this.cAJ, aVar.scriptName, aVar.czA, "", 0, j2, NP2 != null ? NP2.hashCode() : -1, cVar3);
            }
            h.INSTANCE.idkeyStat(778, 21, 1, false);
            if (z) {
                h.INSTANCE.idkeyStat(778, 23, 1, false);
            } else {
                h.INSTANCE.idkeyStat(778, 22, 1, false);
                i.cf(((com.tencent.luggage.sdk.b.a.c.d) NY()).getAppId(), 24);
                i.b(((com.tencent.luggage.sdk.b.a.c.d) NY()).getAppId(), ((com.tencent.luggage.sdk.b.a.c.d) NY()).NP().OM().leE.pkgVersion, ((com.tencent.luggage.sdk.b.a.c.d) NY()).NP().OM().leE.kNW, 778, 22);
            }
            com.tencent.mm.plugin.appbrand.aa.b unused = b.a.nOf;
            com.tencent.mm.plugin.appbrand.aa.b.b(KSProcessWeAppLaunch.NAME, ((com.tencent.luggage.sdk.b.a.c.d) NY()).getAppId(), b.EnumC0531b.INJECT_JS);
            if (((com.tencent.luggage.sdk.b.a.c.d) NY()).NP() != null) {
                AppBrandPerformanceManager.a(((com.tencent.luggage.sdk.b.a.c.d) NY()).NP(), 204, j3 - j2);
                if (z) {
                    c.a(((com.tencent.luggage.sdk.b.a.c.d) NY()).getAppId(), KSProcessWeAppLaunch.stepInjectJSGame, str, j2, j3);
                    c.b(((com.tencent.luggage.sdk.b.a.c.d) NY()).getAppId(), KSProcessWeAppLaunch.stepServiceInit_Game);
                    AppMethodBeat.o(174726);
                    return;
                }
                c.a(((com.tencent.luggage.sdk.b.a.c.d) NY()).getAppId(), KSProcessWeAppLaunch.stepInjectJSGame, "", str, j2, j3);
                c.c(((com.tencent.luggage.sdk.b.a.c.d) NY()).getAppId(), KSProcessWeAppLaunch.stepServiceInit_Game);
            }
        }
        AppMethodBeat.o(174726);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.b
    public final int Mz() {
        AppMethodBeat.i(45089);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_common_lib_code_cache_type, 0);
        AppMethodBeat.o(45089);
        return a2;
    }
}
