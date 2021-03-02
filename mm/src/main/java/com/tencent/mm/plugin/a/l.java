package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.r;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/Atom/Mp4ParserStat;", "", "()V", "ID", "", "TAG", "", "markIncrementParseCost", "", "cost", "markParse", "useLazy", "", "markParseCost", "timeTableLength", "", "plugin-playvideo_release"})
public final class l {
    public static final l jQN = new l();

    static {
        AppMethodBeat.i(175938);
        AppMethodBeat.o(175938);
    }

    private l() {
    }

    public static void ge(boolean z) {
        AppMethodBeat.i(175935);
        Log.i("MicroMsg.Mp4ParserStat", "markParse, useLazy:".concat(String.valueOf(z)));
        if (z) {
            h.INSTANCE.n(1290, 0, 1);
            AppMethodBeat.o(175935);
            return;
        }
        h.INSTANCE.n(1290, 1, 1);
        AppMethodBeat.o(175935);
    }

    public static void a(boolean z, long j2, int i2) {
        r rVar;
        AppMethodBeat.i(175936);
        Log.i("MicroMsg.Mp4ParserStat", "markParseCost, useLazy:" + z + ", cost:" + j2 + ", timetTableLength:" + i2);
        if (j2 < 0 || i2 < 0) {
            AppMethodBeat.o(175936);
            return;
        }
        if (z) {
            h.INSTANCE.n(1290, 8, j2);
            h.INSTANCE.n(1290, 9, 1);
        } else {
            h.INSTANCE.n(1290, 3, j2);
            h.INSTANCE.n(1290, 4, 1);
        }
        if (i2 >= 0 && 30 >= i2) {
            rVar = z ? new r(13, 22, 23) : new r(13, 47, 48);
        } else if (31 <= i2 && 60 >= i2) {
            rVar = z ? new r(14, 26, 27) : new r(14, 51, 52);
        } else if (61 <= i2 && 120 >= i2) {
            rVar = z ? new r(15, 30, 31) : new r(15, 55, 56);
        } else if (121 <= i2 && 180 >= i2) {
            rVar = z ? new r(16, 34, 35) : new r(16, 59, 60);
        } else if (181 <= i2 && 240 >= i2) {
            rVar = z ? new r(17, 38, 39) : new r(17, 63, 64);
        } else if (z) {
            rVar = new r(18, 43, 44);
        } else {
            rVar = new r(18, 67, 68);
        }
        int intValue = rVar.first.intValue();
        int intValue2 = rVar.second.intValue();
        int intValue3 = rVar.SWY.intValue();
        h.INSTANCE.n(1290, (long) intValue, 1);
        h.INSTANCE.n(1290, (long) intValue2, j2);
        h.INSTANCE.n(1290, (long) intValue3, 1);
        AppMethodBeat.o(175936);
    }

    public static void AS(long j2) {
        AppMethodBeat.i(175937);
        Log.i("MicroMsg.Mp4ParserStat", "markIncrementParseCost:".concat(String.valueOf(j2)));
        if (j2 >= 0) {
            h.INSTANCE.n(1290, 72, j2);
            h.INSTANCE.n(1290, 73, 1);
        }
        AppMethodBeat.o(175937);
    }
}
