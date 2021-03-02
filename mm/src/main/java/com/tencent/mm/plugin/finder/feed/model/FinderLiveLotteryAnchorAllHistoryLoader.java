package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.live.model.cgi.ab;
import com.tencent.mm.plugin.finder.model.ap;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.avw;
import com.tencent.mm.protocal.protobuf.awj;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0016\u0017\u0018B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016R.\u0010\u0004\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "()V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "Companion", "LotteryAllHistoryFetcher", "LotteryAllHistoryResponse", "plugin-finder_release"})
public final class FinderLiveLotteryAnchorAllHistoryLoader extends BaseFeedLoader<bo> {
    public static final a tVW = new a((byte) 0);
    public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
    private boolean hasMore;

    static {
        AppMethodBeat.i(244701);
        AppMethodBeat.o(244701);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public FinderLiveLotteryAnchorAllHistoryLoader() {
        super(null);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(244699);
        b bVar = new b();
        AppMethodBeat.o(244699);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        AppMethodBeat.i(244700);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(iResponse);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, bVar.axR());
        p.h(iResponse, "response");
        super.onFetchDone(iResponse);
        if (isInitOperation(iResponse)) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
            AppMethodBeat.o(244700);
            return;
        }
        this.hasMore = iResponse.getHasMore();
        com.tencent.mm.ac.d.h(new d(this, iResponse));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
        AppMethodBeat.o(244700);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader$LotteryAllHistoryResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
    public static final class c extends IResponse<bo> {
        public c(int i2, int i3, String str) {
            super(i2, i3, str);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0016¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader$LotteryAllHistoryFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
    public final class b extends com.tencent.mm.plugin.finder.feed.model.internal.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(244694);
            List<Integer> listOf = j.listOf((Object) 6484);
            AppMethodBeat.o(244694);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final q genRefreshNetScene() {
            AppMethodBeat.i(244695);
            ab abVar = new ab(1, 0, 0, "", FinderLiveLotteryAnchorAllHistoryLoader.this.getLastBuffer());
            abVar.pullType = 0;
            ab abVar2 = abVar;
            AppMethodBeat.o(244695);
            return abVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final q genLoadMoreNetScene() {
            AppMethodBeat.i(244696);
            ab abVar = new ab(1, 0, 0, "", FinderLiveLotteryAnchorAllHistoryLoader.this.getLastBuffer());
            abVar.pullType = 2;
            ab abVar2 = abVar;
            AppMethodBeat.o(244696);
            return abVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(244697);
            p.h(qVar, "scene");
            Log.i(getTAG(), "onSceneEnd: errType " + i2 + ", errCode " + i3 + " errMsg " + str);
            c cVar = new c(i2, i3, str);
            if ((qVar instanceof ab) && i2 == 0 && i3 == 0) {
                com.tencent.mm.bw.a aYK = ((ab) qVar).rr.aYK();
                if (aYK == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryHistoryResponse");
                    AppMethodBeat.o(244697);
                    throw tVar;
                }
                cVar.setLastBuffer(((avw) aYK).lastBuffer);
                com.tencent.mm.bw.a aYK2 = ((ab) qVar).rr.aYK();
                if (aYK2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryHistoryResponse");
                    AppMethodBeat.o(244697);
                    throw tVar2;
                }
                cVar.setHasMore(((avw) aYK2).continueFlag == 1);
                LinkedList<awj> dgI = ((ab) qVar).dgI();
                ArrayList arrayList = new ArrayList(j.a(dgI, 10));
                for (T t : dgI) {
                    p.g(t, LocaleUtil.ITALIAN);
                    arrayList.add(new ap(t));
                }
                cVar.setIncrementList(arrayList);
                cVar.setPullType(((ab) qVar).pullType);
            }
            c cVar2 = cVar;
            AppMethodBeat.o(244697);
            return cVar2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ IResponse $response;
        final /* synthetic */ FinderLiveLotteryAnchorAllHistoryLoader tVX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderLiveLotteryAnchorAllHistoryLoader finderLiveLotteryAnchorAllHistoryLoader, IResponse iResponse) {
            super(0);
            this.tVX = finderLiveLotteryAnchorAllHistoryLoader;
            this.$response = iResponse;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            AppMethodBeat.i(244698);
            kotlin.g.a.b<? super IResponse<bo>, x> bVar = this.tVX.fetchEndCallback;
            if (bVar != null) {
                bVar.invoke(this.$response);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244698);
            return xVar;
        }
    }
}
