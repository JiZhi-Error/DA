package com.tencent.liteav.network;

import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.a;

public interface f {
    void onPullAudio(a aVar);

    void onPullNAL(TXSNALPacket tXSNALPacket);
}
