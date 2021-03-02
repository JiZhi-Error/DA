package com.tencent.mm.gpu.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.rubbishbin.JNIExceptionHandler;
import com.tencent.mm.plugin.rubbishbin.JNIExceptionHandlerImpl;
import com.tencent.mm.sdk.platformtools.Log;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public abstract class GpuHookService extends Service implements Runnable {
    private String hjA = BuildConfig.KINDA_DEFAULT;
    private int hjw = 1000;
    private int hjx = 0;
    private Thread hjy;
    private a hjz;
    private int repeatMode = 1;

    public abstract void axt();

    public IBinder onBind(Intent intent) {
        Log.e("Gpu.GpuHookService", "start GpuHookService of bindService");
        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
            /* class com.tencent.mm.gpu.service.GpuHookService.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(186206);
                Log.e("Gpu.GpuHookService", "kill self in 120s！");
                a a2 = c.a(0, new a());
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/gpu/service/GpuHookService$1", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
                System.exit(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/gpu/service/GpuHookService$1", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
                AppMethodBeat.o(186206);
            }
        }, 120000);
        return null;
    }

    public void onCreate() {
        Log.e("Gpu.GpuHookService", "GpuHookService create start");
        if (this.hjz == null) {
            Log.e("Gpu.GpuHookService", "exceptionHandler init");
            this.hjz = new a(this);
        }
        Thread.setDefaultUncaughtExceptionHandler(this.hjz);
        this.hjy = new Thread(this);
        JNIExceptionHandlerImpl.initJNIExceptionHandler(this, "Gpu.GpuHookService");
        JNIExceptionHandler.init();
        Log.e("Gpu.GpuHookService", "GpuHookService create finish");
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        Log.e("Gpu.GpuHookService", "GpuHookService startCommand start");
        if (intent != null) {
            this.hjx = intent.getIntExtra("exec_time", 0);
            this.hjw = intent.getIntExtra("interval", -1);
            this.hjA = intent.getStringExtra("exec_tag");
        }
        this.hjy.setName(this.hjA);
        JNIExceptionHandler.INSTANCE.setReportExecutionTag(this.hjA);
        switch (this.hjx) {
            case -1:
            case 0:
                this.repeatMode = this.hjx;
                break;
            default:
                this.repeatMode = 1;
                break;
        }
        if (this.hjw == -1) {
            stopSelf();
            return super.onStartCommand(intent, i2, i3);
        }
        if (!this.hjy.isAlive()) {
            h.RTc.ba(this);
        }
        Log.e("Gpu.GpuHookService", "GpuHookService startCommand finish");
        return super.onStartCommand(intent, i2, i3);
    }

    public void run() {
        SharedPreferences sharedPreferences = getSharedPreferences("sp_gpuhook_service", g.aps());
        String format = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        String string = sharedPreferences.getString("LastExecDate", "00000000");
        String string2 = sharedPreferences.getString("GpuHookTag", "N/A");
        if (!Objects.equals(string, format)) {
            sharedPreferences.edit().putString("GpuHookTag", "N/A").putString("LastExecDate", format).apply();
            string2 = "N/A";
        }
        if (!Objects.equals(string2, this.hjA) || this.repeatMode == -1) {
            sharedPreferences.edit().putInt("GpuHookCount", this.hjx).apply();
        } else if (sharedPreferences.getInt("GpuHookCount", this.hjx) <= 0) {
            this.repeatMode = 0;
            stopSelf();
            return;
        }
        sharedPreferences.edit().putString("GpuHookTag", this.hjA).apply();
        this.hjx = sharedPreferences.getInt("GpuHookCount", this.hjx);
        Log.i("Gpu.GpuHookService", "[sunny]dt:%s,cnt:%d,t:%s", format, Integer.valueOf(this.hjx), this.hjA);
        while (true) {
            if (this.repeatMode != 0) {
                this.hjx--;
                sharedPreferences.edit().putInt("GpuHookCount", this.hjx).apply();
                Log.i("Gpu.GpuHookService", "e!");
                axt();
                if (this.hjx == 0 && this.repeatMode != -1) {
                    break;
                }
                try {
                    Thread.sleep((long) this.hjw);
                } catch (InterruptedException e2) {
                }
            } else {
                stopSelf();
                break;
            }
        }
        stopSelf();
    }

    public static void F(Context context, String str) {
        try {
            Intent intent = new Intent(context, GpuHookServiceImpl.class);
            intent.putExtra("exec_time", 1);
            intent.putExtra("interval", 120000);
            intent.putExtra("exec_tag", str);
            context.startService(intent);
        } catch (Exception e2) {
        }
    }
}
