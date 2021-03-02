package com.tencent.mm.plugin.expt.hellhound.a.a.b;

import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u0018\u0010\u0014\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellScrollSamplingStrategy;", "", "callback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "pageName", "", "samplingStrategy", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellScrollSamplingStrategy$STRATEGY;", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;Ljava/lang/String;Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellScrollSamplingStrategy$STRATEGY;)V", "getCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "stagety", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingStagety;", "sendOnScroll", "", "listView", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "sendOnScrollStateChanged", "scrollState", "STRATEGY", "plugin-expt_release"})
public final class c {
    private final e sBU;
    private f sCw;

    public c(e eVar, String str, a aVar) {
        p.h(aVar, "samplingStrategy");
        AppMethodBeat.i(220808);
        this.sBU = eVar;
        int cNv = com.tencent.mm.plugin.expt.hellhound.a.cNv();
        if (cNv <= a.STRATEGY_SPEED.sCA) {
            aVar = a.STRATEGY_SPEED;
        } else if (cNv >= a.STRATEGY_SAMPLING.sCA) {
            aVar = a.STRATEGY_SAMPLING;
        }
        switch (d.$EnumSwitchMapping$0[aVar.ordinal()]) {
            case 1:
                this.sCw = new d(this.sBU, str);
                AppMethodBeat.o(220808);
                return;
            case 2:
                this.sCw = new b(this.sBU, (long) cNv);
                break;
        }
        AppMethodBeat.o(220808);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellScrollSamplingStrategy$STRATEGY;", "", "stagety", "", "(Ljava/lang/String;II)V", "getStagety", "()I", "STRATEGY_SPEED", "STRATEGY_SAMPLING", "plugin-expt_release"})
    public enum a {
        STRATEGY_SPEED(0),
        STRATEGY_SAMPLING(1);
        
        final int sCA;

        public static a valueOf(String str) {
            AppMethodBeat.i(220804);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(220804);
            return aVar;
        }

        private a(int i2) {
            this.sCA = i2;
        }

        static {
            AppMethodBeat.i(220802);
            AppMethodBeat.o(220802);
        }
    }

    public final void a(AbsListView absListView, int i2) {
        AppMethodBeat.i(220806);
        f fVar = this.sCw;
        if (fVar != null) {
            fVar.a(absListView, i2);
            AppMethodBeat.o(220806);
            return;
        }
        AppMethodBeat.o(220806);
    }

    public final void a(AbsListView absListView, int i2, int i3) {
        AppMethodBeat.i(220807);
        f fVar = this.sCw;
        if (fVar != null) {
            fVar.a(absListView, i2, i3);
            AppMethodBeat.o(220807);
            return;
        }
        AppMethodBeat.o(220807);
    }
}
