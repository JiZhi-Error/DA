package com.tencent.mm.plugin.finder.live;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.bn;
import com.tencent.mm.plugin.finder.cgi.bq;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.live.viewmodel.f;
import com.tencent.mm.protocal.protobuf.aov;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\rR0\u0010\u0004\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "()V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "loaderParams", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRelatedLoaderParam;", "getLoaderParams", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRelatedLoaderParam;", "setLoaderParams", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRelatedLoaderParam;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "setLoaderParam", NativeProtocol.WEB_DIALOG_PARAMS, "BaseDataFetcher", "FinderLiveRelResponse", "LiveRelatedDataFetcher", "NearbyLiveRelatedDataFetcher", "plugin-finder_release"})
public final class FinderLiveRelatedLoader extends BaseFeedLoader<com.tencent.mm.plugin.finder.live.viewmodel.c> {
    kotlin.g.a.b<? super IResponse<com.tencent.mm.plugin.finder.live.viewmodel.c>, x> fetchEndCallback;
    f ufx = new f();

    public FinderLiveRelatedLoader() {
        super(null, 1, null);
        AppMethodBeat.i(245821);
        AppMethodBeat.o(245821);
    }

    public final void a(f fVar) {
        AppMethodBeat.i(245818);
        p.h(fVar, NativeProtocol.WEB_DIALOG_PARAMS);
        this.ufx = fVar;
        AppMethodBeat.o(245818);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<com.tencent.mm.plugin.finder.live.viewmodel.c> createDataFetch() {
        AppMethodBeat.i(245819);
        if (this.ufx.uiy == 1) {
            d dVar = new d();
            AppMethodBeat.o(245819);
            return dVar;
        }
        c cVar = new c();
        AppMethodBeat.o(245819);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<com.tencent.mm.plugin.finder.live.viewmodel.c> iResponse) {
        AppMethodBeat.i(245820);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(iResponse);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, bVar.axR());
        p.h(iResponse, "response");
        kotlin.g.a.b<? super IResponse<com.tencent.mm.plugin.finder.live.viewmodel.c>, x> bVar2 = this.fetchEndCallback;
        if (bVar2 != null) {
            bVar2.invoke(iResponse);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
        AppMethodBeat.o(245820);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$FinderLiveRelResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
    public static final class b extends IResponse<com.tencent.mm.plugin.finder.live.viewmodel.c> {
        public b(int i2, int i3, String str) {
            super(i2, i3, str);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\n\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J0\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0007J \u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u0016\u0010\u0019\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u0016\u0010\u001a\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u0016\u0010\u001b\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u0016\u0010\u001c\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007J\b\u0010\u001f\u001a\u00020\u0010H\u0016J*\u0010 \u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0016R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$BaseDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;)V", "map", "", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "dead", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "fetch", "netscene", "", "callback", "fetchInit", "fetchLoadMore", "fetchPreload", "fetchRefresh", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdId", "onSceneEnd", "plugin-finder_release"})
    public class a extends g<com.tencent.mm.plugin.finder.live.viewmodel.c> implements i {
        private final Map<q, com.tencent.mm.plugin.finder.feed.model.internal.f<com.tencent.mm.plugin.finder.live.viewmodel.c>> map = new LinkedHashMap();

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
            AppMethodBeat.i(245815);
            AppMethodBeat.o(245815);
        }

        /* JADX WARNING: Removed duplicated region for block: B:55:0x0180  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x01e5  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x0209  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x0215  */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x0224  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x0226  */
        @Override // com.tencent.mm.ak.i
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onSceneEnd(int r19, int r20, java.lang.String r21, com.tencent.mm.ak.q r22) {
            /*
            // Method dump skipped, instructions count: 604
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.FinderLiveRelatedLoader.a.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public void fetch(Object obj, com.tencent.mm.plugin.finder.feed.model.internal.f<com.tencent.mm.plugin.finder.live.viewmodel.c> fVar) {
            AppMethodBeat.i(245808);
            p.h(fVar, "callback");
            if (obj != null && (obj instanceof q)) {
                this.map.put(obj, fVar);
                com.tencent.mm.kernel.g.azz().b((q) obj);
            }
            AppMethodBeat.o(245808);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public void alive() {
            AppMethodBeat.i(245809);
            super.alive();
            com.tencent.mm.kernel.g.azz().a(getCmdId(), this);
            AppMethodBeat.o(245809);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public void dead() {
            AppMethodBeat.i(245810);
            super.dead();
            com.tencent.mm.kernel.g.azz().b(getCmdId(), this);
            AppMethodBeat.o(245810);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public void fetchPreload(com.tencent.mm.plugin.finder.feed.model.internal.f<com.tencent.mm.plugin.finder.live.viewmodel.c> fVar) {
            AppMethodBeat.i(245811);
            p.h(fVar, "callback");
            q genLoadMoreNetScene = genLoadMoreNetScene();
            if (genLoadMoreNetScene instanceof bn) {
                ((bn) genLoadMoreNetScene).pullType = 3;
            }
            fetch(genLoadMoreNetScene, fVar);
            AppMethodBeat.o(245811);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public void fetchRefresh(com.tencent.mm.plugin.finder.feed.model.internal.f<com.tencent.mm.plugin.finder.live.viewmodel.c> fVar) {
            AppMethodBeat.i(245813);
            p.h(fVar, "callback");
            fetch(null, fVar);
            AppMethodBeat.o(245813);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.f<com.tencent.mm.plugin.finder.live.viewmodel.c> fVar) {
            AppMethodBeat.i(245814);
            p.h(fVar, "callback");
            q genLoadMoreNetScene = genLoadMoreNetScene();
            if (genLoadMoreNetScene instanceof bn) {
                ((bn) genLoadMoreNetScene).pullType = 2;
            }
            fetch(genLoadMoreNetScene, fVar);
            AppMethodBeat.o(245814);
        }

        public int getCmdId() {
            return -1;
        }

        public q genLoadMoreNetScene() {
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.f<com.tencent.mm.plugin.finder.live.viewmodel.c> fVar) {
            AppMethodBeat.i(245812);
            p.h(fVar, "callback");
            com.tencent.mm.plugin.finder.feed.model.internal.c cVar = new com.tencent.mm.plugin.finder.feed.model.internal.c();
            cVar.setPullType(1000);
            fVar.onFetchDone(cVar);
            AppMethodBeat.o(245812);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$LiveRelatedDataFetcher;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$BaseDataFetcher;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;)V", "genLoadMoreNetScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getCmdId", "", "plugin-finder_release"})
    public final class c extends a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
            super();
        }

        @Override // com.tencent.mm.plugin.finder.live.FinderLiveRelatedLoader.a
        public final q genLoadMoreNetScene() {
            AppMethodBeat.i(245816);
            am amVar = am.tuw;
            aov cXY = am.cXY();
            cXY.scene = FinderLiveRelatedLoader.this.ufx.tCE;
            bq bqVar = new bq(FinderLiveRelatedLoader.this.ufx.dLS, FinderLiveRelatedLoader.this.ufx.hFK, FinderLiveRelatedLoader.this.ufx.hwg, FinderLiveRelatedLoader.this.ufx.tsO, FinderLiveRelatedLoader.this.ufx.scene, FinderLiveRelatedLoader.this.ufx.uDl, FinderLiveRelatedLoader.this.ufx.iUY, cXY);
            bqVar.pullType = 2;
            bq bqVar2 = bqVar;
            AppMethodBeat.o(245816);
            return bqVar2;
        }

        @Override // com.tencent.mm.plugin.finder.live.FinderLiveRelatedLoader.a
        public final int getCmdId() {
            return 3688;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$NearbyLiveRelatedDataFetcher;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader$BaseDataFetcher;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;)V", "genLoadMoreNetScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getCmdId", "", "plugin-finder_release"})
    public final class d extends a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d() {
            super();
        }

        @Override // com.tencent.mm.plugin.finder.live.FinderLiveRelatedLoader.a
        public final q genLoadMoreNetScene() {
            AppMethodBeat.i(245817);
            am amVar = am.tuw;
            aov cXY = am.cXY();
            cXY.scene = FinderLiveRelatedLoader.this.ufx.tCE;
            long j2 = FinderLiveRelatedLoader.this.ufx.hFK;
            String str = FinderLiveRelatedLoader.this.ufx.hwg;
            String str2 = FinderLiveRelatedLoader.this.ufx.sessionBuffer;
            if (str2 == null) {
                str2 = "";
            }
            bn bnVar = new bn(j2, str, str2, FinderLiveRelatedLoader.this.ufx.tsO, FinderLiveRelatedLoader.this.ufx.tCE, FinderLiveRelatedLoader.this.ufx.uDl, FinderLiveRelatedLoader.this.ufx.iUY, cXY);
            bnVar.pullType = 2;
            bn bnVar2 = bnVar;
            AppMethodBeat.o(245817);
            return bnVar2;
        }

        @Override // com.tencent.mm.plugin.finder.live.FinderLiveRelatedLoader.a
        public final int getCmdId() {
            return 6479;
        }
    }
}
