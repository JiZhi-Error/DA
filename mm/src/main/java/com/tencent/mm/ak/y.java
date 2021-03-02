package com.tencent.mm.ak;

import android.os.Looper;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.f;
import com.tencent.mm.network.l;
import com.tencent.mm.network.s;
import com.tencent.mm.network.t;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.protocal.protobuf.dta;
import com.tencent.mm.protocal.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class y extends t.a {
    MMHandler handler;
    private s iMO;
    h iNd;
    i iNe;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public y(s sVar) {
        this(sVar, Looper.myLooper() == null ? new MMHandler(Looper.getMainLooper()) : new MMHandler());
        AppMethodBeat.i(132450);
        AppMethodBeat.o(132450);
    }

    public y(s sVar, MMHandler mMHandler) {
        AppMethodBeat.i(132451);
        this.iMO = sVar;
        this.iNd = new x(sVar.getReqObj(), sVar.getType());
        this.iNe = new z(sVar.getRespObj(), sVar.getType());
        this.handler = mMHandler;
        AppMethodBeat.o(132451);
    }

    @Override // com.tencent.mm.network.t
    public final boolean getIsUserCmd() {
        AppMethodBeat.i(132452);
        boolean isUserCmd = this.iMO.getIsUserCmd();
        AppMethodBeat.o(132452);
        return isUserCmd;
    }

    @Override // com.tencent.mm.network.t
    public final int getMMReqRespHash() {
        AppMethodBeat.i(132453);
        int hashCode = this.iMO.hashCode();
        AppMethodBeat.o(132453);
        return hashCode;
    }

    @Override // com.tencent.mm.network.t
    public final int getOptions() {
        AppMethodBeat.i(132454);
        int options = this.iMO.getOptions();
        AppMethodBeat.o(132454);
        return options;
    }

    @Override // com.tencent.mm.network.t
    public final h aZo() {
        return this.iNd;
    }

    @Override // com.tencent.mm.network.t
    public final i aZp() {
        return this.iNe;
    }

    @Override // com.tencent.mm.network.t
    public final int getType() {
        AppMethodBeat.i(132455);
        int type = this.iMO.getType();
        AppMethodBeat.o(132455);
        return type;
    }

    @Override // com.tencent.mm.network.t
    public final String getUri() {
        AppMethodBeat.i(132456);
        String uri = this.iMO.getUri();
        AppMethodBeat.o(132456);
        return uri;
    }

    @Override // com.tencent.mm.network.t
    public final void setConnectionInfo(String str) {
        AppMethodBeat.i(132457);
        this.iMO.setConnectionInfo(str);
        AppMethodBeat.o(132457);
    }

    @Override // com.tencent.mm.network.t
    public final String getCgiVerifyPublicKey() {
        AppMethodBeat.i(197067);
        String cgiVerifyPublicKey = this.iMO.getReqObj().getCgiVerifyPublicKey();
        AppMethodBeat.o(197067);
        return cgiVerifyPublicKey;
    }

    @Override // com.tencent.mm.network.t
    public final String getCgiVerifyPrivateKey() {
        AppMethodBeat.i(197068);
        String cgiVerifyPrivateKey = this.iMO.getReqObj().getCgiVerifyPrivateKey();
        AppMethodBeat.o(197068);
        return cgiVerifyPrivateKey;
    }

    @Override // com.tencent.mm.network.t
    public final void a(l lVar, final int i2, final int i3, final String str) {
        AppMethodBeat.i(132458);
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.ak.y.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(132447);
                Log.d("MicroMsg.RemoteReqResp", "summerauth doAutoAuthEnd type:%d, stack[%s]", Integer.valueOf(y.this.iMO.getType()), Util.getStack());
                j.h hVar = (j.h) y.this.iMO.getReqObj();
                j.i iVar = (j.i) y.this.iMO.getRespObj();
                if (iVar == null) {
                    Log.f("MicroMsg.RemoteReqResp", "null auth.resp");
                    AppMethodBeat.o(132447);
                    return;
                }
                j.e.a.Kzx.a(hVar, iVar, i2, i3, str);
                AppMethodBeat.o(132447);
            }
        });
        AppMethodBeat.o(132458);
    }

    @Override // com.tencent.mm.network.t
    public final void a(final l lVar, final int i2, final int i3) {
        AppMethodBeat.i(132459);
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.ak.y.AnonymousClass2 */

            /* JADX WARNING: Removed duplicated region for block: B:18:0x009a  */
            /* JADX WARNING: Removed duplicated region for block: B:21:0x00a5  */
            /* JADX WARNING: Removed duplicated region for block: B:36:0x0123  */
            /* JADX WARNING: Removed duplicated region for block: B:48:0x0170  */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x0174  */
            /* JADX WARNING: Removed duplicated region for block: B:59:0x0196  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 445
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ak.y.AnonymousClass2.run():void");
            }
        });
        AppMethodBeat.o(132459);
    }

    @Override // com.tencent.mm.network.t
    public final void a(f fVar, final l lVar, final int i2, final int i3) {
        AppMethodBeat.i(132460);
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.ak.y.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(132449);
                try {
                    lVar.a(new y(new p(), y.this.handler), i2, i3, "");
                    AppMethodBeat.o(132449);
                } catch (RemoteException e2) {
                    Log.e("MicroMsg.RemoteReqResp", "exception:%s", Util.stackTraceToString(e2));
                    AppMethodBeat.o(132449);
                }
            }
        });
        AppMethodBeat.o(132460);
    }

    @Override // com.tencent.mm.network.t
    public final int aZq() {
        byte[] bArr;
        int length;
        AppMethodBeat.i(132461);
        int type = getType();
        int i2 = -1;
        Log.d("MicroMsg.RemoteReqResp", "summerauth decodeAndRetriveAccInfo type:%d", Integer.valueOf(type));
        switch (type) {
            case 126:
                s sVar = this.iMO;
                x.a aVar = (x.a) sVar.getReqObj();
                x.b bVar = (x.b) sVar.getRespObj();
                Log.i("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo type:%d, stack[%s]", Integer.valueOf(aVar.getFuncId()), Util.getStack());
                if (bVar.hku != 0) {
                    Log.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", Integer.valueOf(bVar.hku));
                } else {
                    dta dta = bVar.KAj.MyS;
                    if (dta != null) {
                        int i3 = dta.KLn;
                        aif aif = dta.KKX;
                        byte[] a2 = z.a(dta.KLq);
                        byte[] a3 = z.a(dta.KLr);
                        byte[] a4 = z.a(dta.KKY);
                        Object[] objArr = new Object[6];
                        objArr[0] = Integer.valueOf(aif.KLU.getILen());
                        objArr[1] = Integer.valueOf(aif.LrO);
                        objArr[2] = Integer.valueOf(a4 == null ? -1 : a4.length);
                        objArr[3] = Util.secPrint(Util.dumpHex(a4));
                        objArr[4] = Util.secPrint(Util.dumpHex(a2));
                        objArr[5] = Util.secPrint(Util.dumpHex(a3));
                        Log.d("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s, clientSession[%s], serverSession[%s]", objArr);
                        byte[] a5 = z.a(aif.KLU);
                        byte[] bArr2 = aVar.Kzv;
                        byte[] bArr3 = null;
                        if (!Util.isNullOrNil(a5)) {
                            Object[] objArr2 = new Object[4];
                            objArr2[0] = Integer.valueOf(a5.length);
                            objArr2[1] = Util.secPrint(Util.dumpHex(a5));
                            objArr2[2] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
                            objArr2[3] = Util.secPrint(Util.dumpHex(bArr2));
                            Log.d("MicroMsg.MMReqRespReg2", "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s", objArr2);
                            PByteArray pByteArray = new PByteArray();
                            int computerKeyWithAllStr = MMProtocalJni.computerKeyWithAllStr(aif.LrO, a5, bArr2, pByteArray, 0);
                            bArr3 = pByteArray.value;
                            Object[] objArr3 = new Object[3];
                            objArr3[0] = Integer.valueOf(computerKeyWithAllStr);
                            if (bArr3 == null) {
                                length = -1;
                            } else {
                                length = bArr3.length;
                            }
                            objArr3[1] = Integer.valueOf(length);
                            objArr3[2] = Util.secPrint(Util.dumpHex(bArr3));
                            Log.i("MicroMsg.MMReqRespReg2", "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s", objArr3);
                        } else {
                            Log.w("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key is null!");
                        }
                        if (bArr3 != null) {
                            bArr = bArr3;
                        } else {
                            bArr = new byte[0];
                        }
                        bVar.KzA = bArr;
                        if ((i3 & 4) != 0) {
                            Log.d("MicroMsg.MMReqRespReg2", "summerauth must decode session key");
                            if (!Util.isNullOrNil(bArr3)) {
                                byte[] aesDecrypt = MMProtocalJni.aesDecrypt(a4, bArr3);
                                Object[] objArr4 = new Object[4];
                                objArr4[0] = Integer.valueOf(a4 == null ? -1 : a4.length);
                                objArr4[1] = Util.dumpHex(a4);
                                objArr4[2] = Integer.valueOf(aesDecrypt == null ? -1 : aesDecrypt.length);
                                objArr4[3] = Util.secPrint(Util.dumpHex(aesDecrypt));
                                Log.d("MicroMsg.MMReqRespReg2", "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s", objArr4);
                                if (!Util.isNullOrNil(aesDecrypt)) {
                                    Log.d("MicroMsg.MMReqRespReg2", "summerauth decode session key succ session:%s", Util.secPrint(Util.dumpHex(aesDecrypt)));
                                    bVar.b(aesDecrypt, a2, a3);
                                    bVar.hku = 1;
                                } else {
                                    Log.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed ret null!");
                                    bVar.b(new byte[0], a2, a3);
                                    bVar.hku = 2;
                                }
                            } else {
                                Log.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed as agreedECDHKey is null!");
                                bVar.b(new byte[0], a2, a3);
                                bVar.hku = 2;
                            }
                        } else {
                            Log.d("MicroMsg.MMReqRespReg2", "summerauth not need decode session key");
                            bVar.b(a4, a2, a3);
                            bVar.hku = 1;
                        }
                    } else {
                        Log.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo sect null and decode failed!");
                        bVar.b(new byte[0], new byte[0], new byte[0]);
                        bVar.hku = 2;
                    }
                }
                i2 = bVar.hku;
                break;
            case 252:
            case 701:
            case 702:
            case 763:
                i2 = bh.a(this.iMO);
                break;
        }
        AppMethodBeat.o(132461);
        return i2;
    }

    @Override // com.tencent.mm.network.t
    public final int getTimeOut() {
        AppMethodBeat.i(132462);
        int timeOut = this.iMO.getTimeOut();
        AppMethodBeat.o(132462);
        return timeOut;
    }

    @Override // com.tencent.mm.network.t
    public final boolean isSingleSession() {
        AppMethodBeat.i(132463);
        boolean isSingleSession = this.iMO.isSingleSession();
        AppMethodBeat.o(132463);
        return isSingleSession;
    }

    @Override // com.tencent.mm.network.t
    public final boolean getIsLongPolling() {
        AppMethodBeat.i(197069);
        boolean isLongPolling = this.iMO.getIsLongPolling();
        AppMethodBeat.o(197069);
        return isLongPolling;
    }

    @Override // com.tencent.mm.network.t
    public final boolean aZr() {
        AppMethodBeat.i(197070);
        boolean keepAlive = this.iMO.keepAlive();
        AppMethodBeat.o(197070);
        return keepAlive;
    }

    @Override // com.tencent.mm.network.t
    public final int getLongPollingTimeout() {
        AppMethodBeat.i(197071);
        int longPollingTimeout = this.iMO.getLongPollingTimeout();
        AppMethodBeat.o(197071);
        return longPollingTimeout;
    }

    @Override // com.tencent.mm.network.t
    public final int getNewExtFlags() {
        AppMethodBeat.i(197072);
        int newExtFlags = this.iMO.getNewExtFlags();
        AppMethodBeat.o(197072);
        return newExtFlags;
    }

    @Override // com.tencent.mm.network.t
    public final byte[] getTransHeader() {
        AppMethodBeat.i(197073);
        byte[] transHeader = this.iMO.getTransHeader();
        AppMethodBeat.o(197073);
        return transHeader;
    }
}
