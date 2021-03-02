package com.tencent.mm.plugin.finder.feed.model;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bv;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bf;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.ayb;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0002\u000f\u001c\u0018\u00002\u00020\u0001:\u0004DEFGB#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020(0*H\u0016J\u000e\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020-J\u000e\u0010+\u001a\u00020&2\u0006\u0010.\u001a\u00020/J\u0016\u00100\u001a\u00020\u00132\u0006\u0010,\u001a\u00020-2\u0006\u00101\u001a\u00020&J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000203H\u0016J\b\u00105\u001a\u000203H\u0016J\b\u00106\u001a\u00020\u0013H\u0016J\b\u00107\u001a\u00020\u0013H\u0016J\u0016\u00108\u001a\u00020\u00132\f\u00109\u001a\b\u0012\u0004\u0012\u00020(0:H\u0016J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020>H\u0016J\u0016\u0010A\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u00101\u001a\u00020&J\u000e\u0010B\u001a\u00020\u00132\u0006\u0010C\u001a\u00020/R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0010\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006H"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "finderSelfName", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cachedState", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$CacheState;", "getCachedState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$CacheState;", "setCachedState", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$CacheState;)V", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$feedProgressListener$1;", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFinderSelfName", "()Ljava/lang/String;", "getFinderUserName", "musicPlayEventListener", "com/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$musicPlayEventListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$musicPlayEventListener$1;", "state", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$State;", "getState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$State;", "setState", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$State;)V", "addRvFeed", FirebaseAnalytics.b.INDEX, "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "findMusicIndex", "wrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "id", "", "handleMusic", NativeProtocol.WEB_DIALOG_ACTION, "interceptMvFeed", "", "interceptMvPostStart", "isObservePostEvent", "onAlive", "onDead", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "transformFinderObj", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "transformToMusicData", "item", "updateMusic", "updateMusicProgressByLocalId", ch.COL_LOCALID, "CacheState", "MusicDataFetcher", "MvResponse", "State", "plugin-finder_release"})
public final class FinderProfileMusicLoader extends BaseFinderFeedLoader {
    final String sBN;
    public kotlin.g.a.a<x> tTS;
    public d tWS = d.INIT;
    public a tWT = a.INIT;
    private final e tWU = new e(this);
    private final f tWV = new f(this);
    final String tWW;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$CacheState;", "", "(Ljava/lang/String;I)V", TMAssistantDownloadSDKClientBase.CONNTECTSTATE_INIT, "NO_CACHE", "WITH_CACHED", "plugin-finder_release"})
    public enum a {
        INIT,
        NO_CACHE,
        WITH_CACHED;

