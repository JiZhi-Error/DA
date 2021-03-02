package com.tencent.mm.plugin.finder.nearby;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/NearbyConfig;", "", "()V", "TAG", "", "get3TabTargetTabCommentScene", "", "get3TabTargetTabType", "saveExitTabType", "", "tabType", "plugin-finder_release"})
public final class a {
    public static final a uQd = new a();

    static {
        AppMethodBeat.i(248996);
        AppMethodBeat.o(248996);
    }

    private a() {
    }

    public static int dlh() {
        int i2;
        AppMethodBeat.i(248993);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i3 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_NEARBY_LAST_TAB_TYPE_INT_SYNC, -1);
        com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        k asX = ((PluginFinder) ah).getRedDotManager().asX("NearbyEntrance");
        if (asX == null) {
            i2 = -1;
        } else if (asX.field_ctrInfo.type == 1014) {
            Log.i("Finder.RedDotManager", "[getNearbyAliveTabType] entrance red dot is foot print, jump to default tab");
            i2 = -1;
        } else {
            i2 = f.a(asX);
        }
        Log.i("NearbyConfig", "get3TabTargetTabType defaultType=1001, lastExitType:" + i3 + " aliveType=" + i2);
        if (i2 != -1) {
            AppMethodBeat.o(248993);
            return i2;
        } else if (i3 == -1 || i3 == 1003) {
            AppMethodBeat.o(248993);
            return 1001;
        } else {
            AppMethodBeat.o(248993);
            return i3;
        }
    }

    public static int dli() {
        AppMethodBeat.i(248994);
        switch (dlh()) {
            case 1001:
                AppMethodBeat.o(248994);
                return 94;
            case 1002:
                AppMethodBeat.o(248994);
                return 15;
            case 1003:
                AppMethodBeat.o(248994);
                return 77;
            default:
                AppMethodBeat.o(248994);
                return 94;
        }
    }

    public static void Jy(int i2) {
        AppMethodBeat.i(248995);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_NEARBY_LAST_TAB_TYPE_INT_SYNC, Integer.valueOf(i2));
        AppMethodBeat.o(248995);
    }
}
