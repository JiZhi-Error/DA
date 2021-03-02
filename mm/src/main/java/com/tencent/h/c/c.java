package com.tencent.h.c;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class c {
    public static String getIMEI(Context context) {
        String str;
        AppMethodBeat.i(214620);
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Throwable th) {
            str = "";
        }
        AppMethodBeat.o(214620);
        return str;
    }

    public static String kY(Context context) {
        AppMethodBeat.i(214621);
        try {
            String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            if (subscriberId == null) {
                subscriberId = "";
            }
            AppMethodBeat.o(214621);
            return subscriberId;
        } catch (Exception e2) {
            AppMethodBeat.o(214621);
            return "";
        }
    }

    public static String kZ(Context context) {
        AppMethodBeat.i(214622);
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            AppMethodBeat.o(214622);
            return string;
        } catch (Throwable th) {
            AppMethodBeat.o(214622);
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x008b A[SYNTHETIC, Splitter:B:31:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0090 A[SYNTHETIC, Splitter:B:34:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009b A[SYNTHETIC, Splitter:B:40:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a0 A[SYNTHETIC, Splitter:B:43:0x00a0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String DO(boolean r8) {
        /*
        // Method dump skipped, instructions count: 194
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.h.c.c.DO(boolean):java.lang.String");
    }

    public static String hkQ() {
        FileInputStream fileInputStream;
        StringBuilder sb;
        AppMethodBeat.i(214624);
        String str = "";
        try {
            fileInputStream = new FileInputStream("/proc/version");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), 8192);
            sb = new StringBuilder("");
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        try {
                            break;
                        } catch (Throwable th) {
                        }
                    }
                } catch (Throwable th2) {
                }
            }
            bufferedReader.close();
            try {
                fileInputStream.close();
            } catch (Throwable th3) {
            }
            str = sb.toString();
            AppMethodBeat.o(214624);
        } catch (Throwable th4) {
            AppMethodBeat.o(214624);
        }
        return str;
        fileInputStream.close();
        AppMethodBeat.o(214624);
        throw th;
        fileInputStream.close();
        str = sb.toString();
        AppMethodBeat.o(214624);
        return str;
        AppMethodBeat.o(214624);
        throw th;
        str = sb.toString();
        AppMethodBeat.o(214624);
        return str;
    }

    public static String bpY(String str) {
        AppMethodBeat.i(214625);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(214625);
            return "";
        }
        AppMethodBeat.o(214625);
        return str;
    }

    public static int getAppVersionCode(Context context) {
        int i2 = -1;
        AppMethodBeat.i(214626);
        if (context == null) {
            AppMethodBeat.o(214626);
        } else {
            try {
                i2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Exception e2) {
            }
            AppMethodBeat.o(214626);
        }
        return i2;
    }

    public static String getAppVersionName(Context context) {
        AppMethodBeat.i(214627);
        String str = "";
        if (context == null) {
            AppMethodBeat.o(214627);
        } else {
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e2) {
            }
            AppMethodBeat.o(214627);
        }
        return str;
    }

    public static String getAppPackageName(Context context) {
        AppMethodBeat.i(214628);
        String str = "";
        if (context == null) {
            AppMethodBeat.o(214628);
        } else {
            try {
                str = context.getPackageName();
            } catch (Exception e2) {
            }
            AppMethodBeat.o(214628);
        }
        return str;
    }

    public static int lr(Context context) {
        int i2;
        AppMethodBeat.i(214629);
        try {
            i2 = ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode() ? 0 : 1;
        } catch (Throwable th) {
            h.b("DeviceUtil", th);
            i2 = 0;
        }
        AppMethodBeat.o(214629);
        return i2;
    }

    public static int ls(Context context) {
        boolean z;
        int i2 = 1;
        AppMethodBeat.i(214630);
        try {
            if (Build.VERSION.SDK_INT > 19) {
                Class<?> cls = Class.forName("android.hardware.display.DisplayManager");
                Field field = context.getClass().getField("DISPLAY_SERVICE");
                field.setAccessible(true);
                Object systemService = context.getSystemService((String) field.get(context));
                if (systemService == null) {
                    i2 = -1;
                } else {
                    Method method = cls.getMethod("getDisplays", new Class[0]);
                    if (method == null) {
                        i2 = -1;
                    } else {
                        method.setAccessible(true);
                        Display[] displayArr = (Display[]) method.invoke(systemService, new Object[0]);
                        Method method2 = Display.class.getMethod("getState", new Class[0]);
                        method2.setAccessible(true);
                        Field field2 = Display.class.getField("STATE_OFF");
                        field2.setAccessible(true);
                        int length = displayArr.length;
                        int i3 = 0;
                        boolean z2 = false;
                        while (i3 < length) {
                            Display display = displayArr[i3];
                            if (((Integer) method2.invoke(display, new Object[0])).intValue() != field2.getInt(display)) {
                                z = true;
                            } else {
                                z = z2;
                            }
                            i3++;
                            z2 = z;
                        }
                        if (!z2) {
                            i2 = 0;
                        }
                    }
                }
            } else {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager == null) {
                    AppMethodBeat.o(214630);
                    return -1;
                } else if (!powerManager.isScreenOn()) {
                    i2 = 0;
                }
            }
        } catch (Throwable th) {
            h.b("DeviceUtil", th);
            i2 = -1;
        }
        AppMethodBeat.o(214630);
        return i2;
    }

    public static String getProcessName(Context context) {
        AppMethodBeat.i(214631);
        if (context == null) {
            AppMethodBeat.o(214631);
            return "";
        }
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    String str = runningAppProcessInfo.processName;
                    AppMethodBeat.o(214631);
                    return str;
                }
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(214631);
        return "";
    }

    public static float i(Context context, float f2) {
        AppMethodBeat.i(214632);
        float f3 = f2 / context.getResources().getDisplayMetrics().density;
        AppMethodBeat.o(214632);
        return f3;
    }

    public static int getScreenWidth(Context context) {
        AppMethodBeat.i(214633);
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            AppMethodBeat.o(214633);
            return i2;
        } catch (Throwable th) {
            AppMethodBeat.o(214633);
            return -1;
        }
    }

    public static int getScreenHeight(Context context) {
        AppMethodBeat.i(214634);
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.heightPixels;
            AppMethodBeat.o(214634);
            return i2;
        } catch (Throwable th) {
            AppMethodBeat.o(214634);
            return -1;
        }
    }

    public static int getScreenOrientation(Context context) {
        AppMethodBeat.i(214635);
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            if (displayMetrics.heightPixels > displayMetrics.widthPixels) {
                AppMethodBeat.o(214635);
                return 0;
            }
            AppMethodBeat.o(214635);
            return 1;
        } catch (Throwable th) {
            AppMethodBeat.o(214635);
            return -1;
        }
    }

    public static String hpT() {
        AppMethodBeat.i(214636);
        String str = null;
        String[] strArr = {d.V(d.SpW), d.V(d.SpX)};
        for (int i2 = 0; i2 < 2; i2++) {
            str = bqZ(strArr[i2]);
            if (!TextUtils.isEmpty(str)) {
                break;
            }
        }
        AppMethodBeat.o(214636);
        return str;
    }

    private static String bqZ(String str) {
        AppMethodBeat.i(214637);
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getMethod("get", String.class).invoke(cls, str);
            AppMethodBeat.o(214637);
            return str2;
        } catch (Exception e2) {
            AppMethodBeat.o(214637);
            return "";
        } catch (Throwable th) {
            AppMethodBeat.o(214637);
            return "";
        }
    }
}
