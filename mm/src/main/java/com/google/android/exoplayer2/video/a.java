package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.i.d;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public final float bHl;
    public final List<byte[]> bds;
    public final int biD;
    public final int height;
    public final int width;

    public static a K(m mVar) {
        int i2;
        int i3;
        AppMethodBeat.i(93250);
        try {
            mVar.eZ(4);
            int readUnsignedByte = (mVar.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte == 3) {
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(93250);
                throw illegalStateException;
            }
            ArrayList arrayList = new ArrayList();
            int readUnsignedByte2 = mVar.readUnsignedByte() & 31;
            for (int i4 = 0; i4 < readUnsignedByte2; i4++) {
                arrayList.add(L(mVar));
            }
            int readUnsignedByte3 = mVar.readUnsignedByte();
            for (int i5 = 0; i5 < readUnsignedByte3; i5++) {
                arrayList.add(L(mVar));
            }
            float f2 = 1.0f;
            if (readUnsignedByte2 > 0) {
                k.b k = k.k((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                i2 = k.width;
                i3 = k.height;
                f2 = k.bHl;
            } else {
                i2 = -1;
                i3 = -1;
            }
            a aVar = new a(arrayList, readUnsignedByte, i2, i3, f2);
            AppMethodBeat.o(93250);
            return aVar;
        } catch (ArrayIndexOutOfBoundsException e2) {
            o oVar = new o("Error parsing AVC config", e2);
            AppMethodBeat.o(93250);
            throw oVar;
        }
    }

    private a(List<byte[]> list, int i2, int i3, int i4, float f2) {
        this.bds = list;
        this.biD = i2;
        this.width = i3;
        this.height = i4;
        this.bHl = f2;
    }

    private static byte[] L(m mVar) {
        AppMethodBeat.i(93251);
        int readUnsignedShort = mVar.readUnsignedShort();
        int i2 = mVar.position;
        mVar.eZ(readUnsignedShort);
        byte[] j2 = d.j(mVar.data, i2, readUnsignedShort);
        AppMethodBeat.o(93251);
        return j2;
    }
}
