package com.tencent.mm.booter;

import android.os.Build;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTaskForNative;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.s;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import org.xwalk.core.XWalkEnvironment;

public final class j {
    private static long glX = -1;
    private static final int[] glY = {20, 30, 40};
    private static final int[] glZ = {21, 31, 41};
    private static final int[] gma = {22, 32, 42};
    private static final int[] gmb = {23, 33, 43};
    private static final int[] gmc = {24, 34, 44};
    private static final int[] gmd = {25, 35, 45};
    private static final int[] gme = {26, 36, 46};
    private static final int[] gmf = {27, 37, 47};
    private static final int[] gmg = {28, 38, 48};
    private static final int[] gmh = {29, 39, 49};
    private static final int[] gmi = {100, 110, 120};
    private static final int[] gmj = {101, 111, 121};
    private static final int[] gmk = {102, 112, 122};
    private static final int[] gml = {103, 113, 123};
    private static final int[] gmm = {104, 114, 124};
    private static final int[] gmn = {105, 115, 125};
    private static final int[] gmo = {106, 116, 126};
    private static final int[] gmp = {107, 117, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH};
    private static final int[] gmq = {108, 118, 128};
    private static final int[] gmr = {109, 119, 129};
    private static final int[] gms = {160, TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE, TXLiveConstants.RENDER_ROTATION_180};

