package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.convert.ab;
import com.tencent.mm.plugin.finder.convert.ag;
import com.tencent.mm.plugin.finder.convert.bz;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u0003J\"\u0010\u0012\u001a\u00020\u00132\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001eH\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "gridSpanCount", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "isSelfFlag", "", ch.COL_USERNAME, "", "(ILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;ZLjava/lang/String;)V", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getGridSpanCount", "()I", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class af extends al {
    final BaseFinderFeedLoader tFM;
    final boolean tFN;
    final String username;
    private final int vEY;

    private /* synthetic */ af() {
        this(null, false, "");
        AppMethodBeat.i(251858);
        AppMethodBeat.o(251858);
    }

    public af(BaseFinderFeedLoader baseFinderFeedLoader, boolean z, String str) {
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(251857);
        this.vEY = 3;
        this.tFM = baseFinderFeedLoader;
        this.tFN = z;
        this.username = str;
        AppMethodBeat.o(251857);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig$getLayoutManager$1", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-finder_release"})
    public static final class c extends GridLayoutManager.b {
        c() {
        }

        @Override // android.support.v7.widget.GridLayoutManager.b
        public final int bX(int i2) {
            return 1;
        }
    }

    @Override // com.tencent.mm.plugin.finder.storage.al
    public final RecyclerView.LayoutManager eS(Context context) {
        AppMethodBeat.i(251853);
        p.h(context, "context");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.vEY);
        gridLayoutManager.a(new c());
        gridLayoutManager.setItemPrefetchEnabled(true);
        GridLayoutManager gridLayoutManager2 = gridLayoutManager;
        AppMethodBeat.o(251853);
        return gridLayoutManager2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "space", "", "getSpace", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
    public static final class b extends RecyclerView.h {
        private final int tCv = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1.0f);

        b() {
            AppMethodBeat.i(251852);
            AppMethodBeat.o(251852);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(251851);
            p.h(rect, "outRect");
            p.h(view, "view");
            p.h(recyclerView, "parent");
            p.h(sVar, "state");
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager.LayoutParams");
                AppMethodBeat.o(251851);
                throw tVar;
            }
            GridLayoutManager.LayoutParams layoutParams2 = (GridLayoutManager.LayoutParams) layoutParams;
            int bw = RecyclerView.bw(view);
            if (gridLayoutManager == null) {
                p.hyc();
            }
            int ki = gridLayoutManager.ki();
            if (gridLayoutManager.kf().ac(bw, ki) == 0) {
                rect.top = this.tCv;
            }
            rect.bottom = this.tCv;
            if (layoutParams2.kk() == ki) {
                rect.left = this.tCv;
                rect.right = this.tCv;
                AppMethodBeat.o(251851);
                return;
            }
            rect.left = (int) ((((float) (ki - layoutParams2.kj())) / ((float) ki)) * ((float) this.tCv));
            rect.right = (int) ((((1.0f * ((float) this.tCv)) * ((float) (ki + 1))) / ((float) ki)) - ((float) rect.left));
            AppMethodBeat.o(251851);
        }
    }

    @Override // com.tencent.mm.plugin.finder.storage.al
    public final RecyclerView.h getItemDecoration() {
        AppMethodBeat.i(251854);
        b bVar = new b();
        AppMethodBeat.o(251854);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    public static final class a implements f {
        final /* synthetic */ kotlin.g.a.b uTz;
        final /* synthetic */ af vEZ;

        a(af afVar, kotlin.g.a.b bVar) {
            this.vEZ = afVar;
            this.uTz = bVar;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final e<?> EC(int i2) {
            com.tencent.mm.plugin.finder.convert.f fVar;
            AppMethodBeat.i(251850);
            switch (i2) {
                case -5:
                    ab abVar = new ab();
                    AppMethodBeat.o(251850);
                    return abVar;
                case -3:
                    ag agVar = new ag();
                    AppMethodBeat.o(251850);
                    return agVar;
                case 2:
                case 3001:
                    bz bzVar = new bz(this.vEZ.tFM, this.vEZ.username, this.vEZ.tFN, (byte) 0);
                    AppMethodBeat.o(251850);
                    return bzVar;
                case 4:
                case 3002:
                    bz bzVar2 = new bz(this.vEZ.tFM, this.vEZ.username, this.vEZ.tFN, (byte) 0);
                    AppMethodBeat.o(251850);
                    return bzVar2;
                default:
                    kotlin.g.a.b bVar = this.uTz;
                    if (bVar == null || (fVar = (e) bVar.invoke(Integer.valueOf(i2))) == null) {
                        y yVar = y.vXH;
                        y.dQ("FinderProfileGridLayoutConfig", i2);
                        fVar = new com.tencent.mm.plugin.finder.convert.f();
                    }
                    AppMethodBeat.o(251850);
                    return fVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.storage.al
    public final f G(kotlin.g.a.b<? super Integer, ? extends e<?>> bVar) {
        AppMethodBeat.i(251855);
        a aVar = new a(this, bVar);
        AppMethodBeat.o(251855);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.finder.storage.al
    public final RecyclerView.m f(MMActivity mMActivity) {
        AppMethodBeat.i(251856);
        p.h(mMActivity, "context");
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        RecyclerView.m mVar = ((FinderRecyclerViewPool) com.tencent.mm.ui.component.a.b(mMActivity).get(FinderRecyclerViewPool.class)).wux;
        AppMethodBeat.o(251856);
        return mVar;
    }
}
