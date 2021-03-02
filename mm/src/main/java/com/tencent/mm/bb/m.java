package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.s;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.ahr;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;
import java.io.IOException;

public final class m extends q implements s, com.tencent.mm.network.m {
    private i callback;
    public int jho;
    private int offset = 0;
    private int packageType;
    private d rr;

    public m(int i2, int i3) {
        AppMethodBeat.i(150807);
        this.jho = i2;
        this.packageType = i3;
        q dt = v.bev().dt(i2, i3);
        if (dt == null) {
            Log.e("MicroMsg.NetSceneDownloadPackage", "doScene get info null, id:".concat(String.valueOf(i2)));
            AppMethodBeat.o(150807);
            return;
        }
        dt.status = 3;
        dt.cSx = 64;
        v.bev().b(dt);
        if (i3 == 5) {
            com.tencent.mm.vfs.s.deleteFile(g.aAh().cachePath + "brand_i18n.apk");
            AppMethodBeat.o(150807);
            return;
        }
        com.tencent.mm.vfs.s.deleteFile(r.bes() + v.bev().dv(i2, i3));
        AppMethodBeat.o(150807);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(150808);
        this.callback = iVar;
        Log.d("MicroMsg.NetSceneDownloadPackage", "dkregcode doScene pkgId:%d packageType:%d", Integer.valueOf(this.jho), Integer.valueOf(this.packageType));
        q dt = v.bev().dt(this.jho, this.packageType);
        if (dt == null) {
            Log.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme failed id:" + this.jho + " type:" + this.packageType);
            AppMethodBeat.o(150808);
            return -1;
        } else if (dt.status != 3) {
            Log.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme stat failed id:" + this.jho + " stat:" + dt.status);
            AppMethodBeat.o(150808);
            return -1;
        } else if (dt.size <= 0) {
            Log.e("MicroMsg.NetSceneDownloadPackage", "doScene Theme size err id:" + this.jho + " size:" + dt.size);
            AppMethodBeat.o(150808);
            return -1;
        } else {
            d.a aVar = new d.a();
            aVar.iLN = new ahr();
            aVar.iLO = new ahs();
            aVar.uri = "/cgi-bin/micromsg-bin/downloadpackage";
            aVar.funcId = 160;
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            this.rr = aVar.aXF();
            ahr ahr = (ahr) this.rr.iLK.iLR;
            cyb cyb = new cyb();
            cyb.xNF = dt.id;
            cyb.Version = dt.version;
            ahr.Lrv = cyb;
            ahr.KZk = this.offset;
            ahr.Lrw = 65536;
            ahr.oUv = this.packageType;
            int dispatch = dispatch(gVar, this.rr, this);
            AppMethodBeat.o(150808);
            return dispatch;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        AppMethodBeat.i(150809);
        ahr ahr = (ahr) ((d) sVar).iLK.iLR;
        q dt = v.bev().dt(this.jho, this.packageType);
        if (dt == null) {
            Log.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked get Theme failed id:" + this.jho);
            q.b bVar = q.b.EFailed;
            AppMethodBeat.o(150809);
            return bVar;
        } else if (ahr.Lrv.xNF == this.jho && ahr.KZk == this.offset && ahr.KZk < dt.size && ahr.Lrw == 65536 && dt.size > 0 && dt.status == 3) {
            q.b bVar2 = q.b.EOk;
            AppMethodBeat.o(150809);
            return bVar2;
        } else {
            Log.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked Theme failed id:" + this.jho);
            q.b bVar3 = q.b.EFailed;
            AppMethodBeat.o(150809);
            return bVar3;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 50;
    }

    @Override // com.tencent.mm.ak.q
    public final void setSecurityCheckError(q.a aVar) {
        AppMethodBeat.i(150810);
        v.bev().dx(this.jho, this.packageType);
        AppMethodBeat.o(150810);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        String bes;
        String dv;
        AppMethodBeat.i(150811);
        Log.d("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd id:" + this.jho + " + id:" + i2 + " errtype:" + i3 + " errCode:" + i4);
        if (i3 == 0 || i4 == 0) {
            ahs ahs = (ahs) ((d) sVar).iLL.iLR;
            if (ahs.oUv != this.packageType) {
                Log.e("MicroMsg.NetSceneDownloadPackage", "packageType is not consistent");
                v.bev().dx(this.jho, this.packageType);
                this.callback.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(150811);
                return;
            }
            byte[] a2 = z.a(ahs.Lrx);
            if (a2 == null || a2.length == 0) {
                Log.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd get pkgBuf failed id:" + this.jho);
                v.bev().dx(this.jho, this.packageType);
                this.callback.onSceneEnd(3, -1, str, this);
                AppMethodBeat.o(150811);
                return;
            }
            q dt = v.bev().dt(this.jho, this.packageType);
            if (dt == null) {
                Log.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd info is null, pkgId = " + this.jho);
                v.bev().dx(this.jho, this.packageType);
                this.callback.onSceneEnd(3, -1, str, this);
                AppMethodBeat.o(150811);
            } else if (dt.size != ahs.Lry) {
                Log.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd totalSize is incorrect");
                v.bev().dx(this.jho, this.packageType);
                g.aAg().hqi.a(new n(this.packageType), 0);
                this.callback.onSceneEnd(3, -1, str, this);
                AppMethodBeat.o(150811);
            } else {
                if (this.packageType == 5) {
                    bes = g.aAh().cachePath;
                    dv = "brand_i18n.apk";
                } else {
                    v.bev();
                    bes = r.bes();
                    dv = v.bev().dv(this.jho, this.packageType);
                }
                Log.d("MicroMsg.NetSceneDownloadPackage", "packagePath ".concat(String.valueOf(bes)));
                Log.d("MicroMsg.NetSceneDownloadPackage", "packageName ".concat(String.valueOf(dv)));
                com.tencent.mm.vfs.s.boN(bes);
                int e2 = com.tencent.mm.vfs.s.e(bes + '/' + dv, a2, a2.length);
                if (e2 != 0) {
                    v.bev().dx(this.jho, this.packageType);
                    Log.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd write file fail, ret = ".concat(String.valueOf(e2)));
                    this.callback.onSceneEnd(3, -1, str, this);
                    AppMethodBeat.o(150811);
                    return;
                }
                this.offset = a2.length + this.offset;
                if (this.offset >= dt.size) {
                    boolean z = false;
                    if (this.packageType == 1) {
                        String dw = v.bev().dw(this.jho, this.packageType);
                        int UnZipFolder = Util.UnZipFolder(bes + dv, dw);
                        if (UnZipFolder < 0) {
                            Log.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + UnZipFolder + ", zipFilePath = " + bes + dv + ", unzipPath = " + dw);
                            v.bev().dx(this.jho, this.packageType);
                            this.callback.onSceneEnd(3, 0, "unzip fail", this);
                            z = false;
                        } else {
                            z = true;
                        }
                    }
                    if (this.packageType == 23) {
                        if (Util.isNullOrNil(bes) || Util.isNullOrNil(dv)) {
                            Log.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, packagePath: %s, packageName: %s", bes, dv);
                            v.bev().dx(this.jho, this.packageType);
                            this.callback.onSceneEnd(3, 0, "open permission pkg failed", this);
                            z = false;
                        } else if (!new o(bes + dv).exists()) {
                            Log.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, file no exist, path: %s, name: %s", bes, dv);
                            v.bev().dx(this.jho, this.packageType);
                            this.callback.onSceneEnd(3, 0, "file not exist", this);
                            z = false;
                        } else {
                            if (-1 == com.tencent.mm.vfs.s.nw(bes + dv, b.aKB() + "permissioncfg.cfg")) {
                                Log.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
                                v.bev().dx(this.jho, this.packageType);
                                this.callback.onSceneEnd(3, 0, "copy file failed", this);
                                z = false;
                            } else {
                                z = true;
                            }
                        }
                    }
                    if (this.packageType == 7) {
                        z = true;
                    }
                    if (this.packageType == 9) {
                        z = true;
                    }
                    if (this.packageType == 5) {
                        z = true;
                        Log.i("MicroMsg.NetSceneDownloadPackage", "resetResContextImp");
                    }
                    if (this.packageType == 12) {
                        qi qiVar = new qi();
                        qiVar.dWH.dWJ = bes + dv;
                        EventCenter.instance.publish(qiVar);
                        z = true;
                    }
                    if (this.packageType == 18) {
                        String dw2 = v.bev().dw(this.jho, this.packageType);
                        int UnZipFolder2 = Util.UnZipFolder(bes + dv, dw2);
                        if (UnZipFolder2 < 0) {
                            Log.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + UnZipFolder2 + ", zipFilePath = " + bes + dv + ", unzipPath = " + dw2);
                            v.bev().dx(this.jho, this.packageType);
                            this.callback.onSceneEnd(3, 0, "unzip fail", this);
                            z = false;
                        } else {
                            Log.i("MicroMsg.NetSceneDownloadPackage", "Unzip Path %s", dw2);
                            z = true;
                        }
                    }
                    if (this.packageType == 20) {
                        z = true;
                    }
                    if (this.packageType == 21) {
                        z = true;
                    }
                    if (this.packageType == 26) {
                        if (Util.isNullOrNil(bes) || Util.isNullOrNil(dv)) {
                            Log.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, packagePath: %s, packageName: %s", bes, dv);
                            this.callback.onSceneEnd(3, 0, "open IPCallContryCodeConfigs pkg failed", this);
                            z = false;
                        } else if (!new o(bes + dv).exists()) {
                            Log.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, file not exist, packagePath: %s, packageName: %s", bes, dv);
                            v.bev().dx(this.jho, this.packageType);
                            this.callback.onSceneEnd(3, 0, "file not exist", this);
                            z = false;
                        } else {
                            if (-1 == com.tencent.mm.vfs.s.nw(bes + dv, b.aKB() + "ipcallCountryCodeConfig.cfg")) {
                                Log.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
                                v.bev().dx(this.jho, this.packageType);
                                this.callback.onSceneEnd(3, 0, "copy file failed", this);
                                z = false;
                            } else {
                                Log.d("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg success");
                                z = true;
                            }
                        }
                    }
                    if (this.packageType == 36) {
                        z = bx(bes, dv);
                    }
                    if (z) {
                        dt.status = 2;
                        dt.cSx = 64;
                        v.bev().b(dt);
                        this.callback.onSceneEnd(0, 0, "", this);
                    }
                    AppMethodBeat.o(150811);
                    return;
                }
                if (doScene(dispatcher(), this.callback) < 0) {
                    v.bev().dx(this.jho, this.packageType);
                    this.callback.onSceneEnd(3, -1, str, this);
                }
                AppMethodBeat.o(150811);
            }
        } else {
            Log.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd, errType = " + i3 + ", errCode = " + i4);
            v.bev().dx(this.jho, this.packageType);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(150811);
        }
    }

