package com.tencent.mm.plugin.finder.feed.model;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.plugin.finder.cgi.aq;
import com.tencent.mm.plugin.finder.cgi.bh;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.bp;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aom;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003ABCBY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n¢\u0006\u0002\u0010\u0010J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020\u001a0:H\u0016J\u000e\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001a0<H\u0016J\u0006\u0010=\u001a\u00020\u0003J\b\u0010>\u001a\u00020\nH\u0016J\u0016\u0010?\u001a\u00020\u001b2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R.\u0010\u0017\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR.\u0010 \u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010&R\u001a\u0010*\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010,R\u001a\u0010/\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010,R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b5\u00104R\u001a\u00106\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0012\"\u0004\b8\u0010&¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "feedId", "", "encryptedFeedId", "", "nonceId", "tabType", "", "isFromAd", "", "shareScene", "sessionId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isPostingScene", "(JLjava/lang/String;Ljava/lang/String;IZILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getEncryptedFeedId", "()Ljava/lang/String;", "getFeedId", "()J", "setFeedId", "(J)V", "fetchCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchCallback", "(Lkotlin/jvm/functions/Function1;)V", "fetchEndCallback", "getFetchEndCallback", "setFetchEndCallback", "finderUserName", "getFinderUserName", "setFinderUserName", "(Ljava/lang/String;)V", "fromUserName", "getFromUserName", "setFromUserName", "hasRefreshFinish", "getHasRefreshFinish", "()Z", "setHasRefreshFinish", "(Z)V", "isOpenEntranceTipShown", "setOpenEntranceTipShown", "getNonceId", "getSessionId", "getShareScene", "()I", "getTabType", "toUserName", "getToUserName", "setToUserName", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getLastItem", "isObservePostEvent", "onFetchDone", "response", "FeedShareRelDataFetcher", "FinderShareRelativeListResponse", "UserPageDataFetcher", "plugin-finder_release"})
public final class FinderFeedShareRelativeListLoader extends BaseFinderFeedLoader {
    public String dJw = "";
    final int dLS;
    public String dYs = "";
    public long feedId;
    public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
    final String hwg;
    public String sBN = "";
    final String sessionId;
    final int shareScene;
    final boolean tNP;
    public boolean tVj;
    public kotlin.g.a.b<? super IResponse<bo>, x> tVk;
    private boolean tVl;
    private final boolean tVm;
    final String tuI;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFeedShareRelativeListLoader(long j2, String str, String str2, int i2, boolean z, int i3, String str3, bbn bbn, boolean z2) {
        super(bbn);
        p.h(str, "encryptedFeedId");
        p.h(str2, "nonceId");
        AppMethodBeat.i(244628);
        this.feedId = j2;
        this.tuI = str;
        this.hwg = str2;
        this.dLS = i2;
        this.tVm = z;
        this.shareScene = i3;
        this.sessionId = str3;
        this.tNP = z2;
        AppMethodBeat.o(244628);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(244625);
        if (this.tVm) {
            c cVar = new c();
            AppMethodBeat.o(244625);
            return cVar;
        }
        a aVar = new a();
        AppMethodBeat.o(244625);
        return aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002J@\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "findMergeIndex", "", "srcList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "newList", "", "cmd", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "", "plugin-finder_release"})
    public static final class d extends BaseFeedLoader<bo>.a {
        final /* synthetic */ FinderFeedShareRelativeListLoader tVn;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderFeedShareRelativeListLoader finderFeedShareRelativeListLoader) {
            super();
            this.tVn = finderFeedShareRelativeListLoader;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final int findMergeIndex(ArrayList<bo> arrayList, List<? extends bo> list, int i2, Object obj) {
            AppMethodBeat.i(244624);
            p.h(arrayList, "srcList");
            p.h(list, "newList");
            int size = this.tVn.getDataList().size();
            AppMethodBeat.o(244624);
            return size;
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger() {
        AppMethodBeat.i(244626);
        d dVar = new d(this);
        AppMethodBeat.o(244626);
        return dVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tR\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FinderShareRelativeListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "tipsWording", "(IILjava/lang/String;Ljava/lang/String;)V", "getTipsWording", "()Ljava/lang/String;", "setTipsWording", "(Ljava/lang/String;)V", "plugin-finder_release"})
    public static final class b extends IResponse<bo> {
        public String tipsWording;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i2, int i3, String str, String str2) {
            super(i2, i3, str);
            p.h(str2, "tipsWording");
            AppMethodBeat.i(244619);
            this.tipsWording = str2;
            AppMethodBeat.o(244619);
        }

        public final void atp(String str) {
            AppMethodBeat.i(244618);
            p.h(str, "<set-?>");
            this.tipsWording = str;
            AppMethodBeat.o(244618);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final boolean isObservePostEvent() {
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        kotlin.g.a.b<? super IResponse<bo>, x> bVar;
        AppMethodBeat.i(244627);
        p.h(iResponse, "response");
        if (iResponse.getPullType() == 0) {
            this.tVl = true;
            Log.d(getTAG(), "refresh finish");
        }
        if (iResponse.getPullType() != 2 || this.tVl) {
            if (!isInitOperation(iResponse) && (bVar = this.tVk) != null) {
                bVar.invoke(iResponse);
            }
            if (iResponse.getPullType() == 0) {
                iResponse.setPullType(2);
            }
            super.onFetchDone(iResponse);
            if (isInitOperation(iResponse)) {
                AppMethodBeat.o(244627);
                return;
            }
            kotlin.g.a.b<? super IResponse<bo>, x> bVar2 = this.fetchEndCallback;
            if (bVar2 != null) {
                bVar2.invoke(iResponse);
                AppMethodBeat.o(244627);
                return;
            }
            AppMethodBeat.o(244627);
            return;
        }
        Log.d(getTAG(), "loadmore before refresh");
        AppMethodBeat.o(244627);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J2\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FeedShareRelDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;)V", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "TaskDataCallbackWrapper", "plugin-finder_release"})
    public final class a extends com.tencent.mm.plugin.finder.feed.model.internal.a {
        private final i tMX = new i("FeedShareRelData");

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FeedShareRelDataFetcher$dealOnSceneEnd$2$1"})
        static final class b extends q implements kotlin.g.a.b<bo, Boolean> {
            final /* synthetic */ a tVq;
            final /* synthetic */ z.d tVr;
            final /* synthetic */ bcx tVs;
            final /* synthetic */ List tVt;
            final /* synthetic */ bo tVu;
            final /* synthetic */ z.a tVv;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(z.d dVar, a aVar, bcx bcx, List list, bo boVar, z.a aVar2) {
                super(1);
                this.tVr = dVar;
                this.tVq = aVar;
                this.tVs = bcx;
                this.tVt = list;
                this.tVu = boVar;
                this.tVv = aVar2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Boolean invoke(bo boVar) {
                boolean z;
                AppMethodBeat.i(244607);
                bo boVar2 = boVar;
                p.h(boVar2, LocaleUtil.ITALIAN);
                if (this.tVt.indexOf(boVar2) > this.tVr.SYE) {
                    z = true;
                } else {
                    z = false;
                }
                Boolean valueOf = Boolean.valueOf(z);
                AppMethodBeat.o(244607);
                return valueOf;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
        static final class c extends q implements kotlin.g.a.b<h, x> {
            final /* synthetic */ a tVq;
            final /* synthetic */ Object tVw;
            final /* synthetic */ f tVx;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(a aVar, Object obj, f fVar) {
                super(1);
                this.tVq = aVar;
                this.tVw = obj;
                this.tVx = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(h hVar) {
                AppMethodBeat.i(244608);
                h hVar2 = hVar;
                p.h(hVar2, "task");
                a.a(this.tVq, this.tVw, new C1155a(this.tVq, hVar2, this.tVx));
                x xVar = x.SXb;
                AppMethodBeat.o(244608);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
            AppMethodBeat.i(244616);
            AppMethodBeat.o(244616);
        }

        public static final /* synthetic */ void a(a aVar, Object obj, f fVar) {
            AppMethodBeat.i(244617);
            super.fetch(obj, fVar);
            AppMethodBeat.o(244617);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(244609);
            List<Integer> listOf = j.listOf((Object) 3688);
            AppMethodBeat.o(244609);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genRefreshNetScene() {
            AppMethodBeat.i(244610);
            if (FinderFeedShareRelativeListLoader.this.tNP) {
                AppMethodBeat.o(244610);
                return null;
            }
            bh bhVar = new bh(FinderFeedShareRelativeListLoader.this.feedId, FinderFeedShareRelativeListLoader.this.hwg, FinderFeedShareRelativeListLoader.this.dLS, FinderFeedShareRelativeListLoader.this.getLastBuffer(), null, FinderFeedShareRelativeListLoader.this.shareScene, FinderFeedShareRelativeListLoader.this.dYs, FinderFeedShareRelativeListLoader.this.dJw, FinderFeedShareRelativeListLoader.this.sessionId, FinderFeedShareRelativeListLoader.this.getContextObj(), 0.0f, 0.0f, 6656);
            bhVar.pullType = 0;
            bh bhVar2 = bhVar;
            AppMethodBeat.o(244610);
            return bhVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a, com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void alive() {
            AppMethodBeat.i(244611);
            super.alive();
            this.tMX.start();
            AppMethodBeat.o(244611);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a, com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void dead() {
            AppMethodBeat.i(244612);
            super.dead();
            this.tMX.stop();
            AppMethodBeat.o(244612);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a, com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetch(Object obj, f<bo> fVar) {
            AppMethodBeat.i(244613);
            p.h(fVar, "callback");
            this.tMX.a(new h(new c(this, obj, fVar)));
            AppMethodBeat.o(244613);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FeedShareRelDataFetcher$TaskDataCallbackWrapper;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "callback", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FeedShareRelDataFetcher;Lcom/tencent/mm/loader/loader/SingleTask;Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getTask", "()Lcom/tencent/mm/loader/loader/SingleTask;", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.model.FinderFeedShareRelativeListLoader$a$a  reason: collision with other inner class name */
        public final class C1155a implements f<bo> {
            private final h tVo;
            private final f<bo> tVp;
            final /* synthetic */ a tVq;

            public C1155a(a aVar, h hVar, f<bo> fVar) {
                p.h(hVar, "task");
                p.h(fVar, "callback");
                this.tVq = aVar;
                AppMethodBeat.i(244606);
                this.tVo = hVar;
                this.tVp = fVar;
                AppMethodBeat.o(244606);
            }

            @Override // com.tencent.mm.plugin.finder.feed.model.internal.f
            public final void onFetchDone(IResponse<bo> iResponse) {
                AppMethodBeat.i(244605);
                p.h(iResponse, "response");
                this.tVp.onFetchDone(iResponse);
                this.tVo.a(com.tencent.mm.loader.g.j.OK);
                AppMethodBeat.o(244605);
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genLoadMoreNetScene() {
            AppMethodBeat.i(244614);
            if (FinderFeedShareRelativeListLoader.this.tNP) {
                AppMethodBeat.o(244614);
                return null;
            }
            bh bhVar = new bh(FinderFeedShareRelativeListLoader.this.feedId, FinderFeedShareRelativeListLoader.this.hwg, FinderFeedShareRelativeListLoader.this.dLS, FinderFeedShareRelativeListLoader.this.getLastBuffer(), null, FinderFeedShareRelativeListLoader.this.shareScene, FinderFeedShareRelativeListLoader.this.dYs, FinderFeedShareRelativeListLoader.this.dJw, FinderFeedShareRelativeListLoader.this.sessionId, FinderFeedShareRelativeListLoader.this.getContextObj(), 0.0f, 0.0f, 6656);
            bhVar.pullType = 2;
            bh bhVar2 = bhVar;
            AppMethodBeat.o(244614);
            return bhVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            boolean z;
            Object obj;
            LinkedList<bcw> linkedList;
            boolean z2;
            boolean z3;
            boolean z4;
            AppMethodBeat.i(244615);
            p.h(qVar, "scene");
            if (qVar instanceof bh) {
                z.a aVar = new z.a();
                if (i2 == 0 && i3 == 0) {
                    z = ((bh) qVar).cYp();
                } else {
                    com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
                    com.tencent.mm.plugin.finder.report.h.d(FinderFeedShareRelativeListLoader.this.dLS, FinderFeedShareRelativeListLoader.this.getContextObj());
                    z = true;
                }
                aVar.SYB = z;
                b bVar = new b(i2, i3, str, "");
                LinkedList<FinderObject> cYr = ((bh) qVar).cYr();
                ArrayList arrayList = new ArrayList();
                LinkedList<FinderObject> linkedList2 = cYr;
                ArrayList arrayList2 = new ArrayList(j.a(linkedList2, 10));
                Iterator<T> it = linkedList2.iterator();
                while (it.hasNext()) {
                    FinderItem.a aVar2 = FinderItem.Companion;
                    FinderItem a2 = FinderItem.a.a((FinderObject) it.next(), 256);
                    c.a aVar3 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    arrayList2.add(c.a.s(a2));
                }
                arrayList.addAll(arrayList2);
                if (((bh) qVar).pullType == 0) {
                    bcx bcx = ((bh) qVar).cYq().LEA;
                    Iterator it2 = arrayList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        Object next = it2.next();
                        bo boVar = (bo) next;
                        if (!(boVar instanceof BaseFinderFeed) || boVar.lT() == ((bh) qVar).feedId) {
                            z4 = false;
                            continue;
                        } else {
                            z4 = true;
                            continue;
                        }
                        if (z4) {
                            obj = next;
                            break;
                        }
                    }
                    bo boVar2 = (bo) obj;
                    if (boVar2 != null && arrayList.indexOf(boVar2) > 0) {
                        y yVar = y.vXH;
                        int i4 = FinderFeedShareRelativeListLoader.this.dLS;
                        bbn contextObj = FinderFeedShareRelativeListLoader.this.getContextObj();
                        if (!y.gr(i4, contextObj != null ? contextObj.tCE : 0)) {
                            bp bpVar = bp.uOZ;
                            arrayList.add(1, bp.Ju(2001));
                        }
                    }
                    y yVar2 = y.vXH;
                    int i5 = FinderFeedShareRelativeListLoader.this.dLS;
                    bbn contextObj2 = FinderFeedShareRelativeListLoader.this.getContextObj();
                    if (!(y.gr(i5, contextObj2 != null ? contextObj2.tCE : 0) || bcx == null || (linkedList = bcx.LLI) == null)) {
                        ArrayList<bcw> arrayList3 = new ArrayList();
                        for (T t : linkedList) {
                            if (t.LLE == 3) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                arrayList3.add(t);
                            }
                        }
                        for (bcw bcw : arrayList3) {
                            z.d dVar = new z.d();
                            LinkedList<Long> linkedList3 = bcx.LMe;
                            p.g(linkedList3, "layoutInfo.layoutIds");
                            int i6 = 0;
                            Iterator<Long> it3 = linkedList3.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    i6 = -1;
                                    break;
                                }
                                Long next2 = it3.next();
                                long j2 = bcw.uOx;
                                if (next2 != null && next2.longValue() == j2) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    break;
                                }
                                i6++;
                            }
                            dVar.SYE = i6;
                            if (dVar.SYE > arrayList.size()) {
                                dVar.SYE = arrayList.size();
                            }
                            if (boVar2 != null && dVar.SYE > 0 && dVar.SYE <= arrayList.size()) {
                                int i7 = dVar.SYE;
                                bp bpVar2 = bp.uOZ;
                                arrayList.add(i7, bp.Ju(2016));
                                j.c((List) arrayList, (kotlin.g.a.b) new b(dVar, this, bcx, arrayList, boVar2, aVar));
                                this.tMX.clean();
                                FinderFeedShareRelativeListLoader.this.tVj = true;
                                aVar.SYB = false;
                            }
                        }
                    }
                }
                bVar.setIncrementList(arrayList);
                c.a aVar4 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                c.a.s(cYr, 1);
                String tag = getTAG();
                StringBuilder sb = new StringBuilder("incrementList size: ");
                List incrementList = bVar.getIncrementList();
                Log.i(tag, sb.append(incrementList != null ? Integer.valueOf(incrementList.size()) : null).toString());
                bVar.setPullType(((bh) qVar).pullType);
                bVar.setLastBuffer(((bh) qVar).cYm());
                bVar.setHasMore(aVar.SYB);
                String wording = ((bh) qVar).getWording();
                if (wording == null) {
                    wording = "";
                }
                bVar.atp(wording);
                b bVar2 = bVar;
                AppMethodBeat.o(244615);
                return bVar2;
            }
            AppMethodBeat.o(244615);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0016¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$UserPageDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneAdFeedList;", "getCmdIds", "", "plugin-finder_release"})
    public final class c extends com.tencent.mm.plugin.finder.feed.model.internal.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(244620);
            List<Integer> listOf = j.listOf((Object) 6692);
            AppMethodBeat.o(244620);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genLoadMoreNetScene() {
            long j2 = 0;
            AppMethodBeat.i(244622);
            FinderFeedShareRelativeListLoader finderFeedShareRelativeListLoader = FinderFeedShareRelativeListLoader.this;
            int size = finderFeedShareRelativeListLoader.getDataList().size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                bo boVar = (bo) finderFeedShareRelativeListLoader.getDataList().get(size);
                if ((boVar instanceof BaseFinderFeed) && ((BaseFinderFeed) boVar).feedObject.getId() != 0) {
                    j2 = ((BaseFinderFeed) boVar).feedObject.getId();
                    break;
                }
                size--;
            }
            aq aqVar = new aq(FinderFeedShareRelativeListLoader.this.sBN, FinderFeedShareRelativeListLoader.this.feedId, FinderFeedShareRelativeListLoader.this.tuI, j2, FinderFeedShareRelativeListLoader.this.getLastBuffer(), 2, FinderFeedShareRelativeListLoader.this.getContextObj());
            AppMethodBeat.o(244622);
            return aqVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            boolean z;
            boolean z2;
            boolean z3 = true;
            AppMethodBeat.i(244623);
            p.h(qVar, "scene");
            if (qVar instanceof aq) {
                com.tencent.mm.bw.a aYK = ((aq) qVar).rr.aYK();
                if (aYK == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
                    AppMethodBeat.o(244623);
                    throw tVar;
                }
                if (((aom) aYK).privateLock == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    b bVar = new b(i2, i3, str, "");
                    if (i2 == 0 && i3 == 0) {
                        z2 = ((aq) qVar).tuG;
                    } else {
                        z2 = true;
                    }
                    bVar.setPullType(((aq) qVar).pullType);
                    com.tencent.mm.bw.a aYK2 = ((aq) qVar).rr.aYK();
                    if (aYK2 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
                        AppMethodBeat.o(244623);
                        throw tVar2;
                    }
                    bVar.setLastBuffer(((aom) aYK2).lastBuffer);
                    bVar.setHasMore(z2);
                    com.tencent.mm.bw.a aYK3 = ((aq) qVar).rr.aYK();
                    if (aYK3 == null) {
                        t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
                        AppMethodBeat.o(244623);
                        throw tVar3;
                    }
                    String str2 = ((aom) aYK3).LAH;
                    if (str2 == null) {
                        str2 = "";
                    }
                    bVar.atp(str2);
                    com.tencent.mm.bw.a aYK4 = ((aq) qVar).rr.aYK();
                    if (aYK4 == null) {
                        t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
                        AppMethodBeat.o(244623);
                        throw tVar4;
                    }
                    LinkedList<FinderObject> linkedList = ((aom) aYK4).object;
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                    }
                    ArrayList arrayList = new ArrayList();
                    LinkedList<FinderObject> linkedList2 = linkedList;
                    ArrayList arrayList2 = new ArrayList(j.a(linkedList2, 10));
                    Iterator<T> it = linkedList2.iterator();
                    while (it.hasNext()) {
                        FinderItem.a aVar = FinderItem.Companion;
                        FinderItem a2 = FinderItem.a.a((FinderObject) it.next(), 256);
                        c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                        arrayList2.add(c.a.s(a2));
                    }
                    arrayList.addAll(arrayList2);
                    if (((aq) qVar).pullType == 0) {
                        if (!arrayList.isEmpty()) {
                            z3 = false;
                        }
                        if (!z3) {
                            bp bpVar = bp.uOZ;
                            arrayList.add(0, bp.Ju(2001));
                        }
                    }
                    bVar.setIncrementList(arrayList);
                    b bVar2 = bVar;
                    AppMethodBeat.o(244623);
                    return bVar2;
                }
            }
            AppMethodBeat.o(244623);
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final /* synthetic */ com.tencent.mm.ak.q genRefreshNetScene() {
            AppMethodBeat.i(244621);
            aq aqVar = new aq(FinderFeedShareRelativeListLoader.this.sBN, FinderFeedShareRelativeListLoader.this.feedId, FinderFeedShareRelativeListLoader.this.tuI, 0, FinderFeedShareRelativeListLoader.this.getLastBuffer(), 0, FinderFeedShareRelativeListLoader.this.getContextObj());
            AppMethodBeat.o(244621);
            return aqVar;
        }
    }
}
