package com.tencent.mm.plugin.appbrand.service;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.c.i;
import com.tencent.luggage.sdk.b.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.x;
import com.tencent.mm.g.b.a.mj;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.m.g;
import com.tencent.mm.plugin.appbrand.m.t;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;
import java.util.UUID;

public final class a extends i<c> {
    @Override // com.tencent.luggage.sdk.b.a.c.b
    public final /* synthetic */ String a(s sVar, String str) {
        AppMethodBeat.i(48245);
        String e2 = e((c) sVar, str);
        AppMethodBeat.o(48245);
        return e2;
    }

    @Override // com.tencent.luggage.sdk.b.a.c.b
    public final /* synthetic */ void a(s sVar, g gVar) {
        AppMethodBeat.i(175064);
        aa aaVar = aa.nMY;
        if (aa.f((c) sVar)) {
            final long currentTimeMillis = System.currentTimeMillis();
            aa aaVar2 = aa.nMY;
            final String bVu = aa.bVu();
            aa aaVar3 = aa.nMY;
            String bVv = aa.bVv();
            aa aaVar4 = aa.nMY;
            String bVw = aa.bVw();
            Log.i("MicroMsg.AppBrandJSContextInterfaceWC", "beforeEvaluateScriptFile name:%s", bVu);
            Log.v("MicroMsg.AppBrandJSContextInterfaceWC", "beforeEvaluateScriptFile jsSource:%s", bVu, bVv);
            final d.a aVar = new d.a();
            aVar.scriptName = bVu;
            aVar.czz = bVv;
            aVar.czA = bVv.length();
            com.tencent.mm.plugin.appbrand.utils.s.a(gVar, "https://lib/" + bVu, "", "", 0, bVv, bVw, new s.a() {
                /* class com.tencent.mm.plugin.appbrand.service.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.utils.s.a
                public final void onSuccess(String str) {
                    AppMethodBeat.i(48238);
                    a.this.a(aVar, true, currentTimeMillis, System.currentTimeMillis(), null);
                    Log.i("MicroMsg.AppBrandJSContextInterfaceWC", "beforeEvaluateScriptFile inject name(%s) onSuccess ret:%s", bVu, str);
                    AppMethodBeat.o(48238);
                }

                @Override // com.tencent.mm.plugin.appbrand.utils.s.a
                public final void du(String str) {
                    AppMethodBeat.i(48239);
                    a.this.a(aVar, false, currentTimeMillis, System.currentTimeMillis(), null);
                    Log.e("MicroMsg.AppBrandJSContextInterfaceWC", "beforeEvaluateScriptFile inject name(%s) onFailure ret:%s", bVu, str);
                    AppMethodBeat.o(48239);
                }
            });
        }
        AppMethodBeat.o(175064);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.i, com.tencent.luggage.sdk.b.a.c.b
    public final /* synthetic */ String b(com.tencent.mm.plugin.appbrand.s sVar) {
        AppMethodBeat.i(48247);
        String e2 = e((c) sVar);
        AppMethodBeat.o(48247);
        return e2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.luggage.sdk.b.a.c.d] */
    @Override // com.tencent.luggage.sdk.b.a.c.i
    public final /* synthetic */ String c(c cVar) {
        AppMethodBeat.i(48244);
        String e2 = e(cVar);
        AppMethodBeat.o(48244);
        return e2;
    }

    a(c cVar, t tVar) {
        super(cVar, tVar);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.b
    public final void a(d.a aVar, boolean z, long j2, long j3, Object obj) {
        long j4;
        long j5;
        long j6;
        AppMethodBeat.i(175063);
        String str = aVar.scriptName;
        Log.i("MicroMsg.AppBrandJSContextInterfaceWC", "reportBootstrapScriptEvaluateResult appId[%s] name[%s] succeed[%b]", ((c) NY()).getAppId(), str, Boolean.valueOf(z));
        if ("WASubContext.js".equals(str)) {
            if (((c) NY()).getRuntime() != null) {
                if (z) {
                    c.a(((c) NY()).getAppId(), KSProcessWeAppLaunch.stepInjectJSWASubContext, "WASubContext.js", j2, j3);
                } else {
                    c.a(((c) NY()).getAppId(), KSProcessWeAppLaunch.stepInjectJSWASubContext, "", "WASubContext.js", j2, j3);
                }
            }
            if (z && (((c) NY()).bsW() || ((c) NY()).isRunning())) {
                m.c cVar = obj instanceof m.c ? (m.c) obj : null;
                mj zy = b.bUZ().l(NY()).zy(str);
                zy.fbD = (long) aVar.czA;
                if (cVar == null || cVar.codeCacheStatus < 0 || cVar.codeCacheStatus >= v.mNV.length) {
                    j4 = 4;
                } else {
                    j4 = (long) v.mNV[cVar.codeCacheStatus];
                }
                zy.fbG = j4;
                zy.fbH = 1;
                if (cVar != null) {
                    j5 = cVar.flatJSCompileCost;
                } else {
                    j5 = 0;
                }
                zy.fbI = j5;
                if (cVar != null) {
                    j6 = (long) cVar.dqm;
                } else {
                    j6 = 0;
                }
                zy.fca = j6;
                zy.vX(j2);
                zy.vY(j3);
                zy.vW(zy.fae - zy.fad);
                zy.bfK();
            }
            h.INSTANCE.idkeyStat(370, 40, 1, false);
            if (z) {
                h.INSTANCE.idkeyStat(370, 41, 1, false);
                AppMethodBeat.o(175063);
                return;
            }
            h.INSTANCE.idkeyStat(370, 42, 1, false);
            if (aVar.czA <= 0) {
                h.INSTANCE.dN(370, 74);
            }
            if (((c) NY()).getRuntime() == null) {
                AppMethodBeat.o(175063);
                return;
            }
            com.tencent.mm.plugin.appbrand.report.i.b(((c) NY()).getAppId(), ((c) NY()).getRuntime().bsB().leE.pkgVersion, ((c) NY()).getRuntime().bsB().leE.kNW, 370, 42);
            AppMethodBeat.o(175063);
            return;
        }
        if (str.endsWith("app-service.js")) {
            if (((c) NY()).getRuntime() != null) {
                if (z) {
                    c.a(((c) NY()).getAppId(), KSProcessWeAppLaunch.stepInjectJSAppService, str, j2, j3);
                    c.b(((c) NY()).getAppId(), KSProcessWeAppLaunch.stepServiceInit);
                } else {
                    c.a(((c) NY()).getAppId(), KSProcessWeAppLaunch.stepInjectJSAppService, "", str, j2, j3);
                    c.c(((c) NY()).getAppId(), KSProcessWeAppLaunch.stepServiceInit);
                }
            }
            if (z) {
                if (((c) NY()).bsW() || ((c) NY()).isRunning()) {
                    q runtime = ((c) NY()).getRuntime();
                    m.c cVar2 = obj instanceof m.c ? (m.c) obj : null;
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(runtime != null ? runtime.hashCode() : -1);
                    Log.i("MicroMsg.AppBrandJSContextInterfaceWC", "[QualitySystem] app-service.js runtime.hashCode = [%d]", objArr);
                    b.a(this.cAJ, str, aVar.czA, "", 0, j2, runtime != null ? runtime.hashCode() : -1, cVar2);
                }
                x.a(1, j3 - j2, ((c) NY()).bsX() ? 1 : 0, ((c) this.cAJ).getAppId(), -1, 0, ((c) NY()).bqZ().bvd());
                QualitySessionRuntime aeU = b.aeU(((c) this.cAJ).getAppId());
                if (aeU != null) {
                    x.a(7, System.currentTimeMillis() - aeU.nLD, ((c) NY()).bsX() ? 1 : 0, ((c) this.cAJ).getAppId(), -1, 0, ((c) NY()).bqZ().bvd());
                }
            }
            h.INSTANCE.idkeyStat(370, 44, 1, false);
            if (z) {
                h.INSTANCE.idkeyStat(370, 45, 1, false);
                AppMethodBeat.o(175063);
                return;
            }
            h.INSTANCE.idkeyStat(370, 46, 1, false);
            com.tencent.mm.plugin.appbrand.report.i.b(((c) NY()).getAppId(), ((c) NY()).getRuntime().bsB().leE.pkgVersion, ((c) NY()).getRuntime().bsB().leE.kNW, 370, 46);
        }
        AppMethodBeat.o(175063);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.b, com.tencent.mm.plugin.appbrand.jsapi.file.w.b
    public final void a(String str, d.a[] aVarArr, boolean[] zArr, Object[] objArr, long j2, long j3) {
        m.c cVar;
        int i2;
        AppMethodBeat.i(227414);
        if (TextUtils.isEmpty(str) && BuildInfo.DEBUG) {
            str = UUID.randomUUID().toString();
        }
        if (TextUtils.isEmpty(str) || aVarArr.length == 0 || zArr.length == 0) {
            AppMethodBeat.o(227414);
            return;
        }
        q runtime = ((c) this.cAJ).getRuntime();
        int i3 = 0;
        if (aVarArr.length == 1) {
            if (objArr[0] instanceof m.c) {
                cVar = (m.c) objArr[0];
            } else {
                cVar = null;
            }
            if (cVar != null) {
                i2 = cVar.sourceLength;
            } else if (aVarArr[0] != null) {
                i2 = aVarArr[0].czA;
            } else {
                AppMethodBeat.o(227414);
                return;
            }
        } else {
            long j4 = 0;
            long j5 = 0;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < aVarArr.length; i6++) {
                if (objArr[i6] instanceof m.c) {
                    m.c cVar2 = (m.c) objArr[i6];
                    i3 += cVar2.sourceLength;
                    j4 += cVar2.flatJSCompileCost;
                    j5 += cVar2.flatJSRunCost;
                    i4 = cVar2.codeCacheStatus;
                    i5 = cVar2.dqm;
                } else if (aVarArr[i6] != null) {
                    i3 += aVarArr[i6].czA;
                }
            }
            if (j5 > 0) {
                cVar = new m.c();
                cVar.dqk = j2;
                cVar.dql = j3;
                cVar.codeCacheStatus = i4;
                cVar.dqm = i5;
                cVar.flatJSCompileCost = j4;
                cVar.flatJSRunCost = j5;
                cVar.sourceLength = i3;
                i2 = i3;
            } else {
                cVar = null;
                i2 = i3;
            }
        }
        b.a(this.cAJ, (String) Objects.requireNonNull(str), i2, "", 0, j2, runtime != null ? runtime.hashCode() : -1, cVar);
        AppMethodBeat.o(227414);
    }

    private String e(c cVar) {
        AppMethodBeat.i(48241);
        String str = "";
        try {
            if (cVar instanceof y) {
                str = (str + Util.nullAsNil(((y) cVar).nMu)) + '\n';
            }
            String str2 = str + super.c(cVar);
            AppMethodBeat.o(48241);
            return str2;
        } catch (aq e2) {
            h.INSTANCE.idkeyStat(370, 39, 1, false);
            com.tencent.mm.plugin.appbrand.report.i.b(((c) NY()).getAppId(), ((c) NY()).getRuntime().bsB().leE.pkgVersion, ((c) NY()).getRuntime().bsB().leE.kNW, 370, 39);
            AppMethodBeat.o(48241);
            throw e2;
        }
    }

    private String e(c cVar, String str) {
        AppMethodBeat.i(48242);
        try {
            String a2 = super.a(cVar, str);
            AppMethodBeat.o(48242);
            return a2;
        } catch (aq e2) {
            h.INSTANCE.idkeyStat(370, 48, 1, false);
            com.tencent.mm.plugin.appbrand.report.i.b(((c) NY()).getAppId(), ((c) NY()).getRuntime().bsB().leE.pkgVersion, ((c) NY()).getRuntime().bsB().leE.kNW, 370, 48);
            AppMethodBeat.o(48242);
            throw e2;
        }
    }

    @Override // com.tencent.luggage.sdk.b.a.c.b
    public final int Mz() {
        AppMethodBeat.i(48243);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_common_lib_code_cache_type, 0);
        AppMethodBeat.o(48243);
        return a2;
    }
}
