package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public class StreamUtils {
    public static long skipForBufferStream(InputStream inputStream, long j2) {
        AppMethodBeat.i(114157);
        if (inputStream == null || j2 <= 0) {
            AppMethodBeat.o(114157);
            return 0;
        }
        long j3 = j2;
        long j4 = 0;
        do {
            j3 -= j4;
            j4 = inputStream.skip(j3);
            if (j4 <= 0) {
                break;
            }
        } while (j4 < j3);
        if (j4 > 0) {
            AppMethodBeat.o(114157);
            return j2;
        }
        long j5 = j2 - j3;
        AppMethodBeat.o(114157);
        return j5;
    }
}
