package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
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

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003567B\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.H\u0016J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020/01H\u0016J\u0016\u00102\u001a\u00020!2\f\u00103\u001a\b\u0012\u0004\u0012\u00020/04H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR0\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020!\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R(\u0010&\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020!\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMFragmentActivity;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/ui/MMFragmentActivity;)V", "getActivity", "()Lcom/tencent/mm/ui/MMFragmentActivity;", "firstFeedId", "", "getFirstFeedId", "()J", "setFirstFeedId", "(J)V", "firstNonceId", "", "getFirstNonceId", "()Ljava/lang/String;", "setFirstNonceId", "(Ljava/lang/String;)V", "firstUserName", "getFirstUserName", "setFirstUserName", "needGetDetail", "", "getNeedGetDetail", "()Z", "setNeedGetDetail", "(Z)V", "showErrUi", "Lkotlin/Function2;", "", "", "getShowErrUi", "()Lkotlin/jvm/functions/Function2;", "setShowErrUi", "(Lkotlin/jvm/functions/Function2;)V", "successNext", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "getSuccessNext", "()Lkotlin/jvm/functions/Function1;", "setSuccessNext", "(Lkotlin/jvm/functions/Function1;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "MegaVideoGetDetailResponse", "MegaVideoListResponse", "NormalMegaVideoDataFetcher", "plugin-finder_release"})
public final class NormalMegaVideoLoader extends BaseMegaVideoLoader {
    public m<? super Integer, ? super String, x> tNM;
    public kotlin.g.a.b<? super bm, x> tNN;
    private String uKW = "";
    public boolean uKX;
    public long uLp;
    public String uLq = "";
    final MMFragmentActivity uLr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NormalMegaVideoLoader(bbn bbn, MMFragmentActivity mMFragmentActivity) {
        super(bbn);
        p.h(mMFragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(248442);
        this.uLr = mMFragmentActivity;
        AppMethodBeat.o(248442);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(248439);
        c cVar = new c();
        AppMethodBeat.o(248439);
        return cVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u001a\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeInit", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
    public static final class d extends BaseFeedLoader<bo>.a {
        final /* synthetic */ NormalMegaVideoLoader uLs;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(NormalMegaVideoLoader normalMegaVideoLoader) {
            super();
            this.uLs = normalMegaVideoLoader;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void mergeInit(IResponse<bo> iResponse, kotlin.g.a.b<? super IResponse<bo>, x> bVar) {
            AppMethodBeat.i(248438);
            p.h(iResponse, "response");
            if (iResponse instanceof a) {
                if (iResponse.getIncrementList() == null) {
                    iResponse.setIncrementList(v.SXr);
                }
                com.tencent.mm.ac.d.h(new a(this, iResponse, bVar));
                AppMethodBeat.o(248438);
                return;
            }
            super.mergeInit(iResponse, bVar);
            AppMethodBeat.o(248438);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ d uLu;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, IResponse iResponse, kotlin.g.a.b bVar) {
                super(0);
                this.uLu = dVar;
                this.$response = iResponse;
                this.$next = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                boolean z;
                bm bmVar = null;
                AppMethodBeat.i(248437);
                if (this.uLu.uLs.getDataList().size() > 0) {
                    List incrementList = this.$response.getIncrementList();
                    if (incrementList != null) {
                        if (incrementList.size() == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        List list = z ? incrementList : null;
                        if (list != null) {
                            Object obj = this.uLu.uLs.getDataList().get(0);
                            if (obj instanceof bm) {
                                bmVar = obj;
                            }
                            bm bmVar2 = bmVar;
                            if (bmVar2 != null) {
                                Object obj2 = list.get(0);
                                if (obj2 == null) {
                                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.MegaVideoFeed");
                                    AppMethodBeat.o(248437);
                                    throw tVar;
                                }
                                bmVar2.g(((bm) obj2).getFeedObject());
                            }
                            this.uLu.uLs.dispatcher().onItemRangeChanged(0, 1, new o(0, 1));
                        }
                    }
                } else {
                    DataBuffer dataList = this.uLu.uLs.getDataList();
                    List incrementList2 = this.$response.getIncrementList();
                    if (incrementList2 == null) {
                        p.hyc();
                    }
                    dataList.addAll(incrementList2);
                    this.uLu.uLs.dispatcher().onChanged();
                }
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(248437);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger() {
        AppMethodBeat.i(248440);
        d dVar = new d(this);
        AppMethodBeat.o(248440);
        return dVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader$MegaVideoGetDetailResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
    public static final class a extends IResponse<bo> {
        public a(int i2, int i3, String str) {
            super(i2, i3, str);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader$MegaVideoListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
    public static final class b extends IResponse<bo> {
        public b(String str) {
            super(0, 0, str);
        }
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        int i2;
        String str;
        AppMethodBeat.i(248441);
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
                    AppMethodBeat.o(248441);
                    throw tVar;
                }
                bm bmVar = (bm) boVar;
                FinderContact finderContact = bmVar.contact;
                if (finderContact == null || (str = finderContact.username) == null) {
                    str = "";
                }
                this.uKW = str;
                this.uLp = bmVar.dkW();
                this.uLq = bmVar.dkX();
            }
            AppMethodBeat.o(248441);
            return;
        }
        this.hasMore = iResponse.getHasMore();
        kotlin.g.a.b<? super IResponse<bo>, x> bVar = this.fetchEndCallback;
        if (bVar != null) {
            bVar.invoke(iResponse);
            AppMethodBeat.o(248441);
            return;
        }
        AppMethodBeat.o(248441);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J2\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0016¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader$NormalMegaVideoDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/NormalMegaVideoLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
    public final class c extends com.tencent.mm.plugin.finder.feed.model.internal.a {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
        static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
            final /* synthetic */ c uLt;

            a(c cVar) {
                this.uLt = cVar;
            }

            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(248433);
                c.a aVar = (c.a) obj;
                if (aVar == null) {
                    Log.i(this.uLt.getTAG(), "result == null finder id " + NormalMegaVideoLoader.this.uLp);
                    m<? super Integer, ? super String, x> mVar = NormalMegaVideoLoader.this.tNM;
                    if (mVar != null) {
                        mVar.invoke(-1, null);
                    }
                } else {
                    Log.i(this.uLt.getTAG(), "NormalMegaVideoLoader: CgiGetFinderFeedComment errType = " + aVar.errType + ", errCode = " + aVar.errCode);
                    if (!(aVar.errType == 0 && aVar.errCode == 0)) {
                        y yVar = y.vXH;
                        if (!y.gp(aVar.errType, aVar.errCode)) {
                            m<? super Integer, ? super String, x> mVar2 = NormalMegaVideoLoader.this.tNM;
                            if (mVar2 != null) {
                                mVar2.invoke(Integer.valueOf(aVar.errCode), aVar.errMsg);
                            }
                        }
                    }
                    FinderObject finderObject = ((ars) aVar.iLC).feedObject;
                    if (finderObject != null) {
                        a aVar2 = new a(aVar.errType, aVar.errCode, aVar.errMsg);
                        p.g(finderObject, "this");
                        bm bmVar = new bm(finderObject);
                        c.a aVar3 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                        c.a.b(j.listOf(finderObject), NormalMegaVideoLoader.this.getContextObj());
                        aVar2.setIncrementList(j.listOf(bmVar));
                        aVar2.setPullType(1000);
                        NormalMegaVideoLoader.this.onFetchDone(aVar2);
                        kotlin.g.a.b<? super bm, x> bVar = NormalMegaVideoLoader.this.tNN;
                        if (bVar != null) {
                            bVar.invoke(bmVar);
                        }
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(248433);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(248434);
            List<Integer> listOf = j.listOf((Object) 4195);
            AppMethodBeat.o(248434);
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
            AppMethodBeat.i(248435);
            p.h(qVar, "scene");
            AppMethodBeat.o(248435);
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> callInit() {
            ArrayList<bo> arrayList;
            com.tencent.mm.bw.b bVar;
            AppMethodBeat.i(248436);
            b bVar2 = new b("");
            bVar2.setPullType(1000);
            h cache = NormalMegaVideoLoader.this.getCache();
            if (cache == null || (arrayList = cache.kgc) == null) {
                c cVar = this;
                if (NormalMegaVideoLoader.this.uLp != 0) {
                    e.a aVar = e.vFX;
                    FinderObject FD = e.a.FD(NormalMegaVideoLoader.this.uLp);
                    if (FD != null) {
                        Log.i(cVar.getTAG(), "fetchInit: use finder cache data");
                        bVar2.setIncrementList(j.listOf(new bm(FD)));
                    }
                }
            } else {
                Log.i(getTAG(), "fetchInit: use old data list, size: " + arrayList.size());
                bVar2.setIncrementList(arrayList);
                h cache2 = NormalMegaVideoLoader.this.getCache();
                if (cache2 != null) {
                    bVar = cache2.lastBuffer;
                } else {
                    bVar = null;
                }
                bVar2.setLastBuffer(bVar);
            }
            if (NormalMegaVideoLoader.this.uKX && NormalMegaVideoLoader.this.uLp != 0) {
                String str = NormalMegaVideoLoader.this.uLq;
                if (!(str == null || str.length() == 0)) {
                    long j2 = NormalMegaVideoLoader.this.uLp;
                    String str2 = NormalMegaVideoLoader.this.uLq;
                    bbn contextObj = NormalMegaVideoLoader.this.getContextObj();
                    new af(j2, str2, contextObj != null ? contextObj.tCE : 0, 2, "", true, null, null, 0, null, false, false, null, NormalMegaVideoLoader.this.getContextObj(), 0, 24512).aYI().b(new a(this)).a(NormalMegaVideoLoader.this.uLr);
                }
            }
            b bVar3 = bVar2;
            AppMethodBeat.o(248436);
            return bVar3;
        }
    }
}
