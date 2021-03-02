package com.tencent.mm.plugin.finder.preload.tabPreload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.preload.tabPreload.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/tabPreload/FollowTabPreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "core", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;)V", "performChangeEnterTargetTab", "", "lastTab", "", "targetTab", "plugin-finder_release"})
public final class b extends f {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "invoke"})
    static final class a extends q implements kotlin.g.a.b<f.d, x> {
        final /* synthetic */ b uUU;
        final /* synthetic */ long uUV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(b bVar, long j2) {
            super(1);
            this.uUU = bVar;
            this.uUV = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(f.d dVar) {
            AppMethodBeat.i(249572);
            p.h(dVar, "ret");
            this.uUU.uVb.a(this.uUU.uVf, this.uUV, "performChangeEnterTargetTab");
            x xVar = x.SXb;
            AppMethodBeat.o(249572);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(FinderStreamTabPreloadCore finderStreamTabPreloadCore) {
        super(3, finderStreamTabPreloadCore);
        p.h(finderStreamTabPreloadCore, "core");
        AppMethodBeat.i(249574);
        AppMethodBeat.o(249574);
    }

    @Override // com.tencent.mm.plugin.finder.preload.tabPreload.f
    public final void gc(int i2, int i3) {
        AppMethodBeat.i(249573);
        super.gc(i2, i3);
        if (this.dLS == i3) {
            long al = FinderStreamTabPreloadCore.al(this.dLS, true);
            Log.i(this.TAG, "[performChangeEnterTargetTab] interval=".concat(String.valueOf(al)));
            if (al > 0 && al < MAlarmHandler.NEXT_FIRE_INTERVAL) {
                this.uVb.aut("performChangeEnterTargetTab");
                a(f.c.OutSideRedDot, null, new a(this, al));
            }
        }
        AppMethodBeat.o(249573);
    }
}
