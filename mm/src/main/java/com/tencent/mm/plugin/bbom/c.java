package com.tencent.mm.plugin.bbom;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.d;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.ui.preference.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.cpo;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.protocal.protobuf.dbk;
import com.tencent.mm.protocal.protobuf.dbl;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cl;
import com.tencent.mm.storage.cn;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import junit.framework.Assert;

public final class c implements i, d {
    private static int peQ = -1;

    private static void a(cpl cpl, String str, as asVar, boolean z) {
        AppMethodBeat.i(22337);
        String aTY = z.aTY();
        if (aTY != null && !aTY.equals(str)) {
            com.tencent.mm.api.c MT = ag.bah().MT(str);
            MT.field_username = str;
            MT.field_brandList = cpl.kei;
            aeq aeq = cpl.MmR;
            if (aeq != null) {
                MT.field_brandFlag = aeq.kem;
                MT.field_brandInfo = aeq.keo;
                MT.field_brandIconURL = aeq.kep;
                if (z) {
                    MT.field_extInfo = aeq.ken;
                    Log.i("MicroMsg.BigBallContactAssemblerImpl", "update extInfo=%s", MT.field_extInfo);
                    MT.field_attrSyncVersion = null;
                    MT.field_incrementUpdateTime = 0;
                    Log.i("MicroMsg.BigBallContactAssemblerImpl", "Reset biz(%s) Attribute syncVersion and incUpdateTime.", str);
                }
                if (!Util.isNullOrNil(MT.field_extInfo)) {
                    MT.cG(true);
                }
            }
            if (MT.cG(false) != null && MT.cG(false).getServiceType() == 3 && MT.cG(false).Vh() != null && !Util.isNullOrNil(MT.UN())) {
                MT.field_enterpriseFather = MT.UN();
                Log.d("MicroMsg.BigBallContactAssemblerImpl", "saveBizInfo, %s set enterpriseFather %s", str, MT.field_enterpriseFather);
            }
            if (!ag.bah().h(MT)) {
                ag.bah().g(MT);
            }
            asVar.np(MT.field_type);
        }
        AppMethodBeat.o(22337);
    }

