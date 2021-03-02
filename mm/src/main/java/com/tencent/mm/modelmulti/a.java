package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.a.xm;
import com.tencent.mm.g.a.ym;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cr;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.protocal.protobuf.cpd;
import com.tencent.mm.protocal.protobuf.cpg;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cql;
import com.tencent.mm.protocal.protobuf.ctf;
import com.tencent.mm.protocal.protobuf.dgj;
import com.tencent.mm.protocal.protobuf.dtv;
import com.tencent.mm.protocal.protobuf.efy;
import com.tencent.mm.protocal.protobuf.eos;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.smtt.sdk.TbsListener;
import junit.framework.Assert;

public final class a implements x {
    @Override // com.tencent.mm.plugin.messenger.foundation.a.x
    public final void a(abn abn, byte[] bArr, boolean z, aa aaVar) {
        String str;
        String str2;
        AppMethodBeat.i(20538);
        switch (abn.Lms) {
            case 13:
                cpx cpx = (cpx) new cpx().parseFrom(bArr);
                if (1 == cpx.MvQ) {
                    bg.aVF();
                    c.aSW().i(z.a(cpx.Lqk), cpx.DeleteFlag == 1, cpx.MvR == 1);
                    AppMethodBeat.o(20538);
                    return;
                }
                Log.e("MicroMsg.BigBallOfMudSyncExtension", "unknown micro blog type:" + cpx.MvQ);
                AppMethodBeat.o(20538);
                return;
            case 15:
                cpg cpg = (cpg) new cpg().parseFrom(bArr);
                if (cpg != null) {
                    Log.d("MicroMsg.BigBallOfMudSyncExtension", "processModChatRoomMember username:" + cpg.Lqk + " nickname:" + cpg.Mjj);
                    String a2 = z.a(cpg.Lqk);
                    bg.aVF();
                    as Kn = c.aSN().Kn(a2);
                    Kn.setUsername(a2);
                    Kn.setNickname(z.a(cpg.Mjj));
                    Kn.BF(z.a(cpg.LpA));
                    Kn.BG(z.a(cpg.LpB));
                    Kn.nj(cpg.kdY);
                    Kn.BD(z.a(cpg.MuI));
                    Kn.BI(z.a(cpg.MuK));
                    Kn.BJ(z.a(cpg.MuJ));
                    Kn.nl(cpg.LoM);
                    i iVar = new i();
                    iVar.cSx = -1;
                    iVar.username = Kn.field_username;
                    iVar.iKW = cpg.Lis;
                    iVar.iKX = cpg.Lir;
                    Log.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl chatmember %s b[%s] s[%s]", iVar.getUsername(), iVar.aYt(), iVar.aYu());
                    iVar.fv(true);
                    if (cpg.Mvd == 3 || cpg.Mvd == 4) {
                        Kn.ni(cpg.Mvd);
                        iVar.fuz = cpg.Mvd;
                    } else if (cpg.Mvd == 2) {
                        Kn.ni(3);
                        iVar.fuz = 3;
                        Kn.ni(3);
                        if (!com.tencent.mm.model.z.aTY().equals(Kn.field_username)) {
                            p.aYn();
                            e.N(Kn.field_username, false);
                            p.aYn();
                            e.N(Kn.field_username, true);
                            p.aYD().Mg(Kn.field_username);
                        }
                    }
                    p.aYB().b(iVar);
                    bg.aVF();
                    c.aSN().ao(Kn);
                    com.tencent.mm.api.c MT = ag.bah().MT(Kn.field_username);
                    MT.field_username = Kn.field_username;
                    MT.field_brandList = cpg.kei;
                    aeq aeq = cpg.MmR;
                    if (aeq != null) {
                        MT.field_brandFlag = aeq.kem;
                        MT.field_brandInfo = aeq.keo;
                        MT.field_brandIconURL = aeq.kep;
                        MT.field_extInfo = aeq.ken;
                        MT.field_attrSyncVersion = null;
                        Log.i("MicroMsg.BigBallOfMudSyncExtension", "update extInfo=%s", MT.field_extInfo);
                    }
                    if (!ag.bah().h(MT)) {
                        ag.bah().g(MT);
                    }
                }
                AppMethodBeat.o(20538);
                return;
            case 22:
                cdm cdm = (cdm) new cdm().parseFrom(bArr);
                com.tencent.mm.plugin.account.friend.a.p pVar = new com.tencent.mm.plugin.account.friend.a.p();
                pVar.username = cdm.UserName;
                pVar.keQ = cdm.Mjk;
                pVar.dii = (int) Util.nowSecond();
                com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().b(pVar);
                AppMethodBeat.o(20538);
                return;
            case 23:
                bfx bfx = (bfx) new bfx().parseFrom(bArr);
                switch (bfx.LPB) {
                    case 1:
                        bg.aVF();
                        c.azQ().set(17, Integer.valueOf(bfx.BsD));
                        AppMethodBeat.o(20538);
                        return;
                    case 2:
                    case 3:
                    default:
                        Log.e("MicroMsg.BigBallOfMudSyncExtension", "unknown function switch id:" + bfx.LPB);
                        AppMethodBeat.o(20538);
                        return;
                    case 4:
                        AppMethodBeat.o(20538);
                        return;
                }
            case 24:
                dgj dgj = (dgj) new dgj().parseFrom(bArr);
                Assert.assertTrue(dgj != null);
                Assert.assertTrue(Util.nullAsNil(dgj.UserName).length() > 0);
                if (!as.bjo(dgj.UserName)) {
                    Log.w("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: qcontact should ends with @t.qq.com");
                    AppMethodBeat.o(20538);
                    return;
                }
                bg.aVF();
                as Kn2 = c.aSN().Kn(dgj.UserName);
                if (Kn2 == null || ((int) Kn2.gMZ) == 0) {
                    as asVar = new as(dgj.UserName);
                    asVar.aqW();
                    asVar.setNickname(dgj.Liq);
                    asVar.BD(dgj.Liq);
                    asVar.nl(4);
                    bg.aVF();
                    if (c.aSN().aq(asVar) == -1) {
                        Log.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: insert contact failed");
                        AppMethodBeat.o(20538);
                        return;
                    }
                    com.tencent.mm.aj.c.Mb(asVar.field_username);
                } else if (!Util.nullAsNil(dgj.Liq).equals(Util.nullAsNil(Kn2.field_username))) {
                    Kn2.setNickname(dgj.Liq);
                    Kn2.BD(dgj.Liq);
                    bg.aVF();
                    if (c.aSN().c(Kn2.field_username, Kn2) == -1) {
                        Log.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: update contact failed");
                    }
                }
                qc qcVar = new qc();
                qcVar.dWm.opType = 1;
                qcVar.dWm.dWq = dgj.UserName;
                qcVar.dWm.dWr = dgj.MKY;
                qcVar.dWm.dWs = dgj.LoT;
                EventCenter.instance.publish(qcVar);
                AppMethodBeat.o(20538);
                return;
            case 25:
                efy efy = (efy) new efy().parseFrom(bArr);
                Assert.assertTrue(efy != null);
                Assert.assertTrue(Util.nullAsNil(efy.UserName).length() > 0);
                if (!as.bjm(efy.UserName)) {
                    Log.w("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: tcontact should ends with @t.qq.com");
                    AppMethodBeat.o(20538);
                    return;
                }
                bg.aVF();
                as Kn3 = c.aSN().Kn(efy.UserName);
                if (Kn3 == null || ((int) Kn3.gMZ) == 0) {
                    as asVar2 = new as(efy.UserName);
                    asVar2.BD(efy.Liq);
                    asVar2.nl(1);
                    asVar2.aqW();
                    bg.aVF();
                    if (c.aSN().aq(asVar2) == -1) {
                        Log.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: insert contact failed");
                        AppMethodBeat.o(20538);
                        return;
                    }
                    String str3 = asVar2.field_username;
                    if (str3 == null) {
                        Log.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
                    } else if (!str3.endsWith("@t.qq.com")) {
                        Log.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
                    } else {
                        i iVar2 = new i();
                        iVar2.username = str3;
                        iVar2.fuz = 3;
                        iVar2.cSx = 3;
                        p.aYB().b(iVar2);
                    }
                } else if (!Util.nullAsNil(efy.Liq).equals(Util.nullAsNil(Kn3.field_username))) {
                    Kn3.BD(efy.Liq);
                    bg.aVF();
                    if (c.aSN().c(Kn3.field_username, Kn3) == -1) {
                        Log.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: update contact failed");
                    }
                }
                xm xmVar = new xm();
                xmVar.edJ.opType = 1;
                xmVar.edJ.dWq = efy.UserName;
                xmVar.edJ.dWr = efy.MKY;
                xmVar.edJ.dWs = efy.LoT;
                EventCenter.instance.publish(xmVar);
                AppMethodBeat.o(20538);
                return;
            case 33:
                cpd cpd = (cpd) new cpd().parseFrom(bArr);
                Assert.assertTrue(cpd != null);
                Assert.assertTrue(Util.nullAsNil(cpd.UserName).length() > 0);
                as asVar3 = new as();
                asVar3.setUsername(cpd.UserName);
                asVar3.setType(cpd.oUv);
                asVar3.nj(cpd.kdY);
                asVar3.Cb(RegionCodeDecoder.bq(cpd.keh, cpd.kdZ, cpd.kea));
                asVar3.BV(cpd.keb);
                i iVar3 = new i();
                iVar3.cSx = -1;
                iVar3.username = cpd.UserName;
                iVar3.iKW = cpd.Lis;
                iVar3.iKX = cpd.Lir;
                Log.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl bottle %s b[%s] s[%s]", iVar3.getUsername(), iVar3.aYt(), iVar3.aYu());
                Log.d("MicroMsg.BigBallOfMudSyncExtension", "bottlecontact imgflag:" + cpd.Mvd + " hd:" + cpd.Mve);
                iVar3.fv(cpd.Mve != 0);
                if (cpd.Mvd == 3 || cpd.Mvd == 4) {
                    asVar3.ni(cpd.Mvd);
                    iVar3.fuz = cpd.Mvd;
                } else if (cpd.Mvd == 2) {
                    asVar3.ni(3);
                    iVar3.fuz = 3;
                    p.aYn();
                    e.N(cpd.UserName, false);
                    p.aYn();
                    e.N(cpd.UserName, true);
                    p.aYD().Mg(cpd.UserName);
                } else {
                    asVar3.ni(3);
                    iVar3.fuz = 3;
                }
                p.aYB().b(iVar3);
                bg.aVF();
                c.aSN().an(asVar3);
                AppMethodBeat.o(20538);
                return;
            case 35:
                cql cql = (cql) new cql().parseFrom(bArr);
                Assert.assertTrue(cql != null);
                String aTY = com.tencent.mm.model.z.aTY();
                int i2 = cql.Mwb;
                if (i2 == 2) {
                    String bjz = as.bjz(aTY);
                    bg.aVF();
                    str = bjz;
                    str2 = (String) c.azQ().get(12553, (Object) null);
                } else {
                    bg.aVF();
                    str = aTY;
                    str2 = (String) c.azQ().get(12297, (Object) null);
                }
                boolean z2 = false;
                if (str2 == null || !str2.equals(cql.Mwe)) {
                    p.aYn();
                    e.N(str, true);
                    bg.aVF();
                    c.azQ().set(i2 == 2 ? 12553 : 12297, cql.Mwe);
                    z2 = true;
                }
                Log.d("MicroMsg.BigBallOfMudSyncExtension", "ModUserImg beRemove:%b imgtype:%d md5:%s big:%s sm:%s", Boolean.valueOf(z2), Integer.valueOf(i2), cql.Mwe, cql.Lir, cql.Lis);
                i iVar4 = new i();
                iVar4.username = str;
                iVar4.iKX = cql.Lir;
                iVar4.iKW = cql.Lis;
                if (!Util.isNullOrNil(iVar4.aYu())) {
                    if (i2 == 1) {
                        bg.aVF();
                        c.azQ().set(59, Boolean.TRUE);
                    } else {
                        bg.aVF();
                        c.azQ().set(60, Boolean.TRUE);
                    }
                }
                iVar4.fv(false);
                iVar4.cSx = 56;
                if (!Util.isNullOrNil(cql.Mwe)) {
                    iVar4.fv(true);
                }
                p.aYB().b(iVar4);
                if (z2) {
                    new f().a(str, new f.c() {
                        /* class com.tencent.mm.modelmulti.a.AnonymousClass1 */

                        @Override // com.tencent.mm.aj.f.c
                        public final int dp(int i2, int i3) {
                            return 0;
                        }
                    });
                }
                AppMethodBeat.o(20538);
                return;
            case 44:
                eos eos = (eos) new eos().parseFrom(bArr);
                Log.i("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt snsExtFlag:%s, snsExtFlagEx:%s, snsPrivacyRecent:%s, textStatus:%s", Integer.valueOf(eos.MmQ.kej), Integer.valueOf(eos.MmQ.Nbc), Integer.valueOf(eos.MmQ.Nbd), eos.Liv);
                bg.aVF();
                String str4 = (String) c.azQ().get(2, (Object) null);
                if (str4 == null || str4.length() <= 0) {
                    AppMethodBeat.o(20538);
                    return;
                }
                if (o.DCN != null) {
                    o.DCN.a(str4, eos.MmQ);
                }
                Log.i("MicroMsg.BigBallOfMudSyncExtension", "storyExtFlag:%s", Integer.valueOf(eos.NmJ.NeF));
                ((com.tencent.mm.plugin.story.api.e) g.ah(com.tencent.mm.plugin.story.api.e.class)).updateStoryUserInfo(str4, eos.NmJ);
                Log.i("MicroMsg.BigBallOfMudSyncExtension", "finderSetting:%s", Long.valueOf(eos.NmS));
                ((aj) g.ah(aj.class)).getFinderSwitchApi().Gf(eos.NmS);
                com.tencent.mm.api.c fJ = com.tencent.mm.al.g.fJ(com.tencent.mm.model.z.aTY());
                if (fJ == null) {
                    fJ = new com.tencent.mm.api.c();
                }
                fJ.field_username = str4;
                fJ.field_brandList = eos.kei;
                if (fJ.UG() && fJ.cG(false) != null && fJ.cG(false).Vh() != null && !Util.isNullOrNil(fJ.UN())) {
                    fJ.field_enterpriseFather = fJ.UN();
                    Log.d("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt, %s set enterpriseFather %s", str4, fJ.field_enterpriseFather);
                }
                if (!ag.bah().h(fJ)) {
                    ag.bah().g(fJ);
                }
                int i3 = eos.Nms;
                int i4 = eos.Nmt;
                int i5 = eos.Nmu;
                Log.d("MicroMsg.BigBallOfMudSyncExtension", "roomSize :" + i3 + " rommquota: " + i4 + " invite: " + i5);
                bg.aVF();
                c.azQ().set(135175, Integer.valueOf(i3));
                bg.aVF();
                c.azQ().set(135176, Integer.valueOf(i4));
                bg.aVF();
                c.azQ().set(135177, Integer.valueOf(i5));
                bg.aVF();
                c.azQ().set(144385, Integer.valueOf(eos.Nmy));
                bg.aVF();
                c.azQ().set(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(eos.LRD));
                com.tencent.mm.plugin.base.model.c.cjL();
                bg.aVF();
                c.azQ().set(339975, Integer.valueOf(eos.NmG));
                Log.i("MicroMsg.BigBallOfMudSyncExtension", "hy: sync do cmd pay wallet type: %d %d", Integer.valueOf(eos.NmG), Integer.valueOf(eos.LRD));
                bg.aVF();
                c.azQ().set(ar.a.USERINFO_PROFILE_WEIDIANINFO_STRING, Util.nullAs(eos.fuW, ""));
                Log.d("MicroMsg.BigBallOfMudSyncExtension", "weidianinfo:%s", eos.fuW);
                bg.aVF();
                c.azQ().set(147457, Long.valueOf(eos.NmH));
                Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.ExtStatus:%s", Long.valueOf(eos.NmH));
                bg.aVF();
                c.azQ().set(ar.a.USERINFO_EXT_USER_STATUS_INT_SYNC, Integer.valueOf(eos.MKH));
                Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.UserStatus:%s", Integer.valueOf(eos.MKH));
                bg.aVF();
                c.azQ().set(ar.a.USERINFO_EXT_BIND_XMAIL_STRING_SYNC, eos.NmM);
                Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.BindXMail:%s", eos.NmM);
                bg.aVF();
                c.azQ().set(ar.a.USERINFO_EXT_PAY_SETTING_LONG_SYNC, Long.valueOf(eos.NmK));
                Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PaySetting:%s", Long.toBinaryString(eos.NmK));
                bg.aVF();
                c.azQ().set(ar.a.USERINFO_F2F_RING_TONE_STRING, eos.NmI);
                bg.aVF();
                c.azQ().set(ar.a.USERINFO_MOBILE_REMITTANCE_BIND_MOBILE_TRANSFER_INT_SYNC, Integer.valueOf(eos.NmL));
                Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PayBindMobileTransfer:%s", Integer.valueOf(eos.NmL));
                g.aAh().azQ().set(ar.a.USERINFO_PAT_SUFFIX_STRING_SYNC, eos.MvT);
                Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PatSuffix:%s", eos.MvT);
                g.aAh().azQ().set(ar.a.USERINFO_PAT_SUFFIX_VERSION_INT_SYNC, Integer.valueOf(eos.MVK));
                Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PatSuffixVersion:%d", Integer.valueOf(eos.MVK));
                com.tencent.mm.plugin.patmsg.c.fa(str4, eos.MVK);
                g.aAh().azQ().set(ar.a.USERINFO_SETTING_TEEN_MODE_STATE_BOOLEAN_SYNC, Boolean.valueOf((eos.NmH & 1099511627776L) != 0));
                g.aAh().azQ().set(ar.a.USERINFO_SETTING_TEEN_MODE_FINDER_RANGE_INT_SYNC, Integer.valueOf(eos.NmN));
                g.aAh().azQ().set(ar.a.USERINFO_SETTING_TEEN_MODE_BIZ_ACCT_RANGE_INT_SYNC, Integer.valueOf(eos.NmO));
                g.aAh().azQ().set(ar.a.USERINFO_SETTING_TEEN_MODE_MINI_PROGRAM_RANGE_INT_SYNC, Integer.valueOf(eos.NmP));
                ((b) g.af(b.class)).fvq();
                i iVar5 = new i();
                iVar5.cSx = -1;
                iVar5.username = str4;
                iVar5.iKX = eos.Lir;
                iVar5.iKW = eos.Lis;
                iVar5.fv(true);
                iVar5.fuz = 3;
                Log.d("MicroMsg.BigBallOfMudSyncExtension", "dkavatar user:[%s] big:[%s] sm:[%s]", iVar5.getUsername(), iVar5.aYt(), iVar5.aYu());
                p.aYB().b(iVar5);
                String str5 = eos.Mvo;
                String str6 = eos.Mvp;
                bg.aVF();
                c.azQ().set(274433, str6);
                bg.aVF();
                c.azQ().set(274434, str5);
                if (eos.KHD != null) {
                    bg.aVF();
                    c.azQ().set(286721, eos.KHD.KPG);
                    bg.aVF();
                    c.azQ().set(286722, eos.KHD.KPH);
                    bg.aVF();
                    c.azQ().set(286723, eos.KHD.KPI);
                }
                if (!(eos.NmE == null || eos.NmE.MEK == null || eos.NmE.MEK.getILen() <= 0)) {
                    Log.i("MicroMsg.BigBallOfMudSyncExtension", "tomgest PatternLockInfo %d", Integer.valueOf(eos.NmE.MEK.getILen()));
                    ym ymVar = new ym();
                    ymVar.eeL.eeM = eos.NmE;
                    EventCenter.instance.publish(ymVar);
                }
                Log.i("MicroMsg.BigBallOfMudSyncExtension", "handling xagreement configs");
                if (eos.NmQ != null) {
                    cr.z(eos.NmQ.NAz, eos.NmQ.NAA);
                }
                AppMethodBeat.o(20538);
                return;
            case 53:
                ctf ctf = (ctf) new ctf().parseFrom(bArr);
                Log.d("MicroMsg.BigBallOfMudSyncExtension", "rollback, msgtype is %d, msgid is %d", Integer.valueOf(ctf.xKb), Long.valueOf(ctf.Brn));
                if (ab.Jj(ctf.xNH)) {
                    sy syVar = new sy();
                    syVar.dZu.msgId = ctf.Brn;
                    EventCenter.instance.publish(syVar);
                }
                AppMethodBeat.o(20538);
                return;
            case 204:
                ux uxVar = new ux();
                uxVar.ebm.data = bArr;
                EventCenter.instance.publish(uxVar);
                AppMethodBeat.o(20538);
                return;
            case TbsListener.ErrorCode.RENAME_EXCEPTION /*{ENCODED_INT: 219}*/:
                dtv dtv = (dtv) new dtv().parseFrom(bArr);
                if (dtv != null) {
                    ((l) g.af(l.class)).aSN().mS(dtv.UserName, dtv.Bri);
                    AppMethodBeat.o(20538);
                    return;
                }
                break;
            case 999999:
                try {
                    int v = com.tencent.mm.b.o.v(bArr, 0);
                    Log.d("MicroMsg.BigBallOfMudSyncExtension", "local test synccmd, sleep %d", Integer.valueOf(v));
                    if (v > 0) {
                        Thread.sleep((long) v);
                    }
                    AppMethodBeat.o(20538);
                    return;
                } catch (InterruptedException e2) {
                    Log.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", e2, "", new Object[0]);
                    AppMethodBeat.o(20538);
                    return;
                }
            default:
                Log.e("MicroMsg.BigBallOfMudSyncExtension", "doCmd: no processing method, cmd id=" + abn.Lms);
                break;
        }
        AppMethodBeat.o(20538);
    }

