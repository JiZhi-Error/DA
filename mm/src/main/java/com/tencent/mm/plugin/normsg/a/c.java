package com.tencent.mm.plugin.normsg.a;

import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class c {
    public static String TN(int i2) {
        AppMethodBeat.i(192286);
        StringBuilder sb = new StringBuilder();
        switch (i2) {
            case 1:
                sb.append("Register");
                break;
            case 2:
                sb.append("Login");
                break;
            case 3:
                sb.append("VerifyUser");
                break;
            default:
                sb.append(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
                break;
        }
        sb.append("_");
        sb.append(UUID.randomUUID().toString());
        String sb2 = sb.toString();
        AppMethodBeat.o(192286);
        return sb2;
    }
}
