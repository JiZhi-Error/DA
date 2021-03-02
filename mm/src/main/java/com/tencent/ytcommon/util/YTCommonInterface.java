package com.tencent.ytcommon.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ytcommon.auth.Auth;

public class YTCommonInterface {
    private static final String TAG = "youtu-common";

    public static int initAuth(Context context, String str, int i2) {
        AppMethodBeat.i(2632);
        int init = Auth.init(context, str, "", i2);
        if (init == 0) {
            new StringBuilder("error code: ").append(init).append("  version: ").append(getVersion()).append("  ").append(getFailedReason(init));
        } else {
            new StringBuilder("error code: ").append(init).append("  version: ").append(getVersion()).append("  ").append(getFailedReason(init));
        }
        AppMethodBeat.o(2632);
        return init;
    }

    public static int initAuth(Context context, String str, String str2, int i2) {
        AppMethodBeat.i(186331);
        int init = Auth.init(context, str, str2, i2);
        if (init == 0) {
            new StringBuilder("error code: ").append(init).append("  version: ").append(getVersion()).append("  ").append(getFailedReason(init));
        } else {
            new StringBuilder("error code: ").append(init).append("  version: ").append(getVersion()).append("  ").append(getFailedReason(init));
        }
        AppMethodBeat.o(186331);
        return init;
    }

    public static int initAuth(Context context, String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(186332);
        int init = Auth.init(context, str, str2, 0, str3);
        if (init == 0) {
            new StringBuilder("error code: ").append(init).append("  version: ").append(getVersion()).append("  ").append(getFailedReason(init));
        } else {
            new StringBuilder("error code: ").append(init).append("  version: ").append(getVersion()).append("  ").append(getFailedReason(init));
        }
        AppMethodBeat.o(186332);
        return init;
    }

    public static int initAuthForQQ(Context context) {
        AppMethodBeat.i(186333);
        int initAuthForQQ = Auth.initAuthForQQ(context);
        if (initAuthForQQ == 0) {
            new StringBuilder("error code: ").append(initAuthForQQ).append("  version: ").append(getVersion()).append("  ").append(getFailedReason(initAuthForQQ));
        } else {
            new StringBuilder("error code: ").append(initAuthForQQ).append("  version: ").append(getVersion()).append("  ").append(getFailedReason(initAuthForQQ));
        }
        AppMethodBeat.o(186333);
        return initAuthForQQ;
    }

    public static long getEndTime() {
        AppMethodBeat.i(2634);
        long endTime = Auth.getEndTime();
        AppMethodBeat.o(2634);
        return endTime;
    }

    public static void setLicensePath(String str) {
        AppMethodBeat.i(2635);
        Auth.setLicensePath(str);
        AppMethodBeat.o(2635);
    }

    public static String getLicensePath() {
        AppMethodBeat.i(2636);
        String licensePath = Auth.getLicensePath();
        AppMethodBeat.o(2636);
        return licensePath;
    }

    public static int getVersion() {
        AppMethodBeat.i(2637);
        int version = Auth.getVersion();
        AppMethodBeat.o(2637);
        return version;
    }

    public static String getFailedReason(int i2) {
        AppMethodBeat.i(2638);
        String failedReason = Auth.getFailedReason(i2);
        AppMethodBeat.o(2638);
        return failedReason;
    }
}
