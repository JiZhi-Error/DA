package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.audio.mix.jni.SilkResampleJni;

public final class j implements i {
    private int duY = 0;
    private int duZ = 0;
    private String fileName;

    @Override // com.tencent.mm.audio.mix.c.i
    public final boolean l(String str, int i2, int i3) {
        AppMethodBeat.i(136781);
        this.duY = i2;
        this.duZ = i3;
        this.fileName = str;
        b.i("MicroMsg.Mix.SilkResampleAlgorithm", "initResample, fileName:%s, sSample:%d, dSample:%d", str, Integer.valueOf(i2), Integer.valueOf(i3));
        if (SilkResampleJni.initResample(str, i2, i3) == -1) {
            b.e("MicroMsg.Mix.SilkResampleAlgorithm", "initResample result is -1, fileName:%s", str);
            AppMethodBeat.o(136781);
            return false;
        }
        AppMethodBeat.o(136781);
        return true;
    }

    @Override // com.tencent.mm.audio.mix.c.i
    public final byte[] X(byte[] bArr) {
        AppMethodBeat.i(136782);
        short[] sArr = new short[(bArr.length / 2)];
        for (int i2 = 0; i2 < sArr.length; i2++) {
            sArr[i2] = (short) ((bArr[i2 * 2] & 255) | ((bArr[(i2 * 2) + 1] & 255) << 8));
        }
        int length = (sArr.length * this.duZ) / this.duY;
        if (this.duZ % this.duY != 0) {
            length++;
        }
        short[] sArr2 = new short[length];
        if (SilkResampleJni.resamplePcm(this.fileName, this.duY, this.duZ, sArr, sArr.length, sArr2) == -1) {
            b.e("MicroMsg.Mix.SilkResampleAlgorithm", "resamplePcm result is -1, fileName:%s", this.fileName);
            AppMethodBeat.o(136782);
            return null;
        }
        byte[] bArr2 = new byte[(sArr2.length << 1)];
        for (int i3 = 0; i3 < sArr2.length; i3++) {
            bArr2[i3 * 2] = (byte) (sArr2[i3] & 255);
            bArr2[(i3 * 2) + 1] = (byte) ((sArr2[i3] & 65280) >> 8);
        }
        AppMethodBeat.o(136782);
        return bArr2;
    }

    @Override // com.tencent.mm.audio.mix.c.i
    public final boolean release() {
        AppMethodBeat.i(136783);
        if (SilkResampleJni.clearResample(this.fileName) == -1) {
            b.e("MicroMsg.Mix.SilkResampleAlgorithm", "clearResample result is -1");
            AppMethodBeat.o(136783);
            return false;
        }
        b.i("MicroMsg.Mix.SilkResampleAlgorithm", "release");
        AppMethodBeat.o(136783);
        return true;
    }
}
