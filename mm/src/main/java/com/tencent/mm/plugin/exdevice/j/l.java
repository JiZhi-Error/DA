package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.service.l;
import com.tencent.mm.plugin.exdevice.service.p;
import junit.framework.Assert;

public final class l extends l.a {
    private final long iMN = 15000;
    private c rEM = null;
    boolean rEN = false;
    boolean rEO = false;
    Runnable rEP = new Runnable() {
        /* class com.tencent.mm.plugin.exdevice.j.l.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(23813);
            l.this.rEN = true;
            if (l.this.rEO) {
                AppMethodBeat.o(23813);
                return;
            }
            l.this.rEM.a(-1, -1, -2, "TimeOut", null);
            AppMethodBeat.o(23813);
        }

        public final String toString() {
            AppMethodBeat.i(23814);
            String str = super.toString() + "|mAsyncTimeOut";
            AppMethodBeat.o(23814);
            return str;
        }
    };

    public l(c cVar) {
        AppMethodBeat.i(23817);
        Assert.assertNotNull(cVar);
        this.rEM = cVar;
        AppMethodBeat.o(23817);
    }

    @Override // com.tencent.mm.plugin.exdevice.service.l
    public final void a(final long j2, final int i2, final int i3, final String str, final p pVar) {
        AppMethodBeat.i(23818);
        if (this.rEO) {
            AppMethodBeat.o(23818);
        } else if (this.rEN) {
            AppMethodBeat.o(23818);
        } else {
            bg.aAk().getWorkerHandler().removeCallbacks(this.rEP);
            bg.aAk().getWorkerHandler().post(new Runnable() {
                /* class com.tencent.mm.plugin.exdevice.j.l.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(23815);
                    l.this.rEM.a(j2, i2, i3, str, pVar);
                    AppMethodBeat.o(23815);
                }

                public final String toString() {
                    AppMethodBeat.i(23816);
                    String str = super.toString() + "|onTaskEnd";
                    AppMethodBeat.o(23816);
                    return str;
                }
            });
            AppMethodBeat.o(23818);
        }
    }
}
