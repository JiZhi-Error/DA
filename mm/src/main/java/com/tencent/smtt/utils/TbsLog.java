package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsConfig;
import java.util.LinkedList;
import java.util.List;

public class TbsLog {
    public static final int TBSLOG_CODE_SDK_BASE = 1000;
    public static final int TBSLOG_CODE_SDK_CONFLICT_X5CORE = 993;
    public static final int TBSLOG_CODE_SDK_INIT = 999;
    public static final int TBSLOG_CODE_SDK_INVOKE_ERROR = 997;
    public static final int TBSLOG_CODE_SDK_LOAD_ERROR = 998;
    public static final int TBSLOG_CODE_SDK_NO_SHARE_X5CORE = 994;
    public static final int TBSLOG_CODE_SDK_SELF_MODE = 996;
    public static final int TBSLOG_CODE_SDK_THIRD_MODE = 995;
    public static final int TBSLOG_CODE_SDK_UNAVAIL_X5CORE = 992;
    public static final String X5LOGTAG = "x5logtag";

    /* renamed from: a  reason: collision with root package name */
    private static boolean f2147a = true;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2148b = true;

    /* renamed from: c  reason: collision with root package name */
    private static TbsLogClient f2149c = null;
    public static int sLogMaxCount = 10;
    public static List<String> sTbsLogList = new LinkedList();

    static {
        AppMethodBeat.i(54000);
        AppMethodBeat.o(54000);
    }

    public static void setWriteLogJIT(boolean z) {
        AppMethodBeat.i(53982);
        f2148b = z;
        if (f2149c == null) {
            AppMethodBeat.o(53982);
            return;
        }
        TbsLogClient.setWriteLogJIT(z);
        AppMethodBeat.o(53982);
    }

