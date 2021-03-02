package com.google.android.gms.gcm;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.concurrent.GuardedBy;

public abstract class GcmTaskService extends Service {
    public static final String SERVICE_ACTION_EXECUTE_TASK = "com.google.android.gms.gcm.ACTION_TASK_READY";
    public static final String SERVICE_ACTION_INITIALIZE = "com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE";
    public static final String SERVICE_PERMISSION = "com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE";
    private ComponentName componentName;
    private final Object lock = new Object();
    @GuardedBy("lock")
    private int zzt;
    private ExecutorService zzu;
    private Messenger zzv;
    private GcmNetworkManager zzw;

    @VisibleForTesting
    @TargetApi(21)
    class zzd extends Handler {
        zzd(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            Messenger messenger;
            AppMethodBeat.i(3631);
            if (!UidVerifier.uidHasPackageName(GcmTaskService.this, message.sendingUid, "com.google.android.gms")) {
                AppMethodBeat.o(3631);
                return;
            }
            switch (message.what) {
                case 1:
                    Bundle data = message.getData();
                    if (!data.isEmpty() && (messenger = message.replyTo) != null) {
                        String string = data.getString("tag");
                        ArrayList parcelableArrayList = data.getParcelableArrayList("triggered_uris");
                        if (!GcmTaskService.this.zzg((GcmTaskService) string)) {
                            GcmTaskService.this.zzd((GcmTaskService) new zze(string, messenger, data.getBundle("extras"), parcelableArrayList));
                        }
                    }
                    AppMethodBeat.o(3631);
                    return;
                case 2:
                    if (Log.isLoggable("GcmTaskService", 3)) {
                        String valueOf = String.valueOf(message);
                        new StringBuilder(String.valueOf(valueOf).length() + 45).append("ignoring unimplemented stop message for now: ").append(valueOf);
                    }
                    AppMethodBeat.o(3631);
                    return;
                case 3:
                default:
                    String valueOf2 = String.valueOf(message);
                    new StringBuilder(String.valueOf(valueOf2).length() + 31).append("Unrecognized message received: ").append(valueOf2);
                    AppMethodBeat.o(3631);
                    return;
                case 4:
                    GcmTaskService.this.onInitializeTasks();
                    AppMethodBeat.o(3631);
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class zze implements Runnable {
        private final Bundle extras;
        private final String tag;
        private final zzg zzaa;
        private final Messenger zzab;
        private final List<Uri> zzz;

        zze(String str, IBinder iBinder, Bundle bundle, List<Uri> list) {
            zzg zzh;
            AppMethodBeat.i(3632);
            this.tag = str;
            if (iBinder == null) {
                zzh = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gcm.INetworkTaskCallback");
                zzh = queryLocalInterface instanceof zzg ? (zzg) queryLocalInterface : new zzh(iBinder);
            }
            this.zzaa = zzh;
            this.extras = bundle;
            this.zzz = list;
            this.zzab = null;
            AppMethodBeat.o(3632);
        }

        zze(String str, Messenger messenger, Bundle bundle, List<Uri> list) {
            this.tag = str;
            this.zzab = messenger;
            this.extras = bundle;
            this.zzz = list;
            this.zzaa = null;
        }

        static /* synthetic */ void zzd(zze zze, int i2) {
            AppMethodBeat.i(3635);
            zze.zze(1);
            AppMethodBeat.o(3635);
        }

        private final void zze(int i2) {
            AppMethodBeat.i(3634);
            synchronized (GcmTaskService.this.lock) {
                try {
                    if (GcmTaskService.this.zzw.zzf(this.tag, GcmTaskService.this.componentName.getClassName())) {
                        try {
                            GcmTaskService.this.zzw.zze(this.tag, GcmTaskService.this.componentName.getClassName());
                            if (!zzf() && !GcmTaskService.this.zzw.zzf(GcmTaskService.this.componentName.getClassName())) {
                                GcmTaskService.this.stopSelf(GcmTaskService.this.zzt);
                            }
                        } finally {
                            AppMethodBeat.o(3634);
                        }
                    } else {
                        if (zzf()) {
                            Messenger messenger = this.zzab;
                            Message obtain = Message.obtain();
                            obtain.what = 3;
                            obtain.arg1 = i2;
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("component", GcmTaskService.this.componentName);
                            bundle.putString("tag", this.tag);
                            obtain.setData(bundle);
                            messenger.send(obtain);
                        } else {
                            this.zzaa.zzf(i2);
                        }
                        GcmTaskService.this.zzw.zze(this.tag, GcmTaskService.this.componentName.getClassName());
                        if (!zzf() && !GcmTaskService.this.zzw.zzf(GcmTaskService.this.componentName.getClassName())) {
                            GcmTaskService.this.stopSelf(GcmTaskService.this.zzt);
                        }
                        AppMethodBeat.o(3634);
                    }
                } catch (RemoteException e2) {
                    String valueOf = String.valueOf(this.tag);
                    if (valueOf.length() != 0) {
                        "Error reporting result of operation to scheduler for ".concat(valueOf);
                    } else {
                        new String("Error reporting result of operation to scheduler for ");
                    }
                    GcmTaskService.this.zzw.zze(this.tag, GcmTaskService.this.componentName.getClassName());
                    if (!zzf() && !GcmTaskService.this.zzw.zzf(GcmTaskService.this.componentName.getClassName())) {
                        GcmTaskService.this.stopSelf(GcmTaskService.this.zzt);
                    }
                } catch (Throwable th) {
                    GcmTaskService.this.zzw.zze(this.tag, GcmTaskService.this.componentName.getClassName());
                    if (!zzf() && !GcmTaskService.this.zzw.zzf(GcmTaskService.this.componentName.getClassName())) {
                        GcmTaskService.this.stopSelf(GcmTaskService.this.zzt);
                    }
                    AppMethodBeat.o(3634);
                    throw th;
                }
            }
        }

        private final boolean zzf() {
            return this.zzab != null;
        }

        public final void run() {
            AppMethodBeat.i(3633);
            zze(GcmTaskService.this.onRunTask(new TaskParams(this.tag, this.extras, this.zzz)));
            AppMethodBeat.o(3633);
        }
    }

    private final void zzd(int i2) {
        synchronized (this.lock) {
            this.zzt = i2;
            if (!this.zzw.zzf(this.componentName.getClassName())) {
                stopSelf(this.zzt);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zzd(zze zze2) {
        try {
            this.zzu.execute(zze2);
        } catch (RejectedExecutionException e2) {
            zze.zzd(zze2, 1);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean zzg(String str) {
        boolean z;
        synchronized (this.lock) {
            z = !this.zzw.zzd(str, this.componentName.getClassName());
            if (z) {
                String packageName = getPackageName();
                new StringBuilder(String.valueOf(packageName).length() + 44 + String.valueOf(str).length()).append(packageName).append(" ").append(str).append(": Task already running, won't start another");
            }
        }
        return z;
    }

    public IBinder onBind(Intent intent) {
        if (intent == null || !PlatformVersion.isAtLeastLollipop() || !SERVICE_ACTION_EXECUTE_TASK.equals(intent.getAction())) {
            return null;
        }
        return this.zzv.getBinder();
    }

    public void onCreate() {
        super.onCreate();
        this.zzw = GcmNetworkManager.getInstance(this);
        this.zzu = Executors.newFixedThreadPool(2, new zze(this));
        this.zzv = new Messenger(new zzd(Looper.getMainLooper()));
        this.componentName = new ComponentName(this, getClass());
    }

    public void onDestroy() {
        super.onDestroy();
        List<Runnable> shutdownNow = this.zzu.shutdownNow();
        if (!shutdownNow.isEmpty()) {
            new StringBuilder(79).append("Shutting down, but not all tasks are finished executing. Remaining: ").append(shutdownNow.size());
        }
    }

    public void onInitializeTasks() {
    }

    public abstract int onRunTask(TaskParams taskParams);

    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent == null) {
            zzd(i3);
        } else {
            try {
                intent.setExtrasClassLoader(PendingCallback.class.getClassLoader());
                String action = intent.getAction();
                if (SERVICE_ACTION_EXECUTE_TASK.equals(action)) {
                    String stringExtra = intent.getStringExtra("tag");
                    Parcelable parcelableExtra = intent.getParcelableExtra("callback");
                    Bundle bundleExtra = intent.getBundleExtra("extras");
                    ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("triggered_uris");
                    if (!(parcelableExtra instanceof PendingCallback)) {
                        String packageName = getPackageName();
                        new StringBuilder(String.valueOf(packageName).length() + 47 + String.valueOf(stringExtra).length()).append(packageName).append(" ").append(stringExtra).append(": Could not process request, invalid callback.");
                    } else if (zzg(stringExtra)) {
                        zzd(i3);
                    } else {
                        zzd(new zze(stringExtra, ((PendingCallback) parcelableExtra).zzal, bundleExtra, parcelableArrayListExtra));
                    }
                } else if (SERVICE_ACTION_INITIALIZE.equals(action)) {
                    onInitializeTasks();
                } else {
                    new StringBuilder(String.valueOf(action).length() + 37).append("Unknown action received ").append(action).append(", terminating");
                }
                zzd(i3);
            } finally {
                zzd(i3);
            }
        }
        return 2;
    }
}
