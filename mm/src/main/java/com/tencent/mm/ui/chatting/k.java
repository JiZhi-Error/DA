package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.v;
import com.tencent.mm.ag.z;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.av.e;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.i.a;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class k {
    public static boolean bh(ca caVar) {
        EmojiInfo aml;
        boolean z;
        k.b bVar;
        AppMethodBeat.i(34397);
        if (caVar == null) {
            Log.w("MicroMsg.ChattingEditModeLogic", "check is store emoji error, msg is null");
            AppMethodBeat.o(34397);
            return true;
        }
        if (caVar.gDo()) {
            be beVar = new be(caVar.field_content);
            k.b aD = k.b.aD(caVar.field_content, caVar.field_reserved);
            if (aD == null) {
                k.b bVar2 = new k.b();
                bVar2.iwK = beVar.md5;
                bVar = bVar2;
            } else {
                bVar = aD;
            }
            aml = ((d) g.ah(d.class)).getEmojiMgr().aml(bVar.iwK);
        } else {
            aml = ((d) g.ah(d.class)).getEmojiMgr().aml(caVar.field_imgPath);
        }
        if (aml == null || (aml.field_catalog != EmojiInfo.VkW && (Util.isNullOrNil(aml.field_groupId) || !((d) g.ah(d.class)).getEmojiMgr().amq(aml.field_groupId)))) {
            if (aml != null) {
                if (!Util.isNullOrNil(aml.field_app_id) || Util.isNullOrNil(aml.field_groupId) || aml.field_groupId.equals(String.valueOf(EmojiGroupInfo.VkO)) || aml.field_groupId.equals(String.valueOf(EmojiGroupInfo.VkN)) || aml.field_groupId.equals(String.valueOf(EmojiGroupInfo.VkP)) || aml.field_groupId.equals(String.valueOf(EmojiInfo.VkQ)) || aml.field_groupId.equals("capture")) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    AppMethodBeat.o(34397);
                    return true;
                }
            }
            AppMethodBeat.o(34397);
            return false;
        }
        AppMethodBeat.o(34397);
        return false;
    }

    public static boolean bi(ca caVar) {
        k.b bVar;
        AppMethodBeat.i(34398);
        if (caVar.gDo()) {
            be beVar = new be(caVar.field_content);
            k.b aD = k.b.aD(caVar.field_content, caVar.field_reserved);
            if (aD == null) {
                k.b bVar2 = new k.b();
                bVar2.iwK = beVar.md5;
                bVar = bVar2;
            } else {
                bVar = aD;
            }
            if (((d) g.ah(d.class)).getEmojiMgr().aml(bVar.iwK) == null) {
                AppMethodBeat.o(34398);
                return false;
            }
        }
        AppMethodBeat.o(34398);
        return true;
    }

    public static boolean bj(ca caVar) {
        String str;
        AppMethodBeat.i(34399);
        if (caVar == null) {
            Log.w("MicroMsg.ChattingEditModeLogic", "check is game msg error, msg is null");
            AppMethodBeat.o(34399);
            return true;
        }
        if (caVar.field_isSend == 0) {
            str = bp.Kt(caVar.field_content);
        } else {
            str = caVar.field_content;
        }
        k.b HD = k.b.HD(str);
        if (HD == null) {
            Log.w("MicroMsg.ChattingEditModeLogic", "parse app message content fail");
            AppMethodBeat.o(34399);
            return false;
        }
        com.tencent.mm.pluginsdk.model.app.g o = h.o(HD.appId, false, false);
        if (o == null || !o.NA()) {
            AppMethodBeat.o(34399);
            return false;
        }
        AppMethodBeat.o(34399);
        return true;
    }

    public static boolean bk(ca caVar) {
        AppMethodBeat.i(34400);
        if (caVar.getType() == 419430449) {
            AppMethodBeat.o(34400);
            return true;
        }
        AppMethodBeat.o(34400);
        return false;
    }

    public static boolean bl(ca caVar) {
        AppMethodBeat.i(34401);
        if (caVar.getType() == 436207665 || caVar.getType() == 469762097) {
            AppMethodBeat.o(34401);
            return true;
        }
        AppMethodBeat.o(34401);
        return false;
    }

    public static boolean bm(ca caVar) {
        String str;
        AppMethodBeat.i(34402);
        if (caVar == null) {
            Log.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, check msg error, msg is null");
            AppMethodBeat.o(34402);
            return true;
        }
        if (caVar.field_isSend == 0) {
            str = bp.Kt(caVar.field_content);
        } else {
            str = caVar.field_content;
        }
        k.b HD = k.b.HD(str);
        if (HD == null) {
            Log.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, parse app message content fail");
            AppMethodBeat.o(34402);
            return false;
        } else if (HD.izr != 0 || ((HD.type == 33 && HD.izk == 3) || ((HD.type == 36 && HD.izk == 3) || ((HD.type == 46 && HD.izk == 3) || ((HD.type == 44 && (HD.izk == 3 || !HD.fn(false))) || (HD.type == 48 && HD.izk == 3)))))) {
            AppMethodBeat.o(34402);
            return true;
        } else {
            AppMethodBeat.o(34402);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean jg(java.util.List<com.tencent.mm.storage.ca> r6) {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.k.jg(java.util.List):boolean");
    }

    public static boolean a(boolean z, List<ca> list, String str, z zVar) {
        boolean z2;
        boolean z3;
        AppMethodBeat.i(34404);
        if (list == null || list.isEmpty()) {
            Log.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
            AppMethodBeat.o(34404);
            return false;
        } else if (list.size() != 1 || ((zVar == null || !zVar.aSC()) && !z)) {
            Iterator<ca> it = list.iterator();
            boolean z4 = true;
            while (it.hasNext()) {
                ca next = it.next();
                if ((zVar == null || !zVar.aSC()) && !z) {
                    if (bn(next) || bo(next) || next.getType() == 788529201 || next.getType() == 889192497 || next.getType() == 922746929) {
                        it.remove();
                        z3 = false;
                    } else {
                        z3 = z4;
                    }
                    z4 = z3;
                } else {
                    boolean z5 = ((b) g.af(b.class)).a(b.a.clicfg_forward_card, 0) == 1;
                    if (next.gAy() || bh(next) || bj(next) || bk(next) || next.getType() == -1879048186 || ((next.getType() == 486539313 && z) || br(next) || bl(next) || ((bn(next) && (zVar == null || !zVar.aSC())) || ((bo(next) && (zVar == null || !zVar.aSC())) || next.getType() == 318767153 || ((bu(next) && (!z5 || bs(next) || g(next, str))) || bv(next) || bq(next) || bm(next) || f(next, z) || next.getType() == 788529201 || next.getType() == 889192497 || next.getType() == 922746929 || next.getType() == 536936497))))) {
                        it.remove();
                        z2 = false;
                    } else {
                        z2 = z4;
                    }
                    z4 = z2;
                }
            }
            AppMethodBeat.o(34404);
            return z4;
        } else {
            ca caVar = list.get(0);
            boolean z6 = ((b) g.af(b.class)).a(b.a.clicfg_forward_card, 0) == 1;
            if ((!bu(caVar) || (z6 && !bs(caVar) && !g(caVar, str))) && !caVar.gAy() && !bh(caVar) && !bj(caVar) && !bk(caVar) && caVar.getType() != -1879048186 && caVar.getType() != 318767153 && ((caVar.getType() != 486539313 || !z) && !br(caVar) && !bl(caVar) && !bv(caVar) && !bq(caVar) && !bm(caVar) && !f(caVar, z) && caVar.getType() != 788529201 && caVar.getType() != 889192497 && caVar.getType() != 922746929)) {
                AppMethodBeat.o(34404);
                return true;
            }
            AppMethodBeat.o(34404);
            return false;
        }
    }

    private static boolean bn(ca caVar) {
        k.b HD;
        AppMethodBeat.i(34405);
        if (caVar == null || (HD = k.b.HD(caVar.field_content)) == null || HD.type != 19) {
            AppMethodBeat.o(34405);
            return false;
        }
        rc rcVar = new rc();
        rcVar.dXF.type = 0;
        rcVar.dXF.dXH = HD.ixl;
        EventCenter.instance.publish(rcVar);
        c cVar = rcVar.dXG.dXP;
        if (cVar != null) {
            Iterator<aml> it = cVar.iAd.iterator();
            while (it.hasNext()) {
                aml next = it.next();
                if (!Util.isNullOrNil(next.LwF)) {
                    Log.e("MicroMsg.ChattingEditModeLogic", "record type subDataItem contain tpurl, type:%d", Integer.valueOf(next.dataType));
                    AppMethodBeat.o(34405);
                    return true;
                }
            }
        }
        if (HD.ixl == null || !HD.ixl.contains("<recordxml>")) {
            AppMethodBeat.o(34405);
            return false;
        }
        AppMethodBeat.o(34405);
        return true;
    }

    private static boolean bo(ca caVar) {
        k.b HD;
        AppMethodBeat.i(34406);
        if (caVar == null || (HD = k.b.HD(caVar.field_content)) == null || HD.type != 24) {
            AppMethodBeat.o(34406);
            return false;
        }
        AppMethodBeat.o(34406);
        return true;
    }

    public static boolean bp(ca caVar) {
        AppMethodBeat.i(34407);
        if (caVar != null) {
            k.b HD = k.b.HD(caVar.field_content);
            if (HD == null) {
                AppMethodBeat.o(34407);
                return false;
            } else if (HD.type == 6 || HD.type == 5 || HD.type == 19) {
                AppMethodBeat.o(34407);
                return true;
            }
        }
        AppMethodBeat.o(34407);
        return false;
    }

    public static boolean bq(ca caVar) {
        AppMethodBeat.i(34408);
        if (caVar == null || !caVar.gAt()) {
            AppMethodBeat.o(34408);
            return false;
        }
        boolean c2 = m.c(caVar.field_msgId, caVar.field_content);
        AppMethodBeat.o(34408);
        return c2;
    }

    static boolean br(ca caVar) {
        AppMethodBeat.i(34409);
        if (caVar != null) {
            k.b HD = k.b.HD(caVar.field_content);
            if (HD != null && HD.type == 16) {
                AppMethodBeat.o(34409);
                return true;
            } else if (HD != null && HD.type == 34) {
                AppMethodBeat.o(34409);
                return true;
            }
        }
        AppMethodBeat.o(34409);
        return false;
    }

    private static boolean f(ca caVar, boolean z) {
        k.b HD;
        AppMethodBeat.i(34410);
        if (!z) {
            AppMethodBeat.o(34410);
            return false;
        } else if (caVar == null || (HD = k.b.HD(caVar.field_content)) == null || HD.type != 33 || HD.izk != 1) {
            AppMethodBeat.o(34410);
            return false;
        } else {
            AppMethodBeat.o(34410);
            return true;
        }
    }

    private static boolean g(ca caVar, String str) {
        boolean z;
        AppMethodBeat.i(34411);
        bg.aVF();
        ca.a aEK = com.tencent.mm.model.c.aSQ().aEK(caVar.field_content);
        if (aEK.dkU == null || aEK.dkU.length() <= 0) {
            Log.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
            AppMethodBeat.o(34411);
            return false;
        }
        if (((b) g.af(b.class)).a(b.a.clicfg_forward_card, 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        if (!z || (!as.bjp(str) && !as.bjq(str) && caVar.getType() != 66)) {
            AppMethodBeat.o(34411);
            return false;
        }
        AppMethodBeat.o(34411);
        return true;
    }

    public static boolean bs(ca caVar) {
        AppMethodBeat.i(34412);
        bg.aVF();
        ca.a aEK = com.tencent.mm.model.c.aSQ().aEK(caVar.field_content);
        if (aEK.dkU == null || aEK.dkU.length() <= 0) {
            Log.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
        }
        if (ab.rR(aEK.IOs) || caVar.getType() != 42) {
            AppMethodBeat.o(34412);
            return false;
        }
        boolean gDD = caVar.gDD();
        AppMethodBeat.o(34412);
        return gDD;
    }

    public static boolean bt(ca caVar) {
        AppMethodBeat.i(34413);
        bg.aVF();
        ca.a aEK = com.tencent.mm.model.c.aSQ().aEK(caVar.field_content);
        if (aEK.dkU == null || aEK.dkU.length() <= 0) {
            Log.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
        }
        if (ab.rR(aEK.IOs) || caVar.getType() != 42) {
            AppMethodBeat.o(34413);
            return false;
        } else if ((caVar.fqJ & 2048) > 0) {
            AppMethodBeat.o(34413);
            return true;
        } else {
            AppMethodBeat.o(34413);
            return false;
        }
    }

    static boolean bu(ca caVar) {
        AppMethodBeat.i(34414);
        if (!caVar.gDl()) {
            AppMethodBeat.o(34414);
            return false;
        }
        bg.aVF();
        ca.a aEK = com.tencent.mm.model.c.aSQ().aEK(caVar.field_content);
        if (aEK == null || Util.isNullOrNil(aEK.dkU)) {
            AppMethodBeat.o(34414);
            return true;
        } else if (ab.IT(aEK.dkU)) {
            AppMethodBeat.o(34414);
            return false;
        } else {
            AppMethodBeat.o(34414);
            return true;
        }
    }

    private static boolean bv(ca caVar) {
        k.b HD;
        AppMethodBeat.i(232858);
        if (caVar == null || !caVar.dOQ() || (HD = k.b.HD(caVar.field_content)) == null || HD.type != 6 || HD.iwI < 1073741824) {
            AppMethodBeat.o(232858);
            return false;
        }
        AppMethodBeat.o(232858);
        return true;
    }

    public static boolean bw(ca caVar) {
        k.b HD;
        AppMethodBeat.i(34416);
        if (caVar == null || !caVar.dOQ() || (HD = k.b.HD(caVar.field_content)) == null || HD.type != 6) {
            AppMethodBeat.o(34416);
            return false;
        }
        AppMethodBeat.o(34416);
        return true;
    }

    public static int jh(List<ca> list) {
        int i2 = 0;
        AppMethodBeat.i(34417);
        if (list == null) {
            Log.w("MicroMsg.ChattingEditModeLogic", "get invalid send to friend msg num error, select item empty");
            AppMethodBeat.o(34417);
            return 0;
        }
        for (ca caVar : list) {
            if (caVar.gAy() || bh(caVar) || caVar.dOS() || bj(caVar) || bk(caVar) || bl(caVar)) {
                i2++;
            } else {
                i2 = i2;
            }
        }
        AppMethodBeat.o(34417);
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0020, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean ji(java.util.List<com.tencent.mm.storage.ca> r12) {
        /*
        // Method dump skipped, instructions count: 276
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.k.ji(java.util.List):boolean");
    }

    public static boolean jj(List<ca> list) {
        AppMethodBeat.i(34419);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(34419);
            return false;
        }
        for (ca caVar : list) {
            if (caVar.cWJ() && com.tencent.mm.pluginsdk.model.m.bdr(caVar.field_imgPath)) {
                AppMethodBeat.o(34419);
                return true;
            }
        }
        AppMethodBeat.o(34419);
        return false;
    }

    public static boolean jk(List<ca> list) {
        AppMethodBeat.i(34420);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(34420);
            return false;
        }
        for (ca caVar : list) {
            if (caVar.cWL()) {
                AppMethodBeat.o(34420);
                return true;
            }
        }
        AppMethodBeat.o(34420);
        return false;
    }

    public static String A(String str, int i2, boolean z) {
        AppMethodBeat.i(34421);
        if (z && str != null && i2 == 0) {
            str = bp.Kt(str);
        }
        AppMethodBeat.o(34421);
        return str;
    }

    public static List<String> gNu() {
        AppMethodBeat.i(34422);
        List<String> sN = ag.bah().sN(25);
        f bah = ag.bah();
        ArrayList<String> arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        f.a(sb);
        f.c(sb);
        f.d(sb);
        f.a(sb, true);
        sb.append(" order by ");
        sb.append(f.aZD());
        String sb2 = sb.toString();
        Log.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatLst sql %s", sb2);
        Cursor rawQuery = bah.rawQuery(sb2, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    arrayList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        HashMap hashMap = new HashMap();
        for (String str : arrayList) {
            String UN = com.tencent.mm.al.g.fJ(str).UN();
            if (!Util.isNullOrNil(UN)) {
                hashMap.put(UN, str);
            }
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (String str2 : sN) {
            if (!com.tencent.mm.al.g.Ne(str2)) {
                linkedList.add(str2);
            } else if (com.tencent.mm.al.g.Ni(str2)) {
                String str3 = com.tencent.mm.al.g.fJ(str2).field_enterpriseFather;
                if (!linkedList2.contains(str3) && com.tencent.mm.al.g.Ng(str3)) {
                    linkedList2.add(str3);
                    String str4 = (String) hashMap.get(str3);
                    if (!Util.isNullOrNil(str4)) {
                        linkedList2.add(str4);
                    }
                }
            }
        }
        for (String str5 : hashMap.values()) {
            if (!Util.isNullOrNil(str5) && !linkedList2.contains(str5)) {
                linkedList2.add(str5);
            }
        }
        linkedList.addAll(linkedList2);
        Log.d("MicroMsg.ChattingEditModeLogic", "get selected accept list, size %d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(34422);
        return linkedList;
    }

    public static List<String> gNv() {
        AppMethodBeat.i(34423);
        List<String> sN = ag.bah().sN(25);
        LinkedList linkedList = new LinkedList();
        for (String str : sN) {
            if (!com.tencent.mm.al.g.Ne(str)) {
                linkedList.add(str);
            }
        }
        Log.d("MicroMsg.ChattingEditModeLogic", "get selected accept list without enterprise, size %d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(34423);
        return linkedList;
    }

    public static void a(String str, String str2, int i2, int i3, String str3, int i4, long j2) {
        AppMethodBeat.i(163284);
        Log.d("MicroMsg.ChattingEditModeLogic", "copy video fileName %s userName %s export %d videoLength %d", str, str2, Integer.valueOf(i2), Integer.valueOf(i3));
        String Qv = t.Qv(str2);
        o.bhj();
        String Qw = t.Qw(str);
        String Qw2 = t.Qw(Qv);
        String Qx = t.Qx(str);
        String Qx2 = t.Qx(Qv);
        Log.d("MicroMsg.ChattingEditModeLogic", "copy video: srcFullPath[%s] destFullPath[%s] srcThumbPath[%s] destThumbPath[%s]", Qw, Qw2, Qx, Qx2);
        s.nw(Qw, Qw2);
        s.nw(Qx, Qx2);
        u.a(Qv, i3, str2, null, i2, str3, i4, (int) j2);
        u.QG(Qv);
        AppMethodBeat.o(163284);
    }

    static boolean a(Context context, String str, ca caVar, String str2) {
        AppMethodBeat.i(34425);
        if (context == null) {
            Log.w("MicroMsg.ChattingEditModeLogic", "send %s fail, context is null", str2);
            AppMethodBeat.o(34425);
            return false;
        } else if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.ChattingEditModeLogic", "send %s fail, username is null", str2);
            AppMethodBeat.o(34425);
            return false;
        } else if (caVar == null) {
            Log.w("MicroMsg.ChattingEditModeLogic", "send %s fail, msg is null", str2);
            AppMethodBeat.o(34425);
            return false;
        } else {
            AppMethodBeat.o(34425);
            return true;
        }
    }

    public static void a(Context context, String str, ca caVar) {
        String str2;
        AppMethodBeat.i(34426);
        if (!a(context, str, caVar, "emoji")) {
            AppMethodBeat.o(34426);
            return;
        }
        String str3 = be.bkr(caVar.field_content).md5;
        if (str3 == null || str3.endsWith("-1")) {
            str2 = caVar.field_imgPath;
        } else {
            str2 = str3;
        }
        if (str2 == null) {
            Log.w("MicroMsg.ChattingEditModeLogic", "showAcceptEmojiConnector: filePath is null");
            AppMethodBeat.o(34426);
            return;
        }
        ((d) g.ah(d.class)).getEmojiMgr().u(context, str, str2);
        AppMethodBeat.o(34426);
    }

    public static void b(final Context context, final String str, final ca caVar) {
        final int i2;
        String str2;
        boolean z;
        AppMethodBeat.i(34427);
        if (!a(context, str, caVar, "image")) {
            AppMethodBeat.o(34427);
            return;
        }
        final com.tencent.mm.av.g gVar = null;
        if (caVar.field_msgId > 0) {
            gVar = q.bcR().H(caVar.field_talker, caVar.field_msgId);
        }
        if ((gVar == null || gVar.localId <= 0) && caVar.field_msgSvrId > 0) {
            gVar = q.bcR().G(caVar.field_talker, caVar.field_msgSvrId);
        }
        if (gVar == null) {
            AppMethodBeat.o(34427);
            return;
        }
        int i3 = 0;
        if (gVar.bcv() && !com.tencent.mm.av.h.a(gVar).iXm.startsWith("SERVERID://")) {
            i3 = 1;
        }
        String o = q.bcR().o(com.tencent.mm.av.h.c(gVar), "", "");
        String o2 = q.bcR().o(gVar.iXo, "th_", "");
        if (gVar.offset < gVar.iKP || gVar.iKP == 0) {
            final String aTY = com.tencent.mm.model.z.aTY();
            final String str3 = gVar.iXy;
            Map<String, String> parseXml = XmlParser.parseXml(gVar.iXy, "msg", null);
            if (parseXml == null) {
                Log.e("MicroMsg.ChattingEditModeLogic", "parse cdnInfo failed. [%s]", gVar.iXy);
                z = false;
            } else {
                final int i4 = gVar.iXp;
                if (i4 != 1) {
                    i2 = 2;
                    str2 = parseXml.get(".msg.img.$cdnmidimgurl");
                } else {
                    i2 = 1;
                    str2 = parseXml.get(".msg.img.$cdnbigimgurl");
                }
                Log.d("MicroMsg.ChattingEditModeLogic", "cdntra read xml  comptype:%d url:[%s]", Integer.valueOf(i4), str2);
                if (Util.isNullOrNil(str2)) {
                    Log.e("MicroMsg.ChattingEditModeLogic", "cdntra get cdnUrlfailed.");
                    z = false;
                } else {
                    String str4 = parseXml.get(".msg.img.$aeskey");
                    if (Util.isNullOrNil(str4)) {
                        Log.e("MicroMsg.ChattingEditModeLogic", "cdntra get aes key failed.");
                        z = false;
                    } else if (Util.isNullOrNil(com.tencent.mm.an.c.a("downimg", (long) gVar.iXu, caVar.field_talker, new StringBuilder().append(caVar.field_msgId).toString()))) {
                        Log.w("MicroMsg.ChattingEditModeLogic", "cdntra genClientId failed not use cdn imgLocalId:%d", Long.valueOf(caVar.field_msgSvrId));
                        z = false;
                    } else {
                        final String str5 = parseXml.get(".msg.img.$md5");
                        com.tencent.mm.i.g gVar2 = new com.tencent.mm.i.g();
                        gVar2.taskName = "task_ChattingEditModeLogic_1";
                        gVar2.gqy = new g.a() {
                            /* class com.tencent.mm.ui.chatting.k.AnonymousClass1 */
                            final /* synthetic */ int psA = 4;

                            /* JADX WARNING: Removed duplicated region for block: B:17:0x01a3  */
                            /* JADX WARNING: Removed duplicated region for block: B:23:0x02be  */
                            @Override // com.tencent.mm.i.g.a
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final int a(java.lang.String r29, int r30, com.tencent.mm.i.c r31, com.tencent.mm.i.d r32, boolean r33) {
                                /*
                                // Method dump skipped, instructions count: 713
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.k.AnonymousClass1.a(java.lang.String, int, com.tencent.mm.i.c, com.tencent.mm.i.d, boolean):int");
                            }

                            @Override // com.tencent.mm.i.g.a
                            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                            }

                            @Override // com.tencent.mm.i.g.a
                            public final byte[] f(String str, byte[] bArr) {
                                return new byte[0];
                            }
                        };
                        gVar2.field_mediaId = com.tencent.mm.an.c.a("checkExist", Util.nowMilliSecond(), str, new StringBuilder().append(caVar.field_msgId).toString());
                        gVar2.field_fileId = str2;
                        gVar2.field_aesKey = str4;
                        gVar2.field_filemd5 = str5;
                        gVar2.field_fileType = i2;
                        gVar2.field_talker = str;
                        gVar2.field_priority = a.gpM;
                        gVar2.field_svr_signature = "";
                        gVar2.field_onlycheckexist = true;
                        gVar2.field_trysafecdn = true;
                        if (!com.tencent.mm.an.f.baQ().f(gVar2)) {
                            Log.e("MicroMsg.ChattingEditModeLogic", "check exist fail! download img before retransmit");
                            z = false;
                        } else {
                            z = true;
                        }
                    }
                }
            }
            if (!z) {
                a(context, gVar, caVar, 4, str, o2);
            }
            AppMethodBeat.o(34427);
            return;
        }
        if (!Util.isNullOrNil(o)) {
            com.tencent.mm.plugin.messenger.a.g.eir().a(context, str, o, i3, gVar.iXy, o2, caVar.field_msgId, (String) null);
        }
        AppMethodBeat.o(34427);
    }

    static void a(final Context context, final com.tencent.mm.av.g gVar, ca caVar, int i2, final String str, final String str2) {
        AppMethodBeat.i(34428);
        String o = q.bcR().o(com.tencent.mm.av.h.c(gVar), "", "");
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        pString.value = o;
        int i3 = gVar.iXp;
        long a2 = q.bcR().a(caVar.field_talker, o, i3, i2, pString, pInt, pInt2);
        com.tencent.mm.av.g c2 = q.bcR().c(Long.valueOf(a2));
        c2.tj(1);
        ca caVar2 = new ca();
        caVar2.setType(ab.JH(str));
        caVar2.Cy(str);
        caVar2.nv(1);
        caVar2.setStatus(1);
        caVar2.Cz(pString.value);
        caVar2.nG(pInt.value);
        caVar2.nH(pInt2.value);
        caVar2.setCreateTime(bp.Kw(caVar2.field_talker));
        if (com.tencent.mm.al.g.DQ(caVar2.field_talker)) {
            caVar.BB(e.ajw());
        }
        bg.aVF();
        long aC = com.tencent.mm.model.c.aSQ().aC(caVar2);
        Assert.assertTrue(aC >= 0);
        Log.i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(aC)));
        c2.Aw((long) ((int) aC));
        q.bcR().a(Long.valueOf(a2), c2);
        HashMap hashMap = new HashMap();
        hashMap.put(Long.valueOf(aC), gVar);
        q.bcS().a(gVar.localId, caVar.field_msgId, i3, hashMap, R.drawable.c3h, new e.a() {
            /* class com.tencent.mm.ui.chatting.k.AnonymousClass3 */

            @Override // com.tencent.mm.av.e.a
            public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, com.tencent.mm.ak.q qVar) {
            }

            @Override // com.tencent.mm.av.e.a
            public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, String str, com.tencent.mm.ak.q qVar) {
                HashMap hashMap;
                AppMethodBeat.i(34392);
                boolean z = i4 == 0 && i5 == 0;
                if ((obj instanceof HashMap) && (hashMap = (HashMap) obj) != null) {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        Long l = (Long) entry.getKey();
                        String o = q.bcR().o(com.tencent.mm.av.h.c((com.tencent.mm.av.g) entry.getValue()), "", "");
                        if (z) {
                            bg.aVF();
                            com.tencent.mm.model.c.aSQ().Hc(l.longValue());
                            com.tencent.mm.plugin.messenger.a.g.eir().a(context, str, o, i2, gVar.iXy, str2, j3, (String) null);
                        }
                    }
                }
                AppMethodBeat.o(34392);
            }

            @Override // com.tencent.mm.av.e.a
            public final void a(long j2, long j3, int i2, int i3, Object obj) {
            }
        });
        AppMethodBeat.o(34428);
    }

    static void f(final String str, final ca caVar) {
        AppMethodBeat.i(34429);
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.ui.chatting.k.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(34396);
                o.bho().a(caVar.field_imgPath, new t.a() {
                    /* class com.tencent.mm.ui.chatting.k.AnonymousClass5.AnonymousClass1 */

                    @Override // com.tencent.mm.modelvideo.t.a
                    public final void a(t.a.C0460a aVar) {
                        AppMethodBeat.i(34395);
                        com.tencent.mm.modelvideo.s QN = u.QN(aVar.fileName);
                        if (QN != null && QN.status == 199) {
                            k.a(caVar.field_imgPath, str, QN.jsr, QN.iFw, QN.bhv(), caVar.getType(), caVar.field_msgId);
                        }
                        AppMethodBeat.o(34395);
                    }
                });
                AppMethodBeat.o(34396);
            }
        });
        AppMethodBeat.o(34429);
    }

    public static void c(Context context, final String str, final ca caVar) {
        boolean z;
        AppMethodBeat.i(34430);
        if (!a(context, str, caVar, "video") || caVar == null) {
            AppMethodBeat.o(34430);
        } else if (caVar == null || !caVar.cWL() || !u.QO(caVar.field_imgPath)) {
            com.tencent.mm.modelvideo.s QN = u.QN(caVar.field_imgPath);
            if (QN == null || QN.status != 199) {
                Map<String, String> parseXml = XmlParser.parseXml(QN.bhv(), "msg", null);
                if (parseXml == null) {
                    Log.w("MicroMsg.ChattingEditModeLogic", "%s cdntra parse video recv xml failed");
                    z = false;
                } else {
                    final String str2 = parseXml.get(".msg.videomsg.$cdnvideourl");
                    if (Util.isNullOrNil(str2)) {
                        z = false;
                    } else {
                        final String str3 = parseXml.get(".msg.videomsg.$aeskey");
                        final String str4 = parseXml.get(".msg.videomsg.$md5");
                        final String str5 = parseXml.get(".msg.videomsg.$newmd5");
                        final int i2 = Util.getInt(parseXml.get(".msg.videomsg.$length"), 0);
                        final int i3 = Util.getInt(parseXml.get(".msg.videomsg.$playlength"), 0);
                        final int i4 = Util.getInt(parseXml.get(".msg.videomsg.$cdnthumblength"), 0);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1328, 12, 1, true);
                        if (Util.isNullOrNil(str4)) {
                            o.bhj();
                            if (!s.YS(t.Qw(QN.getFileName()))) {
                                Log.i("MicroMsg.ChattingEditModeLogic", "checkVideoCdnInfo md5 %s", str4);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1328, 2, 1, true);
                                z = false;
                            }
                        }
                        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                        gVar.taskName = "task_ChattingEditModeLogic_2";
                        gVar.gqy = new g.a() {
                            /* class com.tencent.mm.ui.chatting.k.AnonymousClass4 */

                            @Override // com.tencent.mm.i.g.a
                            public final int a(String str, int i2, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                                AppMethodBeat.i(34394);
                                if (dVar != null) {
                                    if (dVar.field_exist_whencheck) {
                                        dVar.field_fileId = str2;
                                        dVar.field_aesKey = str3;
                                        dVar.field_thumbimgLength = i4;
                                        dVar.field_fileLength = (long) i2;
                                        dVar.field_toUser = str;
                                        dVar.field_filemd5 = str4;
                                        dVar.field_mp4identifymd5 = str5;
                                        Log.i("MicroMsg.ChattingEditModeLogic", "support second!! sceneResult: %s", dVar);
                                        final String Qv = t.Qv(str);
                                        o.bhj();
                                        String Qx = t.Qx(Qv);
                                        o.bhj();
                                        s.nw(t.Qx(caVar.field_imgPath), Qx);
                                        String str2 = ((("<msg><videomsg aeskey=\"" + str3 + "\" cdnthumbaeskey=\"" + str3 + "\" cdnvideourl=\"" + str2 + "\" ") + "cdnthumburl=\"" + str2 + "\" ") + "length=\"" + i2 + "\" ") + "cdnthumblength=\"" + i4 + "\"/></msg>";
                                        Log.i("MicroMsg.ChattingEditModeLogic", "cdn callback new build cdnInfo:%s", str2);
                                        u.b(Qv, i3, str, str2, (int) caVar.field_msgId);
                                        com.tencent.mm.av.s bcY = com.tencent.mm.av.s.bcY();
                                        bcY.fileName = Qv;
                                        bcY.jaB = 0;
                                        bcY.jaC = dVar;
                                        bcY.jaD = new com.tencent.mm.av.f() {
                                            /* class com.tencent.mm.ui.chatting.k.AnonymousClass4.AnonymousClass1 */

                                            @Override // com.tencent.mm.av.f
                                            public final void dq(int i2, int i3) {
                                                AppMethodBeat.i(34393);
                                                com.tencent.mm.modelvideo.s QN = u.QN(Qv);
                                                QN.status = 111;
                                                QN.cSx = 256;
                                                o.bhj().c(QN);
                                                Log.d("MicroMsg.ChattingEditModeLogic", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
                                                AppMethodBeat.o(34393);
                                            }
                                        };
                                        bcY.jdR = 4;
                                        bcY.bdQ().execute();
                                    } else {
                                        k.f(str, caVar);
                                    }
                                }
                                AppMethodBeat.o(34394);
                                return 0;
                            }

                            @Override // com.tencent.mm.i.g.a
                            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                            }

                            @Override // com.tencent.mm.i.g.a
                            public final byte[] f(String str, byte[] bArr) {
                                return new byte[0];
                            }
                        };
                        gVar.field_mediaId = com.tencent.mm.an.c.a("checkExist", Util.nowMilliSecond(), str, new StringBuilder().append(caVar.field_msgId).toString());
                        gVar.field_fileId = str2;
                        gVar.field_aesKey = str3;
                        gVar.field_filemd5 = str4;
                        gVar.field_fileType = a.MediaType_VIDEO;
                        gVar.field_talker = str;
                        gVar.field_priority = a.gpM;
                        gVar.field_svr_signature = "";
                        gVar.field_onlycheckexist = true;
                        gVar.field_trysafecdn = true;
                        if (!com.tencent.mm.an.f.baQ().f(gVar)) {
                            Log.e("MicroMsg.ChattingEditModeLogic", "check exist fail! download video before retransmit");
                            z = false;
                        } else {
                            z = true;
                        }
                    }
                }
                if (!z) {
                    f(str, caVar);
                }
                AppMethodBeat.o(34430);
                return;
            }
            a(caVar.field_imgPath, str, QN.jsr, QN.iFw, QN.bhv(), caVar.getType(), caVar.field_msgId);
            AppMethodBeat.o(34430);
        } else {
            AppMethodBeat.o(34430);
        }
    }

    public static void a(Context context, String str, ca caVar, boolean z) {
        AppMethodBeat.i(34431);
        if (!a(context, str, caVar, "text")) {
            AppMethodBeat.o(34431);
            return;
        }
        String A = A(caVar.field_content, caVar.field_isSend, z);
        if (A == null || A.equals("")) {
            Log.e("MicroMsg.ChattingEditModeLogic", "Transfer text erro: content null");
            AppMethodBeat.o(34431);
            return;
        }
        com.tencent.mm.plugin.messenger.a.g.eir().ad(str, A, ab.JG(str));
        AppMethodBeat.o(34431);
    }

    public static void b(Context context, String str, ca caVar, boolean z) {
        String str2;
        i Mx;
        AppMethodBeat.i(34432);
        if (!a(context, str, caVar, "appmsg")) {
            AppMethodBeat.o(34432);
        } else if (context == null) {
            Log.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: context is null");
            AppMethodBeat.o(34432);
        } else if (caVar == null) {
            Log.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: msg is null");
            AppMethodBeat.o(34432);
        } else {
            bg.aVF();
            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                AppMethodBeat.o(34432);
                return;
            }
            String d2 = q.bcR().d(caVar.field_imgPath, false, false);
            String str3 = (af.isNullOrNil(d2) || d2.endsWith("hd") || !s.YS(d2 + "hd")) ? d2 : d2 + "hd";
            try {
                com.tencent.mm.ag.u a2 = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(caVar.field_msgId, caVar.field_content);
                LinkedList<v> linkedList = a2.iAd;
                if (linkedList == null || linkedList.size() <= 0) {
                    if (caVar == null || (!caVar.dOQ() && !caVar.gAt())) {
                        str2 = null;
                    } else {
                        String JX = ad.JX(new StringBuilder().append(caVar.field_msgSvrId).toString());
                        ad.b G = ad.aVe().G(JX, true);
                        G.l("prePublishId", "msg_" + caVar.field_msgSvrId);
                        G.l("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(caVar, z, false));
                        G.l("preChatName", caVar.field_talker);
                        G.l("preMsgIndex", 0);
                        G.l("sendAppMsgScene", 1);
                        ((j) com.tencent.mm.kernel.g.af(j.class)).a("adExtStr", G, caVar);
                        str2 = JX;
                    }
                    com.tencent.mm.plugin.messenger.a.g.eir().a(str, Util.readFromFile(str3), Util.processXml(caVar.field_content), str2);
                    AppMethodBeat.o(34432);
                    return;
                }
                for (v vVar : linkedList) {
                    k.b bVar = new k.b();
                    if (m.HF(vVar.iAt)) {
                        m.b(str, m.a(str, vVar), vVar.iAw);
                    } else {
                        bVar.title = vVar.title;
                        bVar.description = vVar.iAq;
                        bVar.action = "view";
                        bVar.type = 5;
                        bVar.url = vVar.url;
                        bVar.eag = a2.eag;
                        bVar.eah = a2.eah;
                        bVar.fQR = a2.fQR;
                        bVar.thumburl = m.a(vVar);
                        com.tencent.mm.ag.e eVar = new com.tencent.mm.ag.e();
                        eVar.iwc = vVar.type;
                        eVar.iwf = vVar.iwf;
                        if (vVar.type == 5) {
                            eVar.vid = vVar.vid;
                            eVar.iwd = (int) vVar.time;
                            eVar.duration = vVar.iAs;
                            eVar.videoWidth = vVar.videoWidth;
                            eVar.videoHeight = vVar.videoHeight;
                        }
                        bVar.a(eVar);
                        if (Util.isNullOrNil(bVar.thumburl) && !Util.isNullOrNil(bVar.eag) && (Mx = p.aYB().Mx(bVar.eag)) != null) {
                            bVar.thumburl = Mx.aYt();
                        }
                        com.tencent.mm.plugin.messenger.a.g.eir().a(str, Util.readFromFile(str3), Util.processXml(k.b.a(bVar, null, null)), null);
                    }
                }
                AppMethodBeat.o(34432);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e2, "", new Object[0]);
                Log.e("MicroMsg.ChattingEditModeLogic", "send app msg error : %s", e2.getLocalizedMessage());
                AppMethodBeat.o(34432);
            }
        }
    }

    public static void c(Context context, String str, ca caVar, boolean z) {
        AppMethodBeat.i(34433);
        if (!a(context, str, caVar, FirebaseAnalytics.b.LOCATION)) {
            AppMethodBeat.o(34433);
            return;
        }
        com.tencent.mm.plugin.messenger.a.g.eir().ad(str, A(caVar.field_content, caVar.field_isSend, z), 48);
        AppMethodBeat.o(34433);
    }

    public static void a(Context context, String str, String str2, int i2, boolean z) {
        AppMethodBeat.i(34435);
        try {
            ca caVar = new ca();
            caVar.setContent(str2);
            caVar.nv(i2);
            int indexOf = str2.indexOf("<msg>");
            if (indexOf > 0 && indexOf < str2.length()) {
                str2 = str2.substring(indexOf).trim();
            }
            Map<String, String> parseXml = XmlParser.parseXml(str2, "msg", null);
            if (parseXml != null && parseXml.size() > 0) {
                caVar.CA(SemiXml.encode(parseXml));
            }
            b(context, str, caVar, z);
            AppMethodBeat.o(34435);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e2, "", new Object[0]);
            Log.e("MicroMsg.ChattingEditModeLogic", "retransmit sigle app msg error : %s", e2.getLocalizedMessage());
            AppMethodBeat.o(34435);
        }
    }

    public static void d(EmojiInfo emojiInfo, String str) {
        AppMethodBeat.i(34436);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        String hYx = emojiInfo.hYx();
        if (s.boW(hYx + "_thumb") > 0) {
            wXMediaMessage.thumbData = s.aW(hYx + "_thumb", 0, (int) s.boW(hYx + "_thumb"));
        } else {
            try {
                InputStream openRead = s.openRead(hYx);
                wXMediaMessage.setThumbImage(BackwardSupportUtil.BitmapFactory.decodeStream(openRead, 1.0f));
                openRead.close();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e2, "", new Object[0]);
                Log.e("MicroMsg.ChattingEditModeLogic", "sendAppMsgEmoji Fail cause there is no thumb");
            }
        }
        wXMediaMessage.mediaObject = new WXEmojiObject(hYx);
        com.tencent.mm.pluginsdk.model.app.m.a(wXMediaMessage, emojiInfo.field_app_id, (String) null, str, 1, emojiInfo.getMd5());
        AppMethodBeat.o(34436);
    }
}
