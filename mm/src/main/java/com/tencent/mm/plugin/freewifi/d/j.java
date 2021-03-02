package com.tencent.mm.plugin.freewifi.d;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.cmh;
import com.tencent.mm.protocal.protobuf.cmi;
import com.tencent.mm.protocal.protobuf.cmj;
import java.util.LinkedList;

public final class j extends c {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.d.c
    public final void dNu() {
        AppMethodBeat.i(24863);
        d.a aVar = new d.a();
        aVar.iLN = new cmh();
        aVar.iLO = new cmi();
        aVar.uri = "/cgi-bin/mmo2o-bin/manufacturerapinfo";
        aVar.funcId = 1707;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(24863);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1707;
    }

    public j(LinkedList<cmj> linkedList, int i2) {
        AppMethodBeat.i(24864);
        dNu();
        cmh cmh = (cmh) this.rr.iLK.iLR;
        cmh.MrE = Build.BRAND;
        cmh.MrD = i2;
        cmh.MrC = linkedList;
        AppMethodBeat.o(24864);
    }

    public final cmi dNF() {
        return (cmi) this.rr.iLL.iLR;
    }
}
