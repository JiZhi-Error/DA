package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.webview.core.g;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.ao;
import kotlin.f;
import kotlin.g;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewActionBarHelper;", "", "webViewUI", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)V", "urlParams", "Lcom/tencent/mm/plugin/webview/ui/tools/UrlParams;", "getUrlParams", "()Lcom/tencent/mm/plugin/webview/ui/tools/UrlParams;", "setUrlParams", "(Lcom/tencent/mm/plugin/webview/ui/tools/UrlParams;)V", "initImmersivePageBgIsDark", "", "immersivePageBgIsDark", "", "initImmersiveStyle", "initParams", "initParamsFromUrl", "isBgDarkMode", "", "isImmersiveStyle", "Companion", "plugin-webview_release"})
public final class q {
    private static final f VgL = g.ah(b.VgO);
    private static final f VgM = g.ah(d.VgQ);
    public static final a VgN = new a((byte) 0);
    private static final f iBW = g.ah(c.VgP);
    final WebViewUI Jkg;
    p VgK = new p((byte) 0);

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0067, code lost:
        if (r1 != false) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public q(com.tencent.mm.plugin.webview.ui.tools.WebViewUI r9) {
        /*
        // Method dump skipped, instructions count: 387
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.q.<init>(com.tencent.mm.plugin.webview.ui.tools.WebViewUI):void");
    }

    private final void axr(int i2) {
        AppMethodBeat.i(259820);
        switch (i2) {
            case 0:
                this.VgK.ITY = false;
                AppMethodBeat.o(259820);
                return;
            case 1:
                this.VgK.ITY = true;
                AppMethodBeat.o(259820);
                return;
            default:
                this.VgK.ITY = ao.isDarkMode();
                AppMethodBeat.o(259820);
                return;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR#\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f8FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0012\u0010\b¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewActionBarHelper$Companion;", "", "()V", "TAG", "", "immersiveStyleFromUrl", "", "getImmersiveStyleFromUrl", "()Z", "immersiveStyleFromUrl$delegate", "Lkotlin/Lazy;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "showRedPacketAlphaTitleBar", "getShowRedPacketAlphaTitleBar", "showRedPacketAlphaTitleBar$delegate", "isImmersiveStyleHost", "host", "isImmersiveStylePath", "path", "plugin-webview_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(259822);
        AppMethodBeat.o(259822);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final c VgP = new c();

        static {
            AppMethodBeat.i(259817);
            AppMethodBeat.o(259817);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(259816);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("__webview_command");
            AppMethodBeat.o(259816);
            return mmkv;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final b VgO = new b();

        static {
            AppMethodBeat.i(259815);
            AppMethodBeat.o(259815);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(259814);
            g.a aVar = com.tencent.mm.plugin.webview.core.g.ILB;
            if (g.a.KB()) {
                a aVar2 = q.VgN;
                f fVar = q.iBW;
                a aVar3 = q.VgN;
                if (((MultiProcessMMKV) fVar.getValue()).decodeBool("ImmersiveStyleFromUrl", false)) {
                    z = true;
                    Boolean valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(259814);
                    return valueOf;
                }
            }
            z = false;
            Boolean valueOf2 = Boolean.valueOf(z);
            AppMethodBeat.o(259814);
            return valueOf2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final d VgQ = new d();

        static {
            AppMethodBeat.i(259819);
            AppMethodBeat.o(259819);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(259818);
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_webview_showredpacket_alpha_title_bar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(259818);
            return valueOf;
        }
    }
}
