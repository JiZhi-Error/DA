package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.x;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ajk;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.ajm;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.protocal.protobuf.zi;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class q {

    public static class a extends l.d implements l.b {
        public final ajl KzQ = new ajl();

        public a() {
            AppMethodBeat.i(152468);
            setUin(0);
            this.KzQ.LsX = new ajk();
            this.KzQ.LsX.LsV = new zh();
            this.KzQ.LsW = new ajm();
            AppMethodBeat.o(152468);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(152469);
            setRsaInfo(ac.gtR());
            this.KzQ.LsX.setBaseRequest(l.a(this));
            this.KzQ.LsW.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
            setPassKey(this.KzQ.LsW.KPW.getBuffer().toByteArray());
            setReqPackControl(new l.a() {
                /* class com.tencent.mm.protocal.q.a.AnonymousClass1 */

                @Override // com.tencent.mm.protocal.l.a
                public final boolean a(PByteArray pByteArray, int i2, byte[] bArr, byte[] bArr2, int i3) {
                    long j2;
                    AppMethodBeat.i(152467);
                    l.b bVar = (l.b) this;
                    long uin = (long) this.getUin();
                    if (!CrashReportFactory.hasDebuger() || uin != 0) {
                        j2 = uin;
                    } else {
                        j2 = d.KyN;
                    }
                    ac rsaInfo = this.getRsaInfo();
                    if (i2 == 722) {
                        Log.e("MicroMsg.MMEncryptCheckResUpdate", "MMEncryptCheckResUpdate reqToBuf rsaReqData");
                        ajl ajl = ((a) this).KzQ;
                        byte[][] a2 = x.a(j2, ajl.LsW, ajl.LsX);
                        if (a2 == null) {
                            AppMethodBeat.o(152467);
                            return false;
                        }
                        if (MMProtocalJni.packHybrid(pByteArray, bArr, this.getDeviceID(), (int) j2, bVar.getFuncId(), rsaInfo.ver, a2[0], a2[1], rsaInfo.KAw.getBytes(), rsaInfo.KAx.getBytes(), this.getPassKey(), i3, ((a) this).getRouteInfo())) {
                            Log.d("MicroMsg.MMEncryptCheckResUpdate", "IRemoteReqDelegate reqToBuf packHybrid using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i3));
                            AppMethodBeat.o(152467);
                            return true;
                        }
                    } else if (i2 == 784) {
                        Log.i("MicroMsg.MMEncryptCheckResUpdate", "summerauths rsaInfo[%s] EcdhMgr.USE_ECDH[%s] engine[%s]", Integer.valueOf(rsaInfo.ver), Boolean.valueOf(f.KyZ), Long.valueOf(((l.b) this).getECDHEngine()));
                        ((l.b) this).getFuncId();
                        PByteArray pByteArray2 = new PByteArray();
                        byte[] protoBuf = ((l.b) this).toProtoBuf();
                        if (protoBuf == null) {
                            Log.f("MicroMsg.MMEncryptCheckResUpdate", "protobuf is null");
                            AppMethodBeat.o(152467);
                            return false;
                        }
                        long cF = f.cF(null);
                        this.setEcdhEngine(cF);
                        boolean packHybridEcdh = MMProtocalJni.packHybridEcdh(pByteArray2, bArr, this.getDeviceID(), (int) j2, bVar.getFuncId(), f.Kze, UtilsJni.HybridEcdhEncrypt(cF, protoBuf), i3, bVar.getRouteInfo(), 12);
                        Log.d("MicroMsg.MMEncryptCheckResUpdate", "summerauths MMFunc_SecMMEncryptCheckResUpdate reqToBuf packHybridEcdh using protobuf ok, jType:%d, cert:%d len:%d, flag:%d ret:%s", Integer.valueOf(i2), Integer.valueOf(f.Kze), Integer.valueOf(pByteArray2.value.length), Integer.valueOf(i3), Boolean.valueOf(packHybridEcdh));
                        AppMethodBeat.o(152467);
                        return packHybridEcdh;
                    }
                    AppMethodBeat.o(152467);
                    return false;
                }
            });
            byte[] byteArray = this.KzQ.toByteArray();
            AppMethodBeat.o(152469);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return f.KyZ ? 784 : 722;
        }
    }

    public static class b extends l.e implements l.c {
        public final zi KzT = new zi();

        public b() {
            AppMethodBeat.i(152470);
            AppMethodBeat.o(152470);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(152471);
            this.KzT.parseFrom(bArr);
            int i2 = this.KzT.BaseResponse.Ret;
            AppMethodBeat.o(152471);
            return i2;
        }
    }
}
