package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.co;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.plugin.finder.storage.data.u;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "megaVideoCount", "", "getMegaVideoCount", "()I", "setMegaVideoCount", "(I)V", "totalCount", "getTotalCount", "setTotalCount", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "FavMegaVideoDataFetcher", "FinderFavMegaVideoListResponse", "plugin-finder_release"})
public final class FinderFavMegaVideoLoader extends BaseMegaVideoLoader {
    public int gAZ;
    private final String sBN;
    public int tUU;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFavMegaVideoLoader(String str, bbn bbn) {
        super(bbn);
        p.h(str, "finderUserName");
        AppMethodBeat.i(248377);
        this.sBN = str;
        AppMethodBeat.o(248377);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(248374);
        a aVar = new a();
        AppMethodBeat.o(248374);
        return aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u001a\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
    public static final class c extends BaseFeedLoader<bo>.a {
        final /* synthetic */ FinderFavMegaVideoLoader uKL;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderFavMegaVideoLoader finderFavMegaVideoLoader) {
            super();
            this.uKL = finderFavMegaVideoLoader;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void mergeRefresh(IResponse<bo> iResponse, kotlin.g.a.b<? super IResponse<bo>, x> bVar) {
            AppMethodBeat.i(248373);
            p.h(iResponse, "response");
            RefreshLoadMoreLayout.c.a aVar = RefreshLoadMoreLayout.c.Rms;
            d.h(new a(this, new n(7, iResponse.getIncrementList(), false, 12), new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.Rmm), bVar, iResponse));
            AppMethodBeat.o(248373);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ n $op;
            final /* synthetic */ RefreshLoadMoreLayout.c $reason;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ c uKN;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, n nVar, RefreshLoadMoreLayout.c cVar2, kotlin.g.a.b bVar, IResponse iResponse) {
                super(0);
                this.uKN = cVar;
                this.$op = nVar;
                this.$reason = cVar2;
                this.$next = bVar;
                this.$response = iResponse;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(248372);
                this.uKN.convertOpToReason(this.$op, this.$reason);
                this.uKN.uKL.dispatcher().onPreFinishRefresh(this.$reason);
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(248372);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger() {
        AppMethodBeat.i(248375);
        c cVar = new c(this);
        AppMethodBeat.o(248375);
        return cVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nR\u001a\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader$FinderFavMegaVideoListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "megaVideoTotalCount", "totalCount", "(IILjava/lang/String;II)V", "getMegaVideoTotalCount", "()I", "setMegaVideoTotalCount", "(I)V", "getTotalCount", "setTotalCount", "plugin-finder_release"})
    public static final class b extends IResponse<bo> {
        int gAZ;
        int uKM;

        public b(int i2, int i3, String str, int i4, int i5) {
            super(i2, i3, str);
            this.uKM = i4;
            this.gAZ = i5;
        }
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        AppMethodBeat.i(248376);
        p.h(iResponse, "response");
        super.onFetchDone(iResponse);
        if (isInitOperation(iResponse)) {
            AppMethodBeat.o(248376);
            return;
        }
        if ((iResponse instanceof b) && iResponse.getPullType() == 0) {
            this.gAZ = ((b) iResponse).gAZ;
            this.tUU = ((b) iResponse).uKM;
        }
        this.hasMore = iResponse.getHasMore();
        kotlin.g.a.b<? super IResponse<bo>, x> bVar = this.fetchEndCallback;
        if (bVar != null) {
            bVar.invoke(iResponse);
            AppMethodBeat.o(248376);
            return;
        }
        AppMethodBeat.o(248376);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J2\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0016¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader$FavMegaVideoDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
    public final class a extends com.tencent.mm.plugin.finder.feed.model.internal.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(248367);
            List<Integer> listOf = j.listOf((Object) 3966);
            AppMethodBeat.o(248367);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genRefreshNetScene() {
            AppMethodBeat.i(248368);
            co coVar = new co(FinderFavMegaVideoLoader.this.sBN, FinderFavMegaVideoLoader.this.getLastBuffer(), FinderFavMegaVideoLoader.this.getContextObj(), 1);
            coVar.pullType = 0;
            co coVar2 = coVar;
            AppMethodBeat.o(248368);
            return coVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genLoadMoreNetScene() {
            AppMethodBeat.i(248369);
            co coVar = new co(FinderFavMegaVideoLoader.this.sBN, FinderFavMegaVideoLoader.this.getLastBuffer(), FinderFavMegaVideoLoader.this.getContextObj(), 1);
            coVar.pullType = 2;
            co coVar2 = coVar;
            AppMethodBeat.o(248369);
            return coVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(248370);
            p.h(qVar, "scene");
            if (qVar instanceof co) {
                boolean z = i2 != 0 || i3 != 0 || ((co) qVar).cYA() != 0;
                b bVar = new b(i2, i3, str, ((co) qVar).cYy(), ((co) qVar).cZm());
                bVar.setPullType(((co) qVar).pullType);
                List<FinderObject> cYD = ((co) qVar).cYD();
                ArrayList arrayList = new ArrayList(j.a(cYD, 10));
                Iterator<T> it = cYD.iterator();
                while (it.hasNext()) {
                    arrayList.add(new bm((FinderObject) it.next()));
                }
                ArrayList<bm> arrayList2 = arrayList;
                bVar.setIncrementList(arrayList2);
                String tag = getTAG();
                StringBuilder sb = new StringBuilder("incrementList size: ");
                List incrementList = bVar.getIncrementList();
                Log.i(tag, sb.append(incrementList != null ? Integer.valueOf(incrementList.size()) : null).toString());
                bVar.setLastBuffer(((co) qVar).cYz());
                bVar.setHasMore(z);
                c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                c.a.b(((co) qVar).cYD(), FinderFavMegaVideoLoader.this.getContextObj());
                if (bVar.getPullType() != 2) {
                    LinkedList linkedList = new LinkedList();
                    for (bm bmVar : arrayList2) {
                        linkedList.add(new u(bmVar.lT(), 1, bmVar.getFeedObject()));
                    }
                    if (linkedList.size() > 0) {
                        l.a aVar2 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
                        String aUg = z.aUg();
                        p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                        l.a.a(12, aUg, linkedList);
                    }
                    Log.i(getTAG(), "FavMegaVideoDataFetcher FinderPage size: " + linkedList.size());
                }
                b bVar2 = bVar;
                AppMethodBeat.o(248370);
                return bVar2;
            }
            AppMethodBeat.o(248370);
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> callInit() {
            ArrayList<bo> arrayList;
            com.tencent.mm.bw.b bVar;
            AppMethodBeat.i(248371);
            Log.i(getTAG(), "fetchInit");
            b bVar2 = new b(0, 0, "", 0, 0);
            bVar2.setPullType(1000);
            h cache = FinderFavMegaVideoLoader.this.getCache();
            if (cache == null || (arrayList = cache.kgc) == null) {
                List a2 = l.a.a(com.tencent.mm.plugin.finder.storage.data.l.vGw, 12);
                Log.i(getTAG(), "fetchInit: use first page data list, size: " + a2.size());
                bVar2.setIncrementList(a2);
                bVar2.uKM = a2.size();
            } else {
                Log.i(getTAG(), "fetchInit: use old data list, size: " + arrayList.size());
                bVar2.setIncrementList(arrayList);
                bVar2.uKM = arrayList.size();
                h cache2 = FinderFavMegaVideoLoader.this.getCache();
                if (cache2 != null) {
                    bVar = cache2.lastBuffer;
                } else {
                    bVar = null;
                }
                bVar2.setLastBuffer(bVar);
            }
            b bVar3 = bVar2;
            AppMethodBeat.o(248371);
            return bVar3;
        }
    }
}
