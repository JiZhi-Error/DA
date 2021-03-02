package com.tencent.mm.plugin.finder.report;

import com.google.android.gms.common.stats.LoggingConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.event.a;
import com.tencent.mm.plugin.finder.event.base.g;
import com.tencent.mm.plugin.finder.event.base.j;
import com.tencent.mm.plugin.finder.event.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.ag;
import com.tencent.mm.plugin.finder.report.e;
import com.tencent.mm.plugin.finder.report.p;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 32\u00020\u0001:\u00013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020&H\u0016J\b\u0010*\u001a\u00020&H\u0016J\u0018\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u001eH\u0002J\u0018\u0010.\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\b2\u0006\u0010/\u001a\u00020 H\u0002J\b\u00100\u001a\u00020&H\u0002J\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020\u001e02H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR6\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b`\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0016j\b\u0012\u0004\u0012\u00020\u000f`\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u000e¢\u0006\u0002\n\u0000¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/MegaVideoFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMFragmentActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMFragmentActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "lastCenterFeed", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "getLastCenterFeed", "()Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "setLastCenterFeed", "(Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;)V", "lastVisibleFeedMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getLastVisibleFeedMap", "()Ljava/util/HashMap;", "setLastVisibleFeedMap", "(Ljava/util/HashMap;)V", "lastVisibleNotFeedSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getLastVisibleNotFeedSet", "()Ljava/util/HashSet;", "setLastVisibleNotFeedSet", "(Ljava/util/HashSet;)V", "waitForReportStatsList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "onExit", "onInvisible", "onRelease", "onVisible", "reportCenterRecord", "record", LoggingConstants.LOG_FILE_PREFIX, "reportExpose", "across", "resumeDataAdapter", "sendStatsList", "Ljava/util/LinkedList;", "Companion", "plugin-finder_release"})
public final class ae extends e {
    public static final a vix = new a((byte) 0);
    private ConcurrentLinkedQueue<ecq> vfE = new ConcurrentLinkedQueue<>();
    p vfI;
    HashSet<Long> vfJ = new HashSet<>();
    HashMap<Long, p> vfK = new HashMap<>();

