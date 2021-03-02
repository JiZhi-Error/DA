package com.tencent.midas.comm.log.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;

public class APLogDataReporter {
    public static final String MIDAS_LOG_ERROR_APPEND = "sdk.log.error.append";
    public static final String MIDAS_LOG_ERROR_CLOSE = "sdk.log.error.close";
    public static final String MIDAS_LOG_ERROR_FLUSH = "sdk.log.error.flush";
    public static final String MIDAS_LOG_ERROR_INIT = "sdk.log.error.init";
    public static final String MIDAS_LOG_ERROR_MMAP_OPEN = "sdk.log.error.mmap.open";
    public static final String MIDAS_LOG_ERROR_PRINT = "sdk.log.error.print";
    public static final String MIDAS_LOG_ERROR_PROCESS = "sdk.log.error.process";
    public static final String MIDAS_LOG_ERROR_WRITE = "sdk.log.error.write";
    public static final String MIDAS_LOG_INIT = "sdk.log.init";
    private Reporter reporter;

    public interface Reporter {
        void report(String str, String str2, String str3);
    }

    /* access modifiers changed from: package-private */
    public static class Holder {
        private static final APLogDataReporter INSTANCE = new APLogDataReporter();

        private Holder() {
        }

        static {
            AppMethodBeat.i(193441);
            AppMethodBeat.o(193441);
        }
    }

    private APLogDataReporter() {
    }

    public static APLogDataReporter getInstance() {
        AppMethodBeat.i(193442);
        APLogDataReporter aPLogDataReporter = Holder.INSTANCE;
        AppMethodBeat.o(193442);
        return aPLogDataReporter;
    }

    public Reporter getReporter() {
        return this.reporter;
    }

    public void setReporter(Reporter reporter2) {
        this.reporter = reporter2;
    }

    public void report(String str, String str2) {
        AppMethodBeat.i(193443);
        report(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY, str, str2);
        AppMethodBeat.o(193443);
    }

    public void report(String str, String str2, String str3) {
        AppMethodBeat.i(193444);
        try {
            if (this.reporter != null) {
                this.reporter.report(str, str2, str3);
            }
            AppMethodBeat.o(193444);
        } catch (Throwable th) {
            new StringBuilder("report error: ").append(th.getMessage());
            AppMethodBeat.o(193444);
        }
    }

    public void reportTimeEx(String str, long j2) {
        AppMethodBeat.i(193445);
        report(str, String.valueOf(System.currentTimeMillis() - j2));
        AppMethodBeat.o(193445);
    }
}
