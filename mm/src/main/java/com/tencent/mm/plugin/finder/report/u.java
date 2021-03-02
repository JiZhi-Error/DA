package com.tencent.mm.plugin.finder.report;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.utils.y;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "TAG", "", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/TwoFeedFlowScrollEvent;", "newState", "", "handleEvent", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class u extends f {
    private final String TAG;

    private /* synthetic */ u() {
        this(null);
    }

    public u(c cVar) {
        super(cVar);
        this.TAG = "Finder.FinderTwoFeedFlowEventSubscriber";
    }

    @Override // com.tencent.mm.plugin.finder.event.base.f
    public final b g(RecyclerView recyclerView, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = 0;
        AppMethodBeat.i(250804);
        p.h(recyclerView, "recyclerView");
        b g2 = super.g(recyclerView, i2);
        if (g2 == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.event.base.TwoFeedFlowScrollEvent");
            AppMethodBeat.o(250804);
            throw tVar;
        }
        com.tencent.mm.plugin.finder.event.base.l lVar = (com.tencent.mm.plugin.finder.event.base.l) g2;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
            AppMethodBeat.o(250804);
            throw tVar2;
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        int[] n = staggeredGridLayoutManager.n(null);
        int[] o = staggeredGridLayoutManager.o(null);
        if (n != null) {
            i3 = n[0];
        } else {
            i3 = 0;
        }
        if (n != null) {
            i4 = n[1];
        } else {
            i4 = 0;
        }
        lVar.tIy = Math.min(i3, i4);
        if (o != null) {
            i5 = o[0];
        } else {
            i5 = 0;
        }
        if (o != null) {
            i9 = o[1];
        }
        lVar.tIA = Math.max(i5, i9);
        y yVar = y.vXH;
        lVar.tII = y.a(lVar.tIy, lVar.tIA, recyclerView);
        if (!(this.ptb == lVar.tIy && this.ptc == lVar.tIA)) {
            if (this.ptb == Integer.MAX_VALUE || this.ptc == Integer.MAX_VALUE) {
                i6 = lVar.tIy;
                i7 = lVar.tIA;
            } else {
                if (lVar.tIy < this.ptb) {
                    i8 = lVar.tIy;
                } else {
                    i8 = this.ptb;
                }
                if (lVar.tIA > this.ptc) {
                    i7 = lVar.tIA;
                    i6 = i8;
                } else {
                    i7 = this.ptc;
                    i6 = i8;
                }
            }
            y yVar2 = y.vXH;
            lVar.tIH = y.a(i6, i7, recyclerView);
        }
        this.ptb = lVar.tIy;
        this.ptc = lVar.tIA;
        com.tencent.mm.plugin.finder.event.base.l lVar2 = lVar;
        AppMethodBeat.o(250804);
        return lVar2;
    }

    @Override // com.tencent.mm.plugin.finder.event.base.f
    public final /* synthetic */ b It(int i2) {
        AppMethodBeat.i(250803);
        com.tencent.mm.plugin.finder.event.base.l lVar = new com.tencent.mm.plugin.finder.event.base.l(i2);
        AppMethodBeat.o(250803);
        return lVar;
    }
}
