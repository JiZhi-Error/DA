package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bH\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogicWC;", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogic;", "appId", "", "pipContainerView", "Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;)V", "lastStablePos", "Landroid/graphics/Point;", "getStablePosAsync", "", "callback", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosCallback;", "saveStablePos", "point", "plugin-appbrand-integration_release"})
final class l extends i {
    volatile Point nDQ;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "point", "Landroid/graphics/Point;", "onCallback"})
    static final class a<T> implements d<ResultType> {
        final /* synthetic */ l nDR;
        final /* synthetic */ h nDS;

        a(l lVar, h hVar) {
            this.nDR = lVar;
            this.nDS = hVar;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            AppMethodBeat.i(229264);
            Point point = (Point) obj;
            this.nDR.nDQ = point;
            this.nDS.f(point);
            AppMethodBeat.o(229264);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(String str, AppBrandPipContainerView appBrandPipContainerView) {
        super(str, appBrandPipContainerView);
        p.h(str, "appId");
        p.h(appBrandPipContainerView, "pipContainerView");
        AppMethodBeat.i(229267);
        AppMethodBeat.o(229267);
    }

    @Override // com.tencent.mm.plugin.appbrand.pip.i
    public final void a(h hVar) {
        AppMethodBeat.i(229265);
        p.h(hVar, "callback");
        h.a(MainProcessIPCService.dkO, new IPCString(this.appId), n.class, new a(this, hVar));
        AppMethodBeat.o(229265);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.pip.i
    public final void g(Point point) {
        AppMethodBeat.i(229266);
        p.h(point, "point");
        if (p.j(point, this.nDQ)) {
            Log.i("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "saveStablePos, same pos");
            AppMethodBeat.o(229266);
            return;
        }
        h.a(MainProcessIPCService.dkO, new PipStablePos(this.appId, point), p.class, new b(this, point));
        AppMethodBeat.o(229266);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class b<T> implements d<ResultType> {
        final /* synthetic */ l nDR;
        final /* synthetic */ Point nDT;

        b(l lVar, Point point) {
            this.nDR = lVar;
            this.nDT = point;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* bridge */ /* synthetic */ void bn(Object obj) {
            this.nDR.nDQ = this.nDT;
        }
    }
}
