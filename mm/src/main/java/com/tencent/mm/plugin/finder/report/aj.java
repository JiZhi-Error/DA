package com.tencent.mm.plugin.finder.report;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/Reporter21875;", "", "()V", "report21875", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", NativeProtocol.WEB_DIALOG_ACTION, "", "expose", "", "feedId", "", "plugin-finder_release"})
public final class aj {
    public static final aj viU = new aj();

    static {
        AppMethodBeat.i(250882);
        AppMethodBeat.o(250882);
    }

    private aj() {
    }

    public static void a(bbn bbn, String str, boolean z, long j2) {
        int i2 = 0;
        AppMethodBeat.i(250881);
        p.h(str, NativeProtocol.WEB_DIALOG_ACTION);
        if (bbn != null) {
            i iVar = new i();
            iVar.h("feedid", b.zs(j2));
            String iVar2 = iVar.toString();
            p.g(iVar2, "JSONObject().apply {\n   …\n            }.toString()");
            String j3 = n.j(iVar2, ",", ";", false);
            Log.i("report21875", "report 21875 sessionId:" + bbn.sessionId + ", contextId:" + bbn.sGQ + ", commentScene:" + bbn.tCE + ", expose:" + z + ", eid:" + str + ", udf_kv:" + j3 + ", clickTabContextId:" + bbn.sGE);
            h hVar = h.INSTANCE;
            Object[] objArr = new Object[8];
            objArr[0] = bbn.sessionId;
            objArr[1] = bbn.sGQ;
            objArr[2] = Integer.valueOf(bbn.tCE);
            if (!z) {
                i2 = 1;
            }
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = String.valueOf(System.currentTimeMillis());
            objArr[5] = str;
            objArr[6] = j3;
            objArr[7] = bbn.sGE;
            hVar.a(21875, objArr);
            AppMethodBeat.o(250881);
            return;
        }
        AppMethodBeat.o(250881);
    }
}
