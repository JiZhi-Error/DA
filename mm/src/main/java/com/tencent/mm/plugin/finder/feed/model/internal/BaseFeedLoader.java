package com.tencent.mm.plugin.finder.feed.model.internal;

import android.content.Intent;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.feed.model.j;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

public abstract class BaseFeedLoader<T extends i> extends Dispatcher<T> implements f<T> {
    private final kotlin.f dataFetch$delegate;
    private h initDone;
    private j<T> preload;
    private final com.tencent.mm.plugin.finder.feed.model.j store;

    public BaseFeedLoader() {
        this(null, 1, null);
    }

    private final g<T> getDataFetch() {
        return (g) this.dataFetch$delegate.getValue();
    }

    public abstract g<T> createDataFetch();

    public static final class c extends q implements kotlin.g.a.b<IResponse<T>, x> {
        final /* synthetic */ BaseFeedLoader this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(BaseFeedLoader baseFeedLoader) {
            super(1);
            this.this$0 = baseFeedLoader;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Object obj) {
            AppMethodBeat.i(244968);
            IResponse<T> iResponse = (IResponse) obj;
            p.h(iResponse, LocaleUtil.ITALIAN);
            this.this$0.onFetchInitDone(iResponse);
            x xVar = x.SXb;
            AppMethodBeat.o(244968);
            return xVar;
        }
    }

    public static final class d extends q implements kotlin.g.a.b<IResponse<T>, x> {
        final /* synthetic */ IResponse $response;
        final /* synthetic */ BaseFeedLoader this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(BaseFeedLoader baseFeedLoader, IResponse iResponse) {
            super(1);
            this.this$0 = baseFeedLoader;
            this.$response = iResponse;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Object obj) {
            AppMethodBeat.i(244969);
            p.h((IResponse) obj, LocaleUtil.ITALIAN);
            this.this$0.onFetchRefreshDone(this.$response);
            x xVar = x.SXb;
            AppMethodBeat.o(244969);
            return xVar;
        }
    }

    public static final class e extends q implements kotlin.g.a.b<IResponse<T>, x> {
        final /* synthetic */ IResponse $response;
        final /* synthetic */ BaseFeedLoader this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(BaseFeedLoader baseFeedLoader, IResponse iResponse) {
            super(1);
            this.this$0 = baseFeedLoader;
            this.$response = iResponse;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Object obj) {
            AppMethodBeat.i(244970);
            p.h((IResponse) obj, LocaleUtil.ITALIAN);
            this.this$0.onFetchInsertedDone(this.$response);
            x xVar = x.SXb;
            AppMethodBeat.o(244970);
            return xVar;
        }
    }

    public static final class f extends q implements kotlin.g.a.b<IResponse<T>, x> {
        final /* synthetic */ IResponse $response;
        final /* synthetic */ BaseFeedLoader this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(BaseFeedLoader baseFeedLoader, IResponse iResponse) {
            super(1);
            this.this$0 = baseFeedLoader;
            this.$response = iResponse;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Object obj) {
            AppMethodBeat.i(244971);
            p.h((IResponse) obj, LocaleUtil.ITALIAN);
            this.this$0.onFetchLoadMoreDone(this.$response);
            x xVar = x.SXb;
            AppMethodBeat.o(244971);
            return xVar;
        }
    }

    public static final class g extends q implements kotlin.g.a.b<IResponse<T>, x> {
        final /* synthetic */ Object tVH;
        final /* synthetic */ BaseFeedLoader this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(BaseFeedLoader baseFeedLoader, Object obj) {
            super(1);
            this.this$0 = baseFeedLoader;
            this.tVH = obj;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Object obj) {
            AppMethodBeat.i(244972);
            IResponse<T> iResponse = (IResponse) obj;
            if (iResponse != null) {
                Log.i(this.this$0.getTAG(), "request hit cache");
                this.this$0.onFetchDone(iResponse);
            } else {
                BaseFeedLoader baseFeedLoader = this.this$0;
                baseFeedLoader.getDataFetch().fetch(this.tVH, baseFeedLoader);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244972);
            return xVar;
        }
    }

