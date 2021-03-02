package com.tencent.mm.plugin.wepkg.downloader;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.net.HttpURLConnection;
import java.util.concurrent.Future;
import javax.net.ssl.SSLContext;

public final class c implements Runnable {
    f JLZ;
    HttpURLConnection JMa;
    private String JMb;
    private String JMc;
    private String JMd;
    boolean JMe;
    private boolean JMf;
    private boolean JMg = false;
    Future<?> jKp;
    private String mContentType;
    private int mStatusCode;
    private int retCode = 0;

    public c(f fVar) {
        this.JLZ = fVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00e6, code lost:
        r1 = bcs("TLSv1");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 765
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wepkg.downloader.c.run():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x01af A[Catch:{ all -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0252  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void gkK() {
        /*
        // Method dump skipped, instructions count: 710
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wepkg.downloader.c.gkK():void");
    }

    private static SSLContext bcs(String str) {
        AppMethodBeat.i(110594);
        try {
            SSLContext instance = SSLContext.getInstance(str);
            AppMethodBeat.o(110594);
            return instance;
        } catch (Exception e2) {
            AppMethodBeat.o(110594);
            return null;
        }
    }

    private static int bct(String str) {
        String[] split;
        AppMethodBeat.i(110595);
        if (!TextUtils.isEmpty(str) && (split = str.split(FilePathGenerator.ANDROID_DIR_SEP)) != null && split.length == 2) {
            try {
                int intValue = Integer.valueOf(split[1]).intValue();
                AppMethodBeat.o(110595);
                return intValue;
            } catch (NumberFormatException e2) {
            }
        }
        AppMethodBeat.o(110595);
        return -1;
    }

    private static long bcu(String str) {
        AppMethodBeat.i(110596);
        if (!TextUtils.isEmpty(str)) {
            try {
                long longValue = Long.valueOf(str).longValue();
                AppMethodBeat.o(110596);
                return longValue;
            } catch (NumberFormatException e2) {
            }
        }
        AppMethodBeat.o(110596);
        return -1;
    }
}
