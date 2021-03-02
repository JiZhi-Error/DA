package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.convert.ab;
import com.tencent.mm.plugin.finder.convert.ag;
import com.tencent.mm.plugin.finder.convert.al;
import com.tencent.mm.plugin.finder.convert.v;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\u0004J\"\u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0016H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderStaggeredConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "()V", "spanCount", "", "getSpanCount", "()I", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class ah extends al {
    private final int att = 2;

    @Override // com.tencent.mm.plugin.finder.storage.al
    public final RecyclerView.LayoutManager eS(Context context) {
        AppMethodBeat.i(251872);
        p.h(context, "context");
        FinderStaggeredGridLayoutManager finderStaggeredGridLayoutManager = new FinderStaggeredGridLayoutManager(this.att);
        finderStaggeredGridLayoutManager.setItemPrefetchEnabled(true);
        FinderStaggeredGridLayoutManager finderStaggeredGridLayoutManager2 = finderStaggeredGridLayoutManager;
        AppMethodBeat.o(251872);
        return finderStaggeredGridLayoutManager2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
    public static final class b extends RecyclerView.h {
        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(251871);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(rect);
            bVar.bm(view);
            bVar.bm(recyclerView);
            bVar.bm(sVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$1", "com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$android/support/v7/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V", this, bVar.axR());
            p.h(rect, "outRect");
            p.h(view, "view");
            p.h(recyclerView, "parent");
            p.h(sVar, "state");
            Context context = view.getContext();
            p.g(context, "view.context");
            int dimension = (int) context.getResources().getDimension(R.dimen.bt);
            Context context2 = view.getContext();
            p.g(context2, "view.context");
            int dimension2 = (int) context2.getResources().getDimension(R.dimen.a4l);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
                AppMethodBeat.o(251871);
                throw tVar;
            }
            if (((StaggeredGridLayoutManager.LayoutParams) layoutParams).mJ()) {
                rect.left = 0;
                rect.right = 0;
                rect.bottom = 0;
                rect.top = 0;
            } else {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
                    AppMethodBeat.o(251871);
                    throw tVar2;
                } else if (((StaggeredGridLayoutManager.LayoutParams) layoutParams2).kj() % 2 == 0) {
                    rect.left = dimension;
                    rect.right = dimension2;
                    rect.bottom = dimension2;
                    rect.top = dimension2;
                } else {
                    rect.left = dimension2;
                    rect.right = dimension;
                    rect.bottom = dimension2;
                    rect.top = dimension2;
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$1", "com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$android/support/v7/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V");
            AppMethodBeat.o(251871);
        }
    }

    @Override // com.tencent.mm.plugin.finder.storage.al
    public final RecyclerView.h getItemDecoration() {
        AppMethodBeat.i(251873);
        b bVar = new b();
        AppMethodBeat.o(251873);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    public static final class a implements f {
        final /* synthetic */ kotlin.g.a.b uTz;
        final /* synthetic */ ah vFi;

        a(ah ahVar, kotlin.g.a.b bVar) {
            this.vFi = ahVar;
            this.uTz = bVar;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final e<?> EC(int i2) {
            com.tencent.mm.plugin.finder.convert.f fVar;
            AppMethodBeat.i(251870);
            switch (i2) {
                case -5:
                    ab abVar = new ab();
                    AppMethodBeat.o(251870);
                    return abVar;
                case -3:
                    ag agVar = new ag();
                    AppMethodBeat.o(251870);
                    return agVar;
                case 2:
                case 3001:
                    v vVar = new v();
                    AppMethodBeat.o(251870);
                    return vVar;
                case 4:
                case 9:
                case 3002:
                    al alVar = new al();
                    AppMethodBeat.o(251870);
                    return alVar;
                default:
                    kotlin.g.a.b bVar = this.uTz;
                    if (bVar == null || (fVar = (e) bVar.invoke(Integer.valueOf(i2))) == null) {
                        y yVar = y.vXH;
                        y.dQ("FinderStaggeredConfig", i2);
                        fVar = new com.tencent.mm.plugin.finder.convert.f();
                    }
                    AppMethodBeat.o(251870);
                    return fVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.storage.al
    public final f G(kotlin.g.a.b<? super Integer, ? extends e<?>> bVar) {
        AppMethodBeat.i(251874);
        a aVar = new a(this, bVar);
        AppMethodBeat.o(251874);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.finder.storage.al
    public final RecyclerView.m f(MMActivity mMActivity) {
        AppMethodBeat.i(251875);
        p.h(mMActivity, "context");
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        RecyclerView.m mVar = ((FinderRecyclerViewPool) com.tencent.mm.ui.component.a.b(mMActivity).get(FinderRecyclerViewPool.class)).wuw;
        AppMethodBeat.o(251875);
        return mVar;
    }
}
