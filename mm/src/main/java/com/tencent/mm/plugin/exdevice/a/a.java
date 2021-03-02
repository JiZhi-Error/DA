package com.tencent.mm.plugin.exdevice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.protocal.protobuf.byi;
import com.tencent.mm.protocal.protobuf.byj;

public final class a implements b {
    @Override // com.tencent.mm.plugin.exdevice.a.b
    public final void a(final b.a aVar) {
        AppMethodBeat.i(169753);
        d.a aVar2 = new d.a();
        aVar2.iLN = new byi();
        aVar2.iLO = new byj();
        aVar2.uri = "/cgi-bin/mmoc-bin/hardware/getwerunuserstate";
        aVar2.funcId = 1926;
        aVar2.iLP = 0;
        aVar2.respCmdId = 0;
        aa.a(aVar2.aXF(), new aa.a() {
            /* class com.tencent.mm.plugin.exdevice.a.a.AnonymousClass1 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                boolean z;
                boolean z2 = true;
                AppMethodBeat.i(169752);
                if (qVar.getType() != 1926) {
                    AppMethodBeat.o(169752);
                } else {
                    if (i2 == 0 && i3 == 0) {
                        byj byj = (byj) dVar.iLL.iLR;
                        z = byj != null && byj.MdT;
                    } else {
                        z = false;
                        z2 = false;
                    }
                    if (aVar != null) {
                        aVar.w(z2, z);
                    }
                    AppMethodBeat.o(169752);
                }
                return 0;
            }
        }, true);
        AppMethodBeat.o(169753);
    }
}
