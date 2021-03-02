package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/util/ExptReportLogic;", "", "()V", "TAG", "", "structLog", "", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "plugin-comm_release"})
public final class b {
    public static final b QYu = new b();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(223482);
        AppMethodBeat.o(223482);
    }

    private b() {
    }

    public static void a(a aVar) {
        AppMethodBeat.i(223481);
        p.h(aVar, "struct");
        String str = TAG;
        String abW = aVar.abW();
        p.g(abW, "struct.toShowString()");
        Log.i(str, "report%s %s", Integer.valueOf(aVar.getId()), n.j(abW, APLogFileUtil.SEPARATOR_LINE, " ", false));
        AppMethodBeat.o(223481);
    }
}
