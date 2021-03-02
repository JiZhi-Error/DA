package com.tencent.mm.sdcard_migrate;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.cc.b;
import com.tencent.mm.g.a.cp;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdcard_migrate.e;
import com.tencent.mm.sdcard_migrate.util.ExtStorageMigrateException;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.File;
import java.util.List;

@Keep
public final class ExtStorageMigrateRoutine {
    static final String AUXUI_ACTION_DO_MIGRATE_ROUTINE = "auxui_action_do_migrate_routine";
    static final String AUXUI_PARAM_IS_MIGRAION_END = "auxui_param_is_migration_end";
    static final ExtStorageMigrateConfig DEFAULT_CONFIG = ExtStorageMigrateConfig.NGK;
    private static final boolean[] IS_ACCOUNT_INIT_CALLBACK_ADDED = {false};
    private static final String LAUNCHER_UI_CLASS_NAME = "com.tencent.mm.ui.LauncherUI";
    static final int NOTIFICATION_TASK_ID = 1027;
    static final int PENDING_INTENT_REQUEST_CANCEL_MIGRATION = 3843;
    static final int PENDING_INTENT_REQUEST_LAUNCH_QUESTIONNAIRE = 3841;
    static final int PENDING_INTENT_REQUEST_LAUNCH_WECHAT = 3842;
    public static final int RESULT_CANCEL_REASON_CANCEL_BEFORE_PROCESSING = 2;
    public static final int RESULT_CANCEL_REASON_CANCEL_ON_PROCESSING = 3;
    public static final int RESULT_CANCEL_REASON_UNNECESSARY = 1;
    public static final int RESULT_FAIL_REASON_DEST_PATH_UNAVAILABLE = 8;
    public static final int RESULT_FAIL_REASON_EXCEPTION_OCCURRED = 5;
    public static final int RESULT_FAIL_REASON_SERVICE_IS_BUSY = 4;
    public static final int RESULT_FAIL_REASON_SERVICE_IS_KILLED = 6;
    public static final int RESULT_FAIL_REASON_SRC_PATH_UNAVAILABLE = 7;
    static final String SERVICE_ACTION_CANCEL_MIGRATE = "service_action_cancel_migrate";
    static final String SERVICE_ACTION_STARTUP = "service_action_startup";
    private static final String SERVICE_CLASS_NAME = "com.tencent.mm.sdcard_migrate.ExtStorageMigrateService";
    private static final String SERVICE_PROCESS_SUFFIX = ":extmig";
    private static final String TAG = "MicroMsg.ExtStorageMigrateRoutine";
    private byte _hellAccFlag_;

