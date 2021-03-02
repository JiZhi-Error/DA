package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.cu;
import com.tencent.mm.plugin.finder.cgi.cv;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003'()B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0!H\u0016J\u0016\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0%H\u0016J\b\u0010&\u001a\u00020#H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoRelatedLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "feedId", "", "nonceId", "", "sessionId", "sessionBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFeedId", "()J", "firstUserName", "getFirstUserName", "()Ljava/lang/String;", "setFirstUserName", "(Ljava/lang/String;)V", "needGetDetail", "", "getNeedGetDetail", "()Z", "setNeedGetDetail", "(Z)V", "getNonceId", "getSessionBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getSessionId", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "requestRefresh", "MegaVideoGetDetailResponse", "MegaVideoListResponse", "RelatedMegaVideoDataFetcher", "plugin-finder_release"})
public final class FinderMegaVideoRelatedLoader extends BaseMegaVideoLoader {
    final long feedId;
    final String hwg;
    final String sessionId;
    final com.tencent.mm.bw.b tvj;
    String uKW;
    boolean uKX;

    public /* synthetic */ FinderMegaVideoRelatedLoader(long j2, String str, bbn bbn) {
        this(j2, str, "", bbn);
        AppMethodBeat.i(248415);
        AppMethodBeat.o(248415);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FinderMegaVideoRelatedLoader(long j2, String str, String str2, bbn bbn) {
        super(bbn);
        p.h(str, "nonceId");
        AppMethodBeat.i(248414);
        this.feedId = j2;
        this.hwg = str;
        this.sessionId = str2;
        this.tvj = null;
        this.uKW = "";
        this.uKX = true;
        AppMethodBeat.o(248414);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(248410);
        c cVar = new c();
        AppMethodBeat.o(248410);
        return cVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u001a\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoRelatedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeInit", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
    public static final class d extends BaseFeedLoader<bo>.a {
        final /* synthetic */ FinderMegaVideoRelatedLoader uKY;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderMegaVideoRelatedLoader finderMegaVideoRelatedLoader) {
            super();
            this.uKY = finderMegaVideoRelatedLoader;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void mergeInit(IResponse<bo> iResponse, kotlin.g.a.b<? super IResponse<bo>, x> bVar) {
            AppMethodBeat.i(248409);
            p.h(iResponse, "response");
            if (iResponse instanceof a) {
                if (iResponse.getIncrementList() == null) {
                    iResponse.setIncrementList(v.SXr);
                }
                com.tencent.mm.ac.d.h(new a(this, iResponse, bVar));
                AppMethodBeat.o(248409);
                return;
            }
            super.mergeInit(iResponse, bVar);
            AppMethodBeat.o(248409);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ d uKZ;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, IResponse iResponse, kotlin.g.a.b bVar) {
                super(0);
                this.uKZ = dVar;
                this.$response = iResponse;
                this.$next = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                boolean z;
                bm bmVar = null;
                AppMethodBeat.i(248408);
                if (this.uKZ.uKY.getDataList().size() > 0) {
                    List incrementList = this.$response.getIncrementList();
                    if (incrementList != null) {
                        if (incrementList.size() == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        List list = z ? incrementList : null;
                        if (list != null) {
                            Object obj = this.uKZ.uKY.getDataList().get(0);
                            if (obj instanceof bm) {
                                bmVar = obj;
                            }
                            bm bmVar2 = bmVar;
                            if (bmVar2 != null) {
                                Object obj2 = list.get(0);
                                if (obj2 == null) {
                                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.MegaVideoFeed");
                                    AppMethodBeat.o(248408);
                                    throw tVar;
                                }
                                bmVar2.g(((bm) obj2).getFeedObject());
                            }
                            this.uKZ.uKY.dispatcher().onItemRangeChanged(0, 1, new o(0, 1));
                        }
                    }
                } else {
                    DataBuffer dataList = this.uKZ.uKY.getDataList();
                    List incrementList2 = this.$response.getIncrementList();
                    if (incrementList2 == null) {
                        p.hyc();
                    }
                    dataList.addAll(incrementList2);
                    this.uKZ.uKY.dispatcher().onChanged();
                }
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(248408);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger() {
        AppMethodBeat.i(248411);
        d dVar = new d(this);
        AppMethodBeat.o(248411);
        return dVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoRelatedLoader$MegaVideoGetDetailResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
    public static final class a extends IResponse<bo> {
        public a(int i2, int i3, String str) {
            super(i2, i3, str);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoRelatedLoader$MegaVideoListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
    public static final class b extends IResponse<bo> {
        public b(String str) {
            super(0, 0, str);
        }
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        int i2;
        String str;
        AppMethodBeat.i(248412);
        p.h(iResponse, "response");
        super.onFetchDone(iResponse);
        if (isInitOperation(iResponse)) {
            List<bo> incrementList = iResponse.getIncrementList();
            if (incrementList != null) {
                i2 = incrementList.size();
            } else {
                i2 = 0;
            }
            if (i2 > 0 && (iResponse instanceof b)) {
                List<bo> incrementList2 = iResponse.getIncrementList();
                if (incrementList2 == null) {
                    p.hyc();
                }
                bo boVar = incrementList2.get(0);
                if (boVar == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.MegaVideoFeed");
                    AppMethodBeat.o(248412);
                    throw tVar;
                }
                FinderContact finderContact = ((bm) boVar).contact;
                if (finderContact == null || (str = finderContact.username) == null) {
                    str = "";
                }
                this.uKW = str;
                iResponse.setHasMore(true);
                kotlin.g.a.b<? super IResponse<bo>, x> bVar = this.fetchEndCallback;
                if (bVar != null) {
                    bVar.invoke(iResponse);
                    AppMethodBeat.o(248412);
                    return;
                }
            }
            AppMethodBeat.o(248412);
            return;
        }
        this.hasMore = iResponse.getHasMore();
        kotlin.g.a.b<? super IResponse<bo>, x> bVar2 = this.fetchEndCallback;
        if (bVar2 != null) {
            bVar2.invoke(iResponse);
            AppMethodBeat.o(248412);
            return;
        }
        AppMethodBeat.o(248412);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final void requestRefresh() {
        AppMethodBeat.i(248413);
        requestLoadMore();
        AppMethodBeat.o(248413);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J2\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0015H\u0016¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoRelatedLoader$RelatedMegaVideoDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoRelatedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetchInit", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
    public final class c extends com.tencent.mm.plugin.finder.feed.model.internal.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(248403);
            List<Integer> listOf = j.listOf((Object[]) new Integer[]{4195, 6432});
            AppMethodBeat.o(248403);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genRefreshNetScene() {
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genLoadMoreNetScene() {
            AppMethodBeat.i(248404);
            cv cvVar = new cv(FinderMegaVideoRelatedLoader.this.feedId, FinderMegaVideoRelatedLoader.this.hwg, FinderMegaVideoRelatedLoader.this.getLastBuffer(), FinderMegaVideoRelatedLoader.this.sessionId, FinderMegaVideoRelatedLoader.this.tvj, FinderMegaVideoRelatedLoader.this.getContextObj());
            cvVar.pullType = 2;
            cv cvVar2 = cvVar;
            AppMethodBeat.o(248404);
            return cvVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            Integer num = null;
            AppMethodBeat.i(248405);
            p.h(qVar, "scene");
            if (qVar instanceof cu) {
                ayj cZr = ((cu) qVar).cZr();
                a aVar = new a(i2, i3, str);
                aVar.setIncrementList(j.listOf(new bm(cZr)));
                aVar.setPullType(1000);
                String tag = getTAG();
                StringBuilder append = new StringBuilder("NetSceneMegaVideoGetDetail errType = ").append(i2).append(", errCode = ").append(i3).append(", size = ");
                List incrementList = aVar.getIncrementList();
                if (incrementList != null) {
                    num = Integer.valueOf(incrementList.size());
                }
                Log.i(tag, append.append(num).toString());
                a aVar2 = aVar;
                AppMethodBeat.o(248405);
                return aVar2;
            }
            AppMethodBeat.o(248405);
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> callInit() {
            ArrayList<bo> arrayList;
            com.tencent.mm.bw.b bVar;
            AppMethodBeat.i(248406);
            b bVar2 = new b("");
            bVar2.setPullType(1000);
            h cache = FinderMegaVideoRelatedLoader.this.getCache();
            if (!(cache == null || (arrayList = cache.kgc) == null)) {
                Log.i(getTAG(), "fetchInit: use old data list, size: " + arrayList.size());
                bVar2.setIncrementList(arrayList);
                h cache2 = FinderMegaVideoRelatedLoader.this.getCache();
                if (cache2 != null) {
                    bVar = cache2.lastBuffer;
                } else {
                    bVar = null;
                }
                bVar2.setLastBuffer(bVar);
            }
            b bVar3 = bVar2;
            AppMethodBeat.o(248406);
            return bVar3;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a, com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetchInit(f<bo> fVar) {
            AppMethodBeat.i(248407);
            p.h(fVar, "callback");
            super.fetchInit(fVar);
            if (FinderMegaVideoRelatedLoader.this.feedId != 0 && FinderMegaVideoRelatedLoader.this.uKX) {
                fetch(new cu(FinderMegaVideoRelatedLoader.this.feedId, FinderMegaVideoRelatedLoader.this.uKW, FinderMegaVideoRelatedLoader.this.hwg, FinderMegaVideoRelatedLoader.this.getContextObj()), fVar);
            }
            AppMethodBeat.o(248407);
        }
    }
}
