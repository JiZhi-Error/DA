package com.tencent.mm.plugin.finder.nearby.live;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.convert.ab;
import com.tencent.mm.plugin.finder.convert.ag;
import com.tencent.mm.plugin.finder.convert.al;
import com.tencent.mm.plugin.finder.convert.co;
import com.tencent.mm.plugin.finder.convert.v;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.nearby.live.b;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003%&'B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0017\u001a\u00020\u0004H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0002J \u0010\u001f\u001a\u00020\u001e2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00020!j\b\u0012\u0004\u0012\u00020\u0002`\"H\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J \u0010$\u001a\u00020\u001e2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00020!j\b\u0012\u0004\u0012\u00020\u0002`\"H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R#\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0013\u001a\n \u000e*\u0004\u0018\u00010\b0\b8BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0014\u0010\u0015¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "parent", "Landroid/view/View;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;Landroid/view/View;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "Lkotlin/Lazy;", "rootScroll", "getRootScroll", "()Landroid/view/View;", "rootScroll$delegate", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "getRootScrollParent", "gotoMoreLivePage", "", "initRecyclerView", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "initRefreshLayout", "initView", "Companion", "NearbyLiveItemConvertFactory", "NearbyLiveItemDecoration", "plugin-finder_release"})
public class e implements b.AbstractC1238b<bo> {
    public static final a uRp = new a((byte) 0);
    private final View hVd;
    final MMActivity tRl;
    private final kotlin.f tSX = kotlin.g.ah(new j(this));
    private final bbn ttO;
    private final kotlin.f uRn = kotlin.g.ah(new k(this));
    private final b.a<bo> uRo;

    static {
        AppMethodBeat.i(249146);
        AppMethodBeat.o(249146);
    }

    private final View dls() {
        AppMethodBeat.i(249144);
        View view = (View) this.uRn.getValue();
        AppMethodBeat.o(249144);
        return view;
    }

