package com.tencent.mm.plugin.finder.feed.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.a.j;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00017B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\nJ\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010%\u001a\u00020#2\u0018\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020 0'0\u0011H\u0002J\u000e\u0010(\u001a\u00020#2\u0006\u0010!\u001a\u00020\nJH\u0010)\u001a\u00020#2@\u0010\u000b\u001a<\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0018\u00010\fJ\u0006\u0010*\u001a\u00020#J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020-H\u0016J\"\u0010.\u001a\u00020#2\u0018\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\n0'0\u0011H\u0002J\u0016\u00100\u001a\u00020#2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\n02H\u0002J\u001f\u00103\u001a\u00020#2\b\u00104\u001a\u0004\u0018\u00010\u001d2\b\u00105\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u00106R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000RH\u0010\u000b\u001a<\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u000e¢\u0006\u0002\n\u0000¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "()V", "NOTIFY_BY_CLICK", "", "NOTIFY_SIGNAL", "REQUEASR_SIGNAL", "TAG", "", "getData", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "firstItemPos", "lastItemPos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "loadedList", "Ljava/util/Vector;", "", "loadingList", "getOrRequestNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "userName", "keep", "", "target", "notify", "noticeInfos", "Lkotlin/Pair;", "notifyWithCache", "onAttach", "onDetach", "onEventHappen", "ev", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "preLoadFinderLiveNoticeInfo", "ids", "publishEvent", "nameList", "", "requestSignNoticeInfo", "feedId", "nonceId", "(Ljava/lang/Long;Ljava/lang/String;)V", "Companion", "plugin-finder_release"})
public final class f extends com.tencent.mm.plugin.finder.event.base.d implements com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> {
    public static final a tWl = new a((byte) 0);
    private final String TAG = "FinderLiveNoticePreLoader";
    private final kotlin.f lhN = g.ah(new b(this));
    private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> tLP = new CopyOnWriteArraySet<>();
    private Vector<Long> tUP = new Vector<>();
    private m<? super Integer, ? super Integer, ? extends LinkedList<bo>> tWg;
    private final Vector<Long> tWh = new Vector<>();
    private final int tWi = 1;
    private final int tWj = 2;
    public final int tWk = 3;

    static {
        AppMethodBeat.i(244734);
        AppMethodBeat.o(244734);
    }

