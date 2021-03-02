package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i {
    public long juy;

    public i(int i2, int i3, int i4) {
        AppMethodBeat.i(130039);
        this.juy = MediaRecorder.SilkEncInit(i2, i3, i4, MediaRecorder.juf);
        AppMethodBeat.o(130039);
    }

    public final int dC(int i2, int i3) {
        AppMethodBeat.i(130040);
        int SetVoiceSilkControl = MediaRecorder.SetVoiceSilkControl(i2, i3, this.juy);
        AppMethodBeat.o(130040);
        return SetVoiceSilkControl;
    }
}
