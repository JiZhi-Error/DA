package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.d;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013*\u0002\u0016(\u0018\u00002\u00020\u0001:\u0004defgB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010M\u001a\u00020\u001cJ\u0006\u0010N\u001a\u00020\u001cJ\u000e\u0010O\u001a\b\u0012\u0004\u0012\u00020\u001b0PH\u0016J\u000e\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u001b0RH\u0016J\u0006\u0010S\u001a\u00020\u0010J\b\u0010T\u001a\u00020UH\u0016J\b\u0010V\u001a\u00020&H\u0016J\b\u0010W\u001a\u00020&H\u0016J\u0014\u0010X\u001a\u00020\u001c2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\b\u0010Z\u001a\u00020\u001cH\u0016J\b\u0010[\u001a\u00020\u001cH\u0016J\b\u0010\\\u001a\u00020\u001cH\u0016J\u0016\u0010]\u001a\u00020\u001c2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\u0018\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020\u00102\u0006\u0010`\u001a\u00020&H\u0016J\b\u0010a\u001a\u00020\u001cH\u0016J\u000e\u0010b\u001a\u00020\u001c2\u0006\u0010c\u001a\u00020\u0010R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017R.\u0010\u0018\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R&\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001c0\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020(X\u0004¢\u0006\u0004\n\u0002\u0010)R\u001a\u0010*\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R(\u0010/\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001e\"\u0004\b2\u0010 R\"\u00103\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u000104X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u00109\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010?\u001a\u00020@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR!\u0010E\u001a\u0012\u0012\u0004\u0012\u00020G0Fj\b\u0012\u0004\u0012\u00020G`H¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bK\u0010L¨\u0006h"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", ch.COL_USERNAME, "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cachedState", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$CacheState;", "getCachedState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$CacheState;", "setCachedState", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$CacheState;)V", "curTopicId", "", "getCurTopicId", "()J", "setCurTopicId", "(J)V", "feedStickyListener", "com/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$feedStickyListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$feedStickyListener$1;", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "handleStickyEvent", "Lcom/tencent/mm/autogen/events/FeedStickyEvent;", "getHandleStickyEvent", "setHandleStickyEvent", "isLoadingMore", "", "liveLifeListener", "com/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$liveLifeListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$liveLifeListener$1;", "needToFilterLiveData", "getNeedToFilterLiveData", "()Z", "setNeedToFilterLiveData", "(Z)V", "onFetchCallback", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$ProfileResponse;", "getOnFetchCallback", "setOnFetchCallback", "onFilterDataChanged", "Lkotlin/Function0;", "getOnFilterDataChanged", "()Lkotlin/jvm/functions/Function0;", "setOnFilterDataChanged", "(Lkotlin/jvm/functions/Function0;)V", "readFeedId", "getReadFeedId", "()Ljava/lang/Long;", "setReadFeedId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "state", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$State;", "getState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$State;", "setState", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$State;)V", "topicFilterList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "Lkotlin/collections/ArrayList;", "getTopicFilterList", "()Ljava/util/ArrayList;", "getUsername", "()Ljava/lang/String;", "clearMarkRead", "clearStoreCache", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getLastItem", "getPageName", "", "interceptPostStart", "isObservePostEvent", "markRead", "response", "onAlive", "onDataChanged", "onDead", "onFetchDone", "onPostStart", ch.COL_LOCALID, "isFromSns", "requestLoadMore", "switchToTopic", "topicId", "CacheState", "ProfileDataFetcher", "ProfileResponse", "State", "plugin-finder_release"})
public final class FinderProfileFeedLoader extends BaseFinderFeedLoader {
    private CacheState cachedState = CacheState.INIT;
    private long curTopicId;
    private final FinderProfileFeedLoader$feedStickyListener$1 feedStickyListener = new FinderProfileFeedLoader$feedStickyListener$1(this);
    private b<? super IResponse<bo>, x> fetchEndCallback;
    private b<? super hm, x> handleStickyEvent = FinderProfileFeedLoader$handleStickyEvent$1.INSTANCE;
    private boolean isLoadingMore;
    private final FinderProfileFeedLoader$liveLifeListener$1 liveLifeListener = new FinderProfileFeedLoader$liveLifeListener$1(this);
    private boolean needToFilterLiveData;
    private b<? super ProfileResponse, x> onFetchCallback;
    private a<x> onFilterDataChanged;
    private Long readFeedId;
    private State state = State.INIT;
    private final ArrayList<bds> topicFilterList = new ArrayList<>();
    private final String username;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$CacheState;", "", "(Ljava/lang/String;I)V", TMAssistantDownloadSDKClientBase.CONNTECTSTATE_INIT, "NO_CACHE", "WITH_CACHED", "plugin-finder_release"})
    public enum CacheState {
        INIT,
        NO_CACHE,
        WITH_CACHED;

