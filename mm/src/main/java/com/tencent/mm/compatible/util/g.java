package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;

public final class g {
    private static Boolean gLn = null;
    private static Boolean isMIUI = null;
    private static Boolean isMIUIV8 = null;

    public static File getExternalStorageDirectory() {
        AppMethodBeat.i(155884);
        if (Util.isNullOrNil(ae.gKE.gHw)) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            AppMethodBeat.o(155884);
            return externalStorageDirectory;
        }
        File file = new File(ae.gKE.gHw);
        AppMethodBeat.o(155884);
        return file;
    }

    @TargetApi(8)
    public static File getExternalStoragePublicDirectory(String str) {
        AppMethodBeat.i(155885);
        if (Util.isNullOrNil(ae.gKE.gHx)) {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(str);
            AppMethodBeat.o(155885);
            return externalStoragePublicDirectory;
        }
        File file = new File(ae.gKE.gHx);
        AppMethodBeat.o(155885);
        return file;
    }

    public static File getDataDirectory() {
        AppMethodBeat.i(155886);
        if (Util.isNullOrNil(ae.gKE.gHy)) {
            File dataDirectory = Environment.getDataDirectory();
            AppMethodBeat.o(155886);
            return dataDirectory;
        }
        File file = new File(ae.gKE.gHy);
        AppMethodBeat.o(155886);
        return file;
    }

    public static File getRootDirectory() {
        AppMethodBeat.i(155887);
        if (Util.isNullOrNil(ae.gKE.gHz)) {
            File rootDirectory = Environment.getRootDirectory();
            AppMethodBeat.o(155887);
            return rootDirectory;
        }
        File file = new File(ae.gKE.gHz);
        AppMethodBeat.o(155887);
        return file;
    }

    public static File getDownloadCacheDirectory() {
        AppMethodBeat.i(155888);
        if (Util.isNullOrNil(ae.gKE.gHB)) {
            File downloadCacheDirectory = Environment.getDownloadCacheDirectory();
            AppMethodBeat.o(155888);
            return downloadCacheDirectory;
        }
        File file = new File(ae.gKE.gHB);
        AppMethodBeat.o(155888);
        return file;
    }

    public static String getExternalStorageState() {
        AppMethodBeat.i(155889);
        if (Util.isNullOrNil(ae.gKE.gHA)) {
            String externalStorageState = Environment.getExternalStorageState();
            AppMethodBeat.o(155889);
            return externalStorageState;
        }
        String str = ae.gKE.gHA;
        AppMethodBeat.o(155889);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052 A[SYNTHETIC, Splitter:B:17:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c A[SYNTHETIC, Splitter:B:23:0x005c] */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isMIUI() {
        /*
        // Method dump skipped, instructions count: 107
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.util.g.isMIUI():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005a A[SYNTHETIC, Splitter:B:17:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064 A[SYNTHETIC, Splitter:B:23:0x0064] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isMIUIV8() {
        /*
        // Method dump skipped, instructions count: 115
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.util.g.isMIUIV8():boolean");
    }

    public static int aps() {
        return 4;
    }
}
