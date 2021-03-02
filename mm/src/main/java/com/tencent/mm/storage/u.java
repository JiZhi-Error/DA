package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.contact.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.bw;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.Map;

public final class u implements f, g {
    private bw NPD;

    public u(bw bwVar) {
        AppMethodBeat.i(124594);
        ag.baw();
        this.NPD = bwVar;
        this.NPD.a((g) this);
        this.NPD.a((f) this);
        AppMethodBeat.o(124594);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.g
    public final void a(ca caVar, i.c cVar, boolean[] zArr) {
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.g
    public final void a(ca caVar, az azVar, boolean z, i.c cVar) {
        AppMethodBeat.i(124596);
        if (cVar == null) {
            Log.e("MicroMsg.BizConversationStorage", "compose notifyInfo is null");
            AppMethodBeat.o(124596);
            return;
        }
        String str = cVar.talker;
        if (z) {
            if (!(caVar == null || caVar.field_isSend == 1 || (br.A(caVar) & 1) == 0)) {
                Log.i("MicroMsg.BizConversationStorage", "create a temp session conversation.");
                azVar.oT(4194304);
            }
            if (caVar != null && com.tencent.mm.al.g.DQ(str)) {
                Log.i("MicroMsg.BizConversationStorage", "create a bitChat conversation.");
                azVar.oT(TPMediaCodecProfileLevel.HEVCHighTierLevel61);
            }
        } else {
            as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(str);
            if (Kn != null && Kn.gBM() && !c.oR(Kn.field_type) && caVar != null && caVar.field_isSend != 1 && !azVar.oV(4194304) && (azVar.field_conversationTime < ag.baw() || (br.A(caVar) & 1) != 0)) {
                azVar.oT(4194304);
                Log.i("MicroMsg.BizConversationStorage", "onNotifyChange is old temp session, %s", str);
            }
            if (caVar != null && com.tencent.mm.al.g.DQ(str)) {
                Log.i("MicroMsg.BizConversationStorage", "onNotifyChange a bitChat conversation, %s", str);
                azVar.oT(TPMediaCodecProfileLevel.HEVCHighTierLevel61);
            }
        }
        if (!(cVar == null || cVar.hIs.isEmpty() || cVar.hIs.get(0) == null)) {
            azVar.nv(cVar.hIs.get(0).field_isSend);
            if (cVar.zqn.equals("insert")) {
                azVar.OoM = cVar.hIs.get(cVar.hIs.size() - 1);
            }
        }
        AppMethodBeat.o(124596);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.g
    public final void b(ca caVar, az azVar, boolean z, i.c cVar) {
        String str;
        int i2;
        int i3;
        az azVar2;
        AppMethodBeat.i(124597);
        bw aST = ((l) com.tencent.mm.kernel.g.af(l.class)).aST();
        if (cVar == null) {
            str = null;
        } else {
            str = cVar.talker;
        }
        if (cVar == null || !cVar.zqn.equals("delete") || cVar.zqp <= 0) {
            i2 = 0;
        } else {
            i2 = cVar.zqp;
        }
        if (cVar == null || !cVar.zqn.equals("insert") || cVar.zqo <= 0) {
            i3 = 0;
        } else {
            i3 = cVar.zqo;
        }
        if (!Util.isNullOrNil(azVar.field_parentRef)) {
            az bjY = aST.bjY(azVar.field_parentRef);
            if (bjY == null || !bjY.oV(TPMediaCodecProfileLevel.HEVCHighTierLevel6)) {
                if (bjY == null || !"officialaccounts".equals(bjY.field_username)) {
                    if (bjY != null && "appbrandcustomerservicemsg".equals(bjY.field_username) && i3 > 0) {
                        if ((cVar.zqn.equals("insert") && cVar.tYD > 0) || (cVar.zqn.equals("update") && bjY.field_unReadCount + cVar.tYD >= 0)) {
                            bjY.nt(bjY.field_unReadCount + i3);
                        }
                        aST.a(azVar, i2, i3);
                        aST.a(bjY, azVar.field_parentRef);
                    }
                } else if (i3 > 0 && !ab.clc() && ((cVar.zqn.equals("insert") && cVar.tYD > 0) || (cVar.zqn.equals("update") && bjY.field_unReadCount + cVar.tYD >= 0))) {
                    bjY.nt(bjY.field_unReadCount + i3);
                    aST.a(bjY, azVar.field_parentRef);
                    azVar2 = bjY;
                }
                azVar2 = bjY;
            } else {
                if (i3 > 0) {
                    if ((cVar.zqn.equals("insert") && cVar.tYD > 0) || (cVar.zqn.equals("update") && bjY.field_unReadCount + cVar.tYD >= 0)) {
                        as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(str);
                        if (Kn == null || (!Kn.Zx() && !b(cVar))) {
                            bjY.nt(bjY.field_unReadCount + i3);
                        } else {
                            bjY.nz(bjY.field_unReadMuteCount + i3);
                        }
                    }
                    aST.a(azVar, i2, i3);
                }
                ca aEx = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().aEx(((l) com.tencent.mm.kernel.g.af(l.class)).aST().bkl(azVar.field_parentRef));
                if (aEx == null || aEx.field_msgId <= 0) {
                    bjY.gCr();
                } else {
                    bjY.aX(aEx);
                    bjY.setContent(aEx.field_talker + ":" + aEx.field_content);
                    bjY.Cl(Integer.toString(aEx.getType()));
                    if (aST.Xh() != null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        aEx.Cy(azVar.field_parentRef);
                        aEx.setContent(bjY.field_content);
                        aST.Xh().a(aEx, pString, pString2, pInt, true);
                        String dk = aST.dk(aEx.getType(), aEx.field_content);
                        if (aEx.field_bizChatId != -1) {
                            try {
                                pString.value = String.format(pString.value, ag.bal().fB(aEx.field_bizChatUserId).field_userName);
                                bjY.Cn("");
                            } catch (Throwable th) {
                            }
                        } else {
                            bjY.Cn(pString2.value);
                        }
                        bjY.Cm(Util.nullAsNil(pString.value).concat(Util.isNullOrNil(dk) ? "" : " " + Util.nullAsNil(dk)));
                        bjY.nw(pInt.value);
                    }
                }
                if (aST.a(bjY, azVar.field_parentRef) > 0) {
                    Log.d("MicroMsg.BizConversationStorage", "hakon update parent conversation's unread %s, %d", azVar.field_parentRef, Integer.valueOf(bjY.field_unReadCount + i3));
                    aST.doNotify(3, (MStorageEx) aST, azVar.field_parentRef);
                }
                azVar2 = bjY;
            }
        } else {
            azVar2 = null;
        }
        a(str, azVar, i3, i2, cVar, azVar2);
        AppMethodBeat.o(124597);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r13, com.tencent.mm.storage.az r14, int r15, int r16, com.tencent.mm.plugin.messenger.foundation.a.a.i.c r17, com.tencent.mm.storage.az r18) {
        /*
        // Method dump skipped, instructions count: 793
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.u.a(java.lang.String, com.tencent.mm.storage.az, int, int, com.tencent.mm.plugin.messenger.foundation.a.a.i$c, com.tencent.mm.storage.az):void");
    }

    private static boolean b(i.c cVar) {
        AppMethodBeat.i(212324);
        try {
            boolean iE = ag.baj().bs(cVar.ppv).iE(1);
            AppMethodBeat.o(212324);
            return iE;
        } catch (Throwable th) {
            AppMethodBeat.o(212324);
            return false;
        }
    }

    private static boolean biN(String str) {
        AppMethodBeat.i(124599);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(124599);
            return false;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "msgsource", null);
        if (parseXml == null) {
            AppMethodBeat.o(124599);
            return false;
        }
        try {
            if (Integer.parseInt(parseXml.get(".msgsource.atall")) > 0) {
                AppMethodBeat.o(124599);
                return true;
            }
            AppMethodBeat.o(124599);
            return false;
        } catch (Throwable th) {
            AppMethodBeat.o(124599);
            return false;
        }
    }

    public final void biO(String str) {
        AppMethodBeat.i(124600);
        if (str == null || !ab.IT(str) || !com.tencent.mm.al.g.Ng(str)) {
            AppMethodBeat.o(124600);
            return;
        }
        az bjY = this.NPD.bjY(str);
        if (bjY == null) {
            AppMethodBeat.o(124600);
            return;
        }
        ca aEx = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().aEx(((l) com.tencent.mm.kernel.g.af(l.class)).aST().bkl(str));
        if (aEx != null && aEx.field_msgId > 0) {
            bjY.aX(aEx);
            bjY.setContent(aEx.field_talker + ":" + aEx.field_content);
            bjY.Cl(Integer.toString(aEx.getType()));
            bw.b Xh = this.NPD.Xh();
            if (Xh != null) {
                PString pString = new PString();
                PString pString2 = new PString();
                PInt pInt = new PInt();
                aEx.Cy(str);
                aEx.setContent(bjY.field_content);
                Xh.a(aEx, pString, pString2, pInt, true);
                bjY.Cm(pString.value);
                bjY.Cn(pString2.value);
                bjY.nw(pInt.value);
            } else {
                bjY.gCr();
            }
            this.NPD.a(bjY, bjY.field_username);
        }
        AppMethodBeat.o(124600);
    }

    public static void biP(String str) {
        AppMethodBeat.i(124601);
        bw aST = ((l) com.tencent.mm.kernel.g.af(l.class)).aST();
        az azVar = new az(str);
        azVar.Co("officialaccounts");
        b(azVar, aST);
        AppMethodBeat.o(124601);
    }

    public static void b(az azVar, bw bwVar) {
        boolean z;
        az azVar2;
        boolean z2;
        AppMethodBeat.i(124602);
        if (azVar == null || bwVar == null) {
            AppMethodBeat.o(124602);
            return;
        }
        if (ab.IT(azVar.field_username) && !Util.isNullOrNil(azVar.field_parentRef)) {
            if (!ab.clc() || !ab.Js(azVar.field_parentRef)) {
                az bjY = bwVar.bjY(azVar.field_parentRef);
                Log.v("MicroMsg.BizConversationStorage", "postConvExt, username = %s, parentRef = %s", azVar.field_username, azVar.field_parentRef);
                if (!azVar.field_parentRef.equals("officialaccounts")) {
                    z = true;
                } else {
                    z = false;
                }
                if (bjY == null) {
                    az azVar3 = new az(azVar.field_parentRef);
                    if (z) {
                        azVar3.oT(TPMediaCodecProfileLevel.HEVCHighTierLevel6);
                    }
                    azVar2 = azVar3;
                    z2 = true;
                } else {
                    azVar2 = bjY;
                    z2 = false;
                }
                if (z && azVar2.field_attrflag == 0) {
                    azVar2.oT(TPMediaCodecProfileLevel.HEVCHighTierLevel6);
                    Log.v("MicroMsg.BizConversationStorage", "Enterprise cvs reset attr flag!");
                }
                Log.i("MicroMsg.BizConversationStorage", "enterprise cvs count is %d", Integer.valueOf(azVar2.field_unReadCount));
                String bkl = ((l) com.tencent.mm.kernel.g.af(l.class)).aST().bkl(azVar.field_parentRef);
                ca aEx = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().aEx(bkl);
                if (aEx == null || aEx.field_msgId <= 0) {
                    azVar2.gCr();
                    Log.i("MicroMsg.BizConversationStorage", "lastOfMsg is null or MsgId <= 0, lastConvBiz is %s", bkl);
                } else {
                    azVar2.aX(aEx);
                    azVar2.setContent(aEx.field_talker + ":" + aEx.field_content);
                    azVar2.Cl(Integer.toString(aEx.getType()));
                    bw.b Xh = bwVar.Xh();
                    if (Xh != null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        aEx.Cy(azVar.field_parentRef);
                        aEx.setContent(azVar2.field_content);
                        Xh.a(aEx, pString, pString2, pInt, true);
                        azVar2.Cm(pString.value);
                        azVar2.Cn(pString2.value);
                        azVar2.nw(pInt.value);
                    }
                }
                boolean z3 = false;
                if (z && bwVar.bkk(azVar2.field_username) <= 0) {
                    z3 = true;
                }
                if (z3) {
                    bwVar.bjW(azVar2.field_username);
                    AppMethodBeat.o(124602);
                    return;
                } else if (z2) {
                    bwVar.e(azVar2);
                    AppMethodBeat.o(124602);
                    return;
                } else {
                    bwVar.a(azVar2, azVar2.field_username);
                }
            } else {
                AppMethodBeat.o(124602);
                return;
            }
        }
        AppMethodBeat.o(124602);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.f
    public final void a(ca caVar, az azVar) {
        String str;
        String str2 = null;
        AppMethodBeat.i(124595);
        if (!(azVar == null || caVar == null || caVar.field_bizChatId == -1 || !azVar.oV(TPMediaCodecProfileLevel.HEVCHighTierLevel61))) {
            com.tencent.mm.al.a.c bs = ag.baj().bs(caVar.field_bizChatId);
            String str3 = azVar.field_digest;
            if (!Util.isNullOrNil(caVar.field_bizChatUserId)) {
                k fB = ag.bal().fB(caVar.field_bizChatUserId);
                if (fB != null) {
                    str = fB.field_userName;
                } else {
                    str = null;
                }
                boolean equals = caVar.field_bizChatUserId.equals(ag.bal().fC(caVar.field_talker));
                if (fB != null && equals) {
                    azVar.Cm(MMApplicationContext.getContext().getString(R.string.wh) + ":" + str3);
                } else if (fB != null && !Util.isNullOrNil(fB.field_userName)) {
                    azVar.Cm(fB.field_userName + ":" + str3);
                }
                if (!bs.isGroup()) {
                    if (equals || str == null || str.length() <= 0 || str.equals(bs.field_chatName)) {
                        k fB2 = ag.bal().fB(bs.field_bizChatServId);
                        if (fB2 != null) {
                            str2 = fB2.field_userName;
                        }
                        if (str2 != null && str2.length() > 0 && !str2.equals(bs.field_chatName)) {
                            bs.field_chatName = str2;
                            ag.baj().b(bs);
                        }
                    } else {
                        bs.field_chatName = str;
                        ag.baj().b(bs);
                        AppMethodBeat.o(124595);
                        return;
                    }
                }
                AppMethodBeat.o(124595);
                return;
            }
            Log.w("MicroMsg.BizConversationStorage", "BizChatUserId is null:%s %s", bs.field_bizChatServId, bs.field_chatName);
        }
        AppMethodBeat.o(124595);
    }
}
