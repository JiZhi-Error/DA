package com.tencent.midas.comm.log;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APLogInfo;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.io.File;

public class APLogFileInfo {
    public static String dirName = "";
    public static String fileName = "";
    public static String mmapName = "";

    public static void create() {
        AppMethodBeat.i(193403);
        try {
            dirName = buildDirName();
            fileName = buildFileName(true);
            mmapName = buildMmapName();
            new StringBuilder("log dir: ").append(dirName);
            new StringBuilder("log file: ").append(fileName);
            AppMethodBeat.o(193403);
        } catch (Throwable th) {
            new StringBuilder("file info create error: ").append(th.toString());
            AppMethodBeat.o(193403);
        }
    }

    private static String buildMmapName() {
        AppMethodBeat.i(193404);
        String str = dirName + File.separator + "MidasLog.mmap";
        AppMethodBeat.o(193404);
        return str;
    }

    private static String buildDirName() {
        AppMethodBeat.i(193405);
        APLogInfo logInfo = APLog.getLogInfo();
        if (logInfo == null || logInfo.getLogPath() == null) {
            AppMethodBeat.o(193405);
            return "";
        }
        String logPath = logInfo.getLogPath();
        if (!logPath.endsWith(File.separator)) {
            logPath = logPath + File.separator;
        }
        String str = logPath + logInfo.getPkgName() + File.separator;
        if (!TextUtils.isEmpty(logInfo.getProcessName())) {
            str = str + logInfo.getProcessName() + File.separator;
        }
        AppMethodBeat.o(193405);
        return str;
    }

    private static int buildFileNumber(String str) {
        int i2 = 1;
        AppMethodBeat.i(193406);
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(APLogFileUtil.getToday() + "_");
                if (split.length > 1) {
                    i2 = Integer.parseInt(split[1].split(".txt")[0]) + 1;
                }
            } catch (Throwable th) {
                new StringBuilder("build file number error: ").append(th.getMessage());
            }
        }
        AppMethodBeat.o(193406);
        return i2;
    }

    public static void updateFileName() {
        AppMethodBeat.i(193407);
        fileName = buildFileName(false);
        new StringBuilder("update file name: ").append(fileName);
        AppMethodBeat.o(193407);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String buildFileName(boolean r5) {
        /*
        // Method dump skipped, instructions count: 131
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.comm.log.APLogFileInfo.buildFileName(boolean):java.lang.String");
    }
}
