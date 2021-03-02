package com.tencent.mm.plugin.subapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.Log;

public final class Plugin implements d {
    public Plugin() {
        AppMethodBeat.i(28828);
        Log.i("MicroMsg.Plugin.subapp", "subapp constructor " + System.currentTimeMillis());
        AppMethodBeat.o(28828);
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final n createApplication() {
        AppMethodBeat.i(28829);
        Log.i("MicroMsg.Plugin.subapp", "subapp createApplication " + System.currentTimeMillis());
        b bVar = new b();
        AppMethodBeat.o(28829);
        return bVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final c getContactWidgetFactory() {
        AppMethodBeat.i(28830);
        Log.i("MicroMsg.Plugin.subapp", "subapp getContactWidgetFactory " + System.currentTimeMillis());
        AppMethodBeat.o(28830);
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final bd createSubCore() {
        AppMethodBeat.i(28831);
        Log.i("MicroMsg.Plugin.subapp", "subapp createSubCore " + System.currentTimeMillis());
        a aVar = new a();
        AppMethodBeat.o(28831);
        return aVar;
    }
}
