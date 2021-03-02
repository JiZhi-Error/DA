package com.tencent.mm.storage;

import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\\\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJT\u0010\u0015\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/storage/BizCardReport;", "", "()V", "bizRecycleCardRejectReport", "", "status", "", "extraData", "", "report20800Insert", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "arriveType", "pos", "useServerTime", "cardType", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "recID", "", "cardId", "expType", "report20800Receive", "weight", "plugin-biz_release"})
public final class s {
    public static final s NPC = new s();

    static {
        AppMethodBeat.i(212554);
        AppMethodBeat.o(212554);
    }

    private s() {
    }

    public static void a(int i2, int i3, int i4, int i5, int i6, long j2, String str, String str2, String str3) {
        AppMethodBeat.i(212551);
        h.INSTANCE.a(20800, 1, 0, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(j2), str, str2, z.bfG(Util.nullAsNil(str3)));
        AppMethodBeat.o(212551);
    }

    public static void a(z zVar, int i2, int i3, int i4, int i5, long j2, String str, String str2, String str3) {
        AppMethodBeat.i(212552);
        p.h(zVar, "info");
        if (!zVar.gAu()) {
            AppMethodBeat.o(212552);
            return;
        }
        h.INSTANCE.a(20800, 2, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(zVar.gAp()), Integer.valueOf(i4), 5, Integer.valueOf(i5), Long.valueOf(j2), str, str2, z.bfG(Util.nullAsNil(str3)));
        AppMethodBeat.o(212552);
    }

    public static void di(int i2, String str) {
        AppMethodBeat.i(212553);
        h.INSTANCE.a(21314, z.bfG(Util.nullAsNil(str)), Integer.valueOf(i2));
        AppMethodBeat.o(212553);
    }
}
