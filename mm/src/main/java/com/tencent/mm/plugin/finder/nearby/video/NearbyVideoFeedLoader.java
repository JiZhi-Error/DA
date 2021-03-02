package com.tencent.mm.plugin.finder.nearby.video;

import android.os.SystemClock;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ab;
import com.tencent.mm.plugin.finder.cgi.al;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
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

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003./0B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0 H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u0014\u0010$\u001a\u00020#2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0&J\u0014\u0010'\u001a\u00020(2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0002J\u0018\u0010+\u001a\u00020#2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u001bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "firstLoad", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFirstLoad", "()I", "setFirstLoad", "(I)V", "value", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher;", "getStreamFetcher", "()Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher;", "colletExtraPageName", "", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getPageName", "onDead", "", "preloadMoreToBuffer", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "printVisibleFeeds", "", "hasVisibleFeeds", "Landroid/util/LongSparseArray;", "requestRefresh", "unreadList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "TimelineDataFetcher", "TimelineRequest", "TimelineResponse", "plugin-finder_release"})
public final class NearbyVideoFeedLoader extends BaseFinderFeedLoader {
    private final e tVT;
    int tXs;
    private final b uTt;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NearbyVideoFeedLoader(e eVar, int i2, bbn bbn) {
        super(bbn);
        p.h(eVar, "scene");
        AppMethodBeat.i(249384);
        this.tVT = eVar;
        this.tXs = i2;
        this.uTt = new b(this.tVT.value, bbn);
        AppMethodBeat.o(249384);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(249379);
        a aVar = new a(this, this.uTt, this.tVT);
        AppMethodBeat.o(249379);
        return aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u001a\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
    public static final class d extends BaseFeedLoader<bo>.a {
        final /* synthetic */ NearbyVideoFeedLoader uTu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(NearbyVideoFeedLoader nearbyVideoFeedLoader) {
            super();
            this.uTu = nearbyVideoFeedLoader;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void mergeRefresh(IResponse<bo> iResponse, kotlin.g.a.b<? super IResponse<bo>, x> bVar) {
            int i2;
            awe liveInfo;
            AppMethodBeat.i(249378);
            p.h(iResponse, "response");
            RefreshLoadMoreLayout.c.a aVar = RefreshLoadMoreLayout.c.Rms;
            RefreshLoadMoreLayout.c cVar = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.Rmm);
            cVar.Rmj = iResponse.getHasMore();
            int size = this.uTu.getDataList().size();
            List<bo> incrementList = iResponse.getIncrementList();
            if (incrementList == null) {
                incrementList = new LinkedList();
            }
            LinkedList linkedList = new LinkedList();
            bo boVar = (bo) j.kt(this.uTu.getDataList());
            if (boVar != null && (boVar instanceof z)) {
                linkedList.add(this.uTu.getDataList().get(0));
            }
            linkedList.addAll(incrementList);
            Iterator it = linkedList.iterator();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = i4;
                    break;
                }
                Object next = it.next();
                int i5 = i3 + 1;
                if (i3 < 0) {
                    j.hxH();
                }
                bo boVar2 = (bo) next;
                Iterator it2 = this.uTu.getDataList().iterator();
                int i6 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        i6 = -1;
                        break;
                    }
                    bo boVar3 = (bo) it2.next();
                    if ((boVar3.a(boVar2) == 0 && (boVar3 instanceof w) && (liveInfo = ((w) boVar3).feedObject.getLiveInfo()) != null && liveInfo.liveStatus == 1) || (i3 == 0 && (boVar2 instanceof z) && (boVar3 instanceof z))) {
                        break;
                    }
                    i6++;
                }
                if (i6 == -1 || i6 != i3) {
                    i2 = i3 - 1;
                } else {
                    i4 = i3;
                    i3 = i5;
                }
            }
            LinkedList linkedList2 = new LinkedList();
            linkedList2.addAll(this.uTu.getDataList());
            this.uTu.getDataList().clear();
            this.uTu.getDataList().addAll(linkedList);
            int size2 = linkedList.size();
            if (size2 <= 0) {
                Log.w(this.uTu.getTAG(), "没有新的数据.");
            } else if (i2 + 1 == size2) {
                int i7 = i2 + 1;
                int i8 = size - size2;
                this.uTu.dispatcher().onItemRangeRemoved(i7, i8);
                if (BuildInfo.DEBUG) {
                    String tag = this.uTu.getTAG();
                    StringBuilder append = new StringBuilder("mergeRefresh() hasMore:").append(iResponse.getHasMore()).append(' ').append("removeIndex:").append(i7).append("  removeSize:").append(i8).append(' ').append("newList:");
                    al alVar = al.tuv;
                    StringBuilder append2 = append.append(al.dP(linkedList)).append(' ').append("oldList:");
                    al alVar2 = al.tuv;
                    Log.i(tag, append2.append(al.dP(linkedList2)).toString());
                }
            } else if (i2 + 1 > size2) {
                Log.w(this.uTu.getTAG(), "数据出错，需要检查.");
            } else {
                int i9 = i2 + 1;
                int i10 = size - i9;
                if (size > 0 && i10 > 0) {
                    this.uTu.dispatcher().onItemRangeRemoved(i9, i10);
                }
                int i11 = i2 + 1;
                int i12 = size2 - i11;
                if (i12 > 0) {
                    this.uTu.dispatcher().onItemRangeInserted(i11, i12);
                }
                if (BuildInfo.DEBUG) {
                    String tag2 = this.uTu.getTAG();
                    StringBuilder append3 = new StringBuilder("mergeRefresh() hasMore:").append(iResponse.getHasMore()).append(' ').append("removeIndex:").append(i9).append("  removeSize:").append(i10).append(' ').append("insertIndex:").append(i11).append("  insertSize:").append(i12).append(' ').append("newList:");
                    al alVar3 = al.tuv;
                    StringBuilder append4 = append3.append(al.dP(linkedList)).append(' ').append("oldList:");
                    al alVar4 = al.tuv;
                    Log.i(tag2, append4.append(al.dP(linkedList2)).toString());
                }
            }
            cVar.Rmk = 0;
            com.tencent.mm.ac.d.h(new a(this, cVar));
            AppMethodBeat.o(249378);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ RefreshLoadMoreLayout.c $reason;
            final /* synthetic */ d uTx;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, RefreshLoadMoreLayout.c cVar) {
                super(0);
                this.uTx = dVar;
                this.$reason = cVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(249377);
                this.uTx.uTu.dispatcher().onPreFinishRefresh(this.$reason);
                x xVar = x.SXb;
                AppMethodBeat.o(249377);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger() {
        AppMethodBeat.i(249380);
        d dVar = new d(this);
        AppMethodBeat.o(249380);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final void onDead() {
        AppMethodBeat.i(249381);
        super.onDead();
        this.uTt.ttK.dead();
        AppMethodBeat.o(249381);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final int getPageName() {
        AppMethodBeat.i(249382);
        y yVar = y.vXH;
        int LL = y.LL(this.tVT.value);
        y yVar2 = y.vXH;
        int LJ = y.LJ(LL);
        AppMethodBeat.o(249382);
        return LJ;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final List<Integer> colletExtraPageName() {
        AppMethodBeat.i(249383);
        ArrayList arrayList = new ArrayList();
        arrayList.add(4);
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(249383);
        return arrayList2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader$TimelineRequest;", "", "pullType", "", "unreadList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(ILjava/util/List;)V", "hasPrefetch", "", "getHasPrefetch", "()Z", "setHasPrefetch", "(Z)V", "isPreloadMore", "setPreloadMore", "minDuration", "", "getMinDuration", "()J", "setMinDuration", "(J)V", "needToRefreshForPrefetch", "getNeedToRefreshForPrefetch", "setNeedToRefreshForPrefetch", "getPullType", "()I", "setPullType", "(I)V", "getUnreadList", "()Ljava/util/List;", "setUnreadList", "(Ljava/util/List;)V", "plugin-finder_release"})
    public static class b {
        int pullType;
        boolean tXB;
        boolean tXC;
        long tXD;
        boolean tXE;
        List<? extends BaseFinderFeed> tsE;

        private b(int i2) {
            this.pullType = i2;
            this.tsE = null;
        }

        public /* synthetic */ b(int i2, byte b2) {
            this(i2);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader$TimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "extraData", "", "(IILjava/lang/String;Ljava/lang/Object;)V", "dataBufferList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataBufferList", "()Ljava/util/ArrayList;", "setDataBufferList", "(Ljava/util/ArrayList;)V", "getExtraData", "()Ljava/lang/Object;", "setExtraData", "(Ljava/lang/Object;)V", "plugin-finder_release"})
    public static final class c extends IResponse<bo> {
        ArrayList<bo> tUG;
        Object tXF;

        private c(int i2, int i3, String str) {
            super(i2, i3, str);
            this.tXF = null;
        }

        public /* synthetic */ c(int i2, int i3, String str, byte b2) {
            this(i2, i3, str);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\u0016\u0010\u0016\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\u0016\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader$TimelineDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "(Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader;Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;)V", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchInit", "fetchLoadMore", "fetchRefresh", "keep", "target", "onFetchDone", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
    public final class a extends g<bo> implements ab.a, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> {
        i tMX;
        private final e tVT;
        final b uTt;
        final /* synthetic */ NearbyVideoFeedLoader uTu;

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.nearby.video.NearbyVideoFeedLoader$a$a  reason: collision with other inner class name */
        public static final class C1246a extends q implements kotlin.g.a.b<h, x> {
            final /* synthetic */ long ipR;
            final /* synthetic */ Object tVH;
            final /* synthetic */ f tVx;
            final /* synthetic */ a uTv;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1246a(a aVar, Object obj, long j2, f fVar) {
                super(1);
                this.uTv = aVar;
                this.tVH = obj;
                this.ipR = j2;
                this.tVx = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(h hVar) {
                AppMethodBeat.i(249368);
                final h hVar2 = hVar;
                p.h(hVar2, "task");
                Log.i(this.uTv.getTAG(), "[call] hasPrefetch=" + ((b) this.tVH).tXB + " needToRefreshForPrefetch=" + ((b) this.tVH).tXC + " pullType=" + ((b) this.tVH).pullType);
                if (((b) this.tVH).tXB && !((b) this.tVH).tXC) {
                    c cVar = new c(0, 0, "", (byte) 0);
                    cVar.setIncrementList(l.a.a(com.tencent.mm.plugin.finder.storage.data.l.vGw, 4));
                    List incrementList = cVar.getIncrementList();
                    if (!(incrementList == null || incrementList.isEmpty())) {
                        cVar.setPullType(0);
                        cVar.setHasMore(true);
                        cVar.setNeedClear(true);
                        long uptimeMillis = ((b) this.tVH).tXD - (SystemClock.uptimeMillis() - this.ipR);
                        if (((b) this.tVH).tXB && uptimeMillis > 0) {
                            SystemClock.sleep(uptimeMillis);
                        }
                        this.tVx.onFetchDone(cVar);
                        hVar2.a(com.tencent.mm.loader.g.j.OK);
                        x xVar = x.SXb;
                        AppMethodBeat.o(249368);
                        return xVar;
                    }
                    Log.w(this.uTv.getTAG(), "[fetch] incrementList is empty.");
                }
                b.a(this.uTv.uTt, new ab.a(this) {
                    /* class com.tencent.mm.plugin.finder.nearby.video.NearbyVideoFeedLoader.a.C1246a.AnonymousClass1 */
                    final /* synthetic */ C1246a uTw;

                    {
                        this.uTw = r1;
                    }

                    @Override // com.tencent.mm.plugin.finder.cgi.ab.a
                    public final void a(com.tencent.mm.plugin.finder.feed.model.b bVar, int i2) {
                        int i3;
                        AppMethodBeat.i(249366);
                        p.h(bVar, "info");
                        boolean z = bVar.tUC != 0;
                        String tag = this.uTw.uTv.getTAG();
                        StringBuilder append = new StringBuilder("[call] onFetchDone... pullType=").append(i2).append(", isPreloadMore=").append(((b) this.uTw.tVH).tXE).append(" hasMore:").append(z).append(' ').append(" list:");
                        al alVar = al.tuv;
                        Log.i(tag, append.append(al.dP(bVar.tUz)).toString());
                        c cVar = new c(bVar.errType, bVar.errCode, bVar.errMsg, (byte) 0);
                        cVar.setIncrementList(bVar.tUz);
                        cVar.setPullType(i2);
                        cVar.setHasMore(z);
                        cVar.setNeedClear(bVar.isNeedClear);
                        cVar.tXF = bVar.tUF;
                        cVar.tUG = bVar.tUG;
                        com.tencent.mm.plugin.finder.nearby.report.c cVar2 = com.tencent.mm.plugin.finder.nearby.report.c.uTk;
                        bbn contextObj = this.uTw.uTv.uTu.getContextObj();
                        if (contextObj != null) {
                            i3 = contextObj.tCE;
                        } else {
                            i3 = -1;
                        }
                        com.tencent.mm.plugin.finder.nearby.report.c.j(i3, bVar.tUz);
                        this.uTw.tVx.onFetchDone(cVar);
                        hVar2.a(com.tencent.mm.loader.g.j.OK);
                        AppMethodBeat.o(249366);
                    }
                }, ((b) this.tVH).pullType, new ab.c(this) {
                    /* class com.tencent.mm.plugin.finder.nearby.video.NearbyVideoFeedLoader.a.C1246a.AnonymousClass2 */
                    final /* synthetic */ C1246a uTw;

                    {
                        this.uTw = r1;
                    }

                    @Override // com.tencent.mm.plugin.finder.cgi.ab.c
                    public final boolean b(dpc dpc) {
                        AppMethodBeat.i(249367);
                        p.h(dpc, "resp");
                        i iVar = this.uTw.uTv.tMX;
                        if (iVar == null || iVar.token != hVar2.token) {
                            hVar2.a(com.tencent.mm.loader.g.j.OK);
                            String tag = this.uTw.uTv.getTAG();
                            StringBuilder sb = new StringBuilder("[isFetchConsume] executorToken=");
                            i iVar2 = this.uTw.uTv.tMX;
                            Log.w(tag, sb.append(iVar2 != null ? Integer.valueOf(iVar2.token) : null).append(" taskToken=").append(hVar2.token).toString());
                            AppMethodBeat.o(249367);
                            return true;
                        }
                        AppMethodBeat.o(249367);
                        return false;
                    }
                }, ((b) this.tVH).tXE, ((b) this.tVH).tsE);
                x xVar2 = x.SXb;
                AppMethodBeat.o(249368);
                return xVar2;
            }
        }

        public a(NearbyVideoFeedLoader nearbyVideoFeedLoader, b bVar, e eVar) {
            p.h(bVar, "streamFetcher");
            p.h(eVar, "scene");
            this.uTu = nearbyVideoFeedLoader;
            AppMethodBeat.i(249376);
            this.uTt = bVar;
            this.tVT = eVar;
            AppMethodBeat.o(249376);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetchRefresh(f<bo> fVar) {
            AppMethodBeat.i(249369);
            p.h(fVar, "callback");
            b bVar = new b(this.uTu.tXs, (byte) 0);
            if (bVar.tXC) {
                bVar.pullType = 4;
            } else {
                bVar.pullType = this.uTu.tXs;
            }
            if (this.uTu.tXs == 0) {
                this.uTu.tXs = 1;
            }
            Log.i(getTAG(), "[requestRefresh] pullType=" + bVar.pullType + "  hasPrefetch=" + bVar.tXB + " needToRefreshForPrefetch=" + bVar.tXC);
            fetch(bVar, fVar);
            AppMethodBeat.o(249369);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetchLoadMore(f<bo> fVar) {
            AppMethodBeat.i(249370);
            p.h(fVar, "callback");
            fetch(new b(2, (byte) 0), fVar);
            AppMethodBeat.o(249370);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetchInit(f<bo> fVar) {
            boolean z;
            AppMethodBeat.i(249371);
            p.h(fVar, "callback");
            LinkedList linkedList = new LinkedList();
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            FinderHomeTabStateVM.a Mq = ((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mq(this.tVT.value);
            if (Mq.wuc.isEmpty()) {
                List<bo> a2 = l.a.a(com.tencent.mm.plugin.finder.storage.data.l.vGw, this.uTu.getPageName());
                for (bo boVar : a2) {
                    if (boVar instanceof BaseFinderFeed) {
                        bbn contextObj = this.uTu.getContextObj();
                        if (contextObj != null) {
                            k kVar = k.vfA;
                            k.e(boVar.lT(), contextObj.tCE, ((BaseFinderFeed) boVar).feedObject.getFeedObject().sessionBuffer);
                        }
                        for (T t : ((BaseFinderFeed) boVar).feedObject.getFoldedFeedList()) {
                            k kVar2 = k.vfA;
                            k.e(t.lT(), 14, t.feedObject.getFeedObject().sessionBuffer);
                        }
                    }
                }
                bbn contextObj2 = this.uTu.getContextObj();
                if (contextObj2 != null) {
                    e.a aVar2 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                    int i2 = contextObj2.tCE;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : a2) {
                        if (((bo) obj) instanceof BaseFinderFeed) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList<bo> arrayList2 = arrayList;
                    ArrayList arrayList3 = new ArrayList(j.a(arrayList2, 10));
                    for (bo boVar2 : arrayList2) {
                        if (boVar2 == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                            AppMethodBeat.o(249371);
                            throw tVar;
                        }
                        arrayList3.add(((BaseFinderFeed) boVar2).feedObject.getFeedObject());
                    }
                    e.a.k(i2, arrayList3);
                }
                linkedList.addAll(a2);
                bbn contextObj3 = this.uTu.getContextObj();
                if (contextObj3 != null) {
                    com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
                    int i3 = contextObj3.tCE;
                    y yVar = y.vXH;
                    ((FinderTabStreamUnreadVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStreamUnreadVM.class)).o(i3, y.a(linkedList, BaseFinderFeed.class));
                }
            } else {
                linkedList.addAll(Mq.wuc);
            }
            com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
            com.tencent.mm.plugin.finder.report.h.an(this.uTt.dLS, !linkedList.isEmpty());
            bo boVar3 = (bo) j.kt(linkedList);
            String tag = getTAG();
            StringBuilder append = new StringBuilder("fetchInit tabType=").append(this.uTt.dLS).append(" callInitData scene=").append(this.tVT).append(", contextObj=").append(this.uTu.getContextObj() == null).append(" list first=").append(boVar3 instanceof BaseFinderFeed ? ((BaseFinderFeed) boVar3).feedObject.getNickName() : "").append(" => ");
            bo boVar4 = (bo) j.kt(linkedList);
            Log.i(tag, append.append(com.tencent.mm.ac.d.zs(boVar4 != null ? boVar4.lT() : 0)).toString());
            c cVar = new c(0, 0, "", (byte) 0);
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : linkedList) {
                bo boVar5 = (bo) obj2;
                if (boVar5 instanceof BaseFinderFeed) {
                    y yVar2 = y.vXH;
                    z = y.r(((BaseFinderFeed) boVar5).feedObject.getFeedObject());
                } else {
                    z = true;
                }
                if (z) {
                    arrayList4.add(obj2);
                }
            }
            cVar.setIncrementList(arrayList4);
            cVar.setPullType(1000);
            fVar.onFetchDone(cVar);
            AppMethodBeat.o(249371);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void alive() {
            AppMethodBeat.i(249372);
            super.alive();
            if (this.tVT == com.tencent.mm.plugin.finder.feed.model.internal.e.FEED_TIMELINE_ALL) {
                this.tMX = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFollowTlSingleExecutor();
                i iVar = this.tMX;
                if (iVar != null) {
                    iVar.clean();
                    AppMethodBeat.o(249372);
                    return;
                }
                AppMethodBeat.o(249372);
                return;
            }
            i iVar2 = new i("SingleExecutor#TabType=" + this.uTt.dLS);
            iVar2.start();
            this.tMX = iVar2;
            AppMethodBeat.o(249372);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void dead() {
            AppMethodBeat.i(249373);
            super.dead();
            i iVar = this.tMX;
            if (iVar != null) {
                iVar.reset();
            }
            this.tMX = null;
            AppMethodBeat.o(249373);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetch(Object obj, f<bo> fVar) {
            AppMethodBeat.i(249374);
            p.h(fVar, "callback");
            if (obj instanceof b) {
                long uptimeMillis = SystemClock.uptimeMillis();
                i iVar = this.tMX;
                if (iVar != null) {
                    iVar.a(new h(new C1246a(this, obj, uptimeMillis, fVar)));
                    AppMethodBeat.o(249374);
                    return;
                }
            }
            AppMethodBeat.o(249374);
        }

        @Override // com.tencent.mm.vending.e.b
        public final void keep(com.tencent.mm.vending.e.a aVar) {
        }

        @Override // com.tencent.mm.plugin.finder.cgi.ab.a
        public final void a(com.tencent.mm.plugin.finder.feed.model.b bVar, int i2) {
            AppMethodBeat.i(249375);
            p.h(bVar, "info");
            AppMethodBeat.o(249375);
        }
    }
}
