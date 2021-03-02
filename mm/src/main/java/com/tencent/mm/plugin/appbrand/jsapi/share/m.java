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
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/share/JsApiShareVideoMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class m extends d<f> {
    private static final int CTRL_INDEX = 957;
    private static final String NAME = "shareVideoMessage";
    public static final a msa = new a((byte) 0);

    static {
        AppMethodBeat.i(228526);
        AppMethodBeat.o(228526);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareToConversationResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
    static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult> implements AppBrandProxyUIProcessTask.b<ShareToConversationResult> {
        final /* synthetic */ f lyn;
        final /* synthetic */ int lyo;
        final /* synthetic */ m msb;

        b(m mVar, f fVar, int i2) {
            this.msb = mVar;
            this.lyn = fVar;
            this.lyo = i2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult] */
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b
        public final /* synthetic */ void a(ShareToConversationResult shareToConversationResult) {
            AppMethodBeat.i(228524);
            ShareToConversationResult shareToConversationResult2 = shareToConversationResult;
            if (shareToConversationResult2 == null) {
                Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, result is null");
                AppMethodBeat.o(228524);
                return;
            }
            ab.a aVar = ab.msY;
            ab xo = ab.a.xo(shareToConversationResult2.result);
            if (xo == null) {
                Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, shareResult is null");
                xo = ab.FAIL;
            }
            Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, shareResult: ".concat(String.valueOf(xo)));
            if (xo == null) {
                AppMethodBeat.o(228524);
                return;
            }
            switch (n.$EnumSwitchMapping$0[xo.ordinal()]) {
                case 1:
                    this.lyn.i(this.lyo, this.msb.Zf("ok"));
                    AppMethodBeat.o(228524);
                    return;
                case 2:
                    this.lyn.i(this.lyo, this.msb.Zf("cancel"));
                    AppMethodBeat.o(228524);
                    return;
                case 3:
                    this.lyn.i(this.lyo, this.msb.Zf("fail"));
                    break;
            }
            AppMethodBeat.o(228524);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/share/JsApiShareVideoMessage$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_KEY_THUMB_PATH", "PARAM_KEY_VIDEO_PATH", "plugin-appbrand-integration_release"})
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
        AppMethodBeat.i(228525);
        if (fVar == null) {
            Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, env is null");
            AppMethodBeat.o(228525);
            return;
        }
        Context context = fVar.getContext();
        if (!(context instanceof Activity)) {
            context = null;
        }
        Activity activity = (Activity) context;
        if (activity == null) {
            Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, activity is null");
            fVar.i(i2, Zf("fail:activity is null"));
            AppMethodBeat.o(228525);
        } else if (jSONObject == null) {
            Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, data is null");
            fVar.i(i2, Zf("fail:data is null"));
            AppMethodBeat.o(228525);
        } else {
            String optString = jSONObject.optString("videoPath");
            String str3 = optString;
            if (str3 == null || str3.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, videoPath is empty");
                fVar.i(i2, Zf("fail:videoPath is empty"));
                AppMethodBeat.o(228525);
                return;
            }
            Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, videoPath: ".concat(String.valueOf(optString)));
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
                Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, videoPath is illegal");
                fVar.i(i2, Zf("fail:videoPath is illegal"));
                AppMethodBeat.o(228525);
                return;
            }
            Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, realVideoPath: ".concat(String.valueOf(str)));
            String optString2 = jSONObject.optString("thumbPath");
            q fileSystem2 = fVar.getFileSystem();
            if (!(fileSystem2 == null || (VY = fileSystem2.VY(optString2)) == null)) {
                str2 = VY.getAbsolutePath();
            }
            Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, thumbPath: " + optString2 + ", realThumbPath: " + str2);
            com.tencent.mm.plugin.appbrand.ipc.a.a(activity, new ShareVideoToConversationRequest(str, str2), new b(this, fVar, i2));
            AppMethodBeat.o(228525);
        }
    }
}
