package com.tencent.mm.plugin.location_soso;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.Log;

public class Plugin implements d {
    public static final String TAG = "MicroMsg.Plugin";

    public Plugin() {
        AppMethodBeat.i(56228);
        Log.d(TAG, "initLoctionInit");
        AppMethodBeat.o(56228);
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public n createApplication() {
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public c getContactWidgetFactory() {
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public bd createSubCore() {
        return null;
    }
}
