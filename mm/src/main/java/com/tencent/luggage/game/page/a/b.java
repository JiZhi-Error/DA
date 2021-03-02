package com.tencent.luggage.game.page.a;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.h;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.c.c;

public final class b implements com.tencent.mm.plugin.appbrand.page.a.b, h {
    private final a cxq;
    private final ac cxr;

    public b(ac acVar) {
        AppMethodBeat.i(130682);
        this.cxq = new a(acVar);
        this.cxr = acVar;
        AppMethodBeat.o(130682);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void onForeground() {
        AppMethodBeat.i(130683);
        this.cxq.MV();
        AppMethodBeat.o(130683);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void onBackground() {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void onDestroy() {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b bVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.h
    public final void Nj() {
        AppMethodBeat.i(130684);
        this.cxr.runOnUiThread(new Runnable() {
            /* class com.tencent.luggage.game.page.a.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(130680);
                b.this.cxq.Nj();
                AppMethodBeat.o(130680);
            }
        });
        AppMethodBeat.o(130684);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.h
    public final void Nk() {
        AppMethodBeat.i(130685);
        this.cxr.runOnUiThread(new Runnable() {
            /* class com.tencent.luggage.game.page.a.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(130681);
                b.this.cxq.Nk();
                AppMethodBeat.o(130681);
            }
        });
        AppMethodBeat.o(130685);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.h
    public final boolean Nm() {
        AppMethodBeat.i(130686);
        if (this.cxq.Nl() == c.b.HIDDEN) {
            AppMethodBeat.o(130686);
            return true;
        }
        AppMethodBeat.o(130686);
        return false;
    }
}
