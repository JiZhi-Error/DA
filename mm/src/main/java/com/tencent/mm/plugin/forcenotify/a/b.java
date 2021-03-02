package com.tencent.mm.plugin.forcenotify.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.storage.MAutoStorage;

public interface b extends a, q, y<de> {
    void aS(String str, int i2);

    void axA(String str);

    long axB(String str);

    boolean axC(String str);

    boolean byf(String str);

    MAutoStorage dMm();

    void ps(boolean z);
}
