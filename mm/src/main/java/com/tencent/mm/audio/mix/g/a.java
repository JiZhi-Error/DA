package com.tencent.mm.audio.mix.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.b;

public final class a {
    public static boolean I(int i2, int i3, int i4) {
        AppMethodBeat.i(136884);
        if (!jg(i2)) {
            AppMethodBeat.o(136884);
            return false;
        } else if (!jh(i3)) {
            AppMethodBeat.o(136884);
            return false;
        } else if (!ji(i4)) {
            AppMethodBeat.o(136884);
            return false;
        } else {
            AppMethodBeat.o(136884);
            return true;
        }
    }

    private static boolean jg(int i2) {
        AppMethodBeat.i(136885);
        if (i2 <= 0) {
            b.e("MicroMsg.Mix.AudioMixConfig", "sampleRate is illegal! %d", Integer.valueOf(i2));
            AppMethodBeat.o(136885);
            return false;
        } else if (i2 == 44100) {
            AppMethodBeat.o(136885);
            return true;
        } else {
            AppMethodBeat.o(136885);
            return false;
        }
    }

    private static boolean jh(int i2) {
        AppMethodBeat.i(136886);
        if (i2 <= 0) {
            b.e("MicroMsg.Mix.AudioMixConfig", "channels is illegal, %d", Integer.valueOf(i2));
            AppMethodBeat.o(136886);
            return false;
        } else if (i2 == 2) {
            AppMethodBeat.o(136886);
            return true;
        } else {
            AppMethodBeat.o(136886);
            return false;
        }
    }

    private static boolean ji(int i2) {
        AppMethodBeat.i(136887);
        if (i2 <= 0) {
            b.e("MicroMsg.Mix.AudioMixConfig", "encode is illegal, %d", Integer.valueOf(i2));
        }
        if (i2 == 2) {
            AppMethodBeat.o(136887);
            return true;
        }
        AppMethodBeat.o(136887);
        return false;
    }
}
