package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.event.base.j;
import com.tencent.mm.plugin.finder.report.p;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderImportantFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMFragmentActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMFragmentActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "Companion", "plugin-finder_release"})
public final class g extends o {
    private static final String TAG = TAG;
    private static LinkedList<ecq> vej = new LinkedList<>();
    public static final a vek = new a((byte) 0);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(MMFragmentActivity mMFragmentActivity, bbn bbn) {
        super(mMFragmentActivity, bbn);
        p.h(mMFragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(bbn, "contextObj");
        AppMethodBeat.i(250556);
        AppMethodBeat.o(250556);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderImportantFeedFlowReporter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "streamCgiStats", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "getWaitForReportStatsListAndClear", "tabType", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static LinkedList<ecq> Kc(int i2) {
            AppMethodBeat.i(250553);
            if (i2 == 4) {
                LinkedList<ecq> linkedList = g.vej;
                g.vej = new LinkedList();
                Log.i(g.TAG, "streamCgiStats returnList " + linkedList.size());
                if (BuildInfo.DEBUG) {
                    Iterator<T> it = linkedList.iterator();
                    while (it.hasNext()) {
                        p.a aVar = p.vgC;
                        a aVar2 = g.vek;
                        p.a.a(it.next(), g.TAG);
                    }
                }
                AppMethodBeat.o(250553);
                return linkedList;
            }
            AppMethodBeat.o(250553);
            return null;
        }
    }

    static {
        AppMethodBeat.i(250557);
        AppMethodBeat.o(250557);
    }

    @Override // com.tencent.mm.plugin.finder.report.o, com.tencent.mm.plugin.finder.report.e, com.tencent.mm.plugin.finder.event.base.d
    public final void a(com.tencent.mm.plugin.finder.event.base.b bVar) {
        AppMethodBeat.i(250555);
        kotlin.g.b.p.h(bVar, "event");
        super.a(bVar);
        if ((bVar instanceof j) && ((j) bVar).tCi != ((j) bVar).tIC) {
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            d.c(FinderReporterUIC.kWD, new b(this));
        }
        AppMethodBeat.o(250555);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g vel;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(g gVar) {
            super(0);
            this.vel = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(250554);
            LinkedList<ecq> dnM = this.vel.dnM();
            synchronized (g.vej) {
                try {
                    g.vej.addAll(dnM);
                } catch (Throwable th) {
                    AppMethodBeat.o(250554);
                    throw th;
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(250554);
            return xVar;
        }
    }
}
