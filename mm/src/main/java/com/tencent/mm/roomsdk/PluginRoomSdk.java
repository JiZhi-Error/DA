package com.tencent.mm.roomsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginRoomSdk extends f implements c {
    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(152753);
        Log.i("MicroMsg.PluginRoomSdk", "onAccountInitialized");
        AppMethodBeat.o(152753);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(152754);
        Log.i("MicroMsg.PluginRoomSdk", "onAccountRelease");
        AppMethodBeat.o(152754);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
    }
}
