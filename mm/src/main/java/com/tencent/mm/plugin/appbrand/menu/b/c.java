package com.tencent.mm.plugin.appbrand.menu.b;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class c implements b<com.tencent.luggage.sdk.b.a.c> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ boolean a(Context context, com.tencent.luggage.sdk.b.a.c cVar, String str) {
        AppMethodBeat.i(147339);
        if (m.c(cVar.NP()) || m.Xf(str)) {
            AppMethodBeat.o(147339);
            return true;
        }
        AppMethodBeat.o(147339);
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ String b(Context context, com.tencent.luggage.sdk.b.a.c cVar, String str) {
        String string;
        AppMethodBeat.i(147338);
        if (((AppBrandSysConfigLU) cVar.av(AppBrandSysConfigLU.class)).cyC) {
            string = context.getString(R.string.ki);
        } else {
            string = context.getString(R.string.kl);
        }
        String charSequence = string.toString();
        AppMethodBeat.o(147338);
        return charSequence;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ void c(Context context, com.tencent.luggage.sdk.b.a.c cVar, String str) {
        boolean z;
        AppMethodBeat.i(147337);
        com.tencent.luggage.sdk.b.a.c cVar2 = cVar;
        if (!cVar2.NP().OM().cyC) {
            z = true;
        } else {
            z = false;
        }
        a(cVar2, str, z);
        AppMethodBeat.o(147337);
    }

    public static void a(final d dVar, String str, boolean z) {
        final String string;
        AppMethodBeat.i(147336);
        m.an(str, z);
        if (z) {
            string = dVar.getContext().getResources().getString(R.string.jw);
        } else {
            string = dVar.getContext().getResources().getString(R.string.jv);
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.menu.b.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(147335);
                Toast.makeText(dVar.getContext(), string, 0).show();
                dVar.getRuntime().finish();
                AppMethodBeat.o(147335);
            }
        });
        AppMethodBeat.o(147336);
    }
}
