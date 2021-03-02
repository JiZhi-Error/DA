package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.BufferInfo;
import com.tencent.qqmusic.mediaplayer.FloatBufferInfo;

public class PcmConvertionUtil {
    public static void convertBitDepthTo16(BufferInfo bufferInfo, BufferInfo bufferInfo2, int i2) {
        AppMethodBeat.i(103503);
        switch (i2) {
            case 2:
                checkBufferLength(bufferInfo);
                bufferInfo.fillInto(bufferInfo2);
                AppMethodBeat.o(103503);
                return;
            case 3:
                convertBitDepth24To16(bufferInfo, bufferInfo2, i2);
                AppMethodBeat.o(103503);
                return;
            case 4:
                convertBitDepth32To16(bufferInfo, bufferInfo2, i2);
                AppMethodBeat.o(103503);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("not support originBitDepth, originBitDepth=".concat(String.valueOf(i2)));
                AppMethodBeat.o(103503);
                throw illegalArgumentException;
        }
    }

    private static void convertBitDepth24To16(BufferInfo bufferInfo, BufferInfo bufferInfo2, int i2) {
        int i3;
        AppMethodBeat.i(103504);
        checkBufferLength(bufferInfo);
        if (bufferInfo2 == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("BufferInfo dest must not be null");
            AppMethodBeat.o(103504);
            throw illegalArgumentException;
        } else if (i2 != 3) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("origin bit depth must be 3");
            AppMethodBeat.o(103504);
            throw illegalArgumentException2;
        } else {
            int i4 = bufferInfo.bufferSize;
            bufferInfo2.setTempByteBufferCapacity(bufferInfo.bufferSize);
            int i5 = 0;
            int i6 = 0;
            while (i5 < i4) {
                if (i5 % 3 != 0) {
                    i3 = i6 + 1;
                    bufferInfo2.tempByteBuffer[i6] = bufferInfo.byteBuffer[i5];
                } else {
                    i3 = i6;
                }
                i5++;
                i6 = i3;
            }
            bufferInfo2.fillByte(bufferInfo2.tempByteBuffer, i6);
            bufferInfo2.bufferSize = i6;
            AppMethodBeat.o(103504);
        }
    }

    private static void convertBitDepth32To16(BufferInfo bufferInfo, BufferInfo bufferInfo2, int i2) {
        AppMethodBeat.i(103505);
        checkBufferLength(bufferInfo);
        if (bufferInfo2 == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("BufferInfo dest must not be null");
            AppMethodBeat.o(103505);
            throw illegalArgumentException;
        } else if (i2 != 4) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("origin bit depth must be 4");
            AppMethodBeat.o(103505);
            throw illegalArgumentException2;
        } else {
            int i3 = bufferInfo.bufferSize;
            bufferInfo2.setTempByteBufferCapacity(bufferInfo.bufferSize);
            int i4 = 0;
            int i5 = 0;
            while (i4 < i3) {
                DataConversionUtil.floatTo2Bytes(DataConversionUtil.bytesToFloat32bitInLittleEndian(bufferInfo.byteBuffer, i4), bufferInfo2.tempByteBuffer, i5);
                i4 += 4;
                i5 += 2;
            }
            bufferInfo2.fillByte(bufferInfo2.tempByteBuffer, i5);
            bufferInfo2.bufferSize = i5;
            AppMethodBeat.o(103505);
        }
    }

    public static void convertByteBufferToFloatBuffer(BufferInfo bufferInfo, FloatBufferInfo floatBufferInfo, int i2) {
        AppMethodBeat.i(103506);
        checkBufferLength(bufferInfo);
        if (floatBufferInfo == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("BufferInfo dest must not be null");
            AppMethodBeat.o(103506);
            throw illegalArgumentException;
        } else if (i2 <= 0) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("bit depth must not be zero");
            AppMethodBeat.o(103506);
            throw illegalArgumentException2;
        } else {
            floatBufferInfo.setTempFloatBufferCapacity(bufferInfo.bufferSize / i2);
            floatBufferInfo.bufferSize = bufferInfo.bufferSize / i2;
            DataConversionUtil.byteArrayToFloatArray(bufferInfo.byteBuffer, bufferInfo.bufferSize, i2, floatBufferInfo.tempFloatBuffer);
            floatBufferInfo.fillFloat(floatBufferInfo.tempFloatBuffer, floatBufferInfo.bufferSize);
            AppMethodBeat.o(103506);
        }
    }

    public static void reSample(BufferInfo bufferInfo, BufferInfo bufferInfo2, long j2, long j3, int i2) {
        AppMethodBeat.i(103507);
        checkBufferLength(bufferInfo);
        if (bufferInfo2 == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("BufferInfo dest must not be null");
            AppMethodBeat.o(103507);
            throw illegalArgumentException;
        } else if (j2 == j3 || j3 <= 0 || j2 <= 0) {
            bufferInfo.fillInto(bufferInfo2);
            AppMethodBeat.o(103507);
        } else {
            switch (i2) {
                case 2:
                    interpolateIn16Bit(bufferInfo, bufferInfo2, j2, j3);
                    AppMethodBeat.o(103507);
                    return;
                case 3:
                    interpolateIn24Bit(bufferInfo, bufferInfo2, j2, j3);
                    AppMethodBeat.o(103507);
                    return;
                case 4:
                    interpolateIn32Bit(bufferInfo, bufferInfo2, j2, j3);
                    AppMethodBeat.o(103507);
                    return;
                default:
                    bufferInfo.fillInto(bufferInfo2);
                    AppMethodBeat.o(103507);
                    return;
            }
        }
    }

    private static void interpolateIn16Bit(BufferInfo bufferInfo, BufferInfo bufferInfo2, long j2, long j3) {
        AppMethodBeat.i(103508);
        int i2 = bufferInfo.bufferSize / 2;
        int round = Math.round(((1.0f * ((float) i2)) / ((float) j2)) * ((float) j3));
        short[] sArr = new short[i2];
        short[] sArr2 = new short[round];
        DataConversionUtil.byteArray16BitToShortArray(bufferInfo.byteBuffer, bufferInfo.bufferSize, sArr);
        linearInterpolate(sArr, i2, sArr2, round, ((float) round) / ((float) i2));
        byte[] bArr = new byte[(round * 2)];
        DataConversionUtil.shortArrayToByteArray16Bit(sArr2, round, bArr);
        bufferInfo2.fillByte(bArr, bArr.length);
        AppMethodBeat.o(103508);
    }

    private static void interpolateIn24Bit(BufferInfo bufferInfo, BufferInfo bufferInfo2, long j2, long j3) {
        AppMethodBeat.i(103509);
        int i2 = bufferInfo.bufferSize / 3;
        int round = Math.round(((1.0f * ((float) i2)) / ((float) j2)) * ((float) j3));
        int[] iArr = new int[i2];
        int[] iArr2 = new int[round];
        DataConversionUtil.byteArray24BitToIntArray(bufferInfo.byteBuffer, bufferInfo.bufferSize, iArr);
        linearInterpolate(iArr, i2, iArr2, round, ((float) round) / ((float) i2));
        byte[] bArr = new byte[(round * 3)];
        DataConversionUtil.intArrayToByteArray24Bit(iArr2, round, bArr);
        bufferInfo2.fillByte(bArr, bArr.length);
        AppMethodBeat.o(103509);
    }

    private static void interpolateIn32Bit(BufferInfo bufferInfo, BufferInfo bufferInfo2, long j2, long j3) {
        AppMethodBeat.i(103510);
        int i2 = bufferInfo.bufferSize / 4;
        int round = Math.round(((1.0f * ((float) i2)) / ((float) j2)) * ((float) j3));
        int[] iArr = new int[i2];
        int[] iArr2 = new int[round];
        DataConversionUtil.byteArray32BitToIntArray(bufferInfo.byteBuffer, bufferInfo.bufferSize, iArr);
        linearInterpolate(iArr, i2, iArr2, round, ((float) round) / ((float) i2));
        byte[] bArr = new byte[(round * 4)];
        DataConversionUtil.intArrayToByteArray32Bit(iArr2, round, bArr);
        bufferInfo2.fillByte(bArr, bArr.length);
        AppMethodBeat.o(103510);
    }

    private static void linearInterpolate(int[] iArr, int i2, int[] iArr2, int i3, float f2) {
        AppMethodBeat.i(103511);
        checkArrayLength(iArr, i2);
        checkArrayLength(iArr2, i3);
        for (int i4 = 0; i4 < i3; i4++) {
            float f3 = ((float) i4) / f2;
            int i5 = (int) f3;
            int i6 = i5 + 1;
            if (i6 >= i2) {
                i6 = i2 - 1;
            }
            iArr2[i4] = (int) ((((float) (iArr[i6] - iArr[i5])) * (f3 - ((float) i5))) + ((float) iArr[i5]));
        }
        AppMethodBeat.o(103511);
    }

    private static void linearInterpolate(short[] sArr, int i2, short[] sArr2, int i3, float f2) {
        AppMethodBeat.i(103512);
        checkArrayLength(sArr, i2);
        checkArrayLength(sArr2, i3);
        for (int i4 = 0; i4 < i3; i4++) {
            float f3 = ((float) i4) / f2;
            int i5 = (int) f3;
            int i6 = i5 + 1;
            if (i6 >= i2) {
                i6 = i2 - 1;
            }
            sArr2[i4] = (short) ((int) ((((float) (sArr[i6] - sArr[i5])) * (f3 - ((float) i5))) + ((float) sArr[i5])));
        }
        AppMethodBeat.o(103512);
    }

    private static void checkBufferLength(BufferInfo bufferInfo) {
        AppMethodBeat.i(103513);
        if (bufferInfo == null || bufferInfo.byteBuffer == null || bufferInfo.bufferSize <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("bufferInfo must not be null or zero length");
            AppMethodBeat.o(103513);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(103513);
    }

    private static void checkArrayLength(int[] iArr, int i2) {
        AppMethodBeat.i(103514);
        if (iArr == null || iArr.length == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("int Array must not be null or zero length");
            AppMethodBeat.o(103514);
            throw illegalArgumentException;
        } else if (i2 > iArr.length) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("the length param can not larger than int Array length. param:" + i2 + ", int array length:" + iArr.length);
            AppMethodBeat.o(103514);
            throw illegalArgumentException2;
        } else {
            AppMethodBeat.o(103514);
        }
    }

    private static void checkArrayLength(short[] sArr, int i2) {
        AppMethodBeat.i(103515);
        if (sArr == null || sArr.length == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("short Array must not be null or zero length");
            AppMethodBeat.o(103515);
            throw illegalArgumentException;
        } else if (i2 > sArr.length) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("the length param can not larger than short Array length. param:" + i2 + ", short array length:" + sArr.length);
            AppMethodBeat.o(103515);
            throw illegalArgumentException2;
        } else {
            AppMethodBeat.o(103515);
        }
    }
}
