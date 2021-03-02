package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bm;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
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

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J\u0016\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "megaVideoCount", "", "getMegaVideoCount", "()I", "setMegaVideoCount", "(I)V", "totalCount", "getTotalCount", "setTotalCount", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "FinderLikeMegaVideoListResponse", "LikeMegaVideoDataFetcher", "plugin-finder_release"})
public final class FinderLikeMegaVideoLoader extends BaseMegaVideoLoader {
    public int gAZ;
    public int tUU;

    public FinderLikeMegaVideoLoader(bbn bbn) {
        super(bbn);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(248385);
        b bVar = new b();
        AppMethodBeat.o(248385);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u001a\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
    public static final class c extends BaseFeedLoader<bo>.a {
        final /* synthetic */ FinderLikeMegaVideoLoader uKO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderLikeMegaVideoLoader finderLikeMegaVideoLoader) {
            super();
            this.uKO = finderLikeMegaVideoLoader;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void mergeRefresh(IResponse<bo> iResponse, kotlin.g.a.b<? super IResponse<bo>, x> bVar) {
            AppMethodBeat.i(248384);
            p.h(iResponse, "response");
            RefreshLoadMoreLayout.c.a aVar = RefreshLoadMoreLayout.c.Rms;
            d.h(new a(this, new n(7, iResponse.getIncrementList(), false, 12), new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.Rmm), bVar, iResponse));
            AppMethodBeat.o(248384);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ n $op;
            final /* synthetic */ RefreshLoadMoreLayout.c $reason;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ c uKP;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, n nVar, RefreshLoadMoreLayout.c cVar2, kotlin.g.a.b bVar, IResponse iResponse) {
                super(0);
                this.uKP = cVar;
                this.$op = nVar;
                this.$reason = cVar2;
                this.$next = bVar;
                this.$response = iResponse;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(248383);
                this.uKP.convertOpToReason(this.$op, this.$reason);
                this.uKP.uKO.dispatcher().onPreFinishRefresh(this.$reason);
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(248383);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger() {
        AppMethodBeat.i(248386);
        c cVar = new c(this);
        AppMethodBeat.o(248386);
        return cVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nR\u001a\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader$FinderLikeMegaVideoListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "megaVideoTotalCount", "totalCount", "(IILjava/lang/String;II)V", "getMegaVideoTotalCount", "()I", "setMegaVideoTotalCount", "(I)V", "getTotalCount", "setTotalCount", "plugin-finder_release"})
    public static final class a extends IResponse<bo> {
        int gAZ;
        int uKM;

        public a(int i2, int i3, String str, int i4, int i5) {
            super(i2, i3, str);
            this.uKM = i4;
            this.gAZ = i5;
        }
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        AppMethodBeat.i(248387);
        p.h(iResponse, "response");
        super.onFetchDone(iResponse);
        if (isInitOperation(iResponse)) {
            AppMethodBeat.o(248387);
            return;
        }
        if ((iResponse instanceof a) && iResponse.getPullType() == 0) {
            this.gAZ = ((a) iResponse).gAZ;
            this.tUU = ((a) iResponse).uKM;
        }
        this.hasMore = iResponse.getHasMore();
        kotlin.g.a.b<? super IResponse<bo>, x> bVar = this.fetchEndCallback;
        if (bVar != null) {
            bVar.invoke(iResponse);
            AppMethodBeat.o(248387);
            return;
        }
        AppMethodBeat.o(248387);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J2\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0016¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader$LikeMegaVideoDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
    public final class b extends com.tencent.mm.plugin.finder.feed.model.internal.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(248378);
            List<Integer> listOf = j.listOf((Object) 3965);
            AppMethodBeat.o(248378);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genRefreshNetScene() {
            AppMethodBeat.i(248379);
            bm bmVar = new bm(0, FinderLikeMegaVideoLoader.this.getLastBuffer(), 0, null, FinderLikeMegaVideoLoader.this.getContextObj(), 1, false, 72);
            AppMethodBeat.o(248379);
            return bmVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genLoadMoreNetScene() {
            FinderItem finderItem;
            FinderObject feedObject;
            AppMethodBeat.i(248380);
            BaseFinderFeed baseFinderFeed = (BaseFinderFeed) FinderLikeMegaVideoLoader.this.getLastItemOfType(BaseFinderFeed.class);
            bm bmVar = new bm((baseFinderFeed == null || (finderItem = baseFinderFeed.feedObject) == null || (feedObject = finderItem.getFeedObject()) == null) ? 0 : feedObject.displayId, FinderLikeMegaVideoLoader.this.getLastBuffer(), 2, null, FinderLikeMegaVideoLoader.this.getContextObj(), 1, false, 72);
            AppMethodBeat.o(248380);
            return bmVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            ArrayList<com.tencent.mm.plugin.finder.model.bm> arrayList;
            Integer num = null;
            AppMethodBeat.i(248381);
            p.h(qVar, "scene");
            if (qVar instanceof bm) {
                boolean z = i2 != 0 || i3 != 0 || ((bm) qVar).cYA() != 0;
                a aVar = new a(i2, i3, str, ((bm) qVar).cYy(), ((bm) qVar).getCount());
                aVar.setPullType(((bm) qVar).pullType);
                List<? extends FinderItem> list = ((bm) qVar).tvo;
                if (list != null) {
                    List<? extends FinderItem> list2 = list;
                    ArrayList arrayList2 = new ArrayList(j.a(list2, 10));
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(new com.tencent.mm.plugin.finder.model.bm(it.next().getFeedObject()));
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = null;
                }
                aVar.setIncrementList(arrayList);
                String tag = getTAG();
                StringBuilder sb = new StringBuilder("incrementList size: ");
                List incrementList = aVar.getIncrementList();
                if (incrementList != null) {
                    num = Integer.valueOf(incrementList.size());
                }
                Log.i(tag, sb.append(num).toString());
                aVar.setLastBuffer(((bm) qVar).cYz());
                aVar.setHasMore(z);
                if (arrayList != null) {
                    c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    ArrayList<com.tencent.mm.plugin.finder.model.bm> arrayList3 = arrayList;
                    ArrayList arrayList4 = new ArrayList(j.a(arrayList3, 10));
                    for (com.tencent.mm.plugin.finder.model.bm bmVar : arrayList3) {
                        arrayList4.add(bmVar.getFeedObject());
                    }
                    c.a.b(arrayList4, FinderLikeMegaVideoLoader.this.getContextObj());
                }
                if (aVar.getPullType() != 2) {
                    LinkedList linkedList = new LinkedList();
                    if (arrayList != null) {
                        for (com.tencent.mm.plugin.finder.model.bm bmVar2 : arrayList) {
                            linkedList.add(new u(bmVar2.lT(), 1, bmVar2.getFeedObject()));
                        }
                    }
                    if (linkedList.size() > 0) {
                        l.a aVar3 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
                        String aUg = z.aUg();
                        p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                        l.a.a(11, aUg, linkedList);
                    }
                    Log.i(getTAG(), "LikeMegaVideoDataFetcher FinderPage size: " + linkedList.size());
                }
                a aVar4 = aVar;
                AppMethodBeat.o(248381);
                return aVar4;
            }
            AppMethodBeat.o(248381);
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> callInit() {
            ArrayList<bo> arrayList;
            com.tencent.mm.bw.b bVar;
            AppMethodBeat.i(248382);
            Log.i(getTAG(), "fetchInit");
            a aVar = new a(0, 0, "", 0, 0);
            aVar.setPullType(1000);
            h cache = FinderLikeMegaVideoLoader.this.getCache();
            if (cache == null || (arrayList = cache.kgc) == null) {
                List a2 = l.a.a(com.tencent.mm.plugin.finder.storage.data.l.vGw, 11);
                Log.i(getTAG(), "fetchInit: use first page data list, size: " + a2.size());
                aVar.setIncrementList(a2);
                aVar.uKM = a2.size();
            } else {
                Log.i(getTAG(), "fetchInit: use old data list, size: " + arrayList.size());
                aVar.setIncrementList(arrayList);
                aVar.uKM = arrayList.size();
                h cache2 = FinderLikeMegaVideoLoader.this.getCache();
                if (cache2 != null) {
                    bVar = cache2.lastBuffer;
                } else {
                    bVar = null;
                }
                aVar.setLastBuffer(bVar);
            }
            a aVar2 = aVar;
            AppMethodBeat.o(248382);
            return aVar2;
        }
    }
}