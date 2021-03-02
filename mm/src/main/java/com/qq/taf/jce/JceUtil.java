package com.qq.taf.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

public final class JceUtil {
    private static final byte[] highDigits;
    private static final int iConstant = 37;
    private static final int iTotal = 17;
    private static final byte[] lowDigits;

    public static boolean equals(boolean z, boolean z2) {
        return z == z2;
    }

    public static boolean equals(byte b2, byte b3) {
        return b2 == b3;
    }

    public static boolean equals(char c2, char c3) {
        return c2 == c3;
    }

    public static boolean equals(short s, short s2) {
        return s == s2;
    }

    public static boolean equals(int i2, int i3) {
        return i2 == i3;
    }

    public static boolean equals(long j2, long j3) {
        return j2 == j3;
    }

    public static boolean equals(float f2, float f3) {
        return f2 == f3;
    }

    public static boolean equals(double d2, double d3) {
        return d2 == d3;
    }

    public static boolean equals(Object obj, Object obj2) {
        AppMethodBeat.i(109640);
        boolean equals = obj.equals(obj2);
        AppMethodBeat.o(109640);
        return equals;
    }

    public static int compareTo(boolean z, boolean z2) {
        int i2 = 1;
        int i3 = z ? 1 : 0;
        if (!z2) {
            i2 = 0;
        }
        return i3 - i2;
    }

    public static int compareTo(byte b2, byte b3) {
        if (b2 < b3) {
            return -1;
        }
        return b2 > b3 ? 1 : 0;
    }

    public static int compareTo(char c2, char c3) {
        if (c2 < c3) {
            return -1;
        }
        return c2 > c3 ? 1 : 0;
    }

    public static int compareTo(short s, short s2) {
        if (s < s2) {
            return -1;
        }
        return s > s2 ? 1 : 0;
    }

    public static int compareTo(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    public static int compareTo(long j2, long j3) {
        if (j2 < j3) {
            return -1;
        }
        return j2 > j3 ? 1 : 0;
    }

    public static int compareTo(float f2, float f3) {
        if (f2 < f3) {
            return -1;
        }
        return f2 > f3 ? 1 : 0;
    }

    public static int compareTo(double d2, double d3) {
        if (d2 < d3) {
            return -1;
        }
        return d2 > d3 ? 1 : 0;
    }

    public static <T extends Comparable<T>> int compareTo(T t, T t2) {
        AppMethodBeat.i(109641);
        int compareTo = t.compareTo(t2);
        AppMethodBeat.o(109641);
        return compareTo;
    }

    public static <T extends Comparable<T>> int compareTo(List<T> list, List<T> list2) {
        AppMethodBeat.i(109642);
        Iterator<T> it = list.iterator();
        Iterator<T> it2 = list2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compareTo = it.next().compareTo(it2.next());
            if (compareTo != 0) {
                AppMethodBeat.o(109642);
                return compareTo;
            }
        }
        int compareTo2 = compareTo(it.hasNext(), it2.hasNext());
        AppMethodBeat.o(109642);
        return compareTo2;
    }

    public static <T extends Comparable<T>> int compareTo(T[] tArr, T[] tArr2) {
        int i2 = 0;
        AppMethodBeat.i(109643);
        int i3 = 0;
        while (i2 < tArr.length && i3 < tArr2.length) {
            int compareTo = tArr[i2].compareTo(tArr2[i3]);
            if (compareTo != 0) {
                AppMethodBeat.o(109643);
                return compareTo;
            }
            i2++;
            i3++;
        }
        int compareTo2 = compareTo(tArr.length, tArr2.length);
        AppMethodBeat.o(109643);
        return compareTo2;
    }

    public static int compareTo(boolean[] zArr, boolean[] zArr2) {
        int i2 = 0;
        AppMethodBeat.i(109644);
        int i3 = 0;
        while (i2 < zArr.length && i3 < zArr2.length) {
            int compareTo = compareTo(zArr[i2], zArr2[i3]);
            if (compareTo != 0) {
                AppMethodBeat.o(109644);
                return compareTo;
            }
            i2++;
            i3++;
        }
        int compareTo2 = compareTo(zArr.length, zArr2.length);
        AppMethodBeat.o(109644);
        return compareTo2;
    }

