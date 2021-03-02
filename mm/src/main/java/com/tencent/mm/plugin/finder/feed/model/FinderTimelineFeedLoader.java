package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.LongSparseArray;
import android.view.View;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ab;
import com.tencent.mm.plugin.finder.cgi.ah;
import com.tencent.mm.plugin.finder.cgi.fetcher.c;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.h;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004DEFGB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010)\u001a\u00020\u0005J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050+H\u0016J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0-H\u0016J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0/H\u0016J\b\u00100\u001a\u00020\u0005H\u0016J\b\u00101\u001a\u00020\u0017H\u0016J\b\u00102\u001a\u00020\rH\u0016J\u0016\u00103\u001a\u00020\r2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0016\u00105\u001a\u00020\r2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0014J\u0010\u00106\u001a\u00020\r2\u0006\u00107\u001a\u000208H\u0016J\u0018\u00106\u001a\u00020\r2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0017H\u0016J\u0014\u0010:\u001a\u00020\r2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\f0<J\u0014\u0010=\u001a\u00020>2\n\u0010?\u001a\u0006\u0012\u0002\b\u00030@H\u0002J\u0018\u0010A\u001a\u00020\r2\u0010\b\u0002\u0010B\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010+R.\u0010\t\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006H"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "firstLoad", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "extraDataOp", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getExtraDataOp", "()Lkotlin/jvm/functions/Function1;", "setExtraDataOp", "(Lkotlin/jvm/functions/Function1;)V", "getFirstLoad", "()I", "setFirstLoad", "(I)V", "postFeedFlag", "", "getPostFeedFlag", "()Z", "setPostFeedFlag", "(Z)V", "value", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "getStreamFetcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "bufferSize", "colletExtraPageName", "", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getPageName", "isObservePostEvent", "onDead", "onFetchDone", "response", "onFetchInsertedDone", "onPostStart", ch.COL_LOCALID, "", "isFromSns", "preloadMoreToBuffer", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "printVisibleFeeds", "", "hasVisibleFeeds", "Landroid/util/LongSparseArray;", "requestRefresh", "unreadList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "TimelineDataFetcher", "TimelineInsertRequest", "TimelineRequest", "TimelineResponse", "plugin-finder_release"})
public final class FinderTimelineFeedLoader extends BaseFinderFeedLoader {
    public RecyclerView hak;
    private final com.tencent.mm.plugin.finder.feed.model.internal.e tVT;
    final com.tencent.mm.plugin.finder.cgi.fetcher.c tXp;
    public boolean tXq;
    public kotlin.g.a.b<? super IResponse<bo>, x> tXr;
    public int tXs;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<x> {
        public static final f tXH = new f();

        static {
            AppMethodBeat.i(244893);
            AppMethodBeat.o(244893);
        }

        f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderTimelineFeedLoader(com.tencent.mm.plugin.finder.feed.model.internal.e eVar, int i2, bbn bbn) {
        super(bbn);
        p.h(eVar, "scene");
        AppMethodBeat.i(244907);
        this.tVT = eVar;
        this.tXs = i2;
        this.tXp = new com.tencent.mm.plugin.finder.cgi.fetcher.c(this.tVT.value, bbn);
        AppMethodBeat.o(244907);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$recyclerView$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-finder_release"})
    public static final class g implements View.OnAttachStateChangeListener {
        final /* synthetic */ RecyclerView tXI;

        public g(RecyclerView recyclerView) {
            this.tXI = recyclerView;
        }

        public final void onViewDetachedFromWindow(View view) {
            LongSparseArray<k> longSparseArray = null;
            AppMethodBeat.i(244894);
            p.h(view, "v");
            h hVar = h.vGk;
            RecyclerView.a adapter = this.tXI.getAdapter();
            if (!(adapter instanceof WxRecyclerAdapter)) {
                adapter = null;
            }
            WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
            if (wxRecyclerAdapter != null) {
                longSparseArray = wxRecyclerAdapter.Rrx;
            }
            h.b(longSparseArray);
            AppMethodBeat.o(244894);
        }

        public final void onViewAttachedToWindow(View view) {
            LongSparseArray<k> longSparseArray = null;
            AppMethodBeat.i(244895);
            p.h(view, "v");
            h hVar = h.vGk;
            RecyclerView.a adapter = this.tXI.getAdapter();
            if (!(adapter instanceof WxRecyclerAdapter)) {
                adapter = null;
            }
            WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
            if (wxRecyclerAdapter != null) {
                longSparseArray = wxRecyclerAdapter.Rrx;
            }
            h.c(longSparseArray);
            AppMethodBeat.o(244895);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.g<bo> createDataFetch() {
        AppMethodBeat.i(244896);
        a aVar = new a(this, this.tXp, this.tVT);
        AppMethodBeat.o(244896);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        AppMethodBeat.i(244897);
        p.h(iResponse, "response");
        super.onFetchDone(iResponse);
        com.tencent.mm.ac.d.h(f.tXH);
        AppMethodBeat.o(244897);
    }

    public final void dX(List<? extends BaseFinderFeed> list) {
        AppMethodBeat.i(244898);
        c cVar = new c(this.tXs, list);
        if (cVar.tXC) {
            cVar.pullType = 4;
        } else {
            cVar.pullType = this.tXs;
        }
        Log.i(getTAG(), "[requestRefresh] pullType=" + cVar.pullType + "  hasPrefetch=" + cVar.tXB + " needToRefreshForPrefetch=" + cVar.tXC);
        super.request(cVar, this);
        if (this.tXs == 0) {
            this.tXs = 1;
        }
        AppMethodBeat.o(244898);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000i\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0016JH\u0010\n\u001a\u00020\u00052\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00020\u0003`\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J@\u0010\u0015\u001a\u00020\u00112\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00020\u0003`\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J2\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J2\u0010\u001b\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\u001a\u0010\u001e\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001d\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001fH\u0016J2\u0010 \u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\u001a\u0010\u001e\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001d\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001fH\u0016J2\u0010!\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\u001a\u0010\u001e\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001d\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001fH\u0016J\u0016\u0010\"\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0016J\u0018\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0011H\u0016J\u0018\u0010*\u001a\u00020\u00052\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"com/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isDebug", "", "cleanDataList", "", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "finallyHandleMergeList", "srcList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "newList", "Ljava/util/LinkedList;", "insertIndex", "", "cmd", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "", "findMergeIndex", "", "mergeDataAndNotify", "Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeResult;", "insList", "isNeedClear", "mergeInsert", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeLoadMore", "mergeRefresh", "needCleanWhenRefresh", "notifyLiveListChange", "liveStatus", ch.COL_USERNAME, "", "onDataReplace", "feed", "existIndex", "updateLiveList", "plugin-finder_release"})
    public static final class e extends BaseFeedLoader<bo>.a {
        private final boolean cWq;
        final /* synthetic */ FinderTimelineFeedLoader tXt;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderTimelineFeedLoader finderTimelineFeedLoader) {
            super();
            this.tXt = finderTimelineFeedLoader;
            AppMethodBeat.i(244892);
            this.cWq = BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED || CrashReportFactory.hasDebuger();
            AppMethodBeat.o(244892);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x00a5  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00b8  */
        @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean onDataReplace(com.tencent.mm.plugin.finder.feed.model.internal.i r9, int r10) {
            /*
            // Method dump skipped, instructions count: 200
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader.e.onDataReplace(com.tencent.mm.plugin.finder.feed.model.internal.i, int):boolean");
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void mergeRefresh(IResponse<bo> iResponse, kotlin.g.a.b<? super IResponse<bo>, x> bVar) {
            boolean z;
            AppMethodBeat.i(244881);
            p.h(iResponse, "response");
            RefreshLoadMoreLayout.c cVar = new RefreshLoadMoreLayout.c(iResponse.getPullType());
            if (iResponse.getErrType() == 0 && iResponse.getErrCode() == 0) {
                cVar.Rmh = 1;
            } else {
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                cVar.Rmi = context.getResources().getString(R.string.da_);
                cVar.Rmh = -1;
            }
            kotlin.g.a.b<? super IResponse<bo>, x> bVar2 = this.tXt.tXr;
            if (bVar2 != null) {
                bVar2.invoke(iResponse);
            }
            if (iResponse.getPullType() != 0) {
                z = true;
            } else {
                z = false;
            }
            cVar.jLE = z;
            cVar.Rmj = iResponse.getHasMore();
            if (cVar.actionType == 0 || cVar.actionType == 4 || cVar.actionType == 1) {
                if (cVar.Rmk > 0 || this.tXt.getDataListJustForAdapter().size() <= 0) {
                    cVar.Rmi = null;
                } else {
                    Context context2 = MMApplicationContext.getContext();
                    p.g(context2, "MMApplicationContext.getContext()");
                    cVar.Rmi = context2.getResources().getString(R.string.daa);
                }
            }
            Log.i(this.tXt.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(cVar)));
            com.tencent.mm.ac.d.h(new b(this, new n(iResponse.getHasMore() ? 4 : 6, iResponse.getIncrementList(), iResponse.isNeedClear(), 8), cVar, bVar, iResponse));
            AppMethodBeat.o(244881);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void mergeLoadMore(IResponse<bo> iResponse, kotlin.g.a.b<? super IResponse<bo>, x> bVar) {
            boolean z;
            int i2 = 1;
            AppMethodBeat.i(244882);
            p.h(iResponse, "response");
            if (iResponse instanceof d) {
                this.tXt.getDataListJustForAdapter().setBuffer(((d) iResponse).tUG);
            }
            RefreshLoadMoreLayout.c cVar = new RefreshLoadMoreLayout.c(iResponse.getPullType());
            cVar.Rmj = iResponse.getHasMore();
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            cVar.Rmi = context.getResources().getString(R.string.da2);
            cVar.Rmh = 2;
            if (!iResponse.getHasMore()) {
                z = true;
            } else {
                z = false;
            }
            cVar.jLE = z;
            Log.i(this.tXt.getTAG(), "[onFetchLoadMoreDone]  reason=".concat(String.valueOf(cVar)));
            if (!iResponse.getHasMore()) {
                i2 = 5;
            }
            com.tencent.mm.ac.d.h(new a(this, new n(i2, iResponse.getIncrementList(), false, 12), cVar, bVar, iResponse));
            AppMethodBeat.o(244882);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void cleanDataList(DataBuffer<bo> dataBuffer) {
            AppMethodBeat.i(244883);
            p.h(dataBuffer, "dataList");
            super.cleanDataList(dataBuffer);
            AppMethodBeat.o(244883);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void mergeInsert(IResponse<bo> iResponse, kotlin.g.a.b<? super IResponse<bo>, x> bVar) {
            AppMethodBeat.i(244884);
            p.h(iResponse, "response");
            Object request = iResponse.getRequest();
            if (request instanceof b) {
                if (!((b) request).tXA) {
                    super.mergeInsert(iResponse, bVar);
                }
                Log.i(this.tXt.getTAG(), "[onFetchInsertedDone] isPrefetch=" + ((b) request).tXA);
            }
            AppMethodBeat.o(244884);
        }

        private static void aY(int i2, String str) {
            AppMethodBeat.i(244885);
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                hn hnVar = new hn();
                hnVar.dLW.dLY = 0;
                hnVar.dLW.liveStatus = i2;
                hnVar.dLW.username = str;
                hnVar.dLW.type = 9;
                EventCenter.instance.publish(hnVar);
            }
            AppMethodBeat.o(244885);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:68:0x0159, code lost:
            if (r1 == false) goto L_0x015b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final boolean dY(java.util.List<? extends com.tencent.mm.plugin.finder.model.bo> r10) {
            /*
            // Method dump skipped, instructions count: 473
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader.e.dY(java.util.List):boolean");
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final com.tencent.mm.plugin.finder.feed.model.internal.k mergeDataAndNotify(int i2, List<? extends bo> list, boolean z, Object obj) {
            BaseFinderFeed baseFinderFeed;
            FinderItem finderItem;
            String str;
            com.tencent.mm.view.recyclerview.h hVar;
            AppMethodBeat.i(244887);
            if (!(obj instanceof b) || this.tXt.hak == null || (baseFinderFeed = ((b) obj).tNO) == null || (finderItem = baseFinderFeed.feedObject) == null || finderItem.isRelatedItem()) {
                boolean dY = !z ? dY(list) : false;
                com.tencent.mm.plugin.finder.feed.model.internal.k mergeDataAndNotify = super.mergeDataAndNotify(i2, list, z, obj);
                if (list != null && !z && i2 == 4) {
                    Log.i(this.tXt.getTAG(), "isNeedClear false, manual merge...");
                    mergeDataAndNotify = merge(list, 1, obj);
                    mergeDataAndNotify.tYD = 0;
                }
                if (this.cWq) {
                    if (obj instanceof b) {
                        String str2 = this.tXt.getTAG() + "#insert";
                        DataBuffer<bo> dataList = this.tXt.getDataList();
                        ArrayList arrayList = new ArrayList(j.a(dataList, 10));
                        for (bo boVar : dataList) {
                            arrayList.add(boVar instanceof BaseFinderFeed ? com.tencent.mm.ac.d.zs(((BaseFinderFeed) boVar).feedObject.getFeedObject().id) : "");
                        }
                        Log.i(str2, String.valueOf(arrayList));
                    } else if (this.tXt.tXp.dLS == 4 && i2 == 1) {
                        String str3 = this.tXt.getTAG() + "#loadMore";
                        DataBuffer<bo> dataList2 = this.tXt.getDataList();
                        ArrayList arrayList2 = new ArrayList(j.a(dataList2, 10));
                        for (bo boVar2 : dataList2) {
                            arrayList2.add(boVar2 instanceof BaseFinderFeed ? com.tencent.mm.ac.d.zs(((BaseFinderFeed) boVar2).feedObject.getFeedObject().id) : "");
                        }
                        Log.i(str3, String.valueOf(arrayList2));
                    } else if (this.tXt.tXp.dLS == 4 && i2 == 4) {
                        String str4 = this.tXt.getTAG() + "#refresh";
                        DataBuffer<bo> dataList3 = this.tXt.getDataList();
                        ArrayList arrayList3 = new ArrayList(j.a(dataList3, 10));
                        for (bo boVar3 : dataList3) {
                            arrayList3.add(boVar3 instanceof BaseFinderFeed ? com.tencent.mm.ac.d.zs(((BaseFinderFeed) boVar3).feedObject.getFeedObject().id) : "");
                        }
                        Log.i(str4, String.valueOf(arrayList3));
                    }
                }
                mergeDataAndNotify.tYG |= dY;
                AppMethodBeat.o(244887);
                return mergeDataAndNotify;
            }
            BaseFinderFeed baseFinderFeed2 = ((b) obj).tNO;
            long lT = baseFinderFeed2 != null ? baseFinderFeed2.lT() : 0;
            RecyclerView recyclerView = this.tXt.hak;
            RecyclerView.a adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (!(adapter instanceof WxRecyclerAdapter)) {
                adapter = null;
            }
            WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
            int lR = (wxRecyclerAdapter == null || (hVar = (com.tencent.mm.view.recyclerview.h) wxRecyclerAdapter.V(lT, false)) == null) ? -1 : hVar.lR();
            RecyclerView recyclerView2 = this.tXt.hak;
            RecyclerView.LayoutManager layoutManager = recyclerView2 != null ? recyclerView2.getLayoutManager() : null;
            if (layoutManager == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(244887);
                throw tVar;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int ks = linearLayoutManager.ks();
            int ku = linearLayoutManager.ku();
            boolean z2 = lR >= 0 && ks <= lR && lR <= ku;
            Log.i(this.tXt.getTAG(), "[mergeDataAndNotify] tabType=" + this.tXt.tXp.dLS + " position=" + lR + " first=" + ks + " last=" + ku + " isConsume=" + z2);
            if (z2) {
                com.tencent.mm.plugin.finder.feed.model.internal.k mergeDataAndNotify2 = super.mergeDataAndNotify(i2, list, z, obj);
                if (this.cWq) {
                    String str5 = this.tXt.getTAG() + "#insert";
                    DataBuffer<bo> dataList4 = this.tXt.getDataList();
                    ArrayList arrayList4 = new ArrayList(j.a(dataList4, 10));
                    for (bo boVar4 : dataList4) {
                        if (boVar4 instanceof BaseFinderFeed) {
                            str = com.tencent.mm.ac.d.zs(((BaseFinderFeed) boVar4).feedObject.getFeedObject().id);
                        } else {
                            str = "";
                        }
                        arrayList4.add(str);
                    }
                    Log.i(str5, String.valueOf(arrayList4));
                }
                AppMethodBeat.o(244887);
                return mergeDataAndNotify2;
            }
            if (list != null) {
                h hVar2 = h.vGk;
                h.FM(lT);
                y yVar = y.vXH;
                int i3 = this.tXt.tXp.dLS;
                y yVar2 = y.vXH;
                y.a(i3, y.a(list, BaseFinderFeed.class), this.tXt.getContextObj());
            }
            com.tencent.mm.plugin.finder.feed.model.internal.k kVar = new com.tencent.mm.plugin.finder.feed.model.internal.k(new LinkedList());
            AppMethodBeat.o(244887);
            return kVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:127:0x0050 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:129:0x00bc A[EDGE_INSN: B:129:0x00bc->B:42:0x00bc ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x0141 A[LOOP:0: B:5:0x0022->B:60:0x0141, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x015e A[LOOP:1: B:34:0x009f->B:68:0x015e, LOOP_END] */
        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int findMergeIndex(java.util.ArrayList<com.tencent.mm.plugin.finder.model.bo> r11, java.util.List<? extends com.tencent.mm.plugin.finder.model.bo> r12, int r13, java.lang.Object r14) {
            /*
            // Method dump skipped, instructions count: 733
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader.e.findMergeIndex(java.util.ArrayList, java.util.List, int, java.lang.Object):int");
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b
        public final boolean finallyHandleMergeList(ArrayList<bo> arrayList, LinkedList<bo> linkedList, int i2, int i3, Object obj) {
            RecyclerView.a aVar;
            LongSparseArray<k> longSparseArray;
            long j2;
            boolean z;
            FinderItem finderItem;
            int i4;
            LongSparseArray<k> longSparseArray2;
            long j3;
            FinderItem finderItem2;
            AppMethodBeat.i(244890);
            p.h(arrayList, "srcList");
            p.h(linkedList, "newList");
            if (i3 == 8 && (obj instanceof b)) {
                if (i2 > 0 || ((b) obj).tXz) {
                    RecyclerView recyclerView = this.tXt.hak;
                    if (recyclerView != null) {
                        aVar = recyclerView.getAdapter();
                    } else {
                        aVar = null;
                    }
                    if (!(aVar instanceof WxRecyclerAdapter)) {
                        aVar = null;
                    }
                    WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) aVar;
                    if (wxRecyclerAdapter == null || (longSparseArray2 = wxRecyclerAdapter.Rrx) == null) {
                        longSparseArray = new LongSparseArray<>();
                    } else {
                        longSparseArray = longSparseArray2;
                    }
                    LinkedList linkedList2 = new LinkedList(arrayList.subList(0, Math.min(i2, arrayList.size())));
                    LinkedList linkedList3 = i2 < arrayList.size() ? new LinkedList(arrayList.subList(i2, arrayList.size())) : new LinkedList();
                    int i5 = -1;
                    int i6 = 0;
                    for (Object obj2 : linkedList2) {
                        int i7 = i6 + 1;
                        if (i6 < 0) {
                            j.hxH();
                        }
                        if (longSparseArray.indexOfKey(((bo) obj2).lT()) >= 0) {
                            i4 = i6;
                        } else {
                            i4 = i5;
                        }
                        i6 = i7;
                        i5 = i4;
                    }
                    int size = i5 >= 0 ? (linkedList2.size() - i5) - 1 : 0;
                    int i8 = ((b) obj).tXx - size;
                    LinkedList linkedList4 = new LinkedList();
                    LinkedList linkedList5 = new LinkedList();
                    linkedList5.addAll(linkedList);
                    linkedList5.addAll(linkedList3);
                    linkedList4.addAll(linkedList5);
                    Iterator it = linkedList4.iterator();
                    p.g(it, "increment.iterator()");
                    int i9 = 0;
                    while (it.hasNext()) {
                        Object next = it.next();
                        p.g(next, "iterator.next()");
                        bo boVar = (bo) next;
                        if ((boVar instanceof BaseFinderFeed) && longSparseArray.indexOfKey(((BaseFinderFeed) boVar).feedObject.getId()) < 0) {
                            if (i9 >= i8) {
                                it.remove();
                            } else {
                                i9++;
                            }
                        }
                        i9 = i9;
                    }
                    List subList = linkedList5.subList(linkedList4.size(), linkedList5.size());
                    p.g(subList, "after.subList(increment.size, after.size)");
                    String tag = this.tXt.getTAG();
                    StringBuilder sb = new StringBuilder("[finallyHandleMergeList] feed=");
                    BaseFinderFeed baseFinderFeed = ((b) obj).tNO;
                    if (baseFinderFeed == null || (finderItem = baseFinderFeed.feedObject) == null) {
                        j2 = 0;
                    } else {
                        j2 = finderItem.getId();
                    }
                    Log.i(tag, sb.append(com.tencent.mm.ac.d.zs(j2)).append(' ').append("rawBefore=").append(linkedList2.size()).append(" raw=").append(arrayList.size()).append(" readIndex=").append(i5).append(" unreadCount=").append(size).append(" maxUnreadCount=").append(((b) obj).tXx).append(" limitUnreadCount=").append(i8).append(' ').append("afterSize=").append(linkedList5.size()).append(" incrementCount=").append(linkedList4.size()).append(" remain=").append(subList.size()).append(' ').append("hasVisibleFeeds=").append(FinderTimelineFeedLoader.a(longSparseArray)).toString());
                    arrayList.clear();
                    arrayList.addAll(linkedList2);
                    linkedList.clear();
                    linkedList.addAll(linkedList4);
                    y yVar = y.vXH;
                    int i10 = this.tXt.tXp.dLS;
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj3 : subList) {
                        bo boVar2 = (bo) obj3;
                        if (!(boVar2 instanceof BaseFinderFeed) || longSparseArray.indexOfKey(boVar2.lT()) >= 0) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            arrayList2.add(obj3);
                        }
                    }
                    y.a(i10, arrayList2, this.tXt.getContextObj());
                } else {
                    h hVar = h.vGk;
                    BaseFinderFeed baseFinderFeed2 = ((b) obj).tNO;
                    if (baseFinderFeed2 == null || (finderItem2 = baseFinderFeed2.feedObject) == null) {
                        j3 = 0;
                    } else {
                        j3 = finderItem2.getId();
                    }
                    h.FM(j3);
                    y yVar2 = y.vXH;
                    int i11 = this.tXt.tXp.dLS;
                    y yVar3 = y.vXH;
                    y.a(i11, y.a(linkedList, BaseFinderFeed.class), this.tXt.getContextObj());
                    linkedList.clear();
                    AppMethodBeat.o(244890);
                    return false;
                }
            }
            AppMethodBeat.o(244890);
            return true;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b
        public final boolean needCleanWhenRefresh(List<? extends bo> list) {
            AppMethodBeat.i(244891);
            p.h(list, "newList");
            AppMethodBeat.o(244891);
            return true;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ n $op;
            final /* synthetic */ RefreshLoadMoreLayout.c $reason;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ e tXG;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(e eVar, n nVar, RefreshLoadMoreLayout.c cVar, kotlin.g.a.b bVar, IResponse iResponse) {
                super(0);
                this.tXG = eVar;
                this.$op = nVar;
                this.$reason = cVar;
                this.$next = bVar;
                this.$response = iResponse;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(244880);
                this.tXG.convertOpToReason(this.$op, this.$reason);
                this.tXG.tXt.dispatcher().onPreFinishRefresh(this.$reason);
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(244880);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ n $op;
            final /* synthetic */ RefreshLoadMoreLayout.c $reason;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ e tXG;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(e eVar, n nVar, RefreshLoadMoreLayout.c cVar, kotlin.g.a.b bVar, IResponse iResponse) {
                super(0);
                this.tXG = eVar;
                this.$op = nVar;
                this.$reason = cVar;
                this.$next = bVar;
                this.$response = iResponse;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(244879);
                this.tXG.convertOpToReason(this.$op, this.$reason);
                this.tXG.tXt.dispatcher().f(this.$reason);
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(244879);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger() {
        AppMethodBeat.i(244899);
        e eVar = new e(this);
        AppMethodBeat.o(244899);
        return eVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final boolean isObservePostEvent() {
        AppMethodBeat.i(244900);
        if (this.tVT != com.tencent.mm.plugin.finder.feed.model.internal.e.FEED_TIMELINE_FOLLOW) {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dsx().value().intValue() == 1) {
                AppMethodBeat.o(244900);
                return false;
            }
        }
        AppMethodBeat.o(244900);
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final void onPostStart(long j2, boolean z) {
        AppMethodBeat.i(244901);
        super.onPostStart(j2, z);
        this.tXq = true;
        AppMethodBeat.o(244901);
    }

    @Override // com.tencent.mm.plugin.finder.upload.q, com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final void onPostStart(long j2) {
        AppMethodBeat.i(244902);
        super.onPostStart(j2);
        this.tXq = true;
        Log.i(getTAG(), "onPostStart postFeedFlag true");
        AppMethodBeat.o(244902);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final void onFetchInsertedDone(IResponse<bo> iResponse) {
        AppMethodBeat.i(244903);
        p.h(iResponse, "response");
        Object request = iResponse.getRequest();
        if (request instanceof b) {
            if (!((b) request).tXA) {
                super.onFetchInsertedDone(iResponse);
            }
            Log.i(getTAG(), "[onFetchInsertedDone] isPrefetch=" + ((b) request).tXA);
        }
        AppMethodBeat.o(244903);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final void onDead() {
        AppMethodBeat.i(244904);
        super.onDead();
        this.tXp.ttK.dead();
        AppMethodBeat.o(244904);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final int getPageName() {
        AppMethodBeat.i(244905);
        y yVar = y.vXH;
        int LL = y.LL(this.tVT.value);
        y yVar2 = y.vXH;
        int LJ = y.LJ(LL);
        AppMethodBeat.o(244905);
        return LJ;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final List<Integer> colletExtraPageName() {
        AppMethodBeat.i(244906);
        ArrayList arrayList = new ArrayList();
        arrayList.add(4);
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(244906);
        return arrayList2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineRequest;", "", "pullType", "", "unreadList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(ILjava/util/List;)V", "hasPrefetch", "", "getHasPrefetch", "()Z", "setHasPrefetch", "(Z)V", "isPreloadMore", "setPreloadMore", "minDuration", "", "getMinDuration", "()J", "setMinDuration", "(J)V", "needToRefreshForPrefetch", "getNeedToRefreshForPrefetch", "setNeedToRefreshForPrefetch", "getPullType", "()I", "setPullType", "(I)V", "getUnreadList", "()Ljava/util/List;", "setUnreadList", "(Ljava/util/List;)V", "plugin-finder_release"})
    public static class c {
        int pullType;
        boolean tXB;
        boolean tXC;
        long tXD;
        boolean tXE;
        List<? extends BaseFinderFeed> tsE;

        public /* synthetic */ c(int i2) {
            this(i2, null);
        }

        public c(int i2, List<? extends BaseFinderFeed> list) {
            this.pullType = i2;
            this.tsE = list;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001f\u001a\u00020 H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineInsertRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineRequest;", "pullType", "", "(I)V", "centerFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "feed", "getFeed", "setFeed", "isConsume", "", "()Z", "setConsume", "(Z)V", "isPrefetch", "setPrefetch", "maxUnreadCount", "getMaxUnreadCount", "()I", "setMaxUnreadCount", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "getRelatedEntranceInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "setRelatedEntranceInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;)V", "toString", "", "plugin-finder_release"})
    public static final class b extends c {
        public BaseFinderFeed tNO;
        public boolean tXA;
        public int tXx = -1;
        public BaseFinderFeed tXy;
        boolean tXz = true;
        public atn tuo;

        public b() {
            super(-1);
        }

        public final String toString() {
            FinderItem finderItem;
            AppMethodBeat.i(244878);
            StringBuilder sb = new StringBuilder("feed=");
            BaseFinderFeed baseFinderFeed = this.tNO;
            String sb2 = sb.append(com.tencent.mm.ac.d.zs((baseFinderFeed == null || (finderItem = baseFinderFeed.feedObject) == null) ? 0 : finderItem.getId())).append(", keepUnreadSize=").append(this.tXx).toString();
            AppMethodBeat.o(244878);
            return sb2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "extraData", "", "(IILjava/lang/String;Ljava/lang/Object;)V", "dataBufferList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataBufferList", "()Ljava/util/ArrayList;", "setDataBufferList", "(Ljava/util/ArrayList;)V", "getExtraData", "()Ljava/lang/Object;", "setExtraData", "(Ljava/lang/Object;)V", "plugin-finder_release"})
    public static final class d extends IResponse<bo> {
        ArrayList<bo> tUG;
        public Object tXF;

        private d(int i2, int i3, String str) {
            super(i2, i3, str);
            this.tXF = null;
        }

        public /* synthetic */ d(int i2, int i3, String str, byte b2) {
            this(i2, i3, str);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\u0016\u0010\u0016\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\u0016\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;)V", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchInit", "fetchLoadMore", "fetchRefresh", "keep", "p0", "onFetchDone", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
    public final class a extends com.tencent.mm.plugin.finder.feed.model.internal.g<bo> implements ab.a, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> {
        i tMX;
        private final com.tencent.mm.plugin.finder.feed.model.internal.e tVT;
        final com.tencent.mm.plugin.finder.cgi.fetcher.c tXp;
        final /* synthetic */ FinderTimelineFeedLoader tXt;

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader$a$a  reason: collision with other inner class name */
        public static final class C1156a extends q implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x> {
            final /* synthetic */ long ipR;
            final /* synthetic */ Object tVH;
            final /* synthetic */ com.tencent.mm.plugin.finder.feed.model.internal.f tVx;
            final /* synthetic */ a tXu;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1156a(a aVar, Object obj, long j2, com.tencent.mm.plugin.finder.feed.model.internal.f fVar) {
                super(1);
                this.tXu = aVar;
                this.tVH = obj;
                this.ipR = j2;
                this.tVx = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(com.tencent.mm.loader.g.h hVar) {
                byte[] bArr;
                AppMethodBeat.i(244868);
                final com.tencent.mm.loader.g.h hVar2 = hVar;
                p.h(hVar2, "task");
                Log.i(this.tXu.getTAG(), "[call] hasPrefetch=" + ((c) this.tVH).tXB + " needToRefreshForPrefetch=" + ((c) this.tVH).tXC + " pullType=" + ((c) this.tVH).pullType);
                if (((c) this.tVH).tXB && !((c) this.tVH).tXC) {
                    d dVar = new d(0, 0, "", (byte) 0);
                    dVar.setIncrementList(l.a.a(com.tencent.mm.plugin.finder.storage.data.l.vGw, 4));
                    List incrementList = dVar.getIncrementList();
                    if (!(incrementList == null || incrementList.isEmpty())) {
                        dVar.setPullType(0);
                        dVar.setHasMore(true);
                        dVar.setNeedClear(true);
                        long uptimeMillis = ((c) this.tVH).tXD - (SystemClock.uptimeMillis() - this.ipR);
                        if (((c) this.tVH).tXB && uptimeMillis > 0) {
                            SystemClock.sleep(uptimeMillis);
                        }
                        this.tVx.onFetchDone(dVar);
                        hVar2.a(com.tencent.mm.loader.g.j.OK);
                        x xVar = x.SXb;
                        AppMethodBeat.o(244868);
                        return xVar;
                    }
                    Log.w(this.tXu.getTAG(), "[fetch] incrementList is empty.");
                }
                if (this.tVH instanceof b) {
                    BaseFinderFeed baseFinderFeed = ((b) this.tVH).tNO;
                    if (baseFinderFeed != null) {
                        com.tencent.mm.plugin.finder.cgi.fetcher.c cVar = this.tXu.tXp;
                        long id = baseFinderFeed.feedObject.getId();
                        String objectNonceId = baseFinderFeed.feedObject.getObjectNonceId();
                        boolean z = ((b) this.tVH).tXA;
                        atn atn = ((b) this.tVH).tuo;
                        C1157a aVar = new C1157a(this, hVar2);
                        p.h(objectNonceId, "nonceId");
                        p.h(aVar, "callback");
                        Log.i("Finder.TimelineFeedFetcher", "[fetchHotRelatedList] feedId=" + id + " isPrefetch=" + z);
                        if (!z) {
                            h hVar3 = h.vGk;
                            b FO = h.FO(id);
                            if (FO != null) {
                                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                                p.g(aAh, "MMKernel.storage()");
                                ao azQ = aAh.azQ();
                                y yVar = y.vXH;
                                ar.a LK = y.LK(4);
                                com.tencent.mm.bw.b bVar = FO.lastBuffer;
                                if (bVar != null) {
                                    bArr = bVar.toByteArray();
                                } else {
                                    bArr = null;
                                }
                                azQ.set(LK, Util.encodeHexString(bArr));
                                aVar.a(FO, -1);
                                h hVar4 = h.vGk;
                                h.a(cVar.ttO, false, "fetchHotRelatedList#used");
                                Log.i("Finder.TimelineFeedFetcher", "[fetchHotRelatedList] feedId=" + id + " use prefetch cache.");
                            }
                        }
                        new ah(id, objectNonceId, atn, cVar.ttO).aYI().h(new c.C1093c(cVar, z, id, aVar));
                    } else {
                        hVar2.a(com.tencent.mm.loader.g.j.OK);
                    }
                } else {
                    com.tencent.mm.plugin.finder.cgi.fetcher.c.a(this.tXu.tXp, new ab.a(this) {
                        /* class com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader.a.C1156a.AnonymousClass1 */
                        final /* synthetic */ C1156a tXv;

                        {
                            this.tXv = r1;
                        }

                        @Override // com.tencent.mm.plugin.finder.cgi.ab.a
                        public final void a(b bVar, int i2) {
                            AppMethodBeat.i(244866);
                            p.h(bVar, "info");
                            Log.i(this.tXv.tXu.getTAG(), "[call] onFetchDone... pullType=" + i2 + ", isPreloadMore=" + ((c) this.tXv.tVH).tXE);
                            boolean z = bVar.tUC != 0;
                            d dVar = new d(bVar.errType, bVar.errCode, bVar.errMsg, (byte) 0);
                            dVar.setIncrementList(bVar.tUz);
                            dVar.setPullType(i2);
                            dVar.setHasMore(z);
                            dVar.setNeedClear(bVar.isNeedClear);
                            dVar.tXF = bVar.tUF;
                            dVar.tUG = bVar.tUG;
                            this.tXv.tVx.onFetchDone(dVar);
                            hVar2.a(com.tencent.mm.loader.g.j.OK);
                            AppMethodBeat.o(244866);
                        }
                    }, ((c) this.tVH).pullType, new ab.c(this) {
                        /* class com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader.a.C1156a.AnonymousClass2 */
                        final /* synthetic */ C1156a tXv;

                        {
                            this.tXv = r1;
                        }

                        @Override // com.tencent.mm.plugin.finder.cgi.ab.c
                        public final boolean b(dpc dpc) {
                            AppMethodBeat.i(244867);
                            p.h(dpc, "resp");
                            i iVar = this.tXv.tXu.tMX;
                            if (iVar == null || iVar.token != hVar2.token) {
                                hVar2.a(com.tencent.mm.loader.g.j.OK);
                                String tag = this.tXv.tXu.getTAG();
                                StringBuilder sb = new StringBuilder("[isFetchConsume] executorToken=");
                                i iVar2 = this.tXv.tXu.tMX;
                                Log.w(tag, sb.append(iVar2 != null ? Integer.valueOf(iVar2.token) : null).append(" taskToken=").append(hVar2.token).toString());
                                AppMethodBeat.o(244867);
                                return true;
                            }
                            AppMethodBeat.o(244867);
                            return false;
                        }
                    }, null, ((c) this.tVH).tXE, ((c) this.tVH).tsE, 8);
                }
                x xVar2 = x.SXb;
                AppMethodBeat.o(244868);
                return xVar2;
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineDataFetcher$fetch$1$1$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
            /* renamed from: com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader$a$a$a  reason: collision with other inner class name */
            public static final class C1157a implements ab.a {
                final /* synthetic */ C1156a tXv;
                final /* synthetic */ com.tencent.mm.loader.g.h tXw;

                C1157a(C1156a aVar, com.tencent.mm.loader.g.h hVar) {
                    this.tXv = aVar;
                    this.tXw = hVar;
                }

                @Override // com.tencent.mm.plugin.finder.cgi.ab.a
                public final void a(b bVar, int i2) {
                    AppMethodBeat.i(244865);
                    p.h(bVar, "info");
                    d dVar = new d(bVar.errType, bVar.errCode, bVar.errMsg, (byte) 0);
                    dVar.setIncrementList(bVar.tUz);
                    dVar.setPullType(i2);
                    dVar.setHasMore(true);
                    dVar.setRequest(this.tXv.tVH);
                    dVar.tXF = bVar.tUF;
                    this.tXv.tVx.onFetchDone(dVar);
                    this.tXw.a(com.tencent.mm.loader.g.j.OK);
                    AppMethodBeat.o(244865);
                }
            }
        }

        public a(FinderTimelineFeedLoader finderTimelineFeedLoader, com.tencent.mm.plugin.finder.cgi.fetcher.c cVar, com.tencent.mm.plugin.finder.feed.model.internal.e eVar) {
            p.h(cVar, "streamFetcher");
            p.h(eVar, "scene");
            this.tXt = finderTimelineFeedLoader;
            AppMethodBeat.i(244877);
            this.tXp = cVar;
            this.tVT = eVar;
            AppMethodBeat.o(244877);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetchRefresh(com.tencent.mm.plugin.finder.feed.model.internal.f<bo> fVar) {
            AppMethodBeat.i(244869);
            p.h(fVar, "callback");
            c cVar = new c(this.tXt.tXs);
            if (cVar.tXC) {
                cVar.pullType = 4;
            } else {
                cVar.pullType = this.tXt.tXs;
            }
            if (this.tXt.tXs == 0) {
                this.tXt.tXs = 1;
            }
            Log.i(getTAG(), "[requestRefresh] pullType=" + cVar.pullType + "  hasPrefetch=" + cVar.tXB + " needToRefreshForPrefetch=" + cVar.tXC);
            fetch(cVar, fVar);
            AppMethodBeat.o(244869);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.f<bo> fVar) {
            AppMethodBeat.i(244870);
            p.h(fVar, "callback");
            fetch(new c(2), fVar);
            AppMethodBeat.o(244870);
        }

        @Override // com.tencent.mm.vending.e.b
        public final void keep(com.tencent.mm.vending.e.a aVar) {
            AppMethodBeat.i(244871);
            p.h(aVar, "p0");
            AppMethodBeat.o(244871);
        }

        @Override // com.tencent.mm.plugin.finder.cgi.ab.a
        public final void a(b bVar, int i2) {
            AppMethodBeat.i(244872);
            p.h(bVar, "info");
            AppMethodBeat.o(244872);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.f<bo> fVar) {
            boolean z;
            AppMethodBeat.i(244873);
            p.h(fVar, "callback");
            List a2 = y.a(y.vXH, this.tVT.value, this.tXt.getContextObj(), this.tXt.getPageName(), false, this.tXp.dLS, 8);
            com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
            com.tencent.mm.plugin.finder.report.h.an(this.tXp.dLS, !a2.isEmpty());
            bo boVar = (bo) j.kt(a2);
            String tag = getTAG();
            StringBuilder append = new StringBuilder("fetchInit tabType=").append(this.tXp.dLS).append(" callInitData scene=").append(this.tVT).append(", contextObj=").append(this.tXt.getContextObj() == null).append(" list first=").append(boVar instanceof BaseFinderFeed ? ((BaseFinderFeed) boVar).feedObject.getNickName() : "").append(" => ");
            bo boVar2 = (bo) j.kt(a2);
            Log.i(tag, append.append(com.tencent.mm.ac.d.zs(boVar2 != null ? boVar2.lT() : 0)).toString());
            d dVar = new d(0, 0, "", (byte) 0);
            ArrayList arrayList = new ArrayList();
            for (Object obj : a2) {
                bo boVar3 = (bo) obj;
                if (boVar3 instanceof BaseFinderFeed) {
                    y yVar = y.vXH;
                    z = y.r(((BaseFinderFeed) boVar3).feedObject.getFeedObject());
                } else {
                    z = true;
                }
                if (z) {
                    arrayList.add(obj);
                }
            }
            dVar.setIncrementList(arrayList);
            dVar.setPullType(1000);
            fVar.onFetchDone(dVar);
            AppMethodBeat.o(244873);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void alive() {
            AppMethodBeat.i(244874);
            super.alive();
            if (this.tVT == com.tencent.mm.plugin.finder.feed.model.internal.e.FEED_TIMELINE_ALL) {
                this.tMX = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFollowTlSingleExecutor();
                i iVar = this.tMX;
                if (iVar != null) {
                    iVar.clean();
                    AppMethodBeat.o(244874);
                    return;
                }
                AppMethodBeat.o(244874);
                return;
            }
            i iVar2 = new i("SingleExecutor#TabType=" + this.tXp.dLS);
            iVar2.start();
            this.tMX = iVar2;
            AppMethodBeat.o(244874);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void dead() {
            AppMethodBeat.i(244875);
            super.dead();
            i iVar = this.tMX;
            if (iVar != null) {
                iVar.reset();
            }
            this.tMX = null;
            AppMethodBeat.o(244875);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetch(Object obj, com.tencent.mm.plugin.finder.feed.model.internal.f<bo> fVar) {
            AppMethodBeat.i(244876);
            p.h(fVar, "callback");
            if (obj instanceof c) {
                long uptimeMillis = SystemClock.uptimeMillis();
                i iVar = this.tMX;
                if (iVar != null) {
                    iVar.a(new com.tencent.mm.loader.g.h(new C1156a(this, obj, uptimeMillis, fVar)));
                    AppMethodBeat.o(244876);
                    return;
                }
            }
            AppMethodBeat.o(244876);
        }
    }

    public static final /* synthetic */ String a(LongSparseArray longSparseArray) {
        AppMethodBeat.i(244908);
        StringBuilder sb = new StringBuilder();
        int size = longSparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(com.tencent.mm.ac.d.zs(longSparseArray.keyAt(i2)) + ',');
        }
        String sb2 = sb.toString();
        p.g(sb2, "ss.toString()");
        AppMethodBeat.o(244908);
        return sb2;
    }
}
