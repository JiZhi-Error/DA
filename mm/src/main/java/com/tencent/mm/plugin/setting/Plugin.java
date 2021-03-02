package com.tencent.mm.plugin.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.Log;

public final class Plugin implements d {
    public Plugin() {
        AppMethodBeat.i(73741);
        Log.i("MicroMsg.Plugin.setting", "setting constructor " + System.currentTimeMillis());
        AppMethodBeat.o(73741);
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final n createApplication() {
        AppMethodBeat.i(73742);
        Log.i("MicroMsg.Plugin.setting", "setting createApplication " + System.currentTimeMillis());
        c cVar = new c();
        AppMethodBeat.o(73742);
        return cVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final c getContactWidgetFactory() {
        AppMethodBeat.i(73743);
        Log.i("MicroMsg.Plugin.setting", "setting getContactWidgetFactory " + System.currentTimeMillis());
        AppMethodBeat.o(73743);
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final bd createSubCore() {
        AppMethodBeat.i(73744);
        Log.i("MicroMsg.Plugin.setting", "setting createSubCore " + System.currentTimeMillis());
        d dVar = new d();
        AppMethodBeat.o(73744);
        return dVar;
    }
}
