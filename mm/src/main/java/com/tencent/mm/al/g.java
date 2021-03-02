package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.e;
import com.tencent.mm.api.c;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.protocal.protobuf.ewv;
import com.tencent.mm.protocal.protobuf.oh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class g {
    public static c fJ(String str) {
        AppMethodBeat.i(124043);
        c MT = ag.bah().MT(str);
        if (MT.field_updateTime > 0) {
            AppMethodBeat.o(124043);
            return MT;
        }
        AppMethodBeat.o(124043);
        return null;
    }

    public static boolean Nb(String str) {
        AppMethodBeat.i(124044);
        c fJ = fJ(str);
        if (fJ == null) {
            AppMethodBeat.o(124044);
            return false;
        } else if (fJ.UC()) {
            AppMethodBeat.o(124044);
            return true;
        } else {
            AppMethodBeat.o(124044);
            return false;
        }
    }

    public static boolean Nc(String str) {
        AppMethodBeat.i(124045);
        c fJ = fJ(str);
        if (fJ == null) {
            AppMethodBeat.o(124045);
            return false;
        } else if (fJ.UC()) {
            AppMethodBeat.o(124045);
            return true;
        } else if (fJ.UD()) {
            AppMethodBeat.o(124045);
            return true;
        } else {
            AppMethodBeat.o(124045);
            return false;
        }
    }

    public static boolean Nd(String str) {
        AppMethodBeat.i(124046);
        c fJ = fJ(str);
        if (fJ == null) {
            AppMethodBeat.o(124046);
            return false;
        }
        boolean UD = fJ.UD();
        AppMethodBeat.o(124046);
        return UD;
    }

    public static boolean Ne(String str) {
        AppMethodBeat.i(124047);
        c fJ = fJ(str);
        if (fJ == null) {
            AppMethodBeat.o(124047);
            return false;
        } else if (fJ.UE()) {
            AppMethodBeat.o(124047);
            return true;
        } else {
            AppMethodBeat.o(124047);
            return false;
        }
    }

    public static boolean Nf(String str) {
        AppMethodBeat.i(124048);
        c fJ = fJ(str);
        if (fJ == null) {
            AppMethodBeat.o(124048);
            return false;
        } else if (fJ.UG()) {
            AppMethodBeat.o(124048);
            return true;
        } else {
            AppMethodBeat.o(124048);
            return false;
        }
    }

    public static boolean Ng(String str) {
        AppMethodBeat.i(124049);
        if (str == null) {
            AppMethodBeat.o(124049);
            return false;
        }
        c fJ = fJ(str);
        if (fJ == null) {
            AppMethodBeat.o(124049);
            return false;
        } else if (fJ.UF()) {
            AppMethodBeat.o(124049);
            return true;
        } else {
            AppMethodBeat.o(124049);
            return false;
        }
    }

    public static boolean DQ(String str) {
        AppMethodBeat.i(124050);
        c fJ = fJ(str);
        if (fJ == null) {
            AppMethodBeat.o(124050);
            return false;
        } else if (fJ.UH()) {
            AppMethodBeat.o(124050);
            return true;
        } else {
            AppMethodBeat.o(124050);
            return false;
        }
    }

    public static boolean Nh(String str) {
        AppMethodBeat.i(124051);
        c fJ = fJ(str);
        if (fJ == null) {
            AppMethodBeat.o(124051);
            return false;
        } else if (fJ.UI()) {
            AppMethodBeat.o(124051);
            return true;
        } else {
            AppMethodBeat.o(124051);
            return false;
        }
    }

    public static boolean Ni(String str) {
        AppMethodBeat.i(124052);
        c fJ = fJ(str);
        if (fJ == null) {
            AppMethodBeat.o(124052);
            return false;
        }
        boolean Ux = fJ.Ux();
        AppMethodBeat.o(124052);
        return Ux;
    }

    public static void i(c cVar) {
        AppMethodBeat.i(124053);
        if (cVar == null) {
            Log.e("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession bizInfo is Null");
            AppMethodBeat.o(124053);
            return;
        }
        cpe cpe = new cpe();
        cpe.kem = cVar.field_brandFlag;
        cpe.UserName = cVar.field_username;
        as bjK = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().bjK(cVar.field_username);
        if (bjK == null || !com.tencent.mm.contact.c.oR(bjK.field_type)) {
            ((l) com.tencent.mm.kernel.g.af(l.class)).aSM().d(new k.a(58, cpe));
        } else {
            ((l) com.tencent.mm.kernel.g.af(l.class)).aSM().d(new k.a(47, cpe));
        }
        Log.i("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession ret = %b, BrandFlag = %b", Boolean.valueOf(ag.bah().update(cVar, new String[0])), Integer.valueOf(cVar.field_brandFlag));
        AppMethodBeat.o(124053);
    }

    public static void j(c cVar) {
        AppMethodBeat.i(124054);
        if (cVar != null) {
            cpe cpe = new cpe();
            cpe.kem = cVar.field_brandFlag;
            cpe.UserName = cVar.field_username;
            ((l) com.tencent.mm.kernel.g.af(l.class)).aSM().d(new k.a(47, cpe));
            ag.bah().update(cVar, new String[0]);
        }
        AppMethodBeat.o(124054);
    }

    public static void k(c cVar) {
        AppMethodBeat.i(124055);
        if (cVar != null) {
            cVar.field_brandFlag |= 8;
            j(cVar);
        }
        AppMethodBeat.o(124055);
    }

    public static void l(c cVar) {
        AppMethodBeat.i(124056);
        if (cVar != null) {
            cVar.field_brandFlag &= -9;
            j(cVar);
        }
        AppMethodBeat.o(124056);
    }

    public static boolean aZH() {
        AppMethodBeat.i(124057);
        if (ag.bah().sO(1) > 0) {
            AppMethodBeat.o(124057);
            return true;
        }
        AppMethodBeat.o(124057);
        return false;
    }

    public static boolean aZI() {
        AppMethodBeat.i(124058);
        if (ag.bah().sO(4) > 0) {
            AppMethodBeat.o(124058);
            return true;
        }
        AppMethodBeat.o(124058);
        return false;
    }

    public static boolean aZJ() {
        AppMethodBeat.i(124059);
        if (ag.bah().sO(8) > 0) {
            AppMethodBeat.o(124059);
            return true;
        }
        AppMethodBeat.o(124059);
        return false;
    }

    public static boolean aZK() {
        AppMethodBeat.i(124060);
        if (ag.bah().sO(16) > 0) {
            AppMethodBeat.o(124060);
            return true;
        }
        AppMethodBeat.o(124060);
        return false;
    }

    public static boolean aZL() {
        AppMethodBeat.i(124061);
        if (ag.bah().sO(64) > 0) {
            AppMethodBeat.o(124061);
            return true;
        }
        AppMethodBeat.o(124061);
        return false;
    }

    public static List<String> aZM() {
        AppMethodBeat.i(124062);
        List<String> sN = ag.bah().sN(128);
        AppMethodBeat.o(124062);
        return sN;
    }

    public static boolean aZN() {
        AppMethodBeat.i(124063);
        if (ag.bah().sO(128) > 0) {
            AppMethodBeat.o(124063);
            return true;
        }
        AppMethodBeat.o(124063);
        return false;
    }

    public static List<String> aZO() {
        AppMethodBeat.i(124064);
        List<String> sN = ag.bah().sN(256);
        AppMethodBeat.o(124064);
        return sN;
    }

    public static boolean aZP() {
        AppMethodBeat.i(124065);
        if (ag.bah().sO(256) > 0) {
            AppMethodBeat.o(124065);
            return true;
        }
        AppMethodBeat.o(124065);
        return false;
    }

    public static List<String> aZQ() {
        AppMethodBeat.i(124066);
        List<String> sN = ag.bah().sN(512);
        AppMethodBeat.o(124066);
        return sN;
    }

    public static boolean aZR() {
        AppMethodBeat.i(124067);
        if (ag.bah().sO(512) > 0) {
            AppMethodBeat.o(124067);
            return true;
        }
        AppMethodBeat.o(124067);
        return false;
    }

    public static void Nj(String str) {
        AppMethodBeat.i(124068);
        ag.bah();
        String MX = f.MX(str);
        if (MX != null) {
            ((q) com.tencent.mm.kernel.g.af(q.class)).aSR().aEE(MX);
        }
        ((l) com.tencent.mm.kernel.g.af(l.class)).aST().bjW(str);
        c fJ = fJ(str);
        if (fJ == null) {
            ag.bar().gC(str);
            AppMethodBeat.o(124068);
            return;
        }
        if (fJ.UF()) {
            ((l) com.tencent.mm.kernel.g.af(l.class)).aST().bkp(str);
            ag.bah();
            List<String> MW = f.MW(str);
            bp.as(MW);
            for (int i2 = 0; i2 < MW.size(); i2++) {
                String str2 = MW.get(i2);
                if (DQ(str2)) {
                    e.P(str2, true);
                }
                ag.bah().delete(str2);
            }
        }
        if (fJ.UH()) {
            e.P(str, true);
        }
        ag.bah().f(fJ);
        ag.bar().gC(str);
        AppMethodBeat.o(124068);
    }

    public static List<ewv> Nk(String str) {
        AppMethodBeat.i(212161);
        try {
            d MO = ag.bar().MO(str);
            oh ohVar = new oh();
            ohVar.parseFrom(MO.field_raw_attrs);
            LinkedList<ewv> linkedList = ohVar.KUa;
            AppMethodBeat.o(212161);
            return linkedList;
        } catch (Throwable th) {
            AppMethodBeat.o(212161);
            return null;
        }
    }

    public static boolean fF(String str) {
        AppMethodBeat.i(212162);
        try {
            boolean z = ag.bar().MO(str).field_hide_colleage_invite;
            AppMethodBeat.o(212162);
            return z;
        } catch (Throwable th) {
            AppMethodBeat.o(212162);
            return true;
        }
    }

    public static String fG(String str) {
        AppMethodBeat.i(212163);
        try {
            d MO = ag.bar().MO(str);
            oh ohVar = new oh();
            ohVar.parseFrom(MO.field_raw_attrs);
            String str2 = ohVar.KUd;
            AppMethodBeat.o(212163);
            return str2;
        } catch (Throwable th) {
            AppMethodBeat.o(212163);
            return "";
        }
    }

    public static String fH(String str) {
        AppMethodBeat.i(212164);
        try {
            d MO = ag.bar().MO(str);
            oh ohVar = new oh();
            ohVar.parseFrom(MO.field_raw_attrs);
            String str2 = ohVar.KUe;
            AppMethodBeat.o(212164);
            return str2;
        } catch (Throwable th) {
            AppMethodBeat.o(212164);
            return "";
        }
    }

    public static List<String> Nl(String str) {
        AppMethodBeat.i(212165);
        try {
            d MO = ag.bar().MO(str);
            oh ohVar = new oh();
            ohVar.parseFrom(MO.field_raw_attrs);
            LinkedList<String> linkedList = ohVar.KUc;
            AppMethodBeat.o(212165);
            return linkedList;
        } catch (Throwable th) {
            ArrayList arrayList = new ArrayList(0);
            AppMethodBeat.o(212165);
            return arrayList;
        }
    }
}
