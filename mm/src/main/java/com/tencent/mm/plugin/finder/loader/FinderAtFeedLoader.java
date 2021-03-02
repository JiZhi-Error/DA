package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.bp;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00046789B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020$03H\u0016J\b\u00104\u001a\u00020\u001dH\u0016J\u0016\u00105\u001a\u00020\u00162\f\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016R\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R=\u0010!\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020$0#¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u0016\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "finderUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "cachedState", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$CacheState;", "getCachedState", "()Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$CacheState;", "setCachedState", "(Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$CacheState;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFinderUsername", "isLoading", "", "()Z", "setLoading", "(Z)V", "refreshCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/ParameterName;", "name", "response", "getRefreshCallback", "()Lkotlin/jvm/functions/Function1;", "setRefreshCallback", "(Lkotlin/jvm/functions/Function1;)V", "state", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$State;", "getState", "()Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$State;", "setState", "(Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$State;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "isObservePostEvent", "onFetchDone", "AtDataFetcher", "CacheState", "FinderAtTimelineResponse", "State", "plugin-finder_release"})
public final class FinderAtFeedLoader extends BaseFinderFeedLoader {
    private String TAG = "Finder.AtTimelineLoader";
    final String finderUsername;
    public kotlin.g.a.a<x> tTS;
    public kotlin.g.a.b<? super IResponse<bo>, x> tVa;
    public d uHR = d.INIT;
    public b uHS = b.INIT;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$CacheState;", "", "(Ljava/lang/String;I)V", TMAssistantDownloadSDKClientBase.CONNTECTSTATE_INIT, "NO_CACHE", "WITH_CACHED", "plugin-finder_release"})
    public enum b {
        INIT,
        NO_CACHE,
        WITH_CACHED;

        static {
            AppMethodBeat.i(248195);
            AppMethodBeat.o(248195);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(248197);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(248197);
            return bVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$State;", "", "(Ljava/lang/String;I)V", TMAssistantDownloadSDKClientBase.CONNTECTSTATE_INIT, "LOADING", "LOADED", "FAILURE", "plugin-finder_release"})
    public enum d {
        INIT,
        LOADING,
        LOADED,
        FAILURE;

        static {
            AppMethodBeat.i(248198);
            AppMethodBeat.o(248198);
        }

        public static d valueOf(String str) {
            AppMethodBeat.i(248200);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(248200);
            return dVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderAtFeedLoader(e eVar, String str, bbn bbn) {
        super(bbn);
        p.h(eVar, "scene");
        p.h(str, "finderUsername");
        AppMethodBeat.i(248205);
        this.finderUsername = str;
        AppMethodBeat.o(248205);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.DataStore
    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.DataStore
    public final void setTAG(String str) {
        AppMethodBeat.i(248201);
        p.h(str, "<set-?>");
        this.TAG = str;
        AppMethodBeat.o(248201);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(248202);
        a aVar = new a();
        AppMethodBeat.o(248202);
        return aVar;
    }

    public final void a(d dVar) {
        AppMethodBeat.i(248203);
        p.h(dVar, "<set-?>");
        this.uHR = dVar;
        AppMethodBeat.o(248203);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        kotlin.g.a.a<x> aVar;
        kotlin.g.a.b<? super IResponse<bo>, x> bVar;
        AppMethodBeat.i(248204);
        p.h(iResponse, "response");
        super.onFetchDone(iResponse);
        this.uHS = getDataListJustForAdapter().size() > 0 ? b.WITH_CACHED : b.NO_CACHE;
        if (isInitOperation(iResponse)) {
            AppMethodBeat.o(248204);
            return;
        }
        if (isRefreshOperation(iResponse) && (bVar = this.tVa) != null) {
            bVar.invoke(iResponse);
        }
        if (iResponse.getHasMore() || (aVar = this.tTS) == null) {
            AppMethodBeat.o(248204);
            return;
        }
        aVar.invoke();
        AppMethodBeat.o(248204);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final boolean isObservePostEvent() {
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$FinderAtTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
    public static final class c extends IResponse<bo> {
        public c(int i2, int i3, String str) {
            super(i2, i3, str);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J2\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0016¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$AtDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
    public final class a extends com.tencent.mm.plugin.finder.feed.model.internal.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(248189);
            List<Integer> listOf = j.listOf((Object) 3810);
            AppMethodBeat.o(248189);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a, com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetch(Object obj, f<bo> fVar) {
            AppMethodBeat.i(248190);
            p.h(fVar, "callback");
            super.fetch(obj, fVar);
            FinderAtFeedLoader.this.a(d.LOADING);
            AppMethodBeat.o(248190);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final q genRefreshNetScene() {
            AppMethodBeat.i(248191);
            bp bpVar = new bp(FinderAtFeedLoader.this.finderUsername, FinderAtFeedLoader.this.getLastBuffer());
            bpVar.pullType = 1;
            bp bpVar2 = bpVar;
            AppMethodBeat.o(248191);
            return bpVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final q genLoadMoreNetScene() {
            AppMethodBeat.i(248192);
            bp bpVar = new bp(FinderAtFeedLoader.this.finderUsername, FinderAtFeedLoader.this.getLastBuffer());
            bpVar.pullType = 2;
            bp bpVar2 = bpVar;
            AppMethodBeat.o(248192);
            return bpVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> callInit() {
            ArrayList<bo> arrayList;
            com.tencent.mm.bw.b bVar = null;
            AppMethodBeat.i(248193);
            h cache = FinderAtFeedLoader.this.getCache();
            if (cache == null || cache.kgc == null) {
                c cVar = new c(0, 0, "");
                List<bo> bc = com.tencent.mm.plugin.finder.storage.data.l.vGw.bc(14, FinderAtFeedLoader.this.finderUsername);
                Log.i(getTAG(), "[callInit] page list=" + bc.size());
                cVar.setIncrementList(bc);
                cVar.setLastBuffer(null);
                cVar.setHasMore(true);
                c cVar2 = cVar;
                AppMethodBeat.o(248193);
                return cVar2;
            }
            c cVar3 = new c(0, 0, "");
            h cache2 = FinderAtFeedLoader.this.getCache();
            if (cache2 != null) {
                arrayList = cache2.kgc;
            } else {
                arrayList = null;
            }
            cVar3.setIncrementList(arrayList);
            h cache3 = FinderAtFeedLoader.this.getCache();
            if (cache3 != null) {
                bVar = cache3.lastBuffer;
            }
            cVar3.setLastBuffer(bVar);
            cVar3.setHasMore(true);
            c cVar4 = cVar3;
            AppMethodBeat.o(248193);
            return cVar4;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0064 A[LOOP:0: B:16:0x005e->B:18:0x0064, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00c5  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00e5  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00f4  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00f6  */
        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.tencent.mm.plugin.finder.feed.model.internal.IResponse<com.tencent.mm.plugin.finder.model.bo> dealOnSceneEnd(int r11, int r12, java.lang.String r13, com.tencent.mm.ak.q r14) {
            /*
            // Method dump skipped, instructions count: 289
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader.a.dealOnSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):com.tencent.mm.plugin.finder.feed.model.internal.IResponse");
        }
    }
}
