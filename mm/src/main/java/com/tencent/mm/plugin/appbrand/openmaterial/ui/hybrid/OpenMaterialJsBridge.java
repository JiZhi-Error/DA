package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.support.annotation.Keep;
import android.webkit.JavascriptInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@Keep
@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001cH\u0007J\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/OpenMaterialJsBridge;", "", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/ui/widget/MMWebView;)V", "launchWeAppDelegate", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/ILaunchWeAppDelegate;", "getLaunchWeAppDelegate", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/ILaunchWeAppDelegate;", "setLaunchWeAppDelegate", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/ILaunchWeAppDelegate;)V", "weAppExposureDelegate", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/IWeAppExposureDelegate;", "getWeAppExposureDelegate", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/IWeAppExposureDelegate;", "setWeAppExposureDelegate", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/IWeAppExposureDelegate;)V", "attachMyOpenMaterials2Template", "", "htmlTemplateContent", "scene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "openMaterialDetailModels", "", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialDetailModel;", "launchWeApp", "", "launchJsonStr", "", "onWeAppExposure", "weAppJsonStr", "onWindowHeightChange", "newHeight", "", "plugin-appbrand-integration_release"})
public final class OpenMaterialJsBridge {
    private c launchWeAppDelegate;
    private d weAppExposureDelegate;
    private final MMWebView webView;

    public OpenMaterialJsBridge(MMWebView mMWebView) {
        p.h(mMWebView, "webView");
        AppMethodBeat.i(229230);
        this.webView = mMWebView;
        AppMethodBeat.o(229230);
    }

    public final c getLaunchWeAppDelegate() {
        return this.launchWeAppDelegate;
    }

    public final void setLaunchWeAppDelegate(c cVar) {
        this.launchWeAppDelegate = cVar;
    }

    public final d getWeAppExposureDelegate() {
        return this.weAppExposureDelegate;
    }

    public final void setWeAppExposureDelegate(d dVar) {
        this.weAppExposureDelegate = dVar;
    }

    public final byte[] attachMyOpenMaterials2Template(byte[] bArr, b bVar, List<? extends AppBrandOpenMaterialDetailModel> list) {
        AppMethodBeat.i(261691);
        p.h(bArr, "htmlTemplateContent");
        p.h(bVar, "scene");
        p.h(list, "openMaterialDetailModels");
        Log.i("MicroMsg.AppBrand.OpenMaterialJsBridge", "attachMyOpenMaterials2Template, scene: " + bVar.FVD);
        JSONArray jSONArray = new JSONArray();
        for (T t : list) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", ((AppBrandOpenMaterialDetailModel) t).appId);
                jSONObject.put("versionType", ((AppBrandOpenMaterialDetailModel) t).iOo);
                jSONObject.put("enterPath", ((AppBrandOpenMaterialDetailModel) t).kHw);
                jSONObject.put("iconUrl", ((AppBrandOpenMaterialDetailModel) t).iconUrl);
                jSONObject.put("functionName", ((AppBrandOpenMaterialDetailModel) t).nlH);
                jSONObject.put("functionDesc", t.nlG);
                JSONArray jSONArray2 = new JSONArray();
                List<String> list2 = t.lgE;
                p.g(list2, "openMaterialDetailModel.categories");
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next());
                }
                jSONObject.put("functionCategories", jSONArray2);
                jSONObject.put(FirebaseAnalytics.b.SCORE, Float.valueOf(t.score));
                jSONArray.put(jSONObject);
            } catch (Exception e2) {
                Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", "attachMyOpenMaterials2Template, " + ((Object) t) + " to json fail since " + e2);
            }
        }
        String jSONArray3 = jSONArray.toString();
        p.g(jSONArray3, "openMaterialDetailsJson.toString()");
        String str = new String(bArr, d.UTF_8);
        String str2 = bVar.FVD;
        p.g(str2, "scene.myName");
        String j2 = n.j(n.j(str, "###scene###", str2, false), "###preloadObjFeedsData###", jSONArray3, false);
        Charset charset = d.UTF_8;
        if (j2 == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(261691);
            throw tVar;
        }
        byte[] bytes = j2.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        AppMethodBeat.o(261691);
        return bytes;
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void launchWeApp(String str) {
        AppMethodBeat.i(229227);
        p.h(str, "launchJsonStr");
        Log.i("MicroMsg.AppBrand.OpenMaterialJsBridge", "launchWeApp, launchJsonStr: ".concat(String.valueOf(str)));
        c cVar = this.launchWeAppDelegate;
        if (cVar == null) {
            Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", "launchWeApp, launchWeAppDelegateSnapshot is null");
            AppMethodBeat.o(229227);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("appId");
            int i2 = jSONObject.getInt("versionType");
            String string2 = jSONObject.getString("enterPath");
            p.g(string, "appId");
            p.g(string2, "enterPath");
            cVar.B(string, i2, string2);
            AppMethodBeat.o(229227);
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", "launchWeApp, fail since ".concat(String.valueOf(e2)));
            AppMethodBeat.o(229227);
        }
    }

    public final void onWindowHeightChange(int i2) {
        AppMethodBeat.i(229228);
        Log.i("MicroMsg.AppBrand.OpenMaterialJsBridge", "onWindowHeightChange, newHeight: ".concat(String.valueOf(i2)));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("height", i2);
            String jSONObject2 = jSONObject.toString();
            p.g(jSONObject2, "json.toString()");
            h.RTc.aV(new a(this, jSONObject2));
            AppMethodBeat.o(229228);
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", "onWindowHeightChange, fail since ".concat(String.valueOf(e2)));
            AppMethodBeat.o(229228);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ OpenMaterialJsBridge nmT;
        final /* synthetic */ String nmU;

        a(OpenMaterialJsBridge openMaterialJsBridge, String str) {
            this.nmT = openMaterialJsBridge;
            this.nmU = str;
        }

        public final void run() {
            AppMethodBeat.i(229225);
            String format = String.format("javascript:OpenMaterialJsApi['%s'] && OpenMaterialJsApi.%s(%s)", Arrays.copyOf(new Object[]{"onWindowHeightChange", "onWindowHeightChange", this.nmU}, 3));
            p.g(format, "java.lang.String.format(this, *args)");
            this.nmT.webView.evaluateJavascript(format, AnonymousClass1.nmV);
            AppMethodBeat.o(229225);
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onWeAppExposure(String str) {
        AppMethodBeat.i(229229);
        p.h(str, "weAppJsonStr");
        Log.i("MicroMsg.AppBrand.OpenMaterialJsBridge", "onWeAppExposure, weAppJsonStr: ".concat(String.valueOf(str)));
        d dVar = this.weAppExposureDelegate;
        if (dVar == null) {
            Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", "onWeAppExposure, weAppExposureDelegateSnapshot is null");
            AppMethodBeat.o(229229);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("appId");
            int i2 = jSONObject.getInt("versionType");
            String string2 = jSONObject.getString("enterPath");
            p.g(string, "appId");
            p.g(string2, "enterPath");
            dVar.C(string, i2, string2);
            AppMethodBeat.o(229229);
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", "onWeAppExposure, fail since ".concat(String.valueOf(e2)));
            AppMethodBeat.o(229229);
        }
    }
}
