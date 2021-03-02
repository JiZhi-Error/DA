package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class e {
    public final byte[] cdA;
    private final CharSequence cdx;
    private final int cdy;
    public final int cdz;

    public e(CharSequence charSequence, int i2, int i3) {
        AppMethodBeat.i(12232);
        this.cdx = charSequence;
        this.cdz = i2;
        this.cdy = i3;
        this.cdA = new byte[(i2 * i3)];
        Arrays.fill(this.cdA, (byte) -1);
        AppMethodBeat.o(12232);
    }

    private void g(int i2, int i3, boolean z) {
        this.cdA[(this.cdz * i3) + i2] = (byte) (z ? 1 : 0);
    }

    private boolean bM(int i2, int i3) {
        return this.cdA[(this.cdz * i3) + i2] >= 0;
    }

    public final void Il() {
        int i2;
        AppMethodBeat.i(12233);
        int i3 = 0;
        int i4 = 4;
        int i5 = 0;
        while (true) {
            if (i4 == this.cdy && i3 == 0) {
                q(this.cdy - 1, 0, i5, 1);
                q(this.cdy - 1, 1, i5, 2);
                q(this.cdy - 1, 2, i5, 3);
                q(0, this.cdz - 2, i5, 4);
                q(0, this.cdz - 1, i5, 5);
                q(1, this.cdz - 1, i5, 6);
                q(2, this.cdz - 1, i5, 7);
                q(3, this.cdz - 1, i5, 8);
                i5++;
            }
            if (i4 == this.cdy - 2 && i3 == 0 && this.cdz % 4 != 0) {
                q(this.cdy - 3, 0, i5, 1);
                q(this.cdy - 2, 0, i5, 2);
                q(this.cdy - 1, 0, i5, 3);
                q(0, this.cdz - 4, i5, 4);
                q(0, this.cdz - 3, i5, 5);
                q(0, this.cdz - 2, i5, 6);
                q(0, this.cdz - 1, i5, 7);
                q(1, this.cdz - 1, i5, 8);
                i5++;
            }
            if (i4 == this.cdy - 2 && i3 == 0 && this.cdz % 8 == 4) {
                q(this.cdy - 3, 0, i5, 1);
                q(this.cdy - 2, 0, i5, 2);
                q(this.cdy - 1, 0, i5, 3);
                q(0, this.cdz - 2, i5, 4);
                q(0, this.cdz - 1, i5, 5);
                q(1, this.cdz - 1, i5, 6);
                q(2, this.cdz - 1, i5, 7);
                q(3, this.cdz - 1, i5, 8);
                i5++;
            }
            if (i4 == this.cdy + 4 && i3 == 2 && this.cdz % 8 == 0) {
                q(this.cdy - 1, 0, i5, 1);
                q(this.cdy - 1, this.cdz - 1, i5, 2);
                q(0, this.cdz - 3, i5, 3);
                q(0, this.cdz - 2, i5, 4);
                q(0, this.cdz - 1, i5, 5);
                q(1, this.cdz - 3, i5, 6);
                q(1, this.cdz - 2, i5, 7);
                q(1, this.cdz - 1, i5, 8);
                i5++;
            }
            do {
                if (i4 < this.cdy && i3 >= 0 && !bM(i3, i4)) {
                    B(i4, i3, i5);
                    i5++;
                }
                i4 -= 2;
                i3 += 2;
                if (i4 < 0) {
                    break;
                }
            } while (i3 < this.cdz);
            int i6 = i4 + 1;
            int i7 = i3 + 3;
            int i8 = i6;
            int i9 = i5;
            while (true) {
                if (i8 < 0 || i7 >= this.cdz || bM(i7, i8)) {
                    i5 = i9;
                } else {
                    i5 = i9 + 1;
                    B(i8, i7, i9);
                }
                i8 += 2;
                i2 = i7 - 2;
                if (i8 >= this.cdy || i2 < 0) {
                    i4 = i8 + 3;
                    i3 = i2 + 1;
                } else {
                    i7 = i2;
                    i9 = i5;
                }
            }
            i4 = i8 + 3;
            i3 = i2 + 1;
            if (i4 >= this.cdy && i3 >= this.cdz) {
                break;
            }
        }
        if (!bM(this.cdz - 1, this.cdy - 1)) {
            g(this.cdz - 1, this.cdy - 1, true);
            g(this.cdz - 2, this.cdy - 2, true);
        }
        AppMethodBeat.o(12233);
    }

    private void q(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        boolean z = true;
        AppMethodBeat.i(12234);
        if (i2 < 0) {
            i7 = i2 + this.cdy;
            i6 = (4 - ((this.cdy + 4) % 8)) + i3;
        } else {
            i6 = i3;
            i7 = i2;
        }
        if (i6 < 0) {
            i6 += this.cdz;
            i7 += 4 - ((this.cdz + 4) % 8);
        }
        if ((this.cdx.charAt(i4) & (1 << (8 - i5))) == 0) {
            z = false;
        }
        g(i6, i7, z);
        AppMethodBeat.o(12234);
    }

    private void B(int i2, int i3, int i4) {
        AppMethodBeat.i(12235);
        q(i2 - 2, i3 - 2, i4, 1);
        q(i2 - 2, i3 - 1, i4, 2);
        q(i2 - 1, i3 - 2, i4, 3);
        q(i2 - 1, i3 - 1, i4, 4);
        q(i2 - 1, i3, i4, 5);
        q(i2, i3 - 2, i4, 6);
        q(i2, i3 - 1, i4, 7);
        q(i2, i3, i4, 8);
        AppMethodBeat.o(12235);
    }
}
