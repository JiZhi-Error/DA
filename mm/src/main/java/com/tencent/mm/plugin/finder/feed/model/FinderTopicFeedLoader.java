package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.finder.cgi.ax;
import com.tencent.mm.plugin.finder.cgi.bk;
import com.tencent.mm.plugin.finder.cgi.bs;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atv;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dcz;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

public class FinderTopicFeedLoader extends BaseFinderFeedLoader {
    public int UIB = -1;
    private final String dST;
    boolean isLoadingMore;
    public String tTG = "";
    public int tTH;
    public String tTQ = "";
    public volatile d tXJ;
    private com.tencent.mm.bw.b tXK;
    private a tXL = new a();
    public axt tXM;
    public Long tXN;
    public kotlin.g.a.a<x> tXO;
    public bcc tvs;
    public long twd;
    final int type;
    private String userName = "";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderTopicFeedLoader(int i2, String str, bbn bbn) {
        super(bbn);
        p.h(str, "topic");
        AppMethodBeat.i(244933);
        this.type = i2;
        this.dST = str;
        AppMethodBeat.o(244933);
    }

    public final com.tencent.mm.bw.b atr(String str) {
        AppMethodBeat.i(244924);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            com.tencent.mm.bw.b lastBuffer = getLastBuffer();
            AppMethodBeat.o(244924);
            return lastBuffer;
        }
        com.tencent.mm.bw.b bVar = this.tXK;
        AppMethodBeat.o(244924);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
    public boolean isObservePostEvent() {
        AppMethodBeat.i(244925);
        if (this.type == 4 || this.type == 7) {
            AppMethodBeat.o(244925);
            return true;
        }
        boolean isObservePostEvent = super.isObservePostEvent();
        AppMethodBeat.o(244925);
        return isObservePostEvent;
    }

