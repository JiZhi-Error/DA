package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.api.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy;
import com.tencent.mm.plugin.appbrand.launching.e.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.m;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.q;
import junit.framework.Assert;
import kotlin.g.b.p;

public final class bf implements r {
    private q gut;
    private boolean lUi = false;

    static /* synthetic */ void b(bf bfVar) {
        AppMethodBeat.i(47387);
        bfVar.biW();
        AppMethodBeat.o(47387);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.r
    public final void b(Context context, String str, String str2, String str3, int i2, String str4, int i3) {
        AppMethodBeat.i(47376);
        if (Util.isNullOrNil(str3)) {
            AppMethodBeat.o(47376);
        } else if (Util.isNullOrNil(str3) || Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.WeAppLauncher", "targetAppId %s referrerAppId %s, Null Or Nil");
            AppMethodBeat.o(47376);
        } else {
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1055;
            appBrandStatObject.dCw = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(str)) + ":" + str2 + ":" + i3;
            AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
            appBrandLaunchReferrer.appId = str2;
            appBrandLaunchReferrer.leo = 2;
            appBrandLaunchReferrer.url = str;
            AppBrandLaunchProxyUI.a(context, null, str3, str4, i2, -1, appBrandStatObject, appBrandLaunchReferrer, null);
            Assert.assertTrue(true);
            AppMethodBeat.o(47376);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.service.r
    public final void a(Context context, String str, String str2, int i2, int i3, String str3, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(47377);
        AppBrandLaunchProxyUI.a(context, str, str2, str3, i2, i3, appBrandStatObject, null, null);
        AppMethodBeat.o(47377);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.r
    public final void a(Context context, g gVar) {
        AppMethodBeat.i(47378);
        u uVar = u.mTD;
        try {
            u.a(gVar);
            f fVar = f.mZp;
            if (gVar == null) {
                p.hyc();
            }
            fVar.a(context, u.b(gVar));
            AppMethodBeat.o(47378);
        } catch (Exception e2) {
            if (BuildInfo.IS_FLAVOR_RED) {
                RuntimeException runtimeException = new RuntimeException(e2);
                AppMethodBeat.o(47378);
                throw runtimeException;
            }
            Log.printErrStackTrace("MicroMsg.AppBrand.ExportWxaInstrumentation", e2, "", new Object[0]);
            AppMethodBeat.o(47378);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.service.r
    public final void a(i iVar) {
        AppMethodBeat.i(227119);
        if (iVar != null) {
            WeAppOpenUICallbackIPCProxy.c.b(iVar);
        }
        AppMethodBeat.o(227119);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.r
    public final void ej(String str, String str2) {
        String str3;
        AppMethodBeat.i(227120);
        if (TextUtils.isEmpty(str2)) {
            str3 = y.Xw(str);
        } else {
            str3 = str2;
        }
        Log.i("MicroMsg.WeAppLauncher", "closeWxaApp() identity:[%s | %s]->[%s | %s], versionType:%d, allowBackgroundRunning:%b", str, str2, str, str3, -1, Boolean.FALSE);
        if (TextUtils.isEmpty(str3)) {
            AppMethodBeat.o(227120);
            return;
        }
        h.bWb().cl(str3, -1);
        AppMethodBeat.o(227120);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.r
    public final void b(g gVar, com.tencent.mm.plugin.appbrand.api.f fVar) {
        AppMethodBeat.i(227121);
        if (gVar == null) {
            AppMethodBeat.o(227121);
            return;
        }
        j jVar = j.kAc;
        j.a(gVar, fVar);
        AppMethodBeat.o(227121);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.r
    public final boolean bW(String str, int i2) {
        AppMethodBeat.i(227122);
        boolean cn = h.bWb().cn(str, i2);
        AppMethodBeat.o(227122);
        return cn;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.r
    public final void a(Context context, String str, String str2, int i2, int i3, String str3, AppBrandStatObject appBrandStatObject, String str4) {
        AppMethodBeat.i(47379);
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        switch (appBrandStatObject.scene) {
            case 1020:
            case 1035:
            case 1043:
                appBrandLaunchReferrer.leo = 5;
                break;
            case 1036:
            case 1069:
                appBrandLaunchReferrer.leo = 4;
                break;
            case 1055:
                appBrandLaunchReferrer.leo = 2;
                break;
        }
        appBrandLaunchReferrer.appId = str4;
        AppBrandLaunchProxyUI.a(context, str, str2, str3, i2, i3, appBrandStatObject, appBrandLaunchReferrer, null);
        AppMethodBeat.o(47379);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.r
    public final void a(Context context, String str, String str2, boolean z, k.b bVar, Bundle bundle) {
        AppMethodBeat.i(175004);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        if (bundle.getBoolean("stat_kf_guide", false)) {
            Log.d("MicroMsg.WeAppLauncher", "launchByOpenSdkAppMessage kf guide msg");
            appBrandStatObject.scene = 1157;
            appBrandStatObject.dCw = str;
        } else {
            appBrandStatObject.scene = 1036;
            appBrandStatObject.dCw = Util.nullAsNil(bVar.appId) + ":" + Util.nullAsNil(com.tencent.mm.compatible.util.q.encode(bVar.url));
        }
        appBrandStatObject.ecU = z ? 2 : 1;
        if (z) {
            str2 = String.format("%s:%s", str, str2);
        }
        appBrandStatObject.ecV = str2;
        LaunchParamsOptional launchParamsOptional = new LaunchParamsOptional();
        if (!Util.isNullOrNil(bVar.izo)) {
            launchParamsOptional.cyq = str;
            launchParamsOptional.cyr = bVar.izo;
            appBrandStatObject.dCw += ":1";
        } else {
            appBrandStatObject.dCw += ":0";
        }
        appBrandStatObject.dCw += ":" + Util.nullAsNil(bVar.izn);
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        appBrandLaunchReferrer.leo = 4;
        appBrandLaunchReferrer.appId = bVar.appId;
        AppBrandLaunchProxyUI.a(context, bVar.izi, bVar.izj, bVar.izh, bVar.izz, bVar.izA, appBrandStatObject, appBrandLaunchReferrer, launchParamsOptional);
        AppMethodBeat.o(175004);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.r
    public final void b(Context context, String str, String str2, boolean z, k.b bVar, Bundle bundle) {
        AppMethodBeat.i(47381);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        LaunchParamsOptional launchParamsOptional = new LaunchParamsOptional();
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        boolean z2 = bundle.getBoolean("stat_weishi_from_opensdk", false);
        if (z2) {
            appBrandStatObject.scene = 1036;
            appBrandStatObject.dCw = Util.nullAsNil(bVar.appId) + ":" + Util.nullAsNil(com.tencent.mm.compatible.util.q.encode(bVar.url)) + ":" + Util.nullAsNil(bVar.izn);
            appBrandStatObject.ecU = z ? 2 : 1;
            if (z) {
                str2 = String.format("%s:%s", str, str2);
            }
            appBrandStatObject.ecV = str2;
            Log.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, from opensdk appmsg, scene:%s", Integer.valueOf(appBrandStatObject.scene));
            if (!Util.isNullOrNil(bVar.izo)) {
                appBrandStatObject.dCw += ":1";
            } else {
                appBrandStatObject.dCw += ":0";
            }
            appBrandLaunchReferrer.appId = bVar.appId;
            appBrandLaunchReferrer.leo = 4;
        } else {
            String str3 = bVar.izn;
            if (z) {
                appBrandStatObject.scene = 1008;
                appBrandStatObject.dCw = str + ":" + str2 + ":" + str3;
            } else {
                appBrandStatObject.scene = 1007;
                appBrandStatObject.dCw = str2 + ":" + str3;
            }
            appBrandStatObject.ecU = m.k(appBrandStatObject.scene, bundle);
            appBrandStatObject.ecV = m.l(appBrandStatObject.scene, bundle);
            Log.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, from chatting appmsg, scene:%s", Integer.valueOf(appBrandStatObject.scene));
            appBrandLaunchReferrer.appId = bVar.appId;
            appBrandLaunchReferrer.leo = 6;
        }
        if (!Util.isNullOrNil(bVar.izo)) {
            launchParamsOptional.cyq = str;
            launchParamsOptional.cyr = bVar.izo;
        }
        if ("wxfe02ecfe70800f46".equalsIgnoreCase(bVar.izj)) {
            AppBrandWeishiParams appBrandWeishiParams = new AppBrandWeishiParams();
            appBrandWeishiParams.ivk = z2 ? 1 : 0;
            appBrandWeishiParams.thumbUrl = bundle.getString("stat_weishi_thumb_url", null);
            appBrandWeishiParams.leN = bundle.getString("stat_weishi_thumb_path", null);
            appBrandWeishiParams.leO = bundle.getString("stat_weishi_msg_img_path", null);
            appBrandWeishiParams.appId = bundle.getString("stat_weishi_app_id", null);
            appBrandWeishiParams.appName = bundle.getString("stat_weishi_app_name", null);
            appBrandWeishiParams.sourceUserName = bundle.getString("stat_weishi_source_username", null);
            launchParamsOptional.cyt = appBrandWeishiParams;
            Log.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, weishi params:%s", appBrandWeishiParams);
        }
        AppBrandLaunchProxyUI.a(context, bVar.izi, bVar.izj, bVar.izh, bVar.izz, bVar.izA, appBrandStatObject, appBrandLaunchReferrer, launchParamsOptional);
        AppMethodBeat.o(47381);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.r
    public final void a(Context context, String str, int i2, String str2, AppBrandStatObject appBrandStatObject, String str3, String str4) {
        AppMethodBeat.i(47382);
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        appBrandLaunchReferrer.leo = 7;
        appBrandLaunchReferrer.appId = str3;
        appBrandLaunchReferrer.ler = str4;
        AppBrandLaunchProxyUI.a(context, str, null, str2, i2, 0, appBrandStatObject, appBrandLaunchReferrer, null);
        AppMethodBeat.o(47382);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.r
    public final void a(final Context context, final String str, final String str2, final String str3, String str4, final int i2, final int i3) {
        AppMethodBeat.i(47383);
        this.lUi = false;
        a(context, new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.appbrand.launching.bf.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(47368);
                Log.w("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, user canceled");
                bf.this.lUi = true;
                OpenBusinessViewUtil.B(str3, null, -3);
                AppMethodBeat.o(47368);
            }
        });
        OpenBusinessViewUtil.a(2, str3, str4, str2, str, new OpenBusinessViewUtil.a() {
            /* class com.tencent.mm.plugin.appbrand.launching.bf.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.a
            public final void ds(String str, String str2) {
                AppMethodBeat.i(47369);
                bf.b(bf.this);
                if (bf.this.lUi) {
                    AppMethodBeat.o(47369);
                } else if (Util.isNullOrNil(str)) {
                    Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, invalid businessType");
                    OpenBusinessViewUtil.B(str3, null, -4);
                    AppMethodBeat.o(47369);
                } else {
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = 1055;
                    appBrandStatObject.dCw = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(str)) + ":" + str2 + ":" + i3;
                    AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
                    appBrandLaunchReferrer.appId = str2;
                    appBrandLaunchReferrer.leo = 2;
                    appBrandLaunchReferrer.url = str;
                    appBrandLaunchReferrer.businessType = str3;
                    appBrandLaunchReferrer.sourceType = 5;
                    if (AppBrandLaunchProxyUI.a(context, null, str, str2, i2, -1, appBrandStatObject, appBrandLaunchReferrer, null)) {
                        Log.i("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch success");
                        AppMethodBeat.o(47369);
                        return;
                    }
                    Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch fail");
                    OpenBusinessViewUtil.B(str3, null, -1);
                    AppMethodBeat.o(47369);
                }
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.a
            public final void ak(int i2, String str) {
                AppMethodBeat.i(47370);
                Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch fail, CGI errCode:%d, errMsg:%s", Integer.valueOf(i2), str);
                bf.b(bf.this);
                OpenBusinessViewUtil.B(str3, null, -2);
                AppMethodBeat.o(47370);
            }
        });
        AppMethodBeat.o(47383);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.r
    public final void a(Context context, final String str, final String str2, String str3, final int i2, final r.a aVar) {
        AppMethodBeat.i(47384);
        Log.i("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk isMain[%b]", Boolean.valueOf(MMHandlerThread.isMainThread()));
        final AnonymousClass3 r2 = new r.a() {
            /* class com.tencent.mm.plugin.appbrand.launching.bf.AnonymousClass3 */
            private boolean mXt = false;

            @Override // com.tencent.mm.plugin.appbrand.service.r.a
            public final void bNR() {
                AppMethodBeat.i(47371);
                if (this.mXt) {
                    AppMethodBeat.o(47371);
                    return;
                }
                this.mXt = true;
                if (aVar != null) {
                    aVar.bNR();
                }
                AppMethodBeat.o(47371);
            }

            @Override // com.tencent.mm.plugin.appbrand.service.r.a
            public final void bNS() {
                AppMethodBeat.i(47372);
                if (this.mXt) {
                    AppMethodBeat.o(47372);
                    return;
                }
                this.mXt = true;
                if (aVar != null) {
                    aVar.bNS();
                }
                AppMethodBeat.o(47372);
            }
        };
        this.lUi = false;
        a(context, new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.appbrand.launching.bf.AnonymousClass4 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(47373);
                Log.w("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, user canceled");
                bf.this.lUi = true;
                r2.bNS();
                OpenBusinessViewUtil.A(str, str2, -2);
                AppMethodBeat.o(47373);
            }
        });
        OpenBusinessViewUtil.a(1, str2, str3, str, null, new OpenBusinessViewUtil.a() {
            /* class com.tencent.mm.plugin.appbrand.launching.bf.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.a
            public final void ds(String str, String str2) {
                AppMethodBeat.i(47374);
                bf.b(bf.this);
                if (bf.this.lUi) {
                    AppMethodBeat.o(47374);
                } else if (Util.isNullOrNil(str)) {
                    Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, invalid businessType");
                    r2.bNS();
                    OpenBusinessViewUtil.A(str, str2, -3);
                    AppMethodBeat.o(47374);
                } else {
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = 1069;
                    appBrandStatObject.dCw = str;
                    AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
                    appBrandLaunchReferrer.appId = str;
                    appBrandLaunchReferrer.leo = 4;
                    appBrandLaunchReferrer.businessType = str2;
                    appBrandLaunchReferrer.sourceType = 5;
                    if (AppBrandLaunchProxyUI.a(MMApplicationContext.getContext(), null, str, str2, i2, -1, appBrandStatObject, appBrandLaunchReferrer, null)) {
                        Log.i("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch success");
                        r2.bNR();
                        AppMethodBeat.o(47374);
                        return;
                    }
                    Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch fail");
                    r2.bNS();
                    OpenBusinessViewUtil.A(str, str2, -3);
                    AppMethodBeat.o(47374);
                }
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.a
            public final void ak(int i2, String str) {
                AppMethodBeat.i(47375);
                Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch fail, CGI errCode:%d, errMsg:%s", Integer.valueOf(i2), str);
                bf.b(bf.this);
                r2.bNS();
                OpenBusinessViewUtil.A(str, str2, -3);
                AppMethodBeat.o(47375);
            }
        });
        AppMethodBeat.o(47384);
    }

    private void a(Context context, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(47385);
        biW();
        context.getString(R.string.zb);
        this.gut = com.tencent.mm.ui.base.h.a(context, context.getString(R.string.a06), true, onCancelListener);
        AppMethodBeat.o(47385);
    }

    private void biW() {
        AppMethodBeat.i(47386);
        if (this.gut != null) {
            this.gut.dismiss();
            this.gut = null;
        }
        AppMethodBeat.o(47386);
    }
}