    public final MMHandler bkj() {
        AppMethodBeat.i(244725);
        MMHandler mMHandler = (MMHandler) this.lhN.getValue();
        AppMethodBeat.o(244725);
        return mMHandler;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class d<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ f tWm;
        final /* synthetic */ z.f tWs;

        d(f fVar, z.f fVar2) {
            this.tWm = fVar;
            this.tWs = fVar2;
        }

        /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
            java.lang.StackOverflowError
            	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
            	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
            	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
            	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
            */
        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ java.lang.Object call(java.lang.Object r10) {
            /*
            // Method dump skipped, instructions count: 443
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.model.f.d.call(java.lang.Object):java.lang.Object");
        }
    }

    public f() {
        AppMethodBeat.i(244733);
        AppMethodBeat.o(244733);
    }

    public static final /* synthetic */ void b(f fVar, LinkedList linkedList) {
        AppMethodBeat.i(244737);
        fVar.ag(linkedList);
        AppMethodBeat.o(244737);
    }

    public static final /* synthetic */ MMHandler e(f fVar) {
        AppMethodBeat.i(244736);
        MMHandler bkj = fVar.bkj();
        AppMethodBeat.o(244736);
        return bkj;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\b\u001a\u00020\u0004¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader$Companion;", "", "()V", "nameList2Str", "", "nameList", "", "str2NameList", "str", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<MMHandler> {
        final /* synthetic */ f tWm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(f fVar) {
            super(0);
            this.tWm = fVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
        static final class a implements MMHandler.Callback {
            final /* synthetic */ b tWn;

            a(b bVar) {
                this.tWn = bVar;
            }

            public final boolean handleMessage(Message message) {
                AppMethodBeat.i(244720);
                int i2 = message.what;
                if (i2 == this.tWn.tWm.tWi) {
                    f fVar = this.tWn.tWm;
                    Object obj = message.obj;
                    if (obj == null) {
                        t tVar = new t("null cannot be cast to non-null type java.util.LinkedList<kotlin.Pair<kotlin.Long, kotlin.String>>");
                        AppMethodBeat.o(244720);
                        throw tVar;
                    }
                    f.b(fVar, (LinkedList) obj);
                } else if (i2 == this.tWn.tWm.tWj) {
                    Object obj2 = message.obj;
                    if (obj2 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type java.util.LinkedList<kotlin.Pair<kotlin.String, com.tencent.mm.protocal.protobuf.FinderLiveNoticeInfo>>");
                        AppMethodBeat.o(244720);
                        throw tVar2;
                    }
                    LinkedList<o> linkedList = (LinkedList) obj2;
                    ArrayList arrayList = new ArrayList(j.a(linkedList, 10));
                    for (o oVar : linkedList) {
                        arrayList.add(oVar.first);
                    }
                    ArrayList arrayList2 = arrayList;
                    if (!(!arrayList2.isEmpty())) {
                        arrayList2 = null;
                    }
                    if (arrayList2 != null) {
                        f.dW(arrayList2);
                    }
                } else if (i2 == this.tWn.tWm.tWk) {
                    Object obj3 = message.obj;
                    if (obj3 == null) {
                        t tVar3 = new t("null cannot be cast to non-null type kotlin.String");
                        AppMethodBeat.o(244720);
                        throw tVar3;
                    }
                    f.dW(j.listOf((String) obj3));
                }
                AppMethodBeat.o(244720);
                return true;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMHandler invoke() {
            AppMethodBeat.i(244721);
            MMHandler mMHandler = new MMHandler("FinderLiveNoticePreLoader", new a(this));
            mMHandler.setLogging(false);
            AppMethodBeat.o(244721);
            return mMHandler;
        }
    }

    public final void e(m<? super Integer, ? super Integer, ? extends LinkedList<bo>> mVar) {
        AppMethodBeat.i(244726);
        Log.i(this.TAG, "onAttach");
        this.tWg = mVar;
        AppMethodBeat.o(244726);
    }

    public final void onDetach() {
        AppMethodBeat.i(244727);
        Log.i(this.TAG, "onDetach");
        this.tWg = null;
        Iterator<T> it = this.tLP.iterator();
        while (it.hasNext()) {
            it.next().dead();
        }
        this.tLP.clear();
        this.tUP.clear();
        bkj().removeMessages(this.tWi);
        bkj().removeMessages(this.tWj);
        this.tWh.clear();
        AppMethodBeat.o(244727);
    }

    public static awt atq(String str) {
        AppMethodBeat.i(244728);
        p.h(str, "userName");
        e eVar = e.tUY;
        awt ato = e.ato(str);
        AppMethodBeat.o(244728);
        return ato;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0130 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void ag(java.util.LinkedList<kotlin.o<java.lang.Long, java.lang.String>> r15) {
        /*
        // Method dump skipped, instructions count: 447
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.model.f.ag(java.util.LinkedList):void");
    }

    @Override // com.tencent.mm.vending.e.b
    public final void keep(com.tencent.mm.vending.e.a aVar) {
        AppMethodBeat.i(244730);
        this.tLP.add(aVar);
        AppMethodBeat.o(244730);
    }

    @Override // com.tencent.mm.plugin.finder.event.base.d
    public final void a(com.tencent.mm.plugin.finder.event.base.b bVar) {
        AppMethodBeat.i(244731);
        p.h(bVar, "ev");
        if (bVar instanceof h) {
            int i2 = ((h) bVar).tIy;
            int i3 = ((h) bVar).tIA;
            if (i2 > i3) {
                AppMethodBeat.o(244731);
                return;
            }
            com.tencent.mm.ac.d.h(new c(this, i2, i3));
        }
        AppMethodBeat.o(244731);
    }

    public final void a(Long l, String str) {
        AppMethodBeat.i(244732);
        if (!(l == null || str == null)) {
            bkj().sendMessage(bkj().obtainMessage(this.tWi, new LinkedList(j.listOf(new o(Long.valueOf(l.longValue()), str)))));
        }
        AppMethodBeat.o(244732);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f tWm;
        final /* synthetic */ int tWo;
        final /* synthetic */ int tWp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(f fVar, int i2, int i3) {
            super(0);
            this.tWm = fVar;
            this.tWo = i2;
            this.tWp = i3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(244723);
            m mVar = this.tWm.tWg;
            final LinkedList linkedList = mVar != null ? (LinkedList) mVar.invoke(Integer.valueOf(this.tWo), Integer.valueOf(this.tWp)) : null;
            f.e(this.tWm).post(new Runnable(this) {
                /* class com.tencent.mm.plugin.finder.feed.model.f.c.AnonymousClass1 */
                final /* synthetic */ c tWq;

                {
                    this.tWq = r1;
                }

                public final void run() {
                    ArrayList arrayList;
                    AppMethodBeat.i(244722);
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = linkedList;
                    if (linkedList2 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj : linkedList2) {
                            if (obj instanceof BaseFinderFeed) {
                                arrayList2.add(obj);
                            }
                        }
                        ArrayList arrayList3 = new ArrayList();
                        for (Object obj2 : arrayList2) {
                            BaseFinderFeed baseFinderFeed = (BaseFinderFeed) obj2;
                            e eVar = e.tUY;
                            boolean z = e.ato(baseFinderFeed.feedObject.getUserName()) != null;
                            if (z) {
                                linkedList.add(baseFinderFeed.feedObject.getUserName());
                            }
                            if (!z) {
                                arrayList3.add(obj2);
                            }
                        }
                        ArrayList<BaseFinderFeed> arrayList4 = arrayList3;
                        ArrayList arrayList5 = new ArrayList(j.a(arrayList4, 10));
                        for (BaseFinderFeed baseFinderFeed2 : arrayList4) {
                            if (baseFinderFeed2 == null) {
                                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                                AppMethodBeat.o(244722);
                                throw tVar;
                            }
                            FinderItem finderItem = baseFinderFeed2.feedObject;
                            Long valueOf = Long.valueOf(finderItem.getExpectId());
                            String objectNonceId = finderItem.getObjectNonceId();
                            if (objectNonceId == null) {
                                objectNonceId = "";
                            }
                            arrayList5.add(new o(valueOf, objectNonceId));
                        }
                        arrayList = arrayList5;
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null) {
                        if ((!arrayList.isEmpty() ? arrayList : null) != null) {
                            LinkedList linkedList3 = new LinkedList(arrayList);
                            f.e(this.tWq.tWm).removeMessages(this.tWq.tWm.tWi);
                            f.e(this.tWq.tWm).sendMessage(f.e(this.tWq.tWm).obtainMessage(this.tWq.tWm.tWi, linkedList3));
                            AppMethodBeat.o(244722);
                            return;
                        }
                    }
                    AppMethodBeat.o(244722);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(244723);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(f fVar, LinkedList linkedList) {
        AppMethodBeat.i(244735);
        fVar.bkj().removeMessages(fVar.tWj);
        fVar.bkj().sendMessage(fVar.bkj().obtainMessage(fVar.tWj, linkedList));
        AppMethodBeat.o(244735);
    }

    public static final /* synthetic */ void dW(List list) {
        AppMethodBeat.i(244738);
        hn hnVar = new hn();
        hn.a aVar = hnVar.dLW;
        p.h(list, "nameList");
        StringBuilder sb = new StringBuilder("");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next()).append(",");
        }
        String sb2 = sb.toString();
        p.g(sb2, "strBuilder.toString()");
        aVar.username = n.c(sb2, (CharSequence) ",");
        hnVar.dLW.type = 11;
        EventCenter.instance.publish(hnVar);
        AppMethodBeat.o(244738);
    }
}