    private void a(String str, com.tencent.mm.bw.b bVar) {
        AppMethodBeat.i(244926);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            setLastBuffer(bVar);
            AppMethodBeat.o(244926);
            return;
        }
        this.tXK = bVar;
        AppMethodBeat.o(244926);
    }

    public static /* synthetic */ void a(FinderTopicFeedLoader finderTopicFeedLoader, int i2) {
        AppMethodBeat.i(260254);
        finderTopicFeedLoader.a(i2, null, -1);
        AppMethodBeat.o(260254);
    }

    public final void a(int i2, dmk dmk, int i3) {
        String str;
        LinkedList<bds> linkedList;
        bds bds;
        AppMethodBeat.i(244927);
        String tag = getTAG();
        StringBuilder sb = new StringBuilder("requestRefresh tag: ");
        if (dmk == null || (linkedList = dmk.MPW) == null || (bds = linkedList.get(0)) == null || (str = bds.dST) == null) {
            str = BuildConfig.COMMAND;
        }
        Log.d(tag, sb.append(str).append("  topic:").append(this.dST).append(" innerTabType:").append(this.tTH).append(" this:").append(this).toString());
        c cVar = new c(this.type, this.dST, this.tTG, this.twd, this.tTQ, this.tTH, this.tXM, this.tXN, this.tvs, this.userName, i2, dmk, i3, getContextObj());
        cVar.ddB();
        BaseFeedLoader.request$default(this, cVar, null, 2, null);
        this.tXJ = cVar;
        AppMethodBeat.o(244927);
    }

    public static /* synthetic */ void b(FinderTopicFeedLoader finderTopicFeedLoader, int i2) {
        AppMethodBeat.i(260255);
        finderTopicFeedLoader.a(i2, (dmk) null);
        AppMethodBeat.o(260255);
    }

    public final void a(int i2, dmk dmk) {
        String str;
        LinkedList<bds> linkedList;
        bds bds;
        LinkedList<bds> linkedList2;
        bds bds2;
        AppMethodBeat.i(244929);
        if (this.isLoadingMore) {
            Log.d(getTAG(), "already load more,return");
            AppMethodBeat.o(244929);
            return;
        }
        this.isLoadingMore = true;
        com.tencent.mm.bw.b atr = atr((dmk == null || (linkedList2 = dmk.MPW) == null || (bds2 = linkedList2.get(0)) == null) ? null : bds2.dST);
        String tag = getTAG();
        StringBuilder sb = new StringBuilder("requestLoadMore tag: ");
        if (dmk == null || (linkedList = dmk.MPW) == null || (bds = linkedList.get(0)) == null || (str = bds.dST) == null) {
            str = BuildConfig.COMMAND;
        }
        Log.d(tag, sb.append(str).append("  topic:").append(this.dST).append(" innerTabType:").append(this.tTH).toString());
        b bVar = new b(this.type, this.dST, this.tTG, this.twd, this.tTQ, this.tTH, this.tXM, this.tXN, atr, this.tvs, this.userName, i2, dmk, getContextObj());
        bVar.ddB();
        BaseFeedLoader.request$default(this, bVar, null, 2, null);
        this.tXJ = bVar;
        AppMethodBeat.o(244929);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public void onSaveLastBuffer(IResponse<bo> iResponse) {
        AppMethodBeat.i(244931);
        p.h(iResponse, "response");
        AppMethodBeat.o(244931);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public void onFetchDone(IResponse<bo> iResponse) {
        Integer num;
        byte[] bArr;
        String mD5String;
        byte[] bArr2;
        String mD5String2;
        LinkedList<bds> linkedList;
        bds bds;
        LinkedList<bds> linkedList2;
        bds bds2;
        LinkedList<bds> linkedList3;
        bds bds3;
        String str = null;
        AppMethodBeat.i(166066);
        p.h(iResponse, "response");
        String tag = getTAG();
        Object[] objArr = new Object[1];
        List<bo> incrementList = iResponse.getIncrementList();
        objArr[0] = incrementList != null ? Integer.valueOf(incrementList.size()) : null;
        Log.i(tag, "onFetchDone %d feeds", objArr);
        if (iResponse instanceof e) {
            String tag2 = getTAG();
            StringBuilder sb = new StringBuilder("incrementCount ");
            List<bo> incrementList2 = iResponse.getIncrementList();
            if (incrementList2 != null) {
                num = Integer.valueOf(incrementList2.size());
            } else {
                num = null;
            }
            StringBuilder append = sb.append(num).append(", totalCount ").append(((e) iResponse).tTn).append(", lastBuffer ");
            if (getLastBuffer() == null) {
                mD5String = BuildConfig.COMMAND;
            } else {
                com.tencent.mm.bw.b lastBuffer = getLastBuffer();
                if (lastBuffer != null) {
                    bArr = lastBuffer.zy;
                } else {
                    bArr = null;
                }
                mD5String = MD5Util.getMD5String(bArr);
            }
            StringBuilder append2 = append.append(mD5String).append(", resp buffer ");
            if (iResponse.getLastBuffer() == null) {
                mD5String2 = BuildConfig.COMMAND;
            } else {
                com.tencent.mm.bw.b lastBuffer2 = iResponse.getLastBuffer();
                if (lastBuffer2 != null) {
                    bArr2 = lastBuffer2.zy;
                } else {
                    bArr2 = null;
                }
                mD5String2 = MD5Util.getMD5String(bArr2);
            }
            Log.i(tag2, append2.append(mD5String2).toString());
            if (this.tXJ instanceof c) {
                d dVar = this.tXJ;
                if (dVar == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
                    AppMethodBeat.o(166066);
                    throw tVar;
                }
                dmk dmk = ((c) dVar).tUb;
                a((dmk == null || (linkedList3 = dmk.MPW) == null || (bds3 = linkedList3.get(0)) == null) ? null : bds3.dST, iResponse.getLastBuffer());
            } else if (this.tXJ instanceof b) {
                d dVar2 = this.tXJ;
                if (dVar2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicLoadMoreRequest");
                    AppMethodBeat.o(166066);
                    throw tVar2;
                }
                dmk dmk2 = ((b) dVar2).tUb;
                a((dmk2 == null || (linkedList = dmk2.MPW) == null || (bds = linkedList.get(0)) == null) ? null : bds.dST, iResponse.getLastBuffer());
            }
            if (this.tXJ instanceof c) {
                d dVar3 = this.tXJ;
                if (dVar3 == null) {
                    t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
                    AppMethodBeat.o(166066);
                    throw tVar3;
                } else if (((c) dVar3).pullType != -1) {
                    d dVar4 = this.tXJ;
                    if (dVar4 == null) {
                        t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
                        AppMethodBeat.o(166066);
                        throw tVar4;
                    }
                    iResponse.setPullType(((c) dVar4).pullType);
                } else {
                    iResponse.setPullType(1);
                }
            } else {
                iResponse.setPullType(2);
                this.isLoadingMore = false;
            }
            Log.i(getTAG(), "resp tag: " + ((e) iResponse).tag);
            if (this.tXJ instanceof c) {
                d dVar5 = this.tXJ;
                if (dVar5 == null) {
                    t tVar5 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicRefreshRequest");
                    AppMethodBeat.o(166066);
                    throw tVar5;
                }
                dmk dmk3 = ((c) dVar5).tUb;
                if (!(dmk3 == null || (linkedList2 = dmk3.MPW) == null || (bds2 = linkedList2.get(0)) == null)) {
                    str = bds2.dST;
                }
                String str2 = str;
                if (!(str2 == null || str2.length() == 0)) {
                    String str3 = ((e) iResponse).tag;
                    if (str3 == null || str3.equals(str)) {
                        kotlin.g.a.a<x> aVar = this.tXO;
                        if (aVar != null) {
                            aVar.invoke();
                        }
                    } else {
                        Log.i(getTAG(), "resp tag: " + ((e) iResponse).tag + " ,not match current tag " + str + ",return");
                        AppMethodBeat.o(166066);
                        return;
                    }
                } else {
                    kotlin.g.a.a<x> aVar2 = this.tXO;
                    if (aVar2 != null) {
                        aVar2.invoke();
                    }
                }
            }
        }
        super.onFetchDone(iResponse);
        AppMethodBeat.o(166066);
    }

    public static final class f extends BaseFeedLoader<bo>.a {
        final /* synthetic */ FinderTopicFeedLoader tXQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FinderTopicFeedLoader finderTopicFeedLoader) {
            super();
            this.tXQ = finderTopicFeedLoader;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.tencent.mm.plugin.finder.feed.model.internal.IResponse<com.tencent.mm.plugin.finder.model.bo> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void mergeRefresh(IResponse<bo> iResponse, kotlin.g.a.b<? super IResponse<bo>, x> bVar) {
            int i2 = 3;
            AppMethodBeat.i(244921);
            p.h(iResponse, "response");
            RefreshLoadMoreLayout.c cVar = new RefreshLoadMoreLayout.c(iResponse.getPullType() == 1 ? 3 : 4);
            if (iResponse.getPullType() != 1) {
                i2 = 4;
            }
            n nVar = new n(i2, iResponse.getIncrementList(), false, 12);
            cVar.Rmj = iResponse.getHasMore();
            cVar.tXF = iResponse;
            com.tencent.mm.ac.d.h(new b(this, nVar, cVar, bVar, iResponse));
            AppMethodBeat.o(244921);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.tencent.mm.plugin.finder.feed.model.internal.IResponse<com.tencent.mm.plugin.finder.model.bo> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final void mergeLoadMore(IResponse<bo> iResponse, kotlin.g.a.b<? super IResponse<bo>, x> bVar) {
            boolean z;
            int i2 = 1;
            AppMethodBeat.i(244922);
            p.h(iResponse, "response");
            RefreshLoadMoreLayout.c.a aVar = RefreshLoadMoreLayout.c.Rms;
            RefreshLoadMoreLayout.c cVar = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.Rmn);
            List incrementList = iResponse.getIncrementList();
            if (incrementList != null) {
                z = incrementList.isEmpty();
            } else {
                z = true;
            }
            cVar.jLE = z;
            cVar.Rmj = iResponse.getHasMore();
            cVar.tXF = iResponse;
            if (!iResponse.getHasMore()) {
                i2 = 5;
            }
            com.tencent.mm.ac.d.h(new a(this, new n(i2, iResponse.getIncrementList(), false, 12), cVar, bVar, iResponse));
            AppMethodBeat.o(244922);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
        public final int findMergeIndex(ArrayList<bo> arrayList, List<? extends bo> list, int i2, Object obj) {
            AppMethodBeat.i(244923);
            p.h(arrayList, "srcList");
            p.h(list, "newList");
            if (this.tXQ.type == 4 && list.size() == 1 && (list.get(0) instanceof BaseFinderFeed)) {
                Object obj2 = list.get(0);
                if (obj2 == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                    AppMethodBeat.o(244923);
                    throw tVar;
                } else if (((BaseFinderFeed) obj2).feedObject.getFeedObject().id == 0) {
                    AppMethodBeat.o(244923);
                    return 1;
                }
            }
            int findMergeIndex = super.findMergeIndex(arrayList, list, i2, obj);
            AppMethodBeat.o(244923);
            return findMergeIndex;
        }

        static final class b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ n $op;
            final /* synthetic */ RefreshLoadMoreLayout.c $reason;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ f tXT;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(f fVar, n nVar, RefreshLoadMoreLayout.c cVar, kotlin.g.a.b bVar, IResponse iResponse) {
                super(0);
                this.tXT = fVar;
                this.$op = nVar;
                this.$reason = cVar;
                this.$next = bVar;
                this.$response = iResponse;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(244920);
                this.tXT.convertOpToReason(this.$op, this.$reason);
                this.tXT.tXQ.dispatcher().onPreFinishRefresh(this.$reason);
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(244920);
                return xVar;
            }
        }

        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b $next;
            final /* synthetic */ n $op;
            final /* synthetic */ RefreshLoadMoreLayout.c $reason;
            final /* synthetic */ IResponse $response;
            final /* synthetic */ f tXT;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(f fVar, n nVar, RefreshLoadMoreLayout.c cVar, kotlin.g.a.b bVar, IResponse iResponse) {
                super(0);
                this.tXT = fVar;
                this.$op = nVar;
                this.$reason = cVar;
                this.$next = bVar;
                this.$response = iResponse;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(244919);
                this.tXT.convertOpToReason(this.$op, this.$reason);
                this.tXT.tXQ.dispatcher().f(this.$reason);
                kotlin.g.a.b bVar = this.$next;
                if (bVar != null) {
                    bVar.invoke(this.$response);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(244919);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger() {
        AppMethodBeat.i(244932);
        f fVar = new f(this);
        AppMethodBeat.o(244932);
        return fVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public void requestRefresh() {
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public void requestLoadMore() {
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public g<bo> createDataFetch() {
        return this.tXL;
    }

    public static final class e extends IResponse<bo> {
        public int cSx;
        public final bds dMU;
        public azk musicInfo;
        public String oqZ;
        public long tTn;
        public int tTo;
        public dmk tXS = new dmk();
        String tag;

        public e(int i2, int i3, bds bds, String str) {
            super(i2, i3, str);
            AppMethodBeat.i(244918);
            this.dMU = bds;
            AppMethodBeat.o(244918);
        }
    }

    public final class a extends g<bo> implements i {
        private HashSet<com.tencent.mm.ak.q> UIC = new HashSet<>();
        private com.tencent.mm.plugin.finder.feed.model.internal.f<bo> tXP;

        public a() {
            FinderTopicFeedLoader.this = r3;
            AppMethodBeat.i(260253);
            AppMethodBeat.o(260253);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetchRefresh(com.tencent.mm.plugin.finder.feed.model.internal.f<bo> fVar) {
            AppMethodBeat.i(244909);
            p.h(fVar, "callback");
            AppMethodBeat.o(244909);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.f<bo> fVar) {
            AppMethodBeat.i(244910);
            p.h(fVar, "callback");
            AppMethodBeat.o(244910);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.f<bo> fVar) {
            AppMethodBeat.i(244911);
            p.h(fVar, "callback");
            fVar.onFetchDone(new com.tencent.mm.plugin.finder.feed.model.internal.c());
            AppMethodBeat.o(244911);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void fetch(Object obj, com.tencent.mm.plugin.finder.feed.model.internal.f<bo> fVar) {
            AppMethodBeat.i(244912);
            p.h(fVar, "callback");
            if (obj instanceof d) {
                this.tXP = fVar;
                ((d) obj).call();
                this.UIC.add(((d) obj).tXR);
            }
            AppMethodBeat.o(244912);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void alive() {
            AppMethodBeat.i(244913);
            super.alive();
            FinderTopicFeedLoader.this.isLoadingMore = false;
            com.tencent.mm.kernel.g.azz().a(817, this);
            AppMethodBeat.o(244913);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.g
        public final void dead() {
            AppMethodBeat.i(244914);
            super.dead();
            com.tencent.mm.kernel.g.azz().b(817, this);
            AppMethodBeat.o(244914);
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(244915);
            Log.i(getTAG(), "errType " + i2 + ", errCode " + i3 + ", errMsg " + str + " activeTabType:" + FinderTopicFeedLoader.this.UIB + " innerTabType:" + FinderTopicFeedLoader.this.tTH);
            if (FinderTopicFeedLoader.this.type == 7) {
                if (FinderTopicFeedLoader.this.UIB == -1 || FinderTopicFeedLoader.this.UIB == FinderTopicFeedLoader.this.tTH) {
                    if (qVar != null) {
                        k(i2, i3, str, qVar);
                        AppMethodBeat.o(244915);
                        return;
                    }
                    AppMethodBeat.o(244915);
                    return;
                }
            } else if (qVar != null) {
                k(i2, i3, str, qVar);
            }
            AppMethodBeat.o(244915);
        }

        private final void k(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            String str2;
            int i4;
            int i5;
            List incrementList;
            bo boVar;
            int i6;
            azk azk = null;
            int i7 = 0;
            AppMethodBeat.i(260252);
            if (qVar instanceof bs) {
                boolean remove = this.UIC.remove(qVar);
                Log.i(getTAG(), "isRemoved :".concat(String.valueOf(remove)));
                if (!remove) {
                    AppMethodBeat.o(260252);
                    return;
                }
                if (FinderTopicFeedLoader.this.type == 7) {
                    if (((bs) qVar).hSG() == 7 && ((bs) qVar).getTabType() != FinderTopicFeedLoader.this.tTH) {
                        Log.i(getTAG(), "activity request ignore not my tab innerTabType:" + FinderTopicFeedLoader.this.tTH + "  tabType: " + ((bs) qVar).getTabType());
                        AppMethodBeat.o(260252);
                        return;
                    } else if (((bs) qVar).hSG() != 7) {
                        Log.i(getTAG(), "other type request if current is activity ignore!! innerTabType:" + FinderTopicFeedLoader.this.tTH + "  tabType: " + ((bs) qVar).getTabType());
                        AppMethodBeat.o(260252);
                        return;
                    }
                }
                e eVar = new e(i2, i3, ((bs) qVar).cYJ(), str);
                if (i2 == 0 && i3 == 0) {
                    eVar.setLastBuffer(((bs) qVar).cYz());
                    eVar.tTn = ((bs) qVar).cYI();
                    LinkedList<FinderObject> cYH = ((bs) qVar).cYH();
                    ArrayList arrayList = new ArrayList(j.a(cYH, 10));
                    Iterator<T> it = cYH.iterator();
                    while (it.hasNext()) {
                        FinderItem.a aVar = FinderItem.Companion;
                        FinderItem a2 = FinderItem.a.a((FinderObject) it.next(), 64);
                        FinderTopicFeedUI.a aVar2 = FinderTopicFeedUI.udw;
                        FinderTopicFeedUI.tZo.put(Long.valueOf(a2.getId()), a2);
                        c.a aVar3 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                        arrayList.add(c.a.s(a2));
                    }
                    eVar.setIncrementList(arrayList);
                    if (((bs) qVar).tvC == 4) {
                        List incrementList2 = eVar.getIncrementList();
                        if (incrementList2 != null) {
                            i5 = incrementList2.size();
                        } else {
                            i5 = 0;
                        }
                        if (!(i5 <= 0 || (incrementList = eVar.getIncrementList()) == null || (boVar = (bo) incrementList.get(0)) == null)) {
                            if (boVar == null) {
                                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                                AppMethodBeat.o(260252);
                                throw tVar;
                            }
                            BaseFinderFeed baseFinderFeed = (BaseFinderFeed) boVar;
                            String zs = com.tencent.mm.ac.d.zs(((BaseFinderFeed) boVar).feedObject.field_id);
                            bdr bgmInfo = ((bs) qVar).getBgmInfo();
                            if (bgmInfo == null || (i6 = bgmInfo.groupId) == null) {
                                i6 = 0;
                            }
                            baseFinderFeed.isOriginFeed = p.j(zs, i6);
                        }
                    }
                    eVar.setPullType(((bs) qVar).pullType);
                    eVar.setHasMore(((bs) qVar).cYA() != 0);
                    com.tencent.mm.bw.a aYK = ((bs) qVar).rr.aYK();
                    if (aYK == null) {
                        t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
                        AppMethodBeat.o(260252);
                        throw tVar2;
                    }
                    eVar.tXS = ((atv) aYK).tTT;
                    com.tencent.mm.bw.a aYK2 = ((bs) qVar).rr.aYK();
                    if (aYK2 == null) {
                        t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
                        AppMethodBeat.o(260252);
                        throw tVar3;
                    }
                    dcz dcz = ((atv) aYK2).LEI;
                    if (dcz != null) {
                        str2 = dcz.MIg;
                    } else {
                        str2 = null;
                    }
                    eVar.oqZ = str2;
                    com.tencent.mm.bw.a aYK3 = ((bs) qVar).rr.aYK();
                    if (aYK3 == null) {
                        t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
                        AppMethodBeat.o(260252);
                        throw tVar4;
                    }
                    bds bds = ((atv) aYK3).LEG;
                    if (bds != null) {
                        azk = bds.LJj;
                    }
                    eVar.musicInfo = azk;
                    eVar.setBgmInfo(((bs) qVar).getBgmInfo());
                    com.tencent.mm.bw.a aYK4 = ((bs) qVar).rr.aYK();
                    if (aYK4 == null) {
                        t tVar5 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
                        AppMethodBeat.o(260252);
                        throw tVar5;
                    }
                    bds bds2 = ((atv) aYK4).LEG;
                    if (bds2 != null) {
                        i4 = bds2.LNx;
                    } else {
                        i4 = 0;
                    }
                    eVar.cSx = i4;
                    com.tencent.mm.bw.a aYK5 = ((bs) qVar).rr.aYK();
                    if (aYK5 == null) {
                        t tVar6 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
                        AppMethodBeat.o(260252);
                        throw tVar6;
                    }
                    bds bds3 = ((atv) aYK5).LEG;
                    if (bds3 != null) {
                        i7 = bds3.LNy;
                    }
                    eVar.tTo = i7;
                    Log.d(getTAG(), "onSceneEnd (" + ((bs) qVar).tvB + ')');
                    eVar.tag = ((bs) qVar).tvB;
                }
                com.tencent.mm.plugin.finder.feed.model.internal.f<bo> fVar = this.tXP;
                if (fVar != null) {
                    fVar.onFetchDone(eVar);
                    AppMethodBeat.o(260252);
                    return;
                }
            }
            AppMethodBeat.o(260252);
        }
    }

    public static abstract class d {
        private String TAG = "Finder.FinderTopicFeedLoader.TopicRequest";
        ax tXR;

        public abstract void call();

        public final void setTAG(String str) {
            p.h(str, "<set-?>");
            this.TAG = str;
        }

        public String toString() {
            return "";
        }

        public final void ddB() {
            Log.i(this.TAG, toString());
        }
    }

    public static final class c extends d {
        private final int dLS;
        private final String dST;
        private final axt location;
        final int pullType;
        private final String sBN;
        private final String tTG;
        private final int tTH;
        private final String tTQ;
        final dmk tUb;
        private final Long tXN;
        private final bbn ttO;
        private bcc tvs;
        private final long twd;
        private final int type;

        public c(int i2, String str, String str2, long j2, String str3, int i3, axt axt, Long l, bcc bcc, String str4, int i4, dmk dmk, int i5, bbn bbn) {
            p.h(str, "topic");
            p.h(str4, "finderUserName");
            AppMethodBeat.i(244917);
            this.type = i2;
            this.dST = str;
            this.tTG = str2;
            this.twd = j2;
            this.tTQ = str3;
            this.tTH = i3;
            this.location = axt;
            this.tXN = l;
            this.tvs = bcc;
            this.sBN = str4;
            this.dLS = i4;
            this.tUb = dmk;
            this.pullType = i5;
            this.ttO = bbn;
            setTAG("Finder.FinderTopicFeedLoader.TopicRefreshRequest");
            AppMethodBeat.o(244917);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.d
        public final String toString() {
            AppMethodBeat.i(166061);
            String str = "hashCode: " + hashCode() + ", type:" + this.type + ", topic:" + this.dST;
            AppMethodBeat.o(166061);
            return str;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.d
        public final void call() {
            AppMethodBeat.i(166062);
            switch (this.type) {
                case 1:
                    this.tXR = new bs(this.dST, this.tXN, (com.tencent.mm.bw.b) null, this.tvs, this.ttO, (byte) 0);
                    break;
                case 2:
                    axt axt = this.location;
                    if (axt != null) {
                        String str = axt.LIb;
                        if (str == null) {
                            str = "";
                        }
                        this.tXR = new bs(str, axt.dTj, axt.latitude, this.tXN, null, this.dLS, this.tUb, this.tvs, this.ttO);
                        break;
                    }
                    break;
                case 3:
                    this.tXR = new bk(null, this.sBN);
                    break;
                case 4:
                    String str2 = this.tTG;
                    if (str2 == null) {
                        Long l = this.tXN;
                        str2 = com.tencent.mm.ac.d.zs(l != null ? l.longValue() : -1);
                    }
                    this.tXR = new bs(str2, this.tXN, null, this.tvs, this.ttO);
                    break;
                case 7:
                    this.tXR = new bs(this.twd, this.tXN, this.tTQ, this.tTH, (com.tencent.mm.bw.b) null, this.ttO);
                    break;
            }
            if (this.tXR != null) {
                com.tencent.mm.kernel.g.azz().b(this.tXR);
            }
            AppMethodBeat.o(166062);
        }
    }

    public static final class b extends d {
        private final int dLS;
        private final String dST;
        private final com.tencent.mm.bw.b lastBuffer;
        private final axt location;
        private final String tTG;
        private final int tTH;
        private final String tTQ;
        final dmk tUb;
        private final Long tXN;
        private final bbn ttO;
        private final bcc tvs;
        private final long twd;
        private final int type;
        private final String userName;

        public b(int i2, String str, String str2, long j2, String str3, int i3, axt axt, Long l, com.tencent.mm.bw.b bVar, bcc bcc, String str4, int i4, dmk dmk, bbn bbn) {
            p.h(str, "topic");
            p.h(str4, "userName");
            AppMethodBeat.i(244916);
            this.type = i2;
            this.dST = str;
            this.tTG = str2;
            this.twd = j2;
            this.tTQ = str3;
            this.tTH = i3;
            this.location = axt;
            this.tXN = l;
            this.lastBuffer = bVar;
            this.tvs = bcc;
            this.userName = str4;
            this.dLS = i4;
            this.tUb = dmk;
            this.ttO = bbn;
            setTAG("Finder.FinderTopicFeedLoader.TopicLoadMoreRequest");
            AppMethodBeat.o(244916);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.d
        public final String toString() {
            byte[] bArr;
            String mD5String;
            AppMethodBeat.i(166058);
            StringBuilder append = new StringBuilder("hashCode: ").append(hashCode()).append(", type:").append(this.type).append(", topic:").append(this.dST).append(", lastBuffer:");
            if (this.lastBuffer == null) {
                mD5String = BuildConfig.COMMAND;
            } else {
                com.tencent.mm.bw.b bVar = this.lastBuffer;
                if (bVar != null) {
                    bArr = bVar.zy;
                } else {
                    bArr = null;
                }
                mD5String = MD5Util.getMD5String(bArr);
            }
            String sb = append.append(mD5String).toString();
            AppMethodBeat.o(166058);
            return sb;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.d
        public final void call() {
            AppMethodBeat.i(166059);
            switch (this.type) {
                case 1:
                    this.tXR = new bs(this.dST, this.tXN, this.lastBuffer, this.tvs, this.ttO, (byte) 0);
                    break;
                case 2:
                    axt axt = this.location;
                    if (axt != null) {
                        String str = axt.LIb;
                        if (str == null) {
                            str = "";
                        }
                        this.tXR = new bs(str, axt.dTj, axt.latitude, this.tXN, this.lastBuffer, this.dLS, this.tUb, this.tvs, this.ttO);
                        break;
                    }
                    break;
                case 3:
                    this.tXR = new bk(this.lastBuffer, this.userName);
                    break;
                case 4:
                    String str2 = this.tTG;
                    if (str2 == null) {
                        Long l = this.tXN;
                        str2 = com.tencent.mm.ac.d.zs(l != null ? l.longValue() : -1);
                    }
                    this.tXR = new bs(str2, this.tXN, this.lastBuffer, this.tvs, this.ttO);
                    break;
                case 7:
                    this.tXR = new bs(this.twd, this.tXN, this.tTQ, this.tTH, this.lastBuffer, this.ttO);
                    break;
            }
            if (this.tXR != null) {
                com.tencent.mm.kernel.g.azz().b(this.tXR);
            }
            AppMethodBeat.o(166059);
        }
    }
}
