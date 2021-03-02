package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class b {
    public final List<byte[]> bds;
    public final int biD;

    public static b M(m mVar) {
        AppMethodBeat.i(93266);
        try {
            mVar.eZ(21);
            int readUnsignedByte = mVar.readUnsignedByte() & 3;
            int readUnsignedByte2 = mVar.readUnsignedByte();
            int i2 = mVar.position;
            int i3 = 0;
            int i4 = 0;
            while (i3 < readUnsignedByte2) {
                mVar.eZ(1);
                int readUnsignedShort = mVar.readUnsignedShort();
                int i5 = i4;
                for (int i6 = 0; i6 < readUnsignedShort; i6++) {
                    int readUnsignedShort2 = mVar.readUnsignedShort();
                    i5 += readUnsignedShort2 + 4;
                    mVar.eZ(readUnsignedShort2);
                }
                i3++;
                i4 = i5;
            }
            mVar.setPosition(i2);
            byte[] bArr = new byte[i4];
            int i7 = 0;
            for (int i8 = 0; i8 < readUnsignedByte2; i8++) {
                mVar.eZ(1);
                int readUnsignedShort3 = mVar.readUnsignedShort();
                for (int i9 = 0; i9 < readUnsignedShort3; i9++) {
                    int readUnsignedShort4 = mVar.readUnsignedShort();
                    System.arraycopy(k.bGT, 0, bArr, i7, k.bGT.length);
                    int length = i7 + k.bGT.length;
                    System.arraycopy(mVar.data, mVar.position, bArr, length, readUnsignedShort4);
                    i7 = length + readUnsignedShort4;
                    mVar.eZ(readUnsignedShort4);
                }
            }
            b bVar = new b(i4 == 0 ? null : Collections.singletonList(bArr), readUnsignedByte + 1);
            AppMethodBeat.o(93266);
            return bVar;
        } catch (ArrayIndexOutOfBoundsException e2) {
            o oVar = new o("Error parsing HEVC config", e2);
            AppMethodBeat.o(93266);
            throw oVar;
        }
    }

    private b(List<byte[]> list, int i2) {
        this.bds = list;
        this.biD = i2;
    }
}
