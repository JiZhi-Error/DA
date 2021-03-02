package com.tencent.mm.plugin.music.b;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MD5Util;

public final class g {
    public static String esG() {
        AppMethodBeat.i(137015);
        String str = SlookAirButtonRecentMediaAdapter.AUDIO_TYPE + MD5Util.getMD5String(new StringBuilder().append(System.nanoTime()).toString());
        AppMethodBeat.o(137015);
        return str;
    }
}
