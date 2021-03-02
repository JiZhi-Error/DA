package com.tencent.mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class c {
    private MMHandler wOE;

    public final MMHandler dMZ() {
        AppMethodBeat.i(24773);
        if (this.wOE == null) {
            this.wOE = new MMHandler("FreeWifiHandlerThread_handlerThread");
        }
        MMHandler mMHandler = this.wOE;
        AppMethodBeat.o(24773);
        return mMHandler;
    }

    public final void release() {
        AppMethodBeat.i(24774);
        if (this.wOE != null) {
            this.wOE.quit();
        }
        this.wOE = null;
        AppMethodBeat.o(24774);
    }
}
