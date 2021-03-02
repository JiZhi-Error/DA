package com.tencent.mm.plugin.webview.ui.tools.floatball;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bJ\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/floatball/WebViewFloatBallInfo;", "", "()V", "canAddJsApiNow", "", "getCanAddJsApiNow", "()Z", "setCanAddJsApiNow", "(Z)V", "jsApiList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/ui/tools/floatball/JSApiInfo;", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "addJsApi", "", "jsApiInfo", "getJsApiList", "plugin-webview_release"})
public final class c {
    public boolean JmM;
    public String title;
    public final LinkedList<a> xwA = new LinkedList<>();

    public c() {
        AppMethodBeat.i(210491);
        AppMethodBeat.o(210491);
    }

    public final synchronized void a(a aVar) {
        T t;
        AppMethodBeat.i(210490);
        p.h(aVar, "jsApiInfo");
        if (!this.JmM) {
            AppMethodBeat.o(210490);
        } else {
            Iterator<T> it = this.xwA.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (t.id == aVar.id) {
                    break;
                }
            }
            if (t != null) {
                this.xwA.remove(t);
            }
            this.xwA.add(aVar);
            AppMethodBeat.o(210490);
        }
    }
}
