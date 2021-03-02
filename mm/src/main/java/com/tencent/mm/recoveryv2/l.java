package com.tencent.mm.recoveryv2;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.a;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public final class l {
    public static File iU(Context context) {
        AppMethodBeat.i(193882);
        File file = new File(context.getFilesDir().getParentFile(), "MicroMsg/recovery");
        AppMethodBeat.o(193882);
        return file;
    }

    static <T> T checkNotNull(T t, String str) {
        AppMethodBeat.i(193883);
        if (t == null) {
            RuntimeException runtimeException = new RuntimeException(String.valueOf(str));
            AppMethodBeat.o(193883);
            throw runtimeException;
        }
        AppMethodBeat.o(193883);
        return t;
    }

    static boolean cv(Context context, String str) {
        AppMethodBeat.i(193884);
        if (bJ(context) == null || !bJ(context).equals(context.getPackageName() + str)) {
            AppMethodBeat.o(193884);
            return false;
        }
        AppMethodBeat.o(193884);
        return true;
    }

    private static String bJ(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        AppMethodBeat.i(193885);
        int myPid = Process.myPid();
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses();
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid && packageName.equals(runningAppProcessInfo.processName)) {
                    String str = runningAppProcessInfo.processName;
                    AppMethodBeat.o(193885);
                    return str;
                }
            }
        } catch (Exception e2) {
            a.C2043a.log(5, "MicroMsg.recovery.utils", "get proc name by am fail, try pid cmdline");
        }
        byte[] bArr = new byte[128];
        FileInputStream fileInputStream2 = null;
        try {
            FileInputStream fileInputStream3 = new FileInputStream("/proc/" + myPid + "/cmdline");
            try {
                int read = fileInputStream3.read(bArr);
                if (read > 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= read) {
                            break;
                        } else if (bArr[i2] <= 0) {
                            read = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    String str2 = new String(bArr, 0, read);
                    b.closeQuietly(fileInputStream3);
                    AppMethodBeat.o(193885);
                    return str2;
                }
                b.closeQuietly(fileInputStream3);
                AppMethodBeat.o(193885);
                return "";
            } catch (Exception e3) {
                fileInputStream2 = fileInputStream3;
                try {
                    a.C2043a.log(5, "MicroMsg.recovery.utils", "get proc name by pid cmdline fail");
                    b.closeQuietly(fileInputStream2);
                    AppMethodBeat.o(193885);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    b.closeQuietly(fileInputStream);
                    AppMethodBeat.o(193885);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream3;
                b.closeQuietly(fileInputStream);
                AppMethodBeat.o(193885);
                throw th;
            }
        } catch (Exception e4) {
            a.C2043a.log(5, "MicroMsg.recovery.utils", "get proc name by pid cmdline fail");
            b.closeQuietly(fileInputStream2);
            AppMethodBeat.o(193885);
            return "";
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            b.closeQuietly(fileInputStream);
            AppMethodBeat.o(193885);
            throw th;
        }
    }

    static String iV(Context context) {
        AppMethodBeat.i(193886);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                String str = packageInfo.versionName;
                AppMethodBeat.o(193886);
                return str;
            }
            AppMethodBeat.o(193886);
            return null;
        } catch (PackageManager.NameNotFoundException | RuntimeException e2) {
            a.w("MicroMsg.recovery.utils", "get version name fail", e2);
            AppMethodBeat.o(193886);
            return null;
        }
    }

    static int am(long j2, int i2) {
        AppMethodBeat.i(193887);
        if (j2 < -2147483648L || j2 > 2147483647L) {
            a.C2043a.log(5, "MicroMsg.recovery.utils", j2 + " cannot be cast to int without changing its value.");
            AppMethodBeat.o(193887);
            return i2;
        }
        int i3 = (int) j2;
        AppMethodBeat.o(193887);
        return i3;
    }

    static boolean isNumeric(String str) {
        AppMethodBeat.i(193888);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(193888);
            return false;
        } else if (str.startsWith("-")) {
            boolean isDigitsOnly = TextUtils.isDigitsOnly(str.substring(1));
            AppMethodBeat.o(193888);
            return isDigitsOnly;
        } else {
            boolean isDigitsOnly2 = TextUtils.isDigitsOnly(str);
            AppMethodBeat.o(193888);
            return isDigitsOnly2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static Application gNz;

        public static Application gva() {
            AppMethodBeat.i(193874);
            if (gNz == null) {
                gNz = getApplication();
            }
            Application application = gNz;
            AppMethodBeat.o(193874);
            return application;
        }

        private static Application getApplication() {
            Application application;
            AppMethodBeat.i(193875);
            try {
                Method declaredMethod = Class.forName("android.app.AppGlobals").getDeclaredMethod("getInitialApplication", new Class[0]);
                declaredMethod.setAccessible(true);
                application = (Application) declaredMethod.invoke(null, new Object[0]);
            } catch (Exception e2) {
                try {
                    Method declaredMethod2 = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]);
                    declaredMethod2.setAccessible(true);
                    application = (Application) declaredMethod2.invoke(null, new Object[0]);
                } catch (Exception e3) {
                    application = null;
                }
            }
            AppMethodBeat.o(193875);
            return application;
        }
    }

    @SuppressLint({"LongLogTag"})
    public static final class b {
        @SuppressLint({"NewApi"})
        static void closeQuietly(Object obj) {
            AppMethodBeat.i(193876);
            if (obj == null) {
                AppMethodBeat.o(193876);
            } else if (obj instanceof Closeable) {
                try {
                    ((Closeable) obj).close();
                    AppMethodBeat.o(193876);
                } catch (Throwable th) {
                    AppMethodBeat.o(193876);
                }
            } else {
                if (Build.VERSION.SDK_INT >= 19 && (obj instanceof AutoCloseable)) {
                    try {
                        ((AutoCloseable) obj).close();
                        AppMethodBeat.o(193876);
                        return;
                    } catch (Throwable th2) {
                    }
                }
                AppMethodBeat.o(193876);
            }
        }

        public static boolean M(File file) {
            AppMethodBeat.i(193877);
            if (file == null) {
                AppMethodBeat.o(193877);
                return false;
            } else if (file.isDirectory()) {
                boolean N = N(file);
                AppMethodBeat.o(193877);
                return N;
            } else {
                boolean safeDeleteFile = safeDeleteFile(file);
                AppMethodBeat.o(193877);
                return safeDeleteFile;
            }
        }

        private static boolean safeDeleteFile(File file) {
            boolean z = true;
            AppMethodBeat.i(193878);
            if (file == null) {
                AppMethodBeat.o(193878);
            } else if (file.exists()) {
                z = file.delete();
                if (!z) {
                    new StringBuilder("Failed to delete file, try to delete when exit. path: ").append(file.getPath());
                    file.deleteOnExit();
                }
                AppMethodBeat.o(193878);
            } else {
                AppMethodBeat.o(193878);
            }
            return z;
        }

        private static boolean N(File file) {
            File[] listFiles;
            AppMethodBeat.i(193879);
            if (file == null || !file.exists()) {
                AppMethodBeat.o(193879);
                return false;
            }
            if (file.isFile()) {
                safeDeleteFile(file);
            } else if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    N(file2);
                }
                safeDeleteFile(file);
            }
            AppMethodBeat.o(193879);
            return true;
        }

        static void O(File file) {
            AppMethodBeat.i(193880);
            if (file == null) {
                IOException iOException = new IOException("File is null.");
                AppMethodBeat.o(193880);
                throw iOException;
            }
            if (file.exists()) {
                M(file);
            }
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                IOException iOException2 = new IOException("Can not create parent for current file, path = " + file.getAbsolutePath());
                AppMethodBeat.o(193880);
                throw iOException2;
            }
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (!file.createNewFile()) {
                IOException iOException3 = new IOException("Create file fail, file already exists.");
                AppMethodBeat.o(193880);
                throw iOException3;
            }
            AppMethodBeat.o(193880);
        }

        public static File[] P(File file) {
            AppMethodBeat.i(193881);
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    AppMethodBeat.o(193881);
                    return listFiles;
                }
                File[] fileArr = new File[0];
                AppMethodBeat.o(193881);
                return fileArr;
            } catch (Throwable th) {
                File[] fileArr2 = new File[0];
                AppMethodBeat.o(193881);
                return fileArr2;
            }
        }
    }
}
