package com.tencent.mm.plugin.music.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.music.e.a;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {
    public static boolean Th(int i2) {
        AppMethodBeat.i(137449);
        switch (i2) {
            case 10:
            case 11:
                AppMethodBeat.o(137449);
                return true;
            default:
                a aVar = k.euj().AjC;
                if (aVar == null || !aVar.hWq()) {
                    AppMethodBeat.o(137449);
                    return false;
                }
                AppMethodBeat.o(137449);
                return true;
        }
    }

    public static boolean U(f fVar) {
        AppMethodBeat.i(137450);
        if (fVar == null) {
            AppMethodBeat.o(137450);
            return false;
        } else if (TextUtils.isEmpty(fVar.protocol)) {
            AppMethodBeat.o(137450);
            return false;
        } else {
            Log.d("MicroMsg.Music.MusicPlayerSupport", "protocol:%s", fVar.protocol);
            if ("hls".equalsIgnoreCase(fVar.protocol)) {
                AppMethodBeat.o(137450);
                return true;
            }
            AppMethodBeat.o(137450);
            return false;
        }
    }
}
