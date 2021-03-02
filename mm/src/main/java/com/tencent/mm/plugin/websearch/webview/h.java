package com.tencent.mm.plugin.websearch.webview;

import android.webkit.JavascriptInterface;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004H\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0017J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0017J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageJSApi;", "T", "Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchJSApi;", "imageUIComponent", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;", "(Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;)V", "TAG", "", "getImageUIComponent", "getSearchAvatarList", NativeProtocol.WEB_DIALOG_PARAMS, "getSearchImageList", "onSearchImageListReady", "", "ret", "", "data", "ui-websearch_release"})
public class h<T> extends b<T> {
    private final String TAG = "MicroMsg.WebSearch.WebSearchImageJSApi";

    public h(c<T> cVar) {
        p.h(cVar, "imageUIComponent");
        AppMethodBeat.i(198073);
        this.IHe = cVar;
        AppMethodBeat.o(198073);
    }

    @JavascriptInterface
    public String getSearchImageList(String str) {
        g<T> dQh;
        AppMethodBeat.i(198070);
        Log.i(this.TAG, "getSearchImageList ".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("requestType", 0);
            String optString = jSONObject.optString("data", "");
            c<T> fYS = fYS();
            if (!(fYS == null || (dQh = fYS.dQh()) == null)) {
                p.g(optString, "data");
                dQh.cP(optInt, optString);
            }
            String valueOf = String.valueOf(fYQ());
            AppMethodBeat.o(198070);
            return valueOf;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(fYR());
            AppMethodBeat.o(198070);
            return valueOf2;
        }
    }

    @JavascriptInterface
    public String getSearchAvatarList(String str) {
        g<T> dQh;
        AppMethodBeat.i(198071);
        try {
            String optString = new JSONObject(str).optString("data", "");
            c<T> fYS = fYS();
            if (!(fYS == null || (dQh = fYS.dQh()) == null)) {
                p.g(optString, "data");
                dQh.aXr(optString);
            }
            String valueOf = String.valueOf(fYQ());
            AppMethodBeat.o(198071);
            return valueOf;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(fYR());
            AppMethodBeat.o(198071);
            return valueOf2;
        }
    }

    public final void cQ(int i2, String str) {
        WebSearchWebView dQg;
        AppMethodBeat.i(198072);
        p.h(str, "data");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", i2);
            jSONObject.put("data", str);
        } catch (Exception e2) {
        }
        d<T> dVar = this.IHe;
        if (dVar == null || (dQg = dVar.dQg()) == null) {
            AppMethodBeat.o(198072);
            return;
        }
        i iVar = i.IHk;
        String jSONObject2 = jSONObject.toString();
        p.g(jSONObject2, "requestObj.toString()");
        i.a(dQg, "onSearchImageListReady", jSONObject2);
        AppMethodBeat.o(198072);
    }

    private final c<T> fYS() {
        d<T> dVar = this.IHe;
        if (!(dVar instanceof c)) {
            dVar = null;
        }
        return (c) dVar;
    }
}
