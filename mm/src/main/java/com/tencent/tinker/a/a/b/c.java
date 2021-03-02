package com.tencent.tinker.a.a.b;

import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.export.external.interfaces.ISelectionInterface;

public final class c {
    public static int a(byte b2, byte b3) {
        if (b2 == b3) {
            return 0;
        }
        return (b2 & 255) < (b3 & 255) ? -1 : 1;
    }

    public static int a(short s, short s2) {
        if (s == s2) {
            return 0;
        }
        return (s & ISelectionInterface.HELD_NOTHING) < (65535 & s2) ? -1 : 1;
    }

    public static int mD(int i2, int i3) {
        if (i2 == i3) {
            return 0;
        }
        return (((long) i2) & Util.MAX_32BIT_VALUE) < (((long) i3) & Util.MAX_32BIT_VALUE) ? -1 : 1;
    }

    public static int p(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i2 = 0; i2 < length; i2++) {
            int a2 = a(bArr[i2], bArr2[i2]);
            if (a2 != 0) {
                return a2;
            }
        }
        return 0;
    }

    public static int a(short[] sArr, short[] sArr2) {
        int length = sArr.length;
        int length2 = sArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i2 = 0; i2 < length; i2++) {
            int a2 = a(sArr[i2], sArr2[i2]);
            if (a2 != 0) {
                return a2;
            }
        }
        return 0;
    }

    public static int mE(int i2, int i3) {
        if (i2 == i3) {
            return 0;
        }
        return i2 < i3 ? -1 : 1;
    }

    public static int c(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int length2 = iArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i2 = 0; i2 < length; i2++) {
            int mE = mE(iArr[i2], iArr2[i2]);
            if (mE != 0) {
                return mE;
            }
        }
        return 0;
    }

    public static <T extends Comparable<T>> int a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i2 = 0; i2 < length; i2++) {
            int compareTo = tArr[i2].compareTo(tArr2[i2]);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }
}