    public static final class h extends q implements kotlin.g.a.b<IResponse<T>, x> {
        final /* synthetic */ Object tVH;
        final /* synthetic */ f tVx;
        final /* synthetic */ BaseFeedLoader this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(BaseFeedLoader baseFeedLoader, Object obj, f fVar) {
            super(1);
            this.this$0 = baseFeedLoader;
            this.tVH = obj;
            this.tVx = fVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Object obj) {
            AppMethodBeat.i(244973);
            IResponse<T> iResponse = (IResponse) obj;
            if (iResponse != null) {
                Log.i(this.this$0.getTAG(), "request hit cache");
                this.this$0.onFetchDone(iResponse);
            } else {
                this.this$0.getDataFetch().fetch(this.tVH, this.tVx);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244973);
            return xVar;
        }
    }

    public static final class j extends q implements kotlin.g.a.b<IResponse<T>, x> {
        final /* synthetic */ BaseFeedLoader this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(BaseFeedLoader baseFeedLoader) {
            super(1);
            this.this$0 = baseFeedLoader;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Object obj) {
            AppMethodBeat.i(244975);
            IResponse<T> iResponse = (IResponse) obj;
            if (iResponse != null) {
                Log.i(this.this$0.getTAG(), "requestLoadMore hit cache");
                this.this$0.onFetchDone(iResponse);
            } else {
                BaseFeedLoader baseFeedLoader = this.this$0;
                baseFeedLoader.getDataFetch().fetchLoadMore(baseFeedLoader);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244975);
            return xVar;
        }
    }

    public static final class l extends q implements kotlin.g.a.b<IResponse<T>, x> {
        final /* synthetic */ BaseFeedLoader this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(BaseFeedLoader baseFeedLoader) {
            super(1);
            this.this$0 = baseFeedLoader;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Object obj) {
            AppMethodBeat.i(244978);
            IResponse<T> iResponse = (IResponse) obj;
            if (iResponse != null) {
                Log.i(this.this$0.getTAG(), "requestRefresh hit cache");
                this.this$0.onFetchDone(iResponse);
            } else {
                BaseFeedLoader baseFeedLoader = this.this$0;
                baseFeedLoader.getDataFetch().fetchRefresh(baseFeedLoader);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244978);
            return xVar;
        }
    }

