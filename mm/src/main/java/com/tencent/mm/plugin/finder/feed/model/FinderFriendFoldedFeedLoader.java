package com.tencent.mm.plugin.finder.feed.model;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.protocal.protobuf.bbn;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002 !B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001bH\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001dH\u0016J\u0016\u0010\u001e\u001a\u00020\u00102\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR.\u0010\f\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0016\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "feedId", "", "nonceId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFeedId", "()J", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getFinderUserName", "()Ljava/lang/String;", "getNonceId", "setNonceId", "(Ljava/lang/String;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "FinderFoldedListResponse", "FoldedDataFetcher", "plugin-finder_release"})
public final class FinderFriendFoldedFeedLoader extends BaseFinderFeedLoader {
    final long feedId;
    public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
    String hwg;
    final String sBN;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFriendFoldedFeedLoader(String str, long j2, String str2, bbn bbn) {
        super(bbn);
        p.h(str, "finderUserName");
        p.h(str2, "nonceId");
        AppMethodBeat.i(244638);
        this.sBN = str;
        this.feedId = j2;
        this.hwg = str2;
        AppMethodBeat.o(244638);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(244635);
        b bVar = new b();
        AppMethodBeat.o(244635);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002J6\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "findMergeIndex", "", "srcList", "Ljava/util/ArrayList;", "newList", "", "cmd", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "", "plugin-finder_release"})
    public static final class c extends BaseFeedLoader<bo>.a {
        final /* synthetic */ FinderFriendFoldedFeedLoader tVy;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderFriendFoldedFeedLoader finderFriendFoldedFeedLoader) {
            super();
            this.tVy = finderFriendFoldedFeedLoader;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final int findMergeIndex(ArrayList<bo> arrayList, List<? extends bo> list, int i2, Object obj) {
            AppMethodBeat.i(244634);
            p.h(arrayList, "srcList");
            p.h(list, "newList");
            int size = this.tVy.getDataList().size();
            AppMethodBeat.o(244634);
            return size;
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger() {
        AppMethodBeat.i(244636);
        c cVar = new c(this);
        AppMethodBeat.o(244636);
        return cVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
    public static final class a extends IResponse<bo> {
        public a(int i2, int i3, String str) {
            super(i2, i3, str);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        kotlin.g.a.b<? super IResponse<bo>, x> bVar;
        AppMethodBeat.i(244637);
        p.h(iResponse, "response");
        super.onFetchDone(iResponse);
        if (isInitOperation(iResponse)) {
            AppMethodBeat.o(244637);
        } else if (iResponse.getHasMore() || (bVar = this.fetchEndCallback) == null) {
            AppMethodBeat.o(244637);
        } else {
            bVar.invoke(iResponse);
            AppMethodBeat.o(244637);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J2\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0016¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FoldedDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedListResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene1", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFoldedList;", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
    public final class b extends com.tencent.mm.plugin.finder.feed.model.internal.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(244629);
            List<Integer> listOf = j.listOf((Object) 3904);
            AppMethodBeat.o(244629);
            return listOf;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0051 A[LOOP:0: B:11:0x004b->B:13:0x0051, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00b3  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00bf  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00c1  */
        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.tencent.mm.plugin.finder.feed.model.internal.IResponse<com.tencent.mm.plugin.finder.model.bo> dealOnSceneEnd(int r9, int r10, java.lang.String r11, com.tencent.mm.ak.q r12) {
            /*
            // Method dump skipped, instructions count: 210
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.model.FinderFriendFoldedFeedLoader.b.dealOnSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):com.tencent.mm.plugin.finder.feed.model.internal.IResponse");
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final /* synthetic */ q genRefreshNetScene() {
            AppMethodBeat.i(244630);
            bi biVar = new bi(FinderFriendFoldedFeedLoader.this.sBN, FinderFriendFoldedFeedLoader.this.feedId, FinderFriendFoldedFeedLoader.this.hwg, FinderFriendFoldedFeedLoader.this.getLastBuffer(), FinderFriendFoldedFeedLoader.this.getContextObj());
            biVar.pullType = 0;
            bi biVar2 = biVar;
            AppMethodBeat.o(244630);
            return biVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final /* synthetic */ q genLoadMoreNetScene() {
            AppMethodBeat.i(244631);
            bi biVar = new bi(FinderFriendFoldedFeedLoader.this.sBN, FinderFriendFoldedFeedLoader.this.feedId, FinderFriendFoldedFeedLoader.this.hwg, FinderFriendFoldedFeedLoader.this.getLastBuffer(), FinderFriendFoldedFeedLoader.this.getContextObj());
            biVar.pullType = 2;
            bi biVar2 = biVar;
            AppMethodBeat.o(244631);
            return biVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final /* synthetic */ IResponse callInit() {
            com.tencent.mm.bw.b bVar = null;
            AppMethodBeat.i(244633);
            a aVar = new a(0, 0, "");
            h cache = FinderFriendFoldedFeedLoader.this.getCache();
            aVar.setIncrementList(cache != null ? cache.kgc : null);
            h cache2 = FinderFriendFoldedFeedLoader.this.getCache();
            if (cache2 != null) {
                bVar = cache2.lastBuffer;
            }
            aVar.setLastBuffer(bVar);
            List<bo> incrementList = aVar.getIncrementList();
            if (incrementList != null) {
                for (bo boVar : incrementList) {
                    if (boVar instanceof BaseFinderFeed) {
                        k kVar = k.vfA;
                        k.e(boVar.lT(), 14, ((BaseFinderFeed) boVar).feedObject.getFeedObject().sessionBuffer);
                    }
                }
            }
            a aVar2 = aVar;
            AppMethodBeat.o(244633);
            return aVar2;
        }
    }
}
