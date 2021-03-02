package com.tencent.mm.plugin.groupcollect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class PluginGroupCollect extends f implements a, c, a {
    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(175280);
        Log.i("MicroMsg.groupcollect.PluginGroupCollect", "onAccountInitialized");
        AppMethodBeat.o(175280);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(175281);
        Log.i("MicroMsg.groupcollect.PluginGroupCollect", "onAccountRelease");
        AppMethodBeat.o(175281);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(175282);
        Log.i("MicroMsg.groupcollect.PluginGroupCollect", "execute");
        AppMethodBeat.o(175282);
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        return null;
    }
}
