package com.tencent.mm.platformtools;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    private l jMA;
    private j jMB;
    private m jMw;
    private n jMx;
    private o jMy;
    private k jMz;

    public final boolean a(Activity activity, ae aeVar) {
        AppMethodBeat.i(127673);
        if (aeVar.type == 0 || aeVar.action == 0) {
            AppMethodBeat.o(127673);
            return false;
        }
        switch (aeVar.type) {
            case 1:
                if (this.jMw == null) {
                    this.jMw = new m(activity);
                }
                this.jMw.a(aeVar);
                break;
            case 2:
                if (this.jMx == null) {
                    this.jMx = new n(activity);
                }
                this.jMx.a(aeVar);
                break;
            case 3:
                if (this.jMy == null) {
                    this.jMy = new o(activity);
                }
                this.jMy.a(aeVar);
                break;
            case 4:
                if (this.jMz == null) {
                    this.jMz = new k(activity);
                }
                this.jMz.a(aeVar);
                break;
            case 5:
                if (this.jMA == null) {
                    this.jMA = new l(activity);
                }
                this.jMA.a(aeVar);
                break;
            case 6:
                if (this.jMB == null) {
                    this.jMB = new j(activity);
                }
                this.jMB.a(aeVar);
                break;
            default:
                Log.e("MicroMsg.BaseErrorHelper", "Unkown error type");
                AppMethodBeat.o(127673);
                return false;
        }
        AppMethodBeat.o(127673);
        return true;
    }

    private static void a(c cVar) {
        AppMethodBeat.i(127674);
        if (cVar != null) {
            for (Integer num : cVar.jMC) {
                g.azz().b(num.intValue(), cVar);
            }
            cVar.activity = null;
        }
        AppMethodBeat.o(127674);
    }

    public final void close() {
        AppMethodBeat.i(127675);
        a(this.jMw);
        a(this.jMx);
        a(this.jMy);
        a(this.jMz);
        a(this.jMA);
        a(this.jMB);
        AppMethodBeat.o(127675);
    }
}
