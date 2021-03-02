package com.tencent.mm.plugin.auto.a;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/auto/model/AutoReportLogic;", "", "()V", "IDKey", "", "getIDKey", "()J", "reportIdKey", "", NativeProtocol.WEB_DIALOG_ACTION, "app_release"})
public final class b {
    private static final long oIF = oIF;
    public static final b oIG = new b();

    static {
        AppMethodBeat.i(230598);
        AppMethodBeat.o(230598);
    }

    private b() {
    }

    public static void Bt(long j2) {
        AppMethodBeat.i(230597);
        e.INSTANCE.idkeyStat(oIF, j2, 1, false);
        AppMethodBeat.o(230597);
    }
}
