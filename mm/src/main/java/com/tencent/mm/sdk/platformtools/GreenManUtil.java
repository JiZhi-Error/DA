package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public class GreenManUtil {
    private static final String TAG = "MicroMsg.GreenManUtil";
    private static int batteryStatus = -1;
    private static int batteryStatusPlugged = 0;
    private static BroadcastReceiver broadcastReceiver = null;
    private static IForeground sForeground = new ForegroundImpl();

    public interface IForeground {
        boolean isAppForeground(Context context);
    }

    public static boolean reflectScreenOn(Context context) {
        AppMethodBeat.i(230297);
        try {
            boolean booleanValue = ((Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) context.getSystemService("power"), new Object[0])).booleanValue();
            AppMethodBeat.o(230297);
            return booleanValue;
        } catch (Exception e2) {
            Log.e(TAG, "reflectScreenOn invoke ERROR use isScreenOn e:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(230297);
            return true;
        }
    }

    public static boolean isScreenOn(Context context) {
        AppMethodBeat.i(157548);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (Build.VERSION.SDK_INT >= 20) {
                boolean isInteractive = powerManager.isInteractive();
                AppMethodBeat.o(157548);
                return isInteractive;
            }
            boolean isScreenOn = powerManager.isScreenOn();
            AppMethodBeat.o(157548);
            return isScreenOn;
        } catch (Exception e2) {
            Log.e(TAG, "isScreenOn ERROR use isScreenOn e:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(157548);
            return false;
        }
    }

    static {
        AppMethodBeat.i(157554);
        AppMethodBeat.o(157554);
    }

    public static synchronized boolean isCharging(Context context) {
        boolean z = false;
        synchronized (GreenManUtil.class) {
            AppMethodBeat.i(230298);
            if (broadcastReceiver == null) {
                broadcastReceiver = new BroadcastReceiver() {
                    /* class com.tencent.mm.sdk.platformtools.GreenManUtil.AnonymousClass1 */

                    public final void onReceive(Context context, Intent intent) {
                        AppMethodBeat.i(230295);
                        if (intent == null) {
                            AppMethodBeat.o(230295);
                            return;
                        }
                        try {
                            int unused = GreenManUtil.batteryStatus = intent.getIntExtra("status", -1);
                            int unused2 = GreenManUtil.batteryStatusPlugged = intent.getIntExtra("plugged", 0);
                        } catch (Throwable th) {
                        }
                        Log.i(GreenManUtil.TAG, "isCharging BroadcastReceiver thread:%d status:%d plugged:%d", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(GreenManUtil.batteryStatus), Integer.valueOf(GreenManUtil.batteryStatusPlugged));
                        AppMethodBeat.o(230295);
                    }
                };
                try {
                    Intent registerReceiver = context.registerReceiver(broadcastReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                    batteryStatus = registerReceiver.getIntExtra("status", -1);
                    batteryStatusPlugged = registerReceiver.getIntExtra("plugged", 0);
                } catch (Throwable th) {
                }
            }
            if (batteryStatus == 2 || batteryStatusPlugged == 1 || batteryStatusPlugged == 2 || (Build.VERSION.SDK_INT >= 17 && batteryStatusPlugged == 4)) {
                AppMethodBeat.o(230298);
                z = true;
            } else {
                AppMethodBeat.o(230298);
            }
        }
        return z;
    }

    public static boolean isAppOnForeground(String str, Context context) {
        AppMethodBeat.i(230299);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            AppMethodBeat.o(230299);
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(str) && runningAppProcessInfo.importance == 100) {
                AppMethodBeat.o(230299);
                return true;
            }
        }
        AppMethodBeat.o(230299);
        return false;
    }

    public static boolean isAppOnForeground(Context context) {
        AppMethodBeat.i(157549);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            AppMethodBeat.o(157549);
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.startsWith(context.getPackageName())) {
                AppMethodBeat.o(157549);
                return true;
            }
        }
        AppMethodBeat.o(157549);
        return false;
    }

    /* access modifiers changed from: package-private */
    public static class ForegroundImpl implements IForeground {
        private Field Field_processState = null;

        ForegroundImpl() {
            AppMethodBeat.i(157546);
            prepare();
            AppMethodBeat.o(157546);
        }

        private void prepare() {
            AppMethodBeat.i(230296);
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    if (this.Field_processState == null) {
                        Field declaredField = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
                        declaredField.setAccessible(true);
                        this.Field_processState = declaredField;
                    }
                    AppMethodBeat.o(230296);
                    return;
                } catch (Throwable th) {
                    Log.printErrStackTrace(GreenManUtil.TAG, th, "", new Object[0]);
                }
            }
            AppMethodBeat.o(230296);
        }

        @Override // com.tencent.mm.sdk.platformtools.GreenManUtil.IForeground
        public boolean isAppForeground(Context context) {
            boolean z;
            AppMethodBeat.i(157547);
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                AppMethodBeat.o(157547);
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.startsWith(context.getPackageName())) {
                    if (Build.VERSION.SDK_INT >= 21 && this.Field_processState != null) {
                        try {
                            int i2 = this.Field_processState.getInt(runningAppProcessInfo);
                            Log.i(GreenManUtil.TAG, "isAppForeground processState %s", Integer.valueOf(i2));
                            if (i2 <= 2) {
                                AppMethodBeat.o(157547);
                                return true;
                            }
                            z = false;
                            if (z && runningAppProcessInfo.importance == 100) {
                                AppMethodBeat.o(157547);
                                return true;
                            }
                        } catch (Throwable th) {
                            Log.printErrStackTrace(GreenManUtil.TAG, th, "", new Object[0]);
                        }
                    }
                    z = true;
                    AppMethodBeat.o(157547);
                    return true;
                }
            }
            AppMethodBeat.o(157547);
            return false;
        }
    }

    public static int reflectProcessState(ActivityManager.RunningAppProcessInfo runningAppProcessInfo) {
        AppMethodBeat.i(157550);
        if (!(sForeground instanceof ForegroundImpl)) {
            AppMethodBeat.o(157550);
            return -1;
        }
        Field field = ((ForegroundImpl) sForeground).Field_processState;
        if (Build.VERSION.SDK_INT >= 21 && field != null) {
            try {
                int i2 = field.getInt(runningAppProcessInfo);
                AppMethodBeat.o(157550);
                return i2;
            } catch (Throwable th) {
                Log.printErrStackTrace(TAG, th, "", new Object[0]);
            }
        }
        AppMethodBeat.o(157550);
        return -1;
    }

    public static void dumpRunningServices(Context context) {
        AppMethodBeat.i(157551);
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningServices(10);
        if (runningServices == null) {
            AppMethodBeat.o(157551);
            return;
        }
        for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
            Log.i(TAG, "dumpRunningServices %s %s", runningServiceInfo.service, Boolean.valueOf(runningServiceInfo.foreground), Long.valueOf(runningServiceInfo.activeSince));
        }
        AppMethodBeat.o(157551);
    }

    public static boolean isAppVisibleForeground(Context context) {
        AppMethodBeat.i(157552);
        boolean isAppForeground = sForeground.isAppForeground(context);
        AppMethodBeat.o(157552);
        return isAppForeground;
    }

    public static String getTopActivityName(Context context) {
        AppMethodBeat.i(157553);
        if (!isAppOnForeground(context)) {
            AppMethodBeat.o(157553);
            return "";
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            if (Build.VERSION.SDK_INT >= 23) {
                List<ActivityManager.AppTask> appTasks = activityManager.getAppTasks();
                if (appTasks == null || appTasks.size() <= 0) {
                    AppMethodBeat.o(157553);
                    return "";
                }
                Iterator<ActivityManager.AppTask> it = appTasks.iterator();
                if (it.hasNext()) {
                    ComponentName componentName = it.next().getTaskInfo().topActivity;
                    if (componentName == null) {
                        AppMethodBeat.o(157553);
                        return null;
                    }
                    String className = componentName.getClassName();
                    AppMethodBeat.o(157553);
                    return className;
                }
                AppMethodBeat.o(157553);
                return "";
            }
            String className2 = activityManager.getRunningTasks(1).get(0).topActivity.getClassName();
            AppMethodBeat.o(157553);
            return className2;
        } catch (Exception e2) {
            Log.e(TAG, "getTopActivityName Exception:%s stack:%s", e2.getMessage(), Util.stackTraceToString(e2));
        }
    }
}
