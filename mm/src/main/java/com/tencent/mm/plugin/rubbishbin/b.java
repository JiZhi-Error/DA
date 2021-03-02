package com.tencent.mm.plugin.rubbishbin;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

public final class b implements Thread.UncaughtExceptionHandler {
    private int Czp = 0;
    private long Czq = 0;
    private Context context = null;
    private String stackTrace = "";
    private String threadName = "";

    public b(Context context2) {
        this.context = context2;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        String substring;
        AppMethodBeat.i(146673);
        this.threadName = thread.getName();
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        this.stackTrace = stringWriter.toString() + "\n";
        int length = (this.stackTrace.length() / 512) + 1;
        long nanoTime = System.nanoTime();
        for (int i2 = 0; i2 < length; i2++) {
            if ((i2 + 1) * 512 < this.stackTrace.length()) {
                substring = this.stackTrace.substring(i2 * 512, (i2 + 1) * 512);
            } else {
                substring = this.stackTrace.substring(i2 * 512);
            }
            h.INSTANCE.a(17910, a.CLIENT_VERSION, BuildInfo.CLIENT_VERSION, this.threadName, 0, substring, 1, Integer.valueOf(i2 + 1), Integer.valueOf(length), Long.valueOf(nanoTime));
        }
        this.context.stopService(new Intent(this.context, RubbishBinServiceImpl.class));
        while (true) {
            try {
                Looper.loop();
            } catch (Exception e2) {
            }
        }
    }
}
