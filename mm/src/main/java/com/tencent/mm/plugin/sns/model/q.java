package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.dzs;
import com.tencent.mm.protocal.protobuf.dzt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.OutputStream;

public final class q extends com.tencent.mm.ak.q implements m {
    private String DIl;
    private int DIm = -1;
    int DIn = -1;
    private boolean DIo = true;
    private String DIp = null;
    private cnb DIq;
    public i callback;
    private String filename;
    String mediaId = "";
    private OutputStream output = null;
    private d rr;

    public q(cnb cnb, String str, String str2, int i2, boolean z, int i3, String str3) {
        AppMethodBeat.i(95589);
        this.mediaId = str;
        this.DIq = cnb;
        this.DIo = z;
        this.DIm = i2;
        this.DIn = i3;
        this.DIp = str3;
        this.DIl = ar.ki(aj.getAccSnsPath(), str);
        d.a aVar = new d.a();
        aVar.iLN = new dzs();
        aVar.iLO = new dzt();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsdownload";
        aVar.funcId = 208;
        aVar.iLP = 96;
        aVar.respCmdId = 1000000096;
        this.rr = aVar.aXF();
        dzs dzs = (dzs) this.rr.iLK.iLR;
        com.tencent.mm.plugin.sns.storage.q aQE = aj.faD().aQE(str);
        aQE = aQE == null ? new com.tencent.mm.plugin.sns.storage.q() : aQE;
        aQE.EmQ = str;
        aQE.offset = 0;
        aj.faD().a(str, aQE);
        if (z) {
            this.filename = r.n(cnb);
        } else {
            this.filename = r.m(cnb);
        }
        s.boN(this.DIl);
        s.deleteFile(ar.ki(aj.getAccSnsPath(), str) + this.filename);
        dzs.MZo = str2;
        dzs.MZp = 0;
        dzs.BsG = 0;
        dzs.BsF = 0;
        dzs.oUv = this.DIm;
        Log.d("MicroMsg.NetSceneSnsDownload", "requestKey ".concat(String.valueOf(str3)));
        AppMethodBeat.o(95589);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(95590);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(95590);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        boolean z;
        String l;
        AppMethodBeat.i(95591);
        Log.d("MicroMsg.NetSceneSnsDownload", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        dzt dzt = (dzt) ((d) sVar).iLL.iLR;
        if (((d.c) sVar.getRespObj()).getRetCode() != 0) {
            this.callback.onSceneEnd(i3, i4, str, this);
            aj.faJ().aOR(this.DIp);
            AppMethodBeat.o(95591);
            return;
        }
        com.tencent.mm.plugin.sns.storage.q aQE = aj.faD().aQE(this.mediaId);
        if (dzt.BsF <= 0) {
            Log.e("MicroMsg.NetSceneSnsDownload", "error 1");
            onError();
            AppMethodBeat.o(95591);
        } else if (dzt.KMS == null) {
            Log.e("MicroMsg.NetSceneSnsDownload", "error 2");
            onError();
            AppMethodBeat.o(95591);
        } else if (dzt.BsG < 0 || dzt.BsG + dzt.KMS.getBuffer().zy.length > dzt.BsF) {
            Log.e("MicroMsg.NetSceneSnsDownload", "error 3");
            onError();
            AppMethodBeat.o(95591);
        } else if (dzt.BsG != aQE.offset) {
            Log.e("MicroMsg.NetSceneSnsDownload", "error 4");
            onError();
            AppMethodBeat.o(95591);
        } else {
            int ak = ak(dzt.KMS.getBuffer().toByteArray());
            if (ak < 0) {
                Log.e("MicroMsg.NetSceneSnsDownload", "error 5");
                onError();
                AppMethodBeat.o(95591);
                return;
            }
            aQE.offset += ak;
            aQE.EmM = dzt.BsF;
            Log.d("MicroMsg.NetSceneSnsDownload", "byteLen " + ak + "  totalLen " + dzt.BsF);
            aj.faD().a(this.mediaId, aQE);
            if (aQE.offset != aQE.EmM || aQE.EmM == 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                Log.d("MicroMsg.NetSceneSnsDownload", "downLoad ok");
                if (this.DIn == 1) {
                    l = r.e(this.DIq);
                } else {
                    l = r.l(this.DIq);
                }
                String ki = ar.ki(aj.getAccSnsPath(), this.mediaId);
                s.deleteFile(ki + l);
                s.bo(ki, this.filename, l);
                if (this.DIo) {
                    com.tencent.mm.plugin.sns.storage.r.b(ki, l, r.f(this.DIq), (float) aj.fbb());
                } else {
                    String e2 = r.e(this.DIq);
                    if (!s.YS(ki + e2)) {
                        com.tencent.mm.plugin.sns.storage.r.a(ki, l, e2, (float) aj.fbc());
                    }
                    String f2 = r.f(this.DIq);
                    if (!s.YS(ki + f2)) {
                        com.tencent.mm.plugin.sns.storage.r.b(ki, l, f2, (float) aj.fbb());
                    }
                }
                aj.faJ().aOR(this.DIp);
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(95591);
                return;
            }
            doScene(dispatcher(), this.callback);
            AppMethodBeat.o(95591);
        }
    }

    private void onError() {
        AppMethodBeat.i(95592);
        aj.faJ().aOR(this.DIp);
        AppMethodBeat.o(95592);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 208;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 100;
    }

    private int ak(byte[] bArr) {
        AppMethodBeat.i(95593);
        if (!r.aOt(aj.getAccPath())) {
            AppMethodBeat.o(95593);
            return 0;
        }
        try {
            if (this.output == null) {
                s.boN(this.DIl);
                this.output = s.dw(this.DIl + this.filename, false);
            }
            Log.d("MicroMsg.NetSceneSnsDownload", "appendBuf " + bArr.length);
            this.output.write(bArr);
            aYw();
            int length = bArr.length;
            AppMethodBeat.o(95593);
            return length;
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneSnsDownload", e2, "appendBuf failed: " + this.filename, new Object[0]);
            aYw();
            AppMethodBeat.o(95593);
            return -1;
        } catch (Throwable th) {
            aYw();
            AppMethodBeat.o(95593);
            throw th;
        }
    }

    private void aYw() {
        AppMethodBeat.i(95594);
        try {
            if (this.output != null) {
                this.output.flush();
                this.output.close();
                this.output = null;
            }
            AppMethodBeat.o(95594);
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneSnsDownload", e2, "", new Object[0]);
            AppMethodBeat.o(95594);
        }
    }
}
