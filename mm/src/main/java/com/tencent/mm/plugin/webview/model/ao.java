package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class ao {
    private static ao IZk = new ao();
    HashMap<String, WebViewJSSDKFileItem> IZl = new HashMap<>();

    static {
        AppMethodBeat.i(79009);
        AppMethodBeat.o(79009);
    }

    public static final ao gcQ() {
        return IZk;
    }

    public ao() {
        AppMethodBeat.i(79005);
        AppMethodBeat.o(79005);
    }

    public final void a(WebViewJSSDKFileItem webViewJSSDKFileItem) {
        AppMethodBeat.i(79006);
        if (webViewJSSDKFileItem == null || Util.isNullOrNil(webViewJSSDKFileItem.dJX)) {
            Log.e("MicroMsg.WebViewJSSDKFileItemManager", "item is null or local id is null, ignore this add");
            AppMethodBeat.o(79006);
            return;
        }
        Log.i("MicroMsg.WebViewJSSDKFileItemManager", "add jssdk file item, local id : %s, file path : %s", webViewJSSDKFileItem.dJX, webViewJSSDKFileItem.laR);
        this.IZl.put(webViewJSSDKFileItem.dJX, webViewJSSDKFileItem);
        AppMethodBeat.o(79006);
    }

    public final void aYN(String str) {
        AppMethodBeat.i(211001);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.WebViewJSSDKFileItemManager", "removeJSSDKFileItem, local id is null");
            AppMethodBeat.o(211001);
            return;
        }
        Log.i("MicroMsg.WebViewJSSDKFileItemManager", "removeJSSDKFileItem, localId:%s", str);
        this.IZl.remove(str);
        AppMethodBeat.o(211001);
    }

    public final WebViewJSSDKFileItem aYO(String str) {
        AppMethodBeat.i(79007);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.WebViewJSSDKFileItemManager", "get by local id error, local id is null or nil");
            AppMethodBeat.o(79007);
            return null;
        }
        WebViewJSSDKFileItem webViewJSSDKFileItem = this.IZl.get(str);
        AppMethodBeat.o(79007);
        return webViewJSSDKFileItem;
    }

    public final WebViewJSSDKFileItem aYP(String str) {
        AppMethodBeat.i(79008);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByServerId error, media id is null or nil");
            AppMethodBeat.o(79008);
            return null;
        }
        for (WebViewJSSDKFileItem webViewJSSDKFileItem : this.IZl.values()) {
            if (Util.nullAsNil(webViewJSSDKFileItem.laS).equals(str)) {
                AppMethodBeat.o(79008);
                return webViewJSSDKFileItem;
            }
        }
        AppMethodBeat.o(79008);
        return null;
    }
}
