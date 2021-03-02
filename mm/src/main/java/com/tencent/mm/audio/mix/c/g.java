package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.a;
import com.tencent.mm.audio.mix.i.b;

public final class g extends d {
    public g(String str, int i2, int i3, int i4, int i5, int i6, int i7) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(136780);
        b.i("MicroMsg.Mix.AudioVariableConvertProcess", "AudioVariableConvertProcess src:%s, srcSampleRate:%d, srcChannels:%d, srcBitDepth:%d, desSampleRate:%d, desChannels:%d, desBitDepth:%d", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
        this.dus = str;
        this.duF = a.hr(str);
        c.YP();
        if (i5 <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.duz = i5;
        }
        if (i6 <= 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            this.duA = i6;
        }
        if (i5 > 0 ? true : z3) {
            this.duB = i7;
        }
        G(i2, i3, i4);
        AppMethodBeat.o(136780);
    }
}