    public static void app_extra(String str, Context context) {
        int i2 = 0;
        AppMethodBeat.i(53983);
        try {
            Context applicationContext = context.getApplicationContext();
            String[] strArr = {TbsConfig.APP_DEMO, TbsConfig.APP_QB, "com.tencent.mm", TbsConfig.APP_QQ, TbsConfig.APP_DEMO_TEST, TbsConfig.APP_QZONE};
            String[] strArr2 = {"DEMO", "QB", "WX", "QQ", "TEST", "QZ"};
            while (true) {
                if (i2 >= 6) {
                    break;
                } else if (applicationContext.getPackageName().contains(strArr[i2])) {
                    i(str, "app_extra pid:" + Process.myPid() + "; APP_TAG:" + strArr2[i2] + "!");
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == 6) {
                i(str, "app_extra pid:" + Process.myPid() + "; APP_TAG:OTHER!");
            }
            AppMethodBeat.o(53983);
        } catch (Throwable th) {
            w(str, "app_extra exception:" + Log.getStackTraceString(th));
            AppMethodBeat.o(53983);
        }
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(53984);
        if (f2149c == null) {
            AppMethodBeat.o(53984);
            return;
        }
        f2149c.i(str, "TBS:".concat(String.valueOf(str2)));
        f2149c.writeLog("(I)-" + str + "-TBS:" + str2);
        AppMethodBeat.o(53984);
    }

    public static void i(String str, String str2, boolean z) {
        AppMethodBeat.i(53985);
        i(str, str2);
        if (f2149c != null && f2147a && z) {
            f2149c.showLog(str + ": " + str2);
        }
        AppMethodBeat.o(53985);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(53986);
        if (f2149c == null) {
            AppMethodBeat.o(53986);
            return;
        }
        f2149c.e(str, "TBS:".concat(String.valueOf(str2)));
        f2149c.writeLog("(E)-" + str + "-TBS:" + str2);
        AppMethodBeat.o(53986);
    }

    public static void e(String str, String str2, boolean z) {
        AppMethodBeat.i(53987);
        e(str, str2);
        if (f2149c != null && f2147a && z) {
            f2149c.showLog(str + ": " + str2);
        }
        AppMethodBeat.o(53987);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(53988);
        if (f2149c == null) {
            AppMethodBeat.o(53988);
            return;
        }
        f2149c.w(str, "TBS:".concat(String.valueOf(str2)));
        f2149c.writeLog("(W)-" + str + "-TBS:" + str2);
        AppMethodBeat.o(53988);
    }

    public static void w(String str, String str2, boolean z) {
        AppMethodBeat.i(53989);
        w(str, str2);
        if (f2149c != null && f2147a && z) {
            f2149c.showLog(str + ": " + str2);
        }
        AppMethodBeat.o(53989);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(53990);
        if (f2149c == null) {
            AppMethodBeat.o(53990);
            return;
        }
        f2149c.d(str, "TBS:".concat(String.valueOf(str2)));
        AppMethodBeat.o(53990);
    }

    public static void d(String str, String str2, boolean z) {
        AppMethodBeat.i(53991);
        d(str, str2);
        if (f2149c != null && f2147a && z) {
            f2149c.showLog(str + ": " + str2);
        }
        AppMethodBeat.o(53991);
    }

    public static void v(String str, String str2) {
        AppMethodBeat.i(53992);
        if (f2149c == null) {
            AppMethodBeat.o(53992);
            return;
        }
        f2149c.v(str, "TBS:".concat(String.valueOf(str2)));
        AppMethodBeat.o(53992);
    }

    public static void v(String str, String str2, boolean z) {
        AppMethodBeat.i(53993);
        v(str, str2);
        if (f2149c != null && f2147a && z) {
            f2149c.showLog(str + ": " + str2);
        }
        AppMethodBeat.o(53993);
    }

    public static void setLogView(TextView textView) {
        AppMethodBeat.i(53994);
        if (textView == null || f2149c == null) {
            AppMethodBeat.o(53994);
            return;
        }
        f2149c.setLogView(textView);
        AppMethodBeat.o(53994);
    }

    public static boolean setTbsLogClient(TbsLogClient tbsLogClient) {
        AppMethodBeat.i(53995);
        if (tbsLogClient == null) {
            AppMethodBeat.o(53995);
            return false;
        }
        f2149c = tbsLogClient;
        TbsLogClient.setWriteLogJIT(f2148b);
        AppMethodBeat.o(53995);
        return true;
    }

    public static String getTbsLogFilePath() {
        AppMethodBeat.i(53996);
        if (TbsLogClient.f2151c != null) {
            String absolutePath = TbsLogClient.f2151c.getAbsolutePath();
            AppMethodBeat.o(53996);
            return absolutePath;
        }
        AppMethodBeat.o(53996);
        return null;
    }

    public static synchronized void initIfNeed(Context context) {
        synchronized (TbsLog.class) {
            AppMethodBeat.i(53997);
            if (f2149c == null) {
                setTbsLogClient(new TbsLogClient(context));
            }
            AppMethodBeat.o(53997);
        }
    }

    public static synchronized void writeLogToDisk() {
        synchronized (TbsLog.class) {
            AppMethodBeat.i(53998);
            if (f2149c != null) {
                f2149c.writeLogToDisk();
            }
            AppMethodBeat.o(53998);
        }
    }

    public static void addLog(int i2, String str, Object... objArr) {
        AppMethodBeat.i(53999);
        synchronized (sTbsLogList) {
            try {
                if (sTbsLogList.size() > sLogMaxCount) {
                    int size = sTbsLogList.size() - sLogMaxCount;
                    while (true) {
                        int i3 = size - 1;
                        if (size <= 0 || sTbsLogList.size() <= 0) {
                            break;
                        }
                        sTbsLogList.remove(0);
                        size = i3;
                    }
                }
                String str2 = null;
                if (str != null) {
                    try {
                        str2 = String.format(str, objArr);
                    } catch (Exception e2) {
                    }
                }
                if (str2 == null) {
                    str2 = "";
                }
                sTbsLogList.add(String.format("[%d][%d][%c][%d]%s", Long.valueOf(System.currentTimeMillis()), 1, '0', Integer.valueOf(i2), str2));
            } catch (Exception e3) {
            }
            try {
            } catch (Throwable th) {
                AppMethodBeat.o(53999);
                throw th;
            }
        }
        AppMethodBeat.o(53999);
    }
}
