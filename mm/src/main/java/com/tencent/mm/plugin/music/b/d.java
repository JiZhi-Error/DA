package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class d {
    private static boolean AgP = false;
    private static long dap = 0;

    public static boolean esF() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(137011);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - dap < 120000) {
            boolean z3 = AgP;
            AppMethodBeat.o(137011);
            return z3;
        }
        dap = currentTimeMillis;
        if (e.etK()) {
            z = ((c) b.aS(c.class)).etG();
        } else {
            Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
            z = false;
        }
        AgP = z;
        Log.i("MicroMsg.Audio.AudioMixSupport", "isSupportMixAudio:%b", Boolean.valueOf(AgP));
        if (!AgP) {
            if (e.etK()) {
                z2 = ((c) b.aS(c.class)).etH();
            } else {
                Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
                z2 = false;
            }
            AgP = z2;
            Log.i("MicroMsg.Audio.AudioMixSupport", "isSupportMixAudioByCP:%b", Boolean.valueOf(AgP));
        }
        boolean z4 = AgP;
        AppMethodBeat.o(137011);
        return z4;
    }
}
