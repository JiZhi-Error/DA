package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.cgi.co;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002*+B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0$H\u0016J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0&H\u0016J\b\u0010'\u001a\u00020\u001eH\u0016J\u0016\u0010(\u001a\u00020\r2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016R.\u0010\t\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isTimeline", "", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "refObjectId", "", "getRefObjectId", "()J", "setRefObjectId", "(J)V", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getPageName", "onFetchDone", "response", "FavDataFetcher", "FinderFavListResponse", "plugin-finder_release"})
public final class FinderFavFeedLoader extends BaseFinderFeedLoader {
    public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
    public int gAZ;
    public boolean hasMore;
    private final String sBN;
    final boolean tUS;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFavFeedLoader(String str, bbn bbn, boolean z) {
        super(bbn);
        p.h(str, "finderUserName");
        AppMethodBeat.i(244576);
        this.sBN = str;
        this.tUS = z;
        AppMethodBeat.o(244576);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(244573);
        a aVar = new a();
        AppMethodBeat.o(244573);
        return aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u001a\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
    public static final class c extends BaseFeedLoader<bo>.a {
        final /* synthetic */ FinderFavFeedLoader tUT;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderFavFeedLoader finderFavFeedLoader) {
            super();
            this.tUT = finderFavFeedLoader;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void mergeRefresh(IResponse<bo> iResponse, kotlin.g.a.b<? super IResponse<bo>, x> bVar) {
            boolean z;
            int i2;
            List<bo> incrementList;
            int i3 = 0;
            AppMethodBeat.i(244572);
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
            cVar.iMa = (E) Integer.valueOf(((b) iResponse).gAZ);
            Log.i(this.tUT.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(cVar)));
            List<bo> incrementList2 = iResponse.getIncrementList();
            if (incrementList2 != null) {
                i3 = incrementList2.size();
            }
            if (iResponse.getHasMore()) {
                if (i3 <= this.tUT.getDataList().size()) {
                    i2 = 2;
                }
                i2 = 4;
            } else {
                if ((this.tUT.getDataList().size() == 0 || i3 == 0 || this.tUT.getDataList().size() <= i3) && (incrementList = iResponse.getIncrementList()) != null && incrementList.containsAll(j.p(this.tUT.getDataList()))) {
                    i2 = 6;
                }
                i2 = 4;
            }
            d.h(new a(this, new n(i2, iResponse.getIncrementList(), iResponse.isNeedClear(), 8), cVar, bVar, iResponse));
            AppMethodBeat.o(244572);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ n $op;
            final /* synthetic */ RefreshLoadMoreLayout.c $reason;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ c tUV;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, n nVar, RefreshLoadMoreLayout.c cVar2, kotlin.g.a.b bVar, IResponse iResponse) {
                super(0);
                this.tUV = cVar;
                this.$op = nVar;
                this.$reason = cVar2;
                this.$next = bVar;
                this.$response = iResponse;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(244571);
                this.tUV.convertOpToReason(this.$op, this.$reason);
                this.tUV.tUT.dispatcher().onPreFinishRefresh(this.$reason);
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(244571);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger() {
        AppMethodBeat.i(244574);
        c cVar = new c(this);
        AppMethodBeat.o(244574);
        return cVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FinderFavListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "totalCount", "megaVideoCount", "(IILjava/lang/String;II)V", "getMegaVideoCount", "()I", "setMegaVideoCount", "(I)V", "getTotalCount", "setTotalCount", "plugin-finder_release"})
    public static final class b extends IResponse<bo> {
        int gAZ;
        public int tUU;

        private b(int i2, int i3, String str, int i4) {
            super(i2, i3, str);
            this.gAZ = i4;
            this.tUU = 0;
        }

        public /* synthetic */ b(int i2, int i3, String str, int i4, byte b2) {
            this(i2, i3, str, i4);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        AppMethodBeat.i(244575);
        p.h(iResponse, "response");
        super.onFetchDone(iResponse);
        if (isInitOperation(iResponse)) {
            AppMethodBeat.o(244575);
            return;
        }
        if (iResponse.getPullType() == 0 && (iResponse instanceof b)) {
            this.gAZ = ((b) iResponse).gAZ;
        }
        this.hasMore = iResponse.getHasMore();
        kotlin.g.a.b<? super IResponse<bo>, x> bVar = this.fetchEndCallback;
        if (bVar != null) {
            bVar.invoke(iResponse);
            AppMethodBeat.o(244575);
            return;
        }
        AppMethodBeat.o(244575);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J2\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0016¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FavDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
    public final class a extends com.tencent.mm.plugin.finder.feed.model.internal.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(244566);
            List<Integer> listOf = j.listOf((Object) 3966);
            AppMethodBeat.o(244566);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genRefreshNetScene() {
            AppMethodBeat.i(244567);
            co coVar = new co(FinderFavFeedLoader.this.sBN, FinderFavFeedLoader.this.getLastBuffer(), FinderFavFeedLoader.this.getContextObj());
            coVar.pullType = 0;
            co coVar2 = coVar;
            AppMethodBeat.o(244567);
            return coVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genLoadMoreNetScene() {
            AppMethodBeat.i(244568);
            co coVar = new co(FinderFavFeedLoader.this.sBN, FinderFavFeedLoader.this.getLastBuffer(), FinderFavFeedLoader.this.getContextObj());
            coVar.pullType = 2;
            co coVar2 = coVar;
            AppMethodBeat.o(244568);
            return coVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            boolean z;
            AppMethodBeat.i(244569);
            p.h(qVar, "scene");
            if (qVar instanceof co) {
                if (i2 == 0 && i3 == 0 && ((co) qVar).cYA() == 0) {
                    z = false;
                } else {
                    z = true;
                }
                b bVar = new b(i2, i3, str, ((co) qVar).cZm(), (byte) 0);
                List<FinderObject> cYD = ((co) qVar).cYD();
                ArrayList arrayList = new ArrayList(j.a(cYD, 10));
                Iterator<T> it = cYD.iterator();
                while (it.hasNext()) {
                    FinderItem.a aVar = FinderItem.Companion;
                    FinderItem a2 = FinderItem.a.a((FinderObject) it.next(), 256);
                    c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    arrayList.add(c.a.s(a2));
                }
                bVar.setIncrementList(arrayList);
                c.a aVar3 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                c.a.a(((co) qVar).cYD(), 256, FinderFavFeedLoader.this.getContextObj());
                if (((co) qVar).pullType != 2) {
                    c.a aVar4 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    List incrementList = bVar.getIncrementList();
                    if (incrementList == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.collections.List<com.tencent.mm.plugin.finder.model.BaseFinderFeed>");
                        AppMethodBeat.o(244569);
                        throw tVar;
                    }
                    c.a.b(incrementList, 256, true);
                    bVar.gAZ = ((co) qVar).cZm();
                    bVar.tUU = ((co) qVar).cYy();
                }
                String tag = getTAG();
                StringBuilder sb = new StringBuilder("incrementList size: ");
                List incrementList2 = bVar.getIncrementList();
                Log.i(tag, sb.append(incrementList2 != null ? Integer.valueOf(incrementList2.size()) : null).toString());
                bVar.setPullType(((co) qVar).pullType);
                bVar.setLastBuffer(((co) qVar).cYz());
                bVar.setHasMore(z);
                b bVar2 = bVar;
                AppMethodBeat.o(244569);
                return bVar2;
            }
            AppMethodBeat.o(244569);
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> callInit() {
            ArrayList<bo> arrayList;
            com.tencent.mm.bw.b bVar = null;
            AppMethodBeat.i(244570);
            Log.i(getTAG(), "fetchInit initCount ");
            b bVar2 = new b(0, 0, "", 0, (byte) 0);
            if (FinderFavFeedLoader.this.tUS) {
                h cache = FinderFavFeedLoader.this.getCache();
                if (cache != null) {
                    arrayList = cache.kgc;
                } else {
                    arrayList = null;
                }
                bVar2.setIncrementList(arrayList);
                h cache2 = FinderFavFeedLoader.this.getCache();
                if (cache2 != null) {
                    bVar = cache2.lastBuffer;
                }
                bVar2.setLastBuffer(bVar);
            } else {
                bVar2.setIncrementList(l.a.a(com.tencent.mm.plugin.finder.storage.data.l.vGw, FinderFavFeedLoader.this.getPageName()));
            }
            b bVar3 = bVar2;
            AppMethodBeat.o(244570);
            return bVar3;
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final int getPageName() {
        return 10;
    }
}
