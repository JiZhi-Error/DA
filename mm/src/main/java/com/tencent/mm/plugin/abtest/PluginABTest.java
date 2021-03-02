package com.tencent.mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.storage.c;

public class PluginABTest extends f implements a {
    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(153143);
        ToolsProcessIPCService.a(new ToolsProcessIPCService.a() {
            /* class com.tencent.mm.plugin.abtest.PluginABTest.AnonymousClass1 */

            @Override // com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService.a
            public final boolean ayt() {
                boolean z;
                boolean z2 = true;
                AppMethodBeat.i(153142);
                a aVar = a.C0356a.hnM;
                c Fu = a.Fu("100488");
                if (Fu == null) {
                    AppMethodBeat.o(153142);
                    return false;
                }
                if (!Fu.isValid() || !"1".equals(Fu.gzz().get("SAFEFLAG"))) {
                    z = false;
                } else {
                    z = true;
                }
                if (!Fu.isValid() || !"1".equals(Fu.gzz().get("TURNOFFTOOLMP"))) {
                    z2 = false;
                }
                boolean z3 = z & z2;
                AppMethodBeat.o(153142);
                return z3;
            }
        });
        if (gVar.aBb()) {
            pin(b.bmZ());
            pin(c.bna());
            pin(com.tencent.mm.model.c.c.iHj);
        }
        AppMethodBeat.o(153143);
    }
}
