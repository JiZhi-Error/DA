package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.finder.cgi.ab;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0004*+,-B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0%H\u0016J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0'H\u0016J\u0016\u0010(\u001a\u00020\u000b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016R.\u0010\u0007\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getFinderUserName", "()Ljava/lang/String;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "refObjectId", "", "getRefObjectId", "()J", "setRefObjectId", "(J)V", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Companion", "FinderLbsStreamListRequest", "FinderLbsStreamListResponse", "LbsStreamDataFetcher", "plugin-finder_release"})
public final class FinderLbsStreamFeedLoader extends BaseFinderFeedLoader {
    private static final String TAG = TAG;
    private static final ConcurrentHashMap<Long, Object> tVK = new ConcurrentHashMap<>();
    public static final a tVL = new a((byte) 0);
    public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
    public int gAZ;
    private boolean hasMore;
    final String sBN;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLbsStreamFeedLoader(String str, bbn bbn) {
        super(bbn);
        p.h(str, "finderUserName");
        p.h(bbn, "contextObj");
        AppMethodBeat.i(244681);
        this.sBN = str;
        AppMethodBeat.o(244681);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(244678);
        d dVar = new d();
        AppMethodBeat.o(244678);
        return dVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u001a\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
    public static final class e extends BaseFeedLoader<bo>.a {
        final /* synthetic */ FinderLbsStreamFeedLoader tVO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderLbsStreamFeedLoader finderLbsStreamFeedLoader) {
            super();
            this.tVO = finderLbsStreamFeedLoader;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void mergeRefresh(IResponse<bo> iResponse, kotlin.g.a.b<? super IResponse<bo>, x> bVar) {
            boolean z;
            AppMethodBeat.i(244677);
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
            Log.i(this.tVO.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(cVar)));
            com.tencent.mm.ac.d.h(new a(this, new n(iResponse.getHasMore() ? 4 : 6, iResponse.getIncrementList(), iResponse.isNeedClear(), 8), cVar, bVar, iResponse));
            AppMethodBeat.o(244677);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ n $op;
            final /* synthetic */ RefreshLoadMoreLayout.c $reason;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ e tVR;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(e eVar, n nVar, RefreshLoadMoreLayout.c cVar, kotlin.g.a.b bVar, IResponse iResponse) {
                super(0);
                this.tVR = eVar;
                this.$op = nVar;
                this.$reason = cVar;
                this.$next = bVar;
                this.$response = iResponse;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(244676);
                this.tVR.convertOpToReason(this.$op, this.$reason);
                this.tVR.tVO.dispatcher().onPreFinishRefresh(this.$reason);
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(244676);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger() {
        AppMethodBeat.i(244679);
        e eVar = new e(this);
        AppMethodBeat.o(244679);
        return eVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListRequest;", "", "finderUserName", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "getFinderUserName", "()Ljava/lang/String;", "getLastBuff", "()Lcom/tencent/mm/protobuf/ByteString;", "getPullType", "()I", "plugin-finder_release"})
    public static final class b {
        final int pullType;
        private final String sBN;
        final com.tencent.mm.bw.b tVM;

        public b(String str, com.tencent.mm.bw.b bVar, int i2) {
            p.h(str, "finderUserName");
            AppMethodBeat.i(244666);
            this.sBN = str;
            this.tVM = bVar;
            this.pullType = i2;
            AppMethodBeat.o(244666);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0002\u0010\tR\u001a\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "totalCount", "(IILjava/lang/String;I)V", "getTotalCount", "()I", "setTotalCount", "(I)V", "plugin-finder_release"})
    public static final class c extends IResponse<bo> {
        int gAZ;

        public c(int i2, int i3, String str, int i4) {
            super(i2, i3, str);
            this.gAZ = i4;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0007J&\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$Companion;", "", "()V", "TAG", "", "lbsStreamDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$Companion$LbsStreamFeedCache;", "getLbsStreamDataCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "clearCache", "", "getCache", "id", "putCache", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "removeCache", "key", "LbsStreamFeedCache", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(244682);
        AppMethodBeat.o(244682);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        kotlin.g.a.b<? super IResponse<bo>, x> bVar;
        AppMethodBeat.i(244680);
        p.h(iResponse, "response");
        super.onFetchDone(iResponse);
        if (iResponse.getPullType() == 0 && (iResponse instanceof c)) {
            this.gAZ = ((c) iResponse).gAZ;
        }
        if (isInitOperation(iResponse)) {
            AppMethodBeat.o(244680);
            return;
        }
        this.hasMore = iResponse.getHasMore();
        if (iResponse.getHasMore() || (bVar = this.fetchEndCallback) == null) {
            AppMethodBeat.o(244680);
            return;
        }
        bVar.invoke(iResponse);
        AppMethodBeat.o(244680);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J \u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016J\u0016\u0010\u0011\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016J\u0016\u0010\u0012\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$LbsStreamDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;)V", "dataFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchInit", "fetchLoadMore", "fetchRefresh", "plugin-finder_release"})
    public final class d extends g<bo> {
        private i tMX = new i("LbsStreamListData");
        final com.tencent.mm.plugin.finder.cgi.fetcher.c tVN;

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
        public static final class a extends q implements kotlin.g.a.b<h, x> {
            final /* synthetic */ Object tVH;
            final /* synthetic */ d tVP;
            final /* synthetic */ f tVx;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, f fVar, Object obj) {
                super(1);
                this.tVP = dVar;
                this.tVx = fVar;
                this.tVH = obj;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(h hVar) {
                AppMethodBeat.i(244668);
                final h hVar2 = hVar;
                p.h(hVar2, "task");
                com.tencent.mm.plugin.finder.cgi.fetcher.c.a(this.tVP.tVN, new ab.a(this) {
                    /* class com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader.d.a.AnonymousClass1 */
                    final /* synthetic */ a tVQ;

                    {
                        this.tVQ = r1;
                    }

                    @Override // com.tencent.mm.plugin.finder.cgi.ab.a
                    public final void a(b bVar, int i2) {
                        AppMethodBeat.i(244667);
                        p.h(bVar, "info");
                        boolean z = bVar.tUC != 0;
                        c cVar = new c(bVar.errType, bVar.errCode, bVar.errMsg, 0);
                        cVar.setIncrementList(bVar.tUz);
                        cVar.setPullType(i2);
                        cVar.setLastBuffer(bVar.lastBuffer);
                        cVar.setHasMore(z);
                        this.tVQ.tVx.onFetchDone(cVar);
                        hVar2.a(j.OK);
                        AppMethodBeat.o(244667);
                    }
                }, ((b) this.tVH).pullType, null, ((b) this.tVH).tVM, false, null, 16);
                x xVar = x.SXb;
                AppMethodBeat.o(244668);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d() {
            AppMethodBeat.i(244675);
            this.tVN = new com.tencent.mm.plugin.finder.cgi.fetcher.c(2, FinderLbsStreamFeedLoader.this.getContextObj());
            AppMethodBeat.o(244675);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetchRefresh(f<bo> fVar) {
            AppMethodBeat.i(244669);
            p.h(fVar, "callback");
            fetch(new b(FinderLbsStreamFeedLoader.this.sBN, FinderLbsStreamFeedLoader.this.getLastBuffer(), 0), fVar);
            AppMethodBeat.o(244669);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetchLoadMore(f<bo> fVar) {
            AppMethodBeat.i(244670);
            p.h(fVar, "callback");
            fetch(new b(FinderLbsStreamFeedLoader.this.sBN, FinderLbsStreamFeedLoader.this.getLastBuffer(), 2), fVar);
            AppMethodBeat.o(244670);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v9, types: [java.util.List] */
        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetchInit(f<bo> fVar) {
            v vVar;
            com.tencent.mm.bw.b bVar;
            ArrayList<bo> arrayList;
            AppMethodBeat.i(244671);
            p.h(fVar, "callback");
            h cache = FinderLbsStreamFeedLoader.this.getCache();
            if (cache == null || (arrayList = cache.kgc) == null) {
                vVar = v.SXr;
            } else {
                vVar = arrayList;
            }
            Log.i(getTAG(), "[fetchInit] ret=".concat(String.valueOf(vVar)));
            c cVar = new c(0, 0, "", vVar.size());
            cVar.setIncrementList(vVar);
            h cache2 = FinderLbsStreamFeedLoader.this.getCache();
            if (cache2 != null) {
                bVar = cache2.lastBuffer;
            } else {
                bVar = null;
            }
            cVar.setLastBuffer(bVar);
            cVar.setPullType(1000);
            fVar.onFetchDone(cVar);
            AppMethodBeat.o(244671);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void alive() {
            AppMethodBeat.i(244672);
            super.alive();
            this.tMX.start();
            AppMethodBeat.o(244672);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void dead() {
            AppMethodBeat.i(244673);
            super.dead();
            this.tVN.ttK.dead();
            this.tMX.stop();
            AppMethodBeat.o(244673);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetch(Object obj, f<bo> fVar) {
            AppMethodBeat.i(244674);
            p.h(fVar, "callback");
            if (obj instanceof b) {
                this.tMX.a(new h(new a(this, fVar, obj)));
            }
            AppMethodBeat.o(244674);
        }
    }
}
