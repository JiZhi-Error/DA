package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e.h;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* access modifiers changed from: package-private */
public final class g extends h {
    private static final int bpw = x.bJ("Opus");
    private static final byte[] bpx = {79, 112, 117, 115, 72, 101, 97, 100};
    private boolean bpy;

    g() {
    }

    static {
        AppMethodBeat.i(92165);
        AppMethodBeat.o(92165);
    }

    public static boolean r(m mVar) {
        AppMethodBeat.i(92160);
        if (mVar.xd() < bpx.length) {
            AppMethodBeat.o(92160);
            return false;
        }
        byte[] bArr = new byte[bpx.length];
        mVar.readBytes(bArr, 0, bpx.length);
        boolean equals = Arrays.equals(bArr, bpx);
        AppMethodBeat.o(92160);
        return equals;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c.e.h
    public final void reset(boolean z) {
        AppMethodBeat.i(92161);
        super.reset(z);
        if (z) {
            this.bpy = false;
        }
        AppMethodBeat.o(92161);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c.e.h
    public final long s(m mVar) {
        int i2;
        int i3;
        AppMethodBeat.i(92162);
        byte[] bArr = mVar.data;
        int i4 = bArr[0] & 255;
        switch (i4 & 3) {
            case 0:
                i2 = 1;
                break;
            case 1:
            case 2:
                i2 = 2;
                break;
            default:
                i2 = bArr[1] & 63;
                break;
        }
        int i5 = i4 >> 3;
        int i6 = i5 & 3;
        if (i5 >= 16) {
            i3 = 2500 << i6;
        } else if (i5 >= 12) {
            i3 = 10000 << (i6 & 1);
        } else if (i6 == 3) {
            i3 = 60000;
        } else {
            i3 = 10000 << i6;
        }
        long T = T((long) (i3 * i2));
        AppMethodBeat.o(92162);
        return T;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c.e.h
    public final boolean a(m mVar, long j2, h.a aVar) {
        boolean z;
        AppMethodBeat.i(92163);
        if (!this.bpy) {
            byte[] copyOf = Arrays.copyOf(mVar.data, mVar.limit);
            int i2 = copyOf[9] & 255;
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(copyOf);
            b(arrayList, ((copyOf[11] & 255) << 8) | (copyOf[10] & 255));
            b(arrayList, 3840);
            aVar.bdF = Format.a(null, "audio/opus", -1, -1, i2, 48000, arrayList, null, null);
            this.bpy = true;
            AppMethodBeat.o(92163);
            return true;
        }
        if (mVar.readInt() == bpw) {
            z = true;
        } else {
            z = false;
        }
        mVar.setPosition(0);
        AppMethodBeat.o(92163);
        return z;
    }

    private static void b(List<byte[]> list, int i2) {
        AppMethodBeat.i(92164);
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) i2) * 1000000000) / 48000).array());
        AppMethodBeat.o(92164);
    }
}
