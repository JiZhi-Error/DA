package com.tencent.mars.smc;

import com.tencent.mm.protocal.a.a.a;
import com.tencent.mm.protocal.a.a.b;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.a.a.d;
import com.tencent.mm.protocal.a.a.e;
import com.tencent.mm.protocal.a.a.f;
import com.tencent.mm.protocal.a.a.g;
import com.tencent.mm.protocal.a.a.h;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.a.a.j;
import com.tencent.mm.protocal.a.a.k;
import com.tencent.mm.protocal.a.a.l;
import com.tencent.mm.protocal.a.a.m;
import com.tencent.mm.protocal.a.a.n;
import com.tencent.mm.protocal.a.a.o;
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.protocal.protobuf.aak;
import com.tencent.mm.protocal.protobuf.aal;
import com.tencent.mm.protocal.protobuf.blg;
import com.tencent.mm.protocal.protobuf.blh;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.protocal.protobuf.cct;
import com.tencent.mm.protocal.protobuf.cfu;
import com.tencent.mm.protocal.protobuf.ctq;
import com.tencent.mm.protocal.protobuf.eeo;
import java.util.ArrayList;
import java.util.LinkedList;

public class SmcProtoBufUtil {
    public static aak toMMReportKvReq(i iVar) {
        aak aak = new aak();
        aak.Lly = iVar.KAB;
        aak.Llz = iVar.KAR;
        aak.LlA = iVar.KAP;
        for (int i2 = 0; i2 < iVar.KAS.size(); i2++) {
            e eVar = iVar.KAS.get(i2);
            aaj aaj = new aaj();
            aaj.rBx = eVar.uin;
            aaj.KOj = eVar.KAz;
            aaj.Llx = eVar.nettype;
            aaj.hif = eVar.KAL;
            aaj.hid = eVar.KAJ;
            aaj.hie = eVar.KAK;
            aaj.hig = eVar.KAM;
            aaj.hih = eVar.KAN;
            aaj.oUA = eVar.KAO;
            for (int i3 = 0; i3 < eVar.KAA.size(); i3++) {
                d dVar = eVar.KAA.get(i3);
                cfu cfu = new cfu();
                cfu.MlF = dVar.KAy;
                cfu.MlG = dVar.KAH;
                cfu.MlH = dVar.KAI;
                cfu.Lrp = dVar.DhD;
                cfu.oTz = dVar.count;
                aaj.xKD.add(cfu);
            }
            aak.LlB.add(aaj);
        }
        return aak;
    }

    public static aak toMMReportIdkeyReq(g gVar) {
        aak aak = new aak();
        aak.Lly = gVar.KAB;
        aak.Llz = gVar.KAR;
        aak.LlA = 0;
        for (int i2 = 0; i2 < gVar.KAS.size(); i2++) {
            b bVar = gVar.KAS.get(i2);
            aaj aaj = new aaj();
            aaj.rBx = bVar.uin;
            aaj.KOj = bVar.KAz;
            aaj.Llx = bVar.nettype;
            for (int i3 = 0; i3 < bVar.KAA.size(); i3++) {
                a aVar = bVar.KAA.get(i3);
                cfu cfu = new cfu();
                cfu.MlF = aVar.KAy;
                cfu.Lrp = 0;
                cfu.MlH = 0;
                cfu.oTz = aVar.count;
                cfu.MlG = com.tencent.mm.bw.b.cD(Integer.toString(aVar.value).getBytes());
                aaj.xKD.add(cfu);
            }
            aak.LlB.add(aaj);
        }
        return aak;
    }

