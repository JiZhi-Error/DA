package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.a.e;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.ekm;
import com.tencent.mm.protocal.protobuf.hz;
import com.tencent.mm.protocal.t;
import com.tencent.mm.protocal.x;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class x extends h.a {
    private static e iMZ;
    private int iNa = 0;
    private byte[] iNb = null;
    private byte[] iNc;
    private l.d req;
    private int type;

    public static void a(e eVar) {
        iMZ = eVar;
    }

    public x(l.d dVar, int i2) {
        this.req = dVar;
        this.type = i2;
        this.iNa = 0;
        this.iNb = null;
    }

    public static boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3, l.d dVar, ByteArrayOutputStream byteArrayOutputStream, boolean z) {
        AppMethodBeat.i(132424);
        if (Util.isNullOrNil(bArr)) {
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            Log.e("MicroMsg.RemoteReq", "reqToBufNoRSA session is null :%d", objArr);
            AppMethodBeat.o(132424);
            return false;
        }
        PByteArray pByteArray = new PByteArray();
        try {
            l.b bVar = (l.b) dVar;
            byte[] protoBuf = bVar.toProtoBuf();
            if (protoBuf == null) {
                AppMethodBeat.o(132424);
                return false;
            } else if (bVar.isRawData()) {
                byteArrayOutputStream.write(protoBuf);
                AppMethodBeat.o(132424);
                return true;
            } else {
                ac gtR = ac.gtR();
                int i2 = 6;
                if (z) {
                    i2 = 7;
                }
                int i3 = 0;
                if (!Util.isNullOrNil(bArr3) && !Util.isNullOrNil(protoBuf)) {
                    i3 = MMProtocalJni.genSignature(dVar.getUin(), bArr3, protoBuf);
                }
                if (MMProtocalJni.pack(protoBuf, pByteArray, bArr, 0, bArr2, dVar.getDeviceID(), dVar.getUin(), bVar.getFuncId(), gtR.ver, gtR.KAw.getBytes(), gtR.KAx.getBytes(), i3, i2, bVar.getRouteInfo(), 0)) {
                    Log.d("MicroMsg.RemoteReq", "reqToBuf using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i2));
                    byteArrayOutputStream.write(pByteArray.value);
                    AppMethodBeat.o(132424);
                    return true;
                }
                AppMethodBeat.o(132424);
                return false;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.RemoteReq", "protobuf build exception, check now! :" + e2.getMessage());
            Log.printErrStackTrace("MicroMsg.RemoteReq", e2, "", new Object[0]);
            AppMethodBeat.o(132424);
            return false;
        }
    }

    @Override // com.tencent.mm.protocal.h
    public final boolean a(int i2, byte[] bArr, int i3, byte[] bArr2, byte[] bArr3, int i4, boolean z) {
        long j2;
        byte[] bArr4;
        boolean z2;
        int i5;
        byte[] bArr5;
        int length;
        int length2;
        byte[] bArr6;
        byte[] bArr7;
        int length3;
        int length4;
        AppMethodBeat.i(132425);
        PByteArray pByteArray = new PByteArray();
        Log.d("MicroMsg.RemoteReq", "reqToBuf jType: %d, stack: %s", Integer.valueOf(i2), Util.getStack());
        if (i2 == 268369922) {
            try {
                this.iNc = ((l.b) this.req).toProtoBuf();
                this.req.setBufferSize((long) this.iNc.length);
                AppMethodBeat.o(132425);
                return true;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.RemoteReq", e2, "", new Object[0]);
                AppMethodBeat.o(132425);
                return false;
            }
        } else if (!(this.req instanceof l.b)) {
            Log.f("MicroMsg.RemoteReq", "all protocal should implemented with protobuf");
            AppMethodBeat.o(132425);
            return false;
        } else {
            try {
                l.b bVar = (l.b) this.req;
                byte[] protoBuf = bVar.toProtoBuf();
                if (protoBuf == null) {
                    Log.f("MicroMsg.RemoteReq", "protobuf is null");
                    AppMethodBeat.o(132425);
                    return false;
                } else if (bVar.isRawData()) {
                    this.iNc = protoBuf;
                    this.req.setBufferSize((long) this.iNc.length);
                    AppMethodBeat.o(132425);
                    return true;
                } else {
                    long uin = (long) this.req.getUin();
                    if (!CrashReportFactory.hasDebuger() || uin != 0) {
                        j2 = uin;
                    } else {
                        j2 = d.KyN;
                    }
                    int i6 = 6;
                    if (i2 == 775) {
                        i6 = 0;
                    }
                    if (z) {
                        i6 |= 1;
                    }
                    if (bVar.isAxAuth()) {
                        boolean packHybridEcdh = MMProtocalJni.packHybridEcdh(pByteArray, bArr2, this.req.getDeviceID(), (int) j2, bVar.getFuncId(), f.Kze, protoBuf, i6, bVar.getRouteInfo(), 11);
                        Log.d("MicroMsg.RemoteReq", "summerauths reqToBuf packHybridEcdh ax using protobuf ok, jType:%d, cert:%d len:%d, flag:%d ret:%s", Integer.valueOf(i2), Integer.valueOf(f.Kze), Integer.valueOf(pByteArray.value.length), Integer.valueOf(i6), Boolean.valueOf(packHybridEcdh));
                        this.iNc = pByteArray.value;
                        this.req.setBufferSize((long) this.iNc.length);
                        AppMethodBeat.o(132425);
                        return packHybridEcdh;
                    }
                    ac rsaInfo = this.req.getRsaInfo();
                    if (i2 == 775 || this.req.getReqPackControl() != null || !rsaInfo.gtU() || !Util.isNullOrNil(bArr)) {
                        if (!rsaInfo.gtU()) {
                            bArr4 = new byte[0];
                        } else {
                            bArr4 = bArr;
                        }
                        if (this.type == 381 || !f.KyZ) {
                            byte[][] bArr8 = null;
                            switch (i2) {
                                case 701:
                                    cmf cmf = ((j.f) this.req).Kzy;
                                    bArr8 = a(j2, cmf.MrA, cmf.MrB);
                                    z2 = true;
                                    break;
                                case 702:
                                    Log.d("MicroMsg.RemoteReq", "summerauth reqToBuf rsaReqData uin[%d]", Long.valueOf(j2));
                                    if (j2 == 0) {
                                        int aVJ = j.e.a.Kzx == null ? -1 : j.e.a.Kzx.aVJ();
                                        g.aAi();
                                        g.aAf();
                                        int uin2 = a.getUin();
                                        Log.w("MicroMsg.RemoteReq", "summerauth autoauth uin[%d] is invalid! uinForProtocal[%d] accountUin[%d]", Long.valueOf(j2), Integer.valueOf(aVJ), Integer.valueOf(uin2));
                                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(148, 54, 1, true);
                                        if (aVJ != 0) {
                                            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(148, 55, 1, true);
                                        }
                                        if (uin2 != 0) {
                                            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(148, 56, 1, true);
                                        }
                                    }
                                    hz hzVar = ((j.a) this.req).Kzu;
                                    bArr8 = a(j2, hzVar.KLV, hzVar.KLW);
                                    z2 = true;
                                    break;
                                default:
                                    z2 = false;
                                    break;
                            }
                            if (z2) {
                                if (rsaInfo.gtU() && Util.isNullOrNil(bArr4)) {
                                    AppMethodBeat.o(132425);
                                    return false;
                                } else if (bArr8 == null) {
                                    AppMethodBeat.o(132425);
                                    return false;
                                } else {
                                    if (i2 == 702) {
                                        if (MMProtocalJni.packDoubleHybrid(pByteArray, bArr2, this.req.getDeviceID(), (int) j2, bVar.getFuncId(), rsaInfo.ver, bArr8[0], bArr8[1], rsaInfo.KAw.getBytes(), rsaInfo.KAx.getBytes(), getPassKey(), i6, bVar.getRouteInfo())) {
                                            Log.d("MicroMsg.RemoteReq", "summer reqToBuf packDoubleHybrid AutoAuth using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i6));
                                            this.iNc = pByteArray.value;
                                        }
                                    } else if (MMProtocalJni.packHybrid(pByteArray, bArr2, this.req.getDeviceID(), (int) j2, bVar.getFuncId(), rsaInfo.ver, bArr8[0], bArr8[1], rsaInfo.KAw.getBytes(), rsaInfo.KAx.getBytes(), getPassKey(), i6, bVar.getRouteInfo())) {
                                        Log.d("MicroMsg.RemoteReq", "summer reqToBuf packHybrid using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i6));
                                        this.iNc = pByteArray.value;
                                    }
                                    this.req.setBufferSize((long) this.iNc.length);
                                }
                            } else if (this.req.getReqPackControl() != null) {
                                int i7 = 6;
                                if (z) {
                                    i7 = 7;
                                }
                                l.a reqPackControl = this.req.getReqPackControl();
                                bVar.getRouteInfo();
                                if (reqPackControl.a(pByteArray, i2, bArr2, bArr3, i7)) {
                                    this.iNc = pByteArray.value;
                                    this.req.setBufferSize((long) this.iNc.length);
                                    Log.d("MicroMsg.RemoteReq", "reqToBuf using req.getReqPackControl() ok, len:%d", Integer.valueOf(pByteArray.value.length));
                                }
                                AppMethodBeat.o(132425);
                                return true;
                            } else if (i2 == 775 || !rsaInfo.gtU() || !Util.isNullOrNil(bArr4)) {
                                if (i2 == 775) {
                                    i5 = i6 & -3 & -5;
                                } else {
                                    i5 = i6;
                                }
                                int i8 = 0;
                                if (!Util.isNullOrNil(bArr3) && !Util.isNullOrNil(protoBuf)) {
                                    i8 = MMProtocalJni.genSignature((int) j2, bArr3, protoBuf);
                                }
                                Object[] objArr = new Object[5];
                                objArr[0] = bArr4;
                                objArr[1] = Integer.valueOf(i2);
                                objArr[2] = Integer.valueOf(i5);
                                objArr[3] = Integer.valueOf(bArr3 == null ? -1 : bArr3.length);
                                objArr[4] = Integer.valueOf(i8);
                                Log.i("MicroMsg.RemoteReq", "summerauths no ecdh dkrsa use session :%s  type:%d, flag:%d, ecdh:[%s] signature[%s]", objArr);
                                if (i3 == 13) {
                                    bArr5 = UtilsJni.AesGcmEncryptWithCompress(bArr4, protoBuf);
                                    Object[] objArr2 = new Object[4];
                                    objArr2[0] = Integer.valueOf(i2);
                                    objArr2[1] = Integer.valueOf(bArr4 == null ? -1 : bArr4.length);
                                    if (protoBuf == null) {
                                        length = -1;
                                    } else {
                                        length = protoBuf.length;
                                    }
                                    objArr2[2] = Integer.valueOf(length);
                                    if (bArr5 == null) {
                                        length2 = -1;
                                    } else {
                                        length2 = bArr5.length;
                                    }
                                    objArr2[3] = Integer.valueOf(length2);
                                    Log.i("MicroMsg.RemoteReq", "summerauths no ecdh goto aesgcm compress jType[%s] key[%s] message[%s] buf[%s]", objArr2);
                                } else {
                                    bArr5 = protoBuf;
                                }
                                if (MMProtocalJni.pack(bArr5, pByteArray, bArr4, i3, bArr2, this.req.getDeviceID(), (int) j2, bVar.getFuncId(), rsaInfo.ver, rsaInfo.KAw.getBytes(), rsaInfo.KAx.getBytes(), i8, i5, bVar.getRouteInfo(), this.iNa)) {
                                    Log.d("MicroMsg.RemoteReq", "summerauths no ecdh reqToBuf using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i5));
                                    this.iNc = pByteArray.value;
                                }
                                this.req.setBufferSize((long) this.iNc.length);
                            } else {
                                Log.e("MicroMsg.RemoteReq", "dksession jType %d session should not null", Integer.valueOf(i2));
                                AppMethodBeat.o(132425);
                                return false;
                            }
                            AppMethodBeat.o(132425);
                            return true;
                        } else if (this.req.useECDH()) {
                            Log.i("MicroMsg.RemoteReq", "summerauths rsaInfo[%s] USE_ECDH[%s] engine[%s]", Integer.valueOf(rsaInfo.ver), Boolean.valueOf(f.KyZ), Long.valueOf(((l.b) this.req).getECDHEngine()));
                            ((l.b) this.req).getFuncId();
                            long cF = f.cF(i2 == 763 ? ((j.a) this.req).Kzu.KLV.KLX.getBufferToBytes() : null);
                            if (i2 == 3941) {
                                cF = f.cF(((j.c) this.req).Kzu.KLV.KLX.getBufferToBytes());
                            }
                            this.req.setEcdhEngine(cF);
                            boolean packHybridEcdh2 = MMProtocalJni.packHybridEcdh(pByteArray, bArr2, this.req.getDeviceID(), (int) j2, bVar.getFuncId(), f.Kze, UtilsJni.HybridEcdhEncrypt(cF, protoBuf), i6, bVar.getRouteInfo(), 12);
                            Log.d("MicroMsg.RemoteReq", "summerauths reqToBuf packHybridEcdh using protobuf ok, jType:%d, cert:%d len:%d, flag:%d ret:%s", Integer.valueOf(i2), Integer.valueOf(f.Kze), Integer.valueOf(pByteArray.value.length), Integer.valueOf(i6), Boolean.valueOf(packHybridEcdh2));
                            this.iNc = pByteArray.value;
                            this.req.setBufferSize((long) this.iNc.length);
                            AppMethodBeat.o(132425);
                            return packHybridEcdh2;
                        } else if (this.req.getReqPackControl() != null) {
                            int i9 = 6;
                            if (z) {
                                i9 = 7;
                            }
                            l.a reqPackControl2 = this.req.getReqPackControl();
                            bVar.getRouteInfo();
                            if (reqPackControl2.a(pByteArray, i2, bArr2, bArr3, i9)) {
                                this.iNc = pByteArray.value;
                                this.req.setBufferSize((long) this.iNc.length);
                                Log.d("MicroMsg.RemoteReq", "reqToBuf using req.getReqPackControl() ok, len:%d", Integer.valueOf(pByteArray.value.length));
                            }
                            AppMethodBeat.o(132425);
                            return true;
                        } else {
                            int i10 = 0;
                            if (!Util.isNullOrNil(bArr3) && !Util.isNullOrNil(protoBuf)) {
                                i10 = MMProtocalJni.genSignature((int) j2, bArr3, protoBuf);
                            }
                            if (this.iNa == 2) {
                                Log.i("MicroMsg.RemoteReq", "do new request ,header " + new String(this.iNb, StandardCharsets.UTF_8));
                                ekm ekm = new ekm();
                                ekm.NjD = -1179822202;
                                ekm.NjE = new b(this.iNb);
                                ekm.NjF = new b(protoBuf);
                                bArr6 = ekm.toByteArray();
                            } else {
                                bArr6 = protoBuf;
                            }
                            Object[] objArr3 = new Object[5];
                            objArr3[0] = bArr4;
                            objArr3[1] = Integer.valueOf(i2);
                            objArr3[2] = Integer.valueOf(i6);
                            objArr3[3] = Integer.valueOf(bArr3 == null ? -1 : bArr3.length);
                            objArr3[4] = Integer.valueOf(i10);
                            Log.i("MicroMsg.RemoteReq", "summerauths dkrsa use session :%s  type:%d, flag:%d, ecdh:[%s] signature[%d]", objArr3);
                            if (i3 == 13) {
                                bArr7 = UtilsJni.AesGcmEncryptWithCompress(bArr4, bArr6);
                                Object[] objArr4 = new Object[4];
                                objArr4[0] = Integer.valueOf(i2);
                                objArr4[1] = Integer.valueOf(bArr4 == null ? -1 : bArr4.length);
                                if (bArr6 == null) {
                                    length3 = -1;
                                } else {
                                    length3 = bArr6.length;
                                }
                                objArr4[2] = Integer.valueOf(length3);
                                if (bArr7 == null) {
                                    length4 = -1;
                                } else {
                                    length4 = bArr7.length;
                                }
                                objArr4[3] = Integer.valueOf(length4);
                                Log.i("MicroMsg.RemoteReq", "summerauths AesGcmEncryptWithCompress jType[%s] key[%s] message[%s] buf[%s]", objArr4);
                            } else {
                                bArr7 = bArr6;
                            }
                            if (MMProtocalJni.pack(bArr7, pByteArray, bArr4, i3, bArr2, this.req.getDeviceID(), (int) j2, bVar.getFuncId(), rsaInfo.ver, rsaInfo.KAw.getBytes(), rsaInfo.KAx.getBytes(), i10, i6, bVar.getRouteInfo(), this.iNa)) {
                                Log.d("MicroMsg.RemoteReq", "summerauths reqToBuf using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i6));
                                this.iNc = pByteArray.value;
                            }
                            this.req.setBufferSize((long) this.iNc.length);
                            AppMethodBeat.o(132425);
                            return true;
                        }
                    } else {
                        Log.e("MicroMsg.RemoteReq", "dksession jType %d session should not null", Integer.valueOf(i2));
                        AppMethodBeat.o(132425);
                        return false;
                    }
                }
            } catch (Exception e3) {
                Log.e("MicroMsg.RemoteReq", "protobuf build exception, check now! :" + e3.getMessage());
                Log.printErrStackTrace("MicroMsg.RemoteReq", e3, "", new Object[0]);
                AppMethodBeat.o(132425);
                return false;
            }
        }
    }

    public static byte[][] a(long j2, com.tencent.mm.bw.a aVar, com.tencent.mm.bw.a aVar2) {
        byte[] bArr;
        byte[] bArr2;
        AppMethodBeat.i(132426);
        if (j2 == 0) {
            Log.w("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray autoauth uin is invalid!");
        }
        try {
            bArr = aVar.toByteArray();
        } catch (IOException e2) {
            Log.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf rsaReqData toProtoBuf exception:%s", Util.stackTraceToString(e2));
            bArr = null;
        }
        if (Util.isNullOrNil(bArr)) {
            Log.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf rsaReqDataBuf is null and ret false");
            AppMethodBeat.o(132426);
            return null;
        }
        try {
            bArr2 = aVar2.toByteArray();
        } catch (IOException e3) {
            Log.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf aesReqData toProtoBuf exception:%s", Util.stackTraceToString(e3));
            bArr2 = null;
        }
        if (Util.isNullOrNil(bArr2)) {
            Log.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf aesReqDataBuf is null and ret false");
            AppMethodBeat.o(132426);
            return null;
        }
        byte[][] bArr3 = {bArr, bArr2};
        AppMethodBeat.o(132426);
        return bArr3;
    }

    @Override // com.tencent.mm.protocal.h
    public final byte[] aZm() {
        return this.iNc;
    }

    @Override // com.tencent.mm.protocal.h
    public final void setSessionKey(byte[] bArr) {
        AppMethodBeat.i(132427);
        this.req.setSessionKey(bArr);
        AppMethodBeat.o(132427);
    }

    @Override // com.tencent.mm.protocal.h
    public final byte[] getSessionKey() {
        AppMethodBeat.i(132428);
        byte[] sessionKey = this.req.getSessionKey();
        AppMethodBeat.o(132428);
        return sessionKey;
    }

    @Override // com.tencent.mm.protocal.h
    public final void setUin(int i2) {
        AppMethodBeat.i(132429);
        this.req.setUin(i2);
        AppMethodBeat.o(132429);
    }

    @Override // com.tencent.mm.protocal.h
    public final int getUin() {
        AppMethodBeat.i(132430);
        int uin = this.req.getUin();
        AppMethodBeat.o(132430);
        return uin;
    }

    @Override // com.tencent.mm.protocal.h
    public final void setClientVersion(int i2) {
        AppMethodBeat.i(132431);
        this.req.setClientVersion(i2);
        AppMethodBeat.o(132431);
    }

    @Override // com.tencent.mm.protocal.h
    public final int getClientVersion() {
        AppMethodBeat.i(132432);
        int clientVersion = this.req.getClientVersion();
        AppMethodBeat.o(132432);
        return clientVersion;
    }

    @Override // com.tencent.mm.protocal.h
    public final void setDeviceType(String str) {
        AppMethodBeat.i(132433);
        this.req.setDeviceType(str);
        AppMethodBeat.o(132433);
    }

    @Override // com.tencent.mm.protocal.h
    public final String getDeviceType() {
        AppMethodBeat.i(132434);
        String deviceType = this.req.getDeviceType();
        AppMethodBeat.o(132434);
        return deviceType;
    }

    @Override // com.tencent.mm.protocal.h
    public final String getDeviceID() {
        AppMethodBeat.i(132435);
        String deviceID = this.req.getDeviceID();
        AppMethodBeat.o(132435);
        return deviceID;
    }

    @Override // com.tencent.mm.protocal.h
    public final void setDeviceID(String str) {
        AppMethodBeat.i(132436);
        this.req.setDeviceID(str);
        AppMethodBeat.o(132436);
    }

    @Override // com.tencent.mm.protocal.h
    public final void setSceneStatus(int i2) {
        AppMethodBeat.i(132437);
        this.req.setSceneStatus(i2);
        AppMethodBeat.o(132437);
    }

    @Override // com.tencent.mm.protocal.h
    public final int getSceneStatus() {
        AppMethodBeat.i(132438);
        int sceneStatus = this.req.getSceneStatus();
        AppMethodBeat.o(132438);
        return sceneStatus;
    }

    @Override // com.tencent.mm.protocal.h
    public final byte[] getPassKey() {
        byte[] a2;
        AppMethodBeat.i(132439);
        Log.d("MicroMsg.RemoteReq", "dkrsa getpass type:%d", Integer.valueOf(this.type));
        switch (this.type) {
            case 126:
                byte[] byteArray = ((x.a) this.req).KAi.KPW.getBuffer().toByteArray();
                AppMethodBeat.o(132439);
                return byteArray;
            case 381:
                byte[] byteArray2 = ((t.a) this.req).KAc.KPW.getBuffer().toByteArray();
                AppMethodBeat.o(132439);
                return byteArray2;
            case 701:
                byte[] byteArray3 = ((j.f) this.req).Kzy.MrA.KPW.getBuffer().toByteArray();
                AppMethodBeat.o(132439);
                return byteArray3;
            case 702:
                byte[] byteArray4 = ((j.a) this.req).Kzu.KLV.KLX.getBuffer().toByteArray();
                AppMethodBeat.o(132439);
                return byteArray4;
            default:
                if (iMZ != null && (a2 = iMZ.a(this.req, this.type)) != null) {
                    AppMethodBeat.o(132439);
                    return a2;
                } else if (this.req.getPassKey() != null) {
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(this.req.getPassKey() == null ? -1 : this.req.getPassKey().length);
                    Log.d("MicroMsg.RemoteReq", "summerauths getPassKey[%s]", objArr);
                    byte[] passKey = this.req.getPassKey();
                    AppMethodBeat.o(132439);
                    return passKey;
                } else {
                    byte[] sessionKey = getSessionKey();
                    AppMethodBeat.o(132439);
                    return sessionKey;
                }
        }
    }

    @Override // com.tencent.mm.protocal.h
    public final void setPassKey(byte[] bArr) {
        AppMethodBeat.i(132440);
        this.req.setPassKey(bArr);
        AppMethodBeat.o(132440);
    }

    @Override // com.tencent.mm.protocal.h
    public final String getPassword() {
        switch (this.type) {
            case 126:
            case com.tencent.mm.plugin.appbrand.jsapi.openvoice.g.CTRL_INDEX /*{ENCODED_INT: 877}*/:
                return ((x.a) this.req).KAi.KQi;
            case 252:
            case 701:
                return ((j.f) this.req).Kzy.MrA.KQi;
            default:
                return "";
        }
    }

    @Override // com.tencent.mm.protocal.h
    public final String aZn() {
        switch (this.type) {
            case 252:
            case 701:
                return ((j.f) this.req).Kzy.MrA.KQv;
            default:
                return "";
        }
    }

    @Override // com.tencent.mm.protocal.h
    public final String getUserName() {
        switch (this.type) {
            case 126:
            case com.tencent.mm.plugin.appbrand.jsapi.openvoice.g.CTRL_INDEX /*{ENCODED_INT: 877}*/:
                return ((x.a) this.req).KAi.UserName;
            case 252:
            case 701:
                return ((j.f) this.req).Kzy.MrA.UserName;
            case 702:
            case 763:
                return ((j.a) this.req).username;
            case 3941:
                return ((j.c) this.req).username;
            default:
                return "";
        }
    }

    @Override // com.tencent.mm.protocal.h
    public final int getCmdId() {
        AppMethodBeat.i(132441);
        int cmdId = this.req.getCmdId();
        AppMethodBeat.o(132441);
        return cmdId;
    }

    @Override // com.tencent.mm.protocal.h
    public final boolean getShortSupport() {
        AppMethodBeat.i(132442);
        boolean shortSupport = this.req.getShortSupport();
        AppMethodBeat.o(132442);
        return shortSupport;
    }

    @Override // com.tencent.mm.protocal.h
    public final long getECDHEngine() {
        AppMethodBeat.i(132443);
        long eCDHEngine = this.req.getECDHEngine();
        AppMethodBeat.o(132443);
        return eCDHEngine;
    }

    @Override // com.tencent.mm.protocal.h
    public final boolean isAxAuth() {
        AppMethodBeat.i(132444);
        boolean isAxAuth = this.req.isAxAuth();
        AppMethodBeat.o(132444);
        return isAxAuth;
    }

    @Override // com.tencent.mm.protocal.h
    public final void setUseAxsession(boolean z) {
        AppMethodBeat.i(132445);
        this.req.setUseAxsession(z);
        AppMethodBeat.o(132445);
    }

    @Override // com.tencent.mm.protocal.h
    public final boolean useAxSession() {
        AppMethodBeat.i(132446);
        boolean useAxSession = this.req.useAxSession();
        AppMethodBeat.o(132446);
        return useAxSession;
    }

    @Override // com.tencent.mm.protocal.h
    public final void sL(int i2) {
        if (i2 == 1 || i2 == 2) {
            this.iNa = i2;
        } else {
            this.iNa = 0;
        }
    }

    @Override // com.tencent.mm.protocal.h
    public final void an(byte[] bArr) {
        this.iNb = bArr;
    }
}
