package com.tencent.map.geolocation.sapp;

import android.content.Context;
import c.t.m.sapp.c.q;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TencentLocationUtils {
    public TencentLocationUtils() {
        AppMethodBeat.i(223093);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(223093);
        throw unsupportedOperationException;
    }

    public static boolean contains(TencentLocation tencentLocation, double d2, TencentLocation tencentLocation2) {
        AppMethodBeat.i(223096);
        if (tencentLocation == null || tencentLocation2 == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(223096);
            throw nullPointerException;
        } else if (distanceBetween(tencentLocation, tencentLocation2) <= d2) {
            AppMethodBeat.o(223096);
            return true;
        } else {
            AppMethodBeat.o(223096);
            return false;
        }
    }

    public static double distanceBetween(TencentLocation tencentLocation, TencentLocation tencentLocation2) {
        AppMethodBeat.i(223094);
        if (tencentLocation == null || tencentLocation2 == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(223094);
            throw nullPointerException;
        }
        double a2 = q.a(tencentLocation.getLatitude(), tencentLocation.getLongitude(), tencentLocation2.getLatitude(), tencentLocation2.getLongitude());
        AppMethodBeat.o(223094);
        return a2;
    }

    public static boolean isFromGps(TencentLocation tencentLocation) {
        AppMethodBeat.i(223098);
        if (tencentLocation == null) {
            AppMethodBeat.o(223098);
            return false;
        }
        boolean equals = "gps".equals(tencentLocation.getProvider());
        AppMethodBeat.o(223098);
        return equals;
    }

    public static boolean isFromNetwork(TencentLocation tencentLocation) {
        AppMethodBeat.i(223099);
        if (tencentLocation == null) {
            AppMethodBeat.o(223099);
            return false;
        }
        boolean equals = TencentLocation.NETWORK_PROVIDER.equals(tencentLocation.getProvider());
        AppMethodBeat.o(223099);
        return equals;
    }

    public static boolean isSupportGps(Context context) {
        AppMethodBeat.i(223100);
        if (context == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(223100);
            throw nullPointerException;
        } else if ((q.g(context) & 16) == 0) {
            AppMethodBeat.o(223100);
            return true;
        } else {
            AppMethodBeat.o(223100);
            return false;
        }
    }

    public static boolean wgs84ToGcj02(double[] dArr, double[] dArr2) {
        boolean z = false;
        AppMethodBeat.i(223097);
        if (!(dArr == null || dArr2 == null)) {
            try {
                if (dArr.length == 2 && dArr2.length == 2) {
                    z = TencentExtraKeys.wgs84ToGcj02(dArr, dArr2);
                    AppMethodBeat.o(223097);
                    return z;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(223097);
            }
        }
        AppMethodBeat.o(223097);
        return z;
    }

    public static double distanceBetween(double d2, double d3, double d4, double d5) {
        AppMethodBeat.i(223095);
        double a2 = q.a(d2, d3, d4, d5);
        AppMethodBeat.o(223095);
        return a2;
    }
}
