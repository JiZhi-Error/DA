package com.danikula.videocache;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class StorageUtils {
    private static final String INDIVIDUAL_DIR_NAME = "video-cache";

    static File getIndividualCacheDirectory(Context context) {
        AppMethodBeat.i(223199);
        File file = new File(getCacheDirectory(context), INDIVIDUAL_DIR_NAME);
        AppMethodBeat.o(223199);
        return file;
    }

    private static File getCacheDirectory(Context context) {
        AppMethodBeat.i(223200);
        File file = null;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            file = context.getExternalCacheDir();
        }
        if (file == null) {
            file = context.getCacheDir();
        }
        if (file == null) {
            file = new File("/data/data/" + context.getPackageName() + "/cache/");
        }
        AppMethodBeat.o(223200);
        return file;
    }

    public static boolean deleteFiles(File file) {
        AppMethodBeat.i(223201);
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (!file2.isDirectory() && file2.exists() && !file2.delete()) {
                    AppMethodBeat.o(223201);
                    return false;
                }
            }
        }
        AppMethodBeat.o(223201);
        return true;
    }

    public static boolean deleteFile(String str) {
        AppMethodBeat.i(223202);
        File file = new File(str);
        if (!file.exists()) {
            AppMethodBeat.o(223202);
            return true;
        } else if (file.isFile()) {
            boolean delete = file.delete();
            AppMethodBeat.o(223202);
            return delete;
        } else {
            String[] list = file.list();
            if (list != null) {
                int length = list.length;
                for (int i2 = 0; i2 < length; i2++) {
                    deleteFile(str + File.separator + list[i2]);
                }
            }
            boolean delete2 = file.delete();
            AppMethodBeat.o(223202);
            return delete2;
        }
    }
}