    static {
        AppMethodBeat.i(250845);
        AppMethodBeat.o(250845);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ae(MMFragmentActivity mMFragmentActivity, bbn bbn) {
        super(mMFragmentActivity, bbn);
        p.h(mMFragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(bbn, "contextObj");
        AppMethodBeat.i(250844);
        AppMethodBeat.o(250844);
    }

    public static final /* synthetic */ ecq a(ae aeVar, p pVar) {
        AppMethodBeat.i(250846);
        ecq d2 = aeVar.d(pVar);
        AppMethodBeat.o(250846);
        return d2;
    }

    public static final /* synthetic */ void a(ae aeVar, p pVar, ecq ecq) {
        AppMethodBeat.i(250847);
        aeVar.a(pVar, ecq);
        AppMethodBeat.o(250847);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/MegaVideoFeedFlowReporter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.report.e, com.tencent.mm.plugin.finder.event.base.d
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c cVar, com.tencent.mm.plugin.finder.event.base.b bVar) {
        AppMethodBeat.i(250835);
        p.h(cVar, "dispatcher");
        p.h(bVar, "event");
        if (super.a(cVar, bVar)) {
            AppMethodBeat.o(250835);
            return true;
        } else if (bVar instanceof ag.b) {
            AppMethodBeat.o(250835);
            return true;
        } else if (bVar instanceof j) {
            AppMethodBeat.o(250835);
            return true;
        } else if (bVar instanceof a.C1104a) {
            AppMethodBeat.o(250835);
            return true;
        } else {
            AppMethodBeat.o(250835);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.finder.report.e, com.tencent.mm.plugin.finder.event.base.d
    public final void onRelease() {
        AppMethodBeat.i(250836);
        onExit();
        super.onRelease();
        AppMethodBeat.o(250836);
    }

    private final void onExit() {
        AppMethodBeat.i(250837);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        d.c(FinderReporterUIC.kWD, new c(this));
        AppMethodBeat.o(250837);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.finder.report.e, com.tencent.mm.plugin.finder.event.base.d
    public final void a(com.tencent.mm.plugin.finder.event.base.b bVar) {
        boolean z;
        boolean z2;
        p pVar;
        boolean z3;
        p pVar2;
        boolean z4;
        boolean z5;
        boolean z6;
        p pVar3;
        boolean z7;
        p pVar4;
        boolean z8;
        p pVar5;
        FinderItem finderItem;
        WxRecyclerAdapter<?> wxRecyclerAdapter;
        FinderItem finderItem2;
        FinderItem finderItem3;
        FinderItem finderItem4;
        ArrayList arrayList;
        AppMethodBeat.i(250839);
        p.h(bVar, "event");
        super.a(bVar);
        if (bVar instanceof j) {
            if (!this.visible) {
                Log.i("MegaVideoFeedFlowReporter", this.ttO.tCE + " not visible");
                AppMethodBeat.o(250839);
                return;
            }
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dtF().value().intValue() == 1) {
                as asVar = as.uOL;
                List<g> list = ((j) bVar).tIH;
                if (list != null) {
                    List<g> list2 = list;
                    ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(list2, 10));
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(it.next().tIu);
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = null;
                }
                as.a(arrayList, this.ttO);
            }
            if (!(((j) bVar).tCi == ((j) bVar).tIC && ((j) bVar).ptb == ((j) bVar).tIy && ((j) bVar).ptc == ((j) bVar).tIA)) {
                LinkedList linkedList = new LinkedList();
                if (((j) bVar).tCi != ((j) bVar).tIC) {
                    p pVar6 = this.vfI;
                    if (pVar6 != null) {
                        pVar6.a(this.vdR);
                        p.a aVar = p.vgC;
                        ecq a2 = p.a.a(pVar6, this.ttO);
                        linkedList.add(a2);
                        a(pVar6, a2);
                        x xVar = x.SXb;
                    }
                    List<g> list3 = ((j) bVar).tII;
                    if (list3 != null) {
                        for (T t : list3) {
                            if (t.tIu.lT() == ((j) bVar).tIC) {
                                long lT = t.tIu.lT();
                                long j2 = bVar.tHW;
                                if (t.tIu instanceof BaseFinderFeed) {
                                    finderItem4 = ((BaseFinderFeed) t.tIu).feedObject;
                                } else {
                                    finderItem4 = null;
                                }
                                p pVar7 = new p(lT, j2, finderItem4, t.tIw, true, this.vdR, t.tIu instanceof bm ? (bm) t.tIu : null);
                                pVar7.vfP = t.tIv;
                                x xVar2 = x.SXb;
                                this.vfI = pVar7;
                            }
                        }
                        x xVar3 = x.SXb;
                    }
                }
                HashSet hashSet = new HashSet();
                HashSet hashSet2 = new HashSet();
                hashSet.addAll(this.vfK.keySet());
                List<g> list4 = ((j) bVar).tII;
                if (list4 != null) {
                    for (T t2 : list4) {
                        hashSet.add(Long.valueOf(t2.tIu.lT()));
                        hashSet2.add(Long.valueOf(t2.tIu.lT()));
                    }
                    x xVar4 = x.SXb;
                }
                List<g> list5 = ((j) bVar).tIH;
                if (list5 != null) {
                    for (T t3 : list5) {
                        if (!hashSet.contains(Long.valueOf(t3.tIu.lT()))) {
                            long lT2 = t3.tIu.lT();
                            long j3 = bVar.tHW;
                            if (t3.tIu instanceof BaseFinderFeed) {
                                finderItem3 = ((BaseFinderFeed) t3.tIu).feedObject;
                            } else {
                                finderItem3 = null;
                            }
                            p pVar8 = new p(lT2, j3, finderItem3, t3.tIw, false, null, t3.tIu instanceof bm ? (bm) t3.tIu : null, 48);
                            pVar8.vgy = t3.tIu;
                            linkedList.add(d(pVar8));
                            x xVar5 = x.SXb;
                        }
                    }
                    x xVar6 = x.SXb;
                }
                for (Map.Entry<Long, p> entry : this.vfK.entrySet()) {
                    if (!hashSet2.contains(entry.getKey())) {
                        linkedList.add(d(entry.getValue()));
                    }
                }
                HashMap<Long, p> hashMap = new HashMap<>();
                List<g> list6 = ((j) bVar).tII;
                if (list6 != null) {
                    for (T t4 : list6) {
                        p pVar9 = this.vfK.get(Long.valueOf(t4.tIu.lT()));
                        if (pVar9 != null) {
                            pVar9.vgy = t4.tIu;
                            if (hashMap.put(Long.valueOf(t4.tIu.lT()), pVar9) != null) {
                            }
                        }
                        long lT3 = t4.tIu.lT();
                        long j4 = bVar.tHW;
                        if (t4.tIu instanceof BaseFinderFeed) {
                            finderItem2 = ((BaseFinderFeed) t4.tIu).feedObject;
                        } else {
                            finderItem2 = null;
                        }
                        p pVar10 = new p(lT3, j4, finderItem2, t4.tIw, false, null, t4.tIu instanceof bm ? (bm) t4.tIu : null, 48);
                        pVar10.vgy = t4.tIu;
                        pVar10.vfP = t4.tIv;
                        hashMap.put(Long.valueOf(t4.tIu.lT()), pVar10);
                    }
                    x xVar7 = x.SXb;
                }
                this.vfK = hashMap;
                this.vfE.addAll(linkedList);
                if (this.vfE.size() > 20) {
                    FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                    d.c(FinderReporterUIC.kWD, new b(this));
                }
                StringBuilder sb = new StringBuilder("waitForReportStatsList ");
                ConcurrentLinkedQueue<ecq> concurrentLinkedQueue = this.vfE;
                ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(concurrentLinkedQueue, 10));
                Iterator<T> it2 = concurrentLinkedQueue.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(d.zs(it2.next().hFK));
                }
                Log.i("MegaVideoFeedFlowReporter", sb.append(arrayList3).toString());
            }
            if (!(((j) bVar).ptb == ((j) bVar).tIy && ((j) bVar).ptc == ((j) bVar).tIA)) {
                this.vfJ = new HashSet<>();
                LinkedList<bo> linkedList2 = ((j) bVar).tIJ;
                if (linkedList2 != null) {
                    HashSet<Long> hashSet3 = this.vfJ;
                    LinkedList<bo> linkedList3 = linkedList2;
                    ArrayList arrayList4 = new ArrayList(kotlin.a.j.a(linkedList3, 10));
                    Iterator<T> it3 = linkedList3.iterator();
                    while (it3.hasNext()) {
                        arrayList4.add(Long.valueOf(it3.next().lT()));
                    }
                    Boolean.valueOf(hashSet3.addAll(arrayList4));
                }
            }
            List<g> list7 = ((j) bVar).tII;
            if (list7 != null) {
                for (T t5 : list7) {
                    i iVar = t5.tIw;
                    if (iVar != null) {
                        if (iVar.Rrg) {
                            bbn bbn = this.ttO;
                            long lT4 = t5.tIu.lT();
                            long j5 = bVar.tHW;
                            if (t5.tIu instanceof BaseFinderFeed) {
                                finderItem = ((BaseFinderFeed) t5.tIu).feedObject;
                            } else {
                                finderItem = null;
                            }
                            e.a.a(bbn, new p(lT4, j5, finderItem, iVar, false, null, t5.tIu instanceof bm ? (bm) t5.tIu : null, 48));
                            iVar.Rrg = false;
                            WeakReference<WxRecyclerAdapter<?>> weakReference = iVar.Rri;
                            if (!(weakReference == null || (wxRecyclerAdapter = weakReference.get()) == null)) {
                                wxRecyclerAdapter.onPause();
                                x xVar8 = x.SXb;
                            }
                        }
                        x xVar9 = x.SXb;
                    }
                }
                x xVar10 = x.SXb;
                AppMethodBeat.o(250839);
                return;
            }
            AppMethodBeat.o(250839);
        } else if (bVar instanceof a.C1104a) {
            p pVar11 = null;
            int i2 = ((a.C1104a) bVar).type;
            a.C1104a.C1105a aVar3 = a.C1104a.tHJ;
            if (i2 == a.C1104a.tHq) {
                p pVar12 = this.vfI;
                p pVar13 = pVar12 != null ? (pVar12.feedId > ((a.C1104a) bVar).feedId ? 1 : (pVar12.feedId == ((a.C1104a) bVar).feedId ? 0 : -1)) == 0 ? pVar12 : null : null;
                if (pVar13 != null) {
                    pVar13.msj++;
                    int i3 = pVar13.vgd;
                    pVar13.vgd = i3 + 1;
                    Integer.valueOf(i3);
                } else {
                    long j6 = ((a.C1104a) bVar).feedId;
                    long j7 = bVar.tHW;
                    k kVar = k.vfA;
                    p pVar14 = new p(j6, j7, null, null, false, null, k.Fd(((a.C1104a) bVar).feedId), 56);
                    pVar14.msj++;
                    pVar14.vgd++;
                    x xVar11 = x.SXb;
                    x xVar12 = x.SXb;
                    pVar11 = pVar14;
                }
                k kVar2 = k.vfA;
                bm Fd = k.Fd(((a.C1104a) bVar).feedId);
                if (Fd != null) {
                    long dkW = Fd.dkW();
                    bbn bbn2 = this.ttO;
                    e.c.a aVar4 = e.c.vdX;
                    e.a.a(bbn2, dkW, 1, e.c.vdW, 0, Fd, 16);
                    bbn bbn3 = this.ttO;
                    String aTY = z.aTY();
                    kotlin.g.b.p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
                    String jSONObject = e.a.a(10, "1", aTY).toString();
                    kotlin.g.b.p.g(jSONObject, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                    e.a.a(bbn3, dkW, 10, jSONObject, 0, Fd, 16);
                    x xVar13 = x.SXb;
                } else {
                    Log.i("MegaVideoFeedFlowReporter", "ActionEvent.SHARE_TO_SNS mega video is null id = " + ((a.C1104a) bVar).feedId);
                    x xVar14 = x.SXb;
                }
            } else {
                a.C1104a.C1105a aVar5 = a.C1104a.tHJ;
                if (i2 == a.C1104a.tHp) {
                    p pVar15 = this.vfI;
                    p pVar16 = pVar15 != null ? (pVar15.feedId > ((a.C1104a) bVar).feedId ? 1 : (pVar15.feedId == ((a.C1104a) bVar).feedId ? 0 : -1)) == 0 ? pVar15 : null : null;
                    if (pVar16 != null) {
                        int i4 = pVar16.msj;
                        pVar16.msj = i4 + 1;
                        Integer.valueOf(i4);
                    } else {
                        long j8 = ((a.C1104a) bVar).feedId;
                        long j9 = bVar.tHW;
                        k kVar3 = k.vfA;
                        p pVar17 = new p(j8, j9, null, null, false, null, k.Fd(((a.C1104a) bVar).feedId), 56);
                        pVar17.msj++;
                        x xVar15 = x.SXb;
                        x xVar16 = x.SXb;
                        pVar11 = pVar17;
                    }
                    k kVar4 = k.vfA;
                    bm Fd2 = k.Fd(((a.C1104a) bVar).feedId);
                    if (Fd2 != null) {
                        long dkW2 = Fd2.dkW();
                        bbn bbn4 = this.ttO;
                        e.c.a aVar6 = e.c.vdX;
                        e.a.a(bbn4, dkW2, 1, e.c.vdW, 0, Fd2, 16);
                        bbn bbn5 = this.ttO;
                        String aTY2 = z.aTY();
                        kotlin.g.b.p.g(aTY2, "ConfigStorageLogic.getUsernameFromUserInfo()");
                        String jSONObject2 = e.a.a(10, "2", aTY2).toString();
                        kotlin.g.b.p.g(jSONObject2, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                        e.a.a(bbn5, dkW2, 10, jSONObject2, 0, Fd2, 16);
                        x xVar17 = x.SXb;
                    } else {
                        Log.i("MegaVideoFeedFlowReporter", "ActionEvent.SHARE_TO_CHAT mega video is null id = " + ((a.C1104a) bVar).feedId);
                        x xVar18 = x.SXb;
                    }
                } else {
                    a.C1104a.C1105a aVar7 = a.C1104a.tHJ;
                    if (i2 == a.C1104a.tHs) {
                        k kVar5 = k.vfA;
                        bm Fd3 = k.Fd(((a.C1104a) bVar).feedId);
                        if (Fd3 != null) {
                            long dkW3 = Fd3.dkW();
                            bbn bbn6 = this.ttO;
                            String aTY3 = z.aTY();
                            kotlin.g.b.p.g(aTY3, "ConfigStorageLogic.getUsernameFromUserInfo()");
                            String jSONObject3 = e.a.a(13, "1", aTY3).toString();
                            kotlin.g.b.p.g(jSONObject3, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                            e.a.a(bbn6, dkW3, 13, jSONObject3, 0, Fd3, 16);
                            x xVar19 = x.SXb;
                        } else {
                            Log.i("MegaVideoFeedFlowReporter", "ActionEvent.CANCEL_SHARE_TO_SNS mega video is null id = " + ((a.C1104a) bVar).feedId);
                            x xVar20 = x.SXb;
                        }
                    } else {
                        a.C1104a.C1105a aVar8 = a.C1104a.tHJ;
                        if (i2 == a.C1104a.tHr) {
                            k kVar6 = k.vfA;
                            bm Fd4 = k.Fd(((a.C1104a) bVar).feedId);
                            if (Fd4 != null) {
                                long dkW4 = Fd4.dkW();
                                bbn bbn7 = this.ttO;
                                String aTY4 = z.aTY();
                                kotlin.g.b.p.g(aTY4, "ConfigStorageLogic.getUsernameFromUserInfo()");
                                String jSONObject4 = e.a.a(13, "2", aTY4).toString();
                                kotlin.g.b.p.g(jSONObject4, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                                e.a.a(bbn7, dkW4, 13, jSONObject4, 0, Fd4, 16);
                                x xVar21 = x.SXb;
                            } else {
                                Log.i("MegaVideoFeedFlowReporter", "ActionEvent.CANCEL_SHARE_TO_CHAT mega video is null id = " + ((a.C1104a) bVar).feedId);
                                x xVar22 = x.SXb;
                            }
                        } else {
                            a.C1104a.C1105a aVar9 = a.C1104a.tHJ;
                            if (i2 == a.C1104a.tHx) {
                                p pVar18 = this.vfI;
                                p pVar19 = pVar18 != null ? (pVar18.feedId > ((a.C1104a) bVar).feedId ? 1 : (pVar18.feedId == ((a.C1104a) bVar).feedId ? 0 : -1)) == 0 ? pVar18 : null : null;
                                if (pVar19 != null) {
                                    pVar19.vga++;
                                } else {
                                    long j10 = ((a.C1104a) bVar).feedId;
                                    long j11 = bVar.tHW;
                                    k kVar7 = k.vfA;
                                    p pVar20 = new p(j10, j11, null, null, false, null, k.Fd(((a.C1104a) bVar).feedId), 56);
                                    pVar20.vga++;
                                    x xVar23 = x.SXb;
                                    pVar11 = pVar20;
                                }
                                k kVar8 = k.vfA;
                                bm Fd5 = k.Fd(((a.C1104a) bVar).feedId);
                                if (Fd5 != null) {
                                    long dkW5 = Fd5.dkW();
                                    bbn bbn8 = this.ttO;
                                    e.c.a aVar10 = e.c.vdX;
                                    e.a.a(bbn8, dkW5, 7, e.c.vdW, 0, Fd5, 16);
                                    x xVar24 = x.SXb;
                                } else {
                                    Log.i("MegaVideoFeedFlowReporter", "ActionEvent.CLICK_AVATAR mega video is null id = " + ((a.C1104a) bVar).feedId);
                                    x xVar25 = x.SXb;
                                }
                                x xVar26 = x.SXb;
                            } else {
                                a.C1104a.C1105a aVar11 = a.C1104a.tHJ;
                                if (i2 == a.C1104a.tHy) {
                                    p pVar21 = this.vfI;
                                    p pVar22 = pVar21 != null ? (pVar21.feedId > ((a.C1104a) bVar).feedId ? 1 : (pVar21.feedId == ((a.C1104a) bVar).feedId ? 0 : -1)) == 0 ? pVar21 : null : null;
                                    if (pVar22 != null) {
                                        pVar22.vgb++;
                                    } else {
                                        long j12 = ((a.C1104a) bVar).feedId;
                                        long j13 = bVar.tHW;
                                        k kVar9 = k.vfA;
                                        p pVar23 = new p(j12, j13, null, null, false, null, k.Fd(((a.C1104a) bVar).feedId), 56);
                                        pVar23.vgb++;
                                        x xVar27 = x.SXb;
                                        pVar11 = pVar23;
                                    }
                                    k kVar10 = k.vfA;
                                    bm Fd6 = k.Fd(((a.C1104a) bVar).feedId);
                                    if (Fd6 != null) {
                                        long dkW6 = Fd6.dkW();
                                        bbn bbn9 = this.ttO;
                                        e.c.a aVar12 = e.c.vdX;
                                        e.a.a(bbn9, dkW6, 16, e.c.vdW, 0, Fd6, 16);
                                        x xVar28 = x.SXb;
                                    } else {
                                        Log.i("MegaVideoFeedFlowReporter", "ActionEvent.FAV mega video is null id = " + ((a.C1104a) bVar).feedId);
                                        x xVar29 = x.SXb;
                                    }
                                    x xVar30 = x.SXb;
                                } else {
                                    a.C1104a.C1105a aVar13 = a.C1104a.tHJ;
                                    if (i2 == a.C1104a.tHA) {
                                        p pVar24 = this.vfI;
                                        p pVar25 = pVar24 != null ? (pVar24.feedId > ((a.C1104a) bVar).feedId ? 1 : (pVar24.feedId == ((a.C1104a) bVar).feedId ? 0 : -1)) == 0 ? pVar24 : null : null;
                                        if (pVar25 != null) {
                                            int i5 = pVar25.vgl;
                                            pVar25.vgl = i5 + 1;
                                            Integer.valueOf(i5);
                                        } else {
                                            long j14 = ((a.C1104a) bVar).feedId;
                                            long j15 = bVar.tHW;
                                            k kVar11 = k.vfA;
                                            p pVar26 = new p(j14, j15, null, null, false, null, k.Fd(((a.C1104a) bVar).feedId), 56);
                                            pVar26.vgl++;
                                            x xVar31 = x.SXb;
                                            x xVar32 = x.SXb;
                                            pVar11 = pVar26;
                                        }
                                    } else {
                                        a.C1104a.C1105a aVar14 = a.C1104a.tHJ;
                                        if (i2 == a.C1104a.tHt) {
                                            p pVar27 = this.vfI;
                                            p pVar28 = pVar27 != null ? (pVar27.feedId > ((a.C1104a) bVar).feedId ? 1 : (pVar27.feedId == ((a.C1104a) bVar).feedId ? 0 : -1)) == 0 ? pVar27 : null : null;
                                            if (pVar28 != null) {
                                                int i6 = pVar28.vgc;
                                                pVar28.vgc = i6 + 1;
                                                Integer.valueOf(i6);
                                            } else {
                                                long j16 = ((a.C1104a) bVar).feedId;
                                                long j17 = bVar.tHW;
                                                k kVar12 = k.vfA;
                                                p pVar29 = new p(j16, j17, null, null, false, null, k.Fd(((a.C1104a) bVar).feedId), 56);
                                                pVar29.vgc++;
                                                x xVar33 = x.SXb;
                                                x xVar34 = x.SXb;
                                                pVar11 = pVar29;
                                            }
                                        } else {
                                            a.C1104a.C1105a aVar15 = a.C1104a.tHJ;
                                            if (i2 == a.C1104a.tHB) {
                                                p pVar30 = this.vfI;
                                                p pVar31 = pVar30 != null ? (pVar30.feedId > ((a.C1104a) bVar).feedId ? 1 : (pVar30.feedId == ((a.C1104a) bVar).feedId ? 0 : -1)) == 0 ? pVar30 : null : null;
                                                if (pVar31 != null) {
                                                    int i7 = pVar31.vgf;
                                                    pVar31.vgf = i7 + 1;
                                                    Integer.valueOf(i7);
                                                } else {
                                                    long j18 = ((a.C1104a) bVar).feedId;
                                                    long j19 = bVar.tHW;
                                                    k kVar13 = k.vfA;
                                                    p pVar32 = new p(j18, j19, null, null, false, null, k.Fd(((a.C1104a) bVar).feedId), 56);
                                                    pVar32.vgf++;
                                                    x xVar35 = x.SXb;
                                                    x xVar36 = x.SXb;
                                                    pVar11 = pVar32;
                                                }
                                            } else {
                                                a.C1104a.C1105a aVar16 = a.C1104a.tHJ;
                                                if (i2 == a.C1104a.tHC) {
                                                    p pVar33 = this.vfI;
                                                    p pVar34 = pVar33 != null ? (pVar33.feedId > ((a.C1104a) bVar).feedId ? 1 : (pVar33.feedId == ((a.C1104a) bVar).feedId ? 0 : -1)) == 0 ? pVar33 : null : null;
                                                    if (pVar34 != null) {
                                                        int i8 = pVar34.vge;
                                                        pVar34.vge = i8 + 1;
                                                        Integer.valueOf(i8);
                                                    } else {
                                                        long j20 = ((a.C1104a) bVar).feedId;
                                                        long j21 = bVar.tHW;
                                                        k kVar14 = k.vfA;
                                                        p pVar35 = new p(j20, j21, null, null, false, null, k.Fd(((a.C1104a) bVar).feedId), 56);
                                                        pVar35.vge++;
                                                        x xVar37 = x.SXb;
                                                        x xVar38 = x.SXb;
                                                        pVar11 = pVar35;
                                                    }
                                                } else {
                                                    a.C1104a.C1105a aVar17 = a.C1104a.tHJ;
                                                    if (i2 == a.C1104a.tHD) {
                                                        p pVar36 = this.vfI;
                                                        p pVar37 = pVar36 != null ? (pVar36.feedId > ((a.C1104a) bVar).feedId ? 1 : (pVar36.feedId == ((a.C1104a) bVar).feedId ? 0 : -1)) == 0 ? pVar36 : null : null;
                                                        if (pVar37 != null) {
                                                            int i9 = pVar37.vgg;
                                                            pVar37.vgg = i9 + 1;
                                                            Integer.valueOf(i9);
                                                        } else {
                                                            long j22 = ((a.C1104a) bVar).feedId;
                                                            long j23 = bVar.tHW;
                                                            k kVar15 = k.vfA;
                                                            p pVar38 = new p(j22, j23, null, null, false, null, k.Fd(((a.C1104a) bVar).feedId), 56);
                                                            pVar38.vgg++;
                                                            x xVar39 = x.SXb;
                                                            x xVar40 = x.SXb;
                                                            pVar11 = pVar38;
                                                        }
                                                    } else {
                                                        a.C1104a.C1105a aVar18 = a.C1104a.tHJ;
                                                        if (i2 == a.C1104a.tHE) {
                                                            p pVar39 = this.vfI;
                                                            p pVar40 = pVar39 != null ? (pVar39.feedId > ((a.C1104a) bVar).feedId ? 1 : (pVar39.feedId == ((a.C1104a) bVar).feedId ? 0 : -1)) == 0 ? pVar39 : null : null;
                                                            if (pVar40 != null) {
                                                                int i10 = pVar40.vgj;
                                                                pVar40.vgj = i10 + 1;
                                                                Integer.valueOf(i10);
                                                            } else {
                                                                long j24 = ((a.C1104a) bVar).feedId;
                                                                long j25 = bVar.tHW;
                                                                k kVar16 = k.vfA;
                                                                p pVar41 = new p(j24, j25, null, null, false, null, k.Fd(((a.C1104a) bVar).feedId), 56);
                                                                pVar41.vgj++;
                                                                x xVar41 = x.SXb;
                                                                x xVar42 = x.SXb;
                                                                pVar11 = pVar41;
                                                            }
                                                        } else {
                                                            a.C1104a.C1105a aVar19 = a.C1104a.tHJ;
                                                            if (i2 == a.C1104a.tHF) {
                                                                p pVar42 = this.vfI;
                                                                p pVar43 = pVar42 != null ? (pVar42.feedId > ((a.C1104a) bVar).feedId ? 1 : (pVar42.feedId == ((a.C1104a) bVar).feedId ? 0 : -1)) == 0 ? pVar42 : null : null;
                                                                if (pVar43 != null) {
                                                                    int i11 = pVar43.vgk;
                                                                    pVar43.vgk = i11 + 1;
                                                                    Integer.valueOf(i11);
                                                                } else {
                                                                    long j26 = ((a.C1104a) bVar).feedId;
                                                                    long j27 = bVar.tHW;
                                                                    k kVar17 = k.vfA;
                                                                    p pVar44 = new p(j26, j27, null, null, false, null, k.Fd(((a.C1104a) bVar).feedId), 56);
                                                                    pVar44.vgk++;
                                                                    x xVar43 = x.SXb;
                                                                    x xVar44 = x.SXb;
                                                                    pVar11 = pVar44;
                                                                }
                                                            } else {
                                                                a.C1104a.C1105a aVar20 = a.C1104a.tHJ;
                                                                if (i2 != a.C1104a.tHG) {
                                                                    a.C1104a.C1105a aVar21 = a.C1104a.tHJ;
                                                                    if (i2 != a.C1104a.tHH) {
                                                                        a.C1104a.C1105a aVar22 = a.C1104a.tHJ;
                                                                        if (i2 != a.C1104a.tHI) {
                                                                            AppMethodBeat.o(250839);
                                                                            return;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (pVar11 != null) {
                p.c(pVar11);
                p.a aVar23 = p.vgC;
                Boolean.valueOf(this.vfE.add(p.a.a(pVar11, this.ttO)));
                AppMethodBeat.o(250839);
                return;
            }
            AppMethodBeat.o(250839);
        } else {
            if (bVar instanceof c.a) {
                switch (((c.a) bVar).type) {
                    case 1:
                        p pVar45 = this.vfI;
                        if (pVar45 != null) {
                            if (pVar45.feedId == ((c.a) bVar).feedId) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if (z6) {
                                pVar3 = pVar45;
                            } else {
                                pVar3 = null;
                            }
                            if (pVar3 != null) {
                                pVar3.vgn = bVar.tHW;
                                x xVar45 = x.SXb;
                                AppMethodBeat.o(250839);
                                return;
                            }
                        }
                        AppMethodBeat.o(250839);
                        return;
                    case 2:
                        p pVar46 = this.vfI;
                        if (pVar46 != null) {
                            if (pVar46.feedId == ((c.a) bVar).feedId) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (!z5) {
                                pVar46 = null;
                            }
                            if (pVar46 != null) {
                                pVar46.vfT[pVar46.vfU] = pVar46.vfT[pVar46.vfU] + 1;
                                int i12 = pVar46.vfV;
                                pVar46.vfV = i12 + 1;
                                Integer.valueOf(i12);
                                AppMethodBeat.o(250839);
                                return;
                            }
                        }
                        AppMethodBeat.o(250839);
                        return;
                    case 3:
                        p pVar47 = this.vfI;
                        if (pVar47 != null) {
                            if (pVar47.feedId == ((c.a) bVar).feedId) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (!z4) {
                                pVar47 = null;
                            }
                            if (pVar47 != null) {
                                pVar47.vgt.add(Integer.valueOf(((c.a) bVar).offset));
                                int i13 = (int) ((100.0f * ((float) ((c.a) bVar).offset)) / ((float) ((c.a) bVar).jcu));
                                if (i13 > pVar47.vfS[pVar47.vfU]) {
                                    pVar47.vfS[pVar47.vfU] = i13;
                                }
                                if (i13 > pVar47.vfY) {
                                    pVar47.vfX = ((c.a) bVar).offset;
                                    pVar47.vfY = i13;
                                }
                                x xVar46 = x.SXb;
                                AppMethodBeat.o(250839);
                                return;
                            }
                        }
                        AppMethodBeat.o(250839);
                        return;
                    case 4:
                        p pVar48 = this.vfI;
                        if (pVar48 != null) {
                            if (pVar48.feedId == ((c.a) bVar).feedId) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            if (z8) {
                                pVar5 = pVar48;
                            } else {
                                pVar5 = null;
                            }
                            if (pVar5 != null) {
                                pVar5.vgp = bVar.tHW;
                                x xVar47 = x.SXb;
                                AppMethodBeat.o(250839);
                                return;
                            }
                        }
                        AppMethodBeat.o(250839);
                        return;
                    case 6:
                        p pVar49 = this.vfI;
                        if (pVar49 != null) {
                            if (pVar49.feedId == ((c.a) bVar).feedId) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            if (z7) {
                                pVar4 = pVar49;
                            } else {
                                pVar4 = null;
                            }
                            if (pVar4 != null) {
                                if (pVar4.vgp != 0) {
                                    pVar4.vgo = bVar.tHW - pVar4.vgp;
                                }
                                x xVar48 = x.SXb;
                                AppMethodBeat.o(250839);
                                return;
                            }
                        }
                        AppMethodBeat.o(250839);
                        return;
                    case 10:
                        p pVar50 = this.vfI;
                        if (pVar50 != null) {
                            if (pVar50.feedId == ((c.a) bVar).feedId) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                pVar = pVar50;
                            } else {
                                pVar = null;
                            }
                            if (pVar != null) {
                                pVar.vgr = 1;
                                x xVar49 = x.SXb;
                            }
                        }
                        if (((c.a) bVar).tHM != null) {
                            k kVar18 = k.vfA;
                            bm Fd7 = k.Fd(((c.a) bVar).feedId);
                            if (Fd7 != null) {
                                long dkW7 = Fd7.dkW();
                                if (((c.a) bVar).tHO > ((c.a) bVar).tHP) {
                                    e.a.a(this.ttO, dkW7, 15, String.valueOf(e.a.a(15, "-1")), 0, Fd7, 16);
                                } else if (((c.a) bVar).tHO < ((c.a) bVar).tHP) {
                                    e.a.a(this.ttO, dkW7, 15, String.valueOf(e.a.a(15, "1")), 0, Fd7, 16);
                                }
                                x xVar50 = x.SXb;
                            } else {
                                Log.i("MegaVideoFeedFlowReporter", "ActionEvent.VIDEO_SEEK mega video is null id = " + ((c.a) bVar).feedId);
                                x xVar51 = x.SXb;
                            }
                            x xVar52 = x.SXb;
                        }
                        AppMethodBeat.o(250839);
                        return;
                    case 11:
                        p pVar51 = this.vfI;
                        if (pVar51 != null) {
                            if (pVar51.feedId == ((c.a) bVar).feedId) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                pVar2 = pVar51;
                            } else {
                                pVar2 = null;
                            }
                            if (pVar2 != null) {
                                if (pVar2.vgn != 0) {
                                    pVar2.vgm += bVar.tHW - pVar2.vgn;
                                    pVar2.vgn = 0;
                                }
                                x xVar53 = x.SXb;
                                AppMethodBeat.o(250839);
                                return;
                            }
                        }
                        AppMethodBeat.o(250839);
                        return;
                    case 17:
                        p pVar52 = this.vfI;
                        if (pVar52 != null) {
                            if (pVar52.feedId == ((c.a) bVar).feedId) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                pVar52 = null;
                            }
                            if (pVar52 != null) {
                                pVar52.vgq = 1;
                                x xVar54 = x.SXb;
                                AppMethodBeat.o(250839);
                                return;
                            }
                        }
                        break;
                }
            }
            AppMethodBeat.o(250839);
        }
    }

    private final ecq d(p pVar) {
        AppMethodBeat.i(250840);
        p.c(pVar);
        p.a aVar = p.vgC;
        ecq a2 = p.a.a(pVar, this.ttO);
        bm bmVar = pVar.uJO;
        if (bmVar != null) {
            e.a.a(this.ttO, bmVar.dkW(), 14, String.valueOf(pVar.endTime - pVar.startTime), 0, bmVar, 16);
        }
        AppMethodBeat.o(250840);
        return a2;
    }

    @Override // com.tencent.mm.plugin.finder.report.e
    public final LinkedList<ecq> dnM() {
        AppMethodBeat.i(250841);
        if (this.vfE.size() > 0) {
            LinkedList<ecq> linkedList = new LinkedList<>(this.vfE);
            this.vfE.clear();
            s sVar = s.vhF;
            s.a(linkedList, this.ttO, 0);
            AppMethodBeat.o(250841);
            return linkedList;
        }
        LinkedList<ecq> linkedList2 = new LinkedList<>();
        AppMethodBeat.o(250841);
        return linkedList2;
    }

    @Override // com.tencent.mm.plugin.finder.report.e
    public final void onVisible() {
        LinkedList<WeakReference<WxRecyclerAdapter<?>>> linkedList;
        AppMethodBeat.i(250842);
        super.onVisible();
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.uLr);
        if (fH == null || (linkedList = fH.wzz) == null) {
            AppMethodBeat.o(250842);
            return;
        }
        Iterator<T> it = linkedList.iterator();
        while (it.hasNext()) {
            WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) it.next().get();
            if (wxRecyclerAdapter != null) {
                wxRecyclerAdapter.onResume();
            }
        }
        AppMethodBeat.o(250842);
    }

    @Override // com.tencent.mm.plugin.finder.report.e
    public final void onInvisible() {
        AppMethodBeat.i(250843);
        super.onInvisible();
        onExit();
        AppMethodBeat.o(250843);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ae viy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ae aeVar) {
            super(0);
            this.viy = aeVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(250834);
            LinkedList linkedList = new LinkedList();
            for (Map.Entry<Long, p> entry : this.viy.vfK.entrySet()) {
                linkedList.add(ae.a(this.viy, entry.getValue()));
            }
            ae aeVar = this.viy;
            HashMap<Long, p> hashMap = new HashMap<>();
            kotlin.g.b.p.h(hashMap, "<set-?>");
            aeVar.vfK = hashMap;
            p pVar = this.viy.vfI;
            if (pVar != null) {
                pVar.a(this.viy.vdR);
                p.a aVar = p.vgC;
                ecq a2 = p.a.a(pVar, this.viy.ttO);
                linkedList.add(a2);
                ae.a(this.viy, pVar, a2);
            }
            this.viy.vfI = null;
            this.viy.vfE.addAll(linkedList);
            ae aeVar2 = this.viy;
            HashSet<Long> hashSet = new HashSet<>();
            kotlin.g.b.p.h(hashSet, "<set-?>");
            aeVar2.vfJ = hashSet;
            x xVar = x.SXb;
            AppMethodBeat.o(250834);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ae viy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ae aeVar) {
            super(0);
            this.viy = aeVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(250833);
            this.viy.dnM();
            x xVar = x.SXb;
            AppMethodBeat.o(250833);
            return xVar;
        }
    }

    private final void a(p pVar, ecq ecq) {
        Object obj;
        AppMethodBeat.i(250838);
        bm bmVar = pVar.uJO;
        if (bmVar != null) {
            long dkW = bmVar.dkW();
            if (pVar.vfV > 0) {
                e.a.a(this.ttO, dkW, 5, String.valueOf(pVar.vfV), pVar.uOV, bmVar);
            }
            e.a.a(this.ttO, dkW, 2, String.valueOf(pVar.endTime - pVar.startTime), pVar.uOV, bmVar);
            if (pVar.vfY > 0) {
                e.a.a(this.ttO, dkW, 11, String.valueOf(pVar.vfY), pVar.uOV, bmVar);
            }
            bbn bbn = this.ttO;
            mp mpVar = ecq.NcM;
            if (mpVar != null) {
                obj = Long.valueOf(mpVar.KQT);
            } else {
                obj = "";
            }
            e.a.a(bbn, dkW, 3, String.valueOf(obj), pVar.uOV, bmVar);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DownloadInfo.NETTYPE, pVar.netType);
            jSONObject.put("isPause", pVar.vgq);
            jSONObject.put("isSeek", pVar.vgr);
            jSONObject.put("playProgressInfo", pVar.vgs);
            jSONObject.put("maxPlayPercent", pVar.vfY);
            jSONObject.put("maxPlayLength", pVar.vfX);
            jSONObject.put("videoDuration", pVar.videoDuration);
            jSONObject.put("playTime", pVar.vgo);
            jSONObject.put("realPlayTime", pVar.vgm);
            jSONObject.put("voiceInfo", pVar.vgw);
            jSONObject.put("playFormat", pVar.vgx);
            bbn bbn2 = this.ttO;
            String jSONObject2 = jSONObject.toString();
            kotlin.g.b.p.g(jSONObject2, "playInfoObj.toString()");
            e.a.a(bbn2, dkW, 17, n.j(jSONObject2, ",", ";", false), pVar.uOV, bmVar);
            c cVar = c.vdc;
            String EY = c.EY(pVar.feedId);
            if (!Util.isNullOrNil(EY)) {
                e.a.a(this.ttO, dkW, 18, EY, pVar.uOV, bmVar);
            }
            AppMethodBeat.o(250838);
            return;
        }
        AppMethodBeat.o(250838);
    }
}
