package com.tencent.mm.plugin.webview.luggage.c;

import android.os.Bundle;
import android.os.Looper;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class b {

    public static class c implements k<Bundle, Bundle> {
        private c() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ Bundle invoke(Bundle bundle) {
            AppMethodBeat.i(78765);
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("has_set_uin", g.aAc());
            AppMethodBeat.o(78765);
            return bundle2;
        }
    }

    public static class a implements k<Bundle, Bundle> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ Bundle invoke(Bundle bundle) {
            AppMethodBeat.i(78763);
            String string = bundle.getString(ch.COL_USERNAME);
            Bundle bundle2 = new Bundle();
            boolean z = false;
            if (g.aAc()) {
                z = ab.IT(string);
            }
            bundle2.putBoolean("is_biz_contact", z);
            AppMethodBeat.o(78763);
            return bundle2;
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(78766);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            MMHandlerThread.postToMainThread(runnable);
            AppMethodBeat.o(78766);
            return;
        }
        runnable.run();
        AppMethodBeat.o(78766);
    }

    public static JSONObject Zc(String str) {
        AppMethodBeat.i(78767);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(78767);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            AppMethodBeat.o(78767);
            return jSONObject;
        } catch (Exception e2) {
            Log.e("MicroMsg.LuggageWebViewUtil", e2.getMessage());
            AppMethodBeat.o(78767);
            return null;
        }
    }

    public static WebViewJSSDKFileItem aYC(String str) {
        AppMethodBeat.i(78768);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.LuggageWebViewUtil", "get by local id error, local id is null or nil");
            AppMethodBeat.o(78768);
            return null;
        } else if (MMApplicationContext.isMMProcess()) {
            WebViewJSSDKFileItem aYO = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO(str);
            AppMethodBeat.o(78768);
            return aYO;
        } else {
            WebViewJSSDKFileItem webViewJSSDKFileItem = (WebViewJSSDKFileItem) h.a(MainProcessIPCService.dkO, new IPCString(str), C1965b.class);
            AppMethodBeat.o(78768);
            return webViewJSSDKFileItem;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.c.b$b  reason: collision with other inner class name */
    static class C1965b implements k<IPCString, WebViewJSSDKFileItem> {
        private C1965b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ WebViewJSSDKFileItem invoke(IPCString iPCString) {
            AppMethodBeat.i(78764);
            WebViewJSSDKFileItem aYO = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO(iPCString.value);
            AppMethodBeat.o(78764);
            return aYO;
        }
    }

    public static boolean afC(String str) {
        AppMethodBeat.i(78769);
        if (Util.isNullOrNil(str) || (!URLUtil.isHttpsUrl(str) && !URLUtil.isHttpUrl(str))) {
            AppMethodBeat.o(78769);
            return false;
        }
        AppMethodBeat.o(78769);
        return true;
    }
}
