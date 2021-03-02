package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.jr;
import com.tencent.mm.protocal.protobuf.wl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class l {

    public interface a {
        boolean a(PByteArray pByteArray, int i2, byte[] bArr, byte[] bArr2, int i3);
    }

    public interface b {
        long getECDHEngine();

        int getFuncId();

        int getRouteInfo();

        boolean isAxAuth();

        boolean isRawData();

        byte[] toProtoBuf();
    }

    public interface c {
        int fromProtoBuf(byte[] bArr);

        boolean isRawData();
    }

    public static jr a(d dVar) {
        AppMethodBeat.i(133100);
        jr jrVar = new jr();
        jrVar.KOj = dVar.getClientVersion();
        jrVar.Scene = dVar.getSceneStatus();
        jrVar.rBx = dVar.getUin();
        jrVar.KOi = com.tencent.mm.bw.b.cD(dVar.getDeviceID().getBytes());
        if (jrVar.KOi.zy.length >= 16) {
            jrVar.KOi = jrVar.KOi.aiU(16);
        }
        jrVar.KOk = com.tencent.mm.bw.b.cD(dVar.getDeviceType().getBytes());
        if (jrVar.KOk.zy.length >= 132) {
            jrVar.KOk = jrVar.KOk.aiU(132);
        }
        jrVar.KOh = com.tencent.mm.bw.b.cD(dVar.getSessionKey());
        if (jrVar.KOh.zy.length >= 36) {
            jrVar.KOh = jrVar.KOh.aiU(36);
        }
        AppMethodBeat.o(133100);
        return jrVar;
    }

    public static void a(e eVar, BaseResponse baseResponse) {
        AppMethodBeat.i(133101);
        if (baseResponse.ErrMsg != null) {
            eVar.setErrMsg(baseResponse.ErrMsg.MTo);
            AppMethodBeat.o(133101);
            return;
        }
        eVar.setErrMsg("");
        Log.e("MicroMsg.MMBase", "ErrMsg is Null!!!!!!");
        AppMethodBeat.o(133101);
    }

    public static class d {
        private static final String TAG = "MicroMsg.MMBase.Req";
        private boolean bShortSupport = true;
        private long bufferSize = 0;
        private b.a cgiVerifyKeys;
        private long ecdhEngine = 0;
        private int iClientVersion = 0;
        private int iSceneStatus = 0;
        private int iUin = 0;
        private a mReqPackControl;
        private byte[] passKey;
        private int routeInfo = 0;
        private ac rsaInfo = new ac("", "", 0);
        private String sDeviceID = "";
        private String sDeviceType = "";
        private byte[] sessionKey = new byte[0];
        private boolean useAxSession = false;
        private boolean useECDH = false;

        public d() {
            AppMethodBeat.i(133097);
            AppMethodBeat.o(133097);
        }

        public void setSessionKey(byte[] bArr) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            this.sessionKey = bArr;
        }

        public byte[] getSessionKey() {
            return this.sessionKey;
        }

        public void setUin(int i2) {
            this.iUin = i2;
        }

        public int getUin() {
            return this.iUin;
        }

        public void setClientVersion(int i2) {
            this.iClientVersion = i2;
        }

        public int getClientVersion() {
            return this.iClientVersion;
        }

        public void setDeviceType(String str) {
            this.sDeviceType = str;
        }

        public String getDeviceType() {
            return this.sDeviceType;
        }

        public boolean packToNetMsg(PByteArray pByteArray) {
            return false;
        }

        public String getDeviceID() {
            return this.sDeviceID;
        }

        public void setDeviceID(String str) {
            this.sDeviceID = str;
        }

        public void setSceneStatus(int i2) {
            this.iSceneStatus = i2;
        }

        public int getSceneStatus() {
            return this.iSceneStatus;
        }

        public int getCmdId() {
            return 0;
        }

        public boolean isRawData() {
            return false;
        }

        public boolean getShortSupport() {
            return this.bShortSupport;
        }

        public void setShortSupport(boolean z) {
            this.bShortSupport = z;
        }

        public void setRsaInfo(ac acVar) {
            AppMethodBeat.i(133098);
            this.rsaInfo = acVar;
            Log.i(TAG, "summerauths setRsaInfo cgi[%s], USE_ECDH[%b], stack[%s]", Integer.valueOf(getCmdId()), Boolean.valueOf(f.KyZ), Util.getStack());
            if (f.KyZ) {
                setUseECDH(true);
            }
            AppMethodBeat.o(133098);
        }

        public ac getRsaInfo() {
            return this.rsaInfo;
        }

        public void setUseECDH(boolean z) {
            AppMethodBeat.i(133099);
            this.useECDH = z;
            Log.i(TAG, "summerauths setUseECDH[%s]  cgi[%s], stack[%s]", Boolean.valueOf(z), Integer.valueOf(getCmdId()), Util.getStack());
            AppMethodBeat.o(133099);
        }

        public boolean useECDH() {
            return this.useECDH;
        }

        public boolean isAxAuth() {
            return false;
        }

        public void setBufferSize(long j2) {
            this.bufferSize = j2;
        }

        public long getBufferSize() {
            return this.bufferSize;
        }

        public void setPassKey(byte[] bArr) {
            this.passKey = bArr;
        }

        public byte[] getPassKey() {
            return this.passKey;
        }

        public a getReqPackControl() {
            return this.mReqPackControl;
        }

        public void setReqPackControl(a aVar) {
            this.mReqPackControl = aVar;
        }

        public void setRouteInfo(int i2) {
            this.routeInfo = i2;
        }

        public int getRouteInfo() {
            return this.routeInfo;
        }

        public void setEcdhEngine(long j2) {
            this.ecdhEngine = j2;
        }

        public long getECDHEngine() {
            return this.ecdhEngine;
        }

        public void setUseAxsession(boolean z) {
            this.useAxSession = z;
        }

        public boolean useAxSession() {
            return this.useAxSession;
        }

        public void setCGiVerifyKey(b.a aVar) {
            this.cgiVerifyKeys = aVar;
        }

        public String getCgiVerifyPrivateKey() {
            if (this.cgiVerifyKeys != null) {
                return this.cgiVerifyKeys.jDC;
            }
            return "";
        }

        public String getCgiVerifyPublicKey() {
            if (this.cgiVerifyKeys != null) {
                return this.cgiVerifyKeys.jDD;
            }
            return "";
        }
    }

    public static class e {
        private long bufferSize = 0;
        private int iHeadExtFlags = 255;
        private int iRetCode = -99;
        private wl profile;
        private String sErrMsg = "";

        public void setRetCode(int i2) {
            this.iRetCode = i2;
        }

        public int getRetCode() {
            return this.iRetCode;
        }

        public void setHeadExtFlags(int i2) {
            this.iHeadExtFlags = i2;
        }

        public int getHeadExtFlags() {
            return this.iHeadExtFlags;
        }

        public String getErrMsg() {
            return this.sErrMsg;
        }

        public void setErrMsg(String str) {
            this.sErrMsg = str;
        }

        public int getCmdId() {
            return 0;
        }

        public boolean isRawData() {
            return false;
        }

        public void setBufferSize(long j2) {
            this.bufferSize = j2;
        }

        public long getBufferSize() {
            return this.bufferSize;
        }

        public byte[] getAuthResponse() {
            return null;
        }

        public void setProfile(byte[] bArr) {
            AppMethodBeat.i(197128);
            this.profile = new wl();
            try {
                this.profile.parseFrom(bArr);
                AppMethodBeat.o(197128);
            } catch (Exception e2) {
                Log.e("setProfile", e2.getLocalizedMessage());
                AppMethodBeat.o(197128);
            }
        }

        public wl getProfile() {
            return this.profile;
        }
    }
}
