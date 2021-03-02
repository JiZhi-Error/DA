package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.b.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.appbrand.utils.t;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;
import org.apache.commons.a.e;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\r\u000eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J%\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "Reporter", "luggage-wechat-full-sdk_release"})
public final class w extends d<ac> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "loadJsFiles";
    public static final a lUW = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JO\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Reporter;", "", "batchReportEvaluateDetails", "", "reportKey", "", "scripts", "", "Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;", "results", "", "extras", "evalStartMs", "", "evalEndMs", "(Ljava/lang/String;[Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;[Z[Ljava/lang/Object;JJ)V", "luggage-wechat-full-sdk_release"})
    public interface b {
        void a(String str, d.a[] aVarArr, boolean[] zArr, Object[] objArr, long j2, long j3);
    }

    static {
        AppMethodBeat.i(147945);
        AppMethodBeat.o(147945);
    }

    public static final void a(AppBrandRuntime appBrandRuntime, JSONArray jSONArray, i iVar, q qVar, String str, b bVar) {
        AppMethodBeat.i(230091);
        a.a(appBrandRuntime, jSONArray, iVar, qVar, str, bVar);
        AppMethodBeat.o(230091);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(ac acVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(147944);
        ac acVar2 = acVar;
        if (acVar2 == null) {
            AppMethodBeat.o(147944);
        } else if (jSONObject == null) {
            AppMethodBeat.o(147944);
        } else {
            JSONArray optJSONArray = jSONObject.optJSONArray("paths");
            String optString = jSONObject.optString("key");
            AppBrandRuntime runtime = acVar2.getRuntime();
            p.g(runtime, "env.runtime");
            a.a(runtime, optJSONArray, acVar2.getJsRuntime(), acVar2.bqY(), optString, new c(this, acVar2, optJSONArray, i2));
            AppMethodBeat.o(147944);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", w.NAME, "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "paths", "Lorg/json/JSONArray;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "scriptProvider", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "reportKey", "reporter", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Reporter;", "toJavascriptInfo", "Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        private static d.a b(q.a aVar) {
            AppMethodBeat.i(230088);
            d.a aVar2 = new d.a();
            aVar2.a(aVar);
            aVar2.czA = aVar.kKK;
            AppMethodBeat.o(230088);
            return aVar2;
        }

        public static void a(AppBrandRuntime appBrandRuntime, JSONArray jSONArray, i iVar, q qVar, String str, b bVar) {
            c cVar;
            String str2;
            AppMethodBeat.i(230089);
            p.h(appBrandRuntime, "runtime");
            if (jSONArray == null || jSONArray.length() <= 0) {
                if (bVar != null) {
                    bVar.a(str, new d.a[0], new boolean[0], new Object[0], Util.nowMilliSecond(), Util.nowMilliSecond());
                    AppMethodBeat.o(230089);
                    return;
                }
                AppMethodBeat.o(230089);
            } else if (iVar == null) {
                AppMethodBeat.o(230089);
            } else if (qVar == null) {
                AppMethodBeat.o(230089);
            } else {
                String appId = appBrandRuntime.getAppId();
                long nowMilliSecond = Util.nowMilliSecond();
                d.a[] aVarArr = new d.a[jSONArray.length()];
                int length = jSONArray.length();
                boolean[] zArr = new boolean[length];
                for (int i2 = 0; i2 < length; i2++) {
                    zArr[i2] = false;
                }
                Object[] objArr = new Object[jSONArray.length()];
                int length2 = jSONArray.length();
                for (int i3 = 0; i3 < length2; i3++) {
                    String optString = jSONArray.optString(i3, null);
                    if (optString != null) {
                        if (i3 == jSONArray.length() - 1) {
                            cVar = new c(bVar, str, aVarArr, zArr, objArr, nowMilliSecond);
                        } else {
                            cVar = null;
                        }
                        q.a UV = qVar.UV(optString);
                        if (UV == null) {
                            Log.e("Luggage.WXA.JsApiLoadJsFiles", "loadJsFiles appId[" + appId + "] path[" + optString + "] EMPTY");
                            if (cVar != null) {
                                cVar.onReceiveValue("404");
                            }
                            aVarArr[i3] = null;
                            zArr[i3] = false;
                            objArr[i3] = null;
                        } else {
                            d.a b2 = b(UV);
                            b2.scriptName = optString;
                            aVarArr[i3] = b2;
                            if (((v) iVar.R(v.class)) == null) {
                                InputStream UU = qVar.UU(optString);
                                if (UU == null) {
                                    p.hyc();
                                }
                                String a2 = e.a(UU, kotlin.n.d.UTF_8);
                                if (a2 == null) {
                                    str2 = "";
                                } else {
                                    str2 = a2;
                                }
                                b2.czz = str2;
                                b2.czA = str2.length();
                                s.a(iVar, str2, new C0664a(zArr, i3, cVar));
                            } else {
                                t.a(appBrandRuntime, iVar, optString, UV, new b(cVar, zArr, i3, b2, objArr));
                            }
                        }
                    }
                }
                AppMethodBeat.o(230089);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Companion$loadJsFiles$1", "Lcom/tencent/mm/plugin/appbrand/utils/JsValidationInjector$JsValidationInjectionCallback;", "onFailure", "", "ret", "", "onSuccess", "luggage-wechat-full-sdk_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.w$a$a  reason: collision with other inner class name */
        public static final class C0664a implements s.a {
            final /* synthetic */ int hAM;
            final /* synthetic */ boolean[] lUX;
            final /* synthetic */ ValueCallback lUY;

            C0664a(boolean[] zArr, int i2, ValueCallback valueCallback) {
                this.lUX = zArr;
                this.hAM = i2;
                this.lUY = valueCallback;
            }

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void onSuccess(String str) {
                AppMethodBeat.i(230082);
                this.lUX[this.hAM] = true;
                ValueCallback valueCallback = this.lUY;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(str);
                    AppMethodBeat.o(230082);
                    return;
                }
                AppMethodBeat.o(230082);
            }

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void du(String str) {
                AppMethodBeat.i(230083);
                this.lUX[this.hAM] = false;
                ValueCallback valueCallback = this.lUY;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(str);
                    AppMethodBeat.o(230083);
                    return;
                }
                AppMethodBeat.o(230083);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Companion$loadJsFiles$2", "Lcom/tencent/mm/plugin/appbrand/utils/JsValidationInjector$JsValidationInjectionCallbackV8Ex;", "condition", "", "ret", "", "countdownAndCallback", "", "onFailure", "onResult", "details", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine$ExecuteDetails;", "onSuccess", "luggage-wechat-full-sdk_release"})
        public static final class b implements s.b {
            private int condition = 2;
            private String dNk;
            final /* synthetic */ int hAM;
            final /* synthetic */ boolean[] lUX;
            final /* synthetic */ ValueCallback lUY;
            final /* synthetic */ d.a lUZ;
            final /* synthetic */ Object[] lVa;

            b(ValueCallback valueCallback, boolean[] zArr, int i2, d.a aVar, Object[] objArr) {
                this.lUY = valueCallback;
                this.lUX = zArr;
                this.hAM = i2;
                this.lUZ = aVar;
                this.lVa = objArr;
            }

            private final void bGn() {
                ValueCallback valueCallback;
                AppMethodBeat.i(230084);
                this.condition--;
                if (this.condition != 0 || (valueCallback = this.lUY) == null) {
                    AppMethodBeat.o(230084);
                    return;
                }
                valueCallback.onReceiveValue(this.dNk);
                AppMethodBeat.o(230084);
            }

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void onSuccess(String str) {
                AppMethodBeat.i(230085);
                this.lUX[this.hAM] = true;
                this.dNk = str;
                bGn();
                AppMethodBeat.o(230085);
            }

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void du(String str) {
                AppMethodBeat.i(230086);
                this.lUX[this.hAM] = false;
                this.dNk = str;
                bGn();
                AppMethodBeat.o(230086);
            }

            @Override // com.tencent.mm.plugin.appbrand.utils.s.b
            public final void a(m.c cVar) {
                AppMethodBeat.i(230087);
                if (cVar != null && cVar.sourceLength > 0) {
                    this.lUZ.czA = cVar.sourceLength;
                }
                this.lVa[this.hAM] = cVar;
                bGn();
                AppMethodBeat.o(230087);
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onReceiveValue"})
        public static final class c<T> implements ValueCallback<String> {
            final /* synthetic */ boolean[] lUX;
            final /* synthetic */ Object[] lVa;
            final /* synthetic */ b lVb;
            final /* synthetic */ String lVc;
            final /* synthetic */ d.a[] lVd;
            final /* synthetic */ long lVe;

            c(b bVar, String str, d.a[] aVarArr, boolean[] zArr, Object[] objArr, long j2) {
                this.lVb = bVar;
                this.lVc = str;
                this.lVd = aVarArr;
                this.lUX = zArr;
                this.lVa = objArr;
                this.lVe = j2;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str) {
                AppMethodBeat.i(147938);
                long nowMilliSecond = Util.nowMilliSecond();
                b bVar = this.lVb;
                if (bVar != null) {
                    bVar.a(this.lVc, this.lVd, this.lUX, this.lVa, this.lVe, nowMilliSecond);
                    AppMethodBeat.o(147938);
                    return;
                }
                AppMethodBeat.o(147938);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JO\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$invoke$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Reporter;", "batchReportEvaluateDetails", "", "reportKey", "", "scripts", "", "Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;", "results", "", "extras", "", "evalStartMs", "", "evalEndMs", "(Ljava/lang/String;[Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;[Z[Ljava/lang/Object;JJ)V", "luggage-wechat-full-sdk_release"})
    public static final class c implements b {
        final /* synthetic */ ac lIn;
        final /* synthetic */ w lVf;
        final /* synthetic */ JSONArray lVg;
        final /* synthetic */ int lyo;

        c(w wVar, ac acVar, JSONArray jSONArray, int i2) {
            this.lVf = wVar;
            this.lIn = acVar;
            this.lVg = jSONArray;
            this.lyo = i2;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.file.w.b
        public final void a(String str, d.a[] aVarArr, boolean[] zArr, Object[] objArr, long j2, long j3) {
            AppMethodBeat.i(230090);
            p.h(aVarArr, "scripts");
            p.h(zArr, "results");
            p.h(objArr, "extras");
            StringBuilder append = new StringBuilder("invoke with appId:").append(this.lIn.getAppId()).append(" paths:").append(this.lVg).append(" key:").append(str).append(", results:");
            String arrays = Arrays.toString(zArr);
            p.g(arrays, "java.util.Arrays.toString(this)");
            Log.i("Luggage.WXA.JsApiLoadJsFiles", append.append(arrays).toString());
            this.lIn.i(this.lyo, this.lVf.Zf("ok"));
            b bVar = (b) this.lIn.S(b.class);
            if (bVar != null) {
                bVar.a(str, aVarArr, zArr, objArr, j2, j3);
                AppMethodBeat.o(230090);
                return;
            }
            AppMethodBeat.o(230090);
        }
    }
}
