package com.tencent.thumbplayer.core.imagegenerator;

import com.tencent.thumbplayer.core.common.TPVideoFrame;

public interface ITPImageGeneratorCallback {
    void onImageGenerationCompleted(int i2, long j2, long j3, long j4, TPVideoFrame tPVideoFrame);
}
