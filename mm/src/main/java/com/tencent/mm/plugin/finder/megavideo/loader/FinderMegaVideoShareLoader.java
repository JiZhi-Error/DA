package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.cgi.cu;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u000389:BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0016J\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020103H\u0016J\u0016\u00104\u001a\u00020#2\f\u00105\u001a\b\u0012\u0004\u0012\u00020106H\u0016J\b\u00107\u001a\u00020#H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R0\u0010 \u001a\u0018\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020#\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0012¨\u0006;"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoShareLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "feedId", "", "nonceId", "", "fromUsername", "toUserName", "sessionId", "sessionBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFeedId", "()J", "firstUserName", "getFirstUserName", "()Ljava/lang/String;", "setFirstUserName", "(Ljava/lang/String;)V", "getFromUsername", "needGetDetail", "", "getNeedGetDetail", "()Z", "setNeedGetDetail", "(Z)V", "getNonceId", "getSessionBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getSessionId", "showErrUi", "Lkotlin/Function2;", "", "", "getShowErrUi", "()Lkotlin/jvm/functions/Function2;", "setShowErrUi", "(Lkotlin/jvm/functions/Function2;)V", "successNext", "Lkotlin/Function0;", "getSuccessNext", "()Lkotlin/jvm/functions/Function0;", "setSuccessNext", "(Lkotlin/jvm/functions/Function0;)V", "getToUserName", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "requestRefresh", "MegaVideoGetDetailResponse", "MegaVideoListResponse", "RelatedMegaVideoDataFetcher", "plugin-finder_release"})
public final class FinderMegaVideoShareLoader extends BaseMegaVideoLoader {
    private final String dJw;
    private final String dkU;
    final long feedId;
    final String hwg;
    private final String sessionId;
    public m<? super Integer, ? super String, x> tNM;
    private final com.tencent.mm.bw.b tvj;
    public String uKW;
    boolean uKX;
    public kotlin.g.a.a<x> uLa;

