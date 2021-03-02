package com.tencent.mm.plugin.fav.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.offline.PluginFavOffline;

public final class c implements ae {
    @Override // com.tencent.mm.plugin.fav.a.ae
    public final void add(String str) {
        AppMethodBeat.i(73563);
        ((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineService().add(str);
        AppMethodBeat.o(73563);
    }
}
