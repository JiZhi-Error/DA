package com.tencent.mm.bh;

import android.content.Context;
import android.content.DialogInterface;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.n.h;
import com.tencent.mm.q.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.a.d;

public final class e {
    public static boolean cA(Context context) {
        AppMethodBeat.i(151157);
        boolean cA = a.cA(context);
        AppMethodBeat.o(151157);
        return cA;
    }

    public static boolean att() {
        AppMethodBeat.i(263520);
        boolean att = a.att();
        AppMethodBeat.o(263520);
        return att;
    }

    public static boolean bgI() {
        AppMethodBeat.i(223643);
        if (h.aqJ().getInt("MultitalkBlockReceiver", 0) == 0) {
            AppMethodBeat.o(223643);
            return true;
        }
        AppMethodBeat.o(223643);
        return false;
    }

    public static boolean isCalling() {
        AppMethodBeat.i(223644);
        if (((TelephonyManager) MMApplicationContext.getContext().getSystemService("phone")).getCallState() != 0) {
            AppMethodBeat.o(223644);
            return true;
        }
        AppMethodBeat.o(223644);
        return false;
    }

    public static d a(Context context, int i2, final Runnable runnable) {
        AppMethodBeat.i(151161);
        d.a aVar = new d.a(context);
        aVar.aoO(R.string.zb);
        aVar.aoS(i2);
        aVar.aoV(R.string.w1).c(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.bh.e.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(151155);
                if (runnable != null) {
                    runnable.run();
                }
                AppMethodBeat.o(151155);
            }
        });
        aVar.Dk(true);
        aVar.f(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.bh.e.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(151156);
                if (runnable != null) {
                    runnable.run();
                }
                AppMethodBeat.o(151156);
            }
        });
        d hbn = aVar.hbn();
        hbn.show();
        AppMethodBeat.o(151161);
        return hbn;
    }

    public static boolean bgF() {
        AppMethodBeat.i(151158);
        mu muVar = new mu();
        muVar.dSs.action = 2;
        EventCenter.instance.publish(muVar);
        boolean z = muVar.dSt.isStart;
        AppMethodBeat.o(151158);
        return z;
    }

    public static boolean bgG() {
        AppMethodBeat.i(151159);
        if (g.jpy == null || !g.jpy.bgr()) {
            AppMethodBeat.o(151159);
            return false;
        }
        AppMethodBeat.o(151159);
        return true;
    }

    public static boolean bgH() {
        AppMethodBeat.i(151160);
        if (com.tencent.mm.bi.d.jpA == null || !com.tencent.mm.bi.d.jpA.bgJ()) {
            AppMethodBeat.o(151160);
            return false;
        }
        AppMethodBeat.o(151160);
        return true;
    }
}
