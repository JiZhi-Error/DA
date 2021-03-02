package com.tencent.mm.plugin.hp.b;

import android.util.Base64;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ku;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.hp.d.a;
import com.tencent.mm.plugin.hp.tinker.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c extends IListener<ku> {
    private static final String icT = (b.aKB() + "_temp.hp");
    private a ymw = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(ku kuVar) {
        AppMethodBeat.i(117413);
        boolean a2 = a(kuVar);
        AppMethodBeat.o(117413);
        return a2;
    }

    static {
        AppMethodBeat.i(117414);
        AppMethodBeat.o(117414);
    }

    public c() {
        AppMethodBeat.i(161180);
        this.__eventId = ku.class.getName().hashCode();
        AppMethodBeat.o(161180);
    }

    public static void aBG(String str) {
        AppMethodBeat.i(117410);
        Log.w("Tinker.HotPatchApplyService", "hp_apply from file %s", str);
        e.aBJ(str);
        AppMethodBeat.o(117410);
    }

    private boolean a(ku kuVar) {
        AppMethodBeat.i(117412);
        if (this.ymw != null) {
            Log.e("Tinker.HotPatchApplyService", "hp_apply processing busy, ignore new event");
            AppMethodBeat.o(117412);
        } else if (1 == kuVar.dPP.dDe) {
            e.dZn();
            AppMethodBeat.o(117412);
        } else if (kuVar.dPP.dPU != null) {
            aBG(kuVar.dPP.dPU);
            AppMethodBeat.o(117412);
        } else {
            b.Mg(1);
            if (kuVar.dPP.dPS != null) {
                try {
                    byte[] decode = Base64.decode(kuVar.dPP.dPS, 0);
                    kuVar.dPP.dPS = new String(decode);
                } catch (Error e2) {
                }
            }
            if (!Util.isNullOrNil(kuVar.dPP.dPS) && !Util.isNullOrNil(kuVar.dPP.dPT)) {
                Log.i("Tinker.HotPatchApplyService", "hp_apply request url=%s, signature=%s", kuVar.dPP.dPS, kuVar.dPP.dPT);
                this.ymw = new a(kuVar.dPP.dPS, icT, kuVar.dPP.dPT) {
                    /* class com.tencent.mm.plugin.hp.b.c.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.hp.d.a, com.tencent.f.i.f
                    public final /* bridge */ /* synthetic */ void boG() {
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.plugin.hp.d.a, com.tencent.f.i.f
                    public final /* synthetic */ void cp(Runnable runnable) {
                        AppMethodBeat.i(184413);
                        av(runnable);
                        AppMethodBeat.o(184413);
                    }

                    @Override // com.tencent.mm.plugin.hp.d.a
                    public final void av(Runnable runnable) {
                        AppMethodBeat.i(184412);
                        super.av(runnable);
                        Log.d("Tinker.HotPatchApplyService", "hp_apply download url=%s, file=%s, failed=%b", c.this.ymw.url, c.this.ymw.ynt, Boolean.valueOf(c.this.ymw.aGI));
                        if (!c.this.ymw.aGI) {
                            b.OP(1);
                            c.aBG(c.this.ymw.ynt);
                        } else {
                            b.OQ(1);
                        }
                        c.this.ymw = null;
                        AppMethodBeat.o(184412);
                    }
                };
            } else if (Util.isNullOrNil(kuVar.dPP.dPQ) || Util.isNullOrNil(kuVar.dPP.dPR)) {
                AppMethodBeat.o(117412);
            }
            h.RTc.b(this.ymw, "hp_apply_download");
            AppMethodBeat.o(117412);
        }
        return false;
    }
}
