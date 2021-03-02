package com.tencent.mm.modelfriend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.o;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.n;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.protocal.protobuf.dyh;
import com.tencent.mm.protocal.protobuf.dyx;
import com.tencent.mm.protocal.protobuf.eer;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;

public final class a extends q implements m {
    public static AbstractC0450a iUI;
    i callback;
    public final s iMO;
    private int iMt;

    /* renamed from: com.tencent.mm.modelfriend.a$a  reason: collision with other inner class name */
    public interface AbstractC0450a {
        String bbV();
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str, 11, str2, str3, str4);
        AppMethodBeat.i(134115);
        n.a aVar = (n.a) this.iMO.getReqObj();
        aVar.KzI.KPU = str5;
        aVar.KzI.KPV = str6;
        AppMethodBeat.o(134115);
    }

    public a(String str, int i2, String str2, String str3, String str4) {
        this(str, i2, str2, 0, str3);
        AppMethodBeat.i(134116);
        ((n.a) this.iMO.getReqObj()).KzI.KLk = str4;
        AppMethodBeat.o(134116);
    }

    public a(String str, int i2, String str2, int i3, String str3) {
        this(str, i2, str2, i3, str3, 0);
    }

    public a(String str, int i2, String str2, int i3, String str3, int i4) {
        AppMethodBeat.i(134117);
        this.callback = null;
        this.iMt = 2;
        this.iMO = new b();
        n.a aVar = (n.a) this.iMO.getReqObj();
        aVar.KzI.KMz = i2;
        Log.d("MicroMsg.NetSceneBindMobileForReg", "Get mobile:" + str + " opcode:" + i2 + " verifyCode:" + str2);
        aVar.KzI.KPP = str;
        aVar.KzI.KPQ = str2;
        aVar.KzI.KPZ = i4;
        aVar.KzI.KPR = i3;
        aVar.KzI.KPS = str3;
        aVar.KzI.rBI = LocaleUtil.getApplicationLanguage();
        aVar.KzI.KLN = com.tencent.mm.kernel.a.azt();
        if (Util.isNullOrNil(aVar.KzI.KPU) && Util.isNullOrNil(aVar.KzI.KPV)) {
            aVar.KzI.KPU = iUI != null ? iUI.bbV() : "";
            aVar.KzI.KPV = d.DEVICE_NAME;
        }
        AppMethodBeat.o(134117);
    }

    public final void Oj(String str) {
        AppMethodBeat.i(222847);
        ((n.a) this.iMO.getReqObj()).KzI.KQf = str;
        AppMethodBeat.o(222847);
    }

    public final void sZ(int i2) {
        AppMethodBeat.i(134118);
        ((n.a) this.iMO.getReqObj()).KzI.KPX = i2;
        AppMethodBeat.o(134118);
    }

    public final void ta(int i2) {
        AppMethodBeat.i(134119);
        ((n.a) this.iMO.getReqObj()).KzI.KPY = i2;
        AppMethodBeat.o(134119);
    }

    public final int Vj() {
        AppMethodBeat.i(134120);
        int i2 = ((n.a) this.iMO.getReqObj()).KzI.KMz;
        AppMethodBeat.o(134120);
        return i2;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(134121);
        this.callback = iVar;
        n.a aVar = (n.a) this.iMO.getReqObj();
        if (aVar.KzI.KPP == null || aVar.KzI.KPP.length() <= 0) {
            Log.e("MicroMsg.NetSceneBindMobileForReg", "doScene getMobile Error: " + aVar.KzI.KPP);
            AppMethodBeat.o(134121);
            return -1;
        } else if ((aVar.KzI.KMz == 6 || aVar.KzI.KMz == 9) && (aVar.KzI.KPQ == null || aVar.KzI.KPQ.length() <= 0)) {
            Log.e("MicroMsg.NetSceneBindMobileForReg", "doScene getVerifyCode Error: " + aVar.KzI.KPP);
            AppMethodBeat.o(134121);
            return -1;
        } else {
            int dispatch = dispatch(gVar, this.iMO, this);
            AppMethodBeat.o(134121);
            return dispatch;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 145;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 3;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final void setSecurityCheckError(q.a aVar) {
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(134122);
        Log.i("MicroMsg.NetSceneBindMobileForReg", "dkidc onGYNetEnd  errType:%d errCode:%d", Integer.valueOf(i3), Integer.valueOf(i4));
        n.b bVar = (n.b) sVar.getRespObj();
        if (bVar == null || bVar.KzJ == null) {
            Log.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg not set as ret:%s", bVar);
        } else {
            int i5 = bVar.KzJ.KLo;
            Log.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg:%s", Integer.valueOf(i5));
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().hqB.set(47, Integer.valueOf(i5));
            g gVar = com.tencent.mm.kernel.g.aAg().hqi.iMw;
            if (gVar != null) {
                gVar.fB((i5 & 1) == 0);
            }
        }
        if (i3 == 4 && i4 == -301) {
            bh.a(true, bVar.KzJ.KQk, bVar.KzJ.KQl, bVar.KzJ.KQj);
            this.iMt--;
            if (this.iMt <= 0) {
                this.callback.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(134122);
                return;
            }
            doScene(dispatcher(), this.callback);
            AppMethodBeat.o(134122);
        } else if (i3 == 4 && i4 == -240) {
            Log.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindopreg MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", Integer.valueOf(this.iMt));
            this.iMt--;
            if (this.iMt <= 0) {
                this.callback.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(134122);
                return;
            }
            doScene(dispatcher(), this.callback);
            AppMethodBeat.o(134122);
        } else if (i3 == 4 && i4 == -102) {
            final int i6 = sVar.getReqObj().getRsaInfo().ver;
            Log.d("MicroMsg.NetSceneBindMobileForReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i6));
            com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.modelfriend.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(134113);
                    new com.tencent.mm.modelsimple.m().doScene(a.this.dispatcher(), new i() {
                        /* class com.tencent.mm.modelfriend.a.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                            AppMethodBeat.i(134112);
                            Log.d("MicroMsg.NetSceneBindMobileForReg", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3));
                            if (i2 == 0 && i3 == 0) {
                                a.this.doScene(a.this.dispatcher(), a.this.callback);
                                AppMethodBeat.o(134112);
                                return;
                            }
                            a.this.callback.onSceneEnd(i2, i3, "", a.this);
                            AppMethodBeat.o(134112);
                        }
                    });
                    AppMethodBeat.o(134113);
                }
            });
            AppMethodBeat.o(134122);
        } else if (i3 == 4 && (i4 == -305 || i4 == -306)) {
            Log.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindmobilereg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", Integer.valueOf(i4), Integer.valueOf(f.Kze));
            doScene(dispatcher(), this.callback);
            AppMethodBeat.o(134122);
        } else if (i3 == 0 && i4 == 0) {
            bh.a(false, bVar.KzJ.KQk, bVar.KzJ.KQl, bVar.KzJ.KQj);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(134122);
        } else {
            Log.e("MicroMsg.NetSceneBindMobileForReg", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(134122);
        }
    }

    public final String bbF() {
        AppMethodBeat.i(134123);
        String str = ((n.b) this.iMO.getRespObj()).KzJ.KQi;
        AppMethodBeat.o(134123);
        return str;
    }

    public final String getUsername() {
        AppMethodBeat.i(134124);
        String str = ((n.b) this.iMO.getRespObj()).KzJ.Username;
        AppMethodBeat.o(134124);
        return str;
    }

    public final String bbG() {
        AppMethodBeat.i(134125);
        String str = ((n.b) this.iMO.getRespObj()).KzJ.dHx;
        AppMethodBeat.o(134125);
        return str;
    }

    public final String bbH() {
        AppMethodBeat.i(134126);
        String str = ((n.b) this.iMO.getRespObj()).KzJ.KLk;
        AppMethodBeat.o(134126);
        return str;
    }

    public final String bbI() {
        AppMethodBeat.i(134127);
        String str = ((n.b) this.iMO.getRespObj()).KzJ.KQp;
        AppMethodBeat.o(134127);
        return str;
    }

    public final int bbJ() {
        AppMethodBeat.i(134128);
        int i2 = ((n.b) this.iMO.getRespObj()).KzJ.KPZ;
        AppMethodBeat.o(134128);
        return i2;
    }

    public final String bbK() {
        AppMethodBeat.i(134129);
        String str = ((n.b) this.iMO.getRespObj()).KzJ.KQr;
        AppMethodBeat.o(134129);
        return str;
    }

    public final String bbL() {
        AppMethodBeat.i(134130);
        String str = ((n.b) this.iMO.getRespObj()).KzJ.KQs;
        AppMethodBeat.o(134130);
        return str;
    }

    public final cta bbM() {
        AppMethodBeat.i(222848);
        cta cta = ((n.b) this.iMO.getRespObj()).KzJ.KQe;
        AppMethodBeat.o(222848);
        return cta;
    }

    public final void tb(int i2) {
        AppMethodBeat.i(222849);
        ((n.a) this.iMO.getReqObj()).KzI.KPZ = i2;
        AppMethodBeat.o(222849);
    }

    public final void a(ewf ewf) {
        AppMethodBeat.i(134132);
        try {
            ((n.a) this.iMO.getReqObj()).KzI.KLQ = new SKBuiltinBuffer_t().setBuffer(ewf.toByteArray());
            AppMethodBeat.o(134132);
        } catch (Throwable th) {
            AppMethodBeat.o(134132);
        }
    }

    public final int bbN() {
        int i2;
        AppMethodBeat.i(134133);
        dyh dyh = ((n.b) this.iMO.getRespObj()).KzJ.KLj;
        if (dyh != null && dyh.MXV != null && dyh.MXV.size() > 0) {
            Iterator<eer> it = dyh.MXV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eer next = it.next();
                if (next.Cya == 6) {
                    i2 = Util.getInt(next.NeO, 3);
                    break;
                }
            }
        }
        i2 = 3;
        AppMethodBeat.o(134133);
        return i2;
    }

    public final int bbO() {
        int i2;
        AppMethodBeat.i(134134);
        dyh dyh = ((n.b) this.iMO.getRespObj()).KzJ.KLj;
        if (dyh != null && dyh.MXV != null && dyh.MXV.size() > 0) {
            Iterator<eer> it = dyh.MXV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eer next = it.next();
                if (next.Cya == 4) {
                    i2 = Util.getInt(next.NeO, 30);
                    break;
                }
            }
        }
        i2 = 30;
        AppMethodBeat.o(134134);
        return i2;
    }

    public final int bbP() {
        int i2;
        AppMethodBeat.i(134135);
        dyh dyh = ((n.b) this.iMO.getRespObj()).KzJ.KLj;
        if (dyh != null && dyh.MXV != null && dyh.MXV.size() > 0) {
            Iterator<eer> it = dyh.MXV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eer next = it.next();
                if (next.Cya == 5) {
                    i2 = Util.getInt(next.NeO, 0);
                    break;
                }
            }
        }
        i2 = 0;
        AppMethodBeat.o(134135);
        return i2;
    }

    public final boolean bbQ() {
        int i2;
        AppMethodBeat.i(134136);
        dyh dyh = ((n.b) this.iMO.getRespObj()).KzJ.KLj;
        if (dyh != null && dyh.MXV != null && dyh.MXV.size() > 0) {
            Iterator<eer> it = dyh.MXV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eer next = it.next();
                if (next.Cya == 7) {
                    i2 = Util.getInt(next.NeO, 0);
                    break;
                }
            }
        }
        i2 = 0;
        if (i2 > 0) {
            AppMethodBeat.o(134136);
            return true;
        }
        AppMethodBeat.o(134136);
        return false;
    }

    public final boolean bbR() {
        int i2;
        AppMethodBeat.i(134137);
        dyh dyh = ((n.b) this.iMO.getRespObj()).KzJ.KLj;
        if (dyh != null && dyh.MXV != null && dyh.MXV.size() > 0) {
            Iterator<eer> it = dyh.MXV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eer next = it.next();
                if (next.Cya == 10) {
                    i2 = Util.getInt(next.NeO, 0);
                    break;
                }
            }
        }
        i2 = 0;
        if (i2 > 0) {
            AppMethodBeat.o(134137);
            return true;
        }
        AppMethodBeat.o(134137);
        return false;
    }

    public final String bbS() {
        String str;
        AppMethodBeat.i(134138);
        dyh dyh = ((n.b) this.iMO.getRespObj()).KzJ.KLj;
        if (dyh != null && dyh.MXV != null && dyh.MXV.size() > 0) {
            Iterator<eer> it = dyh.MXV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eer next = it.next();
                if (next.Cya == 14) {
                    str = next.NeO;
                    break;
                }
            }
        }
        str = null;
        AppMethodBeat.o(134138);
        return str;
    }

    public final String bbT() {
        String str;
        AppMethodBeat.i(134139);
        dyh dyh = ((n.b) this.iMO.getRespObj()).KzJ.KLj;
        if (dyh != null && dyh.MXV != null && dyh.MXV.size() > 0) {
            Iterator<eer> it = dyh.MXV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eer next = it.next();
                if (next.Cya == 15) {
                    str = next.NeO;
                    break;
                }
            }
        }
        str = null;
        AppMethodBeat.o(134139);
        return str;
    }

    public final String bbU() {
        AppMethodBeat.i(134140);
        String str = ((n.b) this.iMO.getRespObj()).KzJ.KQa;
        AppMethodBeat.o(134140);
        return str;
    }

    public final void Ok(String str) {
        AppMethodBeat.i(134141);
        ((n.a) this.iMO.getReqObj()).KzI.KQa = str;
        AppMethodBeat.o(134141);
    }

    public final void F(int i2, boolean z) {
        AppMethodBeat.i(134142);
        dyx dyx = new dyx();
        dyx.AhC = i2;
        dyx.MYy = z ? 1 : 0;
        ((n.a) this.iMO.getReqObj()).KzI.KQd = dyx;
        AppMethodBeat.o(134142);
    }

    public static class b extends o {
        private final n.a iUM = new n.a();
        private final n.b iUN = new n.b();

        public b() {
            AppMethodBeat.i(134114);
            AppMethodBeat.o(134114);
        }

        @Override // com.tencent.mm.ak.o
        public final l.d getReqObjImp() {
            return this.iUM;
        }

        @Override // com.tencent.mm.network.s
        public final l.e getRespObj() {
            return this.iUN;
        }

        @Override // com.tencent.mm.network.s
        public final int getType() {
            return 145;
        }

        @Override // com.tencent.mm.network.s
        public final String getUri() {
            return "/cgi-bin/micromsg-bin/bindopmobileforreg";
        }

        @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
        public final int getOptions() {
            return 1;
        }
    }
}
