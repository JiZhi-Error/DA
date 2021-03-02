package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.xm;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.adn;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.kk;
import com.tencent.mm.protocal.protobuf.kl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Set;
import junit.framework.Assert;

public final class b extends q implements m {
    private Set<String> Bqe;
    private i callback;

    public b(Set<String> set) {
        AppMethodBeat.i(27712);
        Assert.assertTrue(true);
        this.Bqe = set;
        AppMethodBeat.o(27712);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(27713);
        this.callback = iVar;
        LinkedList<String> linkedList = new LinkedList();
        for (String str : this.Bqe) {
            linkedList.add(str);
        }
        if (linkedList.size() == 0) {
            Log.e("MicroMsg.NetSceneBatchGetContactProfile", f.apq() + "doScene reqSize ==0");
            AppMethodBeat.o(27713);
            return -1;
        }
        d.a aVar = new d.a();
        aVar.iLN = new kk();
        aVar.iLO = new kl();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcontactprofile";
        aVar.funcId = 140;
        aVar.iLP = 28;
        aVar.respCmdId = 1000000028;
        d aXF = aVar.aXF();
        LinkedList<dqi> linkedList2 = new LinkedList<>();
        for (String str2 : linkedList) {
            linkedList2.add(z.Su(str2));
        }
        ((kk) aXF.iLK.iLR).KGP = linkedList2;
        ((kk) aXF.iLK.iLR).KOC = 1;
        ((kk) aXF.iLK.iLR).oTz = linkedList2.size();
        int dispatch = dispatch(gVar, aXF, this);
        AppMethodBeat.o(27713);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 140;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 50;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(27714);
        if (i3 == 0 && i4 == 0) {
            if (g(sVar) && this.Bqe.size() > 0) {
                doScene(dispatcher(), this.callback);
            }
            Log.d("MicroMsg.NetSceneBatchGetContactProfile", "left cnt = " + this.Bqe.size());
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(27714);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(27714);
    }

    private boolean g(s sVar) {
        adn adn;
        boolean z;
        AppMethodBeat.i(27715);
        kl klVar = (kl) ((d) sVar).iLL.iLR;
        if (klVar == null) {
            Log.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp: resp is null");
            AppMethodBeat.o(27715);
            return false;
        } else if (sVar.getRespObj().getRetCode() == 1) {
            Log.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : endless loop, should stop");
            AppMethodBeat.o(27715);
            return false;
        } else if (sVar.getRespObj().getRetCode() == -1) {
            Log.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : server err, can try again");
            AppMethodBeat.o(27715);
            return true;
        } else {
            LinkedList<SKBuiltinBuffer_t> linkedList = klVar.KOD;
            if (linkedList == null) {
                AppMethodBeat.o(27715);
                return false;
            }
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                try {
                    adn = (adn) new adn().parseFrom(z.a(linkedList.get(i2)));
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.NetSceneBatchGetContactProfile", e2, "", new Object[0]);
                    Log.e("MicroMsg.NetSceneBatchGetContactProfile", "ContactProfile.parseFrom fail");
                    adn = null;
                }
                if (adn == null || adn.UserName == null) {
                    Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: profile name is null");
                    z = false;
                } else if (!this.Bqe.contains(adn.UserName)) {
                    Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: resp data not in req");
                    z = false;
                } else {
                    this.Bqe.remove(adn.UserName);
                    bg.aVF();
                    as Kn = c.aSN().Kn(adn.UserName);
                    if (Kn == null || ((int) Kn.gMZ) == 0) {
                        Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find this contact");
                        z = false;
                    } else {
                        Kn.setUsername(adn.UserName);
                        Kn.BC(adn.ked);
                        Kn.setType(adn.LoG & adn.LoH);
                        Kn.setNickname(adn.oUJ);
                        Kn.BF(adn.LoE);
                        Kn.BG(adn.LoF);
                        Kn.nj(adn.kdY);
                        Kn.BD(adn.LoI);
                        Kn.BI(adn.LoL);
                        Kn.BJ(adn.LoK);
                        Kn.nl(adn.LoM);
                        Kn.BE(adn.LoP);
                        Kn.nm(adn.LoQ);
                        bg.aVF();
                        if (c.aSN().c(Kn.field_username, Kn) == -1) {
                            Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update contact failed");
                        }
                        if (as.bjo(adn.UserName)) {
                            d aKB = g.eFZ().aKB(adn.UserName);
                            if (aKB == null || Util.nullAsNil(aKB.getUsername()).length() <= 0) {
                                Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find qcontact");
                                z = false;
                            } else {
                                aKB.extInfo = adn.xNU;
                                aKB.Bqh = (long) adn.LoS;
                                aKB.Bqi = (long) adn.LoT;
                                aKB.cSx = 52;
                                if (!g.eFZ().a(adn.UserName, aKB)) {
                                    Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update qcontact failed");
                                }
                            }
                        }
                        if (as.bjm(adn.UserName)) {
                            xm xmVar = new xm();
                            xmVar.edJ.opType = 0;
                            xmVar.edJ.dWq = adn.UserName;
                            xmVar.edJ.dWr = adn.LoS;
                            xmVar.edJ.dWs = adn.LoJ;
                            EventCenter.instance.publish(xmVar);
                        }
                        z = true;
                    }
                }
                if (!z) {
                    AppMethodBeat.o(27715);
                    return false;
                }
            }
            AppMethodBeat.o(27715);
            return true;
        }
    }
}
