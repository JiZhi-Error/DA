package com.google.android.gms.gcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.e.a;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

public class GcmNetworkManager {
    public static final int RESULT_FAILURE = 2;
    public static final int RESULT_RESCHEDULE = 1;
    public static final int RESULT_SUCCESS = 0;
    @GuardedBy("GcmNetworkManager.class")
    private static GcmNetworkManager zzg;
    private final Context zzh;
    @GuardedBy("this")
    private final Map<String, Map<String, Boolean>> zzi = new a();

    private GcmNetworkManager(Context context) {
        AppMethodBeat.i(3612);
        this.zzh = context;
        AppMethodBeat.o(3612);
    }

    public static GcmNetworkManager getInstance(Context context) {
        GcmNetworkManager gcmNetworkManager;
        AppMethodBeat.i(3611);
        synchronized (GcmNetworkManager.class) {
            try {
                if (zzg == null) {
                    zzg = new GcmNetworkManager(context.getApplicationContext());
                }
                gcmNetworkManager = zzg;
            } finally {
                AppMethodBeat.o(3611);
            }
        }
        return gcmNetworkManager;
    }

    private final zzn zzd() {
        AppMethodBeat.i(3613);
        if (GoogleCloudMessaging.zzf(this.zzh) < 5000000) {
            zzo zzo = new zzo();
            AppMethodBeat.o(3613);
            return zzo;
        }
        zzm zzm = new zzm(this.zzh);
        AppMethodBeat.o(3613);
        return zzm;
    }

    static void zzd(String str) {
        AppMethodBeat.i(3617);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Must provide a valid tag.");
            AppMethodBeat.o(3617);
            throw illegalArgumentException;
        } else if (100 < str.length()) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Tag is larger than max permissible tag length (100)");
            AppMethodBeat.o(3617);
            throw illegalArgumentException2;
        } else {
            AppMethodBeat.o(3617);
        }
    }

    private final boolean zze(String str) {
        AppMethodBeat.i(3618);
        Preconditions.checkNotNull(str, "GcmTaskService must not be null.");
        PackageManager packageManager = this.zzh.getPackageManager();
        List<ResolveInfo> emptyList = packageManager == null ? Collections.emptyList() : packageManager.queryIntentServices(str != null ? new Intent(GcmTaskService.SERVICE_ACTION_EXECUTE_TASK).setClassName(this.zzh, str) : new Intent(GcmTaskService.SERVICE_ACTION_EXECUTE_TASK).setPackage(this.zzh.getPackageName()), 0);
        if (CollectionUtils.isEmpty(emptyList)) {
            String.valueOf(str).concat(" is not available. This may cause the task to be lost.");
            AppMethodBeat.o(3618);
        } else {
            for (ResolveInfo resolveInfo : emptyList) {
                if (resolveInfo.serviceInfo != null && resolveInfo.serviceInfo.enabled) {
                    AppMethodBeat.o(3618);
                }
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 118).append("The GcmTaskService class you provided ").append(str).append(" does not seem to support receiving com.google.android.gms.gcm.ACTION_TASK_READY").toString());
            AppMethodBeat.o(3618);
            throw illegalArgumentException;
        }
        return true;
    }

    public void cancelAllTasks(Class<? extends GcmTaskService> cls) {
        AppMethodBeat.i(3616);
        ComponentName componentName = new ComponentName(this.zzh, cls);
        zze(componentName.getClassName());
        zzd().zzd(componentName);
        AppMethodBeat.o(3616);
    }

    public void cancelTask(String str, Class<? extends GcmTaskService> cls) {
        AppMethodBeat.i(3615);
        ComponentName componentName = new ComponentName(this.zzh, cls);
        zzd(str);
        zze(componentName.getClassName());
        zzd().zzd(componentName, str);
        AppMethodBeat.o(3615);
    }

    public synchronized void schedule(Task task) {
        Map<String, Boolean> map;
        AppMethodBeat.i(3614);
        zze(task.getServiceName());
        if (zzd().zzd(task) && (map = this.zzi.get(task.getServiceName())) != null && map.containsKey(task.getTag())) {
            map.put(task.getTag(), Boolean.TRUE);
        }
        AppMethodBeat.o(3614);
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzd(String str, String str2) {
        boolean z;
        AppMethodBeat.i(3619);
        Map<String, Boolean> map = this.zzi.get(str2);
        if (map == null) {
            map = new a<>();
            this.zzi.put(str2, map);
        }
        if (map.put(str, Boolean.FALSE) == null) {
            z = true;
            AppMethodBeat.o(3619);
        } else {
            z = false;
            AppMethodBeat.o(3619);
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zze(String str, String str2) {
        AppMethodBeat.i(3620);
        Map<String, Boolean> map = this.zzi.get(str2);
        if (map != null) {
            if ((map.remove(str) != null) && map.isEmpty()) {
                this.zzi.remove(str2);
            }
        }
        AppMethodBeat.o(3620);
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzf(String str) {
        boolean containsKey;
        AppMethodBeat.i(3622);
        containsKey = this.zzi.containsKey(str);
        AppMethodBeat.o(3622);
        return containsKey;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzf(String str, String str2) {
        boolean z;
        AppMethodBeat.i(3621);
        Map<String, Boolean> map = this.zzi.get(str2);
        if (map != null) {
            Boolean bool = map.get(str);
            if (bool == null) {
                AppMethodBeat.o(3621);
                z = false;
            } else {
                z = bool.booleanValue();
                AppMethodBeat.o(3621);
            }
        } else {
            AppMethodBeat.o(3621);
            z = false;
        }
        return z;
    }
}
