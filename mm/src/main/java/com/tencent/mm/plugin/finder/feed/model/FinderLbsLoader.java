package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ab;
import com.tencent.mm.plugin.finder.cgi.fetcher.b;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.plugin.finder.storage.data.t;
import com.tencent.mm.plugin.finder.storage.o;
import com.tencent.mm.protocal.protobuf.azm;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0014\u0015\u0016B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016R.\u0010\u0006\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "FinderLbsResponse", "FinderLbsReuqest", "LbsDataFetcher", "plugin-finder_release"})
public final class FinderLbsLoader extends BaseFeedLoader<com.tencent.mm.plugin.finder.model.c> {
    public kotlin.g.a.b<? super IResponse<com.tencent.mm.plugin.finder.model.c>, x> fetchEndCallback;

    private /* synthetic */ FinderLbsLoader() {
        this(null);
    }

    public FinderLbsLoader(bbn bbn) {
        super(bbn);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<com.tencent.mm.plugin.finder.model.c> createDataFetch() {
        AppMethodBeat.i(244663);
        c cVar = new c();
        AppMethodBeat.o(244663);
        return cVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u001a\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
    public static final class d extends BaseFeedLoader<com.tencent.mm.plugin.finder.model.c>.a {
        final /* synthetic */ FinderLbsLoader tVF;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderLbsLoader finderLbsLoader) {
            super();
            this.tVF = finderLbsLoader;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void mergeRefresh(IResponse<com.tencent.mm.plugin.finder.model.c> iResponse, kotlin.g.a.b<? super IResponse<com.tencent.mm.plugin.finder.model.c>, x> bVar) {
            boolean z;
            AppMethodBeat.i(244661);
            p.h(iResponse, "response");
            RefreshLoadMoreLayout.c.a aVar = RefreshLoadMoreLayout.c.Rms;
            RefreshLoadMoreLayout.c cVar = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.Rmm);
            if (iResponse.getErrType() == 0 && iResponse.getErrCode() == 0) {
                cVar.Rmh = 1;
            } else {
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                cVar.Rmi = context.getResources().getString(R.string.da_);
                cVar.Rmh = -1;
            }
            if (iResponse.getPullType() != 0) {
                z = true;
            } else {
                z = false;
            }
            cVar.jLE = z;
            cVar.Rmj = iResponse.getHasMore();
            if (cVar.actionType == 0 || cVar.actionType == 4 || cVar.actionType == 4) {
                if (cVar.Rmk > 0 || this.tVF.getDataListJustForAdapter().size() <= 0) {
                    cVar.Rmi = null;
                } else {
                    Context context2 = MMApplicationContext.getContext();
                    p.g(context2, "MMApplicationContext.getContext()");
                    cVar.Rmi = context2.getResources().getString(R.string.dab);
                }
            }
            com.tencent.mm.ac.d.h(new a(this, new n(4, iResponse.getIncrementList(), false, 12), cVar, bVar, iResponse));
            AppMethodBeat.o(244661);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ n $op;
            final /* synthetic */ RefreshLoadMoreLayout.c $reason;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ d tVJ;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, n nVar, RefreshLoadMoreLayout.c cVar, kotlin.g.a.b bVar, IResponse iResponse) {
                super(0);
                this.tVJ = dVar;
                this.$op = nVar;
                this.$reason = cVar;
                this.$next = bVar;
                this.$response = iResponse;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(244660);
                this.tVJ.convertOpToReason(this.$op, this.$reason);
                this.tVJ.tVF.dispatcher().onPreFinishRefresh(this.$reason);
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(244660);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.b<com.tencent.mm.plugin.finder.model.c> createDataMerger() {
        AppMethodBeat.i(244664);
        d dVar = new d(this);
        AppMethodBeat.o(244664);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<com.tencent.mm.plugin.finder.model.c> iResponse) {
        AppMethodBeat.i(244665);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(iResponse);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, bVar.axR());
        p.h(iResponse, "response");
        super.onFetchDone(iResponse);
        if (isInitOperation(iResponse)) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
            AppMethodBeat.o(244665);
            return;
        }
        com.tencent.mm.ac.d.h(new e(this, iResponse));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
        AppMethodBeat.o(244665);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsReuqest;", "", "pullType", "", "(I)V", "getPullType", "()I", "plugin-finder_release"})
    public static final class b {
        final int pullType;

        public b(int i2) {
            this.pullType = i2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
    public static final class a extends IResponse<com.tencent.mm.plugin.finder.model.c> {
        public a(int i2, int i3, String str) {
            super(i2, i3, str);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J \u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016J\u0016\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016J\u0016\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016J\u0016\u0010\u0017\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$LbsDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;)V", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "fetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "", "callback", "fetchInit", "fetchLoadMore", "fetchRefresh", "plugin-finder_release"})
    public final class c extends g<com.tencent.mm.plugin.finder.model.c> {
        i tMX;
        com.tencent.mm.plugin.finder.cgi.fetcher.b tVE;

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
        public static final class a extends q implements kotlin.g.a.b<h, x> {
            final /* synthetic */ c tVG;
            final /* synthetic */ Object tVH;
            final /* synthetic */ f tVx;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, Object obj, f fVar) {
                super(1);
                this.tVG = cVar;
                this.tVH = obj;
                this.tVx = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(h hVar) {
                com.tencent.mm.bw.b bVar;
                AppMethodBeat.i(244653);
                final h hVar2 = hVar;
                p.h(hVar2, "task");
                Log.i(this.tVG.getTAG(), "[call] pullType=" + ((b) this.tVH).pullType);
                com.tencent.mm.plugin.finder.cgi.fetcher.b bVar2 = this.tVG.tVE;
                if (bVar2 == null) {
                    p.hyc();
                }
                AnonymousClass1 r2 = new b.a(this) {
                    /* class com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader.c.a.AnonymousClass1 */
                    final /* synthetic */ a tVI;

                    {
                        this.tVI = r1;
                    }

                    @Override // com.tencent.mm.plugin.finder.cgi.fetcher.b.a
                    public final void a(a aVar) {
                        azm azm;
                        AppMethodBeat.i(244651);
                        p.h(aVar, "response");
                        Log.i(this.tVI.tVG.getTAG(), "[call] onFetchDone... pullType=" + aVar.getPullType());
                        if (aVar.getPullType() != 2) {
                            LinkedList linkedList = new LinkedList();
                            List<com.tencent.mm.plugin.finder.model.c> incrementList = aVar.getIncrementList();
                            if (incrementList != null) {
                                for (com.tencent.mm.plugin.finder.model.c cVar : incrementList) {
                                    o oVar = cVar.uNJ.vEF;
                                    if ((oVar != null ? oVar.vEa : null) != null) {
                                        long j2 = cVar.uNJ.vEH;
                                        o oVar2 = cVar.uNJ.vEF;
                                        if (oVar2 == null || (azm = oVar2.vEa) == null) {
                                            azm = new azm();
                                        }
                                        linkedList.add(new t(j2, azm));
                                    }
                                }
                            }
                            if (linkedList.size() > 0) {
                                l.a aVar2 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
                                String aUg = z.aUg();
                                p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                                l.a.a(9, aUg, linkedList);
                                com.tencent.mm.bw.b lastBuffer = aVar.getLastBuffer();
                                String encodeHexString = Util.encodeHexString(lastBuffer != null ? lastBuffer.toByteArray() : null);
                                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                                p.g(aAh, "MMKernel.storage()");
                                aAh.azQ().set(ar.a.USERINFO_FINDER_TIMELINE_LBS_SECTION_LASTBUF_STRING_SYNC, encodeHexString);
                                Log.i(this.tVI.tVG.getTAG(), "save firstPage and lastBuffer, size:" + linkedList.size() + ", lastBuffer:" + encodeHexString);
                            }
                            Log.i(this.tVI.tVG.getTAG(), "lxl FinderLbsLoader FinderPage size: " + linkedList.size());
                        }
                        this.tVI.tVx.onFetchDone(aVar);
                        hVar2.a(j.OK);
                        AppMethodBeat.o(244651);
                    }
                };
                int i2 = ((b) this.tVH).pullType;
                AnonymousClass2 r4 = new ab.c(this) {
                    /* class com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader.c.a.AnonymousClass2 */
                    final /* synthetic */ a tVI;

                    {
                        this.tVI = r1;
                    }

                    @Override // com.tencent.mm.plugin.finder.cgi.ab.c
                    public final boolean b(dpc dpc) {
                        AppMethodBeat.i(244652);
                        p.h(dpc, "resp");
                        i iVar = this.tVI.tVG.tMX;
                        if (iVar == null || iVar.token != hVar2.token) {
                            hVar2.a(j.OK);
                            String tag = this.tVI.tVG.getTAG();
                            StringBuilder sb = new StringBuilder("[isFetchConsume] executorToken=");
                            i iVar2 = this.tVI.tVG.tMX;
                            Log.w(tag, sb.append(iVar2 != null ? Integer.valueOf(iVar2.token) : null).append(" taskToken=").append(hVar2.token).toString());
                            AppMethodBeat.o(244652);
                            return true;
                        }
                        AppMethodBeat.o(244652);
                        return false;
                    }
                };
                p.h((b) this.tVH, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
                p.h(r2, "callback");
                if (bVar2.twY.txd == 1) {
                    if (i2 != 2) {
                        bVar = null;
                    } else {
                        bVar = bVar2.twY.txe;
                    }
                    new com.tencent.mm.plugin.finder.cgi.n(bVar, new b.d(bVar2, r2, r4), i2, r4, bVar2.ttO).aYI().a(bVar2.ttK);
                } else {
                    b.g gVar = new b.g(bVar2, i2, r2);
                    if (bVar2.twY.txd == 2) {
                        new ab(new b.f(bVar2, gVar), i2, bVar2.dLS, r4, bVar2.twY.txf, bVar2.ttO).aYI().a(bVar2.ttK);
                    } else {
                        com.tencent.mm.plugin.finder.cgi.fetcher.b.a(bVar2, gVar, bVar2.txa, i2, null, false);
                        bVar2.txa = false;
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(244653);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetchRefresh(f<com.tencent.mm.plugin.finder.model.c> fVar) {
            AppMethodBeat.i(244654);
            p.h(fVar, "callback");
            fetch(new b(4), fVar);
            AppMethodBeat.o(244654);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetchLoadMore(f<com.tencent.mm.plugin.finder.model.c> fVar) {
            AppMethodBeat.i(244655);
            p.h(fVar, "callback");
            fetch(new b(2), fVar);
            AppMethodBeat.o(244655);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetchInit(f<com.tencent.mm.plugin.finder.model.c> fVar) {
            b.C1092b bVar;
            com.tencent.mm.bw.b bVar2;
            b.C1092b bVar3;
            AppMethodBeat.i(244656);
            p.h(fVar, "callback");
            LinkedList linkedList = new LinkedList();
            try {
                l.a aVar = com.tencent.mm.plugin.finder.storage.data.l.vGw;
                l.a.Lf(9);
                linkedList.addAll(l.a.avF(""));
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                p.g(aAh, "MMKernel.storage()");
                Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_TIMELINE_LBS_SECTION_LASTBUF_STRING_SYNC, "");
                if (obj == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(244656);
                    throw tVar;
                }
                byte[] decodeHexString = Util.decodeHexString((String) obj);
                com.tencent.mm.plugin.finder.cgi.fetcher.b bVar4 = this.tVE;
                if (!(bVar4 == null || (bVar3 = bVar4.twY) == null)) {
                    bVar3.txe = com.tencent.mm.bw.b.cD(decodeHexString);
                }
                String tag = getTAG();
                StringBuilder append = new StringBuilder("FinderLbsLoader load init data from FirstPage, size:").append(linkedList.size()).append(", lastBuffer:");
                com.tencent.mm.plugin.finder.cgi.fetcher.b bVar5 = this.tVE;
                Log.i(tag, append.append(Util.encodeHexString((bVar5 == null || (bVar = bVar5.twY) == null || (bVar2 = bVar.txe) == null) ? null : bVar2.toByteArray())).toString());
                a aVar2 = new a(0, 0, "");
                aVar2.setPullType(1000);
                aVar2.setIncrementList(linkedList);
                fVar.onFetchDone(aVar2);
                AppMethodBeat.o(244656);
            } catch (Throwable th) {
                Log.printErrStackTrace(getTAG(), th, "lxl FinderLbsLoader load init data exception", new Object[0]);
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetch(Object obj, f<com.tencent.mm.plugin.finder.model.c> fVar) {
            i iVar;
            AppMethodBeat.i(244657);
            p.h(fVar, "callback");
            if (!(obj instanceof b) || (iVar = this.tMX) == null) {
                AppMethodBeat.o(244657);
                return;
            }
            iVar.a(new h(new a(this, obj, fVar)));
            AppMethodBeat.o(244657);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void alive() {
            AppMethodBeat.i(244658);
            super.alive();
            this.tVE = new com.tencent.mm.plugin.finder.cgi.fetcher.b(FinderLbsLoader.this.getContextObj());
            i iVar = new i("FinderFollowTlSingleExecutor");
            iVar.start();
            this.tMX = iVar;
            new com.tencent.mm.plugin.finder.cgi.fetcher.b(FinderLbsLoader.this.getContextObj());
            AppMethodBeat.o(244658);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void dead() {
            com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> cVar;
            AppMethodBeat.i(244659);
            super.dead();
            com.tencent.mm.plugin.finder.cgi.fetcher.b bVar = this.tVE;
            if (!(bVar == null || (cVar = bVar.ttK) == null)) {
                cVar.dead();
            }
            i iVar = this.tMX;
            if (iVar != null) {
                iVar.reset();
            }
            this.tMX = null;
            AppMethodBeat.o(244659);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ IResponse $response;
        final /* synthetic */ FinderLbsLoader tVF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderLbsLoader finderLbsLoader, IResponse iResponse) {
            super(0);
            this.tVF = finderLbsLoader;
            this.$response = iResponse;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            kotlin.g.a.b<? super IResponse<com.tencent.mm.plugin.finder.model.c>, x> bVar;
            AppMethodBeat.i(244662);
            if (!this.$response.getHasMore() && (bVar = this.tVF.fetchEndCallback) != null) {
                bVar.invoke(this.$response);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244662);
            return xVar;
        }
    }
}
