package com.tencent.mm.plugin.game.luggage.g;

import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/game/luggage/page/GameNoActionBarPreloadWebPage;", "Lcom/tencent/mm/plugin/game/luggage/page/PreloadGameWebPage;", "ctrl", "Lcom/tencent/luggage/container/LuggagePageContainerCtrl;", "wc", "Lcom/tencent/luggage/container/LuggageWebCore;", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", "(Lcom/tencent/luggage/container/LuggagePageContainerCtrl;Lcom/tencent/luggage/container/LuggageWebCore;Landroid/os/Bundle;)V", "enableMinimize", "", "noActionBar", "luggage-game_release"})
public final class c extends j {
    @Override // com.tencent.mm.plugin.webview.luggage.g
    public final /* bridge */ /* synthetic */ Boolean dTB() {
        return Boolean.TRUE;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(j jVar, p pVar, Bundle bundle) {
        super(jVar, pVar, bundle);
        kotlin.g.b.p.h(jVar, "ctrl");
        kotlin.g.b.p.h(bundle, NativeProtocol.WEB_DIALOG_PARAMS);
        AppMethodBeat.i(187039);
        AppMethodBeat.o(187039);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.g
    public final boolean cpz() {
        return false;
    }
}
