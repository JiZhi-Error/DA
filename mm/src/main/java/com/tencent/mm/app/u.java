package com.tencent.mm.app;

import android.content.Context;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.StatFs;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.a;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.cp;
import com.tencent.mm.plugin.appbrand.jsapi.aa.e;
import com.tencent.mm.plugin.performance.watchdogs.ThreadWatchDog;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.crash.CallbackForReset;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.crash.ICrashReporter;
import com.tencent.mm.sdk.crash.ISubReporter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebView;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Set;
import org.xwalk.core.XWalkEnvironment;

public class u implements ICrashReporter, MMUncaughtExceptionHandler.IReporter {
    private static String dlA = "";
    private static final byte[] dlP = {0};
    private static volatile ParcelFileDescriptor dlQ = null;
    private static final String dlR = ("version:" + d.KyO);
    private static final long dlq = Util.nowMilliSecond();
    private static final Set<ICrashReporter.ICrashReportExtraMessageGetter> dlu = new HashSet();
    private static final Set<ICrashReporter.ICrashReportListener> dlv = new HashSet();
    private static CrashMonitorForJni.CrashExtraMessageGetter sCrashExtraMessageGetter = new CrashMonitorForJni.CrashExtraMessageGetter() {
        /* class com.tencent.mm.app.u.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.CrashMonitorForJni.CrashExtraMessageGetter
        public final String getExtraMessage() {
            AppMethodBeat.i(19446);
            StringBuilder sb = new StringBuilder();
            String processName = MMApplicationContext.getProcessName();
            if (processName != null && (processName.contains(":tools") || processName.contains(":appbrand") || processName.contains(":isolated_process0"))) {
                sb.append("\n");
                String crashExtraMessage = WebView.getCrashExtraMessage(MMApplicationContext.getContext());
                if (crashExtraMessage != null && crashExtraMessage.length() > 0) {
                    String str = crashExtraMessage + String.format(Locale.US, "client_version:%s;", BuildInfo.CLIENT_VERSION);
                    if (str.length() > 8192) {
                        str = str.substring(str.length() - 8192);
                    }
                    sb.append("#qbrowser.crashmsg=" + Base64.encodeToString(str.getBytes(), 2));
                    Log.v("MicroMsg.MMIsolatedCrashReporter", "header #qbrowser.crashmsg=%s", str);
                }
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(19446);
            return sb2;
        }
    };

    static {
        AppMethodBeat.i(19455);
        AppMethodBeat.o(19455);
    }

    public static boolean a(ParcelFileDescriptor parcelFileDescriptor, ParcelFileDescriptor parcelFileDescriptor2, String str) {
        AppMethodBeat.i(19447);
        dlA = str;
        synchronized (dlP) {
            try {
                dlQ = parcelFileDescriptor;
            } finally {
                AppMethodBeat.o(19447);
            }
        }
        u uVar = new u();
        uVar.init(MMApplicationContext.getContext(), false);
        CrashReportFactory.setupCrashReporter(uVar);
        String str2 = af.get("ro.product.cpu.abi");
        if (str2 == null || str2.length() == 0 || (!str2.equals("x86") && !str2.equals("x86-64"))) {
            u.class.getClassLoader();
            j.Ed("wechatCrashForJni");
            CrashMonitorForJni.setCrashExtraMessageGetter(sCrashExtraMessageGetter);
            String str3 = dlR + "\n" + WebView.getCrashExtraMessage(MMApplicationContext.getContext()) + String.format(Locale.US, "client_version:%s;", BuildInfo.CLIENT_VERSION) + "\n";
            Log.i("MicroMsg.MMIsolatedCrashReporter", "append crash extra message : %s", str3);
            CrashMonitorForJni.setClientVersionMsg(str3);
            CrashMonitorForJni.setCrashRecordLowFd(parcelFileDescriptor2);
        }
        return false;
    }

    private static void ge(String str) {
        int lastIndexOf;
        AppMethodBeat.i(19448);
        while (str.length() > 896 && -1 != (lastIndexOf = str.substring(0, e.CTRL_INDEX).lastIndexOf("\n"))) {
            try {
                Log.e("MicroMsg.MMIsolatedCrashReporter", str.substring(0, lastIndexOf));
                str = str.substring(lastIndexOf + 1);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMIsolatedCrashReporter", e2, "Failed printing stack trace.", new Object[0]);
                AppMethodBeat.o(19448);
                return;
            }
        }
        Log.e("MicroMsg.MMIsolatedCrashReporter", str);
        AppMethodBeat.o(19448);
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter
    public void init(Context context, boolean z) {
        AppMethodBeat.i(231386);
        MMUncaughtExceptionHandler.setReporter(this);
        AppMethodBeat.o(231386);
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter
    public void reportRawMessage(String str, String str2) {
        PrintWriter printWriter;
        Throwable th;
        Throwable th2;
        AppMethodBeat.i(19450);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(19450);
            return;
        }
        synchronized (dlP) {
            try {
                if (dlQ != null) {
                    try {
                        printWriter = new PrintWriter(new FileWriter(dlQ.getFileDescriptor()));
                        try {
                            printWriter.print(dlR);
                            printWriter.println(str);
                            Util.qualityClose(printWriter);
                        } catch (Throwable th3) {
                            th2 = th3;
                            try {
                                Log.printErrStackTrace("MicroMsg.MMIsolatedCrashReporter", th2, "reportRawMessage", new Object[0]);
                                Util.qualityClose(printWriter);
                            } catch (Throwable th4) {
                                th = th4;
                                Util.qualityClose(printWriter);
                                AppMethodBeat.o(19450);
                                throw th;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        printWriter = null;
                        Util.qualityClose(printWriter);
                        AppMethodBeat.o(19450);
                        throw th;
                    }
                }
            } finally {
                AppMethodBeat.o(19450);
            }
        }
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter
    public void setCallbackForReset(CallbackForReset callbackForReset) {
        AppMethodBeat.i(19451);
        MMUncaughtExceptionHandler.setCallbackForReset(callbackForReset);
        AppMethodBeat.o(19451);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0020, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0) == false) goto L_0x0022;
     */
    @Override // com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IReporter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void reportException(com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler r8, java.lang.String r9, java.lang.Throwable r10) {
        /*
        // Method dump skipped, instructions count: 173
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.u.reportException(com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler, java.lang.String, java.lang.Throwable):void");
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter
    public void reportJniCrash(int i2, String str, String str2) {
    }

    private static String gg(String str) {
        AppMethodBeat.i(19453);
        StringBuilder sb = new StringBuilder(256);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(sb);
        Context context = MMApplicationContext.getContext();
        stringBuilderPrinter.println("#client.version=" + d.KyO);
        stringBuilderPrinter.println("#client.verhistory=" + cp.sj(4));
        stringBuilderPrinter.println("#client.imei=0123456789ABCDEF");
        stringBuilderPrinter.println("#accinfo.revision=" + BuildInfo.REV);
        stringBuilderPrinter.println("#accinfo.uin=0");
        stringBuilderPrinter.println("#accinfo.dev=");
        stringBuilderPrinter.println("#accinfo.runtime=" + (Util.nowMilliSecond() - dlq) + "(" + Util.nullAsNil(dlA) + ")");
        stringBuilderPrinter.println("#accinfo.build=" + BuildInfo.TIME + ":" + BuildInfo.HOSTNAME + ":" + ChannelUtil.channelId);
        stringBuilderPrinter.println("#qbrwoser.corever=" + WebView.getInstalledTbsCoreVersion(context));
        stringBuilderPrinter.println("#qbrowser.ver=" + WebView.getTbsSDKVersion(context));
        stringBuilderPrinter.println("#xsdkver=201201");
        try {
            stringBuilderPrinter.println("#xcorever=" + XWalkEnvironment.getInstalledNewstVersion(MMApplicationContext.getContext()));
            stringBuilderPrinter.println("#syswebcore=" + XWalkEnvironment.safeGetChromiunVersion());
        } catch (Exception e2) {
            Log.e("MicroMsg.MMIsolatedCrashReporter", "get syswebcore failed: " + e2.getMessage());
        }
        Log.i("MicroMsg.MMIsolatedCrashReporter", "Activity dump before crash report, [%s]", a.aBz());
        stringBuilderPrinter.println(sCrashExtraMessageGetter.getExtraMessage());
        stringBuilderPrinter.println("#accinfo.env=" + (CrashReportFactory.foreground ? "f" : "b") + ":" + Thread.currentThread().getName() + ":" + CrashReportFactory.currentActivity);
        String str2 = "";
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(b.aKD());
            str2 = String.format("%s:%d:%d:%d %s:%d:%d:%d", Environment.getDataDirectory().getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), b.aKD(), Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks()));
        } catch (Exception e3) {
            Log.e("MicroMsg.MMIsolatedCrashReporter", "check data size failed :%s", e3.getMessage());
        }
        stringBuilderPrinter.println("#accinfo.data=".concat(String.valueOf(str2)));
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        long j2 = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        String str3 = "" + String.format("Runtime Mem[%s:%s:%s:%s] vmSize:%s", Long.valueOf(j2), Long.valueOf(freeMemory), Long.valueOf(j2 - freeMemory), Long.valueOf(Runtime.getRuntime().maxMemory()), LogLogic.getVmSize());
        int processThreadCount = ThreadWatchDog.getProcessThreadCount();
        if (processThreadCount > 260) {
            LinkedList linkedList = new LinkedList();
            str3 = str3 + String.format("[threadInfo(%s:%s) %s]", Integer.valueOf(ThreadWatchDog.getJavaThreads(linkedList)), Integer.valueOf(processThreadCount), linkedList);
        }
        stringBuilderPrinter.println("#accinfo.memory=".concat(String.valueOf(str3)));
        if (!Util.isNullOrNil(str)) {
            stringBuilderPrinter.println("#".concat(String.valueOf(str)));
        }
        stringBuilderPrinter.println("#crashContent=");
        String sb2 = sb.toString();
        AppMethodBeat.o(19453);
        return sb2;
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter
    public void setupSubReporter(ISubReporter iSubReporter) {
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter
    public void reportCrashMessage(String str, String str2) {
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter
    public void setReportID(String str) {
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter
    public void addExtraMessageGetter(ICrashReporter.ICrashReportExtraMessageGetter iCrashReportExtraMessageGetter) {
        AppMethodBeat.i(19454);
        if (iCrashReportExtraMessageGetter == null) {
            AppMethodBeat.o(19454);
            return;
        }
        dlu.add(iCrashReportExtraMessageGetter);
        AppMethodBeat.o(19454);
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter
    public void addCrashReportListener(ICrashReporter.ICrashReportListener iCrashReportListener) {
        AppMethodBeat.i(231387);
        if (iCrashReportListener == null) {
            AppMethodBeat.o(231387);
            return;
        }
        dlv.add(iCrashReportListener);
        AppMethodBeat.o(231387);
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter
    public void removeCrashReportListener(ICrashReporter.ICrashReportListener iCrashReportListener) {
        AppMethodBeat.i(231388);
        if (iCrashReportListener == null) {
            AppMethodBeat.o(231388);
            return;
        }
        dlv.remove(iCrashReportListener);
        AppMethodBeat.o(231388);
    }
}
