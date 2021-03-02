package com.tencent.mm.plugin.finder.cgi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.cgi.report.d;
import com.tencent.mm.plugin.finder.cgi.report.e;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u0011\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J*\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u001e\u001a\u00020\u001fJ\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010 \u001a\u00020\rJ\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u0015H\u0016J9\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020$2\b\u0010+\u001a\u0004\u0018\u00010\t2\u0006\u0010,\u001a\u00028\u00002\b\u0010-\u001a\u0004\u0018\u00010.H\u0014¢\u0006\u0002\u0010/J9\u00100\u001a\u00020\u00192\u0006\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020$2\b\u0010+\u001a\u0004\u0018\u00010\t2\u0006\u0010,\u001a\u00028\u00002\b\u0010-\u001a\u0004\u0018\u00010.H&¢\u0006\u0002\u0010/J\n\u00101\u001a\u0004\u0018\u00010\u0017H\u0016J\u0014\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000403H\u0016J\u0014\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u000208R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/finder/cgi/report/ICgiTrack;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;", "report", "Lcom/tencent/mm/plugin/finder/cgi/report/FinderCgiReport;", "getReport", "()Lcom/tencent/mm/plugin/finder/cgi/report/FinderCgiReport;", "report$delegate", "Lkotlin/Lazy;", "showErrorTips", "", "actionExt", "Lorg/json/JSONObject;", "cancel", "", "delayLoading", "context", "Landroid/content/Context;", "wording", "delay", "", "customLoadingComponent", "getCgiReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getCmdId", "", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "isFetchFeedCgi", "onCgiBack", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "onCgiEnd", "resultExt", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "setShowErrorTips", "updateFeedSessionBuffer", ch.COL_FINDEROBJECT, "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
public abstract class an<_Resp extends dpc> extends c<_Resp> implements e {
    private final String TAG;
    final bbn ttO;
    private b tux;
    public boolean tuy;
    private final f tuz;

    private final d cYa() {
        return (d) this.tuz.getValue();
    }

    public abstract void b(int i2, int i3, String str, _Resp _resp, q qVar);

    public /* synthetic */ an() {
        this(null);
    }

    public an(bbn bbn) {
        this.ttO = bbn;
        this.TAG = "Finder.FinderCgi";
        this.tuy = true;
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

    @Override // com.tencent.mm.ak.c
    public final void a(int i2, int i3, String str, _Resp _resp, q qVar) {
        p.h(_resp, "resp");
        super.a(i2, i3, str, _resp, qVar);
        cYa().cZt();
        b bVar = this.tux;
        if (bVar != null) {
            bVar.end();
        }
        b(i2, i3, str, _resp, qVar);
        cYa().cZu();
        cYa().b(i2, i3, str, aYG());
        if (this.tuy) {
            com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
            com.tencent.mm.plugin.finder.spam.a.t(i2, i3, str);
            com.tencent.mm.plugin.finder.spam.a aVar2 = com.tencent.mm.plugin.finder.spam.a.vwk;
            com.tencent.mm.plugin.finder.spam.a.u(i2, i3, str);
        }
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

    public final an<_Resp> c(Context context, String str, long j2) {
        p.h(context, "context");
        b.a aVar = b.vVa;
        this.tux = b.a.e(context, str, j2);
        return this;
    }

    @Override // com.tencent.mm.ak.c
    public com.tencent.mm.co.f<c.a<_Resp>> aYI() {
        b bVar = this.tux;
        if (bVar != null) {
            bVar.begin();
        }
        d cYa = cYa();
        if (cYa != null) {
            cYa.g(aYG());
        }
        com.tencent.mm.co.f<c.a<_Resp>> aYI = super.aYI();
        p.g(aYI, "super.run()");
        return aYI;
    }

    @Override // com.tencent.mm.ak.c
    public final void cancel() {
        b bVar = this.tux;
        if (bVar != null) {
            bVar.end();
        }
        super.cancel();
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

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/cgi/report/FinderCgiReport;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<d> {
        final /* synthetic */ an tuA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(an anVar) {
            super(0);
            this.tuA = anVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ d invoke() {
            AppMethodBeat.i(242327);
            d dVar = new d(this.tuA);
            AppMethodBeat.o(242327);
            return dVar;
        }
    }
}
