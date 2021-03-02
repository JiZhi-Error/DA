package com.tencent.youtu.sdkkitframework.common;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class FileUtils {
    private static final String TAG = FileUtils.class.getSimpleName();
    private static Map<String, String> mLoadedLibrary = new HashMap();

    static {
        AppMethodBeat.i(192557);
        AppMethodBeat.o(192557);
    }

    private FileUtils() {
        AppMethodBeat.i(192550);
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(192550);
        throw assertionError;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0055 A[SYNTHETIC, Splitter:B:16:0x0055] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.StringBuilder readAssetFile(android.content.Context r6, java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 131
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.youtu.sdkkitframework.common.FileUtils.readAssetFile(android.content.Context, java.lang.String):java.lang.StringBuilder");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f A[SYNTHETIC, Splitter:B:20:0x005f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.StringBuilder readFile(java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 142
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.youtu.sdkkitframework.common.FileUtils.readFile(java.lang.String):java.lang.StringBuilder");
    }

    public static boolean copyAsset(AssetManager assetManager, String str, String str2) {
        AppMethodBeat.i(192553);
        try {
            InputStream open = assetManager.open(str);
            new File(str2).createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            copyFile(open, fileOutputStream);
            open.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            AppMethodBeat.o(192553);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(192553);
            return false;
        }
    }

    public static void copyFileOrDir(AssetManager assetManager, String str, String str2) {
        AppMethodBeat.i(192554);
        try {
            String[] list = assetManager.list(str);
            if (list.length == 0) {
                copyAsset(assetManager, str, str2 + FilePathGenerator.ANDROID_DIR_SEP + str);
                AppMethodBeat.o(192554);
                return;
            }
            File file = new File(str2.endsWith(File.separator) ? str2 + str : str2 + File.separator + str);
            if (!file.exists()) {
                file.mkdir();
            }
            for (int i2 = 0; i2 < list.length; i2++) {
                copyFileOrDir(assetManager, str + FilePathGenerator.ANDROID_DIR_SEP + list[i2], str2);
            }
            AppMethodBeat.o(192554);
        } catch (IOException e2) {
            YtLogger.e("tag", "I/O Exception".concat(String.valueOf(e2)));
            AppMethodBeat.o(192554);
        }
    }

    public static void copyFile(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(192555);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                AppMethodBeat.o(192555);
                return;
            }
        }
    }

    public static void loadLibrary(String str) {
        AppMethodBeat.i(192556);
        if (mLoadedLibrary.get(str) == null) {
            YtLogger.i(TAG, "[YTUtils.loadLibrary] " + System.getProperty("java.library.path"));
            try {
                System.loadLibrary(str);
            } catch (Exception e2) {
                YtLogger.e(TAG, "Load " + str + " failed:" + e2.getLocalizedMessage());
            }
            mLoadedLibrary.put(str, "loaded");
        }
        AppMethodBeat.o(192556);
    }
}
