package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.cqg;
import com.tencent.mm.protocal.protobuf.cqh;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ci;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ab {
    private static ar iCD = null;
    private static HashMap<String, Boolean> iCE = new HashMap<>();
    public static final String iCF = b("rconversation.username", new String[]{"@im.chatroom", "@chatroom", "@openim", "@micromsg.qq.com"});
    public static final String iCG = b("rconversation.username", new String[]{"@chatroom", "@micromsg.qq.com"});
    public static final String iCH = b("rconversation.username", new String[]{"@t.qq.com"});
    public static final String iCI = b("rconversation.username", new String[]{"@qqim"});
    public static final String iCJ = b("rconversation.username", new String[]{"@chatroom_exclusive"});
    public static final String iCK = b("rconversation.username", new String[]{"@micromsg.qq.com"});
    public static final String iCL = b("rconversation.username", new String[]{"@app"});
    public static final String iCM = b("rconversation.username", new String[]{"@chatroom"});
    public static final String iCN = b("rconversation.username", new String[]{"@im.chatroom"});
    public static final String[] iCO = {"qqmail", "fmessage", "tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp", "shakeapp", "medianote", "qqfriend", "newsapp", "blogapp", "facebookapp", "topstoryapp", "masssendapp", "feedsapp", "voipapp", "cardpackage", "voicevoipapp", "voiceinputapp", "officialaccounts", "linkedinplugin", "notifymessage", "appbrandcustomerservicemsg", "appbrand_notify_message"};

    static {
        AppMethodBeat.i(42931);
        AppMethodBeat.o(42931);
    }

    public static void a(ar arVar) {
        iCD = arVar;
    }

    public static boolean Iu(String str) {
        AppMethodBeat.i(42831);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(42831);
            return false;
        } else if (!str.contains("@") || str.endsWith("@micromsg.qq.com")) {
            AppMethodBeat.o(42831);
            return true;
        } else {
            AppMethodBeat.o(42831);
            return false;
        }
    }

    public static boolean Iv(String str) {
        AppMethodBeat.i(225930);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(225930);
            return false;
        }
        boolean equalsIgnoreCase = str.equalsIgnoreCase("weixin");
        AppMethodBeat.o(225930);
        return equalsIgnoreCase;
    }

    public static boolean Iw(String str) {
        AppMethodBeat.i(42832);
        if (Ix(str) || Iy(str)) {
            AppMethodBeat.o(42832);
            return true;
        }
        AppMethodBeat.o(42832);
        return false;
    }

    public static boolean Ix(String str) {
        AppMethodBeat.i(42833);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(42833);
            return false;
        }
        boolean endsWith = str.endsWith("@chatroom");
        AppMethodBeat.o(42833);
        return endsWith;
    }

    public static boolean Eq(String str) {
        AppMethodBeat.i(42834);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(42834);
            return false;
        } else if (str.endsWith("@chatroom") || str.endsWith("@im.chatroom")) {
            AppMethodBeat.o(42834);
            return true;
        } else {
            AppMethodBeat.o(42834);
            return false;
        }
    }

    public static boolean Iy(String str) {
        AppMethodBeat.i(42835);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(42835);
            return false;
        }
        boolean endsWith = str.endsWith("@im.chatroom");
        AppMethodBeat.o(42835);
        return endsWith;
    }

    public static boolean Iz(String str) {
        AppMethodBeat.i(178864);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(178864);
            return false;
        } else if (str.endsWith("@im.chatroom") || IB(str)) {
            AppMethodBeat.o(178864);
            return true;
        } else {
            AppMethodBeat.o(178864);
            return false;
        }
    }

    public static boolean IA(String str) {
        boolean z;
        AppMethodBeat.i(225931);
        if (str == null || str.length() <= 0) {
            Log.i("MicroMsg.ContactStorageLogic", "union luckymoney logic：isOpenImIncludeAssociateRoomOrOpenIMUser :(username == null) || (username.length() <= 0) ");
            AppMethodBeat.o(225931);
            return false;
        }
        if (Iz(str) || as.bjp(str)) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.ContactStorageLogic", "union luckymoney logic：isOpenImIncludeAssociateRoomOrOpenIMUser :%s ", Boolean.valueOf(z));
        AppMethodBeat.o(225931);
        return z;
    }

    public static boolean rQ(int i2) {
        AppMethodBeat.i(225932);
        Log.i("MicroMsg.ContactStorageLogic", "union luckymoney logic：isOpenImIncludeAssociateRoomOrOpenIMUser sceneid :%s ", Integer.valueOf(i2));
        if (i2 == 1005) {
            Log.i("MicroMsg.ContactStorageLogic", "union luckymoney logic：use union luckymoney ");
            AppMethodBeat.o(225932);
            return true;
        }
        Log.i("MicroMsg.ContactStorageLogic", "union luckymoney logic：use normal luckymoney ");
        AppMethodBeat.o(225932);
        return false;
    }

    public static boolean IB(String str) {
        AppMethodBeat.i(178865);
        if (Ix(str)) {
            Boolean bool = null;
            if (iCE.containsKey(str)) {
                bool = iCE.get(str);
            }
            if (bool == null) {
                Boolean bool2 = Boolean.FALSE;
                ah Kd = ((c) g.af(c.class)).aSX().Kd(str);
                if (Kd == null || (Kd.field_chatroomStatus & 131072) != 131072) {
                    bool = bool2;
                } else {
                    bool = Boolean.TRUE;
                }
                iCE.put(str, bool);
            }
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(178865);
            return booleanValue;
        }
        AppMethodBeat.o(178865);
        return false;
    }

    public static void IC(String str) {
        AppMethodBeat.i(225933);
        iCE.remove(str);
        AppMethodBeat.o(225933);
    }

    public static boolean ID(String str) {
        ah Kd;
        AppMethodBeat.i(178866);
        if (!Ix(str) || (Kd = ((c) g.af(c.class)).aSX().Kd(str)) == null || (Kd.field_chatroomStatus & 131072) == 131072 || (Kd.field_chatroomStatus & 65536) != 65536) {
            AppMethodBeat.o(178866);
            return false;
        }
        AppMethodBeat.o(178866);
        return true;
    }

    public static boolean IE(String str) {
        ah Kd;
        AppMethodBeat.i(178867);
        if (!((t) g.af(t.class)).ama() || !Ix(str) || (Kd = ((c) g.af(c.class)).aSX().Kd(str)) == null || !Kd.amD()) {
            AppMethodBeat.o(178867);
            return false;
        }
        AppMethodBeat.o(178867);
        return true;
    }

    public static boolean IF(String str) {
        AppMethodBeat.i(42836);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(42836);
            return false;
        }
        boolean endsWith = str.endsWith("@qy_u");
        AppMethodBeat.o(42836);
        return endsWith;
    }

    public static boolean IG(String str) {
        AppMethodBeat.i(42837);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(42837);
            return false;
        }
        boolean endsWith = str.endsWith("@bottle");
        AppMethodBeat.o(42837);
        return endsWith;
    }

    public static boolean IH(String str) {
        AppMethodBeat.i(42838);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(42838);
            return false;
        }
        boolean endsWith = str.endsWith("@qqim");
        AppMethodBeat.o(42838);
        return endsWith;
    }

    public static boolean II(String str) {
        AppMethodBeat.i(42839);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(42839);
            return false;
        }
        boolean endsWith = str.endsWith("@lbsroom");
        AppMethodBeat.o(42839);
        return endsWith;
    }

    public static boolean p(as asVar) {
        AppMethodBeat.i(42840);
        if (asVar == null) {
            AppMethodBeat.o(42840);
            return false;
        } else if (!Iw(asVar.field_username)) {
            AppMethodBeat.o(42840);
            return false;
        } else if (!com.tencent.mm.contact.c.oR(asVar.field_type)) {
            AppMethodBeat.o(42840);
            return false;
        } else {
            AppMethodBeat.o(42840);
            return true;
        }
    }

    public static boolean IJ(String str) {
        AppMethodBeat.i(42841);
        boolean equals = "gh_43f2581f6fd6".equals(str);
        AppMethodBeat.o(42841);
        return equals;
    }

    public static boolean IK(String str) {
        AppMethodBeat.i(42842);
        boolean equals = "gh_3dfda90e39d6".equals(str);
        AppMethodBeat.o(42842);
        return equals;
    }

    public static boolean IL(String str) {
        AppMethodBeat.i(225934);
        boolean equals = "gh_f0a92aa7146c".equals(str);
        AppMethodBeat.o(225934);
        return equals;
    }

    public static boolean IM(String str) {
        AppMethodBeat.i(225935);
        boolean equals = "gh_579db1f2cf89".equals(str);
        AppMethodBeat.o(225935);
        return equals;
    }

    public static boolean IN(String str) {
        AppMethodBeat.i(163508);
        boolean equals = "1@fackuser".equals(str);
        AppMethodBeat.o(163508);
        return equals;
    }

    public static boolean IO(String str) {
        AppMethodBeat.i(225936);
        boolean equals = "msginfo@fakeuser".equals(str);
        AppMethodBeat.o(225936);
        return equals;
    }

    public static boolean IP(String str) {
        AppMethodBeat.i(42843);
        boolean equals = "downloaderapp".equals(str);
        AppMethodBeat.o(42843);
        return equals;
    }

    public static boolean IQ(String str) {
        AppMethodBeat.i(42844);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(42844);
            return false;
        } else if (!Iw(str)) {
            AppMethodBeat.o(42844);
            return false;
        } else {
            as Kn = ((l) g.af(l.class)).aSN().Kn(str);
            if (Kn == null || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                AppMethodBeat.o(42844);
                return false;
            }
            AppMethodBeat.o(42844);
            return true;
        }
    }

    public static boolean IR(String str) {
        AppMethodBeat.i(42845);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(42845);
            return false;
        }
        boolean endsWith = str.endsWith("@stranger");
        AppMethodBeat.o(42845);
        return endsWith;
    }

    public static List<String> aUU() {
        AppMethodBeat.i(42846);
        List<String> gBZ = ((l) g.af(l.class)).aSN().gBZ();
        AppMethodBeat.o(42846);
        return gBZ;
    }

    public static List<as> aUV() {
        AppMethodBeat.i(42847);
        ArrayList arrayList = new ArrayList();
        Cursor gCa = ((l) g.af(l.class)).aSN().gCa();
        if (gCa.moveToFirst()) {
            do {
                as asVar = new as();
                asVar.convertFrom(gCa);
                arrayList.add(asVar);
            } while (gCa.moveToNext());
        }
        gCa.close();
        AppMethodBeat.o(42847);
        return arrayList;
    }

    public static boolean IS(String str) {
        AppMethodBeat.i(42849);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(42849);
            return true;
        }
        boolean oR = com.tencent.mm.contact.c.oR(((l) g.af(l.class)).aSN().Kn(str).field_type);
        AppMethodBeat.o(42849);
        return oR;
    }

    public static boolean IT(String str) {
        AppMethodBeat.i(42850);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(42850);
            return false;
        }
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn == null) {
            AppMethodBeat.o(42850);
            return false;
        }
        boolean akh = as.akh(Kn.field_verifyFlag);
        AppMethodBeat.o(42850);
        return akh;
    }

    public static boolean rR(int i2) {
        AppMethodBeat.i(42851);
        boolean akh = as.akh(i2);
        AppMethodBeat.o(42851);
        return akh;
    }

    public static void q(as asVar) {
        AppMethodBeat.i(42852);
        Assert.assertTrue(asVar != null);
        as Kn = ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
        if (Kn != null && !Util.isNullOrNil(Kn.field_username)) {
            asVar = Kn;
        }
        asVar.aqW();
        G(asVar);
        AppMethodBeat.o(42852);
    }

    public static void D(String str, boolean z) {
        AppMethodBeat.i(42853);
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn == null || Util.isNullOrNil(Kn.field_username)) {
            AppMethodBeat.o(42853);
            return;
        }
        if (z) {
            Kn.arf();
        } else {
            Kn.arg();
        }
        E(Kn);
        AppMethodBeat.o(42853);
    }

    public static void r(as asVar) {
        AppMethodBeat.i(42854);
        Assert.assertTrue(asVar != null);
        as Kn = ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
        if (Kn != null && !Util.isNullOrNil(Kn.field_username)) {
            asVar = Kn;
        }
        asVar.aqU();
        G(asVar);
        AppMethodBeat.o(42854);
    }

    public static void s(as asVar) {
        AppMethodBeat.i(42855);
        Assert.assertTrue(asVar != null);
        as Kn = ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
        if (Kn != null && !Util.isNullOrNil(Kn.field_username)) {
            asVar = Kn;
        }
        asVar.aqV();
        G(asVar);
        AppMethodBeat.o(42855);
    }

    public static void t(as asVar) {
        AppMethodBeat.i(42856);
        Assert.assertTrue(asVar != null);
        as Kn = ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
        if (Kn == null || Util.isNullOrNil(Kn.field_username)) {
            Kn = asVar;
        }
        Kn.aqS();
        if (as.bjp(asVar.field_username) && iCD != null) {
            iCD.EA(asVar.field_username);
        }
        G(Kn);
        AppMethodBeat.o(42856);
    }

    public static void u(as asVar) {
        AppMethodBeat.i(42857);
        Assert.assertTrue(asVar != null);
        as Kn = ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
        if (Kn == null || Util.isNullOrNil(Kn.field_username)) {
            Kn = asVar;
        }
        Kn.aqT();
        if (as.bjp(asVar.field_username) && iCD != null) {
            iCD.EB(asVar.field_username);
        }
        G(Kn);
        az bjY = ((l) g.af(l.class)).aST().bjY(asVar.field_username);
        if (bjY != null && "@blacklist".equals(bjY.field_parentRef)) {
            ((l) g.af(l.class)).aST().c(new String[]{bjY.field_username}, "");
        }
        AppMethodBeat.o(42857);
    }

    public static void v(as asVar) {
        AppMethodBeat.i(42858);
        Assert.assertTrue(asVar != null);
        as Kn = ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
        if (Kn == null || Util.isNullOrNil(Kn.field_username)) {
            Kn = asVar;
        }
        Kn.arf();
        Kn.nd(asVar.aqN());
        E(Kn);
        AppMethodBeat.o(42858);
    }

    public static void w(as asVar) {
        AppMethodBeat.i(42859);
        Assert.assertTrue(asVar != null);
        as Kn = ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
        if (Kn == null || Util.isNullOrNil(Kn.field_username)) {
            Kn = asVar;
        }
        Kn.arg();
        Kn.nd(asVar.aqN());
        E(Kn);
        AppMethodBeat.o(42859);
    }

    public static void x(as asVar) {
        AppMethodBeat.i(42860);
        Assert.assertTrue(asVar != null);
        as Kn = ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
        if (Kn == null || Util.isNullOrNil(Kn.field_username)) {
            Kn = asVar;
        }
        Kn.arb();
        Kn.nd(asVar.aqN());
        if (as.bjp(asVar.field_username) && iCD != null) {
            iCD.EC(asVar.field_username);
        }
        G(Kn);
        AppMethodBeat.o(42860);
    }

    public static void y(as asVar) {
        AppMethodBeat.i(42861);
        Assert.assertTrue(asVar != null);
        as Kn = ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
        if (Kn == null || Util.isNullOrNil(Kn.field_username)) {
            Kn = asVar;
        }
        Kn.arc();
        Kn.nd(asVar.aqN());
        if (as.bjp(asVar.field_username) && iCD != null) {
            iCD.ED(asVar.field_username);
        }
        G(Kn);
        AppMethodBeat.o(42861);
    }

    public static void E(String str, boolean z) {
        AppMethodBeat.i(42862);
        Assert.assertTrue(!Util.isNullOrNil(str));
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn == null || Util.isNullOrNil(Kn.field_username)) {
            AppMethodBeat.o(42862);
            return;
        }
        Kn.setType(Kn.field_type | 2048);
        if ((as.bjp(str) || Iy(str)) && iCD != null) {
            iCD.Ey(str);
        }
        G(Kn);
        if (z) {
            ((l) g.af(l.class)).aST().bke(str);
        }
        AppMethodBeat.o(42862);
    }

    public static void IU(String str) {
        AppMethodBeat.i(42863);
        az bjY = ((l) g.af(l.class)).aST().bjY(str);
        boolean z = false;
        if (bjY == null) {
            bjY = new az();
            bjY.gCr();
            z = true;
            bjY.setUsername(str);
        }
        bjY.yA(System.currentTimeMillis());
        if (z) {
            ((l) g.af(l.class)).aST().e(bjY);
            AppMethodBeat.o(42863);
            return;
        }
        ((l) g.af(l.class)).aST().a(bjY, str);
        AppMethodBeat.o(42863);
    }

    public static void F(String str, boolean z) {
        AppMethodBeat.i(42864);
        Assert.assertTrue(!Util.isNullOrNil(str));
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn == null || Util.isNullOrNil(Kn.field_username)) {
            AppMethodBeat.o(42864);
            return;
        }
        Kn.setType(Kn.field_type & -2049);
        if ((as.bjp(str) || Iy(str)) && iCD != null) {
            iCD.Ez(str);
        }
        G(Kn);
        if (z) {
            ((l) g.af(l.class)).aST().bkf(str);
        }
        AppMethodBeat.o(42864);
    }

    public static void z(as asVar) {
        AppMethodBeat.i(42865);
        Assert.assertTrue(asVar != null);
        as Kn = ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
        if (Kn == null || Util.isNullOrNil(Kn.field_username)) {
            Kn = asVar;
        }
        Kn.ard();
        if (as.bjp(asVar.field_username) && iCD != null) {
            iCD.EE(asVar.field_username);
        }
        G(Kn);
        AppMethodBeat.o(42865);
    }

    public static void A(as asVar) {
        AppMethodBeat.i(42866);
        Assert.assertTrue(asVar != null);
        as Kn = ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
        if (Kn == null || Util.isNullOrNil(Kn.field_username)) {
            Kn = asVar;
        }
        Kn.are();
        if (as.bjp(asVar.field_username) && iCD != null) {
            iCD.EF(asVar.field_username);
        }
        G(Kn);
        AppMethodBeat.o(42866);
    }

    public static void B(as asVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(42867);
        Assert.assertTrue("MicroMsg.ContactStorageLogic: user is null", asVar != null);
        if (((int) asVar.gMZ) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue("MicroMsg.ContactStorageLogic: contactId == 0", z);
        if (asVar.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue("MicroMsg.ContactStorageLogic: username length <= 0", z2);
        asVar.aqQ();
        ((l) g.af(l.class)).aSN().c(asVar.field_username, asVar);
        AppMethodBeat.o(42867);
    }

    public static void C(as asVar) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(42868);
        if (asVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (((int) asVar.gMZ) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (asVar.field_username.length() <= 0) {
            z3 = false;
        }
        Assert.assertTrue(z3);
        asVar.aqQ();
        ((l) g.af(l.class)).aSN().c(asVar.field_username, asVar);
        G(asVar);
        AppMethodBeat.o(42868);
    }

    public static void c(as asVar, String str) {
        AppMethodBeat.i(42869);
        as Kn = ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
        Assert.assertTrue((Kn == null || str == null) ? false : true);
        Kn.BD(str);
        if (as.bjp(asVar.field_username) && iCD != null) {
            iCD.am(asVar.field_username, str);
        }
        G(Kn);
        AppMethodBeat.o(42869);
    }

    public static void D(as asVar) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(42870);
        if (asVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (((int) asVar.gMZ) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (asVar.field_username.length() <= 0) {
            z3 = false;
        }
        Assert.assertTrue(z3);
        asVar.arG();
        G(asVar);
        AppMethodBeat.o(42870);
    }

    private static void E(as asVar) {
        boolean z;
        AppMethodBeat.i(42871);
        if (asVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (((int) asVar.gMZ) == 0) {
            ((l) g.af(l.class)).aSN().aq(asVar);
            ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
        }
        ((l) g.af(l.class)).aSN().c(asVar.field_username, asVar);
        cqg cqg = new cqg();
        cqg.MvG = asVar.field_username;
        if (asVar.arB()) {
            cqg.MvC = 1;
        } else {
            cqg.MvC = 2;
        }
        ((l) g.af(l.class)).aSM().d(new k.a(52, cqg));
        AppMethodBeat.o(42871);
    }

    public static void F(as asVar) {
        boolean z;
        AppMethodBeat.i(42872);
        if (asVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (((int) asVar.gMZ) == 0) {
            ((l) g.af(l.class)).aSN().aq(asVar);
            ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
        }
        ((l) g.af(l.class)).aSN().c(asVar.field_username, asVar);
        cqh cqh = new cqh();
        cqh.MvG = asVar.field_username;
        if (asVar.arD()) {
            cqh.MvC = 1;
        } else {
            cqh.MvC = 2;
        }
        ((l) g.af(l.class)).aSM().d(new k.a(72, cqh));
        AppMethodBeat.o(42872);
    }

    public static void G(as asVar) {
        boolean z;
        AppMethodBeat.i(42873);
        if (asVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (((int) asVar.gMZ) == 0) {
            ((l) g.af(l.class)).aSN().aq(asVar);
            ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
        }
        ((l) g.af(l.class)).aSN().c(asVar.field_username, asVar);
        if (!as.bjp(asVar.field_username)) {
            I(asVar);
        }
        AppMethodBeat.o(42873);
    }

    public static cpl H(as asVar) {
        AppMethodBeat.i(225937);
        Log.i("MicroMsg.ContactStorageLogic", "oplog modContact user:%s remark:%s type:%d ", asVar.field_username, asVar.field_conRemark, Integer.valueOf(asVar.field_type));
        cpl cpl = new cpl();
        cpl.Lqk = new dqi().bhy(Util.nullAsNil(asVar.field_username));
        cpl.Mjj = new dqi().bhy(Util.nullAsNil(asVar.field_nickname));
        cpl.LpA = new dqi().bhy(Util.nullAsNil(asVar.ajz()));
        cpl.LpB = new dqi().bhy(Util.nullAsNil(asVar.ajA()));
        cpl.kdY = asVar.fuA;
        cpl.LoG = 176787327;
        cpl.LoH = asVar.field_type;
        cpl.MuI = new dqi().bhy(Util.nullAsNil(asVar.field_conRemark));
        cpl.MuJ = new dqi().bhy(Util.nullAsNil(asVar.field_conRemarkPYShort));
        cpl.MuK = new dqi().bhy(Util.nullAsNil(asVar.field_conRemarkPYFull));
        cpl.LoM = asVar.fuE;
        cpl.Mvh = new dqi().bhy(Util.nullAsNil(asVar.field_domainList));
        cpl.LoQ = asVar.fuH;
        cpl.kec = asVar.fuI;
        cpl.keb = Util.nullAsNil(asVar.signature);
        cpl.kea = Util.nullAsNil(asVar.getCityCode());
        cpl.kdZ = Util.nullAsNil(asVar.gBR());
        cpl.MmM = Util.nullAsNil(asVar.fuM);
        cpl.MmO = asVar.field_weiboFlag;
        cpl.Mvd = 0;
        cpl.KHp = new SKBuiltinBuffer_t();
        cpl.keh = Util.nullAsNil(asVar.getCountryCode());
        AppMethodBeat.o(225937);
        return cpl;
    }

    public static void I(as asVar) {
        AppMethodBeat.i(42874);
        ((l) g.af(l.class)).aSM().d(new k.a(2, H(asVar)));
        AppMethodBeat.o(42874);
    }

    public static void IV(String str) {
        AppMethodBeat.i(42875);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(42875);
            return;
        }
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn == null) {
            AppMethodBeat.o(42875);
            return;
        }
        Kn.setSource(0);
        Kn.aqO();
        ((l) g.af(l.class)).aSN().c(str, Kn);
        AppMethodBeat.o(42875);
    }

    public static int[] a(String[] strArr, String str, String str2, List<String> list, String str3) {
        AppMethodBeat.i(225938);
        long currentTimeMillis = System.currentTimeMillis();
        int[] b2 = ((l) g.af(l.class)).aSN().b(strArr, str, str2, str3, list);
        Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - currentTimeMillis));
        if (b2.length <= 0) {
            AppMethodBeat.o(225938);
            return null;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        int[] c2 = ((l) g.af(l.class)).aSN().c(strArr, str, str2, str3, list);
        Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - currentTimeMillis2));
        if (c2 == null) {
            AppMethodBeat.o(225938);
            return null;
        } else if (b2.length != c2.length) {
            Log.e("MicroMsg.ContactStorageLogic", "[%s:%s] filterType:%s filterSearchStr:%s blocklist:%s searchString:%s", Integer.valueOf(b2.length), Integer.valueOf(c2.length), str, str2, list, str3);
            AppMethodBeat.o(225938);
            return null;
        } else {
            int[] iArr = new int[c2.length];
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i4 < b2.length) {
                iArr[i2] = i3;
                i3 += c2[i4];
                i4++;
                i2++;
            }
            AppMethodBeat.o(225938);
            return iArr;
        }
    }

    public static int[] ap(List<String> list) {
        AppMethodBeat.i(42877);
        long currentTimeMillis = System.currentTimeMillis();
        int[] iV = ((l) g.af(l.class)).aSN().iV(list);
        Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - currentTimeMillis));
        if (iV.length <= 0) {
            AppMethodBeat.o(42877);
            return null;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        int[] iW = ((l) g.af(l.class)).aSN().iW(list);
        Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - currentTimeMillis2));
        if (iW == null) {
            AppMethodBeat.o(42877);
            return null;
        }
        Assert.assertTrue(iV.length == iW.length);
        int[] iArr = new int[iW.length];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < iV.length) {
            iArr[i4] = i3;
            i3 += iW[i2];
            i2++;
            i4++;
        }
        AppMethodBeat.o(42877);
        return iArr;
    }

    public static int[] a(String str, String str2, List<String> list, String[] strArr) {
        AppMethodBeat.i(42878);
        int[] b2 = ((l) g.af(l.class)).aSN().b(str, str2, strArr, list);
        if (b2.length <= 0) {
            AppMethodBeat.o(42878);
            return null;
        }
        int[] c2 = ((l) g.af(l.class)).aSN().c(str, str2, strArr, list);
        if (c2 == null) {
            AppMethodBeat.o(42878);
            return null;
        }
        Assert.assertTrue(b2.length == c2.length);
        int[] iArr = new int[c2.length];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < b2.length) {
            iArr[i4] = i3;
            i3 += c2[i2];
            i2++;
            i4++;
        }
        AppMethodBeat.o(42878);
        return iArr;
    }

    public static String[] a(String str, String str2, String[] strArr, List<String> list) {
        int i2 = 0;
        AppMethodBeat.i(42879);
        long currentTimeMillis = System.currentTimeMillis();
        int[] b2 = ((l) g.af(l.class)).aSN().b(str, str2, strArr, list);
        Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (b2.length <= 0) {
            AppMethodBeat.o(42879);
            return null;
        }
        String[] strArr2 = new String[b2.length];
        for (int i3 : b2) {
            char c2 = (char) i3;
            if (c2 == '{') {
                i2++;
                strArr2[i2] = "#";
            } else if (c2 == ' ') {
                i2++;
                strArr2[i2] = "$";
            } else {
                i2++;
                strArr2[i2] = String.valueOf(c2);
            }
        }
        AppMethodBeat.o(42879);
        return strArr2;
    }

    public static String[] a(String[] strArr, String str, String str2, String str3, List<String> list) {
        int i2;
        AppMethodBeat.i(225939);
        long currentTimeMillis = System.currentTimeMillis();
        int[] b2 = ((l) g.af(l.class)).aSN().b(strArr, str, str2, str3, list);
        Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (b2.length <= 0) {
            AppMethodBeat.o(225939);
            return null;
        }
        String[] strArr2 = new String[b2.length];
        int i3 = 0;
        int i4 = 0;
        while (i3 < b2.length) {
            char c2 = (char) b2[i3];
            if (c2 == '{') {
                i2 = i4 + 1;
                strArr2[i4] = "#";
            } else if (c2 == ' ') {
                i2 = i4 + 1;
                strArr2[i4] = "$";
            } else {
                i2 = i4 + 1;
                strArr2[i4] = String.valueOf(c2);
            }
            i3++;
            i4 = i2;
        }
        AppMethodBeat.o(225939);
        return strArr2;
    }

    public static String[] aq(List<String> list) {
        int i2 = 0;
        AppMethodBeat.i(42881);
        long currentTimeMillis = System.currentTimeMillis();
        int[] iV = ((l) g.af(l.class)).aSN().iV(list);
        Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (iV.length <= 0) {
            AppMethodBeat.o(42881);
            return null;
        }
        String[] strArr = new String[iV.length];
        for (int i3 : iV) {
            char c2 = (char) i3;
            if (c2 == '{') {
                i2++;
                strArr[i2] = "#";
            } else if (c2 == ' ') {
                i2++;
                strArr[i2] = "$";
            } else {
                i2++;
                strArr[i2] = String.valueOf(c2);
            }
        }
        AppMethodBeat.o(42881);
        return strArr;
    }

    public static boolean IW(String str) {
        AppMethodBeat.i(42882);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("qqmail");
            AppMethodBeat.o(42882);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42882);
        return false;
    }

    public static boolean IX(String str) {
        AppMethodBeat.i(42883);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("fmessage");
            AppMethodBeat.o(42883);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42883);
        return false;
    }

    public static boolean IY(String str) {
        AppMethodBeat.i(42884);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("tmessage");
            AppMethodBeat.o(42884);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42884);
        return false;
    }

    public static boolean IZ(String str) {
        AppMethodBeat.i(42885);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("floatbottle");
            AppMethodBeat.o(42885);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42885);
        return false;
    }

    public static boolean Ja(String str) {
        AppMethodBeat.i(42886);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("qmessage");
            AppMethodBeat.o(42886);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42886);
        return false;
    }

    public static boolean Jb(String str) {
        AppMethodBeat.i(42887);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("facebookapp");
            AppMethodBeat.o(42887);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42887);
        return false;
    }

    public static boolean Jc(String str) {
        AppMethodBeat.i(42888);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("masssendapp");
            AppMethodBeat.o(42888);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42888);
        return false;
    }

    public static boolean aUW() {
        return false;
    }

    public static boolean Jd(String str) {
        AppMethodBeat.i(42889);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("feedsapp");
            AppMethodBeat.o(42889);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42889);
        return false;
    }

    public static boolean Je(String str) {
        AppMethodBeat.i(42890);
        boolean equalsIgnoreCase = "qqsync".equalsIgnoreCase(str);
        AppMethodBeat.o(42890);
        return equalsIgnoreCase;
    }

    public static boolean Jf(String str) {
        AppMethodBeat.i(42891);
        if (str == null) {
            AppMethodBeat.o(42891);
            return false;
        } else if (str.equalsIgnoreCase("weixin") || str.equalsIgnoreCase("gh_9639b5a92773")) {
            AppMethodBeat.o(42891);
            return true;
        } else {
            AppMethodBeat.o(42891);
            return false;
        }
    }

    public static boolean Jg(String str) {
        AppMethodBeat.i(42892);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("lbsapp");
            AppMethodBeat.o(42892);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42892);
        return false;
    }

    public static boolean Jh(String str) {
        AppMethodBeat.i(42893);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("shakeapp");
            AppMethodBeat.o(42893);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42893);
        return false;
    }

    public static boolean Ji(String str) {
        AppMethodBeat.i(42894);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("medianote");
            AppMethodBeat.o(42894);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42894);
        return false;
    }

    public static boolean Jj(String str) {
        AppMethodBeat.i(42895);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("newsapp");
            AppMethodBeat.o(42895);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42895);
        return false;
    }

    public static boolean Jk(String str) {
        AppMethodBeat.i(42896);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("topstoryapp");
            AppMethodBeat.o(42896);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42896);
        return false;
    }

    public static boolean Jl(String str) {
        AppMethodBeat.i(42897);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("voipapp");
            AppMethodBeat.o(42897);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42897);
        return false;
    }

    public static boolean Jm(String str) {
        AppMethodBeat.i(42898);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("voicevoipapp");
            AppMethodBeat.o(42898);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42898);
        return false;
    }

    public static boolean Jn(String str) {
        AppMethodBeat.i(42899);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("voiceinputapp");
            AppMethodBeat.o(42899);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42899);
        return false;
    }

    public static boolean Jo(String str) {
        AppMethodBeat.i(42900);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("linkedinplugin");
            AppMethodBeat.o(42900);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42900);
        return false;
    }

    public static boolean Jp(String str) {
        AppMethodBeat.i(42901);
        boolean Jq = Jq(str);
        AppMethodBeat.o(42901);
        return Jq;
    }

    public static boolean Jq(String str) {
        AppMethodBeat.i(42902);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("gh_22b87fa7cb3c");
            AppMethodBeat.o(42902);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42902);
        return false;
    }

    public static boolean Jr(String str) {
        AppMethodBeat.i(42903);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("blogapp");
            AppMethodBeat.o(42903);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42903);
        return false;
    }

    public static boolean Js(String str) {
        AppMethodBeat.i(42904);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("officialaccounts");
            AppMethodBeat.o(42904);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42904);
        return false;
    }

    public static boolean Jt(String str) {
        AppMethodBeat.i(42905);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("helper_entry");
            AppMethodBeat.o(42905);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42905);
        return false;
    }

    public static boolean Ju(String str) {
        AppMethodBeat.i(42906);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("qqfriend");
            AppMethodBeat.o(42906);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42906);
        return false;
    }

    public static boolean Jv(String str) {
        AppMethodBeat.i(42907);
        boolean equalsIgnoreCase = "filehelper".equalsIgnoreCase(str);
        AppMethodBeat.o(42907);
        return equalsIgnoreCase;
    }

    public static boolean Jw(String str) {
        AppMethodBeat.i(42908);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("pc_share");
            AppMethodBeat.o(42908);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42908);
        return false;
    }

    public static boolean Jx(String str) {
        AppMethodBeat.i(42909);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("notifymessage");
            AppMethodBeat.o(42909);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42909);
        return false;
    }

    public static boolean Jy(String str) {
        AppMethodBeat.i(42910);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("notification_messages");
            AppMethodBeat.o(42910);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42910);
        return false;
    }

    public static boolean Jz(String str) {
        AppMethodBeat.i(42911);
        if (JA(str)) {
            AppMethodBeat.o(42911);
            return true;
        } else if (JE(str)) {
            AppMethodBeat.o(42911);
            return true;
        } else if (Js(str)) {
            AppMethodBeat.o(42911);
            return true;
        } else if (Jt(str)) {
            AppMethodBeat.o(42911);
            return true;
        } else {
            AppMethodBeat.o(42911);
            return false;
        }
    }

    public static boolean JA(String str) {
        AppMethodBeat.i(42912);
        g.aAi();
        String str2 = (String) g.aAh().azQ().get(21, (Object) null);
        if ((str2 == null || !str2.equalsIgnoreCase(str)) && !str.equalsIgnoreCase("weixin")) {
            AppMethodBeat.o(42912);
            return false;
        }
        AppMethodBeat.o(42912);
        return true;
    }

    public static boolean JB(String str) {
        AppMethodBeat.i(42913);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("appbrandcustomerservicemsg");
            AppMethodBeat.o(42913);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(42913);
        return false;
    }

    public static boolean JC(String str) {
        AppMethodBeat.i(225940);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("appbrand_notify_message");
            AppMethodBeat.o(225940);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(225940);
        return false;
    }

    public static boolean JD(String str) {
        AppMethodBeat.i(225941);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("findersayhisessionholder");
            AppMethodBeat.o(225941);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(225941);
        return false;
    }

    public static boolean JE(String str) {
        AppMethodBeat.i(42914);
        for (String str2 : iCO) {
            if (str2.equalsIgnoreCase(str)) {
                AppMethodBeat.o(42914);
                return true;
            }
        }
        AppMethodBeat.o(42914);
        return false;
    }

    public static boolean JF(String str) {
        AppMethodBeat.i(42915);
        if (JE(str)) {
            AppMethodBeat.o(42915);
            return true;
        } else if (as.bjo(str)) {
            AppMethodBeat.o(42915);
            return true;
        } else if (as.bjm(str)) {
            AppMethodBeat.o(42915);
            return true;
        } else if (as.IG(str)) {
            AppMethodBeat.o(42915);
            return true;
        } else {
            AppMethodBeat.o(42915);
            return false;
        }
    }

    public static int JG(String str) {
        AppMethodBeat.i(42916);
        Assert.assertTrue(Util.nullAsNil(str).length() > 0);
        String lowerCase = str.trim().toLowerCase();
        if (lowerCase.endsWith("@chatroom")) {
            AppMethodBeat.o(42916);
            return 1;
        } else if (as.bjm(lowerCase)) {
            AppMethodBeat.o(42916);
            return 11;
        } else if (as.bjo(lowerCase)) {
            AppMethodBeat.o(42916);
            return 36;
        } else if (as.IG(lowerCase)) {
            AppMethodBeat.o(42916);
            return 1;
        } else {
            AppMethodBeat.o(42916);
            return 1;
        }
    }

    public static int JH(String str) {
        AppMethodBeat.i(42917);
        Assert.assertTrue(Util.nullAsNil(str).length() > 0);
        String lowerCase = str.trim().toLowerCase();
        if (lowerCase.endsWith("@chatroom")) {
            AppMethodBeat.o(42917);
            return 3;
        } else if (as.bjm(lowerCase)) {
            AppMethodBeat.o(42917);
            return 13;
        } else if (as.bjo(lowerCase)) {
            AppMethodBeat.o(42917);
            return 39;
        } else if (as.IG(lowerCase)) {
            AppMethodBeat.o(42917);
            return 3;
        } else if (lowerCase.contains("@")) {
            AppMethodBeat.o(42917);
            return 3;
        } else {
            AppMethodBeat.o(42917);
            return 3;
        }
    }

    public static boolean JI(String str) {
        AppMethodBeat.i(42918);
        if (((l) g.af(l.class)).aSN().Kn(str).fuH != 1) {
            AppMethodBeat.o(42918);
            return false;
        }
        AppMethodBeat.o(42918);
        return true;
    }

    public static boolean JJ(String str) {
        AppMethodBeat.i(42919);
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn == null || !Kn.Zx()) {
            AppMethodBeat.o(42919);
            return false;
        }
        AppMethodBeat.o(42919);
        return true;
    }

    public static boolean JK(String str) {
        AppMethodBeat.i(42920);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(42920);
            return false;
        } else if (str.startsWith("t.qq.com/") || str.startsWith("http://t.qq.com/")) {
            AppMethodBeat.o(42920);
            return true;
        } else {
            AppMethodBeat.o(42920);
            return false;
        }
    }

    public static String JL(String str) {
        AppMethodBeat.i(42921);
        if (JK(str)) {
            String replace = str.replace("http://t.qq.com/", "").replace("t.qq.com/", "");
            AppMethodBeat.o(42921);
            return replace;
        }
        AppMethodBeat.o(42921);
        return "";
    }

    public static boolean aUX() {
        AppMethodBeat.i(42922);
        if (!z.aUM()) {
            AppMethodBeat.o(42922);
            return false;
        }
        ci aEY = ((l) g.af(l.class)).aSW().aEY("@t.qq.com");
        if (aEY == null || Util.isNullOrNil(aEY.name)) {
            AppMethodBeat.o(42922);
            return false;
        }
        AppMethodBeat.o(42922);
        return true;
    }

    public static boolean aUY() {
        AppMethodBeat.i(42923);
        if (!z.aUM()) {
            AppMethodBeat.o(42923);
            return false;
        }
        ci aEY = ((l) g.af(l.class)).aSW().aEY("@t.qq.com");
        if (aEY == null || Util.nullAsNil(aEY.name).length() == 0) {
            AppMethodBeat.o(42923);
            return false;
        }
        AppMethodBeat.o(42923);
        return true;
    }

    public static List<as> aUZ() {
        AppMethodBeat.i(42924);
        LinkedList linkedList = new LinkedList();
        Cursor gCd = ((l) g.af(l.class)).aSN().gCd();
        if (gCd.getCount() == 0) {
            gCd.close();
            AppMethodBeat.o(42924);
            return linkedList;
        }
        gCd.moveToFirst();
        do {
            as asVar = new as();
            asVar.convertFrom(gCd);
            linkedList.add(asVar);
        } while (gCd.moveToNext());
        gCd.close();
        Log.d("MicroMsg.ContactStorageLogic", "getFavourList size:  " + linkedList.size());
        AppMethodBeat.o(42924);
        return linkedList;
    }

    public static List<String> aVa() {
        AppMethodBeat.i(42925);
        LinkedList linkedList = new LinkedList();
        Cursor gCb = ((l) g.af(l.class)).aSN().gCb();
        if (gCb.getCount() == 0) {
            gCb.close();
            AppMethodBeat.o(42925);
            return linkedList;
        }
        gCb.moveToFirst();
        do {
            as asVar = new as();
            asVar.convertFrom(gCb);
            linkedList.add(asVar.field_username);
        } while (gCb.moveToNext());
        gCb.close();
        Log.d("MicroMsg.ContactStorageLogic", "getSnsBlackContactList size:  " + linkedList.size());
        AppMethodBeat.o(42925);
        return linkedList;
    }

    public static int aVb() {
        AppMethodBeat.i(42928);
        int c2 = ((l) g.af(l.class)).aSN().c(iCO, z.aTY(), "weixin", "helper_entry", "filehelper");
        AppMethodBeat.o(42928);
        return c2;
    }

    public static int aVc() {
        AppMethodBeat.i(225942);
        int gCn = ((l) g.af(l.class)).aSN().gCn();
        AppMethodBeat.o(225942);
        return gCn;
    }

    private static String b(String str, String[] strArr) {
        AppMethodBeat.i(42929);
        String str2 = " and ( 1 != 1 ";
        for (String str3 : strArr) {
            if ("@all.android".equals(str3)) {
                str2 = str2 + " or 1 = 1";
            } else if ("@micromsg.qq.com".equals(str3)) {
                str2 = str2 + " or " + str + " not like '%@%'";
            } else if ("@chatroom".equals(str3)) {
                str2 = str2 + " or " + str + " like '%@chatroom'";
            } else if ("@talkroom".equals(str3)) {
                str2 = str2 + " or " + str + " like '%@talkroom'";
            } else if ("@t.qq.com".equals(str3)) {
                str2 = str2 + " or " + str + " like '%@t.qq.com'";
            } else if ("@qqim".equals(str3)) {
                str2 = str2 + " or " + str + " like '%@qqim'";
            } else if ("@chatroom_exclusive".equals(str3)) {
                str2 = str2 + " or " + str + "not like %@chatroom";
            } else if ("@app".equals(str3)) {
                str2 = str2 + " or " + str + " like '%@app'";
            } else if ("@openim".equals(str3)) {
                str2 = str2 + " or " + str + " like '%@openim'";
            } else if ("@im.chatroom".equals(str3)) {
                str2 = str2 + " or " + str + " like '%@im.chatroom'";
            }
        }
        String str4 = str2 + " ) ";
        AppMethodBeat.o(42929);
        return str4;
    }

    public static boolean JM(String str) {
        AppMethodBeat.i(42930);
        if (str.equals("weixinsrc") || str.equalsIgnoreCase("gh_6e99ff560306")) {
            AppMethodBeat.o(42930);
            return true;
        }
        AppMethodBeat.o(42930);
        return false;
    }

    public static boolean JN(String str) {
        AppMethodBeat.i(178868);
        ah Kd = ((c) g.af(c.class)).aSX().Kd(str);
        if (Kd == null) {
            AppMethodBeat.o(178868);
            return false;
        }
        boolean amD = Kd.amD();
        AppMethodBeat.o(178868);
        return amD;
    }

    public static boolean JO(String str) {
        AppMethodBeat.i(184702);
        ah Kd = ((c) g.af(c.class)).aSX().Kd(str);
        if (Kd == null) {
            AppMethodBeat.o(184702);
            return false;
        }
        boolean JO = Kd.JO(z.aTY());
        AppMethodBeat.o(184702);
        return JO;
    }

    public static boolean J(as asVar) {
        return (asVar.field_weiboFlag & 1) != 0;
    }

    public static boolean a(az azVar) {
        AppMethodBeat.i(42926);
        String str = azVar.field_username;
        if (JE(str)) {
            AppMethodBeat.o(42926);
            return false;
        } else if (JA(str)) {
            AppMethodBeat.o(42926);
            return false;
        } else if (Js(str)) {
            AppMethodBeat.o(42926);
            return false;
        } else if (Jt(str)) {
            AppMethodBeat.o(42926);
            return false;
        } else if (azVar.field_conversationTime == -1) {
            AppMethodBeat.o(42926);
            return false;
        } else if (IT(str)) {
            AppMethodBeat.o(42926);
            return true;
        } else {
            AppMethodBeat.o(42926);
            return true;
        }
    }

    public static boolean b(az azVar) {
        AppMethodBeat.i(42927);
        String str = azVar.field_username;
        if (Js(str)) {
            AppMethodBeat.o(42927);
            return false;
        } else if (JB(str)) {
            AppMethodBeat.o(42927);
            return false;
        } else if (JC(str)) {
            AppMethodBeat.o(42927);
            return false;
        } else {
            AppMethodBeat.o(42927);
            return true;
        }
    }
}
