package com.tencent.youtu.ytcommon;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.lang.reflect.Method;

public class YTCommonExInterface {
    private static final String TAG = "YTUtilityInterface";
    public static final String VERSION = "3.2.3";
    protected static Method commonSoInitAuth = null;
    private static int mBusinessCode = 0;

    public interface BUSINESS_CODE {
        public static final int YT_COMMON = 0;
        public static final int YT_WX = 1;
    }

    public static float setAppBrightness(Activity activity, int i2) {
        float f2 = -1.0f;
        AppMethodBeat.i(73337);
        YTLogger.i(TAG, "[YTUtilityInterface.setAppBrightness] brightness: ".concat(String.valueOf(i2)));
        try {
            if ((Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) && !activity.isFinishing()) {
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (i2 == -1) {
                    attributes.screenBrightness = -1.0f;
                } else {
                    if (i2 <= 0) {
                        i2 = 1;
                    }
                    attributes.screenBrightness = ((float) i2) / 255.0f;
                }
                f2 = attributes.screenBrightness;
                window.setAttributes(attributes);
                AppMethodBeat.o(73337);
                return f2;
            }
            AppMethodBeat.o(73337);
            return f2;
        } catch (Exception e2) {
            YTLogger.e(TAG, "set appbrightness failed :" + e2.getLocalizedMessage());
        }
    }

    public static void setLogger(YTLogger.IFaceLiveLogger iFaceLiveLogger) {
        AppMethodBeat.i(73338);
        YTLogger.setLog(iFaceLiveLogger);
        AppMethodBeat.o(73338);
    }

    public static void setIsEnabledLog(boolean z) {
        AppMethodBeat.i(73339);
        YTLogger.setIsEnabledLog(z);
        AppMethodBeat.o(73339);
    }

    public static void setIsEnabledNativeLog(boolean z) {
        AppMethodBeat.i(73340);
        YTLogger.setIsEnabledNativeLog(z);
        AppMethodBeat.o(73340);
    }

    public static void setBusinessCode(int i2) {
        mBusinessCode = i2;
    }

    public static int getBusinessCode() {
        return mBusinessCode;
    }
}
