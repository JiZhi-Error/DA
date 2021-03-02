package com.tencent.mm.plugin.finder.live.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkView;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002&'B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00132\b\u0010\b\u001a\u0004\u0018\u00010\tJ\b\u0010\u001a\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018H\u0016J\u0014\u0010#\u001a\u00020\u00132\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00100%R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyPageAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyPageAdapter$ApplyLinkViewHolder;", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "(Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;)V", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "pageList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkView;", "Lkotlin/collections/ArrayList;", "dispatchHidePanel", "", "dispatchKeyboardChange", "show", "", "height", "", "dispatchUpdateLinkList", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateData", "data", "", "ApplyLinkViewHolder", "Companion", "plugin-finder_release"})
public final class j extends RecyclerView.a<a> {
    private static final int UNZ = 0;
    private static final int UOa = 1;
    public static final b UOb = new b((byte) 0);
    public final ArrayList<FinderLiveApplyLinkView> jmY = new ArrayList<>();
    public g liveData;
    private final s ujx;

    public j(s sVar) {
        AppMethodBeat.i(260886);
        this.ujx = sVar;
        AppMethodBeat.o(260886);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        a aVar;
        AppMethodBeat.i(260883);
        p.h(viewGroup, "parent");
        if (i2 == UNZ) {
            FinderLiveApplyLinkView finderLiveApplyLinkView = this.jmY.get(0);
            p.g(finderLiveApplyLinkView, "pageList[0]");
            aVar = new a(finderLiveApplyLinkView);
        } else {
            FinderLiveApplyLinkView finderLiveApplyLinkView2 = this.jmY.get(1);
            p.g(finderLiveApplyLinkView2, "pageList[1]");
            aVar = new a(finderLiveApplyLinkView2);
        }
        a aVar2 = aVar;
        AppMethodBeat.o(260883);
        return aVar2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(260885);
        a aVar2 = aVar;
        p.h(aVar2, "holder");
        aVar2.UOc.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        aVar2.UOc.a(this.liveData, this.ujx);
        AppMethodBeat.o(260885);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyPageAdapter$Companion;", "", "()V", "PAGE_TYPE_ANCHOR", "", "getPAGE_TYPE_ANCHOR", "()I", "PAGE_TYPE_VISITOR", "getPAGE_TYPE_VISITOR", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(260887);
        AppMethodBeat.o(260887);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        switch (i2) {
            case 0:
                return UNZ;
            case 1:
                return UOa;
            default:
                return -1;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(260884);
        int size = this.jmY.size();
        AppMethodBeat.o(260884);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyPageAdapter$ApplyLinkViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "pageView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkView;", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkView;)V", "getPageView", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkView;", "plugin-finder_release"})
    public static final class a extends RecyclerView.v {
        final FinderLiveApplyLinkView UOc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FinderLiveApplyLinkView finderLiveApplyLinkView) {
            super(finderLiveApplyLinkView);
            p.h(finderLiveApplyLinkView, "pageView");
            AppMethodBeat.i(260882);
            this.UOc = finderLiveApplyLinkView;
            AppMethodBeat.o(260882);
        }
    }
}
