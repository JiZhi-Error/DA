package com.tencent.mm.plugin.finder.feed.model;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.stats.LoggingConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bh;
import com.tencent.mm.plugin.finder.feed.ah;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamCardVM;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bdb;
import com.tencent.mm.protocal.protobuf.blo;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001:\u0003]^_B§\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0002\u0010\u001bJ\u000e\u0010T\u001a\b\u0012\u0004\u0012\u00020)0UH\u0016J\b\u0010V\u001a\u00020\u000bH\u0016J\u0016\u0010W\u001a\u00020*2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016J\u0016\u0010Y\u001a\u00020*2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020)0(H\u0014J\u0016\u0010[\u001a\u00020*2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020)0(H\u0014J\u0016\u0010\\\u001a\u00020*2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020)0(H\u0014R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R.\u0010&\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(\u0012\u0004\u0012\u00020*\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00104\"\u0004\b8\u00106R.\u00109\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(\u0012\u0004\u0012\u00020*\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010,\"\u0004\b;\u0010.R\u001a\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u0010!R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0011\u0010\u001a\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bC\u0010BR.\u0010D\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(\u0012\u0004\u0012\u00020*\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010,\"\u0004\bF\u0010.R\u001a\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010=\"\u0004\bH\u0010?R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u001d\"\u0004\bN\u0010\u001fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bS\u0010=¨\u0006`"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "feedId", "", "nonceId", "", "tabType", "", "category", "relatedListScene", "hasMoreAfterInit", "", "sessionBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "get_column_feed_info", "Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;", "cardBuffer", LoggingConstants.LOG_FILE_PREFIX, "Lcom/tencent/mm/protocal/protobuf/Stats;", "loadScene", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "poiLatitude", "", "poiLongitude", "(JLjava/lang/String;ILjava/lang/String;IZLcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/Stats;ILcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;FF)V", "getCardBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setCardBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getFeedId", "()J", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getGet_column_feed_info", "()Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;", "setGet_column_feed_info", "(Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;)V", "getHasMoreAfterInit", "()Z", "setHasMoreAfterInit", "(Z)V", "isLoading", "setLoading", "loadMoreCallback", "getLoadMoreCallback", "setLoadMoreCallback", "getLoadScene", "()I", "setLoadScene", "(I)V", "getNonceId", "getPoiLatitude", "()F", "getPoiLongitude", "refreshCallback", "getRefreshCallback", "setRefreshCallback", "getRelatedListScene", "setRelatedListScene", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "setRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;)V", "getSessionBuffer", "setSessionBuffer", "getStats", "()Lcom/tencent/mm/protocal/protobuf/Stats;", "setStats", "(Lcom/tencent/mm/protocal/protobuf/Stats;)V", "getTabType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "isObservePostEvent", "onFetchDone", "response", "onFetchInitDone", "initResponse", "onFetchLoadMoreDone", "onFetchRefreshDone", "FeedRelDataFetcher", "FinderFeedRelResponse", "FinderStreamCardDataFetcher", "plugin-finder_release"})
public class FinderFeedRelTimelineLoader extends BaseFinderFeedLoader {
    final float UIp;
    final float UIq;
    public String category;
    final int dLS;
    final long feedId;
    public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
    final String hwg;
    boolean isLoading;
    public kotlin.g.a.b<? super IResponse<bo>, x> tVa;
    public kotlin.g.a.b<? super IResponse<bo>, x> tVb;
    public boolean tVc;
    blo tVd;
    com.tencent.mm.bw.b tVe;
    ecq tVf;
    int tVg;
    public ato tta;
    public int ttb;
    private com.tencent.mm.bw.b tvj;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FinderFeedRelTimelineLoader(long r20, java.lang.String r22, int r23, java.lang.String r24, int r25, boolean r26, com.tencent.mm.protocal.protobuf.blo r27, com.tencent.mm.bw.b r28, com.tencent.mm.protocal.protobuf.ecq r29, int r30, com.tencent.mm.protocal.protobuf.bbn r31, float r32, float r33, int r34) {
        /*
        // Method dump skipped, instructions count: 135
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader.<init>(long, java.lang.String, int, java.lang.String, int, boolean, com.tencent.mm.protocal.protobuf.blo, com.tencent.mm.bw.b, com.tencent.mm.protocal.protobuf.ecq, int, com.tencent.mm.protocal.protobuf.bbn, float, float, int):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FinderFeedRelTimelineLoader(long j2, String str, int i2, String str2, int i3, boolean z, blo blo, com.tencent.mm.bw.b bVar, ecq ecq, int i4, bbn bbn, float f2, float f3) {
        super(bbn);
        p.h(str, "nonceId");
        AppMethodBeat.i(260249);
        this.feedId = j2;
        this.hwg = str;
        this.dLS = i2;
        this.category = str2;
        this.ttb = i3;
        this.tVc = z;
        this.tvj = null;
        this.tVd = blo;
        this.tVe = bVar;
        this.tVf = ecq;
        this.tVg = i4;
        this.tta = null;
        this.UIp = f2;
        this.UIq = f3;
        AppMethodBeat.o(260249);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public g<bo> createDataFetch() {
        AppMethodBeat.i(244598);
        a aVar = new a();
        AppMethodBeat.o(244598);
        return aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderFeedRelResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "title", "", "errType", "", "errCode", "errMsg", "(Ljava/lang/String;IILjava/lang/String;)V", "cards", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "getCards", "()Ljava/util/LinkedList;", "setCards", "(Ljava/util/LinkedList;)V", "objectList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class b extends IResponse<bo> {
        public LinkedList<bcu> tVi = new LinkedList<>();
        public final String title;
        public List<? extends FinderObject> tvo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str, int i2, int i3, String str2) {
            super(i2, i3, str2);
            p.h(str, "title");
            AppMethodBeat.i(244593);
            this.title = str;
            AppMethodBeat.o(244593);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public void onFetchDone(IResponse<bo> iResponse) {
        kotlin.g.a.b<? super IResponse<bo>, x> bVar;
        AppMethodBeat.i(244599);
        p.h(iResponse, "response");
        super.onFetchDone(iResponse);
        if (isInitOperation(iResponse)) {
            AppMethodBeat.o(244599);
        } else if (iResponse.getHasMore() || (bVar = this.fetchEndCallback) == null) {
            AppMethodBeat.o(244599);
        } else {
            bVar.invoke(iResponse);
            AppMethodBeat.o(244599);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public void onFetchInitDone(IResponse<bo> iResponse) {
        kotlin.g.a.b<? super IResponse<bo>, x> bVar;
        AppMethodBeat.i(244600);
        p.h(iResponse, "initResponse");
        super.onFetchInitDone(iResponse);
        if (iResponse.getHasMore() || (bVar = this.fetchEndCallback) == null) {
            AppMethodBeat.o(244600);
            return;
        }
        bVar.invoke(iResponse);
        AppMethodBeat.o(244600);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public void onFetchRefreshDone(IResponse<bo> iResponse) {
        AppMethodBeat.i(244601);
        p.h(iResponse, "response");
        super.onFetchRefreshDone(iResponse);
        kotlin.g.a.b<? super IResponse<bo>, x> bVar = this.tVa;
        if (bVar != null) {
            bVar.invoke(iResponse);
            AppMethodBeat.o(244601);
            return;
        }
        AppMethodBeat.o(244601);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public void onFetchLoadMoreDone(IResponse<bo> iResponse) {
        AppMethodBeat.i(244602);
        p.h(iResponse, "response");
        super.onFetchLoadMoreDone(iResponse);
        kotlin.g.a.b<? super IResponse<bo>, x> bVar = this.tVb;
        if (bVar != null) {
            bVar.invoke(iResponse);
            AppMethodBeat.o(244602);
            return;
        }
        AppMethodBeat.o(244602);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J2\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderStreamCardDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FeedRelDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;)V", "dead", "", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "genStats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "read", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "plugin-finder_release"})
    public class c extends a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
            super();
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader.a, com.tencent.mm.plugin.finder.feed.model.internal.a
        public q genRefreshNetScene() {
            AppMethodBeat.i(244594);
            com.tencent.mm.bw.b bVar = FinderFeedRelTimelineLoader.this.tVe;
            int i2 = FinderFeedRelTimelineLoader.this.tVg;
            ecq ecq = FinderFeedRelTimelineLoader.this.tVf;
            bh bhVar = new bh(bVar, i2, ecq != null ? j.listOf(ecq) : null, FinderFeedRelTimelineLoader.this.tVd, FinderFeedRelTimelineLoader.this.getContextObj());
            bhVar.pullType = 0;
            bh bhVar2 = bhVar;
            AppMethodBeat.o(244594);
            return bhVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader.a, com.tencent.mm.plugin.finder.feed.model.internal.a
        public q genLoadMoreNetScene() {
            AppMethodBeat.i(244595);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            List<cmm> dHT = ((FinderStreamCardVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamCardVM.class)).dHT();
            ArrayList arrayList = new ArrayList(j.a(dHT, 10));
            for (T t : dHT) {
                ecq ecq = new ecq();
                ecq.NcN = new epf();
                ecq.NcM = new mp();
                ecq.NcO = new cxr();
                ecq.hFK = t.hFK;
                ecq.tCE = t.MrI;
                ecq.sessionBuffer = t.sessionBuffer;
                ecq.finderUsername = z.aUg();
                ecq.NcP = cl.aWA();
                ecq.mediaType = 11;
                arrayList.add(ecq);
            }
            bh bhVar = new bh(FinderFeedRelTimelineLoader.this.getLastBuffer(), FinderFeedRelTimelineLoader.this.tVg, arrayList, FinderFeedRelTimelineLoader.this.tVd, FinderFeedRelTimelineLoader.this.getContextObj());
            bhVar.pullType = 2;
            bh bhVar2 = bhVar;
            AppMethodBeat.o(244595);
            return bhVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a, com.tencent.mm.plugin.finder.feed.model.internal.g
        public void dead() {
            AppMethodBeat.i(244596);
            super.dead();
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderStreamCardVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamCardVM.class)).pg(true);
            AppMethodBeat.o(244596);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader.a, com.tencent.mm.plugin.finder.feed.model.internal.a
        public IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, q qVar) {
            boolean z;
            long j2;
            Boolean bool;
            List<bo> incrementList;
            Integer num = null;
            boolean z2 = true;
            AppMethodBeat.i(244597);
            p.h(qVar, "scene");
            IResponse<bo> dealOnSceneEnd = super.dealOnSceneEnd(i2, i3, str, qVar);
            if (qVar instanceof bh) {
                if (i2 == 0 && i3 == 0) {
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    FinderStreamCardVM.a((FinderStreamCardVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamCardVM.class));
                }
                String tag = getTAG();
                StringBuilder append = new StringBuilder("[dealOnSceneEnd] errType=").append(i2).append(" errCode=").append(str).append(" pullType=").append(((bh) qVar).pullType).append(' ').append("lastBuffer=");
                if (FinderFeedRelTimelineLoader.this.getLastBuffer() != null) {
                    z = true;
                } else {
                    z = false;
                }
                StringBuilder append2 = append.append(z).append(" cardBuffer=");
                if (FinderFeedRelTimelineLoader.this.tVe == null) {
                    z2 = false;
                }
                StringBuilder append3 = append2.append(z2).append(' ').append("stats=");
                ecq ecq = FinderFeedRelTimelineLoader.this.tVf;
                if (ecq != null) {
                    j2 = ecq.hFK;
                } else {
                    j2 = 0;
                }
                StringBuilder append4 = append3.append(d.zs(j2)).append(" get_column_feed_info=");
                blo blo = FinderFeedRelTimelineLoader.this.tVd;
                StringBuilder append5 = append4.append(d.zs(blo != null ? blo.id : 0)).append(' ').append("hasMore=");
                if (dealOnSceneEnd != null) {
                    bool = Boolean.valueOf(dealOnSceneEnd.getHasMore());
                } else {
                    bool = null;
                }
                StringBuilder append6 = append5.append(bool).append(" size=");
                if (!(dealOnSceneEnd == null || (incrementList = dealOnSceneEnd.getIncrementList()) == null)) {
                    num = Integer.valueOf(incrementList.size());
                }
                Log.i(tag, append6.append(num).toString());
            }
            AppMethodBeat.o(244597);
            return dealOnSceneEnd;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J2\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0016¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FeedRelDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
    public class a extends com.tencent.mm.plugin.finder.feed.model.internal.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public List<Integer> getCmdIds() {
            AppMethodBeat.i(244587);
            List<Integer> listOf = j.listOf((Object) 3688);
            AppMethodBeat.o(244587);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public q genRefreshNetScene() {
            AppMethodBeat.i(244588);
            bh bhVar = new bh(FinderFeedRelTimelineLoader.this.feedId, FinderFeedRelTimelineLoader.this.hwg, FinderFeedRelTimelineLoader.this.dLS, FinderFeedRelTimelineLoader.this.getLastBuffer(), FinderFeedRelTimelineLoader.this.category, FinderFeedRelTimelineLoader.this.ttb, null, null, null, FinderFeedRelTimelineLoader.this.getContextObj(), FinderFeedRelTimelineLoader.this.UIp, FinderFeedRelTimelineLoader.this.UIq, 960);
            bhVar.pullType = 0;
            bh bhVar2 = bhVar;
            AppMethodBeat.o(244588);
            return bhVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public q genLoadMoreNetScene() {
            AppMethodBeat.i(244589);
            bh bhVar = new bh(FinderFeedRelTimelineLoader.this.feedId, FinderFeedRelTimelineLoader.this.hwg, FinderFeedRelTimelineLoader.this.dLS, FinderFeedRelTimelineLoader.this.getLastBuffer(), FinderFeedRelTimelineLoader.this.category, FinderFeedRelTimelineLoader.this.ttb, null, null, null, FinderFeedRelTimelineLoader.this.getContextObj(), FinderFeedRelTimelineLoader.this.UIp, FinderFeedRelTimelineLoader.this.UIq, 960);
            bhVar.pullType = 2;
            bh bhVar2 = bhVar;
            AppMethodBeat.o(244589);
            return bhVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a, com.tencent.mm.plugin.finder.feed.model.internal.g
        public void fetch(Object obj, f<bo> fVar) {
            AppMethodBeat.i(244590);
            p.h(fVar, "callback");
            FinderFeedRelTimelineLoader.this.isLoading = true;
            super.fetch(obj, fVar);
            AppMethodBeat.o(244590);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, q qVar) {
            boolean z;
            AppMethodBeat.i(244591);
            p.h(qVar, "scene");
            FinderFeedRelTimelineLoader.this.isLoading = false;
            if (qVar instanceof bh) {
                if (i2 == 0 && i3 == 0) {
                    z = ((bh) qVar).cYp();
                } else {
                    z = true;
                }
                String wording = ((bh) qVar).getWording();
                if (wording == null) {
                    wording = "";
                }
                b bVar = new b(wording, i2, i3, str);
                LinkedList<FinderObject> cYr = ((bh) qVar).cYr();
                ArrayList arrayList = new ArrayList(j.a(cYr, 10));
                Iterator<T> it = cYr.iterator();
                while (it.hasNext()) {
                    FinderItem.a aVar = FinderItem.Companion;
                    FinderItem a2 = FinderItem.a.a((FinderObject) it.next(), 256);
                    c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    arrayList.add(c.a.s(a2));
                }
                LinkedList linkedList = new LinkedList(arrayList);
                LinkedList<bdb> linkedList2 = ((bh) qVar).cYq().LEz;
                p.g(linkedList2, "scene.getResponse().txt_card");
                bdb bdb = (bdb) j.kt(linkedList2);
                if (bdb != null) {
                    String str2 = bVar.title;
                    p.h(bdb, "$this$toRVFeed");
                    p.h(str2, "streamCardTitle");
                    ah ahVar = new ah(bdb);
                    p.h(str2, "<set-?>");
                    ahVar.tQV = str2;
                    linkedList.add(ahVar);
                }
                bVar.setIncrementList(linkedList);
                bVar.tVi.addAll(((bh) qVar).cYq().LEy);
                bVar.tvo = new LinkedList(((bh) qVar).cYr());
                bVar.setPullType(((bh) qVar).pullType);
                bVar.setLastBuffer(((bh) qVar).cYm());
                bVar.setHasMore(z);
                c.a aVar3 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                c.a.a(((bh) qVar).cYr(), 1, FinderFeedRelTimelineLoader.this.getContextObj());
                b bVar2 = bVar;
                AppMethodBeat.o(244591);
                return bVar2;
            }
            AppMethodBeat.o(244591);
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public IResponse<bo> callInit() {
            ArrayList<bo> arrayList;
            com.tencent.mm.bw.b bVar = null;
            AppMethodBeat.i(244592);
            b bVar2 = new b("", 0, 0, "");
            h cache = FinderFeedRelTimelineLoader.this.getCache();
            if (cache != null) {
                arrayList = cache.kgc;
            } else {
                arrayList = null;
            }
            bVar2.setIncrementList(arrayList);
            h cache2 = FinderFeedRelTimelineLoader.this.getCache();
            if (cache2 != null) {
                bVar = cache2.lastBuffer;
            }
            bVar2.setLastBuffer(bVar);
            bVar2.setHasMore(FinderFeedRelTimelineLoader.this.tVc);
            b bVar3 = bVar2;
            AppMethodBeat.o(244592);
            return bVar3;
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public boolean isObservePostEvent() {
        return true;
    }
}
