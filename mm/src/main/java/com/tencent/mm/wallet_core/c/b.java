package com.tencent.mm.wallet_core.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tenpay.ndk.CertUtil;
import com.tenpay.ndk.MessageDigestUtil;

public final class b {
    private static b Rtl = null;
    static boolean isInit = false;
    private boolean Rtm = false;
    private CertUtil.EventListener Rtn = new CertUtil.EventListener() {
        /* class com.tencent.mm.wallet_core.c.b.AnonymousClass1 */

        @Override // com.tenpay.ndk.CertUtil.EventListener
        public final void onEvent(int i2, String str) {
            AppMethodBeat.i(72723);
            Log.i("MicroMsg.CertUtilWx", "code ret: %s %s", Integer.valueOf(i2), str);
            AppMethodBeat.o(72723);
        }

        @Override // com.tenpay.ndk.CertUtil.EventListener
        public final String getUniqueID() {
            AppMethodBeat.i(72724);
            String dr = q.dr(false);
            if (Util.isNullOrNil(dr)) {
                String aoG = q.aoG();
                AppMethodBeat.o(72724);
                return aoG;
            }
            AppMethodBeat.o(72724);
            return dr;
        }
    };

    public b() {
        AppMethodBeat.i(72725);
        AppMethodBeat.o(72725);
    }

    public static b hhj() {
        AppMethodBeat.i(72726);
        if (Rtl == null) {
            Rtl = new b();
        }
        b bVar = Rtl;
        AppMethodBeat.o(72726);
        return bVar;
    }

    public final void init(Context context) {
        AppMethodBeat.i(72727);
        if (isInit) {
            AppMethodBeat.o(72727);
            return;
        }
        Log.d("MicroMsg.CertUtilWx", "init  %s", Util.getStack().toString());
        CertUtil.getInstance().init(context, this.Rtn);
        isInit = true;
        AppMethodBeat.o(72727);
    }

    public final String hr(String str, int i2) {
        String certApplyCSR;
        AppMethodBeat.i(72728);
        Log.i("MicroMsg.CertUtilWx", "getCertApplyCSR lock %s %s", Util.getStack().toString(), Integer.valueOf(i2));
        synchronized (this) {
            try {
                if (this.Rtm) {
                    Log.i("MicroMsg.CertUtilWx", "isCert_Wating");
                    certApplyCSR = "";
                } else {
                    this.Rtm = true;
                    certApplyCSR = CertUtil.getInstance().getCertApplyCSR(str, i2);
                    AppMethodBeat.o(72728);
                }
            } finally {
                AppMethodBeat.o(72728);
            }
        }
        return certApplyCSR;
    }

    public final boolean importCert(String str, String str2) {
        boolean importCert;
        AppMethodBeat.i(72729);
        Log.i("MicroMsg.CertUtilWx", "importCert  cid %s cert %s stack %s", str, str2, Util.getStack().toString());
        synchronized (this) {
            try {
                this.Rtm = false;
                importCert = CertUtil.getInstance().importCert(str, str2);
            } catch (Throwable th) {
                AppMethodBeat.o(72729);
                throw th;
            }
        }
        Log.i("MicroMsg.CertUtilWx", "importCert %s", Boolean.valueOf(importCert));
        AppMethodBeat.o(72729);
        return importCert;
    }

    public final boolean hhk() {
        AppMethodBeat.i(72730);
        Log.d("MicroMsg.CertUtilWx", "importCertNone");
        synchronized (this) {
            try {
                this.Rtm = false;
            } finally {
                AppMethodBeat.o(72730);
            }
        }
        return false;
    }

    public static boolean isCertExist(String str) {
        AppMethodBeat.i(72731);
        Log.d("MicroMsg.CertUtilWx", "isCertExist stack %s", Util.getStack().toString());
        h.INSTANCE.idkeyStat(414, 5, 1, true);
        boolean isCertExist = CertUtil.getInstance().isCertExist(str);
        h.INSTANCE.idkeyStat(414, 6, 1, true);
        AppMethodBeat.o(72731);
        return isCertExist;
    }

