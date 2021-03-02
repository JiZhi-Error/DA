package com.tencent.mm.plugin.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.l;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public final class b extends a implements Runnable {
    private int errorCode = -2;
    private j wTn;
    private WeakReference<l> wTo;

    public b(j jVar) {
        AppMethodBeat.i(187307);
        this.wTn = jVar;
        this.wTo = new WeakReference<>(jVar.wWZ);
        this.wTn.wWZ = null;
        AppMethodBeat.o(187307);
    }

    @Override // com.tencent.mm.plugin.fts.a.a.a
    public final boolean execute() {
        AppMethodBeat.i(52501);
        if (this.errorCode == -2 || this.errorCode == -3) {
            final k kVar = new k(this.wTn);
            kVar.wXa = this;
            kVar.resultCode = this.errorCode;
            kVar.wXb = new LinkedList();
            kVar.wWd = h.bE(this.wTn.query, false);
            if (this.wTn.handler == null) {
                l lVar = this.wTo.get();
                if (lVar != null) {
                    lVar.b(kVar);
                }
            } else {
                this.wTn.handler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.fts.b.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(52499);
                        l lVar = (l) b.this.wTo.get();
                        if (lVar != null) {
                            lVar.b(kVar);
                        }
                        AppMethodBeat.o(52499);
                    }
                });
            }
        }
        AppMethodBeat.o(52501);
        return true;
    }

    public final void run() {
        AppMethodBeat.i(52502);
        try {
            execute();
            AppMethodBeat.o(52502);
        } catch (Exception e2) {
            AppMethodBeat.o(52502);
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.a.a
    public final int getPriority() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.fts.a.a.a
    public final boolean isCancelled() {
        return false;
    }

    @Override // com.tencent.mm.plugin.fts.a.a.a
    public final int getId() {
        return -1;
    }
}
