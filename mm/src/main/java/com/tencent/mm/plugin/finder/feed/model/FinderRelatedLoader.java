package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.bq;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\"#B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001fH\u0016J\u0016\u0010 \u001a\u00020\u00132\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR.\u0010\u000f\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000e¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "tabType", "", "commentScene", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IIFFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getCommentScene", "()I", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getLat", "()F", "getLng", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTabType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "FinderFeedRelResponse", "RelatedDataFetcher", "plugin-finder_release"})
public final class FinderRelatedLoader extends BaseFinderFeedLoader {
    final int dLS;
    public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
    final float iUY;
    final float iUZ;
    private final int tCE;
    final bcc tvs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderRelatedLoader(int i2, int i3, float f2, float f3, bcc bcc, bbn bbn) {
        super(bbn);
        p.h(bcc, "sectionInfo");
        AppMethodBeat.i(244859);
        this.dLS = i2;
        this.tCE = i3;
        this.iUZ = f2;
        this.iUY = f3;
        this.tvs = bcc;
        AppMethodBeat.o(244859);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(244857);
        b bVar = new b();
        AppMethodBeat.o(244857);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
    public static final class a extends IResponse<bo> {
        public a(int i2, int i3, String str) {
            super(i2, i3, str);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        kotlin.g.a.b<? super IResponse<bo>, x> bVar;
        AppMethodBeat.i(244858);
        p.h(iResponse, "response");
        super.onFetchDone(iResponse);
        if (isInitOperation(iResponse)) {
            AppMethodBeat.o(244858);
        } else if (iResponse.getHasMore() || (bVar = this.fetchEndCallback) == null) {
            AppMethodBeat.o(244858);
        } else {
            bVar.invoke(iResponse);
            AppMethodBeat.o(244858);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J2\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H\u0016¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$RelatedDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
    public final class b extends com.tencent.mm.plugin.finder.feed.model.internal.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(244853);
            List<Integer> listOf = j.listOf((Object) 3688);
            AppMethodBeat.o(244853);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final q genRefreshNetScene() {
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final q genLoadMoreNetScene() {
            AppMethodBeat.i(244854);
            bq bqVar = new bq(FinderRelatedLoader.this.dLS, FinderRelatedLoader.this.getLastBuffer(), FinderRelatedLoader.this.iUZ, FinderRelatedLoader.this.iUY, FinderRelatedLoader.this.tvs, FinderRelatedLoader.this.getContextObj());
            bqVar.pullType = 2;
            bq bqVar2 = bqVar;
            AppMethodBeat.o(244854);
            return bqVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, q qVar) {
            boolean z;
            AppMethodBeat.i(244855);
            p.h(qVar, "scene");
            if (qVar instanceof bq) {
                if (i2 == 0 && i3 == 0) {
                    z = ((bq) qVar).cYp();
                } else {
                    z = true;
                }
                a aVar = new a(i2, i3, str);
                LinkedList<FinderObject> cYr = ((bq) qVar).cYr();
                ArrayList arrayList = new ArrayList(j.a(cYr, 10));
                Iterator<T> it = cYr.iterator();
                while (it.hasNext()) {
                    FinderItem.a aVar2 = FinderItem.Companion;
                    FinderItem a2 = FinderItem.a.a((FinderObject) it.next(), 256);
                    c.a aVar3 = c.vGN;
                    arrayList.add(c.a.s(a2));
                }
                aVar.setIncrementList(arrayList);
                c.a aVar4 = c.vGN;
                c.a.a(((bq) qVar).cYr(), 1, FinderRelatedLoader.this.getContextObj());
                String tag = getTAG();
                StringBuilder sb = new StringBuilder("incrementList size: ");
                List incrementList = aVar.getIncrementList();
                Log.i(tag, sb.append(incrementList != null ? Integer.valueOf(incrementList.size()) : null).toString());
                aVar.setPullType(((bq) qVar).pullType);
                aVar.setLastBuffer(((bq) qVar).cYm());
                aVar.setHasMore(z);
                a aVar5 = aVar;
                AppMethodBeat.o(244855);
                return aVar5;
            }
            AppMethodBeat.o(244855);
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final /* synthetic */ IResponse callInit() {
            ArrayList<bo> arrayList;
            com.tencent.mm.bw.b bVar = null;
            AppMethodBeat.i(244856);
            a aVar = new a(0, 0, "");
            h cache = FinderRelatedLoader.this.getCache();
            if (cache != null) {
                arrayList = cache.kgc;
            } else {
                arrayList = null;
            }
            aVar.setIncrementList(arrayList);
            h cache2 = FinderRelatedLoader.this.getCache();
            if (cache2 != null) {
                bVar = cache2.lastBuffer;
            }
            aVar.setLastBuffer(bVar);
            a aVar2 = aVar;
            AppMethodBeat.o(244856);
            return aVar2;
        }
    }
}
