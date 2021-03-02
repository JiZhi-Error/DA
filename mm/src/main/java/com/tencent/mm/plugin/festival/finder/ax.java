package com.tencent.mm.plugin.festival.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.aus;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveUtil;", "", "()V", "getLiveDisplayName", "", ch.COL_USERNAME, "nickname", "printLog", "", "plugin-festival_release"})
public final class ax {
    public static final ax UuB = new ax();

    static {
        AppMethodBeat.i(262577);
        AppMethodBeat.o(262577);
    }

    private ax() {
    }

    public static /* synthetic */ String cC(String str, String str2) {
        aus aus;
        AppMethodBeat.i(262576);
        m mVar = m.vVH;
        if (!m.dBP()) {
            m mVar2 = m.vVH;
            if (m.byb(str)) {
                at atVar = at.Uuv;
                g dfZ = at.dfZ();
                if (!(dfZ == null || (aus = dfZ.UQh) == null || aus.LFy != 2)) {
                    if (str2 == null) {
                        str2 = "";
                    }
                    AppMethodBeat.o(262576);
                    return str2;
                }
            }
        }
        y yVar = y.vXH;
        String he = y.he(str, str2);
        AppMethodBeat.o(262576);
        return he;
    }
}
