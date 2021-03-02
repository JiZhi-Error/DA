package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/emoji/report/EmojiTabClickReport;", "", "()V", "clickIndex", "", "getClickIndex", "()I", "setClickIndex", "(I)V", "scene", "getScene", "setScene", "timePanelShow", "", "panelShow", "", "openTime", "reportClick", "tabIndex", "productId", "", "plugin-emojisdk_release"})
public final class g {
    private static long hcf;
    private static int hcg;
    public static final g hcn = new g();
    private static int scene;

    static {
        AppMethodBeat.i(105727);
        AppMethodBeat.o(105727);
    }

    private g() {
    }

    public static void setScene(int i2) {
        scene = i2;
    }

    public static void zj(long j2) {
        hcf = j2;
        hcg = 1;
    }

    public static void B(int i2, String str) {
        AppMethodBeat.i(105726);
        h.INSTANCE.a(18231, Long.valueOf(hcf), Integer.valueOf(scene), Integer.valueOf(hcg), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i2), str);
        hcg++;
        AppMethodBeat.o(105726);
    }
}
