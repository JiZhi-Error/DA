package com.tencent.smtt.export.external;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.io.File;
import java.util.ArrayList;

public class LibraryLoader {
    private static String[] sLibrarySearchPaths = null;

    public static String[] getLibrarySearchPaths(Context context) {
        AppMethodBeat.i(53150);
        if (sLibrarySearchPaths != null) {
            String[] strArr = sLibrarySearchPaths;
            AppMethodBeat.o(53150);
            return strArr;
        } else if (context == null) {
            String[] strArr2 = {"/system/lib"};
            AppMethodBeat.o(53150);
            return strArr2;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(getNativeLibraryDir(context));
            arrayList.add("/system/lib");
            String[] strArr3 = new String[arrayList.size()];
            arrayList.toArray(strArr3);
            sLibrarySearchPaths = strArr3;
            AppMethodBeat.o(53150);
            return strArr3;
        }
    }

    public static String getNativeLibraryDir(Context context) {
        AppMethodBeat.i(53151);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 9) {
            String str = context.getApplicationInfo().nativeLibraryDir;
            AppMethodBeat.o(53151);
            return str;
        } else if (i2 >= 4) {
            String str2 = context.getApplicationInfo().dataDir + "/lib";
            AppMethodBeat.o(53151);
            return str2;
        } else {
            String str3 = "/data/data/" + context.getPackageName() + "/lib";
            AppMethodBeat.o(53151);
            return str3;
        }
    }

    public static void loadLibrary(Context context, String str) {
        AppMethodBeat.i(53152);
        String[] librarySearchPaths = getLibrarySearchPaths(context);
        String mapLibraryName = System.mapLibraryName(str);
        int length = librarySearchPaths.length;
        for (int i2 = 0; i2 < length; i2++) {
            String str2 = librarySearchPaths[i2] + FilePathGenerator.ANDROID_DIR_SEP + mapLibraryName;
            if (new File(str2).exists()) {
                try {
                    System.load(str2);
                    AppMethodBeat.o(53152);
                    return;
                } catch (Exception e2) {
                    AppMethodBeat.o(53152);
                    return;
                }
            }
        }
        try {
            System.loadLibrary(str);
            AppMethodBeat.o(53152);
        } catch (Exception e3) {
            AppMethodBeat.o(53152);
        }
    }
}
