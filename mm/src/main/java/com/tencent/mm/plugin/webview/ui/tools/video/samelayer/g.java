package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import com.tencent.luggage.xweb_ext.extendplugin.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.video.samelayer.l;

public final class g implements c {
    private static g JxT;

    private g() {
    }

    public static g gie() {
        AppMethodBeat.i(212059);
        if (JxT == null) {
            JxT = new g();
        }
        g gVar = JxT;
        AppMethodBeat.o(212059);
        return gVar;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.c
    public final b dW(String str) {
        AppMethodBeat.i(212060);
        char c2 = 65535;
        switch (str.hashCode()) {
            case 112202875:
                if (str.equals("video")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                l lVar = new l();
                j jVar = new j();
                jVar.JxX = lVar;
                lVar.Jyg = jVar;
                lVar.cIY = new i();
                com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c cVar = lVar.cIY;
                if (cVar != null) {
                    cVar.a(new l.r(lVar));
                }
                AppMethodBeat.o(212060);
                return lVar;
            default:
                AppMethodBeat.o(212060);
                return null;
        }
    }
}
