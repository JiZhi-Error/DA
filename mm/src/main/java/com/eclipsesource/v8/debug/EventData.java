package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class EventData implements Releasable {
    protected V8Object v8Object;

    EventData(V8Object v8Object2) {
        AppMethodBeat.i(61472);
        this.v8Object = v8Object2.twin();
        AppMethodBeat.o(61472);
    }

    @Override // com.eclipsesource.v8.Releasable
    public void release() {
        AppMethodBeat.i(61473);
        if (!this.v8Object.isReleased()) {
            this.v8Object.release();
        }
        AppMethodBeat.o(61473);
    }
}