        static {
            AppMethodBeat.i(244827);
            AppMethodBeat.o(244827);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(244829);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(244829);
            return aVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$State;", "", "(Ljava/lang/String;I)V", TMAssistantDownloadSDKClientBase.CONNTECTSTATE_INIT, "LOADING", "LOADED", "FAILURE", "PRIVATE_LOCK", "plugin-finder_release"})
    public enum d {
        INIT,
        LOADING,
        LOADED,
        FAILURE,
        PRIVATE_LOCK;

        static {
            AppMethodBeat.i(244838);
            AppMethodBeat.o(244838);
        }

        public static d valueOf(String str) {
            AppMethodBeat.i(244840);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(244840);
            return dVar;
        }
    }

    public FinderProfileMusicLoader(String str, String str2, bbn bbn) {
        super(bbn);
        AppMethodBeat.i(244852);
        this.sBN = str;
        this.tWW = str2;
        AppMethodBeat.o(244852);
    }

    public final void a(d dVar) {
        AppMethodBeat.i(244844);
        p.h(dVar, "<set-?>");
        this.tWS = dVar;
        AppMethodBeat.o(244844);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class e extends IListener<hk> {
        final /* synthetic */ FinderProfileMusicLoader tXb;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(FinderProfileMusicLoader finderProfileMusicLoader) {
            this.tXb = finderProfileMusicLoader;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hk hkVar) {
            AppMethodBeat.i(244841);
            hk hkVar2 = hkVar;
            if (hkVar2 != null) {
                Log.i(this.tXb.getTAG(), "feedProgressListener localId:" + hkVar2.dLT.localId + ", progress:" + hkVar2.dLT.progress);
                FinderProfileMusicLoader finderProfileMusicLoader = this.tXb;
                long j2 = hkVar2.dLT.localId;
                if (j2 > 0) {
                    com.tencent.mm.ac.d.h(new g(finderProfileMusicLoader, j2));
                }
            }
            AppMethodBeat.o(244841);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$musicPlayEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class f extends IListener<mx> {
        final /* synthetic */ FinderProfileMusicLoader tXb;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(FinderProfileMusicLoader finderProfileMusicLoader) {
            this.tXb = finderProfileMusicLoader;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mx mxVar) {
            AppMethodBeat.i(244842);
            mx mxVar2 = mxVar;
            if (mxVar2 != null) {
                mx.a aVar = mxVar2.dSE;
                Integer valueOf = aVar != null ? Integer.valueOf(aVar.action) : null;
                if ((valueOf != null && valueOf.intValue() == 2) || ((valueOf != null && valueOf.intValue() == 3) || ((valueOf != null && valueOf.intValue() == 4) || ((valueOf != null && valueOf.intValue() == 7) || ((valueOf != null && valueOf.intValue() == 0) || (valueOf != null && valueOf.intValue() == 1)))))) {
                    this.tXb.dispatcher().onChanged();
                }
            }
            AppMethodBeat.o(244842);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final void onAlive() {
        AppMethodBeat.i(244845);
        super.onAlive();
        this.tWU.alive();
        this.tWV.alive();
        AppMethodBeat.o(244845);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final void onDead() {
        AppMethodBeat.i(244846);
        super.onDead();
        this.tWU.dead();
        this.tWV.dead();
        AppMethodBeat.o(244846);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.g<bo> createDataFetch() {
        AppMethodBeat.i(244847);
        b bVar = new b();
        AppMethodBeat.o(244847);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final boolean isObservePostEvent() {
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final boolean interceptMvPostStart() {
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final boolean interceptMvFeed() {
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final BaseFinderFeed transformFinderObj(FinderItem finderItem) {
        AppMethodBeat.i(244848);
        p.h(finderItem, "feedObj");
        if (interceptMvFeed()) {
            BaseFinderFeed transformToMusicData = transformToMusicData(finderItem);
            AppMethodBeat.o(244848);
            return transformToMusicData;
        }
        BaseFinderFeed transformFinderObj = super.transformFinderObj(finderItem);
        AppMethodBeat.o(244848);
        return transformFinderObj;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final void addRvFeed(int i2, bo boVar) {
        AppMethodBeat.i(244849);
        p.h(boVar, "feed");
        if (!(boVar instanceof BaseFinderFeed) || !((BaseFinderFeed) boVar).feedObject.isMvFeed() || (boVar instanceof bf)) {
            getDataList().add(i2, boVar);
            AppMethodBeat.o(244849);
            return;
        }
        getDataList().add(i2, transformToMusicData(((BaseFinderFeed) boVar).feedObject));
        AppMethodBeat.o(244849);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final BaseFinderFeed transformToMusicData(FinderItem finderItem) {
        AppMethodBeat.i(244850);
        p.h(finderItem, "item");
        bf bfVar = new bf(finderItem);
        AppMethodBeat.o(244850);
        return bfVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        kotlin.g.a.a<x> aVar;
        AppMethodBeat.i(244851);
        p.h(iResponse, "response");
        super.onFetchDone(iResponse);
        this.tWT = getDataListJustForAdapter().size() > 0 ? a.WITH_CACHED : a.NO_CACHE;
        if (isInitOperation(iResponse)) {
            AppMethodBeat.o(244851);
        } else if (iResponse.getHasMore() || (aVar = this.tTS) == null) {
            AppMethodBeat.o(244851);
        } else {
            aVar.invoke();
            AppMethodBeat.o(244851);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J2\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0016J4\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0002J \u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00172\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017H\u0002¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$MusicDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "mergeLocalData", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "nowList", "userName", "start", "end", "transfromMusicInfoList", "Lcom/tencent/mm/plugin/finder/model/FinderMusicInfoData;", "items", "plugin-finder_release"})
    public final class b extends com.tencent.mm.plugin.finder.feed.model.internal.a {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "removeIt", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "invoke"})
        static final class a extends q implements kotlin.g.a.b<FinderItem, Boolean> {
            final /* synthetic */ List $nowList;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(List list) {
                super(1);
                this.$nowList = list;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Boolean invoke(FinderItem finderItem) {
                Object obj;
                boolean z;
                boolean z2;
                AppMethodBeat.i(244830);
                FinderItem finderItem2 = finderItem;
                p.h(finderItem2, "removeIt");
                Iterator it = this.$nowList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object next = it.next();
                    FinderItem finderItem3 = (FinderItem) next;
                    if (finderItem3.getLocalId() == finderItem2.getLocalId() || ((finderItem3.field_id != 0 && finderItem3.field_id == finderItem2.field_id) || finderItem3.getCreateTime() == finderItem2.getCreateTime())) {
                        z2 = true;
                        continue;
                    } else {
                        z2 = false;
                        continue;
                    }
                    if (z2) {
                        obj = next;
                        break;
                    }
                }
                if (((FinderItem) obj) != null) {
                    z = true;
                } else {
                    z = false;
                }
                Boolean valueOf = Boolean.valueOf(z);
                AppMethodBeat.o(244830);
                return valueOf;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a, com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetch(Object obj, com.tencent.mm.plugin.finder.feed.model.internal.f<bo> fVar) {
            AppMethodBeat.i(244831);
            p.h(fVar, "callback");
            super.fetch(obj, fVar);
            FinderProfileMusicLoader.this.a(d.LOADING);
            AppMethodBeat.o(244831);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(244832);
            List<Integer> listOf = j.listOf((Object) 6628);
            AppMethodBeat.o(244832);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genRefreshNetScene() {
            AppMethodBeat.i(244833);
            bv bvVar = new bv(FinderProfileMusicLoader.this.sBN, FinderProfileMusicLoader.this.tWW, null, 0, FinderProfileMusicLoader.this.getContextObj());
            AppMethodBeat.o(244833);
            return bvVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final com.tencent.mm.ak.q genLoadMoreNetScene() {
            AppMethodBeat.i(244834);
            bv bvVar = new bv(FinderProfileMusicLoader.this.sBN, FinderProfileMusicLoader.this.tWW, FinderProfileMusicLoader.this.getLastBuffer(), 2, FinderProfileMusicLoader.this.getContextObj());
            AppMethodBeat.o(244834);
            return bvVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> callInit() {
            AppMethodBeat.i(244835);
            l.a aVar = com.tencent.mm.plugin.finder.storage.data.l.vGw;
            String str = FinderProfileMusicLoader.this.sBN;
            if (str == null) {
                str = "";
            }
            List<FinderItem> dG = aVar.dG(str, 17);
            String str2 = FinderProfileMusicLoader.this.sBN;
            if (str2 == null) {
                str2 = "";
            }
            if (!(str2.length() == 0) && !(!p.j(str2, z.aUg()))) {
                if (com.tencent.mm.plugin.finder.feed.model.internal.g.DEBUG) {
                    y yVar = y.vXH;
                    y.m(dG, "newList");
                }
                Log.i(getTAG(), new StringBuilder("mergeLocalData start 0 end 2147483647").toString());
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(dG);
                c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                ArrayList arrayList = new ArrayList();
                for (T t : c.a.af(str2, 0, Integer.MAX_VALUE)) {
                    if (t.getFeedObject().objectType == 2) {
                        arrayList.add(t);
                    }
                }
                ArrayList<FinderItem> arrayList2 = arrayList;
                com.tencent.mm.ac.d.a(arrayList2, (kotlin.g.a.b) new a(dG));
                linkedList.addAll(0, arrayList2);
                if (com.tencent.mm.plugin.finder.feed.model.internal.g.DEBUG) {
                    y yVar2 = y.vXH;
                    y.m(linkedList, "newList");
                }
                Log.i(getTAG(), "dblist size:" + arrayList2.size());
                for (FinderItem finderItem : arrayList2) {
                    Log.i(getTAG(), "dblist item, localId:" + finderItem.getLocalId() + ", id:" + finderItem.getId());
                }
            }
            c cVar = new c(0, 0, "");
            ArrayList arrayList3 = new ArrayList();
            Iterator<T> it = dG.iterator();
            while (it.hasNext()) {
                arrayList3.add(new bf(it.next()));
            }
            cVar.setIncrementList(arrayList3);
            cVar.setLastBuffer(null);
            c cVar2 = cVar;
            AppMethodBeat.o(244835);
            return cVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            boolean z;
            AppMethodBeat.i(244836);
            p.h(qVar, "scene");
            if (qVar instanceof bv) {
                FinderProfileMusicLoader.this.a((i2 == 0 && i3 == 0) ? d.LOADED : d.FAILURE);
                List<FinderItem> cYL = ((bv) qVar).cYL();
                c cVar = new c(i2, i3, str);
                List<FinderItem> list = cYL;
                ArrayList arrayList = new ArrayList(j.a(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new bf(it.next()));
                }
                cVar.setIncrementList(arrayList);
                cVar.setPullType(((bv) qVar).pullType);
                com.tencent.mm.bw.a aYK = ((bv) qVar).iUB.aYK();
                if (aYK == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderMVUserPageResponse");
                    AppMethodBeat.o(244836);
                    throw tVar;
                }
                if (((ayb) aYK).continueFlag == 1) {
                    z = true;
                } else {
                    z = false;
                }
                cVar.setHasMore(z);
                com.tencent.mm.bw.a aYK2 = ((bv) qVar).iUB.aYK();
                if (aYK2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderMVUserPageResponse");
                    AppMethodBeat.o(244836);
                    throw tVar2;
                }
                cVar.setLastBuffer(((ayb) aYK2).lastBuffer);
                c cVar2 = cVar;
                AppMethodBeat.o(244836);
                return cVar2;
            }
            AppMethodBeat.o(244836);
            return null;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader$MvResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
    public static final class c extends IResponse<bo> {
        public c(int i2, int i3, String str) {
            super(i2, i3, str);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ long $localId;
        final /* synthetic */ FinderProfileMusicLoader tXb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(FinderProfileMusicLoader finderProfileMusicLoader, long j2) {
            super(0);
            this.tXb = finderProfileMusicLoader;
            this.$localId = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(244843);
            int i2 = 0;
            for (Object obj : this.tXb.getDataList()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                bo boVar = (bo) obj;
                if ((boVar instanceof bf) && ((bf) boVar).uOO.getLocalId() == this.$localId) {
                    c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    FinderItem FS = c.a.FS(this.$localId);
                    if (FS != null) {
                        this.tXb.getDataList().set(i2, new bf(FS));
                    }
                    Log.i(this.tXb.getTAG(), "updateProgressByLocalId " + ((bf) boVar).uOO.getLocalId() + " index:" + i2);
                    this.tXb.dispatcher().onItemRangeChanged(i2, 1, new o(2, 1));
                }
                i2 = i3;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244843);
            return xVar;
        }
    }
}