    public static boolean a(as asVar, cpl cpl, boolean z) {
        AppMethodBeat.i(22338);
        if (asVar == null || Util.isNullOrNil(asVar.field_username)) {
            Log.e("MicroMsg.BigBallContactAssemblerImpl", "dkinit dealModContactExtInfo failed invalid contact");
            AppMethodBeat.o(22338);
            return false;
        }
        String str = asVar.field_username;
        String str2 = asVar.field_encryptUsername;
        p.aYB().b(com.tencent.mm.aj.c.a(str, cpl));
        ebj ebj = cpl.MmQ;
        if (!asVar.field_username.endsWith("@chatroom") && ebj != null) {
            Log.i("MicroMsg.BigBallContactAssemblerImpl", "SnsFlag modcontact " + ebj.kej + " " + cpl.Lqk);
            Log.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBg modcontact " + ebj.kek);
            Log.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ebj.kel);
            Log.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ebj.Nbc);
            Log.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ebj.Nbd);
            if (o.DCN != null) {
                o.DCN.a(asVar.field_username, ebj);
            }
        }
        if (com.tencent.mm.contact.c.oR(asVar.field_type)) {
            boolean gP = com.tencent.mm.bj.d.bgN().gP(str, 1);
            if (gP) {
                Log.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, user = ".concat(String.valueOf(str)));
            } else {
                gP = com.tencent.mm.bj.d.bgN().gP(str2, 1);
                Log.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, encryptUser = ".concat(String.valueOf(str2)));
            }
            Log.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact, update state(ADDED) FMessageConversation, ret = ".concat(String.valueOf(gP)));
        }
        if (com.tencent.mm.contact.c.oR(asVar.field_type) && (asVar.getSource() == 10 || asVar.getSource() == 13)) {
            t.l(MMApplicationContext.getContext(), asVar.field_username, asVar.field_encryptUsername);
            a SR = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(asVar.field_encryptUsername);
            if (SR != null && !Util.isNullOrNil(SR.kdX)) {
                SR.username = asVar.field_username;
                Log.d("MicroMsg.BigBallContactAssemblerImpl", "account sync: update addr ".concat(String.valueOf(com.tencent.mm.plugin.account.a.getAddrUploadStg().a(SR.kdX, SR))));
            }
        }
        a(cpl, str, asVar, z);
        AppMethodBeat.o(22338);
        return true;
    }

    public static boolean ahc(String str) {
        AppMethodBeat.i(22339);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(22339);
            return false;
        }
        Matcher matcher = k.a.KqT.matcher(str);
        if (!matcher.find()) {
            AppMethodBeat.o(22339);
            return false;
        } else if (Util.isEqual(str, matcher.group(0))) {
            AppMethodBeat.o(22339);
            return true;
        } else {
            AppMethodBeat.o(22339);
            return false;
        }
    }

    private static boolean a(as asVar, cn cnVar) {
        AppMethodBeat.i(22340);
        boolean z = false;
        if (!Util.isNullOrNil(cnVar.field_conDescription)) {
            asVar.Cc(cnVar.field_conDescription);
        }
        if (!ab.IR(asVar.field_username) && com.tencent.mm.contact.c.oR(asVar.field_type)) {
            z = true;
            if (!Util.isNullOrNil(cnVar.field_conDescription)) {
                cpo cpo = new cpo();
                cpo.MvG = asVar.field_username;
                cpo.Desc = cnVar.field_conDescription;
                bg.aVF();
                com.tencent.mm.model.c.aSM().d(new k.a(54, cpo));
            }
        }
        AppMethodBeat.o(22340);
        return z;
    }

    private static void R(as asVar) {
        AppMethodBeat.i(22341);
        if (asVar != null && g.Nf(asVar.field_username) && !g.DQ(asVar.field_username)) {
            bg.aVF();
            az bjY = com.tencent.mm.model.c.aST().bjY(asVar.field_username);
            com.tencent.mm.api.c MT = ag.bah().MT(asVar.field_username);
            if (!g.Ni(MT.field_username)) {
                AppMethodBeat.o(22341);
                return;
            } else if (bjY == null) {
                az azVar = new az(MT.field_username);
                Log.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", MT.UN(), MT.field_username);
                azVar.Co(Util.nullAsNil(MT.UN()));
                azVar.gCr();
                bg.aVF();
                com.tencent.mm.model.c.aST().e(azVar);
            }
        }
        AppMethodBeat.o(22341);
    }

    private static void cC(String str, int i2) {
        bn[] bnVarArr;
        cl[] clVarArr;
        b[] bVarArr;
        int i3;
        AppMethodBeat.i(22342);
        bx[] bxVarArr = null;
        if (i2 == 26 || i2 == 27 || i2 == 28 || i2 == 29) {
            Log.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is shake");
            cl[] bkW = com.tencent.mm.bj.d.bgP().bkW(str);
            bVarArr = b.a(MMApplicationContext.getContext(), bkW);
            clVarArr = bkW;
            bnVarArr = null;
        } else if (i2 == 18) {
            Log.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is lbs");
            bxVarArr = com.tencent.mm.bj.d.bgO().bkx(str);
            bVarArr = b.a(MMApplicationContext.getContext(), bxVarArr);
            clVarArr = null;
            bnVarArr = null;
        } else {
            bn[] bku = com.tencent.mm.bj.d.bgM().bku(str);
            bVarArr = b.a(MMApplicationContext.getContext(), bku);
            clVarArr = null;
            bnVarArr = bku;
        }
        if (bVarArr == null) {
            AppMethodBeat.o(22342);
            return;
        }
        int i4 = 0;
        int length = bVarArr.length;
        int i5 = 0;
        while (i5 < length) {
            b bVar = bVarArr[i5];
            ca caVar = new ca();
            caVar.setContent(bVar.iAq);
            int JG = ab.JG(bVar.username);
            if (bnVarArr != null) {
                i3 = i4 + 1;
                caVar.setCreateTime(bnVarArr[i4].field_createTime);
            } else if (bxVarArr != null) {
                i3 = i4 + 1;
                caVar.setCreateTime(bxVarArr[i4].field_createtime * 1000);
            } else if (clVarArr != null) {
                i3 = i4 + 1;
                caVar.setCreateTime(clVarArr[i4].field_createtime * 1000);
            } else {
                i3 = i4;
            }
            caVar.Cy(bVar.username);
            caVar.setType(JG);
            if (bVar.ehd) {
                caVar.setStatus(2);
                caVar.nv(1);
            } else {
                caVar.setStatus(6);
                caVar.nv(0);
            }
            bg.aVF();
            long aC = com.tencent.mm.model.c.aSQ().aC(caVar);
            Assert.assertTrue(aC != -1);
            Log.i("MicroMsg.BigBallContactAssemblerImpl", "new msg inserted to db , local id = ".concat(String.valueOf(aC)));
            i5++;
            i4 = i3;
        }
        ca caVar2 = new ca();
        if (bnVarArr != null) {
            caVar2.setCreateTime(bnVarArr[0].field_createTime + 1);
        } else if (bxVarArr != null) {
            caVar2.setCreateTime((bxVarArr[0].field_createtime * 1000) + 1);
        } else if (clVarArr != null) {
            caVar2.setCreateTime((clVarArr[0].field_createtime * 1000) + 1);
        }
        caVar2.Cy(str);
        caVar2.setContent(MMApplicationContext.getContext().getString(R.string.hrm));
        caVar2.setType(10000);
        caVar2.setStatus(6);
        caVar2.nv(0);
        bg.aVF();
        com.tencent.mm.model.c.aSQ().aC(caVar2);
        AppMethodBeat.o(22342);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, final q qVar) {
        AppMethodBeat.i(22343);
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "onsceneEnd errType:%d,errCode:%d,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar.getType() != 681) {
            AppMethodBeat.o(22343);
        } else if (i2 != 0 || i3 != 0) {
            AppMethodBeat.o(22343);
        } else if (!com.tencent.mm.kernel.g.aAf().hpY) {
            Log.w("MicroMsg.BigBallContactAssemblerImpl", "initialize notify is not done.");
            AppMethodBeat.o(22343);
        } else {
            h.RTc.aY(new Runnable() {
                /* class com.tencent.mm.plugin.bbom.c.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(231630);
                    List<k.b> list = ((com.tencent.mm.ba.b) qVar).jgc;
                    HashSet<String> hashSet = new HashSet();
                    try {
                        for (k.b bVar : list) {
                            if (bVar.getCmdId() == 2) {
                                hashSet.add(com.tencent.mm.platformtools.z.a(((cpl) new cpl().parseFrom(bVar.getBuffer())).Lqk));
                            } else if (bVar.getCmdId() == 54) {
                                hashSet.add(((cpo) new cpo().parseFrom(bVar.getBuffer())).MvG);
                            } else if (bVar.getCmdId() == 60) {
                                hashSet.add(((cqe) new cqe().parseFrom(bVar.getBuffer())).MvG);
                            }
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.BigBallContactAssemblerImpl", e2, "BaseProtoBuf parseFrom error!", new Object[0]);
                    }
                    for (String str : hashSet) {
                        if (!Util.isNullOrNil(str)) {
                            ay.a.iDq.a(str, null, null);
                        }
                    }
                    AppMethodBeat.o(231630);
                }
            });
            AppMethodBeat.o(22343);
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.d
    public final void a(as asVar, as asVar2, cpl cpl, byte[] bArr, boolean z) {
        Object valueOf;
        String stringBuffer;
        a SR;
        int length;
        AppMethodBeat.i(22335);
        String str = asVar.field_username;
        String str2 = asVar.field_encryptUsername;
        if (asVar2 != null && !Util.nullAsNil(asVar2.fuS).equals(Util.nullAsNil(cpl.Mvw))) {
            com.tencent.mm.bd.c.bez();
            com.tencent.mm.bd.c.Pt(str);
        }
        if (Util.isNullOrNil(bArr)) {
            a(asVar, cpl, true);
        } else if (as.akh(asVar.field_verifyFlag)) {
            a(cpl, str, asVar, true);
        }
        boolean z2 = asVar2 != null && !com.tencent.mm.contact.c.oR(asVar2.field_type) && com.tencent.mm.contact.c.oR(asVar.field_type);
        if (z2 && ab.IR(str)) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(931, 22);
        }
        Object[] objArr = new Object[3];
        objArr[0] = asVar.field_username;
        if (cpl.Mvx == null) {
            valueOf = "";
        } else {
            valueOf = Integer.valueOf(Util.nullAsNil(Integer.valueOf(cpl.Mvx.MGv.size())));
        }
        objArr[1] = valueOf;
        objArr[2] = Integer.valueOf(peQ);
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s PhoneNumList size:%s mergePhoneSw:%s", objArr);
        if (peQ == -1) {
            peQ = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_mod_contact_merge_switch, 0);
        }
        if (peQ == 1) {
            StringBuffer stringBuffer2 = new StringBuffer();
            if (!(cpl.Mvx == null || cpl.Mvx.MGv == null)) {
                Iterator<dbk> it = cpl.Mvx.MGv.iterator();
                while (it.hasNext()) {
                    dbk next = it.next();
                    if (next.MGu != null) {
                        stringBuffer2.append(next.MGu).append("，");
                    }
                }
            }
            Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", asVar.field_username, stringBuffer2.toString());
            String str3 = null;
            String[] strArr = null;
            boolean z3 = false;
            if (asVar2 != null) {
                str3 = asVar2.fuX;
                strArr = com.tencent.mm.contact.a.a(asVar2, str3);
            }
            if (str3 == null || str3.equals("")) {
                bg.aVF();
                cn aEZ = com.tencent.mm.model.c.aSO().aEZ(str2);
                if (!(aEZ == null || (str3 = aEZ.field_conPhone) == null)) {
                    strArr = str3.split(",");
                }
            }
            Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, oldPhoneList %s", asVar.field_username, Util.nullAsNil(str3));
            if (strArr != null && strArr.length > 0) {
                String[] al = com.tencent.mm.contact.a.al(stringBuffer2.toString(), "，");
                boolean z4 = false;
                for (String str4 : strArr) {
                    if (al != null && al.length > 0) {
                        int length2 = al.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length2) {
                                break;
                            } else if (Util.isEqual(str4, al[i2])) {
                                z4 = false;
                                break;
                            } else {
                                z4 = true;
                                i2++;
                            }
                        }
                        if (z4 && ahc(str4)) {
                            stringBuffer2.append(str4).append("，");
                            z3 = true;
                        }
                    }
                }
                if (z3) {
                    cqe cqe = new cqe();
                    cqe.MvG = asVar.field_username;
                    dbl dbl = new dbl();
                    String[] al2 = com.tencent.mm.contact.a.al(stringBuffer2.toString(), "，");
                    if (al2 != null && al2.length > 0) {
                        dbl.oTz = al2.length;
                        dbl.MGv = new LinkedList<>();
                        for (String str5 : al2) {
                            dbk dbk = new dbk();
                            dbk.MGu = str5;
                            dbl.MGv.add(dbk);
                        }
                        cqe.Mvx = dbl;
                        bg.aVF();
                        com.tencent.mm.model.c.aSM().d(new k.a(60, cqe));
                    }
                }
                if (z2 && 15 == cpl.xub && !Util.isNullOrNil(asVar.field_username) && (SR = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(asVar.field_username)) != null) {
                    String[] al3 = com.tencent.mm.contact.a.al(stringBuffer2.toString(), "，");
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = asVar.field_username;
                    objArr2[1] = 3;
                    objArr2[2] = Integer.valueOf(Util.isNullOrNil(SR.getMd5()) ? 0 : 1);
                    if (al3 == null) {
                        length = 0;
                    } else {
                        length = al3.length >= 5 ? 5 : al3.length;
                    }
                    objArr2[3] = Integer.valueOf(length);
                    hVar.a(12040, objArr2);
                }
            }
            Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", asVar.field_username, stringBuffer2.toString());
            stringBuffer = stringBuffer2.toString();
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            if (!(cpl.Mvx == null || cpl.Mvx.MGv == null)) {
                Iterator<dbk> it2 = cpl.Mvx.MGv.iterator();
                while (it2.hasNext()) {
                    dbk next2 = it2.next();
                    if (next2.MGu != null) {
                        stringBuffer3.append(next2.MGu).append("，");
                    }
                }
            }
            Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", asVar.field_username, stringBuffer3.toString());
            stringBuffer = stringBuffer3.toString();
        }
        String nullAs = Util.nullAs(stringBuffer, "");
        Log.i("MicroMsg.BigBallContactAssemblerImpl", nullAs);
        asVar.Ci(nullAs);
        if (!ab.Eq(str) && cpl.LUi != null) {
            v.a(str, cpl.LUi);
        }
        boolean z5 = false;
        bg.aVF();
        cn aEZ2 = com.tencent.mm.model.c.aSO().aEZ(asVar.field_username);
        if (Util.isNullOrNil(asVar.field_conRemark)) {
            if (aEZ2 == null || Util.isNullOrNil(aEZ2.field_encryptUsername)) {
                Log.i("MicroMsg.BigBallContactAssemblerImpl", "try get stranger again");
                if (!Util.isNullOrNil(str2)) {
                    bg.aVF();
                    aEZ2 = com.tencent.mm.model.c.aSO().aEZ(str2);
                }
            }
            if (aEZ2 != null && !Util.isNullOrNil(aEZ2.field_encryptUsername)) {
                Log.i("MicroMsg.BigBallContactAssemblerImpl", "mod stranger remark : " + aEZ2.field_encryptUsername);
                asVar.BD(aEZ2.field_conRemark);
                asVar.BI(f.Sh(aEZ2.field_conRemark));
                asVar.BJ(f.Si(aEZ2.field_conRemark));
                z5 = a(asVar, aEZ2);
            }
            switch (asVar.getSource()) {
                case 10:
                case 11:
                case 13:
                    a aVar = null;
                    if (cpl != null && !Util.isNullOrNil(cpl.Mvq)) {
                        Log.i("MicroMsg.BigBallContactAssemblerImpl", "MobileHash[%s],MobileFullHash[%s]", cpl.Mvq, cpl.Mvr);
                        com.tencent.mm.plugin.account.friend.a.b addrUploadStg = com.tencent.mm.plugin.account.a.getAddrUploadStg();
                        String str6 = cpl.Mvq;
                        String str7 = cpl.Mvr;
                        aVar = addrUploadStg.SU(str6);
                        if (aVar == null) {
                            aVar = addrUploadStg.SU(str7);
                        }
                    } else if (!Util.isNullOrNil(str2)) {
                        aVar = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(str2);
                    }
                    if (aVar == null) {
                        Log.i("MicroMsg.BigBallContactAssemblerImpl", "dealWithRemark-> addr == null");
                    } else {
                        Log.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], needSetRemark[%s]", Util.nullAsNil(aVar.bnK()), Util.nullAsNil(aVar.getUsername()), Boolean.valueOf(aVar.bnR()));
                    }
                    if (aVar != null && !Util.isNullOrNil(aVar.bnK()) && aVar.bnR()) {
                        Log.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], remarkChange[%s]", aVar.bnK(), aVar.getUsername(), Boolean.valueOf(z5));
                        aVar.username = asVar.field_username;
                        aVar.status = 2;
                        aVar.bnQ();
                        if (!z5) {
                            asVar.BD(aVar.bnK());
                            asVar.BI(f.Sh(aVar.bnK()));
                            asVar.BJ(f.Si(aVar.bnK()));
                            z5 = true;
                        }
                        if (com.tencent.mm.contact.c.oR(asVar.field_type)) {
                            Log.i("MicroMsg.BigBallContactAssemblerImpl", "updateAddrUp RealName[%s], User[%s], remarkChange[%s]", aVar.bnK(), aVar.getUsername(), Boolean.valueOf(z5));
                            com.tencent.mm.plugin.account.a.getAddrUploadStg().a(aVar.getMd5(), aVar);
                            break;
                        }
                    }
                    break;
            }
        } else {
            Log.i("MicroMsg.BigBallContactAssemblerImpl", "remark is set");
            if (aEZ2 != null && !Util.isNullOrNil(asVar.fuR) && !asVar.fuR.equals(aEZ2.field_conDescription)) {
                a(asVar, aEZ2);
            }
            z5 = false;
        }
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s needModContact %s encryptUser:%s", asVar.field_username, Boolean.valueOf(z5), str2);
        if (z5) {
            ab.I(asVar);
        }
        String str8 = null;
        bg.aVF();
        cn aEZ3 = com.tencent.mm.model.c.aSO().aEZ(asVar.field_encryptUsername);
        if (aEZ3 != null) {
            str8 = aEZ3.field_contactLabels;
        }
        if (Util.isNullOrNil(str8)) {
            bg.aVF();
            aEZ3 = com.tencent.mm.model.c.aSO().aEZ(asVar.field_username);
            if (aEZ3 != null) {
                str8 = aEZ3.field_contactLabels;
            }
        }
        if (!Util.isNullOrNil(str8)) {
            com.tencent.mm.plugin.label.a.a.ecg().is(asVar.field_username, str8);
            aEZ3.field_contactLabels = "";
            bg.aVF();
            com.tencent.mm.model.c.aSO().replace(aEZ3);
        }
        AppMethodBeat.o(22335);
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0301 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0324 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0482  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x04c2  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0502  */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x079e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007e  */
    @Override // com.tencent.mm.plugin.messenger.foundation.a.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.tencent.mm.storage.as r13, com.tencent.mm.storage.as r14, com.tencent.mm.protocal.protobuf.cpl r15, byte[] r16, boolean r17) {
        /*
        // Method dump skipped, instructions count: 1993
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.bbom.c.b(com.tencent.mm.storage.as, com.tencent.mm.storage.as, com.tencent.mm.protocal.protobuf.cpl, byte[], boolean):void");
    }
}
