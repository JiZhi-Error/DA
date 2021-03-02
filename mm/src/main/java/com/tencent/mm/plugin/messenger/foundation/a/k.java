package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.c.a;

public interface k extends a {
    void addSyncDoCmdCallback(z zVar);

    h.b processAddMsg(h.a aVar, aa aaVar);

    void removeSyncDoCmdCallback(z zVar);
}
