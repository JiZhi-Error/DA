package com.tencent.mm.audio.mix.f;

import com.tencent.mm.audio.mix.a.b;
import com.tencent.mm.audio.mix.a.e;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public abstract class f implements h {
    protected int MAX_VALUE = 32767;
    protected int MIN_VALUE = -32768;
    protected short[][] dwL = ((short[][]) Array.newInstance(Short.TYPE, 1, 1));
    protected int dwM = 1;
    protected int dwN = 1;
    protected short[] dwO = new short[1];
    protected int dwP = 1;
    protected b dwQ;

    /* access modifiers changed from: protected */
    public abstract byte[] H(int i2, int i3, int i4);

    @Override // com.tencent.mm.audio.mix.f.h
    public final boolean a(b bVar, List<e> list) {
        byte[] bArr;
        if (list == null || list.size() == 0) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.BaseAudioMixAlgorithm", "process list is invalid");
            return false;
        }
        byte[][] bArr2 = new byte[list.size()][];
        for (int i2 = 0; i2 < list.size(); i2++) {
            bArr2[i2] = list.get(i2).dtQ;
        }
        this.dwQ = bVar;
        if (bArr2.length == 0) {
            bArr = null;
        } else {
            byte[] bArr3 = bArr2[0];
            if (bArr3 == null || bArr3.length == 0) {
                bArr = null;
            } else if (bArr2.length == 1) {
                bArr = ZD();
                if (bArr == null || bArr.length != bArr3.length) {
                    bArr = new byte[bArr3.length];
                }
                System.arraycopy(bArr3, 0, bArr, 0, bArr3.length);
            } else {
                int i3 = 0;
                while (true) {
                    if (i3 >= bArr2.length) {
                        int length = bArr2.length;
                        int length2 = bArr3.length / 2;
                        if (!(length == this.dwM && length2 == this.dwN)) {
                            this.dwL = (short[][]) Array.newInstance(Short.TYPE, length, length2);
                            this.dwM = length;
                            this.dwN = length2;
                        }
                        for (int i4 = 0; i4 < length; i4++) {
                            Arrays.fill(this.dwL[i4], 0, length2 - 1, (short) 0);
                            for (int i5 = 0; i5 < length2; i5++) {
                                this.dwL[i4][i5] = (short) ((bArr2[i4][i5 * 2] & 255) | ((bArr2[i4][(i5 * 2) + 1] & 255) << 8));
                            }
                        }
                        if (this.dwP != length2) {
                            this.dwP = length2;
                            this.dwO = new short[length2];
                        }
                        Arrays.fill(this.dwO, 0, length2 - 1, (short) 0);
                        bArr = H(length, length2, bArr3.length);
                    } else if (bArr2[i3].length != bArr3.length) {
                        com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.BaseAudioMixAlgorithm", "column of the road of audio + " + i3 + " is different.");
                        bArr = null;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        if (bArr == null) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.BaseAudioMixAlgorithm", "mixed data is invalid");
            return false;
        }
        bVar.dtQ = bArr;
        bVar.channels = list.get(0).channels;
        bVar.sampleRate = list.get(0).sampleRate;
        return true;
    }

    private byte[] ZD() {
        if (this.dwQ != null) {
            return this.dwQ.dtQ;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final short jf(int i2) {
        if (i2 > this.MAX_VALUE) {
            return (short) this.MAX_VALUE;
        }
        if (i2 < this.MIN_VALUE) {
            return (short) this.MIN_VALUE;
        }
        return (short) i2;
    }

    /* access modifiers changed from: protected */
    public final byte[] ci(int i2, int i3) {
        byte[] ZD = ZD();
        if (ZD == null || ZD.length != i2) {
            ZD = new byte[i2];
        }
        for (int i4 = 0; i4 < i3; i4++) {
            ZD[i4 * 2] = (byte) (this.dwO[i4] & 255);
            ZD[(i4 * 2) + 1] = (byte) ((this.dwO[i4] & 65280) >> 8);
        }
        return ZD;
    }
}
