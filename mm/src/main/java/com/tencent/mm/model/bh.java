package com.tencent.mm.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.network.aj;
import com.tencent.mm.network.c;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.o;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.protocal.protobuf.cca;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.protocal.protobuf.cme;
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.protocal.protobuf.ell;
import com.tencent.mm.protocal.protobuf.ewr;
import com.tencent.mm.protocal.protobuf.fca;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.protocal.protobuf.hx;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.protocal.protobuf.ia;
import com.tencent.mm.protocal.protobuf.jk;
import com.tencent.mm.protocal.protobuf.qx;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import junit.framework.Assert;

public final class bh extends o implements j.e {
    private static a iDP = null;
    private final int iDM;
    private final j.h iDN;
    private final j.i iDO;

    public interface a {
        void a(j.h hVar, j.i iVar);
    }

    public bh(int i2) {
        AppMethodBeat.i(132239);
        Assert.assertTrue(i2 == 702 || i2 == 701 || i2 == 252 || i2 == 763);
        this.iDM = i2;
        if (i2 == 702 || i2 == 763) {
            this.iDN = new j.a();
            this.iDO = new j.b();
            AppMethodBeat.o(132239);
            return;
        }
        this.iDN = new j.f();
        this.iDO = new j.g();
        AppMethodBeat.o(132239);
    }

