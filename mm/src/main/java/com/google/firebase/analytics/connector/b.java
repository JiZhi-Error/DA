package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b implements a {
    private static volatile a bKB;
    private final AppMeasurement bKA;
    @VisibleForTesting
    final Map<String, Object> bKC = new ConcurrentHashMap();

    private b(AppMeasurement appMeasurement) {
        AppMethodBeat.i(116766);
        Preconditions.checkNotNull(appMeasurement);
        this.bKA = appMeasurement;
        AppMethodBeat.o(116766);
    }

    @KeepForSdk
    public static a ao(Context context) {
        AppMethodBeat.i(116767);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (bKB == null) {
            synchronized (a.class) {
                try {
                    if (bKB == null) {
                        bKB = new b(AppMeasurement.getInstance(context));
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(116767);
                    throw th;
                }
            }
        }
        a aVar = bKB;
        AppMethodBeat.o(116767);
        return aVar;
    }

    @Override // com.google.firebase.analytics.connector.a
    @KeepForSdk
    public final void logEvent(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(116768);
        if (!com.google.firebase.analytics.connector.internal.b.bM(str)) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Origin not allowed : ".concat(valueOf);
                AppMethodBeat.o(116768);
                return;
            }
            new String("Origin not allowed : ");
            AppMethodBeat.o(116768);
        } else if (!com.google.firebase.analytics.connector.internal.b.e(str2, bundle)) {
            AppMethodBeat.o(116768);
        } else if (!com.google.firebase.analytics.connector.internal.b.a(str, str2, bundle)) {
            AppMethodBeat.o(116768);
        } else {
            this.bKA.logEventInternal(str, str2, bundle);
            AppMethodBeat.o(116768);
        }
    }

    @Override // com.google.firebase.analytics.connector.a
    @KeepForSdk
    public final void setUserProperty(String str, String str2, Object obj) {
        AppMethodBeat.i(116769);
        if (!com.google.firebase.analytics.connector.internal.b.bM(str)) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Origin not allowed : ".concat(valueOf);
                AppMethodBeat.o(116769);
                return;
            }
            new String("Origin not allowed : ");
            AppMethodBeat.o(116769);
        } else if (!com.google.firebase.analytics.connector.internal.b.bN(str2)) {
            String valueOf2 = String.valueOf(str2);
            if (valueOf2.length() != 0) {
                "User Property not allowed : ".concat(valueOf2);
                AppMethodBeat.o(116769);
                return;
            }
            new String("User Property not allowed : ");
            AppMethodBeat.o(116769);
        } else if ((str2.equals("_ce1") || str2.equals("_ce2")) && !str.equals(AppMeasurement.FCM_ORIGIN) && !str.equals("frc")) {
            String valueOf3 = String.valueOf(str2);
            if (valueOf3.length() != 0) {
                "User Property not allowed for this origin: ".concat(valueOf3);
                AppMethodBeat.o(116769);
                return;
            }
            new String("User Property not allowed for this origin: ");
            AppMethodBeat.o(116769);
        } else {
            this.bKA.setUserPropertyInternal(str, str2, obj);
            AppMethodBeat.o(116769);
        }
    }
}