    public static boolean a(as asVar) {
        String str;
        cpl cpl;
        AppMethodBeat.i(20539);
        if (asVar == null || Util.isNullOrNil(asVar.field_username)) {
            Object[] objArr = new Object[1];
            if (asVar == null) {
                str = "-1";
            } else {
                str = asVar.field_username;
            }
            objArr[0] = str;
            Log.w("MicroMsg.BigBallOfMudSyncExtension", "dealModContactExtInfo username:%s ", objArr);
            AppMethodBeat.o(20539);
            return false;
        }
        bg.aVF();
        byte[] bjP = c.aSN().bjP(asVar.field_username);
        if (Util.isNullOrNil(bjP)) {
            Object[] objArr2 = new Object[2];
            objArr2[0] = asVar.field_username;
            objArr2[1] = Integer.valueOf(bjP == null ? -1 : bjP.length);
            Log.w("MicroMsg.BigBallOfMudSyncExtension", "dealModContactExtInfo username:%s  buf:%d", objArr2);
            AppMethodBeat.o(20539);
            return false;
        }
        try {
            cpl = (cpl) new cpl().parseFrom(bjP);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", e2, "", new Object[0]);
            cpl = null;
        }
        bg.aVF();
        c.aSN().bjQ(asVar.field_username);
        if (cpl == null) {
            Log.e("MicroMsg.BigBallOfMudSyncExtension", "dkinit dealModContactExtInfo failed parse buf failed.");
            AppMethodBeat.o(20539);
            return false;
        }
        boolean a2 = com.tencent.mm.plugin.bbom.c.a(asVar, cpl, false);
        AppMethodBeat.o(20539);
        return a2;
    }
}