    private static int akN() {
        BufferedReader bufferedReader;
        Throwable th;
        Throwable th2;
        String trim;
        AppMethodBeat.i(19887);
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(s.openRead("/proc/cpuinfo"), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        Util.qualityClose(bufferedReader);
                        AppMethodBeat.o(19887);
                        return 2;
                    } else if (!Util.isNullOrNil(readLine)) {
                        if (Util.isNullOrNil(readLine)) {
                            trim = "";
                        } else {
                            trim = readLine.replaceAll(" ", "").trim().replaceAll("kB", "").trim().replaceAll("\\t", "").trim();
                        }
                        if (trim.contains("CPUarchitecture:7")) {
                            Util.qualityClose(bufferedReader);
                            AppMethodBeat.o(19887);
                            return 0;
                        } else if (trim.contains("CPUarchitecture:8") || trim.contains("CPUarchitecture:AArch64")) {
                            Util.qualityClose(bufferedReader);
                            AppMethodBeat.o(19887);
                        }
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        Log.printErrStackTrace("MicroMsg.PostTaskReportEABISupport", th2, "unexpected exception occurred.", new Object[0]);
                        Util.qualityClose(bufferedReader);
                        AppMethodBeat.o(19887);
                        return -1;
                    } catch (Throwable th4) {
                        th = th4;
                        Util.qualityClose(bufferedReader);
                        AppMethodBeat.o(19887);
                        throw th;
                    }
                }
            }
            Util.qualityClose(bufferedReader);
            AppMethodBeat.o(19887);
            return 1;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            Util.qualityClose(bufferedReader);
            AppMethodBeat.o(19887);
            throw th;
        }
    }

    private static boolean g(ArrayList<IDKey> arrayList) {
        int i2 = 1;
        AppMethodBeat.i(19888);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        for (int i3 = 0; i3 < Build.SUPPORTED_32_BIT_ABIS.length; i3++) {
            String str = Build.SUPPORTED_32_BIT_ABIS[i3];
            if ("armeabi".equalsIgnoreCase(str)) {
                z4 = true;
            } else if (XWalkEnvironment.RUNTIME_ABI_ARM32_STR.equalsIgnoreCase(str)) {
                z3 = true;
            } else if ("x86".equalsIgnoreCase(str)) {
                z2 = true;
            } else if ("mips".equalsIgnoreCase(str)) {
                z = true;
            }
        }
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        for (int i4 = 0; i4 < Build.SUPPORTED_64_BIT_ABIS.length; i4++) {
            String str2 = Build.SUPPORTED_64_BIT_ABIS[i4];
            if (XWalkEnvironment.RUNTIME_ABI_ARM64_STR.equalsIgnoreCase(str2)) {
                z7 = true;
            } else if ("x86_64".equalsIgnoreCase(str2)) {
                z6 = true;
            } else if ("mips64".equalsIgnoreCase(str2)) {
                z5 = true;
            }
        }
        if (z4) {
            arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 10, 1));
        }
        if (z3) {
            arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 11, 1));
        }
        if (z7) {
            arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 12, 1));
        }
        if (z2) {
            arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 13, 1));
        }
        if (z6) {
            arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 14, 1));
        }
        if (z) {
            arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 15, 1));
        }
        if (z5) {
            arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 16, 1));
        }
        e eVar = e.INSTANCE;
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(z7 ? 1 : 0);
        objArr[1] = Integer.valueOf(z3 ? 1 : 0);
        objArr[2] = Integer.valueOf(z4 ? 1 : 0);
        objArr[3] = Integer.valueOf(z2 ? 1 : 0);
        objArr[4] = Integer.valueOf(z6 ? 1 : 0);
        objArr[5] = Integer.valueOf(z ? 1 : 0);
        if (!z5) {
            i2 = 0;
        }
        objArr[6] = Integer.valueOf(i2);
        eVar.a(18459, objArr);
        AppMethodBeat.o(19888);
        return z7;
    }

    public static void run() {
        int[] iArr;
        int[] iArr2;
        AppMethodBeat.i(19889);
        if (d.oE(21)) {
            AppMethodBeat.o(19889);
            return;
        }
        if (glX < 0) {
            glX = MMApplicationContext.getContext().getSharedPreferences("eabi_report", 0).getLong("last_report", -1);
        }
        if (glX < 0 || System.currentTimeMillis() - glX > Util.MILLSECONDS_OF_DAY) {
            boolean z = Build.SUPPORTED_64_BIT_ABIS.length > 0;
            Log.i("MicroMsg.PostTaskReportEABISupport", "current device support eabi: %s, %s", Arrays.toString(Build.SUPPORTED_32_BIT_ABIS), Arrays.toString(Build.SUPPORTED_64_BIT_ABIS));
            ArrayList<IDKey> arrayList = new ArrayList<>();
            arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 3, 1));
            if (z) {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 4, 1));
            } else {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 5, 1));
            }
            boolean g2 = g(arrayList);
            if (g2) {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 64, 1));
                if (Build.VERSION.SDK_INT - 21 < 10) {
                    arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, (Build.VERSION.SDK_INT - 21) + 90, 1));
                }
            } else {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 65, 1));
                if (Build.VERSION.SDK_INT - 21 < 10) {
                    arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, (Build.VERSION.SDK_INT - 21) + 80, 1));
                }
            }
            Log.i("MicroMsg.PostTaskReportEABISupport", "supportArm64_v8a : %s", Boolean.valueOf(g2));
            arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 50, 1));
            if (BuildInfo.IS_ARM64) {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 52, 1));
            } else {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 51, 1));
            }
            boolean equalsIgnoreCase = XWalkEnvironment.RUNTIME_ABI_ARM64_STR.equalsIgnoreCase(Build.CPU_ABI);
            if ((!BuildInfo.IS_ARM64 || !equalsIgnoreCase) && (BuildInfo.IS_ARM64 || equalsIgnoreCase)) {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 54, 1));
            } else {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 53, 1));
            }
            Log.i("MicroMsg.PostTaskReportEABISupport", "IS_ARM64: %s, isRuntime64 : %s", Boolean.valueOf(BuildInfo.IS_ARM64), Boolean.valueOf(equalsIgnoreCase));
            int akN = akN();
            Log.i("MicroMsg.PostTaskReportEABISupport", "supportArm64FromCpuInfo : %s", Integer.valueOf(akN));
            if (akN == -1) {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 63, 1));
            } else if (akN == 0) {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 61, 1));
            } else if (akN == 1) {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 60, 1));
            } else if (akN == 2) {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 62, 1));
            }
            if ((g2 && akN == 1) || (!g2 && akN == 0)) {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 66, 1));
            } else if ((!g2 || akN != 0) && (g2 || akN != 1)) {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 68, 1));
            } else {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, 67, 1));
            }
            String lowerCase = Build.BRAND.toLowerCase();
            if (lowerCase.contains("xiaomi") || lowerCase.contains("redmi")) {
                iArr = gmc;
            } else if (lowerCase.contains("huawei")) {
                iArr = glY;
            } else if (lowerCase.contains("honor")) {
                iArr = glZ;
            } else if (lowerCase.contains("vivo")) {
                iArr = gma;
            } else if (lowerCase.contains("oppo")) {
                iArr = gmb;
            } else if (lowerCase.contains("samsung")) {
                iArr = gmd;
            } else if (lowerCase.contains("meizu")) {
                iArr = gme;
            } else if (lowerCase.contains("gionee")) {
                iArr = gmf;
            } else if (lowerCase.contains("oneplus")) {
                iArr = gmg;
            } else {
                iArr = gmh;
                Log.i("MicroMsg.PostTaskReportEABISupport", "factoryKeys : %s", lowerCase);
            }
            arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, iArr[0], 1));
            if (g2) {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, iArr[1], 1));
            } else {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, iArr[2], 1));
            }
            boolean z2 = BuildInfo.IS_ARM64;
            String lowerCase2 = Build.BRAND.toLowerCase();
            if (lowerCase2.contains("xiaomi") || lowerCase2.contains("redmi")) {
                iArr2 = gmm;
            } else if (lowerCase2.contains("huawei")) {
                iArr2 = gmi;
            } else if (lowerCase2.contains("honor")) {
                iArr2 = gmj;
            } else if (lowerCase2.contains("vivo")) {
                iArr2 = gmk;
            } else if (lowerCase2.contains("oppo")) {
                iArr2 = gml;
            } else if (lowerCase2.contains("samsung")) {
                iArr2 = gmn;
            } else if (lowerCase2.contains("meizu")) {
                iArr2 = gmo;
            } else if (lowerCase2.contains("gionee")) {
                iArr2 = gmp;
            } else if (lowerCase2.contains("oneplus")) {
                iArr2 = gmq;
            } else {
                iArr2 = gmr;
                Log.i("MicroMsg.PostTaskReportEABISupport", "wechatKeys : %s %s", lowerCase2, Boolean.valueOf(z2));
            }
            arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, iArr2[0], 1));
            if (z2) {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, iArr2[2], 1));
            } else {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, iArr2[1], 1));
            }
            boolean z3 = BuildInfo.IS_ARM64;
            int i2 = Build.VERSION.SDK_INT - 21;
            arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, gms[0] + i2, 1));
            if (z3) {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, i2 + gms[2], 1));
            } else {
                arrayList.add(new IDKey((int) JsApiQueryDownloadTaskForNative.CTRL_INDEX, i2 + gms[1], 1));
            }
            e.INSTANCE.b(arrayList, false);
            glX = System.currentTimeMillis();
            MMApplicationContext.getContext().getSharedPreferences("eabi_report", 0).edit().putLong("last_report", glX).commit();
        }
        AppMethodBeat.o(19889);
    }
}
