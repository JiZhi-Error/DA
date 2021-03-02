package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.la;
import com.tencent.mm.protocal.protobuf.lb;
import com.tencent.mm.protocal.protobuf.lc;
import com.tencent.mm.protocal.protobuf.ld;
import com.tencent.mm.protocal.protobuf.le;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import java.util.Iterator;
import java.util.LinkedList;

public final class k extends q implements m {
    private i heq = null;
    private d hhm = null;
    private String[] rAr;

    public k(String[] strArr, String str) {
        AppMethodBeat.i(23380);
        this.rAr = strArr;
        Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, %s, list = %d", str, 1);
        d.a aVar = new d.a();
        aVar.iLN = new lc();
        aVar.iLO = new ld();
        aVar.funcId = 542;
        aVar.uri = "/cgi-bin/micromsg-bin/batchsearchharddevice";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        lc lcVar = (lc) this.hhm.iLK.iLR;
        LinkedList<lb> linkedList = new LinkedList<>();
        for (int i2 = 0; i2 <= 0; i2++) {
            String str2 = strArr[0];
            if (str2 != null) {
                lb lbVar = new lb();
                lbVar.KOS = str2;
                linkedList.add(lbVar);
                Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, item = %s", str2);
            }
        }
        lcVar.KOT = linkedList;
        if (!Util.isNullOrNil(str)) {
            la laVar = new la();
            laVar.KOR = str;
            lcVar.KOU = laVar;
        }
        lcVar.KOV = 3;
        AppMethodBeat.o(23380);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(23381);
        Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "onGYNetEnd, netId = %d, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.rAr != null && this.rAr.length == 1) {
            Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "device mac is  = %s", this.rAr[0]);
        }
        if (sVar == null) {
            Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == rr");
            AppMethodBeat.o(23381);
        } else if (this.hhm.getType() != sVar.getType()) {
            Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "mReqResp.getType(%d) != rr.getType(%d)", Integer.valueOf(this.hhm.getType()), Integer.valueOf(sVar.getType()));
            AppMethodBeat.o(23381);
        } else {
            if (i3 == 0 && i4 == 0) {
                Iterator<le> it = cKD().KOW.iterator();
                while (it.hasNext()) {
                    le next = it.next();
                    Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "BatchSearchHardDeviceResp, ret = %d, bind ticket = %s, mac = %s, device name = %s", Integer.valueOf(next.Ret), next.KOX, next.KOS, next.oTI);
                    if (next.KOY == null) {
                        Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == item.Contact");
                    } else {
                        cpl cpl = next.KOY;
                        if (cpl == null) {
                            Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "unable to parse mod contact");
                        } else {
                            String a2 = z.a(cpl.Lqk);
                            String nullAsNil = Util.nullAsNil(cpl.Mvn);
                            if (!Util.isNullOrNil(a2) || !Util.isNullOrNil(nullAsNil)) {
                                Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact : %s", a2);
                                bg.aVF();
                                as Kn = c.aSN().Kn(a2);
                                if (Kn == null || !a2.equals(Kn.field_encryptUsername)) {
                                    as asVar = new as(a2);
                                    asVar.BC(cpl.ked);
                                    asVar.setType(cpl.LoG & cpl.LoH);
                                    if (!Util.isNullOrNil(nullAsNil)) {
                                        asVar.BK(nullAsNil);
                                    } else if (Kn != null && ((int) Kn.gMZ) > 0) {
                                        asVar.BK(Kn.field_encryptUsername);
                                    }
                                    asVar.gMZ = Kn == null ? 0 : (long) ((int) Kn.gMZ);
                                    asVar.setNickname(z.a(cpl.Mjj));
                                    asVar.BF(z.a(cpl.LpA));
                                    asVar.BG(z.a(cpl.LpB));
                                    asVar.nj(cpl.kdY);
                                    asVar.nl(cpl.LoM);
                                    asVar.BE(z.a(cpl.Mvh));
                                    asVar.nm(cpl.LoQ);
                                    asVar.nn(cpl.kec);
                                    asVar.Cb(RegionCodeDecoder.bq(cpl.keh, cpl.kdZ, cpl.kea));
                                    asVar.BV(cpl.keb);
                                    asVar.nf(cpl.MmK);
                                    asVar.Ca(cpl.MmL);
                                    asVar.setSource(cpl.xub);
                                    asVar.ne(cpl.MmO);
                                    asVar.BH(cpl.MmN);
                                    if (ab.JK(cpl.MmM)) {
                                        asVar.BZ(cpl.MmM);
                                    }
                                    asVar.no((int) Util.nowSecond());
                                    asVar.BD(z.a(cpl.MuI));
                                    asVar.BI(z.a(cpl.MuK));
                                    asVar.BJ(z.a(cpl.MuJ));
                                    asVar.Cc(cpl.KHk);
                                    asVar.Cd(cpl.Mvw);
                                    if (Kn != null && !Util.nullAsNil(Kn.fuS).equals(Util.nullAsNil(cpl.Mvw))) {
                                        com.tencent.mm.bd.c.bez();
                                        com.tencent.mm.bd.c.Pt(a2);
                                    }
                                    bg.aVF();
                                    c.aSN().bjQ(a2);
                                    if (Util.isNullOrNil(asVar.field_username)) {
                                        Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "dkinit dealModContactExtInfo failed invalid contact");
                                    } else {
                                        String str2 = asVar.field_username;
                                        p.aYB().b(com.tencent.mm.aj.c.a(str2, cpl));
                                        ebj ebj = cpl.MmQ;
                                        if (!asVar.field_username.endsWith("@chatroom") && ebj != null) {
                                            Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsFlag modcontact " + ebj.kej + " " + cpl.Lqk);
                                            Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBg modcontact " + ebj.kek);
                                            Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ebj.kel);
                                            Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ebj.Nbc);
                                            if (o.DCN != null) {
                                                o.DCN.a(asVar.field_username, ebj);
                                            }
                                        }
                                        String aTY = com.tencent.mm.model.z.aTY();
                                        if (aTY != null && !aTY.equals(str2)) {
                                            com.tencent.mm.api.c MT = ag.bah().MT(str2);
                                            MT.field_username = str2;
                                            MT.field_brandList = cpl.kei;
                                            aeq aeq = cpl.MmR;
                                            if (aeq != null) {
                                                MT.field_brandFlag = aeq.kem;
                                                MT.field_brandInfo = aeq.keo;
                                                MT.field_brandIconURL = aeq.kep;
                                                MT.field_extInfo = aeq.ken;
                                                MT.field_attrSyncVersion = null;
                                                MT.field_incrementUpdateTime = 0;
                                            }
                                            if (!ag.bah().h(MT)) {
                                                ag.bah().g(MT);
                                            }
                                            asVar.np(MT.field_type);
                                        }
                                    }
                                    asVar.nh(cpl.DeleteFlag);
                                    if (!(cpl.Mvs == null || cpl.Mvs.KHD == null)) {
                                        asVar.Ce(cpl.Mvs.KHD.KPG);
                                        asVar.Cf(cpl.Mvs.KHD.KPH);
                                        asVar.Cg(cpl.Mvs.KHD.KPI);
                                    }
                                    if (ab.JE(a2)) {
                                        asVar.aqZ();
                                    }
                                    if (asVar.gBM()) {
                                        asVar.arc();
                                    }
                                    if (!Util.isNullOrNil(nullAsNil)) {
                                        bg.aVF();
                                        c.aSN().d(nullAsNil, asVar);
                                    } else {
                                        bg.aVF();
                                        c.aSN().ao(asVar);
                                    }
                                    if (!(Kn == null || (Kn.field_type & 2048) == (asVar.field_type & 2048))) {
                                        if ((asVar.field_type & 2048) != 0) {
                                            bg.aVF();
                                            c.aST().bke(asVar.field_username);
                                        } else {
                                            bg.aVF();
                                            c.aST().bkf(asVar.field_username);
                                        }
                                    }
                                } else {
                                    Log.w("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "cat's replace user with stranger");
                                }
                            } else {
                                Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact user is null user:%s enuser:%s", a2, nullAsNil);
                            }
                        }
                    }
                }
            }
            this.heq.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(23381);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 542;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(23382);
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.hhm, this);
        AppMethodBeat.o(23382);
        return dispatch;
    }

    public final ld cKD() {
        if (this.hhm == null || this.hhm.iLL.iLR == null) {
            return null;
        }
        return (ld) this.hhm.iLL.iLR;
    }
}
