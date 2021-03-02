package com.tencent.mm.plugin.freewifi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.Log;

public final class d {
    private String dFd;
    private String dHx;
    private int wPw;

    /* synthetic */ d(byte b2) {
        this();
    }

    private d() {
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static d wPx = new d((byte) 0);

        static {
            AppMethodBeat.i(24874);
            AppMethodBeat.o(24874);
        }
    }

    public final synchronized boolean B(int i2, String str, String str2) {
        boolean z;
        boolean z2 = true;
        synchronized (this) {
            AppMethodBeat.i(24875);
            Log.i("MicroMsg.FreeWifi.Protocol31Locker", "threeOneStartUpType=%d, apKey=%s, ticket=%s", Integer.valueOf(i2), str, str2);
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                AppMethodBeat.o(24875);
            } else if (m.eP(str) || m.eP(str2)) {
                AppMethodBeat.o(24875);
                z2 = false;
            } else if (!str.equals(this.dFd) || !str2.equals(this.dHx) || this.wPw == i2) {
                this.wPw = i2;
                this.dFd = str;
                this.dHx = str2;
                AppMethodBeat.o(24875);
            } else {
                AppMethodBeat.o(24875);
                z2 = false;
            }
        }
        return z2;
    }
}
