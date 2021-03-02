package com.tencent.soter.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.c.b;
import com.tencent.soter.a.e.b;
import com.tencent.soter.a.f.e;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.i;

public final class k extends c {
    e RRP = null;
    private boolean RRQ = false;

    public k(e eVar, boolean z) {
        this.RRP = eVar;
        this.RRQ = z;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.soter.a.g.d
    public final boolean hlM() {
        AppMethodBeat.i(116);
        if (!b.hlG().isInit()) {
            d.w("Soter.TaskPrepareAppSecureKey", "soter: not initialized yet", new Object[0]);
            c(new c(1008));
            AppMethodBeat.o(116);
            return true;
        } else if (!b.hlG().hlC()) {
            d.w("Soter.TaskPrepareAppSecureKey", "soter: not support soter", new Object[0]);
            c(new c(2));
            AppMethodBeat.o(116);
            return true;
        } else if (!a.hln() || this.RRQ) {
            if (this.RRP == null) {
                d.w("Soter.TaskPrepareAppSecureKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload ASK validation from server! Please make sure you upload it later", new Object[0]);
            }
            AppMethodBeat.o(116);
            return false;
        } else {
            d.i("Soter.TaskPrepareAppSecureKey", "soter: already has ask. do not need generate again", new Object[0]);
            c(new c(a.hlo()));
            AppMethodBeat.o(116);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.soter.a.g.d
    public final void hlN() {
        AppMethodBeat.i(117);
        d.w("Soter.TaskPrepareAppSecureKey", "soter: cancelled prepare ask", new Object[0]);
        a.hll();
        AppMethodBeat.o(117);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.soter.a.g.d
    public final void execute() {
        AppMethodBeat.i(118);
        hx(com.tencent.soter.core.c.e.hls().RPL, 1);
        b.a aVar = new b.a();
        boolean z = this.RRQ;
        aVar.RQB |= 1;
        aVar.RQD = z;
        aVar.RQF = new com.tencent.soter.a.e.a() {
            /* class com.tencent.soter.a.g.k.AnonymousClass1 */

            @Override // com.tencent.soter.a.e.a
            public final void onError(int i2, String str) {
                AppMethodBeat.i(113);
                d.w("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate failed. errcode: %d, errmsg: %s", Integer.valueOf(i2), str);
                k.hx(com.tencent.soter.core.c.e.hls().RPL, 0);
                k.this.c(new c(i2, str));
                AppMethodBeat.o(113);
            }

            @Override // com.tencent.soter.a.e.a
            public final void onSuccess() {
                AppMethodBeat.i(114);
                d.i("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate successfully. start upload ask", new Object[0]);
                if (k.this.RRP != null) {
                    k.hx(com.tencent.soter.core.c.e.hls().RPL, 2);
                } else {
                    k.hx(com.tencent.soter.core.c.e.hls().RPL, 0);
                }
                k kVar = k.this;
                i hlo = a.hlo();
                if (hlo == null) {
                    d.e("Soter.TaskPrepareAppSecureKey", "soter: ask model is null even after generation. fatal error", new Object[0]);
                    a.hll();
                    kVar.c(new c(3, "ask model is null even after generation."));
                    AppMethodBeat.o(114);
                } else if (kVar.RRP != null) {
                    kVar.RRP.setRequest(new e.a(hlo.signature, hlo.RPQ));
                    kVar.RRP.a(new com.tencent.soter.a.f.b<e.b>(hlo) {
                        /* class com.tencent.soter.a.g.k.AnonymousClass2 */
                        final /* synthetic */ i RRS;

                        {
                            this.RRS = r2;
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.soter.a.f.b
                        public final /* synthetic */ void eB(e.b bVar) {
                            AppMethodBeat.i(115);
                            k.hx(com.tencent.soter.core.c.e.hls().RPL, 0);
                            boolean z = bVar.RQL;
                            d.i("Soter.TaskPrepareAppSecureKey", "soter: ask upload result: %b", Boolean.valueOf(z));
                            if (z) {
                                k.this.c(new c(this.RRS));
                                AppMethodBeat.o(115);
                                return;
                            }
                            a.hll();
                            k.this.c(new c(1003, "upload app secure key failed"));
                            AppMethodBeat.o(115);
                        }
                    });
                    kVar.RRP.execute();
                    AppMethodBeat.o(114);
                } else {
                    d.d("Soter.TaskPrepareAppSecureKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
                    kVar.c(new c("treat as normal because you do not provide the net wrapper", hlo));
                    AppMethodBeat.o(114);
                }
            }
        };
        aVar.hlK().hi();
        AppMethodBeat.o(118);
    }
}
