package com.tencent.tinker.lib.service;

import android.app.IntentService;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import com.tencent.tinker.lib.c.a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class TinkerPatchService extends IntentService {
    private static a SjO = null;
    private static Class<? extends AbstractResultService> SjP = null;
    private static AtomicBoolean SjQ = new AtomicBoolean(false);
    private static int notificationId = ShareConstants.TINKER_PATCH_SERVICE_NOTIFICATION;

    public TinkerPatchService() {
        super("TinkerPatchService");
    }

    public static void cX(Context context, String str) {
        ShareTinkerLog.i("Tinker.TinkerPatchService", "run patch service...", new Object[0]);
        Intent intent = new Intent(context, TinkerPatchService.class);
        intent.putExtra("patch_path_extra", str);
        intent.putExtra("patch_result_class", SjP.getName());
        try {
            context.startService(intent);
        } catch (Throwable th) {
            ShareTinkerLog.e("Tinker.TinkerPatchService", "run patch service fail, exception:".concat(String.valueOf(th)), new Object[0]);
        }
    }

    public static void a(a aVar, Class<? extends AbstractResultService> cls) {
        SjO = aVar;
        SjP = cls;
        try {
            Class.forName(cls.getName());
        } catch (ClassNotFoundException e2) {
            ShareTinkerLog.printErrStackTrace("Tinker.TinkerPatchService", e2, "patch processor class not found.", new Object[0]);
        }
    }

    public static String bK(Intent intent) {
        if (intent != null) {
            return ShareIntentUtil.getStringExtra(intent, "patch_path_extra");
        }
        throw new TinkerRuntimeException("getPatchPathExtra, but intent is null");
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 26) {
            ShareTinkerLog.i("Tinker.TinkerPatchService", "for system version >= Android O, we just ignore increasingPriority job to avoid crash or toasts.", new Object[0]);
        } else if ("ZUK".equals(Build.MANUFACTURER)) {
            ShareTinkerLog.i("Tinker.TinkerPatchService", "for ZUK device, we just ignore increasingPriority job to avoid crash.", new Object[0]);
        } else {
            ShareTinkerLog.i("Tinker.TinkerPatchService", "try to increase patch process priority", new Object[0]);
            try {
                Notification notification = new Notification();
                if (Build.VERSION.SDK_INT < 18) {
                    startForeground(notificationId, notification);
                } else {
                    startForeground(notificationId, notification);
                    startService(new Intent(this, InnerService.class));
                }
            } catch (Throwable th) {
                ShareTinkerLog.i("Tinker.TinkerPatchService", "try to increase patch process priority error:".concat(String.valueOf(th)), new Object[0]);
            }
        }
        if (!SjQ.compareAndSet(false, true)) {
            ShareTinkerLog.w("Tinker.TinkerPatchService", "TinkerPatchService doApplyPatch is running by another runner.", new Object[0]);
            return;
        }
        com.tencent.tinker.lib.e.a lk = com.tencent.tinker.lib.e.a.lk(this);
        lk.SjV.aE(intent);
        if (intent == null) {
            ShareTinkerLog.e("Tinker.TinkerPatchService", "TinkerPatchService received a null intent, ignoring.", new Object[0]);
            return;
        }
        String bK = bK(intent);
        if (bK == null) {
            ShareTinkerLog.e("Tinker.TinkerPatchService", "TinkerPatchService can't get the path extra, ignoring.", new Object[0]);
            return;
        }
        File file = new File(bK);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Throwable th2 = null;
        a aVar = new a();
        try {
            if (SjO == null) {
                throw new TinkerRuntimeException("upgradePatchProcessor is null.");
            }
            z = SjO.a(this, bK, aVar);
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            lk.SjV.a(file, z, elapsedRealtime2);
            aVar.isSuccess = z;
            aVar.SjJ = bK;
            aVar.costTime = elapsedRealtime2;
            aVar.f2950e = th2;
            if (intent == null) {
                throw new TinkerRuntimeException("getPatchResultExtra, but intent is null");
            }
            AbstractResultService.a(this, aVar, ShareIntentUtil.getStringExtra(intent, "patch_result_class"));
            SjQ.set(false);
        } catch (Throwable th3) {
            th2 = th3;
            lk.SjV.a(file, th2);
            z = false;
        }
    }

    public static class InnerService extends Service {
        public void onCreate() {
            super.onCreate();
            try {
                startForeground(TinkerPatchService.notificationId, new Notification());
            } catch (Throwable th) {
                ShareTinkerLog.e("Tinker.TinkerPatchService", "InnerService set service for push exception:%s.", th);
            }
            stopSelf();
        }

        public void onDestroy() {
            stopForeground(true);
            super.onDestroy();
        }

        public IBinder onBind(Intent intent) {
            return null;
        }
    }
}
