package com.tencent.thumbplayer.core.downloadproxy.utils;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class TPDLFileSystem {
    public static File getExternalDirectory(Context context) {
        AppMethodBeat.i(210107);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            AppMethodBeat.o(210107);
            return null;
        }
        File file = new File(externalStorageDirectory.getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + context.getPackageName() + File.separator + "files");
        AppMethodBeat.o(210107);
        return file;
    }

    public static File getExternalDirectory(Context context, String str) {
        AppMethodBeat.i(210108);
        File externalDirectory = getExternalDirectory(context);
        if (externalDirectory == null) {
            AppMethodBeat.o(210108);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(externalDirectory.getAbsolutePath()).append(File.separator).append(str);
        File file = new File(sb.toString());
        AppMethodBeat.o(210108);
        return file;
    }

    public static void deleteExternalDirectory(Context context, String str) {
        AppMethodBeat.i(210109);
        TPDLIOUtil.recursiveDelete(getExternalDirectory(context, str));
        AppMethodBeat.o(210109);
    }

    public static File getExternalFile(Context context, String str, String str2) {
        AppMethodBeat.i(210110);
        File externalDirectory = getExternalDirectory(context, str);
        if (externalDirectory == null) {
            AppMethodBeat.o(210110);
            return null;
        }
        File file = new File(externalDirectory, str2);
        AppMethodBeat.o(210110);
        return file;
    }

    public static File getExternalCacheDirectory(Context context) {
        AppMethodBeat.i(210111);
        File externalCacheDir = context.getExternalCacheDir();
        AppMethodBeat.o(210111);
        return externalCacheDir;
    }

    public static File getExternalCacheDirectory(Context context, String str) {
        AppMethodBeat.i(210112);
        File externalCacheDirectory = getExternalCacheDirectory(context);
        if (externalCacheDirectory == null) {
            AppMethodBeat.o(210112);
            return null;
        }
        File file = new File(externalCacheDirectory.getAbsolutePath() + File.separator + str);
        AppMethodBeat.o(210112);
        return file;
    }

    public static File getExternalCacheFile(Context context, String str, String str2) {
        AppMethodBeat.i(210113);
        File externalCacheDirectory = getExternalCacheDirectory(context, str);
        if (externalCacheDirectory == null) {
            AppMethodBeat.o(210113);
            return null;
        }
        File file = new File(externalCacheDirectory, str2);
        AppMethodBeat.o(210113);
        return file;
    }

    public static void clearExternalCache(Context context) {
        AppMethodBeat.i(210114);
        TPDLIOUtil.recursiveDelete(getExternalCacheDirectory(context));
        AppMethodBeat.o(210114);
    }

    public static void clearExternalCache(Context context, String str) {
        AppMethodBeat.i(210115);
        TPDLIOUtil.recursiveDelete(getExternalCacheDirectory(context, str));
        AppMethodBeat.o(210115);
    }

    public static File getInternalDirectory(Context context) {
        AppMethodBeat.i(210116);
        File filesDir = context.getFilesDir();
        AppMethodBeat.o(210116);
        return filesDir;
    }

    public static File getInternalDirectory(Context context, String str) {
        AppMethodBeat.i(210117);
        File internalDirectory = getInternalDirectory(context);
        if (internalDirectory == null) {
            AppMethodBeat.o(210117);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(internalDirectory.getAbsolutePath()).append(File.separator).append(str);
        File file = new File(sb.toString());
        AppMethodBeat.o(210117);
        return file;
    }

    public static void deleteInternalDirectory(Context context, String str) {
        AppMethodBeat.i(210118);
        TPDLIOUtil.recursiveDelete(getInternalDirectory(context, str));
        AppMethodBeat.o(210118);
    }

    public static File getInternalFile(Context context, String str, String str2) {
        AppMethodBeat.i(210119);
        File internalDirectory = getInternalDirectory(context, str);
        if (internalDirectory == null) {
            AppMethodBeat.o(210119);
            return null;
        }
        File file = new File(internalDirectory, str2);
        AppMethodBeat.o(210119);
        return file;
    }

    public static File getInternalCacheDirectory(Context context) {
        AppMethodBeat.i(210120);
        File cacheDir = context.getCacheDir();
        AppMethodBeat.o(210120);
        return cacheDir;
    }

    public static File getInternalCacheDirectory(Context context, String str) {
        AppMethodBeat.i(210121);
        File internalCacheDirectory = getInternalCacheDirectory(context);
        if (internalCacheDirectory == null) {
            AppMethodBeat.o(210121);
            return null;
        }
        File file = new File(internalCacheDirectory.getAbsolutePath() + File.separator + str);
        AppMethodBeat.o(210121);
        return file;
    }

    public static File getInternalCacheFile(Context context, String str, String str2) {
        AppMethodBeat.i(210122);
        File internalCacheDirectory = getInternalCacheDirectory(context, str);
        if (internalCacheDirectory == null) {
            AppMethodBeat.o(210122);
            return null;
        }
        File file = new File(internalCacheDirectory, str2);
        AppMethodBeat.o(210122);
        return file;
    }

    public static void clearInternalCache(Context context) {
        AppMethodBeat.i(210123);
        TPDLIOUtil.recursiveDelete(getInternalCacheDirectory(context));
        AppMethodBeat.o(210123);
    }

    public static void clearInternalCache(Context context, String str) {
        AppMethodBeat.i(210124);
        TPDLIOUtil.recursiveDelete(getInternalCacheDirectory(context, str));
        AppMethodBeat.o(210124);
    }

    public static File getProperFile(Context context, String str, String str2) {
        AppMethodBeat.i(210125);
        if (TPDLIOUtil.isExternalStorageMounted()) {
            File externalFile = getExternalFile(context, str, str2);
            AppMethodBeat.o(210125);
            return externalFile;
        }
        File internalFile = getInternalFile(context, str, str2);
        AppMethodBeat.o(210125);
        return internalFile;
    }

    public static File getProperCacheFile(Context context, String str, String str2) {
        AppMethodBeat.i(210126);
        if (TPDLIOUtil.isExternalStorageMounted()) {
            File externalCacheFile = getExternalCacheFile(context, str, str2);
            AppMethodBeat.o(210126);
            return externalCacheFile;
        }
        File internalCacheFile = getInternalCacheFile(context, str, str2);
        AppMethodBeat.o(210126);
        return internalCacheFile;
    }

    public static void clearCache(Context context) {
        AppMethodBeat.i(210127);
        clearInternalCache(context);
        clearExternalCache(context);
        AppMethodBeat.o(210127);
    }

    public static void clearCache(Context context, String str) {
        AppMethodBeat.i(210128);
        clearInternalCache(context, str);
        clearExternalCache(context, str);
        AppMethodBeat.o(210128);
    }

    public static void deleteDirectory(Context context, String str) {
        AppMethodBeat.i(210129);
        deleteInternalDirectory(context, str);
        deleteExternalDirectory(context, str);
        AppMethodBeat.o(210129);
    }

    public static File getNewerFile(Context context, String str, String str2) {
        AppMethodBeat.i(210130);
        File compare = TPDLIOUtil.compare(getInternalFile(context, str, str2), getExternalFile(context, str, str2));
        AppMethodBeat.o(210130);
        return compare;
    }

    public static File getNewerCacheFile(Context context, String str, String str2) {
        AppMethodBeat.i(210131);
        File compare = TPDLIOUtil.compare(getInternalCacheFile(context, str, str2), getExternalCacheFile(context, str, str2));
        AppMethodBeat.o(210131);
        return compare;
    }

    public static File getProperCacheDirectory(Context context, String str) {
        AppMethodBeat.i(210132);
        if (TPDLIOUtil.isExternalStorageMounted()) {
            File externalCacheDirectory = getExternalCacheDirectory(context, str);
            AppMethodBeat.o(210132);
            return externalCacheDirectory;
        }
        File internalCacheDirectory = getInternalCacheDirectory(context, str);
        AppMethodBeat.o(210132);
        return internalCacheDirectory;
    }

    public static File getProperDirectory(Context context, String str) {
        AppMethodBeat.i(210133);
        if (TPDLIOUtil.isExternalStorageMounted()) {
            File externalDirectory = getExternalDirectory(context, str);
            AppMethodBeat.o(210133);
            return externalDirectory;
        }
        File internalDirectory = getInternalDirectory(context, str);
        AppMethodBeat.o(210133);
        return internalDirectory;
    }
}
