package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;

public final class b {
    private static final List<String> bKE = Arrays.asList("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd", FirebaseAnalytics.a.APP_OPEN);
    private static final List<String> bKF = Arrays.asList("auto", "app", "am");
    private static final List<String> bKG = Arrays.asList("_r", "_dbg");
    private static final List<String> bKH = Arrays.asList((String[]) ArrayUtils.concat(AppMeasurement.UserProperty.zzadb, AppMeasurement.UserProperty.zzadc));
    private static final List<String> bKI = Arrays.asList("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    static {
        AppMethodBeat.i(116777);
        AppMethodBeat.o(116777);
    }

    public static boolean a(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(116776);
        if (!"_cmp".equals(str2)) {
            AppMethodBeat.o(116776);
            return true;
        } else if (!bM(str)) {
            AppMethodBeat.o(116776);
            return false;
        } else if (bundle == null) {
            AppMethodBeat.o(116776);
            return false;
        } else {
            for (String str3 : bKG) {
                if (bundle.containsKey(str3)) {
                    AppMethodBeat.o(116776);
                    return false;
                }
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case 101200:
                    if (str.equals(AppMeasurement.FCM_ORIGIN)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 101230:
                    if (str.equals("fdl")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    bundle.putString("_cis", "fcm_integration");
                    AppMethodBeat.o(116776);
                    return true;
                case 1:
                    bundle.putString("_cis", "fdl_integration");
                    AppMethodBeat.o(116776);
                    return true;
                default:
                    AppMethodBeat.o(116776);
                    return false;
            }
        }
    }

    public static boolean bM(String str) {
        AppMethodBeat.i(116773);
        if (!bKF.contains(str)) {
            AppMethodBeat.o(116773);
            return true;
        }
        AppMethodBeat.o(116773);
        return false;
    }

    public static boolean bN(String str) {
        AppMethodBeat.i(116775);
        if (bKH.contains(str)) {
            AppMethodBeat.o(116775);
            return false;
        }
        for (String str2 : bKI) {
            if (str.matches(str2)) {
                AppMethodBeat.o(116775);
                return false;
            }
        }
        AppMethodBeat.o(116775);
        return true;
    }

    public static boolean e(String str, Bundle bundle) {
        AppMethodBeat.i(116774);
        if (bKE.contains(str)) {
            AppMethodBeat.o(116774);
            return false;
        }
        if (bundle != null) {
            for (String str2 : bKG) {
                if (bundle.containsKey(str2)) {
                    AppMethodBeat.o(116774);
                    return false;
                }
            }
        }
        AppMethodBeat.o(116774);
        return true;
    }
}
