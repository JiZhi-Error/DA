package com.tencent.midas.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import java.io.File;
import java.util.HashMap;

public class APPluginChecker {
    private static final String TAG = "APPluginChecker";

    public static boolean isPluginValid(Context context) {
        AppMethodBeat.i(193121);
        APLog.d(TAG, "Calling into isPluginValid " + Thread.currentThread().getStackTrace()[3].toString());
        boolean isAllPluginValid = isAllPluginValid(APPluginConfig.getPluginPath(context));
        AppMethodBeat.o(193121);
        return isAllPluginValid;
    }

    private static boolean isAllPluginValid(File file) {
        int i2;
        AppMethodBeat.i(193122);
        if (file == null) {
            APLog.e(TAG, "Cannot check all plugin valid, pluginPath is null!");
            AppMethodBeat.o(193122);
            return false;
        }
        APLog.d(TAG, "Check all plugin valid, parameter ok!");
        try {
            File file2 = new File(file.getCanonicalPath() + File.separator + APPluginConfig.SIGN_FILE_NAME);
            if (!file2.exists()) {
                APLog.e(TAG, "Check all plugin valid, sign file is not found");
                AppMethodBeat.o(193122);
                return false;
            }
            APLog.d(TAG, "Check all plugin valid, sign file exist!");
            HashMap hashMap = new HashMap();
            APPluginUtils.readSingInfo(hashMap, file2);
            File[] listFiles = file.listFiles();
            int i3 = 0;
            int i4 = 0;
            while (i3 < listFiles.length) {
                File file3 = listFiles[i3];
                String name = file3.getName();
                APLog.d(TAG, "Check all plugin valid, current check file = ".concat(String.valueOf(name)));
                if (name.startsWith("MidasSign") || !name.startsWith("Midas")) {
                    APLog.d(TAG, "Check all plugin valid, ignore = ".concat(String.valueOf(name)));
                    i2 = i4;
                } else {
                    String str = (String) hashMap.get(name.split("\\_")[0]);
                    if (TextUtils.isEmpty(str)) {
                        i2 = i4;
                    } else if (!APPluginUtils.checkFileMD5(file3.getCanonicalPath(), str)) {
                        APLog.d(TAG, "Check all plugin valid, current check file = " + name + ", MD5 not OK");
                        file3.delete();
                        i2 = i4;
                    } else {
                        i2 = i4 + 1;
                        APLog.d(TAG, "Check all plugin valid, current check file = " + name + ", MD5 OK");
                    }
                }
                i3++;
                i4 = i2;
            }
            if (i4 != hashMap.size() || i4 < 2) {
                APLog.e(TAG, "Check all plugin valid, all valid file num = " + i4 + ", but sign file size = " + hashMap.size() + ", check fail!");
                AppMethodBeat.o(193122);
                return false;
            }
            APLog.d(TAG, "Check all plugin valid, all valid file num = " + i4 + ", sign file size = " + hashMap.size() + ", check success!");
            AppMethodBeat.o(193122);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(193122);
            return false;
        }
    }
}
