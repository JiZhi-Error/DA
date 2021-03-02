package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.upload.q;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\b\u000b\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016H\u0016J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016H\u0016J\u0018\u0010#\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020 H\u0016J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0016\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u0016J\u0016\u0010)\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010(\u001a\u00020\u0016J\b\u0010+\u001a\u00020\u0010H\u0016J \u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.2\u0006\u0010(\u001a\u00020\u00162\b\b\u0002\u0010/\u001a\u00020\u0016J\u001a\u00100\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010/\u001a\u00020\u0016H\u0004J\"\u00100\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u00101\u001a\u00020 2\b\b\u0002\u0010/\u001a\u00020\u0016H\u0004R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010\r\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "feedChangeListener", "com/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader$feedChangeListener$1;", "feedDeleteListener", "com/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader$feedDeleteListener$1;", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "isObservePostEvent", "onAlive", "onDead", "onPostEnd", ch.COL_LOCALID, "", "isOk", "onPostNotify", "onPostOk", "svrID", "onPostStart", "remove", "finderFeedId", "notify", "removeLocal", "", "requestLoadMore", "updateByLocalId", "newFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isPostUpdate", "updateItem", "svrId", "plugin-finder_release"})
public abstract class BaseMegaVideoLoader extends BaseFeedLoader<bo> implements q {
    public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
    public boolean hasMore = true;
    private final b uKF = new b(this);
    private final a uKG = new a(this);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.finder.feed.model.internal.IResponse] */
    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public void onFetchDone(IResponse<bo> iResponse) {
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(iResponse);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, bVar.axR());
        super.onFetchDone(iResponse);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    }

    public BaseMegaVideoLoader(bbn bbn) {
        super(bbn);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public void onAlive() {
        super.onAlive();
        this.uKG.alive();
        this.uKF.alive();
        if (isObservePostEvent()) {
            g.a aVar = g.vSJ;
            g.vSH.a(this);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public void onDead() {
        super.onDead();
        this.uKG.dead();
        this.uKF.dead();
        if (isObservePostEvent()) {
            g.a aVar = g.vSJ;
            g.vSH.b(this);
        }
    }

    public boolean isObservePostEvent() {
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public void requestLoadMore() {
        if (this.hasMore) {
            super.requestLoadMore();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader$feedDeleteListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedDeleteEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class b extends IListener<hg> {
        final /* synthetic */ BaseMegaVideoLoader uKH;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(BaseMegaVideoLoader baseMegaVideoLoader) {
            this.uKH = baseMegaVideoLoader;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hg hgVar) {
            AppMethodBeat.i(248366);
            hg hgVar2 = hgVar;
            if (hgVar2 != null) {
                d.h(new a(hgVar2, this, hgVar2));
            }
            AppMethodBeat.o(248366);
            return false;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader$feedDeleteListener$1$callback$1$1"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ hg $event$inlined;
            final /* synthetic */ hg uKJ;
            final /* synthetic */ b uKK;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(hg hgVar, b bVar, hg hgVar2) {
                super(0);
                this.uKJ = hgVar;
                this.uKK = bVar;
                this.$event$inlined = hgVar2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                FinderItem finderItem;
                AppMethodBeat.i(248365);
                if (this.$event$inlined.dLJ.id != 0) {
                    this.uKK.uKH.ER(this.$event$inlined.dLJ.id);
                }
                if (this.uKJ.dLJ.localId != 0) {
                    BaseMegaVideoLoader baseMegaVideoLoader = this.uKK.uKH;
                    long j2 = this.uKJ.dLJ.localId;
                    if (j2 > 0) {
                        Iterator it = baseMegaVideoLoader.getDataList().iterator();
                        int i2 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i2 = -1;
                                break;
                            }
                            bo boVar = (bo) it.next();
                            if ((boVar instanceof bm) && (finderItem = ((bm) boVar).uOW) != null && finderItem.getLocalId() == j2) {
                                break;
                            }
                            i2++;
                        }
                        if (i2 != -1) {
                            baseMegaVideoLoader.getDataList().remove(i2);
                            baseMegaVideoLoader.dispatcher().onItemRangeRemoved(i2, 1);
                        }
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(248365);
                return xVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader$feedChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class a extends IListener<hn> {
        final /* synthetic */ BaseMegaVideoLoader uKH;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(BaseMegaVideoLoader baseMegaVideoLoader) {
            this.uKH = baseMegaVideoLoader;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hn hnVar) {
            AppMethodBeat.i(248364);
            hn hnVar2 = hnVar;
            p.h(hnVar2, "event");
            d.a(0, new C1217a(this, hnVar2));
            AppMethodBeat.o(248364);
            return true;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader$a$a  reason: collision with other inner class name */
        static final class C1217a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ hn $event;
            final /* synthetic */ a uKI;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1217a(a aVar, hn hnVar) {
                super(0);
                this.uKI = aVar;
                this.$event = hnVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                int i2;
                int i3;
                boolean z;
                int i4;
                int i5;
                boolean z2;
                boolean z3;
                AppMethodBeat.i(248363);
                Log.i(this.uKI.uKH.getTAG(), "feedChangeListener " + this.$event.dLW.id + ",fav = " + this.$event.dLW.dLX + ',' + "like = " + this.$event.dLW.dLZ + ",likeCount = " + this.$event.dLW.likeCount + " ,needChangeData = " + this.$event.dLW.dLY);
                switch (this.$event.dLW.type) {
                    case 0:
                        if (this.$event.dLW.id != 0) {
                            Iterator it = this.uKI.uKH.getDataList().iterator();
                            int i6 = 0;
                            while (true) {
                                if (it.hasNext()) {
                                    bo boVar = (bo) it.next();
                                    if (!(boVar instanceof bm) || ((bm) boVar).dkW() != this.$event.dLW.id) {
                                        z3 = false;
                                    } else {
                                        z3 = true;
                                    }
                                    if (!z3) {
                                        i6++;
                                    }
                                } else {
                                    i6 = -1;
                                }
                            }
                            if (i6 != -1) {
                                Object obj = this.uKI.uKH.getDataList().get(i6);
                                if (obj != null) {
                                    bm bmVar = (bm) obj;
                                    e.a aVar = e.vFX;
                                    FinderObject FD = e.a.FD(bmVar.lT());
                                    if (FD != null) {
                                        bmVar.g(FD);
                                        if (this.$event.dLW.dMa == 0) {
                                            this.uKI.uKH.dispatcher().onItemRangeChanged(i6, 1, new o(0, 1));
                                            break;
                                        }
                                    }
                                } else {
                                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.MegaVideoFeed");
                                    AppMethodBeat.o(248363);
                                    throw tVar;
                                }
                            }
                        }
                        break;
                    case 4:
                        Iterator it2 = this.uKI.uKH.getDataList().iterator();
                        int i7 = 0;
                        while (true) {
                            if (it2.hasNext()) {
                                bo boVar2 = (bo) it2.next();
                                if (!(boVar2 instanceof bm) || ((bm) boVar2).dkW() != this.$event.dLW.id) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                if (z2) {
                                    i4 = i7;
                                } else {
                                    i7++;
                                }
                            } else {
                                i4 = -1;
                            }
                        }
                        if (i4 != -1) {
                            int i8 = this.$event.dLW.dLZ;
                            Object obj2 = this.uKI.uKH.getDataList().get(i4);
                            if (obj2 != null) {
                                bm bmVar2 = (bm) obj2;
                                if ((bmVar2.getFeedObject().likeFlag != i8) && this.$event.dLW.dLY == 1) {
                                    bmVar2.getFeedObject().likeFlag = i8;
                                    int i9 = bmVar2.getFeedObject().likeCount;
                                    cng cng = bmVar2.tuP;
                                    if (cng == null || cng.likeFlag != 0) {
                                        i5 = i9 + 1;
                                    } else {
                                        i5 = i9 - 1;
                                    }
                                    FinderObject feedObject = bmVar2.getFeedObject();
                                    if (i5 < 0) {
                                        i5 = 0;
                                    }
                                    feedObject.likeCount = i5;
                                }
                                this.uKI.uKH.dispatcher().onItemRangeChanged(i4, 1, new o(1, 1));
                                break;
                            } else {
                                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.MegaVideoFeed");
                                AppMethodBeat.o(248363);
                                throw tVar2;
                            }
                        }
                        break;
                    case 5:
                        Iterator it3 = this.uKI.uKH.getDataList().iterator();
                        int i10 = 0;
                        while (true) {
                            if (it3.hasNext()) {
                                bo boVar3 = (bo) it3.next();
                                if (!(boVar3 instanceof bm) || ((bm) boVar3).dkW() != this.$event.dLW.id) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    i2 = i10;
                                } else {
                                    i10++;
                                }
                            } else {
                                i2 = -1;
                            }
                        }
                        if (i2 != -1) {
                            int i11 = this.$event.dLW.dLX == 1 ? 1 : 0;
                            Object obj3 = this.uKI.uKH.getDataList().get(i2);
                            if (obj3 != null) {
                                bm bmVar3 = (bm) obj3;
                                if ((bmVar3.getFeedObject().favFlag != i11) && this.$event.dLW.dLY == 1) {
                                    bmVar3.getFeedObject().favFlag = i11;
                                    int i12 = bmVar3.getFeedObject().favCount;
                                    if (bmVar3.getFeedObject().favFlag == 1) {
                                        i3 = i12 + 1;
                                    } else {
                                        i3 = i12 - 1;
                                    }
                                    FinderObject feedObject2 = bmVar3.getFeedObject();
                                    if (i3 < 0) {
                                        i3 = 0;
                                    }
                                    feedObject2.favCount = i3;
                                }
                                this.uKI.uKH.dispatcher().onItemRangeChanged(i2, 1, new o(2, 1));
                                break;
                            } else {
                                t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.MegaVideoFeed");
                                AppMethodBeat.o(248363);
                                throw tVar3;
                            }
                        }
                        break;
                }
                x xVar = x.SXb;
                AppMethodBeat.o(248363);
                return xVar;
            }
        }
    }

    public final long ER(long j2) {
        boolean z;
        Iterator it = getDataList().iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            bo boVar = (bo) it.next();
            if (!(boVar instanceof bm) || ((bm) boVar).dkW() != j2) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                break;
            }
            i2++;
        }
        bm bmVar = null;
        if (i2 != -1) {
            Object remove = getDataList().remove(i2);
            if (remove == null) {
                throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.MegaVideoFeed");
            }
            bmVar = (bm) remove;
            dispatcher().onItemRangeRemoved(i2, 1);
        }
        if (bmVar != null) {
            return bmVar.lT();
        }
        return 0;
    }

    @Override // com.tencent.mm.plugin.finder.upload.q
    public void onPostStart(long j2) {
        cng cng;
        c.a aVar = c.vGN;
        FinderItem FS = c.a.FS(j2);
        if (FS != null) {
            cng = FS.getMegaVideo();
        } else {
            cng = null;
        }
        if (cng != null && FS != null) {
            ArrayList arrayList = new ArrayList();
            Log.i(getTAG(), "onPostStart localId ".concat(String.valueOf(j2)));
            bm bmVar = new bm(FS.getFeedObject());
            bmVar.uOW = FS;
            arrayList.add(bmVar);
            com.tencent.mm.plugin.finder.feed.model.internal.b.mergeDataAndNotify$default(getMerger(), 2, arrayList, true, null, 8, null);
        }
    }

    @Override // com.tencent.mm.plugin.finder.upload.q
    public void onPostEnd(long j2, boolean z) {
        ES(j2);
    }

    @Override // com.tencent.mm.plugin.finder.upload.q
    public void onPostNotify(long j2, boolean z) {
        ES(j2);
    }

    private void ES(long j2) {
        c.a aVar = c.vGN;
        FinderItem FS = c.a.FS(j2);
        if (FS != null) {
            Log.i(getTAG(), "updateItem localId:" + j2 + " itemLoadId:" + FS.getLocalId() + " itemId:" + FS.getId());
            c(FS);
        }
    }

    private void c(FinderItem finderItem) {
        p.h(finderItem, "newFeed");
        if (finderItem.getLocalId() > 0) {
            int i2 = 0;
            for (Object obj : getDataList()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                bo boVar = (bo) obj;
                if (boVar instanceof bm) {
                    FinderItem finderItem2 = ((bm) boVar).uOW;
                    if (finderItem2 == null) {
                        i2 = i3;
                    } else if (finderItem2.getLocalId() == finderItem.getLocalId()) {
                        ((bm) boVar).uOW = finderItem;
                        ((bm) boVar).g(finderItem.getFeedObject());
                        Log.i(getTAG(), "updateByLocalId " + finderItem.getLocalId());
                        dispatcher().onItemRangeChanged(i2, 1, new o(4, 1));
                        return;
                    }
                }
                i2 = i3;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.upload.q
    public void onPostOk(long j2, long j3) {
        e.a aVar = e.vFX;
        FinderItem Fy = e.a.Fy(j3);
        if (Fy != null) {
            Fy.setLocalId(j2);
        }
        if (Fy != null) {
            Log.i(getTAG(), "updateItem localId:" + j2 + " itemLoadId:" + Fy.getLocalId() + " itemId:" + Fy.getId());
            c(Fy);
        }
    }
}
