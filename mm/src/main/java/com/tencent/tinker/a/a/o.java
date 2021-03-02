package com.tencent.tinker.a.a;

import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.tinker.a.a.b.a;
import com.tencent.tinker.a.a.b.b;

public final class o {
    public static int a(a aVar) {
        int readByte;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            readByte = aVar.readByte() & 255;
            i2 = ((readByte & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH) << (i4 * 7)) | i2;
            i3 <<= 7;
            i4++;
            if ((readByte & 128) != 128 || i4 >= 5) {
            }
        }
        if ((readByte & 128) == 128) {
            throw new j("invalid LEB128 sequence");
        } else if (((i3 >> 1) & i2) != 0) {
            return i2 | i3;
        } else {
            return i2;
        }
    }

    public static int b(a aVar) {
        int readByte;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            readByte = aVar.readByte() & 255;
            i2 = ((readByte & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH) << (i3 * 7)) | i2;
            i3++;
            if ((readByte & 128) != 128 || i3 >= 5) {
            }
        }
        if ((readByte & 128) != 128) {
            return i2;
        }
        throw new j("invalid LEB128 sequence");
    }

    public static int c(a aVar) {
        return b(aVar) - 1;
    }

    public static int a(b bVar, int i2) {
        int i3 = 0;
        for (int i4 = i2 >>> 7; i4 != 0; i4 >>>= 7) {
            bVar.writeByte((byte) ((i2 & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH) | 128));
            i3++;
            i2 = i4;
        }
        bVar.writeByte((byte) (i2 & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH));
        return i3 + 1;
    }

    public static int b(b bVar, int i2) {
        return a(bVar, i2 + 1);
    }

    public static int c(b bVar, int i2) {
        int i3;
        int i4 = i2 >> 7;
        int i5 = (Integer.MIN_VALUE & i2) == 0 ? 0 : -1;
        int i6 = 0;
        boolean z = true;
        int i7 = i4;
        while (z) {
            if (i7 == i5 && (i7 & 1) == ((i2 >> 6) & 1)) {
                z = false;
            } else {
                z = true;
            }
            int i8 = i2 & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
            if (z) {
                i3 = 128;
            } else {
                i3 = 0;
            }
            bVar.writeByte((byte) (i3 | i8));
            i6++;
            i2 = i7;
            i7 >>= 7;
        }
        return i6;
    }
}