    private final RefreshLoadMoreLayout getRlLayout() {
        AppMethodBeat.i(249143);
        RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) this.tSX.getValue();
        AppMethodBeat.o(249143);
        return refreshLoadMoreLayout;
    }

    public e(MMActivity mMActivity, b.a<bo> aVar, View view, bbn bbn) {
        p.h(mMActivity, "baseContext");
        p.h(aVar, "presenter");
        p.h(view, "parent");
        p.h(bbn, "contextObj");
        AppMethodBeat.i(249145);
        this.tRl = mMActivity;
        this.uRo = aVar;
        this.hVd = view;
        this.ttO = bbn;
        AppMethodBeat.o(249145);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.nearby.live.b.AbstractC1238b
    public final View dlo() {
        AppMethodBeat.i(249140);
        View dls = dls();
        p.g(dls, "rootScroll");
        AppMethodBeat.o(249140);
        return dls;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.live.b.AbstractC1238b
    public final RecyclerView getRecyclerView() {
        AppMethodBeat.i(249141);
        RefreshLoadMoreLayout rlLayout = getRlLayout();
        if (rlLayout != null) {
            RecyclerView recyclerView = rlLayout.getRecyclerView();
            AppMethodBeat.o(249141);
            return recyclerView;
        }
        AppMethodBeat.o(249141);
        return null;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.live.b.AbstractC1238b
    public final RefreshLoadMoreLayout dcQ() {
        AppMethodBeat.i(249142);
        RefreshLoadMoreLayout rlLayout = getRlLayout();
        p.g(rlLayout, "rlLayout");
        AppMethodBeat.o(249142);
        return rlLayout;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h implements View.OnClickListener {
        final /* synthetic */ e uRr;

        h(e eVar) {
            this.uRr = eVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(249132);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            e.a(this.uRr);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(249132);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
    public static final class i extends RefreshLoadMoreLayout.a {
        final /* synthetic */ e uRr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(e eVar) {
            this.uRr = eVar;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(249133);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            Log.i("NearbyLiveViewCallback", "onRefreshBegin");
            super.ED(i2);
            this.uRr.uRo.onRefresh();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(249133);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(249134);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            Log.i("NearbyLiveViewCallback", "onRefreshEnd");
            super.onRefreshEnd(cVar);
            this.uRr.uRo.onRefreshEnd(cVar);
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            RecyclerView recyclerView = this.uRr.getRecyclerView();
            s.p pVar = s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD;
            com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.a(recyclerView, pVar, com.tencent.mm.plugin.finder.report.live.k.dpl().vlS, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_REFRESH, -100, -100);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(249134);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            AppMethodBeat.i(249135);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            Log.i("NearbyLiveViewCallback", "onLoadMoreBegin");
            super.cxo();
            this.uRr.uRo.onLoadMore();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(249135);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(249136);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            Log.i("NearbyLiveViewCallback", "onLoadMoreEnd");
            super.a(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(249136);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRecyclerView$adapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
    public static final class g extends WxRecyclerAdapter<bo> {
        final /* synthetic */ ArrayList tMn;
        final /* synthetic */ e uRr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(e eVar, ArrayList arrayList, com.tencent.mm.view.recyclerview.f fVar, ArrayList arrayList2) {
            super(fVar, arrayList2);
            this.uRr = eVar;
            this.tMn = arrayList;
        }

        @Override // com.tencent.mm.view.recyclerview.WxRecyclerAdapter, android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void k(RecyclerView.v vVar) {
            AppMethodBeat.i(249131);
            n((com.tencent.mm.view.recyclerview.h) vVar);
            AppMethodBeat.o(249131);
        }

        @Override // com.tencent.mm.view.recyclerview.WxRecyclerAdapter
        public final void n(com.tencent.mm.view.recyclerview.h hVar) {
            AppMethodBeat.i(249130);
            p.h(hVar, "holder");
            super.n(hVar);
            View view = hVar.aus;
            p.g(view, "holder.itemView");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).aC(hVar.lU() == -1 || hVar.lU() == -9 || hVar.lU() == -10);
            }
            AppMethodBeat.o(249130);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRecyclerView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
    public static final class d implements g.c<com.tencent.mm.view.recyclerview.h> {
        final /* synthetic */ ArrayList tMn;
        final /* synthetic */ e uRr;

        d(e eVar, ArrayList arrayList) {
            this.uRr = eVar;
            this.tMn = arrayList;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
        @Override // com.tencent.mm.view.recyclerview.g.c
        public final /* synthetic */ void a(RecyclerView.a<com.tencent.mm.view.recyclerview.h> aVar, View view, int i2, com.tencent.mm.view.recyclerview.h hVar) {
            String str;
            AppMethodBeat.i(249126);
            p.h(aVar, "adapter");
            p.h(view, "view");
            p.h(hVar, "holder");
            int size = ((WxRecyclerAdapter) aVar).RqM.size();
            if (i2 >= size) {
                Object obj = this.tMn.get(i2 - size);
                p.g(obj, "data[position - headCount]");
                bo boVar = (bo) obj;
                com.tencent.mm.plugin.finder.nearby.report.d dVar = com.tencent.mm.plugin.finder.nearby.report.d.uTq;
                String acj = com.tencent.mm.plugin.finder.nearby.report.d.acj();
                String str2 = this.uRr.ttO.sGE;
                if (str2 == null) {
                    str = "";
                } else {
                    str = str2;
                }
                p.g(str, "contextObj.clickTabContextId ?: \"\"");
                if (boVar == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                    AppMethodBeat.o(249126);
                    throw tVar;
                }
                BaseFinderFeed baseFinderFeed = (BaseFinderFeed) boVar;
                y yVar = y.vXH;
                if (y.w(baseFinderFeed)) {
                    s.p pVar = s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM;
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.vkd.a((BaseFinderFeed) boVar, (long) i2, pVar, com.tencent.mm.plugin.finder.report.live.k.dpl().vlS);
                    if (Util.isEqual(((BaseFinderFeed) boVar).feedObject.getUserName(), z.aUg())) {
                        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        MMActivity mMActivity = this.uRr.tRl;
                        long id = ((BaseFinderFeed) boVar).feedObject.getId();
                        String objectNonceId = ((BaseFinderFeed) boVar).feedObject.getObjectNonceId();
                        awe liveInfo = ((BaseFinderFeed) boVar).feedObject.getLiveInfo();
                        if (liveInfo == null) {
                            liveInfo = new awe();
                        }
                        com.tencent.mm.plugin.finder.utils.a.a(mMActivity, id, objectNonceId, liveInfo, false, null, null, null, null, null, baseFinderFeed.getSessionBuffer(), null, null, 14320);
                        AppMethodBeat.o(249126);
                        return;
                    }
                    com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(aj.class);
                    p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
                    af finderUtilApi = ((aj) ah).getFinderUtilApi();
                    p.g(finderUtilApi, "MMKernel.plugin(IPluginF…class.java).finderUtilApi");
                    if (finderUtilApi.dDg()) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(boVar);
                        com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        m mVar = m.vVH;
                        com.tencent.mm.plugin.finder.utils.a.a(this.uRr.tRl, m.a(arrayList, boVar, this.uRr.ttO.tCE), acj, str, (Intent) null, 16);
                        AppMethodBeat.o(249126);
                        return;
                    }
                    com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    m mVar2 = m.vVH;
                    com.tencent.mm.plugin.finder.utils.a.a(this.uRr.tRl, m.a(this.tMn, boVar, 1001, this.uRr.ttO.tCE), acj, str, (Intent) null, 16);
                }
            }
            AppMethodBeat.o(249126);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRecyclerView$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemLongClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.nearby.live.e$e  reason: collision with other inner class name */
    public static final class C1243e implements g.d<com.tencent.mm.view.recyclerview.h> {
        final /* synthetic */ ArrayList tMn;

        C1243e(ArrayList arrayList) {
            this.tMn = arrayList;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x006e  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x007e  */
        @Override // com.tencent.mm.view.recyclerview.g.d
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean b(android.support.v7.widget.RecyclerView.a<com.tencent.mm.view.recyclerview.h> r10, android.view.View r11, int r12, com.tencent.mm.view.recyclerview.h r13) {
            /*
            // Method dump skipped, instructions count: 272
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.nearby.live.e.C1243e.b(android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v):boolean");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0006H\u0016J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRecyclerView$5", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onExposeTimeRecorded", "", "recordsSet", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "onItemExposeStart", "item", "plugin-finder_release"})
    public static final class f extends com.tencent.mm.view.recyclerview.d<com.tencent.mm.view.recyclerview.a> {
        final /* synthetic */ e uRr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(e eVar) {
            this.uRr = eVar;
        }

        @Override // com.tencent.mm.view.recyclerview.d
        public final void l(Set<com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a>> set) {
            AppMethodBeat.i(249128);
            p.h(set, "recordsSet");
            Log.i("NearbyLiveViewCallback", "onExposeTimeRecorded: size = " + set.size());
            LinkedList linkedList = new LinkedList();
            for (T t : set) {
                if (t.RqA instanceof w) {
                    cmm cmm = new cmm();
                    T t2 = t.RqA;
                    if (t2 == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FinderFeedLive");
                        AppMethodBeat.o(249128);
                        throw tVar;
                    }
                    w wVar = (w) t2;
                    cmm.hFK = wVar.lT();
                    as asVar = as.uOL;
                    as.a(cmm, this.uRr.uRo.getCommentScene());
                    cmm.MrJ = (int) t.wVY;
                    cmm.sessionBuffer = wVar.getSessionBuffer();
                    linkedList.add(cmm);
                    Log.d("NearbyLiveViewCallback", "onExposeTimeRecorded pos:" + t.Qgj + " exposeTime:" + t.wVY + " nick:" + wVar.feedObject.getFeedObject().nickname);
                } else {
                    Log.d("NearbyLiveViewCallback", "onExposeTimeRecorded pos:" + t.Qgj + " exposeTime:" + t.wVY);
                }
            }
            com.tencent.mm.plugin.finder.nearby.report.c cVar = com.tencent.mm.plugin.finder.nearby.report.c.uTk;
            com.tencent.mm.plugin.finder.nearby.report.c.i(this.uRr.uRo.getCommentScene(), linkedList);
            as asVar2 = as.uOL;
            as.ar(linkedList);
            AppMethodBeat.o(249128);
        }

        @Override // com.tencent.mm.view.recyclerview.d
        public final void a(com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a> bVar) {
            AppMethodBeat.i(249129);
            p.h(bVar, "item");
            if (bVar.RqA instanceof w) {
                cmm cmm = new cmm();
                T t = bVar.RqA;
                if (t == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FinderFeedLive");
                    AppMethodBeat.o(249129);
                    throw tVar;
                }
                w wVar = (w) t;
                cmm.hFK = wVar.lT();
                cmm.MrJ = (int) bVar.startTime;
                as asVar = as.uOL;
                as.a(cmm, this.uRr.uRo.getCommentScene());
                com.tencent.mm.plugin.finder.nearby.report.c cVar = com.tencent.mm.plugin.finder.nearby.report.c.uTk;
                com.tencent.mm.plugin.finder.nearby.report.c.a(this.uRr.uRo.getCommentScene(), cmm);
                Log.d("NearbyLiveViewCallback", "onItemExposeStart id:" + cmm.hFK + " nick:" + wVar.feedObject.getFeedObject().nickname);
            }
            AppMethodBeat.o(249129);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$NearbyLiveItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
    public static final class c extends RecyclerView.h {
        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(249125);
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
                AppMethodBeat.o(249125);
                throw tVar;
            } else if (((StaggeredGridLayoutManager.LayoutParams) layoutParams).mJ()) {
                rect.left = 0;
                rect.right = 0;
                rect.bottom = 0;
                rect.top = 0;
                AppMethodBeat.o(249125);
            } else {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
                    AppMethodBeat.o(249125);
                    throw tVar2;
                } else if (((StaggeredGridLayoutManager.LayoutParams) layoutParams2).kj() % 2 == 0) {
                    rect.left = dimension;
                    rect.right = dimension2;
                    rect.bottom = dimension2;
                    rect.top = dimension2;
                    AppMethodBeat.o(249125);
                } else {
                    rect.left = dimension2;
                    rect.right = dimension;
                    rect.bottom = dimension2;
                    rect.top = dimension2;
                    AppMethodBeat.o(249125);
                }
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0014\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$NearbyLiveItemConvertFactory;", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;)V", "bindLive", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "bindMedia", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    public static final class b implements com.tencent.mm.view.recyclerview.f {
        final MMActivity tRl;
        final b.a<bo> uRo;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "invoke"})
        static final class d extends q implements kotlin.g.a.b<View, x> {
            final /* synthetic */ b uRq;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(b bVar) {
                super(1);
                this.uRq = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(View view) {
                AppMethodBeat.i(249119);
                p.h(view, LocaleUtil.ITALIAN);
                y yVar = y.vXH;
                if (!y.isFastClick()) {
                    com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                    com.tencent.mm.plugin.finder.utils.a.Z(this.uRq.tRl, new Intent());
                }
                x xVar = x.SXb;
                AppMethodBeat.o(249119);
                return xVar;
            }
        }

        public b(MMActivity mMActivity, b.a<bo> aVar) {
            p.h(mMActivity, "baseContext");
            p.h(aVar, "presenter");
            AppMethodBeat.i(249123);
            this.tRl = mMActivity;
            this.uRo = aVar;
            AppMethodBeat.o(249123);
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(249122);
            switch (i2) {
                case -10:
                    com.tencent.mm.plugin.finder.convert.af afVar = new com.tencent.mm.plugin.finder.convert.af(new d(this));
                    AppMethodBeat.o(249122);
                    return afVar;
                case -5:
                    ab abVar = new ab();
                    AppMethodBeat.o(249122);
                    return abVar;
                case -3:
                    ag agVar = new ag();
                    AppMethodBeat.o(249122);
                    return agVar;
                case -1:
                    com.tencent.mm.plugin.finder.convert.m mVar = new com.tencent.mm.plugin.finder.convert.m(new C1242e(this), new f(this));
                    AppMethodBeat.o(249122);
                    return mVar;
                case 2:
                case 3001:
                    C1241b bVar = new C1241b(this);
                    AppMethodBeat.o(249122);
                    return bVar;
                case 4:
                case 3002:
                    a aVar = new a(this);
                    AppMethodBeat.o(249122);
                    return aVar;
                case 9:
                    c cVar = new c(this);
                    AppMethodBeat.o(249122);
                    return cVar;
                default:
                    if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
                        RuntimeException runtimeException = new RuntimeException("type invalid");
                        AppMethodBeat.o(249122);
                        throw runtimeException;
                    }
                    Log.printInfoStack("RecyclerViewAdapterEx", "type invalid", new Object[0]);
                    com.tencent.mm.plugin.finder.convert.f fVar = new com.tencent.mm.plugin.finder.convert.f();
                    AppMethodBeat.o(249122);
                    return fVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$NearbyLiveItemConvertFactory$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
        public static final class a extends al {
            final /* synthetic */ b uRq;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            a(b bVar) {
                this.uRq = bVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
            @Override // com.tencent.mm.plugin.finder.convert.ae, com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.finder.convert.al
            public final /* bridge */ /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List list) {
                AppMethodBeat.i(249114);
                a(hVar, baseFinderFeed, i2, i3, z, (List<Object>) list);
                AppMethodBeat.o(249114);
            }

            @Override // com.tencent.mm.plugin.finder.convert.ae, com.tencent.mm.plugin.finder.convert.al
            public final void a(com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List<Object> list) {
                AppMethodBeat.i(249113);
                p.h(hVar, "holder");
                p.h(baseFinderFeed, "item");
                super.a(hVar, baseFinderFeed, i2, i3, z, list);
                b.k(hVar, baseFinderFeed);
                AppMethodBeat.o(249113);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$NearbyLiveItemConvertFactory$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.nearby.live.e$b$b  reason: collision with other inner class name */
        public static final class C1241b extends v {
            final /* synthetic */ b uRq;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            C1241b(b bVar) {
                this.uRq = bVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
            @Override // com.tencent.mm.plugin.finder.convert.ae, com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.finder.convert.v
            public final /* bridge */ /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List list) {
                AppMethodBeat.i(249116);
                a(hVar, baseFinderFeed, i2, i3, z, (List<Object>) list);
                AppMethodBeat.o(249116);
            }

            @Override // com.tencent.mm.plugin.finder.convert.ae, com.tencent.mm.plugin.finder.convert.v
            public final void a(com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List<Object> list) {
                AppMethodBeat.i(249115);
                p.h(hVar, "holder");
                p.h(baseFinderFeed, "item");
                super.a(hVar, baseFinderFeed, i2, i3, z, list);
                b.k(hVar, baseFinderFeed);
                AppMethodBeat.o(249115);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$NearbyLiveItemConvertFactory$getItemConvert$3", "Lcom/tencent/mm/plugin/finder/convert/NearbyLiveFeedsConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
        public static final class c extends co {
            final /* synthetic */ b uRq;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            c(b bVar) {
                this.uRq = bVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
            @Override // com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.finder.convert.co
            public final /* bridge */ /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List list) {
                AppMethodBeat.i(249118);
                a(hVar, baseFinderFeed, i2, i3, z, (List<Object>) list);
                AppMethodBeat.o(249118);
            }

            @Override // com.tencent.mm.plugin.finder.convert.co
            public final void a(com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List<Object> list) {
                int i4;
                AppMethodBeat.i(249117);
                p.h(hVar, "holder");
                p.h(baseFinderFeed, "item");
                super.a(hVar, baseFinderFeed, i2, i3, z, list);
                View Mn = hVar.Mn(R.id.cw9);
                TextView textView = (TextView) hVar.Mn(R.id.gtz);
                TextView textView2 = (TextView) hVar.Mn(R.id.jj_);
                awe liveInfo = baseFinderFeed.feedObject.getLiveInfo();
                if (liveInfo != null && liveInfo.liveStatus == 1) {
                    p.g(Mn, "liveOnLineLayout");
                    Mn.setVisibility(0);
                    String str = baseFinderFeed.feedObject.getFeedObject().recommendReason;
                    if (str == null) {
                        str = "";
                    }
                    p.g(str, "item.feedObject.feedObject.recommendReason ?: \"\"");
                    if (TextUtils.isEmpty(str)) {
                        Mn.setVisibility(8);
                    } else {
                        p.g(textView, "recReasonTv");
                        textView.setText(str);
                        Mn.setVisibility(0);
                    }
                    awe liveInfo2 = baseFinderFeed.feedObject.getLiveInfo();
                    if (liveInfo2 != null) {
                        i4 = liveInfo2.LCy;
                    } else {
                        i4 = 0;
                    }
                    if (i4 > 0) {
                        p.g(textView2, "watchCountHistoryTv");
                        y yVar = y.vXH;
                        textView2.setText(String.valueOf(y.LT(i4)));
                        textView2.setVisibility(0);
                    } else {
                        p.g(textView2, "watchCountHistoryTv");
                        textView2.setVisibility(8);
                    }
                }
                TextView textView3 = (TextView) hVar.Mn(R.id.cl2);
                p.g(textView3, "descTv");
                textView3.setVisibility(8);
                AppMethodBeat.o(249117);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.nearby.live.e$b$e  reason: collision with other inner class name */
        static final class C1242e extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ b uRq;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1242e(b bVar) {
                super(0);
                this.uRq = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(249120);
                b.a<bo> aVar = this.uRq.uRo;
                if (aVar == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.live.NearbyLivePresenter");
                    AppMethodBeat.o(249120);
                    throw tVar;
                }
                NearbyLiveFeedLoader nearbyLiveFeedLoader = ((d) aVar).uQU;
                if (nearbyLiveFeedLoader == null) {
                    p.hyc();
                }
                nearbyLiveFeedLoader.requestRefresh();
                x xVar = x.SXb;
                AppMethodBeat.o(249120);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class f extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ b uRq;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(b bVar) {
                super(0);
                this.uRq = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(249121);
                com.tencent.mm.plugin.finder.utils.l lVar = com.tencent.mm.plugin.finder.utils.l.vVE;
                com.tencent.mm.plugin.finder.utils.l.g(this.uRq.tRl);
                x xVar = x.SXb;
                AppMethodBeat.o(249121);
                return xVar;
            }
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public static final /* synthetic */ void k(com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed) {
            String str;
            AppMethodBeat.i(249124);
            View Mn = hVar.Mn(R.id.cml);
            ImageView imageView = (ImageView) hVar.Mn(R.id.ebf);
            TextView textView = (TextView) hVar.Mn(R.id.eba);
            p.g(Mn, "likeContainer");
            Mn.setVisibility(8);
            p.g(textView, "likeTv");
            String str2 = baseFinderFeed.feedObject.getFeedObject().recommendReason;
            if (str2 != null) {
                str = str2;
            }
            textView.setText(str);
            switch (baseFinderFeed.feedObject.getFeedObject().recommendReasonType) {
                case 1:
                    Mn.setVisibility(0);
                    Context context = hVar.getContext();
                    Context context2 = hVar.getContext();
                    p.g(context2, "holder.context");
                    imageView.setImageDrawable(ar.m(context, R.raw.icons_filled_location, context2.getResources().getColor(R.color.am)));
                    p.g(imageView, "likeIv");
                    imageView.setVisibility(0);
                    AppMethodBeat.o(249124);
                    return;
                case 9:
                    Mn.setVisibility(0);
                    Context context3 = hVar.getContext();
                    Context context4 = hVar.getContext();
                    p.g(context4, "holder.context");
                    imageView.setImageDrawable(ar.m(context3, R.raw.icons_filled_me, context4.getResources().getColor(R.color.am)));
                    p.g(imageView, "likeIv");
                    imageView.setVisibility(0);
                    AppMethodBeat.o(249124);
                    return;
                case 10:
                    Mn.setVisibility(0);
                    Context context5 = hVar.getContext();
                    Context context6 = hVar.getContext();
                    p.g(context6, "holder.context");
                    imageView.setImageDrawable(ar.m(context5, R.raw.finder_icons_filled_topic, context6.getResources().getColor(R.color.am)));
                    p.g(imageView, "likeIv");
                    imageView.setVisibility(0);
                    AppMethodBeat.o(249124);
                    return;
                case 11:
                    Mn.setVisibility(0);
                    Context context7 = hVar.getContext();
                    Context context8 = hVar.getContext();
                    p.g(context8, "holder.context");
                    imageView.setImageDrawable(ar.m(context7, R.raw.finder_icons_filled_sight, context8.getResources().getColor(R.color.am)));
                    p.g(imageView, "likeIv");
                    imageView.setVisibility(0);
                    AppMethodBeat.o(249124);
                    return;
                case 12:
                    Mn.setVisibility(0);
                    Context context9 = hVar.getContext();
                    Context context10 = hVar.getContext();
                    p.g(context10, "holder.context");
                    imageView.setImageDrawable(ar.m(context9, R.raw.finder_filled_fire, context10.getResources().getColor(R.color.am)));
                    p.g(imageView, "likeIv");
                    imageView.setVisibility(0);
                    break;
                case 13:
                    Mn.setVisibility(0);
                    Context context11 = hVar.getContext();
                    Context context12 = hVar.getContext();
                    p.g(context12, "holder.context");
                    imageView.setImageDrawable(ar.m(context11, R.raw.finder_icons_filled_food, context12.getResources().getColor(R.color.am)));
                    p.g(imageView, "likeIv");
                    imageView.setVisibility(0);
                    AppMethodBeat.o(249124);
                    return;
            }
            AppMethodBeat.o(249124);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class j extends q implements kotlin.g.a.a<RefreshLoadMoreLayout> {
        final /* synthetic */ e uRr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(e eVar) {
            super(0);
            this.uRr = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RefreshLoadMoreLayout invoke() {
            AppMethodBeat.i(249137);
            RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) this.uRr.hVd.findViewById(R.id.h7t);
            AppMethodBeat.o(249137);
            return refreshLoadMoreLayout;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class k extends q implements kotlin.g.a.a<View> {
        final /* synthetic */ e uRr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(e eVar) {
            super(0);
            this.uRr = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(249138);
            View findViewById = this.uRr.hVd.findViewById(R.id.h97);
            AppMethodBeat.o(249138);
            return findViewById;
        }
    }

    @Override // com.tencent.mm.plugin.finder.nearby.live.b.AbstractC1238b
    public final void ab(ArrayList<bo> arrayList) {
        View findViewById;
        AppMethodBeat.i(249139);
        p.h(arrayList, "data");
        View dls = dls();
        p.g(dls, "rootScroll");
        Context context = dls.getContext();
        p.g(context, "rootScroll.context");
        Resources resources = context.getResources();
        getRlLayout().setLimitTopRequest(((int) resources.getDimension(R.dimen.a5g)) - ((int) resources.getDimension(R.dimen.bx)));
        getRlLayout().setRefreshTargetY(((int) resources.getDimension(R.dimen.cn)) - ((int) resources.getDimension(R.dimen.a5g)));
        getRlLayout().setDamping(1.85f);
        View loadMoreFooter = getRlLayout().getLoadMoreFooter();
        if (!(loadMoreFooter == null || (findViewById = loadMoreFooter.findViewById(R.id.dko)) == null)) {
            findViewById.setOnClickListener(new h(this));
        }
        getRlLayout().setActionCallback(new i(this));
        RecyclerView recyclerView = getRlLayout().getRecyclerView();
        NearbyLiveViewCallback$initRecyclerView$1 nearbyLiveViewCallback$initRecyclerView$1 = new NearbyLiveViewCallback$initRecyclerView$1();
        nearbyLiveViewCallback$initRecyclerView$1.setItemPrefetchEnabled(true);
        recyclerView.setLayoutManager(nearbyLiveViewCallback$initRecyclerView$1);
        recyclerView.b(new c());
        RecyclerView.f itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.lB();
        }
        g gVar = new g(this, arrayList, new b(this.tRl, this.uRo), arrayList);
        gVar.RqP = new d(this, arrayList);
        gVar.RqO = new C1243e(arrayList);
        recyclerView.setAdapter(gVar);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(8);
        if (recyclerView == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
            AppMethodBeat.o(249139);
            throw tVar;
        }
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        ((WxRecyclerView) recyclerView).setFlingSpeedFactor(com.tencent.mm.plugin.finder.storage.c.dsZ().value().intValue());
        com.tencent.mm.view.recyclerview.c.a(recyclerView, new f(this));
        AppMethodBeat.o(249139);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.c
    public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
        return this.tRl;
    }

    public static final /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(249147);
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.Z(eVar.tRl, new Intent());
        AppMethodBeat.o(249147);
    }
}
