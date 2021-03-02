package com.tencent.qqmusic.mediaplayer.seektable.flac;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class BytesUtil {
    public static int from(byte[] bArr) {
        AppMethodBeat.i(114273);
        if (bArr.length > 4) {
            RuntimeException runtimeException = new RuntimeException("bytes can't be greater than 32 bit!");
            AppMethodBeat.o(114273);
            throw runtimeException;
        } else if (bArr.length == 3) {
            int i2 = ((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[2] & 255);
            AppMethodBeat.o(114273);
            return i2;
        } else if (bArr.length == 2) {
            int i3 = ((bArr[0] & 255) << 8) | (bArr[1] & 15);
            AppMethodBeat.o(114273);
            return i3;
        } else if (bArr.length == 1) {
            int i4 = bArr[0] & 255;
            AppMethodBeat.o(114273);
            return i4;
        } else {
            RuntimeException runtimeException2 = new RuntimeException("bytes must be greater than 8 bit!");
            AppMethodBeat.o(114273);
            throw runtimeException2;
        }
    }
}
