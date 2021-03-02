package com.tencent.recovery;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.recovery.ConstantsRecovery;
import com.tencent.recovery.crash.DefaultExceptionHandler;
import com.tencent.recovery.handler.RecoveryMessageHandler;
import com.tencent.recovery.log.RecoveryFileLog;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.service.RecoveryReportService;
import com.tencent.recovery.util.Util;

public class Recovery {
    private static final String TAG = "Recovery";
    private static int activityForegroundCount = 0;
    private static Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() {
        /* class com.tencent.recovery.Recovery.AnonymousClass1 */

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            if (!Recovery.markFinalStatus && !Recovery.recoveryMessageHandler.hasMessages(3)) {
                Recovery.recoveryMessageHandler.removeCallbacksAndMessages(null);
                String myProcessName = Util.getMyProcessName(Recovery.context);
                SharedPreferences.Editor edit = Recovery.context.getSharedPreferences(Recovery.spName, 0).edit();
                edit.putInt(ConstantsRecovery.SpKeys.KeyComponentOnCreateForeground, 1);
                edit.putInt(ConstantsRecovery.SpKeys.KeyComponentOnCreateExceptionType, 4096);
                edit.apply();
                Recovery.recoveryMessageHandler.sendEmptyMessageDelayed(3, (long) OptionFactory.getProcessOptions(myProcessName, 1).getTimeout());
                RecoveryLog.i(Recovery.TAG, "%s markActivityOnCreated %s", myProcessName, Long.valueOf(System.currentTimeMillis() - Recovery.startRecoveryTime));
            }
        }

