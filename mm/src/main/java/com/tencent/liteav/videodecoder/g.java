package com.tencent.liteav.videodecoder;

import com.tencent.liteav.basic.structs.TXSVideoFrame;

public interface g {
    void onDecodeFailed(int i2);

    void onDecodeFrame(TXSVideoFrame tXSVideoFrame, int i2, int i3, long j2, long j3, int i4);

    void onDecoderChange(String str, boolean z);

    void onVideoSizeChange(int i2, int i3);
}
