package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.utils.c;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddImageToFavorites;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class ao extends d<f> {
    private static final int CTRL_INDEX = 924;
    private static final String NAME = "addImageToFavorites";
    public static final a lyp = new a((byte) 0);

    static {
        AppMethodBeat.i(228267);
        AppMethodBeat.o(228267);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddImageToFavorites$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_KEY_IMAGE_PATH", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(228266);
        if (fVar == null) {
            Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, env is null");
            AppMethodBeat.o(228266);
        } else if (jSONObject == null) {
            Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, data is null");
            fVar.i(i2, Zf("fail:data is null"));
            AppMethodBeat.o(228266);
        } else {
            String optString = jSONObject.optString("url");
            String str = optString;
            if (str == null || str.length() == 0) {
                Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, url is empty");
                fVar.i(i2, Zf("fail:url is empty"));
                AppMethodBeat.o(228266);
                return;
            }
            c.a(fVar, optString, null, new b(this, fVar, i2));
            AppMethodBeat.o(228266);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "localPath", "", "kotlin.jvm.PlatformType", "onLoad"})
    static final class b implements c.a {
        final /* synthetic */ f lyn;
        final /* synthetic */ int lyo;
        final /* synthetic */ ao lyq;

        b(ao aoVar, f fVar, int i2) {
            this.lyq = aoVar;
            this.lyn = fVar;
            this.lyo = i2;
        }

        @Override // com.tencent.mm.plugin.appbrand.utils.c.a
        public final void Wz(String str) {
            AppMethodBeat.i(228265);
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, url is illegal");
                this.lyn.i(this.lyo, this.lyq.Zf("fail:url is illegal"));
                AppMethodBeat.o(228265);
            } else if (!ImgUtil.isImgFile(str)) {
                Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, " + str + " is not image");
                s.deleteFile(str);
                this.lyn.i(this.lyo, this.lyq.Zf("fail:url is illegal"));
                AppMethodBeat.o(228265);
            } else {
                com.tencent.mm.plugin.appbrand.ipc.a.a(this.lyn.getContext(), new AddImageToFavoritesRequest(str), new AppBrandProxyUIProcessTask.b<AddToFavoritesResult>(this) {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.ao.b.AnonymousClass1 */
                    final /* synthetic */ b lyr;

                    {
                        this.lyr = r1;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult] */
                    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b
                    public final /* synthetic */ void a(AddToFavoritesResult addToFavoritesResult) {
                        AppMethodBeat.i(228264);
                        AddToFavoritesResult addToFavoritesResult2 = addToFavoritesResult;
                        if (addToFavoritesResult2 == null) {
                            Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "onReceiveResult#IProcessResultReceiver, result is null");
                            AppMethodBeat.o(228264);
                            return;
                        }
                        Log.i("MicroMsg.AppBrand.JsApiAddImageToFavorites", "onReceiveResult#IProcessResultReceiver, success: " + addToFavoritesResult2.success);
                        this.lyr.lyn.i(this.lyr.lyo, this.lyr.lyq.Zf(addToFavoritesResult2.success ? "ok" : "fail"));
                        AppMethodBeat.o(228264);
                    }
                });
                AppMethodBeat.o(228265);
            }
        }
    }
}
