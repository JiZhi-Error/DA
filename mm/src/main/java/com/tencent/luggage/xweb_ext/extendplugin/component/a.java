package com.tencent.luggage.xweb_ext.extendplugin.component;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.x;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.appbrand.jsapi.z;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.platform.window.a.j;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;

public abstract class a {
    final com.tencent.luggage.xweb_ext.extendplugin.a.a cDK;
    final z cDL;
    protected boolean cDM = false;
    protected boolean cDN = false;
    private boolean cDO = false;
    j cDP = null;
    i.c cDQ = null;
    ac cwK;

    /* access modifiers changed from: protected */
    public abstract boolean Pv();

    public abstract void a(String str, com.tencent.luggage.xweb_ext.extendplugin.a aVar);

    public a(com.tencent.luggage.xweb_ext.extendplugin.a.a aVar, z zVar) {
        this.cDK = aVar;
        this.cDL = zVar;
    }

    /* access modifiers changed from: protected */
    public final void a(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        final ac acVar;
        if (this.cwK == null) {
            f NN = aVar.NN();
            if (!(NN instanceof ac)) {
                Log.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "setPageView, component(" + NN + ") is not AppBrandPageView");
                if (!(NN instanceof s)) {
                    Log.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "setPageView, component(" + NN + ") is not AppBrandService");
                    return;
                }
                acVar = ((s) NN).getCurrentPageView();
            } else {
                acVar = (ac) NN;
            }
            if (!this.cDO) {
                if (this.cDP == null) {
                    this.cDP = new j() {
                        /* class com.tencent.luggage.xweb_ext.extendplugin.component.a.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.appbrand.platform.window.a.j
                        public final void a(ad.a aVar) {
                            Object obj;
                            AppMethodBeat.i(178799);
                            Log.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, orientation: ".concat(String.valueOf(aVar)));
                            if (!a.this.Pv()) {
                                Log.i("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, not in foreground");
                                AppMethodBeat.o(178799);
                            } else if (!a.this.cDM || !a.this.cDN) {
                                Log.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, mIsNeedNotify: " + a.this.cDM + ", mIsAutoRotationEnabled: " + a.this.cDN);
                                AppMethodBeat.o(178799);
                            } else if (a.this.cwK == null) {
                                Log.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, null == mPageView");
                                AppMethodBeat.o(178799);
                            } else {
                                c windowAndroid = acVar.getRuntime().getWindowAndroid();
                                if (windowAndroid == null || !windowAndroid.OD()) {
                                    x PW = a.this.cDL.PW();
                                    ac acVar = a.this.cwK;
                                    int id = a.this.cDK.getId();
                                    p.h(acVar, "pageView");
                                    p.h(aVar, "orientation");
                                    Log.d("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, pageView: " + acVar + ", viewId: " + id + ", orientation: " + aVar);
                                    switch (y.$EnumSwitchMapping$0[aVar.ordinal()]) {
                                        case 1:
                                            obj = "landscapeLeft";
                                            break;
                                        case 2:
                                            obj = "landscape";
                                            break;
                                        case 3:
                                            obj = "portrait";
                                            break;
                                        default:
                                            obj = null;
                                            break;
                                    }
                                    if (obj == null) {
                                        Log.d("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, null == orientationStr");
                                        AppMethodBeat.o(178799);
                                        return;
                                    }
                                    HashMap hashMap = new HashMap(2);
                                    hashMap.put("viewId", Integer.valueOf(id));
                                    hashMap.put("orientation", obj);
                                    String obj2 = h.v(hashMap).toString();
                                    Log.i("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, name: " + PW.getName() + ", data: " + obj2);
                                    PW.Zg(obj2).b(acVar, acVar.getComponentId()).bEo();
                                    s NY = acVar.NY();
                                    if (NY != null) {
                                        PW.Zg(obj2).b(NY, acVar.getComponentId()).bEo();
                                        AppMethodBeat.o(178799);
                                        return;
                                    }
                                    AppMethodBeat.o(178799);
                                    return;
                                }
                                Log.i("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged: disable autoRotationEnabled for pad compat mode");
                                AppMethodBeat.o(178799);
                            }
                        }
                    };
                    this.cDQ = new i.c() {
                        /* class com.tencent.luggage.xweb_ext.extendplugin.component.a.AnonymousClass2 */

                        @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
                        public final void onDestroy() {
                            AppMethodBeat.i(178800);
                            Log.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onDestroy");
                            Activity activity = acVar.getActivity();
                            if (activity == null) {
                                Log.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onDestroy, null == activity");
                                AppMethodBeat.o(178800);
                                return;
                            }
                            com.tencent.mm.plugin.appbrand.platform.window.a.i F = com.tencent.mm.plugin.appbrand.platform.window.a.i.F(activity);
                            j jVar = a.this.cDP;
                            p.h(jVar, "orientationObserver");
                            Log.d(F.lMQ, "removeOrientationObserver");
                            F.nFk.remove(jVar);
                            acVar.b(a.this.cDQ);
                            AppMethodBeat.o(178800);
                        }
                    };
                }
                Activity activity = acVar.getActivity();
                if (activity == null) {
                    Log.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "listenOrientationChanged, null == activity");
                } else {
                    com.tencent.mm.plugin.appbrand.platform.window.a.i F = com.tencent.mm.plugin.appbrand.platform.window.a.i.F(activity);
                    j jVar = this.cDP;
                    p.h(jVar, "orientationObserver");
                    Log.d(F.lMQ, "addOrientationObserver");
                    F.nFk.add(jVar);
                    acVar.a(this.cDQ);
                    this.cDO = true;
                }
            }
            this.cwK = acVar;
        }
    }
}
