package com.tencent.mm.plugin.websearch.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u0006\u0010\u000b\u001a\u00020\fJ,\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0011R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchData;", "T", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;", "(Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;)V", "getUiComponent", "()Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;", "setUiComponent", "destroy", "", "getWebViewId", "", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "querySearchWeb", "paramsStr", "ui-websearch_release"})
public class a<T> implements i {
    public d<T> IHe;

    public a(d<T> dVar) {
        AppMethodBeat.i(198044);
        this.IHe = dVar;
        g.azz().a(2975, this);
        AppMethodBeat.o(198044);
    }

    public void destroy() {
        AppMethodBeat.i(198041);
        g.azz().b(2975, this);
        AppMethodBeat.o(198041);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        if (r0 == null) goto L_0x0045;
     */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int r8, int r9, java.lang.String r10, com.tencent.mm.ak.q r11) {
        /*
        // Method dump skipped, instructions count: 111
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.websearch.webview.a.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    public final int fXz() {
        WebSearchWebView dQg;
        AppMethodBeat.i(198043);
        d<T> dVar = this.IHe;
        if (dVar == null || (dQg = dVar.dQg()) == null) {
            AppMethodBeat.o(198043);
            return -1;
        }
        int hashCode = dQg.hashCode();
        AppMethodBeat.o(198043);
        return hashCode;
    }
}
