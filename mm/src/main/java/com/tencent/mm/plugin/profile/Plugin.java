package com.tencent.mm.plugin.profile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.Log;

public final class Plugin implements d {
    public Plugin() {
        AppMethodBeat.i(26855);
        Log.i("MicroMsg.Plugin.profile", "profile constructor " + System.currentTimeMillis());
        AppMethodBeat.o(26855);
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final n createApplication() {
        AppMethodBeat.i(26856);
        Log.i("MicroMsg.Plugin.profile", "profile createApplication " + System.currentTimeMillis());
        b bVar = new b();
        AppMethodBeat.o(26856);
        return bVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final c getContactWidgetFactory() {
        AppMethodBeat.i(26857);
        Log.i("MicroMsg.Plugin.profile", "profile getContactWidgetFactory " + System.currentTimeMillis());
        AppMethodBeat.o(26857);
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final bd createSubCore() {
        AppMethodBeat.i(26858);
        Log.i("MicroMsg.Plugin.profile", "profile createSubCore " + System.currentTimeMillis());
        d dVar = new d();
        AppMethodBeat.o(26858);
        return dVar;
    }
}
