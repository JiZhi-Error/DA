package com.tencent.soter.core;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.biometric.BiometricManagerCompat;
import com.tencent.soter.core.c.b;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.h;
import com.tencent.soter.core.c.i;
import com.tencent.soter.core.c.j;
import com.tencent.soter.core.d.c;
import com.tencent.soter.core.d.e;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;

public final class a implements b {
    private static e RPi;
    private static com.tencent.soter.core.d.b RPj = hlg();

    static {
        boolean z = true;
        AppMethodBeat.i(88522);
        d.i("Soter.SoterCore", "soter: SoterCore is call static block to init SoterCore IMPL", new Object[0]);
        Object[] objArr = new Object[1];
        if (RPj != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        d.i("Soter.SoterCore", "soter: SoterCore is call static block to init SoterCore IMPL, IMPL is null[%b]", objArr);
        AppMethodBeat.o(88522);
    }

    public static void efp() {
        AppMethodBeat.i(88492);
        c.efp();
        AppMethodBeat.o(88492);
    }

    public static synchronized void lc(Context context) {
        synchronized (a.class) {
            AppMethodBeat.i(88493);
            if (RPj == null) {
                d.i("Soter.SoterCore", "soter: SoterCore IMPL is null then call tryToInitSoterTreble to init", new Object[0]);
                if (!com.tencent.soter.core.d.d.isInitializing()) {
                    com.tencent.soter.core.d.d dVar = new com.tencent.soter.core.d.d();
                    RPj = dVar;
                    dVar.a(RPi);
                    if (!RPj.lg(context)) {
                        RPj = null;
                        d.i("Soter.SoterCore", "soter: SoterCore IMPL is null after call tryToInitSoterTreble to init", new Object[0]);
                        AppMethodBeat.o(88493);
                    }
                } else {
                    d.i("Soter.SoterCore", "soter: treble is initializing", new Object[0]);
                }
            }
            AppMethodBeat.o(88493);
        }
    }

    public static void hle() {
        boolean z = true;
        AppMethodBeat.i(88494);
        if (RPj == null) {
            d.i("Soter.SoterCore", "soter: SoterCore IMPL is null then call getProviderSoterCore to init", new Object[0]);
            RPj = hlg();
            Object[] objArr = new Object[1];
            if (RPj != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            d.i("Soter.SoterCore", "soter: SoterCore IMPL is null[%b], after call getProviderSoterCore to init", objArr);
        }
        AppMethodBeat.o(88494);
    }

    public static int hlf() {
        AppMethodBeat.i(88495);
        if (RPj == null) {
            AppMethodBeat.o(88495);
            return 0;
        } else if (RPj instanceof com.tencent.soter.core.d.d) {
            d.d("Soter.SoterCore", "getSoterCoreType is TREBLE", new Object[0]);
            AppMethodBeat.o(88495);
            return 1;
        } else {
            d.d("Soter.SoterCore", "getSoterCoreType is not TREBLE", new Object[0]);
            AppMethodBeat.o(88495);
            return 0;
        }
    }

    private static com.tencent.soter.core.d.b hlg() {
        AppMethodBeat.i(88496);
        c.efp();
        if (h.hlu()) {
            AppMethodBeat.o(88496);
            return null;
        }
        Provider[] providers = Security.getProviders();
        if (providers == null) {
            AppMethodBeat.o(88496);
            return null;
        }
        for (Provider provider : providers) {
            String name = provider.getName();
            if (name != null && name.startsWith("SoterKeyStore")) {
                if (name.split("\\.").length > 1) {
                    com.tencent.soter.core.d.a aVar = new com.tencent.soter.core.d.a(name);
                    AppMethodBeat.o(88496);
                    return aVar;
                } else {
                    c cVar = new c(name);
                    AppMethodBeat.o(88496);
                    return cVar;
                }
            }
        }
        AppMethodBeat.o(88496);
        return null;
    }

    public static boolean hlh() {
        AppMethodBeat.i(88497);
        if (RPj == null) {
            d.e("Soter.SoterCore", "soter: isTrebleServiceConnected IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(88497);
            return false;
        }
        boolean hlh = RPj.hlh();
        AppMethodBeat.o(88497);
        return hlh;
    }

    public static void hli() {
        AppMethodBeat.i(88498);
        if (RPj == null) {
            d.e("Soter.SoterCore", "soter: triggerConnecting IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(88498);
            return;
        }
        RPj.hli();
        AppMethodBeat.o(88498);
    }

    public static void a(e eVar) {
        AppMethodBeat.i(88499);
        RPi = eVar;
        if (RPj == null) {
            d.e("Soter.SoterCore", "soter: setTrebleServiceListener IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(88499);
            return;
        }
        RPj.a(eVar);
        AppMethodBeat.o(88499);
    }

    public static boolean hlj() {
        AppMethodBeat.i(88500);
        if (RPj == null) {
            d.e("Soter.SoterCore", "soter: isNativeSupportSoter IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(88500);
            return false;
        }
        boolean hlj = RPj.hlj();
        d.e("Soter.SoterCore", "soter: isNativeSupportSoter return[" + hlj + "]", new Object[0]);
        AppMethodBeat.o(88500);
        return hlj;
    }

    public static f hlk() {
        AppMethodBeat.i(88501);
        if (RPj == null) {
            d.e("Soter.SoterCore", "soter: generateAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
            f fVar = new f(2);
            AppMethodBeat.o(88501);
            return fVar;
        }
        f hlk = RPj.hlk();
        AppMethodBeat.o(88501);
        return hlk;
    }

    public static f hll() {
        AppMethodBeat.i(88502);
        if (RPj == null) {
            d.e("Soter.SoterCore", "soter: removeAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
            f fVar = new f(2);
            AppMethodBeat.o(88502);
            return fVar;
        }
        f hll = RPj.hll();
        AppMethodBeat.o(88502);
        return hll;
    }

    public static boolean hlm() {
        AppMethodBeat.i(88503);
        if (RPj == null) {
            d.e("Soter.SoterCore", "soter: hasAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(88503);
            return false;
        }
        boolean hlm = RPj.hlm();
        AppMethodBeat.o(88503);
        return hlm;
    }

    public static boolean hln() {
        AppMethodBeat.i(88504);
        if (RPj == null) {
            d.e("Soter.SoterCore", "soter: isAppGlobalSecureKeyValid IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(88504);
            return false;
        }
        boolean hln = RPj.hln();
        AppMethodBeat.o(88504);
        return hln;
    }

    public static i hlo() {
        AppMethodBeat.i(88505);
        if (RPj == null) {
            d.e("Soter.SoterCore", "soter: getAppGlobalSecureKeyModel IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(88505);
            return null;
        }
        i hlo = RPj.hlo();
        AppMethodBeat.o(88505);
        return hlo;
    }

    public static f bqg(String str) {
        AppMethodBeat.i(88506);
        if (RPj == null) {
            d.e("Soter.SoterCore", "soter: generateAuthKey IMPL is null, not support soter", new Object[0]);
            f fVar = new f(2);
            AppMethodBeat.o(88506);
            return fVar;
        }
        f bqg = RPj.bqg(str);
        AppMethodBeat.o(88506);
        return bqg;
    }

    public static f dE(String str, boolean z) {
        AppMethodBeat.i(88507);
        if (RPj == null) {
            d.e("Soter.SoterCore", "soter: removeAuthKey IMPL is null, not support soter", new Object[0]);
            f fVar = new f(2);
            AppMethodBeat.o(88507);
            return fVar;
        }
        f dE = RPj.dE(str, z);
        AppMethodBeat.o(88507);
        return dE;
    }

    public static boolean bqh(String str) {
        AppMethodBeat.i(88508);
        if (RPj == null) {
            d.e("Soter.SoterCore", "soter: hasAuthKey IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(88508);
            return false;
        }
        boolean bqh = RPj.bqh(str);
        AppMethodBeat.o(88508);
        return bqh;
    }

    public static boolean bqi(String str) {
        AppMethodBeat.i(88509);
        if (RPj == null) {
            d.e("Soter.SoterCore", "soter: isAuthKeyValid IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(88509);
            return false;
        }
        boolean bqi = RPj.bqi(str);
        AppMethodBeat.o(88509);
        return bqi;
    }

    public static i bqj(String str) {
        AppMethodBeat.i(88510);
        if (RPj == null) {
            d.e("Soter.SoterCore", "soter: getAuthKeyModel IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(88510);
            return null;
        }
        i bqj = RPj.bqj(str);
        AppMethodBeat.o(88510);
        return bqj;
    }

    public static Signature bqk(String str) {
        AppMethodBeat.i(88511);
        if (RPj == null) {
            d.e("Soter.SoterCore", "soter: getAuthInitAndSign IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(88511);
            return null;
        }
        Signature bqk = RPj.bqk(str);
        AppMethodBeat.o(88511);
        return bqk;
    }

    public static SoterSessionResult nI(String str, String str2) {
        AppMethodBeat.i(88512);
        if (RPj == null) {
            d.e("Soter.SoterCore", "soter: initSigh IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(88512);
            return null;
        }
        SoterSessionResult nI = RPj.nI(str, str2);
        AppMethodBeat.o(88512);
        return nI;
    }

    public static byte[] Oz(long j2) {
        AppMethodBeat.i(88513);
        if (RPj == null) {
            d.e("Soter.SoterCore", "soter: finishSign IMPL is null, not support soter", new Object[0]);
            byte[] bArr = new byte[0];
            AppMethodBeat.o(88513);
            return bArr;
        }
        byte[] Oz = RPj.Oz(j2);
        AppMethodBeat.o(88513);
        return Oz;
    }

    @Deprecated
    public static boolean fN(Context context) {
        AppMethodBeat.i(88515);
        boolean isHardwareDetected = BiometricManagerCompat.from(context, 1).isHardwareDetected();
        d.e("Soter.SoterCore", "soter: isSupportFingerprint return[" + isHardwareDetected + "]", new Object[0]);
        AppMethodBeat.o(88515);
        return isHardwareDetected;
    }

    public static boolean aU(Context context, int i2) {
        AppMethodBeat.i(88516);
        boolean isHardwareDetected = BiometricManagerCompat.from(context, Integer.valueOf(i2)).isHardwareDetected();
        d.e("Soter.SoterCore", "soter: isSupportBiometric type[" + i2 + "] return[" + isHardwareDetected + "]", new Object[0]);
        AppMethodBeat.o(88516);
        return isHardwareDetected;
    }

    @Deprecated
    public static boolean ld(Context context) {
        AppMethodBeat.i(88517);
        boolean hasEnrolledBiometric = BiometricManagerCompat.from(context, 1).hasEnrolledBiometric();
        AppMethodBeat.o(88517);
        return hasEnrolledBiometric;
    }

    public static boolean aV(Context context, int i2) {
        AppMethodBeat.i(88518);
        boolean hasEnrolledBiometric = BiometricManagerCompat.from(context, Integer.valueOf(i2)).hasEnrolledBiometric();
        AppMethodBeat.o(88518);
        return hasEnrolledBiometric;
    }

    @Deprecated
    public static boolean le(Context context) {
        AppMethodBeat.i(88519);
        if (BiometricManagerCompat.from(context, 1).isCurrentFailTimeAvailable() || BiometricManagerCompat.from(context, 1).isCurrentTweenTimeAvailable(context)) {
            AppMethodBeat.o(88519);
            return false;
        }
        AppMethodBeat.o(88519);
        return true;
    }

    public static boolean aW(Context context, int i2) {
        AppMethodBeat.i(88520);
        if (BiometricManagerCompat.from(context, Integer.valueOf(i2)).isCurrentFailTimeAvailable() || BiometricManagerCompat.from(context, Integer.valueOf(i2)).isCurrentTweenTimeAvailable(context)) {
            AppMethodBeat.o(88520);
            return false;
        }
        AppMethodBeat.o(88520);
        return true;
    }

    public static String hlp() {
        AppMethodBeat.i(88521);
        StringBuilder sb = new StringBuilder();
        sb.append("<deviceinfo>");
        sb.append("<MANUFACTURER name=\"");
        sb.append(Build.MANUFACTURER);
        sb.append("\">");
        sb.append("<MODEL name=\"");
        sb.append(Build.MODEL);
        sb.append("\">");
        sb.append("<VERSION_RELEASE name=\"");
        sb.append(Build.VERSION.RELEASE);
        sb.append("\">");
        sb.append("<VERSION_INCREMENTAL name=\"");
        sb.append(Build.VERSION.INCREMENTAL);
        sb.append("\">");
        sb.append("<DISPLAY name=\"");
        sb.append(Build.DISPLAY);
        sb.append("\">");
        sb.append("</DISPLAY></VERSION_INCREMENTAL></VERSION_RELEASE></MODEL></MANUFACTURER></deviceinfo>");
        d.d("Soter.SoterCore", "soter: getFingerprint  " + sb.toString(), new Object[0]);
        String sb2 = sb.toString();
        AppMethodBeat.o(88521);
        return sb2;
    }

    public static j cY(byte[] bArr) {
        j jVar = null;
        AppMethodBeat.i(88514);
        if (bArr == null || bArr.length <= 0) {
            d.e("Soter.SoterCore", "origin is null or nil. abort", new Object[0]);
            AppMethodBeat.o(88514);
        } else if (bArr.length < 4) {
            d.e("Soter.SoterCore", "soter: length not correct 1", new Object[0]);
            AppMethodBeat.o(88514);
        } else {
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 0, bArr2, 0, 4);
            int i2 = 0;
            for (int i3 = 0; i3 < 4; i3++) {
                i2 += (bArr2[i3] & 255) << (i3 * 8);
            }
            d.d("Soter", "parsed raw length: ".concat(String.valueOf(i2)), new Object[0]);
            if (i2 > 1048576) {
                d.e("Soter.SoterCore", "soter: too large signature result!", new Object[0]);
                AppMethodBeat.o(88514);
            } else {
                byte[] bArr3 = new byte[i2];
                if (bArr.length <= i2 + 4) {
                    d.e("Soter.SoterCore", "soter: length not correct 2", new Object[0]);
                    AppMethodBeat.o(88514);
                } else {
                    System.arraycopy(bArr, 4, bArr3, 0, i2);
                    jVar = j.bql(new String(bArr3));
                    int length = bArr.length - (i2 + 4);
                    d.d("Soter.SoterCore", "soter: signature length: ".concat(String.valueOf(length)), new Object[0]);
                    byte[] bArr4 = new byte[length];
                    System.arraycopy(bArr, i2 + 4, bArr4, 0, length);
                    if (jVar != null) {
                        jVar.signature = Base64.encodeToString(bArr4, 2);
                    }
                    AppMethodBeat.o(88514);
                }
            }
        }
        return jVar;
    }
}
