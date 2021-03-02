package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0002¨\u0006\u0007"}, hxF = {"ensureGlobalLayoutAtRepeatCount", "", "Landroid/view/View;", "repeat", "", "callback", "Lkotlin/Function0;", "luggage-wxa-app_release"})
public final class f {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImplKt$ensureGlobalLayoutAtRepeatCount$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "luggage-wxa-app_release"})
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ kotlin.g.a.a ihE;
        final /* synthetic */ View nEN;
        final /* synthetic */ z.d nEO;
        final /* synthetic */ int nEP = 2;

        a(View view, z.d dVar, kotlin.g.a.a aVar) {
            this.nEN = view;
            this.nEO = dVar;
            this.ihE = aVar;
        }

        public final void onGlobalLayout() {
            AppMethodBeat.i(176484);
            z.d dVar = this.nEO;
            dVar.SYE++;
            if (dVar.SYE < this.nEP) {
                AppMethodBeat.o(176484);
                return;
            }
            this.nEN.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.ihE.invoke();
            AppMethodBeat.o(176484);
        }
    }
}
