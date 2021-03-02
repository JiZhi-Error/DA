package com.tencent.luggage.game.page;

import com.tencent.luggage.sdk.b.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.bx;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import java.util.concurrent.Callable;

public class f implements w.a {
    @Override // com.tencent.mm.plugin.appbrand.page.w.a
    public final t a(String str, bx bxVar, w wVar, Callable<t> callable) {
        AppMethodBeat.i(177439);
        e eVar = new e(wVar.getContext(), wVar);
        AppMethodBeat.o(177439);
        return eVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.w.a
    public ac a(w wVar) {
        AppMethodBeat.i(177440);
        c cVar = new c(h.class);
        AppMethodBeat.o(177440);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.w.a
    public final boolean a(String str, bx bxVar, w wVar, w.d dVar) {
        AppMethodBeat.i(130639);
        switch (bxVar) {
            case APP_LAUNCH:
                dVar.proceed();
                break;
            case AUTO_RE_LAUNCH:
                wVar.a((t) null, wVar.getCurrentPage(), bx.AUTO_RE_LAUNCH, str, false);
                wVar.getCurrentPage().loadUrl(str);
                wVar.a((t) null, wVar.getCurrentPage(), bx.AUTO_RE_LAUNCH);
                break;
        }
        AppMethodBeat.o(130639);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.w.a
    public final boolean MX() {
        return true;
    }
}