    public BaseFeedLoader(bbn bbn) {
        this.store = new com.tencent.mm.plugin.finder.feed.model.j();
        this.store.ttO = bbn;
        this.dataFetch$delegate = kotlin.g.ah(new b(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseFeedLoader(bbn bbn, int i2, kotlin.g.b.j jVar) {
        this((i2 & 1) != 0 ? null : bbn);
    }

    public final com.tencent.mm.plugin.finder.feed.model.j getStore() {
        return this.store;
    }

    public final bbn getContextObj() {
        return this.store.ttO;
    }

    public final void setContextObj(bbn bbn) {
        this.store.ttO = bbn;
    }

    public final com.tencent.mm.bw.b getLastBuffer() {
        return this.store.lastBuffer;
    }

    public final void setLastBuffer(com.tencent.mm.bw.b bVar) {
        this.store.lastBuffer = bVar;
    }

    public final int getInitPos() {
        int i2;
        com.tencent.mm.plugin.finder.feed.model.h hVar = this.store.tXW;
        if (hVar != null) {
            i2 = hVar.position;
        } else {
            i2 = 0;
        }
        return Math.max(i2, 0);
    }

    public final com.tencent.mm.plugin.finder.feed.model.h getCache() {
        return this.store.tXW;
    }

    public final com.tencent.mm.plugin.finder.feed.model.h getBackCache() {
        return this.store.tXX;
    }

    public final void initFromCache(Intent intent) {
        p.h(intent, "intent");
        com.tencent.mm.plugin.finder.feed.model.j.a(this.store, intent);
    }

    public final void initBackCache(Intent intent) {
        p.h(intent, "intent");
        com.tencent.mm.plugin.finder.feed.model.j jVar = this.store;
        p.h(intent, "intent");
        j.a aVar = com.tencent.mm.plugin.finder.feed.model.j.tYb;
        jVar.tXX = j.a.al(intent);
    }

    public static /* synthetic */ void saveCache$default(BaseFeedLoader baseFeedLoader, Intent intent, int i2, com.tencent.mm.plugin.finder.feed.model.a aVar, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveCache");
        }
        if ((i3 & 4) != 0) {
            aVar = null;
        }
        baseFeedLoader.saveCache(intent, i2, aVar);
    }

    public final void saveCache(Intent intent, int i2, com.tencent.mm.plugin.finder.feed.model.a aVar) {
        p.h(intent, "intent");
        ArrayList arrayList = new ArrayList();
        DataBuffer<T> dataList = getDataList();
        if (!(dataList instanceof DataBuffer)) {
            dataList = null;
        }
        if (dataList != null) {
            arrayList.addAll(dataList);
        }
        this.store.a(new com.tencent.mm.plugin.finder.feed.model.h(arrayList, getLastBuffer(), i2, aVar), intent);
    }

    public static /* synthetic */ void saveCacheToIntent$default(BaseFeedLoader baseFeedLoader, Intent intent, List list, com.tencent.mm.bw.b bVar, int i2, com.tencent.mm.plugin.finder.feed.model.a aVar, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveCacheToIntent");
        }
        baseFeedLoader.saveCacheToIntent(intent, list, bVar, i2, (i3 & 16) != 0 ? null : aVar);
    }

    public final void saveCacheToIntent(Intent intent, List<? extends bo> list, com.tencent.mm.bw.b bVar, int i2, com.tencent.mm.plugin.finder.feed.model.a aVar) {
        p.h(intent, "intent");
        p.h(list, "feedList");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        this.store.a(new com.tencent.mm.plugin.finder.feed.model.h(arrayList, bVar, i2, aVar), intent);
    }

    public void onSaveLastBuffer(IResponse<T> iResponse) {
        p.h(iResponse, "response");
        setLastBuffer(iResponse.getLastBuffer());
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher
    public void onAlive() {
        Log.i(getTAG(), "onAlive");
        getDataFetch().alive();
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher
    public void onDead() {
        Log.i(getTAG(), "onDead");
        getDataFetch().dead();
    }

    public final boolean isRefreshOperation(IResponse<T> iResponse) {
        p.h(iResponse, "response");
        return 1 == iResponse.getPullType() || iResponse.getPullType() == 0 || 4 == iResponse.getPullType() || 3 == iResponse.getPullType();
    }

    public final boolean isInsertOperation(IResponse<T> iResponse) {
        p.h(iResponse, "response");
        return -1 == iResponse.getPullType();
    }

    public final boolean isInitOperation(IResponse<T> iResponse) {
        p.h(iResponse, "response");
        return 1000 == iResponse.getPullType();
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.f
    public void onFetchDone(IResponse<T> iResponse) {
        p.h(iResponse, "response");
        if (isInitOperation(iResponse)) {
            getMerger().mergeInit(iResponse, new c(this));
        } else if (isRefreshOperation(iResponse)) {
            getMerger().mergeRefresh(iResponse, new d(this, iResponse));
        } else if (isInsertOperation(iResponse)) {
            getMerger().mergeInsert(iResponse, new e(this, iResponse));
        } else {
            getMerger().mergeLoadMore(iResponse, new f(this, iResponse));
        }
        onSaveLastBuffer(iResponse);
    }

    public void onFetchInitDone(IResponse<T> iResponse) {
        p.h(iResponse, "initResponse");
        h hVar = this.initDone;
        if (hVar != null) {
            List<T> incrementList = iResponse.getIncrementList();
            hVar.call(incrementList != null ? incrementList.size() : 0);
        }
    }

    public void onFetchRefreshDone(IResponse<T> iResponse) {
        p.h(iResponse, "response");
    }

    public void onFetchLoadMoreDone(IResponse<T> iResponse) {
        p.h(iResponse, "response");
    }

    public void onFetchInsertedDone(IResponse<T> iResponse) {
        p.h(iResponse, "response");
    }

    public final h getInitDone() {
        return this.initDone;
    }

    public final void setInitDone(h hVar) {
        this.initDone = hVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void request$default(BaseFeedLoader baseFeedLoader, Object obj, f fVar, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: request");
        }
        if ((i2 & 2) != 0) {
            fVar = null;
        }
        baseFeedLoader.request(obj, fVar);
    }

    public final void request(Object obj, f<T> fVar) {
        Log.i(getTAG(), ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        if (fVar == null) {
            j<T> jVar = this.preload;
            if (jVar != null) {
                jVar.D(new g(this, obj));
                return;
            }
            BaseFeedLoader<T> baseFeedLoader = this;
            baseFeedLoader.getDataFetch().fetch(obj, baseFeedLoader);
            return;
        }
        j<T> jVar2 = this.preload;
        if (jVar2 != null) {
            jVar2.D(new h(this, obj, fVar));
        } else {
            getDataFetch().fetch(obj, fVar);
        }
    }

    public static /* synthetic */ void requestInit$default(BaseFeedLoader baseFeedLoader, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestInit");
        }
        if ((i2 & 1) != 0) {
            z = true;
        }
        baseFeedLoader.requestInit(z);
    }

    public final void requestInit(boolean z) {
        Log.i(getTAG(), "initData from " + Util.getStack());
        if (z) {
            getDataFetch().fetchInit(this);
        } else {
            kotlin.c.a.ai(new i(this));
        }
    }

    public final void requestPreload() {
        requestPreload(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void requestPreload$default(BaseFeedLoader baseFeedLoader, f fVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestPreload");
        }
        if ((i2 & 1) != 0) {
            fVar = null;
        }
        baseFeedLoader.requestPreload(fVar);
    }

    public void requestPreload(f<T> fVar) {
        j<T> jVar = this.preload;
        if (jVar != null) {
            jVar.G(new k(this, fVar));
        }
    }

    public void requestRefresh() {
        Log.i(getTAG(), "requestRefresh");
        j<T> jVar = this.preload;
        if (jVar != null) {
            jVar.D(new l(this));
            return;
        }
        BaseFeedLoader<T> baseFeedLoader = this;
        baseFeedLoader.getDataFetch().fetchRefresh(baseFeedLoader);
    }

    public void requestLoadMore() {
        Log.i(getTAG(), "requestLoadMore");
        j<T> jVar = this.preload;
        if (jVar != null) {
            jVar.D(new j(this));
            return;
        }
        BaseFeedLoader<T> baseFeedLoader = this;
        baseFeedLoader.getDataFetch().fetchLoadMore(baseFeedLoader);
    }

    public void requestInsert(Object obj) {
        p.h(obj, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Log.i(getTAG(), "requestInsert ".concat(String.valueOf(obj)));
        request$default(this, obj, null, 2, null);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher
    public b<T> createDataMerger() {
        return new a();
    }

    public final void setPreload(j<T> jVar) {
        p.h(jVar, "preloader");
        this.preload = jVar;
    }

    public class a extends b<T> {
        public a() {
            BaseFeedLoader.this = r1;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b
        public void mergeInit(IResponse<T> iResponse, kotlin.g.a.b<? super IResponse<T>, x> bVar) {
            AppMethodBeat.i(244955);
            p.h(iResponse, "response");
            if (iResponse.getIncrementList() == null) {
                iResponse.setIncrementList(v.SXr);
            }
            String tag = BaseFeedLoader.this.getTAG();
            StringBuilder sb = new StringBuilder("initData dataFetch.initData ");
            List<T> incrementList = iResponse.getIncrementList();
            Log.i(tag, sb.append(incrementList != null ? Integer.valueOf(incrementList.size()) : null).toString());
            com.tencent.mm.ac.d.h(new b(this, iResponse, bVar));
            AppMethodBeat.o(244955);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b
        public void mergeRefresh(IResponse<T> iResponse, kotlin.g.a.b<? super IResponse<T>, x> bVar) {
            AppMethodBeat.i(244956);
            p.h(iResponse, "response");
            RefreshLoadMoreLayout.c.a aVar = RefreshLoadMoreLayout.c.Rms;
            com.tencent.mm.ac.d.h(new e(this, new n(iResponse.getHasMore() ? 2 : 6, iResponse.getIncrementList(), false, 12), new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.Rmm), bVar, iResponse));
            AppMethodBeat.o(244956);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b
        public void mergeLoadMore(IResponse<T> iResponse, kotlin.g.a.b<? super IResponse<T>, x> bVar) {
            boolean z;
            int i2 = 1;
            AppMethodBeat.i(244957);
            p.h(iResponse, "response");
            RefreshLoadMoreLayout.c.a aVar = RefreshLoadMoreLayout.c.Rms;
            RefreshLoadMoreLayout.c cVar = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.Rmn);
            List<T> incrementList = iResponse.getIncrementList();
            if (incrementList != null) {
                z = incrementList.isEmpty();
            } else {
                z = true;
            }
            cVar.jLE = z;
            cVar.Rmj = iResponse.getHasMore();
            if (!iResponse.getHasMore()) {
                i2 = 5;
            }
            com.tencent.mm.ac.d.h(new d(this, new n(i2, iResponse.getIncrementList(), false, 12), cVar, bVar, iResponse));
            AppMethodBeat.o(244957);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b
        public void mergeInsert(IResponse<T> iResponse, kotlin.g.a.b<? super IResponse<T>, x> bVar) {
            AppMethodBeat.i(244958);
            p.h(iResponse, "response");
            RefreshLoadMoreLayout.c.a aVar = RefreshLoadMoreLayout.c.Rms;
            RefreshLoadMoreLayout.c cVar = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.Rmo);
            cVar.jLE = true;
            cVar.Rmj = true;
            n nVar = new n(8, iResponse.getIncrementList(), false, 12);
            nVar.request = iResponse.getRequest();
            com.tencent.mm.ac.d.h(new c(this, nVar, cVar, bVar, iResponse));
            AppMethodBeat.o(244958);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b
        public int findMergeIndex(ArrayList<T> arrayList, List<? extends T> list, int i2, Object obj) {
            AppMethodBeat.i(244959);
            p.h(arrayList, "srcList");
            p.h(list, "newList");
            if (i2 == 1 || i2 == 5) {
                int size = BaseFeedLoader.this.getDataList().size();
                AppMethodBeat.o(244959);
                return size;
            } else if (i2 == 2 || i2 == 6 || i2 == 4) {
                AppMethodBeat.o(244959);
                return 0;
            } else {
                AppMethodBeat.o(244959);
                return 0;
            }
        }

        public void cleanDataList(DataBuffer<T> dataBuffer) {
            AppMethodBeat.i(244960);
            p.h(dataBuffer, "dataList");
            dataBuffer.clear();
            AppMethodBeat.o(244960);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b
        public k mergeDataAndNotify(int i2, List<? extends T> list, boolean z, Object obj) {
            boolean z2;
            AppMethodBeat.i(244961);
            if (list == null) {
                k kVar = new k(new LinkedList());
                AppMethodBeat.o(244961);
                return kVar;
            } else if (!z) {
                Log.i(BaseFeedLoader.this.getTAG(), "nothing need to notify, just return. cmd=" + i2 + " size =" + list.size());
                k kVar2 = new k(new LinkedList());
                AppMethodBeat.o(244961);
                return kVar2;
            } else {
                int size = BaseFeedLoader.this.getDataList().size();
                if ((i2 == 4 || i2 == 3 || i2 == 7) && needCleanWhenRefresh(list)) {
                    if ((!list.isEmpty()) || i2 == 7) {
                        cleanDataList(BaseFeedLoader.this.getDataList());
                        if (i2 == 4) {
                            BaseFeedLoader.this.dispatcher().onItemRangeRemoved(0, size);
                        }
                    }
                }
                k merge = merge(list, i2, obj);
                String tag = BaseFeedLoader.this.getTAG();
                StringBuilder append = new StringBuilder("mergeDataAndNotify insertIndex=").append(merge.tYC).append(" insertCount=").append(merge.tYD).append(" changeIndex=").append(merge.tYE).append(' ').append("size: ").append(BaseFeedLoader.this.getDataList().size()).append(" isRemoveBeforeInsert=").append(merge.tYF).append(" loader:").append(getClass().getSimpleName()).append(" cmd:");
                n.a aVar = n.tYR;
                Log.i(tag, append.append(n.a.IP(i2)).append('}').toString());
                if (!merge.tYE.isEmpty()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2 || merge.tYD > 0) {
                    if (i2 == 3 || i2 == 2 || i2 == 6 || i2 == 7) {
                        BaseFeedLoader.this.dispatcher().onChanged();
                    } else {
                        if (merge.tYF) {
                            d<T> dispatcher = BaseFeedLoader.this.dispatcher();
                            int i3 = merge.tYC;
                            dispatcher.onItemRangeRemoved(i3, size - i3);
                        }
                        BaseFeedLoader.this.dispatcher().onItemRangeInserted(merge.tYC, merge.tYD);
                    }
                    AppMethodBeat.o(244961);
                    return merge;
                }
                Log.i(BaseFeedLoader.this.getTAG(), "just change all. cmd=".concat(String.valueOf(i2)));
                BaseFeedLoader.this.dispatcher().onChanged();
                AppMethodBeat.o(244961);
                return merge;
            }
        }

        public static /* synthetic */ k merge$default(a aVar, List list, int i2, Object obj, int i3, Object obj2) {
            AppMethodBeat.i(244963);
            if (obj2 != null) {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: merge");
                AppMethodBeat.o(244963);
                throw unsupportedOperationException;
            }
            if ((i3 & 4) != 0) {
                obj = null;
            }
            k merge = aVar.merge(list, i2, obj);
            AppMethodBeat.o(244963);
            return merge;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader$a */
        /* JADX WARN: Multi-variable type inference failed */
        public final k merge(List<? extends T> list, int i2, Object obj) {
            AppMethodBeat.i(244962);
            p.h(list, "newList");
            printList("newList", i2, list);
            DataBuffer dataList = BaseFeedLoader.this.getDataList();
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            boolean z = false;
            for (T t : list) {
                int i3 = 0;
                Iterator it = dataList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i3 = -1;
                        break;
                    }
                    if (((i) it.next()).a(t) == 0) {
                        break;
                    }
                    i3++;
                }
                int i4 = 0;
                Iterator it2 = linkedList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        i4 = -1;
                        break;
                    }
                    if (((i) it2.next()).a(t) == 0) {
                        break;
                    }
                    i4++;
                }
                if (i3 == -1 && i4 == -1) {
                    linkedList.add(t);
                } else if (i3 != -1) {
                    dataList.set(i3, t);
                    boolean onDataReplace = onDataReplace(t, i3);
                    linkedList2.add(Integer.valueOf(i3));
                    z = onDataReplace;
                } else {
                    Log.w(BaseFeedLoader.this.getTAG(), "newList exist a same feed[" + ((i) linkedList.get(i4)) + "], just ignore this feed=" + ((Object) t) + " existIndex=" + i3 + " existIndexInIncrementList=" + i4);
                }
            }
            printList("incrementList", i2, linkedList);
            int i5 = 0;
            boolean z2 = false;
            if ((linkedList.size() > 0 || canFinallyHandleMergeList(i2) ? linkedList : null) != null) {
                int findMergeIndex = findMergeIndex(dataList, linkedList, i2, obj);
                z2 = finallyHandleMergeList(dataList, linkedList, findMergeIndex, i2, obj);
                Log.i(BaseFeedLoader.this.getTAG(), "merge list index " + findMergeIndex + " incrementList:" + linkedList.size() + " cmd=" + i2);
                dataList.addAll(findMergeIndex, linkedList);
                i5 = findMergeIndex;
            }
            k kVar = new k(i5, linkedList.size(), linkedList2, z2, z);
            printList("dataList", i2, BaseFeedLoader.this.getDataList());
            AppMethodBeat.o(244962);
            return kVar;
        }

        public boolean canFinallyHandleMergeList(int i2) {
            return false;
        }

        public boolean onDataReplace(T t, int i2) {
            AppMethodBeat.i(244965);
            p.h(t, "feed");
            AppMethodBeat.o(244965);
            return false;
        }

        /* renamed from: com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader$a$a */
        public static final class C1159a implements android.support.v7.h.d {
            final /* synthetic */ a tYc;

            C1159a(a aVar) {
                this.tYc = aVar;
            }

            @Override // android.support.v7.h.d
            public final void c(int i2, int i3, Object obj) {
                AppMethodBeat.i(244948);
                BaseFeedLoader.this.dispatcher().onItemRangeChanged(i2, i3, obj);
                AppMethodBeat.o(244948);
            }

            @Override // android.support.v7.h.d
            public final void l(int i2, int i3) {
            }

            @Override // android.support.v7.h.d
            public final void f(int i2, int i3) {
                AppMethodBeat.i(244949);
                BaseFeedLoader.this.dispatcher().onItemRangeInserted(i2, i3);
                AppMethodBeat.o(244949);
            }

            @Override // android.support.v7.h.d
            public final void k(int i2, int i3) {
                AppMethodBeat.i(244950);
                BaseFeedLoader.this.dispatcher().onItemRangeRemoved(i2, i3);
                AppMethodBeat.o(244950);
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b
        public android.support.v7.h.d getListUpdateCallback() {
            AppMethodBeat.i(244966);
            C1159a aVar = new C1159a(this);
            AppMethodBeat.o(244966);
            return aVar;
        }

        public final void printList(String str, int i2, List<? extends T> list) {
            AppMethodBeat.i(244967);
            p.h(str, "tag");
            p.h(list, "mmlist");
            if (getDEBUG()) {
                int i3 = 0;
                for (T t : list) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        kotlin.a.j.hxH();
                    }
                    String tag = BaseFeedLoader.this.getTAG();
                    StringBuilder append = new StringBuilder().append(str).append(" index ").append(i3).append(" cmd:");
                    n.a aVar = n.tYR;
                    Log.i(tag, append.append(n.a.IP(i2)).append(' ').append((Object) t).toString());
                    i3 = i4;
                }
            }
            AppMethodBeat.o(244967);
        }

        /* access modifiers changed from: package-private */
        public static final class b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ a tYc;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar, IResponse iResponse, kotlin.g.a.b bVar) {
                super(0);
                this.tYc = aVar;
                this.$response = iResponse;
                this.$next = bVar;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(244951);
                b.mergeDataAndNotify$default(BaseFeedLoader.this.getMerger(), 3, this.$response.getIncrementList(), true, null, 8, null);
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(244951);
                return xVar;
            }
        }

        static final class e extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ n $op;
            final /* synthetic */ RefreshLoadMoreLayout.c $reason;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ a tYc;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(a aVar, n nVar, RefreshLoadMoreLayout.c cVar, kotlin.g.a.b bVar, IResponse iResponse) {
                super(0);
                this.tYc = aVar;
                this.$op = nVar;
                this.$reason = cVar;
                this.$next = bVar;
                this.$response = iResponse;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(244954);
                this.tYc.convertOpToReason(this.$op, this.$reason);
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                BaseFeedLoader.this.dispatcher().onPreFinishRefresh(this.$reason);
                x xVar = x.SXb;
                AppMethodBeat.o(244954);
                return xVar;
            }
        }

        static final class d extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ n $op;
            final /* synthetic */ RefreshLoadMoreLayout.c $reason;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ a tYc;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(a aVar, n nVar, RefreshLoadMoreLayout.c cVar, kotlin.g.a.b bVar, IResponse iResponse) {
                super(0);
                this.tYc = aVar;
                this.$op = nVar;
                this.$reason = cVar;
                this.$next = bVar;
                this.$response = iResponse;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(244953);
                this.tYc.convertOpToReason(this.$op, this.$reason);
                BaseFeedLoader.this.dispatcher().f(this.$reason);
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(244953);
                return xVar;
            }
        }

        public static final class c extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ n $op;
            final /* synthetic */ RefreshLoadMoreLayout.c $reason;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ a tYc;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(a aVar, n nVar, RefreshLoadMoreLayout.c cVar, kotlin.g.a.b bVar, IResponse iResponse) {
                super(0);
                this.tYc = aVar;
                this.$op = nVar;
                this.$reason = cVar;
                this.$next = bVar;
                this.$response = iResponse;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(244952);
                this.tYc.convertOpToReason(this.$op, this.$reason);
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(244952);
                return xVar;
            }
        }

        public final void convertOpToReason(n<T> nVar, RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244964);
            p.h(nVar, "op");
            p.h(cVar, "reason");
            E e2 = (E) mergeDataAndNotify(nVar.EX, nVar.tYQ, nVar.isNeedClear, nVar.request);
            cVar.iMa = e2;
            cVar.Rmk = e2.tYD;
            AppMethodBeat.o(244964);
        }
    }

    public static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ BaseFeedLoader this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(BaseFeedLoader baseFeedLoader) {
            super(0);
            this.this$0 = baseFeedLoader;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(244974);
            this.this$0.getDataFetch().fetchInit(this.this$0);
            x xVar = x.SXb;
            AppMethodBeat.o(244974);
            return xVar;
        }
    }

