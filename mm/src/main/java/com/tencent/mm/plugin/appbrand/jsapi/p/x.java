package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.b.g;
import com.tencent.mm.plugin.appbrand.page.b.h;
import com.tencent.mm.plugin.appbrand.page.b.i;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackConfirmDialog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app-jsapi_release"})
public final class x extends d<s> {
    public static final int CTRL_INDEX = 772;
    public static final String NAME = "setNavigateBackConfirmDialog";
    public static final a mkJ = new a((byte) 0);

    static {
        AppMethodBeat.i(177324);
        AppMethodBeat.o(177324);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(177323);
        s sVar2 = sVar;
        if (sVar2 == null || jSONObject == null) {
            AppMethodBeat.o(177323);
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("enable", false);
        z.f fVar = new z.f();
        fVar.SYG = (T) jSONObject.optString("content");
        Log.i("JsApiSetNavigateBackConfirmDialog", "[invoke] enable=" + optBoolean + "  content=" + ((String) fVar.SYG));
        if (Util.isNullOrNil((String) fVar.SYG)) {
            Context context = sVar2.getContext();
            p.g(context, "env.context");
            fVar.SYG = (T) context.getResources().getString(R.string.etr);
        }
        AppBrandRuntime runtime = sVar2.getRuntime();
        p.g(runtime, "env.runtime");
        w brh = runtime.brh();
        p.g(brh, "env.runtime.pageContainer");
        MMHandlerThread.postToMainThread(new b(this, brh.getCurrentPage(), sVar2, optBoolean, fVar, i2));
        AppMethodBeat.o(177323);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ boolean hLa;
        final /* synthetic */ s lXa;
        final /* synthetic */ int lyo;
        final /* synthetic */ x mkK;
        final /* synthetic */ t mkL;
        final /* synthetic */ z.f mkM;

        b(x xVar, t tVar, s sVar, boolean z, z.f fVar, int i2) {
            this.mkK = xVar;
            this.mkL = tVar;
            this.lXa = sVar;
            this.hLa = z;
            this.mkM = fVar;
            this.lyo = i2;
        }

        public final void run() {
            ArrayList arrayList;
            i iVar;
            t tVar;
            g gVar = null;
            AppMethodBeat.i(177322);
            t tVar2 = this.mkL;
            String currentUrl = tVar2 != null ? tVar2.getCurrentUrl() : null;
            AppBrandRuntime runtime = this.lXa.getRuntime();
            p.g(runtime, "env.runtime");
            w brh = runtime.brh();
            p.g(brh, "env.runtime.pageContainer");
            t currentPage = brh.getCurrentPage();
            if (!TextUtils.equals(currentUrl, currentPage != null ? currentPage.getCurrentUrl() : null)) {
                AppMethodBeat.o(177322);
                return;
            }
            if (this.hLa) {
                ArrayList arrayList2 = new ArrayList();
                for (String str : j.listOf((Object[]) new String[]{"scene_actionbar_back", "scene_back_key_pressed", "scene_jsapi_navigate_back"})) {
                    arrayList2.add(new h(this.hLa, str));
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            AppBrandRuntime runtime2 = this.lXa.getRuntime();
            p.g(runtime2, "env.runtime");
            w brh2 = runtime2.brh();
            p.g(brh2, "env.runtime.pageContainer");
            t currentPage2 = brh2.getCurrentPage();
            if (currentPage2 != null) {
                i iVar2 = i.WITH_CONFIRM_DIALOG;
                if (arrayList != null) {
                    T t = this.mkM.SYG;
                    p.g(t, "content");
                    gVar = new g(t, arrayList);
                    iVar = iVar2;
                    tVar = currentPage2;
                } else {
                    iVar = iVar2;
                    tVar = currentPage2;
                }
                tVar.a(iVar, gVar);
            }
            this.lXa.i(this.lyo, this.mkK.Zf("ok"));
            AppMethodBeat.o(177322);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackConfirmDialog$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-wxa-app-jsapi_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
