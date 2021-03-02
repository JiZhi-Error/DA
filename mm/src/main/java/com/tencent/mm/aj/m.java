package com.tencent.mm.aj;

import androidx.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.g;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.enk;
import com.tencent.mm.protocal.protobuf.enl;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.vfs.s;
import java.io.IOException;

public final class m extends q implements com.tencent.mm.network.m {
    private int bNu;
    private i callback;
    private String dRr;
    private int iKP;
    private int iKQ;
    private String iLf;
    private String iLg;
    private String username;

    /* JADX WARNING: Removed duplicated region for block: B:112:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x02f0  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x030f  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x03fd  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0402  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x040d  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0411  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0415  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0421  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01de A[Catch:{ all -> 0x0204 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int bd(java.lang.String r12, java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 1352
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.aj.m.bd(java.lang.String, java.lang.String):int");
    }

    private static boolean Mz(String str) {
        AppMethodBeat.i(223534);
        try {
            a aVar = new a(str);
            String attribute = aVar.getAttribute(android.support.e.a.TAG_GPS_LONGITUDE);
            String attribute2 = aVar.getAttribute(android.support.e.a.TAG_GPS_LATITUDE);
            String attribute3 = aVar.getAttribute(android.support.e.a.TAG_GPS_LONGITUDE_REF);
            String attribute4 = aVar.getAttribute(android.support.e.a.TAG_GPS_LATITUDE_REF);
            String attribute5 = aVar.getAttribute(android.support.e.a.TAG_GPS_DEST_LONGITUDE);
            String attribute6 = aVar.getAttribute(android.support.e.a.TAG_GPS_DEST_LONGITUDE_REF);
            if (attribute == null && attribute2 == null && attribute3 == null && attribute4 == null && attribute5 == null && attribute6 == null) {
                AppMethodBeat.o(223534);
                return false;
            }
            AppMethodBeat.o(223534);
            return true;
        } catch (IOException e2) {
            AppMethodBeat.o(223534);
            return false;
        }
    }

    public m(int i2, String str) {
        this(1, str, (byte) 0);
    }

    public m(int i2, String str, byte b2) {
        AppMethodBeat.i(223535);
        this.username = null;
        if (Util.isNullOrNil((String) null)) {
            this.username = z.aTY();
            if (i2 == 2) {
                this.username = as.bjz(this.username);
            }
        }
        p.aYn();
        this.iLf = e.M(this.username, true);
        String str2 = this.iLf + ".tmp";
        if (bd(str, str2) == 0) {
            this.dRr = str2;
            this.iKQ = i2;
            p.aYn();
            this.iLg = g.getMessageDigest(s.aW(e.L(this.username, true), 0, -1));
            this.iKP = 0;
            this.bNu = 0;
        }
        AppMethodBeat.o(223535);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(150306);
        this.callback = iVar;
        if (this.dRr == null || this.dRr.length() == 0) {
            Log.e("MicroMsg.NetSceneUploadHDHeadImg", "imgPath is null or length = 0");
            AppMethodBeat.o(150306);
            return -1;
        } else if (!s.YS(this.dRr)) {
            Log.e("MicroMsg.NetSceneUploadHDHeadImg", "The img does not exist, imgPath = " + this.dRr);
            AppMethodBeat.o(150306);
            return -1;
        } else {
            if (this.iKP == 0) {
                this.iKP = (int) s.boW(this.dRr);
            }
            byte[] aW = s.aW(this.dRr, this.bNu, Math.min(this.iKP - this.bNu, 8192));
            if (aW == null) {
                Log.e("MicroMsg.NetSceneUploadHDHeadImg", "readFromFile error");
                AppMethodBeat.o(150306);
                return -1;
            }
            Log.i("MicroMsg.NetSceneUploadHDHeadImg", "doScene uploadLen:%d, total: %d", Integer.valueOf(aW.length), Integer.valueOf(this.iKP));
            d.a aVar = new d.a();
            aVar.iLN = new enk();
            aVar.iLO = new enl();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadhdheadimg";
            aVar.funcId = 157;
            aVar.iLP = 46;
            aVar.respCmdId = 1000000046;
            d aXF = aVar.aXF();
            enk enk = (enk) aXF.iLK.iLR;
            enk.BsF = this.iKP;
            enk.BsG = this.bNu;
            enk.LWp = this.iKQ;
            enk.BsI = new SKBuiltinBuffer_t().setBuffer(aW);
            enk.Nll = this.iLg;
            enk.UserName = this.username;
            try {
                ewf ewf = new ewf();
                ewf.NtQ = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.exJ());
                enk.KLQ = new SKBuiltinBuffer_t().setBuffer(ewf.toByteArray());
            } catch (Throwable th) {
            }
            int dispatch = dispatch(gVar, aXF, this);
            AppMethodBeat.o(150306);
            return dispatch;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        AppMethodBeat.i(150307);
        if (this.dRr == null || this.dRr.length() == 0) {
            q.b bVar = q.b.EFailed;
            AppMethodBeat.o(150307);
            return bVar;
        }
        q.b bVar2 = q.b.EOk;
        AppMethodBeat.o(150307);
        return bVar2;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 200;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        boolean z;
        AppMethodBeat.i(150308);
        enl enl = (enl) ((d) sVar).iLL.iLR;
        Log.d("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + i3 + " errCode:" + i4);
        if (i3 != 4 && i4 != 0) {
            Log.e("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + i3 + " errCode:" + i4);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(150308);
        } else if (i3 == 4 || i3 == 5) {
            this.callback.onSceneEnd(i3, i4, str, this);
            Log.e("MicroMsg.NetSceneUploadHDHeadImg", "ErrType:".concat(String.valueOf(i3)));
            AppMethodBeat.o(150308);
        } else {
            int retCode = sVar.getRespObj().getRetCode();
            if (retCode == -4) {
                Log.e("MicroMsg.NetSceneUploadHDHeadImg", "retcode == %d", Integer.valueOf(retCode));
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.e("MicroMsg.NetSceneUploadHDHeadImg", "handleCertainError");
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(150308);
                return;
            }
            this.bNu = enl.BsG;
            if (this.bNu < this.iKP) {
                if (doScene(dispatcher(), this.callback) < 0) {
                    Log.e("MicroMsg.NetSceneUploadHDHeadImg", "doScene again failed");
                    this.callback.onSceneEnd(3, -1, "", this);
                }
                Log.d("MicroMsg.NetSceneUploadHDHeadImg", "doScene again");
                AppMethodBeat.o(150308);
                return;
            }
            try {
                s.nx(this.dRr, this.iLf);
                com.tencent.mm.kernel.g.aAh().azQ().set(12297, enl.Nlm);
                p.aYn().e(this.username, BitmapUtil.getBitmapNative(this.iLf));
                String aTY = z.aTY();
                if (!Util.isNullOrNil(aTY)) {
                    i iVar = new i();
                    iVar.username = aTY;
                    iVar.fv(true);
                    iVar.cSx = 32;
                    iVar.fuz = 3;
                    iVar.cSx = 34;
                    p.aYB().b(iVar);
                }
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(150308);
            } catch (Exception e2) {
                Log.e("MicroMsg.NetSceneUploadHDHeadImg", "rename temp file failed :" + e2.getMessage());
                this.callback.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(150308);
            }
        }
    }

    @Override // com.tencent.mm.ak.q
    public final void cancel() {
        AppMethodBeat.i(150309);
        super.cancel();
        AppMethodBeat.o(150309);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 157;
    }
}
