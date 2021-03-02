package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static int MAX_FRAME_SIZE = 2000;
    private byte[] RKE = null;
    public byte[] RKF = null;
    private long RKG = 0;
    public long RKH = 0;
    public TRSpeexNative RKI = new TRSpeexNative();

    public a() {
        AppMethodBeat.i(87694);
        AppMethodBeat.o(87694);
    }

    public final int hkr() {
        AppMethodBeat.i(87695);
        if (this.RKG != 0) {
            AppMethodBeat.o(87695);
            return -103;
        }
        long nativeTRSpeexInit = this.RKI.nativeTRSpeexInit();
        if (nativeTRSpeexInit == -1) {
            int i2 = (int) nativeTRSpeexInit;
            AppMethodBeat.o(87695);
            return i2;
        }
        this.RKG = nativeTRSpeexInit;
        this.RKE = new byte[(MAX_FRAME_SIZE * 10)];
        AppMethodBeat.o(87695);
        return 0;
    }

    public final byte[] ah(byte[] bArr, int i2) {
        AppMethodBeat.i(87696);
        if (this.RKG == 0) {
            b bVar = new b(-102);
            AppMethodBeat.o(87696);
            throw bVar;
        } else if (bArr == null || bArr.length == 0) {
            b bVar2 = new b(-104);
            AppMethodBeat.o(87696);
            throw bVar2;
        } else {
            int nativeTRSpeexEncode = this.RKI.nativeTRSpeexEncode(this.RKG, bArr, 0, i2, this.RKE);
            if (nativeTRSpeexEncode < 0) {
                b bVar3 = new b(nativeTRSpeexEncode);
                AppMethodBeat.o(87696);
                throw bVar3;
            } else if (nativeTRSpeexEncode == 0) {
                AppMethodBeat.o(87696);
                return null;
            } else {
                byte[] bArr2 = new byte[nativeTRSpeexEncode];
                System.arraycopy(this.RKE, 0, bArr2, 0, nativeTRSpeexEncode);
                AppMethodBeat.o(87696);
                return bArr2;
            }
        }
    }

    public final int hks() {
        AppMethodBeat.i(87697);
        if (this.RKG == 0) {
            AppMethodBeat.o(87697);
            return -102;
        }
        this.RKE = null;
        int nativeTRSpeexRelease = this.RKI.nativeTRSpeexRelease(this.RKG);
        this.RKG = 0;
        AppMethodBeat.o(87697);
        return nativeTRSpeexRelease;
    }
}
