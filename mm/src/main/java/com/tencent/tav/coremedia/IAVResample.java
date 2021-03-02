package com.tencent.tav.coremedia;

import java.nio.ByteBuffer;

public interface IAVResample {
    byte[] resample(ByteBuffer byteBuffer, int i2);

    void updateSrcFormat(int i2, int i3);
}