    public static int compareTo(byte[] bArr, byte[] bArr2) {
        int i2 = 0;
        AppMethodBeat.i(109645);
        int i3 = 0;
        while (i2 < bArr.length && i3 < bArr2.length) {
            int compareTo = compareTo(bArr[i2], bArr2[i3]);
            if (compareTo != 0) {
                AppMethodBeat.o(109645);
                return compareTo;
            }
            i2++;
            i3++;
        }
        int compareTo2 = compareTo(bArr.length, bArr2.length);
        AppMethodBeat.o(109645);
        return compareTo2;
    }

    public static int compareTo(char[] cArr, char[] cArr2) {
        int i2 = 0;
        AppMethodBeat.i(109646);
        int i3 = 0;
        while (i2 < cArr.length && i3 < cArr2.length) {
            int compareTo = compareTo(cArr[i2], cArr2[i3]);
            if (compareTo != 0) {
                AppMethodBeat.o(109646);
                return compareTo;
            }
            i2++;
            i3++;
        }
        int compareTo2 = compareTo(cArr.length, cArr2.length);
        AppMethodBeat.o(109646);
        return compareTo2;
    }

    public static int compareTo(short[] sArr, short[] sArr2) {
        int i2 = 0;
        AppMethodBeat.i(109647);
        int i3 = 0;
        while (i2 < sArr.length && i3 < sArr2.length) {
            int compareTo = compareTo(sArr[i2], sArr2[i3]);
            if (compareTo != 0) {
                AppMethodBeat.o(109647);
                return compareTo;
            }
            i2++;
            i3++;
        }
        int compareTo2 = compareTo(sArr.length, sArr2.length);
        AppMethodBeat.o(109647);
        return compareTo2;
    }

    public static int compareTo(int[] iArr, int[] iArr2) {
        int i2 = 0;
        AppMethodBeat.i(109648);
        int i3 = 0;
        while (i2 < iArr.length && i3 < iArr2.length) {
            int compareTo = compareTo(iArr[i2], iArr2[i3]);
            if (compareTo != 0) {
                AppMethodBeat.o(109648);
                return compareTo;
            }
            i2++;
            i3++;
        }
        int compareTo2 = compareTo(iArr.length, iArr2.length);
        AppMethodBeat.o(109648);
        return compareTo2;
    }

    public static int compareTo(long[] jArr, long[] jArr2) {
        int i2 = 0;
        AppMethodBeat.i(109649);
        int i3 = 0;
        while (i2 < jArr.length && i3 < jArr2.length) {
            int compareTo = compareTo(jArr[i2], jArr2[i3]);
            if (compareTo != 0) {
                AppMethodBeat.o(109649);
                return compareTo;
            }
            i2++;
            i3++;
        }
        int compareTo2 = compareTo(jArr.length, jArr2.length);
        AppMethodBeat.o(109649);
        return compareTo2;
    }

    public static int compareTo(float[] fArr, float[] fArr2) {
        int i2 = 0;
        AppMethodBeat.i(109650);
        int i3 = 0;
        while (i2 < fArr.length && i3 < fArr2.length) {
            int compareTo = compareTo(fArr[i2], fArr2[i3]);
            if (compareTo != 0) {
                AppMethodBeat.o(109650);
                return compareTo;
            }
            i2++;
            i3++;
        }
        int compareTo2 = compareTo(fArr.length, fArr2.length);
        AppMethodBeat.o(109650);
        return compareTo2;
    }