        public final void onActivityStarted(Activity activity) {
            Recovery.access$508();
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
            Recovery.access$510();
            if (Recovery.activityForegroundCount == 0) {
                RecoveryLog.i(Recovery.TAG, "%s onActivityStopped: activityForegroundCount is 0", Util.getMyProcessName(Recovery.context));
                Recovery.normal(16);
            }
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }
    };
    private static Application application;
    private static CommonOptions commonOptions;
    private static Context context;
    private static boolean markAppOnCreateEnd = false;
    private static boolean markFinalStatus = false;
    private static RecoveryMessageHandler recoveryMessageHandler;
    private static String spName;
    private static long startRecoveryTime;

    static /* synthetic */ int access$508() {
        int i2 = activityForegroundCount;
        activityForegroundCount = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$510() {
        int i2 = activityForegroundCount;
        activityForegroundCount = i2 - 1;
        return i2;
    }

    public static void initStatic() {
        RecoveryLog.i(TAG, "initStatic Run", new Object[0]);
        Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(Thread.getDefaultUncaughtExceptionHandler()));
        try {
            System.loadLibrary(ConstantsRecovery.RECOVERY_CONF_NAME);
        } catch (Exception e2) {
            RecoveryLog.printErrStackTrace(TAG, e2, "load recovery library", new Object[0]);
        }
        startRecoveryTime = System.currentTimeMillis();
        recoveryMessageHandler = new RecoveryMessageHandler();
    }

    public static void attachBaseContext(Application application2, Context context2, String str) {
        OptionFactory.initOptionCreator(str);
        application = application2;
        context = context2;
        commonOptions = OptionFactory.getCommonOptions(context2);
        if (application != null) {
            application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        String myProcessName = Util.getMyProcessName(context2);
        if (RecoveryLogic.isRecoveryProcess(context2)) {
            if (commonOptions.isDebugMode()) {
                RecoveryLog.setDebugMode();
            }
            RecoveryLog.setLogImpl(new RecoveryFileLog(getContext()));
            markFinalStatus();
            RecoveryLog.i(TAG, "recovery process, no need to do any thing", new Object[0]);
            return;
        }
        RecoveryLog.i(TAG, "%s attachBaseContext start ============================== %d", myProcessName, Long.valueOf(System.currentTimeMillis() - startRecoveryTime));
        spName = "recovery-".concat(String.valueOf(myProcessName));
        SharedPreferences sharedPreferences = context2.getSharedPreferences(spName, 0);
        String string = sharedPreferences.getString(ConstantsRecovery.SpKeys.KeyRecoveryVersion, "");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (!string.equals(commonOptions.getClientVersion())) {
            edit.clear();
            edit.putString(ConstantsRecovery.SpKeys.KeyRecoveryVersion, commonOptions.getClientVersion());
            edit.apply();
            RecoveryLog.i(TAG, "recovery sp version not equal lastVersion %s currentVersion %s", string, commonOptions.getClientVersion());
            edit = sharedPreferences.edit();
        }
        RecoveryContext recoveryContext = new RecoveryContext();
        recoveryContext.readFromSp(sharedPreferences);
        RecoveryStatusItem recoveryStatusItem = new RecoveryStatusItem();
        recoveryStatusItem.processName = myProcessName;
        recoveryStatusItem.clientVersion = commonOptions.getClientVersion();
        recoveryStatusItem.uuid = commonOptions.getUUID();
        recoveryStatusItem.timestamp = System.currentTimeMillis();
        if (sharedPreferences.contains(ConstantsRecovery.SpKeys.KeyAppOnCreateExceptionType)) {
            RecoveryLog.i(TAG, "contains KeyAppOnCreateExceptionType", new Object[0]);
            recoveryStatusItem.processStartFlag = sharedPreferences.getInt(ConstantsRecovery.SpKeys.KeyAppOnCreateForeground, 17);
            recoveryStatusItem.processStatus = sharedPreferences.getInt(ConstantsRecovery.SpKeys.KeyAppOnCreateExceptionType, 4096);
            recoveryStatusItem.processStage = 1;
        } else if (sharedPreferences.contains(ConstantsRecovery.SpKeys.KeyComponentOnCreateExceptionType)) {
            RecoveryLog.i(TAG, "contains KeyComponentOnCreateExceptionType", new Object[0]);
            recoveryStatusItem.processStartFlag = sharedPreferences.getInt(ConstantsRecovery.SpKeys.KeyAppOnCreateForeground, 17);
            recoveryStatusItem.processStatus = sharedPreferences.getInt(ConstantsRecovery.SpKeys.KeyComponentOnCreateExceptionType, 4096);
            recoveryStatusItem.processStage = 16;
        } else {
            recoveryContext.clear();
            if (!sharedPreferences.contains(ConstantsRecovery.SpKeys.KeyAppOnCreateNormalType)) {
                RecoveryLog.i(TAG, "DefaultNormal", new Object[0]);
                recoveryStatusItem.processStartFlag = 17;
                recoveryStatusItem.processStatus = 273;
                recoveryStatusItem.processStage = 1;
            } else if (sharedPreferences.contains(ConstantsRecovery.SpKeys.KeyComponentOnCreateNormalType)) {
                RecoveryLog.i(TAG, "contains KeyComponentOnCreateNormalType", new Object[0]);
                recoveryStatusItem.processStartFlag = sharedPreferences.getInt(ConstantsRecovery.SpKeys.KeyAppOnCreateForeground, 17);
                recoveryStatusItem.processStatus = sharedPreferences.getInt(ConstantsRecovery.SpKeys.KeyComponentOnCreateNormalType, 273);
                recoveryStatusItem.processStage = 16;
            } else {
                RecoveryLog.i(TAG, "contains KeyAppOnCreateNormalType", new Object[0]);
                recoveryStatusItem.processStartFlag = sharedPreferences.getInt(ConstantsRecovery.SpKeys.KeyAppOnCreateForeground, 17);
                recoveryStatusItem.processStatus = sharedPreferences.getInt(ConstantsRecovery.SpKeys.KeyAppOnCreateNormalType, 273);
                recoveryStatusItem.processStage = 1;
            }
        }
        if (recoveryStatusItem.isException()) {
            recoveryContext.addExceptionItem(recoveryStatusItem);
            RecoveryLogic.startReportService(context2, recoveryStatusItem, RecoveryReportService.class.getName());
        }
        edit.remove(ConstantsRecovery.SpKeys.KeyAppOnCreateForeground);
        edit.remove(ConstantsRecovery.SpKeys.KeyAppOnCreateExceptionType);
        edit.remove(ConstantsRecovery.SpKeys.KeyAppOnCreateNormalType);
        edit.remove(ConstantsRecovery.SpKeys.KeyComponentOnCreateForeground);
        edit.remove(ConstantsRecovery.SpKeys.KeyComponentOnCreateExceptionType);
        edit.remove(ConstantsRecovery.SpKeys.KeyComponentOnCreateNormalType);
        int processStartFlag = RecoveryLogic.getProcessStartFlag(context2, myProcessName);
        RecoveryLog.i(TAG, "processStartFlag %s %s", myProcessName, Integer.toHexString(processStartFlag));
        if (OptionFactory.getProcessOptions(myProcessName, processStartFlag).getExpress().getResult(recoveryContext.exceptionItemList)) {
            RecoveryLogic.startHandleService(context2, commonOptions, recoveryContext);
            recoveryContext.clear();
            markFinalStatus();
        } else {
            edit.putInt(ConstantsRecovery.SpKeys.KeyAppOnCreateForeground, processStartFlag);
            edit.putInt(ConstantsRecovery.SpKeys.KeyComponentOnCreateForeground, processStartFlag);
            edit.putInt(ConstantsRecovery.SpKeys.KeyAppOnCreateExceptionType, 4096);
        }
        recoveryContext.saveToSp(edit);
        edit.apply();
        RecoveryLog.i(TAG, "%s attachBaseContext end ============================== %d", myProcessName, Long.valueOf(System.currentTimeMillis() - startRecoveryTime));
    }

    public static void markApplicationOnCreateNormal() {
        if (!markFinalStatus && !markAppOnCreateEnd) {
            markAppOnCreateEnd = true;
            String myProcessName = Util.getMyProcessName(context);
            int processStartFlag = RecoveryLogic.getProcessStartFlag(context, myProcessName);
            RecoveryLog.i(TAG, "%s markApplicationOnCreateNormal %d", myProcessName, Long.valueOf(System.currentTimeMillis() - startRecoveryTime));
            SharedPreferences.Editor edit = context.getSharedPreferences(spName, 0).edit();
            edit.remove(ConstantsRecovery.SpKeys.KeyAppOnCreateExceptionType);
            edit.putInt(ConstantsRecovery.SpKeys.KeyAppOnCreateNormalType, 256);
            if (RecoveryLogic.getProcessStartFlag(context, myProcessName) == 16) {
                edit.putInt(ConstantsRecovery.SpKeys.KeyComponentOnCreateForeground, processStartFlag);
                edit.putInt(ConstantsRecovery.SpKeys.KeyComponentOnCreateExceptionType, 4096);
                recoveryMessageHandler.sendEmptyMessageDelayed(2, (long) OptionFactory.getProcessOptions(myProcessName, processStartFlag).getTimeout());
            }
            edit.apply();
        }
    }

    private static void destroy() {
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public static void crash() {
        if (context != null && !markFinalStatus) {
            markFinalStatus();
            RecoveryLog.i(TAG, "%s Recovery.crash %d", Util.getMyProcessName(context), Long.valueOf(System.currentTimeMillis() - startRecoveryTime));
            SharedPreferences.Editor edit = context.getSharedPreferences(spName, 0).edit();
            if (markAppOnCreateEnd) {
                edit.putInt(ConstantsRecovery.SpKeys.KeyComponentOnCreateExceptionType, 65536);
            } else {
                edit.putInt(ConstantsRecovery.SpKeys.KeyAppOnCreateExceptionType, 65536);
            }
            edit.apply();
            destroy();
        }
    }

    public static void anr() {
        if (context != null && !markFinalStatus) {
            markFinalStatus();
            RecoveryLog.i(TAG, "%s Recovery.anr %d", Util.getMyProcessName(context), Long.valueOf(System.currentTimeMillis() - startRecoveryTime));
            SharedPreferences.Editor edit = context.getSharedPreferences(spName, 0).edit();
            if (markAppOnCreateEnd) {
                edit.putInt(ConstantsRecovery.SpKeys.KeyComponentOnCreateExceptionType, 1048576);
            } else {
                edit.putInt(ConstantsRecovery.SpKeys.KeyAppOnCreateExceptionType, 1048576);
            }
            edit.apply();
            destroy();
        }
    }

    public static void normal(int i2) {
        if (context != null && !markFinalStatus) {
            markFinalStatus();
            String myProcessName = Util.getMyProcessName(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences(spName, 0);
            RecoveryLog.i(TAG, "%s Recovery.normal %s %d", myProcessName, Integer.toHexString(i2), Long.valueOf(System.currentTimeMillis() - startRecoveryTime));
            recoveryMessageHandler.removeCallbacksAndMessages(null);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(ConstantsRecovery.SpKeys.KeyComponentOnCreateExceptionType);
            edit.putInt(ConstantsRecovery.SpKeys.KeyComponentOnCreateNormalType, i2);
            edit.apply();
            destroy();
        }
    }

    public static Context getContext() {
        return context;
    }

    public static CommonOptions getCommonOptions() {
        if (commonOptions == null) {
            commonOptions = ConstantsRecovery.DefaultCommonOptions.DefaultOptions;
        }
        return commonOptions;
    }

    private static void markFinalStatus() {
        if (context != null && !markFinalStatus) {
            RecoveryLog.i(TAG, "%s markFinalStatus", Util.getMyProcessName(context));
            markFinalStatus = true;
        }
    }
}
