package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.FileFilter;

public class m {
    private static File c(Context context) {
        AppMethodBeat.i(54012);
        File file = new File(QbSdk.getTbsFolderDir(context), "core_share");
        if (!file.isDirectory() || !file.exists()) {
            AppMethodBeat.o(54012);
            return null;
        }
        AppMethodBeat.o(54012);
        return file;
    }

    public static boolean a(Context context) {
        AppMethodBeat.i(54013);
        boolean z = true;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            z = b(context);
        }
        AppMethodBeat.o(54013);
        return z;
    }

    public static boolean b(Context context) {
        AppMethodBeat.i(54014);
        try {
            if (Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT > 25) {
                AppMethodBeat.o(54014);
                return true;
            }
            File c2 = c(context);
            if (c2 == null) {
                AppMethodBeat.o(54014);
                return true;
            }
            File[] listFiles = c2.listFiles(new FileFilter() {
                /* class com.tencent.smtt.utils.m.AnonymousClass1 */

                public final boolean accept(File file) {
                    AppMethodBeat.i(53958);
                    String name = file.getName();
                    if (TextUtils.isEmpty(name) || !name.endsWith(ShareConstants.DEX_SUFFIX)) {
                        AppMethodBeat.o(53958);
                        return false;
                    }
                    AppMethodBeat.o(53958);
                    return true;
                }
            });
            for (File file : listFiles) {
                if (file.isFile() && file.exists()) {
                    if (a(file)) {
                        TbsLog.w("TbsCheckUtils", file + " is invalid --> check failed!");
                        file.delete();
                        AppMethodBeat.o(54014);
                        return false;
                    }
                    TbsLog.i("TbsCheckUtils", file + " #4 check success!");
                }
            }
            TbsLog.i("TbsCheckUtils", "checkTbsValidity -->#5 check ok!");
            AppMethodBeat.o(54014);
            return true;
        } catch (Throwable th) {
        }
    }

    private static boolean a(File file) {
        AppMethodBeat.i(54015);
        try {
            if (!e.b(file)) {
                AppMethodBeat.o(54015);
                return true;
            }
        } catch (Throwable th) {
            new StringBuilder("isOatFileBroken exception: ").append(th);
        }
        AppMethodBeat.o(54015);
        return false;
    }
}