    private static boolean bx(String str, String str2) {
        IOException e2;
        boolean z = true;
        AppMethodBeat.i(150812);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(150812);
            return false;
        }
        try {
            String str3 = str + str2;
            String boY = com.tencent.mm.vfs.s.boY(str3);
            if (!Util.isNullOrNil(boY)) {
                g.aAh().azQ().set(ar.a.USERINFO_SENSE_WHERE_LOCATION_STRING, boY);
            } else {
                z = false;
            }
            try {
                com.tencent.mm.vfs.s.deleteFile(str3);
                Log.i("MicroMsg.NetSceneDownloadPackage", "update sense where result[%b] filepath[%s] xml[%s] ", Boolean.valueOf(z), str3, Util.secPrint(boY));
            } catch (IOException e3) {
                e2 = e3;
                Log.printErrStackTrace("MicroMsg.NetSceneDownloadPackage", e2, "", new Object[0]);
                AppMethodBeat.o(150812);
                return z;
            }
        } catch (IOException e4) {
            e2 = e4;
            z = false;
            Log.printErrStackTrace("MicroMsg.NetSceneDownloadPackage", e2, "", new Object[0]);
            AppMethodBeat.o(150812);
            return z;
        }
        AppMethodBeat.o(150812);
        return z;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 160;
    }

    @Override // com.tencent.mm.ak.s
    public final int aYR() {
        return this.packageType;
    }
}
