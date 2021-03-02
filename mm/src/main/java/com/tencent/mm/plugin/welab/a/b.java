package com.tencent.mm.plugin.welab.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.welab.a.a.a;
import com.tencent.mm.plugin.welab.d;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class b implements a {
    private Map<String, Integer> JFW = new HashMap();
    private String tag = "";

    public b() {
        AppMethodBeat.i(146235);
        AppMethodBeat.o(146235);
    }

    @Override // com.tencent.mm.plugin.welab.a.a.a
    public final boolean Uw(String str) {
        AppMethodBeat.i(146236);
        if (com.tencent.mm.plugin.welab.a.gjg().bbz(str).field_Switch == 2) {
            Log.i("LabAppLifeService", "appid %s is open ", str);
            AppMethodBeat.o(146236);
            return true;
        }
        Log.i("LabAppLifeService", "appid %s is close", str);
        AppMethodBeat.o(146236);
        return false;
    }

    @Override // com.tencent.mm.plugin.welab.a.a.a
    public final boolean bbD(String str) {
        boolean z;
        AppMethodBeat.i(146237);
        com.tencent.mm.plugin.welab.d.a.a bbz = com.tencent.mm.plugin.welab.a.gjg().bbz(str);
        StringBuilder append = new StringBuilder("isOnline ").append(str).append(", ");
        if (bbz.gjo()) {
            z = true;
        } else {
            z = false;
        }
        Log.i("LabAppLifeService", append.append(z).toString());
        if (bbz.gjo()) {
            AppMethodBeat.o(146237);
            return true;
        }
        AppMethodBeat.o(146237);
        return false;
    }

    @Override // com.tencent.mm.plugin.welab.a.a.a
    public final void open(String str) {
        AppMethodBeat.i(146238);
        com.tencent.mm.plugin.welab.d.a.a bbz = com.tencent.mm.plugin.welab.a.gjg().bbz(str);
        d.a aVar = new d.a();
        aVar.dNI = str;
        aVar.JFU = bbz.field_expId;
        aVar.timeStamp = System.currentTimeMillis();
        aVar.action = 3;
        d.a(aVar);
        AppMethodBeat.o(146238);
    }

    @Override // com.tencent.mm.plugin.welab.a.a.a
    public final boolean bbE(String str) {
        boolean z;
        AppMethodBeat.i(146239);
        com.tencent.mm.plugin.welab.d.a.a bbz = com.tencent.mm.plugin.welab.a.gjg().bbz(str);
        StringBuilder append = new StringBuilder("hitExp ").append(str).append(", ");
        if (bbz.isRunning()) {
            z = true;
        } else {
            z = false;
        }
        Log.i("LabAppLifeService", append.append(z).toString());
        if (bbz.isRunning()) {
            AppMethodBeat.o(146239);
            return true;
        }
        AppMethodBeat.o(146239);
        return false;
    }

    @Override // com.tencent.mm.plugin.welab.a.a.a
    public final void cR(String str, boolean z) {
        int i2 = 1;
        AppMethodBeat.i(146240);
        Log.i("LabAppLifeService", "switchEntry " + str + "," + z);
        com.tencent.mm.plugin.welab.d.a.a bbz = com.tencent.mm.plugin.welab.a.gjg().bbz(str);
        int i3 = z ? 2 : 1;
        if (bbz.field_Switch != i3) {
            bbz.field_Switch = i3;
            com.tencent.mm.plugin.welab.a.gjg().JFR.update(bbz, new String[0]);
            cgw cgw = new cgw();
            cgv cgv = new cgv();
            cgv.Mmd = bbz.gjp() ? 0 : Util.safeParseInt(bbz.field_expId);
            cgv.Mme = bbz.field_LabsAppId;
            if (bbz.field_Switch != 2) {
                i2 = 2;
            }
            cgv.KWb = i2;
            cgw.gCs.add(cgv);
            ((l) g.af(l.class)).aSM().d(new k.a(207, cgw));
            d.y(str, bbz.field_Switch == 2 ? 4 : 5, false);
        }
        AppMethodBeat.o(146240);
    }

    @Override // com.tencent.mm.plugin.welab.a.a.a
    public final String bbF(String str) {
        AppMethodBeat.i(146241);
        String str2 = com.tencent.mm.plugin.welab.a.gjg().bbz(str).field_WeAppUser;
        AppMethodBeat.o(146241);
        return str2;
    }

    @Override // com.tencent.mm.plugin.welab.a.a.a
    public final int bbG(String str) {
        AppMethodBeat.i(146242);
        int i2 = com.tencent.mm.plugin.welab.a.gjg().bbz(str).field_WeAppDebugMode;
        AppMethodBeat.o(146242);
        return i2;
    }
}
