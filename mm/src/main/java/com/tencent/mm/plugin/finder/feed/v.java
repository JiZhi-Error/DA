package com.tencent.mm.plugin.finder.feed;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.convert.aa;
import com.tencent.mm.plugin.finder.convert.ad;
import com.tencent.mm.plugin.finder.convert.ai;
import com.tencent.mm.plugin.finder.convert.ak;
import com.tencent.mm.plugin.finder.convert.be;
import com.tencent.mm.plugin.finder.convert.ci;
import com.tencent.mm.plugin.finder.convert.q;
import com.tencent.mm.plugin.finder.convert.r;
import com.tencent.mm.plugin.finder.convert.t;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.convert.x;
import com.tencent.mm.plugin.finder.convert.y;
import com.tencent.mm.plugin.finder.feed.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedMegaVideoBtnAnimUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class v {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0019H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010 \u001a\u00020\u001fJ\u0018\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u001fH\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getDataAt", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", FirebaseAnalytics.b.INDEX, "", "getDataIndex", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedList", "Ljava/util/ArrayList;", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "ifSafeMode", "", "initViewCallback", "", "loadInitData", "onAttach", "model", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "plugin-finder_release"})
    public static abstract class a extends b.a {
        private final String TAG = "Finder.FinderLoaderFeedUIContract.Presenter";
        public BaseFinderFeedLoader tFM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MMActivity mMActivity) {
            super(mMActivity);
            p.h(mMActivity, "context");
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public String getTAG() {
            return this.TAG;
        }

        @Override // com.tencent.mm.plugin.finder.feed.ab.a
        public ArrayList<bo> dcH() {
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
            return baseFinderFeedLoader != null ? baseFinderFeedLoader.getDataListJustForAdapter() : null;
        }

        public void a(BaseFinderFeedLoader baseFinderFeedLoader, b bVar) {
            p.h(baseFinderFeedLoader, "model");
            p.h(bVar, "callback");
            this.tFM = baseFinderFeedLoader;
            super.onAttach(bVar);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderFeedMegaVideoBtnAnimUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderFeedMegaVideoBtnAnimUIC.class)).t(bVar.tLS.getRecyclerView());
        }

        public final void dcp() {
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
            if (baseFinderFeedLoader != null) {
                BaseFeedLoader.requestInit$default(baseFinderFeedLoader, false, 1, null);
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final DataBuffer<bo> dcc() {
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
            if (baseFinderFeedLoader == null) {
                p.hyc();
            }
            return baseFinderFeedLoader.getDataListJustForAdapter();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.v$a$a  reason: collision with other inner class name */
        public static final class C1170a implements f {
            final /* synthetic */ a tOJ;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            C1170a(a aVar) {
                this.tOJ = aVar;
            }

            @Override // com.tencent.mm.view.recyclerview.f
            public final e<?> EC(int i2) {
                int i3;
                AppMethodBeat.i(165721);
                switch (i2) {
                    case 1:
                        ad adVar = new ad(this.tOJ, this.tOJ.dcG(), 0, 4);
                        AppMethodBeat.o(165721);
                        return adVar;
                    case 2:
                        if (this.tOJ.dca()) {
                            q qVar = new q(this.tOJ, this.tOJ.dcG(), this.tOJ.dLS);
                            AppMethodBeat.o(165721);
                            return qVar;
                        }
                        u uVar = new u(this.tOJ, this.tOJ.dcG(), this.tOJ.dLS);
                        AppMethodBeat.o(165721);
                        return uVar;
                    case 4:
                        if (this.tOJ.dca()) {
                            t tVar = new t(this.tOJ.tCD, this.tOJ, this.tOJ.dcG(), this.tOJ.dLS);
                            AppMethodBeat.o(165721);
                            return tVar;
                        }
                        ak akVar = new ak(this.tOJ.tCD, this.tOJ, this.tOJ.dcG(), this.tOJ.dLS);
                        AppMethodBeat.o(165721);
                        return akVar;
                    case 7:
                        ai aiVar = new ai(this.tOJ, this.tOJ.dcG(), 0, 4);
                        AppMethodBeat.o(165721);
                        return aiVar;
                    case 8:
                        aa aaVar = new aa(this.tOJ.tCD, this.tOJ, this.tOJ.dcG(), 0, 8);
                        AppMethodBeat.o(165721);
                        return aaVar;
                    case 9:
                        if (this.tOJ.dca()) {
                            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tOJ.gte);
                            if (fH != null) {
                                i3 = fH.tCE;
                            } else {
                                i3 = 0;
                            }
                            r rVar = new r(this.tOJ.tCD, this.tOJ, this.tOJ.dcG(), this.tOJ.dLS, i3);
                            AppMethodBeat.o(165721);
                            return rVar;
                        }
                        x xVar = new x(this.tOJ.tCD, this.tOJ, this.tOJ.dcG());
                        AppMethodBeat.o(165721);
                        return xVar;
                    case 2001:
                        be beVar = new be();
                        AppMethodBeat.o(165721);
                        return beVar;
                    case 2003:
                        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                        y yVar = new y(((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.tOJ.gte).get(FinderReporterUIC.class)).dIx(), 0);
                        AppMethodBeat.o(165721);
                        return yVar;
                    case 2014:
                        ci ciVar = new ci(this.tOJ.tFM);
                        AppMethodBeat.o(165721);
                        return ciVar;
                    case 3001:
                        u uVar2 = new u(this.tOJ, this.tOJ.dcG(), 0, 4);
                        AppMethodBeat.o(165721);
                        return uVar2;
                    case 3002:
                        ak akVar2 = new ak(this.tOJ.tCD, this.tOJ, this.tOJ.dcG(), 0, 8);
                        AppMethodBeat.o(165721);
                        return akVar2;
                    default:
                        com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
                        com.tencent.mm.plugin.finder.utils.y.dQ(this.tOJ.getTAG(), i2);
                        com.tencent.mm.plugin.finder.convert.f fVar = new com.tencent.mm.plugin.finder.convert.f();
                        AppMethodBeat.o(165721);
                        return fVar;
                }
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public f dce() {
            return new C1170a(this);
        }

        public boolean dcG() {
            return false;
        }

        @Override // com.tencent.mm.plugin.finder.feed.ab.a
        public final int l(BaseFinderFeed baseFinderFeed) {
            DataBuffer dataListJustForAdapter;
            p.h(baseFinderFeed, "feed");
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
            if (baseFinderFeedLoader == null || (dataListJustForAdapter = baseFinderFeedLoader.getDataListJustForAdapter()) == null) {
                return -1;
            }
            return dataListJustForAdapter.indexOf(baseFinderFeed);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final bo IE(int i2) {
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
            if (baseFinderFeedLoader != null) {
                return (bo) baseFinderFeedLoader.safeGet(i2);
            }
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void dcb() {
            BaseFinderFeedLoader baseFinderFeedLoader;
            b.AbstractC1134b bVar = this.tLN;
            if (bVar == null) {
                throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.ViewCallback");
            }
            j dcI = ((b) bVar).dcI();
            if (!(dcI == null || (baseFinderFeedLoader = this.tFM) == null)) {
                baseFinderFeedLoader.register(dcI);
            }
            b.AbstractC1134b bVar2 = this.tLN;
            if (bVar2 == null) {
                p.hyc();
            }
            BaseFinderFeedLoader baseFinderFeedLoader2 = this.tFM;
            if (baseFinderFeedLoader2 == null) {
                p.hyc();
            }
            bVar2.ab(baseFinderFeedLoader2.getDataListJustForAdapter());
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a, com.tencent.mm.plugin.finder.presenter.base.a
        public void onDetach() {
            BaseFinderFeedLoader baseFinderFeedLoader;
            b.AbstractC1134b bVar = this.tLN;
            if (bVar == null) {
                throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.ViewCallback");
            }
            j dcI = ((b) bVar).dcI();
            if (!(dcI == null || (baseFinderFeedLoader = this.tFM) == null)) {
                baseFinderFeedLoader.unregister(dcI);
            }
            super.onDetach();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u0016\u0010\u0016\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;II)V", "actionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "setActionCallback", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "getViewActionCallback", "onViewCallPreFinishLoadMore", "", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onViewCallPreFinishRefresh", "onViewPrepared", "plugin-finder_release"})
    public static abstract class b extends b.AbstractC1134b {
        private j tOK = new a(this);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MMActivity mMActivity, a aVar, int i2, int i3) {
            super(mMActivity, aVar, i2, i3);
            p.h(mMActivity, "context");
            p.h(aVar, "presenter");
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public void dbY() {
            d.a(d.aBx(), new C1171b(this));
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\u0002\u001a\u00020\u0003H\u0001J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H\u0016J\u0017\u0010\u0012\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H\u0001J\u0016\u0010\u0013\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H\u0016¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback$actionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
        public static final class a implements j {
            private final /* synthetic */ RefreshLoadMoreLayout tNU;
            final /* synthetic */ b tOL;

            @Override // com.tencent.mm.view.j
            public final void onChanged() {
                AppMethodBeat.i(243990);
                this.tNU.onChanged();
                AppMethodBeat.o(243990);
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> cVar) {
                AppMethodBeat.i(243991);
                p.h(cVar, "reason");
                this.tNU.onPreFinishLoadMoreSmooth(cVar);
                AppMethodBeat.o(243991);
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            a(b bVar) {
                this.tOL = bVar;
                this.tNU = bVar.tLS;
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeChanged(int i2, int i3) {
                AppMethodBeat.i(243984);
                this.tOL.tLS.onItemRangeChanged(this.tOL.sHN + i2, i3);
                AppMethodBeat.o(243984);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeChanged(int i2, int i3, Object obj) {
                AppMethodBeat.i(243985);
                this.tOL.tLS.onItemRangeChanged(this.tOL.sHN + i2, i3, obj);
                AppMethodBeat.o(243985);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeInserted(int i2, int i3) {
                AppMethodBeat.i(243986);
                this.tOL.tLS.onItemRangeInserted(this.tOL.sHN + i2, i3);
                AppMethodBeat.o(243986);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeRemoved(int i2, int i3) {
                AppMethodBeat.i(243987);
                this.tOL.tLS.onItemRangeRemoved(this.tOL.sHN + i2, i3);
                AppMethodBeat.o(243987);
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> cVar) {
                AppMethodBeat.i(243988);
                p.h(cVar, "reason");
                p.h(cVar, "reason");
                AppMethodBeat.o(243988);
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> cVar) {
                AppMethodBeat.i(243989);
                p.h(cVar, "reason");
                this.tOL.d(cVar);
                AppMethodBeat.o(243989);
            }
        }

        public void d(RefreshLoadMoreLayout.c<Object> cVar) {
            p.h(cVar, "reason");
        }

        public j dcI() {
            return this.tOK;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.v$b$b  reason: collision with other inner class name */
        static final class C1171b extends kotlin.g.b.q implements kotlin.g.a.b<Void, kotlin.x> {
            final /* synthetic */ b tOL;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1171b(b bVar) {
                super(1);
                this.tOL = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ kotlin.x invoke(Void r4) {
                AppMethodBeat.i(165728);
                b.a aVar = this.tOL.tLY;
                if (aVar == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.Presenter");
                    AppMethodBeat.o(165728);
                    throw tVar;
                }
                ((a) aVar).dcp();
                RefreshLoadMoreLayout.d(this.tOL.tLS);
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(165728);
                return xVar;
            }
        }
    }
}
