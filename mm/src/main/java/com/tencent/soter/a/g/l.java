package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.c.b;
import com.tencent.soter.a.e.b;
import com.tencent.soter.a.f.e;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;
import com.tencent.soter.core.c.i;
import com.tencent.thumbplayer.api.TPOptionalID;

public final class l extends c {
    e FhP = null;
    private e FhQ = null;
    String RQC = null;
    private boolean RRQ = false;
    private boolean RRT = false;
    private int mScene = -1;

    static /* synthetic */ void a(l lVar) {
        AppMethodBeat.i(TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
        lVar.hlW();
        AppMethodBeat.o(TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
    }

    public l(int i2, e eVar, e eVar2, boolean z) {
        this.mScene = i2;
        this.FhP = eVar;
        this.RRQ = z;
        this.RRT = true;
        this.FhQ = eVar2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.soter.a.g.d
    @SuppressLint({"DefaultLocale"})
    public final boolean hlM() {
        AppMethodBeat.i(123);
        if (!b.hlG().isInit()) {
            d.w("Soter.TaskPrepareAuthKey", "soter: not initialized yet", new Object[0]);
            c(new c(1008));
            AppMethodBeat.o(123);
            return true;
        } else if (!b.hlG().hlC()) {
            d.w("Soter.TaskPrepareAuthKey", "soter: not support soter", new Object[0]);
            c(new c(2));
            AppMethodBeat.o(123);
            return true;
        } else {
            this.RQC = b.hlG().hlI().get(this.mScene, "");
            if (g.isNullOrNil(this.RQC)) {
                d.w("Soter.TaskPrepareAuthKey", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
                c(new c(1009, String.format("auth scene %d not initialized in map", Integer.valueOf(this.mScene))));
                AppMethodBeat.o(123);
                return true;
            }
            boolean hln = a.hln();
            if (!hln && a.bqh(this.RQC)) {
                d.w("Soter.TaskPrepareAuthKey", "soter: no ask but has auth key. delete the auth key as well", new Object[0]);
                a.dE(this.RQC, false);
            }
            if (!hln && !this.RRT) {
                d.w("Soter.TaskPrepareAuthKey", "soter: has not generate app secure key yet and not require to generate it", new Object[0]);
                c(new c(3));
                AppMethodBeat.o(123);
                return true;
            } else if (a.bqh(this.RQC) && !a.bqi(this.RQC)) {
                d.w("Soter.TaskPrepareAuthKey", "soter: already has auth key but not valid. delete it already and re-generate", new Object[0]);
                AppMethodBeat.o(123);
                return false;
            } else if (!a.bqh(this.RQC) || this.RRQ) {
                if (this.FhP == null) {
                    d.w("Soter.TaskPrepareAuthKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload AuthKey validation from server! Please make sure you upload it later", new Object[0]);
                }
                AppMethodBeat.o(123);
                return false;
            } else {
                d.i("Soter.TaskPrepareAuthKey", "soter: already has key. do not need generate again", new Object[0]);
                c(new c(a.bqj(this.RQC)));
                AppMethodBeat.o(123);
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.soter.a.g.d
    public final void hlN() {
        AppMethodBeat.i(124);
        d.w("Soter.TaskPrepareAuthKey", "soter: cancelled prepare authkey: %s", this.RQC);
        a.dE(this.RQC, false);
        AppMethodBeat.o(124);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.soter.a.g.d
    public final void execute() {
        AppMethodBeat.i(125);
        if (a.hln() || !this.RRT) {
            hlW();
            AppMethodBeat.o(125);
            return;
        }
        d.d("Soter.TaskPrepareAuthKey", "soter: ask not found, but required to generate it. start generate", new Object[0]);
        com.tencent.soter.a.a.a(new com.tencent.soter.a.b.b<c>() {
            /* class com.tencent.soter.a.g.l.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.soter.a.b.e] */
            @Override // com.tencent.soter.a.b.b
            public final /* synthetic */ void a(c cVar) {
                AppMethodBeat.i(119);
                c cVar2 = cVar;
                d.d("Soter.TaskPrepareAuthKey", "soter: prepare ask end: %s", cVar2.toString());
                if (cVar2.errCode == 0) {
                    l.a(l.this);
                    AppMethodBeat.o(119);
                    return;
                }
                l.this.c(cVar2);
                AppMethodBeat.o(119);
            }
        }, false, this.FhQ);
        AppMethodBeat.o(125);
    }

    private void hlW() {
        AppMethodBeat.i(126);
        hx(this.RQC, 1);
        b.a dF = new b.a().dF(this.RQC, this.RRQ);
        dF.RQF = new com.tencent.soter.a.e.a() {
            /* class com.tencent.soter.a.g.l.AnonymousClass2 */

            @Override // com.tencent.soter.a.e.a
            public final void onError(int i2, String str) {
                AppMethodBeat.i(120);
                d.w("Soter.TaskPrepareAuthKey", "soter: auth key %s generate failed. errcode: %d, errmsg: %s", l.this.RQC, Integer.valueOf(i2), str);
                l.hx(l.this.RQC, 0);
                l.this.c(new c(i2, str));
                AppMethodBeat.o(120);
            }

            @Override // com.tencent.soter.a.e.a
            public final void onSuccess() {
                AppMethodBeat.i(121);
                d.i("Soter.TaskPrepareAuthKey", "soter: auth key generate successfully. start upload", new Object[0]);
                if (l.this.FhP != null) {
                    l.hx(l.this.RQC, 2);
                } else {
                    l.hx(l.this.RQC, 0);
                }
                l lVar = l.this;
                i bqj = a.bqj(lVar.RQC);
                if (bqj == null) {
                    d.e("Soter.TaskPrepareAuthKey", "soter: auth key model is null even after generation. fatal error", new Object[0]);
                    a.dE(lVar.RQC, false);
                    lVar.c(new c(1006, "auth key model is null even after generation."));
                    AppMethodBeat.o(121);
                } else if (lVar.FhP != null) {
                    lVar.FhP.setRequest(new e.a(bqj.signature, bqj.RPQ));
                    lVar.FhP.a(new com.tencent.soter.a.f.b<e.b>(bqj) {
                        /* class com.tencent.soter.a.g.l.AnonymousClass3 */
                        final /* synthetic */ i RRV;

                        {
                            this.RRV = r2;
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.soter.a.f.b
                        public final /* synthetic */ void eB(e.b bVar) {
                            AppMethodBeat.i(122);
                            l.hx(l.this.RQC, 0);
                            boolean z = bVar.RQL;
                            d.i("Soter.TaskPrepareAuthKey", "soter: auth key upload result: %b", Boolean.valueOf(z));
                            if (z) {
                                l.this.c(new c(this.RRV));
                                AppMethodBeat.o(122);
                                return;
                            }
                            a.dE(l.this.RQC, false);
                            l.this.c(new c(1004, String.format("upload auth key: %s failed", l.this.RQC)));
                            AppMethodBeat.o(122);
                        }
                    });
                    lVar.FhP.execute();
                    AppMethodBeat.o(121);
                } else {
                    d.d("Soter.TaskPrepareAuthKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
                    lVar.c(new c("treat as normal because you do not provide the net wrapper", bqj));
                    AppMethodBeat.o(121);
                }
            }
        };
        dF.hlK().hi();
        AppMethodBeat.o(126);
    }
}
