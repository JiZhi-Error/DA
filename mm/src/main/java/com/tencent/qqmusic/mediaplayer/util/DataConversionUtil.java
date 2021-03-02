package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteOrder;

public class DataConversionUtil {
    private static final float BASE_16BIT = 32768.0f;
    private static final float BASE_32BIT = 2.14748365E9f;
    private static final boolean IS_LITTLE_ENDIAN = (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN);

    static {
        AppMethodBeat.i(87727);
        AppMethodBeat.o(87727);
    }

    public static float bytesToFloat24bit(byte[] bArr, int i2) {
        AppMethodBeat.i(87708);
        if (IS_LITTLE_ENDIAN) {
            float bytesToFloat24bitInLittleEndian = bytesToFloat24bitInLittleEndian(bArr, i2);
            AppMethodBeat.o(87708);
            return bytesToFloat24bitInLittleEndian;
        }
        float bytesToFloat24bitInBigEndian = bytesToFloat24bitInBigEndian(bArr, i2);
        AppMethodBeat.o(87708);
        return bytesToFloat24bitInBigEndian;
    }

    public static float bytesToFloat32bit(byte[] bArr, int i2) {
        AppMethodBeat.i(87709);
        if (IS_LITTLE_ENDIAN) {
            float bytesToFloat32bitInLittleEndian = bytesToFloat32bitInLittleEndian(bArr, i2);
            AppMethodBeat.o(87709);
            return bytesToFloat32bitInLittleEndian;
        }
        float bytesToFloat32bitInBigEndian = bytesToFloat32bitInBigEndian(bArr, i2);
        AppMethodBeat.o(87709);
        return bytesToFloat32bitInBigEndian;
    }

    public static float bytesToFloat24bitInLittleEndian(byte[] bArr, int i2) {
        AppMethodBeat.i(87710);
        float bytesToInt24bitInLittleEndian = ((float) bytesToInt24bitInLittleEndian(bArr, i2)) / BASE_32BIT;
        AppMethodBeat.o(87710);
        return bytesToInt24bitInLittleEndian;
    }

    public static float bytesToFloat24bitInBigEndian(byte[] bArr, int i2) {
        AppMethodBeat.i(87711);
        float bytesToInt24bitInBigEndian = ((float) bytesToInt24bitInBigEndian(bArr, i2)) / BASE_32BIT;
        AppMethodBeat.o(87711);
        return bytesToInt24bitInBigEndian;
    }

    public static float bytesToFloat32bitInLittleEndian(byte[] bArr, int i2) {
        AppMethodBeat.i(87712);
        float bytesToInt32bitInLittleEndian = ((float) bytesToInt32bitInLittleEndian(bArr, i2)) / BASE_32BIT;
        AppMethodBeat.o(87712);
        return bytesToInt32bitInLittleEndian;
    }

    public static float bytesToFloat32bitInBigEndian(byte[] bArr, int i2) {
        AppMethodBeat.i(87713);
        float bytesToInt32bitInBigEndian = ((float) bytesToInt32bitInBigEndian(bArr, i2)) / BASE_32BIT;
        AppMethodBeat.o(87713);
        return bytesToInt32bitInBigEndian;
    }

    public static short bytesToShort16bitInLittleEndian(byte[] bArr, int i2) {
        return (short) ((bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8));
    }

    public static short bytesToShort16bitInBigEndian(byte[] bArr, int i2) {
        return (short) ((bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8));
    }

