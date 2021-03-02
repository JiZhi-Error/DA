package com.tencent.mm.plugin.ai.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.io.File;

public final class c {
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0074 A[SYNTHETIC, Splitter:B:22:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007c A[Catch:{ IOException -> 0x00f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c1 A[SYNTHETIC, Splitter:B:38:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c9 A[Catch:{ IOException -> 0x00ff }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean cg(java.lang.String r10, java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 286
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ai.d.a.c.cg(java.lang.String, java.lang.String):boolean");
    }

    private static void ch(String str, String str2) {
        AppMethodBeat.i(238909);
        String[] split = str.split(FilePathGenerator.ANDROID_DIR_SEP);
        if (split.length <= 1) {
            AppMethodBeat.o(238909);
            return;
        }
        for (int i2 = 0; i2 < split.length - 1; i2++) {
            str2 = str2 + split[i2] + FilePathGenerator.ANDROID_DIR_SEP;
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        AppMethodBeat.o(238909);
    }
}
