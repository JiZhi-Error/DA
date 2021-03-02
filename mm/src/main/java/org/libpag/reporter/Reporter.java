package org.libpag.reporter;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Reporter {
    private static final String TAG = (Reporter.class.getSimpleName() + "-" + Integer.toHexString(Reporter.class.hashCode()));
    private Boolean auto;
    private File dir;
    private Handler ioHandler;
    private Runnable uploadRunnable = new Runnable() {
        /* class org.libpag.reporter.Reporter.AnonymousClass1 */

        public void run() {
            AppMethodBeat.i(237031);
            try {
                File[] listFiles = Reporter.this.dir.listFiles();
                for (File file : listFiles) {
                    if (file.exists() && file.isFile()) {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        byte[] bArr = new byte[1024];
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            for (int i2 = 0; i2 < read; i2++) {
                                bArr[i2] = (byte) (bArr[i2] ^ -23);
                            }
                            sb.append(new String(bArr, 0, read));
                        }
                        fileInputStream.close();
                        file.delete();
                        Reporter.access$100(Reporter.this, sb.toString());
                    }
                }
            } catch (Throwable th) {
            }
            Reporter.access$200(Reporter.this);
            AppMethodBeat.o(237031);
        }
    };

    static /* synthetic */ void access$100(Reporter reporter, String str) {
        AppMethodBeat.i(237036);
        reporter.report(str);
        AppMethodBeat.o(237036);
    }

    static /* synthetic */ void access$200(Reporter reporter) {
        AppMethodBeat.i(237037);
        reporter.schedule();
        AppMethodBeat.o(237037);
    }

    static {
        AppMethodBeat.i(237038);
        AppMethodBeat.o(237038);
    }

    public Reporter(File file, Boolean bool, Looper looper) {
        AppMethodBeat.i(237032);
        this.dir = file;
        this.auto = bool;
        if (looper == null) {
            HandlerThread handlerThread = new HandlerThread(TAG);
            handlerThread.setDaemon(true);
            handlerThread.start();
            do {
            } while (!handlerThread.isAlive());
            looper = handlerThread.getLooper();
        }
        this.ioHandler = new Handler(looper);
        schedule();
        AppMethodBeat.o(237032);
    }

    private void schedule() {
        AppMethodBeat.i(237033);
        if (this.auto.booleanValue() && this.ioHandler != null) {
            this.ioHandler.postDelayed(this.uploadRunnable, 30000);
        }
        AppMethodBeat.o(237033);
    }

    private void report(String str) {
        AppMethodBeat.i(237034);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://h.trace.qq.com/kv").openConnection();
            httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(false);
            httpURLConnection.setDoOutput(true);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            httpURLConnection.disconnect();
            AppMethodBeat.o(237034);
        } catch (Exception e2) {
            AppMethodBeat.o(237034);
        }
    }

    public void flush() {
        AppMethodBeat.i(237035);
        if (this.ioHandler != null) {
            this.ioHandler.removeCallbacks(this.uploadRunnable);
            this.ioHandler.post(this.uploadRunnable);
        }
        AppMethodBeat.o(237035);
    }
}
