package com.tencent.mm.plugin.finder.nearby.live;

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
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.plugin.finder.nearby.base.d;
import com.tencent.mm.plugin.finder.nearby.live.c;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.plugin.finder.storage.data.r;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0003&'(B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001eH\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0 H\u0016J\u0016\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J \u0010#\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010$\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010%\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR.\u0010\f\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000b¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "commentScene", "", "firstLoad", "tabType", "localTypeFlag", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;IIII)V", "getCommentScene", "()I", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "fileCacheFlag", "getFirstLoad", "setFirstLoad", "(I)V", "memoryCacheFlag", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getTabType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "requestInit", "requestLoadMore", "requestRefresh", "FinderLiveFriendsRequest", "FinderLiveFriendsResponse", "LbsDataFetcher", "plugin-finder_release"})
public class NearbyLiveFeedLoader extends BaseFinderFeedLoader {
    final int dLS;
    kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
    final int tCE;
    int tXs;
    private axj uQK;
    private int uQL = this.dLS;
    private int uQM;

    public NearbyLiveFeedLoader(bbn bbn, int i2, int i3, int i4, int i5) {
        super(bbn);
        AppMethodBeat.i(249050);
        this.tCE = i2;
        this.tXs = i3;
        this.dLS = i4;
        this.uQM = i5;
        AppMethodBeat.o(249050);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public g<bo> createDataFetch() {
        AppMethodBeat.i(249044);
        c cVar = new c();
        AppMethodBeat.o(249044);
        return cVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u001a\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
    public static final class d extends BaseFeedLoader<bo>.a {
        final /* synthetic */ NearbyLiveFeedLoader uQP;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(NearbyLiveFeedLoader nearbyLiveFeedLoader) {
            super();
            this.uQP = nearbyLiveFeedLoader;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void mergeRefresh(IResponse<bo> iResponse, kotlin.g.a.b<? super IResponse<bo>, x> bVar) {
            int i2;
            awe liveInfo;
            AppMethodBeat.i(249042);
            p.h(iResponse, "response");
            RefreshLoadMoreLayout.c.a aVar = RefreshLoadMoreLayout.c.Rms;
            RefreshLoadMoreLayout.c cVar = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.Rmm);
            cVar.Rmj = iResponse.getHasMore();
            cVar.iMa = (E) ((b) iResponse).uQN;
            int size = this.uQP.getDataList().size();
            List<bo> incrementList = iResponse.getIncrementList();
            if (incrementList == null) {
                incrementList = new LinkedList();
            }
            LinkedList linkedList = new LinkedList();
            bo boVar = (bo) j.kt(this.uQP.getDataList());
            if (boVar != null && (boVar instanceof z)) {
                linkedList.add(this.uQP.getDataList().get(0));
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
                Iterator it2 = this.uQP.getDataList().iterator();
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
            linkedList2.addAll(this.uQP.getDataList());
            this.uQP.getDataList().clear();
            this.uQP.getDataList().addAll(linkedList);
            int size2 = linkedList.size();
            if (size2 <= 0) {
                Log.w(this.uQP.getTAG(), "没有新的数据.");
            } else if (i2 + 1 == size2) {
                int i7 = i2 + 1;
                int i8 = size - size2;
                this.uQP.dispatcher().onItemRangeRemoved(i7, i8);
                String tag = this.uQP.getTAG();
                StringBuilder append = new StringBuilder("mergeRefresh() hasMore:").append(iResponse.getHasMore()).append(' ').append("removeIndex:").append(i7).append("  removeSize:").append(i8).append(' ').append("newList:");
                al alVar = al.tuv;
                StringBuilder append2 = append.append(al.dP(linkedList)).append(' ').append("oldList:");
                al alVar2 = al.tuv;
                Log.i(tag, append2.append(al.dP(linkedList2)).toString());
            } else if (i2 + 1 > size2) {
                Log.w(this.uQP.getTAG(), "数据出错，需要检查.");
            } else {
                int i9 = i2 + 1;
                int i10 = size - i9;
                if (size > 0 && i10 > 0) {
                    this.uQP.dispatcher().onItemRangeRemoved(i9, i10);
                }
                int i11 = i2 + 1;
                int i12 = size2 - i11;
                if (i12 > 0) {
                    this.uQP.dispatcher().onItemRangeInserted(i11, i12);
                }
                String tag2 = this.uQP.getTAG();
                StringBuilder append3 = new StringBuilder("mergeRefresh() hasMore:").append(iResponse.getHasMore()).append(' ').append("removeIndex:").append(i9).append("  removeSize:").append(i10).append(' ').append("insertIndex:").append(i11).append("  insertSize:").append(i12).append(' ').append("newList:");
                al alVar3 = al.tuv;
                StringBuilder append4 = append3.append(al.dP(linkedList)).append(' ').append("oldList:");
                al alVar4 = al.tuv;
                Log.i(tag2, append4.append(al.dP(linkedList2)).toString());
            }
            cVar.Rmk = 0;
            com.tencent.mm.ac.d.h(new a(this, cVar));
            AppMethodBeat.o(249042);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ RefreshLoadMoreLayout.c $reason;
            final /* synthetic */ d uQS;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, RefreshLoadMoreLayout.c cVar) {
                super(0);
                this.uQS = dVar;
                this.$reason = cVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(249041);
                this.uQS.uQP.dispatcher().onPreFinishRefresh(this.$reason);
                x xVar = x.SXb;
                AppMethodBeat.o(249041);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger() {
        AppMethodBeat.i(249045);
        d dVar = new d(this);
        AppMethodBeat.o(249045);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public void onFetchDone(IResponse<bo> iResponse) {
        AppMethodBeat.i(249046);
        p.h(iResponse, "response");
        com.tencent.mm.ac.d.h(new e(this, iResponse));
        super.onFetchDone(iResponse);
        d.a aVar = com.tencent.mm.plugin.finder.nearby.base.d.uQu;
        d.a.JA(this.uQL).uQq = System.currentTimeMillis();
        if (isInitOperation(iResponse)) {
            AppMethodBeat.o(249046);
        } else {
            AppMethodBeat.o(249046);
        }
    }

    public final void a(int i2, int i3, axj axj) {
        AppMethodBeat.i(249047);
        this.uQL = i2;
        this.uQM = i3;
        this.uQK = axj;
        super.requestInit(true);
        AppMethodBeat.o(249047);
    }

    public final void a(axj axj) {
        AppMethodBeat.i(249048);
        d.a aVar = com.tencent.mm.plugin.finder.nearby.base.d.uQu;
        d.a.JA(this.uQL).uQn = System.currentTimeMillis();
        this.uQK = axj;
        super.requestRefresh();
        AppMethodBeat.o(249048);
    }

    public final void b(axj axj) {
        AppMethodBeat.i(249049);
        this.uQK = axj;
        super.requestLoadMore();
        AppMethodBeat.o(249049);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsRequest;", "", "pullType", "", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "(ILcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "getPullType", "()I", "getTabInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "plugin-finder_release"})
    public static final class a {
        final int pullType;
        final axj uQK;

        public a(int i2, axj axj) {
            this.pullType = i2;
            this.uQK = axj;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "jumpLiveTab", "Lcom/tencent/mm/protocal/protobuf/FinderJumpLiveTab;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderJumpLiveTab;)V", "getJumpLiveTab", "()Lcom/tencent/mm/protocal/protobuf/FinderJumpLiveTab;", "setJumpLiveTab", "(Lcom/tencent/mm/protocal/protobuf/FinderJumpLiveTab;)V", "plugin-finder_release"})
    public static final class b extends IResponse<bo> {
        auh uQN;

        private b(int i2, int i3, String str) {
            super(i2, i3, str);
            this.uQN = null;
        }

        public /* synthetic */ b(int i2, int i3, String str, byte b2) {
            this(i2, i3, str);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J \u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016J\u0016\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016J\u0016\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016J\u0016\u0010\u0017\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$LbsDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;)V", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "fetcher", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "", "callback", "fetchInit", "fetchLoadMore", "fetchRefresh", "plugin-finder_release"})
    public final class c extends g<bo> {
        i tMX;
        c uQO;

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
        public static final class a extends q implements kotlin.g.a.b<h, x> {
            final /* synthetic */ Object tVH;
            final /* synthetic */ f tVx;
            final /* synthetic */ c uQQ;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, Object obj, f fVar) {
                super(1);
                this.uQQ = cVar;
                this.tVH = obj;
                this.tVx = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(h hVar) {
                com.tencent.mm.bw.b bVar;
                AppMethodBeat.i(249034);
                final h hVar2 = hVar;
                p.h(hVar2, "task");
                Log.i(this.uQQ.getTAG(), "[call] pullType=" + ((a) this.tVH).pullType);
                c cVar = this.uQQ.uQO;
                if (cVar == null) {
                    p.hyc();
                }
                a aVar = (a) this.tVH;
                AnonymousClass1 r2 = new c.a(this) {
                    /* class com.tencent.mm.plugin.finder.nearby.live.NearbyLiveFeedLoader.c.a.AnonymousClass1 */
                    final /* synthetic */ a uQR;

                    {
                        this.uQR = r1;
                    }

                    @Override // com.tencent.mm.plugin.finder.nearby.live.c.a
                    public final void a(b bVar) {
                        bbn contextObj;
                        boolean z;
                        AppMethodBeat.i(249032);
                        p.h(bVar, "response");
                        String tag = this.uQR.uQQ.getTAG();
                        StringBuilder append = new StringBuilder("[call] onFetchDone... pullType=").append(bVar.getPullType()).append("  hasMore:").append(bVar.getHasMore()).append("list:");
                        al alVar = al.tuv;
                        Log.i(tag, append.append(al.dP(bVar.getIncrementList())).toString());
                        List incrementList = bVar.getIncrementList();
                        if (incrementList != null && ((bo) j.kt(NearbyLiveFeedLoader.this.getDataListJustForAdapter())) == null) {
                            if (!incrementList.isEmpty()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z && NearbyLiveFeedLoader.this.dLS == 1001) {
                                LinkedList linkedList = new LinkedList();
                                linkedList.add(new z(new FinderItem()));
                                linkedList.addAll(incrementList);
                                bVar.setIncrementList(linkedList);
                            }
                            x xVar = x.SXb;
                        }
                        if (bVar.getPullType() != 2) {
                            LinkedList linkedList2 = new LinkedList();
                            List<bo> incrementList2 = bVar.getIncrementList();
                            if (incrementList2 != null) {
                                for (bo boVar : incrementList2) {
                                    if (boVar instanceof w) {
                                        int cxn = boVar.cxn();
                                        long lT = boVar.lT();
                                        FinderObject feedObject = ((w) boVar).feedObject.getFeedObject();
                                        y yVar = y.vXH;
                                        linkedList2.add(new r(cxn, lT, feedObject, y.LL(NearbyLiveFeedLoader.this.uQL)));
                                    } else if (boVar instanceof z) {
                                        int cxn2 = boVar.cxn();
                                        long lT2 = boVar.lT();
                                        FinderObject feedObject2 = ((z) boVar).feedObject.getFeedObject();
                                        y yVar2 = y.vXH;
                                        linkedList2.add(new r(cxn2, lT2, feedObject2, y.LL(NearbyLiveFeedLoader.this.uQL)));
                                    }
                                }
                            }
                            if (linkedList2.size() > 0) {
                                l.a aVar = com.tencent.mm.plugin.finder.storage.data.l.vGw;
                                int i2 = NearbyLiveFeedLoader.this.uQM;
                                String aUg = com.tencent.mm.model.z.aUg();
                                p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                                l.a.a(i2, aUg, linkedList2);
                            }
                            Log.i(this.uQR.uQQ.getTAG(), "cache FinderPage size: " + linkedList2.size());
                        }
                        List<bo> incrementList3 = bVar.getIncrementList();
                        if (incrementList3 != null) {
                            for (bo boVar2 : incrementList3) {
                                if ((boVar2 instanceof BaseFinderFeed) && (contextObj = NearbyLiveFeedLoader.this.getContextObj()) != null) {
                                    k kVar = k.vfA;
                                    k.e(boVar2.lT(), contextObj.tCE, ((BaseFinderFeed) boVar2).feedObject.getFeedObject().sessionBuffer);
                                }
                            }
                        }
                        if (BuildInfo.DEBUG) {
                            Log.d(this.uQR.uQQ.getTAG(), "onFetchDone remote list: " + bVar.getIncrementList() + " local list:" + NearbyLiveFeedLoader.this.getDataListJustForAdapter());
                        }
                        this.uQR.tVx.onFetchDone(bVar);
                        hVar2.a(com.tencent.mm.loader.g.j.OK);
                        AppMethodBeat.o(249032);
                    }
                };
                int i2 = ((a) this.tVH).pullType;
                AnonymousClass2 r5 = new ab.c(this) {
                    /* class com.tencent.mm.plugin.finder.nearby.live.NearbyLiveFeedLoader.c.a.AnonymousClass2 */
                    final /* synthetic */ a uQR;

                    {
                        this.uQR = r1;
                    }

                    @Override // com.tencent.mm.plugin.finder.cgi.ab.c
                    public final boolean b(dpc dpc) {
                        AppMethodBeat.i(249033);
                        p.h(dpc, "resp");
                        i iVar = this.uQR.uQQ.tMX;
                        if (iVar == null || iVar.token != hVar2.token) {
                            hVar2.a(com.tencent.mm.loader.g.j.OK);
                            String tag = this.uQR.uQQ.getTAG();
                            StringBuilder sb = new StringBuilder("[isFetchConsume] executorToken=");
                            i iVar2 = this.uQR.uQQ.tMX;
                            Log.w(tag, sb.append(iVar2 != null ? Integer.valueOf(iVar2.token) : null).append(" taskToken=").append(hVar2.token).toString());
                            AppMethodBeat.o(249033);
                            return true;
                        }
                        AppMethodBeat.o(249033);
                        return false;
                    }
                };
                int i3 = NearbyLiveFeedLoader.this.uQL;
                p.h(aVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
                p.h(r2, "callback");
                if (i2 != 2) {
                    bVar = null;
                } else {
                    bVar = cVar.uQF.txe;
                }
                d.a aVar2 = com.tencent.mm.plugin.finder.nearby.base.d.uQu;
                d.a.JA(i3).uQo = System.currentTimeMillis();
                new a(bVar, new c.d(cVar, i3, r2), i2, cVar.tCE, r5, cVar.ttO, aVar.uQK).aYI().a(cVar.ttK);
                x xVar = x.SXb;
                AppMethodBeat.o(249034);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetchRefresh(f<bo> fVar) {
            AppMethodBeat.i(249035);
            p.h(fVar, "callback");
            fetch(new a(NearbyLiveFeedLoader.this.tXs, NearbyLiveFeedLoader.this.uQK), fVar);
            if (NearbyLiveFeedLoader.this.tXs == 0) {
                NearbyLiveFeedLoader.this.tXs = 1;
            }
            AppMethodBeat.o(249035);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetchLoadMore(f<bo> fVar) {
            AppMethodBeat.i(249036);
            p.h(fVar, "callback");
            fetch(new a(2, NearbyLiveFeedLoader.this.uQK), fVar);
            AppMethodBeat.o(249036);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetchInit(f<bo> fVar) {
            bbn contextObj;
            AppMethodBeat.i(249037);
            p.h(fVar, "callback");
            LinkedList<bo> linkedList = new LinkedList();
            try {
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                FinderHomeTabStateVM.a Mq = ((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mq(NearbyLiveFeedLoader.this.uQL);
                if (Mq.wuc.isEmpty()) {
                    linkedList.addAll(l.a.a(com.tencent.mm.plugin.finder.storage.data.l.vGw, NearbyLiveFeedLoader.this.uQM));
                    Log.i(getTAG(), "load init data from FirstPage, size:" + linkedList.size() + ", memoryCacheFlag:" + NearbyLiveFeedLoader.this.uQL + ", fileCacheFlag:" + NearbyLiveFeedLoader.this.uQM);
                } else {
                    linkedList.addAll(Mq.wuc);
                    Log.i(getTAG(), "load init data from cache, size:" + linkedList.size() + ", memoryCacheFlag:" + NearbyLiveFeedLoader.this.uQL + ", fileCacheFlag:" + NearbyLiveFeedLoader.this.uQM);
                }
            } catch (Throwable th) {
                Log.printErrStackTrace(getTAG(), th, "load init data exception", new Object[0]);
            }
            for (bo boVar : linkedList) {
                if ((boVar instanceof BaseFinderFeed) && (contextObj = NearbyLiveFeedLoader.this.getContextObj()) != null) {
                    k kVar = k.vfA;
                    k.e(boVar.lT(), contextObj.tCE, ((BaseFinderFeed) boVar).feedObject.getFeedObject().sessionBuffer);
                }
            }
            b bVar = new b(0, 0, "", (byte) 0);
            bVar.setPullType(1000);
            bVar.setIncrementList(linkedList);
            fVar.onFetchDone(bVar);
            AppMethodBeat.o(249037);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetch(Object obj, f<bo> fVar) {
            i iVar;
            AppMethodBeat.i(249038);
            p.h(fVar, "callback");
            if (!(obj instanceof a) || (iVar = this.tMX) == null) {
                AppMethodBeat.o(249038);
                return;
            }
            iVar.a(new h(new a(this, obj, fVar)));
            AppMethodBeat.o(249038);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void alive() {
            AppMethodBeat.i(249039);
            super.alive();
            this.uQO = new c(NearbyLiveFeedLoader.this.dLS, NearbyLiveFeedLoader.this.tCE, NearbyLiveFeedLoader.this.getContextObj());
            i iVar = new i("FinderFollowTlSingleExecutor");
            iVar.start();
            this.tMX = iVar;
            AppMethodBeat.o(249039);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void dead() {
            com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> cVar;
            AppMethodBeat.i(249040);
            super.dead();
            c cVar2 = this.uQO;
            if (!(cVar2 == null || (cVar = cVar2.ttK) == null)) {
                cVar.dead();
            }
            i iVar = this.tMX;
            if (iVar != null) {
                iVar.reset();
            }
            this.tMX = null;
            AppMethodBeat.o(249040);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ IResponse $response;
        final /* synthetic */ NearbyLiveFeedLoader uQP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(NearbyLiveFeedLoader nearbyLiveFeedLoader, IResponse iResponse) {
            super(0);
            this.uQP = nearbyLiveFeedLoader;
            this.$response = iResponse;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            AppMethodBeat.i(249043);
            kotlin.g.a.b<? super IResponse<bo>, x> bVar = this.uQP.fetchEndCallback;
            if (bVar != null) {
                bVar.invoke(this.$response);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(249043);
            return xVar;
        }
    }
}
