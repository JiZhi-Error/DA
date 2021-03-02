package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/WeEffectWorkaroundManagerFactory;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$IFactory;", "()V", "create", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "plugin-appbrand-integration_release"})
public final class q implements m.b {
    public static final q oHw = new q();

    static {
        AppMethodBeat.i(229772);
        AppMethodBeat.o(229772);
    }

    private q() {
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m.b
    public final m Qh() {
        AppMethodBeat.i(229771);
        o oVar = o.INSTANCE;
        com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l cdK = o.cdK();
        p.g(cdK, "WeEffectManagerFactory.INSTANCE.create()");
        p pVar = new p(cdK);
        AppMethodBeat.o(229771);
        return pVar;
    }
}
