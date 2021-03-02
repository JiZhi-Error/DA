package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.convert.f;
import com.tencent.mm.plugin.finder.feed.aq;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.ah;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001)B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J \u0010$\u001a\u00020%2\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00110'j\b\u0012\u0004\u0012\u00020\u0011`(H\u0016R\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "parent", "Landroid/view/View;", "fragment", "Landroid/support/v4/app/Fragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;Landroid/view/View;Landroid/support/v4/app/Fragment;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRootView", "getWxRecyclerAdapter", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "SpacesItemDecoration", "plugin-finder_release"})
public final class as implements aq.b {
    final String TAG = "FinderTimelineMachineContract.ViewCallback";
    private final Fragment fragment;
    private final View hVd;
    public WxRecyclerAdapter<bo> tFp;
    private al tMj = new ah();
    final aq.a tRT;
    final MMActivity tRl;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", LocaleUtil.ITALIAN, "", "invoke"})
    static final class a extends q implements kotlin.g.a.b<Integer, e<?>> {
        final /* synthetic */ as tRU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(as asVar) {
            super(1);
            this.tRU = asVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ e<?> invoke(Integer num) {
            AppMethodBeat.i(244331);
            int intValue = num.intValue();
            switch (intValue) {
                case -6:
                    com.tencent.mm.plugin.finder.convert.ah ahVar = new com.tencent.mm.plugin.finder.convert.ah(this.tRU);
                    AppMethodBeat.o(244331);
                    return ahVar;
                default:
                    y yVar = y.vXH;
                    y.dQ(this.tRU.TAG, intValue);
                    f fVar = new f();
                    AppMethodBeat.o(244331);
                    return fVar;
            }
        }
    }

    public as(MMActivity mMActivity, aq.a aVar, View view, Fragment fragment2) {
        p.h(mMActivity, "baseContext");
        p.h(aVar, "presenter");
        p.h(view, "parent");
        AppMethodBeat.i(244341);
        this.tRl = mMActivity;
        this.tRT = aVar;
        this.hVd = view;
        this.fragment = fragment2;
        AppMethodBeat.o(244341);
    }

    @Override // com.tencent.mm.plugin.finder.feed.aq.b
    public final void ab(ArrayList<bo> arrayList) {
        AppMethodBeat.i(244337);
        p.h(arrayList, "data");
        RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) this.hVd.findViewById(R.id.h7t);
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        Resources resources = context.getResources();
        refreshLoadMoreLayout.setLimitTopRequest(((int) resources.getDimension(R.dimen.a5g)) - ((int) resources.getDimension(R.dimen.bx)));
        refreshLoadMoreLayout.setRefreshTargetY(((int) resources.getDimension(R.dimen.cp)) - ((int) resources.getDimension(R.dimen.a5g)));
        refreshLoadMoreLayout.setDamping(1.85f);
        RecyclerView recyclerView = refreshLoadMoreLayout.getRecyclerView();
        recyclerView.setRecycledViewPool(this.tMj.f(this.tRl));
        this.tFp = new WxRecyclerAdapter<>(this.tMj.G(new a(this)), arrayList);
        al alVar = this.tMj;
        Context context2 = this.hVd.getContext();
        p.g(context2, "parent.context");
        recyclerView.setLayoutManager(alVar.eS(context2));
        recyclerView.b(this.tMj.getItemDecoration());
        for (T t : this.tRT.getHeaderInfo()) {
            WxRecyclerAdapter<bo> wxRecyclerAdapter = this.tFp;
            if (wxRecyclerAdapter == null) {
                p.btv("adapter");
            }
            wxRecyclerAdapter.a((g) t, (g.b) true);
        }
        WxRecyclerAdapter<bo> wxRecyclerAdapter2 = this.tFp;
        if (wxRecyclerAdapter2 == null) {
            p.btv("adapter");
        }
        wxRecyclerAdapter2.RqP = new b(this, arrayList);
        WxRecyclerAdapter<bo> wxRecyclerAdapter3 = this.tFp;
        if (wxRecyclerAdapter3 == null) {
            p.btv("adapter");
        }
        recyclerView.setAdapter(wxRecyclerAdapter3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(4);
        refreshLoadMoreLayout.setActionCallback(new c(this));
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.event.base.f MC = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.tRl).get(FinderReporterUIC.class)).MC(4);
        if (MC != null) {
            MC.m(refreshLoadMoreLayout.getRecyclerView());
            AppMethodBeat.o(244337);
            return;
        }
        AppMethodBeat.o(244337);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
    public static final class b implements g.c<h> {
        final /* synthetic */ ArrayList tMn;
        final /* synthetic */ as tRU;

        b(as asVar, ArrayList arrayList) {
            this.tRU = asVar;
            this.tMn = arrayList;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
        @Override // com.tencent.mm.view.recyclerview.g.c
        public final /* synthetic */ void a(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
            AppMethodBeat.i(244332);
            p.h(aVar, "adapter");
            p.h(view, "view");
            p.h(hVar, "holder");
            int size = ((WxRecyclerAdapter) aVar).RqM.size();
            if (i2 >= size) {
                Object obj = this.tMn.get(i2 - size);
                p.g(obj, "data[position - headCount]");
                bo boVar = (bo) obj;
                if (boVar instanceof BaseFinderFeed) {
                    Intent intent = new Intent();
                    intent.putExtra("FEED_ID", ((BaseFinderFeed) boVar).feedObject.getId());
                    FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                    FinderReporterUIC.a.a(this.tRU.tRl, intent, 0, 0, false, 124);
                    com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    com.tencent.mm.plugin.finder.utils.a.X(this.tRU.tRl, intent);
                }
            }
            AppMethodBeat.o(244332);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
    public static final class c extends RefreshLoadMoreLayout.a {
        final /* synthetic */ as tRU;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(as asVar) {
            this.tRU = asVar;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(244333);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            this.tRU.tRT.onRefresh();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(244333);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244334);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            super.onRefreshEnd(cVar);
            this.tRU.tRT.onRefreshEnd(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(244334);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            AppMethodBeat.i(244335);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            super.cxo();
            this.tRU.tRT.onLoadMore();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(244335);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244336);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            super.a(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(244336);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.aq.b
    public final RecyclerView getRecyclerView() {
        AppMethodBeat.i(244338);
        RecyclerView recyclerView = ((RefreshLoadMoreLayout) this.hVd.findViewById(R.id.h7t)).getRecyclerView();
        AppMethodBeat.o(244338);
        return recyclerView;
    }

    @Override // com.tencent.mm.plugin.finder.feed.aq.b
    public final WxRecyclerAdapter<bo> dcT() {
        AppMethodBeat.i(244339);
        WxRecyclerAdapter<bo> wxRecyclerAdapter = this.tFp;
        if (wxRecyclerAdapter == null) {
            p.btv("adapter");
        }
        AppMethodBeat.o(244339);
        return wxRecyclerAdapter;
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.b
    public final View getRootView() {
        return this.hVd;
    }

    @Override // com.tencent.mm.plugin.finder.feed.aq.b
    public final RefreshLoadMoreLayout dcQ() {
        AppMethodBeat.i(244340);
        RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) this.hVd.findViewById(R.id.h7t);
        p.g(refreshLoadMoreLayout, "parent.rl_layout");
        AppMethodBeat.o(244340);
        return refreshLoadMoreLayout;
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.c
    public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
        return this.tRl;
    }
}
