package com.tencent.mm.plugin.rubbishbin;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.rubbishbin.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class RubbishBinService extends Service implements Runnable {
    private boolean Czr = false;
    private b Czs = null;
    private String Czt = "";
    private IBinder Czu = null;
    private int Czv = 8;
    private Context context = this;
    private String hjA = null;
    int hjw = 1000;
    private int hjx = 0;
    Thread hjy;
    private int repeatMode = 1;
    private int xGO = 7;

    public IBinder onBind(Intent intent) {
        this.Czu = new a.AbstractBinderC1662a() {
            /* class com.tencent.mm.plugin.rubbishbin.RubbishBinService.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.rubbishbin.a
            public final void F(int i2, int i3, String str) {
                AppMethodBeat.i(146674);
                RubbishBinService.this.hjx = i3;
                RubbishBinService.this.hjw = i2;
                RubbishBinService.this.hjA = str;
                RubbishBinService.this.hjy.setName(RubbishBinService.this.hjA);
                switch (RubbishBinService.this.hjx) {
                    case -1:
                    case 0:
                        RubbishBinService.this.repeatMode = RubbishBinService.this.hjx;
                        break;
                    default:
                        RubbishBinService.this.repeatMode = 1;
                        break;
                }
                if (!RubbishBinService.this.hjy.isAlive()) {
                    RubbishBinService.this.hjy.start();
                }
                AppMethodBeat.o(146674);
            }
        };
        return this.Czu;
    }

    public void onCreate() {
        super.onCreate();
        this.context = this;
        if (this.Czs == null) {
            this.Czs = new b(this);
        }
        Thread.setDefaultUncaughtExceptionHandler(this.Czs);
        this.hjy = new Thread(this);
        JNIExceptionHandlerImpl.initJNIExceptionHandler(this, this.hjA);
        JNIExceptionHandler.init();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent != null) {
            this.hjx = intent.getIntExtra("exec_time", 0);
            this.hjw = intent.getIntExtra("interval", -1);
            this.hjA = intent.getStringExtra("exec_tag");
        }
        if (this.hjA == null) {
            this.hjA = "Default";
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
            this.hjy = new Thread(this);
            this.hjy.setName(this.hjA);
            this.hjy.start();
        }
        return super.onStartCommand(intent, i2, i3);
    }

    public void run() {
        SharedPreferences sharedPreferences = getSharedPreferences("system_config_prefs", g.aps());
        String format = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        String string = sharedPreferences.getString("LastExecDate", "00000000");
        String string2 = sharedPreferences.getString("RubbishTag", "N/A");
        if (!string.equals(format)) {
            sharedPreferences.edit().putString("RubbishTag", "N/A").putString("LastExecDate", format).apply();
            string2 = "N/A";
        }
        if (this.Czr || !string2.equals(this.hjA) || this.repeatMode == -1) {
            sharedPreferences.edit().putInt("RubbishCount", this.hjx).apply();
        } else if (sharedPreferences.getInt("RubbishCount", this.hjx) <= 0) {
            this.repeatMode = 0;
            stopSelf();
            return;
        }
        sharedPreferences.edit().putString("RubbishTag", this.hjA).apply();
        this.hjx = sharedPreferences.getInt("RubbishCount", this.hjx);
        Log.i("RubbishBinService", "[sunny]dt:%s,cnt:%d,t:%s", format, Integer.valueOf(this.hjx), this.hjA);
        while (true) {
            if (this.repeatMode != 0) {
                this.hjx--;
                sharedPreferences.edit().putInt("RubbishCount", this.hjx).apply();
                Log.i("RubbishBinService", "e!");
                h.INSTANCE.a(17910, com.tencent.mm.loader.j.a.CLIENT_VERSION, BuildInfo.CLIENT_VERSION, this.hjA, 1, "", 0, 0, 0, Long.valueOf(System.nanoTime()));
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
}
