package com.tencent.mm.openim.room.a;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.room.a.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cvq;
import com.tencent.mm.protocal.protobuf.cvr;
import com.tencent.mm.protocal.protobuf.xg;
import com.tencent.mm.protocal.protobuf.xh;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import java.util.LinkedList;

public final class a {
    private static void a(cvq cvq) {
        int size;
        LinkedList<xh> aN;
        AppMethodBeat.i(151313);
        String str = cvq.jHa;
        com.tencent.mm.k.a.a.a aVar = new com.tencent.mm.k.a.a.a();
        aVar.maxCount = cvq.MBa.MBl;
        aVar.gCu = cvq.LYP;
        if (cvq.LYP != 0) {
            aVar.dTg = cvq.LYP;
        }
        nf nfVar = new nf();
        nfVar.dTf.chatroomName = str;
        nfVar.dTf.dTg = aVar.dTg;
        xg xgVar = new xg();
        if (cvq.LYQ == null) {
            size = 0;
        } else {
            size = cvq.LYQ.KHx.size();
        }
        xgVar.gsq = size;
        xgVar.Lip = z.Su(cvq.jHa);
        xgVar.Lio = cvq.LYQ.MBn;
        if (cvq.LYQ == null) {
            aN = new LinkedList<>();
        } else {
            aN = b.c.aN(cvq.LYQ.KHx);
        }
        xgVar.Lin = aN;
        ((com.tencent.mm.plugin.chatroom.a.b) g.af(com.tencent.mm.plugin.chatroom.a.b.class)).a(str, cvq.MBa.buA, xgVar, com.tencent.mm.model.z.aTY(), aVar, nfVar);
        AppMethodBeat.o(151313);
    }

    public static void a(cvq cvq, int i2, int i3) {
        boolean z;
        AppMethodBeat.i(223651);
        if (!cvq.jHa.toLowerCase().endsWith("@im.chatroom")) {
            Log.e("OpenIMChatRoomContactLogic", "updateChatroom: bad room:[" + cvq.jHa + "]");
            AppMethodBeat.o(223651);
            return;
        }
        a(cvq);
        ah Kd = ((c) g.af(c.class)).aSX().Kd(cvq.jHa);
        if (Kd == null) {
            Kd = new ah();
            Kd.field_chatroomname = cvq.jHa;
        }
        if (i2 != -1) {
            Kd.field_oldChatroomVersion = i2;
        }
        if (i3 != -1) {
            Kd.field_chatroomVersion = i3;
        }
        Kd.gBr().type = cvq.MBa.LGU;
        Kd.c(Kd.gBr());
        a(cvq.jHa, Kd, cvq.MBa);
        g.aAi();
        as Kn = ((l) g.af(l.class)).aSN().Kn(cvq.jHa);
        int i4 = Kn.field_type;
        Kn.BN(cvq.app_id);
        boolean z2 = cvq.MBa != null;
        if (!Util.isNullOrNil(cvq.MBa.dST)) {
            z = true;
        } else {
            z = false;
        }
        if (z2 && z) {
            Kn.setNickname(cvq.MBa.dST);
        }
        Kn.setUsername(cvq.jHa);
        Kn.nl(cvq.LDk);
        Kn.setType(cvq.MBd & cvq.zqk);
        Kn.nl(cvq.LDk);
        Kn.nm(cvq.MBc);
        Kn.yy(cvq.MBa.MBm);
        Log.i("OpenIMChatRoomContactLogic", "updateChatroom done %s, chatroom_business_type:%s ", Kn.field_username, Long.valueOf(cvq.MBa.MBm));
        g.aAi();
        ((l) g.af(l.class)).aSN().ao(Kn);
        if ((Kn.field_type & 2048) != 0) {
            if (Kn == null || (i4 & 2048) != (Kn.field_type & 2048)) {
                ((l) g.af(l.class)).aST().bke(Kn.field_username);
            }
        } else if (Kn == null || (i4 & 2048) != (Kn.field_type & 2048)) {
            ((l) g.af(l.class)).aST().bkf(Kn.field_username);
        }
        if (!Util.isNullOrNil(cvq.app_id)) {
            ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).s(cvq.app_id, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), "");
        }
        AppMethodBeat.o(223651);
    }

    private static void a(String str, ah ahVar, cvr cvr) {
        AppMethodBeat.i(151315);
        j aYB = p.aYB();
        if (!Util.isNullOrNil(str) && !Util.isNullOrNil(cvr.MBf)) {
            i Mx = aYB.Mx(str);
            if (Mx == null) {
                Mx = new i();
                Mx.username = str;
            }
            Mx.iKX = cvr.MBe;
            Mx.iKW = cvr.MBf;
            Mx.fuz = 3;
            Mx.fv(!Util.isNullOrNil(cvr.MBe));
            aYB.b(Mx);
            if (cvr.MBg == 2 && !com.tencent.mm.model.z.aTY().equals(str)) {
                p.aYn();
                e.N(str, false);
                p.aYn();
                e.N(str, true);
                p.aYD().Mg(str);
            }
        }
        ahVar.field_roomowner = cvr.buA;
        if (ahVar.field_chatroomnoticePublishTime <= ((long) cvr.MBk)) {
            ahVar.field_chatroomnotice = cvr.pWh;
            ahVar.field_chatroomnoticeEditor = cvr.MBj;
            ahVar.field_chatroomnoticePublishTime = (long) cvr.MBk;
        }
        ((c) g.af(c.class)).aSX().replace(ahVar);
        AppMethodBeat.o(151315);
    }

    public static boolean N(as asVar) {
        AppMethodBeat.i(151316);
        if (asVar == null) {
            AppMethodBeat.o(151316);
            return false;
        } else if (!as.bjp(asVar.field_username)) {
            AppMethodBeat.o(151316);
            return false;
        } else if (Util.isNullOrNil(asVar.field_openImAppid)) {
            AppMethodBeat.o(151316);
            return false;
        } else if ("3552365301".equals(asVar.field_openImAppid)) {
            AppMethodBeat.o(151316);
            return true;
        } else {
            AppMethodBeat.o(151316);
            return false;
        }
    }

    public static CharSequence a(as asVar, CharSequence charSequence) {
        AppMethodBeat.i(151317);
        String O = O(asVar);
        if (O == null) {
            AppMethodBeat.o(151317);
            return charSequence;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) O);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(MMApplicationContext.getContext().getResources().getColor(R.color.a3_)), length, spannableStringBuilder.length(), 33);
        AppMethodBeat.o(151317);
        return spannableStringBuilder;
    }

    public static String O(as asVar) {
        AppMethodBeat.i(151318);
        if (asVar == null) {
            AppMethodBeat.o(151318);
            return null;
        } else if (!as.bjp(asVar.field_username)) {
            AppMethodBeat.o(151318);
            return null;
        } else if (Util.isNullOrNil(asVar.field_openImAppid)) {
            AppMethodBeat.o(151318);
            return null;
        } else {
            String bN = ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).bN(asVar.field_openImAppid, asVar.field_descWordingId);
            if (Util.isNullOrNil(bN)) {
                AppMethodBeat.o(151318);
                return null;
            }
            String concat = "＠".concat(String.valueOf(bN));
            AppMethodBeat.o(151318);
            return concat;
        }
    }

    public static boolean bkC() {
        AppMethodBeat.i(184257);
        if (com.tencent.mm.plugin.appbrand.ac.b.getPackageInfo(MMApplicationContext.getContext(), "com.tencent.wework") != null) {
            AppMethodBeat.o(184257);
            return true;
        }
        AppMethodBeat.o(184257);
        return false;
    }
}
