package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.convert.m;
import com.tencent.mm.plugin.finder.feed.aj;
import com.tencent.mm.plugin.finder.storage.n;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J \u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0019j\b\u0012\u0004\u0012\u00020\u0002`\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;Landroid/view/View;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;)V", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"})
public final class al implements aj.b<com.tencent.mm.plugin.finder.model.c> {
    private final View hVd;
    final aj.a<com.tencent.mm.plugin.finder.model.c> tEK;
    private n tRk = new n(this.tRl);
    final MMActivity tRl;

    public al(MMActivity mMActivity, aj.a<com.tencent.mm.plugin.finder.model.c> aVar, View view) {
        p.h(mMActivity, "baseContext");
        p.h(aVar, "presenter");
        p.h(view, "parent");
        AppMethodBeat.i(244231);
        this.tRl = mMActivity;
        this.tEK = aVar;
        this.hVd = view;
        AppMethodBeat.o(244231);
    }

    @Override // com.tencent.mm.plugin.finder.feed.aj.b
    public final void ab(ArrayList<com.tencent.mm.plugin.finder.model.c> arrayList) {
        AppMethodBeat.i(244228);
        p.h(arrayList, "data");
        RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) this.hVd.findViewById(R.id.h7t);
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        Resources resources = context.getResources();
        refreshLoadMoreLayout.setLimitTopRequest(((int) resources.getDimension(R.dimen.a5g)) - ((int) resources.getDimension(R.dimen.bx)));
        refreshLoadMoreLayout.setRefreshTargetY(((int) resources.getDimension(R.dimen.cp)) - ((int) resources.getDimension(R.dimen.a5g)));
        refreshLoadMoreLayout.setDamping(1.85f);
        RecyclerView recyclerView = refreshLoadMoreLayout.getRecyclerView();
        Context context2 = this.hVd.getContext();
        p.g(context2, "parent.context");
        p.h(context2, "context");
        recyclerView.setLayoutManager(new FinderLinearLayoutManager(context2));
        Context context3 = this.hVd.getContext();
        p.g(context3, "parent.context");
        p.h(context3, "context");
        recyclerView.b(new com.tencent.mm.plugin.finder.view.decoration.b(new ColorDrawable(context3.getResources().getColor(R.color.BW_93)), (int) context3.getResources().getDimension(R.dimen.a4f)));
        aj.a<com.tencent.mm.plugin.finder.model.c> aVar = this.tEK;
        p.h(aVar, "presenter");
        recyclerView.setAdapter(new b(this, arrayList, new n.a(this.tRk, aVar, new c(this)), arrayList));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(4);
        refreshLoadMoreLayout.setActionCallback(new a(this));
        AppMethodBeat.o(244228);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$adapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "onBindFirstBodyViewHolder", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onViewAttachedToWindow", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
    public static final class b extends WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.c> {
        final /* synthetic */ ArrayList tMn;
        final /* synthetic */ al tRm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(al alVar, ArrayList arrayList, f fVar, ArrayList arrayList2) {
            super(fVar, arrayList2);
            this.tRm = alVar;
            this.tMn = arrayList;
        }

        @Override // com.tencent.mm.view.recyclerview.WxRecyclerAdapter, android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void k(RecyclerView.v vVar) {
            AppMethodBeat.i(244223);
            n((h) vVar);
            AppMethodBeat.o(244223);
        }

        @Override // com.tencent.mm.view.recyclerview.WxRecyclerAdapter
        public final void n(h hVar) {
            AppMethodBeat.i(244222);
            p.h(hVar, "holder");
            super.n(hVar);
            AppMethodBeat.o(244222);
        }

        @Override // com.tencent.mm.view.recyclerview.WxRecyclerAdapter
        public final void n(RecyclerView recyclerView) {
            AppMethodBeat.i(244224);
            p.h(recyclerView, "recyclerView");
            AppMethodBeat.o(244224);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", LocaleUtil.ITALIAN, "", "invoke"})
    static final class c extends q implements kotlin.g.a.b<Integer, e<?>> {
        final /* synthetic */ al tRm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(al alVar) {
            super(1);
            this.tRm = alVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ e<?> invoke(Integer num) {
            AppMethodBeat.i(244227);
            switch (num.intValue()) {
                case -1:
                    m mVar = new m(new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.finder.feed.al.c.AnonymousClass1 */
                        final /* synthetic */ c tRn;

                        {
                            this.tRn = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(244225);
                            aj.a<com.tencent.mm.plugin.finder.model.c> aVar = this.tRn.tRm.tEK;
                            if (aVar == null) {
                                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTimelineLbsMixPresenter");
                                AppMethodBeat.o(244225);
                                throw tVar;
                            }
                            ((ak) aVar).dcR().requestRefresh();
                            x xVar = x.SXb;
                            AppMethodBeat.o(244225);
                            return xVar;
                        }
                    }, new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.finder.feed.al.c.AnonymousClass2 */
                        final /* synthetic */ c tRn;

                        {
                            this.tRn = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(244226);
                            com.tencent.mm.plugin.finder.utils.l lVar = com.tencent.mm.plugin.finder.utils.l.vVE;
                            com.tencent.mm.plugin.finder.utils.l.g(this.tRn.tRm.tRl);
                            x xVar = x.SXb;
                            AppMethodBeat.o(244226);
                            return xVar;
                        }
                    });
                    AppMethodBeat.o(244227);
                    return mVar;
                default:
                    p.hyc();
                    AppMethodBeat.o(244227);
                    return null;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
    public static final class a extends RefreshLoadMoreLayout.a {
        final /* synthetic */ al tRm;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(al alVar) {
            this.tRm = alVar;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(244218);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            this.tRm.tEK.onRefresh();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(244218);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244219);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            super.onRefreshEnd(cVar);
            this.tRm.tEK.onRefreshEnd(cVar);
            com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.plugin.finder.report.h.a(hVar, 2, false, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.tRm.tRl).get(FinderReporterUIC.class)).dIx(), 8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(244219);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            AppMethodBeat.i(244220);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            super.cxo();
            this.tRm.tEK.onLoadMore();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(244220);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244221);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            super.a(cVar);
            com.tencent.mm.plugin.finder.report.h.a(com.tencent.mm.plugin.finder.report.h.veu, 2, false, null, 12);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(244221);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.aj.b
    public final RecyclerView getRecyclerView() {
        AppMethodBeat.i(244229);
        RecyclerView recyclerView = ((RefreshLoadMoreLayout) this.hVd.findViewById(R.id.h7t)).getRecyclerView();
        AppMethodBeat.o(244229);
        return recyclerView;
    }

    @Override // com.tencent.mm.plugin.finder.feed.aj.b
    public final RefreshLoadMoreLayout dcQ() {
        AppMethodBeat.i(244230);
        RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) this.hVd.findViewById(R.id.h7t);
        AppMethodBeat.o(244230);
        return refreshLoadMoreLayout;
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.c
    public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
        return this.tRl;
    }
}