    public static int compareTo(double[] dArr, double[] dArr2) {
        int i2 = 0;
        AppMethodBeat.i(109651);
        int i3 = 0;
        while (i2 < dArr.length && i3 < dArr2.length) {
            int compareTo = compareTo(dArr[i2], dArr2[i3]);
            if (compareTo != 0) {
                AppMethodBeat.o(109651);
                return compareTo;
            }
            i2++;
            i3++;
        }
        int compareTo2 = compareTo(dArr.length, dArr2.length);
        AppMethodBeat.o(109651);
        return compareTo2;
    }

    public static int hashCode(boolean z) {
        return (z ? 0 : 1) + 629;
    }

    public static int hashCode(boolean[] zArr) {
        if (zArr == null) {
            return 629;
        }
        int i2 = 17;
        for (int i3 = 0; i3 < zArr.length; i3++) {
            i2 = (zArr[i3] ? 0 : 1) + (i2 * 37);
        }
        return i2;
    }

    public static int hashCode(byte b2) {
        return b2 + 629;
    }

    public static int hashCode(byte[] bArr) {
        if (bArr == null) {
            return 629;
        }
        int i2 = 17;
        for (byte b2 : bArr) {
            i2 = (i2 * 37) + b2;
        }
        return i2;
    }

    public static int hashCode(char c2) {
        return c2 + 629;
    }

    public static int hashCode(char[] cArr) {
        if (cArr == null) {
            return 629;
        }
        int i2 = 17;
        for (char c2 : cArr) {
            i2 = (i2 * 37) + c2;
        }
        return i2;
    }

    public static int hashCode(double d2) {
        AppMethodBeat.i(109652);
        int hashCode = hashCode(Double.doubleToLongBits(d2));
        AppMethodBeat.o(109652);
        return hashCode;
    }

    public static int hashCode(double[] dArr) {
        AppMethodBeat.i(109653);
        if (dArr == null) {
            AppMethodBeat.o(109653);
            return 629;
        }
        int i2 = 17;
        for (int i3 = 0; i3 < dArr.length; i3++) {
            i2 = (i2 * 37) + ((int) (Double.doubleToLongBits(dArr[i3]) ^ (Double.doubleToLongBits(dArr[i3]) >> 32)));
        }
        AppMethodBeat.o(109653);
        return i2;
    }

    public static int hashCode(float f2) {
        AppMethodBeat.i(109654);
        int floatToIntBits = Float.floatToIntBits(f2) + 629;
        AppMethodBeat.o(109654);
        return floatToIntBits;
    }

    public static int hashCode(float[] fArr) {
        AppMethodBeat.i(109655);
        if (fArr == null) {
            AppMethodBeat.o(109655);
            return 629;
        }
        int i2 = 17;
        for (float f2 : fArr) {
            i2 = (i2 * 37) + Float.floatToIntBits(f2);
        }
        AppMethodBeat.o(109655);
        return i2;
    }

    public static int hashCode(short s) {
        return s + 629;
    }

    public static int hashCode(short[] sArr) {
        if (sArr == null) {
            return 629;
        }
        int i2 = 17;
        for (short s : sArr) {
            i2 = (i2 * 37) + s;
        }
        return i2;
    }

    public static int hashCode(int i2) {
        return i2 + 629;
    }

    public static int hashCode(int[] iArr) {
        if (iArr == null) {
            return 629;
        }
        int i2 = 17;
        for (int i3 : iArr) {
            i2 = (i2 * 37) + i3;
        }
        return i2;
    }

    public static int hashCode(long j2) {
        return ((int) ((j2 >> 32) ^ j2)) + 629;
    }

    public static int hashCode(long[] jArr) {
        if (jArr == null) {
            return 629;
        }
        int i2 = 17;
        for (int i3 = 0; i3 < jArr.length; i3++) {
            i2 = (i2 * 37) + ((int) (jArr[i3] ^ (jArr[i3] >> 32)));
        }
        return i2;
    }

    public static int hashCode(JceStruct[] jceStructArr) {
        AppMethodBeat.i(109656);
        if (jceStructArr == null) {
            AppMethodBeat.o(109656);
            return 629;
        }
        int i2 = 17;
        for (JceStruct jceStruct : jceStructArr) {
            i2 = (i2 * 37) + jceStruct.hashCode();
        }
        AppMethodBeat.o(109656);
        return i2;
    }

