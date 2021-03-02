package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.s;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001a\u0010\u0017\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001a\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool;", "Landroid/arch/lifecycle/ViewModel;", "()V", "bulletSubtitleViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getBulletSubtitleViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "setBulletSubtitleViewPool", "(Landroid/support/v7/widget/RecyclerView$RecycledViewPool;)V", "commentDrawerViewPool", "getCommentDrawerViewPool", "setCommentDrawerViewPool", "foldedLayoutViewPool", "getFoldedLayoutViewPool", "setFoldedLayoutViewPool", "fullFoldedLayoutViewPool", "getFullFoldedLayoutViewPool", "setFullFoldedLayoutViewPool", "fullTimeLinePool", "getFullTimeLinePool", "gridViewPool", "getGridViewPool", "setGridViewPool", "mediaBannerViewPool", "getMediaBannerViewPool", "setMediaBannerViewPool", "staggeredViewPool", "getStaggeredViewPool", "setStaggeredViewPool", "timelinePool", "getTimelinePool", "Companion", "plugin-finder_release"})
public final class FinderRecyclerViewPool extends ViewModel {
    public static final a wuC = new a((byte) 0);
    public RecyclerView.m tLO;
    private RecyclerView.m wuA;
    public RecyclerView.m wuB;
    public final RecyclerView.m wuu;
    public final RecyclerView.m wuv;
    public RecyclerView.m wuw;
    public RecyclerView.m wux;
    public RecyclerView.m wuy;
    public RecyclerView.m wuz;

    static {
        AppMethodBeat.i(255359);
        AppMethodBeat.o(255359);
    }

    public FinderRecyclerViewPool() {
        AppMethodBeat.i(255358);
        c cVar = new c();
        cVar.aw(4, 18);
        cVar.aw(2, 6);
        cVar.aw(2003, 0);
        this.wuu = cVar;
        b bVar = new b();
        bVar.aw(4, 18);
        bVar.aw(2, 6);
        this.wuv = bVar;
        RecyclerView.m mVar = new RecyclerView.m();
        mVar.aw(2, 16);
        mVar.aw(4, 12);
        this.tLO = mVar;
        RecyclerView.m mVar2 = new RecyclerView.m();
        mVar2.aw(4, 20);
        mVar2.aw(2, 20);
        mVar2.aw(-3, 2);
        mVar2.aw(2003, 0);
        this.wuw = mVar2;
        RecyclerView.m mVar3 = new RecyclerView.m();
        mVar3.aw(4, 20);
        mVar3.aw(2, 20);
        mVar3.aw(-3, 2);
        this.wux = mVar3;
        RecyclerView.m mVar4 = new RecyclerView.m();
        s.a aVar = s.uOj;
        mVar4.aw(s.uOg, 10);
        s.a aVar2 = s.uOj;
        mVar4.aw(s.uOh, 10);
        this.wuy = mVar4;
        RecyclerView.m mVar5 = new RecyclerView.m();
        s.a aVar3 = s.uOj;
        mVar5.aw(s.uOg, 10);
        s.a aVar4 = s.uOj;
        mVar5.aw(s.uOh, 5);
        this.wuz = mVar5;
        RecyclerView.m mVar6 = new RecyclerView.m();
        mVar6.aw(4, 10);
        mVar6.aw(2, 10);
        this.wuA = mVar6;
        RecyclerView.m mVar7 = new RecyclerView.m();
        mVar7.aw(4, 10);
        this.wuB = mVar7;
        AppMethodBeat.o(255358);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool$timelinePool$1", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "plugin-finder_release"})
    public static final class c extends RecyclerView.m {
        c() {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool$fullTimeLinePool$1", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "plugin-finder_release"})
    public static final class b extends RecyclerView.m {
        b() {
        }
    }
}
