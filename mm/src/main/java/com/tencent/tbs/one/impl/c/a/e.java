package com.tencent.tbs.one.impl.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.BaseDexClassLoader;
import java.io.File;

public final class e extends BaseDexClassLoader {

    /* renamed from: a  reason: collision with root package name */
    private String f2489a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(String str, String str2, String str3, ClassLoader classLoader, String str4) {
        super(str, str2 == null ? null : new File(str2), str3, classLoader);
        AppMethodBeat.i(173827);
        if (!TextUtils.isEmpty(str4)) {
            this.f2489a = str4;
        }
        AppMethodBeat.o(173827);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z) {
        ClassLoader parent;
        AppMethodBeat.i(173828);
        if (this.f2489a == null || str == null || !str.startsWith(this.f2489a)) {
            Class<?> loadClass = super.loadClass(str, z);
            AppMethodBeat.o(173828);
            return loadClass;
        }
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass == null) {
            try {
                findLoadedClass = findClass(str);
            } catch (ClassNotFoundException e2) {
            }
            if (findLoadedClass == null && (parent = getParent()) != null) {
                findLoadedClass = parent.loadClass(str);
            }
        }
        AppMethodBeat.o(173828);
        return findLoadedClass;
    }
}