    public static int hashCode(Object obj) {
        AppMethodBeat.i(109657);
        for (Object obj2 = obj; obj2 != null; obj2 = (Object[]) obj2) {
            if (obj2.getClass().isArray()) {
                if (obj2 instanceof long[]) {
                    int hashCode = hashCode((long[]) obj2);
                    AppMethodBeat.o(109657);
                    return hashCode;
                } else if (obj2 instanceof int[]) {
                    int hashCode2 = hashCode((int[]) obj2);
                    AppMethodBeat.o(109657);
                    return hashCode2;
                } else if (obj2 instanceof short[]) {
                    int hashCode3 = hashCode((short[]) obj2);
                    AppMethodBeat.o(109657);
                    return hashCode3;
                } else if (obj2 instanceof char[]) {
                    int hashCode4 = hashCode((char[]) obj2);
                    AppMethodBeat.o(109657);
                    return hashCode4;
                } else if (obj2 instanceof byte[]) {
                    int hashCode5 = hashCode((byte[]) obj2);
                    AppMethodBeat.o(109657);
                    return hashCode5;
                } else if (obj2 instanceof double[]) {
                    int hashCode6 = hashCode((double[]) obj2);
                    AppMethodBeat.o(109657);
                    return hashCode6;
                } else if (obj2 instanceof float[]) {
                    int hashCode7 = hashCode((float[]) obj2);
                    AppMethodBeat.o(109657);
                    return hashCode7;
                } else if (obj2 instanceof boolean[]) {
                    int hashCode8 = hashCode((boolean[]) obj2);
                    AppMethodBeat.o(109657);
                    return hashCode8;
                } else if (obj2 instanceof JceStruct[]) {
                    int hashCode9 = hashCode((JceStruct[]) obj2);
                    AppMethodBeat.o(109657);
                    return hashCode9;
                }
            } else if (obj2 instanceof JceStruct) {
                int hashCode10 = obj2.hashCode();
                AppMethodBeat.o(109657);
                return hashCode10;
            } else {
                int hashCode11 = obj2.hashCode() + 629;
                AppMethodBeat.o(109657);
                return hashCode11;
            }
        }
        AppMethodBeat.o(109657);
        return 629;
    }

    public static byte[] getJceBufArray(ByteBuffer byteBuffer) {
        AppMethodBeat.i(109658);
        byte[] bArr = new byte[byteBuffer.position()];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, bArr.length);
        AppMethodBeat.o(109658);
        return bArr;
    }

    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr2[i2] = bArr[i2 >>> 4];
            bArr3[i2] = bArr[i2 & 15];
        }
        highDigits = bArr2;
        lowDigits = bArr3;
    }

    public static String getHexdump(byte[] bArr) {
        AppMethodBeat.i(109659);
        String hexdump = getHexdump(ByteBuffer.wrap(bArr));
        AppMethodBeat.o(109659);
        return hexdump;
    }

    public static String getHexdump(ByteBuffer byteBuffer) {
        AppMethodBeat.i(109660);
        int remaining = byteBuffer.remaining();
        if (remaining == 0) {
            AppMethodBeat.o(109660);
            return "empty";
        }
        StringBuffer stringBuffer = new StringBuffer((byteBuffer.remaining() * 3) - 1);
        int position = byteBuffer.position();
        int i2 = byteBuffer.get() & 255;
        stringBuffer.append((char) highDigits[i2]);
        stringBuffer.append((char) lowDigits[i2]);
        for (int i3 = remaining - 1; i3 > 0; i3--) {
            stringBuffer.append(' ');
            int i4 = byteBuffer.get() & 255;
            stringBuffer.append((char) highDigits[i4]);
            stringBuffer.append((char) lowDigits[i4]);
        }
        byteBuffer.position(position);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(109660);
        return stringBuffer2;
    }
}