    @Keep
    static boolean triggerOnDemand(Application application) {
        AppMethodBeat.i(204612);
        b.ju(application);
        String str = d.cQi;
        if (isMigrateServiceProcess(str)) {
            ExtStorageMigrateMonitor.gwK().i(TAG, "[+] Migrate Service Process, skip rest logic in appLike.", new Object[0]);
            LocaleUtil.initLanguage(application);
            MMApplicationContext.setResources(b.a(application.getResources(), application));
            AppMethodBeat.o(204612);
            return true;
        } else if (!isMainProcess(str)) {
            ExtStorageMigrateMonitor.gwK().i(TAG, "[+] Not in main process, startup normally.", new Object[0]);
            AppMethodBeat.o(204612);
            return false;
        } else if (b.gwZ()) {
            ExtStorageMigrateMonitor.gwK().i(TAG, "[+] Last migrate routine indicates that we should startup normally this time.", new Object[0]);
            b.gxb();
            AppMethodBeat.o(204612);
            return false;
        } else {
            if (!isMigrateServiceRunning(application)) {
                ExtStorageMigrateMonitor.gwK().i(TAG, "[+] Migrate service is not running, check if we have external storage permission next.", new Object[0]);
                boolean e2 = com.tencent.mm.pluginsdk.permission.b.e(application, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (!e2) {
                    ExtStorageMigrateMonitor.gwK().w(TAG, "[!] No WRITE_EXTERNAL_STORAGE permission, check READ_EXTERNAL_STORAGE permission next.", new Object[0]);
                    e2 = com.tencent.mm.pluginsdk.permission.b.e(application, "android.permission.READ_EXTERNAL_STORAGE");
                }
                if (!e2) {
                    ExtStorageMigrateMonitor.gwK().w(TAG, "[!] No READ_EXTERNAL_STORAGE permission, check if old sdcard path can read next.", new Object[0]);
                    e2 = new File(com.tencent.mm.loader.j.b.aKI()).canRead();
                }
                if (e2) {
                    ExtStorageMigrateMonitor.gwK().i(TAG, "[+] We have external storage permission, do not need to migrate.", new Object[0]);
                    AppMethodBeat.o(204612);
                    return false;
                }
                ExtStorageMigrateMonitor.gwK().i(TAG, "[+] We have no external storage permission, do further check next.", new Object[0]);
            } else {
                ExtStorageMigrateMonitor.gwK().i(TAG, "[+] Migrate service is running, check if we are doing migrating next.", new Object[0]);
            }
            if (!isStartWithActivity(application)) {
                ExtStorageMigrateMonitor.gwK().i(TAG, "[+] Start up without any activities, let it continue normally.", new Object[0]);
                AppMethodBeat.o(204612);
                return false;
            } else if (isDeviceChangedUnexpectly()) {
                ExtStorageMigrateMonitor.gwK().i(TAG, "[+] External tools may move us into a new device or OTA happened, skip migrate this time.", new Object[0]);
                AppMethodBeat.o(204612);
                return false;
            } else if (!needsToDoMigrate(application)) {
                AppMethodBeat.o(204612);
                return false;
            } else {
                startMigrateQuestionnaire(application);
                ExtStorageMigrateMonitor.gwN();
                suicide();
                AppMethodBeat.o(204612);
                return true;
            }
        }
    }

    static boolean needsToDoMigrate(Context context) {
        AppMethodBeat.i(204613);
        ExtStorageMigrateMonitor.ME(102);
        if (b.gwY()) {
            ExtStorageMigrateMonitor.gwK().i(TAG, "[+] Newly installed, existed old data is ignored, do not need to migrate.", new Object[0]);
            ExtStorageMigrateMonitor.ME(190);
            AppMethodBeat.o(204613);
            return false;
        } else if (b.bhQ(DEFAULT_CONFIG.sourceDir)) {
            ExtStorageMigrateMonitor.gwK().i(TAG, "[+] Already migrated, do not need to migrate", new Object[0]);
            AppMethodBeat.o(204613);
            return false;
        } else if (!new File(DEFAULT_CONFIG.sourceDir).exists()) {
            ExtStorageMigrateMonitor.gwK().i(TAG, "[+] Old external storage directory does not exist, do not need to migrate.", new Object[0]);
            AppMethodBeat.o(204613);
            return false;
        } else {
            ExtStorageMigrateMonitor.ME(100);
            AppMethodBeat.o(204613);
            return true;
        }
    }

    private static boolean isDeviceChangedUnexpectly() {
        AppMethodBeat.i(204614);
        final MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("extstg_migrate_preconditions");
        String string = mmkv.getString("last_fingerprint", "");
        if (string == null || !string.equals(Build.FINGERPRINT)) {
            synchronized (IS_ACCOUNT_INIT_CALLBACK_ADDED) {
                try {
                    if (!IS_ACCOUNT_INIT_CALLBACK_ADDED[0]) {
                        EventCenter.instance.add(new IListener<cp>() {
                            /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateRoutine.AnonymousClass1 */

                            {
                                AppMethodBeat.i(204606);
                                this.__eventId = cp.class.getName().hashCode();
                                AppMethodBeat.o(204606);
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                            @Override // com.tencent.mm.sdk.event.IListener
                            public final /* synthetic */ boolean callback(cp cpVar) {
                                AppMethodBeat.i(204607);
                                ExtStorageMigrateMonitor.gwK().i(ExtStorageMigrateRoutine.TAG, "[+] Save current fingerprint.", new Object[0]);
                                mmkv.encode("last_fingerprint", Build.FINGERPRINT);
                                AppMethodBeat.o(204607);
                                return false;
                            }
                        });
                        IS_ACCOUNT_INIT_CALLBACK_ADDED[0] = true;
                    }
                } finally {
                    AppMethodBeat.o(204614);
                }
            }
            return true;
        }
        AppMethodBeat.o(204614);
        return false;
    }

    private static void startMigrateQuestionnaire(Context context) {
        AppMethodBeat.i(204615);
        Intent intent = new Intent(context, ExtStorageMigrateAuxActivity.class);
        intent.setAction(AUXUI_ACTION_DO_MIGRATE_ROUTINE);
        intent.addFlags(268435456);
        try {
            PendingIntent.getActivity(context, PENDING_INTENT_REQUEST_LAUNCH_QUESTIONNAIRE, intent, 268435456).send();
            AppMethodBeat.o(204615);
        } catch (Throwable th) {
            ExtStorageMigrateMonitor.gwK().printErrStackTrace(TAG, th, "[-] startMigrateQuestionnaire failed, just do normal startup next.", new Object[0]);
            startWeChat(context);
            AppMethodBeat.o(204615);
        }
    }

    @SuppressLint({"NewApi"})
    static void startWeChat(Context context) {
        AppMethodBeat.i(204616);
        b.gxa();
        Intent launchIntentForPackage = context.getApplicationContext().getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            try {
                launchIntentForPackage = new Intent(context, Class.forName(LAUNCHER_UI_CLASS_NAME));
                launchIntentForPackage.setAction("android.intent.action.MAIN");
                launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
                launchIntentForPackage.addCategory("android.intent.category.DEFAULT");
            } catch (ClassNotFoundException e2) {
                IllegalStateException illegalStateException = new IllegalStateException("Should not be here.");
                AppMethodBeat.o(204616);
                throw illegalStateException;
            }
        }
        launchIntentForPackage.addFlags(268435456);
        try {
            PendingIntent.getActivity(context, PENDING_INTENT_REQUEST_LAUNCH_WECHAT, launchIntentForPackage, 268435456).send();
            AppMethodBeat.o(204616);
        } catch (Throwable th) {
            ExtStorageMigrateMonitor.gwK().printErrStackTrace(TAG, th, "[-] startWeChat failed, retry with normal way.", new Object[0]);
            if (context instanceof Activity) {
                launchIntentForPackage.removeFlags(268435456);
            }
            a bl = new a().bl(launchIntentForPackage);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine", "startWeChat", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine", "startWeChat", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(204616);
        }
    }

    private static boolean isMigrateServiceRunning(Context context) {
        AppMethodBeat.i(204617);
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningServices(Integer.MAX_VALUE);
        if (runningServices != null) {
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                if (runningServiceInfo.uid == Process.myUid() && runningServiceInfo.service.getClassName().equals(SERVICE_CLASS_NAME)) {
                    AppMethodBeat.o(204617);
                    return true;
                }
            }
        }
        AppMethodBeat.o(204617);
        return false;
    }

