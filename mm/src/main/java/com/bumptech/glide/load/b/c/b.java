package com.bumptech.glide.load.b.c;

import android.os.Build;
import android.os.StrictMode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* access modifiers changed from: package-private */
public final class b {
    static int availableProcessors() {
        AppMethodBeat.i(77196);
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (Build.VERSION.SDK_INT < 17) {
            availableProcessors = Math.max(pr(), availableProcessors);
        }
        AppMethodBeat.o(77196);
        return availableProcessors;
    }

    private static int pr() {
        int i2;
        AppMethodBeat.i(77197);
        File[] fileArr = null;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            File file = new File("/sys/devices/system/cpu/");
            final Pattern compile = Pattern.compile("cpu[0-9]+");
            fileArr = file.listFiles(new FilenameFilter() {
                /* class com.bumptech.glide.load.b.c.b.AnonymousClass1 */

                public final boolean accept(File file, String str) {
                    AppMethodBeat.i(77195);
                    boolean matches = compile.matcher(str).matches();
                    AppMethodBeat.o(77195);
                    return matches;
                }
            });
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            AppMethodBeat.o(77197);
            throw th;
        }
        if (fileArr != null) {
            i2 = fileArr.length;
        } else {
            i2 = 0;
        }
        int max = Math.max(1, i2);
        AppMethodBeat.o(77197);
        return max;
    }
}
