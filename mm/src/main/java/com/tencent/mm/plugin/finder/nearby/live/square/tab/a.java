package com.tencent.mm.plugin.finder.nearby.live.square.tab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.axj;
import java.util.HashMap;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0005J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabParser;", "", "()V", "liveTabInfoMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "parseTabName", "tabName", "storeTabs", "", "liveTabList", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "plugin-finder_release"})
public final class a {
    private static final HashMap<String, Integer> uRP = new HashMap<>();
    public static final a uRQ = new a();

    static {
        AppMethodBeat.i(249237);
        AppMethodBeat.o(249237);
    }

    private a() {
    }

    public static void el(List<? extends axj> list) {
        AppMethodBeat.i(249235);
        p.h(list, "liveTabList");
        uRP.clear();
        int i2 = 0;
        for (T t : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            String str = t.LHR;
            if (str == null) {
                p.hyc();
            }
            p.g(str, "tab.tab_name!!");
            uRP.put(str, Integer.valueOf(i2 + 1005));
            i2 = i3;
        }
        AppMethodBeat.o(249235);
    }

    public static int aul(String str) {
        AppMethodBeat.i(249236);
        p.h(str, "tabName");
        Integer num = uRP.get(str);
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(249236);
            return intValue;
        }
        AppMethodBeat.o(249236);
        return -1;
    }
}
