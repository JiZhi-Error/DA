package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;

public final class f implements j {
    @Override // com.tencent.mm.plugin.backup.bakoldlogic.b.j
    public final int a(String str, is isVar, ca caVar) {
        AppMethodBeat.i(21849);
        String str2 = new String(isVar.KHn.MTo);
        i aSQ = b.chw().chx().aSQ();
        caVar.setContent(str2);
        switch (isVar.oUv) {
            case 50:
                caVar.setStatus(6);
                break;
        }
        if (caVar.field_msgId == 0) {
            d.x(caVar);
        } else {
            aSQ.b(isVar.Brn, caVar);
        }
        AppMethodBeat.o(21849);
        return 0;
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.b.j
    public final int a(is isVar, ca caVar, String str, LinkedList<u> linkedList) {
        AppMethodBeat.i(231601);
        if (caVar.field_content == null) {
            AppMethodBeat.o(231601);
            return 0;
        }
        int length = caVar.field_content.getBytes().length;
        AppMethodBeat.o(231601);
        return length;
    }
}
