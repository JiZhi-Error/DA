package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.game.e.a.a;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.storage.as;
import java.util.LinkedList;

public final class b {
    public static q a(String str, i iVar, int i2) {
        AppMethodBeat.i(202715);
        d(iVar);
        if (as.bjp(str)) {
            com.tencent.mm.openim.b.b bVar = new com.tencent.mm.openim.b.b(str, "");
            AppMethodBeat.o(202715);
            return bVar;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(79);
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(str);
        p pVar = new p(1, linkedList2, linkedList, new LinkedList(), "", "", null, "", null);
        eqb eqb = new eqb();
        if (i2 == 182) {
            eqb.KJS = 2;
        } else {
            eqb.KJS = 1;
        }
        pVar.a(eqb);
        AppMethodBeat.o(202715);
        return pVar;
    }

    private static void d(i iVar) {
        AppMethodBeat.i(202716);
        g.azz().a(30, iVar);
        g.azz().a(a.CTRL_INDEX, iVar);
        AppMethodBeat.o(202716);
    }

    public static void e(i iVar) {
        AppMethodBeat.i(202717);
        g.azz().b(30, iVar);
        g.azz().b(a.CTRL_INDEX, iVar);
        AppMethodBeat.o(202717);
    }
}
