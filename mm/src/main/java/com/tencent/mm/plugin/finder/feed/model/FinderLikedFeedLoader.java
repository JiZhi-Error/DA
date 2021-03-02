package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.cgi.bm;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
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
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002./B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0016J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020&0(H\u0016J\b\u0010)\u001a\u00020\u001fH\u0016J\u0016\u0010*\u001a\u00020\u000b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020&0,H\u0016J\u0016\u0010-\u001a\u00020\u000b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020&0,H\u0014R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "isTimeLine", "", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ZLcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "fetchRefreshCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedTimelineResponse;", "getFetchRefreshCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchRefreshCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "getScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getPageName", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "onFetchRefreshDone", "LikedDataFetcher", "LikedTimelineResponse", "plugin-finder_release"})
public final class FinderLikedFeedLoader extends BaseFinderFeedLoader {
    public int gAZ;
    public boolean hasMore = true;
    final boolean jqK;
    public kotlin.g.a.a<x> tTS;
    public kotlin.g.a.b<? super b, x> tVS;
    private final e tVT;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLikedFeedLoader(boolean z, e eVar, bbn bbn) {
        super(bbn);
        p.h(eVar, "scene");
        AppMethodBeat.i(244693);
        this.jqK = z;
        this.tVT = eVar;
        AppMethodBeat.o(244693);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(244690);
        a aVar = new a();
        AppMethodBeat.o(244690);
        return aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u001a\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
    public static final class c extends BaseFeedLoader<bo>.a {
        final /* synthetic */ FinderLikedFeedLoader tVU;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderLikedFeedLoader finderLikedFeedLoader) {
            super();
            this.tVU = finderLikedFeedLoader;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void mergeRefresh(IResponse<bo> iResponse, kotlin.g.a.b<? super IResponse<bo>, x> bVar) {
            boolean z;
            int i2;
            int i3 = 0;
            AppMethodBeat.i(244689);
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
            Log.i(this.tVU.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(cVar)));
            List<bo> incrementList = iResponse.getIncrementList();
            if (incrementList != null) {
                i3 = incrementList.size();
            }
            if (iResponse.getHasMore()) {
                if (i3 > this.tVU.getDataList().size()) {
                    i2 = 4;
                } else {
                    i2 = 2;
                }
            } else if (this.tVU.getDataList().size() == 0 || i3 == 0 || this.tVU.getDataList().size() <= i3) {
                i2 = 6;
            } else {
                i2 = 4;
            }
            d.h(new a(this, new n(i2, iResponse.getIncrementList(), iResponse.isNeedClear(), 8), cVar, bVar, iResponse));
            AppMethodBeat.o(244689);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ n $op;
            final /* synthetic */ RefreshLoadMoreLayout.c $reason;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ c tVV;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, n nVar, RefreshLoadMoreLayout.c cVar2, kotlin.g.a.b bVar, IResponse iResponse) {
                super(0);
                this.tVV = cVar;
                this.$op = nVar;
                this.$reason = cVar2;
                this.$next = bVar;
                this.$response = iResponse;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(244688);
                this.tVV.convertOpToReason(this.$op, this.$reason);
                this.tVV.tVU.dispatcher().onPreFinishRefresh(this.$reason);
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(244688);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger() {
        AppMethodBeat.i(244691);
        c cVar = new c(this);
        AppMethodBeat.o(244691);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        kotlin.g.a.a<x> aVar;
        AppMethodBeat.i(166040);
        p.h(iResponse, "response");
        super.onFetchDone(iResponse);
        if (isInitOperation(iResponse)) {
            AppMethodBeat.o(166040);
            return;
        }
        this.hasMore = iResponse.getHasMore();
        if (!(2 == iResponse.getPullType()) || iResponse.getHasMore() || (aVar = this.tTS) == null) {
            AppMethodBeat.o(166040);
            return;
        }
        aVar.invoke();
        AppMethodBeat.o(166040);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final void onFetchRefreshDone(IResponse<bo> iResponse) {
        AppMethodBeat.i(244692);
        p.h(iResponse, "response");
        super.onFetchRefreshDone(iResponse);
        if (iResponse instanceof b) {
            this.gAZ = ((b) iResponse).gAZ;
            kotlin.g.a.b<? super b, x> bVar = this.tVS;
            if (bVar != null) {
                bVar.invoke(iResponse);
                AppMethodBeat.o(244692);
                return;
            }
        }
        AppMethodBeat.o(244692);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "totalCount", "megaVideoCount", "(IILjava/lang/String;II)V", "getMegaVideoCount", "()I", "setMegaVideoCount", "(I)V", "getTotalCount", "setTotalCount", "plugin-finder_release"})
    public static final class b extends IResponse<bo> {
        public int gAZ;
        public int tUU;

        private b(int i2, int i3, String str) {
            super(i2, i3, str);
            this.gAZ = 0;
            this.tUU = 0;
        }

        public /* synthetic */ b(int i2, int i3, String str, byte b2) {
            this(i2, i3, str);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J2\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0016¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedTimelineResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "getCmdIds", "", "plugin-finder_release"})
    public final class a extends com.tencent.mm.plugin.finder.feed.model.internal.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(244683);
            List<Integer> listOf = j.listOf((Object) 3965);
            AppMethodBeat.o(244683);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genLoadMoreNetScene() {
            FinderItem finderItem;
            FinderObject feedObject;
            AppMethodBeat.i(244685);
            BaseFinderFeed baseFinderFeed = (BaseFinderFeed) FinderLikedFeedLoader.this.getLastItemOfType(BaseFinderFeed.class);
            bm bmVar = new bm((baseFinderFeed == null || (finderItem = baseFinderFeed.feedObject) == null || (feedObject = finderItem.getFeedObject()) == null) ? 0 : feedObject.displayId, FinderLikedFeedLoader.this.getLastBuffer(), 2, null, FinderLikedFeedLoader.this.getContextObj(), 0, false, 104);
            AppMethodBeat.o(244685);
            return bmVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            boolean z;
            ArrayList arrayList;
            b bVar;
            AppMethodBeat.i(244686);
            p.h(qVar, "scene");
            bm bmVar = (bm) qVar;
            if (i2 == 0 && i3 == 0 && bmVar.cYA() != 1) {
                z = false;
            } else {
                z = true;
            }
            b bVar2 = new b(i2, i3, str, (byte) 0);
            List<? extends FinderItem> list = bmVar.tvo;
            if (list != null) {
                List<? extends FinderItem> list2 = list;
                ArrayList arrayList2 = new ArrayList(j.a(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    arrayList2.add(c.a.s(it.next()));
                }
                arrayList = arrayList2;
                bVar = bVar2;
            } else {
                arrayList = null;
                bVar = bVar2;
            }
            bVar.setIncrementList(arrayList);
            bVar2.setPullType(bmVar.pullType);
            bVar2.setLastBuffer(bmVar.cYz());
            bVar2.setHasMore(z);
            bVar2.gAZ = bmVar.getCount();
            bVar2.tUU = bmVar.cYy();
            b bVar3 = bVar2;
            AppMethodBeat.o(244686);
            return bVar3;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final /* synthetic */ com.tencent.mm.ak.q genRefreshNetScene() {
            AppMethodBeat.i(244684);
            bm bmVar = new bm(0, FinderLikedFeedLoader.this.getLastBuffer(), 1, null, FinderLikedFeedLoader.this.getContextObj(), 0, false, 104);
            AppMethodBeat.o(244684);
            return bmVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final /* synthetic */ IResponse callInit() {
            ArrayList<bo> arrayList;
            com.tencent.mm.bw.b bVar = null;
            AppMethodBeat.i(244687);
            Log.i(getTAG(), "fetchInit");
            b bVar2 = new b(0, 0, "", (byte) 0);
            if (FinderLikedFeedLoader.this.jqK) {
                h cache = FinderLikedFeedLoader.this.getCache();
                if (cache != null) {
                    arrayList = cache.kgc;
                } else {
                    arrayList = null;
                }
                bVar2.setIncrementList(arrayList);
                h cache2 = FinderLikedFeedLoader.this.getCache();
                if (cache2 != null) {
                    bVar = cache2.lastBuffer;
                }
                bVar2.setLastBuffer(bVar);
            } else {
                bVar2.setIncrementList(l.a.a(com.tencent.mm.plugin.finder.storage.data.l.vGw, FinderLikedFeedLoader.this.getPageName()));
            }
            b bVar3 = bVar2;
            AppMethodBeat.o(244687);
            return bVar3;
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final int getPageName() {
        return 2;
    }
}