    public /* synthetic */ FinderMegaVideoShareLoader(long j2, String str, String str2, String str3, bbn bbn) {
        this(j2, str, str2, str3, "", bbn);
        AppMethodBeat.i(248429);
        AppMethodBeat.o(248429);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FinderMegaVideoShareLoader(long j2, String str, String str2, String str3, String str4, bbn bbn) {
        super(bbn);
        p.h(str, "nonceId");
        p.h(str2, "fromUsername");
        p.h(str3, "toUserName");
        AppMethodBeat.i(248428);
        this.feedId = j2;
        this.hwg = str;
        this.dkU = str2;
        this.dJw = str3;
        this.sessionId = str4;
        this.tvj = null;
        this.uKW = "";
        this.uKX = true;
        AppMethodBeat.o(248428);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(248424);
        c cVar = new c();
        AppMethodBeat.o(248424);
        return cVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u001a\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoShareLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeInit", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
    public static final class d extends BaseFeedLoader<bo>.a {
        final /* synthetic */ FinderMegaVideoShareLoader uLb;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderMegaVideoShareLoader finderMegaVideoShareLoader) {
            super();
            this.uLb = finderMegaVideoShareLoader;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void mergeInit(IResponse<bo> iResponse, kotlin.g.a.b<? super IResponse<bo>, x> bVar) {
            AppMethodBeat.i(248423);
            p.h(iResponse, "response");
            if (iResponse instanceof a) {
                if (iResponse.getIncrementList() == null) {
                    iResponse.setIncrementList(v.SXr);
                }
                com.tencent.mm.ac.d.h(new a(this, iResponse, bVar));
                AppMethodBeat.o(248423);
                return;
            }
            super.mergeInit(iResponse, bVar);
            AppMethodBeat.o(248423);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ d uLi;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, IResponse iResponse, kotlin.g.a.b bVar) {
                super(0);
                this.uLi = dVar;
                this.$response = iResponse;
                this.$next = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                boolean z;
                bm bmVar = null;
                AppMethodBeat.i(248422);
                if (this.uLi.uLb.getDataList().size() > 0) {
                    List incrementList = this.$response.getIncrementList();
                    if (incrementList != null) {
                        if (incrementList.size() == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        List list = z ? incrementList : null;
                        if (list != null) {
                            Object obj = this.uLi.uLb.getDataList().get(0);
                            if (obj instanceof bm) {
                                bmVar = obj;
                            }
                            bm bmVar2 = bmVar;
                            if (bmVar2 != null) {
                                Object obj2 = list.get(0);
                                if (obj2 == null) {
                                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.MegaVideoFeed");
                                    AppMethodBeat.o(248422);
                                    throw tVar;
                                }
                                bmVar2.g(((bm) obj2).getFeedObject());
                            }
                            this.uLi.uLb.dispatcher().onItemRangeChanged(0, 1, new o(0, 1));
                        }
                    }
                } else {
                    DataBuffer dataList = this.uLi.uLb.getDataList();
                    List incrementList2 = this.$response.getIncrementList();
                    if (incrementList2 == null) {
                        p.hyc();
                    }
                    dataList.addAll(incrementList2);
                    this.uLi.uLb.dispatcher().onChanged();
                }
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(248422);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger() {
        AppMethodBeat.i(248425);
        d dVar = new d(this);
        AppMethodBeat.o(248425);
        return dVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoShareLoader$MegaVideoGetDetailResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
    public static final class a extends IResponse<bo> {
        public a(int i2, int i3, String str) {
            super(i2, i3, str);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoShareLoader$MegaVideoListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
    public static final class b extends IResponse<bo> {
        public b(String str) {
            super(0, 0, str);
        }
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        int i2;
        String str;
        AppMethodBeat.i(248426);
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
                    AppMethodBeat.o(248426);
                    throw tVar;
                }
                FinderContact finderContact = ((bm) boVar).contact;
                if (finderContact == null || (str = finderContact.username) == null) {
                    str = "";
                }
                this.uKW = str;
            }
            AppMethodBeat.o(248426);
            return;
        }
        this.hasMore = iResponse.getHasMore();
        kotlin.g.a.b<? super IResponse<bo>, x> bVar = this.fetchEndCallback;
        if (bVar != null) {
            bVar.invoke(iResponse);
            AppMethodBeat.o(248426);
            return;
        }
        AppMethodBeat.o(248426);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final void requestRefresh() {
        AppMethodBeat.i(248427);
        requestLoadMore();
        AppMethodBeat.o(248427);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J2\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0015H\u0016¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoShareLoader$RelatedMegaVideoDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoShareLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetchInit", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
    public final class c extends com.tencent.mm.plugin.finder.feed.model.internal.a {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call", "com/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoShareLoader$RelatedMegaVideoDataFetcher$dealOnSceneEnd$2$1"})
        static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
            final /* synthetic */ long uLc;
            final /* synthetic */ c uLd;
            final /* synthetic */ bm uLe;
            final /* synthetic */ int uLf;
            final /* synthetic */ String uLg;
            final /* synthetic */ int uLh;

            a(long j2, c cVar, bm bmVar, int i2, String str, int i3) {
                this.uLc = j2;
                this.uLd = cVar;
                this.uLe = bmVar;
                this.uLf = i2;
                this.uLg = str;
                this.uLh = i3;
            }

            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(248416);
                c.a aVar = (c.a) obj;
                if (aVar == null) {
                    Log.i(this.uLd.getTAG(), "result == null finder id " + this.uLc);
                    m<? super Integer, ? super String, x> mVar = FinderMegaVideoShareLoader.this.tNM;
                    if (mVar != null) {
                        mVar.invoke(Integer.valueOf(this.uLf), this.uLg);
                    }
                } else {
                    Log.i(this.uLd.getTAG(), "CgiGetFinderFeedComment errType = " + this.uLh + ", errCode = " + this.uLf);
                    if (!(aVar.errType == 0 && aVar.errCode == 0)) {
                        y yVar = y.vXH;
                        if (!y.gp(aVar.errType, aVar.errCode)) {
                            m<? super Integer, ? super String, x> mVar2 = FinderMegaVideoShareLoader.this.tNM;
                            if (mVar2 != null) {
                                mVar2.invoke(Integer.valueOf(this.uLf), this.uLg);
                            }
                        }
                    }
                    FinderObject finderObject = ((ars) aVar.iLC).feedObject;
                    if (finderObject != null) {
                        a aVar2 = new a(this.uLh, this.uLf, this.uLg);
                        p.g(finderObject, "this");
                        bm bmVar = new bm(finderObject);
                        c.a aVar3 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                        c.a.b(j.listOf(finderObject), FinderMegaVideoShareLoader.this.getContextObj());
                        aVar2.setIncrementList(j.listOf(bmVar));
                        aVar2.setPullType(1000);
                        FinderMegaVideoShareLoader.this.onFetchDone(aVar2);
                        kotlin.g.a.a<x> aVar4 = FinderMegaVideoShareLoader.this.uLa;
                        if (aVar4 != null) {
                            aVar4.invoke();
                        }
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(248416);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(248418);
            List<Integer> listOf = j.listOf((Object) 4195);
            AppMethodBeat.o(248418);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genRefreshNetScene() {
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genLoadMoreNetScene() {
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            cns cns;
            String str2;
            cns cns2;
            AppMethodBeat.i(248419);
            p.h(qVar, "scene");
            if (qVar instanceof cu) {
                bm bmVar = new bm(((cu) qVar).cZr());
                Log.i(getTAG(), "NetSceneMegaVideoGetDetail errType = " + i2 + ", errCode = " + i3);
                if (i2 == 0 && i3 == 0) {
                    cng cng = bmVar.tuP;
                    if (!(cng == null || (cns = cng.MtI) == null)) {
                        long j2 = cns.hFK;
                        cng cng2 = bmVar.tuP;
                        if (cng2 == null || (cns2 = cng2.MtI) == null || (str2 = cns2.objectNonceId) == null) {
                            str2 = "";
                        }
                        bbn contextObj = FinderMegaVideoShareLoader.this.getContextObj();
                        new af(j2, str2, contextObj != null ? contextObj.tCE : 0, 2, "", true, null, null, 0, null, false, false, null, FinderMegaVideoShareLoader.this.getContextObj(), 0, 24512).aYI().b(new a(j2, this, bmVar, i3, str, i2));
                    }
                } else {
                    com.tencent.mm.ac.d.h(new b(this, i3, str));
                }
                AppMethodBeat.o(248419);
                return null;
            }
            AppMethodBeat.o(248419);
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> callInit() {
            ArrayList<bo> arrayList;
            com.tencent.mm.bw.b bVar;
            AppMethodBeat.i(248420);
            b bVar2 = new b("");
            bVar2.setPullType(1000);
            h cache = FinderMegaVideoShareLoader.this.getCache();
            if (!(cache == null || (arrayList = cache.kgc) == null)) {
                Log.i(getTAG(), "fetchInit: use old data list, size: " + arrayList.size());
                bVar2.setIncrementList(arrayList);
                h cache2 = FinderMegaVideoShareLoader.this.getCache();
                if (cache2 != null) {
                    bVar = cache2.lastBuffer;
                } else {
                    bVar = null;
                }
                bVar2.setLastBuffer(bVar);
            }
            b bVar3 = bVar2;
            AppMethodBeat.o(248420);
            return bVar3;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a, com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetchInit(f<bo> fVar) {
            AppMethodBeat.i(248421);
            p.h(fVar, "callback");
            super.fetchInit(fVar);
            if (FinderMegaVideoShareLoader.this.feedId != 0 && FinderMegaVideoShareLoader.this.uKX) {
                fetch(new cu(FinderMegaVideoShareLoader.this.feedId, FinderMegaVideoShareLoader.this.uKW, FinderMegaVideoShareLoader.this.hwg, 1, FinderMegaVideoShareLoader.this.getContextObj()), fVar);
            }
            AppMethodBeat.o(248421);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ int $errCode;
            final /* synthetic */ String $errMsg;
            final /* synthetic */ c uLd;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(c cVar, int i2, String str) {
                super(0);
                this.uLd = cVar;
                this.$errCode = i2;
                this.$errMsg = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(248417);
                m<? super Integer, ? super String, x> mVar = FinderMegaVideoShareLoader.this.tNM;
                if (mVar != null) {
                    mVar.invoke(Integer.valueOf(this.$errCode), this.$errMsg);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(248417);
                return xVar;
            }
        }
    }
}
