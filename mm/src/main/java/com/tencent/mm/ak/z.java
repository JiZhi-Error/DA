package com.tencent.mm.ak;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.g;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.div;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dta;
import com.tencent.mm.protocal.t;
import com.tencent.mm.protocal.x;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class z extends i.a {
    private static a iNk;
    private static char[] iNl = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private byte[] ees;
    private l.e iNj;
    private int type;

    public interface a {
        void gs(String str);
    }

    public static void a(a aVar) {
        iNk = aVar;
    }

    public z(l.e eVar, int i2) {
        this.iNj = eVar;
        this.type = i2;
    }

    @Override // com.tencent.mm.protocal.i
    public final boolean a(int i2, byte[] bArr, byte[] bArr2, long j2) {
        int length;
        int length2;
        int length3;
        int length4;
        AppMethodBeat.i(132465);
        PByteArray pByteArray = new PByteArray();
        if (!(this.iNj instanceof l.c)) {
            Log.f("MicroMsg.RemoteResp", "all protocal should implemented with protobuf");
            AppMethodBeat.o(132465);
            return false;
        }
        PByteArray pByteArray2 = new PByteArray();
        PInt pInt = new PInt(0);
        l.c cVar = (l.c) this.iNj;
        PInt pInt2 = new PInt(0);
        PInt pInt3 = new PInt(0);
        PInt pInt4 = new PInt(255);
        try {
            if (cVar.isRawData()) {
                int fromProtoBuf = cVar.fromProtoBuf(bArr);
                Log.d("MicroMsg.RemoteResp", "rawData using protobuf ok");
                this.iNj.setRetCode(fromProtoBuf);
                if (!Util.isNullOrNil(ac.jOF)) {
                    this.iNj.setErrMsg(ac.jOF);
                }
                AppMethodBeat.o(132465);
                return true;
            }
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            objArr[2] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
            objArr[3] = pByteArray.value;
            Log.i("MicroMsg.RemoteResp", "summerauths jType[%s] jBuf[%s] jSession[%s], jCookieBuf[%s]", objArr);
            boolean unpack = MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3, pInt4);
            Object[] objArr2 = new Object[7];
            objArr2[0] = Boolean.valueOf(unpack);
            objArr2[1] = Integer.valueOf(i2);
            objArr2[2] = Integer.valueOf(pInt2.value);
            objArr2[3] = Integer.valueOf(pInt3.value);
            objArr2[4] = Integer.valueOf(pInt4.value);
            objArr2[5] = pByteArray2.value;
            if (pByteArray2.value == null) {
                length = -1;
            } else {
                length = pByteArray2.value.length;
            }
            objArr2[6] = Integer.valueOf(length);
            Log.i("MicroMsg.RemoteResp", "bufToResp unpack ret[%b], jType[%d], enType[%s], noticeid[%d], headExtFlags[%d] pr len[%s, %s]", objArr2);
            if (unpack) {
                this.iNj.setHeadExtFlags(pInt4.value);
                if (!(i2 == 701 || i2 == 702 || i2 == 252 || i2 == 763 || 10001 != ac.jOC || ac.jOD <= 0)) {
                    if (ac.jOD == 2) {
                        com.tencent.mm.protocal.ac.aq("", "", 0);
                    }
                    ac.jOD = 0;
                    pInt.value = -13;
                    Log.w("MicroMsg.RemoteResp", "dkcert dktest set session timeout once !");
                }
                if (pInt.value == -306) {
                    Log.i("MicroMsg.RemoteResp", "summerauths MM_ERR_ECDHFAIL_ROLLBACK USE_ECDH old[%s]", Boolean.valueOf(f.KyZ));
                    f.KyZ = false;
                } else if (pInt2.value == 13) {
                    pByteArray2.value = UtilsJni.AesGcmDecryptWithUncompress(bArr2, pByteArray2.value);
                    Object[] objArr3 = new Object[3];
                    objArr3[0] = Integer.valueOf(i2);
                    objArr3[1] = pByteArray2.value;
                    if (pByteArray2.value == null) {
                        length4 = -1;
                    } else {
                        length4 = pByteArray2.value.length;
                    }
                    objArr3[2] = Integer.valueOf(length4);
                    Log.i("MicroMsg.RemoteResp", "bufToResp AES_GCM_ENCRYPT jType[%s] new pr[%s, %s]", objArr3);
                } else if (pInt2.value == 12) {
                    int length5 = pByteArray2.value == null ? -1 : pByteArray2.value.length;
                    if (j2 == 0) {
                        Log.e("MicroMsg.RemoteResp", "summerauths HYBRID_ECDH_ENCRYPT but req engine is 0 jType[%s]", Integer.valueOf(i2));
                    }
                    pByteArray2.value = UtilsJni.HybridEcdhDecrypt(j2, pByteArray2.value);
                    f.Mt(j2);
                    Object[] objArr4 = new Object[6];
                    objArr4[0] = Integer.valueOf(i2);
                    objArr4[1] = Integer.valueOf(pInt.value);
                    objArr4[2] = Long.valueOf(j2);
                    objArr4[3] = pByteArray2.value;
                    objArr4[4] = Integer.valueOf(length5);
                    if (pByteArray2.value == null) {
                        length3 = -1;
                    } else {
                        length3 = pByteArray2.value.length;
                    }
                    objArr4[5] = Integer.valueOf(length3);
                    Log.i("MicroMsg.RemoteResp", "bufToResp HYBRID_ECDH_ENCRYPT type[%s] ret.value[%s] engine[%s] new pr[%s, %s -> %s]", objArr4);
                } else if (pInt2.value == 11) {
                    int length6 = pByteArray2.value == null ? -1 : pByteArray2.value.length;
                    if (j2 == 0) {
                        Log.e("MicroMsg.RemoteResp", "summerauths AX_ECDH_ENCRYPT but req engine is 0 jType[%s]", Integer.valueOf(i2));
                    }
                    pByteArray2.value = UtilsJni.AxEcdhDecrypt(j2, pByteArray2.value);
                    UtilsJni.ReleaseAxEcdhCryptoEngine(j2);
                    Object[] objArr5 = new Object[6];
                    objArr5[0] = Integer.valueOf(i2);
                    objArr5[1] = Integer.valueOf(pInt.value);
                    objArr5[2] = Long.valueOf(j2);
                    objArr5[3] = pByteArray2.value;
                    objArr5[4] = Integer.valueOf(length6);
                    if (pByteArray2.value == null) {
                        length2 = -1;
                    } else {
                        length2 = pByteArray2.value.length;
                    }
                    objArr5[5] = Integer.valueOf(length2);
                    Log.i("MicroMsg.RemoteResp", "bufToResp AX_ECDH_ENCRYPT type[%s] ret.value[%s] engine[%s] new pr[%s, %s -> %s]", objArr5);
                }
                if (pInt.value == -13 || pInt.value == -102 || pInt.value == -3001 || pInt.value == -3002 || pInt.value == -3003 || pInt.value == -306 || pInt.value == -3006) {
                    this.iNj.setRetCode(pInt.value);
                    if (pInt.value == -3002) {
                        try {
                            this.iNj.setErrMsg(new String(pByteArray2.value));
                        } catch (Exception e2) {
                            Log.e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
                        }
                        Log.i("MicroMsg.RemoteResp", "jType [%d], ret value[%d], noticeId[%s], msg[%s]", Integer.valueOf(i2), Integer.valueOf(pInt.value), pInt3, this.iNj.getErrMsg());
                    }
                } else {
                    try {
                        int fromProtoBuf2 = cVar.fromProtoBuf(pByteArray2.value);
                        Log.i("MicroMsg.RemoteResp", "bufToResp using protobuf ok jType:%d, enType:%d errCode:%d, len:%d, headExtFlags:%d", Integer.valueOf(i2), Integer.valueOf(pInt2.value), Integer.valueOf(fromProtoBuf2), Integer.valueOf(pByteArray2.value.length), Integer.valueOf(this.iNj.getHeadExtFlags()));
                        this.iNj.setRetCode(fromProtoBuf2);
                        if (fromProtoBuf2 == -305) {
                            Log.i("MicroMsg.RemoteResp", "summerauths  MM_ERR_CERT_SWITCH  old ver:%d cgi[%s]", Integer.valueOf(f.Kze), Integer.valueOf(i2));
                            f.gtz();
                        }
                    } catch (OutOfMemoryError e3) {
                        Log.e("MicroMsg.RemoteResp", "fromprotobuf oom error, msg:" + e3.getMessage() + ", dump:\n" + toHexString(pByteArray2.value));
                        this.iNj.setRetCode(-1);
                        AppMethodBeat.o(132465);
                        return true;
                    }
                }
                this.iNj.setBufferSize((long) bArr.length);
                this.ees = pByteArray.value;
                if (!Util.isNullOrNil(ac.jOF)) {
                    this.iNj.setErrMsg(ac.jOF);
                }
                if (pInt3.value != 0) {
                    jm jmVar = new jm();
                    jmVar.dOn.dOo = pInt3.value;
                    if ((i2 == 252 || i2 == 701) && this.iNj.getRetCode() == 0) {
                        Log.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent MMFunc_ManualAuth ok [%d] jType[%d]", Integer.valueOf(pInt3.value), Integer.valueOf(i2));
                        jmVar.dOn.dOp = true;
                    }
                    Log.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(EventCenter.instance.publish(jmVar)));
                    pInt3.value = 0;
                }
                AppMethodBeat.o(132465);
                return true;
            }
            Log.e("MicroMsg.RemoteResp", "unpack return false jType[%d]", Integer.valueOf(i2));
            if (pInt3.value != 0) {
                jm jmVar2 = new jm();
                jmVar2.dOn.dOo = pInt3.value;
                Log.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(EventCenter.instance.publish(jmVar2)));
                pInt3.value = 0;
            }
            AppMethodBeat.o(132465);
            return false;
        } catch (Exception e4) {
            Log.printErrStackTrace("MicroMsg.RemoteResp", e4, "from Protobuf unbuild exception, check now!", new Object[0]);
            Log.e("MicroMsg.RemoteResp", "exception:%s", Util.stackTraceToString(e4));
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, PInt pInt, dpc dpc) {
        AppMethodBeat.i(132466);
        PByteArray pByteArray = new PByteArray();
        pInt.value = -1;
        PByteArray pByteArray2 = new PByteArray();
        PInt pInt2 = new PInt(0);
        PInt pInt3 = new PInt(0);
        PInt pInt4 = new PInt(255);
        try {
            boolean unpack = MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3, pInt4);
            Log.i("MicroMsg.RemoteResp", "bufToRespNoRSA unpack ret[%b], noticeid[%d], headExtFlags[%d]", Boolean.valueOf(unpack), Integer.valueOf(pInt3.value), Integer.valueOf(pInt4.value));
            if (pInt3.value != 0) {
                jm jmVar = new jm();
                jmVar.dOn.dOo = pInt3.value;
                Log.i("MicroMsg.RemoteResp", "summerdiz bufToRespNoRSA publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(EventCenter.instance.publish(jmVar)));
            }
            if (!unpack) {
                Log.e("MicroMsg.RemoteResp", "unpack failed.");
                AppMethodBeat.o(132466);
                return null;
            } else if (pInt.value == -13 || pInt.value == -102 || pInt.value == -3001) {
                Log.e("MicroMsg.RemoteResp", "unpack failed. error:%d", Integer.valueOf(pInt.value));
                AppMethodBeat.o(132466);
                return null;
            } else if (pInt.value == -3002) {
                try {
                    final String str = new String(pByteArray2.value);
                    Log.i("MicroMsg.RemoteResp", "bufToRespNoRSA -3002 ERR_IDCDISASTER, errStr:%s", str);
                    new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.tencent.mm.ak.z.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(132464);
                            if (!Util.isNullOrNil(str) && z.iNk != null) {
                                z.iNk.gs(str);
                            }
                            AppMethodBeat.o(132464);
                        }
                    });
                    AppMethodBeat.o(132466);
                    return null;
                } catch (Exception e2) {
                    Log.e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
                }
            } else {
                Log.i("MicroMsg.RemoteResp", "fuckwifi bufToRespNoRSA using protobuf ok jtype:%d enType:%d ", 110, Integer.valueOf(pInt2.value));
                dpc.parseFrom(pByteArray2.value);
                byte[] bArr3 = pByteArray2.value;
                AppMethodBeat.o(132466);
                return bArr3;
            }
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.RemoteResp", e3, "parseFrom unbuild exception, check now!", new Object[0]);
            Log.e("MicroMsg.RemoteResp", "exception:%s", Util.stackTraceToString(e3));
        }
    }

    @Override // com.tencent.mm.protocal.i
    public final byte[] aZa() {
        return this.ees;
    }

    @Override // com.tencent.mm.protocal.i
    public final int getHeadExtFlags() {
        AppMethodBeat.i(132467);
        int headExtFlags = this.iNj.getHeadExtFlags();
        AppMethodBeat.o(132467);
        return headExtFlags;
    }

    @Override // com.tencent.mm.protocal.i
    public final String getErrMsg() {
        AppMethodBeat.i(132468);
        String errMsg = this.iNj.getErrMsg();
        AppMethodBeat.o(132468);
        return errMsg;
    }

    @Override // com.tencent.mm.protocal.i
    public final void setErrMsg(String str) {
        AppMethodBeat.i(132469);
        this.iNj.setErrMsg(str);
        AppMethodBeat.o(132469);
    }

    @Override // com.tencent.mm.protocal.i
    public final int getRetCode() {
        AppMethodBeat.i(132470);
        int retCode = this.iNj.getRetCode();
        AppMethodBeat.o(132470);
        return retCode;
    }

    @Override // com.tencent.mm.protocal.i
    public final void setRetCode(int i2) {
        AppMethodBeat.i(132471);
        this.iNj.setRetCode(i2);
        AppMethodBeat.o(132471);
    }

    @Override // com.tencent.mm.protocal.i
    public final byte[] qe(int i2) {
        AppMethodBeat.i(132472);
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
            case g.CTRL_INDEX /*{ENCODED_INT: 877}*/:
                bArr = ((x.b) this.iNj).aiZ(i2);
                break;
            case 252:
            case 701:
            case 702:
            case 763:
                bArr = ((j.i) this.iNj).aiZ(i2);
                break;
        }
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[2] = Util.getStack();
        Log.i("MicroMsg.RemoteResp", "summerauths getSessionKey seesionKeyType[%s] [%s] [%s]", objArr);
        AppMethodBeat.o(132472);
        return bArr;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.protocal.i
    public final byte[] aZs() {
        byte[] byteArray;
        AppMethodBeat.i(132473);
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
            case g.CTRL_INDEX /*{ENCODED_INT: 877}*/:
                dta dta = ((x.b) this.iNj).KAj.MyS;
                if (dta != null && dta.KKZ != null) {
                    byteArray = dta.KKZ.getBuffer().toByteArray();
                    break;
                } else {
                    Log.d("MicroMsg.RemoteResp", "summerauth reg[%s] SecAuthRegKeySect is null", Integer.valueOf(this.type));
                    byteArray = bArr;
                    break;
                }
                break;
            case 252:
            case 701:
            case 702:
            case 763:
                if (((j.i) this.iNj).Kzw.Nky.KKZ != null) {
                    byteArray = ((j.i) this.iNj).Kzw.Nky.KKZ.getBuffer().toByteArray();
                    break;
                }
                byteArray = bArr;
                break;
            default:
                byteArray = bArr;
                break;
        }
        Log.i("MicroMsg.RemoteResp", "summerauths getAutoAuthKey type[%s] key[%s]", Integer.valueOf(this.type), Integer.valueOf(byteArray.length));
        AppMethodBeat.o(132473);
        return byteArray;
    }

    @Override // com.tencent.mm.protocal.i
    public final byte[] aZc() {
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
            case g.CTRL_INDEX /*{ENCODED_INT: 877}*/:
                return ((x.b) this.iNj).KzA;
            case 252:
            case 701:
            case 702:
            case 763:
                return ((j.i) this.iNj).KzA;
            default:
                return bArr;
        }
    }

    @Override // com.tencent.mm.protocal.i
    public final String aZt() {
        div div;
        AppMethodBeat.i(132474);
        if (this.type != 381 || (div = ((t.b) this.iNj).KAd.LTK) == null) {
            AppMethodBeat.o(132474);
            return "";
        }
        String nullAsNil = Util.nullAsNil(div.MNb);
        AppMethodBeat.o(132474);
        return nullAsNil;
    }

    @Override // com.tencent.mm.protocal.i
    public final String aZu() {
        div div;
        AppMethodBeat.i(132475);
        if (this.type != 381 || (div = ((t.b) this.iNj).KAd.LTK) == null) {
            AppMethodBeat.o(132475);
            return "";
        }
        String nullAsNil = Util.nullAsNil(div.MNa);
        AppMethodBeat.o(132475);
        return nullAsNil;
    }

    @Override // com.tencent.mm.protocal.i
    public final int aZv() {
        if (this.type == 381) {
            return ((t.b) this.iNj).KAd.LSJ;
        }
        return 0;
    }

    @Override // com.tencent.mm.protocal.i
    public final int getUin() {
        switch (this.type) {
            case 126:
            case g.CTRL_INDEX /*{ENCODED_INT: 877}*/:
                return ((x.b) this.iNj).KAj.rBx;
            case 252:
            case 701:
            case 702:
            case 763:
                return ((j.i) this.iNj).Kzw.Nky.rBx;
            default:
                return 0;
        }
    }

    @Override // com.tencent.mm.protocal.i
    public final String aZd() {
        switch (this.type) {
            case 126:
            case g.CTRL_INDEX /*{ENCODED_INT: 877}*/:
                return ((x.b) this.iNj).KAj.UserName;
            case 252:
            case 701:
            case 702:
            case 763:
                return ((j.i) this.iNj).dMW;
            default:
                return "";
        }
    }

    @Override // com.tencent.mm.protocal.i
    public final int getCmdId() {
        AppMethodBeat.i(132476);
        int cmdId = this.iNj.getCmdId();
        AppMethodBeat.o(132476);
        return cmdId;
    }

    @Override // com.tencent.mm.protocal.i
    public final byte[] getAuthResponse() {
        AppMethodBeat.i(132477);
        byte[] authResponse = this.iNj.getAuthResponse();
        AppMethodBeat.o(132477);
        return authResponse;
    }

    @Override // com.tencent.mm.protocal.i
    public final void ao(byte[] bArr) {
        AppMethodBeat.i(197074);
        this.iNj.setProfile(bArr);
        AppMethodBeat.o(197074);
    }

    private static String toHexString(byte[] bArr) {
        AppMethodBeat.i(132478);
        if (bArr == null) {
            AppMethodBeat.o(132478);
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(iNl[(bArr[i2] & 240) >>> 4]);
            sb.append(iNl[bArr[i2] & 15]);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(132478);
        return sb2;
    }
}
