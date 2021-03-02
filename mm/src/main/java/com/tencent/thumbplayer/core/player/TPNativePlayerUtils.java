package com.tencent.thumbplayer.core.player;

import android.view.Surface;
import com.tencent.thumbplayer.core.common.TPMethodCalledByNative;

public class TPNativePlayerUtils {
    @TPMethodCalledByNative
    static boolean isTPNativePlayerSurface(Surface surface) {
        return surface instanceof TPNativePlayerSurface;
    }
}