    public static final class k extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f tVx;
        final /* synthetic */ BaseFeedLoader this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(BaseFeedLoader baseFeedLoader, f fVar) {
            super(0);
            this.this$0 = baseFeedLoader;
            this.tVx = fVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(244977);
            this.this$0.getDataFetch().fetchPreload(new f<T>(this) {
                /* class com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.k.AnonymousClass1 */
                final /* synthetic */ k tYd;

                {
                    this.tYd = r1;
                }

                @Override // com.tencent.mm.plugin.finder.feed.model.internal.f
                public final void onFetchDone(IResponse<T> iResponse) {
                    AppMethodBeat.i(244976);
                    p.h(iResponse, "response");
                    j jVar = this.tYd.this$0.preload;
                    if (jVar != null) {
                        jVar.a(iResponse);
                    }
                    f fVar = this.tYd.tVx;
                    if (fVar != null) {
                        fVar.onFetchDone(iResponse);
                        AppMethodBeat.o(244976);
                        return;
                    }
                    AppMethodBeat.o(244976);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(244977);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b extends q implements kotlin.g.a.a<g<T>> {
        final /* synthetic */ BaseFeedLoader this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(BaseFeedLoader baseFeedLoader) {
            super(0);
            this.this$0 = baseFeedLoader;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(166096);
            g<T> createDataFetch = this.this$0.createDataFetch();
            AppMethodBeat.o(166096);
            return createDataFetch;
        }
    }
}
