package com.tencent.tbs.one.impl.common;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;

public final class f {
    public static File a(Context context) {
        AppMethodBeat.i(174236);
        if (Build.VERSION.SDK_INT >= 9) {
            File file = new File(context.getApplicationInfo().nativeLibraryDir);
            AppMethodBeat.o(174236);
            return file;
        } else if (Build.VERSION.SDK_INT > 4) {
            File file2 = new File(context.getApplicationInfo().dataDir, ShareConstants.SO_PATH);
            AppMethodBeat.o(174236);
            return file2;
        } else {
            File file3 = new File(context.getFilesDir().getParentFile(), ShareConstants.SO_PATH);
            AppMethodBeat.o(174236);
            return file3;
        }
    }

    public static File a(Context context, Context context2, String str, String str2, int i2) {
        File file;
        AppMethodBeat.i(187999);
        if (context == context2) {
            file = context.getExternalFilesDir("tbs");
        } else {
            if (context.getPackageManager().checkPermission("android.permission.READ_EXTERNAL_STORAGE", context.getPackageName()) == 0) {
                String packageName = context2.getPackageName();
                if (Environment.getExternalStorageState().equals("mounted")) {
                    file = new File(Environment.getExternalStorageDirectory(), "Android/data/" + packageName + "/files/tbs");
                }
            }
            file = null;
        }
        File file2 = file != null ? new File(new File(file, str), str2) : null;
        if (file2 != null) {
            File file3 = new File(file2, String.valueOf(i2));
            AppMethodBeat.o(187999);
            return file3;
        }
        AppMethodBeat.o(187999);
        return null;
    }

    public static File a(File file) {
        AppMethodBeat.i(174237);
        File file2 = new File(file, "home");
        AppMethodBeat.o(174237);
        return file2;
    }

    public static File a(File file, int i2) {
        AppMethodBeat.i(174247);
        File file2 = new File(new File(file, "proc"), String.valueOf(i2));
        AppMethodBeat.o(174247);
        return file2;
    }

    public static File a(File file, String str) {
        AppMethodBeat.i(174238);
        File file2 = new File(a(file), str);
        AppMethodBeat.o(174238);
        return file2;
    }

    public static File a(File file, String str, int i2) {
        AppMethodBeat.i(174243);
        File file2 = new File(b(file, str), String.valueOf(i2));
        AppMethodBeat.o(174243);
        return file2;
    }

    public static File a(File file, String str, String str2) {
        AppMethodBeat.i(174245);
        String str3 = "libtbs=" + Base64.encodeToString((str + File.separator + str2).getBytes(b.f2545a), 2) + ".so";
        File file2 = new File(file, str3);
        if (!file2.exists()) {
            String str4 = "libtbs" + str2 + ".so";
            file2 = new File(file, str4);
            if (!file2.exists()) {
                file2 = new File(file, str2);
                if (!file2.exists()) {
                    com.tencent.tbs.one.impl.a.f.b("Failed to find component file %s or %s or %s in native library directory", file2.getAbsolutePath(), str4, str3);
                }
            }
        }
        AppMethodBeat.o(174245);
        return file2;
    }

    public static File b(Context context) {
        AppMethodBeat.i(174246);
        File file = new File(context.getDir("tbs", 0), "proc");
        AppMethodBeat.o(174246);
        return file;
    }

    public static File b(File file) {
        AppMethodBeat.i(174239);
        File file2 = new File(file, "DEPS");
        AppMethodBeat.o(174239);
        return file2;
    }

    public static File b(File file, String str) {
        AppMethodBeat.i(174242);
        File file2 = new File(d(file), str);
        AppMethodBeat.o(174242);
        return file2;
    }

    public static File c(File file) {
        AppMethodBeat.i(174240);
        File file2 = new File(file, "DEPS.latest");
        AppMethodBeat.o(174240);
        return file2;
    }

    public static File c(File file, String str) {
        AppMethodBeat.i(174244);
        String str2 = "libtbs" + str + "DEPS.so";
        File file2 = new File(file, str2);
        if (!file2.exists()) {
            file2 = new File(file, "libtbsDEPS.so");
            if (!file2.exists()) {
                com.tencent.tbs.one.impl.a.f.b("Failed to find DEPS file %s or %s in native library directory", file2.getAbsolutePath(), str2);
            }
        }
        AppMethodBeat.o(174244);
        return file2;
    }

    public static File d(File file) {
        AppMethodBeat.i(174241);
        File file2 = new File(file, "components");
        AppMethodBeat.o(174241);
        return file2;
    }

    public static File d(File file, String str) {
        AppMethodBeat.i(174248);
        File file2 = new File(file, str);
        AppMethodBeat.o(174248);
        return file2;
    }

    public static File e(File file, String str) {
        AppMethodBeat.i(174249);
        File file2 = new File(file.getParent(), file.getName() + str);
        AppMethodBeat.o(174249);
        return file2;
    }
}
