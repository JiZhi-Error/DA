package com.tencent.tav.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;
import java.nio.ByteBuffer;

public class ADTSUtils {
    public static int getFreqIndex(int i2) {
        switch (i2) {
            case 7350:
                return 12;
            case TXRecordCommon.AUDIO_SAMPLERATE_8000 /*{ENCODED_INT: 8000}*/:
                return 11;
            case 11025:
                return 10;
            case 12000:
                return 9;
            case 16000:
            default:
                return 8;
            case 22050:
                return 7;
            case 24000:
                return 6;
            case 32000:
                return 5;
            case 44100:
                return 4;
            case 48000:
                return 3;
            case 64000:
                return 2;
            case 88200:
                return 1;
            case 96000:
                return 0;
        }
    }

    public static ByteBuffer getADTSCodecSpecificData(int i2, int i3, int i4) {
        AppMethodBeat.i(218050);
        int freqIndex = getFreqIndex(i3);
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.put(0, (byte) ((i2 << 3) | (freqIndex >> 1)));
        allocate.put(1, (byte) (((freqIndex << 7) & 128) | (i4 << 3)));
        allocate.flip();
        AppMethodBeat.o(218050);
        return allocate;
    }
}
