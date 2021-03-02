package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.plugin.game.protobuf.ah;
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.plugin.game.protobuf.bm;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;

public final class ad extends x {
    public static void a(bm bmVar) {
        AppMethodBeat.i(41542);
        if (bmVar == null || Util.isNullOrNil(bmVar.xLC)) {
            AppMethodBeat.o(41542);
            return;
        }
        Iterator<ao> it = bmVar.xLC.iterator();
        while (it.hasNext()) {
            ao next = it.next();
            if (next.xKt != null && next.xKt.xIz != null) {
                d.c(a(next.xKt.xIz));
            } else if (next.xKv != null && !Util.isNullOrNil(next.xKv.xJs)) {
                Iterator<ah> it2 = next.xKv.xJs.iterator();
                while (it2.hasNext()) {
                    d.c(a(it2.next().xIz));
                }
            } else if (!(next.xKu == null || next.xKu.xIz == null)) {
                d.c(a(next.xKu.xIz));
            }
        }
        AppMethodBeat.o(41542);
    }
}
