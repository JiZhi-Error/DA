package com.tencent.mm.protocal;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class f {
    public static boolean KyZ;
    public static boolean Kza;
    private static int Kzb;
    private static byte[] Kzc;
    private static byte[] Kzd;
    public static int Kze;
    private static long Kzf = 0;

    static {
        AppMethodBeat.i(133044);
        KyZ = false;
        Kza = false;
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("auth_info_key_prefs", g.aps());
        KyZ = sharedPreferences.getBoolean("auth_info_prefs_use_new_ecdh", true);
        Kza = sharedPreferences.getBoolean("auth_info_prefs_use_net_ml_cert", false);
        Log.i("MicroMsg.EcdhMgr", "summerauths USE_ECDH[%s] USE_ML[%s]", Boolean.valueOf(KyZ), Boolean.valueOf(Kza));
        if (Kza) {
            Kze = 10001;
            Kzb = 415;
            Kzc = Base64.decode("BJO0cjvgelbYHm8ZlKVVl63oMbeMYLjIqaWtZWvBBTSm7PzWslBMy8loLcnG9dITvDzD6YpddZdH1PnHxG8Kpvo=", 0);
            Kzd = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFQ0JvQVdmMC84ZVJEL0NKeWIxU3RKckhPeVcyVwo2Z3ZjaUh1TTZOZk82cWhLNDJKTjZSRmxucEtZbVAyTlBYbnd3L05VVFpMM05Qa3FZVEh2Q1AwSmtnPT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
        } else {
            Kze = 10002;
            Kzb = 415;
            Kzc = Base64.decode("BJW8blwTMa0XLQ81sXksPOY/kVcqvS3W322sLXAZXD9mJ8ymAwcwXYSVqMOLRBbHUCHoI7bJff/nnBTLfDr4pYY=", 0);
            Kzd = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFUkl5eWlLM1M5UDdIVGFLTGVHUDFLemJDQ1E5SQpMU3hFR3hhRlZFNGpuWmU2RnF3dzBKaHc1bUFxYmZXTEs2Tmk4cHV2U1Y2Q3FDK0QyS2VTM3N2cFl3PT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
        }
        AppMethodBeat.o(133044);
    }

    public static long cF(byte[] bArr) {
        AppMethodBeat.i(133041);
        long CreateHybridEcdhCryptoEngine = UtilsJni.CreateHybridEcdhCryptoEngine(Kzb, Kzc, Kzd, bArr);
        Object[] objArr = new Object[4];
        objArr[0] = Long.valueOf(CreateHybridEcdhCryptoEngine);
        objArr[1] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[2] = Integer.valueOf(Kzb);
        objArr[3] = Util.getStack();
        Log.i("MicroMsg.EcdhMgr", "summerauths getHybridEcdhCryptoEngine engine[%s] autoauth_key[%s] nid[%s] stack[%s]", objArr);
        AppMethodBeat.o(133041);
        return CreateHybridEcdhCryptoEngine;
    }

    public static void Mt(long j2) {
        AppMethodBeat.i(133042);
        UtilsJni.ReleaseHybridEcdhCryptoEngine(j2);
        Log.i("MicroMsg.EcdhMgr", "summerauths releaseHybridEcdhCryptoEngine engine[%s] stack[%s]", Long.valueOf(j2), Util.getStack());
        AppMethodBeat.o(133042);
    }

    public static synchronized boolean gtz() {
        boolean z = false;
        synchronized (f.class) {
            AppMethodBeat.i(133043);
            Log.i("MicroMsg.EcdhMgr", "summerauths switchCert LAST_SWITCH_TIME[%s] old USE_ML[%s] stack[%s]", Long.valueOf(Kzf), Boolean.valueOf(Kza), Util.getStack());
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (600000 < elapsedRealtime - Kzf || Kzf <= 0) {
                Kzf = SystemClock.elapsedRealtime();
                if (!Kza) {
                    z = true;
                }
                Kza = z;
                SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("auth_info_key_prefs", g.aps());
                z = sharedPreferences.edit().putBoolean("auth_info_prefs_use_net_ml_cert", Kza).commit();
                sharedPreferences.getBoolean("auth_info_prefs_use_net_ml_cert", false);
                Log.i("MicroMsg.EcdhMgr", "summerauths switchCert to [%s] save sp[%s]", Boolean.valueOf(Kza), Boolean.valueOf(z));
                if (Kza) {
                    Kze = 10001;
                    Kzb = 415;
                    Kzc = Base64.decode("BJO0cjvgelbYHm8ZlKVVl63oMbeMYLjIqaWtZWvBBTSm7PzWslBMy8loLcnG9dITvDzD6YpddZdH1PnHxG8Kpvo=", 0);
                    Kzd = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFQ0JvQVdmMC84ZVJEL0NKeWIxU3RKckhPeVcyVwo2Z3ZjaUh1TTZOZk82cWhLNDJKTjZSRmxucEtZbVAyTlBYbnd3L05VVFpMM05Qa3FZVEh2Q1AwSmtnPT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
                } else {
                    Kze = 10002;
                    Kzb = 415;
                    Kzc = Base64.decode("BJW8blwTMa0XLQ81sXksPOY/kVcqvS3W322sLXAZXD9mJ8ymAwcwXYSVqMOLRBbHUCHoI7bJff/nnBTLfDr4pYY=", 0);
                    Kzd = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFUkl5eWlLM1M5UDdIVGFLTGVHUDFLemJDQ1E5SQpMU3hFR3hhRlZFNGpuWmU2RnF3dzBKaHc1bUFxYmZXTEs2Tmk4cHV2U1Y2Q3FDK0QyS2VTM3N2cFl3PT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
                }
                AppMethodBeat.o(133043);
            } else {
                Log.i("MicroMsg.EcdhMgr", "summerauths switchCert LAST_SWITCH_TIME freq limit [%s]ms ret false", Long.valueOf(elapsedRealtime - Kzf));
                AppMethodBeat.o(133043);
            }
        }
        return z;
    }

    public static byte[] gtA() {
        return Kzc;
    }
}
