package com.tencent.mm.plugin.appbrand.shortlink;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkAbility;", "Lcom/tencent/mm/plugin/appbrand/IWxaShortLinkAbility;", "()V", "KEY_LAST_LAST_APPBRAND_SWITCH_SHORT_LINK_HIGHLIGHT", "", "TAG", "isHighlightEnable", "Lkotlin/Function0;", "", "()Lkotlin/jvm/functions/Function0;", "isMenuEntryEnable", "checkShortLinkABTestStatus", "", "plugin-appbrand-integration_release"})
public final class d {
    private static final kotlin.g.a.a<Boolean> nNO = a.nNR;
    private static final kotlin.g.a.a<Boolean> nNP = b.nNS;
    public static final d nNQ = new d();

    static {
        AppMethodBeat.i(229360);
        AppMethodBeat.o(229360);
    }

    private d() {
    }

    public static void bVz() {
        AppMethodBeat.i(229359);
        boolean z = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_switch_short_link_highlight, 0) == 1;
        MultiProcessMMKV VQ = f.kIs.VQ();
        if (VQ == null) {
            p.hyc();
        }
        if (VQ.getBoolean("last_appbrand_switch_short_link_highlight", false) != z) {
            com.tencent.mm.pluginsdk.ui.span.l.clearCache();
            MultiProcessMMKV VQ2 = f.kIs.VQ();
            if (VQ2 == null) {
                p.hyc();
            }
            VQ2.putBoolean("last_appbrand_switch_short_link_highlight", z);
            Log.i("WxaShortLinkCapacity", "short link highlight change to " + (z ? "enable" : "disable") + '!');
        }
        AppMethodBeat.o(229359);
    }

    public static kotlin.g.a.a<Boolean> bVA() {
        return nNO;
    }

    public static kotlin.g.a.a<Boolean> bVB() {
        return nNP;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Boolean> {
        public static final a nNR = new a();

        static {
            AppMethodBeat.i(229356);
            AppMethodBeat.o(229356);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(229355);
            MultiProcessMMKV VQ = f.kIs.VQ();
            if (VQ == null) {
                p.hyc();
            }
            boolean z = VQ.getBoolean("last_appbrand_switch_short_link_highlight", false);
            Log.d("WxaShortLinkCapacity", "isHighlightEnable[" + z + ']');
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(229355);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Boolean> {
        public static final b nNS = new b();

        static {
            AppMethodBeat.i(229358);
            AppMethodBeat.o(229358);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(229357);
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_switch_short_link_menu_entry, 0) == 1) {
                MultiProcessMMKV VQ = f.kIs.VQ();
                if (VQ == null) {
                    p.hyc();
                }
                if (VQ.getBoolean("last_appbrand_switch_short_link_highlight", false)) {
                    z = true;
                    Log.d("WxaShortLinkCapacity", "isMenuEntryEnable[" + z + ']');
                    Boolean valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(229357);
                    return valueOf;
                }
            }
            z = false;
            Log.d("WxaShortLinkCapacity", "isMenuEntryEnable[" + z + ']');
            Boolean valueOf2 = Boolean.valueOf(z);
            AppMethodBeat.o(229357);
            return valueOf2;
        }
    }
}
