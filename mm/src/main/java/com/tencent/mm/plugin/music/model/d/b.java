package com.tencent.mm.plugin.music.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    public static int SS(int i2) {
        AppMethodBeat.i(63137);
        Log.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerSumidKeyByMusicType, musicType:".concat(String.valueOf(i2)));
        switch (i2) {
            case 0:
                AppMethodBeat.o(63137);
                return 50;
            case 1:
                AppMethodBeat.o(63137);
                return 51;
            case 2:
            case 3:
            case 5:
            default:
                AppMethodBeat.o(63137);
                return 59;
            case 4:
                AppMethodBeat.o(63137);
                return 52;
            case 6:
                AppMethodBeat.o(63137);
                return 53;
            case 7:
                AppMethodBeat.o(63137);
                return 54;
            case 8:
                AppMethodBeat.o(63137);
                return 55;
            case 9:
                AppMethodBeat.o(63137);
                return 56;
            case 10:
                AppMethodBeat.o(63137);
                return 57;
            case 11:
                AppMethodBeat.o(63137);
                return 58;
        }
    }
}
