package com.tencent.luggage.sdk.d;

import android.animation.Animator;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.luggage.sdk.c.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.appcache.AssetReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bo;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.f;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.p.g;
import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.permission.d;
import com.tencent.mm.plugin.appbrand.permission.j;
import com.tencent.mm.plugin.appbrand.permission.k;
import com.tencent.mm.plugin.appbrand.permission.n;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import junit.framework.Assert;

public class d extends AppBrandRuntime {
    public v cCl;
    private Boolean cCm = null;
    public volatile com.tencent.mm.plugin.appbrand.permission.d cCn;

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public /* synthetic */ l OT() {
        AppMethodBeat.i(146916);
        AppBrandSysConfigLU OM = OM();
        AppMethodBeat.o(146916);
        return OM;
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public /* synthetic */ AppBrandInitConfig OU() {
        AppMethodBeat.i(146917);
        AppBrandInitConfigLU ON = ON();
        AppMethodBeat.o(146917);
        return ON;
    }

    static {
        AppMethodBeat.i(182987);
        bo.a(g.cCq);
        WxaPkgWrappingInfo.a(h.a.nho);
        AppMethodBeat.o(182987);
    }

    public d(ak akVar) {
        super(akVar);
    }

    protected d(c cVar) {
        super(cVar);
    }

    public final com.tencent.mm.plugin.appbrand.permission.d OI() {
        return this.cCn;
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public void onResume() {
        AppMethodBeat.i(146898);
        super.onResume();
        com.tencent.mm.plugin.appbrand.permission.d dVar = this.cCn;
        LinkedList linkedList = new LinkedList();
        synchronized (dVar.nxr) {
            try {
                linkedList.addAll(dVar.nxr);
                dVar.nxr.clear();
            } finally {
                AppMethodBeat.o(146898);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((d.b) it.next()).a(d.a.bSY());
        }
    }

    /* access modifiers changed from: protected */
    public boolean b(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(146900);
        if (!TextUtils.isEmpty(appBrandInitConfig.kHw)) {
            AppMethodBeat.o(146900);
            return true;
        }
        AppMethodBeat.o(146900);
        return false;
    }

    public final at OK() {
        AppMethodBeat.i(146901);
        at atVar = (at) super.getFileSystem();
        AppMethodBeat.o(146901);
        return atVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public q OL() {
        com.tencent.mm.plugin.appbrand.jsapi.file.d a2;
        AppMethodBeat.i(146902);
        AppBrandSysConfigLU OM = OM();
        if (OM == null) {
            Log.e("Luggage.WXA.AppBrandRuntimeLU", "createFileSystem but get NUL sysConfig, appId:%s", this.mAppId);
            a2 = new com.tencent.mm.plugin.appbrand.jsapi.file.d();
        } else {
            a2 = f.a(OM);
        }
        at atVar = new at(this, a2);
        AppMethodBeat.o(146902);
        return atVar;
    }

    public AppBrandSysConfigLU OM() {
        AppMethodBeat.i(146903);
        AppBrandSysConfigLU appBrandSysConfigLU = (AppBrandSysConfigLU) d(AppBrandSysConfigLU.class, false);
        AppMethodBeat.o(146903);
        return appBrandSysConfigLU;
    }

    public AppBrandInitConfigLU ON() {
        AppMethodBeat.i(146904);
        AppBrandInitConfigLU appBrandInitConfigLU = (AppBrandInitConfigLU) super.OU();
        AppMethodBeat.o(146904);
        return appBrandInitConfigLU;
    }

    public final AppBrandStatObject Nz() {
        AppMethodBeat.i(146905);
        AppBrandStatObject appBrandStatObject = ON().cyA;
        AppMethodBeat.o(146905);
        return appBrandStatObject;
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public void a(AppBrandInitConfig appBrandInitConfig, Object obj) {
        String jSONObject;
        AppMethodBeat.i(169456);
        try {
            MiniProgramNavigationBackResult.class.cast(obj);
            AppBrandInitConfigLU NG = ON().NG();
            AppBrandLaunchReferrer appBrandLaunchReferrer = NG.cys;
            MiniProgramNavigationBackResult miniProgramNavigationBackResult = (MiniProgramNavigationBackResult) obj;
            AppBrandLaunchReferrer appBrandLaunchReferrer2 = new AppBrandLaunchReferrer();
            appBrandLaunchReferrer2.appId = appBrandInitConfig.appId;
            appBrandLaunchReferrer2.leo = 3;
            appBrandLaunchReferrer2.dSJ = miniProgramNavigationBackResult == null ? null : miniProgramNavigationBackResult.kFg.toString();
            if (miniProgramNavigationBackResult == null) {
                jSONObject = null;
            } else {
                jSONObject = miniProgramNavigationBackResult.kFh.toString();
            }
            appBrandLaunchReferrer2.lep = jSONObject;
            appBrandLaunchReferrer.a(appBrandLaunchReferrer2);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1038;
            if (appBrandInitConfig instanceof AppBrandInitConfigLU) {
                appBrandStatObject.dCw = appBrandInitConfig.appId + ':' + ((AppBrandInitConfigLU) appBrandInitConfig).cym + ':' + (((AppBrandInitConfigLU) appBrandInitConfig).cyo + 1000);
            }
            NG.startTime = Util.nowMilliSecond();
            NG.kHw = null;
            NG.resetSession();
            NG.cyA = appBrandStatObject;
            d((AppBrandInitConfig) NG);
            AppMethodBeat.o(169456);
        } catch (ClassCastException e2) {
            IllegalStateException illegalStateException = new IllegalStateException("Only data as MiniProgramNavigationBackResult acceptable here.", e2);
            AppMethodBeat.o(169456);
            throw illegalStateException;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public void onReady() {
        AppMethodBeat.i(146907);
        super.onReady();
        if (AppBrandPerformanceManager.e(this) && this.cCl == null) {
            AppBrandPerformanceManager.d(this);
            this.cCl = OP();
            if (this.cCl != null) {
                this.kAt.addView(this.cCl);
                v vVar = this.cCl;
                AppBrandPerformanceManager.f(vVar.cBE);
                vVar.setVisibility(0);
                vVar.setAlpha(0.0f);
                vVar.animate().alpha(1.0f).setDuration(500).setStartDelay(500).setListener(null);
            }
        }
        AppMethodBeat.o(146907);
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public final <T extends a> T V(Class<T> cls) {
        AppMethodBeat.i(169457);
        if (k.class == cls) {
            T cast = cls.cast(n.nxG);
            AppMethodBeat.o(169457);
            return cast;
        } else if (j.class == cls) {
            com.tencent.mm.plugin.appbrand.permission.l lVar = new com.tencent.mm.plugin.appbrand.permission.l(this);
            b(j.class, lVar);
            T cast2 = cls.cast(lVar);
            AppMethodBeat.o(169457);
            return cast2;
        } else {
            T t = (T) super.V(cls);
            AppMethodBeat.o(169457);
            return t;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public void OO() {
        AppMethodBeat.i(146909);
        super.OO();
        if (af(ICommLibReader.class) == null) {
            b(ICommLibReader.class, AssetReader.kKj);
        }
        this.kAA.add(new aa((ICommLibReader) af(ICommLibReader.class), bg.M(this)));
        if (this.cCn == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Should ensure ApiPermissionController installed before init. Use #setApiPermissionController().");
            AppMethodBeat.o(146909);
            throw illegalStateException;
        }
        AppMethodBeat.o(146909);
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public void onDestroy() {
        AppMethodBeat.i(146910);
        super.onDestroy();
        if (this.cCl != null) {
            if (this.cCl.getParent() instanceof ViewGroup) {
                v vVar = this.cCl;
                AppBrandPerformanceManager.aei(vVar.cBE.mAppId);
                vVar.animate().alpha(0.0f).setDuration(500).setListener(new Animator.AnimatorListener() {
                    /* class com.tencent.mm.plugin.appbrand.ui.v.AnonymousClass1 */

                    public final void onAnimationStart(Animator animator) {
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(147691);
                        v.this.setVisibility(8);
                        AppMethodBeat.o(147691);
                    }

                    public final void onAnimationCancel(Animator animator) {
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                });
                ((ViewGroup) this.cCl.getParent()).removeView(this.cCl);
            }
            this.cCl = null;
        }
        if (this.cCn != null) {
            com.tencent.mm.plugin.appbrand.permission.d dVar = this.cCn;
            synchronized (dVar.nxr) {
                try {
                    dVar.nxr.clear();
                } catch (Throwable th) {
                    AppMethodBeat.o(146910);
                    throw th;
                }
            }
        }
        this.cCn = null;
        at atVar = (at) super.getFileSystem();
        if (atVar != null) {
            o oVar = (o) atVar.az(o.class);
            if (oVar != null) {
                s.deleteFile(oVar.kSr + "/dir.lock");
            }
            atVar.release();
        }
        AppMethodBeat.o(146910);
    }

    /* access modifiers changed from: protected */
    public v OP() {
        AppMethodBeat.i(146911);
        v vVar = new v(AndroidContextUtil.castActivityOrNull(this.mContext), this);
        AppMethodBeat.o(146911);
        return vVar;
    }

    public boolean OQ() {
        AppMethodBeat.i(146912);
        if (this.cCm != null) {
            boolean booleanValue = this.cCm.booleanValue();
            AppMethodBeat.o(146912);
            return booleanValue;
        }
        Boolean valueOf = Boolean.valueOf(c(ON()));
        this.cCm = valueOf;
        boolean booleanValue2 = valueOf.booleanValue();
        AppMethodBeat.o(146912);
        return booleanValue2;
    }

    private static boolean c(AppBrandInitConfigLU appBrandInitConfigLU) {
        AppMethodBeat.i(146913);
        if (!appBrandInitConfigLU.cyp || (!e(appBrandInitConfigLU) && !d(appBrandInitConfigLU))) {
            AppMethodBeat.o(146913);
            return false;
        }
        AppMethodBeat.o(146913);
        return true;
    }

    public final boolean OS() {
        AppMethodBeat.i(229874);
        if (isDestroyed()) {
            AppMethodBeat.o(229874);
            return false;
        } else if (ON().cyz == b.PRE_RENDER) {
            AppMethodBeat.o(229874);
            return true;
        } else {
            AppMethodBeat.o(229874);
            return false;
        }
    }

    public final int OJ() {
        AppMethodBeat.i(146897);
        if (j.a.sE(this.kAq.eix)) {
            AppMethodBeat.o(146897);
            return 0;
        }
        int i2 = ON().appVersion;
        AppMethodBeat.o(146897);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public void a(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(146899);
        if (!this.mInitialized) {
            AppMethodBeat.o(146899);
            return;
        }
        boolean OQ = OQ();
        boolean c2 = c((AppBrandInitConfigLU) appBrandInitConfig);
        if ((!OQ && c2) || (OQ && !c2 && e((AppBrandInitConfigLU) appBrandInitConfig))) {
            this.cCm = null;
            brC();
        }
        if (!this.kAJ && !isDestroyed()) {
            if (j.a.vP(this.kAq.eix) && ((AppBrandInitConfigLU) appBrandInitConfig).appVersion != OM().leE.pkgVersion) {
                String format = String.format(Locale.ENGLISH, "Updated InitConfig.appVersion != getSysConfig().appVersion, appId:%s, @smoothieli", this.mAppId);
                Log.w("Luggage.WXA.AppBrandRuntimeLU", format);
                if (this.kAU) {
                    Assert.fail(format);
                } else {
                    brC();
                }
            }
            if (b(appBrandInitConfig)) {
                brE();
            }
        }
        super.a(appBrandInitConfig);
        AppMethodBeat.o(146899);
    }

    private static boolean d(AppBrandInitConfigLU appBrandInitConfigLU) {
        return appBrandInitConfigLU.cyA.scene == 1101;
    }

    private static boolean e(AppBrandInitConfigLU appBrandInitConfigLU) {
        AppBrandStatObject appBrandStatObject = appBrandInitConfigLU.cyA;
        return appBrandStatObject.scene == 1011 || appBrandStatObject.scene == 1012 || appBrandStatObject.scene == 1013;
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public com.tencent.mm.plugin.appbrand.p.a OR() {
        boolean z;
        AppMethodBeat.i(146914);
        if (OM() == null || (Util.isNullOrNil(OM().leE.kNZ) && !ON().NA())) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            g gVar = new g(this);
            AppMethodBeat.o(146914);
            return gVar;
        }
        a.C0183a aVar = new a.C0183a(this, (byte) 0);
        AppMethodBeat.o(146914);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public final /* bridge */ /* synthetic */ q getFileSystem() {
        AppMethodBeat.i(146915);
        at atVar = (at) super.getFileSystem();
        AppMethodBeat.o(146915);
        return atVar;
    }
}
