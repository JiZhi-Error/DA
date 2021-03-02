package com.tencent.mm.plugin.rubbishbin;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.Locale;
import java.util.Map;

public class JNIExceptionHandlerImpl extends JNIExceptionHandler {
    private static final String REPORT_TAG = "RubbishBinProgramException";
    public static final String TAG = "JNIException";
    private byte _hellAccFlag_;
    private Context context;
    private String reportExecutionTag = "";

    public JNIExceptionHandlerImpl(Context context2, String str) {
        this.context = context2;
        this.reportExecutionTag = str;
    }

    @Override // com.tencent.mm.plugin.rubbishbin.JNIExceptionHandler
    public void onException(int i2, String str) {
        String substring;
        AppMethodBeat.i(146667);
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            if (entry.getKey().getName().equals(this.reportExecutionTag)) {
                sb.append("Java stack trace:\n");
                StackTraceElement[] value = entry.getValue();
                for (StackTraceElement stackTraceElement : value) {
                    if (!stackTraceElement.isNativeMethod()) {
                        sb.append(String.format(Locale.ENGLISH, "at %s.%s(%s:%d)\n", stackTraceElement.getClassName(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber())));
                    } else {
                        sb.append(String.format(Locale.ENGLISH, "at %s.%s(%s:%d)(Native Call)\n", stackTraceElement.getClassName(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber())));
                    }
                }
            }
        }
        String str2 = sb.toString() + "Signal:" + i2 + ",Native trace\n" + str;
        int length = (str2.length() / 512) + 1;
        long nanoTime = System.nanoTime();
        for (int i3 = 0; i3 < length; i3++) {
            if ((i3 + 1) * 512 < str2.length()) {
                substring = str2.substring(i3 * 512, (i3 + 1) * 512);
            } else {
                substring = str2.substring(i3 * 512);
            }
            h.INSTANCE.a(17910, true, true, a.CLIENT_VERSION, BuildInfo.CLIENT_VERSION, this.reportExecutionTag, 0, substring, 1, Integer.valueOf(i3 + 1), Integer.valueOf(length), Long.valueOf(nanoTime));
        }
        if (this.context instanceof RubbishBinService) {
            ((RubbishBinService) this.context).hjy.interrupt();
            ((RubbishBinService) this.context).stopSelf();
        }
        try {
            int i4 = ((RubbishBinService) this.context).hjw;
            if (i4 > 0) {
                Thread.sleep((long) i4);
            }
        } catch (Exception e2) {
        }
        if (str2.contains("pthread_exit")) {
            com.tencent.mm.hellhoundlib.b.a a2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            Object obj = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/plugin/rubbishbin/JNIExceptionHandlerImpl", "onException", "(ILjava/lang/String;)V", "java/lang/System_EXEC_", "exit", "(I)V");
            System.exit(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/rubbishbin/JNIExceptionHandlerImpl", "onException", "(ILjava/lang/String;)V", "java/lang/System_EXEC_", "exit", "(I)V");
        }
        AppMethodBeat.o(146667);
    }

    public static void initJNIExceptionHandler(Context context2, String str) {
        AppMethodBeat.i(146668);
        INSTANCE = new JNIExceptionHandlerImpl(context2, str);
        AppMethodBeat.o(146668);
    }

    @Override // com.tencent.mm.plugin.rubbishbin.JNIExceptionHandler
    public void setReportExecutionTag(String str) {
        this.reportExecutionTag = str;
    }
}
