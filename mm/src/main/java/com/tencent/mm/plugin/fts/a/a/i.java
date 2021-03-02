package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;

public abstract class i extends a {
    private WeakReference<l> wTo;
    public j wWO;
    public k wWP;

    public i(j jVar) {
        this.wWO = jVar;
        this.wTo = new WeakReference<>(jVar.wWZ);
        this.wWO.wWZ = null;
    }

    @Override // com.tencent.mm.plugin.fts.a.a.a
    public final boolean execute() {
        j jVar = this.wWO;
        if (!Util.isNullOrNil(jVar.query)) {
            try {
                jVar.query = new String(jVar.query.getBytes("UTF8"), "UTF8");
            } catch (UnsupportedEncodingException e2) {
            }
        }
        this.wWP = new k(this.wWO);
        try {
            this.wWP.wXa = this;
            a(this.wWP);
            this.wWP.resultCode = 0;
            if (this.wWO.handler == null) {
                l lVar = this.wTo.get();
                if (lVar != null) {
                    lVar.b(this.wWP);
                }
            } else {
                this.wWO.handler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.fts.a.a.i.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(131702);
                        l lVar = (l) i.this.wTo.get();
                        if (lVar != null) {
                            lVar.b(i.this.wWP);
                        }
                        AppMethodBeat.o(131702);
                    }
                });
            }
            return true;
        } catch (Exception e3) {
            if (e3 instanceof InterruptedException) {
                this.wWP.resultCode = 1;
            } else {
                this.wWP.resultCode = -1;
            }
            throw e3;
        } catch (Throwable th) {
            if (this.wWO.handler == null) {
                l lVar2 = this.wTo.get();
                if (lVar2 != null) {
                    lVar2.b(this.wWP);
                }
            } else {
                this.wWO.handler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.fts.a.a.i.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(131702);
                        l lVar = (l) i.this.wTo.get();
                        if (lVar != null) {
                            lVar.b(i.this.wWP);
                        }
                        AppMethodBeat.o(131702);
                    }
                });
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void a(k kVar) {
        kVar.wWd = h.bE(this.wWO.query, false);
        kVar.resultCode = -5;
    }
}
