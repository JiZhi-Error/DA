package com.tencent.mm.plugin.appbrand;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.plugin.appbrand.s.d;
import com.tencent.mm.plugin.appbrand.s.k;
import com.tencent.mm.plugin.appbrand.u.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatBrands;

public final class bd {
    private static int kFW = 1;
    private static int kFX = 2;
    private static int kFY = 3;
    private static int kFZ = 4;
    private static k.c kGa = new k.c() {
        /* class com.tencent.mm.plugin.appbrand.bd.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.s.k.c
        public final boolean Uw(String str) {
            AppMethodBeat.i(43986);
            if (c.adj(str)) {
                Log.i("MicroMsg.WcWssSwitchLogic", "isWcWssOpen : true for hardcode case");
                AppMethodBeat.o(43986);
                return true;
            }
            boolean vF = bd.vF(bd.kFW);
            AppMethodBeat.o(43986);
            return vF;
        }

        @Override // com.tencent.mm.plugin.appbrand.s.k.c
        public final boolean btz() {
            AppMethodBeat.i(43987);
            boolean vG = bd.vG(bd.kFW);
            AppMethodBeat.o(43987);
            return vG;
        }
    };
    private static k.c kGb = new k.c() {
        /* class com.tencent.mm.plugin.appbrand.bd.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.appbrand.s.k.c
        public final boolean Uw(String str) {
            AppMethodBeat.i(43988);
            boolean vF = bd.vF(bd.kFW);
            AppMethodBeat.o(43988);
            return vF;
        }

        @Override // com.tencent.mm.plugin.appbrand.s.k.c
        public final boolean btz() {
            AppMethodBeat.i(43989);
            boolean vG = bd.vG(bd.kFW);
            AppMethodBeat.o(43989);
            return vG;
        }
    };
    private static d.b kGc = new d.b() {
        /* class com.tencent.mm.plugin.appbrand.bd.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.appbrand.s.d.b
        public final boolean btA() {
            AppMethodBeat.i(43990);
            boolean vF = bd.vF(bd.kFX);
            AppMethodBeat.o(43990);
            return vF;
        }

        @Override // com.tencent.mm.plugin.appbrand.s.d.b
        public final boolean btz() {
            AppMethodBeat.i(43991);
            boolean vG = bd.vG(bd.kFX);
            AppMethodBeat.o(43991);
            return vG;
        }

        @Override // com.tencent.mm.plugin.appbrand.s.d.b
        public final boolean btB() {
            AppMethodBeat.i(226252);
            boolean vF = bd.vF(bd.kFZ);
            AppMethodBeat.o(226252);
            return vF;
        }
    };
    private static b.AbstractC0793b kGd = new b.AbstractC0793b() {
        /* class com.tencent.mm.plugin.appbrand.bd.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.appbrand.s.b.AbstractC0793b
        public final boolean btA() {
            AppMethodBeat.i(43992);
            boolean vF = bd.vF(bd.kFY);
            AppMethodBeat.o(43992);
            return vF;
        }
    };

    static {
        AppMethodBeat.i(43996);
        AppMethodBeat.o(43996);
    }

    public static k.c btv() {
        return kGa;
    }

    public static k.c btw() {
        return kGb;
    }

    public static d.b btx() {
        return kGc;
    }

    public static b.AbstractC0793b bty() {
        return kGd;
    }

    private static Boolean vE(int i2) {
        AppMethodBeat.i(43993);
        if (i2 == kFW) {
            String string = MMApplicationContext.getToolsProcesstPreference().getString("appbrandgame_open_wcwss", "");
            if (string != null && string.equalsIgnoreCase("wcwss")) {
                Boolean bool = Boolean.TRUE;
                AppMethodBeat.o(43993);
                return bool;
            } else if (string != null && string.equalsIgnoreCase("websocket")) {
                Boolean bool2 = Boolean.FALSE;
                AppMethodBeat.o(43993);
                return bool2;
            }
        } else if (i2 == kFX) {
            String string2 = MMApplicationContext.getToolsProcesstPreference().getString("appbrandgame_open_cdnrequest", "");
            if (string2 != null && string2.equalsIgnoreCase("chromium")) {
                Boolean bool3 = Boolean.TRUE;
                AppMethodBeat.o(43993);
                return bool3;
            } else if (string2 != null && string2.equalsIgnoreCase(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID)) {
                Boolean bool4 = Boolean.FALSE;
                AppMethodBeat.o(43993);
                return bool4;
            }
        } else if (i2 == kFY) {
            String string3 = MMApplicationContext.getToolsProcesstPreference().getString("appbrandgame_open_cronetdownload", "");
            if (string3 != null && string3.equalsIgnoreCase(WeChatBrands.Business.GROUP_OPEN)) {
                Boolean bool5 = Boolean.TRUE;
                AppMethodBeat.o(43993);
                return bool5;
            } else if (string3 != null && string3.equalsIgnoreCase("close")) {
                Boolean bool6 = Boolean.FALSE;
                AppMethodBeat.o(43993);
                return bool6;
            }
        } else if (i2 == kFZ) {
            String string4 = MMApplicationContext.getToolsProcesstPreference().getString("appbrandgame_open_cdnrequest_httpdns", "");
            if (string4 != null && string4.equalsIgnoreCase(WeChatBrands.Business.GROUP_OPEN)) {
                Boolean bool7 = Boolean.TRUE;
                AppMethodBeat.o(43993);
                return bool7;
            } else if (string4 != null && string4.equalsIgnoreCase("close")) {
                Boolean bool8 = Boolean.FALSE;
                AppMethodBeat.o(43993);
                return bool8;
            }
        }
        AppMethodBeat.o(43993);
        return null;
    }

    static /* synthetic */ boolean vF(int i2) {
        boolean a2;
        AppMethodBeat.i(43994);
        Boolean vE = vE(i2);
        if (vE != null) {
            a2 = vE.booleanValue();
            Log.i("MicroMsg.WcWssSwitchLogic", "isABTestOpen commandResult type:%d,flag: %b", Integer.valueOf(i2), Boolean.valueOf(a2));
        } else {
            if (i2 == kFW) {
                a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_socket_default_wcwss, true);
            } else if (i2 == kFX) {
                a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_request_default_cronet, true);
            } else if (i2 == kFY) {
                a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_download_default_cronet, true);
            } else {
                a2 = i2 == kFZ ? ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_cronet_httpdns, true) : false;
            }
            Log.i("MicroMsg.WcWssSwitchLogic", "isABTestOpen type:%d,flag: %b", Integer.valueOf(i2), Boolean.valueOf(a2));
        }
        AppMethodBeat.o(43994);
        return a2;
    }

    static /* synthetic */ boolean vG(int i2) {
        boolean a2;
        AppMethodBeat.i(43995);
        Boolean vE = vE(i2);
        if (vE != null) {
            a2 = vE.booleanValue();
            Log.i("MicroMsg.WcWssSwitchLogic", "isGameABTestOpen commandResult type:%d,flag: %b", Integer.valueOf(i2), Boolean.valueOf(a2));
        } else {
            if (i2 == kFW) {
                a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_socket_default_wcwss, true);
            } else if (i2 == kFX) {
                a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_request_default_cronet, true);
            } else {
                a2 = i2 == kFY ? ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_download_default_cronet, true) : false;
            }
            Log.i("MicroMsg.WcWssSwitchLogic", "isGameABTestOpen type:%d,flag: %b", Integer.valueOf(i2), Boolean.valueOf(a2));
        }
        AppMethodBeat.o(43995);
        return a2;
    }
}
