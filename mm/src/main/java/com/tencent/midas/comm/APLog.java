package com.tencent.midas.comm;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.APLogFileInfo;
import com.tencent.midas.comm.log.internal.APLogger;
import com.tencent.midas.comm.log.util.APLogDataReporter;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.midas.data.APMidasPluginInfo;

public class APLog {
    @SuppressLint({"StaticFieldLeak"})
    private static APLogInfo logInfo = new APLogInfo();
    private static APLogger logger = null;
    private static boolean shouldPrintLog = true;
    private static boolean shouldWriteLog = false;

    static {
        AppMethodBeat.i(193390);
        AppMethodBeat.o(193390);
    }

    private APLog() {
    }

    public static void init(APLogInfo aPLogInfo) {
        AppMethodBeat.i(193370);
        if (aPLogInfo == null) {
            AppMethodBeat.o(193370);
            return;
        }
        try {
            APLogDataReporter.getInstance().report(APMidasPluginInfo.LAUNCH_INTERFACE_INIT, APLogDataReporter.MIDAS_LOG_INIT, "");
            logInfo = aPLogInfo;
            aPLogInfo.init();
            APLogFileInfo.create();
            APLogFileUtil.readLogKeepConf(logInfo.getContext());
            shouldPrintLog = logInfo.shouldPrintLog();
            if (APLogFileUtil.initLogDir(APLogFileInfo.dirName)) {
                shouldWriteLog = logInfo.isWriteLog();
                logger = APLogger.open();
            }
            AppMethodBeat.o(193370);
        } catch (Throwable th) {
            APLogDataReporter.getInstance().report(APMidasPluginInfo.LAUNCH_INTERFACE_INIT, APLogDataReporter.MIDAS_LOG_ERROR_INIT, th.getClass().getName() + th.getMessage());
            new StringBuilder("Log init failed: ").append(th.toString());
            AppMethodBeat.o(193370);
        }
    }

    public static APLogInfo getLogInfo() {
        return logInfo;
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(193371);
        String composeLogMsg = composeLogMsg(str, str2);
        if (shouldPrintLog) {
            APLogger.log(3, logInfo.getLogTag(), composeLogMsg);
        }
        writeLog(composeLogMsg);
        AppMethodBeat.o(193371);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(193372);
        i(str, String.format(str2, objArr));
        AppMethodBeat.o(193372);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(193373);
        String composeLogMsg = composeLogMsg(str, str2);
        if (shouldPrintLog) {
            APLogger.log(2, logInfo.getLogTag(), composeLogMsg);
        }
        writeLog(composeLogMsg);
        AppMethodBeat.o(193373);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(193374);
        d(str, String.format(str2, objArr));
        AppMethodBeat.o(193374);
    }

    public static void v(String str, String str2) {
        AppMethodBeat.i(193375);
        String composeLogMsg = composeLogMsg(str, str2);
        if (shouldPrintLog) {
            APLogger.log(1, logInfo.getLogTag(), composeLogMsg);
        }
        writeLog(composeLogMsg);
        AppMethodBeat.o(193375);
    }

    public static void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(193376);
        v(str, String.format(str2, objArr));
        AppMethodBeat.o(193376);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(193377);
        String composeLogMsg = composeLogMsg(str, str2);
        if (shouldPrintLog) {
            APLogger.log(4, logInfo.getLogTag(), composeLogMsg);
        }
        writeLog(composeLogMsg);
        AppMethodBeat.o(193377);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(193378);
        w(str, String.format(str2, objArr));
        AppMethodBeat.o(193378);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(193379);
        String composeLogMsg = composeLogMsg(str, str2);
        if (shouldPrintLog) {
            APLogger.log(5, logInfo.getLogTag(), composeLogMsg);
        }
        writeLog(composeLogMsg);
        AppMethodBeat.o(193379);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(193380);
        e(str, String.format(str2, objArr));
        AppMethodBeat.o(193380);
    }

    public static void s(boolean z, String str, String str2) {
        AppMethodBeat.i(193381);
        String composeLogMsg = composeLogMsg(str, str2);
        if (shouldPrintLog && !z) {
            APLogger.log(6, logInfo.getLogTag(), composeLogMsg);
        }
        writeLog(composeLogMsg);
        AppMethodBeat.o(193381);
    }

    public static void s(boolean z, String str, String str2, Object... objArr) {
        AppMethodBeat.i(193382);
        s(z, str, String.format(str2, objArr));
        AppMethodBeat.o(193382);
    }

    public static void s(String str, String str2) {
        AppMethodBeat.i(193383);
        writeLog(composeLogMsg(str, str2));
        AppMethodBeat.o(193383);
    }

    public static void s(String str, String str2, Object... objArr) {
        AppMethodBeat.i(193384);
        s(str, String.format(str2, objArr));
        AppMethodBeat.o(193384);
    }

    private static void writeLog(String str) {
        AppMethodBeat.i(193385);
        if (shouldWriteLog) {
            write(str);
        }
        AppMethodBeat.o(193385);
    }

    private static void write(String str) {
        AppMethodBeat.i(193386);
        try {
            if (logger != null) {
                logger.write(str);
            }
            AppMethodBeat.o(193386);
        } catch (Throwable th) {
            new StringBuilder("Log write error: ").append(th.toString());
            AppMethodBeat.o(193386);
        }
    }

    public static void closeLog() {
        AppMethodBeat.i(193387);
        flush();
        AppMethodBeat.o(193387);
    }

    public static void flush() {
        AppMethodBeat.i(193388);
        try {
            if (logger != null) {
                logger.flush();
            }
            AppMethodBeat.o(193388);
        } catch (Throwable th) {
            new StringBuilder("flush log error: ").append(th.toString());
            AppMethodBeat.o(193388);
        }
    }

    private static String composeLogMsg(String str, String str2) {
        AppMethodBeat.i(193389);
        String str3 = str + APLogFileUtil.SEPARATOR_LOG + Thread.currentThread().getName() + APLogFileUtil.SEPARATOR_LOG + str2 + APLogFileUtil.SEPARATOR_LINE;
        AppMethodBeat.o(193389);
        return str3;
    }
}