        static {
            AppMethodBeat.i(244782);
            AppMethodBeat.o(244782);
        }

        public static CacheState valueOf(String str) {
            AppMethodBeat.i(244784);
            CacheState cacheState = (CacheState) Enum.valueOf(CacheState.class, str);
            AppMethodBeat.o(244784);
            return cacheState;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$State;", "", "(Ljava/lang/String;I)V", TMAssistantDownloadSDKClientBase.CONNTECTSTATE_INIT, "LOADING", "LOADED", "FAILURE", "PRIVATE_LOCK", "BLOCKED", "DELETING", "plugin-finder_release"})
    public enum State {
        INIT,
        LOADING,
        LOADED,
        FAILURE,
        PRIVATE_LOCK,
        BLOCKED,
        DELETING;

        static {
            AppMethodBeat.i(244797);
            AppMethodBeat.o(244797);
        }

        public static State valueOf(String str) {
            AppMethodBeat.i(244799);
            State state = (State) Enum.valueOf(State.class, str);
            AppMethodBeat.o(244799);
            return state;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderProfileFeedLoader(e eVar, String str, bbn bbn) {
        super(bbn);
        p.h(eVar, "scene");
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(244826);
        this.username = str;
        AppMethodBeat.o(244826);
    }

    public final String getUsername() {
        return this.username;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(244812);
        ProfileDataFetcher profileDataFetcher = new ProfileDataFetcher();
        AppMethodBeat.o(244812);
        return profileDataFetcher;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger() {
        AppMethodBeat.i(244813);
        FinderProfileFeedLoader$createDataMerger$1 finderProfileFeedLoader$createDataMerger$1 = new FinderProfileFeedLoader$createDataMerger$1(this);
        AppMethodBeat.o(244813);
        return finderProfileFeedLoader$createDataMerger$1;
    }

    public final Long getReadFeedId() {
        return this.readFeedId;
    }

    public final void setReadFeedId(Long l) {
        this.readFeedId = l;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super com.tencent.mm.plugin.finder.feed.model.internal.IResponse<com.tencent.mm.plugin.finder.model.bo>, kotlin.x>, kotlin.g.a.b<com.tencent.mm.plugin.finder.feed.model.internal.IResponse<com.tencent.mm.plugin.finder.model.bo>, kotlin.x> */
    public final b<IResponse<bo>, x> getFetchEndCallback() {
        return this.fetchEndCallback;
    }

    public final void setFetchEndCallback(b<? super IResponse<bo>, x> bVar) {
        this.fetchEndCallback = bVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader$ProfileResponse, kotlin.x>, kotlin.g.a.b<com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader$ProfileResponse, kotlin.x> */
    public final b<ProfileResponse, x> getOnFetchCallback() {
        return this.onFetchCallback;
    }

    public final void setOnFetchCallback(b<? super ProfileResponse, x> bVar) {
        this.onFetchCallback = bVar;
    }

    public final boolean getNeedToFilterLiveData() {
        return this.needToFilterLiveData;
    }

    public final void setNeedToFilterLiveData(boolean z) {
        this.needToFilterLiveData = z;
    }

    public final State getState() {
        return this.state;
    }

    public final void setState(State state2) {
        AppMethodBeat.i(244814);
        p.h(state2, "<set-?>");
        this.state = state2;
        AppMethodBeat.o(244814);
    }

    public final CacheState getCachedState() {
        return this.cachedState;
    }

    public final void setCachedState(CacheState cacheState) {
        AppMethodBeat.i(244815);
        p.h(cacheState, "<set-?>");
        this.cachedState = cacheState;
        AppMethodBeat.o(244815);
    }

    public final ArrayList<bds> getTopicFilterList() {
        return this.topicFilterList;
    }

    public final a<x> getOnFilterDataChanged() {
        return this.onFilterDataChanged;
    }

    public final void setOnFilterDataChanged(a<x> aVar) {
        this.onFilterDataChanged = aVar;
    }

    public final long getCurTopicId() {
        return this.curTopicId;
    }

    public final void setCurTopicId(long j2) {
        this.curTopicId = j2;
    }

    public final void switchToTopic(long j2) {
        AppMethodBeat.i(244816);
        Log.i(getTAG(), "switchToTopic ".concat(String.valueOf(j2)));
        if (this.curTopicId != j2) {
            if (this.state == State.LOADED) {
                j store = getStore();
                String valueOf = String.valueOf(this.curTopicId);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(getDataList());
                h hVar = new h(arrayList, getLastBuffer(), 0, null);
                p.h(valueOf, "key");
                p.h(hVar, "value");
                store.tYa.put(valueOf, hVar);
                Log.i(getTAG(), "save cache of TopicId:" + this.curTopicId + ", size:" + getDataList().size());
            }
            getDataList().clear();
            this.state = State.INIT;
            this.cachedState = CacheState.INIT;
            this.curTopicId = j2;
            j store2 = getStore();
            String valueOf2 = String.valueOf(j2);
            p.h(valueOf2, "key");
            h hVar2 = store2.tYa.get(valueOf2);
            if (hVar2 != null) {
                this.state = State.LOADED;
                this.cachedState = CacheState.WITH_CACHED;
                getDataList().addAll(hVar2.kgc);
                setLastBuffer(hVar2.lastBuffer);
                Log.i(getTAG(), "restore cache, topicId:" + j2 + ", size:" + hVar2.kgc);
                dispatcher().onChanged();
                AppMethodBeat.o(244816);
                return;
            }
            this.cachedState = CacheState.NO_CACHE;
            requestRefresh();
            dispatcher().onChanged();
        }
        AppMethodBeat.o(244816);
    }

    public final void clearStoreCache() {
        AppMethodBeat.i(244817);
        getStore().tYa.clear();
        AppMethodBeat.o(244817);
    }

    public final long getLastItem() {
        AppMethodBeat.i(166044);
        for (int size = getDataList().size() - 1; size >= 0; size--) {
            bo boVar = (bo) getDataList().get(size);
            if ((boVar instanceof BaseFinderFeed) && ((BaseFinderFeed) boVar).feedObject.getId() != 0) {
                long id = ((BaseFinderFeed) boVar).feedObject.getId();
                AppMethodBeat.o(166044);
                return id;
            }
        }
        AppMethodBeat.o(166044);
        return 0;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final void onDataChanged() {
        AppMethodBeat.i(244818);
        clearStoreCache();
        AppMethodBeat.o(244818);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final boolean interceptPostStart() {
        AppMethodBeat.i(260251);
        if (this.curTopicId != 0 || (!p.j(this.username, z.aUg()))) {
            AppMethodBeat.o(260251);
            return true;
        }
        AppMethodBeat.o(260251);
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final boolean isObservePostEvent() {
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final void requestLoadMore() {
        AppMethodBeat.i(166045);
        if (this.isLoadingMore) {
            Log.i(getTAG(), "isLoadingMore return");
            AppMethodBeat.o(166045);
            return;
        }
        this.isLoadingMore = true;
        super.requestLoadMore();
        AppMethodBeat.o(166045);
    }

    public final void markRead(IResponse<bo> iResponse) {
        List<bo> incrementList;
        AppMethodBeat.i(244819);
        p.h(iResponse, "response");
        Long l = this.readFeedId;
        if (l == null || l.longValue() == -1 || (incrementList = iResponse.getIncrementList()) == null) {
            AppMethodBeat.o(244819);
            return;
        }
        for (T t : incrementList) {
            if (t instanceof BaseFinderFeed) {
                long id = t.feedObject.getId();
                if (l != null && id == l.longValue()) {
                    t.markRead = true;
                }
            }
        }
        AppMethodBeat.o(244819);
    }

    public final void clearMarkRead() {
        Long l;
        AppMethodBeat.i(244820);
        if (this.readFeedId != null && ((l = this.readFeedId) == null || l.longValue() != -1)) {
            this.readFeedId = null;
            int i2 = 0;
            for (Object obj : getDataList()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                bo boVar = (bo) obj;
                if ((boVar instanceof BaseFinderFeed) && ((BaseFinderFeed) boVar).markRead) {
                    ((BaseFinderFeed) boVar).markRead = false;
                    d dispatcher = dispatcher();
                    FinderProfileUI.a aVar = FinderProfileUI.ucB;
                    dispatcher.onItemRangeChanged(i2, 1, Integer.valueOf(FinderProfileUI.ucA));
                }
                i2 = i3;
            }
        }
        AppMethodBeat.o(244820);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public final void onFetchDone(IResponse<bo> iResponse) {
        b<? super IResponse<bo>, x> bVar;
        b<? super ProfileResponse, x> bVar2;
        AppMethodBeat.i(166046);
        p.h(iResponse, "response");
        markRead(iResponse);
        if (!isInitOperation(iResponse) && (iResponse instanceof ProfileResponse) && (bVar2 = this.onFetchCallback) != null) {
            bVar2.invoke(iResponse);
        }
        if (2 == iResponse.getPullType()) {
            this.isLoadingMore = false;
        } else if ((iResponse instanceof ProfileResponse) && ((ProfileResponse) iResponse).isRequestAll()) {
            this.topicFilterList.clear();
            this.topicFilterList.addAll(((ProfileResponse) iResponse).getFilterList());
            Log.i(getTAG(), "topicFilterList refresh, size:" + this.topicFilterList.size());
            a<x> aVar = this.onFilterDataChanged;
            if (aVar != null) {
                aVar.invoke();
            }
        }
        super.onFetchDone(iResponse);
        if (!iResponse.getHasMore() && (bVar = this.fetchEndCallback) != null) {
            bVar.invoke(iResponse);
        }
        this.cachedState = getDataListJustForAdapter().size() > 0 ? CacheState.WITH_CACHED : CacheState.NO_CACHE;
        AppMethodBeat.o(166046);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final void onPostStart(long j2, boolean z) {
        AppMethodBeat.i(244821);
        super.onPostStart(j2, z);
        this.cachedState = getDataListJustForAdapter().size() > 0 ? CacheState.WITH_CACHED : CacheState.NO_CACHE;
        AppMethodBeat.o(244821);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eR!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$ProfileResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "filterList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "Lkotlin/collections/ArrayList;", "isRequestAll", "", "(IILjava/lang/String;Ljava/util/ArrayList;Z)V", "getFilterList", "()Ljava/util/ArrayList;", "()Z", "maxid", "", "getMaxid", "()J", "setMaxid", "(J)V", "plugin-finder_release"})
    public static final class ProfileResponse extends IResponse<bo> {
        private final ArrayList<bds> filterList;
        private final boolean isRequestAll;
        private long maxid;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ProfileResponse(int i2, int i3, String str, ArrayList<bds> arrayList, boolean z) {
            super(i2, i3, str);
            p.h(arrayList, "filterList");
            AppMethodBeat.i(244796);
            this.filterList = arrayList;
            this.isRequestAll = z;
            AppMethodBeat.o(244796);
        }

        public final ArrayList<bds> getFilterList() {
            return this.filterList;
        }

        public final boolean isRequestAll() {
            return this.isRequestAll;
        }

        public final long getMaxid() {
            return this.maxid;
        }

        public final void setMaxid(long j2) {
            this.maxid = j2;
        }
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super com.tencent.mm.g.a.hm, kotlin.x>, kotlin.g.a.b<com.tencent.mm.g.a.hm, kotlin.x> */
    public final b<hm, x> getHandleStickyEvent() {
        return this.handleStickyEvent;
    }

    public final void setHandleStickyEvent(b<? super hm, x> bVar) {
        AppMethodBeat.i(244822);
        p.h(bVar, "<set-?>");
        this.handleStickyEvent = bVar;
        AppMethodBeat.o(244822);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final void onAlive() {
        AppMethodBeat.i(244823);
        super.onAlive();
        this.feedStickyListener.alive();
        this.liveLifeListener.alive();
        AppMethodBeat.o(244823);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final void onDead() {
        AppMethodBeat.i(244824);
        super.onDead();
        this.feedStickyListener.dead();
        this.liveLifeListener.dead();
        AppMethodBeat.o(244824);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public final int getPageName() {
        AppMethodBeat.i(244825);
        if ((this.username.length() == 0) || p.j(this.username, z.aUg())) {
            AppMethodBeat.o(244825);
            return 1;
        }
        AppMethodBeat.o(244825);
        return 3;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J2\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0019H\u0016J4\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0002¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$ProfileDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$ProfileResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "genLoadMoreNetScene", "genRefreshNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage;", "getCmdIds", "", "mergeLocalData", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "nowList", ch.COL_USERNAME, "start", "end", "plugin-finder_release"})
    public final class ProfileDataFetcher extends com.tencent.mm.plugin.finder.feed.model.internal.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public ProfileDataFetcher() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a, com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetch(Object obj, f<bo> fVar) {
            AppMethodBeat.i(244787);
            p.h(fVar, "callback");
            super.fetch(obj, fVar);
            FinderProfileFeedLoader.this.setState(State.LOADING);
            AppMethodBeat.o(244787);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final List<Integer> getCmdIds() {
            AppMethodBeat.i(244788);
            List<Integer> listOf = j.listOf((Object) 3736);
            AppMethodBeat.o(244788);
            return listOf;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final cn genRefreshNetScene() {
            AppMethodBeat.i(244789);
            cn cnVar = new cn(FinderProfileFeedLoader.this.getUsername(), 0, null, 1, FinderProfileFeedLoader.this.getContextObj(), 0, FinderProfileFeedLoader.this.getCurTopicId(), 32);
            AppMethodBeat.o(244789);
            return cnVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final q genLoadMoreNetScene() {
            AppMethodBeat.i(244791);
            cn cnVar = new cn(FinderProfileFeedLoader.this.getUsername(), FinderProfileFeedLoader.this.getLastItem(), FinderProfileFeedLoader.this.getLastBuffer(), 2, FinderProfileFeedLoader.this.getContextObj(), 0, FinderProfileFeedLoader.this.getCurTopicId(), 32);
            AppMethodBeat.o(244791);
            return cnVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        public final IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, q qVar) {
            boolean z;
            List<FinderItem> list;
            AppMethodBeat.i(244792);
            p.h(qVar, "scene");
            cn cnVar = (cn) qVar;
            com.tencent.mm.bw.a aYK = cnVar.rr.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
                AppMethodBeat.o(244792);
                throw tVar;
            }
            if (((FinderUserPageResponse) aYK).privateLock == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.i(getTAG(), "dealOnSceneEnd private lock");
                ProfileResponse profileResponse = new ProfileResponse(i2, i3, str, new ArrayList(), true);
                profileResponse.setIncrementList(v.SXr);
                profileResponse.setPullType(cnVar.pullType);
                profileResponse.setMaxid(cnVar.cZj());
                profileResponse.setHasMore(false);
                profileResponse.setLastBuffer(cnVar.getLastBuffer());
                FinderProfileFeedLoader.this.setState((i2 == 0 && i3 == 0) ? State.PRIVATE_LOCK : State.FAILURE);
                ProfileResponse profileResponse2 = profileResponse;
                AppMethodBeat.o(244792);
                return profileResponse2;
            }
            y yVar = y.vXH;
            c.a aVar = c.tsp;
            com.tencent.mm.plugin.finder.api.g asG = c.a.asG(FinderProfileFeedLoader.this.getUsername());
            if (y.LM(asG != null ? asG.field_extFlag : 0)) {
                Log.i(getTAG(), "dealOnSceneEnd isUserBlocked");
                ProfileResponse profileResponse3 = new ProfileResponse(i2, i3, str, new ArrayList(), true);
                profileResponse3.setIncrementList(v.SXr);
                profileResponse3.setPullType(cnVar.pullType);
                profileResponse3.setMaxid(cnVar.cZj());
                profileResponse3.setHasMore(false);
                profileResponse3.setLastBuffer(cnVar.getLastBuffer());
                FinderProfileFeedLoader.this.setState((i2 == 0 && i3 == 0) ? State.BLOCKED : State.FAILURE);
                ProfileResponse profileResponse4 = profileResponse3;
                AppMethodBeat.o(244792);
                return profileResponse4;
            }
            y yVar2 = y.vXH;
            c.a aVar2 = c.tsp;
            com.tencent.mm.plugin.finder.api.g asG2 = c.a.asG(FinderProfileFeedLoader.this.getUsername());
            if (y.LN(asG2 != null ? asG2.field_extFlag : 0)) {
                Log.i(getTAG(), "dealOnSceneEnd isUser deleting");
                ProfileResponse profileResponse5 = new ProfileResponse(i2, i3, str, new ArrayList(), true);
                profileResponse5.setIncrementList(v.SXr);
                profileResponse5.setPullType(cnVar.pullType);
                profileResponse5.setMaxid(cnVar.cZj());
                profileResponse5.setHasMore(false);
                profileResponse5.setLastBuffer(cnVar.getLastBuffer());
                FinderProfileFeedLoader.this.setState((i2 == 0 && i3 == 0) ? State.DELETING : State.FAILURE);
                ProfileResponse profileResponse6 = profileResponse5;
                AppMethodBeat.o(244792);
                return profileResponse6;
            } else if (cnVar.twp != FinderProfileFeedLoader.this.getCurTopicId()) {
                AppMethodBeat.o(244792);
                return null;
            } else {
                FinderProfileFeedLoader.this.setState((i2 == 0 && i3 == 0) ? State.LOADED : State.FAILURE);
                boolean z2 = (i2 == 0 && i3 == 0) ? cnVar.tuG : true;
                LinkedList linkedList = cnVar.tvo;
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                ArrayList arrayList = new ArrayList();
                if (cnVar.pullType == 1 && cnVar.twp == 0) {
                    list = mergeLocalData(linkedList, cnVar.tuH, 0, Integer.MAX_VALUE);
                    com.tencent.mm.bw.a aYK2 = cnVar.rr.aYK();
                    if (aYK2 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
                        AppMethodBeat.o(244792);
                        throw tVar2;
                    }
                    LinkedList<bds> linkedList2 = ((FinderUserPageResponse) aYK2).usualTopics;
                    p.g(linkedList2, "(rr.responseProtoBuf as …PageResponse).usualTopics");
                    arrayList.addAll(linkedList2);
                } else {
                    list = linkedList;
                }
                ProfileResponse profileResponse7 = new ProfileResponse(i2, i3, str, arrayList, cnVar.twp == 0);
                List<FinderItem> list2 = list;
                ArrayList arrayList2 = new ArrayList(j.a(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    c.a aVar3 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    arrayList2.add(c.a.s(it.next()));
                }
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : arrayList2) {
                    if (!(FinderProfileFeedLoader.this.getNeedToFilterLiveData() && ((BaseFinderFeed) obj).feedObject.getMediaType() == 9)) {
                        arrayList3.add(obj);
                    }
                }
                profileResponse7.setIncrementList(arrayList3);
                profileResponse7.setPullType(cnVar.pullType);
                profileResponse7.setMaxid(cnVar.cZj());
                profileResponse7.setHasMore(z2);
                profileResponse7.setLastBuffer(cnVar.getLastBuffer());
                ProfileResponse profileResponse8 = profileResponse7;
                AppMethodBeat.o(244792);
                return profileResponse8;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x007f  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0054 A[SYNTHETIC] */
        @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader.ProfileResponse callInit() {
            /*
            // Method dump skipped, instructions count: 304
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader.ProfileDataFetcher.callInit():com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader$ProfileResponse");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.util.List<? extends com.tencent.mm.plugin.finder.storage.FinderItem> */
        /* JADX WARN: Multi-variable type inference failed */
        private final List<FinderItem> mergeLocalData(List<? extends FinderItem> list, String str, int i2, int i3) {
            AppMethodBeat.i(244795);
            if ((str.length() == 0) || (!p.j(str, z.aUg()))) {
                AppMethodBeat.o(244795);
                return list;
            }
            if (g.DEBUG) {
                y yVar = y.vXH;
                y.m(list, "nowList");
            }
            Log.i(getTAG(), "mergeLocalData start " + i2 + " end " + i3);
            LinkedList linkedList = new LinkedList();
            c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            ArrayList arrayList = new ArrayList();
            for (T t : c.a.af(str, i2, i3)) {
                if (t.getFinderObject().objectType != 2) {
                    arrayList.add(t);
                }
            }
            ArrayList<FinderItem> arrayList2 = arrayList;
            linkedList.addAll(list);
            com.tencent.mm.ac.d.a(arrayList2, (b) new FinderProfileFeedLoader$ProfileDataFetcher$mergeLocalData$1(list));
            linkedList.addAll(0, arrayList2);
            if (g.DEBUG) {
                y yVar2 = y.vXH;
                y.m(linkedList, "newList");
            }
            Log.i(getTAG(), "dblist size:" + arrayList2.size());
            for (FinderItem finderItem : arrayList2) {
                Log.i(getTAG(), "dblist item, localId:" + finderItem.getLocalId() + ", id:" + finderItem.getId());
            }
            LinkedList linkedList2 = linkedList;
            AppMethodBeat.o(244795);
            return linkedList2;
        }
    }
}
