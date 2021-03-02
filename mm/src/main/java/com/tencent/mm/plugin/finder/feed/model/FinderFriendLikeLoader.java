package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.cgi.bm;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.aa;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0003 !\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001cH\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u001eH\u0016J\u0016\u0010\u0016\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016R.\u0010\u0007\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R.\u0010\u0016\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "onFetchDone", "getOnFetchDone", "setOnFetchDone", "getTargetUsername", "()Ljava/lang/String;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "response", "Companion", "FriendLikeDataFetcher", "LikedTimelineResponse", "plugin-finder_release"})
public final class FinderFriendLikeLoader extends BaseFinderFeedLoader {
    private static final ConcurrentHashMap<String, List<bo>> tVA = new ConcurrentHashMap<>();
    public static final a tVB = new a((byte) 0);
    public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
    private boolean hasMore;
    public kotlin.g.a.b<? super IResponse<bo>, x> tVz;
    final String tvp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFriendLikeLoader(String str, bbn bbn) {
        super(bbn);
        p.h(str, "targetUsername");
        AppMethodBeat.i(244649);
        this.tvp = str;
        AppMethodBeat.o(244649);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$Companion;", "", "()V", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(244650);
        AppMethodBeat.o(244650);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(244646);
        b bVar = new b();
        AppMethodBeat.o(244646);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u001a\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
    public static final class d extends BaseFeedLoader<bo>.a {
        final /* synthetic */ FinderFriendLikeLoader tVC;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderFriendLikeLoader finderFriendLikeLoader) {
            super();
            this.tVC = finderFriendLikeLoader;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void mergeRefresh(IResponse<bo> iResponse, kotlin.g.a.b<? super IResponse<bo>, x> bVar) {
            boolean z;
            AppMethodBeat.i(244645);
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
            Log.i(this.tVC.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(cVar)));
            com.tencent.mm.ac.d.h(new a(this, new n(7, iResponse.getIncrementList(), iResponse.isNeedClear(), 8), cVar, bVar, iResponse));
            AppMethodBeat.o(244645);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ n $op;
            final /* synthetic */ RefreshLoadMoreLayout.c $reason;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ d tVD;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, n nVar, RefreshLoadMoreLayout.c cVar, kotlin.g.a.b bVar, IResponse iResponse) {
                super(0);
                this.tVD = dVar;
                this.$op = nVar;
                this.$reason = cVar;
                this.$next = bVar;
                this.$response = iResponse;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(244644);
                this.tVD.convertOpToReason(this.$op, this.$reason);
                this.tVD.tVC.dispatcher().onChanged();
                this.tVD.tVC.dispatcher().onPreFinishRefresh(this.$reason);
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(244644);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger() {
        AppMethodBeat.i(244647);
        d dVar = new d(this);
        AppMethodBeat.o(244647);
        return dVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
    public static final class c extends IResponse<bo> {
        public c(int i2, int i3, String str) {
            super(i2, i3, str);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        kotlin.g.a.b<? super IResponse<bo>, x> bVar;
        AppMethodBeat.i(244648);
        p.h(iResponse, "response");
        super.onFetchDone(iResponse);
        if (isInitOperation(iResponse)) {
            AppMethodBeat.o(244648);
            return;
        }
        kotlin.g.a.b<? super IResponse<bo>, x> bVar2 = this.tVz;
        if (bVar2 != null) {
            bVar2.invoke(iResponse);
        }
        this.hasMore = iResponse.getHasMore();
        if (iResponse.getHasMore() || (bVar = this.fetchEndCallback) == null) {
            AppMethodBeat.o(244648);
            return;
        }
        bVar.invoke(iResponse);
        AppMethodBeat.o(244648);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J2\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0016¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$FriendLikeDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimelineResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
    public final class b extends com.tencent.mm.plugin.finder.feed.model.internal.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(244639);
            List<Integer> listOf = j.listOf((Object) 3965);
            AppMethodBeat.o(244639);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            boolean z;
            c cVar;
            ArrayList arrayList;
            c cVar2;
            List incrementList;
            AppMethodBeat.i(244642);
            p.h(qVar, "scene");
            bm bmVar = (bm) qVar;
            if (i3 == -4100) {
                aa aaVar = aa.vYi;
                aa.aww(FinderFriendLikeLoader.this.tvp);
            }
            if (i2 == 0 && i3 == 0) {
                z = bmVar.cYA() == 1;
            } else {
                z = i3 != -4100;
            }
            if (i3 != -4100) {
                cVar = new c(i2, i3, str);
            } else {
                cVar = new c(0, 0, "");
            }
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
                cVar2 = cVar;
            } else {
                arrayList = null;
                cVar2 = cVar;
            }
            cVar2.setIncrementList(arrayList);
            cVar.setPullType(bmVar.pullType);
            cVar.setLastBuffer(bmVar.cYz());
            cVar.setHasMore(z);
            if (bmVar.pullType == 0 && (incrementList = cVar.getIncrementList()) != null) {
                FinderFriendLikeLoader.tVA.put(FinderFriendLikeLoader.this.tvp, incrementList);
            }
            c cVar3 = cVar;
            AppMethodBeat.o(244642);
            return cVar3;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final /* synthetic */ com.tencent.mm.ak.q genRefreshNetScene() {
            AppMethodBeat.i(244640);
            bm bmVar = new bm(0, FinderFriendLikeLoader.this.getLastBuffer(), 0, FinderFriendLikeLoader.this.tvp, FinderFriendLikeLoader.this.getContextObj(), 0, false, 32);
            AppMethodBeat.o(244640);
            return bmVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final /* synthetic */ com.tencent.mm.ak.q genLoadMoreNetScene() {
            AppMethodBeat.i(244641);
            bm bmVar = new bm(0, FinderFriendLikeLoader.this.getLastBuffer(), 2, FinderFriendLikeLoader.this.tvp, FinderFriendLikeLoader.this.getContextObj(), 0, false, 32);
            AppMethodBeat.o(244641);
            return bmVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final /* synthetic */ IResponse callInit() {
            AppMethodBeat.i(244643);
            c cVar = new c(0, 0, "");
            ArrayList arrayList = (List) FinderFriendLikeLoader.tVA.get(FinderFriendLikeLoader.this.tvp);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            cVar.setIncrementList(arrayList);
            cVar.setLastBuffer(null);
            c cVar2 = cVar;
            AppMethodBeat.o(244643);
            return cVar2;
        }
    }
}
