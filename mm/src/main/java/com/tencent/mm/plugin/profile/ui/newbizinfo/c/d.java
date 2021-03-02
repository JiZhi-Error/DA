package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JP\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002JF\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004JF\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/report/Kv17523;", "", "()V", "DATA_TYPE_CLICK", "", "DATA_TYPE_SHOW", "TAG", "", "report", "", "actionType", "userName", "enterTimestamp", "", "messageId", "messageIndex", "itemShowType", "position", "publishTime", "enterScene", "reportClick", "reportShow", "app_release"})
public final class d {
    private static final int BlP = 1;
    private static final int BlQ = 2;
    public static final d BlR = new d();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(39730);
        AppMethodBeat.o(39730);
    }

    private d() {
    }

    private static void a(int i2, String str, long j2, int i3, int i4, int i5, int i6, int i7, int i8) {
        AppMethodBeat.i(39728);
        h.INSTANCE.a(17523, Integer.valueOf(i2), str, Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
        AppMethodBeat.o(39728);
    }

    public static void a(String str, long j2, int i2, int i3, int i4, int i5, int i6, int i7) {
        AppMethodBeat.i(39729);
        p.h(str, "userName");
        a(BlP, str, j2, i2, i3, i4, i5, i6, i7);
        AppMethodBeat.o(39729);
    }

    public static void b(String str, long j2, int i2, int i3, int i4, int i5, int i6, int i7) {
        AppMethodBeat.i(230661);
        p.h(str, "userName");
        a(BlQ, str, j2, i2, i3, i4, i5, i6, i7);
        AppMethodBeat.o(230661);
    }
}
