package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.x;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    public static boolean a(x xVar) {
        boolean z = true;
        AppMethodBeat.i(137010);
        if (xVar.dCQ.action != 6) {
            Log.d("MicroMsg.Audio.AudioActionListener", "callback, action:%d", Integer.valueOf(xVar.dCQ.action));
        }
        switch (xVar.dCQ.action) {
            case 0:
                z = h.esI().m(xVar.dCQ.dCT);
                xVar.dCR.result = z;
                break;
            case 1:
                z = h.esI().b(xVar.dCQ.dtX, xVar.dCQ.dCT);
                xVar.dCR.result = z;
                break;
            case 2:
                z = h.esI().aGT(xVar.dCQ.dtX);
                xVar.dCR.result = z;
                break;
            case 3:
                z = h.esI().aGU(xVar.dCQ.dtX);
                xVar.dCR.result = z;
                break;
            case 4:
                z = h.esI().eQ(xVar.dCQ.dtX, xVar.dCQ.dCS);
                xVar.dCR.result = z;
                break;
            case 5:
                boolean aGW = h.esI().aGW(xVar.dCQ.dtX);
                xVar.dCR.result = true;
                z = aGW;
                break;
            case 6:
                xVar.dCR.dCV = h.esI().aGZ(xVar.dCQ.dtX);
                break;
            case 7:
                z = h.esI().LT(xVar.dCQ.dtX);
                xVar.dCR.result = z;
                break;
            case 8:
                z = h.esI().aGX(xVar.dCQ.dtX);
                xVar.dCR.result = z;
                break;
            case 9:
                h.esI().aHd(xVar.dCQ.appId);
                break;
            case 10:
                xVar.dCQ.dtX = h.esI().iS(xVar.dCQ.appId, xVar.dCQ.dtX);
                break;
            case 11:
                xVar.dCR.count = h.esI().aHa(xVar.dCQ.appId);
                break;
            case 12:
                h.esI().aHc(xVar.dCQ.appId);
                break;
            case 13:
                z = h.esI().aGY(xVar.dCQ.dtX);
                xVar.dCR.result = z;
                break;
            case 14:
                z = h.esI().aGV(xVar.dCQ.dtX);
                xVar.dCR.result = z;
                break;
            case 15:
                h.esI().aHk(xVar.dCQ.processName);
                break;
            case 16:
                xVar.dCQ.dCT = h.esI().LU(xVar.dCQ.dtX);
                break;
            case 17:
                z = h.esI().hi(xVar.dCQ.dtX);
                xVar.dCR.result = z;
                break;
            case 18:
                z = h.esI().l(xVar.dCQ.dCT);
                xVar.dCR.result = z;
                break;
            case 19:
                boolean a2 = h.esI().a(xVar.dCQ.dCU);
                xVar.dCR.result = true;
                z = a2;
                break;
            case 20:
                xVar.dCR.dCU = h.esI().dCU;
                break;
        }
        AppMethodBeat.o(137010);
        return z;
    }
}
