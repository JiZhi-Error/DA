package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebStorage;
import com.tencent.xweb.internal.l;
import org.xwalk.core.Log;

public final class aa {
    static aa SAe = null;
    public IWebStorage SAd = null;

    public static synchronized aa hsY() {
        aa aaVar;
        synchronized (aa.class) {
            AppMethodBeat.i(156797);
            if (SAe == null) {
                SAe = new aa();
            }
            aaVar = SAe;
            AppMethodBeat.o(156797);
        }
        return aaVar;
    }

    private aa() {
        AppMethodBeat.i(156798);
        IWebStorage createWebviewStorage = l.g(WebView.getCurWebType()).createWebviewStorage();
        if (createWebviewStorage == null) {
            Log.e("WebStorage", "create WebStorage failed webStg is null, cur core kind is " + WebView.getCurWebType());
            AppMethodBeat.o(156798);
            return;
        }
        this.SAd = createWebviewStorage;
        AppMethodBeat.o(156798);
    }
}
