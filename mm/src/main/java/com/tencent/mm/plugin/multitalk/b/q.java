package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

/* access modifiers changed from: package-private */
public final class q {
    String quX = null;
    long quY = -1;
    long quZ = -1;

    q() {
    }

    public final boolean isValid() {
        AppMethodBeat.i(239299);
        if (Util.isNullOrNil(this.quX) || Util.ticksToNow(this.quZ + 3600) / 1000 >= this.quY) {
            AppMethodBeat.o(239299);
            return false;
        }
        AppMethodBeat.o(239299);
        return true;
    }

    public final String toString() {
        AppMethodBeat.i(239300);
        String str = "ILinkSessionKey{sessionKey='" + this.quX + '\'' + ", expireTicks=" + this.quY + ", initTicks=" + this.quZ + '}';
        AppMethodBeat.o(239300);
        return str;
    }
}
