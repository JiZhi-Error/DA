package com.tencent.mm.protocal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.network.b;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.protocal.protobuf.cme;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.protocal.protobuf.dfx;
import com.tencent.mm.protocal.protobuf.ell;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.protocal.protobuf.hx;
import com.tencent.mm.protocal.protobuf.hz;
import com.tencent.mm.protocal.protobuf.ia;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ck;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class j {

    public interface e {

        public static class a {
            public static e Kzx;
        }

        void a(h hVar, i iVar, int i2, int i3, String str);

        int aVJ();

        s dm(int i2, int i3);
    }

    public static abstract class h extends l.d implements l.b {
        public byte[] Kzv;

        public abstract String getUri();

        public final void cG(byte[] bArr) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            this.Kzv = bArr;
        }
    }

    public static class a extends h implements l.b {
        public hz Kzu = new hz();
        public String username;

        public a() {
            AppMethodBeat.i(133087);
            AppMethodBeat.o(133087);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            int ake;
            int i2;
            int i3 = -1;
            AppMethodBeat.i(133088);
            com.tencent.mm.kernel.a.FL("");
            int sceneStatus = getSceneStatus();
            if (sceneStatus == 12) {
                ake = 1;
            } else {
                com.tencent.mm.kernel.g.aAi();
                ake = com.tencent.mm.kernel.g.aAh().hqB.ake(46);
            }
            Log.d("MicroMsg.AutoReq", "summerstatus[%d] clientUpgrade[%d]", Integer.valueOf(sceneStatus), Integer.valueOf(ake));
            setRsaInfo(ac.gtR());
            if (10002 == ac.jOC && ac.jOD > 0) {
                ac.jOD = 0;
                ac.aq("", "", 0);
            }
            hx hxVar = this.Kzu.KLW;
            hxVar.setBaseRequest(l.a(this));
            Log.i("MicroMsg.AutoReq", "summerauth autoauth toProtoBuf uin[%d]", Integer.valueOf(getUin()));
            hxVar.yiZ = q.dr(true);
            hxVar.KLL = com.tencent.mm.plugin.normsg.a.d.INSTANCE.TK(ake);
            hxVar.KLM = 0;
            hxVar.KLN = com.tencent.mm.kernel.a.azt();
            hxVar.keb = Util.getSourceeMd5(MMApplicationContext.getContext());
            hxVar.oTI = d.DEVICE_NAME;
            hxVar.KLO = ck.getFingerprint();
            hxVar.rBI = LocaleUtil.getApplicationLanguage();
            hxVar.rBH = Util.getTimeZoneOffset();
            hxVar.KCx = ChannelUtil.channelId;
            hxVar.KFu = MMApplicationContext.getApplicationId();
            com.tencent.mm.kernel.g.aAi();
            String str = (String) com.tencent.mm.kernel.g.aAh().hqB.get(18);
            Log.d("MicroMsg.AutoReq", "summerecdh ksid:%s, flag:%d", str, Integer.valueOf(hxVar.KLK.KOa));
            hxVar.KLK.KNY.KQA = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString(str));
            try {
                byte[] exJ = com.tencent.mm.plugin.normsg.a.d.INSTANCE.exJ();
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(exJ != null ? exJ.length : -1);
                Log.d("MicroMsg.AutoReq", "[tomys] ccd set on auto auth, len: %s", objArr);
                ewf ewf = new ewf();
                ewf.NtQ = new SKBuiltinBuffer_t().setBuffer(exJ);
                ewf.NtU = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.exM());
                Object[] objArr2 = new Object[1];
                if (ewf.NtU != null) {
                    i2 = ewf.NtU.getILen();
                } else {
                    i2 = -1;
                }
                objArr2[0] = Integer.valueOf(i2);
                Log.d("MicroMsg.AutoReq", "[debug] devtok on auto auth, len: %s", objArr2);
                hxVar.KLQ = new SKBuiltinBuffer_t().setBuffer(ewf.toByteArray());
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.AutoReq", th, "cc throws exception.", new Object[0]);
            }
            hxVar.KLS = new dfx();
            String bjr = com.tencent.mm.network.b.bjq().bjr();
            if (!TextUtils.isEmpty(bjr)) {
                hxVar.KLS.LrO = com.tencent.mm.network.b.bjq().jDB.LrO;
                hxVar.KLS.KLU = new SKBuiltinBuffer_t().setBuffer(bjr.getBytes(StandardCharsets.ISO_8859_1));
                Log.i("MicroMsg.AutoReq", "autoauth add public key , length " + bjr.length());
            } else {
                hxVar.KLS.LrO = 0;
                hxVar.KLS.KLU = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                Log.e("MicroMsg.AutoReq", "get sign key failed");
            }
            b.a aVar = new b.a();
            aVar.jDD = com.tencent.mm.network.b.bjq().bjr();
            aVar.jDC = com.tencent.mm.network.b.bjq().jDC;
            setCGiVerifyKey(aVar);
            ia iaVar = this.Kzu.KLV;
            aif aif = new aif();
            aif.LrO = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(aif.LrO, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            cG(bArr2);
            Object[] objArr3 = new Object[6];
            objArr3[0] = Integer.valueOf(aif.LrO);
            objArr3[1] = Integer.valueOf(generateECKey);
            objArr3[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i3 = bArr2.length;
            }
            objArr3[3] = Integer.valueOf(i3);
            objArr3[4] = Util.dumpHex(bArr);
            objArr3[5] = Util.dumpHex(bArr2);
            Log.d("MicroMsg.AutoReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", objArr3);
            aif.KLU = new SKBuiltinBuffer_t().setBuffer(bArr);
            iaVar.KLY = aif;
            Log.i("MicroMsg.AutoReq", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s AndroidPackageName:%s chan[%d,%d,%d]", hxVar.yiZ, hxVar.KLL, hxVar.KLN, hxVar.keb, hxVar.oTI, hxVar.KLO, hxVar.rBI, hxVar.rBH, hxVar.KFu, Integer.valueOf(hxVar.KCx), Integer.valueOf(ChannelUtil.channelId), Integer.valueOf(ChannelUtil.historyChannelId));
            try {
                byte[] byteArray = this.Kzu.toByteArray();
                AppMethodBeat.o(133088);
                return byteArray;
            } catch (IOException e2) {
                Log.e("MicroMsg.AutoReq", "summerauth toProtoBuf :%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(133088);
                return null;
            }
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return f.KyZ ? 763 : 702;
        }

        @Override // com.tencent.mm.protocal.j.h
        public final String getUri() {
            return f.KyZ ? "/cgi-bin/micromsg-bin/secautoauth" : "/cgi-bin/micromsg-bin/autoauth";
        }
    }

    public static class f extends h implements l.b {
        public cmf Kzy = new cmf();
        public boolean Kzz = false;

        public f() {
            AppMethodBeat.i(133094);
            AppMethodBeat.o(133094);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            int ake;
            int i2;
            int i3;
            int i4;
            int i5 = -1;
            AppMethodBeat.i(133095);
            com.tencent.mm.kernel.a.FL("");
            int sceneStatus = getSceneStatus();
            if (sceneStatus == 16) {
                ake = 1;
            } else if (this.Kzz) {
                ake = 3;
            } else {
                com.tencent.mm.kernel.g.aAi();
                ake = com.tencent.mm.kernel.g.aAh().hqB.ake(46);
            }
            Log.d("MicroMsg.ManualReq", "summerstatus[%d] clientUpgrade[%d]", Integer.valueOf(sceneStatus), Integer.valueOf(ake));
            if (10002 == ac.jOC && ac.jOD > 0) {
                ac.jOD = 0;
                ac.aq("", "", 0);
            }
            setRsaInfo(ac.gtR());
            cme cme = this.Kzy.MrB;
            cme.setBaseRequest(l.a(this));
            cme.yiZ = q.dr(true);
            cme.KLL = com.tencent.mm.plugin.normsg.a.d.INSTANCE.TK(ake);
            cme.KLM = 0;
            cme.KLN = com.tencent.mm.kernel.a.azt();
            cme.keb = Util.getSourceeMd5(MMApplicationContext.getContext());
            cme.oTI = d.DEVICE_NAME;
            cme.KLO = ck.getFingerprint();
            cme.rBI = LocaleUtil.getApplicationLanguage();
            cme.rBH = Util.getTimeZoneOffset();
            cme.KCx = ChannelUtil.channelId;
            if (10012 == ac.jOC && ac.jOD > 0) {
                cme.KCx = ac.jOD;
            }
            cme.hie = d.KyI;
            cme.hid = d.KyJ;
            cme.Mrw = d.KyK;
            cme.Lsj = q.getSimCountryIso();
            cme.KFu = MMApplicationContext.getApplicationId();
            com.tencent.mm.kernel.g.aAi();
            String str = (String) com.tencent.mm.kernel.g.aAh().hqB.get(18);
            Log.d("MicroMsg.ManualReq", "summerauth ksid:%s authreq flag:%d", str, Integer.valueOf(cme.KLK.KOa));
            cme.KLK.KNY.KQA = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString(str));
            try {
                byte[] exJ = com.tencent.mm.plugin.normsg.a.d.INSTANCE.exJ();
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(exJ != null ? exJ.length : -1);
                Log.d("MicroMsg.ManualReq", "[debug] ccd set on manual auth, len: %s", objArr);
                ewf ewf = new ewf();
                if (2 == cme.Mrz || 1 == cme.Mrz || cme.Mrz == 0) {
                    if (com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIO("ie_login_id")) {
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIN("ie_login_id");
                    }
                    ewf.NtO = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIP("ie_login_id"));
                    Object[] objArr2 = new Object[1];
                    if (ewf.NtO != null) {
                        i3 = ewf.NtO.getILen();
                    } else {
                        i3 = -1;
                    }
                    objArr2[0] = Integer.valueOf(i3);
                    Log.d("MicroMsg.ManualReq", "[debug] wcstf set on manual auth, len: %s", objArr2);
                    ewf.NtP = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIS("ce_login_id"));
                    Object[] objArr3 = new Object[1];
                    if (ewf.NtP != null) {
                        i4 = ewf.NtP.getILen();
                    } else {
                        i4 = -1;
                    }
                    objArr3[0] = Integer.valueOf(i4);
                    Log.d("MicroMsg.ManualReq", "[debug] wcste set on manual auth, len: %s", objArr3);
                    String aIT = com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIT("ce_login_id");
                    if (aIT != null) {
                        ewf.NtV = new SKBuiltinBuffer_t().setBuffer(aIT.getBytes());
                    }
                }
                ewf.NtU = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.exM());
                Object[] objArr4 = new Object[1];
                if (ewf.NtU != null) {
                    i2 = ewf.NtU.getILen();
                } else {
                    i2 = -1;
                }
                objArr4[0] = Integer.valueOf(i2);
                Log.d("MicroMsg.ManualReq", "[debug] devtok on manual auth, len: %s", objArr4);
                ewf.NtQ = new SKBuiltinBuffer_t().setBuffer(exJ);
                cme.KLQ = new SKBuiltinBuffer_t().setBuffer(ewf.toByteArray());
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.ManualReq", th, "cc throws exception.", new Object[0]);
            }
            cmg cmg = this.Kzy.MrA;
            cmg.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
            aif aif = new aif();
            aif.LrO = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(aif.LrO, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            cG(bArr2);
            cme.KLS = new dfx();
            String bjr = com.tencent.mm.network.b.bjq().bjr();
            if (!TextUtils.isEmpty(bjr)) {
                cme.KLS.LrO = com.tencent.mm.network.b.bjq().jDB.LrO;
                cme.KLS.KLU = new SKBuiltinBuffer_t().setBuffer(bjr.getBytes(StandardCharsets.ISO_8859_1));
                Log.i("MicroMsg.ManualReq", "manualauth add public key , length " + bjr.length());
            } else {
                cme.KLS.LrO = 0;
                cme.KLS.KLU = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                Log.e("MicroMsg.ManualReq", "get sign key failed");
            }
            b.a aVar = new b.a();
            aVar.jDD = com.tencent.mm.network.b.bjq().bjr();
            aVar.jDC = com.tencent.mm.network.b.bjq().jDC;
            setCGiVerifyKey(aVar);
            Object[] objArr5 = new Object[6];
            objArr5[0] = Integer.valueOf(aif.LrO);
            objArr5[1] = Integer.valueOf(generateECKey);
            objArr5[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i5 = bArr2.length;
            }
            objArr5[3] = Integer.valueOf(i5);
            objArr5[4] = Util.dumpHex(bArr);
            objArr5[5] = Util.dumpHex(bArr2);
            Log.d("MicroMsg.ManualReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", objArr5);
            aif.KLU = new SKBuiltinBuffer_t().setBuffer(bArr);
            cmg.KLY = aif;
            Log.i("MicroMsg.ManualReq", "summerauth manual IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d] DeviceBrand:%s DeviceModel:%s OSType:%s RealCountry:%s AndroidPackageName:%s", cme.yiZ, cme.KLL, cme.KLN, cme.keb, cme.oTI, cme.KLO, cme.rBI, cme.rBH, Integer.valueOf(cme.KCx), Integer.valueOf(ChannelUtil.channelId), Integer.valueOf(ChannelUtil.historyChannelId), cme.hie, cme.hid, cme.Mrw, cme.Lsj, cme.KFu);
            try {
                byte[] byteArray = this.Kzy.toByteArray();
                AppMethodBeat.o(133095);
                return byteArray;
            } catch (IOException e2) {
                Log.e("MicroMsg.ManualReq", "summerauth toProtoBuf :%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(133095);
                return null;
            }
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return f.KyZ ? 252 : 701;
        }

        @Override // com.tencent.mm.protocal.j.h
        public final String getUri() {
            return f.KyZ ? "/cgi-bin/micromsg-bin/secmanualauth" : "/cgi-bin/micromsg-bin/manualauth";
        }
    }

    public static abstract class i extends l.e implements l.c {
        public byte[] KzA;
        private byte[] KzB;
        public ell Kzw = new ell();
        public String dMW;
        public int hku = 0;
        private byte[] jDp;
        private byte[] jDq;

        public final void b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            this.KzB = bArr;
            this.jDp = bArr2;
            this.jDq = bArr3;
            Log.i("MicroMsg.MMAuth", "summerauths setSession [%s] [%s], [%s]", Util.secPrint(Util.dumpHex(this.KzB)), Util.secPrint(Util.dumpHex(this.jDp)), Util.secPrint(Util.dumpHex(this.jDq)));
        }

        public final byte[] aiZ(int i2) {
            byte[] bArr = new byte[0];
            switch (i2) {
                case 1:
                    bArr = this.KzB;
                    break;
                case 2:
                    bArr = this.jDp;
                    break;
                case 3:
                    bArr = this.jDq;
                    break;
            }
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            Log.i("MicroMsg.MMAuth", "summerauths getSession seesionKeyType[%s] [%s]", objArr);
            return bArr;
        }

        @Override // com.tencent.mm.protocal.l.e
        public byte[] getAuthResponse() {
            try {
                return this.Kzw.toByteArray();
            } catch (Exception e2) {
                return null;
            }
        }
    }

    public static class b extends i implements l.c {
        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(133089);
            try {
                this.Kzw = (ell) this.Kzw.parseFrom(bArr);
                l.a(this, this.Kzw.getBaseResponse());
                this.hku = 0;
                if (this.Kzw.getBaseResponse().Ret == 0 && (this.Kzw.Nky == null || this.Kzw.Nky.rBx == 0 || Util.isNullOrNil(z.a(this.Kzw.Nky.KKY)))) {
                    Log.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
                    this.Kzw.getBaseResponse().Ret = -1;
                }
                String errMsg = getErrMsg();
                Log.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", errMsg);
                com.tencent.mm.kernel.a.FL(errMsg);
                int i2 = this.Kzw.getBaseResponse().Ret;
                AppMethodBeat.o(133089);
                return i2;
            } catch (IOException e2) {
                Log.e("MicroMsg.MMAuth", "toProtoBuf :%s", Util.stackTraceToString(e2));
                this.Kzw.getBaseResponse().Ret = -1;
                AppMethodBeat.o(133089);
                return -1;
            }
        }
    }

    public static class g extends i implements l.c {
        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(133096);
            try {
                this.Kzw = (ell) this.Kzw.parseFrom(bArr);
                l.a(this, this.Kzw.getBaseResponse());
                this.hku = 0;
                if (this.Kzw.getBaseResponse().Ret == 0 && (this.Kzw.Nky == null || this.Kzw.Nky.rBx == 0 || Util.isNullOrNil(z.a(this.Kzw.Nky.KKY)))) {
                    Log.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
                    this.Kzw.getBaseResponse().Ret = -1;
                }
                String errMsg = getErrMsg();
                Log.i("MicroMsg.MMAuth", "summerauthkick manual errmsg[%s]", errMsg);
                com.tencent.mm.kernel.a.FL(errMsg);
                int i2 = this.Kzw.getBaseResponse().Ret;
                AppMethodBeat.o(133096);
                return i2;
            } catch (IOException e2) {
                Log.e("MicroMsg.MMAuth", "toProtoBuf :%s", Util.stackTraceToString(e2));
                this.Kzw.getBaseResponse().Ret = -1;
                AppMethodBeat.o(133096);
                return -1;
            }
        }
    }

    public static class c extends l.d implements l.b {
        public hz Kzu = new hz();
        private byte[] Kzv;
        public String username;

        public c() {
            AppMethodBeat.i(133090);
            AppMethodBeat.o(133090);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            int ake;
            int i2 = -1;
            AppMethodBeat.i(133091);
            com.tencent.mm.kernel.a.FL("");
            int sceneStatus = getSceneStatus();
            if (sceneStatus == 12) {
                ake = 1;
            } else {
                com.tencent.mm.kernel.g.aAi();
                ake = com.tencent.mm.kernel.g.aAh().hqB.ake(46);
            }
            Log.d("MicroMsg.MMAuth", "summerstatus[%d] clientUpgrade[%d]", Integer.valueOf(sceneStatus), Integer.valueOf(ake));
            setRsaInfo(ac.gtR());
            if (10002 == ac.jOC && ac.jOD > 0) {
                ac.jOD = 0;
                ac.aq("", "", 0);
            }
            hx hxVar = this.Kzu.KLW;
            hxVar.setBaseRequest(l.a(this));
            Log.i("MicroMsg.MMAuth", "summerauth autoauth toProtoBuf uin[%d]", Integer.valueOf(getUin()));
            hxVar.yiZ = q.aoz();
            hxVar.KLL = com.tencent.mm.plugin.normsg.a.d.INSTANCE.TK(ake);
            hxVar.KLM = 0;
            hxVar.KLN = com.tencent.mm.kernel.a.azt();
            hxVar.keb = Util.getSourceeMd5(MMApplicationContext.getContext());
            hxVar.oTI = d.DEVICE_NAME;
            hxVar.KLO = ck.getFingerprint();
            hxVar.rBI = LocaleUtil.getApplicationLanguage();
            hxVar.rBH = Util.getTimeZoneOffset();
            hxVar.KCx = ChannelUtil.channelId;
            hxVar.KFu = MMApplicationContext.getApplicationId();
            com.tencent.mm.kernel.g.aAi();
            String str = (String) com.tencent.mm.kernel.g.aAh().hqB.get(18);
            Log.d("MicroMsg.MMAuth", "summerecdh ksid:%s, flag:%d", str, Integer.valueOf(hxVar.KLK.KOa));
            hxVar.KLK.KNY.KQA = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString(str));
            hxVar.KLS = new dfx();
            String bjr = com.tencent.mm.network.b.bjq().bjr();
            if (!TextUtils.isEmpty(bjr)) {
                hxVar.KLS.LrO = com.tencent.mm.network.b.bjq().jDB.LrO;
                hxVar.KLS.KLU = new SKBuiltinBuffer_t().setBuffer(bjr.getBytes(StandardCharsets.ISO_8859_1));
                Log.i("MicroMsg.MMAuth", "disaster auth add public key , length " + bjr.length());
            } else {
                hxVar.KLS.LrO = 0;
                hxVar.KLS.KLU = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                Log.e("MicroMsg.MMAuth", "get sign key failed");
            }
            b.a aVar = new b.a();
            aVar.jDD = com.tencent.mm.network.b.bjq().bjr();
            aVar.jDC = com.tencent.mm.network.b.bjq().jDC;
            setCGiVerifyKey(aVar);
            ia iaVar = this.Kzu.KLV;
            aif aif = new aif();
            aif.LrO = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(aif.LrO, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            this.Kzv = bArr2;
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(aif.LrO);
            objArr[1] = Integer.valueOf(generateECKey);
            objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i2 = bArr2.length;
            }
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = Util.dumpHex(bArr);
            objArr[5] = Util.dumpHex(bArr2);
            Log.d("MicroMsg.MMAuth", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", objArr);
            aif.KLU = new SKBuiltinBuffer_t().setBuffer(bArr);
            iaVar.KLY = aif;
            Log.i("MicroMsg.MMAuth", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s AndroidPackageName:%s chan[%d,%d,%d]", hxVar.yiZ, hxVar.KLL, hxVar.KLN, hxVar.keb, hxVar.oTI, hxVar.KLO, hxVar.rBI, hxVar.rBH, hxVar.KFu, Integer.valueOf(hxVar.KCx), Integer.valueOf(ChannelUtil.channelId), Integer.valueOf(ChannelUtil.historyChannelId));
            try {
                byte[] byteArray = this.Kzu.toByteArray();
                AppMethodBeat.o(133091);
                return byteArray;
            } catch (IOException e2) {
                Log.e("MicroMsg.MMAuth", "summerauth toProtoBuf :%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(133091);
                return null;
            }
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return 3941;
        }
    }

    public static class d extends l.e implements l.c {
        public ell Kzw = new ell();

        public d() {
            AppMethodBeat.i(133092);
            AppMethodBeat.o(133092);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(133093);
            try {
                this.Kzw = (ell) this.Kzw.parseFrom(bArr);
                l.a(this, this.Kzw.getBaseResponse());
                if (this.Kzw.getBaseResponse().Ret == 0 && (this.Kzw.Nky == null || this.Kzw.Nky.rBx == 0 || Util.isNullOrNil(z.a(this.Kzw.Nky.KKY)))) {
                    Log.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
                    this.Kzw.getBaseResponse().Ret = -1;
                }
                String errMsg = getErrMsg();
                Log.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", errMsg);
                com.tencent.mm.kernel.a.FL(errMsg);
                int i2 = this.Kzw.getBaseResponse().Ret;
                AppMethodBeat.o(133093);
                return i2;
            } catch (IOException e2) {
                Log.e("MicroMsg.MMAuth", "toProtoBuf :%s", Util.stackTraceToString(e2));
                this.Kzw.getBaseResponse().Ret = -1;
                AppMethodBeat.o(133093);
                return -1;
            }
        }
    }
}
