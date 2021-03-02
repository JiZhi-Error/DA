package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteOrder;

public class BytesTransUtil {
    private static BytesTransUtil instance = null;
    private String TAG = "BytesTransUtil";

    private BytesTransUtil() {
    }

    public static BytesTransUtil getInstance() {
        AppMethodBeat.i(87728);
        if (instance == null) {
            instance = new BytesTransUtil();
        }
        BytesTransUtil bytesTransUtil = instance;
        AppMethodBeat.o(87728);
        return bytesTransUtil;
    }

    public boolean testCPU() {
        AppMethodBeat.i(87729);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            AppMethodBeat.o(87729);
            return true;
        }
        AppMethodBeat.o(87729);
        return false;
    }

    public byte[] getBytes(short s, boolean z) {
        byte[] bArr = new byte[2];
        if (z) {
            for (int i2 = 1; i2 >= 0; i2--) {
                bArr[i2] = (byte) (s & 255);
                s = (short) (s >> 8);
            }
        } else {
            for (int i3 = 0; i3 < 2; i3++) {
                bArr[i3] = (byte) (s & 255);
                s = (short) (s >> 8);
            }
        }
        return bArr;
    }

    public byte[] getBytes(int i2, boolean z) {
        AppMethodBeat.i(87730);
        byte[] bArr = new byte[4];
        if (z) {
            for (int i3 = 3; i3 >= 0; i3--) {
                bArr[i3] = (byte) (i2 & 255);
                i2 >>= 8;
            }
        } else {
            System.out.println("1");
            for (int i4 = 0; i4 < 4; i4++) {
                bArr[i4] = (byte) (i2 & 255);
                i2 >>= 8;
            }
        }
        AppMethodBeat.o(87730);
        return bArr;
    }

    public byte[] getBytes(long j2, boolean z) {
        byte[] bArr = new byte[8];
        if (z) {
            for (int i2 = 7; i2 >= 0; i2--) {
                bArr[i2] = (byte) ((int) (j2 & 255));
                j2 >>= 8;
            }
        } else {
            for (int i3 = 0; i3 < 8; i3++) {
                bArr[i3] = (byte) ((int) (j2 & 255));
                j2 >>= 8;
            }
        }
        return bArr;
    }

    public short getShort(byte[] bArr, boolean z) {
        short s;
        AppMethodBeat.i(87731);
        if (bArr == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("byte array is null!");
            AppMethodBeat.o(87731);
            throw illegalArgumentException;
        } else if (bArr.length > 2) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("byte array size > 2 !");
            AppMethodBeat.o(87731);
            throw illegalArgumentException2;
        } else {
            if (z) {
                s = 0;
                for (byte b2 : bArr) {
                    s = (short) (((short) (s << 8)) | (b2 & 255));
                }
            } else {
                s = 0;
                for (int length = bArr.length - 1; length >= 0; length--) {
                    s = (short) (((short) (s << 8)) | (bArr[length] & 255));
                }
            }
            AppMethodBeat.o(87731);
            return s;
        }
    }

    public int getInt(byte[] bArr, boolean z) {
        int i2;
        AppMethodBeat.i(87732);
        if (bArr == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("byte array is null!");
            AppMethodBeat.o(87732);
            throw illegalArgumentException;
        } else if (bArr.length > 4) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("byte array size > 4 !");
            AppMethodBeat.o(87732);
            throw illegalArgumentException2;
        } else {
            if (z) {
                i2 = 0;
                for (byte b2 : bArr) {
                    i2 = (i2 << 8) | (b2 & 255);
                }
            } else {
                i2 = 0;
                for (int length = bArr.length - 1; length >= 0; length--) {
                    i2 = (i2 << 8) | (bArr[length] & 255);
                }
            }
            AppMethodBeat.o(87732);
            return i2;
        }
    }

    public long getLong(byte[] bArr, boolean z) {
        AppMethodBeat.i(87733);
        if (bArr == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("byte array is null!");
            AppMethodBeat.o(87733);
            throw illegalArgumentException;
        } else if (bArr.length > 8) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("byte array size > 8 !");
            AppMethodBeat.o(87733);
            throw illegalArgumentException2;
        } else {
            long j2 = 0;
            if (z) {
                for (byte b2 : bArr) {
                    j2 = (j2 << 8) | ((long) (b2 & 255));
                }
            } else {
                for (int length = bArr.length - 1; length >= 0; length--) {
                    j2 = (j2 << 8) | ((long) (bArr[length] & 255));
                }
            }
            AppMethodBeat.o(87733);
            return j2;
        }
    }

    public byte[] getBytes(int i2) {
        AppMethodBeat.i(87734);
        byte[] bytes = getBytes(i2, testCPU());
        AppMethodBeat.o(87734);
        return bytes;
    }

    public byte[] getBytes(short s) {
        AppMethodBeat.i(87735);
        byte[] bytes = getBytes(s, testCPU());
        AppMethodBeat.o(87735);
        return bytes;
    }

    public byte[] getBytes(long j2) {
        AppMethodBeat.i(87736);
        byte[] bytes = getBytes(j2, testCPU());
        AppMethodBeat.o(87736);
        return bytes;
    }

    public int getInt(byte[] bArr) {
        AppMethodBeat.i(87737);
        int i2 = getInt(bArr, testCPU());
        AppMethodBeat.o(87737);
        return i2;
    }

    public short getShort(byte[] bArr) {
        AppMethodBeat.i(87738);
        short s = getShort(bArr, testCPU());
        AppMethodBeat.o(87738);
        return s;
    }

    public long getLong(byte[] bArr) {
        AppMethodBeat.i(87739);
        long j2 = getLong(bArr, testCPU());
        AppMethodBeat.o(87739);
        return j2;
    }

    public short[] Bytes2Shorts(short[] sArr, byte[] bArr) {
        AppMethodBeat.i(87740);
        byte[] bArr2 = new byte[2];
        for (int i2 = 0; i2 < sArr.length; i2++) {
            System.arraycopy(bArr, i2 * 2, bArr2, 0, 2);
            sArr[i2] = getShort(bArr2);
        }
        AppMethodBeat.o(87740);
        return sArr;
    }

    public byte[] Shorts2Bytes(short[] sArr) {
        AppMethodBeat.i(87741);
        byte[] bArr = new byte[(sArr.length * 2)];
        Shorts2Bytes(sArr, bArr);
        AppMethodBeat.o(87741);
        return bArr;
    }

    public void Shorts2Bytes(short[] sArr, byte[] bArr) {
        AppMethodBeat.i(87742);
        for (int i2 = 0; i2 < sArr.length; i2++) {
            System.arraycopy(getBytes(sArr[i2]), 0, bArr, i2 * 2, 2);
        }
        AppMethodBeat.o(87742);
    }

    public int[] Bytes2Ints(byte[] bArr) {
        AppMethodBeat.i(87743);
        int[] iArr = new int[(bArr.length / 4)];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            byte[] bArr2 = new byte[4];
            for (int i3 = 0; i3 < 4; i3++) {
                bArr2[i3] = bArr[(i2 * 4) + i3];
            }
            iArr[i2] = getInt(bArr2);
            System.out.println("2out->" + iArr[i2]);
        }
        AppMethodBeat.o(87743);
        return iArr;
    }

    public byte[] Ints2Bytes(int[] iArr) {
        AppMethodBeat.i(87744);
        byte[] bArr = new byte[(iArr.length * 4)];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            byte[] bytes = getBytes(iArr[i2]);
            System.out.println("1out->" + iArr[i2]);
            for (int i3 = 0; i3 < 4; i3++) {
                bArr[(i2 * 4) + i3] = bytes[i3];
            }
        }
        AppMethodBeat.o(87744);
        return bArr;
    }

    public long[] Bytes2Longs(byte[] bArr) {
        AppMethodBeat.i(87745);
        long[] jArr = new long[(bArr.length / 8)];
        for (int i2 = 0; i2 < jArr.length; i2++) {
            byte[] bArr2 = new byte[8];
            for (int i3 = 0; i3 < 8; i3++) {
                bArr2[i3] = bArr[(i2 * 8) + i3];
            }
            jArr[i2] = getLong(bArr2);
        }
        AppMethodBeat.o(87745);
        return jArr;
    }

    public byte[] Longs2Bytes(long[] jArr) {
        AppMethodBeat.i(87746);
        byte[] bArr = new byte[(jArr.length * 8)];
        for (int i2 = 0; i2 < jArr.length; i2++) {
            byte[] bytes = getBytes(jArr[i2]);
            for (int i3 = 0; i3 < 8; i3++) {
                bArr[(i2 * 8) + i3] = bytes[i3];
            }
        }
        AppMethodBeat.o(87746);
        return bArr;
    }
}
