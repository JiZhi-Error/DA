package com.tencent.mm.plugin.appbrand.jsapi.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad.c;

public final class e extends b {
    private a mFU = a.IDLE;

    /* access modifiers changed from: package-private */
    public enum a {
        IDLE,
        START,
        PAUSE,
        STOP,
        ERROR;

        public static a valueOf(String str) {
            AppMethodBeat.i(137906);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(137906);
            return aVar;
        }

        static {
            AppMethodBeat.i(137907);
            AppMethodBeat.o(137907);
        }
    }

    private synchronized void a(a aVar) {
        this.mFU = aVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ad.a.b
    public final synchronized void release() {
        AppMethodBeat.i(137909);
        super.release();
        a(a.IDLE);
        AppMethodBeat.o(137909);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ad.a.a
    public final void S(String str, int i2, int i3) {
        AppMethodBeat.i(137910);
        super.S(str, i2, i3);
        a(a.STOP);
        AppMethodBeat.o(137910);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ad.a.b
    public final synchronized c bLl() {
        c bLl;
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(137908);
            switch (this.mFU) {
                case START:
                case PAUSE:
                    z = true;
                    break;
            }
            if (!z) {
                bLl = new c("can not stop", new Object[0]);
                AppMethodBeat.o(137908);
            } else {
                bLl = super.bLl();
                AppMethodBeat.o(137908);
            }
        }
        return bLl;
    }
}
