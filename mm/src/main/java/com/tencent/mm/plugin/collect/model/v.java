package com.tencent.mm.plugin.collect.model;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.reward.a.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.h;

public final class v extends IListener<tk> {
    private Dialog jUV;

    public v() {
        AppMethodBeat.i(160790);
        this.__eventId = tk.class.getName().hashCode();
        AppMethodBeat.o(160790);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(tk tkVar) {
        AppMethodBeat.i(63857);
        boolean a2 = a(tkVar);
        AppMethodBeat.o(63857);
        return a2;
    }

    private boolean a(final tk tkVar) {
        AppMethodBeat.i(63856);
        Log.i("MicroMsg.ScanMaterialCodeListener", "scan material code type: %s", Integer.valueOf(tkVar.dZQ.type));
        if (tkVar.dZQ.aWF == null || tkVar.dZQ.aWF.get() == null) {
            Log.i("MicroMsg.ScanMaterialCodeListener", "context has destroyed");
            tkVar.dZQ.callback.run();
            AppMethodBeat.o(63856);
        } else {
            final Context context = (Context) tkVar.dZQ.aWF.get();
            if (tkVar.dZQ.type == 0) {
                this.jUV = h.a(context, false, (DialogInterface.OnCancelListener) null);
                k kVar = new k(tkVar.dZQ.dZS, tkVar.dZQ.scene);
                g.azz().a(1800, new i() {
                    /* class com.tencent.mm.plugin.collect.model.v.AnonymousClass1 */

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                        AppMethodBeat.i(63852);
                        if (v.this.jUV != null && v.this.jUV.isShowing()) {
                            v.this.jUV.dismiss();
                            v.this.jUV = null;
                        }
                        g.azz().b(1800, this);
                        final k kVar = (k) qVar;
                        kVar.a(new r.a<k>() {
                            /* class com.tencent.mm.plugin.collect.model.v.AnonymousClass1.AnonymousClass3 */

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.ak.q] */
                            @Override // com.tencent.mm.wallet_core.c.r.a
                            public final /* bridge */ /* synthetic */ void d(int i2, int i3, String str, k kVar) {
                                k kVar2 = kVar;
                                tkVar.dZR.actionType = kVar2.qwj.pTI;
                                tkVar.dZR.dZT = kVar2.qwj.MTC;
                            }
                        }).b(new r.a() {
                            /* class com.tencent.mm.plugin.collect.model.v.AnonymousClass1.AnonymousClass2 */

                            @Override // com.tencent.mm.wallet_core.c.r.a
                            public final void d(int i2, int i3, String str, q qVar) {
                                AppMethodBeat.i(63851);
                                tkVar.dZR.errMsg = kVar.qwj.qwn;
                                if (Util.isNullOrNil(tkVar.dZR.errMsg)) {
                                    tkVar.dZR.errMsg = context.getString(R.string.itf);
                                }
                                AppMethodBeat.o(63851);
                            }
                        }).c(new r.a() {
                            /* class com.tencent.mm.plugin.collect.model.v.AnonymousClass1.AnonymousClass1 */

                            @Override // com.tencent.mm.wallet_core.c.r.a
                            public final void d(int i2, int i3, String str, q qVar) {
                                AppMethodBeat.i(63850);
                                tkVar.dZR.errMsg = str;
                                if (Util.isNullOrNil(tkVar.dZR.errMsg)) {
                                    tkVar.dZR.errMsg = context.getString(R.string.itf);
                                }
                                AppMethodBeat.o(63850);
                            }
                        });
                        tkVar.dZQ.callback.run();
                        AppMethodBeat.o(63852);
                    }
                });
                g.azz().a(kVar, 0);
            } else if (tkVar.dZQ.type == 1) {
                this.jUV = h.a(context, false, (DialogInterface.OnCancelListener) null);
                c cVar = new c(tkVar.dZQ.dZS, tkVar.dZQ.scene);
                g.azz().a(2811, new i() {
                    /* class com.tencent.mm.plugin.collect.model.v.AnonymousClass2 */

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                        AppMethodBeat.i(63855);
                        if (v.this.jUV != null && v.this.jUV.isShowing()) {
                            v.this.jUV.dismiss();
                            v.this.jUV = null;
                        }
                        g.azz().b(2811, this);
                        final c cVar = (c) qVar;
                        cVar.a(new r.a<c>() {
                            /* class com.tencent.mm.plugin.collect.model.v.AnonymousClass2.AnonymousClass3 */

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.ak.q] */
                            @Override // com.tencent.mm.wallet_core.c.r.a
                            public final /* bridge */ /* synthetic */ void d(int i2, int i3, String str, c cVar) {
                                c cVar2 = cVar;
                                tkVar.dZR.actionType = cVar2.qxC.pTI;
                                tkVar.dZR.dZT = cVar2.qxC.MTC;
                            }
                        }).b(new r.a() {
                            /* class com.tencent.mm.plugin.collect.model.v.AnonymousClass2.AnonymousClass2 */

                            @Override // com.tencent.mm.wallet_core.c.r.a
                            public final void d(int i2, int i3, String str, q qVar) {
                                AppMethodBeat.i(63854);
                                tkVar.dZR.errMsg = cVar.qxC.qwn;
                                if (Util.isNullOrNil(tkVar.dZR.errMsg)) {
                                    tkVar.dZR.errMsg = context.getString(R.string.itf);
                                }
                                AppMethodBeat.o(63854);
                            }
                        }).c(new r.a() {
                            /* class com.tencent.mm.plugin.collect.model.v.AnonymousClass2.AnonymousClass1 */

                            @Override // com.tencent.mm.wallet_core.c.r.a
                            public final void d(int i2, int i3, String str, q qVar) {
                                AppMethodBeat.i(63853);
                                tkVar.dZR.errMsg = str;
                                if (Util.isNullOrNil(tkVar.dZR.errMsg)) {
                                    tkVar.dZR.errMsg = context.getString(R.string.itf);
                                }
                                AppMethodBeat.o(63853);
                            }
                        });
                        tkVar.dZQ.callback.run();
                        AppMethodBeat.o(63855);
                    }
                });
                g.azz().a(cVar, 0);
            } else {
                Log.w("MicroMsg.ScanMaterialCodeListener", "unknown type: %d", Integer.valueOf(tkVar.dZQ.type));
            }
            AppMethodBeat.o(63856);
        }
        return false;
    }
}
