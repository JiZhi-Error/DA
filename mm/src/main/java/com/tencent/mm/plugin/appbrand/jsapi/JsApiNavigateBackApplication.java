package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiNavigateBackApplication extends d<d> {
    private static final int CTRL_INDEX = 288;
    public static final String NAME = "navigateBackApplication";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45559);
        final d dVar2 = dVar;
        AppBrandLaunchReferrer appBrandLaunchReferrer = ((q) dVar2.getRuntime()).bsC().cys;
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("extraData");
        String str = p.Um(dVar2.getRuntime().mAppId).kCY;
        Log.i("MicroMsg.JsApiNavigateBackApplication", "navigate back Application, businessType:%s", str);
        if (!Util.isNullOrNil(str)) {
            p.Un(dVar2.getAppId()).kDc = true;
        }
        if (!Util.isNullOrNil(optString)) {
            AppBrandMainProcessService.a(new NavigateBackAppTask(optString, Util.nullAs(optString2, "{}"), str, 0));
        } else if (Util.isNullOrNil(appBrandLaunchReferrer.appId) || !(appBrandLaunchReferrer.leo == 4 || appBrandLaunchReferrer.leo == 7)) {
            Log.w("MicroMsg.JsApiNavigateBackApplication", "navigateBackApplication appid %s,launchScene %d", appBrandLaunchReferrer.appId, Integer.valueOf(appBrandLaunchReferrer.leo));
            dVar2.i(i2, h("fail:not from opensdk", null));
            AppMethodBeat.o(45559);
            return;
        } else {
            AppBrandMainProcessService.a(new NavigateBackAppTask(appBrandLaunchReferrer.appId, Util.nullAs(optString2, "{}"), str, 0));
        }
        dVar2.i(i2, h("ok", null));
        if (!Util.isNullOrNil(str)) {
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(45552);
                    if (!(dVar2 == null || dVar2.getRuntime() == null)) {
                        dVar2.getRuntime().finish();
                    }
                    AppMethodBeat.o(45552);
                }
            }, 1000);
        }
        AppMethodBeat.o(45559);
    }

    public static final class NavigateBackAppTask extends MainProcessTask {
        public static final Parcelable.Creator<NavigateBackAppTask> CREATOR = new Parcelable.Creator<NavigateBackAppTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication.NavigateBackAppTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ NavigateBackAppTask[] newArray(int i2) {
                return new NavigateBackAppTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ NavigateBackAppTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45553);
                NavigateBackAppTask navigateBackAppTask = new NavigateBackAppTask();
                navigateBackAppTask.f(parcel);
                AppMethodBeat.o(45553);
                return navigateBackAppTask;
            }
        };
        public String appId;
        public String businessType;
        public String data;
        public int errCode;

        public NavigateBackAppTask() {
        }

        public NavigateBackAppTask(String str, String str2, String str3, int i2) {
            this.appId = str;
            this.data = str2;
            this.businessType = str3;
            this.errCode = i2;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45554);
            g o = h.o(this.appId, true, true);
            Log.i("MicroMsg.JsApiNavigateBackApplication", "NavigateBackAppTask appid %s", this.appId);
            if (o == null) {
                Log.w("MicroMsg.JsApiNavigateBackApplication", "NavigateBackAppTask appinfo is null");
                AppMethodBeat.o(45554);
            } else if (!h.i(o)) {
                Log.e("MicroMsg.JsApiNavigateBackApplication", "NavigateBackAppTask packageName invalid");
                AppMethodBeat.o(45554);
            } else {
                Bundle bundle = new Bundle();
                if (Util.isNullOrNil(this.businessType)) {
                    WXLaunchMiniProgram.Resp resp = new WXLaunchMiniProgram.Resp(bundle);
                    resp.extMsg = this.data;
                    resp.openId = o.field_openId;
                    a(bundle, resp, o);
                    AppMethodBeat.o(45554);
                    return;
                }
                WXOpenBusinessView.Resp resp2 = new WXOpenBusinessView.Resp(bundle);
                resp2.extMsg = this.data;
                resp2.openId = o.field_openId;
                resp2.errCode = this.errCode;
                resp2.businessType = this.businessType;
                resp2.transaction = n.Kwp;
                a(bundle, resp2, o);
                AppMethodBeat.o(45554);
            }
        }

        private static void a(Bundle bundle, BaseResp baseResp, g gVar) {
            AppMethodBeat.i(45555);
            baseResp.toBundle(bundle);
            MMessageActV2.Args args = new MMessageActV2.Args();
            args.targetPkgName = gVar.field_packageName;
            args.bundle = bundle;
            com.tencent.mm.pluginsdk.model.app.q.bo(bundle);
            com.tencent.mm.pluginsdk.model.app.q.bp(bundle);
            MMessageActV2.send(MMApplicationContext.getContext(), args);
            AppMethodBeat.o(45555);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45556);
            parcel.writeString(this.appId);
            parcel.writeString(this.data);
            parcel.writeString(this.businessType);
            parcel.writeInt(this.errCode);
            AppMethodBeat.o(45556);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(45557);
            this.appId = parcel.readString();
            this.data = parcel.readString();
            this.businessType = parcel.readString();
            this.errCode = parcel.readInt();
            AppMethodBeat.o(45557);
        }

        static {
            AppMethodBeat.i(45558);
            AppMethodBeat.o(45558);
        }
    }
}
