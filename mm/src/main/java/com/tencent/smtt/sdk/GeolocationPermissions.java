package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public class GeolocationPermissions extends z {

    /* renamed from: a  reason: collision with root package name */
    private static GeolocationPermissions f1682a;

    public static GeolocationPermissions getInstance() {
        AppMethodBeat.i(55091);
        GeolocationPermissions a2 = a();
        AppMethodBeat.o(55091);
        return a2;
    }

    private static synchronized GeolocationPermissions a() {
        GeolocationPermissions geolocationPermissions;
        synchronized (GeolocationPermissions.class) {
            AppMethodBeat.i(55092);
            if (f1682a == null) {
                f1682a = new GeolocationPermissions();
            }
            geolocationPermissions = f1682a;
            AppMethodBeat.o(55092);
        }
        return geolocationPermissions;
    }

    public void getOrigins(ValueCallback<Set<String>> valueCallback) {
        AppMethodBeat.i(55093);
        if (isX5Core()) {
            getGeolocationPermissionsImpl().getOrigins(valueCallback);
            AppMethodBeat.o(55093);
            return;
        }
        android.webkit.GeolocationPermissions.getInstance().getOrigins(valueCallback);
        AppMethodBeat.o(55093);
    }

    public void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.i(55094);
        if (isX5Core()) {
            getAllowed(str, valueCallback);
            AppMethodBeat.o(55094);
            return;
        }
        android.webkit.GeolocationPermissions.getInstance().getAllowed(str, valueCallback);
        AppMethodBeat.o(55094);
    }

    public void clear(String str) {
        AppMethodBeat.i(55095);
        if (isX5Core()) {
            getGeolocationPermissionsImpl().clear(str);
            AppMethodBeat.o(55095);
            return;
        }
        android.webkit.GeolocationPermissions.getInstance().clear(str);
        AppMethodBeat.o(55095);
    }

    public void allow(String str) {
        AppMethodBeat.i(55096);
        if (isX5Core()) {
            getGeolocationPermissionsImpl().allow(str);
            AppMethodBeat.o(55096);
            return;
        }
        android.webkit.GeolocationPermissions.getInstance().allow(str);
        AppMethodBeat.o(55096);
    }

    public void clearAll() {
        AppMethodBeat.i(55097);
        if (isX5Core()) {
            getGeolocationPermissionsImpl().clearAll();
            AppMethodBeat.o(55097);
            return;
        }
        android.webkit.GeolocationPermissions.getInstance().clearAll();
        AppMethodBeat.o(55097);
    }
}
