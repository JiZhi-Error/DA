package com.tencent.mm.plugin.appbrand.menu.b;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;

public final class b implements com.tencent.mm.plugin.appbrand.menu.a.b<c> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ boolean a(Context context, c cVar, String str) {
        AppMethodBeat.i(147334);
        if (AppBrandPerformanceManager.e(cVar.NP())) {
            AppMethodBeat.o(147334);
            return true;
        }
        AppMethodBeat.o(147334);
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ void c(final Context context, c cVar, String str) {
        AppMethodBeat.i(147332);
        final c cVar2 = cVar;
        Toast.makeText(context, (int) R.string.of, 0).show();
        m.bZn().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.menu.b.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(147331);
                final boolean h2 = AppBrandPerformanceManager.h(cVar2.NP());
                m.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.menu.b.b.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(147330);
                        Toast.makeText(context, h2 ? R.string.og : R.string.oe, 0).show();
                        AppMethodBeat.o(147330);
                    }
                });
                AppMethodBeat.o(147331);
            }
        });
        AppMethodBeat.o(147332);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ String b(Context context, c cVar, String str) {
        AppMethodBeat.i(147333);
        String string = context.getString(R.string.od);
        AppMethodBeat.o(147333);
        return string;
    }
}
