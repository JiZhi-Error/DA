package com.tencent.tav.decoder.decodecache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

/* access modifiers changed from: package-private */
public class RequestStatus {
    private volatile AtomicBoolean finish = new AtomicBoolean(false);

    RequestStatus() {
        AppMethodBeat.i(218435);
        AppMethodBeat.o(218435);
    }

    public void setFinish(boolean z) {
        AppMethodBeat.i(218436);
        this.finish.set(z);
        AppMethodBeat.o(218436);
    }

    public boolean getFinish() {
        AppMethodBeat.i(218437);
        boolean z = this.finish.get();
        AppMethodBeat.o(218437);
        return z;
    }
}
