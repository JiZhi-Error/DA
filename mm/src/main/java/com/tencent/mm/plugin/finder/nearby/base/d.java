package com.tencent.mm.plugin.finder.nearby.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/base/NearbyTimeConsumingHelper;", "", "tabType", "", "(I)V", "onCgiBackMs", "", "onFetchDoneMs", "onRefreshEndMs", "onViewUpdateMs", "onVisibleMs", "startCgiMs", "startFetchMs", "onCgiBack", "", "onFetchDone", "onRefreshEnd", "onViewUpdate", "onVisible", "printConsumingSteps", "reset", "startCgi", "startFetch", "Companion", "plugin-finder_release"})
public final class d {
    private static final HashMap<Integer, d> uQt = new HashMap<>();
    public static final a uQu = new a((byte) 0);
    public int dLS;
    public long uQm;
    public long uQn;
    public long uQo;
    public long uQp;
    public long uQq;
    public long uQr;
    public long uQs;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/base/NearbyTimeConsumingHelper$Companion;", "", "()V", "TAG", "", "timeConsumingMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/nearby/base/NearbyTimeConsumingHelper;", "Lkotlin/collections/HashMap;", "get", "tabType", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static d JA(int i2) {
            d dVar;
            AppMethodBeat.i(249014);
            d dVar2 = (d) d.uQt.get(Integer.valueOf(i2));
            if (dVar2 == null) {
                dVar = new d(i2);
            } else {
                dVar = dVar2;
            }
            p.g(dVar, "timeConsumingMap[tabType…eConsumingHelper(tabType)");
            d.uQt.put(Integer.valueOf(i2), dVar);
            AppMethodBeat.o(249014);
            return dVar;
        }
    }

    static {
        AppMethodBeat.i(249015);
        AppMethodBeat.o(249015);
    }

    public d(int i2) {
        this.dLS = i2;
    }
}
