package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.api.b;
import com.tencent.mm.plugin.api.recordView.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.a;
import com.tencent.mm.plugin.mmsight.api.b;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginMMSight extends f implements a {
    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-mmsight";
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(89314);
        if (gVar != null) {
            Log.i("MicroMsg.PluginMMSight", "execute, process: %s", gVar.mProcessName);
        }
        b.zsZ = new b.a();
        MMSightRecordView.zsY = new e();
        a.zsW = new com.tencent.mm.plugin.api.a();
        if (gVar != null && gVar.aBb()) {
            pin(new y(e.class));
        }
        AppMethodBeat.o(89314);
    }
}
