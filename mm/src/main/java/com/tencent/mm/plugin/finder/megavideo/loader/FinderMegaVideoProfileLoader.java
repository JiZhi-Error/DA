package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002!\"B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0019H\u0016J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u000eH\u0016J\u0016\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170 H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "initRemoveItemCount", "", "getInitRemoveItemCount", "()I", "setInitRemoveItemCount", "(I)V", "needMergeLocalData", "", "getNeedMergeLocalData", "()Z", "setNeedMergeLocalData", "(Z)V", "getTargetUsername", "()Ljava/lang/String;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getLastItem", "", "isObservePostEvent", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "MegaVideoProfileDataFetcher", "MegaVideoProfileResponse", "plugin-finder_release"})
public final class FinderMegaVideoProfileLoader extends BaseMegaVideoLoader {
    public final String tvp;
    public boolean uKQ;
    public int uKR;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderMegaVideoProfileLoader(String str, bbn bbn) {
        super(bbn);
        p.h(str, "targetUsername");
        AppMethodBeat.i(248402);
        this.tvp = str;
        AppMethodBeat.o(248402);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(248399);
        a aVar = new a();
        AppMethodBeat.o(248399);
        return aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u001a\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
    public static final class c extends BaseFeedLoader<bo>.a {
        final /* synthetic */ FinderMegaVideoProfileLoader uKS;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderMegaVideoProfileLoader finderMegaVideoProfileLoader) {
            super();
            this.uKS = finderMegaVideoProfileLoader;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void mergeRefresh(IResponse<bo> iResponse, kotlin.g.a.b<? super IResponse<bo>, x> bVar) {
            AppMethodBeat.i(248398);
            p.h(iResponse, "response");
            RefreshLoadMoreLayout.c.a aVar = RefreshLoadMoreLayout.c.Rms;
            d.h(new a(this, new n(7, iResponse.getIncrementList(), false, 12), new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.Rmm), bVar, iResponse));
            AppMethodBeat.o(248398);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ n $op;
            final /* synthetic */ RefreshLoadMoreLayout.c $reason;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ c uKV;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, n nVar, RefreshLoadMoreLayout.c cVar2, kotlin.g.a.b bVar, IResponse iResponse) {
                super(0);
                this.uKV = cVar;
                this.$op = nVar;
                this.$reason = cVar2;
                this.$next = bVar;
                this.$response = iResponse;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(248397);
                this.uKV.convertOpToReason(this.$op, this.$reason);
                this.uKV.uKS.dispatcher().onPreFinishRefresh(this.$reason);
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(248397);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger() {
        AppMethodBeat.i(248400);
        c cVar = new c(this);
        AppMethodBeat.o(248400);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        AppMethodBeat.i(248401);
        p.h(iResponse, "response");
        super.onFetchDone(iResponse);
        if (isInitOperation(iResponse)) {
            AppMethodBeat.o(248401);
            return;
        }
        this.hasMore = iResponse.getHasMore();
        kotlin.g.a.b<? super IResponse<bo>, x> bVar = this.fetchEndCallback;
        if (bVar != null) {
            bVar.invoke(iResponse);
            AppMethodBeat.o(248401);
            return;
        }
        AppMethodBeat.o(248401);
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader
    public final boolean isObservePostEvent() {
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader$MegaVideoProfileResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
    public static final class b extends IResponse<bo> {
        public b(int i2, int i3, String str) {
            super(i2, i3, str);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J2\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0012H\u0016J4\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader$MegaVideoProfileDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage;", "getCmdIds", "", "mergeLocalData", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "nowList", ch.COL_USERNAME, "start", "end", "plugin-finder_release"})
    public final class a extends com.tencent.mm.plugin.finder.feed.model.internal.a {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader$MegaVideoProfileDataFetcher$callInit$1$1"})
        /* renamed from: com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader$a$a  reason: collision with other inner class name */
        static final class C1218a extends q implements kotlin.g.a.b<bo, Boolean> {
            final /* synthetic */ a uKT;
            final /* synthetic */ b uKU;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1218a(a aVar, b bVar) {
                super(1);
                this.uKT = aVar;
                this.uKU = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Boolean invoke(bo boVar) {
                boolean z;
                AppMethodBeat.i(248388);
                bo boVar2 = boVar;
                p.h(boVar2, LocaleUtil.ITALIAN);
                if (boVar2.lT() == 0) {
                    FinderMegaVideoProfileLoader.this.uKR++;
                    z = true;
                } else {
                    z = false;
                }
                Boolean valueOf = Boolean.valueOf(z);
                AppMethodBeat.o(248388);
                return valueOf;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "removeIt", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "invoke"})
        public static final class c extends q implements kotlin.g.a.b<FinderItem, Boolean> {
            final /* synthetic */ List $nowList;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(List list) {
                super(1);
                this.$nowList = list;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX WARNING: Code restructure failed: missing block: B:10:0x0047, code lost:
                if (r6 == r0.id) goto L_0x0049;
             */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x004c A[SYNTHETIC] */
            @Override // kotlin.g.a.b
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final /* synthetic */ java.lang.Boolean invoke(com.tencent.mm.plugin.finder.storage.FinderItem r12) {
                /*
                // Method dump skipped, instructions count: 102
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader.a.c.invoke(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(248391);
            List<Integer> listOf = j.listOf((Object) 3736);
            AppMethodBeat.o(248391);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genLoadMoreNetScene() {
            long j2;
            AppMethodBeat.i(248393);
            FinderMegaVideoProfileLoader finderMegaVideoProfileLoader = FinderMegaVideoProfileLoader.this;
            int size = finderMegaVideoProfileLoader.getDataList().size() - 1;
            while (true) {
                if (size < 0) {
                    j2 = 0;
                    break;
                }
                bo boVar = (bo) finderMegaVideoProfileLoader.getDataList().get(size);
                if ((boVar instanceof bm) && ((bm) boVar).getFeedObject().id != 0) {
                    j2 = ((bm) boVar).getFeedObject().id;
                    break;
                }
                size--;
            }
            cn cnVar = new cn(FinderMegaVideoProfileLoader.this.tvp, j2, FinderMegaVideoProfileLoader.this.getLastBuffer(), 2, FinderMegaVideoProfileLoader.this.getContextObj(), 1, 0, 64);
            AppMethodBeat.o(248393);
            return cnVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            boolean z;
            AppMethodBeat.i(248394);
            p.h(qVar, "scene");
            if (qVar instanceof cn) {
                if (i2 == 0 && i3 == 0) {
                    z = ((cn) qVar).tuG;
                } else {
                    z = true;
                }
                b bVar = new b(i2, i3, str);
                bVar.setPullType(((cn) qVar).pullType);
                List<? extends FinderItem> list = ((cn) qVar).tvo;
                if (list == null) {
                    list = new LinkedList();
                }
                List<? extends FinderItem> list2 = list;
                ArrayList arrayList = new ArrayList(j.a(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(new bm(it.next().getFeedObject()));
                }
                bVar.setIncrementList(i(arrayList, FinderMegaVideoProfileLoader.this.tvp));
                bVar.setLastBuffer(((cn) qVar).getLastBuffer());
                bVar.setHasMore(z);
                c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                List<? extends FinderItem> list3 = list;
                ArrayList arrayList2 = new ArrayList(j.a(list3, 10));
                Iterator<T> it2 = list3.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(it2.next().getFeedObject());
                }
                c.a.b(arrayList2, FinderMegaVideoProfileLoader.this.getContextObj());
                String tag = getTAG();
                StringBuilder sb = new StringBuilder("incrementList size: ");
                List incrementList = bVar.getIncrementList();
                Log.i(tag, sb.append(incrementList != null ? Integer.valueOf(incrementList.size()) : null).toString());
                b bVar2 = bVar;
                AppMethodBeat.o(248394);
                return bVar2;
            }
            AppMethodBeat.o(248394);
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> callInit() {
            ArrayList<bo> arrayList;
            com.tencent.mm.bw.b bVar;
            AppMethodBeat.i(248395);
            Log.i(getTAG(), "fetchInit");
            b bVar2 = new b(0, 0, "");
            bVar2.setPullType(1000);
            h cache = FinderMegaVideoProfileLoader.this.getCache();
            if (cache == null || (arrayList = cache.kgc) == null) {
                List<bo> bc = com.tencent.mm.plugin.finder.storage.data.l.vGw.bc(13, FinderMegaVideoProfileLoader.this.tvp);
                Log.i(getTAG(), "fetchInit: use first page data list, size: " + bc.size());
                List<bo> list = bc;
                ArrayList arrayList2 = new ArrayList(j.a(list, 10));
                for (T t : list) {
                    if (t == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.MegaVideoFeed");
                        AppMethodBeat.o(248395);
                        throw tVar;
                    }
                    arrayList2.add(t);
                }
                bVar2.setIncrementList(i(arrayList2, FinderMegaVideoProfileLoader.this.tvp));
            } else {
                Log.i(getTAG(), "fetchInit: use old data list, size: " + arrayList.size());
                if (!FinderMegaVideoProfileLoader.this.uKQ) {
                    d.a((ArrayList) arrayList, (kotlin.g.a.b) new C1218a(this, bVar2));
                }
                bVar2.setIncrementList(arrayList);
                h cache2 = FinderMegaVideoProfileLoader.this.getCache();
                if (cache2 != null) {
                    bVar = cache2.lastBuffer;
                } else {
                    bVar = null;
                }
                bVar2.setLastBuffer(bVar);
            }
            b bVar3 = bVar2;
            AppMethodBeat.o(248395);
            return bVar3;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
        public static final class b<T> implements Comparator<T> {
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int i2;
                int i3 = 0;
                AppMethodBeat.i(248389);
                cng cng = t2.tuP;
                if (cng != null) {
                    i2 = cng.iXu;
                } else {
                    i2 = 0;
                }
                Integer valueOf = Integer.valueOf(i2);
                cng cng2 = t.tuP;
                if (cng2 != null) {
                    i3 = cng2.iXu;
                }
                int a2 = kotlin.b.a.a(valueOf, Integer.valueOf(i3));
                AppMethodBeat.o(248389);
                return a2;
            }
        }

        private final List<bm> i(List<bm> list, String str) {
            AppMethodBeat.i(248396);
            if ((str.length() == 0) || (!p.j(str, z.aUg())) || !FinderMegaVideoProfileLoader.this.uKQ) {
                AppMethodBeat.o(248396);
                return list;
            }
            Log.i(getTAG(), new StringBuilder("mergeLocalData start 0 end 2147483647").toString());
            LinkedList linkedList = new LinkedList();
            c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            LinkedList<FinderItem> af = c.a.af(str, 0, Integer.MAX_VALUE);
            linkedList.addAll(list);
            LinkedList linkedList2 = linkedList;
            if (linkedList2.size() > 1) {
                j.a((List) linkedList2, (Comparator) new b());
            }
            d.a((LinkedList) af, (kotlin.g.a.b) new c(list));
            LinkedList<FinderItem> linkedList3 = af;
            ArrayList arrayList = new ArrayList(j.a(linkedList3, 10));
            for (T t : linkedList3) {
                bm bmVar = new bm(t.getFeedObject());
                bmVar.uOW = t;
                arrayList.add(bmVar);
            }
            linkedList.addAll(0, arrayList);
            Log.i(getTAG(), "mergeLocalData: databaseList size:" + af.size());
            for (T t2 : af) {
                Log.i(getTAG(), "mergeLocalData: databaseList item, localId:" + t2.getLocalId() + ", id:" + t2.getId());
            }
            LinkedList linkedList4 = linkedList;
            AppMethodBeat.o(248396);
            return linkedList4;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final /* synthetic */ com.tencent.mm.ak.q genRefreshNetScene() {
            AppMethodBeat.i(248392);
            cn cnVar = new cn(FinderMegaVideoProfileLoader.this.tvp, 0, null, 0, FinderMegaVideoProfileLoader.this.getContextObj(), 1, 0, 64);
            AppMethodBeat.o(248392);
            return cnVar;
        }
    }
}
