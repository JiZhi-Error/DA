package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.live.model.cgi.aa;
import com.tencent.mm.plugin.finder.model.aq;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.awk;
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

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\"#$B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0002\u0010\tJ\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001fH\u0016J\u0016\u0010 \u001a\u00020\r2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016R.\u0010\n\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001b¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lotteryId", "", "liveId", "", "objectId", "objectNonceId", "(Ljava/lang/String;JJLjava/lang/String;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "getLiveId", "()J", "getLotteryId", "()Ljava/lang/String;", "getObjectId", "getObjectNonceId", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "Companion", "LotteryListFetcher", "LotteryWinnerListResponse", "plugin-finder_release"})
public final class FinderLiveLotteryListLoader extends BaseFeedLoader<bo> {
    public static final a tWc = new a((byte) 0);
    public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
    public final long hFK;
    private boolean hasMore;
    final long liveId;
    final String objectNonceId;
    public final String tWb;

    static {
        AppMethodBeat.i(244719);
        AppMethodBeat.o(244719);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveLotteryListLoader(String str, long j2, long j3, String str2) {
        super(null);
        p.h(str, "lotteryId");
        p.h(str2, "objectNonceId");
        AppMethodBeat.i(244718);
        this.tWb = str;
        this.liveId = j2;
        this.hFK = j3;
        this.objectNonceId = str2;
        AppMethodBeat.o(244718);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(244716);
        b bVar = new b();
        AppMethodBeat.o(244716);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        AppMethodBeat.i(244717);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(iResponse);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, bVar.axR());
        p.h(iResponse, "response");
        super.onFetchDone(iResponse);
        if (isInitOperation(iResponse)) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
            AppMethodBeat.o(244717);
            return;
        }
        this.hasMore = iResponse.getHasMore();
        com.tencent.mm.ac.d.h(new d(this, iResponse));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
        AppMethodBeat.o(244717);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader$LotteryWinnerListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "lotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "isMessageOpen", "", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;Z)V", "()Z", "getLotteryInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "plugin-finder_release"})
    public static final class c extends IResponse<bo> {
        public final awi tWe;
        public final boolean tWf;

        public /* synthetic */ c(int i2, int i3, String str) {
            this(i2, i3, str, null, false);
        }

        public c(int i2, int i3, String str, awi awi, boolean z) {
            super(i2, i3, str);
            this.tWe = awi;
            this.tWf = z;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0016¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader$LotteryListFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
    public final class b extends com.tencent.mm.plugin.finder.feed.model.internal.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(244711);
            List<Integer> listOf = j.listOf((Object) 5258);
            AppMethodBeat.o(244711);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final q genRefreshNetScene() {
            AppMethodBeat.i(244712);
            aa aaVar = new aa(FinderLiveLotteryListLoader.this.liveId, FinderLiveLotteryListLoader.this.hFK, com.tencent.mm.ac.d.Ga(FinderLiveLotteryListLoader.this.objectNonceId), FinderLiveLotteryListLoader.this.tWb, FinderLiveLotteryListLoader.this.getLastBuffer());
            aaVar.pullType = 0;
            aa aaVar2 = aaVar;
            AppMethodBeat.o(244712);
            return aaVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final q genLoadMoreNetScene() {
            AppMethodBeat.i(244713);
            aa aaVar = new aa(FinderLiveLotteryListLoader.this.liveId, FinderLiveLotteryListLoader.this.hFK, com.tencent.mm.ac.d.Ga(FinderLiveLotteryListLoader.this.objectNonceId), FinderLiveLotteryListLoader.this.tWb, FinderLiveLotteryListLoader.this.getLastBuffer());
            aaVar.pullType = 2;
            aa aaVar2 = aaVar;
            AppMethodBeat.o(244713);
            return aaVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, q qVar) {
            LinkedList<awh> linkedList;
            boolean z = true;
            AppMethodBeat.i(244714);
            p.h(qVar, "scene");
            Log.i(getTAG(), "onSceneEnd: errType " + i2 + ", errCode " + i3 + " errMsg " + str);
            c cVar = new c(i2, i3, str);
            if ((qVar instanceof aa) && i2 == 0 && i3 == 0) {
                com.tencent.mm.bw.a aYK = ((aa) qVar).rr.aYK();
                if (aYK == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryRecordResponse");
                    AppMethodBeat.o(244714);
                    throw tVar;
                }
                awi awi = ((avy) aYK).tWe;
                com.tencent.mm.bw.a aYK2 = ((aa) qVar).rr.aYK();
                if (aYK2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryRecordResponse");
                    AppMethodBeat.o(244714);
                    throw tVar2;
                }
                cVar = new c(i2, i3, str, awi, ((avy) aYK2).LGu == 0);
                com.tencent.mm.bw.a aYK3 = ((aa) qVar).rr.aYK();
                if (aYK3 == null) {
                    t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryRecordResponse");
                    AppMethodBeat.o(244714);
                    throw tVar3;
                }
                cVar.setLastBuffer(((avy) aYK3).lastBuffer);
                com.tencent.mm.bw.a aYK4 = ((aa) qVar).rr.aYK();
                if (aYK4 == null) {
                    t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryRecordResponse");
                    AppMethodBeat.o(244714);
                    throw tVar4;
                }
                if (((avy) aYK4).continueFlag != 1) {
                    z = false;
                }
                cVar.setHasMore(z);
                com.tencent.mm.bw.a aYK5 = ((aa) qVar).rr.aYK();
                if (aYK5 == null) {
                    t tVar5 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryRecordResponse");
                    AppMethodBeat.o(244714);
                    throw tVar5;
                }
                awk awk = ((avy) aYK5).LGt;
                if (awk == null || (linkedList = awk.LHf) == null) {
                    linkedList = new LinkedList<>();
                }
                LinkedList<awh> linkedList2 = linkedList;
                ArrayList arrayList = new ArrayList(j.a(linkedList2, 10));
                for (awh awh : linkedList2) {
                    p.g(awh, LocaleUtil.ITALIAN);
                    arrayList.add(new aq(awh));
                }
                cVar.setIncrementList(arrayList);
                cVar.setPullType(((aa) qVar).pullType);
            }
            c cVar2 = cVar;
            AppMethodBeat.o(244714);
            return cVar2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ IResponse $response;
        final /* synthetic */ FinderLiveLotteryListLoader tWd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderLiveLotteryListLoader finderLiveLotteryListLoader, IResponse iResponse) {
            super(0);
            this.tWd = finderLiveLotteryListLoader;
            this.$response = iResponse;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            AppMethodBeat.i(244715);
            kotlin.g.a.b<? super IResponse<bo>, x> bVar = this.tWd.fetchEndCallback;
            if (bVar != null) {
                bVar.invoke(this.$response);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244715);
            return xVar;
        }
    }
}
