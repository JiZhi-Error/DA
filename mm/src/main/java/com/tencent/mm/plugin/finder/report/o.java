package com.tencent.mm.plugin.finder.report;

import android.util.LongSparseArray;
import com.google.android.gms.common.stats.LoggingConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.aw;
import com.tencent.mm.plugin.finder.convert.ap;
import com.tencent.mm.plugin.finder.event.a;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.event.base.j;
import com.tencent.mm.plugin.finder.event.c;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.ag;
import com.tencent.mm.plugin.finder.report.e;
import com.tencent.mm.plugin.finder.report.p;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.azw;
import com.tencent.mm.protocal.protobuf.azx;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.s;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000fH\u0002J.\u0010+\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001a\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020\b2\b\b\u0002\u00106\u001a\u00020\bH\u0002J\b\u00107\u001a\u00020)H\u0002J\u0014\u00108\u001a\u0004\u0018\u00010\f2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\b\u0010;\u001a\u00020)H\u0002J\u0018\u0010<\u001a\u0002012\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020)2\u0006\u0010B\u001a\u00020\u0013H\u0002J\u0010\u0010C\u001a\u00020)2\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010D\u001a\u00020)H\u0002J\b\u0010E\u001a\u00020)H\u0016J\b\u0010F\u001a\u00020)H\u0016J\b\u0010G\u001a\u00020)H\u0016J\u0012\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010J\u001a\u00020\u000fH\u0002J\u0018\u0010K\u001a\u00020)2\u0006\u0010L\u001a\u00020\u00132\u0006\u0010M\u001a\u00020'H\u0002J\u0012\u0010N\u001a\u00020)2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u001c\u0010N\u001a\u00020)2\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010O\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010P\u001a\u00020'2\u0006\u0010L\u001a\u00020\u00132\u0006\u0010Q\u001a\u000201H\u0002J\b\u0010R\u001a\u00020)H\u0002J\u0012\u0010S\u001a\u00020)2\b\u0010T\u001a\u0004\u0018\u00010UH\u0002J\b\u0010V\u001a\u00020)H\u0002J\u0018\u0010W\u001a\u00020)2\u0006\u0010J\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020XH\u0002J\u000e\u0010Y\u001a\u00020)2\u0006\u0010J\u001a\u00020\u000fJ\u000e\u0010Z\u001a\b\u0012\u0004\u0012\u00020'0[H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R6\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u0019j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0013`\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u000b0 j\b\u0012\u0004\u0012\u00020\u000b`!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMFragmentActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMFragmentActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "MEGA_VIDEO_VISIT_ENTRANCE_VALUE", "", "dailyTopicMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderObjectHotTopic;", "extActionValueList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "", "feedReportWatcher", "Lcom/tencent/mm/plugin/finder/report/FeedReportWatcher;", "lastCenterFeed", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "getLastCenterFeed", "()Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "setLastCenterFeed", "(Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;)V", "lastVisibleFeedMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getLastVisibleFeedMap", "()Ljava/util/HashMap;", "setLastVisibleFeedMap", "(Ljava/util/HashMap;)V", "lastVisibleNotFeedSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getLastVisibleNotFeedSet", "()Ljava/util/HashSet;", "setLastVisibleNotFeedSet", "(Ljava/util/HashSet;)V", "waitForReportStatsList", "Lcom/tencent/mm/protocal/protobuf/Stats;", "addActionValue", "", "actionValue", "afterConversationUpdate", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "conversation", "Lcom/tencent/mm/storage/Conversation;", "newCon", "", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "checkEmptyToHotTabExpose", "messageType", FirebaseAnalytics.b.INDEX, "checkRedDotExpose", "getDailyTopic", "feedItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "handleExtStatsRecord", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onDailyShow", "singleFeedRecord", "onEventHappen", "onExit", "onInvisible", "onRelease", "onVisible", "optExtStats", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "feedActionValue", "reportCenterRecord", "record", LoggingConstants.LOG_FILE_PREFIX, "reportDailyShow", "dailyTopic", "reportExpose", "across", "reportExtStatsInCenterSwitch", "reportFavSimilarExpose", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "resumeDataAdapter", "sendExStatsReport", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$ActionEvent;", "sendExtStatsReport", "sendStatsList", "Ljava/util/LinkedList;", "Companion", "plugin-finder_release"})
public class o extends e {
    private static final String TAG = TAG;
    private static p vfM;
    public static final a vfN = new a((byte) 0);
    private ConcurrentLinkedQueue<ecq> vfE = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<String> vfF = new ConcurrentLinkedQueue<>();
    private final b vfG;
    private final int vfH;
    p vfI;
    HashSet<Long> vfJ;
    public HashMap<Long, p> vfK;
    private ConcurrentHashMap<Long, azw> vfL;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(MMFragmentActivity mMFragmentActivity, bbn bbn) {
        super(mMFragmentActivity, bbn);
        p.h(mMFragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(bbn, "contextObj");
        AppMethodBeat.i(250736);
        b bVar = new b();
        bVar.dnC();
        this.vfG = bVar;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.vfH = com.tencent.mm.plugin.finder.storage.c.dvI().value().intValue();
        this.vfJ = new HashSet<>();
        this.vfK = new HashMap<>();
        this.vfL = new ConcurrentHashMap<>();
        AppMethodBeat.o(250736);
    }

    public static final /* synthetic */ ecq a(o oVar, p pVar) {
        AppMethodBeat.i(250738);
        ecq a2 = oVar.a(pVar, false);
        AppMethodBeat.o(250738);
        return a2;
    }

    public static final /* synthetic */ void a(o oVar, p pVar, ecq ecq) {
        AppMethodBeat.i(250740);
        oVar.a(pVar, ecq);
        AppMethodBeat.o(250740);
    }

    public static final /* synthetic */ void b(o oVar) {
        AppMethodBeat.i(250739);
        oVar.dog();
        AppMethodBeat.o(250739);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0013R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "hotStreamCenterFeed", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "getHotStreamCenterFeed", "()Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "setHotStreamCenterFeed", "(Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;)V", "sendExtStatsReport", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "extStats", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(bbn bbn, alc alc) {
            AppMethodBeat.i(250719);
            p.h(alc, "extStats");
            Log.i(o.TAG, "sendExtStatsReport " + com.tencent.mm.ac.d.zs(alc.hFK));
            g.azz().b(new aw(bbn, alc));
            AppMethodBeat.o(250719);
        }
    }

    static {
        AppMethodBeat.i(250737);
        AppMethodBeat.o(250737);
    }

