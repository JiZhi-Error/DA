package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import kotlin.l;
import kotlin.n.n;
import org.apache.commons.a.d;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddFileToFavorites;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class an extends d<f> {
    private static final int CTRL_INDEX = 958;
    private static final String NAME = "addFileToFavorites";
    public static final a lyl = new a((byte) 0);

    static {
        AppMethodBeat.i(228263);
        AppMethodBeat.o(228263);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/AddToFavoritesResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
    static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult> implements AppBrandProxyUIProcessTask.b<AddToFavoritesResult> {
        final /* synthetic */ an lym;
        final /* synthetic */ f lyn;
        final /* synthetic */ int lyo;

        b(an anVar, f fVar, int i2) {
            this.lym = anVar;
            this.lyn = fVar;
            this.lyo = i2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult] */
        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b
        public final /* synthetic */ void a(AddToFavoritesResult addToFavoritesResult) {
            AppMethodBeat.i(228261);
            AddToFavoritesResult addToFavoritesResult2 = addToFavoritesResult;
            if (addToFavoritesResult2 == null) {
                Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "onReceiveResult#IProcessResultReceiver, result is null");
                AppMethodBeat.o(228261);
                return;
            }
            Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", "onReceiveResult#IProcessResultReceiver, success: " + addToFavoritesResult2.success);
            this.lyn.i(this.lyo, this.lym.Zf(addToFavoritesResult2.success ? "ok" : "fail"));
            AppMethodBeat.o(228261);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddFileToFavorites$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_KEY_FILE_NAME", "PARAM_KEY_FILE_PATH", "plugin-appbrand-integration_release"})
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
        String str2;
        boolean z2;
        o VY;
        AppMethodBeat.i(228262);
        if (fVar == null) {
            Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, env is null");
            AppMethodBeat.o(228262);
            return;
        }
        Context context = fVar.getContext();
        if (!(context instanceof Activity)) {
            context = null;
        }
        if (((Activity) context) == null) {
            Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, activity is null");
            fVar.i(i2, Zf("fail:activity is null"));
            AppMethodBeat.o(228262);
        } else if (jSONObject == null) {
            Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, data is null");
            fVar.i(i2, Zf("fail:data is null"));
            AppMethodBeat.o(228262);
        } else {
            String optString = jSONObject.optString("filePath");
            String str3 = optString;
            if (str3 == null || str3.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, filePath is empty");
                fVar.i(i2, Zf("fail:filePath is empty"));
                AppMethodBeat.o(228262);
                return;
            }
            if (n.J(optString, "wxfile://", false)) {
                str = d.getExtension(optString);
            } else {
                str = "";
            }
            Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, filePath: " + optString + ", fileExt: " + str);
            q fileSystem = fVar.getFileSystem();
            if (fileSystem == null || (VY = fileSystem.VY(optString)) == null) {
                str2 = null;
            } else {
                str2 = VY.getAbsolutePath();
            }
            String str4 = str2;
            if (str4 == null || str4.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, filePath is illegal");
                fVar.i(i2, Zf("fail:filePath is illegal"));
                AppMethodBeat.o(228262);
                return;
            }
            Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, realFilePath: ".concat(String.valueOf(str2)));
            String optString2 = jSONObject.optString(DownloadInfo.FILENAME);
            Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, fileName: ".concat(String.valueOf(optString2)));
            com.tencent.mm.plugin.appbrand.ipc.a.a(fVar.getContext(), new AddFileToFavoritesRequest(str2, str, optString2), new b(this, fVar, i2));
            AppMethodBeat.o(228262);
        }
    }
}
