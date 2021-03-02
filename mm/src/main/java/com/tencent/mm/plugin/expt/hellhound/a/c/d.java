package com.tencent.mm.plugin.expt.hellhound.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.e;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class d {
    public static void a(String str, int i2, long j2, e.a aVar) {
        AppMethodBeat.i(184362);
        int i3 = -1;
        if (aVar == e.a.MMActivity_Back2Front) {
            i3 = 7;
        } else if (aVar == e.a.MMActivity_Front2Back) {
            i3 = 8;
        }
        if (b.isMMProcess() && !com.tencent.mm.plugin.expt.g.d.cRv()) {
            if (aVar == e.a.MMActivity_Back2Front) {
                h.INSTANCE.idkeyStat(932, 91, 1, false);
            } else if (aVar == e.a.MMActivity_Front2Back) {
                h.INSTANCE.idkeyStat(932, 92, 1, false);
            }
            Log.i("HABBYGE-MALI.HellFrontBackReport", "report 切换-前后台(3): %d, %s 未登录", Integer.valueOf(i3), str);
        }
        Log.i("HABBYGE-MALI.HellFrontBackReport", "report 切换-前后台(3): %d, %s", Integer.valueOf(i3), str);
        com.tencent.mm.plugin.expt.g.d.cRu().b(str, aVar, i2, j2);
        AppMethodBeat.o(184362);
    }

    static void a(String str, e.a aVar, int i2, long j2) {
        AppMethodBeat.i(122040);
        com.tencent.mm.plugin.expt.g.d.cRu().a(str, aVar, i2, j2);
        AppMethodBeat.o(122040);
    }
}
