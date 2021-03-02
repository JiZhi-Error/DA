package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.sdk.event.EventCenter;

public final class h {
    public static String a(b bVar) {
        AppMethodBeat.i(27800);
        hb hbVar = new hb();
        hbVar.dLm.type = 2;
        hbVar.dLm.dLo = bVar.dKT;
        EventCenter.instance.publish(hbVar);
        String str = hbVar.dLn.path;
        AppMethodBeat.o(27800);
        return str;
    }

    public static String b(b bVar) {
        AppMethodBeat.i(27801);
        hb hbVar = new hb();
        hbVar.dLm.type = 2;
        hbVar.dLm.dLo = bVar.dKT;
        EventCenter.instance.publish(hbVar);
        String str = hbVar.dLn.thumbPath;
        AppMethodBeat.o(27801);
        return str;
    }

    public static boolean c(b bVar) {
        AppMethodBeat.i(27802);
        hb hbVar = new hb();
        hbVar.dLm.type = 14;
        hbVar.dLm.dLo = bVar.dKT;
        EventCenter.instance.publish(hbVar);
        if (hbVar.dLn.ret == 1) {
            AppMethodBeat.o(27802);
            return true;
        }
        AppMethodBeat.o(27802);
        return false;
    }

    public static g HT(long j2) {
        AppMethodBeat.i(27803);
        g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(j2);
        AppMethodBeat.o(27803);
        return DY;
    }
}
