package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.protocal.protobuf.id;
import com.tencent.mm.protocal.protobuf.ie;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ck;

public final class y extends o {
    private final a KAk = new a();
    private final b KAl = new b();
    private final int funcId;
    private final String uri;

    public y(int i2, String str, int i3, SKBuiltinBuffer_t sKBuiltinBuffer_t, byte[] bArr) {
        AppMethodBeat.i(134242);
        this.funcId = i2;
        this.uri = str;
        this.KAk.funcId = i2;
        this.KAk.KAn = bArr;
        this.KAk.KAm.xMB = i3;
        this.KAk.KAm.KMo = sKBuiltinBuffer_t;
        AppMethodBeat.o(134242);
    }

    @Override // com.tencent.mm.ak.o
    public final l.d getReqObjImp() {
        return this.KAk;
    }

    @Override // com.tencent.mm.network.s
    public final int getType() {
        return this.funcId;
    }

    @Override // com.tencent.mm.network.s
    public final String getUri() {
        return this.uri;
    }

    @Override // com.tencent.mm.network.s
    public final l.e getRespObj() {
        return this.KAl;
    }

    public static class a extends l.d implements l.b {
        public id KAm = new id();
        byte[] KAn;
        int funcId;

        public a() {
            AppMethodBeat.i(134238);
            AppMethodBeat.o(134238);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            int i2 = -1;
            AppMethodBeat.i(134239);
            this.KAm.setBaseRequest(l.a(this));
            this.KAm.yiZ = q.aoz();
            this.KAm.KLL = d.INSTANCE.TK(0);
            this.KAm.keb = Util.getSourceeMd5(MMApplicationContext.getContext());
            this.KAm.oTI = d.DEVICE_NAME;
            this.KAm.KLO = ck.getFingerprint();
            this.KAm.rBI = LocaleUtil.getApplicationLanguage();
            this.KAm.rBH = Util.getTimeZoneOffset();
            this.KAm.KCx = ChannelUtil.channelId;
            try {
                byte[] exJ = d.INSTANCE.exJ();
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(exJ != null ? exJ.length : -1);
                Log.d("MicroMsg.MMReqRespAxAuth", "[debug] ccd set on axauth, len: %s", objArr);
                ewf ewf = new ewf();
                ewf.NtQ = new SKBuiltinBuffer_t().setBuffer(exJ);
                ewf.NtU = new SKBuiltinBuffer_t().setBuffer(d.INSTANCE.exM());
                Object[] objArr2 = new Object[1];
                if (ewf.NtU != null) {
                    i2 = ewf.NtU.getILen();
                }
                objArr2[0] = Integer.valueOf(i2);
                Log.d("MicroMsg.MMReqRespAxAuth", "[debug] devtok on axauth, len: %s", objArr2);
                this.KAm.KLQ = new SKBuiltinBuffer_t().setBuffer(ewf.toByteArray());
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.MMReqRespAxAuth", th, "cc throws exception.", new Object[0]);
            }
            long CreateAxEcdhCryptoEngine = UtilsJni.CreateAxEcdhCryptoEngine(this.KAm.xMB, this.KAn, this.KAm.KMo.getBufferToBytes());
            setEcdhEngine(CreateAxEcdhCryptoEngine);
            byte[] AxEcdhEncrypt = UtilsJni.AxEcdhEncrypt(CreateAxEcdhCryptoEngine, this.KAm.toByteArray());
            AppMethodBeat.o(134239);
            return AxEcdhEncrypt;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return this.funcId;
        }

        @Override // com.tencent.mm.protocal.l.b, com.tencent.mm.protocal.l.d
        public final boolean isAxAuth() {
            return true;
        }
    }

    @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
    public final int getOptions() {
        return 1;
    }

    public static class b extends l.e implements l.c {
        public ie KAo = new ie();

        public b() {
            AppMethodBeat.i(134240);
            AppMethodBeat.o(134240);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(134241);
            this.KAo = (ie) new ie().parseFrom(bArr);
            l.a(this, this.KAo.getBaseResponse());
            int i2 = this.KAo.getBaseResponse().Ret;
            AppMethodBeat.o(134241);
            return i2;
        }
    }
}
