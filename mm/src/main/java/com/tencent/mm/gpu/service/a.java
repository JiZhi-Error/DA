package com.tencent.mm.gpu.service;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

public final class a implements Thread.UncaughtExceptionHandler {
    private Context context;

    a(Context context2) {
        this.context = context2;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        String substring;
        AppMethodBeat.i(186205);
        Log.i("Gpu.GpuExceptionHandler", "threadName = ".concat(String.valueOf(thread.getName())));
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String str = stringWriter.toString() + "\n";
        int length = (str.length() / 512) + 1;
        Log.e("Gpu.GpuExceptionHandler", "crashTime = ".concat(String.valueOf(System.nanoTime())));
        for (int i2 = 0; i2 < length; i2++) {
            if ((i2 + 1) * 512 < str.length()) {
                substring = str.substring(i2 * 512, (i2 + 1) * 512);
            } else {
                substring = str.substring(i2 * 512);
            }
            Log.e("Gpu.GpuExceptionHandler", "segToReport = ".concat(String.valueOf(substring)));
        }
        Log.e("Gpu.GpuExceptionHandler", str);
        this.context.stopService(new Intent(this.context, GpuHookService.class));
        while (true) {
            try {
                Looper.loop();
            } catch (Exception e2) {
            }
        }
    }
}
