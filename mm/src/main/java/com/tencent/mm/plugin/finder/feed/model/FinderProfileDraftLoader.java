package com.tencent.mm.plugin.finder.feed.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hu;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bf;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.g;
import com.tencent.mm.plugin.finder.storage.h;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0011\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004<=>?B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000e\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020\u0015H\u0002J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020(H\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020*H\u0016J$\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0/2\u0006\u00100\u001a\u00020\u0004H\u0002J\b\u00101\u001a\u00020\u0015H\u0016J\b\u00102\u001a\u00020\u0015H\u0016J\u0016\u00103\u001a\u00020\u00152\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000205H\u0016J\u0016\u00106\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%2\u0006\u00107\u001a\u00020\u001dJ\b\u00108\u001a\u00020\u0015H\u0016J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020-H\u0002R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000f¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "finderUserName", "", "objectType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cachedState", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$CacheState;", "getCachedState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$CacheState;", "setCachedState", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$CacheState;)V", "draftAddListener", "com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$draftAddListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$draftAddListener$1;", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFinderUserName", "()Ljava/lang/String;", "isLoadingMore", "", "getObjectType", "()I", "state", "getState", "setState", "addDraft", ch.COL_LOCALID, "", "checkEmpty", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "mergeLocalData", "", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "curList", "Ljava/util/LinkedList;", ch.COL_USERNAME, "onAlive", "onDead", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "removeDraft", "notify", "requestLoadMore", "transformDraftInfo", "Lcom/tencent/mm/plugin/finder/model/FinderDraftInfoData;", "draftItem", "CacheState", "DraftFetcher", "DraftResponse", "State", "plugin-finder_release"})
public final class FinderProfileDraftLoader extends BaseFeedLoader<bo> {
    private boolean isLoadingMore;
    final int objectType = 2;
    final String sBN;
    public kotlin.g.a.a<x> tTS;
    public a tWG = a.INIT;
    public volatile a tWH = a.INIT;
    private final e tWI = new e(this);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$CacheState;", "", "(Ljava/lang/String;I)V", TMAssistantDownloadSDKClientBase.CONNTECTSTATE_INIT, "NO_CACHE", "WITH_CACHED", "plugin-finder_release"})
    public enum a {
        INIT,
        NO_CACHE,
        WITH_CACHED;

        static {
            AppMethodBeat.i(244760);
            AppMethodBeat.o(244760);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(244762);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(244762);
            return aVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "removeIt", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "invoke"})
    public static final class f extends q implements kotlin.g.a.b<g, Boolean> {
        final /* synthetic */ LinkedList tWR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(LinkedList linkedList) {
            super(1);
            this.tWR = linkedList;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(g gVar) {
            Object obj;
            boolean z;
            boolean z2;
            AppMethodBeat.i(244772);
            g gVar2 = gVar;
            p.h(gVar2, "removeIt");
            Iterator it = this.tWR.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (gVar2.field_localId == gVar2.field_localId) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            if (((g) obj) != null) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(244772);
            return valueOf;
        }
    }

    public FinderProfileDraftLoader(String str, bbn bbn) {
        super(bbn);
        AppMethodBeat.i(244780);
        this.sBN = str;
        AppMethodBeat.o(244780);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$draftAddListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderDraftOpEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class e extends IListener<hu> {
        final /* synthetic */ FinderProfileDraftLoader tWN;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(FinderProfileDraftLoader finderProfileDraftLoader) {
            this.tWN = finderProfileDraftLoader;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hu huVar) {
            AppMethodBeat.i(244771);
            com.tencent.mm.ac.d.a(0, new a(this, huVar));
            AppMethodBeat.o(244771);
            return false;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ e tWP;
            final /* synthetic */ hu tWQ;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(e eVar, hu huVar) {
                super(0);
                this.tWP = eVar;
                this.tWQ = huVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                g gVar;
                AppMethodBeat.i(244770);
                hu huVar = this.tWQ;
                if (huVar != null) {
                    int i2 = huVar.dMq.dJY;
                    h hVar = h.vDp;
                    if (i2 == h.dxo()) {
                        long j2 = huVar.dMq.localId;
                        Log.i(this.tWP.tWN.getTAG(), "add localId: ".concat(String.valueOf(j2)));
                        FinderProfileDraftLoader finderProfileDraftLoader = this.tWP.tWN;
                        com.tencent.mm.plugin.finder.storage.logic.b draftStorage = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getDraftStorage();
                        Cursor rawQuery = draftStorage.db.rawQuery("SELECT * FROM FinderDraftItem  WHERE " + draftStorage.TABLE + ".localId=" + j2, null, 2);
                        if (rawQuery.moveToFirst()) {
                            gVar = new g();
                            gVar.convertFrom(rawQuery);
                        } else {
                            gVar = null;
                        }
                        rawQuery.close();
                        if (gVar != null) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(new com.tencent.mm.plugin.finder.model.q(gVar));
                            com.tencent.mm.plugin.finder.feed.model.internal.b.mergeDataAndNotify$default(finderProfileDraftLoader.getMerger(), 8, arrayList, true, null, 8, null);
                        }
                    } else {
                        int i3 = huVar.dMq.dJY;
                        h hVar2 = h.vDp;
                        if (i3 == h.dxp()) {
                            long j3 = huVar.dMq.localId;
                            Log.i(this.tWP.tWN.getTAG(), "del localId: ".concat(String.valueOf(j3)));
                            this.tWP.tWN.EF(j3);
                        }
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(244770);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final void onAlive() {
        AppMethodBeat.i(244773);
        super.onAlive();
        this.tWI.alive();
        AppMethodBeat.o(244773);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final void onDead() {
        AppMethodBeat.i(244774);
        super.onDead();
        this.tWI.dead();
        AppMethodBeat.o(244774);
    }

    public final int EF(long j2) {
        AppMethodBeat.i(244775);
        Iterator it = getDataList().iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            if (((bo) it.next()).lT() == j2) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            p.g(getDataList().remove(i2), "dataList.removeAt(index)");
            dispatcher().onChanged();
            if (getDataList().size() == 0) {
                this.tWH = a.NO_CACHE;
                kotlin.g.a.a<x> aVar = this.tTS;
                if (aVar != null) {
                    aVar.invoke();
                }
            }
        }
        AppMethodBeat.o(244775);
        return i2;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.g<bo> createDataFetch() {
        AppMethodBeat.i(244776);
        b bVar = new b();
        AppMethodBeat.o(244776);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u001a\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
    public static final class d extends BaseFeedLoader<bo>.a {
        final /* synthetic */ FinderProfileDraftLoader tWN;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderProfileDraftLoader finderProfileDraftLoader) {
            super();
            this.tWN = finderProfileDraftLoader;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void mergeRefresh(IResponse<bo> iResponse, kotlin.g.a.b<? super IResponse<bo>, x> bVar) {
            AppMethodBeat.i(244769);
            p.h(iResponse, "response");
            RefreshLoadMoreLayout.c.a aVar = RefreshLoadMoreLayout.c.Rms;
            com.tencent.mm.ac.d.h(new a(this, new n(7, iResponse.getIncrementList(), false, 12), new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.Rmm), bVar, iResponse));
            AppMethodBeat.o(244769);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ n $op;
            final /* synthetic */ RefreshLoadMoreLayout.c $reason;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ d tWO;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, n nVar, RefreshLoadMoreLayout.c cVar, kotlin.g.a.b bVar, IResponse iResponse) {
                super(0);
                this.tWO = dVar;
                this.$op = nVar;
                this.$reason = cVar;
                this.$next = bVar;
                this.$response = iResponse;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(244768);
                this.tWO.convertOpToReason(this.$op, this.$reason);
                this.tWO.tWN.dispatcher().onPreFinishRefresh(this.$reason);
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(244768);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger() {
        AppMethodBeat.i(244777);
        d dVar = new d(this);
        AppMethodBeat.o(244777);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        kotlin.g.a.a<x> aVar;
        AppMethodBeat.i(244778);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(iResponse);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, bVar.axR());
        p.h(iResponse, "response");
        if (2 == iResponse.getPullType()) {
            this.isLoadingMore = false;
        }
        super.onFetchDone(iResponse);
        List<bo> incrementList = iResponse.getIncrementList();
        this.tWH = (incrementList != null ? incrementList.size() : 0) > 0 ? a.WITH_CACHED : a.NO_CACHE;
        Log.i(getTAG(), "onFetchDone cachedState :" + this.tWH);
        if (!iResponse.getHasMore() && (aVar = this.tTS) != null) {
            aVar.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
        AppMethodBeat.o(244778);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final void requestLoadMore() {
        AppMethodBeat.i(244779);
        if (this.isLoadingMore) {
            Log.i(getTAG(), "isLoadingMore return");
            AppMethodBeat.o(244779);
            return;
        }
        this.isLoadingMore = true;
        super.requestLoadMore();
        AppMethodBeat.o(244779);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J2\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0016¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$DraftFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
    public final class b extends com.tencent.mm.plugin.finder.feed.model.internal.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(244763);
            List<Integer> listOf = j.listOf((Object) 5801);
            AppMethodBeat.o(244763);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genRefreshNetScene() {
            AppMethodBeat.i(244764);
            bf bfVar = new bf(FinderProfileDraftLoader.this.sBN, FinderProfileDraftLoader.this.objectType, null, 1, FinderProfileDraftLoader.this.getContextObj());
            AppMethodBeat.o(244764);
            return bfVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genLoadMoreNetScene() {
            AppMethodBeat.i(244765);
            bf bfVar = new bf(FinderProfileDraftLoader.this.sBN, FinderProfileDraftLoader.this.objectType, FinderProfileDraftLoader.this.getLastBuffer(), 2, FinderProfileDraftLoader.this.getContextObj());
            AppMethodBeat.o(244765);
            return bfVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> callInit() {
            AppMethodBeat.i(244766);
            LinkedList linkedList = new LinkedList();
            String str = FinderProfileDraftLoader.this.sBN;
            if (str == null) {
                str = "";
            }
            List<g> g2 = FinderProfileDraftLoader.g(linkedList, str);
            c cVar = new c("");
            cVar.setHasMore(false);
            ArrayList arrayList = new ArrayList();
            for (g gVar : g2) {
                arrayList.add(new com.tencent.mm.plugin.finder.model.q(gVar));
            }
            cVar.setIncrementList(arrayList);
            cVar.setLastBuffer(null);
            cVar.setHasMore(false);
            c cVar2 = cVar;
            AppMethodBeat.o(244766);
            return cVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(244767);
            p.h(qVar, "scene");
            bf bfVar = (bf) qVar;
            if (i2 == 0 && i3 == 0 && bfVar.iUB.aYK() == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetDraftResponse");
                AppMethodBeat.o(244767);
                throw tVar;
            }
            c cVar = new c("");
            cVar.setIncrementList(v.SXr);
            cVar.setLastBuffer(null);
            c cVar2 = cVar;
            AppMethodBeat.o(244767);
            return cVar2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader$DraftResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
    public static final class c extends IResponse<bo> {
        public c(String str) {
            super(0, 0, str);
        }
    }

    public static final /* synthetic */ List g(LinkedList linkedList, String str) {
        boolean z;
        AppMethodBeat.i(244781);
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z || (!p.j(str, z.aUg()))) {
            LinkedList linkedList2 = linkedList;
            AppMethodBeat.o(244781);
            return linkedList2;
        }
        LinkedList linkedList3 = new LinkedList();
        linkedList3.addAll(linkedList);
        h hVar = h.vDp;
        List<g> dxq = h.dxq();
        com.tencent.mm.ac.d.a((ArrayList) dxq, (kotlin.g.a.b) new f(linkedList));
        linkedList3.addAll(0, dxq);
        LinkedList linkedList4 = linkedList3;
        AppMethodBeat.o(244781);
        return linkedList4;
    }
}
