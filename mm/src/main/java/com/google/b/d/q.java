package com.google.b.d;

import com.google.b.d;

public abstract class q extends n {
    static final int[] cet = {1, 1, 1, 1, 1, 1};
    static final int[] cev = {1, 1, 1};
    static final int[] cew = {1, 1, 1, 1, 1};
    static final int[][] cex = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
    static final int[][] cey = new int[20][];

    static {
        System.arraycopy(cex, 0, cey, 0, 10);
        for (int i2 = 10; i2 < 20; i2++) {
            int[] iArr = cex[i2 - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr2[i3] = iArr[(iArr.length - i3) - 1];
            }
            cey[i2] = iArr2;
        }
    }

    static boolean x(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i2 = 0;
        for (int i3 = length - 2; i3 >= 0; i3 -= 2) {
            int charAt = charSequence.charAt(i3) - '0';
            if (charAt < 0 || charAt > 9) {
                throw d.Ih();
            }
            i2 += charAt;
        }
        int i4 = i2 * 3;
        for (int i5 = length - 1; i5 >= 0; i5 -= 2) {
            int charAt2 = charSequence.charAt(i5) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw d.Ih();
            }
            i4 += charAt2;
        }
        if (i4 % 10 == 0) {
            return true;
        }
        return false;
    }
}
