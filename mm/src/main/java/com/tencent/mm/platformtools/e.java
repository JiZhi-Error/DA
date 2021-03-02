package com.tencent.mm.platformtools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.protobuf.dyh;
import com.tencent.mm.protocal.protobuf.eer;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;

public final class e {
    public static t.a a(t tVar) {
        AppMethodBeat.i(151375);
        Bundle bundle = new Bundle();
        bundle.putInt("kscene_type", 73);
        t.a a2 = a(tVar, bundle);
        AppMethodBeat.o(151375);
        return a2;
    }

    private static t.a a(t tVar, Bundle bundle) {
        AppMethodBeat.i(151376);
        if (tVar == null) {
            AppMethodBeat.o(151376);
            return null;
        } else if (((j.g) tVar.iMO.getRespObj()).Kzw.Nky == null) {
            AppMethodBeat.o(151376);
            return null;
        } else {
            dyh dyh = ((j.g) tVar.iMO.getRespObj()).Kzw.Nky.KLj;
            if (!(dyh == null || dyh.MXV == null || dyh.MXV.size() <= 0)) {
                t.a aVar = new t.a();
                Iterator<eer> it = dyh.MXV.iterator();
                while (it.hasNext()) {
                    eer next = it.next();
                    if (next.Cya == 19) {
                        aVar.dHx = next.NeO;
                    } else if (next.Cya == 20) {
                        aVar.jke = next.NeO;
                    } else if (next.Cya == 21) {
                        aVar.dQx = next.NeO;
                    }
                }
                aVar.jkf = bundle;
                aVar.type = 0;
                if (!Util.isNullOrNil(aVar.dHx)) {
                    aVar.username = ((j.f) tVar.iMO.getReqObj()).Kzy.MrA.UserName;
                    AppMethodBeat.o(151376);
                    return aVar;
                }
            }
            AppMethodBeat.o(151376);
            return null;
        }
    }
}
