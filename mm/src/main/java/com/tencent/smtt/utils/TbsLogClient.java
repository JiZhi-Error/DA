package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TbsLogClient {

    /* renamed from: a  reason: collision with root package name */
    static TbsLogClient f2150a = null;

    /* renamed from: c  reason: collision with root package name */
    static File f2151c = null;

    /* renamed from: d  reason: collision with root package name */
    static String f2152d = null;

    /* renamed from: e  reason: collision with root package name */
    static byte[] f2153e = null;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f2154i = true;

    /* renamed from: b  reason: collision with root package name */
    TextView f2155b;

    /* renamed from: f  reason: collision with root package name */
    private SimpleDateFormat f2156f = null;

    /* renamed from: g  reason: collision with root package name */
    private Context f2157g = null;

    /* renamed from: h  reason: collision with root package name */
    private StringBuffer f2158h = new StringBuffer();

    public TbsLogClient(Context context) {
        AppMethodBeat.i(53929);
        try {
            this.f2157g = context.getApplicationContext();
            this.f2156f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", Locale.US);
            AppMethodBeat.o(53929);
        } catch (Exception e2) {
            this.f2156f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
            AppMethodBeat.o(53929);
        }
    }

    private void a() {
        AppMethodBeat.i(53930);
        try {
            if (f2151c == null) {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    String a2 = f.a(this.f2157g, 6);
                    if (a2 == null) {
                        f2151c = null;
                        AppMethodBeat.o(53930);
                        return;
                    }
                    f2151c = new File(a2, "tbslog.txt");
                    f2152d = LogFileUtils.createKey();
                    f2153e = LogFileUtils.createHeaderText(f2151c.getName(), f2152d);
                    AppMethodBeat.o(53930);
                    return;
                }
                f2151c = null;
            }
            AppMethodBeat.o(53930);
        } catch (SecurityException e2) {
            AppMethodBeat.o(53930);
        } catch (NullPointerException e3) {
            AppMethodBeat.o(53930);
        }
    }

    public void writeLog(String str) {
        AppMethodBeat.i(53931);
        try {
            this.f2158h.append(this.f2156f.format(Long.valueOf(System.currentTimeMillis()))).append(" pid=").append(Process.myPid()).append(" tid=").append(Process.myTid()).append(str).append("\n");
            if (Thread.currentThread() != Looper.getMainLooper().getThread() || f2154i) {
                writeLogToDisk();
            }
            if (this.f2158h.length() > 524288) {
                this.f2158h.delete(0, this.f2158h.length());
            }
            AppMethodBeat.o(53931);
        } catch (Exception e2) {
            AppMethodBeat.o(53931);
        }
    }

    public void writeLogToDisk() {
        AppMethodBeat.i(53932);
        try {
            a();
            if (f2151c != null) {
                LogFileUtils.writeDataToStorage(f2151c, f2152d, f2153e, this.f2158h.toString(), true);
                this.f2158h.delete(0, this.f2158h.length());
            }
            AppMethodBeat.o(53932);
        } catch (Exception e2) {
            AppMethodBeat.o(53932);
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        String f2159a = null;

        a(String str) {
            this.f2159a = str;
        }

        public void run() {
            AppMethodBeat.i(54005);
            if (TbsLogClient.this.f2155b != null) {
                TbsLogClient.this.f2155b.append(this.f2159a + "\n");
            }
            AppMethodBeat.o(54005);
        }
    }

    public void showLog(String str) {
        AppMethodBeat.i(53933);
        if (this.f2155b != null) {
            this.f2155b.post(new a(str));
        }
        AppMethodBeat.o(53933);
    }

    public void setLogView(TextView textView) {
        this.f2155b = textView;
    }

    public static void setWriteLogJIT(boolean z) {
        f2154i = z;
    }

    public void i(String str, String str2) {
    }

    public void e(String str, String str2) {
    }

    public void w(String str, String str2) {
    }

    public void d(String str, String str2) {
    }

    public void v(String str, String str2) {
    }
}
