package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.bny;
import com.tencent.mm.protocal.protobuf.bnz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.OutputStream;

/* access modifiers changed from: package-private */
public final class l extends q implements m {
    private i callback;
    private String iKI;
    private int iKM;
    private String iKO;
    private int iLd;
    private String iLe;
    private OutputStream output = null;
    private String username;

    public l(String str) {
        AppMethodBeat.i(150296);
        this.username = str;
        if (as.IG(str)) {
            this.username = as.bjz(str);
        }
        Log.i("MicroMsg.NetSceneGetHDHeadImg", "init Headimage in_username:" + str + " out_username" + this.username);
        this.iKM = 480;
        this.iLd = 480;
        this.iKO = "jpg";
        AppMethodBeat.o(150296);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        g gVar2;
        boolean z = false;
        AppMethodBeat.i(150297);
        this.callback = iVar;
        if (this.username == null || this.username.length() == 0) {
            Log.e("MicroMsg.NetSceneGetHDHeadImg", "username is null");
            AppMethodBeat.o(150297);
            return -1;
        } else if (this.username.endsWith("@qqim")) {
            Log.e("MicroMsg.NetSceneGetHDHeadImg", "never try get qq user hd.");
            AppMethodBeat.o(150297);
            return -1;
        } else {
            h aYC = p.aYC();
            p.aYn();
            this.iKI = e.L(this.username, true);
            if (s.YS(this.iKI)) {
                Log.i("MicroMsg.NetSceneGetHDHeadImg", "The HDAvatar of " + this.username + " is already exists");
                AppMethodBeat.o(150297);
                return 0;
            }
            this.iLe = this.iKI + ".tmp";
            g Mu = aYC.Mu(this.username);
            if (Mu == null) {
                s.deleteFile(this.iLe);
                g gVar3 = new g();
                gVar3.username = this.username;
                gVar3.iKO = this.iKO;
                gVar3.iKM = this.iKM;
                gVar3.iKN = this.iLd;
                gVar3.cSx = -1;
                aYC.iFy.insert("hdheadimginfo", ch.COL_USERNAME, gVar3.convertTo());
                gVar2 = gVar3;
            } else {
                String str = this.iLe;
                if (Mu != null && str != null && str.length() != 0 && Mu.aYp().equals(this.iKO) && Mu.iKM == this.iKM && Mu.iKN == this.iLd && s.boW(str) == ((long) Mu.bNu)) {
                    z = true;
                }
                if (!z) {
                    s.deleteFile(this.iLe);
                    Mu.reset();
                    Mu.username = this.username;
                    Mu.iKO = this.iKO;
                    Mu.iKM = this.iKM;
                    Mu.iKN = this.iLd;
                    aYC.a(this.username, Mu);
                }
                gVar2 = Mu;
            }
            d.a aVar = new d.a();
            aVar.iLN = new bny();
            aVar.iLO = new bnz();
            aVar.uri = "/cgi-bin/micromsg-bin/gethdheadimg";
            aVar.funcId = 158;
            aVar.iLP = 47;
            aVar.respCmdId = 1000000047;
            d aXF = aVar.aXF();
            bny bny = (bny) aXF.iLK.iLR;
            if (!as.IG(this.username)) {
                bny.UserName = this.username;
                bny.LWp = 1;
            } else if (this.username.equals(z.aTY() + "@bottle")) {
                bny.UserName = z.aTY();
                bny.LWp = 2;
            } else {
                bny.UserName = this.username;
                bny.LWp = 2;
            }
            Log.d("MicroMsg.NetSceneGetHDHeadImg", "inUser:" + this.username + " outUser:" + bny.UserName + " outType:" + bny.LWp);
            bny.LWm = this.iKM;
            bny.LWn = this.iLd;
            bny.LWo = this.iKO;
            bny.BsF = gVar2.iKP;
            bny.BsG = gVar2.bNu;
            int dispatch = dispatch(gVar, aXF, this);
            AppMethodBeat.o(150297);
            return dispatch;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        AppMethodBeat.i(150298);
        if (this.username == null || this.username.length() == 0) {
            q.b bVar = q.b.EFailed;
            AppMethodBeat.o(150298);
            return bVar;
        }
        q.b bVar2 = q.b.EOk;
        AppMethodBeat.o(150298);
        return bVar2;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 10;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(150299);
        bnz bnz = (bnz) ((d) sVar).iLL.iLR;
        Log.d("MicroMsg.NetSceneGetHDHeadImg", "errType:" + i3 + " errCode:" + i4);
        if (i3 != 4 && i4 != 0) {
            Log.e("MicroMsg.NetSceneGetHDHeadImg", "errType:" + i3 + " errCode:" + i4);
            this.callback.onSceneEnd(i3, i4, str, this);
            aYw();
            AppMethodBeat.o(150299);
        } else if (i3 == 4 || i3 == 5) {
            this.callback.onSceneEnd(i3, i4, str, this);
            Log.e("MicroMsg.NetSceneGetHDHeadImg", "ErrType:".concat(String.valueOf(i3)));
            aYw();
            AppMethodBeat.o(150299);
        } else {
            int retCode = sVar.getRespObj().getRetCode();
            if (retCode == -4 || retCode == -54 || retCode == -55) {
                Log.e("MicroMsg.NetSceneGetHDHeadImg", "retcode == ".concat(String.valueOf(retCode)));
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.e("MicroMsg.NetSceneGetHDHeadImg", "handleCertainError");
                this.callback.onSceneEnd(i3, i4, str, this);
                aYw();
                AppMethodBeat.o(150299);
                return;
            }
            int i5 = -1;
            if (!(bnz.BsI == null || bnz.BsI.getBuffer() == null)) {
                i5 = ak(bnz.BsI.getBuffer().zy);
            }
            if (i5 < 0) {
                Log.e("MicroMsg.NetSceneGetHDHeadImg", "appendBuf fail");
                this.callback.onSceneEnd(i3, i4, str, this);
                aYw();
                AppMethodBeat.o(150299);
                return;
            }
            h aYC = p.aYC();
            g Mu = aYC.Mu(this.username);
            if (Mu == null) {
                Log.e("MicroMsg.NetSceneGetHDHeadImg", "info == null");
                this.callback.onSceneEnd(i3, i4, str, this);
                aYw();
                AppMethodBeat.o(150299);
                return;
            }
            Mu.bNu = i5 + bnz.BsG;
            Mu.iKP = bnz.BsF;
            aYC.a(this.username, Mu);
            if (Mu.bNu >= Mu.iKP) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                Log.i("MicroMsg.NetSceneGetHDHeadImg", "%d doScene again info[%s %d %d]", Integer.valueOf(hashCode()), this.username, Integer.valueOf(Mu.bNu), Integer.valueOf(Mu.iKP));
                if (doScene(dispatcher(), this.callback) < 0) {
                    this.callback.onSceneEnd(3, -1, "", this);
                }
                AppMethodBeat.o(150299);
                return;
            }
            s.nx(this.iLe, this.iKI);
            bc(this.iKI, this.username);
            aYw();
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(150299);
        }
    }

    public static void bc(String str, String str2) {
        AppMethodBeat.i(150300);
        p.aYn().bb(str, str2);
        AppMethodBeat.o(150300);
    }

    @Override // com.tencent.mm.ak.q
    public final void cancel() {
        AppMethodBeat.i(150301);
        super.cancel();
        aYw();
        AppMethodBeat.o(150301);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 158;
    }

    private int ak(byte[] bArr) {
        AppMethodBeat.i(150302);
        try {
            if (this.output == null) {
                this.output = s.dw(this.iLe, false);
            }
            this.output.write(bArr);
            int length = bArr.length;
            AppMethodBeat.o(150302);
            return length;
        } catch (IOException e2) {
            Log.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(150302);
            return -1;
        }
    }

    private void aYw() {
        AppMethodBeat.i(150303);
        try {
            if (this.output != null) {
                this.output.flush();
                this.output.close();
                this.output = null;
            }
            AppMethodBeat.o(150303);
        } catch (IOException e2) {
            Log.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(150303);
        }
    }
}
