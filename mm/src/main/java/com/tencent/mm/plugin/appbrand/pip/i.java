package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH$R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogic;", "", "appId", "", "pipContainerView", "Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;)V", "getAppId", "()Ljava/lang/String;", "getStablePosAsync", "", "callback", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosCallback;", "saveStablePos", "point", "Landroid/graphics/Point;", "luggage-wxa-app_release"})
public abstract class i {
    final String appId;

    public abstract void a(h hVar);

    /* access modifiers changed from: protected */
    public abstract void g(Point point);

    public i(String str, AppBrandPipContainerView appBrandPipContainerView) {
        p.h(str, "appId");
        p.h(appBrandPipContainerView, "pipContainerView");
        this.appId = str;
        appBrandPipContainerView.a(new AppBrandPipContainerView.a(this) {
            /* class com.tencent.mm.plugin.appbrand.pip.i.AnonymousClass1 */
            final /* synthetic */ i nDO;

            {
                this.nDO = r1;
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView.a
            public final void ev(int i2, int i3) {
                AppMethodBeat.i(219750);
                this.nDO.g(new Point(i2, i3));
                AppMethodBeat.o(219750);
            }
        });
    }
}
