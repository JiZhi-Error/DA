package com.tencent.mm.ak;

import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.b;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.util;

public final class ac {
    public static a iNB;
    private long iNA = 0;
    private oicq.wlogin_sdk.request.b iNz = null;

    public interface a {
        boolean aZy();
    }

    class b extends oicq.wlogin_sdk.tools.b {
        public b() {
        }

        @Override // oicq.wlogin_sdk.tools.b
        public final void J(int i2, String str) {
            AppMethodBeat.i(132502);
            OnLog(i2, "", str);
            AppMethodBeat.o(132502);
        }

        @Override // oicq.wlogin_sdk.tools.b
        public final void OnLog(int i2, String str, String str2) {
            AppMethodBeat.i(132503);
            if (i2 == 1) {
                Log.i("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
                AppMethodBeat.o(132503);
            } else if (i2 == 2) {
                Log.d("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
                AppMethodBeat.o(132503);
            } else {
                if (i2 == 0) {
                    Log.w("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
                }
                AppMethodBeat.o(132503);
            }
        }
    }

    public ac() {
        AppMethodBeat.i(132504);
        try {
            long nowMilliSecond = Util.nowMilliSecond();
            byte[] lZ = util.lZ(MMApplicationContext.getContext());
            if (lZ == null || lZ.length == 0) {
                util.b(MMApplicationContext.getContext(), q.aoG().getBytes());
            }
            this.iNz = new oicq.wlogin_sdk.request.b(MMApplicationContext.getContext(), d.KyO);
            util.gQV = 1;
            util.Ueq = new b();
            Log.d("MicroMsg.WtloginMgr", "dkstart wtlogin init :%d", Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)));
            AppMethodBeat.o(132504);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WtloginMgr", e2, "Failed initializing WtloginMgr.", new Object[0]);
            AppMethodBeat.o(132504);
        }
    }

    public final byte[] a(long j2, String str, boolean z) {
        boolean z2;
        AppMethodBeat.i(132505);
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(com.tencent.mm.platformtools.ac.jOC == 10006);
        objArr[1] = Integer.valueOf(com.tencent.mm.platformtools.ac.jOD);
        Log.d("MicroMsg.WtloginMgr", "dkwt isTestWtLogin:%b val:%d", objArr);
        if (com.tencent.mm.platformtools.ac.jOC == 10006) {
            if (com.tencent.mm.platformtools.ac.jOD == 1) {
                com.tencent.mm.platformtools.ac.jOD = 0;
                byte[] bArr = new byte[0];
                AppMethodBeat.o(132505);
                return bArr;
            } else if (com.tencent.mm.platformtools.ac.jOD == 2) {
                byte[] bArr2 = new byte[0];
                AppMethodBeat.o(132505);
                return bArr2;
            }
        }
        if (!z) {
            try {
                if (g.aAc() && iNB != null && iNB.aZy() && !g.aAh().azQ().getBoolean(ar.a.USERINFO_MANUAL_AUTH_AS_QQ_ACCOUNT_BOOLEAN_SYNC, true)) {
                    byte[] bArr3 = new byte[0];
                    AppMethodBeat.o(132505);
                    return bArr3;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBuf e:%s", e2.getMessage());
                Log.e("MicroMsg.WtloginMgr", "exception:%s", Util.stackTraceToString(e2));
                byte[] bArr4 = new byte[0];
                AppMethodBeat.o(132505);
                return bArr4;
            }
        }
        this.iNA = j2;
        byte[] a2 = z ? null : this.iNz.a(j2, b.a.USER_WITH_A1, "");
        Object[] objArr2 = new Object[4];
        objArr2[0] = 8256;
        objArr2[1] = Long.valueOf(j2);
        objArr2[2] = Boolean.valueOf(z);
        if (!Util.isNullOrNil(a2)) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr2[3] = Boolean.valueOf(z2);
        Log.d("MicroMsg.WtloginMgr", "dkwt getReqLoginBuf sig:%d uin:%d manualauth:%b  byA1Buf:%b ", objArr2);
        if (!Util.isNullOrNil(a2)) {
            AppMethodBeat.o(132505);
            return a2;
        }
        byte[] a3 = this.iNz.a(j2, b.a.USER_WITH_MD5, new String(Util.decodeHexString(str), KindaConfigCacheStg.SAVE_CHARSET));
        AppMethodBeat.o(132505);
        return a3;
    }

    public final boolean a(long j2, byte[] bArr) {
        int i2;
        AppMethodBeat.i(132506);
        if (j2 != this.iNA) {
            Log.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.iNA), Long.valueOf(j2));
            AppMethodBeat.o(132506);
            return false;
        } else if (Util.isNullOrNil(bArr)) {
            Log.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf respBuf is null.");
            AppMethodBeat.o(132506);
            return false;
        } else {
            try {
                oicq.wlogin_sdk.request.b bVar = this.iNz;
                if (bArr == null || bArr.length == 0 || bVar.Ucc == null) {
                    i2 = -1017;
                } else {
                    util.buY("user:" + bVar.UbW._uin + " ResolveSvrData ...");
                    i2 = bVar.Ucc.ai(bArr, bArr.length);
                    if (i2 == 1) {
                        bVar.Ps(bVar.UbW._uin);
                    }
                    util.buY("user:" + bVar.UbW._uin + " ResolveSvrData ret=" + i2);
                }
                Log.d("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf buflen:%d ret:%d", Integer.valueOf(bArr.length), Integer.valueOf(i2));
                if (i2 == 0) {
                    AppMethodBeat.o(132506);
                    return true;
                }
                AppMethodBeat.o(132506);
                return false;
            } catch (Exception e2) {
                Log.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf e:%s", e2.getMessage());
                Log.e("MicroMsg.WtloginMgr", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(132506);
                return false;
            }
        }
    }

