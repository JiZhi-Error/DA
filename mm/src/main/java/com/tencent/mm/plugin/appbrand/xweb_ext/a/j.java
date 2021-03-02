package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\t\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/StickerApplyAdapter;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyAdapter;", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;)V", "stickerApplyLogic", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyLogic;", "getStickerApplyLogic", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyLogic;", "applySticker", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "path", "", "", "stickerInfo", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "plugin-appbrand-integration_release"})
public final class j implements i {
    private final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j oGP;

    public j(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l lVar) {
        q qVar;
        p.h(lVar, "weEffectManager");
        AppMethodBeat.i(229738);
        if (lVar instanceof p) {
            Log.w("MicroMsg.AppBrand.StickerApplyAdapter", "weEffectManager is IWeEffectWorkaroundManager");
            qVar = ((p) lVar).oHu.Qe();
        } else {
            qVar = new q(lVar);
        }
        this.oGP = qVar;
        AppMethodBeat.o(229738);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.i
    public final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j Qe() {
        return this.oGP;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.k
    public final boolean a(l.c cVar, List<StickerItemInfo> list) {
        AppMethodBeat.i(229737);
        p.h(cVar, "type");
        p.h(list, "stickerInfo");
        m b2 = k.oGR.b(cVar, list);
        if (b2 != null) {
            this.oGP.a(b2.oGU, b2.path);
            AppMethodBeat.o(229737);
            return true;
        }
        AppMethodBeat.o(229737);
        return false;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j
    public final void a(l.c cVar, String str) {
        AppMethodBeat.i(229736);
        p.h(cVar, "type");
        p.h(str, "path");
        this.oGP.a(cVar, str);
        AppMethodBeat.o(229736);
    }
}
