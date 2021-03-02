package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.b.g;
import com.tencent.mm.plugin.appbrand.page.b.h;
import com.tencent.mm.plugin.appbrand.page.b.i;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.s;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\f\u0010\f\u001a\u00020\r*\u0004\u0018\u00010\u000e¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackInterception;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/NavigateBackInterceptionConstant;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "isEmpty", "", "Lorg/json/JSONArray;", "Companion", "luggage-wxa-app-jsapi_release"})
public final class y extends d<s> {
    public static final int CTRL_INDEX = 880;
    public static final String NAME = "setNavigateBackInterception";
    public static final a mkN = new a((byte) 0);

    static {
        AppMethodBeat.i(240924);
        AppMethodBeat.o(240924);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        boolean z;
        String str;
        AppMethodBeat.i(240923);
        s sVar2 = sVar;
        if (sVar2 == null || jSONObject == null) {
            AppMethodBeat.o(240923);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(Constants.KEY_SCOPES);
        if (optJSONArray == null || optJSONArray.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            sVar2.i(i2, Zf("fail:scopes is empty"));
            AppMethodBeat.o(240923);
            return;
        }
        ArrayList arrayList = new ArrayList();
        z.a aVar = new z.a();
        aVar.SYB = false;
        Iterator it = j.mY(0, optJSONArray.length()).iterator();
        while (it.hasNext()) {
            Object obj = optJSONArray.get(((ab) it).nextInt());
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type org.json.JSONObject");
                AppMethodBeat.o(240923);
                throw tVar;
            }
            JSONObject jSONObject2 = (JSONObject) obj;
            boolean optBoolean = jSONObject2.optBoolean("interception", false);
            aVar.SYB |= optBoolean;
            try {
                switch (jSONObject2.optInt("type", 0)) {
                    case 1:
                        str = "scene_swipe_back";
                        break;
                    case 2:
                        str = "scene_back_key_pressed";
                        break;
                    case 3:
                        str = "scene_actionbar_back";
                        break;
                    case 4:
                        str = "scene_jsapi_navigate_back";
                        break;
                    default:
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("illegal type!");
                        AppMethodBeat.o(240923);
                        throw illegalArgumentException;
                }
                arrayList.add(new h(optBoolean, str));
            } catch (IllegalArgumentException e2) {
                sVar2.i(i2, Zf("fail:illegal type"));
                AppMethodBeat.o(240923);
                return;
            }
        }
        AppBrandRuntime runtime = sVar2.getRuntime();
        p.g(runtime, "env.runtime");
        w brh = runtime.brh();
        p.g(brh, "env.runtime.pageContainer");
        com.tencent.f.h.RTc.aV(new b(this, brh.getCurrentPage(), sVar2, aVar, arrayList, i2));
        AppMethodBeat.o(240923);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ s lXa;
        final /* synthetic */ int lyo;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.page.t mkL;
        final /* synthetic */ y mkO;
        final /* synthetic */ z.a mkP;
        final /* synthetic */ ArrayList mkQ;

        b(y yVar, com.tencent.mm.plugin.appbrand.page.t tVar, s sVar, z.a aVar, ArrayList arrayList, int i2) {
            this.mkO = yVar;
            this.mkL = tVar;
            this.lXa = sVar;
            this.mkP = aVar;
            this.mkQ = arrayList;
            this.lyo = i2;
        }

        public final void run() {
            g gVar = null;
            AppMethodBeat.i(240922);
            com.tencent.mm.plugin.appbrand.page.t tVar = this.mkL;
            String currentUrl = tVar != null ? tVar.getCurrentUrl() : null;
            AppBrandRuntime runtime = this.lXa.getRuntime();
            p.g(runtime, "env.runtime");
            w brh = runtime.brh();
            p.g(brh, "env.runtime.pageContainer");
            com.tencent.mm.plugin.appbrand.page.t currentPage = brh.getCurrentPage();
            if (!TextUtils.equals(currentUrl, currentPage != null ? currentPage.getCurrentUrl() : null)) {
                AppMethodBeat.o(240922);
                return;
            }
            AppBrandRuntime runtime2 = this.lXa.getRuntime();
            p.g(runtime2, "env.runtime");
            w brh2 = runtime2.brh();
            p.g(brh2, "env.runtime.pageContainer");
            com.tencent.mm.plugin.appbrand.page.t currentPage2 = brh2.getCurrentPage();
            if (currentPage2 != null) {
                i iVar = i.SILENT;
                if (this.mkP.SYB) {
                    gVar = new g(null, this.mkQ, 1);
                }
                currentPage2.a(iVar, gVar);
            }
            this.lXa.i(this.lyo, this.mkO.Zf("ok"));
            AppMethodBeat.o(240922);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackInterception$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "typeToScene", "type", "luggage-wxa-app-jsapi_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
