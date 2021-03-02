package c.t.m.sapp.c;

import com.tencent.map.geolocation.sapp.internal.LocationLogCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public static String f77a = "TencentLocTag";

    /* renamed from: b  reason: collision with root package name */
    public static LocationLogCallback f78b;

    public static void a(LocationLogCallback locationLogCallback) {
        f78b = locationLogCallback;
    }

    public static void a(int i2, String str, Throwable th) {
        AppMethodBeat.i(222984);
        LocationLogCallback locationLogCallback = f78b;
        if (locationLogCallback != null) {
            locationLogCallback.onLog(i2, "TencentLocationComp_sapp", str, th);
        }
        AppMethodBeat.o(222984);
    }

    public static void a(String str) {
        AppMethodBeat.i(222985);
        a(4, str, null);
        AppMethodBeat.o(222985);
    }

    public static void a(String str, Throwable th) {
        AppMethodBeat.i(222986);
        a(6, str, th);
        AppMethodBeat.o(222986);
    }
}
