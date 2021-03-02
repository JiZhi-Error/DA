package com.tencent.mm.plugin.finder.event.base;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.y;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/event/base/ScrollEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "newState", "", "handleEvent", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public class i extends f {
    public i(c cVar) {
        super(cVar);
        AppMethodBeat.i(165579);
        AppMethodBeat.o(165579);
    }

    @Override // com.tencent.mm.plugin.finder.event.base.f
    public /* synthetic */ b It(int i2) {
        AppMethodBeat.i(243468);
        h Iu = Iu(i2);
        AppMethodBeat.o(243468);
        return Iu;
    }

    @Override // com.tencent.mm.plugin.finder.event.base.f
    public /* synthetic */ b g(RecyclerView recyclerView, int i2) {
        AppMethodBeat.i(243470);
        h h2 = h(recyclerView, i2);
        AppMethodBeat.o(243470);
        return h2;
    }

    public h Iu(int i2) {
        AppMethodBeat.i(243467);
        h hVar = new h(i2);
        AppMethodBeat.o(243467);
        return hVar;
    }

    public h h(RecyclerView recyclerView, int i2) {
        AppMethodBeat.i(243469);
        p.h(recyclerView, "recyclerView");
        b g2 = super.g(recyclerView, i2);
        if (g2 == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.event.base.ScrollEvent");
            AppMethodBeat.o(243469);
            throw tVar;
        }
        h hVar = (h) g2;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
            AppMethodBeat.o(243469);
            throw tVar2;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        hVar.tIx = linearLayoutManager.kt();
        hVar.tIz = linearLayoutManager.kv();
        hVar.tIy = linearLayoutManager.ks();
        hVar.tIA = linearLayoutManager.ku();
        hVar.akb = linearLayoutManager.getItemCount();
        hVar.tIB = i2;
        y yVar = y.vXH;
        y.a a2 = y.a(recyclerView, hVar.tIy, hVar.tIA, (Set) null, 8);
        hVar.tIC = a2.feedId;
        String str = a2.mediaId;
        p.h(str, "<set-?>");
        hVar.tIE = str;
        hVar.tIF = a2.feed;
        hVar.tID = a2.vXK;
        AppMethodBeat.o(243469);
        return hVar;
    }
}
