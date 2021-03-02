package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.launching.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class f extends d<com.tencent.luggage.sdk.b.a.c.d> {
    public static final int CTRL_INDEX = 166;
    public static final String NAME = "launchMiniProgram";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.luggage.sdk.b.a.c.d dVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46621);
        final com.tencent.luggage.sdk.b.a.c.d dVar2 = dVar;
        String optString = jSONObject.optString("appId", null);
        if (Util.isNullOrNil(optString)) {
            dVar2.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(46621);
        } else if (optString.equals(dVar2.getAppId())) {
            dVar2.i(i2, h("fail target appId is the same as the caller appId", null));
            AppMethodBeat.o(46621);
        } else {
            String optString2 = jSONObject.optString("path", null);
            String optString3 = jSONObject.optString("extraData", null);
            int optInt = jSONObject.optInt("scene", -1);
            String optString4 = jSONObject.optString("sceneNote", null);
            int i3 = b.a(jSONObject.optString("envVersion"), b.RELEASE).iOo;
            LaunchParcel launchParcel = new LaunchParcel();
            launchParcel.appId = optString;
            launchParcel.iOo = i3;
            launchParcel.kHw = optString2;
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            if (optInt != -1) {
                appBrandStatObject.scene = optInt;
            } else {
                appBrandStatObject.scene = 1037;
            }
            if (!TextUtils.isEmpty(optString4)) {
                appBrandStatObject.dCw = optString4;
            } else {
                appBrandStatObject.dCw = dVar2.getAppId() + ":" + dVar2.NP().ON().cym;
            }
            if (jSONObject.has("preScene")) {
                appBrandStatObject.ecU = jSONObject.optInt("preScene", 0);
                appBrandStatObject.ecV = jSONObject.optString("preSceneNote");
            }
            String str = "";
            c Oq = dVar2.Oq();
            if (Oq != null) {
                str = Oq.nna;
            }
            AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
            appBrandLaunchReferrer.appId = dVar2.getAppId();
            appBrandLaunchReferrer.dSJ = optString3;
            appBrandLaunchReferrer.leo = 1;
            appBrandLaunchReferrer.url = str;
            launchParcel.mYK = appBrandStatObject;
            launchParcel.cys = appBrandLaunchReferrer;
            launchParcel.mYO = new a<Bundle>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Parcelable] */
                @Override // com.tencent.luggage.sdk.launching.a
                public final /* synthetic */ void b(Bundle bundle) {
                    AppMethodBeat.i(226908);
                    Bundle bundle2 = bundle;
                    if (bundle2 == null) {
                        dVar2.i(i2, f.this.h("fail:internal error", null));
                        AppMethodBeat.o(226908);
                        return;
                    }
                    bundle2.setClassLoader(f.class.getClassLoader());
                    if (bundle2.get("KEY_PRECONDITION_RESULT") != null) {
                        dVar2.i(i2, f.this.h("ok", null));
                        AppMethodBeat.o(226908);
                        return;
                    }
                    dVar2.i(i2, f.this.h("fail " + Util.nullAsNil(bundle2.getString("KEY_PRECONDITION_ERR_REASON")), null));
                    AppMethodBeat.o(226908);
                }
            };
            if (a(dVar2, jSONObject, i2)) {
                h.a(dVar2.getAppId(), h.d.LAUNCH_MINI_PROGRAM);
                com.tencent.mm.plugin.appbrand.launching.e.f.mZp.a(dVar2.getContext(), launchParcel);
            }
            AppMethodBeat.o(46621);
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(com.tencent.luggage.sdk.b.a.c.d dVar, JSONObject jSONObject, int i2) {
        return true;
    }
}
