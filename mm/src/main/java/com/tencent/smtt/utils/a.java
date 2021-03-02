package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsExtensionFunctionManager;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import java.io.File;
import java.util.regex.Pattern;

public class a {
    public static boolean a(Context context, File file, long j2, int i2) {
        AppMethodBeat.i(53854);
        if (file == null || !file.exists()) {
            AppMethodBeat.o(53854);
            return false;
        } else if (j2 <= 0 || j2 == file.length()) {
            try {
                if (i2 != a(context, file)) {
                    AppMethodBeat.o(53854);
                    return false;
                } else if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(b.a(context, true, file))) {
                    AppMethodBeat.o(53854);
                    return false;
                } else {
                    AppMethodBeat.o(53854);
                    return true;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(53854);
                return false;
            }
        } else {
            AppMethodBeat.o(53854);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033 A[SYNTHETIC, Splitter:B:12:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006b A[SYNTHETIC, Splitter:B:25:0x006b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r12) {
        /*
        // Method dump skipped, instructions count: 146
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.a.a(java.io.File):java.lang.String");
    }

    public static int a(Context context, File file) {
        boolean z;
        int i2 = 0;
        AppMethodBeat.i(53856);
        try {
            if (Build.VERSION.SDK_INT >= 20) {
                z = !TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME);
            } else {
                z = false;
            }
            i2 = a(context, file, z);
        } catch (Exception e2) {
            TbsLog.i("ApkUtil", "getApkVersion Failed");
        }
        AppMethodBeat.o(53856);
        return i2;
    }

    public static final String a(boolean z) {
        AppMethodBeat.i(53857);
        if (b.d()) {
            if (z) {
                AppMethodBeat.o(53857);
                return "x5.64.decouple.backup";
            }
            AppMethodBeat.o(53857);
            return "x5.64.backup";
        } else if (z) {
            AppMethodBeat.o(53857);
            return "x5.decouple.backup";
        } else {
            AppMethodBeat.o(53857);
            return "x5.backup";
        }
    }

    private static int a(boolean z, File file) {
        AppMethodBeat.i(53858);
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                File[] listFiles = parentFile.listFiles();
                Pattern compile = Pattern.compile(a(z) + "(.*)");
                for (File file2 : listFiles) {
                    if (compile.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                        int parseInt = Integer.parseInt(file2.getName().substring(file2.getName().lastIndexOf(".") + 1));
                        AppMethodBeat.o(53858);
                        return parseInt;
                    }
                }
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(53858);
        return -1;
    }

    public static int a(Context context, File file, boolean z) {
        boolean z2;
        int b2;
        int i2 = 0;
        AppMethodBeat.i(53859);
        if (file != null) {
            try {
                if (file.exists()) {
                    boolean contains = file.getName().contains("tbs.org");
                    boolean contains2 = file.getName().contains("x5.tbs.decouple");
                    if (contains || contains2) {
                        int a2 = a(contains2, file);
                        if (a2 > 0) {
                            AppMethodBeat.o(53859);
                            return a2;
                        } else if (!TbsShareManager.isThirdPartyApp(context) && !file.getAbsolutePath().contains(context.getApplicationInfo().packageName)) {
                            AppMethodBeat.o(53859);
                            return 0;
                        }
                    }
                    if ((Build.VERSION.SDK_INT == 23 || Build.VERSION.SDK_INT == 25) && Build.MANUFACTURER.toLowerCase().contains("mi")) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    TbsPVConfig.releaseInstance();
                    int readApk = TbsPVConfig.getInstance(context).getReadApk();
                    if (readApk == 1) {
                        z2 = false;
                        z = false;
                    } else if (readApk == 2) {
                        AppMethodBeat.o(53859);
                        return 0;
                    }
                    if ((z || z2) && (b2 = b(file)) > 0) {
                        AppMethodBeat.o(53859);
                        return b2;
                    }
                }
            } catch (Throwable th) {
            }
        }
        if (file != null && file.exists()) {
            try {
                PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1);
                if (packageArchiveInfo != null) {
                    i2 = packageArchiveInfo.versionCode;
                }
            } catch (Throwable th2) {
                AppMethodBeat.o(53859);
                return -1;
            }
        }
        AppMethodBeat.o(53859);
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0067 A[SYNTHETIC, Splitter:B:31:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006c A[Catch:{ Exception -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0077 A[SYNTHETIC, Splitter:B:39:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007c A[Catch:{ Exception -> 0x008c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int b(java.io.File r7) {
        /*
        // Method dump skipped, instructions count: 157
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.a.b(java.io.File):int");
    }
}
