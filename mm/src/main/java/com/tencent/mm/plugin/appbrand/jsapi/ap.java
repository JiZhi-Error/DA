package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddVideoToFavorites;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class ap extends d<f> {
    private static final int CTRL_INDEX = 959;
    private static final String NAME = "addVideoToFavorites";
    public static final a lyI = new a((byte) 0);

    static {
        AppMethodBeat.i(228270);
        AppMethodBeat.o(228270);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/AddToFavoritesResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
    static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult> implements AppBrandProxyUIProcessTask.b<AddToFavoritesResult> {
        final /* synthetic */ ap lyJ;
        final /* synthetic */ f lyn;
        final /* synthetic */ int lyo;

        b(ap apVar, f fVar, int i2) {
            this.lyJ = apVar;
            this.lyn = fVar;
            this.lyo = i2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult] */
        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b
        public final /* synthetic */ void a(AddToFavoritesResult addToFavoritesResult) {
            AppMethodBeat.i(228268);
            AddToFavoritesResult addToFavoritesResult2 = addToFavoritesResult;
            if (addToFavoritesResult2 == null) {
                Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "onReceiveResult#IProcessResultReceiver, result is null");
                AppMethodBeat.o(228268);
                return;
            }
            Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "onReceiveResult#IProcessResultReceiver, success: " + addToFavoritesResult2.success);
            this.lyn.i(this.lyo, this.lyJ.Zf(addToFavoritesResult2.success ? "ok" : "fail"));
            AppMethodBeat.o(228268);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddVideoToFavorites$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_KEY_THUMB_PATH", "PARAM_KEY_VIDEO_PATH", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        boolean z;
        String str;
        boolean z2;
        o VY;
        o VY2;
        String str2 = null;
        AppMethodBeat.i(228269);
        if (fVar == null) {
            Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, env is null");
            AppMethodBeat.o(228269);
            return;
        }
        Context context = fVar.getContext();
        if (!(context instanceof Activity)) {
            context = null;
        }
        if (((Activity) context) == null) {
            Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, activity is null");
            fVar.i(i2, Zf("fail:activity is null"));
            AppMethodBeat.o(228269);
        } else if (jSONObject == null) {
            Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, data is null");
            fVar.i(i2, Zf("fail:data is null"));
            AppMethodBeat.o(228269);
        } else {
            String optString = jSONObject.optString("videoPath");
            String str3 = optString;
            if (str3 == null || str3.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, videoPath is empty");
                fVar.i(i2, Zf("fail:videoPath is empty"));
                AppMethodBeat.o(228269);
                return;
            }
            Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, videoPath: ".concat(String.valueOf(optString)));
            q fileSystem = fVar.getFileSystem();
            if (fileSystem == null || (VY2 = fileSystem.VY(optString)) == null) {
                str = null;
            } else {
                str = VY2.getAbsolutePath();
            }
            String str4 = str;
            if (str4 == null || str4.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, videoPath is illegal");
                fVar.i(i2, Zf("fail:videoPath is illegal"));
                AppMethodBeat.o(228269);
                return;
            }
            Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, realVideoPath: ".concat(String.valueOf(str)));
            String optString2 = jSONObject.optString("thumbPath");
            q fileSystem2 = fVar.getFileSystem();
            if (!(fileSystem2 == null || (VY = fileSystem2.VY(optString2)) == null)) {
                str2 = VY.getAbsolutePath();
            }
            Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, thumbPath: " + optString2 + ", realThumbPath: " + str2);
            com.tencent.mm.plugin.appbrand.ipc.a.a(fVar.getContext(), new AddVideoToFavoritesRequest(str, str2), new b(this, fVar, i2));
            AppMethodBeat.o(228269);
        }
    }
}
