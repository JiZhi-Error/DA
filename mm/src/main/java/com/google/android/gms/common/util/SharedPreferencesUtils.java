package com.google.android.gms.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class SharedPreferencesUtils {
    private SharedPreferencesUtils() {
    }

    @Deprecated
    public static void publishWorldReadableSharedPreferences(Context context, SharedPreferences.Editor editor, String str) {
        AppMethodBeat.i(5288);
        File file = new File(context.getApplicationInfo().dataDir, "shared_prefs");
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.setExecutable(true, false);
        }
        file.setExecutable(true, false);
        editor.commit();
        new File(file, String.valueOf(str).concat(".xml")).setReadable(true, false);
        AppMethodBeat.o(5288);
    }
}
