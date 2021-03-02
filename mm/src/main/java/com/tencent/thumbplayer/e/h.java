package com.tencent.thumbplayer.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;

public final class h implements b {
    private ITPDownloadProxy RZp;

    public h(ITPDownloadProxy iTPDownloadProxy) {
        this.RZp = iTPDownloadProxy;
    }

    @Override // com.tencent.thumbplayer.e.b
    public final void pushEvent(int i2) {
        AppMethodBeat.i(189240);
        this.RZp.pushEvent(i2);
        AppMethodBeat.o(189240);
    }

    @Override // com.tencent.thumbplayer.e.b
    public final ITPDownloadProxy hnx() {
        return this.RZp;
    }
}
