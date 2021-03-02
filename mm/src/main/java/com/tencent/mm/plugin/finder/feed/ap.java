package com.tencent.mm.plugin.finder.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.convert.m;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.feed.aj;
import com.tencent.mm.plugin.finder.feed.model.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.storage.p;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ8\u0010\u0014\u001a\u00020\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0017j\b\u0012\u0004\u0012\u00020\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J \u0010$\u001a\u00020%2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0017j\b\u0012\u0004\u0012\u00020\u0002`\u0018H\u0016R\u0014\u0010\n\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;Landroid/view/View;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "filterLiveItemClick", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feed", "position", "", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "initView", "", "plugin-finder_release"})
public final class ap implements aj.b<bo> {
    final String TAG = "FinderTimelineLbsContract";
    private final View hVd;
    final aj.a<bo> tEK;
    private al tMj = new p(this.tRl);
    final MMActivity tRl;

    public ap(MMActivity mMActivity, aj.a<bo> aVar, View view) {
        kotlin.g.b.p.h(mMActivity, "baseContext");
        kotlin.g.b.p.h(aVar, "presenter");
        kotlin.g.b.p.h(view, "parent");
        AppMethodBeat.i(244293);
        this.tRl = mMActivity;
        this.tEK = aVar;
        this.hVd = view;
        AppMethodBeat.o(244293);
    }

    @Override // com.tencent.mm.plugin.finder.feed.aj.b
    public final void ab(ArrayList<bo> arrayList) {
        AppMethodBeat.i(244290);
        kotlin.g.b.p.h(arrayList, "data");
        RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) this.hVd.findViewById(R.id.h7t);
        Context context = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
        Resources resources = context.getResources();
        refreshLoadMoreLayout.setLimitTopRequest(((int) resources.getDimension(R.dimen.a5g)) - ((int) resources.getDimension(R.dimen.bx)));
        refreshLoadMoreLayout.setRefreshTargetY(((int) resources.getDimension(R.dimen.cp)) - ((int) resources.getDimension(R.dimen.a5g)));
        refreshLoadMoreLayout.setDamping(1.85f);
        RecyclerView recyclerView = refreshLoadMoreLayout.getRecyclerView();
        al alVar = this.tMj;
        Context context2 = this.hVd.getContext();
        kotlin.g.b.p.g(context2, "parent.context");
        recyclerView.setLayoutManager(alVar.eS(context2));
        recyclerView.b(this.tMj.getItemDecoration());
        recyclerView.setRecycledViewPool(this.tMj.f(this.tRl));
        RecyclerView.f itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.lB();
        }
        c cVar = new c(this, arrayList, this.tMj.G(new d(this)), arrayList);
        cVar.RqP = new a(this, arrayList, refreshLoadMoreLayout);
        recyclerView.setAdapter(cVar);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(4);
        if (recyclerView == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
            AppMethodBeat.o(244290);
            throw tVar;
        }
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        ((WxRecyclerView) recyclerView).setFlingSpeedFactor(com.tencent.mm.plugin.finder.storage.c.dsZ().value().intValue());
        refreshLoadMoreLayout.setActionCallback(new b(this));
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        f d2 = FinderReporterUIC.d((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.tRl).get(FinderReporterUIC.class));
        if (d2 != null) {
            d2.m(recyclerView);
            AppMethodBeat.o(244290);
            return;
        }
        AppMethodBeat.o(244290);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$adapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
    public static final class c extends WxRecyclerAdapter<bo> {
        final /* synthetic */ ArrayList tMn;
        final /* synthetic */ ap tRB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ap apVar, ArrayList arrayList, com.tencent.mm.view.recyclerview.f fVar, ArrayList arrayList2) {
            super(fVar, arrayList2);
            this.tRB = apVar;
            this.tMn = arrayList;
        }

        @Override // com.tencent.mm.view.recyclerview.WxRecyclerAdapter, android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void k(RecyclerView.v vVar) {
            AppMethodBeat.i(244286);
            n((h) vVar);
            AppMethodBeat.o(244286);
        }

        @Override // com.tencent.mm.view.recyclerview.WxRecyclerAdapter
        public final void n(h hVar) {
            AppMethodBeat.i(244285);
            kotlin.g.b.p.h(hVar, "holder");
            super.n(hVar);
            View view = hVar.aus;
            kotlin.g.b.p.g(view, "holder.itemView");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).aC(hVar.lU() == -1 || hVar.lU() == 2003);
            }
            AppMethodBeat.o(244285);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", LocaleUtil.ITALIAN, "", "invoke"})
    static final class d extends q implements kotlin.g.a.b<Integer, e<?>> {
        final /* synthetic */ ap tRB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ap apVar) {
            super(1);
            this.tRB = apVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ e<?> invoke(Integer num) {
            AppMethodBeat.i(244289);
            int intValue = num.intValue();
            switch (intValue) {
                case -1:
                    m mVar = new m(new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.finder.feed.ap.d.AnonymousClass1 */
                        final /* synthetic */ d tRD;

                        {
                            this.tRD = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(244287);
                            aj.a<bo> aVar = this.tRD.tRB.tEK;
                            if (aVar == null) {
                                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTimelineLbsPresenter");
                                AppMethodBeat.o(244287);
                                throw tVar;
                            }
                            ((am) aVar).tRo.requestRefresh();
                            x xVar = x.SXb;
                            AppMethodBeat.o(244287);
                            return xVar;
                        }
                    }, new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.finder.feed.ap.d.AnonymousClass2 */
                        final /* synthetic */ d tRD;

                        {
                            this.tRD = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(244288);
                            k kVar = k.vfA;
                            k.ac(this.tRD.tRB.tRl, 2);
                            com.tencent.mm.plugin.finder.utils.l lVar = com.tencent.mm.plugin.finder.utils.l.vVE;
                            com.tencent.mm.plugin.finder.utils.l.g(this.tRD.tRB.tRl);
                            x xVar = x.SXb;
                            AppMethodBeat.o(244288);
                            return xVar;
                        }
                    });
                    AppMethodBeat.o(244289);
                    return mVar;
                default:
                    y yVar = y.vXH;
                    y.dQ("RecyclerViewAdapterEx", intValue);
                    com.tencent.mm.plugin.finder.convert.f fVar = new com.tencent.mm.plugin.finder.convert.f();
                    AppMethodBeat.o(244289);
                    return fVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
    public static final class a implements g.c<h> {
        final /* synthetic */ RefreshLoadMoreLayout $rlLayout;
        final /* synthetic */ ArrayList tMn;
        final /* synthetic */ ap tRB;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.ap$a$a  reason: collision with other inner class name */
        static final class C1127a extends q implements kotlin.g.a.b<bo, Boolean> {
            public static final C1127a tRC = new C1127a();

            static {
                AppMethodBeat.i(244279);
                AppMethodBeat.o(244279);
            }

            C1127a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Boolean invoke(bo boVar) {
                AppMethodBeat.i(244278);
                bo boVar2 = boVar;
                kotlin.g.b.p.h(boVar2, "feed");
                Boolean valueOf = Boolean.valueOf(boVar2 instanceof com.tencent.mm.plugin.finder.model.x);
                AppMethodBeat.o(244278);
                return valueOf;
            }
        }

        a(ap apVar, ArrayList arrayList, RefreshLoadMoreLayout refreshLoadMoreLayout) {
            this.tRB = apVar;
            this.tMn = arrayList;
            this.$rlLayout = refreshLoadMoreLayout;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
        @Override // com.tencent.mm.view.recyclerview.g.c
        public final /* synthetic */ void a(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
            bo boVar;
            boolean z;
            bbn dIx;
            bbn dIx2;
            AppMethodBeat.i(244280);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(aVar);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.bm(hVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$1", "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", "onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILandroid/support/v7/widget/RecyclerView$ViewHolder;)V", this, bVar.axR());
            h hVar2 = hVar;
            com.tencent.mm.hellhoundlib.b.b bVar2 = new com.tencent.mm.hellhoundlib.b.b();
            bVar2.bm(aVar);
            bVar2.bm(view);
            bVar2.pH(i2);
            bVar2.bm(hVar2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$1", "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", "onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", this, bVar2.axR());
            kotlin.g.b.p.h(aVar, "adapter");
            kotlin.g.b.p.h(view, "view");
            kotlin.g.b.p.h(hVar2, "holder");
            int size = ((WxRecyclerAdapter) aVar).RqM.size();
            if (i2 >= size) {
                Object obj = this.tMn.get(i2 - size);
                kotlin.g.b.p.g(obj, "data[position - headCount]");
                bo boVar2 = (bo) obj;
                ap apVar = this.tRB;
                ArrayList arrayList = this.tMn;
                if (boVar2 instanceof com.tencent.mm.plugin.finder.model.x) {
                    Log.i(apVar.TAG, "itemClick is FinderFeedLiveList!");
                    z = true;
                } else {
                    if (!(boVar2 instanceof BaseFinderFeed)) {
                        boVar = null;
                    } else {
                        boVar = boVar2;
                    }
                    BaseFinderFeed baseFinderFeed = (BaseFinderFeed) boVar;
                    if (baseFinderFeed != null) {
                        y yVar = y.vXH;
                        if (y.w((BaseFinderFeed) boVar2)) {
                            if (Util.isEqual(((BaseFinderFeed) boVar2).feedObject.getUserName(), z.aUg())) {
                                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                                MMActivity mMActivity = apVar.tRl;
                                long id = ((BaseFinderFeed) boVar2).feedObject.getId();
                                String objectNonceId = ((BaseFinderFeed) boVar2).feedObject.getObjectNonceId();
                                awe liveInfo = ((BaseFinderFeed) boVar2).feedObject.getLiveInfo();
                                if (liveInfo == null) {
                                    liveInfo = new awe();
                                }
                                com.tencent.mm.plugin.finder.utils.a.a(mMActivity, id, objectNonceId, liveInfo, false, null, null, null, null, null, baseFinderFeed.getSessionBuffer(), null, null, 14320);
                            } else {
                                com.tencent.mm.plugin.finder.report.live.k.vkd.a((BaseFinderFeed) boVar2, (long) i2, s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM, "15");
                                FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                                Context context = hVar2.getContext();
                                kotlin.g.b.p.g(context, "holder.context");
                                FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
                                int i3 = (fH == null || (dIx = fH.dIx()) == null) ? 0 : dIx.tCE;
                                com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
                                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                                com.tencent.mm.plugin.finder.utils.a.a(apVar.tRl, com.tencent.mm.plugin.finder.utils.m.a(arrayList, boVar2, 2, i3), (String) null, (String) null, (Intent) null, 28);
                            }
                            z = true;
                        }
                    }
                    z = false;
                }
                if (z) {
                    Log.i(this.tRB.TAG, "item click is Live!");
                } else {
                    Intent intent = new Intent();
                    int i4 = i2 - size;
                    com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                    kotlin.g.b.p.g(aAh, "MMKernel.storage()");
                    ao azQ = aAh.azQ();
                    y yVar2 = y.vXH;
                    Object obj2 = azQ.get(y.LK(2), "");
                    if (obj2 == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.String");
                        AppMethodBeat.o(244280);
                        throw tVar;
                    }
                    byte[] decodeHexString = Util.decodeHexString((String) obj2);
                    i C = new i(i4, this.tMn).C(C1127a.tRC);
                    y yVar3 = y.vXH;
                    y.a(C.position, C.tXV, com.tencent.mm.bw.b.cD(decodeHexString), intent);
                    intent.putExtra("KEY_UI_TITLE", "");
                    intent.putExtra("KEY_SAVE_RESULT", true);
                    FinderReporterUIC.a aVar5 = FinderReporterUIC.wzC;
                    Context context2 = view.getContext();
                    kotlin.g.b.p.g(context2, "view.context");
                    FinderReporterUIC.a.a(context2, intent, 0, 0, false, 124);
                    com.tencent.mm.plugin.finder.utils.a aVar6 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    com.tencent.mm.plugin.finder.utils.a.c((Activity) this.tRB.tRl, intent);
                    FinderReporterUIC.a aVar7 = FinderReporterUIC.wzC;
                    Context context3 = view.getContext();
                    kotlin.g.b.p.g(context3, "view.context");
                    FinderReporterUIC fH2 = FinderReporterUIC.a.fH(context3);
                    if (!(fH2 == null || (dIx2 = fH2.dIx()) == null)) {
                        k kVar = k.vfA;
                        k.a(dIx2, boVar2.lT(), this.$rlLayout.getRecyclerView());
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$1", "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", "onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$1", "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", "onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILandroid/support/v7/widget/RecyclerView$ViewHolder;)V");
            AppMethodBeat.o(244280);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
    public static final class b extends RefreshLoadMoreLayout.a {
        final /* synthetic */ ap tRB;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(ap apVar) {
            this.tRB = apVar;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(244281);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            this.tRB.tEK.onRefresh();
            RefreshLoadMoreLayout.c.a aVar = RefreshLoadMoreLayout.c.Rms;
            if (i2 == RefreshLoadMoreLayout.c.Rmq) {
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.dsx().value().intValue() == 1) {
                    FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tRB.tRl);
                    if (fH != null) {
                        k kVar = k.vfA;
                        k.a(fH.dIx(), 3);
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(244281);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244282);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            kotlin.g.b.p.h(cVar, "reason");
            super.onRefreshEnd(cVar);
            this.tRB.tEK.onRefreshEnd(cVar);
            com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.plugin.finder.report.h.a(hVar, 2, false, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.tRB.tRl).get(FinderReporterUIC.class)).dIx(), 8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(244282);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            AppMethodBeat.i(244283);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            super.cxo();
            this.tRB.tEK.onLoadMore();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(244283);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244284);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            kotlin.g.b.p.h(cVar, "reason");
            super.a(cVar);
            com.tencent.mm.plugin.finder.report.h.a(com.tencent.mm.plugin.finder.report.h.veu, 2, false, null, 12);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(244284);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.aj.b
    public final RecyclerView getRecyclerView() {
        AppMethodBeat.i(244291);
        RecyclerView recyclerView = ((RefreshLoadMoreLayout) this.hVd.findViewById(R.id.h7t)).getRecyclerView();
        AppMethodBeat.o(244291);
        return recyclerView;
    }

    @Override // com.tencent.mm.plugin.finder.feed.aj.b
    public final RefreshLoadMoreLayout dcQ() {
        AppMethodBeat.i(244292);
        RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) this.hVd.findViewById(R.id.h7t);
        kotlin.g.b.p.g(refreshLoadMoreLayout, "parent.rl_layout");
        AppMethodBeat.o(244292);
        return refreshLoadMoreLayout;
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.c
    public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
        return this.tRl;
    }
}
