package com.tencent.mm.live.core.core;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface c {
    void callback(int i2, Bundle bundle);

    public static final class a {
        public static /* synthetic */ void a(c cVar, int i2) {
            AppMethodBeat.i(196389);
            cVar.callback(i2, null);
            AppMethodBeat.o(196389);
        }
    }
}
