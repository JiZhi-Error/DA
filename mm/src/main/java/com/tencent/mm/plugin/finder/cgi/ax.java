package com.tencent.mm.plugin.finder.cgi;

import android.content.Context;
import com.tencent.f.h;
import com.tencent.f.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.cgi.report.e;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0014J$\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010!\u001a\u00020\"J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\fJ&\u0010$\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020-H\u0016J>\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u00142\b\u00102\u001a\u0004\u0018\u00010\b2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u00103\u001a\u0004\u0018\u000104H\u0016J>\u00105\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u00142\b\u00102\u001a\u0004\u0018\u00010\b2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\n\u00106\u001a\u0004\u0018\u00010\u001bH\u0016J\u001e\u00107\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016J\b\u00108\u001a\u00020\u0017H\u0002J\u000e\u00109\u001a\u00020\u00172\u0006\u0010:\u001a\u00020;R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "Lcom/tencent/mm/plugin/finder/cgi/report/ICgiTrack;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;", "report", "Lcom/tencent/mm/plugin/finder/cgi/report/FinderCgiReport;", "getReport", "()Lcom/tencent/mm/plugin/finder/cgi/report/FinderCgiReport;", "report$delegate", "Lkotlin/Lazy;", "timeout", "", "timeoutCallback", "Lkotlin/Function0;", "", "timeoutTask", "Lcom/tencent/threadpool/runnable/FutureEx;", "actionExt", "Lorg/json/JSONObject;", "cancel", "delayLoading", "context", "Landroid/content/Context;", "wording", "delay", "", "customLoadingComponent", "dispatch", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "rr", "Lcom/tencent/mm/network/IReqResp;", "callback", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "isFetchFeedCgi", "", "onCgiEnd", "netId", "errType", "errCode", "errMsg", "cookie", "", "onGYNetEnd", "resultExt", "setTimeOut", "timeoutLogic", "updateFeedSessionBuffer", ch.COL_FINDEROBJECT, "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
public abstract class ax extends q implements m, e {
    final String TAG;
    private int timeout;
    public final bbn ttO;
    d<?> tuR;
    kotlin.g.a.a<x> tuS;
    private com.tencent.mm.plugin.finder.utils.b tux;
    private final f tuz;

    private final com.tencent.mm.plugin.finder.cgi.report.d cYa() {
        return (com.tencent.mm.plugin.finder.cgi.report.d) this.tuz.getValue();
    }

    public /* synthetic */ ax() {
        this(null);
    }

    public ax(bbn bbn) {
        this.ttO = bbn;
        this.TAG = "Finder.NetSceneFinderBase";
        this.tuz = g.ah(new a(this));
        if (cXQ()) {
            k kVar = k.vfA;
            bbn bbn2 = this.ttO;
            k.Ku(bbn2 != null ? bbn2.tCE : 0);
        }
        bbn bbn3 = this.ttO;
        if (bbn3 != null) {
            Log.i(this.TAG, "Create commentScene:" + bbn3.tCE + " fromCommentScene:" + bbn3.tyh);
            cYa().tyh = bbn3.tyh;
        }
    }

    public boolean cXQ() {
        return false;
    }

    public final ax d(Context context, String str, long j2) {
        p.h(context, "context");
        b.a aVar = com.tencent.mm.plugin.finder.utils.b.vVa;
        this.tux = b.a.e(context, str, j2);
        return this;
    }

    @Override // com.tencent.mm.ak.q
    public void cancel() {
        com.tencent.mm.plugin.finder.utils.b bVar = this.tux;
        if (bVar != null) {
            bVar.end();
        }
        super.cancel();
    }

    @Override // com.tencent.mm.ak.q
    public int dispatch(com.tencent.mm.network.g gVar, s sVar, m mVar) {
        s sVar2;
        com.tencent.mm.plugin.finder.utils.b bVar = this.tux;
        if (bVar != null) {
            bVar.begin();
        }
        com.tencent.mm.plugin.finder.cgi.report.d cYa = cYa();
        if (cYa != null) {
            if (!(sVar instanceof com.tencent.mm.ak.d)) {
                sVar2 = null;
            } else {
                sVar2 = sVar;
            }
            cYa.g((com.tencent.mm.ak.d) sVar2);
        }
        d<?> dVar = this.tuR;
        if (dVar != null) {
            dVar.cancel(false);
        }
        if (this.timeout > 0) {
            Log.i(this.TAG, "time out:" + this.timeout);
            this.tuR = h.RTc.o(new b(this), (long) this.timeout);
        }
        return super.dispatch(gVar, sVar, mVar);
    }

    @Override // com.tencent.mm.network.m
    public void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        s sVar2;
        cYa().cZt();
        com.tencent.mm.plugin.finder.utils.b bVar = this.tux;
        if (bVar != null) {
            bVar.end();
        }
        d<?> dVar = this.tuR;
        if (dVar != null) {
            dVar.cancel(false);
        }
        com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
        com.tencent.mm.plugin.finder.spam.a.t(i3, i4, str);
        com.tencent.mm.plugin.finder.spam.a aVar2 = com.tencent.mm.plugin.finder.spam.a.vwk;
        com.tencent.mm.plugin.finder.spam.a.u(i3, i4, str);
        a(i2, i3, i4, str, sVar);
        cYa().cZu();
        com.tencent.mm.plugin.finder.cgi.report.d cYa = cYa();
        if (!(sVar instanceof com.tencent.mm.ak.d)) {
            sVar2 = null;
        } else {
            sVar2 = sVar;
        }
        cYa.b(i3, i4, str, (com.tencent.mm.ak.d) sVar2);
    }

    public void a(int i2, int i3, int i4, String str, s sVar) {
    }

    public final void d(FinderObject finderObject) {
        LinkedList<FinderObject> linkedList;
        p.h(finderObject, ch.COL_FINDEROBJECT);
        bbn bbn = this.ttO;
        if (bbn != null) {
            k kVar = k.vfA;
            k.e(finderObject.id, bbn.tCE, finderObject.sessionBuffer);
        }
        ard ard = finderObject.foldedLayout;
        if (!(ard == null || (linkedList = ard.LCW) == null)) {
            for (T t : linkedList) {
                k kVar2 = k.vfA;
                k.e(t.id, 14, t.sessionBuffer);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ ax tuT;

        b(ax axVar) {
            this.tuT = axVar;
        }

        public final void run() {
            AppMethodBeat.i(242359);
            this.tuT.cancel();
            this.tuT.tuR = null;
            Log.i(this.tuT.TAG, "time out!");
            kotlin.g.a.a<x> aVar = this.tuT.tuS;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(242359);
                return;
            }
            AppMethodBeat.o(242359);
        }
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e
    public com.tencent.mm.plugin.finder.cgi.report.b cXS() {
        return com.tencent.mm.plugin.finder.cgi.report.b.Default;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e
    public JSONObject cXV() {
        return null;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e
    public JSONObject cXW() {
        return null;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/cgi/report/FinderCgiReport;", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.cgi.report.d> {
        final /* synthetic */ ax tuT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ax axVar) {
            super(0);
            this.tuT = axVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.cgi.report.d invoke() {
            AppMethodBeat.i(242358);
            com.tencent.mm.plugin.finder.cgi.report.d dVar = new com.tencent.mm.plugin.finder.cgi.report.d(this.tuT);
            AppMethodBeat.o(242358);
            return dVar;
        }
    }
}
