package com.tencent.tav;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.logger.Logger;

public class ResourceLoadUtil {
    public static final String TAG = ResourceLoadUtil.class.getSimpleName();
    private static boolean success = false;

    static {
        AppMethodBeat.i(217627);
        AppMethodBeat.o(217627);
    }

    public static boolean loadSoSync(String str) {
        AppMethodBeat.i(217626);
        if (success) {
            boolean z = success;
            AppMethodBeat.o(217626);
            return z;
        } else if (TextUtils.isEmpty(str)) {
            success = false;
            Logger.e(TAG, "load so path is empty.");
            boolean z2 = success;
            AppMethodBeat.o(217626);
            return z2;
        } else {
            try {
                System.load(str);
                success = true;
                Logger.d(TAG, "load " + str + ": " + success);
                boolean z3 = success;
                AppMethodBeat.o(217626);
                return z3;
            } catch (UnsatisfiedLinkError e2) {
                success = false;
                Logger.e(TAG, "loadSoSync: load soPath = ".concat(String.valueOf(str)), e2);
                Logger.d(TAG, "load " + str + ": " + success);
                boolean z4 = success;
                AppMethodBeat.o(217626);
                return z4;
            } catch (RuntimeException e3) {
                success = false;
                Logger.e(TAG, "loadSoSync: load soPath = ".concat(String.valueOf(str)), e3);
                Logger.d(TAG, "load " + str + ": " + success);
                boolean z5 = success;
                AppMethodBeat.o(217626);
                return z5;
            } catch (Exception e4) {
                success = false;
                Logger.e(TAG, "loadSoSync: load soPath = ".concat(String.valueOf(str)), e4);
                Logger.d(TAG, "load " + str + ": " + success);
                boolean z6 = success;
                AppMethodBeat.o(217626);
                return z6;
            } catch (Throwable th) {
                Logger.d(TAG, "load " + str + ": " + success);
                boolean z7 = success;
                AppMethodBeat.o(217626);
                return z7;
            }
        }
    }

    public static boolean isLoaded() {
        return success;
    }

    public static void setLoaded(boolean z) {
        success = z;
    }
}
