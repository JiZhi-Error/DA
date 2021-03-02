package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.live.model.cgi.z;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0016J\u0016\u0010\u0018\u001a\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016R.\u0010\t\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "liveId", "", "objectId", "objectNonceId", "", "(JJLjava/lang/String;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getLiveId", "()J", "getObjectId", "getObjectNonceId", "()Ljava/lang/String;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "Companion", "LiveWecoinHotFetcher", "LiveWecoinHotResponse", "plugin-finder_release"})
public final class FinderLiveWecoinHotLoader extends BaseFeedLoader<bo> {
    public static final a tWt = new a((byte) 0);
    public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
    final long hFK;
    final long liveId;
    final String objectNonceId;

    static {
        AppMethodBeat.i(244749);
        AppMethodBeat.o(244749);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveWecoinHotLoader(long j2, long j3, String str) {
        super(null);
        p.h(str, "objectNonceId");
        AppMethodBeat.i(244748);
        this.liveId = j2;
        this.hFK = j3;
        this.objectNonceId = str;
        AppMethodBeat.o(244748);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(244746);
        b bVar = new b();
        AppMethodBeat.o(244746);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        AppMethodBeat.i(244747);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(iResponse);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, bVar.axR());
        p.h(iResponse, "response");
        super.onFetchDone(iResponse);
        if (isInitOperation(iResponse)) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
            AppMethodBeat.o(244747);
            return;
        }
        com.tencent.mm.ac.d.h(new d(this, iResponse));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
        AppMethodBeat.o(244747);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader$LiveWecoinHotResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "wecoinHotList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardGainsInfo;", "totalWecoinHot", "", "(IILjava/lang/String;Ljava/util/LinkedList;J)V", "getTotalWecoinHot", "()J", "getWecoinHotList", "()Ljava/util/LinkedList;", "plugin-finder_release"})
    public static final class c extends IResponse<bo> {
        public final LinkedList<axa> tWv;
        public final long tWw;

        public /* synthetic */ c(int i2, int i3, String str) {
            this(i2, i3, str, new LinkedList(), 0);
            AppMethodBeat.i(244744);
            AppMethodBeat.o(244744);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(int i2, int i3, String str, LinkedList<axa> linkedList, long j2) {
            super(i2, i3, str);
            p.h(linkedList, "wecoinHotList");
            AppMethodBeat.i(244743);
            this.tWv = linkedList;
            this.tWw = j2;
            AppMethodBeat.o(244743);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0016¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader$LiveWecoinHotFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
    public final class b extends com.tencent.mm.plugin.finder.feed.model.internal.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(244739);
            List<Integer> listOf = j.listOf((Object) 4168);
            AppMethodBeat.o(244739);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final q genRefreshNetScene() {
            AppMethodBeat.i(244740);
            z zVar = new z(FinderLiveWecoinHotLoader.this.liveId, FinderLiveWecoinHotLoader.this.hFK, FinderLiveWecoinHotLoader.this.objectNonceId, FinderLiveWecoinHotLoader.this.getLastBuffer());
            AppMethodBeat.o(244740);
            return zVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final q genLoadMoreNetScene() {
            AppMethodBeat.i(244741);
            z zVar = new z(FinderLiveWecoinHotLoader.this.liveId, FinderLiveWecoinHotLoader.this.hFK, FinderLiveWecoinHotLoader.this.objectNonceId, FinderLiveWecoinHotLoader.this.getLastBuffer());
            AppMethodBeat.o(244741);
            return zVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, q qVar) {
            c cVar;
            AppMethodBeat.i(244742);
            p.h(qVar, "scene");
            Log.i(getTAG(), "onSceneEnd: errType " + i2 + ", errCode " + i3 + " errMsg " + str);
            c cVar2 = new c(i2, i3, str);
            if ((qVar instanceof z) && i2 == 0 && i3 == 0) {
                Iterator<T> it = ((z) qVar).dgH().iterator();
                while (it.hasNext()) {
                    FinderLiveWecoinHotLoader.this.getDataList().add(new am(((z) qVar).dgH().size(), ((z) qVar).hTl(), it.next()));
                }
                com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.hVh().value().intValue() == 1) {
                    LinkedList<axa> dgH = ((z) qVar).dgH();
                    com.tencent.mm.bw.a aYK = ((z) qVar).rr.aYK();
                    if (aYK == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRewardGainsResponse");
                        AppMethodBeat.o(244742);
                        throw tVar;
                    }
                    cVar = new c(i2, i3, str, dgH, ((asy) aYK).ViH);
                } else {
                    cVar = new c(i2, i3, str, ((z) qVar).dgH(), ((z) qVar).hTl());
                }
            } else {
                cVar = cVar2;
            }
            c cVar4 = cVar;
            AppMethodBeat.o(244742);
            return cVar4;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ IResponse $response;
        final /* synthetic */ FinderLiveWecoinHotLoader tWu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderLiveWecoinHotLoader finderLiveWecoinHotLoader, IResponse iResponse) {
            super(0);
            this.tWu = finderLiveWecoinHotLoader;
            this.$response = iResponse;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            AppMethodBeat.i(244745);
            kotlin.g.a.b<? super IResponse<bo>, x> bVar = this.tWu.fetchEndCallback;
            if (bVar != null) {
                bVar.invoke(this.$response);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244745);
            return xVar;
        }
    }
}
