package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h {
    long decodeHandle;

    public h(int i2, byte[] bArr, int i3) {
        AppMethodBeat.i(130037);
        this.decodeHandle = MediaRecorder.SilkDecInit(i2, bArr, i3, MediaRecorder.jug);
        AppMethodBeat.o(130037);
    }

    public final int a(byte[] bArr, short s) {
        AppMethodBeat.i(130038);
        int SilkDoDec = MediaRecorder.SilkDoDec(bArr, s, this.decodeHandle);
        AppMethodBeat.o(130038);
        return SilkDoDec;
    }
}
