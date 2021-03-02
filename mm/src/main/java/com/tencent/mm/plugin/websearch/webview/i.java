package com.tencent.mm.plugin.websearch.webview;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/websearch/webview/WebSearchJSApiNotifier;", "", "()V", "TAG", "", "notifyJsEvent", "", "webView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "funcName", NativeProtocol.WEB_DIALOG_PARAMS, "ui-websearch_release"})
public final class i {
    public static final i IHk = new i();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(198076);
        AppMethodBeat.o(198076);
    }

    private i() {
    }

    public static void a(WebSearchWebView webSearchWebView, String str, String str2) {
        AppMethodBeat.i(198075);
        p.h(webSearchWebView, "webView");
        p.h(str, "funcName");
        p.h(str2, NativeProtocol.WEB_DIALOG_PARAMS);
        try {
            Log.i(TAG, "notifyJsEvent %s %s", str, str2);
            ae aeVar = ae.SYK;
            String format = String.format("javascript:window['%s'] && %s(%s)", Arrays.copyOf(new Object[]{str, str, str2}, 3));
            p.g(format, "java.lang.String.format(format, *args)");
            d.h(new a(webSearchWebView, format));
            AppMethodBeat.o(198075);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "notifyJsEvent", new Object[0]);
            AppMethodBeat.o(198075);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ WebSearchWebView IHl;
        final /* synthetic */ String IHm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(WebSearchWebView webSearchWebView, String str) {
            super(0);
            this.IHl = webSearchWebView;
            this.IHm = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(198074);
            this.IHl.evaluateJavascript(this.IHm, null);
            x xVar = x.SXb;
            AppMethodBeat.o(198074);
            return xVar;
        }
    }
}
