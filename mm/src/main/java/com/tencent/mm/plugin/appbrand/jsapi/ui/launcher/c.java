package com.tencent.mm.plugin.appbrand.jsapi.ui.launcher;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppStarList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class c extends d<com.tencent.mm.plugin.appbrand.d> {
    public static final int CTRL_INDEX = 649;
    public static final String NAME = "openWeAppStarList";
    @Deprecated
    public static final a mvn = new a((byte) 0);

    static {
        AppMethodBeat.i(50721);
        AppMethodBeat.o(50721);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppStarList$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(50720);
        com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        if (dVar2 == null) {
            AppMethodBeat.o(50720);
        } else if (jSONObject == null) {
            AppMethodBeat.o(50720);
        } else {
            int optInt = jSONObject.optInt("scene", 0);
            String optString = jSONObject.optString("sceneNote");
            int optInt2 = jSONObject.optInt("getUsageReason", 0);
            try {
                AppBrandLauncherFolderUI.a aVar = AppBrandLauncherFolderUI.nTH;
                Context context = dVar2.getContext();
                p.g(context, "env.context");
                Intent intent = new Intent();
                intent.putExtra("extra_get_usage_reason", optInt2);
                intent.putExtra("extra_enter_scene", optInt);
                intent.putExtra("extra_enter_scene_note", optString);
                AppBrandLauncherFolderUI.a.n(context, intent);
                dVar2.i(i2, Zf("ok"));
                AppMethodBeat.o(50720);
            } catch (Exception e2) {
                dVar2.i(i2, Zf("fail:internal error " + e2.getMessage()));
                AppMethodBeat.o(50720);
            }
        }
    }
}
