package com.tencent.mm.plugin.appbrand.jsapi.channels;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J%\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsBase;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", NativeProtocol.WEB_DIALOG_ACTION, "", "getAction", "()Ljava/lang/String;", "requireUsername", "", "getRequireUsername", "()Z", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "isParamValid", "extInfoJsonObj", "preProcessExtInfo", "plugin-appbrand-integration_release"})
public abstract class c extends d<f> {
    private final boolean lRy = true;

    public abstract String getAction();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
    static final class a<R extends AppBrandProxyUIProcessTask.ProcessResult> implements AppBrandProxyUIProcessTask.b<EnterFinderResult> {
        final /* synthetic */ c lRz;
        final /* synthetic */ f lyn;
        final /* synthetic */ int lyo;

        a(c cVar, f fVar, int i2) {
            this.lRz = cVar;
            this.lyn = fVar;
            this.lyo = i2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult] */
        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b
        public final /* synthetic */ void a(EnterFinderResult enterFinderResult) {
            AppMethodBeat.i(228387);
            EnterFinderResult enterFinderResult2 = enterFinderResult;
            if (enterFinderResult2 == null) {
                Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "onReceiveResult#IProcessResultReceiver, result is null");
                AppMethodBeat.o(228387);
                return;
            }
            int i2 = enterFinderResult2.errCode;
            Log.i("MicroMsg.AppBrand.JsApiOpenChannelsBase", "onReceiveResult#IProcessResultReceiver, errCode: ".concat(String.valueOf(i2)));
            this.lyn.i(this.lyo, i2 == 0 ? this.lRz.Zf("ok") : this.lRz.Zf("fail:internal error"));
            AppMethodBeat.o(228387);
        }
    }

    public boolean T(JSONObject jSONObject) {
        p.h(jSONObject, "extInfoJsonObj");
        return true;
    }

    public boolean U(JSONObject jSONObject) {
        p.h(jSONObject, "extInfoJsonObj");
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        if (fVar == null) {
            Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, env is null");
        } else if (fVar.getContext() == null) {
            Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, context is null");
            fVar.i(i2, Zf("fail:internal error invalid android context"));
        } else if (jSONObject == null) {
            Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, data is null");
            fVar.i(i2, Zf("fail:invalid data"));
        } else {
            if (this.lRy) {
                String optString = jSONObject.optString("finderUserName");
                if (optString == null || optString.length() == 0) {
                    Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, finderUserName not found");
                    fVar.i(i2, Zf("fail:invalid data"));
                    return;
                }
            }
            if (!T(jSONObject)) {
                Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, isParamValid return false");
                fVar.i(i2, Zf("fail:invalid data"));
                return;
            }
            try {
                jSONObject.put(NativeProtocol.WEB_DIALOG_ACTION, getAction());
                jSONObject.put("sourceId", fVar.getAppId());
                if (!U(jSONObject)) {
                    Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, preProcessExtInfo fail");
                    fVar.i(i2, Zf("fail:internal error"));
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(IssueStorage.COLUMN_EXT_INFO, jSONObject);
                    String jSONObject3 = jSONObject2.toString();
                    p.g(jSONObject3, "extInfoWrapperJsonObj.toString()");
                    com.tencent.mm.plugin.appbrand.ipc.a.a(fVar.getContext(), new EnterFinderRequest(jSONObject3), new a(this, fVar, i2));
                } catch (Exception e2) {
                    Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, put extInfo fail since ".concat(String.valueOf(e2)));
                    fVar.i(i2, Zf("fail:internal error"));
                }
            } catch (Exception e3) {
                Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, put fail since ".concat(String.valueOf(e3)));
                fVar.i(i2, Zf("fail:internal error"));
            }
        }
    }
}
