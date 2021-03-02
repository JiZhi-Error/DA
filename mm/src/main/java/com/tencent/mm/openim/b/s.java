package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.brp;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;

public final class s {
    public static int a(brp brp) {
        AppMethodBeat.i(151231);
        int i2 = brp.ret;
        cvw cvw = brp.LYS;
        as a2 = a(cvw);
        Log.i("MicroMsg.OpenIMContactLogic", "onGYNetEnd openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", a2.field_username, a2.field_nickname, a2.field_conRemark, Integer.valueOf(a2.getSource()), Integer.valueOf(a2.fuA), a2.field_openImAppid, a2.fvb, Integer.valueOf(a2.fva), Integer.valueOf(a2.field_type), a2.field_descWordingId);
        ((l) g.af(l.class)).aSN().ao(a2);
        ((a) g.af(a.class)).bM(cvw.app_id, cvw.MBp);
        b(cvw);
        AppMethodBeat.o(151231);
        return i2;
    }

    public static as a(cvw cvw) {
        AppMethodBeat.i(151232);
        as Kn = ((l) g.af(l.class)).aSN().Kn(cvw.jGZ);
        if (Kn == null) {
            Kn = new as();
        }
        Kn.setUsername(cvw.jGZ);
        Kn.setNickname(cvw.nickname);
        Kn.setType(cvw.type);
        Kn.BD(cvw.remark);
        Kn.setSource(cvw.source);
        Kn.BF(cvw.MBr);
        Kn.BG(cvw.MBs);
        Kn.BJ(cvw.MBt);
        Kn.BI(cvw.MBu);
        Kn.Ck(cvw.MBv == null ? "" : cvw.MBv.xKd);
        Kn.nr(cvw.MBv == null ? 0 : cvw.MBv.MBw);
        Kn.Cj(cvw.KHz);
        Kn.BN(cvw.app_id);
        Kn.nj(cvw.fuA);
        Kn.BM(cvw.MBp);
        Kn.no((int) Util.nowSecond());
        AppMethodBeat.o(151232);
        return Kn;
    }

    public static void b(cvw cvw) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(151233);
        String str = "";
        String str2 = "";
        i Mx = p.aYB().Mx(cvw.jGZ);
        if (Mx != null) {
            str = Mx.aYt();
            str2 = Mx.aYu();
        }
        i iVar = new i();
        iVar.cSx = -1;
        iVar.username = cvw.jGZ;
        iVar.iKW = cvw.MBf;
        iVar.iKX = cvw.MBe;
        Log.i("MicroMsg.OpenIMContactLogic", "dealwithAvatarFromModContact contact %s b[%s] s[%s]", iVar.getUsername(), iVar.aYt(), iVar.aYu());
        if (!iVar.aYt().equals(str)) {
            p.aYn();
            e.N(cvw.jGZ, true);
            z = true;
        } else {
            z = false;
        }
        if (!iVar.aYu().equals(str2)) {
            p.aYn();
            e.N(cvw.jGZ, false);
        } else {
            z2 = z;
        }
        if (z2) {
            p.aYD().Mg(cvw.jGZ);
            p.aYB().b(iVar);
        }
        AppMethodBeat.o(151233);
    }
}
