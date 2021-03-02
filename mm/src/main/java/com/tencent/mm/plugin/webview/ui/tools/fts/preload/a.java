package com.tencent.mm.plugin.webview.ui.tools.fts.preload;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.facebook.internal.NativeProtocol;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.fts.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchJSApi;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "setPreGetParams", "", NativeProtocol.WEB_DIALOG_PARAMS, "", "Companion", "plugin-webview_release"})
public final class a {
    public static final C1991a Jpy = new C1991a((byte) 0);
    private Context context;

    static {
        AppMethodBeat.i(210525);
        AppMethodBeat.o(210525);
    }

    public a(Context context2) {
        this.context = context2;
    }

    @JavascriptInterface
    public final void setPreGetParams(String str) {
        AppMethodBeat.i(210524);
        h.RTc.b(new b(str), "MicroMsg.WebSearch.WebSearchJSApi");
        AppMethodBeat.o(210524);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ String Jpz;

        b(String str) {
            this.Jpz = str;
        }

        public final void run() {
            AppMethodBeat.i(210523);
            j.setPreGetParams(this.Jpz);
            AppMethodBeat.o(210523);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchJSApi$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.preload.a$a  reason: collision with other inner class name */
    public static final class C1991a {
        private C1991a() {
        }

        public /* synthetic */ C1991a(byte b2) {
            this();
        }
    }
}