    private static o fillStrategyTable(LinkedList<eeo> linkedList) {
        o oVar = new o();
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            eeo eeo = linkedList.get(i2);
            m mVar = new m();
            mVar.KBe = eeo.NeL;
            mVar.KBf = eeo.NeM;
            for (int i3 = 0; i3 < eeo.NeN.size(); i3++) {
                ctq ctq = eeo.NeN.get(i3);
                n nVar = new n();
                nVar.KAy = ctq.MlF;
                nVar.KBh = ctq.MyV;
                nVar.KBi = ctq.MyT;
                nVar.KBj = ctq.MyU;
                nVar.KBk = ctq.MyW;
                nVar.KBl = ctq.MyX;
                nVar.KBm = ctq.MyY;
                nVar.type = ctq.oUv;
                mVar.KBg.add(nVar);
            }
            oVar.KBn.add(mVar);
        }
        return oVar;
    }

    public static j toSmcReportKvResp(aal aal) {
        j jVar = new j();
        jVar.ret = aal.Ret;
        jVar.KAB = aal.LlE;
        jVar.KAC = aal.LlF;
        jVar.KAP = aal.LlG;
        jVar.KAF = aal.LlK;
        jVar.KAU = aal.LlL;
        jVar.KAG = aal.LlM;
        jVar.KAD = fillStrategyTable(aal.LlH);
        jVar.KAE = fillStrategyTable(aal.LlI);
        jVar.KAQ = fillStrategyTable(aal.LlJ);
        return jVar;
    }

    public static h toSmcReportIdkeyResp(aal aal) {
        h hVar = new h();
        hVar.ret = aal.Ret;
        hVar.KAB = aal.LlE;
        hVar.KAC = aal.LlF;
        hVar.KAF = aal.LlK;
        hVar.KAU = aal.LlL;
        hVar.KAG = aal.LlM;
        hVar.KAD = fillStrategyTable(aal.LlH);
        hVar.KAE = fillStrategyTable(aal.LlI);
        return hVar;
    }

    public static blg toMMGetStrategyReq() {
        blg blg = new blg();
        ArrayList<Integer> strategyVersions = SmcLogic.getStrategyVersions();
        if (strategyVersions.size() != 6) {
            return null;
        }
        blg.Lly = strategyVersions.get(0).intValue();
        blg.Llz = strategyVersions.get(1).intValue();
        blg.LlA = strategyVersions.get(2).intValue();
        blg.LUj = strategyVersions.get(3).intValue();
        blg.LUk = strategyVersions.get(4).intValue();
        blg.LUl = strategyVersions.get(5).intValue();
        return blg;
    }

    public static f toSmcKVStrategyResp(blh blh) {
        f fVar = new f();
        fVar.ret = blh.Ret;
        fVar.KAB = blh.LUj;
        fVar.KAC = blh.LUk;
        fVar.KAP = blh.LUl;
        fVar.KAF = blh.LlK;
        fVar.KAG = blh.LlM;
        fVar.KAD = fillStrategyTable(blh.LUm);
        fVar.KAE = fillStrategyTable(blh.LUn);
        fVar.KAQ = fillStrategyTable(blh.LUo);
        return fVar;
    }

    public static c toSmcIdkeyStrategyResp(blh blh) {
        c cVar = new c();
        cVar.ret = blh.Ret;
        cVar.KAB = blh.LlE;
        cVar.KAC = blh.LlF;
        cVar.KAF = blh.LlK;
        cVar.KAG = blh.LlM;
        cVar.KAD = fillStrategyTable(blh.LlH);
        cVar.KAE = fillStrategyTable(blh.LlI);
        return cVar;
    }

    public static ccs toMMSelfMonitor(k kVar) {
        ccs ccs = new ccs();
        ccs.Miz = kVar.KAV;
        for (int i2 = 0; i2 < kVar.KAW.size(); i2++) {
            cct cct = new cct();
            l lVar = kVar.KAW.get(i2);
            cct.MiA = lVar.KAX;
            cct.dDH = lVar.action;
            cct.MiB = lVar.KAY;
            cct.MiC = lVar.KAZ;
            cct.MiD = lVar.KBa;
            cct.MiE = lVar.KBb;
            cct.MiF = lVar.KBc;
            cct.MiG = lVar.KBd;
            ccs.xKD.add(cct);
        }
        return ccs;
    }
}
