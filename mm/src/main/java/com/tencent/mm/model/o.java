package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ab;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/model/BizRecFeedReport;", "", "()V", "reportIdKey1590", "", "value", "", "reportKv22101", "actionType", "", "position", "plugin-biz_release"})
public final class o {
    public static final o iBV = new o();

    static {
        AppMethodBeat.i(212379);
        AppMethodBeat.o(212379);
    }

    private o() {
    }

    public static void Aa(long j2) {
        AppMethodBeat.i(212377);
        h.INSTANCE.idkeyStat(1590, j2, 1, false);
        AppMethodBeat.o(212377);
    }

    public static void dk(int i2, int i3) {
        AppMethodBeat.i(212378);
        String valueOf = String.valueOf(ab.getSessionId());
        h.INSTANCE.a(22101, valueOf, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(212378);
    }
}
