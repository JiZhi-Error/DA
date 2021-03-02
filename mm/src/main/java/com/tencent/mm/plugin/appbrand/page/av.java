package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.af.a;
import com.tencent.mm.plugin.appbrand.page.a.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0016R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/CustomPauseRenderingExtensionWrapper;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPauseRenderingExtension;", "originExtension", "(Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPauseRenderingExtension;)V", "value", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "htmlView", "getHtmlView", "()Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "setHtmlView", "(Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;)V", "paused", "", "pauseRendering", "", "resetRenderingState", "restoreRendering", "Companion", "plugin-appbrand-integration_release"})
public final class av implements e {
    public static final a nsY = new a((byte) 0);
    private com.tencent.mm.plugin.appbrand.jsapi.af.a nsW;
    private final e nsX;
    private boolean tN;

    static {
        AppMethodBeat.i(50936);
        AppMethodBeat.o(50936);
    }

    public av(e eVar) {
        p.h(eVar, "originExtension");
        AppMethodBeat.i(50935);
        this.nsX = eVar;
        AppMethodBeat.o(50935);
    }

    public static final /* synthetic */ void a(av avVar) {
        AppMethodBeat.i(50937);
        avVar.bSb();
        AppMethodBeat.o(50937);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/CustomPauseRenderingExtensionWrapper$Companion;", "", "()V", "TAG", "", "notifyHtmlViewChanged", "", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "htmlView", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"})
        /* renamed from: com.tencent.mm.plugin.appbrand.page.av$a$a  reason: collision with other inner class name */
        public static final class RunnableC0768a implements Runnable {
            final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.af.a nsZ;
            final /* synthetic */ ag nta;

            public RunnableC0768a(com.tencent.mm.plugin.appbrand.jsapi.af.a aVar, ag agVar) {
                this.nsZ = aVar;
                this.nta = agVar;
            }

            public final void run() {
                AppMethodBeat.i(50929);
                Object S = this.nta.S(e.class);
                if (!(S instanceof av)) {
                    S = null;
                }
                av avVar = (av) S;
                if (avVar != null) {
                    avVar.m(this.nsZ);
                    AppMethodBeat.o(50929);
                    return;
                }
                AppMethodBeat.o(50929);
            }
        }
    }

    public final void m(com.tencent.mm.plugin.appbrand.jsapi.af.a aVar) {
        AppMethodBeat.i(50931);
        if (!p.j(this.nsW, aVar)) {
            this.nsW = aVar;
            bSb();
            if (aVar != null) {
                aVar.a(new b(this));
                AppMethodBeat.o(50931);
                return;
            }
        }
        AppMethodBeat.o(50931);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onVisibilityChanged"})
    public static final class b implements a.AbstractC0600a {
        final /* synthetic */ av ntb;

        b(av avVar) {
            this.ntb = avVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.af.a.AbstractC0600a
        public final void bLw() {
            AppMethodBeat.i(50930);
            av.a(this.ntb);
            AppMethodBeat.o(50930);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.e
    public final void bLp() {
        AppMethodBeat.i(50932);
        this.tN = false;
        com.tencent.mm.plugin.appbrand.jsapi.af.a aVar = this.nsW;
        if (aVar == null || aVar.getVisibility() != 0) {
            this.nsX.bLp();
            AppMethodBeat.o(50932);
            return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.af.a aVar2 = this.nsW;
        if (aVar2 == null) {
            p.hyc();
        }
        aVar2.bLp();
        AppMethodBeat.o(50932);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.e
    public final void bLq() {
        AppMethodBeat.i(50933);
        this.tN = true;
        com.tencent.mm.plugin.appbrand.jsapi.af.a aVar = this.nsW;
        if (aVar != null) {
            aVar.bLq();
        }
        this.nsX.bLq();
        AppMethodBeat.o(50933);
    }

    private final void bSb() {
        AppMethodBeat.i(50934);
        if (this.tN) {
            bLq();
            AppMethodBeat.o(50934);
            return;
        }
        bLp();
        if (this.nsW != null) {
            this.nsX.bLq();
        }
        AppMethodBeat.o(50934);
    }

    public static final void a(ag agVar, com.tencent.mm.plugin.appbrand.jsapi.af.a aVar) {
        AppMethodBeat.i(50938);
        p.h(agVar, "page");
        ag agVar2 = agVar;
        if (MMHandlerThread.isMainThread()) {
            Object S = agVar.S(e.class);
            if (!(S instanceof av)) {
                S = null;
            }
            av avVar = (av) S;
            if (avVar != null) {
                avVar.m(aVar);
                AppMethodBeat.o(50938);
                return;
            }
            AppMethodBeat.o(50938);
            return;
        }
        View contentView = agVar2.getContentView();
        if (contentView != null) {
            contentView.post(new a.RunnableC0768a(aVar, agVar));
            AppMethodBeat.o(50938);
            return;
        }
        AppMethodBeat.o(50938);
    }
}
