package com.tencent.mm.plugin.sport;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.model.e;
import com.tencent.mm.plugin.sport.model.k;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;

public final class b implements com.tencent.mm.plugin.sport.a.b {
    @Override // com.tencent.mm.plugin.sport.a.b
    public final void fmf() {
        AppMethodBeat.i(149260);
        if (((PluginSport) g.ah(PluginSport.class)).getDeviceStepManager() != null) {
            ((PluginSport) g.ah(PluginSport.class)).getDeviceStepManager().fmj();
        }
        AppMethodBeat.o(149260);
    }

    @Override // com.tencent.mm.plugin.sport.a.b
    public final void b(String str, String str2, int i2, int i3, int i4, String str3) {
        AppMethodBeat.i(149261);
        if (g.aAc()) {
            g.azz().a(new e(str, str2, i2, i3, i4, str3, 1), 0);
        }
        AppMethodBeat.o(149261);
    }

    @Override // com.tencent.mm.plugin.sport.a.b
    public final boolean hg(Context context) {
        AppMethodBeat.i(149262);
        boolean hg = k.hg(context);
        AppMethodBeat.o(149262);
        return hg;
    }

    @Override // com.tencent.mm.plugin.sport.a.b
    public final boolean fmg() {
        AppMethodBeat.i(149263);
        boolean fmg = k.fmg();
        AppMethodBeat.o(149263);
        return fmg;
    }

    @Override // com.tencent.mm.plugin.sport.a.b
    public final void l(final Activity activity, final String str) {
        AppMethodBeat.i(149265);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.sport.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(149259);
                k.l(activity, str);
                AppMethodBeat.o(149259);
            }
        });
        AppMethodBeat.o(149265);
    }

    @Override // com.tencent.mm.plugin.sport.a.b
    public final void fmi() {
        AppMethodBeat.i(149266);
        k.dYf();
        AppMethodBeat.o(149266);
    }

    @Override // com.tencent.mm.plugin.sport.a.b
    public final void fmh() {
        AppMethodBeat.i(149264);
        if (MMApplicationContext.isMainProcess()) {
            ((PluginSport) g.ah(PluginSport.class)).getSportFileStorage().reset();
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.plugin.sport.model.a.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(149273);
                    try {
                        MMApplicationContext.getContext().getContentResolver().query(Uri.parse("content://" + WeChatAuthorities.AUTHORITIES_PLUGIN_SPORT()), null, "clearConfig", null, null);
                        AppMethodBeat.o(149273);
                    } catch (Exception e2) {
                        AppMethodBeat.o(149273);
                    }
                }
            }, "Sport.clearConfigToPush");
        }
        AppMethodBeat.o(149264);
    }
}
