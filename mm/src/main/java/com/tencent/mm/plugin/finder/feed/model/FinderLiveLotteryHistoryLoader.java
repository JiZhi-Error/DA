package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.live.model.cgi.ab;
import com.tencent.mm.plugin.finder.model.an;
import com.tencent.mm.plugin.finder.model.ao;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.avw;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.awj;
import com.tencent.mm.protocal.protobuf.axv;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003$%&B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020!H\u0016J\u0016\u0010\"\u001a\u00020\u000e2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016R.\u0010\u000b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "scene", "", "liveId", "", "objectId", "objectNonceId", "", "(IJJLjava/lang/String;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "getLiveId", "()J", "getObjectId", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "Companion", "LotteryHistoryFetcher", "LotteryHistoryResponse", "plugin-finder_release"})
public final class FinderLiveLotteryHistoryLoader extends BaseFeedLoader<bo> {
    public static final a tVY = new a((byte) 0);
    public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
    final long hFK;
    private boolean hasMore;
    final long liveId;
    final String objectNonceId;
    public final int scene;

    static {
        AppMethodBeat.i(244710);
        AppMethodBeat.o(244710);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveLotteryHistoryLoader(int i2, long j2, long j3, String str) {
        super(null);
        p.h(str, "objectNonceId");
        AppMethodBeat.i(244709);
        this.scene = i2;
        this.liveId = j2;
        this.hFK = j3;
        this.objectNonceId = str;
        AppMethodBeat.o(244709);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(244707);
        b bVar = new b();
        AppMethodBeat.o(244707);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        AppMethodBeat.i(244708);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(iResponse);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, bVar.axR());
        p.h(iResponse, "response");
        super.onFetchDone(iResponse);
        if (isInitOperation(iResponse)) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
            AppMethodBeat.o(244708);
            return;
        }
        this.hasMore = iResponse.getHasMore();
        com.tencent.mm.ac.d.h(new d(this, iResponse));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
        AppMethodBeat.o(244708);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader$LotteryHistoryResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, "Lcom/tencent/mm/plugin/finder/model/FinderLotteryHistoryHeader;", "(IILjava/lang/String;Lcom/tencent/mm/plugin/finder/model/FinderLotteryHistoryHeader;)V", "getHeader", "()Lcom/tencent/mm/plugin/finder/model/FinderLotteryHistoryHeader;", "plugin-finder_release"})
    public static final class c extends IResponse<bo> {
        public final ao tWa;

        public /* synthetic */ c(int i2, int i3, String str) {
            this(i2, i3, str, null);
        }

        public c(int i2, int i3, String str, ao aoVar) {
            super(i2, i3, str);
            this.tWa = aoVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0016¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader$LotteryHistoryFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
    public final class b extends com.tencent.mm.plugin.finder.feed.model.internal.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(244702);
            List<Integer> listOf = j.listOf((Object) 6484);
            AppMethodBeat.o(244702);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final q genRefreshNetScene() {
            AppMethodBeat.i(244703);
            ab abVar = new ab(FinderLiveLotteryHistoryLoader.this.scene, FinderLiveLotteryHistoryLoader.this.liveId, FinderLiveLotteryHistoryLoader.this.hFK, FinderLiveLotteryHistoryLoader.this.objectNonceId, FinderLiveLotteryHistoryLoader.this.getLastBuffer());
            abVar.pullType = 0;
            ab abVar2 = abVar;
            AppMethodBeat.o(244703);
            return abVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final q genLoadMoreNetScene() {
            AppMethodBeat.i(244704);
            ab abVar = new ab(FinderLiveLotteryHistoryLoader.this.scene, FinderLiveLotteryHistoryLoader.this.liveId, FinderLiveLotteryHistoryLoader.this.hFK, FinderLiveLotteryHistoryLoader.this.objectNonceId, FinderLiveLotteryHistoryLoader.this.getLastBuffer());
            abVar.pullType = 2;
            ab abVar2 = abVar;
            AppMethodBeat.o(244704);
            return abVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, q qVar) {
            ArrayList arrayList;
            c cVar;
            LinkedList<awi> linkedList;
            LinkedList<awj> linkedList2;
            awj awj;
            LinkedList<awj> linkedList3;
            awj awj2;
            AppMethodBeat.i(244705);
            p.h(qVar, "scene");
            Log.i(getTAG(), "onSceneEnd: errType " + i2 + ", errCode " + i3 + " errMsg " + str);
            c cVar2 = new c(i2, i3, str);
            if ((qVar instanceof ab) && i2 == 0 && i3 == 0) {
                awj awj3 = (awj) j.kt(((ab) qVar).dgI());
                c cVar3 = new c(i2, i3, str, awj3 != null ? new ao(((long) awj3.LHd) * 1000, awj3.LHe.size()) : null);
                com.tencent.mm.bw.a aYK = ((ab) qVar).rr.aYK();
                if (aYK == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryHistoryResponse");
                    AppMethodBeat.o(244705);
                    throw tVar;
                }
                axv axv = ((avw) aYK).LGr;
                cVar3.setLastBuffer((axv == null || (linkedList3 = axv.LIc) == null || (awj2 = (awj) j.kt(linkedList3)) == null) ? null : awj2.LDs);
                com.tencent.mm.bw.a aYK2 = ((ab) qVar).rr.aYK();
                if (aYK2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryHistoryResponse");
                    AppMethodBeat.o(244705);
                    throw tVar2;
                }
                axv axv2 = ((avw) aYK2).LGr;
                Integer valueOf = (axv2 == null || (linkedList2 = axv2.LIc) == null || (awj = (awj) j.kt(linkedList2)) == null) ? null : Integer.valueOf(awj.tUC);
                cVar3.setHasMore(valueOf != null && valueOf.intValue() == 1);
                if (awj3 == null || (linkedList = awj3.LHe) == null) {
                    arrayList = null;
                    cVar = cVar3;
                } else {
                    LinkedList<awi> linkedList4 = linkedList;
                    ArrayList arrayList2 = new ArrayList(j.a(linkedList4, 10));
                    for (T t : linkedList4) {
                        p.g(t, LocaleUtil.ITALIAN);
                        arrayList2.add(new an(t));
                    }
                    arrayList = arrayList2;
                    cVar = cVar3;
                }
                cVar.setIncrementList(arrayList);
                cVar3.setPullType(((ab) qVar).pullType);
                cVar2 = cVar3;
            }
            c cVar4 = cVar2;
            AppMethodBeat.o(244705);
            return cVar4;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ IResponse $response;
        final /* synthetic */ FinderLiveLotteryHistoryLoader tVZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderLiveLotteryHistoryLoader finderLiveLotteryHistoryLoader, IResponse iResponse) {
            super(0);
            this.tVZ = finderLiveLotteryHistoryLoader;
            this.$response = iResponse;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            AppMethodBeat.i(244706);
            kotlin.g.a.b<? super IResponse<bo>, x> bVar = this.tVZ.fetchEndCallback;
            if (bVar != null) {
                bVar.invoke(this.$response);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244706);
            return xVar;
        }
    }
}
