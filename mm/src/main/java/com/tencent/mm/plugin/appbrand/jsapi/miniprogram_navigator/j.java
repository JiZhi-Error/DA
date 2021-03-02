package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.g;
import org.json.JSONObject;

public class j implements c {
    static final j meZ = new j();

    static {
        AppMethodBeat.i(147197);
        AppMethodBeat.o(147197);
    }

    public boolean a(d dVar, LaunchParcel launchParcel, c.b bVar) {
        return false;
    }

    public com.tencent.mm.vending.g.c<AppBrandInitConfigLU> a(d dVar, LaunchParcel launchParcel, JSONObject jSONObject) {
        AppMethodBeat.i(147195);
        com.tencent.mm.vending.g.c<AppBrandInitConfigLU> en = g.en(null);
        AppMethodBeat.o(147195);
        return en;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c
    public final void a(final d dVar, String str, int i2, String str2, c.a aVar, final JSONObject jSONObject, final c.AbstractC0681c cVar) {
        ac currentPageView;
        String str3;
        String str4;
        AppMethodBeat.i(147196);
        com.tencent.mm.plugin.appbrand.keylogger.c.e(KSProcessWeAppLaunch.class, str);
        com.tencent.mm.plugin.appbrand.keylogger.c.a(KSProcessWeAppLaunch.class, str, String.format("Network:%s", NetStatusUtil.getNetTypeString(dVar.getRuntime().mContext)));
        Object[] objArr = new Object[3];
        objArr[0] = dVar.getAppId();
        objArr[1] = str;
        objArr[2] = Integer.valueOf(aVar != null ? aVar.sourceType : 0);
        Log.i("MicroMsg.MiniProgramNavigator", "navigateTo fromAppID(%s) targetAppID(%s) sourceType:%d", objArr);
        JSONObject optJSONObject = jSONObject.optJSONObject("extraData");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("privateExtraData");
        if (dVar instanceof ac) {
            currentPageView = (ac) dVar;
        } else {
            currentPageView = ((s) dVar).getCurrentPageView();
        }
        if (currentPageView != null) {
            str3 = currentPageView.nna;
        } else {
            str3 = "";
        }
        final com.tencent.luggage.sdk.d.d dVar2 = (com.tencent.luggage.sdk.d.d) dVar.getRuntime();
        String str5 = dVar.getAppId() + ":" + dVar2.ON().cym + ":" + (dVar2.ON().cyo + 1000);
        AppBrandStatObject appBrandStatObject = dVar2.ON().cyA;
        AppBrandStatObject appBrandStatObject2 = new AppBrandStatObject();
        appBrandStatObject2.scene = (aVar == null || aVar.scene == 0) ? 1037 : aVar.scene;
        appBrandStatObject2.ecS = appBrandStatObject.ecS;
        if (aVar == null || aVar.scene == 0 || Util.isNullOrNil(aVar.dCw)) {
            str4 = str5;
        } else {
            str4 = String.format("%s:%s", str5, aVar.dCw);
        }
        appBrandStatObject2.dCw = str4;
        appBrandStatObject2.ecU = aVar != null ? aVar.ecU : 0;
        appBrandStatObject2.ecV = aVar != null ? aVar.ecV : null;
        appBrandStatObject2.meP = aVar != null ? aVar.meP : null;
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        appBrandLaunchReferrer.appId = dVar.getAppId();
        appBrandLaunchReferrer.dSJ = optJSONObject == null ? "{}" : optJSONObject.toString();
        appBrandLaunchReferrer.lep = optJSONObject2 == null ? "{}" : optJSONObject2.toString();
        appBrandLaunchReferrer.leo = 1;
        appBrandLaunchReferrer.url = str3;
        appBrandLaunchReferrer.sourceType = aVar != null ? aVar.sourceType : 0;
        appBrandLaunchReferrer.leq = aVar != null ? aVar.leq : null;
        appBrandLaunchReferrer.businessType = aVar != null ? aVar.businessType : null;
        long nowMilliSecond = Util.nowMilliSecond();
        final LaunchParcel launchParcel = new LaunchParcel();
        launchParcel.username = null;
        launchParcel.appId = str;
        launchParcel.version = 0;
        launchParcel.iOo = i2;
        launchParcel.kHw = str2;
        launchParcel.mYK = appBrandStatObject2;
        launchParcel.cys = appBrandLaunchReferrer;
        launchParcel.mYL = null;
        launchParcel.mYM = nowMilliSecond;
        final i iVar = new i();
        g.hdG().b(dVar2).f(new a<Boolean, Void>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Boolean call(Void r7) {
                AppMethodBeat.i(147193);
                final b hdH = g.hdH();
                iVar.value = (T) new com.tencent.mm.plugin.appbrand.p.d();
                iVar.value.ngL = new android.arch.a.c.a<Context, k.a>() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j.AnonymousClass4.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.arch.a.c.a
                    public final /* synthetic */ k.a apply(Context context) {
                        AppMethodBeat.i(147189);
                        k.a Y = j.Y(dVar2);
                        Y.setTitle("");
                        Y.setMessage(context.getString(R.string.hr));
                        AppMethodBeat.o(147189);
                        return Y;
                    }
                };
                iVar.value.a(new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j.AnonymousClass4.AnonymousClass2 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(147190);
                        hdH.ej(new Exception("cancel"));
                        AppMethodBeat.o(147190);
                    }
                });
                iVar.value.ab(dVar2);
                if (!j.this.a(dVar, launchParcel, new c.b() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j.AnonymousClass4.AnonymousClass3 */

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.b
                    public final void proceed() {
                        AppMethodBeat.i(147191);
                        hdH.G(Boolean.TRUE);
                        AppMethodBeat.o(147191);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.b
                    public final void cancel() {
                        AppMethodBeat.i(147192);
                        hdH.ej(new Exception("cancel"));
                        AppMethodBeat.o(147192);
                    }
                })) {
                    hdH.G(Boolean.TRUE);
                }
                Boolean bool = Boolean.FALSE;
                AppMethodBeat.o(147193);
                return bool;
            }
        }).f(new a<AppBrandInitConfigLU, Boolean>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ AppBrandInitConfigLU call(Boolean bool) {
                AppMethodBeat.i(147188);
                g.a(j.this.a(dVar, launchParcel, jSONObject));
                AppMethodBeat.o(147188);
                return null;
            }
        }).f(new a<Void, AppBrandInitConfigLU>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(AppBrandInitConfigLU appBrandInitConfigLU) {
                AppMethodBeat.i(147187);
                AppBrandInitConfigLU appBrandInitConfigLU2 = appBrandInitConfigLU;
                if (iVar.value != null) {
                    iVar.value.dismiss();
                }
                if (appBrandInitConfigLU2 == null) {
                    g.hdx().ej(new Exception("get attrs failed"));
                } else if (TextUtils.isEmpty(appBrandInitConfigLU2.appId)) {
                    g.hdx().ej(new Exception("get invalid appId"));
                } else if (!dVar.isRunning()) {
                    g.hdx().ej(new Exception("fail:interrupted"));
                } else {
                    com.tencent.luggage.sdk.d.d dVar = (com.tencent.luggage.sdk.d.d) dVar.getRuntime();
                    if (dVar == null) {
                        g.hdx().ej(new Exception("fail:internal error"));
                    } else {
                        AppBrandStatObject appBrandStatObject = launchParcel.mYK;
                        if (!(appBrandInitConfigLU2 == null || appBrandStatObject == null)) {
                            ak akVar = dVar.kAl;
                            if (akVar == null) {
                                Log.e("Luggage.WXA.AppBrandRuntimeLU", "load with self.appId[%s] config[%s] stat[%d], skip by NULL container", dVar.mAppId, appBrandInitConfigLU2.appId, Integer.valueOf(appBrandStatObject.scene));
                            } else if (akVar instanceof com.tencent.luggage.sdk.d.b) {
                                ((com.tencent.luggage.sdk.d.b) akVar).a(dVar, appBrandInitConfigLU2, appBrandStatObject);
                            } else if (akVar instanceof com.tencent.luggage.sdk.d.c) {
                                ((com.tencent.luggage.sdk.d.c) akVar).a(dVar, appBrandInitConfigLU2, appBrandStatObject);
                            } else {
                                akVar.a((AppBrandRuntime) dVar, (AppBrandInitConfig) appBrandInitConfigLU2);
                            }
                        }
                        if (cVar != null) {
                            cVar.o(true, "ok");
                        }
                    }
                }
                AppMethodBeat.o(147187);
                return null;
            }
        }).a(new d.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j.AnonymousClass1 */

            @Override // com.tencent.mm.vending.g.d.a
            public final void cn(Object obj) {
                String obj2;
                AppMethodBeat.i(147186);
                if (cVar != null) {
                    if (obj instanceof Exception) {
                        obj2 = ((Exception) obj).getMessage();
                    } else {
                        obj2 = obj == null ? "internal error" : obj.toString();
                    }
                    cVar.o(false, obj2);
                }
                dVar2.i(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(147185);
                        if (iVar.value != null) {
                            iVar.value.dismiss();
                        }
                        AppMethodBeat.o(147185);
                    }
                }, 0);
                AppMethodBeat.o(147186);
            }
        });
        AppMethodBeat.o(147196);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.content.Context] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.tencent.mm.plugin.appbrand.widget.dialog.k.a Y(com.tencent.mm.plugin.appbrand.AppBrandRuntime r3) {
        /*
            r2 = 147194(0x23efa, float:2.06263E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            android.content.Context r0 = r3.mContext
            android.app.Activity r0 = com.tencent.mm.sdk.system.AndroidContextUtil.castActivityOrNull(r0)
            if (r0 != 0) goto L_0x0021
            android.content.Context r0 = r3.mContext
            r1 = r0
        L_0x0011:
            if (r1 != 0) goto L_0x0018
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0017:
            return r0
        L_0x0018:
            com.tencent.mm.plugin.appbrand.widget.dialog.g r0 = new com.tencent.mm.plugin.appbrand.widget.dialog.g
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0017
        L_0x0021:
            r1 = r0
            goto L_0x0011
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j.Y(com.tencent.mm.plugin.appbrand.AppBrandRuntime):com.tencent.mm.plugin.appbrand.widget.dialog.k$a");
    }
}
