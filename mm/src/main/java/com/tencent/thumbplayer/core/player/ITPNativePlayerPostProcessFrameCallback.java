package com.tencent.thumbplayer.core.player;

import com.tencent.thumbplayer.core.common.TPPostProcessFrame;

public interface ITPNativePlayerPostProcessFrameCallback {
    public static final int EVENT_EOS = 1;
    public static final int EVENT_FLUSH = 2;

    TPPostProcessFrame onPostProcessFrame(TPPostProcessFrame tPPostProcessFrame, int i2);
}
