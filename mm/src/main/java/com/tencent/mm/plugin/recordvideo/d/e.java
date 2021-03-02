package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/report/StoryRemuxDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markFail", "", "isCaptureVideo", "", "markMixErrorData", "markMixVideoNotExist", "markRemuxStart", "markRemuxStartUniq", "markSuccess", "markSuccessCost", "time", "markSuccessRetryTimes", "times", "", "postDone", "plugin-recordvideo_release"})
public final class e {
    public static final e BXT = new e();

    static {
        AppMethodBeat.i(75852);
        AppMethodBeat.o(75852);
    }

    private e() {
    }

    public static void tj(boolean z) {
        AppMethodBeat.i(75844);
        Log.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markRemuxStartUniq, isCaptureVideo:".concat(String.valueOf(z)));
        h.INSTANCE.n(1005, 101, 1);
        if (z) {
            h.INSTANCE.n(1005, 102, 1);
            AppMethodBeat.o(75844);
            return;
        }
        h.INSTANCE.n(1005, 103, 1);
        AppMethodBeat.o(75844);
    }

    public static void tk(boolean z) {
        AppMethodBeat.i(75845);
        Log.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markRemuxStart, isCaptureVideo:".concat(String.valueOf(z)));
        h.INSTANCE.n(1005, 1, 1);
        if (z) {
            h.INSTANCE.n(1005, 2, 1);
            AppMethodBeat.o(75845);
            return;
        }
        h.INSTANCE.n(1005, 3, 1);
        AppMethodBeat.o(75845);
    }

    public static void tl(boolean z) {
        AppMethodBeat.i(75846);
        Log.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markSucess");
        h.INSTANCE.n(1005, 11, 1);
        if (z) {
            h.INSTANCE.n(1005, 12, 1);
            AppMethodBeat.o(75846);
            return;
        }
        h.INSTANCE.n(1005, 13, 1);
        AppMethodBeat.o(75846);
    }

    public static void tm(boolean z) {
        AppMethodBeat.i(75847);
        Log.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markFail");
        h.INSTANCE.n(1005, 21, 1);
        if (z) {
            h.INSTANCE.n(1005, 22, 1);
            AppMethodBeat.o(75847);
            return;
        }
        h.INSTANCE.n(1005, 23, 1);
        AppMethodBeat.o(75847);
    }

    public static void i(boolean z, long j2) {
        AppMethodBeat.i(75848);
        Log.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markSuccessCost, isCaptureVideo:" + z + ", time:" + j2);
        h.INSTANCE.n(1005, 31, j2);
        if (z) {
            h.INSTANCE.n(1005, 32, j2);
            AppMethodBeat.o(75848);
            return;
        }
        h.INSTANCE.n(1005, 33, j2);
        AppMethodBeat.o(75848);
    }

    public static void aM(int i2, boolean z) {
        AppMethodBeat.i(75849);
        Log.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markSuccessRetryTimes, times:" + i2 + ", isCaptureVideo:" + z);
        h.INSTANCE.n(1005, 41, 1);
        if (i2 <= 1) {
            if (z) {
                h.INSTANCE.n(1005, 42, 1);
                AppMethodBeat.o(75849);
                return;
            }
            h.INSTANCE.n(1005, 43, 1);
            AppMethodBeat.o(75849);
        } else if (i2 != 2) {
            if (i2 == 3) {
                if (z) {
                    h.INSTANCE.n(1005, 48, 1);
                    AppMethodBeat.o(75849);
                    return;
                }
                h.INSTANCE.n(1005, 49, 1);
            }
            AppMethodBeat.o(75849);
        } else if (z) {
            h.INSTANCE.n(1005, 45, 1);
            AppMethodBeat.o(75849);
        } else {
            h.INSTANCE.n(1005, 46, 1);
            AppMethodBeat.o(75849);
        }
    }

    public static void tn(boolean z) {
        AppMethodBeat.i(75850);
        Log.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markMixVideoNotExist");
        if (z) {
            h.INSTANCE.n(1005, 5, 1);
            AppMethodBeat.o(75850);
            return;
        }
        h.INSTANCE.n(1005, 6, 1);
        AppMethodBeat.o(75850);
    }

    public static void eLd() {
        AppMethodBeat.i(75851);
        Log.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markMixErrorData");
        h.INSTANCE.n(1005, 8, 1);
        AppMethodBeat.o(75851);
    }
}
