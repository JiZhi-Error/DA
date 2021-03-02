package com.tencent.mm.plugin.story.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;

public final class c {
    public static boolean BNK = false;

    public static boolean isEnable() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(118528);
        if (BNK) {
            AppMethodBeat.o(118528);
            return true;
        }
        if (((b) g.af(b.class)).a(b.a.clicfg_story_imagevideo_soft_codec_enable, 0L) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && d.oD(28)) {
            if (g.aAh().azQ().a(ar.a.USERINFO_STORY_X264_FAILED_TIMES_LONG_SYNC, 0) >= 3) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                AppMethodBeat.o(118528);
                return true;
            }
        }
        AppMethodBeat.o(118528);
        return false;
    }

    public static long Kh(long j2) {
        long j3;
        AppMethodBeat.i(118529);
        long a2 = ((b) g.af(b.class)).a(b.a.clicfg_story_imagevideo_soft_codec_enable, 40000L);
        Log.i("MicroMsg.X264Config", "updateByCostTime, costTime:%s, max:%s", Long.valueOf(j2), Long.valueOf(a2));
        if (j2 > a2) {
            long fnt = fnt();
            AppMethodBeat.o(118529);
            return fnt;
        }
        long a3 = g.aAh().azQ().a(ar.a.USERINFO_STORY_X264_FAILED_TIMES_LONG_SYNC, 0);
        if (a3 <= 0) {
            j3 = 0;
        } else {
            j3 = a3 - 1;
        }
        g.aAh().azQ().set(ar.a.USERINFO_STORY_X264_FAILED_TIMES_LONG_SYNC, Long.valueOf(j3));
        Log.i("MicroMsg.X264Config", "update succ, costTime:%s, cur:%s", Long.valueOf(j2), Long.valueOf(j3));
        AppMethodBeat.o(118529);
        return j3;
    }

    public static long fnt() {
        long j2 = 0;
        AppMethodBeat.i(118530);
        long a2 = g.aAh().azQ().a(ar.a.USERINFO_STORY_X264_FAILED_TIMES_LONG_SYNC, 0);
        if (a2 >= 0) {
            j2 = a2;
        }
        long j3 = j2 + 1;
        g.aAh().azQ().set(ar.a.USERINFO_STORY_X264_FAILED_TIMES_LONG_SYNC, Long.valueOf(j3));
        Log.i("MicroMsg.X264Config", "updateFailedTimes, cur:%s", Long.valueOf(j3));
        AppMethodBeat.o(118530);
        return j3;
    }
}
