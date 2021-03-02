package com.tencent.qqmusic.mediaplayer.seektable.flac;

import com.tencent.thumbplayer.api.TPOptionalID;

public class Id3Util {
    public static int synchsafe(int i2) {
        for (int i3 = TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH; (Integer.MAX_VALUE ^ i3) > 0; i3 = ((i3 + 1) << 8) - 1) {
            i2 = (((i3 ^ -1) & i2) << 1) | (i2 & i3);
        }
        return i2;
    }

    public static int unsynchsafe(int i2) {
        int i3 = 0;
        for (int i4 = 2130706432; i4 > 0; i4 >>= 8) {
            i3 = (i3 >> 1) | (i2 & i4);
        }
        return i3;
    }
}
