package com.tencent.mm.plugin.finder.report;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.event.base.i;
import com.tencent.mm.plugin.finder.event.base.j;
import com.tencent.mm.plugin.finder.utils.y;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/SingleFeedFlowScrollEvent;", "newState", "", "handleEvent", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onInvisible", "", "plugin-finder_release"})
public final class n extends i {
    private long tCi;

    private /* synthetic */ n() {
        this(null);
    }

    public n(c cVar) {
        super(cVar);
        this.tCi = -1;
    }

    @Override // com.tencent.mm.plugin.finder.event.base.i, com.tencent.mm.plugin.finder.event.base.f
    public final /* synthetic */ b It(int i2) {
        AppMethodBeat.i(250716);
        j Ky = Ky(i2);
        AppMethodBeat.o(250716);
        return Ky;
    }

    @Override // com.tencent.mm.plugin.finder.event.base.i
    public final /* synthetic */ h Iu(int i2) {
        AppMethodBeat.i(250717);
        j Ky = Ky(i2);
        AppMethodBeat.o(250717);
        return Ky;
    }

    @Override // com.tencent.mm.plugin.finder.event.base.i, com.tencent.mm.plugin.finder.event.base.f
    public final /* synthetic */ b g(RecyclerView recyclerView, int i2) {
        AppMethodBeat.i(250714);
        h h2 = h(recyclerView, i2);
        AppMethodBeat.o(250714);
        return h2;
    }

    @Override // com.tencent.mm.plugin.finder.event.base.i
    public final h h(RecyclerView recyclerView, int i2) {
        int i3;
        int i4;
        int i5;
        AppMethodBeat.i(250713);
        p.h(recyclerView, "recyclerView");
        h h2 = super.h(recyclerView, i2);
        if (h2 == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.event.base.SingleFeedFlowScrollEvent");
            AppMethodBeat.o(250713);
            throw tVar;
        }
        j jVar = (j) h2;
        jVar.tCi = this.tCi;
        jVar.ptb = this.ptb;
        jVar.ptc = this.ptc;
        y yVar = y.vXH;
        y.b a2 = y.a(recyclerView, this.tIf);
        jVar.tII = a2.vXL;
        jVar.tIJ = a2.vXM;
        if (!(this.ptb == jVar.tIy && this.ptc == jVar.tIA)) {
            if (this.ptb == Integer.MAX_VALUE || this.ptc == Integer.MAX_VALUE) {
                i3 = jVar.tIy;
                i4 = jVar.tIA;
            } else {
                if (jVar.tIy < this.ptb) {
                    i5 = jVar.tIy;
                } else {
                    i5 = this.ptb;
                }
                if (jVar.tIA > this.ptc) {
                    i4 = jVar.tIA;
                    i3 = i5;
                } else {
                    i4 = this.ptc;
                    i3 = i5;
                }
            }
            y yVar2 = y.vXH;
            jVar.tIH = y.a(i3, i4, recyclerView);
        }
        this.tCi = jVar.tIC;
        this.ptb = jVar.tIy;
        this.ptc = jVar.tIA;
        j jVar2 = jVar;
        AppMethodBeat.o(250713);
        return jVar2;
    }

    private static j Ky(int i2) {
        AppMethodBeat.i(250715);
        j jVar = new j(i2);
        AppMethodBeat.o(250715);
        return jVar;
    }

    @Override // com.tencent.mm.plugin.finder.event.base.f
    public final void onInvisible() {
        AppMethodBeat.i(250718);
        super.onInvisible();
        this.tCi = -1;
        AppMethodBeat.o(250718);
    }
}
