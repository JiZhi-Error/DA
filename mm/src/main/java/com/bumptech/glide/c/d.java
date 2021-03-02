package com.bumptech.glide.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public final class d {
    private final Context context;

    public d(Context context2) {
        this.context = context2;
    }

    public final List<b> pU() {
        AppMethodBeat.i(77595);
        Log.isLoggable("ManifestParser", 3);
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                Log.isLoggable("ManifestParser", 3);
                AppMethodBeat.o(77595);
                return arrayList;
            }
            if (Log.isLoggable("ManifestParser", 2)) {
                new StringBuilder("Got app info metadata: ").append(applicationInfo.metaData);
            }
            for (String str : applicationInfo.metaData.keySet()) {
                if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                    arrayList.add(T(str));
                    Log.isLoggable("ManifestParser", 3);
                }
            }
            Log.isLoggable("ManifestParser", 3);
            AppMethodBeat.o(77595);
            return arrayList;
        } catch (PackageManager.NameNotFoundException e2) {
            RuntimeException runtimeException = new RuntimeException("Unable to find metadata to parse GlideModules", e2);
            AppMethodBeat.o(77595);
            throw runtimeException;
        }
    }

    private static b T(String str) {
        AppMethodBeat.i(77596);
        try {
            Class<?> cls = Class.forName(str);
            Object obj = null;
            try {
                obj = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (InstantiationException e2) {
                a(cls, e2);
            } catch (IllegalAccessException e3) {
                a(cls, e3);
            } catch (NoSuchMethodException e4) {
                a(cls, e4);
            } catch (InvocationTargetException e5) {
                a(cls, e5);
            }
            if (!(obj instanceof b)) {
                RuntimeException runtimeException = new RuntimeException("Expected instanceof GlideModule, but found: ".concat(String.valueOf(obj)));
                AppMethodBeat.o(77596);
                throw runtimeException;
            }
            b bVar = (b) obj;
            AppMethodBeat.o(77596);
            return bVar;
        } catch (ClassNotFoundException e6) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unable to find GlideModule implementation", e6);
            AppMethodBeat.o(77596);
            throw illegalArgumentException;
        }
    }

    private static void a(Class<?> cls, Exception exc) {
        AppMethodBeat.i(77597);
        RuntimeException runtimeException = new RuntimeException("Unable to instantiate GlideModule implementation for ".concat(String.valueOf(cls)), exc);
        AppMethodBeat.o(77597);
        throw runtimeException;
    }
}
