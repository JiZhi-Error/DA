package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.res.TypedArray;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public class AndroidOSafety {
    public static final int ID_ANDROID_O_SAFETY = 1221;
    public static final int KEY_SAFETY_IGNORE_BY_IS_FLOATING = 0;
    public static final int KEY_SAFETY_IGNORE_BY_IS_SWIPE_TO_DISMISS = 1;
    public static final int KEY_SAFETY_PREPARE_FAILED = 2;
    public static final int SAFETY_IGNORE_BY_IS_FLOATING = 2;
    public static final int SAFETY_IGNORE_BY_IS_SWIPE_TO_DISMISS = 3;
    public static final int SAFETY_NORMAL = 0;
    public static final int SAFETY_PREPARE_FAILED = 4;
    public static final int SAFETY_TO_OPAQUE = 1;
    private static final String TAG = "MicroMsg.AndroidOSafety";
    private static ISafetyCallback sISafetyCallback;
    private static boolean sPrepared = false;
    private static int sRealTargetVersion = 0;
    private static int[] sStyleableWindow;
    private static int sStyleableWindowIsFloating;
    private static int sStyleableWindowIsTranslucent;
    private static int sStyleableWindowSwipeToDismiss;

    public interface ISafetyCallback {
        void invokeToOpaque(Activity activity);

        void reportState(int i2, Activity activity);

        boolean supportSwipe(Activity activity);
    }

    public static void setISafetyCallback(ISafetyCallback iSafetyCallback) {
        sISafetyCallback = iSafetyCallback;
    }

    public static int getRealTargetVersion() {
        return sRealTargetVersion;
    }

    public static void replaceTargetVersion(ApplicationInfo applicationInfo) {
        AppMethodBeat.i(156057);
        if (Build.VERSION.SDK_INT != 26 || applicationInfo.targetSdkVersion <= 26) {
            AppMethodBeat.o(156057);
            return;
        }
        sRealTargetVersion = applicationInfo.targetSdkVersion;
        applicationInfo.targetSdkVersion = 26;
        Log.i(TAG, "replaceTargetVersion %s %s", Integer.valueOf(applicationInfo.targetSdkVersion), Integer.valueOf(sRealTargetVersion));
        AppMethodBeat.o(156057);
    }

    public static boolean checkIfNeedAndroidOSafty(ApplicationInfo applicationInfo) {
        if (Build.VERSION.SDK_INT != 26) {
            return false;
        }
        if (sRealTargetVersion > 26) {
            return true;
        }
        return applicationInfo.targetSdkVersion > 26;
    }

    private static boolean prepare() {
        AppMethodBeat.i(156058);
        if (sPrepared) {
            AppMethodBeat.o(156058);
            return true;
        }
        synchronized (AndroidOSafety.class) {
            try {
                if (sPrepared) {
                    return true;
                }
                try {
                    Class<?> cls = Class.forName("com.android.internal.R$styleable");
                    Field declaredField = cls.getDeclaredField("Window");
                    declaredField.setAccessible(true);
                    sStyleableWindow = (int[]) declaredField.get(cls);
                    Field declaredField2 = cls.getDeclaredField("Window_windowIsTranslucent");
                    declaredField2.setAccessible(true);
                    sStyleableWindowIsTranslucent = ((Integer) declaredField2.get(cls)).intValue();
                    Field declaredField3 = cls.getDeclaredField("Window_windowSwipeToDismiss");
                    declaredField3.setAccessible(true);
                    sStyleableWindowSwipeToDismiss = ((Integer) declaredField3.get(cls)).intValue();
                    Field declaredField4 = cls.getDeclaredField("Window_windowIsFloating");
                    declaredField4.setAccessible(true);
                    sStyleableWindowIsFloating = ((Integer) declaredField4.get(cls)).intValue();
                    sPrepared = true;
                    AppMethodBeat.o(156058);
                    return true;
                } catch (ClassNotFoundException e2) {
                    Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                    AppMethodBeat.o(156058);
                    return false;
                } catch (NoSuchFieldException e3) {
                    Log.printErrStackTrace(TAG, e3, "", new Object[0]);
                    AppMethodBeat.o(156058);
                    return false;
                } catch (IllegalAccessException e4) {
                    Log.printErrStackTrace(TAG, e4, "", new Object[0]);
                    AppMethodBeat.o(156058);
                    return false;
                } catch (Throwable th) {
                    Log.printErrStackTrace(TAG, th, "", new Object[0]);
                    AppMethodBeat.o(156058);
                    return false;
                }
            } finally {
                AppMethodBeat.o(156058);
            }
        }
    }

    private static int[] getStyleableWindow() {
        return sStyleableWindow;
    }

    private static int getWindowIsTranslucent() {
        return sStyleableWindowIsTranslucent;
    }

    private static int getWindowSwipeToDismiss() {
        return sStyleableWindowSwipeToDismiss;
    }

    private static int getWindowIsFloating() {
        return sStyleableWindowIsFloating;
    }

    private static int safetyImpl(Activity activity) {
        AppMethodBeat.i(215282);
        if (prepare()) {
            int[] styleableWindow = getStyleableWindow();
            int windowIsTranslucent = getWindowIsTranslucent();
            int windowSwipeToDismiss = getWindowSwipeToDismiss();
            int windowIsFloating = getWindowIsFloating();
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(styleableWindow);
            boolean z = obtainStyledAttributes.getBoolean(windowIsTranslucent, false);
            boolean z2 = !obtainStyledAttributes.hasValue(windowSwipeToDismiss) && obtainStyledAttributes.getBoolean(windowSwipeToDismiss, false);
            boolean z3 = obtainStyledAttributes.getBoolean(windowIsFloating, false);
            obtainStyledAttributes.recycle();
            Log.i(TAG, "activity %s, isTranslucent %s, isFloating %s, isSwipeToDismiss %s", activity, Boolean.valueOf(z), Boolean.valueOf(z3), Boolean.valueOf(z2));
            if (z) {
                AppMethodBeat.o(215282);
                return 1;
            } else if (z3) {
                AppMethodBeat.o(215282);
                return 2;
            } else if (z2) {
                AppMethodBeat.o(215282);
                return 3;
            } else {
                AppMethodBeat.o(215282);
                return 0;
            }
        } else {
            Log.e(TAG, "prepare Failed %s", activity);
            AppMethodBeat.o(215282);
            return 4;
        }
    }

    public static boolean safety(Activity activity, int i2) {
        boolean z;
        AppMethodBeat.i(156059);
        if (!checkIfNeedAndroidOSafty(activity.getApplicationInfo())) {
            z = true;
        } else if (isFixedOrientationLandscape(i2) || isFixedOrientationPortrait(i2)) {
            int safetyImpl = safetyImpl(activity);
            if (safetyImpl == 1) {
                Log.i(TAG, "invokeToOpaque %s %s", activity, Integer.valueOf(activity.hashCode()));
                if (sISafetyCallback != null) {
                    if (!sISafetyCallback.supportSwipe(activity)) {
                        Log.i(TAG, "not support swipe %s %s", activity, Integer.valueOf(activity.hashCode()));
                        z = false;
                    } else {
                        sISafetyCallback.invokeToOpaque(activity);
                        z = true;
                    }
                }
                z = true;
            } else if (safetyImpl == 2 || safetyImpl == 3) {
                Log.e(TAG, "ignore by IS_FLOATING or IS_SWIPE_TO_DISMISS  %s %s", activity, Integer.valueOf(activity.hashCode()));
                z = false;
            } else {
                if (safetyImpl == 4) {
                    Log.e(TAG, "prepare Failed  %s %s", activity, Integer.valueOf(activity.hashCode()));
                    z = false;
                }
                z = true;
            }
            if (sISafetyCallback != null) {
                sISafetyCallback.reportState(safetyImpl, activity);
                if (safetyImpl == 2) {
                    sISafetyCallback.reportState(0, activity);
                } else if (safetyImpl == 3) {
                    sISafetyCallback.reportState(1, activity);
                } else if (safetyImpl == 4) {
                    sISafetyCallback.reportState(2, activity);
                }
            }
        } else {
            AppMethodBeat.o(156059);
            return true;
        }
        AppMethodBeat.o(156059);
        return z;
    }

    public static boolean isFixedOrientationLandscape(int i2) {
        return i2 == 0 || i2 == 6 || i2 == 8 || i2 == 11;
    }

    public static boolean isFixedOrientationPortrait(int i2) {
        return i2 == 1 || i2 == 7 || i2 == 9 || i2 == 12;
    }
}
