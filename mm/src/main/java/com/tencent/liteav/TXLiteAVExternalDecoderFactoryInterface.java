package com.tencent.liteav;

public interface TXLiteAVExternalDecoderFactoryInterface {
    long CreateHevcDecoder();

    void DestroyHevcDecoder(long j2);
}
