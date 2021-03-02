package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;

public class q {

    /* renamed from: a  reason: collision with root package name */
    private static File f2296a = null;

    public static long a() {
        AppMethodBeat.i(54010);
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        AppMethodBeat.o(54010);
        return availableBlocks;
    }

    @TargetApi(9)
    public static boolean a(Context context) {
        AppMethodBeat.i(54011);
        if (context == null) {
            AppMethodBeat.o(54011);
            return false;
        } else if (f2296a == null) {
            try {
                if (!context.getApplicationInfo().processName.contains("com.tencent.mm")) {
                    AppMethodBeat.o(54011);
                    return false;
                }
                File tbsFolderDir = QbSdk.getTbsFolderDir(context);
                if (tbsFolderDir == null || !tbsFolderDir.isDirectory()) {
                    AppMethodBeat.o(54011);
                    return false;
                }
                File file = new File(tbsFolderDir, "share");
                if (file.isDirectory() || file.mkdir()) {
                    f2296a = file;
                    file.setExecutable(true, false);
                    AppMethodBeat.o(54011);
                    return true;
                }
                AppMethodBeat.o(54011);
                return false;
            } catch (Exception e2) {
                AppMethodBeat.o(54011);
                return false;
            }
        } else {
            AppMethodBeat.o(54011);
            return true;
        }
    }
}
