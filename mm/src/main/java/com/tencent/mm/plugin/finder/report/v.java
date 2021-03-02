package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.cd;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\rH\u0002R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMFragmentActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMFragmentActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "lastVisibleFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "Lkotlin/collections/HashMap;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "needMarkRead", "onEventHappen", "", "onExit", "onInvisible", "onRelease", "visibleItemToInvisible", "Lcom/tencent/mm/protocal/protobuf/Stats;", "record", "fastSlip", "Companion", "plugin-finder_release"})
public final class v extends e {
    public static final a vhK = new a((byte) 0);
    private HashMap<Long, w> vfK = new HashMap<>();

    static {
        AppMethodBeat.i(250813);
        AppMethodBeat.o(250813);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(MMFragmentActivity mMFragmentActivity, bbn bbn) {
        super(mMFragmentActivity, bbn);
        p.h(mMFragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(bbn, "contextObj");
        AppMethodBeat.i(250812);
        AppMethodBeat.o(250812);
    }

    public static final /* synthetic */ ecq a(v vVar, w wVar) {
        AppMethodBeat.i(250814);
        ecq a2 = vVar.a(wVar, false);
        AppMethodBeat.o(250814);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.report.e, com.tencent.mm.plugin.finder.event.base.d
    public final void onRelease() {
        AppMethodBeat.i(250807);
        onExit();
        super.onRelease();
        AppMethodBeat.o(250807);
    }

    private final void onExit() {
        AppMethodBeat.i(250808);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        d.c(FinderReporterUIC.kWD, new b(this));
        AppMethodBeat.o(250808);
    }

    @Override // com.tencent.mm.plugin.finder.report.e, com.tencent.mm.plugin.finder.event.base.d
    public final boolean a(c cVar, com.tencent.mm.plugin.finder.event.base.b bVar) {
        AppMethodBeat.i(250809);
        p.h(cVar, "dispatcher");
        p.h(bVar, "event");
        if (bVar instanceof com.tencent.mm.plugin.finder.event.base.l) {
            AppMethodBeat.o(250809);
            return true;
        }
        AppMethodBeat.o(250809);
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.report.e, com.tencent.mm.plugin.finder.event.base.d
    public final void a(com.tencent.mm.plugin.finder.event.base.b bVar) {
        boolean z;
        FinderItem finderItem;
        FinderItem finderItem2;
        ArrayList arrayList;
        AppMethodBeat.i(250810);
        p.h(bVar, "event");
        if (bVar instanceof com.tencent.mm.plugin.finder.event.base.l) {
            switch (this.ttO.tCE) {
                case 22:
                case 26:
                    if (this.ttO.tyh == 34) {
                        z = true;
                        break;
                    } else {
                        z = false;
                        break;
                    }
                case 23:
                case 24:
                case 25:
                case 27:
                case 29:
                default:
                    z = false;
                    break;
                case 28:
                case 30:
                    z = true;
                    break;
            }
            Log.d("Finder.FinderTwoFeedFlowReporter", "needMarkRead:" + z + " commentScene:" + this.ttO.tCE + " fromCommentScene:" + this.ttO.tyh);
            if (z) {
                as asVar = as.uOL;
                List<g> list = ((com.tencent.mm.plugin.finder.event.base.l) bVar).tIH;
                if (list != null) {
                    List<g> list2 = list;
                    ArrayList arrayList2 = new ArrayList(j.a(list2, 10));
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
            if (!(((com.tencent.mm.plugin.finder.event.base.l) bVar).ptb == ((com.tencent.mm.plugin.finder.event.base.l) bVar).tIy && ((com.tencent.mm.plugin.finder.event.base.l) bVar).tIA == ((com.tencent.mm.plugin.finder.event.base.l) bVar).ptc)) {
                HashSet hashSet = new HashSet();
                HashSet hashSet2 = new HashSet();
                hashSet.addAll(this.vfK.keySet());
                List<g> list3 = ((com.tencent.mm.plugin.finder.event.base.l) bVar).tII;
                if (list3 != null) {
                    for (T t : list3) {
                        hashSet.add(Long.valueOf(t.tIu.lT()));
                        hashSet2.add(Long.valueOf(t.tIu.lT()));
                    }
                }
                List<g> list4 = ((com.tencent.mm.plugin.finder.event.base.l) bVar).tIH;
                if (list4 != null) {
                    ArrayList<g> arrayList3 = new ArrayList();
                    for (T t2 : list4) {
                        if (!hashSet.contains(Long.valueOf(t2.tIu.lT()))) {
                            arrayList3.add(t2);
                        }
                    }
                    for (g gVar : arrayList3) {
                        long lT = gVar.tIu.lT();
                        long j2 = bVar.tHW;
                        if (gVar.tIu instanceof BaseFinderFeed) {
                            finderItem2 = ((BaseFinderFeed) gVar.tIu).feedObject;
                        } else {
                            finderItem2 = null;
                        }
                        w wVar = new w(lT, j2, finderItem2);
                        wVar.vfP = gVar.tIv;
                        wVar.tIw = gVar.tIw;
                        a(wVar, true);
                    }
                }
                for (Map.Entry<Long, w> entry : this.vfK.entrySet()) {
                    if (!hashSet2.contains(entry.getKey())) {
                        a(entry.getValue(), false);
                    }
                }
                HashMap<Long, w> hashMap = new HashMap<>();
                List<g> list5 = ((com.tencent.mm.plugin.finder.event.base.l) bVar).tII;
                if (list5 != null) {
                    for (T t3 : list5) {
                        w wVar2 = this.vfK.get(Long.valueOf(t3.tIu.lT()));
                        if (wVar2 != null) {
                            hashMap.put(Long.valueOf(t3.tIu.lT()), wVar2);
                        } else {
                            long lT2 = t3.tIu.lT();
                            long j3 = bVar.tHW;
                            if (t3.tIu instanceof BaseFinderFeed) {
                                finderItem = ((BaseFinderFeed) t3.tIu).feedObject;
                            } else {
                                finderItem = null;
                            }
                            w wVar3 = new w(lT2, j3, finderItem);
                            wVar3.vfP = t3.tIv;
                            wVar3.tIw = t3.tIw;
                            hashMap.put(Long.valueOf(t3.tIu.lT()), wVar3);
                        }
                    }
                }
                this.vfK = hashMap;
            }
        }
        AppMethodBeat.o(250810);
    }

    @Override // com.tencent.mm.plugin.finder.report.e
    public final void onInvisible() {
        AppMethodBeat.i(250811);
        super.onInvisible();
        onExit();
        AppMethodBeat.o(250811);
    }

    private final ecq a(w wVar, boolean z) {
        String str;
        String str2;
        long j2;
        FinderObject finderObject;
        FinderObject finderObject2;
        FinderObjectDesc finderObjectDesc;
        azr azr;
        cd cdVar;
        long j3;
        boolean z2;
        FinderObject finderObject3;
        FinderObjectDesc finderObjectDesc2;
        azs azs;
        FinderObject finderObject4;
        long j4;
        String str3;
        int i2;
        int i3;
        AppMethodBeat.i(250806);
        if (wVar.endTime == 0) {
            wVar.endTime = cl.aWA();
        }
        w.a aVar = w.vhM;
        p.h(wVar, "record");
        ecq ecq = new ecq();
        BitSet bitSet = new BitSet(64);
        ecq.hFK = wVar.feedId;
        FinderItem finderItem = wVar.tHo;
        if (finderItem == null || (str = finderItem.getObjectNonceId()) == null) {
            str = "";
        }
        ecq.objectNonceId = str;
        ecq.NcM = new mp();
        ecq.NcN = new epf();
        ecq.NcO = new cxr();
        FinderItem finderItem2 = wVar.tHo;
        if (finderItem2 == null || (str2 = finderItem2.field_username) == null) {
            str2 = "";
        }
        ecq.finderUsername = str2;
        float f2 = ((float) (wVar.endTime - wVar.startTime)) / 1000.0f;
        if (f2 < 0.5f) {
            bitSet.set(21, true);
        } else if (f2 < 1.0f) {
            bitSet.set(22, true);
        } else if (f2 < 2.0f) {
            bitSet.set(23, true);
        } else if (f2 < 3.0f) {
            bitSet.set(24, true);
        } else if (f2 < 5.0f) {
            bitSet.set(25, true);
        } else if (f2 < 10.0f) {
            bitSet.set(26, true);
        } else if (f2 < 20.0f) {
            bitSet.set(27, true);
        } else if (f2 < 30.0f) {
            bitSet.set(28, true);
        } else if (f2 < 40.0f) {
            bitSet.set(29, true);
        } else if (f2 < 50.0f) {
            bitSet.set(30, true);
        } else {
            bitSet.set(31, true);
        }
        long j5 = bitSet.toLongArray()[0];
        mp mpVar = ecq.NcM;
        if (mpVar != null) {
            mpVar.KQT = j5;
        }
        epf epf = ecq.NcN;
        if (epf != null) {
            epf.ElR = (int) f2;
        }
        cxr cxr = ecq.NcO;
        if (cxr != null) {
            cxr.MCg = (int) f2;
        }
        cxr cxr2 = ecq.NcO;
        if (cxr2 != null) {
            cxr2.MCp = wVar.vfP;
        }
        cxr cxr3 = ecq.NcO;
        if (cxr3 != null) {
            if (z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            cxr3.MCo = i3;
        }
        FinderItem finderItem3 = wVar.tHo;
        if (finderItem3 != null) {
            cxr cxr4 = ecq.NcO;
            if (cxr4 != null) {
                cxr4.MCl = finderItem3.getLikeFlag() != 0 ? 1 : 0;
            }
            cxr cxr5 = ecq.NcO;
            if (cxr5 != null) {
                c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
                cxr5.vPj = c.a.asJ(finderItem3.getUserName()) ? 1 : 0;
            }
            cxr cxr6 = ecq.NcO;
            if (cxr6 != null) {
                if (finderItem3.getFavFlag() == 1) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                cxr6.MCn = i2;
            }
        }
        bbn bbn = this.ttO;
        p.h(bbn, "contextObj");
        p.h(wVar, "record");
        cd cdVar2 = new cd();
        cdVar2.fv((long) bbn.tCE);
        cdVar2.le(d.zs(wVar.feedId));
        cdVar2.lb(bbn.sessionId);
        cdVar2.lc(bbn.sGQ);
        cdVar2.ld(bbn.sGE);
        cdVar2.fz(wVar.startTime);
        cdVar2.fA(wVar.endTime);
        cdVar2.fy(wVar.endTime - wVar.startTime);
        FinderItem finderItem4 = wVar.tHo;
        if (finderItem4 != null) {
            cdVar2.fB((long) finderItem4.getLikeCount());
            String str4 = bbn.wza;
            if (str4 == null || (str3 = n.j(str4, ",", ";", false)) == null) {
                str3 = "";
            }
            cdVar2.lg(str3);
            cdVar2.fC((long) finderItem4.getMediaType());
        }
        cdVar2.fw((long) wVar.vfP);
        k kVar = k.vfA;
        cdVar2.fx(k.Kt(bbn.tCE));
        w.a aVar3 = w.vhM;
        cdVar2.lf(n.j(w.a.a(wVar), ",", ";", false));
        k kVar2 = k.vfA;
        cdVar2.lh(k.G(wVar.feedId, bbn.tCE));
        if (bbn.tCE == 15) {
            FinderItem finderItem5 = wVar.tHo;
            if (finderItem5 != null) {
                finderObject4 = finderItem5.getFeedObject();
            } else {
                finderObject4 = null;
            }
            if (finderObject4 != null) {
                switch (wVar.tHo.getFeedObject().recommendReasonType) {
                    case 1:
                        j4 = 1;
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    default:
                        j4 = 0;
                        break;
                    case 9:
                        j4 = 6;
                        break;
                    case 10:
                        j4 = 2;
                        break;
                    case 11:
                        j4 = 3;
                        break;
                    case 12:
                        j4 = 5;
                        break;
                    case 13:
                        j4 = 4;
                        break;
                }
                cdVar2.fD(j4);
                String str5 = wVar.tHo.getFeedObject().recommendReason;
                if (str5 == null) {
                    str5 = "";
                }
                cdVar2.li(str5);
            }
        }
        FinderItem finderItem6 = wVar.tHo;
        if (!(finderItem6 == null || (finderObject3 = finderItem6.getFinderObject()) == null || (finderObjectDesc2 = finderObject3.objectDesc) == null || (azs = finderObjectDesc2.event) == null)) {
            cdVar2.lk(d.zs(azs.twd));
            cdVar2.PK((long) bbn.dLS);
        }
        FinderItem finderItem7 = wVar.tHo;
        if (finderItem7 == null || (finderObject2 = finderItem7.getFinderObject()) == null || (finderObjectDesc = finderObject2.objectDesc) == null || (azr = finderObjectDesc.feedBgmInfo) == null) {
            FinderItem finderItem8 = wVar.tHo;
            if (finderItem8 == null || (finderObject = finderItem8.getFinderObject()) == null) {
                j2 = 0;
            } else {
                j2 = finderObject.id;
            }
            cdVar2.lj(d.zs(j2));
            FinderItem finderItem9 = wVar.tHo;
            if (finderItem9 != null && finderItem9.getMediaType() == 4) {
                cdVar2.fE(1);
            }
        } else {
            cdVar2.lj(azr.groupId);
            if (azr.musicInfo != null) {
                azk azk = azr.musicInfo;
                String str6 = azk != null ? azk.wWb : null;
                if (str6 == null || str6.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    j3 = 2;
                    cdVar = cdVar2;
                    cdVar.fE(j3);
                }
            }
            cdVar = cdVar2;
            j3 = 1;
            cdVar.fE(j3);
        }
        cdVar2.eOp();
        k kVar3 = k.vfA;
        k.a(cdVar2);
        AppMethodBeat.o(250806);
        return ecq;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ v vhL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(v vVar) {
            super(0);
            this.vhL = vVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(250805);
            for (Map.Entry entry : this.vhL.vfK.entrySet()) {
                v.a(this.vhL, (w) entry.getValue());
            }
            this.vhL.vfK = new HashMap();
            x xVar = x.SXb;
            AppMethodBeat.o(250805);
            return xVar;
        }
    }
}
