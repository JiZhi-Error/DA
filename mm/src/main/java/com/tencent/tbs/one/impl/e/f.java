package com.tencent.tbs.one.impl.e;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.i;
import com.tencent.tbs.one.impl.a.j;
import com.tencent.tbs.one.impl.a.k;
import com.tencent.tbs.one.impl.common.b;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.e;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final class f {
    public static int a(int i2, int i3, int i4) {
        AppMethodBeat.i(173989);
        int min = (int) (((((float) Math.min(Math.max(0, i2), 100)) / 100.0f) * ((float) (i4 - i3))) + ((float) i3));
        AppMethodBeat.o(173989);
        return min;
    }

    private static int a(d dVar, String str) {
        d.a b2;
        AppMethodBeat.i(173988);
        if (dVar == null || (b2 = dVar.b(str)) == null) {
            AppMethodBeat.o(173988);
            return -1;
        }
        int i2 = b2.f2560c;
        AppMethodBeat.o(173988);
        return i2;
    }

    private static String a(String str, String str2) {
        AppMethodBeat.i(173979);
        String substring = str.substring(str2.length(), str.length() - 3);
        AppMethodBeat.o(173979);
        return substring;
    }

    private static String a(byte[] bArr) {
        AppMethodBeat.i(188023);
        int length = bArr.length;
        char[] cArr = new char[(length * 2)];
        for (int i2 = 0; i2 < length; i2++) {
            byte b2 = bArr[i2];
            int i3 = (b2 >> 4) & 15;
            cArr[i2 * 2] = (char) (i3 >= 10 ? (i3 + 97) - 10 : i3 + 48);
            int i4 = b2 & 15;
            cArr[(i2 * 2) + 1] = (char) (i4 >= 10 ? (i4 + 97) - 10 : i4 + 48);
        }
        String str = new String(cArr);
        AppMethodBeat.o(188023);
        return str;
    }

    public static MessageDigest a() {
        AppMethodBeat.i(173981);
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            AppMethodBeat.o(173981);
            return instance;
        } catch (NoSuchAlgorithmException e2) {
            TBSOneException tBSOneException = new TBSOneException(106, "Failed to find md5 algorithm", e2);
            AppMethodBeat.o(173981);
            throw tBSOneException;
        }
    }

    public static void a(Context context) {
        AppMethodBeat.i(173986);
        com.tencent.tbs.one.impl.a.f.a("Cleaning Proc directory", new Object[0]);
        File[] listFiles = com.tencent.tbs.one.impl.common.f.b(context).listFiles();
        if (listFiles == null) {
            AppMethodBeat.o(173986);
            return;
        }
        int myPid = Process.myPid();
        if (listFiles.length != 1 || !listFiles[0].getName().equals(String.valueOf(myPid))) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager == null ? null : activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                AppMethodBeat.o(173986);
                return;
            }
            for (File file : listFiles) {
                int intValue = Integer.valueOf(file.getName()).intValue();
                if (intValue != myPid) {
                    boolean z = false;
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        z = runningAppProcessInfo.pid == intValue ? true : z;
                    }
                    if (!z) {
                        c.a(file);
                    }
                }
            }
            AppMethodBeat.o(173986);
            return;
        }
        AppMethodBeat.o(173986);
    }

    public static void a(File file) {
        AppMethodBeat.i(188014);
        File[] listFiles = file.listFiles();
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                file2.setExecutable(true, false);
                a(file2);
            }
        }
        AppMethodBeat.o(188014);
    }

    public static void a(File file, int i2) {
        AppMethodBeat.i(173983);
        e a2 = e.a(new File(file, "MANIFEST"));
        int i3 = a2.f2564a;
        if (i2 != i3) {
            TBSOneException tBSOneException = new TBSOneException(417, "Failed to verify version code, expected " + i2 + " but was " + i3);
            AppMethodBeat.o(173983);
            throw tBSOneException;
        }
        e.a[] aVarArr = a2.f2568e;
        if (aVarArr != null) {
            MessageDigest messageDigest = null;
            for (e.a aVar : aVarArr) {
                File file2 = new File(file, aVar.f2570a);
                if (!file2.exists()) {
                    TBSOneException tBSOneException2 = new TBSOneException(105, "Failed to find component file " + file2.getAbsolutePath());
                    AppMethodBeat.o(173983);
                    throw tBSOneException2;
                }
                String str = aVar.f2571b;
                if (!TextUtils.isEmpty(str)) {
                    if (messageDigest == null) {
                        messageDigest = a();
                    }
                    a(messageDigest, file2, str);
                }
            }
        }
        AppMethodBeat.o(173983);
    }

    public static void a(File file, long j2) {
        AppMethodBeat.i(173994);
        File e2 = com.tencent.tbs.one.impl.common.f.e(file, ".failed");
        try {
            if (!e2.exists() && !e2.createNewFile()) {
                com.tencent.tbs.one.impl.a.f.c("Failed to touch file %s, cannot create new file", e2.getAbsolutePath());
            } else if (!e2.setLastModified(j2)) {
                com.tencent.tbs.one.impl.a.f.c("Failed to touch file %s, cannot set last modified with %d", e2.getAbsolutePath(), Long.valueOf(j2));
                AppMethodBeat.o(173994);
                return;
            }
            AppMethodBeat.o(173994);
        } catch (IOException e3) {
            com.tencent.tbs.one.impl.a.f.c("Failed to touch file %s", e2.getAbsolutePath(), e3);
            AppMethodBeat.o(173994);
        }
    }

    public static void a(File file, File file2) {
        File[] listFiles;
        String a2;
        AppMethodBeat.i(173980);
        com.tencent.tbs.one.impl.a.f.a("Extracting from installation package %s to %s", file.getAbsolutePath(), file2.getAbsolutePath());
        File file3 = new File(file, "jni");
        String[] strArr = Build.VERSION.SDK_INT < 21 ? new String[]{Build.CPU_ABI, Build.CPU_ABI2} : Build.SUPPORTED_ABIS;
        boolean z = true;
        for (String str : strArr) {
            File file4 = new File(file3, str);
            if (file4.exists() && (listFiles = file4.listFiles()) != null && listFiles.length > 0) {
                com.tencent.tbs.one.impl.a.f.a("  ABI: %s", str);
                for (File file5 : listFiles) {
                    String name = file5.getName();
                    if (name.startsWith("libtbs=")) {
                        a2 = new String(Base64.decode(a(name, "libtbs="), 2), b.f2545a);
                        if (a2.contains(File.separator)) {
                            a2 = a2.substring(a2.indexOf(File.separatorChar) + 1);
                        }
                    } else {
                        a2 = name.startsWith("libtbs") ? a(name, "libtbs") : name;
                    }
                    File file6 = new File(file2, a2);
                    if (file6.exists()) {
                        com.tencent.tbs.one.impl.a.f.a("    %s -> %s, already exist", name, a2);
                    } else {
                        com.tencent.tbs.one.impl.a.f.a("    %s -> %s", name, a2);
                        try {
                            c.c(file5, file6);
                        } catch (IOException e2) {
                            TBSOneException tBSOneException = new TBSOneException(a.CTRL_INDEX, "Failed to extract component files in " + file2.getAbsolutePath(), e2);
                            AppMethodBeat.o(173980);
                            throw tBSOneException;
                        }
                    }
                }
                z = false;
            }
        }
        if (z) {
            com.tencent.tbs.one.impl.a.f.b("No files to extract from %s", file.getAbsolutePath());
        }
        AppMethodBeat.o(173980);
    }

    public static void a(InputStream inputStream, String str, long j2, File file, File file2, k.a aVar) {
        AppMethodBeat.i(188015);
        com.tencent.tbs.one.impl.a.f.a("Unzipping from download stream to %s, sdcard backup file is %s", file.getAbsolutePath(), file2);
        MessageDigest a2 = !TextUtils.isEmpty(str) ? a() : null;
        k kVar = a2 != null ? new k(new DigestInputStream(inputStream, a2), j2) : new k(inputStream, j2);
        kVar.f2370b = aVar;
        try {
            c.a(kVar, file, file2);
            if (j2 > 0) {
                long j3 = kVar.f2369a;
                if (j3 != j2) {
                    TBSOneException tBSOneException = new TBSOneException(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, "Failed to verify download stream length, expected " + j2 + " but was " + j3);
                    AppMethodBeat.o(188015);
                    throw tBSOneException;
                }
            }
            if (a2 != null) {
                String a3 = com.tencent.tbs.one.impl.a.d.a(a2.digest());
                if (!a3.equals(str)) {
                    TBSOneException tBSOneException2 = new TBSOneException(108, "Failed to verify download stream md5, expected " + str + " but was " + a3);
                    AppMethodBeat.o(188015);
                    throw tBSOneException2;
                }
            }
            AppMethodBeat.o(188015);
        } catch (IOException e2) {
            TBSOneException tBSOneException3 = new TBSOneException(com.tencent.mm.plugin.appbrand.jsapi.wifi.e.CTRL_INDEX, "Failed to unzip online component from " + file.getAbsolutePath() + " to " + file.getAbsolutePath(), e2);
            AppMethodBeat.o(188015);
            throw tBSOneException3;
        }
    }

    public static void a(MessageDigest messageDigest, File file, String str) {
        AppMethodBeat.i(173982);
        try {
            c.a(new DigestInputStream(new FileInputStream(file), messageDigest), i.f2363a);
            String a2 = com.tencent.tbs.one.impl.a.d.a(messageDigest.digest());
            if (!a2.equals(str)) {
                TBSOneException tBSOneException = new TBSOneException(108, "Failed to verify md5 for component file " + file.getAbsolutePath() + ", expected " + str + " but was " + a2);
                AppMethodBeat.o(173982);
                throw tBSOneException;
            }
            AppMethodBeat.o(173982);
        } catch (IOException e2) {
            TBSOneException tBSOneException2 = new TBSOneException(107, "Failed to compute md5 for component file " + file.getAbsolutePath(), e2);
            AppMethodBeat.o(173982);
            throw tBSOneException2;
        }
    }

    public static boolean a(Context context, String str) {
        String str2;
        AppMethodBeat.i(188013);
        char c2 = 65535;
        try {
            switch (str.hashCode()) {
                case -973170826:
                    if (str.equals("com.tencent.mm")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -103518033:
                    if (str.equals(TbsConfig.APP_DEMO)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 361910168:
                    if (str.equals(TbsConfig.APP_QQ)) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    str2 = "308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499";
                    break;
                case 1:
                    str2 = "30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049";
                    break;
                case 2:
                    str2 = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
                    break;
                default:
                    AppMethodBeat.o(188013);
                    return false;
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null) {
                AppMethodBeat.o(188013);
                return false;
            }
            if (str2.equals(packageInfo.signatures[0].toCharsString())) {
                AppMethodBeat.o(188013);
                return true;
            }
            AppMethodBeat.o(188013);
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
        } catch (Exception e3) {
            com.tencent.tbs.one.impl.a.f.c("verify app exception,e=" + Log.getStackTraceString(e3), new Object[0]);
        }
    }

    private static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        AppMethodBeat.i(188024);
        InputStream inputStream = jarFile.getInputStream(jarEntry);
        do {
        } while (inputStream.read(bArr, 0, 8192) != -1);
        inputStream.close();
        if (jarEntry != null) {
            Certificate[] certificates = jarEntry.getCertificates();
            AppMethodBeat.o(188024);
            return certificates;
        }
        AppMethodBeat.o(188024);
        return null;
    }

    public static void b(File file) {
        AppMethodBeat.i(173987);
        com.tencent.tbs.one.impl.a.f.a("shareFileIfNeeded,directory=%s", file);
        if (file != null && file.exists()) {
            file.setReadable(true, false);
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    b(file2);
                }
            }
        }
        AppMethodBeat.o(173987);
    }

    public static int c(File file) {
        int i2;
        AppMethodBeat.i(188016);
        File[] listFiles = file.listFiles(new FileFilter() {
            /* class com.tencent.tbs.one.impl.e.f.AnonymousClass1 */

            public final boolean accept(File file) {
                AppMethodBeat.i(174020);
                boolean isDirectory = file.isDirectory();
                AppMethodBeat.o(174020);
                return isDirectory;
            }
        });
        if (listFiles == null) {
            AppMethodBeat.o(188016);
            return -1;
        }
        int length = listFiles.length;
        int i3 = 0;
        int i4 = -1;
        while (i3 < length) {
            File file2 = listFiles[i3];
            if (g(file2)) {
                try {
                    i2 = Integer.parseInt(file2.getName());
                } catch (Exception e2) {
                    com.tencent.tbs.one.impl.a.f.c("Failed to parse component version from path %s", file2.getAbsolutePath(), e2);
                    i2 = -1;
                }
                if (i2 != -1 && i2 > i4) {
                    i3++;
                    i4 = i2;
                }
            }
            i2 = i4;
            i3++;
            i4 = i2;
        }
        AppMethodBeat.o(188016);
        return i4;
    }

    public static void d(File file) {
        AppMethodBeat.i(173991);
        String name = file.getName();
        com.tencent.tbs.one.impl.a.f.a("[%s] Cleaning useless components", name);
        File b2 = com.tencent.tbs.one.impl.common.f.b(file);
        if (!b2.exists()) {
            com.tencent.tbs.one.impl.a.f.a("[%s] %s no DEPS file exists", name, "Early out for cleanup useless components,");
            AppMethodBeat.o(173991);
            return;
        }
        final j a2 = j.a(com.tencent.tbs.one.impl.common.f.e(b2, ".lock"));
        if (a2 == null) {
            com.tencent.tbs.one.impl.a.f.a("[%s] %s the DEPS installation lock is busy", name, "Early out for cleanup useless components,");
            AppMethodBeat.o(173991);
            return;
        }
        File c2 = com.tencent.tbs.one.impl.common.f.c(file);
        final j a3 = j.a(com.tencent.tbs.one.impl.common.f.e(c2, ".lock"));
        AnonymousClass2 r7 = new Runnable() {
            /* class com.tencent.tbs.one.impl.e.f.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(173976);
                a2.a();
                if (a3 != null) {
                    a3.a();
                }
                AppMethodBeat.o(173976);
            }
        };
        if (a3 == null) {
            com.tencent.tbs.one.impl.a.f.a("[%s] %s the update lock is busy", name, "Early out for cleanup useless components,");
            r7.run();
            AppMethodBeat.o(173991);
            return;
        }
        try {
            d a4 = d.a(b2);
            d dVar = null;
            if (c2.exists()) {
                try {
                    dVar = d.a(c2);
                } catch (TBSOneException e2) {
                    com.tencent.tbs.one.impl.a.f.c("[%s] Failed to parse latest DEPS %s", name, " to clean useless components", e2);
                    r7.run();
                    AppMethodBeat.o(173991);
                    return;
                }
            }
            File[] listFiles = com.tencent.tbs.one.impl.common.f.d(file).listFiles();
            if (listFiles == null) {
                r7.run();
                AppMethodBeat.o(173991);
                return;
            }
            for (File file2 : listFiles) {
                String name2 = file2.getName();
                int a5 = a(a4, name2);
                int a6 = a(dVar, name2);
                if (a5 == -1 && a6 == -1) {
                    c.a(file2);
                } else {
                    File[] listFiles2 = file2.listFiles();
                    if (listFiles2 != null) {
                        for (File file3 : listFiles2) {
                            if (file3.isDirectory()) {
                                String name3 = file3.getName();
                                if (!name3.equals(String.valueOf(a5)) && !name3.equals(String.valueOf(a6))) {
                                    com.tencent.tbs.one.impl.a.f.a("[%s] Deleting unreferenced component version directory %s", name, file3.getAbsolutePath());
                                    c.a(file3);
                                }
                            } else {
                                String name4 = file3.getName();
                                if (name4.endsWith(".incomplete")) {
                                    if (!new File(file3.getParent(), name4.substring(0, name4.length() - 11)).exists()) {
                                        com.tencent.tbs.one.impl.a.f.a("[%s] Deleting unused incomplete flag file %s", name, file3.getAbsolutePath());
                                        c.a(file3);
                                    }
                                } else if (!name4.endsWith(".failed")) {
                                    com.tencent.tbs.one.impl.a.f.a("[%s] Deleting unknown file %s", name, file3.getAbsolutePath());
                                    c.a(file3);
                                } else if (System.currentTimeMillis() - file3.lastModified() >= Util.MILLSECONDS_OF_DAY) {
                                    com.tencent.tbs.one.impl.a.f.a("[%s] Deleting expired failed flag file %s", name, file3.getAbsolutePath());
                                    c.a(file3);
                                }
                            }
                        }
                    }
                }
            }
            r7.run();
            AppMethodBeat.o(173991);
        } catch (TBSOneException e3) {
            com.tencent.tbs.one.impl.a.f.c("[%s] Failed to parse current DEPS %s", name, " to clean useless components", e3);
            r7.run();
            AppMethodBeat.o(173991);
        }
    }

    public static void e(File file) {
        AppMethodBeat.i(188017);
        File e2 = com.tencent.tbs.one.impl.common.f.e(file, ".incomplete");
        if (!e2.exists()) {
            c.b(e2);
        }
        AppMethodBeat.o(188017);
    }

    public static void f(File file) {
        AppMethodBeat.i(188018);
        File e2 = com.tencent.tbs.one.impl.common.f.e(file, ".incomplete");
        if (e2.exists()) {
            c.c(e2);
        }
        AppMethodBeat.o(188018);
    }

    public static boolean g(File file) {
        AppMethodBeat.i(188019);
        if (!com.tencent.tbs.one.impl.common.f.e(file, ".incomplete").exists()) {
            AppMethodBeat.o(188019);
            return true;
        }
        AppMethodBeat.o(188019);
        return false;
    }

    public static long h(File file) {
        AppMethodBeat.i(188020);
        File e2 = com.tencent.tbs.one.impl.common.f.e(file, ".failed");
        if (e2.exists()) {
            long lastModified = e2.lastModified();
            AppMethodBeat.o(188020);
            return lastModified;
        }
        AppMethodBeat.o(188020);
        return 0;
    }

    public static void i(File file) {
        AppMethodBeat.i(188021);
        c.c(com.tencent.tbs.one.impl.common.f.e(file, ".failed"));
        AppMethodBeat.o(188021);
    }

    public static boolean j(File file) {
        String str;
        AppMethodBeat.i(188022);
        com.tencent.tbs.one.impl.a.f.a("verifyPkgLegality,path=%s", file);
        if (!file.exists()) {
            com.tencent.tbs.one.impl.a.f.a("verify file signature failed,path=", file);
            AppMethodBeat.o(188022);
            return false;
        }
        try {
            JarFile jarFile = new JarFile(file);
            Enumeration<JarEntry> entries = jarFile.entries();
            String str2 = null;
            byte[] bArr = new byte[8192];
            while (entries.hasMoreElements()) {
                JarEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory() && !nextElement.getName().startsWith("META-INF/")) {
                    Certificate[] a2 = a(jarFile, nextElement, bArr);
                    if (a2 != null) {
                        String a3 = a(a2[0].getEncoded());
                        if (str2 == null) {
                            str = a3;
                        } else if (!str2.equals(a3)) {
                            com.tencent.tbs.one.impl.a.f.a("verify file signature failed,origin entry=%s,signature=%s,target=%s", nextElement.getName(), a3, str2);
                            AppMethodBeat.o(188022);
                            return false;
                        } else {
                            str = str2;
                        }
                        str2 = str;
                    } else {
                        com.tencent.tbs.one.impl.a.f.a("verify file signature failed,origin entry=%s,signature is null", nextElement.getName());
                        AppMethodBeat.o(188022);
                        return false;
                    }
                }
            }
            if (str2.equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
                com.tencent.tbs.one.impl.a.f.a("verify file signature success,path=%s", file);
                AppMethodBeat.o(188022);
                return true;
            }
            com.tencent.tbs.one.impl.a.f.a("verify file not success,signature=%s", str2);
            AppMethodBeat.o(188022);
            return false;
        } catch (IOException | CertificateEncodingException e2) {
            com.tencent.tbs.one.impl.a.f.a("verifyPkgLegality failed,exception=%s,stack=", e2, Log.getStackTraceString(e2));
        }
    }
}
