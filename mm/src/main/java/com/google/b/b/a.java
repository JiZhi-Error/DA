package com.google.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class a implements Cloneable {
    public int[] ccy;
    public int size;

    public a() {
        AppMethodBeat.i(12344);
        this.size = 0;
        this.ccy = new int[1];
        AppMethodBeat.o(12344);
    }

    private a(int[] iArr, int i2) {
        this.ccy = iArr;
        this.size = i2;
    }

    public final int Ii() {
        return (this.size + 7) / 8;
    }

    private void ensureCapacity(int i2) {
        AppMethodBeat.i(12345);
        if (i2 > (this.ccy.length << 5)) {
            int[] iArr = new int[((i2 + 31) / 32)];
            System.arraycopy(this.ccy, 0, iArr, 0, this.ccy.length);
            this.ccy = iArr;
        }
        AppMethodBeat.o(12345);
    }

    public final boolean get(int i2) {
        return (this.ccy[i2 / 32] & (1 << (i2 & 31))) != 0;
    }

    public final void bH(boolean z) {
        AppMethodBeat.i(12346);
        ensureCapacity(this.size + 1);
        if (z) {
            int[] iArr = this.ccy;
            int i2 = this.size / 32;
            iArr[i2] = iArr[i2] | (1 << (this.size & 31));
        }
        this.size++;
        AppMethodBeat.o(12346);
    }

    public final void bH(int i2, int i3) {
        AppMethodBeat.i(12347);
        if (i3 < 0 || i3 > 32) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Num bits must be between 0 and 32");
            AppMethodBeat.o(12347);
            throw illegalArgumentException;
        }
        ensureCapacity(this.size + i3);
        while (i3 > 0) {
            bH(((i2 >> (i3 + -1)) & 1) == 1);
            i3--;
        }
        AppMethodBeat.o(12347);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(12348);
        int i2 = aVar.size;
        ensureCapacity(this.size + i2);
        for (int i3 = 0; i3 < i2; i3++) {
            bH(aVar.get(i3));
        }
        AppMethodBeat.o(12348);
    }

    public final void a(int i2, byte[] bArr, int i3) {
        AppMethodBeat.i(12349);
        int i4 = i2;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (get(i4)) {
                    i6 |= 1 << (7 - i7);
                }
                i4++;
            }
            bArr[i5 + 0] = (byte) i6;
        }
        AppMethodBeat.o(12349);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(12350);
        if (!(obj instanceof a)) {
            AppMethodBeat.o(12350);
            return false;
        }
        a aVar = (a) obj;
        if (this.size != aVar.size || !Arrays.equals(this.ccy, aVar.ccy)) {
            AppMethodBeat.o(12350);
            return false;
        }
        AppMethodBeat.o(12350);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(12351);
        int hashCode = (this.size * 31) + Arrays.hashCode(this.ccy);
        AppMethodBeat.o(12351);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(12352);
        StringBuilder sb = new StringBuilder(this.size);
        for (int i2 = 0; i2 < this.size; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(get(i2) ? 'X' : '.');
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(12352);
        return sb2;
    }

    @Override // java.lang.Object
    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(12353);
        a aVar = new a((int[]) this.ccy.clone(), this.size);
        AppMethodBeat.o(12353);
        return aVar;
    }
}
