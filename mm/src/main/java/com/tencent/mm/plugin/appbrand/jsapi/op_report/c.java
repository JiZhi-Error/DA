package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.clh;
import com.tencent.mm.protocal.protobuf.dol;
import com.tencent.mm.protocal.protobuf.dom;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/op_report/OpReportUtil;", "", "()V", "getReportIdOrThrows", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "matchNetScene", "", "requestAppID", "", "plugin-appbrand-integration_release"})
public final class c {
    public static final c mjJ = new c();

    static {
        AppMethodBeat.i(50632);
        AppMethodBeat.o(50632);
    }

    private c() {
    }

    public static final boolean b(q qVar, String str) {
        clh clh;
        String str2 = null;
        AppMethodBeat.i(50630);
        p.h(str, "requestAppID");
        s reqResp = qVar != null ? qVar.getReqResp() : null;
        if (!(reqResp instanceof d)) {
            reqResp = null;
        }
        d dVar = (d) reqResp;
        a aYJ = dVar != null ? dVar.aYJ() : null;
        if (!(aYJ instanceof dol)) {
            aYJ = null;
        }
        dol dol = (dol) aYJ;
        if (!(dol == null || (clh = dol.MRN) == null)) {
            str2 = clh.dNI;
        }
        boolean j2 = p.j(str2, str);
        AppMethodBeat.o(50630);
        return j2;
    }

    public static final int e(q qVar) {
        AppMethodBeat.i(50631);
        s reqResp = qVar != null ? qVar.getReqResp() : null;
        if (!(reqResp instanceof d)) {
            reqResp = null;
        }
        d dVar = (d) reqResp;
        a aYK = dVar != null ? dVar.aYK() : null;
        if (!(aYK instanceof dom)) {
            aYK = null;
        }
        dom dom = (dom) aYK;
        if (dom != null) {
            int i2 = dom.MRO;
            AppMethodBeat.o(50631);
            return i2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        AppMethodBeat.o(50631);
        throw illegalArgumentException;
    }
}
