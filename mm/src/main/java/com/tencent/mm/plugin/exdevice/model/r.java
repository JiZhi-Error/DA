package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cav;
import com.tencent.mm.protocal.protobuf.caw;
import com.tencent.mm.sdk.platformtools.Log;

public final class r extends q implements m {
    private String brandName;
    private i callback = null;
    String rAx;
    private d rr = null;

    public r(String str, String str2, String str3, int i2, byte[] bArr) {
        AppMethodBeat.i(23398);
        d.a aVar = new d.a();
        aVar.iLN = new cav();
        aVar.iLO = new caw();
        aVar.uri = "/cgi-bin/micromsg-bin/harddeviceauth";
        aVar.funcId = 541;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cav cav = (cav) this.rr.iLK.iLR;
        cat cat = new cat();
        cat.KLO = str2;
        cat.oTH = str3;
        cav.KPD = cat;
        cav.Mgj = i2;
        cav.Mgk = new SKBuiltinBuffer_t().setBuffer(bArr);
        this.rAx = str3;
        this.brandName = str;
        AppMethodBeat.o(23398);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(23399);
        Log.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "onGYNetEnd netId = " + i2 + " errType = " + i3 + " errCode = " + i4 + str);
        b anJ = ad.cKL().anJ(this.rAx);
        if (i3 == 0 && i4 == 0) {
            caw caw = (caw) this.rr.iLL.iLR;
            if (anJ != null) {
                byte[] cKF = cKF();
                if (cKF != null) {
                    anJ.field_authBuf = cKF;
                }
                anJ.fLY = caw.Mgo;
                anJ.fqk = true;
                anJ.fLX = caw.Mgn;
                anJ.fqk = true;
                byte[] sessionKey = getSessionKey();
                if (sessionKey != null) {
                    u.cLx().b(anJ.field_mac, sessionKey, 2);
                    if (u.cLy().rxT != null) {
                        u.cLy().rxT.setChannelSessionKey(anJ.field_mac, sessionKey);
                    }
                    anJ.field_sessionKey = sessionKey;
                }
                byte[] cKG = cKG();
                if (cKG != null) {
                    u.cLx().b(anJ.field_mac, cKG, 3);
                    anJ.field_sessionBuf = cKG;
                }
                byte[] cKF2 = cKF();
                if (cKF != null) {
                    u.cLx().b(anJ.field_mac, cKF2, 1);
                    anJ.field_authBuf = cKF;
                }
                anJ.fLZ = System.currentTimeMillis() / 1000;
                anJ.fqk = true;
                if (2 == u.cLx().CX(anJ.field_mac)) {
                    ad.cKW();
                    e.d(this.brandName, anJ.field_url, 2, anJ.field_deviceID);
                }
                u.cLx().Da(anJ.field_mac);
                Log.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "update local device auth infos = %b", Boolean.valueOf(ad.cKL().update(anJ, new String[0])));
            } else {
                Log.e("MicroMsg.exdevice.NetSceneHardDeviceAuth", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceIdServer == null");
            }
        } else {
            if (anJ != null) {
                u.cLx().Db(anJ.field_mac);
                ad.cKW();
                e.d(this.brandName, anJ.field_url, 4, anJ.field_deviceID);
            }
            ad.cKW();
            e.dh(this.brandName, 3);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(23399);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 541;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(23400);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(23400);
        return dispatch;
    }

    private byte[] getSessionKey() {
        AppMethodBeat.i(23401);
        try {
            byte[] bufferToBytes = ((caw) this.rr.iLL.iLR).KKY.getBufferToBytes();
            AppMethodBeat.o(23401);
            return bufferToBytes;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e2, "", new Object[0]);
            AppMethodBeat.o(23401);
            return null;
        }
    }

    public final byte[] cKF() {
        AppMethodBeat.i(23402);
        try {
            byte[] bufferToBytes = ((caw) this.rr.iLL.iLR).Mgm.getBufferToBytes();
            AppMethodBeat.o(23402);
            return bufferToBytes;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e2, "", new Object[0]);
            AppMethodBeat.o(23402);
            return null;
        }
    }

    private byte[] cKG() {
        AppMethodBeat.i(23403);
        try {
            byte[] bufferToBytes = ((caw) this.rr.iLL.iLR).Mgl.getBufferToBytes();
            AppMethodBeat.o(23403);
            return bufferToBytes;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e2, "", new Object[0]);
            AppMethodBeat.o(23403);
            return null;
        }
    }
}
