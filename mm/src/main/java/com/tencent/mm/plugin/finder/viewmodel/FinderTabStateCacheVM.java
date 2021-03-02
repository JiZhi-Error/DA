package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponentPlugin;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J'\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u001b\u0010\u0016\u001a\u00020\u00172\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStateCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "cachedTabIndex", "", "cachedTimeStamp", "", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "getCachedIndex", "type", "getEnterTabIndex", "getRedDotCount", "Lkotlin/Pair;", "redDotFlags", "", "", "([Ljava/lang/Boolean;)Lkotlin/Pair;", "isExistRedDot", "showInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "setRedDotFlags", "", "([Ljava/lang/Boolean;)V", "store", "tabIndex", "Companion", "plugin-finder_release"})
public final class FinderTabStateCacheVM extends UIComponentPlugin<PluginFinder> {
    public static final a wuJ = new a((byte) 0);
    public final ConcurrentHashMap<Integer, Integer> wtV = new ConcurrentHashMap<>();
    public int wuI = -1;

    static {
        AppMethodBeat.i(255373);
        AppMethodBeat.o(255373);
    }

    public FinderTabStateCacheVM() {
        AppMethodBeat.i(255372);
        AppMethodBeat.o(255372);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStateCacheVM$Companion;", "", "()V", "TAG", "", "TYPE_NOTIFY_TAB", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final int dHU() {
        boolean z;
        Boolean[] boolArr;
        AppMethodBeat.i(255368);
        if (this.wuI != -1) {
            int i2 = this.wuI;
            AppMethodBeat.o(255368);
            return i2;
        }
        int dHV = dHV();
        Boolean[] boolArr2 = {Boolean.FALSE, Boolean.FALSE, Boolean.FALSE};
        a(boolArr2);
        o<Integer, Integer> b2 = b(boolArr2);
        this.wuI = dHV;
        if (b2.first.intValue() == 0) {
            AppMethodBeat.o(255368);
            return dHV;
        }
        if (dHV < 0 || dHV >= 3) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            boolArr = boolArr2;
        } else {
            boolArr = null;
        }
        if (boolArr != null && boolArr2[dHV].booleanValue()) {
            Log.i("Finder.FinderTabStateCacheVM", "red dot index == cachedIndex");
            AppMethodBeat.o(255368);
            return dHV;
        } else if (b2.first.intValue() == 2 || b2.first.intValue() == 1) {
            this.wuI = b2.second.intValue();
            int intValue = b2.second.intValue();
            AppMethodBeat.o(255368);
            return intValue;
        } else {
            AppMethodBeat.o(255368);
            return dHV;
        }
    }

    private final int dHV() {
        AppMethodBeat.i(255369);
        Integer num = this.wtV.get(1);
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(255369);
            return intValue;
        }
        AppMethodBeat.o(255369);
        return 0;
    }

    private static void a(Boolean[] boolArr) {
        AppMethodBeat.i(255370);
        com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        bdo asW = ((PluginFinder) ah).getRedDotManager().asW("NotificationCenterLike");
        com.tencent.mm.kernel.b.a ah2 = g.ah(PluginFinder.class);
        p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
        bdo asW2 = ((PluginFinder) ah2).getRedDotManager().asW("NotificationCenterComment");
        com.tencent.mm.kernel.b.a ah3 = g.ah(PluginFinder.class);
        p.g(ah3, "MMKernel.plugin(PluginFinder::class.java)");
        bdo asW3 = ((PluginFinder) ah3).getRedDotManager().asW("NotificationCenterFollow");
        boolArr[0] = Boolean.valueOf(a(asW));
        boolArr[1] = Boolean.valueOf(a(asW2));
        boolArr[2] = Boolean.valueOf(a(asW3));
        AppMethodBeat.o(255370);
    }

    private static boolean a(bdo bdo) {
        if (bdo == null || bdo.count <= 0) {
            return false;
        }
        return true;
    }

    private static o<Integer, Integer> b(Boolean[] boolArr) {
        AppMethodBeat.i(255371);
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        int i5 = 0;
        while (i2 < 3) {
            int i6 = i3 + 1;
            if (boolArr[i2].booleanValue()) {
                i5++;
                if (i4 == -1) {
                    i4 = i3;
                }
            }
            i2++;
            i3 = i6;
        }
        o<Integer, Integer> oVar = new o<>(Integer.valueOf(i5), Integer.valueOf(i4));
        AppMethodBeat.o(255371);
        return oVar;
    }
}
