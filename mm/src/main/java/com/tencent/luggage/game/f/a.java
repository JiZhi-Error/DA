package com.tencent.luggage.game.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ui.ag;
import com.tencent.mm.plugin.appbrand.ui.al;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/luggage/game/ui/WAGameButtonLayoutPropertiesProvider;", "Lcom/tencent/mm/plugin/appbrand/ui/WxaMenuButtonLayoutPropertiesProvider;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "getExpectedPadding", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Padding;", "luggage-wxa-game-ext_release"})
public final class a extends al {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(AppBrandRuntime appBrandRuntime) {
        super(appBrandRuntime);
        p.h(appBrandRuntime, "rt");
        AppMethodBeat.i(222898);
        AppMethodBeat.o(222898);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.al, com.tencent.mm.plugin.appbrand.ui.ag
    public final ag.a No() {
        AppMethodBeat.i(130752);
        ag.a No = super.No();
        ag.a aVar = new ag.a(No.left, No.top + zr(R.dimen.pp), zr(R.dimen.op) + zr(R.dimen.po), No.bottom);
        AppMethodBeat.o(130752);
        return aVar;
    }
}
