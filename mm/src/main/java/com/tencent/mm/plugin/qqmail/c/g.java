package com.tencent.mm.plugin.qqmail.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.qqmail.d.ar;
import com.tencent.mm.sdk.platformtools.Log;

public class g implements i, b<IPCVoid, IPCInteger> {
    private d<IPCInteger> hny;

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(198584);
        Log.i("MicroMsg.GetUnreadMailCountTask", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        com.tencent.mm.kernel.g.azz().b(12213, this);
        if (this.hny != null) {
            this.hny.bn(new IPCInteger(((ar) ((com.tencent.mm.plugin.qqmail.e.b) qVar).iUB.iLL.iLR).Btg));
        }
        AppMethodBeat.o(198584);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(IPCVoid iPCVoid, d<IPCInteger> dVar) {
        AppMethodBeat.i(198585);
        this.hny = dVar;
        com.tencent.mm.kernel.g.azz().a(12213, this);
        com.tencent.mm.kernel.g.azz().a(new com.tencent.mm.plugin.qqmail.e.b(), 0);
        AppMethodBeat.o(198585);
    }
}