    public static int bytesToInt24bitInLittleEndian(byte[] bArr, int i2) {
        return ((bArr[i2] << 8) & 255) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 24);
    }

    public static int bytesToInt24bitInBigEndian(byte[] bArr, int i2) {
        return ((bArr[i2 + 2] << 8) & 255) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2] & 255) << 24);
    }

    public static int bytesToInt32bitInLittleEndian(byte[] bArr, int i2) {
        return (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24);
    }

    public static int bytesToInt32bitInBigEndian(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2 + 2] & 255) << 8) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2] & 255) << 24);
    }

    public static void floatTo2Bytes(float f2, byte[] bArr, int i2) {
        float f3 = 1.0f;
        float f4 = -1.0f;
        AppMethodBeat.i(87714);
        if (f2 <= 1.0f) {
            f3 = f2;
        }
        if (f3 >= -1.0f) {
            f4 = f3;
        }
        shortTo2Bytes((short) ((int) (f4 * BASE_16BIT)), bArr, i2);
        AppMethodBeat.o(87714);
    }

    public static void shortTo2Bytes(short s, byte[] bArr, int i2) {
        if (IS_LITTLE_ENDIAN) {
            bArr[i2] = (byte) (s & 255);
            bArr[i2 + 1] = (byte) ((s >> 8) & 255);
            return;
        }
        bArr[i2 + 1] = (byte) (s & 255);
        bArr[i2] = (byte) ((s >> 8) & 255);
    }

    public static void intTo3Bytes(int i2, byte[] bArr, int i3) {
        if (IS_LITTLE_ENDIAN) {
            bArr[i3] = (byte) ((i2 >> 8) & 255);
            bArr[i3 + 1] = (byte) ((i2 >> 16) & 255);
            bArr[i3 + 2] = (byte) ((i2 >> 24) & 255);
            return;
        }
        bArr[i3 + 2] = (byte) ((i2 >> 8) & 255);
        bArr[i3 + 1] = (byte) ((i2 >> 16) & 255);
        bArr[i3] = (byte) ((i2 >> 24) & 255);
    }

    public static void intTo4Bytes(int i2, byte[] bArr, int i3) {
        if (IS_LITTLE_ENDIAN) {
            bArr[i3] = (byte) (i2 & 255);
            bArr[i3 + 1] = (byte) ((i2 >> 8) & 255);
            bArr[i3 + 2] = (byte) ((i2 >> 16) & 255);
            bArr[i3 + 3] = (byte) ((i2 >> 24) & 255);
            return;
        }
        bArr[i3 + 3] = (byte) (i2 & 255);
        bArr[i3 + 2] = (byte) ((i2 >> 8) & 255);
        bArr[i3 + 1] = (byte) ((i2 >> 16) & 255);
        bArr[i3] = (byte) ((i2 >> 24) & 255);
    }

    public static int byteArrayToFloatArray(byte[] bArr, int i2, int i3, float[] fArr) {
        float bytesToFloat32bit;
        AppMethodBeat.i(87715);
        checkByteArrayLength(bArr, i2);
        checkFloatArrayLength(fArr, i2 / i3);
        checkByteArrayProperty(i2, i3);
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = i4 / i3;
            if (i3 == 3) {
                bytesToFloat32bit = bytesToFloat24bit(bArr, i4);
            } else {
                bytesToFloat32bit = bytesToFloat32bit(bArr, i4);
            }
            fArr[i6] = bytesToFloat32bit;
            i5++;
            i4 += i3;
        }
        AppMethodBeat.o(87715);
        return i5;
    }

    public static int byteArray16BitToShortArray(byte[] bArr, int i2, short[] sArr) {
        short bytesToShort16bitInBigEndian;
        AppMethodBeat.i(87716);
        checkByteArrayLength(bArr, i2);
        checkShortArrayLength(sArr, i2 / 2);
        if (i2 % 2 != 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("length of byteArray must be multiple of 2");
            AppMethodBeat.o(87716);
            throw illegalArgumentException;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i2 && i3 < sArr.length; i4 += 2) {
            if (IS_LITTLE_ENDIAN) {
                bytesToShort16bitInBigEndian = bytesToShort16bitInLittleEndian(bArr, i4);
            } else {
                bytesToShort16bitInBigEndian = bytesToShort16bitInBigEndian(bArr, i4);
            }
            sArr[i3] = bytesToShort16bitInBigEndian;
            i3++;
        }
        AppMethodBeat.o(87716);
        return i3;
    }

    public static int byteArray24BitToIntArray(byte[] bArr, int i2, int[] iArr) {
        int bytesToInt24bitInBigEndian;
        AppMethodBeat.i(87717);
        checkByteArrayLength(bArr, i2);
        checkIntArrayLength(iArr, i2 / 3);
        if (i2 % 3 != 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("length of byteArray must be multiple of 3");
            AppMethodBeat.o(87717);
            throw illegalArgumentException;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i2 && i3 < iArr.length; i4 += 3) {
            if (IS_LITTLE_ENDIAN) {
                bytesToInt24bitInBigEndian = bytesToInt24bitInLittleEndian(bArr, i4);
            } else {
                bytesToInt24bitInBigEndian = bytesToInt24bitInBigEndian(bArr, i4);
            }
            iArr[i3] = bytesToInt24bitInBigEndian;
            i3++;
        }
        AppMethodBeat.o(87717);
        return i3;
    }

    public static int byteArray32BitToIntArray(byte[] bArr, int i2, int[] iArr) {
        int bytesToInt32bitInBigEndian;
        AppMethodBeat.i(87718);
        checkByteArrayLength(bArr, i2);
        checkIntArrayLength(iArr, i2 / 4);
        if (i2 % 4 != 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("length of byteArray must be multiple of 4");
            AppMethodBeat.o(87718);
            throw illegalArgumentException;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i2 && i3 < iArr.length; i4 += 4) {
            if (IS_LITTLE_ENDIAN) {
                bytesToInt32bitInBigEndian = bytesToInt32bitInLittleEndian(bArr, i4);
            } else {
                bytesToInt32bitInBigEndian = bytesToInt32bitInBigEndian(bArr, i4);
            }
            iArr[i3] = bytesToInt32bitInBigEndian;
            i3++;
        }
        AppMethodBeat.o(87718);
        return i3;
    }

    public static int shortArrayToByteArray16Bit(short[] sArr, int i2, byte[] bArr) {
        AppMethodBeat.i(87719);
        checkShortArrayLength(sArr, i2);
        checkByteArrayLength(bArr, i2 * 2);
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            shortTo2Bytes(sArr[i3], bArr, i4);
            i3++;
            i4 += 2;
        }
        AppMethodBeat.o(87719);
        return i4;
    }

    public static int intArrayToByteArray24Bit(int[] iArr, int i2, byte[] bArr) {
        AppMethodBeat.i(87720);
        checkIntArrayLength(iArr, i2);
        checkByteArrayLength(bArr, i2 * 3);
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            intTo3Bytes(iArr[i3], bArr, i4);
            i3++;
            i4 += 3;
        }
        AppMethodBeat.o(87720);
        return i4;
    }

    public static int intArrayToByteArray32Bit(int[] iArr, int i2, byte[] bArr) {
        AppMethodBeat.i(87721);
        checkIntArrayLength(iArr, i2);
        checkByteArrayLength(bArr, i2 * 4);
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            intTo4Bytes(iArr[i3], bArr, i4);
            i3++;
            i4 += 4;
        }
        AppMethodBeat.o(87721);
        return i4;
    }

    private static void checkByteArrayProperty(int i2, int i3) {
        AppMethodBeat.i(87722);
        if (i3 > 4 || i3 < 3) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("bytesPerSample of " + i3 + " is not supported");
            AppMethodBeat.o(87722);
            throw illegalArgumentException;
        } else if (i2 % i3 != 0) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("length of byteArray must be multiple of bytesPerSample");
            AppMethodBeat.o(87722);
            throw illegalArgumentException2;
        } else {
            AppMethodBeat.o(87722);
        }
    }

    private static void checkByteArrayLength(byte[] bArr, int i2) {
        AppMethodBeat.i(87723);
        if (bArr == null || bArr.length == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("byte Array must not be null or zero length");
            AppMethodBeat.o(87723);
            throw illegalArgumentException;
        } else if (i2 > bArr.length) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("the length param can not larger than byte Array length. param:" + i2 + ", byte array length:" + bArr.length);
            AppMethodBeat.o(87723);
            throw illegalArgumentException2;
        } else {
            AppMethodBeat.o(87723);
        }
    }

    private static void checkShortArrayLength(short[] sArr, int i2) {
        AppMethodBeat.i(87724);
        if (sArr == null || sArr.length == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("short Array must not be null or zero length");
            AppMethodBeat.o(87724);
            throw illegalArgumentException;
        } else if (i2 > sArr.length) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("the length param can not larger than short Array length. param:" + i2 + ", short array length:" + sArr.length);
            AppMethodBeat.o(87724);
            throw illegalArgumentException2;
        } else {
            AppMethodBeat.o(87724);
        }
    }

    private static void checkIntArrayLength(int[] iArr, int i2) {
        AppMethodBeat.i(87725);
        if (iArr == null || iArr.length == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("int Array must not be null or zero length");
            AppMethodBeat.o(87725);
            throw illegalArgumentException;
        } else if (i2 > iArr.length) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("the length param can not larger than int Array length. param:" + i2 + ", int array length:" + iArr.length);
            AppMethodBeat.o(87725);
            throw illegalArgumentException2;
        } else {
            AppMethodBeat.o(87725);
        }
    }

    private static void checkFloatArrayLength(float[] fArr, int i2) {
        AppMethodBeat.i(87726);
        if (fArr == null || fArr.length == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("float Array must not be null or zero length");
            AppMethodBeat.o(87726);
            throw illegalArgumentException;
        } else if (i2 > fArr.length) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("the length param can not larger than float Array length. param:" + i2 + ", float array length:" + fArr.length);
            AppMethodBeat.o(87726);
            throw illegalArgumentException2;
        } else {
            AppMethodBeat.o(87726);
        }
    }
}
