package com.google.android.gms.dynamite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.PathClassLoader;

/* access modifiers changed from: package-private */
public final class zzh extends PathClassLoader {
    zzh(String str, ClassLoader classLoader) {
        super(str, classLoader);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z) {
        AppMethodBeat.i(5477);
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                Class<?> findClass = findClass(str);
                AppMethodBeat.o(5477);
                return findClass;
            } catch (ClassNotFoundException e2) {
            }
        }
        Class<?> loadClass = super.loadClass(str, z);
        AppMethodBeat.o(5477);
        return loadClass;
    }
}
