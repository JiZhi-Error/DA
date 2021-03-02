package com.google.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class b implements Cloneable {
    private final int[] ccy;
    private final int ccz;
    public final int height;
    public final int width;

    public b(int i2) {
        this(i2, i2);
        AppMethodBeat.i(12329);
        AppMethodBeat.o(12329);
    }

    public b(int i2, int i3) {
        AppMethodBeat.i(12330);
        if (i2 <= 0 || i3 <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Both dimensions must be greater than 0");
            AppMethodBeat.o(12330);
            throw illegalArgumentException;
        }
        this.width = i2;
        this.height = i3;
        this.ccz = (i2 + 31) / 32;
        this.ccy = new int[(this.ccz * i3)];
        AppMethodBeat.o(12330);
    }

    private b(int i2, int i3, int i4, int[] iArr) {
        this.width = i2;
        this.height = i3;
        this.ccz = i4;
        this.ccy = iArr;
    }

    public final boolean bI(int i2, int i3) {
        return ((this.ccy[(this.ccz * i3) + (i2 / 32)] >>> (i2 & 31)) & 1) != 0;
    }

    public final void set(int i2, int i3) {
        int i4 = (this.ccz * i3) + (i2 / 32);
        int[] iArr = this.ccy;
        iArr[i4] = iArr[i4] | (1 << (i2 & 31));
    }

    public final void clear() {
        int length = this.ccy.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.ccy[i2] = 0;
        }
    }

    public final void p(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(12331);
        if (i3 < 0 || i2 < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Left and top must be nonnegative");
            AppMethodBeat.o(12331);
            throw illegalArgumentException;
        } else if (i5 <= 0 || i4 <= 0) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Height and width must be at least 1");
            AppMethodBeat.o(12331);
            throw illegalArgumentException2;
        } else {
            int i6 = i2 + i4;
            int i7 = i3 + i5;
            if (i7 > this.height || i6 > this.width) {
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("The region must fit inside the matrix");
                AppMethodBeat.o(12331);
                throw illegalArgumentException3;
            }
            while (i3 < i7) {
                int i8 = i3 * this.ccz;
                for (int i9 = i2; i9 < i6; i9++) {
                    int[] iArr = this.ccy;
                    int i10 = (i9 / 32) + i8;
                    iArr[i10] = iArr[i10] | (1 << (i9 & 31));
                }
                i3++;
            }
            AppMethodBeat.o(12331);
        }
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(12332);
        if (!(obj instanceof b)) {
            AppMethodBeat.o(12332);
            return false;
        }
        b bVar = (b) obj;
        if (this.width == bVar.width && this.height == bVar.height && this.ccz == bVar.ccz && Arrays.equals(this.ccy, bVar.ccy)) {
            AppMethodBeat.o(12332);
            return true;
        }
        AppMethodBeat.o(12332);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(12333);
        int hashCode = (((((((this.width * 31) + this.width) * 31) + this.height) * 31) + this.ccz) * 31) + Arrays.hashCode(this.ccy);
        AppMethodBeat.o(12333);
        return hashCode;
    }

    public final String toString() {
        String str;
        AppMethodBeat.i(12334);
        StringBuilder sb = new StringBuilder(this.height * (this.width + 1));
        for (int i2 = 0; i2 < this.height; i2++) {
            for (int i3 = 0; i3 < this.width; i3++) {
                if (bI(i3, i2)) {
                    str = "X ";
                } else {
                    str = "  ";
                }
                sb.append(str);
            }
            sb.append("\n");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(12334);
        return sb2;
    }

    @Override // java.lang.Object
    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(12335);
        b bVar = new b(this.width, this.height, this.ccz, (int[]) this.ccy.clone());
        AppMethodBeat.o(12335);
        return bVar;
    }
}
