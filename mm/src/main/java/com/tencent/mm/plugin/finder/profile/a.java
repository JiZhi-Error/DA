package com.tencent.mm.plugin.finder.profile;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.convert.by;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bJ\"\u0010\f\u001a\u00020\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0018\u00010\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u0018H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "context", "Landroid/app/Activity;", "isSelfFlag", "", "(Landroid/app/Activity;Z)V", "getContext", "()Landroid/app/Activity;", "()Z", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class a extends al {
    private final Activity dKq;
    final boolean tFN;

    public a(Activity activity, boolean z) {
        p.h(activity, "context");
        AppMethodBeat.i(249976);
        this.dKq = activity;
        this.tFN = z;
        AppMethodBeat.o(249976);
    }

    @Override // com.tencent.mm.plugin.finder.storage.al
    public final RecyclerView.LayoutManager eS(Context context) {
        AppMethodBeat.i(249972);
        p.h(context, "context");
        FinderStaggeredGridLayoutManager finderStaggeredGridLayoutManager = new FinderStaggeredGridLayoutManager(2);
        finderStaggeredGridLayoutManager.setItemPrefetchEnabled(true);
        FinderStaggeredGridLayoutManager finderStaggeredGridLayoutManager2 = finderStaggeredGridLayoutManager;
        AppMethodBeat.o(249972);
        return finderStaggeredGridLayoutManager2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
    public static final class b extends RecyclerView.h {
        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(249971);
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
                AppMethodBeat.o(249971);
                throw tVar;
            } else if (((StaggeredGridLayoutManager.LayoutParams) layoutParams).mJ()) {
                rect.left = 0;
                rect.right = 0;
                rect.bottom = 0;
                rect.top = 0;
                AppMethodBeat.o(249971);
            } else {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
                    AppMethodBeat.o(249971);
                    throw tVar2;
                } else if (((StaggeredGridLayoutManager.LayoutParams) layoutParams2).kj() % 2 == 0) {
                    rect.left = dimension;
                    rect.right = dimension2;
                    rect.bottom = dimension2;
                    rect.top = dimension2;
                    AppMethodBeat.o(249971);
                } else {
                    rect.left = dimension2;
                    rect.right = dimension;
                    rect.bottom = dimension2;
                    rect.top = dimension2;
                    AppMethodBeat.o(249971);
                }
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.storage.al
    public final RecyclerView.h getItemDecoration() {
        AppMethodBeat.i(249973);
        b bVar = new b();
        AppMethodBeat.o(249973);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.profile.a$a  reason: collision with other inner class name */
    public static final class C1261a implements f {
        final /* synthetic */ kotlin.g.a.b uTz;
        final /* synthetic */ a uZh;

        C1261a(a aVar, kotlin.g.a.b bVar) {
            this.uZh = aVar;
            this.uTz = bVar;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final e<?> EC(int i2) {
            com.tencent.mm.plugin.finder.convert.f fVar;
            AppMethodBeat.i(249970);
            switch (i2) {
                case 2:
                case 4:
                case 9:
                    by byVar = new by();
                    byVar.tFI = Boolean.valueOf(this.uZh.tFN);
                    by byVar2 = byVar;
                    AppMethodBeat.o(249970);
                    return byVar2;
                default:
                    kotlin.g.a.b bVar = this.uTz;
                    if (bVar == null || (fVar = (e) bVar.invoke(Integer.valueOf(i2))) == null) {
                        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
                            RuntimeException runtimeException = new RuntimeException("type invalid");
                            AppMethodBeat.o(249970);
                            throw runtimeException;
                        }
                        Log.printInfoStack("FinderGridLayoutConfig", "type invalid", new Object[0]);
                        fVar = new com.tencent.mm.plugin.finder.convert.f();
                    }
                    AppMethodBeat.o(249970);
                    return fVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.storage.al
    public final f G(kotlin.g.a.b<? super Integer, ? extends e<?>> bVar) {
        AppMethodBeat.i(249974);
        C1261a aVar = new C1261a(this, bVar);
        AppMethodBeat.o(249974);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.finder.storage.al
    public final RecyclerView.m f(MMActivity mMActivity) {
        AppMethodBeat.i(249975);
        p.h(mMActivity, "context");
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        RecyclerView.m mVar = ((FinderRecyclerViewPool) com.tencent.mm.ui.component.a.b(mMActivity).get(FinderRecyclerViewPool.class)).wuw;
        AppMethodBeat.o(249975);
        return mVar;
    }
}
