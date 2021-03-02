package com.tencent.mm.plugin.game.luggage.g;

import android.os.Bundle;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.a;
import com.tencent.mm.plugin.webview.ui.tools.game.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import org.json.JSONObject;

public class j extends i {
    public j(com.tencent.luggage.d.j jVar, p pVar, Bundle bundle) {
        super(jVar, pVar, bundle);
        AppMethodBeat.i(83212);
        Log.i("MicroMsg.PreloadGameWebPage", "create");
        a.e(this.ITd);
        com.tencent.mm.ipcinvoker.p.post(new Runnable() {
            /* class com.tencent.mm.plugin.game.luggage.g.j.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(83210);
                j.this.ctS.a(new d() {
                    /* class com.tencent.mm.plugin.game.luggage.g.j.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.luggage.d.d
                    public final String name() {
                        return "onAttachedToWindow";
                    }

                    @Override // com.tencent.luggage.d.d
                    public final JSONObject Ld() {
                        return null;
                    }
                });
                j.this.cT("javascript:(function() {window.__game_center_preload_page_present__=true;})();");
                AppMethodBeat.o(83210);
            }
        });
        com.tencent.mm.ipcinvoker.p.z(new Runnable() {
            /* class com.tencent.mm.plugin.game.luggage.g.j.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(83211);
                if (j.this.ITd != null) {
                    String title = j.this.ITd.getTitle();
                    if (!Util.isNullOrNil(title)) {
                        j.this.ec(title, 0);
                    }
                }
                AppMethodBeat.o(83211);
            }
        });
        dTV();
        AppMethodBeat.o(83212);
    }

    @Override // com.tencent.luggage.d.s, com.tencent.mm.plugin.webview.luggage.g
    public final String LJ() {
        AppMethodBeat.i(83213);
        String afA = com.tencent.mm.plugin.appbrand.ac.d.afA("preload_game_adapter.js");
        AppMethodBeat.o(83213);
        return afA;
    }

    @Override // com.tencent.mm.plugin.game.luggage.g.i, com.tencent.mm.plugin.webview.luggage.g
    public final void c(String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(83214);
        Log.i("MicroMsg.PreloadGameWebPage", "onUrlRedirect, time: %d", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(83214);
    }

    @Override // com.tencent.mm.plugin.game.luggage.g.i, com.tencent.luggage.d.h, com.tencent.luggage.d.s, com.tencent.mm.plugin.webview.luggage.g
    public final void g(String str, Bundle bundle) {
        AppMethodBeat.i(83215);
        super.g(str, bundle);
        AppMethodBeat.o(83215);
    }

    @Override // com.tencent.mm.plugin.game.luggage.g.i, com.tencent.mm.plugin.webview.luggage.g
    public final void cW(String str) {
        AppMethodBeat.i(83216);
        super.cW(str);
        dTV();
        AppMethodBeat.o(83216);
    }

    @Override // com.tencent.mm.plugin.game.luggage.g.i, com.tencent.mm.plugin.webview.luggage.g
    public final boolean azL(String str) {
        AppMethodBeat.i(83217);
        if (str.equals(coX())) {
            AppMethodBeat.o(83217);
            return false;
        }
        boolean azL = super.azL(str);
        AppMethodBeat.o(83217);
        return azL;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.game.luggage.g.i
    public final g azK(String str) {
        AppMethodBeat.i(83219);
        g baK = g.baK(str);
        AppMethodBeat.o(83219);
        return baK;
    }

    private void dTV() {
        AppMethodBeat.i(83218);
        this.ctS.a(new d() {
            /* class com.tencent.mm.plugin.game.luggage.g.j.AnonymousClass3 */

            @Override // com.tencent.luggage.d.d
            public final String name() {
                return "onJsApiReady";
            }

            @Override // com.tencent.luggage.d.d
            public final JSONObject Ld() {
                return null;
            }
        });
        AppMethodBeat.o(83218);
    }
}
