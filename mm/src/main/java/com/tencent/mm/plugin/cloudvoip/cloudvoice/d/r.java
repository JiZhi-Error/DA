package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

/* access modifiers changed from: package-private */
public final class r {
    String quX = null;
    long quY = -1;
    long quZ = -1;

    r() {
    }

    public final boolean isValid() {
        AppMethodBeat.i(90931);
        if (Util.isNullOrNil(this.quX) || Util.ticksToNow(this.quZ + 3600) / 1000 >= this.quY) {
            AppMethodBeat.o(90931);
            return false;
        }
        AppMethodBeat.o(90931);
        return true;
    }

    public final String toString() {
        AppMethodBeat.i(90932);
        String str = "OpenVoiceSessionKey{sessionKey='" + this.quX + '\'' + ", expireTicks=" + this.quY + ", initTicks=" + this.quZ + '}';
        AppMethodBeat.o(90932);
        return str;
    }
}