    private s sa(int i2) {
        String str;
        byte[] bArr;
        AppMethodBeat.i(132240);
        Log.i("MicroMsg.MMReqRespAuth", "summerauth autoAuthReq authReqFlag:%d, this:%d, stack:%s", Integer.valueOf(i2), Integer.valueOf(hashCode()), Util.getStack());
        j.h hVar = (j.h) getReqObj();
        j.i iVar = (j.i) getRespObj();
        SharedPreferences aVK = bi.aVK();
        int i3 = aVK.getInt("key_auth_update_version", 0);
        Log.d("MicroMsg.MMReqRespAuth", "summerauth updateVersion:%d, clientVersion:%d", Integer.valueOf(i3), Integer.valueOf(d.KyO));
        if (i3 < d.KyO) {
            hVar.setSceneStatus((this.iDM == 702 || this.iDM == 763) ? 12 : 16);
            e.INSTANCE.idkeyStat(148, this.iDM == 702 ? 14 : 13, 1, false);
        } else {
            hVar.setSceneStatus((this.iDM == 702 || this.iDM == 763) ? 2 : 1);
        }
        jk jkVar = new jk();
        jkVar.KOa = i2;
        jkVar.KLf = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        jkVar.KLe = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        ewr ewr = new ewr();
        jkVar.KNY = ewr;
        ewr.KQx = "";
        ewr.KQw = "";
        ewr.Num = "";
        fca fca = new fca();
        jkVar.KNZ = fca;
        fca.MbK = "";
        fca.MbJ = "";
        if (!g.aAc()) {
            Log.e("MicroMsg.MMReqRespAuth", "autoAuthReq build autoauth Req  , failed  acc not ready");
            AppMethodBeat.o(132240);
            return null;
        }
        g.aAi();
        String nullAsNil = Util.nullAsNil((String) g.aAh().azQ().get(2, (Object) null));
        g.aAi();
        p pVar = new p(Util.nullAs((Integer) g.aAh().azQ().get(9, (Object) null), 0));
        if (Util.isNullOrNil(nullAsNil)) {
            str = pVar.toString();
        } else {
            str = nullAsNil;
        }
        g.aAi();
        byte[] a2 = g.aAf().azh().a(pVar.longValue(), "", this.iDM == 252 || this.iDM == 701);
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = pVar;
        objArr[2] = Integer.valueOf(a2 == null ? -1 : a2.length);
        objArr[3] = a2 == null ? BuildConfig.COMMAND : Util.secPrint(Util.dumpHex(a2));
        Log.i("MicroMsg.MMReqRespAuth", "summerauth loginbuf username:%s, qq:%s, len:%d, content:[%s]", objArr);
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        if (Util.isNullOrNil(a2)) {
            bArr = new byte[0];
        } else {
            bArr = a2;
        }
        jkVar.KNX = sKBuiltinBuffer_t.setBuffer(bArr);
        if (this.iDM == 702 || this.iDM == 763) {
            j.a aVar = (j.a) hVar;
            j.b bVar = (j.b) iVar;
            hx hxVar = new hx();
            ia iaVar = new ia();
            aVar.Kzu.KLV = iaVar;
            aVar.Kzu.KLW = hxVar;
            String string = aVK.getString("_auth_key", "");
            Object[] objArr2 = new Object[1];
            objArr2[0] = Integer.valueOf(string == null ? -1 : string.length());
            Log.i("MicroMsg.MMReqRespAuth", "summerauths KEY_SP_SUFFIX keyStr[%s]", objArr2);
            byte[] decodeHexString = Util.decodeHexString(string);
            hy hyVar = new hy();
            if (!Util.isNullOrNil(decodeHexString)) {
                hxVar.KKZ = new SKBuiltinBuffer_t().setBuffer(decodeHexString);
                Log.i("MicroMsg.MMReqRespAuth", "summerauths keyBuf[%s, %s]", Integer.valueOf(hxVar.KKZ.getBuffer().zy.length), Integer.valueOf(decodeHexString.length));
                try {
                    hyVar.parseFrom(decodeHexString);
                } catch (IOException e2) {
                    e.INSTANCE.idkeyStat(148, 15, 1, false);
                    Log.printErrStackTrace("MicroMsg.MMReqRespAuth", e2, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
                }
            } else {
                e.INSTANCE.idkeyStat(148, 16, 1, false);
                hxVar.KKZ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
            }
            if (hyVar.KLT != null) {
                iaVar.KLX = hyVar.KLT;
                Log.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey [%s][%s]", Integer.valueOf(hyVar.KLT.getBuffer().zy.length), Util.dumpHex(hyVar.KLT.getBuffer().zy));
            } else {
                e.INSTANCE.idkeyStat(148, 17, 1, false);
                iaVar.KLX = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                Log.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey null!");
            }
            hxVar.KLK = jkVar;
            hxVar.KFu = MMApplicationContext.getApplicationId();
            Log.i("MicroMsg.MMReqRespAuth", "aesReq.AndroidPackageName [%s]", hxVar.KFu);
            aVar.username = str;
            bVar.dMW = str;
        } else {
            j.f fVar = (j.f) hVar;
            cmg cmg = new cmg();
            cme cme = new cme();
            fVar.Kzy.MrA = cmg;
            fVar.Kzy.MrB = cme;
            cme.Mrz = 2;
            cme.KLK = jkVar;
            cmg.UserName = str;
            g.aAi();
            String nullAsNil2 = Util.nullAsNil((String) g.aAh().azQ().get(3, (Object) null));
            g.aAi();
            cmg.KQi = Util.nullAsNil((String) g.aAh().azQ().get(19, (Object) null));
            cmg.KQv = nullAsNil2;
        }
        AppMethodBeat.o(132240);
        return this;
    }

    @Override // com.tencent.mm.protocal.j.e
    public final int aVJ() {
        AppMethodBeat.i(132241);
        if (g.aAc()) {
            g.aAi();
            g.aAf();
            int uin = com.tencent.mm.kernel.a.getUin();
            AppMethodBeat.o(132241);
            return uin;
        }
        Log.e("MicroMsg.MMReqRespAuth", "dkwt acc NOT Ready , the fucking MMReqRespBase need the fucking uin ???  if u find this log , fuck dk. %s", Util.getStack());
        AppMethodBeat.o(132241);
        return 0;
    }

    @Override // com.tencent.mm.protocal.j.e
    public final s dm(int i2, int i3) {
        AppMethodBeat.i(132242);
        s sa = new bh(i2).sa(i3);
        AppMethodBeat.o(132242);
        return sa;
    }

    public static void a(a aVar) {
        iDP = aVar;
    }

    @Override // com.tencent.mm.protocal.j.e
    public final void a(j.h hVar, j.i iVar, int i2, int i3, String str) {
        AppMethodBeat.i(132243);
        if (!g.aAc()) {
            Log.e("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd but account not ready");
            AppMethodBeat.o(132243);
            return;
        }
        ell ell = iVar.Kzw;
        if (ell == null || ell.Nky == null) {
            Log.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto not set as ret:%s", Integer.valueOf(iVar.getRetCode()));
        } else {
            int i4 = iVar.Kzw.Nky.KLo;
            Log.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto:%s", Integer.valueOf(i4));
            g.aAi();
            g.aAh().hqB.set(47, Integer.valueOf(i4));
            com.tencent.mm.network.g gVar = g.aAg().hqi.iMw;
            if (gVar != null) {
                gVar.fB((i4 & 1) == 0);
            }
        }
        Log.i("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            if (ell.Nkz != null) {
                cr.sk(ell.Nkz.KEl);
                cr.a(ell.Nkz.KEm);
                cr.a(ell.Nkz.KEn);
            }
            if (iDP != null) {
                iDP.a(hVar, iVar);
            }
            AppMethodBeat.o(132243);
        } else if (i2 == 4 && i3 == -301) {
            e.INSTANCE.idkeyStat(148, 18, 1, false);
            Log.i("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC");
            if (ell == null || ell.NkA == null) {
                Log.w("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC but NetworkSectResp is null");
                AppMethodBeat.o(132243);
                return;
            }
            a(true, iVar.Kzw.NkA.KQk, iVar.Kzw.NkA.KQl, iVar.Kzw.NkA.KQj);
            AppMethodBeat.o(132243);
        } else {
            e.INSTANCE.idkeyStat(148, f.KyZ ? 119 : 120, 1, false);
            e.INSTANCE.idkeyStat(148, f.Kza ? 121 : 122, 1, false);
            AppMethodBeat.o(132243);
        }
    }

