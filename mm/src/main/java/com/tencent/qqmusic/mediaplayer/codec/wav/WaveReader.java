package com.tencent.qqmusic.mediaplayer.codec.wav;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WaveReader {
    private static final String TAG = "WaveReader";
    private static final int WAV_FORMAT = 1463899717;
    private static final int WAV_FORMAT_CHUNK_ID = 1718449184;
    private static final int WAV_HEADER_CHUNK_ID = 1380533830;
    private static final int WAV_HEADER_SIZE = 50;

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00da A[SYNTHETIC, Splitter:B:41:0x00da] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ee A[SYNTHETIC, Splitter:B:49:0x00ee] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isWavFormat(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 257
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqmusic.mediaplayer.codec.wav.WaveReader.isWavFormat(java.lang.String):boolean");
    }

    private static int readUnsignedInt(byte[] bArr, int i2) {
        if (i2 + 4 > bArr.length) {
            return -1;
        }
        return ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8) | (bArr[i2 + 3] & 255);
    }

    private static int readUnsignedIntLE(byte[] bArr, int i2) {
        if (i2 + 4 > bArr.length) {
            return -1;
        }
        return (bArr[0] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24);
    }

    private static short readUnsignedShortLE(byte[] bArr, int i2) {
        AppMethodBeat.i(114316);
        if (i2 + 2 > bArr.length) {
            AppMethodBeat.o(114316);
            return -1;
        }
        short byteToShortLE = byteToShortLE(bArr[i2], bArr[i2 + 1]);
        AppMethodBeat.o(114316);
        return byteToShortLE;
    }

    private static short byteToShortLE(byte b2, byte b3) {
        return (short) ((b2 & 255) | ((b3 & 255) << 8));
    }
}
