package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzb extends Service {
    final ExecutorService bMa;
    private Binder bMb;
    private int bMc;
    private int bMd;
    private final Object lock;

    public zzb() {
        String valueOf = String.valueOf(getClass().getSimpleName());
        this.bMa = Executors.newSingleThreadExecutor(new NamedThreadFactory(valueOf.length() != 0 ? "Firebase-".concat(valueOf) : new String("Firebase-")));
        this.lock = new Object();
        this.bMd = 0;
    }

    /* access modifiers changed from: private */
    public final void g(Intent intent) {
        if (intent != null) {
            WakefulBroadcastReceiver.completeWakefulIntent(intent);
        }
        synchronized (this.lock) {
            this.bMd--;
            if (this.bMd == 0) {
                stopSelfResult(this.bMc);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Intent e(Intent intent) {
        return intent;
    }

    public abstract void f(Intent intent);

    public boolean h(Intent intent) {
        return false;
    }

    public final synchronized IBinder onBind(Intent intent) {
        Log.isLoggable("EnhancedIntentService", 3);
        if (this.bMb == null) {
            this.bMb = new w(this);
        }
        return this.bMb;
    }

    public final int onStartCommand(Intent intent, int i2, int i3) {
        synchronized (this.lock) {
            this.bMc = i3;
            this.bMd++;
        }
        Intent e2 = e(intent);
        if (e2 == null) {
            g(intent);
            return 2;
        } else if (h(e2)) {
            g(intent);
            return 2;
        } else {
            this.bMa.execute(new t(this, e2, intent));
            return 3;
        }
    }
}
