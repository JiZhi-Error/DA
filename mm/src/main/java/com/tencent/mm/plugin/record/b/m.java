package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;

public final class m implements g {
    @Override // com.tencent.mm.plugin.record.a.g
    public final void HR(long j2) {
        AppMethodBeat.i(27804);
        ao.gnh();
        an.a.HR(j2);
        AppMethodBeat.o(27804);
    }

    @Override // com.tencent.mm.plugin.record.a.g
    public final boolean h(String str, long j2, String str2) {
        AppMethodBeat.i(27805);
        c aKY = p.aKY(str);
        if (aKY == null) {
            Log.w("MicroMsg.RecordMsgHelpService", "get record msg data error, empty");
            AppMethodBeat.o(27805);
            return false;
        }
        aml aml = null;
        Iterator<aml> it = aKY.iAd.iterator();
        while (it.hasNext()) {
            aml next = it.next();
            if (!next.dLl.equals(str2)) {
                next = aml;
            }
            aml = next;
        }
        boolean b2 = p.b(aml, j2, true);
        AppMethodBeat.o(27805);
        return b2;
    }
}