    public final byte[] Ai(long j2) {
        AppMethodBeat.i(132507);
        if (j2 != this.iNA) {
            Log.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.iNA), Long.valueOf(j2));
            byte[] bArr = new byte[0];
            AppMethodBeat.o(132507);
            return bArr;
        }
        try {
            byte[] Pr = this.iNz.Pr(j2);
            AppMethodBeat.o(132507);
            return Pr;
        } catch (Exception e2) {
            Log.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg e:%s", e2.getMessage());
            Log.e("MicroMsg.WtloginMgr", "exception:%s", Util.stackTraceToString(e2));
            byte[] bArr2 = new byte[0];
            AppMethodBeat.o(132507);
            return bArr2;
        }
    }

    public final byte[] e(long j2, String str) {
        byte[] bytes;
        AppMethodBeat.i(132508);
        if (j2 != this.iNA) {
            Log.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.iNA), Long.valueOf(j2));
            byte[] bArr = new byte[0];
            AppMethodBeat.o(132508);
            return bArr;
        }
        if (Util.isNullOrNil(str)) {
            bytes = "****".getBytes();
        } else {
            bytes = str.getBytes();
        }
        try {
            byte[] f2 = this.iNz.f(j2, bytes);
            AppMethodBeat.o(132508);
            return f2;
        } catch (Exception e2) {
            Log.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg e:%s", e2.getMessage());
            Log.e("MicroMsg.WtloginMgr", "exception:%s", Util.stackTraceToString(e2));
            byte[] bArr2 = new byte[0];
            AppMethodBeat.o(132508);
            return bArr2;
        }
    }

    public final byte[] Aj(long j2) {
        WUserSigInfo wUserSigInfo;
        AppMethodBeat.i(132509);
        if (j2 != this.iNA) {
            Log.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.iNA), Long.valueOf(j2));
            byte[] bArr = new byte[0];
            AppMethodBeat.o(132509);
            return bArr;
        }
        try {
            WloginSigInfo Pu = this.iNz.UbW.Pu(j2);
            if (Pu == null) {
                wUserSigInfo = null;
            } else {
                wUserSigInfo = new WUserSigInfo();
                wUserSigInfo.get_clone(Pu);
            }
            if (wUserSigInfo == null) {
                byte[] bArr2 = new byte[0];
                AppMethodBeat.o(132509);
                return bArr2;
            }
            byte[] bArr3 = wUserSigInfo._A2;
            AppMethodBeat.o(132509);
            return bArr3;
        } catch (Exception e2) {
            Log.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf e:%s", e2.getMessage());
            Log.e("MicroMsg.WtloginMgr", "exception:%s", Util.stackTraceToString(e2));
            byte[] bArr4 = new byte[0];
            AppMethodBeat.o(132509);
            return bArr4;
        }
    }

    public final void Ak(long j2) {
        AppMethodBeat.i(132510);
        if (j2 != this.iNA) {
            Log.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.iNA), Long.valueOf(j2));
            AppMethodBeat.o(132510);
            return;
        }
        try {
            this.iNz.Ps(j2);
            AppMethodBeat.o(132510);
        } catch (Exception e2) {
            Log.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo e:%s", e2.getMessage());
            Log.e("MicroMsg.WtloginMgr", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132510);
        }
    }
}
