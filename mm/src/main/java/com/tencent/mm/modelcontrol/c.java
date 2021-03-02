package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {
    public static boolean baV() {
        AppMethodBeat.i(201781);
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_mp4v2_change_to_ffmpeg, true);
        Log.i("MicroMsg.MediaExptUtil", "MediaExptUtil isFFmpegReplaceMp4v2: ".concat(String.valueOf(a2)));
        AppMethodBeat.o(201781);
        return a2;
    }
}
