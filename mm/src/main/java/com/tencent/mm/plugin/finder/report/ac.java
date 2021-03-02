package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.cl;
import com.tencent.mm.g.b.a.cm;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.plugin.finder.storage.o;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J'\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\u0006\u0010\n\u001a\u0002H\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\u0006\u0010\n\u001a\u0002H\bH\u0002¢\u0006\u0002\u0010\u000fJ'\u0010\u0010\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\u0006\u0010\n\u001a\u0002H\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018J\"\u0010\u0019\u001a\u00020\u00152\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/LbsCardFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fillCardInfo", "T", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "struct", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "(Lcom/tencent/mm/plugin/report/AbsReportStruct;Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;)Lcom/tencent/mm/plugin/report/AbsReportStruct;", "fillCommonInfo", "(Lcom/tencent/mm/plugin/report/AbsReportStruct;)Lcom/tencent/mm/plugin/report/AbsReportStruct;", "fillFeedInfo", "baseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Lcom/tencent/mm/plugin/report/AbsReportStruct;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Lcom/tencent/mm/plugin/report/AbsReportStruct;", "reportClick", "", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLbsCardActionReportStruct;", "feedIndex", "", "reportExpose", "dataList", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "refreshTime", "", "reportExposeInternal", "cardStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLbsCardExposeReportStruct;", "plugin-finder_release"})
public final class ac extends e {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ac(MMActivity mMActivity, bbn bbn) {
        super(mMActivity, bbn);
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(bbn, "contextObj");
        AppMethodBeat.i(250832);
        AppMethodBeat.o(250832);
    }

    public final void e(List<b<c>> list, long j2) {
        AppMethodBeat.i(250828);
        p.h(list, "dataList");
        for (T t : list) {
            o oVar = ((c) t.RqA).uNJ.vEF;
            if (oVar != null) {
                cm cmVar = (cm) a((cm) b(new cm()), oVar);
                cmVar.mp(d.zs(j2));
                cmVar.adi();
                cmVar.gA((long) t.Qgj);
                cmVar.gC(t.wVY);
                cmVar.gD(t.startTime);
                cmVar.gE(t.endTime);
                cmVar.gG(t.wVY);
                cmVar.gH(t.startTime);
                cmVar.gI(t.endTime);
                int i2 = 0;
                for (T t2 : oVar.vDZ) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        j.hxH();
                    }
                    T t3 = t2;
                    if (i2 < 3) {
                        cm cmVar2 = (cm) a((a) new cm(cmVar.abV()), (BaseFinderFeed) t3);
                        cmVar2.gF((long) i2);
                        cmVar2.bfK();
                        i2 = i3;
                    } else {
                        i2 = i3;
                    }
                }
            }
        }
        AppMethodBeat.o(250828);
    }

    public final <T extends a> T b(T t) {
        AppMethodBeat.i(250829);
        if (t instanceof cm) {
            ((cm) t).mm(this.ttO.sessionId);
            ((cm) t).mn(this.ttO.sGQ);
            ((cm) t).mo(this.ttO.sGE);
        } else if (t instanceof cl) {
            ((cl) t).mf(this.ttO.sessionId);
            ((cl) t).mg(this.ttO.sGQ);
            ((cl) t).mh(this.ttO.sGE);
        }
        AppMethodBeat.o(250829);
        return t;
    }

    public static <T extends a> T a(T t, o oVar) {
        AppMethodBeat.i(250830);
        if (t instanceof cm) {
            ((cm) t).mq(oVar.dxF());
            ((cm) t).gB((long) oVar.dxE().jjN);
            ((cm) t).mr(oVar.cxc());
            ((cm) t).ms(oVar.dxH());
        } else if (t instanceof cl) {
            ((cl) t).mi(oVar.dxF());
            ((cl) t).gy((long) oVar.dxE().jjN);
            ((cl) t).mj(oVar.cxc());
        }
        AppMethodBeat.o(250830);
        return t;
    }

    public static <T extends a> T a(T t, BaseFinderFeed baseFinderFeed) {
        AppMethodBeat.i(250831);
        if (t instanceof cm) {
            ((cm) t).mt(d.zs(baseFinderFeed.lT()));
            ((cm) t).mu(baseFinderFeed.getSessionBuffer());
            ((cm) t).mw(String.valueOf(baseFinderFeed.feedObject.getLocation().dTj));
            ((cm) t).mv(String.valueOf(baseFinderFeed.feedObject.getLocation().latitude));
        } else if (t instanceof cl) {
            ((cl) t).mk(d.zs(baseFinderFeed.lT()));
            ((cl) t).ml(baseFinderFeed.getSessionBuffer());
        }
        AppMethodBeat.o(250831);
        return t;
    }
}
