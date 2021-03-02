package com.tencent.mm.plugin.finder.nearby.video;

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
import com.tencent.mm.plugin.finder.convert.m;
import com.tencent.mm.plugin.finder.feed.model.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.video.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.sdk.platformtools.BuildInfo;
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
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u00192\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001bj\b\u0012\u0004\u0012\u00020\u0002`\u001cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback;", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "presenter", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$Presenter;Landroid/view/View;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Companion", "plugin-finder_release"})
public final class d implements a.b<bo> {
    public static final a uTJ = new a((byte) 0);
    private final View hVd;
    private al tMj = new c(this.tRl);
    private final MMActivity tRl;
    private final AbsNearByFragment uTH;
    private final a.AbstractC1247a<bo> uTI;

    static {
        AppMethodBeat.i(249497);
        AppMethodBeat.o(249497);
    }

    public d(MMActivity mMActivity, AbsNearByFragment absNearByFragment, a.AbstractC1247a<bo> aVar, View view) {
        p.h(mMActivity, "baseContext");
        p.h(absNearByFragment, "fragment");
        p.h(aVar, "presenter");
        p.h(view, "parent");
        AppMethodBeat.i(249496);
        this.tRl = mMActivity;
        this.uTH = absNearByFragment;
        this.uTI = aVar;
        this.hVd = view;
        AppMethodBeat.o(249496);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.nearby.video.a.b
    public final void ab(ArrayList<bo> arrayList) {
        AppMethodBeat.i(249493);
        p.h(arrayList, "data");
        RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) this.hVd.findViewById(R.id.h7t);
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        Resources resources = context.getResources();
        refreshLoadMoreLayout.setLimitTopRequest(((int) resources.getDimension(R.dimen.a5g)) - ((int) resources.getDimension(R.dimen.bx)));
        refreshLoadMoreLayout.setRefreshTargetY(((int) resources.getDimension(R.dimen.cp)) - ((int) resources.getDimension(R.dimen.a5g)));
        refreshLoadMoreLayout.setDamping(1.85f);
        RecyclerView recyclerView = refreshLoadMoreLayout.getRecyclerView();
        al alVar = this.tMj;
        Context context2 = this.hVd.getContext();
        p.g(context2, "parent.context");
        recyclerView.setLayoutManager(alVar.eS(context2));
        recyclerView.b(this.tMj.getItemDecoration());
        recyclerView.setRecycledViewPool(this.tMj.f(this.tRl));
        RecyclerView.f itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.lB();
        }
        e eVar = new e(this, arrayList, this.tMj.G(new f(this)), arrayList);
        eVar.RqP = new b(this, arrayList, refreshLoadMoreLayout);
        recyclerView.setAdapter(eVar);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(4);
        if (recyclerView == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
            AppMethodBeat.o(249493);
            throw tVar;
        }
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        ((WxRecyclerView) recyclerView).setFlingSpeedFactor(com.tencent.mm.plugin.finder.storage.c.dsZ().value().intValue());
        refreshLoadMoreLayout.setActionCallback(new c(this));
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.event.base.f d2 = FinderReporterUIC.d((FinderReporterUIC) com.tencent.mm.ui.component.a.of(this.uTH).get(FinderReporterUIC.class));
        if (d2 != null) {
            d2.m(recyclerView);
        }
        com.tencent.mm.view.recyclerview.c.a(recyclerView, new C1250d(this));
        AppMethodBeat.o(249493);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$adapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
    public static final class e extends WxRecyclerAdapter<bo> {
        final /* synthetic */ ArrayList tMn;
        final /* synthetic */ d uTK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(d dVar, ArrayList arrayList, com.tencent.mm.view.recyclerview.f fVar, ArrayList arrayList2) {
            super(fVar, arrayList2);
            this.uTK = dVar;
            this.tMn = arrayList;
        }

        @Override // com.tencent.mm.view.recyclerview.WxRecyclerAdapter, android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void k(RecyclerView.v vVar) {
            AppMethodBeat.i(249489);
            n((h) vVar);
            AppMethodBeat.o(249489);
        }

        @Override // com.tencent.mm.view.recyclerview.WxRecyclerAdapter
        public final void n(h hVar) {
            AppMethodBeat.i(249488);
            p.h(hVar, "holder");
            super.n(hVar);
            View view = hVar.aus;
            p.g(view, "holder.itemView");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).aC(hVar.lU() == -1);
            }
            AppMethodBeat.o(249488);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", LocaleUtil.ITALIAN, "", "invoke"})
    static final class f extends q implements kotlin.g.a.b<Integer, com.tencent.mm.view.recyclerview.e<?>> {
        final /* synthetic */ d uTK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(d dVar) {
            super(1);
            this.uTK = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ com.tencent.mm.view.recyclerview.e<?> invoke(Integer num) {
            AppMethodBeat.i(249492);
            switch (num.intValue()) {
                case -1:
                    m mVar = new m(new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.finder.nearby.video.d.f.AnonymousClass1 */
                        final /* synthetic */ f uTM;

                        {
                            this.uTM = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(249490);
                            a.AbstractC1247a aVar = this.uTM.uTK.uTI;
                            if (aVar == null) {
                                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.video.NearbyVideoPresenter");
                                AppMethodBeat.o(249490);
                                throw tVar;
                            }
                            ((NearbyVideoPresenter) aVar).getFeedLoader().requestRefresh();
                            x xVar = x.SXb;
                            AppMethodBeat.o(249490);
                            return xVar;
                        }
                    }, new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.finder.nearby.video.d.f.AnonymousClass2 */
                        final /* synthetic */ f uTM;

                        {
                            this.uTM = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(249491);
                            k kVar = k.vfA;
                            k.ac(this.uTM.uTK.tRl, 2);
                            com.tencent.mm.plugin.finder.utils.l lVar = com.tencent.mm.plugin.finder.utils.l.vVE;
                            com.tencent.mm.plugin.finder.utils.l.g(this.uTM.uTK.tRl);
                            x xVar = x.SXb;
                            AppMethodBeat.o(249491);
                            return xVar;
                        }
                    });
                    AppMethodBeat.o(249492);
                    return mVar;
                default:
                    if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
                        RuntimeException runtimeException = new RuntimeException("type invalid");
                        AppMethodBeat.o(249492);
                        throw runtimeException;
                    }
                    Log.printInfoStack("RecyclerViewAdapterEx", "type invalid", new Object[0]);
                    com.tencent.mm.plugin.finder.convert.f fVar = new com.tencent.mm.plugin.finder.convert.f();
                    AppMethodBeat.o(249492);
                    return fVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
    public static final class b implements g.c<h> {
        final /* synthetic */ RefreshLoadMoreLayout $rlLayout;
        final /* synthetic */ ArrayList tMn;
        final /* synthetic */ d uTK;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
        static final class a extends q implements kotlin.g.a.b<bo, Boolean> {
            public static final a uTL = new a();

            static {
                AppMethodBeat.i(249480);
                AppMethodBeat.o(249480);
            }

            a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Boolean invoke(bo boVar) {
                AppMethodBeat.i(249479);
                bo boVar2 = boVar;
                p.h(boVar2, "feed");
                Boolean valueOf = Boolean.valueOf(boVar2 instanceof com.tencent.mm.plugin.finder.model.x);
                AppMethodBeat.o(249479);
                return valueOf;
            }
        }

        b(d dVar, ArrayList arrayList, RefreshLoadMoreLayout refreshLoadMoreLayout) {
            this.uTK = dVar;
            this.tMn = arrayList;
            this.$rlLayout = refreshLoadMoreLayout;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
        @Override // com.tencent.mm.view.recyclerview.g.c
        public final /* synthetic */ void a(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
            bbn dIx;
            AppMethodBeat.i(249481);
            p.h(aVar, "adapter");
            p.h(view, "view");
            p.h(hVar, "holder");
            int size = ((WxRecyclerAdapter) aVar).RqM.size();
            if (i2 >= size) {
                Object obj = this.tMn.get(i2 - size);
                p.g(obj, "data[position - headCount]");
                bo boVar = (bo) obj;
                Intent intent = new Intent();
                FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                Context context = view.getContext();
                p.g(context, "view.context");
                FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
                int i3 = i2 - size;
                y yVar = y.vXH;
                if (y.isAnyEnableFullScreenEnjoy()) {
                    y yVar2 = y.vXH;
                    bo n = y.n(i3, this.tMn);
                    if (!(n instanceof BaseFinderFeed)) {
                        n = null;
                    }
                    BaseFinderFeed baseFinderFeed = (BaseFinderFeed) n;
                    if (baseFinderFeed != null) {
                        intent.putExtra("feed_object_id", baseFinderFeed.lT());
                        intent.putExtra("feed_object_nonceId", baseFinderFeed.feedObject.getObjectNonceId());
                        intent.putExtra("tab_type", 10);
                        intent.putExtra("key_reuqest_scene", 17);
                        intent.putExtra("key_comment_scene", 16);
                        com.tencent.mm.plugin.finder.nearby.report.d dVar = com.tencent.mm.plugin.finder.nearby.report.d.uTq;
                        intent.putExtra("key_click_tab_context_id", com.tencent.mm.plugin.finder.nearby.report.d.dlA());
                        com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        com.tencent.mm.plugin.finder.utils.a.F(this.uTK.tRl, intent);
                    }
                } else {
                    com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh, "MMKernel.storage()");
                    ao azQ = aAh.azQ();
                    y yVar3 = y.vXH;
                    Object obj2 = azQ.get(y.LK(2), "");
                    if (obj2 == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.String");
                        AppMethodBeat.o(249481);
                        throw tVar;
                    }
                    byte[] decodeHexString = Util.decodeHexString((String) obj2);
                    i C = new i(i3, this.tMn).C(a.uTL);
                    y yVar4 = y.vXH;
                    y.a(C.position, C.tXV, com.tencent.mm.bw.b.cD(decodeHexString), intent);
                    intent.putExtra("KEY_UI_TITLE", "");
                    intent.putExtra("KEY_SAVE_RESULT", true);
                    com.tencent.mm.plugin.finder.nearby.report.d dVar2 = com.tencent.mm.plugin.finder.nearby.report.d.uTq;
                    intent.putExtra("key_click_tab_context_id", com.tencent.mm.plugin.finder.nearby.report.d.dlA());
                    com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    com.tencent.mm.plugin.finder.utils.a.c((Activity) this.uTK.tRl, intent);
                }
                com.tencent.mm.ui.component.a aVar5 = com.tencent.mm.ui.component.a.PRN;
                FinderReporterUIC finderReporterUIC = (FinderReporterUIC) com.tencent.mm.ui.component.a.of(this.uTK.uTH).get(FinderReporterUIC.class);
                if (!(finderReporterUIC == null || (dIx = finderReporterUIC.dIx()) == null)) {
                    k kVar = k.vfA;
                    k.a(dIx, boVar.lT(), this.$rlLayout.getRecyclerView());
                    com.tencent.mm.plugin.finder.nearby.report.a aVar6 = com.tencent.mm.plugin.finder.nearby.report.a.uSY;
                    com.tencent.mm.plugin.finder.nearby.report.a.a(dIx, boVar);
                    AppMethodBeat.o(249481);
                    return;
                }
            }
            AppMethodBeat.o(249481);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
    public static final class c extends RefreshLoadMoreLayout.a {
        final /* synthetic */ d uTK;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(d dVar) {
            this.uTK = dVar;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(249482);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            this.uTK.uTI.onRefresh();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(249482);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(249483);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            super.onRefreshEnd(cVar);
            this.uTK.uTI.onRefreshEnd(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(249483);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            AppMethodBeat.i(249484);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            super.cxo();
            this.uTK.uTI.onLoadMore();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(249484);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(249485);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            super.a(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(249485);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0006H\u0016J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$4", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onExposeTimeRecorded", "", "recordsSet", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "onItemExposeStart", "item", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.nearby.video.d$d  reason: collision with other inner class name */
    public static final class C1250d extends com.tencent.mm.view.recyclerview.d<com.tencent.mm.view.recyclerview.a> {
        final /* synthetic */ d uTK;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1250d(d dVar) {
            this.uTK = dVar;
        }

        @Override // com.tencent.mm.view.recyclerview.d
        public final void l(Set<com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a>> set) {
            AppMethodBeat.i(249486);
            p.h(set, "recordsSet");
            Log.i("FinderTimelineLbsContract", "onExposeTimeRecorded: size = " + set.size());
            LinkedList linkedList = new LinkedList();
            for (T t : set) {
                if (t.RqA instanceof ad) {
                    cmm cmm = new cmm();
                    T t2 = t.RqA;
                    if (t2 == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FinderFeedVideo");
                        AppMethodBeat.o(249486);
                        throw tVar;
                    }
                    ad adVar = (ad) t2;
                    cmm.hFK = adVar.lT();
                    as asVar = as.uOL;
                    as.a(cmm, this.uTK.uTI.getCommentScene());
                    cmm.MrJ = (int) t.wVY;
                    cmm.sessionBuffer = adVar.getSessionBuffer();
                    linkedList.add(cmm);
                    Log.d("FinderTimelineLbsContract", "onExposeTimeRecorded pos:" + t.Qgj + " exposeTime:" + t.wVY + " nick:" + adVar.feedObject.getFeedObject().nickname);
                } else {
                    Log.d("FinderTimelineLbsContract", "onExposeTimeRecorded pos:" + t.Qgj + " exposeTime:" + t.wVY);
                }
            }
            com.tencent.mm.plugin.finder.nearby.report.c cVar = com.tencent.mm.plugin.finder.nearby.report.c.uTk;
            com.tencent.mm.plugin.finder.nearby.report.c.i(this.uTK.uTI.getCommentScene(), linkedList);
            as asVar2 = as.uOL;
            as.ar(linkedList);
            AppMethodBeat.o(249486);
        }

        @Override // com.tencent.mm.view.recyclerview.d
        public final void a(com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a> bVar) {
            AppMethodBeat.i(249487);
            p.h(bVar, "item");
            if (bVar.RqA instanceof ad) {
                cmm cmm = new cmm();
                T t = bVar.RqA;
                if (t == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FinderFeedVideo");
                    AppMethodBeat.o(249487);
                    throw tVar;
                }
                ad adVar = (ad) t;
                cmm.hFK = adVar.lT();
                cmm.MrJ = (int) bVar.startTime;
                as asVar = as.uOL;
                as.a(cmm, this.uTK.uTI.getCommentScene());
                com.tencent.mm.plugin.finder.nearby.report.c cVar = com.tencent.mm.plugin.finder.nearby.report.c.uTk;
                com.tencent.mm.plugin.finder.nearby.report.c.a(this.uTK.uTI.getCommentScene(), cmm);
                Log.d("FinderTimelineLbsContract", "onItemExposeStart id:" + cmm.hFK + " nick:" + adVar.feedObject.getFeedObject().nickname);
            }
            AppMethodBeat.o(249487);
        }
    }

    @Override // com.tencent.mm.plugin.finder.nearby.video.a.b
    public final RecyclerView getRecyclerView() {
        AppMethodBeat.i(249494);
        RecyclerView recyclerView = ((RefreshLoadMoreLayout) this.hVd.findViewById(R.id.h7t)).getRecyclerView();
        AppMethodBeat.o(249494);
        return recyclerView;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.video.a.b
    public final RefreshLoadMoreLayout dcQ() {
        AppMethodBeat.i(249495);
        RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) this.hVd.findViewById(R.id.h7t);
        p.g(refreshLoadMoreLayout, "parent.rl_layout");
        AppMethodBeat.o(249495);
        return refreshLoadMoreLayout;
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.c
    public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
        return this.tRl;
    }
}
