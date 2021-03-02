package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.share.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/share/JsApiShareFileMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class i extends d<f> {
    private static final int CTRL_INDEX = 956;
    private static final String NAME = "shareFileMessage";
    public static final a mrK = new a((byte) 0);

    static {
        AppMethodBeat.i(228522);
        AppMethodBeat.o(228522);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareToConversationResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
    static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult> implements AppBrandProxyUIProcessTask.b<ShareToConversationResult> {
        final /* synthetic */ f lyn;
        final /* synthetic */ int lyo;
        final /* synthetic */ i mrL;

        b(i iVar, f fVar, int i2) {
            this.mrL = iVar;
            this.lyn = fVar;
            this.lyo = i2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult] */
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b
        public final /* synthetic */ void a(ShareToConversationResult shareToConversationResult) {
            AppMethodBeat.i(228520);
            ShareToConversationResult shareToConversationResult2 = shareToConversationResult;
            if (shareToConversationResult2 == null) {
                Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, result is null");
                AppMethodBeat.o(228520);
                return;
            }
            ab.a aVar = ab.msY;
            ab xo = ab.a.xo(shareToConversationResult2.result);
            if (xo == null) {
                Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, shareResult is null");
                xo = ab.FAIL;
            }
            Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, shareResult: ".concat(String.valueOf(xo)));
            if (xo == null) {
                AppMethodBeat.o(228520);
                return;
            }
            switch (j.$EnumSwitchMapping$0[xo.ordinal()]) {
                case 1:
                    this.lyn.i(this.lyo, this.mrL.Zf("ok"));
                    AppMethodBeat.o(228520);
                    return;
                case 2:
                    this.lyn.i(this.lyo, this.mrL.Zf("cancel"));
                    AppMethodBeat.o(228520);
                    return;
                case 3:
                    this.lyn.i(this.lyo, this.mrL.Zf("fail"));
                    break;
            }
            AppMethodBeat.o(228520);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/share/JsApiShareFileMessage$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_KEY_FILE_NAME", "PARAM_KEY_FILE_PATH", "plugin-appbrand-integration_release"})
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
        AppMethodBeat.i(228521);
        if (fVar == null) {
            Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, env is null");
            AppMethodBeat.o(228521);
            return;
        }
        Context context = fVar.getContext();
        if (!(context instanceof Activity)) {
            context = null;
        }
        Activity activity = (Activity) context;
        if (activity == null) {
            Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, activity is null");
            fVar.i(i2, Zf("fail:activity is null"));
            AppMethodBeat.o(228521);
        } else if (jSONObject == null) {
            Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, data is null");
            fVar.i(i2, Zf("fail:data is null"));
            AppMethodBeat.o(228521);
        } else {
            String optString = jSONObject.optString("filePath");
            String str3 = optString;
            if (str3 == null || str3.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, filePath is empty");
                fVar.i(i2, Zf("fail:filePath is empty"));
                AppMethodBeat.o(228521);
                return;
            }
            if (n.J(optString, "wxfile://", false)) {
                str = org.apache.commons.a.d.getExtension(optString);
            } else {
                str = "";
            }
            Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, filePath: " + optString + ", fileExt: " + str);
            q fileSystem = fVar.getFileSystem();
            if (fileSystem == null || (VY = fileSystem.VY(optString)) == null) {
                str2 = null;
            } else if (!n.J(optString, "wxfile://", false)) {
                q fileSystem2 = fVar.getFileSystem();
                if (fileSystem2 != null) {
                    p.g(VY, "realFile");
                    o Wa = fileSystem2.Wa(VY.getName());
                    if (Wa != null) {
                        if (VY.am(Wa)) {
                            p.g(Wa, "newFile");
                            str2 = Wa.getAbsolutePath();
                        } else {
                            str2 = null;
                        }
                    }
                }
                str2 = null;
            } else {
                p.g(VY, "realFile");
                str2 = VY.getAbsolutePath();
            }
            String str4 = str2;
            if (str4 == null || str4.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, filePath is illegal");
                fVar.i(i2, Zf("fail:filePath is illegal"));
                AppMethodBeat.o(228521);
                return;
            }
            Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, realFilePath: ".concat(String.valueOf(str2)));
            String optString2 = jSONObject.optString(DownloadInfo.FILENAME);
            Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, fileName: ".concat(String.valueOf(optString2)));
            com.tencent.mm.plugin.appbrand.ipc.a.a(activity, new ShareFileToConversationRequest(str2, str, optString2), new b(this, fVar, i2));
            AppMethodBeat.o(228521);
        }
    }
}