    private static boolean isStartWithActivity(Context context) {
        AppMethodBeat.i(204618);
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningTasks(Integer.MAX_VALUE);
        if (runningTasks != null) {
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                if (runningTaskInfo.numActivities > 0) {
                    String packageName = context.getPackageName();
                    ComponentName componentName = runningTaskInfo.topActivity;
                    if (componentName != null && packageName.equals(componentName.getPackageName())) {
                        AppMethodBeat.o(204618);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.o(204618);
        return false;
    }

    static void startupMigrationService(Context context) {
        AppMethodBeat.i(204619);
        Intent intent = new Intent(SERVICE_ACTION_STARTUP);
        intent.setClassName(context, SERVICE_CLASS_NAME);
        context.startService(intent);
        ExtStorageMigrateMonitor.gwK().i(TAG, "[+] startupMigrationService called.", new Object[0]);
        AppMethodBeat.o(204619);
    }

    static boolean bindMigrationService(Context context, ServiceConnection serviceConnection) {
        AppMethodBeat.i(204620);
        Intent intent = new Intent(SERVICE_ACTION_STARTUP);
        intent.setClassName(context, SERVICE_CLASS_NAME);
        boolean bindService = context.bindService(intent, serviceConnection, 0);
        AppMethodBeat.o(204620);
        return bindService;
    }

    static void startMigration(Context context, final ExtStorageMigrateConfig extStorageMigrateConfig, final MigrateResultCallback migrateResultCallback) {
        AppMethodBeat.i(204621);
        startupMigrationService(context);
        bindMigrationService(context, new ServiceConnection() {
            /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateRoutine.AnonymousClass2 */
            private IBinder NGX = null;
            private IBinder.DeathRecipient NGY = new IBinder.DeathRecipient() {
                /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateRoutine.AnonymousClass2.AnonymousClass1 */

                public final void binderDied() {
                    AppMethodBeat.i(204608);
                    if (AnonymousClass2.this.NGX == null) {
                        AppMethodBeat.o(204608);
                        return;
                    }
                    AnonymousClass2.this.NGX.unlinkToDeath(this, 0);
                    try {
                        migrateResultCallback.b(6, null);
                        AppMethodBeat.o(204608);
                    } catch (RemoteException e2) {
                        AppMethodBeat.o(204608);
                    }
                }
            };

            {
                AppMethodBeat.i(204609);
                AppMethodBeat.o(204609);
            }

            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                AppMethodBeat.i(204610);
                this.NGX = iBinder;
                e N = e.a.N(iBinder);
                try {
                    iBinder.linkToDeath(this.NGY, 0);
                } catch (RemoteException e2) {
                    ExtStorageMigrateMonitor.gwK().printErrStackTrace(ExtStorageMigrateRoutine.TAG, e2, "[-] Exception occurred.", new Object[0]);
                    try {
                        migrateResultCallback.b(6, null);
                    } catch (RemoteException e3) {
                    }
                }
                try {
                    N.a(migrateResultCallback);
                    N.a(extStorageMigrateConfig);
                    AppMethodBeat.o(204610);
                } catch (RemoteException e4) {
                    ExtStorageMigrateMonitor.gwK().printErrStackTrace(ExtStorageMigrateRoutine.TAG, e4, "[-] Exception occurred.", new Object[0]);
                    try {
                        migrateResultCallback.b(5, new ExtStorageMigrateException(e4));
                        AppMethodBeat.o(204610);
                    } catch (RemoteException e5) {
                        AppMethodBeat.o(204610);
                    }
                }
            }

            public final void onServiceDisconnected(ComponentName componentName) {
                AppMethodBeat.i(204611);
                ExtStorageMigrateMonitor.gwK().w(ExtStorageMigrateRoutine.TAG, "[!] Service [%s] disconnected.", componentName);
                AppMethodBeat.o(204611);
            }
        });
        AppMethodBeat.o(204621);
    }

    static void cancelMigration(Context context) {
        AppMethodBeat.i(204622);
        if (isMigrateServiceRunning(context)) {
            Intent intent = new Intent();
            intent.setClassName(context, SERVICE_CLASS_NAME);
            intent.setAction(SERVICE_ACTION_CANCEL_MIGRATE);
            context.startService(intent);
        }
        AppMethodBeat.o(204622);
    }

    private static boolean isMainProcess(String str) {
        AppMethodBeat.i(204624);
        if (str.indexOf(58) < 0) {
            AppMethodBeat.o(204624);
            return true;
        }
        AppMethodBeat.o(204624);
        return false;
    }

    private static boolean isMigrateServiceProcess(String str) {
        AppMethodBeat.i(204625);
        boolean endsWith = str.endsWith(SERVICE_PROCESS_SUFFIX);
        AppMethodBeat.o(204625);
        return endsWith;
    }

    private static void suicide() {
        AppMethodBeat.i(204626);
        a a2 = c.a(Process.myPid(), new a());
        Object obj = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine", "suicide", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine", "suicide", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(204626);
    }

    public static void triggerMediaRescanOnDemand() {
        AppMethodBeat.i(204623);
        Application application = d.dks.getApplication();
        if (!application.getPackageName().equals(d.cQi)) {
            AppMethodBeat.o(204623);
        } else if (!b.gxe()) {
            AppMethodBeat.o(204623);
        } else {
            AndroidMediaUtil.refreshMediaScannerWithoutVFSRemapAsync(com.tencent.mm.loader.j.b.aKT(), application);
            AndroidMediaUtil.refreshMediaScannerWithoutVFSRemapAsync(com.tencent.mm.loader.j.b.aKU(), application);
            b.gxg();
            AppMethodBeat.o(204623);
        }
    }
}
