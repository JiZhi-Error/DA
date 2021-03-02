package com.tencent.mm.plugin.appbrand;

import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/DefaultWindowOrientationHandlerViewImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "mView", "Landroid/view/View;", "(Landroid/view/View;)V", "LANDSCAPE_ENUMS", "", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "[Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "getCurrentOrientation", "hasExecutingOrPendingRequests", "", "requestDeviceOrientation", "", "reqOrientation", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "luggage-wxa-app_release"})
public final class ad implements e {
    private final e.b[] kEN = {e.b.LANDSCAPE_SENSOR, e.b.LANDSCAPE_LOCKED, e.b.LANDSCAPE_LEFT, e.b.LANDSCAPE_RIGHT};
    private final View mView;

    public ad(View view) {
        p.h(view, "mView");
        AppMethodBeat.i(219647);
        this.mView = view;
        AppMethodBeat.o(219647);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.e
    public final void a(e.b bVar, e.a aVar) {
        AppMethodBeat.i(219645);
        if (bVar == null) {
            new a(aVar).invoke();
            AppMethodBeat.o(219645);
        } else if (bVar == e.b.PORTRAIT) {
            if (aVar != null) {
                aVar.a(btm(), btm() == bVar);
                AppMethodBeat.o(219645);
                return;
            }
            AppMethodBeat.o(219645);
        } else if (!kotlin.a.e.contains(this.kEN, bVar) || aVar == null) {
            AppMethodBeat.o(219645);
        } else {
            aVar.a(btm(), kotlin.a.e.contains(this.kEN, btm()));
            AppMethodBeat.o(219645);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.e
    public final e.b btm() {
        AppMethodBeat.i(219646);
        if (this.mView.getHeight() >= this.mView.getWidth()) {
            e.b bVar = e.b.PORTRAIT;
            AppMethodBeat.o(219646);
            return bVar;
        }
        e.b bVar2 = e.b.LANDSCAPE_LOCKED;
        AppMethodBeat.o(219646);
        return bVar2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ e.a kEO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(e.a aVar) {
            super(0);
            this.kEO = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(219644);
            e.a aVar = this.kEO;
            if (aVar != null) {
                aVar.a(null, false);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(219644);
            return xVar;
        }
    }
}
