package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.ugc.TXRecordCommon;
import java.nio.ByteBuffer;

public final class a {
    public static void a(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(241180);
        Log.d("MicroMsg.ADTSUtils", "addADTStoPacket params: %d, %d, %d, %d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
        int QL = QL(i5);
        byteBuffer.put(i2, (byte) -1);
        byteBuffer.put(i2 + 1, (byte) -7);
        byteBuffer.put(i2 + 2, (byte) ((QL << 2) + ((i4 - 1) << 6) + (i6 >> 2)));
        byteBuffer.put(i2 + 3, (byte) (((i6 & 3) << 6) + (i3 >> 11)));
        byteBuffer.put(i2 + 4, (byte) ((i3 & 2047) >> 3));
        byteBuffer.put(i2 + 5, (byte) (((i3 & 7) << 5) + 31));
        byteBuffer.put(i2 + 6, (byte) -4);
        AppMethodBeat.o(241180);
    }

    public static int QL(int i2) {
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
}
