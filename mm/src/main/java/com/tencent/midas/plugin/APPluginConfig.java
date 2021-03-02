package com.tencent.midas.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class APPluginConfig {
    static final String KERNEL_FILE_NAME = "MidasPay.zip";
    static String PLUGIN_BACKUP_TEMP_DIR_NAME = "midaspluginsBKTemp";
    public static String PLUGIN_DIR_NAME = "midasplugins";
    static String PLUGIN_EMPTY_RES_DIR_NAME = "midasemptyRes";
    static String PLUGIN_LIB_DIR_NAME = "midaslib";
    static String PLUGIN_ODEX_DIR_NAME = "midasodex";
    static String PLUGIN_UPDATE_DIR_NAME = "midaspluginsTemp";
    static String SIGN_FILE_NAME = "MidasSign.ini";
    static int libExtend = 0;

    public static void setSignFileName(String str) {
        AppMethodBeat.i(193030);
        if (!TextUtils.isEmpty(str)) {
            SIGN_FILE_NAME = str;
        }
        AppMethodBeat.o(193030);
    }

    public static void setPluginDirName(String str) {
        AppMethodBeat.i(193031);
        if (!TextUtils.isEmpty(str)) {
            PLUGIN_DIR_NAME = str;
        }
        AppMethodBeat.o(193031);
    }

    public static File getPluginPath(Context context) {
        AppMethodBeat.i(193032);
        File dir = context.getDir(PLUGIN_DIR_NAME, 0);
        AppMethodBeat.o(193032);
        return dir;
    }

    static File getPluginBackUpPath(Context context) {
        AppMethodBeat.i(193033);
        File dir = context.getDir(PLUGIN_BACKUP_TEMP_DIR_NAME, 0);
        AppMethodBeat.o(193033);
        return dir;
    }

    static File getOptimizedDexPath(Context context) {
        AppMethodBeat.i(193034);
        File dir = context.getDir(PLUGIN_ODEX_DIR_NAME, 0);
        AppMethodBeat.o(193034);
        return dir;
    }

    public static File getLibPath(Context context) {
        AppMethodBeat.i(193035);
        File dir = context.getDir(PLUGIN_LIB_DIR_NAME + "_" + libExtend, 0);
        AppMethodBeat.o(193035);
        return dir;
    }

    static File getPluginUpdatePath(Context context) {
        AppMethodBeat.i(193036);
        File dir = context.getDir(PLUGIN_UPDATE_DIR_NAME, 0);
        AppMethodBeat.o(193036);
        return dir;
    }

    static File getPluginEmptyResPath(Context context) {
        AppMethodBeat.i(193037);
        File dir = context.getDir(PLUGIN_EMPTY_RES_DIR_NAME, 0);
        AppMethodBeat.o(193037);
        return dir;
    }
}