    public static void a(boolean z, qy qyVar, ctb ctb, ccb ccb) {
        o.a aVar;
        int i2;
        AppMethodBeat.i(132244);
        Object[] objArr = new Object[9];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(qyVar == null ? -1 : qyVar.KXN);
        objArr[2] = Integer.valueOf(qyVar == null ? -1 : qyVar.KXO);
        objArr[3] = Integer.valueOf(ccb == null ? -1 : ccb.oTz);
        objArr[4] = Integer.valueOf(ctb == null ? -1 : ctb.Mya);
        objArr[5] = Integer.valueOf(ctb == null ? -1 : ctb.Myb);
        objArr[6] = Integer.valueOf(ctb == null ? -1 : ctb.Myc);
        objArr[7] = ctb == null ? BuildConfig.COMMAND : ctb.MxY;
        objArr[8] = ctb == null ? BuildConfig.COMMAND : ctb.MxZ;
        Log.i("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo resetnewwork:%b iplist[l:%d s:%d] hostList[%d] noop[%d %d] typing[%d] port[%s] timeout[%s]", objArr);
        if (ccb == null || ccb.oTA == null || ccb.oTA.size() <= 0) {
            Log.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", Util.getStack());
            AppMethodBeat.o(132244);
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.clear();
        if (qyVar != null) {
            Iterator<qx> it = qyVar.KXR.iterator();
            while (it.hasNext()) {
                qx next = it.next();
                String str = "";
                if (next.KXM != null) {
                    str = next.KXM.yO();
                }
                linkedList.add(new com.tencent.mm.protocal.o(next.type, next.KXL.yO(), next.port, str));
                Log.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo short type:%d port:%d ip:%s", Integer.valueOf(next.type), Integer.valueOf(next.port), next.KXL.yO());
            }
        }
        String iz = com.tencent.mm.protocal.o.iz(linkedList);
        LinkedList linkedList2 = new LinkedList();
        if (qyVar != null) {
            Iterator<qx> it2 = qyVar.KXQ.iterator();
            while (it2.hasNext()) {
                qx next2 = it2.next();
                String str2 = "";
                if (next2.KXM != null) {
                    str2 = next2.KXM.yO();
                }
                linkedList2.add(new com.tencent.mm.protocal.o(next2.type, next2.KXL.yO(), next2.port, str2));
                Log.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo long type:%d port:%d ip:%s", Integer.valueOf(next2.type), Integer.valueOf(next2.port), next2.KXL.yO());
            }
        }
        String iz2 = com.tencent.mm.protocal.o.iz(linkedList2);
        Log.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo builtin ip long[%s] short[%s]", iz2, iz);
        g.aAi();
        g.aAh().hqB.set(2, iz);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
        sharedPreferences.edit().putString("builtin_short_ips", iz).commit();
        g.aAi();
        g.aAh().hqB.set(3, iz2);
        if (ctb != null) {
            g.aAi();
            g.aAh().hqB.set(6, ctb.MxY);
            g.aAi();
            g.aAh().hqB.set(7, ctb.MxZ);
            if (ctb.Myc != 0) {
                g.aAi();
                an anVar = g.aAh().hqB;
                if (ctb.Myc > 60) {
                    i2 = 60;
                } else {
                    i2 = ctb.Myc;
                }
                anVar.set(35, Integer.valueOf(i2));
            }
            aj.E((long) ctb.Mya, (long) ctb.Myd);
            aVar = com.tencent.mm.protocal.o.mJ(ctb.MxY, ctb.MxZ);
        } else {
            aVar = null;
        }
        String str3 = "";
        String str4 = "";
        String[] strArr = new String[ccb.oTA.size()];
        String[] strArr2 = new String[ccb.oTA.size()];
        int[] iArr = new int[ccb.oTA.size()];
        Log.d("MicroMsg.MMReqRespAuth", "hostlist.Count=%d", Integer.valueOf(ccb.oTz));
        Iterator<cca> it3 = ccb.oTA.iterator();
        int i3 = 0;
        while (it3.hasNext()) {
            cca next3 = it3.next();
            Log.d("MicroMsg.MMReqRespAuth", "dkidc host org:%s sub:%s", next3.MhX, next3.MhY);
            strArr[i3] = next3.MhX;
            strArr2[i3] = next3.MhY;
            iArr[i3] = next3.MhZ;
            i3++;
            if (!Util.isNullOrNil(next3.MhX) && !Util.isNullOrNil(next3.MhY)) {
                if (next3.MhX.equals(c.jDI)) {
                    g.aAi();
                    g.aAh().hqB.set(24, next3.MhY);
                    str4 = next3.MhY;
                } else if (next3.MhX.equals(c.jDG)) {
                    g.aAi();
                    g.aAh().hqB.set(25, next3.MhY);
                    str3 = next3.MhY;
                } else if (next3.MhX.equals(c.icB) && !Util.isNullOrNil(next3.MhY)) {
                    sharedPreferences.edit().putString(c.icB, next3.MhY).commit();
                }
            }
        }
        g.aAi();
        com.tencent.mm.network.g gVar = g.aAg().hqi.iMw;
        if (strArr.length > 0 && gVar != null) {
            gVar.setHostInfo(strArr, strArr2, iArr);
        }
        if (!Util.isNullOrNil(str3)) {
            g.aAi();
            g.aAh().hqB.set(25, str3);
        }
        if (!Util.isNullOrNil(str4)) {
            g.aAi();
            g.aAh().hqB.set(24, str4);
        }
        if (!(gVar == null || aVar == null)) {
            gVar.a(z, iz, iz2, aVar.KzK, aVar.KzL, aVar.KzM, aVar.KzN, str4, str3);
        }
        AppMethodBeat.o(132244);
    }

    public static SharedPreferences aVK() {
        AppMethodBeat.i(259564);
        SharedPreferences aVK = bi.aVK();
        AppMethodBeat.o(259564);
        return aVK;
    }

    @Override // com.tencent.mm.ak.o
    public final l.d getReqObjImp() {
        return this.iDN;
    }

    @Override // com.tencent.mm.network.s
    public final l.e getRespObj() {
        return this.iDO;
    }

    @Override // com.tencent.mm.network.s
    public final int getType() {
        AppMethodBeat.i(132246);
        int funcId = this.iDN.getFuncId();
        AppMethodBeat.o(132246);
        return funcId;
    }

    @Override // com.tencent.mm.network.s
    public final String getUri() {
        AppMethodBeat.i(132247);
        String uri = this.iDN.getUri();
        AppMethodBeat.o(132247);
        return uri;
    }

    public static int a(s sVar) {
        byte[] bArr;
        byte[] bArr2;
        int length;
        AppMethodBeat.i(132248);
        j.h hVar = (j.h) sVar.getReqObj();
        j.i iVar = (j.i) sVar.getRespObj();
        Log.i("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo type:%d, hashcode:%d, ret:%d, stack[%s]", Integer.valueOf(hVar.getFuncId()), Integer.valueOf(sVar.hashCode()), Integer.valueOf(iVar.hku), Util.getStack());
        if (iVar.hku != 0) {
            Log.d("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", Integer.valueOf(iVar.hku));
            int i2 = iVar.hku;
            AppMethodBeat.o(132248);
            return i2;
        }
        ell ell = iVar.Kzw;
        int i3 = ell.Nkx;
        if ((i3 & 1) != 0) {
            hk hkVar = ell.Nky;
            int i4 = hkVar.KLn;
            Log.i("MicroMsg.MMReqRespAuth", "decodeAndRetriveAccInfo authResultFlag:%d UpdateFlag:%d ", Integer.valueOf(i4), Integer.valueOf(hkVar.KLm));
            byte[] a2 = z.a(hkVar.KLq);
            byte[] a3 = z.a(hkVar.KLr);
            aif aif = hkVar.KKX;
            byte[] a4 = z.a(hkVar.KKY);
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(aif.KLU.getILen());
            objArr[1] = Integer.valueOf(aif.LrO);
            objArr[2] = Integer.valueOf(a4 == null ? -1 : a4.length);
            objArr[3] = Util.secPrint(Util.dumpHex(a4));
            objArr[4] = Util.secPrint(Util.dumpHex(a2));
            objArr[5] = Util.secPrint(Util.dumpHex(a3));
            Log.d("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s, clientSession[%s], serverSession[%s]", objArr);
            byte[] a5 = z.a(aif.KLU);
            byte[] bArr3 = hVar.Kzv;
            if (!Util.isNullOrNil(a5)) {
                Object[] objArr2 = new Object[4];
                objArr2[0] = Integer.valueOf(a5.length);
                objArr2[1] = Util.secPrint(Util.dumpHex(a5));
                objArr2[2] = Integer.valueOf(bArr3 == null ? -1 : bArr3.length);
                objArr2[3] = Util.secPrint(Util.dumpHex(bArr3));
                Log.d("MicroMsg.MMReqRespAuth", "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s", objArr2);
                PByteArray pByteArray = new PByteArray();
                int computerKeyWithAllStr = MMProtocalJni.computerKeyWithAllStr(aif.LrO, a5, bArr3, pByteArray, 0);
                bArr = pByteArray.value;
                Object[] objArr3 = new Object[3];
                objArr3[0] = Integer.valueOf(computerKeyWithAllStr);
                if (bArr == null) {
                    length = -1;
                } else {
                    length = bArr.length;
                }
                objArr3[1] = Integer.valueOf(length);
                objArr3[2] = Util.secPrint(Util.dumpHex(bArr));
                Log.i("MicroMsg.MMReqRespAuth", "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s", objArr3);
            } else {
                e.INSTANCE.idkeyStat(148, 24, 1, false);
                Log.w("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key is null!");
                bArr = null;
            }
            if (bArr != null) {
                bArr2 = bArr;
            } else {
                bArr2 = new byte[0];
            }
            iVar.KzA = bArr2;
            if ((i4 & 4) != 0) {
                Log.d("MicroMsg.MMReqRespAuth", "summerauth must decode session key");
                if (!Util.isNullOrNil(bArr)) {
                    byte[] aesDecrypt = MMProtocalJni.aesDecrypt(a4, bArr);
                    Object[] objArr4 = new Object[4];
                    objArr4[0] = Integer.valueOf(a4 == null ? -1 : a4.length);
                    objArr4[1] = Util.secPrint(Util.dumpHex(a4));
                    objArr4[2] = Integer.valueOf(aesDecrypt == null ? -1 : aesDecrypt.length);
                    objArr4[3] = Util.secPrint(Util.dumpHex(aesDecrypt));
                    Log.d("MicroMsg.MMReqRespAuth", "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s", objArr4);
                    if (!Util.isNullOrNil(aesDecrypt)) {
                        Log.d("MicroMsg.MMReqRespAuth", "summerauth decode session key succ session:%s", Util.secPrint(Util.dumpHex(aesDecrypt)));
                        iVar.b(aesDecrypt, a2, a3);
                        iVar.hku = 1;
                    } else {
                        e.INSTANCE.idkeyStat(148, 25, 1, false);
                        Log.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed ret null!");
                        iVar.b(new byte[0], a2, a3);
                        iVar.hku = 2;
                    }
                } else {
                    e.INSTANCE.idkeyStat(148, 26, 1, false);
                    Log.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed as agreedECDHKey is null!");
                    iVar.b(new byte[0], a2, a3);
                    iVar.hku = 2;
                }
            } else {
                e.INSTANCE.idkeyStat(148, 27, 1, false);
                Log.d("MicroMsg.MMReqRespAuth", "summerauth not need decode session key");
                iVar.b(a4, a2, a3);
                iVar.hku = 1;
            }
        } else {
            Log.d("MicroMsg.MMReqRespAuth", "summerauth auth sect not set so ret failed AuthSectResp[%s]", ell.Nky);
            iVar.b(new byte[0], new byte[0], new byte[0]);
            iVar.hku = 2;
        }
        if ((i3 & 2) != 0) {
            iVar.dMW = ell.Nkz.UserName;
        } else {
            Log.d("MicroMsg.MMReqRespAuth", "summerauth acct sect not set!");
        }
        int i5 = iVar.hku;
        AppMethodBeat.o(132248);
        return i5;
    }
}
