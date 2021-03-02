package com.google.android.exoplayer2.i;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;

public final class d {
    private static final byte[] bGT = {0, 0, 0, 1};
    private static final int[] bGU = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, TXRecordCommon.AUDIO_SAMPLERATE_8000, 7350};
    private static final int[] bGV = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> u(byte[] bArr) {
        AppMethodBeat.i(93121);
        l lVar = new l(bArr);
        int c2 = c(lVar);
        int d2 = d(lVar);
        int em = lVar.em(4);
        if (c2 == 5 || c2 == 29) {
            d2 = d(lVar);
            if (c(lVar) == 22) {
                em = lVar.em(4);
            }
        }
        int i2 = bGV[em];
        a.checkArgument(i2 != -1);
        Pair<Integer, Integer> create = Pair.create(Integer.valueOf(d2), Integer.valueOf(i2));
        AppMethodBeat.o(93121);
        return create;
    }

    public static byte[] r(int i2, int i3, int i4) {
        return new byte[]{(byte) (((i2 << 3) & 248) | ((i3 >> 1) & 7)), (byte) (((i3 << 7) & 128) | ((i4 << 3) & 120))};
    }

    public static byte[] j(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(93123);
        byte[] bArr2 = new byte[(bGT.length + i3)];
        System.arraycopy(bGT, 0, bArr2, 0, bGT.length);
        System.arraycopy(bArr, i2, bArr2, bGT.length, i3);
        AppMethodBeat.o(93123);
        return bArr2;
    }

    private static int c(l lVar) {
        AppMethodBeat.i(93126);
        int em = lVar.em(5);
        if (em == 31) {
            em = lVar.em(6) + 32;
        }
        AppMethodBeat.o(93126);
        return em;
    }

    private static int d(l lVar) {
        int i2;
        AppMethodBeat.i(93127);
        int em = lVar.em(4);
        if (em == 15) {
            i2 = lVar.em(24);
        } else {
            a.checkArgument(em < 13);
            i2 = bGU[em];
        }
        AppMethodBeat.o(93127);
        return i2;
    }
}