    @Override // com.tencent.mm.plugin.finder.report.e, com.tencent.mm.plugin.finder.event.base.d
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c cVar, com.tencent.mm.plugin.finder.event.base.b bVar) {
        AppMethodBeat.i(250722);
        p.h(cVar, "dispatcher");
        p.h(bVar, "event");
        if (super.a(cVar, bVar)) {
            AppMethodBeat.o(250722);
            return true;
        } else if (bVar instanceof ag.b) {
            AppMethodBeat.o(250722);
            return true;
        } else if (bVar instanceof j) {
            AppMethodBeat.o(250722);
            return true;
        } else if (bVar instanceof a.C1104a) {
            AppMethodBeat.o(250722);
            return true;
        } else {
            AppMethodBeat.o(250722);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.finder.report.e, com.tencent.mm.plugin.finder.event.base.d
    public final void onRelease() {
        AppMethodBeat.i(250723);
        onExit();
        super.onRelease();
        AppMethodBeat.o(250723);
    }

    private final void onExit() {
        AppMethodBeat.i(250724);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        com.tencent.mm.ac.d.c(FinderReporterUIC.kWD, new c(this));
        AppMethodBeat.o(250724);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.finder.report.e, com.tencent.mm.plugin.finder.event.base.d
    public void a(com.tencent.mm.plugin.finder.event.base.b bVar) {
        boolean z;
        boolean z2;
        p pVar;
        boolean z3;
        p pVar2;
        boolean z4;
        p pVar3;
        p pVar4;
        FinderItem finderItem;
        WxRecyclerAdapter<?> wxRecyclerAdapter;
        f d2;
        int i2;
        int i3;
        int i4;
        FinderItem finderItem2;
        FinderItem finderItem3;
        FinderItem finderItem4;
        ArrayList arrayList;
        AppMethodBeat.i(250726);
        p.h(bVar, "event");
        super.a(bVar);
        if (bVar instanceof j) {
            if (!this.visible) {
                Log.i(TAG, this.ttO.tCE + " not visible");
                AppMethodBeat.o(250726);
                return;
            }
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dtF().value().intValue() == 1) {
                as asVar = as.uOL;
                List<com.tencent.mm.plugin.finder.event.base.g> list = ((j) bVar).tIH;
                if (list != null) {
                    List<com.tencent.mm.plugin.finder.event.base.g> list2 = list;
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
                    p pVar5 = this.vfI;
                    if (pVar5 != null) {
                        pVar5.a(this.vdR);
                        p.a aVar = p.vgC;
                        ecq a2 = p.a.a(pVar5, this.ttO);
                        linkedList.add(a2);
                        a(pVar5, a2);
                        switch (((j) bVar).type) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 6:
                            case 8:
                                auL(e.a.ah(ae.b(s.U("feedActionType", 1))));
                                break;
                        }
                        x xVar = x.SXb;
                    }
                    List<com.tencent.mm.plugin.finder.event.base.g> list3 = ((j) bVar).tII;
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
                                p pVar6 = new p(lT, j2, finderItem4, t.tIw, true, this.vdR, null, 64);
                                pVar6.vfP = t.tIv;
                                x xVar2 = x.SXb;
                                this.vfI = pVar6;
                            }
                        }
                        x xVar3 = x.SXb;
                    }
                    vfM = this.vfI;
                }
                HashSet hashSet = new HashSet();
                HashSet hashSet2 = new HashSet();
                hashSet.addAll(this.vfK.keySet());
                List<com.tencent.mm.plugin.finder.event.base.g> list4 = ((j) bVar).tII;
                if (list4 != null) {
                    for (T t2 : list4) {
                        hashSet.add(Long.valueOf(t2.tIu.lT()));
                        hashSet2.add(Long.valueOf(t2.tIu.lT()));
                    }
                    x xVar4 = x.SXb;
                }
                List<com.tencent.mm.plugin.finder.event.base.g> list5 = ((j) bVar).tIH;
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
                            p pVar7 = new p(lT2, j3, finderItem3, t3.tIw, false, null, null, 112);
                            pVar7.vgy = t3.tIu;
                            this.vfG.a(pVar7);
                            this.vfG.a(t3.tIu, "acrossFeedList ", pVar7);
                            ecq a3 = a(pVar7, true);
                            this.vfG.b(pVar7);
                            linkedList.add(a3);
                            x xVar5 = x.SXb;
                        }
                    }
                    x xVar6 = x.SXb;
                }
                for (Map.Entry<Long, p> entry : this.vfK.entrySet()) {
                    if (!hashSet2.contains(entry.getKey())) {
                        ecq a4 = a(entry.getValue(), false);
                        this.vfG.b(entry.getValue());
                        linkedList.add(a4);
                    }
                }
                HashMap<Long, p> hashMap = new HashMap<>();
                List<com.tencent.mm.plugin.finder.event.base.g> list6 = ((j) bVar).tII;
                if (list6 != null) {
                    for (T t4 : list6) {
                        p pVar8 = this.vfK.get(Long.valueOf(t4.tIu.lT()));
                        if (pVar8 != null) {
                            pVar8.vgy = t4.tIu;
                            hashMap.put(Long.valueOf(t4.tIu.lT()), pVar8);
                            if (pVar8 != null) {
                            }
                        }
                        o oVar = this;
                        long lT3 = t4.tIu.lT();
                        long j4 = bVar.tHW;
                        if (t4.tIu instanceof BaseFinderFeed) {
                            finderItem2 = ((BaseFinderFeed) t4.tIu).feedObject;
                        } else {
                            finderItem2 = null;
                        }
                        p pVar9 = new p(lT3, j4, finderItem2, t4.tIw, false, null, null, 112);
                        pVar9.vgy = t4.tIu;
                        pVar9.vfP = t4.tIv;
                        oVar.vfG.a(pVar9);
                        oVar.vfG.a(t4.tIu, "lastVisibleFeedMap ", pVar9);
                        hashMap.put(Long.valueOf(t4.tIu.lT()), pVar9);
                    }
                    x xVar7 = x.SXb;
                }
                this.vfK = hashMap;
                this.vfE.addAll(linkedList);
                if (this.vfE.size() > 20) {
                    FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                    com.tencent.mm.ac.d.c(FinderReporterUIC.kWD, new b(this));
                }
                String str = TAG;
                StringBuilder sb = new StringBuilder("waitForReportStatsList ");
                ConcurrentLinkedQueue<ecq> concurrentLinkedQueue = this.vfE;
                ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(concurrentLinkedQueue, 10));
                Iterator<T> it2 = concurrentLinkedQueue.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(com.tencent.mm.ac.d.zs(it2.next().hFK));
                }
                Log.i(str, sb.append(arrayList3).toString());
            }
            if (!(((j) bVar).ptb == ((j) bVar).tIy && ((j) bVar).ptc == ((j) bVar).tIA)) {
                LinkedList<bo> linkedList2 = ((j) bVar).tIJ;
                if (linkedList2 != null) {
                    for (T t5 : linkedList2) {
                        if (!this.vfJ.contains(Long.valueOf(t5.lT()))) {
                            switch (t5.cxn()) {
                                case -7:
                                case -1:
                                    if (this.ttO.tCE == 17 || this.ttO.tCE == 18) {
                                        gf(1, 0);
                                        break;
                                    } else {
                                        continue;
                                    }
                                case -5:
                                    if (this.ttO.tCE == 17 || this.ttO.tCE == 18 || this.ttO.tCE == 20) {
                                        FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                                        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.uLr);
                                        if (fH == null) {
                                            break;
                                        } else {
                                            if (!fH.dIs()) {
                                                fH = null;
                                            }
                                            if (!(fH == null || (d2 = FinderReporterUIC.d(fH)) == null || d2.ptb > 1)) {
                                                com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
                                                kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
                                                k asX = ((PluginFinder) ah).getRedDotManager().asX("TLWxBubble");
                                                String str2 = "";
                                                if (asX != null) {
                                                    com.tencent.mm.kernel.e aAh = g.aAh();
                                                    kotlin.g.b.p.g(aAh, "MMKernel.storage()");
                                                    int i5 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_COMMENT_INT_SYNC, 0);
                                                    com.tencent.mm.kernel.e aAh2 = g.aAh();
                                                    kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
                                                    int i6 = aAh2.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_LIKE_INT_SYNC, 0);
                                                    com.tencent.mm.kernel.e aAh3 = g.aAh();
                                                    kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
                                                    int i7 = aAh3.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_OBJECT_LIEK_LIKE_INT_SYNC, 0);
                                                    com.tencent.mm.kernel.e aAh4 = g.aAh();
                                                    kotlin.g.b.p.g(aAh4, "MMKernel.storage()");
                                                    int i8 = aAh4.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_OBJECT_RECOMMEND_LIKE_INT_SYNC, 0);
                                                    com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                                                    if (com.tencent.mm.plugin.finder.storage.c.dsx().value().intValue() == 1) {
                                                        i2 = 5;
                                                        int i9 = i6 > 0 ? 1 : 0;
                                                        if (i5 > 0) {
                                                            i9 |= 8;
                                                        }
                                                        if (i7 > 0) {
                                                            i9 |= 2;
                                                        }
                                                        if (i8 > 0) {
                                                            i4 = i9 | 4;
                                                        } else {
                                                            i4 = i9;
                                                        }
                                                        k kVar = k.vfA;
                                                        str2 = k.fp(this.uLr);
                                                        i3 = i4;
                                                    } else {
                                                        str2 = "2";
                                                        i2 = 1;
                                                        i3 = 1;
                                                    }
                                                    k kVar2 = k.vfA;
                                                    k.a(str2, i2, 1, 2, i3, i5 + i6 + i7 + i8, asX.field_tipsId, (String) null, 0, this.ttO, 0, 0, 3456);
                                                }
                                                com.tencent.mm.kernel.b.a ah2 = g.ah(PluginFinder.class);
                                                kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
                                                bdo asW = ((PluginFinder) ah2).getRedDotManager().asW("TLWxBubble");
                                                if (!(asX == null || asW == null)) {
                                                    j jVar = j.vft;
                                                    j.a(str2, asX, asW, 1, this.ttO, 0, 0, 96);
                                                    break;
                                                }
                                            }
                                        }
                                    } else {
                                        continue;
                                    }
                                    break;
                                case 2011:
                                    if (this.ttO.tCE != 17) {
                                        if (this.ttO.tCE == 18) {
                                            ap.a aVar4 = ap.tEt;
                                            gf(2, ap.a.Is(1));
                                            break;
                                        } else {
                                            break;
                                        }
                                    } else {
                                        ap.a aVar5 = ap.tEt;
                                        gf(2, ap.a.Is(3));
                                        continue;
                                    }
                            }
                        }
                    }
                    x xVar8 = x.SXb;
                }
                this.vfJ = new HashSet<>();
                LinkedList<bo> linkedList3 = ((j) bVar).tIJ;
                if (linkedList3 != null) {
                    HashSet<Long> hashSet3 = this.vfJ;
                    LinkedList<bo> linkedList4 = linkedList3;
                    ArrayList arrayList4 = new ArrayList(kotlin.a.j.a(linkedList4, 10));
                    Iterator<T> it3 = linkedList4.iterator();
                    while (it3.hasNext()) {
                        arrayList4.add(Long.valueOf(it3.next().lT()));
                    }
                    Boolean.valueOf(hashSet3.addAll(arrayList4));
                }
            }
            List<com.tencent.mm.plugin.finder.event.base.g> list7 = ((j) bVar).tII;
            if (list7 != null) {
                for (T t6 : list7) {
                    i iVar = t6.tIw;
                    if (iVar != null) {
                        if (iVar.Rrg) {
                            bbn bbn = this.ttO;
                            long lT4 = t6.tIu.lT();
                            long j5 = bVar.tHW;
                            if (t6.tIu instanceof BaseFinderFeed) {
                                finderItem = ((BaseFinderFeed) t6.tIu).feedObject;
                            } else {
                                finderItem = null;
                            }
                            e.a.a(bbn, new p(lT4, j5, finderItem, iVar, false, null, null, 112));
                            iVar.Rrg = false;
                            WeakReference<WxRecyclerAdapter<?>> weakReference = iVar.Rri;
                            if (!(weakReference == null || (wxRecyclerAdapter = weakReference.get()) == null)) {
                                wxRecyclerAdapter.onPause();
                                x xVar9 = x.SXb;
                            }
                        }
                        x xVar10 = x.SXb;
                    }
                }
                x xVar11 = x.SXb;
                AppMethodBeat.o(250726);
                return;
            }
            AppMethodBeat.o(250726);
        } else if (bVar instanceof a.C1104a) {
            p pVar10 = null;
            int i10 = ((a.C1104a) bVar).type;
            a.C1104a.C1105a aVar6 = a.C1104a.tHJ;
            if (i10 == a.C1104a.tHq) {
                p pVar11 = this.vfI;
                p pVar12 = pVar11 != null ? (pVar11.feedId > ((a.C1104a) bVar).feedId ? 1 : (pVar11.feedId == ((a.C1104a) bVar).feedId ? 0 : -1)) == 0 ? pVar11 : null : null;
                if (pVar12 != null) {
                    pVar12.msj++;
                    int i11 = pVar12.vgd;
                    pVar12.vgd = i11 + 1;
                    Integer.valueOf(i11);
                } else {
                    long j6 = ((a.C1104a) bVar).feedId;
                    long j7 = bVar.tHW;
                    k kVar3 = k.vfA;
                    p pVar13 = new p(j6, j7, k.Fc(((a.C1104a) bVar).feedId), null, false, null, null, 120);
                    pVar13.msj++;
                    pVar13.vgd++;
                    x xVar12 = x.SXb;
                    x xVar13 = x.SXb;
                    pVar10 = pVar13;
                }
                bbn bbn2 = this.ttO;
                long j8 = ((a.C1104a) bVar).feedId;
                e.c.a aVar7 = e.c.vdX;
                e.a.a(bbn2, j8, 1, e.c.vdW, 0, null, 48);
                bbn bbn3 = this.ttO;
                long j9 = ((a.C1104a) bVar).feedId;
                String aTY = z.aTY();
                kotlin.g.b.p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
                String jSONObject = e.a.a(10, "1", aTY).toString();
                kotlin.g.b.p.g(jSONObject, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                e.a.a(bbn3, j9, 10, jSONObject, 0, null, 48);
            } else {
                a.C1104a.C1105a aVar8 = a.C1104a.tHJ;
                if (i10 == a.C1104a.tHp) {
                    p pVar14 = this.vfI;
                    if (pVar14 != null) {
                        pVar4 = (pVar14.feedId > ((a.C1104a) bVar).feedId ? 1 : (pVar14.feedId == ((a.C1104a) bVar).feedId ? 0 : -1)) == 0 ? pVar14 : null;
                    } else {
                        pVar4 = null;
                    }
                    if (pVar4 == null) {
                        long j10 = ((a.C1104a) bVar).feedId;
                        long j11 = bVar.tHW;
                        k kVar4 = k.vfA;
                        p pVar15 = new p(j10, j11, k.Fc(((a.C1104a) bVar).feedId), null, false, null, null, 120);
                        x xVar14 = x.SXb;
                        pVar10 = pVar15;
                    }
                    x xVar15 = x.SXb;
                    bbn bbn4 = this.ttO;
                    long j12 = ((a.C1104a) bVar).feedId;
                    e.c.a aVar9 = e.c.vdX;
                    e.a.a(bbn4, j12, 1, e.c.vdW, 0, null, 48);
                    bbn bbn5 = this.ttO;
                    long j13 = ((a.C1104a) bVar).feedId;
                    String aTY2 = z.aTY();
                    kotlin.g.b.p.g(aTY2, "ConfigStorageLogic.getUsernameFromUserInfo()");
                    String jSONObject2 = e.a.a(10, "2", aTY2).toString();
                    kotlin.g.b.p.g(jSONObject2, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                    e.a.a(bbn5, j13, 10, jSONObject2, 0, null, 48);
                } else {
                    a.C1104a.C1105a aVar10 = a.C1104a.tHJ;
                    if (i10 == a.C1104a.tHs) {
                        bbn bbn6 = this.ttO;
                        long j14 = ((a.C1104a) bVar).feedId;
                        String aTY3 = z.aTY();
                        kotlin.g.b.p.g(aTY3, "ConfigStorageLogic.getUsernameFromUserInfo()");
                        String jSONObject3 = e.a.a(13, "1", aTY3).toString();
                        kotlin.g.b.p.g(jSONObject3, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                        e.a.a(bbn6, j14, 13, jSONObject3, 0, null, 48);
                    } else {
                        a.C1104a.C1105a aVar11 = a.C1104a.tHJ;
                        if (i10 == a.C1104a.tHr) {
                            bbn bbn7 = this.ttO;
                            long j15 = ((a.C1104a) bVar).feedId;
                            String aTY4 = z.aTY();
                            kotlin.g.b.p.g(aTY4, "ConfigStorageLogic.getUsernameFromUserInfo()");
                            String jSONObject4 = e.a.a(13, "2", aTY4).toString();
                            kotlin.g.b.p.g(jSONObject4, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                            e.a.a(bbn7, j15, 13, jSONObject4, 0, null, 48);
                        } else {
                            a.C1104a.C1105a aVar12 = a.C1104a.tHJ;
                            if (i10 == a.C1104a.tHu) {
                                p pVar16 = this.vfI;
                                p pVar17 = pVar16 != null ? (pVar16.feedId > ((a.C1104a) bVar).feedId ? 1 : (pVar16.feedId == ((a.C1104a) bVar).feedId ? 0 : -1)) == 0 ? pVar16 : null : null;
                                if (pVar17 != null) {
                                    pVar17.vfZ++;
                                } else {
                                    long j16 = ((a.C1104a) bVar).feedId;
                                    long j17 = bVar.tHW;
                                    k kVar5 = k.vfA;
                                    p pVar18 = new p(j16, j17, k.Fc(((a.C1104a) bVar).feedId), null, false, null, null, 120);
                                    pVar18.vfZ++;
                                    x xVar16 = x.SXb;
                                    pVar10 = pVar18;
                                }
                                bbn bbn8 = this.ttO;
                                long j18 = ((a.C1104a) bVar).feedId;
                                e.c.a aVar13 = e.c.vdX;
                                e.a.a(bbn8, j18, 6, e.c.vdW, 0, null, 48);
                                x xVar17 = x.SXb;
                            } else {
                                a.C1104a.C1105a aVar14 = a.C1104a.tHJ;
                                if (i10 == a.C1104a.tHx) {
                                    p pVar19 = this.vfI;
                                    p pVar20 = pVar19 != null ? (pVar19.feedId > ((a.C1104a) bVar).feedId ? 1 : (pVar19.feedId == ((a.C1104a) bVar).feedId ? 0 : -1)) == 0 ? pVar19 : null : null;
                                    if (pVar20 != null) {
                                        pVar20.vga++;
                                    } else {
                                        long j19 = ((a.C1104a) bVar).feedId;
                                        long j20 = bVar.tHW;
                                        k kVar6 = k.vfA;
                                        p pVar21 = new p(j19, j20, k.Fc(((a.C1104a) bVar).feedId), null, false, null, null, 120);
                                        pVar21.vga++;
                                        x xVar18 = x.SXb;
                                        pVar10 = pVar21;
                                    }
                                    bbn bbn9 = this.ttO;
                                    long j21 = ((a.C1104a) bVar).feedId;
                                    e.c.a aVar15 = e.c.vdX;
                                    e.a.a(bbn9, j21, 7, e.c.vdW, 0, null, 48);
                                    x xVar19 = x.SXb;
                                    p pVar22 = this.vfI;
                                    if (pVar22 != null) {
                                        if (!(pVar22.feedId == ((a.C1104a) bVar).feedId)) {
                                            pVar22 = null;
                                        }
                                        if (pVar22 != null) {
                                            auL(e.a.ah(ae.b(s.U("feedActionType", 4))));
                                            x xVar20 = x.SXb;
                                        }
                                    }
                                } else {
                                    a.C1104a.C1105a aVar16 = a.C1104a.tHJ;
                                    if (i10 == a.C1104a.tHy) {
                                        p pVar23 = this.vfI;
                                        p pVar24 = pVar23 != null ? (pVar23.feedId > ((a.C1104a) bVar).feedId ? 1 : (pVar23.feedId == ((a.C1104a) bVar).feedId ? 0 : -1)) == 0 ? pVar23 : null : null;
                                        if (pVar24 != null) {
                                            pVar24.vgb++;
                                        } else {
                                            long j22 = ((a.C1104a) bVar).feedId;
                                            long j23 = bVar.tHW;
                                            k kVar7 = k.vfA;
                                            p pVar25 = new p(j22, j23, k.Fc(((a.C1104a) bVar).feedId), null, false, null, null, 120);
                                            pVar25.vgb++;
                                            x xVar21 = x.SXb;
                                            pVar10 = pVar25;
                                        }
                                        bbn bbn10 = this.ttO;
                                        long j24 = ((a.C1104a) bVar).feedId;
                                        e.c.a aVar17 = e.c.vdX;
                                        e.a.a(bbn10, j24, 16, e.c.vdW, 0, null, 48);
                                        x xVar22 = x.SXb;
                                    } else {
                                        a.C1104a.C1105a aVar18 = a.C1104a.tHJ;
                                        if (i10 == a.C1104a.tHA) {
                                            p pVar26 = this.vfI;
                                            p pVar27 = pVar26 != null ? (pVar26.feedId > ((a.C1104a) bVar).feedId ? 1 : (pVar26.feedId == ((a.C1104a) bVar).feedId ? 0 : -1)) == 0 ? pVar26 : null : null;
                                            if (pVar27 != null) {
                                                int i12 = pVar27.vgl;
                                                pVar27.vgl = i12 + 1;
                                                Integer.valueOf(i12);
                                            } else {
                                                long j25 = ((a.C1104a) bVar).feedId;
                                                long j26 = bVar.tHW;
                                                k kVar8 = k.vfA;
                                                p pVar28 = new p(j25, j26, k.Fc(((a.C1104a) bVar).feedId), null, false, null, null, 120);
                                                pVar28.vgl++;
                                                x xVar23 = x.SXb;
                                                x xVar24 = x.SXb;
                                                pVar10 = pVar28;
                                            }
                                        } else {
                                            a.C1104a.C1105a aVar19 = a.C1104a.tHJ;
                                            if (i10 == a.C1104a.tHt) {
                                                p pVar29 = this.vfI;
                                                p pVar30 = pVar29 != null ? (pVar29.feedId > ((a.C1104a) bVar).feedId ? 1 : (pVar29.feedId == ((a.C1104a) bVar).feedId ? 0 : -1)) == 0 ? pVar29 : null : null;
                                                if (pVar30 != null) {
                                                    int i13 = pVar30.vgc;
                                                    pVar30.vgc = i13 + 1;
                                                    Integer.valueOf(i13);
                                                } else {
                                                    long j27 = ((a.C1104a) bVar).feedId;
                                                    long j28 = bVar.tHW;
                                                    k kVar9 = k.vfA;
                                                    p pVar31 = new p(j27, j28, k.Fc(((a.C1104a) bVar).feedId), null, false, null, null, 120);
                                                    pVar31.vgc++;
                                                    x xVar25 = x.SXb;
                                                    x xVar26 = x.SXb;
                                                    pVar10 = pVar31;
                                                }
                                                bbn bbn11 = this.ttO;
                                                long j29 = ((a.C1104a) bVar).feedId;
                                                e.c.a aVar20 = e.c.vdX;
                                                e.a.a(bbn11, j29, 12, e.c.vdW, 0, null, 48);
                                            } else {
                                                a.C1104a.C1105a aVar21 = a.C1104a.tHJ;
                                                if (i10 == a.C1104a.tHB) {
                                                    p pVar32 = this.vfI;
                                                    p pVar33 = pVar32 != null ? (pVar32.feedId > ((a.C1104a) bVar).feedId ? 1 : (pVar32.feedId == ((a.C1104a) bVar).feedId ? 0 : -1)) == 0 ? pVar32 : null : null;
                                                    if (pVar33 != null) {
                                                        int i14 = pVar33.vgf;
                                                        pVar33.vgf = i14 + 1;
                                                        Integer.valueOf(i14);
                                                    } else {
                                                        long j30 = ((a.C1104a) bVar).feedId;
                                                        long j31 = bVar.tHW;
                                                        k kVar10 = k.vfA;
                                                        p pVar34 = new p(j30, j31, k.Fc(((a.C1104a) bVar).feedId), null, false, null, null, 120);
                                                        pVar34.vgf++;
                                                        x xVar27 = x.SXb;
                                                        x xVar28 = x.SXb;
                                                        pVar10 = pVar34;
                                                    }
                                                } else {
                                                    a.C1104a.C1105a aVar22 = a.C1104a.tHJ;
                                                    if (i10 == a.C1104a.tHC) {
                                                        p pVar35 = this.vfI;
                                                        p pVar36 = pVar35 != null ? (pVar35.feedId > ((a.C1104a) bVar).feedId ? 1 : (pVar35.feedId == ((a.C1104a) bVar).feedId ? 0 : -1)) == 0 ? pVar35 : null : null;
                                                        if (pVar36 != null) {
                                                            int i15 = pVar36.vge;
                                                            pVar36.vge = i15 + 1;
                                                            Integer.valueOf(i15);
                                                        } else {
                                                            long j32 = ((a.C1104a) bVar).feedId;
                                                            long j33 = bVar.tHW;
                                                            k kVar11 = k.vfA;
                                                            p pVar37 = new p(j32, j33, k.Fc(((a.C1104a) bVar).feedId), null, false, null, null, 120);
                                                            pVar37.vge++;
                                                            x xVar29 = x.SXb;
                                                            x xVar30 = x.SXb;
                                                            pVar10 = pVar37;
                                                        }
                                                        p pVar38 = this.vfI;
                                                        if (pVar38 != null) {
                                                            if (!(pVar38.feedId == ((a.C1104a) bVar).feedId)) {
                                                                pVar38 = null;
                                                            }
                                                            if (pVar38 != null) {
                                                                auL(e.a.ah(ae.b(s.U("feedActionType", 7))));
                                                                x xVar31 = x.SXb;
                                                            }
                                                        }
                                                    } else {
                                                        a.C1104a.C1105a aVar23 = a.C1104a.tHJ;
                                                        if (i10 == a.C1104a.tHD) {
                                                            p pVar39 = this.vfI;
                                                            p pVar40 = pVar39 != null ? (pVar39.getFeedId() > ((a.C1104a) bVar).getFeedId() ? 1 : (pVar39.getFeedId() == ((a.C1104a) bVar).getFeedId() ? 0 : -1)) == 0 ? pVar39 : null : null;
                                                            if (pVar40 != null) {
                                                                int dom = pVar40.dom();
                                                                pVar40.Kz(dom + 1);
                                                                Integer.valueOf(dom);
                                                            } else {
                                                                long feedId = ((a.C1104a) bVar).getFeedId();
                                                                long dao = bVar.dao();
                                                                k kVar12 = k.vfA;
                                                                p pVar41 = new p(feedId, dao, k.Fc(((a.C1104a) bVar).getFeedId()), null, false, null, null, 120);
                                                                pVar41.Kz(pVar41.dom() + 1);
                                                                x xVar32 = x.SXb;
                                                                x xVar33 = x.SXb;
                                                                pVar10 = pVar41;
                                                            }
                                                        } else {
                                                            a.C1104a.C1105a aVar24 = a.C1104a.tHJ;
                                                            if (i10 == a.C1104a.tHE) {
                                                                p pVar42 = this.vfI;
                                                                p pVar43 = pVar42 != null ? (pVar42.getFeedId() > ((a.C1104a) bVar).getFeedId() ? 1 : (pVar42.getFeedId() == ((a.C1104a) bVar).getFeedId() ? 0 : -1)) == 0 ? pVar42 : null : null;
                                                                if (pVar43 != null) {
                                                                    int don = pVar43.don();
                                                                    pVar43.KA(don + 1);
                                                                    Integer.valueOf(don);
                                                                } else {
                                                                    long feedId2 = ((a.C1104a) bVar).getFeedId();
                                                                    long dao2 = bVar.dao();
                                                                    k kVar13 = k.vfA;
                                                                    p pVar44 = new p(feedId2, dao2, k.Fc(((a.C1104a) bVar).getFeedId()), null, false, null, null, 120);
                                                                    pVar44.KA(pVar44.don() + 1);
                                                                    x xVar34 = x.SXb;
                                                                    x xVar35 = x.SXb;
                                                                    pVar10 = pVar44;
                                                                }
                                                            } else {
                                                                a.C1104a.C1105a aVar25 = a.C1104a.tHJ;
                                                                if (i10 == a.C1104a.tHF) {
                                                                    p pVar45 = this.vfI;
                                                                    p pVar46 = pVar45 != null ? (pVar45.getFeedId() > ((a.C1104a) bVar).getFeedId() ? 1 : (pVar45.getFeedId() == ((a.C1104a) bVar).getFeedId() ? 0 : -1)) == 0 ? pVar45 : null : null;
                                                                    if (pVar46 != null) {
                                                                        int doo = pVar46.doo();
                                                                        pVar46.KB(doo + 1);
                                                                        Integer.valueOf(doo);
                                                                    } else {
                                                                        long feedId3 = ((a.C1104a) bVar).getFeedId();
                                                                        long dao3 = bVar.dao();
                                                                        k kVar14 = k.vfA;
                                                                        p pVar47 = new p(feedId3, dao3, k.Fc(((a.C1104a) bVar).getFeedId()), null, false, null, null, 120);
                                                                        pVar47.KB(pVar47.doo() + 1);
                                                                        x xVar36 = x.SXb;
                                                                        String ah3 = e.a.ah(ae.b(s.U("feedActionType", 14)));
                                                                        a.C1104a aVar26 = (a.C1104a) bVar;
                                                                        alc alc = new alc();
                                                                        alc.hFK = aVar26.getFeedId();
                                                                        FinderItem finderItem5 = aVar26.tHo;
                                                                        if (finderItem5 != null) {
                                                                            alc.finderUsername = finderItem5.getUserName();
                                                                        }
                                                                        k kVar15 = k.vfA;
                                                                        alc.sessionBuffer = k.G(aVar26.getFeedId(), getContextObj().tCE);
                                                                        alc.Lub = ah3;
                                                                        if (this.vfK.containsKey(Long.valueOf(alc.hFK)) && (pVar3 = this.vfK.get(Long.valueOf(alc.hFK))) != null) {
                                                                            alc.videoDuration = pVar3.videoDuration;
                                                                            FinderItem finderItem6 = pVar3.tHo;
                                                                            alc.mediaType = finderItem6 != null ? finderItem6.getMediaType() : 0;
                                                                        }
                                                                        a.a(getContextObj(), alc);
                                                                        x xVar37 = x.SXb;
                                                                        pVar10 = pVar47;
                                                                    }
                                                                } else {
                                                                    a.C1104a.C1105a aVar27 = a.C1104a.tHJ;
                                                                    if (i10 == a.C1104a.tHG) {
                                                                        p pVar48 = this.vfI;
                                                                        if (pVar48 != null) {
                                                                            if (!(pVar48.getFeedId() == ((a.C1104a) bVar).getFeedId())) {
                                                                                pVar48 = null;
                                                                            }
                                                                            if (pVar48 != null) {
                                                                                auL(e.a.ah(ae.b(s.U("feedActionType", 6))));
                                                                                x xVar38 = x.SXb;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        a.C1104a.C1105a aVar28 = a.C1104a.tHJ;
                                                                        if (i10 == a.C1104a.tHH) {
                                                                            p pVar49 = this.vfI;
                                                                            if (pVar49 != null) {
                                                                                if (!(pVar49.getFeedId() == ((a.C1104a) bVar).getFeedId())) {
                                                                                    pVar49 = null;
                                                                                }
                                                                                if (pVar49 != null) {
                                                                                    auL(e.a.ah(ae.b(s.U("feedActionType", 8))));
                                                                                    x xVar39 = x.SXb;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            a.C1104a.C1105a aVar29 = a.C1104a.tHJ;
                                                                            if (i10 == a.C1104a.tHI) {
                                                                                p pVar50 = this.vfI;
                                                                                if (pVar50 != null) {
                                                                                    if (!(pVar50.getFeedId() == ((a.C1104a) bVar).getFeedId())) {
                                                                                        pVar50 = null;
                                                                                    }
                                                                                    if (pVar50 != null) {
                                                                                        auL(e.a.ah(ae.b(s.U("feedActionType", 9))));
                                                                                        x xVar40 = x.SXb;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                AppMethodBeat.o(250726);
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
            }
            if (pVar10 != null) {
                p.c(pVar10);
                p.a aVar30 = p.vgC;
                Boolean.valueOf(this.vfE.add(p.a.a(pVar10, getContextObj())));
                AppMethodBeat.o(250726);
                return;
            }
            AppMethodBeat.o(250726);
        } else if (bVar instanceof ag.b) {
            p pVar51 = this.vfI;
            if (pVar51 != null) {
                p pVar52 = (pVar51.getFeedId() > ((ag.b) bVar).feedId ? 1 : (pVar51.getFeedId() == ((ag.b) bVar).feedId ? 0 : -1)) == 0 ? pVar51 : null;
                if (pVar52 != null) {
                    int i16 = ((ag.b) bVar).tHM.mediaType == 2 ? 0 : 1;
                    int i17 = ((ag.b) bVar).index;
                    if (i17 + 1 > pVar52.vfW) {
                        pVar52.vfW = i17 + 1;
                    }
                    int dol = pVar52.dol();
                    if (dol != i17) {
                        long aWA = cl.aWA();
                        long j34 = aWA - pVar52.doi()[pVar52.dol()];
                        int i18 = pVar52.doj()[pVar52.dol()];
                        int i19 = pVar52.dok()[pVar52.dol()];
                        pVar52.vfR[dol] = j34;
                        pVar52.doi()[i17] = aWA;
                        pVar52.vfU = i17;
                        bbn contextObj = getContextObj();
                        long feedId4 = pVar52.getFeedId();
                        String[] strArr = new String[7];
                        strArr[0] = String.valueOf(j34);
                        strArr[1] = String.valueOf(dol);
                        strArr[2] = String.valueOf(i17);
                        strArr[3] = String.valueOf(i16);
                        strArr[4] = String.valueOf(i18);
                        strArr[5] = String.valueOf(i19);
                        strArr[6] = String.valueOf(((ag.b) bVar).viJ ? 1 : 0);
                        e.a.a(contextObj, feedId4, 4, String.valueOf(e.a.a(4, strArr)), 0, null, 48);
                    }
                    dog();
                    x xVar41 = x.SXb;
                    AppMethodBeat.o(250726);
                    return;
                }
            }
            AppMethodBeat.o(250726);
        } else {
            if (bVar instanceof c.a) {
                switch (((c.a) bVar).type) {
                    case 1:
                        p pVar53 = this.vfI;
                        if (pVar53 != null) {
                            p pVar54 = (pVar53.getFeedId() > ((c.a) bVar).getFeedId() ? 1 : (pVar53.getFeedId() == ((c.a) bVar).getFeedId() ? 0 : -1)) == 0 ? pVar53 : null;
                            if (pVar54 != null) {
                                pVar54.Fh(bVar.dao());
                                x xVar42 = x.SXb;
                                AppMethodBeat.o(250726);
                                return;
                            }
                        }
                        AppMethodBeat.o(250726);
                        return;
                    case 2:
                        p pVar55 = this.vfI;
                        if (pVar55 != null) {
                            if (!(pVar55.getFeedId() == ((c.a) bVar).getFeedId())) {
                                pVar55 = null;
                            }
                            if (pVar55 != null) {
                                pVar55.dok()[pVar55.dol()] = pVar55.dok()[pVar55.dol()] + 1;
                                int i20 = pVar55.vfV;
                                pVar55.vfV = i20 + 1;
                                Integer.valueOf(i20);
                                AppMethodBeat.o(250726);
                                return;
                            }
                        }
                        AppMethodBeat.o(250726);
                        return;
                    case 3:
                        p pVar56 = this.vfI;
                        if (pVar56 != null) {
                            if (pVar56.getFeedId() == ((c.a) bVar).getFeedId()) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (!z4) {
                                pVar56 = null;
                            }
                            if (pVar56 != null) {
                                pVar56.vgi = (long) ((c.a) bVar).getOffset();
                                pVar56.vgt.add(Integer.valueOf(((c.a) bVar).getOffset()));
                                int offset = (int) ((100.0f * ((float) ((c.a) bVar).getOffset())) / ((float) ((c.a) bVar).jcu));
                                if (offset > pVar56.doj()[pVar56.dol()]) {
                                    pVar56.doj()[pVar56.dol()] = offset;
                                }
                                if (offset > pVar56.vfY) {
                                    pVar56.vfX = ((c.a) bVar).getOffset();
                                    pVar56.vfY = offset;
                                }
                                x xVar43 = x.SXb;
                                AppMethodBeat.o(250726);
                                return;
                            }
                        }
                        AppMethodBeat.o(250726);
                        return;
                    case 4:
                        p pVar57 = this.vfI;
                        if (pVar57 != null) {
                            p pVar58 = (pVar57.getFeedId() > ((c.a) bVar).getFeedId() ? 1 : (pVar57.getFeedId() == ((c.a) bVar).getFeedId() ? 0 : -1)) == 0 ? pVar57 : null;
                            if (pVar58 != null) {
                                pVar58.vgp = bVar.dao();
                                x xVar44 = x.SXb;
                                AppMethodBeat.o(250726);
                                return;
                            }
                        }
                        AppMethodBeat.o(250726);
                        return;
                    case 6:
                        p pVar59 = this.vfI;
                        if (pVar59 != null) {
                            p pVar60 = (pVar59.getFeedId() > ((c.a) bVar).getFeedId() ? 1 : (pVar59.getFeedId() == ((c.a) bVar).getFeedId() ? 0 : -1)) == 0 ? pVar59 : null;
                            if (pVar60 != null) {
                                if (pVar60.doq() != 0) {
                                    pVar60.vgo = bVar.dao() - pVar60.doq();
                                }
                                x xVar45 = x.SXb;
                                AppMethodBeat.o(250726);
                                return;
                            }
                        }
                        AppMethodBeat.o(250726);
                        return;
                    case 10:
                        p pVar61 = this.vfI;
                        if (pVar61 != null) {
                            if (pVar61.getFeedId() == ((c.a) bVar).getFeedId()) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                pVar = pVar61;
                            } else {
                                pVar = null;
                            }
                            if (pVar != null) {
                                pVar.vgr = 1;
                                x xVar46 = x.SXb;
                            }
                        }
                        if (((c.a) bVar).tHM != null) {
                            if (((c.a) bVar).dam() > ((c.a) bVar).dan()) {
                                e.a.a(getContextObj(), ((c.a) bVar).getFeedId(), 15, String.valueOf(e.a.a(15, "-1")), 0, null, 48);
                            } else if (((c.a) bVar).dam() < ((c.a) bVar).dan()) {
                                e.a.a(getContextObj(), ((c.a) bVar).getFeedId(), 15, String.valueOf(e.a.a(15, "1")), 0, null, 48);
                            }
                            x xVar47 = x.SXb;
                        }
                        AppMethodBeat.o(250726);
                        return;
                    case 11:
                        p pVar62 = this.vfI;
                        if (pVar62 != null) {
                            if (pVar62.getFeedId() == ((c.a) bVar).getFeedId()) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                pVar2 = pVar62;
                            } else {
                                pVar2 = null;
                            }
                            if (pVar2 != null) {
                                pVar2.vgh++;
                                if (pVar2.dop() != 0) {
                                    pVar2.vgm += bVar.dao() - pVar2.dop();
                                    pVar2.Fh(0);
                                }
                                x xVar48 = x.SXb;
                                AppMethodBeat.o(250726);
                                return;
                            }
                        }
                        AppMethodBeat.o(250726);
                        return;
                    case 17:
                        p pVar63 = this.vfI;
                        if (pVar63 != null) {
                            if (pVar63.getFeedId() == ((c.a) bVar).getFeedId()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                pVar63 = null;
                            }
                            if (pVar63 != null) {
                                pVar63.vgq = 1;
                                x xVar49 = x.SXb;
                                AppMethodBeat.o(250726);
                                return;
                            }
                        }
                        break;
                }
            }
            AppMethodBeat.o(250726);
        }
    }

    private final ecq a(p pVar, boolean z) {
        WxRecyclerAdapter<?> wxRecyclerAdapter;
        com.tencent.mm.plugin.finder.storage.k kVar;
        ard foldedLayout;
        LongSparseArray<com.tencent.mm.view.recyclerview.k> longSparseArray;
        WeakReference<WxRecyclerAdapter<?>> weakReference;
        WxRecyclerAdapter<?> wxRecyclerAdapter2;
        i iVar;
        azw azw;
        String str;
        FinderObject feedObject;
        AppMethodBeat.i(250727);
        p.c(pVar);
        if (!b.a(this.vfG)) {
            StringBuilder sb = new StringBuilder();
            if (pVar != null) {
                String dl = b.dl(pVar);
                if (pVar.dUy < 0) {
                    sb.append("stayTime :" + pVar.dUy + " startTime:" + pVar.startTime + " endTime:" + pVar.endTime + "\n obj:" + dl);
                }
                if (pVar.vgm < 0) {
                    sb.append("realPlayTime :" + pVar.vgm + " realPlayTimestamp:" + pVar.vgn + " endTime:" + pVar.endTime + "\n obj:" + dl);
                }
            }
            if (!Util.isNullOrNil(sb.toString())) {
                Log.e("FeedReportWatcher", "vertify error:\n ".concat(String.valueOf(sb)));
            }
        }
        FinderItem finderItem = pVar.tHo;
        Long valueOf = (finderItem == null || (feedObject = finderItem.getFeedObject()) == null) ? null : Long.valueOf(feedObject.id);
        if (valueOf != null) {
            long longValue = valueOf.longValue();
            if (this.vfL.containsKey(Long.valueOf(longValue))) {
                azw azw2 = this.vfL.get(Long.valueOf(longValue));
                String str2 = TAG;
                StringBuilder sb2 = new StringBuilder("get from cache: ");
                if (azw2 != null) {
                    str = azw2.riB;
                } else {
                    str = null;
                }
                Log.i(str2, sb2.append(str).toString());
                azw = azw2;
            } else {
                azw h2 = h(finderItem);
                if (h2 != null) {
                    this.vfL.put(Long.valueOf(longValue), h2);
                }
                Log.i(TAG, "get from feed update map: " + (h2 != null ? h2.riB : null));
                azw = h2;
            }
            if (!(finderItem == null || azw == null)) {
                int i2 = azw.LJO > 0 ? 1 : 0;
                k kVar2 = k.vfA;
                long j2 = finderItem.getFeedObject().id;
                long j3 = azw.twp;
                String str3 = azw.riB;
                if (str3 == null) {
                    str3 = "";
                }
                k.a(j2, 1, j3, str3, (long) i2, this.ttO.tCE);
            }
        }
        p.a aVar = p.vgC;
        ecq a2 = p.a.a(pVar, this.ttO);
        if (pVar.tHo != null) {
            e.a.a(this.ttO, pVar.feedId, 14, String.valueOf(pVar.endTime - pVar.startTime), 0, null, 48);
        } else {
            Log.i(TAG, "local feed ignore");
        }
        e.a.a(this.ttO, pVar, 2);
        if (z) {
            FinderItem finderItem2 = pVar.tHo;
            if (!(finderItem2 == null || (foldedLayout = finderItem2.getFoldedLayout()) == null || foldedLayout.gAZ <= 0)) {
                i iVar2 = pVar.tIw;
                if (iVar2 != null) {
                    longSparseArray = iVar2.Rrh;
                } else {
                    longSparseArray = null;
                }
                if (longSparseArray == null && (iVar = pVar.tIw) != null) {
                    LongSparseArray<com.tencent.mm.view.recyclerview.k> longSparseArray2 = new LongSparseArray<>();
                    LinkedList<FinderObject> linkedList = foldedLayout.LCW;
                    kotlin.g.b.p.g(linkedList, "it.objects");
                    int i3 = 0;
                    for (T t : linkedList) {
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            kotlin.a.j.hxH();
                        }
                        T t2 = t;
                        if (i3 <= 2) {
                            com.tencent.mm.view.recyclerview.k kVar3 = new com.tencent.mm.view.recyclerview.k(new d(t2));
                            kVar3.tIv = i3;
                            longSparseArray2.put(t2.id, kVar3);
                        }
                        i3 = i4;
                    }
                    iVar.Rrh = longSparseArray2;
                }
                e.a.a(this.ttO, pVar);
                i iVar3 = pVar.tIw;
                if (!(iVar3 == null || (weakReference = iVar3.Rri) == null || (wxRecyclerAdapter2 = weakReference.get()) == null)) {
                    wxRecyclerAdapter2.onPause();
                }
            }
        } else {
            i iVar4 = pVar.tIw;
            if (iVar4 != null && (iVar4.Rrf || iVar4.Rrg)) {
                e.a.a(this.ttO, pVar);
                iVar4.Rrg = false;
                WeakReference<WxRecyclerAdapter<?>> weakReference2 = iVar4.Rri;
                if (!(weakReference2 == null || (wxRecyclerAdapter = weakReference2.get()) == null)) {
                    wxRecyclerAdapter.onPause();
                }
            }
        }
        FinderItem finderItem3 = pVar.tHo;
        if (!Util.isNullOrNil(finderItem3 != null ? finderItem3.getLongVideoMediaList() : null) && this.vfH == 1) {
            h.INSTANCE.a(21346, com.tencent.mm.ac.d.zs(pVar.feedId), Integer.valueOf(this.ttO.tCE), this.ttO.sessionId, this.ttO.sGQ, this.ttO.sGE);
        }
        bo boVar = pVar.vgy;
        if (boVar != null && (boVar instanceof BaseFinderFeed)) {
            BaseFinderFeed baseFinderFeed = (BaseFinderFeed) boVar;
            if (baseFinderFeed != null) {
                kVar = baseFinderFeed.attachFavInfo;
            } else {
                kVar = null;
            }
            if (kVar != null) {
                k kVar4 = k.vfA;
                long lT = baseFinderFeed.lT();
                int i5 = this.ttO.tCE;
                String str4 = this.ttO.sGE;
                String str5 = this.ttO.sGQ;
                String str6 = this.ttO.sessionId;
                k kVar5 = k.vfA;
                String G = k.G(baseFinderFeed.lT(), this.ttO.tCE);
                com.tencent.mm.plugin.finder.storage.k kVar6 = baseFinderFeed.attachFavInfo;
                k.a(lT, 2, i5, str4, str5, str6, G, (kVar6 == null || !kVar6.vDG) ? 2 : 1);
            }
        }
        bo boVar2 = pVar.vgy;
        if (boVar2 != null && (boVar2 instanceof BaseFinderFeed)) {
            y yVar = y.vXH;
            if (y.C(((BaseFinderFeed) boVar2).feedObject)) {
                k kVar7 = k.vfA;
                k.a(this.ttO, pVar.feedId, Integer.valueOf(((BaseFinderFeed) boVar2).feedObject.getFeedObject().follow_feed_count));
            }
        }
        AppMethodBeat.o(250727);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter$reportExpose$1$1$1$convertData$1", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getItemId", "", "getItemType", "", "plugin-finder_release"})
    public static final class d implements com.tencent.mm.view.recyclerview.a {
        final /* synthetic */ FinderObject tpH;

        d(FinderObject finderObject) {
            this.tpH = finderObject;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final long lT() {
            return this.tpH.id;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final int cxn() {
            return 0;
        }
    }

    @Override // com.tencent.mm.plugin.finder.report.e
    public final LinkedList<ecq> dnM() {
        AppMethodBeat.i(250728);
        if (this.vfE.size() > 0) {
            LinkedList<ecq> linkedList = new LinkedList<>(this.vfE);
            this.vfE.clear();
            s sVar = s.vhF;
            s.a(linkedList, this.ttO, 0);
            AppMethodBeat.o(250728);
            return linkedList;
        }
        LinkedList<ecq> linkedList2 = new LinkedList<>();
        AppMethodBeat.o(250728);
        return linkedList2;
    }

    private final void gf(int i2, int i3) {
        AppMethodBeat.i(250729);
        k kVar = k.vfA;
        k.a(1, i2, i3, this.ttO);
        AppMethodBeat.o(250729);
    }

    @Override // com.tencent.mm.plugin.finder.report.e
    public final void onVisible() {
        LinkedList<WeakReference<WxRecyclerAdapter<?>>> linkedList;
        AppMethodBeat.i(250730);
        super.onVisible();
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.uLr);
        if (fH == null || (linkedList = fH.wzz) == null) {
            AppMethodBeat.o(250730);
            return;
        }
        Iterator<T> it = linkedList.iterator();
        while (it.hasNext()) {
            WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) it.next().get();
            if (wxRecyclerAdapter != null) {
                wxRecyclerAdapter.onResume();
            }
        }
        AppMethodBeat.o(250730);
    }

    @Override // com.tencent.mm.plugin.finder.report.e
    public final void onInvisible() {
        AppMethodBeat.i(250731);
        super.onInvisible();
        onExit();
        AppMethodBeat.o(250731);
    }

    public final void auL(String str) {
        int i2;
        AppMethodBeat.i(250732);
        kotlin.g.b.p.h(str, "feedActionValue");
        p pVar = this.vfI;
        if (pVar != null) {
            Log.i(TAG, "sendExtStatsReport ".concat(String.valueOf(str)));
            alc alc = new alc();
            alc.hFK = pVar.feedId;
            FinderItem finderItem = pVar.tHo;
            if (finderItem != null) {
                alc.finderUsername = finderItem.getUserName();
            }
            k kVar = k.vfA;
            alc.sessionBuffer = k.G(pVar.feedId, this.ttO.tCE);
            alc.Lub = str;
            alc.videoDuration = pVar.videoDuration;
            FinderItem finderItem2 = pVar.tHo;
            if (finderItem2 != null) {
                i2 = finderItem2.getMediaType();
            } else {
                i2 = 0;
            }
            alc.mediaType = i2;
            a.a(this.ttO, alc);
            AppMethodBeat.o(250732);
            return;
        }
        AppMethodBeat.o(250732);
    }

    private final void auM(String str) {
        AppMethodBeat.i(250734);
        this.vfF.add(str);
        AppMethodBeat.o(250734);
    }

    private static azw h(FinderItem finderItem) {
        AppMethodBeat.i(250735);
        if (finderItem != null) {
            azx azx = finderItem.getFeedObject().hotTopics;
            LinkedList<azw> linkedList = azx != null ? azx.Gbc : null;
            if (linkedList != null) {
                Iterator<azw> it = linkedList.iterator();
                while (it.hasNext()) {
                    azw next = it.next();
                    if (next != null && next.LJN == 5) {
                        AppMethodBeat.o(250735);
                        return next;
                    }
                }
            }
        }
        AppMethodBeat.o(250735);
        return null;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ o vfO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(o oVar) {
            super(0);
            this.vfO = oVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(250721);
            LinkedList linkedList = new LinkedList();
            for (Map.Entry<Long, p> entry : this.vfO.vfK.entrySet()) {
                ecq a2 = o.a(this.vfO, entry.getValue());
                long longValue = entry.getKey().longValue();
                p pVar = this.vfO.vfI;
                if (pVar == null || longValue != pVar.feedId) {
                    linkedList.add(a2);
                }
                this.vfO.vfG.b(entry.getValue());
            }
            o oVar = this.vfO;
            HashMap<Long, p> hashMap = new HashMap<>();
            kotlin.g.b.p.h(hashMap, "<set-?>");
            oVar.vfK = hashMap;
            o.b(this.vfO);
            p pVar2 = this.vfO.vfI;
            if (pVar2 != null) {
                pVar2.a(this.vfO.vdR);
                p.a aVar = p.vgC;
                ecq a3 = p.a.a(pVar2, this.vfO.ttO);
                linkedList.add(a3);
                o.a(this.vfO, pVar2, a3);
            }
            this.vfO.vfI = null;
            this.vfO.vfE.addAll(linkedList);
            o oVar2 = this.vfO;
            HashSet<Long> hashSet = new HashSet<>();
            kotlin.g.b.p.h(hashSet, "<set-?>");
            oVar2.vfJ = hashSet;
            this.vfO.vfG.dnD();
            x xVar = x.SXb;
            AppMethodBeat.o(250721);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ o vfO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(o oVar) {
            super(0);
            this.vfO = oVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(250720);
            this.vfO.dnM();
            x xVar = x.SXb;
            AppMethodBeat.o(250720);
            return xVar;
        }
    }

    private final void a(p pVar, ecq ecq) {
        Object obj;
        AppMethodBeat.i(250725);
        if (pVar.vfV > 0) {
            e.a.a(this.ttO, pVar.feedId, 5, String.valueOf(pVar.vfV), pVar.uOV, null, 32);
        }
        e.a.a(this.ttO, pVar.feedId, 2, String.valueOf(pVar.endTime - pVar.startTime), pVar.uOV, null, 32);
        if (pVar.vfY > 0) {
            e.a.a(this.ttO, pVar.feedId, 11, String.valueOf(pVar.vfY), pVar.uOV, null, 32);
        }
        bbn bbn = this.ttO;
        long j2 = pVar.feedId;
        mp mpVar = ecq.NcM;
        if (mpVar != null) {
            obj = Long.valueOf(mpVar.KQT);
        } else {
            obj = "";
        }
        e.a.a(bbn, j2, 3, String.valueOf(obj), pVar.uOV, null, 32);
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
        long j3 = pVar.feedId;
        String jSONObject2 = jSONObject.toString();
        kotlin.g.b.p.g(jSONObject2, "playInfoObj.toString()");
        e.a.a(bbn2, j3, 17, n.j(jSONObject2, ",", ";", false), pVar.uOV, null, 32);
        c cVar = c.vdc;
        String EY = c.EY(pVar.feedId);
        if (!Util.isNullOrNil(EY)) {
            e.a.a(this.ttO, pVar.feedId, 18, EY, pVar.uOV, null, 32);
        }
        e.a.a(this.ttO, pVar, 1);
        dog();
        AppMethodBeat.o(250725);
    }

    @Override // com.tencent.mm.plugin.finder.report.e
    public final void dnL() {
        this.vdP.vdU = true;
    }

    private final void dog() {
        alc alc;
        p pVar;
        boolean z = false;
        AppMethodBeat.i(250733);
        p pVar2 = this.vfI;
        if (pVar2 != null) {
            if (pVar2.vgr > 0) {
                auM(e.a.ah(ae.b(s.U("feedActionType", 13))));
            }
            if (pVar2.vgk > 0) {
                auM(e.a.ah(ae.b(s.U("feedActionType", 14))));
            }
        }
        e.b bVar = this.vdP;
        if (bVar.vdV) {
            auM(e.a.ah(ae.b(s.U("feedActionType", 11))));
        }
        if (bVar.vdU) {
            auM(e.a.ah(ae.b(s.U("feedActionType", 12))));
        }
        e.b bVar2 = this.vdP;
        bVar2.vdU = false;
        bVar2.vdV = false;
        LinkedList linkedList = new LinkedList();
        if (this.vfI != null) {
            for (T t : this.vfF) {
                Log.i(TAG, "reportExtStatsInCenterSwitch action: ".concat(String.valueOf(t)));
                kotlin.g.b.p.g(t, LocaleUtil.ITALIAN);
                if (Util.isNullOrNil((String) t) || (pVar = this.vfI) == null) {
                    alc = null;
                } else {
                    alc alc2 = new alc();
                    alc2.hFK = pVar.feedId;
                    FinderItem finderItem = pVar.tHo;
                    if (finderItem != null) {
                        alc2.finderUsername = finderItem.getUserName();
                    }
                    k kVar = k.vfA;
                    alc2.sessionBuffer = k.G(pVar.feedId, this.ttO.tCE);
                    alc2.Lub = t;
                    alc2.videoDuration = pVar.videoDuration;
                    FinderItem finderItem2 = pVar.tHo;
                    alc2.mediaType = finderItem2 != null ? finderItem2.getMediaType() : 0;
                    alc = alc2;
                }
                if (alc != null) {
                    linkedList.add(alc);
                }
            }
            this.vfF.clear();
            if (!linkedList.isEmpty()) {
                z = true;
            }
            if (z) {
                bbn bbn = this.ttO;
                LinkedList linkedList2 = linkedList;
                kotlin.g.b.p.h(linkedList2, "extStats");
                Log.i(TAG, "sendExtStatsReport " + linkedList2.size());
                g.azz().b(new aw(bbn, linkedList2));
            }
        }
        AppMethodBeat.o(250733);
    }
}
