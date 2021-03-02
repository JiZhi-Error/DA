package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a {
    public boolean isStart = false;

    public void start() {
        AppMethodBeat.i(25496);
        reset();
        this.isStart = true;
        AppMethodBeat.o(25496);
    }

    public void reset() {
    }

    /* access modifiers changed from: protected */
    public void bUV() {
    }

    public final void finish() {
        AppMethodBeat.i(25497);
        if (this.isStart) {
            bUV();
            this.isStart = false;
        }
        AppMethodBeat.o(25497);
    }
}
