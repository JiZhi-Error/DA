package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ab;
import com.tencent.mm.plugin.finder.convert.bb;
import com.tencent.mm.plugin.finder.convert.bc;
import com.tencent.mm.plugin.finder.feed.aj;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eJ\u0012\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0013\u001a\u00020\u000eJ\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J.\u0010\u0019\u001a\u00020\u001a2\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0018\u00010\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\"J\u000e\u0010#\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020\"J\u000e\u0010%\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;", "", "contextId", "", "clickTabContextId", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/ui/MMActivity;)V", "getClickTabContextId", "()Ljava/lang/String;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getContextId", "spanCount", "", "getSpanCount", "()I", "canFullSpan", "", "type", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getIfReachBottom", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "Landroid/content/Context;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "plugin-finder_release"})
public final class n {
    private final int att;
    private final MMActivity gte;
    private final String sGE;
    private final String sGQ;

    public /* synthetic */ n(MMActivity mMActivity) {
        this("", "", mMActivity);
        AppMethodBeat.i(251766);
        AppMethodBeat.o(251766);
    }

    private n(String str, String str2, MMActivity mMActivity) {
        p.h(str, "contextId");
        p.h(str2, "clickTabContextId");
        p.h(mMActivity, "context");
        AppMethodBeat.i(251765);
        this.sGQ = str;
        this.sGE = str2;
        this.gte = mMActivity;
        this.att = 2;
        AppMethodBeat.o(251765);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/storage/FinderLbsConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    public static final class a implements f {
        final /* synthetic */ b uTz;
        final /* synthetic */ n vDX;
        final /* synthetic */ aj.a vDY;

        public a(n nVar, aj.a aVar, b bVar) {
            this.vDX = nVar;
            this.vDY = aVar;
            this.uTz = bVar;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final e<?> EC(int i2) {
            com.tencent.mm.plugin.finder.convert.f fVar;
            AppMethodBeat.i(251764);
            switch (i2) {
                case -5:
                    ab abVar = new ab();
                    AppMethodBeat.o(251764);
                    return abVar;
                case 1001:
                    bc bcVar = new bc(this.vDY);
                    AppMethodBeat.o(251764);
                    return bcVar;
                case 1002:
                    bb bbVar = new bb();
                    AppMethodBeat.o(251764);
                    return bbVar;
                default:
                    b bVar = this.uTz;
                    if (bVar == null || (fVar = (e) bVar.invoke(Integer.valueOf(i2))) == null) {
                        y yVar = y.vXH;
                        y.dQ("FinderLbsConfig", i2);
                        fVar = new com.tencent.mm.plugin.finder.convert.f();
                    }
                    AppMethodBeat.o(251764);
                    return fVar;
            }
        }
    }
}
