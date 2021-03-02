package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/MakeupApplyLogic;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyLogic;", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;)V", "applyMakeup", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$MakeupType;", "path", "", "luggage-xweb-ext_release"})
public final class p implements f {
    private final l cGQ;

    public p(l lVar) {
        kotlin.g.b.p.h(lVar, "weEffectManager");
        AppMethodBeat.i(215967);
        this.cGQ = lVar;
        AppMethodBeat.o(215967);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.f
    public final void a(l.b bVar, String str) {
        AppMethodBeat.i(215966);
        kotlin.g.b.p.h(bVar, "type");
        kotlin.g.b.p.h(str, "path");
        Log.d("MicroMsg.AppBrand.IWeEffectWorkaroundManager", "applyMakeup, type: " + bVar + ", path: " + str);
        this.cGQ.a(bVar, str);
        AppMethodBeat.o(215966);
    }
}
