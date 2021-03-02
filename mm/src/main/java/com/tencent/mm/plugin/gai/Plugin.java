package com.tencent.mm.plugin.gai;

import com.google.android.gms.common.GoogleApiAvailability;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.gai.a.a;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.thread.ThreadPool;

public class Plugin implements d {
    public Plugin() {
        int i2;
        AppMethodBeat.i(25273);
        boolean z = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_google_aid", g.aps()).getBoolean("already_report_googleaid", false);
        Log.i("MicroMsg.Plugin.gai", "gai Plugin! %b", Boolean.valueOf(z));
        if (!z) {
            try {
                i2 = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MMApplicationContext.getContext());
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Plugin.gai", e2, "", new Object[0]);
                i2 = 9;
            }
            if (i2 == 1 || i2 == 9) {
                Log.w("MicroMsg.Plugin.gai", "gp service invalid, just ignore");
                MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_google_aid", g.aps()).edit().putBoolean("already_report_googleaid", true).commit();
            } else {
                MMApplicationContext.getContext();
                new Object() {
                    /* class com.tencent.mm.plugin.gai.Plugin.AnonymousClass1 */
                };
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.plugin.gai.Plugin.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(25272);
                        AppMethodBeat.o(25272);
                    }
                }, "Advertisement-MAT-thread");
                AppMethodBeat.o(25273);
                return;
            }
        }
        AppMethodBeat.o(25273);
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public n createApplication() {
        AppMethodBeat.i(25274);
        a aVar = new a();
        AppMethodBeat.o(25274);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public c getContactWidgetFactory() {
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public bd createSubCore() {
        AppMethodBeat.i(25275);
        com.tencent.mm.plugin.gai.b.a aVar = new com.tencent.mm.plugin.gai.b.a();
        AppMethodBeat.o(25275);
        return aVar;
    }
}
