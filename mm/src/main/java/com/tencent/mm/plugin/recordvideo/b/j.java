package com.tencent.mm.plugin.recordvideo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.storage.ar;

public final class j {
    public static boolean BNK = false;

    public static boolean isEnable() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(75022);
        if (BNK) {
            AppMethodBeat.o(75022);
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
                AppMethodBeat.o(75022);
                return true;
            }
        }
        AppMethodBeat.o(75022);
        return false;
    }
}