    public static String genUserSig(String str, byte[] bArr) {
        AppMethodBeat.i(72732);
        Log.d("MicroMsg.CertUtilWx", "genUserSig stack %s", Util.getStack().toString());
        String genUserSig = CertUtil.getInstance().genUserSig(str, bArr);
        AppMethodBeat.o(72732);
        return genUserSig;
    }

    public static String genUserSig(String str, String str2) {
        AppMethodBeat.i(72733);
        Log.d("MicroMsg.CertUtilWx", "genUserSig stack %s", Util.getStack().toString());
        String genUserSig = CertUtil.getInstance().genUserSig(str, str2);
        AppMethodBeat.o(72733);
        return genUserSig;
    }

    public static boolean F(String str, String str2, boolean z) {
        AppMethodBeat.i(72734);
        String str3 = "";
        if (z) {
            MessageDigestUtil messageDigestUtil = new MessageDigestUtil();
            g.aAi();
            g.aAf();
            byte[] bArr = new byte[16];
            byte[] bytes = messageDigestUtil.getSHA256Hex((p.getString(a.getUin()) + "_pUI6cNqzLt2Z3mQSrYuF09XSGsBtTIcUgp9jcWZ7F7BBs8/DFVFMKiwbtaRPOiLE").getBytes()).getBytes();
            int i2 = 0;
            while (i2 < 16 && i2 < bytes.length) {
                bArr[i2] = bytes[i2];
                i2++;
            }
            str3 = new String(bArr);
        }
        Log.d("MicroMsg.CertUtilWx", "setTokens stack v2 useSm4 %s sm4Key %s %s", Boolean.valueOf(z), str3, Util.getStack().toString());
        boolean tokens = CertUtil.getInstance().setTokens(str, str2, z, str3);
        Log.d("MicroMsg.CertUtilWx", "setTokens result ret:%s", Boolean.valueOf(tokens));
        AppMethodBeat.o(72734);
        return tokens;
    }

    public static String getToken(String str) {
        AppMethodBeat.i(72735);
        Log.d("MicroMsg.CertUtilWx", "getToken stack %s", Util.getStack().toString());
        String token = CertUtil.getInstance().getToken(str);
        AppMethodBeat.o(72735);
        return token;
    }

    public static void clearToken(String str) {
        AppMethodBeat.i(72736);
        Log.d("MicroMsg.CertUtilWx", "clearToken stack %s", Util.getStack().toString());
        CertUtil.getInstance().clearToken(str);
        AppMethodBeat.o(72736);
    }

    public static int bpl(String str) {
        AppMethodBeat.i(72737);
        int tokenCount = CertUtil.getInstance().getTokenCount(str);
        Log.d("MicroMsg.CertUtilWx", "getTokenCount ret: %d stack %s", Integer.valueOf(tokenCount), Util.getStack().toString());
        AppMethodBeat.o(72737);
        return tokenCount;
    }

    public static int getLastError() {
        AppMethodBeat.i(72738);
        Log.d("MicroMsg.CertUtilWx", "getLastError stack %s", Util.getStack().toString());
        int lastError = CertUtil.getInstance().getLastError();
        AppMethodBeat.o(72738);
        return lastError;
    }

    public static void clearCert(String str) {
        AppMethodBeat.i(72739);
        Log.d("MicroMsg.CertUtilWx", "clearCert stack %s", Util.getStack().toString());
        CertUtil.getInstance().clearCert(str);
        AppMethodBeat.o(72739);
    }

    public static void clean() {
        AppMethodBeat.i(72740);
        Log.d("MicroMsg.CertUtilWx", "clean allcrt stack %s", Util.getStack().toString());
        CertUtil.getInstance().clearAllCert();
        AppMethodBeat.o(72740);
    }
}
