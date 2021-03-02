package com.tencent.thumbplayer.core.player;

import com.tencent.thumbplayer.core.common.TPAudioFrame;

public interface ITPNativePlayerAudioFrameCallback {
    public static final int FLAG_EOS = 1;

    void onAudioFrame(TPAudioFrame tPAudioFrame, int i2);
}
