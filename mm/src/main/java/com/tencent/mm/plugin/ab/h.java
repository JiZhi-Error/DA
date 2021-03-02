package com.tencent.mm.plugin.ab;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.e;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J!\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH\u0007¢\u0006\u0002\u0010\u000bJ!\u0010\f\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH\u0007¢\u0006\u0002\u0010\u000bJ!\u0010\r\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH\u0007¢\u0006\u0002\u0010\u000bJ!\u0010\u000e\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH\u0007¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/webjsapi/WxConsole;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "tagName", "", "(Ljava/lang/String;)V", "error", "", "objects", "", "", "([Ljava/lang/Object;)V", "info", "log", "warn", "webview-sdk_release"})
public final class h extends a<b> {
    private final String FeZ;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(String str) {
        super("console", new b() {
            /* class com.tencent.mm.plugin.ab.h.AnonymousClass1 */
        });
        p.h(str, "tagName");
        AppMethodBeat.i(224807);
        this.FeZ = str;
        AppMethodBeat.o(224807);
    }

    @JavascriptInterface
    public final void log(Object... objArr) {
        AppMethodBeat.i(224803);
        p.h(objArr, "objects");
        if (Log.getLogLevel() <= 0) {
            Log.v(this.TAG, "JsLog[" + this.FeZ + "]:" + e.a(objArr, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 62));
        }
        AppMethodBeat.o(224803);
    }

    @JavascriptInterface
    public final void info(Object... objArr) {
        AppMethodBeat.i(224804);
        p.h(objArr, "objects");
        Log.i(this.TAG, "JsInfo[" + this.FeZ + "]:" + e.a(objArr, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 62));
        AppMethodBeat.o(224804);
    }

    @JavascriptInterface
    public final void warn(Object... objArr) {
        AppMethodBeat.i(224805);
        p.h(objArr, "objects");
        Log.w(this.TAG, "JsInfo[" + this.FeZ + "]:" + e.a(objArr, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 62));
        AppMethodBeat.o(224805);
    }

    @JavascriptInterface
    public final void error(Object... objArr) {
        AppMethodBeat.i(224806);
        p.h(objArr, "objects");
        Log.e(this.TAG, "JsError[" + this.FeZ + "]:" + e.a(objArr, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 62));
        AppMethodBeat.o(224806);
    }
}
