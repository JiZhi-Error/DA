package com.tencent.qqmusic.mediaplayer.seektable.mp3;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class Mp3DecodeBase {
    Mp3DecodeBase() {
    }

    static boolean hasId3v2(byte[] bArr, int i2) {
        if (bArr == null || i2 < 3) {
            return false;
        }
        return bArr[0] == 73 && bArr[1] == 68 && bArr[2] == 51;
    }

    static boolean isXingVBRheader(byte[] bArr, int i2) {
        if (bArr == null || i2 < 4) {
            return false;
        }
        if (bArr[0] == 88 && bArr[1] == 105 && bArr[2] == 110 && bArr[3] == 103) {
            return true;
        }
        return (bArr[0] == 73 && bArr[1] == 110 && bArr[2] == 102 && bArr[3] == 111) ? false : false;
    }

    static boolean isVBRIVBRHeader(byte[] bArr, int i2) {
        if (bArr == null || i2 < 4) {
            return false;
        }
        return bArr[0] == 86 && bArr[1] == 66 && bArr[2] == 82 && bArr[3] == 73;
    }

    static int readInt(byte[] bArr, int i2, int i3) {
        if (bArr == null || i3 < 4 || bArr.length < i2 + i3) {
            return -1;
        }
        return ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8) | (bArr[i2 + 3] & 255);
    }

    static int readInt(byte[] bArr, int i2) {
        AppMethodBeat.i(114241);
        int readInt = readInt(bArr, 0, i2);
        AppMethodBeat.o(114241);
        return readInt;
    }

    static long readLong(byte[] bArr, int i2, int i3) {
        if (bArr == null || i3 < 4 || bArr.length < i2 + i3) {
            return -1;
        }
        return (long) (((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8) | (bArr[i2 + 3] & 255));
    }

    static long readLong(byte[] bArr, int i2) {
        AppMethodBeat.i(114242);
        long readLong = readLong(bArr, 0, i2);
        AppMethodBeat.o(114242);
        return readLong;
    }

    static int readUnsignedInt24(byte[] bArr, int i2, int i3) {
        if (bArr == null || i3 < 3 || bArr.length < i2 + i3) {
            return -1;
        }
        return ((bArr[i2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8) | (bArr[i2 + 2] & 255);
    }

    static int readUnsignedInt24(byte[] bArr, int i2) {
        AppMethodBeat.i(114243);
        int readUnsignedInt24 = readUnsignedInt24(bArr, 0, i2);
        AppMethodBeat.o(114243);
        return readUnsignedInt24;
    }

    static int readShort(byte[] bArr, int i2, int i3) {
        if (bArr == null || i3 < 2 || bArr.length < i2 + i3) {
            return -1;
        }
        return ((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255);
    }

    static int readShort(byte[] bArr, int i2) {
        AppMethodBeat.i(114244);
        int readShort = readShort(bArr, 0, i2);
        AppMethodBeat.o(114244);
        return readShort;
    }

    static int readByte(byte[] bArr, int i2) {
        AppMethodBeat.i(114245);
        int readByte = readByte(bArr, 0, i2);
        AppMethodBeat.o(114245);
        return readByte;
    }

    static int readByte(byte[] bArr, int i2, int i3) {
        if (bArr == null || i3 <= 0 || bArr.length < i2 + i3) {
            return -1;
        }
        return bArr[i2] & 255;
    }
}
