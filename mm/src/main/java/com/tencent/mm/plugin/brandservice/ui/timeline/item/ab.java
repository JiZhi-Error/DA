package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.MutableContextWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ab.f;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.appcache.p;
import com.tencent.mm.plugin.webcanvas.k;
import com.tencent.mm.storage.r;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardRenderJsEngine;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "tlJsEngine", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "bizPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "wxaPkg", "performanceReporter", "Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter;)V", "createCanvasContext", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext;", "canvasId", "", "contextWrapper", "Landroid/content/MutableContextWrapper;", "checkDrawChanged", "", "updateHeight", "enterHotZone", "", "exitHotZone", "Companion", "plugin-brandservice_release"})
public final class ab extends k {
    public static final a pwI = new a((byte) 0);

    static {
        AppMethodBeat.i(195452);
        AppMethodBeat.o(195452);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ab(x xVar, p pVar, p pVar2, com.tencent.mm.plugin.ac.b bVar) {
        super(xVar, pVar, pVar2, bVar);
        kotlin.g.b.p.h(xVar, "tlJsEngine");
        kotlin.g.b.p.h(pVar, "bizPkg");
        kotlin.g.b.p.h(pVar2, "wxaPkg");
        kotlin.g.b.p.h(bVar, "performanceReporter");
        AppMethodBeat.i(195451);
        AppMethodBeat.o(195451);
    }

    @Override // com.tencent.mm.plugin.webcanvas.k
    public final com.tencent.mm.plugin.webcanvas.a a(String str, MutableContextWrapper mutableContextWrapper, boolean z, boolean z2) {
        AppMethodBeat.i(195450);
        kotlin.g.b.p.h(str, "canvasId");
        kotlin.g.b.p.h(mutableContextWrapper, "contextWrapper");
        com.tencent.mm.plugin.webcanvas.a a2 = super.a(str, mutableContextWrapper, z, z2);
        if (kotlin.g.b.p.j(str, "__biz_video_channel_canvas_id__")) {
            a2.IyV = c.pwK;
            a2.IyW = d.pwL;
        }
        r rVar = r.NPl;
        if (r.gzN() && n.J(str, "__ad_card_", false)) {
            a2.IyX = new b(str);
        }
        AppMethodBeat.o(195450);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardRenderJsEngine$Companion;", "", "()V", "limitFontSize", "", "getLimitFontSize", "()F", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Float> {
        public static final c pwK = new c();

        static {
            AppMethodBeat.i(195447);
            AppMethodBeat.o(195447);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(195446);
            a aVar = ab.pwI;
            f.a aVar2 = f.IBd;
            Float valueOf = Float.valueOf(com.tencent.mm.cb.a.ji(f.a.getAppContext()));
            AppMethodBeat.o(195446);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<Float> {
        public static final d pwL = new d();

        static {
            AppMethodBeat.i(195449);
            AppMethodBeat.o(195449);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(195448);
            f.a aVar = f.IBd;
            Float valueOf = Float.valueOf(((float) com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a.eN(f.a.getAppContext())) / g.bZk());
            AppMethodBeat.o(195448);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardRenderJsEngine$createCanvasContext$1$3"})
    static final class b extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ String pwJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(0);
            this.pwJ = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(195445);
            r rVar = r.NPl;
            Boolean valueOf = Boolean.valueOf(r.biJ(this.pwJ));
            AppMethodBeat.o(195445);
            return valueOf;
        }
    }
}
