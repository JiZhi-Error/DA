package com.tencent.midas.comm;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogDataReporter;
import com.tencent.midas.data.APPluginReportManager;

public class APLogUtil {
    private static boolean HAS_INIT_LOG_IN_NEW_PROCESS = false;
    public static boolean IS_IN_NEW_PROCESS = true;

    public static void initAPLogIfNewProcess(Context context, boolean z, boolean z2) {
        AppMethodBeat.i(193218);
        if (z && !HAS_INIT_LOG_IN_NEW_PROCESS) {
            IS_IN_NEW_PROCESS = true;
            try {
                APLogInfo aPLogInfo = new APLogInfo();
                APLogDataReporter.getInstance().setReporter(new APLogDataReporter.Reporter() {
                    /* class com.tencent.midas.comm.APLogUtil.AnonymousClass1 */

                    @Override // com.tencent.midas.comm.log.util.APLogDataReporter.Reporter
                    public final void report(String str, String str2, String str3) {
                        AppMethodBeat.i(193227);
                        APPluginReportManager.getInstance().insertData(str, str2, "", str3);
                        AppMethodBeat.o(193227);
                    }
                });
                aPLogInfo.setContext(context);
                aPLogInfo.setLogEnable(z2);
                aPLogInfo.setAutoFlush(true);
                aPLogInfo.setLogTag("TencentPay");
                APLog.init(aPLogInfo);
                HAS_INIT_LOG_IN_NEW_PROCESS = true;
                AppMethodBeat.o(193218);
                return;
            } catch (Throwable th) {
                APLog.e("APLogUtil init", th.toString());
            }
        }
        AppMethodBeat.o(193218);
    }

    public static void initAPLogInPlugin(Context context, boolean z) {
        AppMethodBeat.i(193219);
        try {
            APLogInfo aPLogInfo = new APLogInfo();
            APLogDataReporter.getInstance().setReporter(new APLogDataReporter.Reporter() {
                /* class com.tencent.midas.comm.APLogUtil.AnonymousClass2 */

                @Override // com.tencent.midas.comm.log.util.APLogDataReporter.Reporter
                public final void report(String str, String str2, String str3) {
                    AppMethodBeat.i(193234);
                    APPluginReportManager.getInstance().insertData(str, str2, "", str3);
                    AppMethodBeat.o(193234);
                }
            });
            aPLogInfo.setContext(context);
            aPLogInfo.setLogEnable(z);
            aPLogInfo.setAutoFlush(true);
            aPLogInfo.setLogTag("TencentPay");
            APLog.init(aPLogInfo);
            AppMethodBeat.o(193219);
        } catch (Throwable th) {
            APLog.e("APLogUtil init", th.toString());
            AppMethodBeat.o(193219);
        }
    }

    public static void flushIfNewProcess() {
        AppMethodBeat.i(193220);
        if (IS_IN_NEW_PROCESS && APLog.getLogInfo() != null && !APLog.getLogInfo().isAutoFlush()) {
            APLog.flush();
        }
        AppMethodBeat.o(193220);
    }
}
