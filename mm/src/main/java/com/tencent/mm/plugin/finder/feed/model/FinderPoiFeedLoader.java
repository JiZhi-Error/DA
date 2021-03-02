package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.i.m;
import com.tencent.mm.plugin.finder.cgi.ca;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.i.a.y;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.protocal.protobuf.eak;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0003()*B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0#H\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0%H\u0016J\u0016\u0010&\u001a\u00020\u000b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R.\u0010\u0007\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "dataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader$PoiDataFetcher;", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "fromType", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "getFromType", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "setFromType", "(Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", m.NAME, "()Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/SnsLocation;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Companion", "FinderPoiStreamListResponse", "PoiDataFetcher", "plugin-finder_release"})
public final class FinderPoiFeedLoader extends BaseFinderFeedLoader {
    public static final a tWA = new a((byte) 0);
    public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
    private boolean hasMore;
    private c tWx;
    public eaa tWy;
    public y.a tWz;

    static {
        AppMethodBeat.i(244759);
        AppMethodBeat.o(244759);
    }

    private /* synthetic */ FinderPoiFeedLoader() {
        this(null);
    }

    public FinderPoiFeedLoader(bbn bbn) {
        super(bbn);
        AppMethodBeat.i(244758);
        this.tWx = new c();
        AppMethodBeat.o(244758);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader$FinderPoiStreamListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "hasFeedData", "", "getHasFeedData", "()Z", "setHasFeedData", "(Z)V", "noticeWording", "getNoticeWording", "()Ljava/lang/String;", "setNoticeWording", "(Ljava/lang/String;)V", "poiDetail", "Lcom/tencent/mm/protocal/protobuf/SnsPoiDetail;", "getPoiDetail", "()Lcom/tencent/mm/protocal/protobuf/SnsPoiDetail;", "setPoiDetail", "(Lcom/tencent/mm/protocal/protobuf/SnsPoiDetail;)V", "plugin-finder_release"})
    public static final class b extends IResponse<bo> {
        public eak tWB;
        public boolean tWC;
        public String tWD = "";

        public b(int i2, int i3, String str) {
            super(i2, i3, str);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        return this.tWx;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u001a\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
    public static final class d extends BaseFeedLoader<bo>.a {
        final /* synthetic */ FinderPoiFeedLoader tWE;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderPoiFeedLoader finderPoiFeedLoader) {
            super();
            this.tWE = finderPoiFeedLoader;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void mergeRefresh(IResponse<bo> iResponse, kotlin.g.a.b<? super IResponse<bo>, x> bVar) {
            boolean z;
            int i2;
            List<bo> incrementList;
            int i3 = 0;
            AppMethodBeat.i(244755);
            p.h(iResponse, "response");
            RefreshLoadMoreLayout.c cVar = new RefreshLoadMoreLayout.c(iResponse.getPullType());
            if (iResponse.getErrType() == 0 && iResponse.getErrCode() == 0) {
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                cVar.Rmi = context.getResources().getString(R.string.da6);
                cVar.Rmh = 1;
            } else {
                Context context2 = MMApplicationContext.getContext();
                p.g(context2, "MMApplicationContext.getContext()");
                cVar.Rmi = context2.getResources().getString(R.string.dak);
                cVar.Rmh = -1;
            }
            if (iResponse.getPullType() != 0) {
                z = true;
            } else {
                z = false;
            }
            cVar.jLE = z;
            cVar.Rmj = iResponse.getHasMore();
            if ((cVar.actionType == 0 || cVar.actionType == 4) && cVar.Rmk > 0) {
                cVar.Rmi = null;
            }
            Log.i("Finder.FinderPoiFeedLoader", "[onFetchRefreshDone]  reason=".concat(String.valueOf(cVar)));
            List<bo> incrementList2 = iResponse.getIncrementList();
            if (incrementList2 != null) {
                i3 = incrementList2.size();
            }
            if (iResponse.getHasMore()) {
                if (i3 <= this.tWE.getDataList().size()) {
                    i2 = 2;
                }
                i2 = 4;
            } else {
                if ((this.tWE.getDataList().size() == 0 || i3 == 0 || this.tWE.getDataList().size() <= i3) && (incrementList = iResponse.getIncrementList()) != null && incrementList.containsAll(j.p(this.tWE.getDataList()))) {
                    i2 = 6;
                }
                i2 = 4;
            }
            com.tencent.mm.ac.d.h(new a(this, new n(i2, iResponse.getIncrementList(), iResponse.isNeedClear(), 8), cVar, bVar, iResponse));
            AppMethodBeat.o(244755);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ n $op;
            final /* synthetic */ RefreshLoadMoreLayout.c $reason;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ d tWF;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, n nVar, RefreshLoadMoreLayout.c cVar, kotlin.g.a.b bVar, IResponse iResponse) {
                super(0);
                this.tWF = dVar;
                this.$op = nVar;
                this.$reason = cVar;
                this.$next = bVar;
                this.$response = iResponse;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(244754);
                this.tWF.convertOpToReason(this.$op, this.$reason);
                this.tWF.tWE.dispatcher().onPreFinishRefresh(this.$reason);
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(244754);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger() {
        AppMethodBeat.i(244756);
        d dVar = new d(this);
        AppMethodBeat.o(244756);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        AppMethodBeat.i(244757);
        p.h(iResponse, "response");
        super.onFetchDone(iResponse);
        this.hasMore = iResponse.getHasMore();
        kotlin.g.a.b<? super IResponse<bo>, x> bVar = this.fetchEndCallback;
        if (bVar != null) {
            bVar.invoke(iResponse);
            AppMethodBeat.o(244757);
            return;
        }
        AppMethodBeat.o(244757);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0016¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader$PoiDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
    public final class c extends com.tencent.mm.plugin.finder.feed.model.internal.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(244750);
            List<Integer> listOf = j.listOf((Object) 5225);
            AppMethodBeat.o(244750);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genRefreshNetScene() {
            ca caVar;
            AppMethodBeat.i(244751);
            eaa eaa = FinderPoiFeedLoader.this.tWy;
            y.a aVar = FinderPoiFeedLoader.this.tWz;
            if (eaa == null || aVar == null) {
                caVar = null;
            } else {
                caVar = new ca(eaa, aVar, FinderPoiFeedLoader.this.getLastBuffer(), (byte) 0);
                caVar.pullType = 0;
            }
            ca caVar2 = caVar;
            AppMethodBeat.o(244751);
            return caVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genLoadMoreNetScene() {
            ca caVar;
            AppMethodBeat.i(244752);
            eaa eaa = FinderPoiFeedLoader.this.tWy;
            y.a aVar = FinderPoiFeedLoader.this.tWz;
            if (eaa == null || aVar == null) {
                caVar = null;
            } else {
                caVar = new ca(eaa, aVar, FinderPoiFeedLoader.this.getLastBuffer(), (byte) 0);
                caVar.pullType = 2;
            }
            ca caVar2 = caVar;
            AppMethodBeat.o(244752);
            return caVar2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x005d A[LOOP:0: B:12:0x0057->B:14:0x005d, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0094  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00bc  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00e2  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00ee  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.tencent.mm.plugin.finder.feed.model.internal.IResponse<com.tencent.mm.plugin.finder.model.bo> dealOnSceneEnd(int r12, int r13, java.lang.String r14, com.tencent.mm.ak.q r15) {
            /*
            // Method dump skipped, instructions count: 352
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.model.FinderPoiFeedLoader.c.dealOnSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):com.tencent.mm.plugin.finder.feed.model.internal.IResponse");
        }
    }
}
