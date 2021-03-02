package com.tencent.mm.sdk.platformtools;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.mm.co.j;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.crash.CallbackForReset;
import com.tencent.recovery.crash.DefaultExceptionHandler;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class MMUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static MMUncaughtExceptionHandler thiz = null;
    private byte _hellAccFlag_;
    public IAfterReport after;
    private Map<String, IAssertFailedReporter> assertFailedReporter;
    private CallbackForReset callbackReset;
    private boolean hasBeenReport;
    private List<IOnUncaughtExceptionListener> mOnUncaughtExceptionListenerList;
    private IReporter reporter;
    private Thread.UncaughtExceptionHandler ueh;

    public interface IAfterReport {
        void afterReport();
    }

    public interface IAssertFailedReporter {
        String getReport();
    }

    public interface IOnUncaughtExceptionListener {
        void uncaughtException(MMUncaughtExceptionHandler mMUncaughtExceptionHandler, String str, Throwable th);
    }

    public interface IReporter {
        void reportException(MMUncaughtExceptionHandler mMUncaughtExceptionHandler, String str, Throwable th);
    }

    public static synchronized void setReporter(IReporter iReporter) {
        synchronized (MMUncaughtExceptionHandler.class) {
            if (thiz == null) {
                thiz = new MMUncaughtExceptionHandler();
            }
            thiz.reporter = iReporter;
        }
    }

    public static synchronized void setCallbackForReset(CallbackForReset callbackForReset) {
        synchronized (MMUncaughtExceptionHandler.class) {
            if (thiz == null) {
                thiz = new MMUncaughtExceptionHandler();
            }
            thiz.callbackReset = callbackForReset;
        }
    }

    public static synchronized void setAfterReport(IAfterReport iAfterReport) {
        synchronized (MMUncaughtExceptionHandler.class) {
            if (thiz == null) {
                thiz = new MMUncaughtExceptionHandler();
            }
            thiz.after = iAfterReport;
        }
    }

    public static synchronized void addAssertFailedReporter(String str, IAssertFailedReporter iAssertFailedReporter) {
        synchronized (MMUncaughtExceptionHandler.class) {
            if (thiz == null) {
                thiz = new MMUncaughtExceptionHandler();
            }
            thiz.assertFailedReporter.put(str, iAssertFailedReporter);
        }
    }

    public static synchronized void assertTrue(String str, final String str2, boolean z) {
        synchronized (MMUncaughtExceptionHandler.class) {
            addAssertFailedReporter(str, new IAssertFailedReporter() {
                /* class com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IAssertFailedReporter
                public final String getReport() {
                    return "subinfo=" + str2;
                }
            });
            Assert.assertTrue(str, z);
        }
    }

    public static synchronized void addOnUncaughtExceptionListener(IOnUncaughtExceptionListener iOnUncaughtExceptionListener) {
        synchronized (MMUncaughtExceptionHandler.class) {
            if (iOnUncaughtExceptionListener != null) {
                if (thiz == null) {
                    thiz = new MMUncaughtExceptionHandler();
                }
                thiz.mOnUncaughtExceptionListenerList.add(iOnUncaughtExceptionListener);
            }
        }
    }

    private MMUncaughtExceptionHandler() {
        this.reporter = null;
        this.callbackReset = null;
        this.after = null;
        this.assertFailedReporter = new HashMap();
        this.ueh = null;
        this.hasBeenReport = false;
        this.mOnUncaughtExceptionListenerList = new LinkedList();
        this.ueh = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(this));
    }

    private static String toVisualString(String str) {
        boolean z;
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        if (charArray == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= charArray.length) {
                z = false;
                break;
            } else if (charArray[i2] > 127) {
                charArray[i2] = 0;
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            return new String(charArray, 0, i2);
        }
        return str;
    }

    public static String getExceptionCauseString(Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (th.getCause() != null) {
            try {
                th = th.getCause();
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                }
            }
        }
        th.printStackTrace(printStream);
        return toVisualString(byteArrayOutputStream.toString());
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        if (!this.hasBeenReport) {
            this.hasBeenReport = true;
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                PrintStream printStream = new PrintStream(byteArrayOutputStream);
                Throwable th2 = th;
                while (th2.getCause() != null) {
                    th2 = th2.getCause();
                }
                th2.printStackTrace(printStream);
                final String visualString = toVisualString(byteArrayOutputStream.toString());
                if (!(this.callbackReset == null || visualString == null)) {
                    final j jVar = new j();
                    new MMHandler("close-db-while-crash").post(new Runnable() {
                        /* class com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.AnonymousClass2 */

                        public void run() {
                            MMUncaughtExceptionHandler.this.callbackReset.callbackForReset(visualString);
                            j jVar = jVar;
                            synchronized (jVar.mLock) {
                                if (jVar.mLock[0] == 0) {
                                    jVar.mLock[0] = 1;
                                    jVar.mLock.notifyAll();
                                    Log.i("MicroMsg.WxTimeoutLock", "notify done %s", jVar);
                                }
                            }
                        }
                    });
                    jVar.hip();
                }
                if (!(this.reporter == null || visualString == null)) {
                    this.reporter.reportException(this, visualString, th);
                    if (this.after != null) {
                        this.after.afterReport();
                    }
                }
                for (IOnUncaughtExceptionListener iOnUncaughtExceptionListener : this.mOnUncaughtExceptionListenerList) {
                    if (iOnUncaughtExceptionListener != null) {
                        try {
                            iOnUncaughtExceptionListener.uncaughtException(this, visualString, th);
                        } catch (Exception e2) {
                        }
                    }
                }
                byteArrayOutputStream.close();
            } catch (Exception e3) {
            }
            Log.appenderClose();
            if (BuildInfo.DEBUG) {
                this.ueh.uncaughtException(thread, th);
                return;
            }
            a a2 = c.a(Process.myPid(), new a());
            Object obj = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler", "uncaughtException", "(Ljava/lang/Thread;Ljava/lang/Throwable;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            Process.killProcess(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler", "uncaughtException", "(Ljava/lang/Thread;Ljava/lang/Throwable;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            a a3 = c.a(0, new a());
            Object obj2 = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(obj2, a3.axQ(), "com/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler", "uncaughtException", "(Ljava/lang/Thread;Ljava/lang/Throwable;)V", "java/lang/System_EXEC_", "exit", "(I)V");
            System.exit(((Integer) a3.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(obj2, "com/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler", "uncaughtException", "(Ljava/lang/Thread;Ljava/lang/Throwable;)V", "java/lang/System_EXEC_", "exit", "(I)V");
        }
    }

    public final String getReportByAssertPrefix(String str) {
        Iterator<Map.Entry<String, IAssertFailedReporter>> it = this.assertFailedReporter.entrySet().iterator();
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry<String, IAssertFailedReporter> next = it.next();
                String key = next.getKey();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(str) && str.startsWith(key)) {
                    return next.getValue().getReport();
                }
            }
        }
        return "";
    }
}
